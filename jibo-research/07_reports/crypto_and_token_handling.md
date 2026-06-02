# Crypto and Token Handling Report — Jibo Android App
**Source:** Static analysis of `com.jibo` v1.0.9  
**Generated:** 2026-06-03  
**Note:** No secrets are revealed in this report. Redacted values shown as `[REDACTED]`.

---

## 1. Overview

The Jibo app uses a multi-layered cryptographic scheme:

1. **AWS-style credential tokens** for API authentication
2. **Android Keystore** for RSA keypair storage
3. **AES-256-CBC** for content/media encryption
4. **RSA/PKCS1** for symmetric key wrapping
5. **SQLCipher** for encrypted local database
6. **Native-stored secrets** (obfuscated in `libutils-jni.so`)

---

## 2. Authentication Tokens

### 2.1 AWS-Style Credentials

- All API calls signed with `AccessKeyId` + `SecretAccessKey` (returned by Login)
- Signing algorithm: AWS SigV4 (`AWSRequestMetrics`)
- Unauthenticated calls use `NoOpSignerType` override
- Credentials stored in memory as `BasicAWSCredentials` and in the local SQLite database

### 2.2 OOBE Temporary Token

- Short-lived token returned by `OOBE.PrepareRobot` 
- Valid for ~10 minutes (`expires` field in epoch milliseconds)
- Auto-refreshed by the app when within 30 seconds of expiry
- Embedded in QR code (XOR-obfuscated, see Section 5)
- Used by the robot to authenticate `OOBE.SetupRobot` call

---

## 3. Android Keystore Integration

**Class:** `com.jibo.aws.integration.util.KeyManager`

### 3.1 Account RSA Keypair

```
Alias:     "account_{accountId}"
Algorithm: RSA
Usage:     Wrapping/unwrapping per-loop AES symmetric keys
Validity:  50 years from creation
Subject:   "CN=account_{accountId}, O=Jibo Authority"
```

The keypair is generated once on first use and stored in the Android Keystore (hardware-backed on supported devices).

### 3.2 Per-Loop Symmetric Keys

```
Algorithm: AES-256
Purpose:   Encrypting media files and messages for each Loop
Storage:   filesDir/"loop_{accountId}_{loopId}" — RSA-wrapped blob
```

**Key generation flow:**
1. Generate 256-bit AES key with `SecureRandom`
2. Encrypt with RSA/NONE/PKCS1 using account's public key from Keystore
3. Store encrypted blob to `context.filesDir`

**Key retrieval flow:**
1. Read encrypted blob from `filesDir`
2. Decrypt with RSA/NONE/PKCS1 using account's private key from Keystore
3. Reconstruct AES `SecretKeySpec`

---

## 4. Content Encryption

**Class:** `KeyManager.SymmetricKeyHolder`

### 4.1 Algorithm

```
Cipher:  AES/CBC/PKCS5Padding
Key:     256-bit AES (per-Loop symmetric key)
IV:      Derived from key bytes using hard-coded index sequence
```

### 4.2 IV Derivation

```java
// Hard-coded index sequence for IV derivation:
private static final byte[] INDEX_SEQ = {2, 4, 6, 8, 31, 29, 27, 25, 9, 11, 13, 15, 24, 22, 20, 18};

// IV is derived from the first 32 bytes of the AES key:
byte[] iv = new byte[16];
byte[] keyBytes = aesKey.getEncoded();
for (int i = 0; i < INDEX_SEQ.length; i++) {
    iv[i] = keyBytes[INDEX_SEQ[i]];
}
```

**Security Note:** This IV derivation from the key is a weakness — the IV should be random per-encryption, not deterministically derived from the key. The same IV will always be used with the same key.

### 4.3 File Encryption/Decryption

```java
void encodeFile(File input, File output)  // AES/CBC/PKCS5 encrypt
void decodeFile(File input, File output)  // AES/CBC/PKCS5 decrypt
String encodeString(String plaintext)     // returns Base64(AES(plaintext))
String decodeString(String ciphertext)    // AES(Base64.decode(ciphertext))
```

### 4.4 Alternative IV (Password-Based)

A separate static IV used for password-protected key exports:
```java
// Hard-coded 16-byte IV: [10, 32, 101, 88, 3, 75, 46, 57, 94, 11, 27, 40, 6, 112, 51, 80]
// Used in: AES/CBC/PKCS5 with key = SHA-256(password)
```

**Security Note:** Hard-coded IV is a cryptographic weakness. The same password will always produce the same ciphertext for the same plaintext.

---

## 5. QR Code Obfuscation

**Class:** `WiFiBaseQRCodeFragment.m11173v()` / `m11159a()`

### 5.1 Algorithm

```java
// XOR obfuscation (NOT cryptographic):
String obfuscate(String data, String key) {
    for (int i = 0; i < data.length(); i++) {
        output += (char)(data.charAt(i) ^ key.charAt(i % key.length()));
    }
}

// Key:
String QR_KEY = "Wow, you cracked our secret code. Impressive. Maybe you should check out jibo.com/jobs.";
```

### 5.2 QR Payload Format

```
SSID\nPASSWORD\n[IP\nSUBNET\nROUTER\nDNS1\nDNS2\n]TOKEN
```

XOR-encoded with the above key. If the encoded payload exceeds chunk size, multiple sequential QR codes are displayed as `"{n}/{total}\n{chunk}"`.

**Security Assessment:** XOR with a fixed key provides no cryptographic security. The actual protection is the short-lived server-validated token. However, the SSID and password are obfuscated in the QR code, which protects against casual over-the-shoulder camera sniffing.

---

## 6. Key Sharing Between Users

**Method:** `KeyManager.SymmetricKeyHolder.shareSymmetricKey(recipientPublicKeyPem)`

```java
// Sender encrypts their AES loop key with recipient's RSA public key:
RSA/NONE/PKCS1Padding encrypt(
    recipientRsaPublicKey,
    this.aesKey.getEncoded()
)
// Returns Base64-encoded ciphertext
```

The recipient then decrypts with their private key (via `KeyManager.saveSymmetricKey`).

**Signature verification:** `SHA256withRSA` used for data signature with separator `"\n-----SIGNATURE-----\n"`.

---

## 7. SQLCipher — Correction

**Jibo's own database is NOT encrypted with SQLCipher.**

- `DatabaseHelper` extends `android.database.sqlite.SQLiteOpenHelper` (standard Android)
- Database filename: `jiboapp.db` (unencrypted)
- ContentProvider authority: `com.jibo.provider.db`

`libsqlcipher.so` and the `net.sqlcipher.*` Java classes are present in the APK but originate from the **Salesforce Service SDK** (SmartStore local storage). The two Jibo fragments that import `net.sqlcipher.database.SQLiteDatabase` do so only to obtain the integer constant `SQLiteDatabase.CREATE_IF_NECESSARY` for use as an Intent flag — no database encryption operations occur in Jibo's code.

**The Salesforce SDK does use SQLCipher** for its own SmartStore, with a per-user derived key managed by `DBOpenHelper` and `PasscodeManager` within the Salesforce SDK scope.

---

## 8. Native-Protected API Keys

**Library:** `libutils-jni.so`  
**JNI functions:**
- `getThirPartyKey1()` → Facebook App ID (passed to `FacebookSdk.setApplicationId`)
- `getThirPartyKey2()` → (purpose not called from Java, possibly Crashlytics key)
- `getThirPartyKey3()` → (purpose not called from Java)
- `getThirPartyKey4()` → Segment Analytics write key

The library stores 4 obfuscated string values. Strings visible via `strings` tool:
- A numeric string: `[REDACTED - 15 digits]`
- A zero-padded string: `[REDACTED]`  
- Two alphanumeric strings (32-34 chars): `[REDACTED]`

**Security Assessment:** Native storage provides mild obfuscation against Java decompilation, but strings are recoverable via `strings` on the `.so` binary. The library also references `Commons.TARGET_PREFIX_ACCOUNT` and performs `strcmp`-based validation, suggesting it may verify API endpoint usage.

---

## 9. Certificate Pinning

**Not found** in static analysis. The app does not appear to implement certificate pinning. It uses standard Android HTTPS trust verification.

**Salesforce SDK** may have its own cert handling via `Encryptor.d(...)` in `JiboSupport`.

---

## 10. Token/Key Lifecycle

| Token/Key | Lifespan | Stored In | Cleared On |
|-----------|---------|-----------|------------|
| AWS accessKeyId/secretAccessKey | Session | SQLite DB (EntityData) | Logout |
| Android Keystore RSA key | 50 years | Android Keystore | `KeyManager.deleteAccountData()` |
| Per-loop AES key (encrypted) | Until logout | filesDir | `KeyManager.deleteAccountData()` |
| OOBE temporary token | ~10 min | Memory only | QR generation |
| Facebook access token | Until revoke | FacebookSdk | Logout |

---

## 11. Security Assessment Summary

| Issue | Severity | Notes |
|-------|---------|-------|
| Weak APK signing (SHA1withRSA, 1024-bit) | MEDIUM | Historical, pre-2018 |
| Hard-coded IV for AES encryption | MEDIUM | Same key → same ciphertext for same input |
| QR XOR uses fixed key | LOW | Only cosmetic protection; token is real security |
| No certificate pinning | LOW | MITM possible on untrusted networks |
| API keys in native library | INFO | Mild obfuscation, keys still extractable |
| Firebase API key in strings.xml | INFO | Firebase API keys are app-public by design |
| Password transmitted in plaintext JSON | INFO | HTTPS transport provides confidentiality |
| Jibo database is unencrypted | MEDIUM | `jiboapp.db` uses standard SQLite — AWS credentials stored in plaintext in `entity` table |
| AWS credentials stored in plaintext DB | MEDIUM | `accessKeyId`/`secretAccessKey` in Gson-serialized `data` column; recoverable from device backup/root |
| Android Keystore for RSA keys | POSITIVE | Hardware-backed where available |
