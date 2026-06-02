# Jibo APK Reverse Engineering — Findings Log

## Session: 2026-06-03

---

## F001 — APK Identity

- **File:** `Jibo.apk`
- **Path:** `/Users/marcnoguera/jibo-claude/Jibo.apk`
- **Size:** 47 MB
- **SHA256:** `1581b6df9e7729f0d33c4011e656ec0508a69c8b1e9dfcc95014f7c25ef87a9f`
- **Package:** `com.jibo`
- **Version Name:** `1.0.9`
- **Version Code:** `33`
- **Build Date:** `Wed May 30 14:33:27 EDT 2018` (from Crashlytics build.properties)
- **Min SDK:** `19` (Android 4.4 KitKat)
- **Target SDK:** `27` (Android 8.1 Oreo)
- **Launchable Activity:** `com.jibo.ui.activity.OnBoardingActivity`

---

## F002 — Signing Certificate

- **Owner/Issuer:** `CN=AZ` (self-signed, likely developer certificate)
- **Serial:** `0x5756a97a`
- **Valid:** `2016-06-07` to `2041-06-01`
- **SHA1:** `50:09:0B:1A:46:82:87:C8:3C:23:AE:CD:C0:8D:94:CC:5C:B4:4D:2C`
- **Algorithm:** `SHA1withRSA` (WEAK — 1024-bit RSA key)

---

## F003 — Native Libraries

Three `.so` libraries, all stripped:
- `libsqlcipher.so` — Encrypted SQLite (SQLCipher), all ABIs
- `libucrop.so` — Image cropping native library
- `libutils-jni.so` — JNI utilities (Jibo-specific)

ABIs: `arm64-v8a`, `armeabi`, `armeabi-v7a`, `x86`, `x86_64`

---

## F004 — Key URLs and API Keys in String Resources

From `res/values/strings.xml`:
- **Firebase DB:** `https://jibo-dev-672f5.firebaseio.com`
- **Google API Key:** `AIzaSyB9RJzyVItZVjNjmDuN0nLhfrLPexhlOkM` (Firebase + Crash Reporting)
- **Google Timezone API Key:** `AIzaSyAMb6PNT4zfy3oAaVBbDUD5e8GNiW9cIrE`
- **Google Places API Key:** `AIzaSyC5ah9HTo60lTaRaEAkKtW_iR_VQPI77ms`
- **IFTTT:** `https://ifttt.com/jibo`
- **Support:** `https://support.jibo.com`
- **Privacy:** `https://www.jibo.com/privacy`
- **EULA:** `https://www.jibo.com/eula`
- **Salesforce API Version:** `v39.0`

---

## F005 — Server Endpoints (Commons.java)

```java
public static final String STG_ENDPOINT = "stg-entrypoint.jibo.com";
public static final String DEV_ENDPOINT = "dev-entrypoint.jibo.com";
public static final String API_ENDPOINT = "api.jibo.com";
public static final String ALPHA_ENDPOINT = "alpha-entrypoint.jibo.com";
public static final String NETPOSA_1_ENDPOINT = "https://jibo-dev.ling.cn";  // China market
public static final String NETPOSA_2_ENDPOINT = "https://jibo.ling.cn";       // China market
public static String ROOT_ENDPOINT = STG_ENDPOINT;  // DEFAULT at runtime
```

**CRITICAL:** The app defaults to `stg-entrypoint.jibo.com` (staging), NOT `api.jibo.com`.
The `OnBoardingActivity.onCreate()` sets this to `ALLOWED_ENDPOINTS[2]` = `api.jibo.com` on startup for the "jibo" flavor (vs "netposa").

---

## F006 — AWS-Based Custom RPC Protocol

All API calls use a custom AWS-style RPC protocol:

- **Transport:** HTTPS POST to `stg-entrypoint.jibo.com` (or other endpoint)
- **Content-Type:** `application/json`
- **Auth:** AWS SigV4 signing via `BasicAWSCredentials(accessKeyId, secretAccessKey)`
- **Routing Header:** `X-Amz-Target: {ServicePrefix}{MethodName}`
- **Body:** JSON-encoded request object

Example:
```
POST https://api.jibo.com/
X-Amz-Target: Account_20151111.Login
Content-Type: application/json
{"email":"user@example.com","password":"..."}
```

---

## F007 — Complete Service Inventory

| Service | Target Prefix | Key Methods |
|---------|--------------|-------------|
| Account | `Account_20151111.` | Login, Create, ActivateByCode, ActivateById, ChangeEmail, ChangePassword, ResetKeys, SendPasswordReset, PasswordResetByCode, FacebookConnect, FacebookMobileConnect, FacebookPrepareLogin, Search, Get, Update, UpdatePhoto, RemovePhoto, Remove, ResendActivationCode, SendPhoneVerificationCode, VerifyPhoneByCode, CreateAccessToken |
| AccountAdmin | `Account_20151111.` | ActivateById |
| Binary | `Binary_20151201.` | Create, CreatePart, Complete, Get, List, Remove, GetLink |
| Collision | `Collision_20161126.` | Match |
| File | `File_20????.` | Get, List, Remove, Upload, GetLink |
| GQA | `GQA_20160930s.` | GetAttribution, GetAttributionList |
| Jot | `Jot_20160126.` | CreateMessage, ListMessages, MarkRead |
| Key | `Key_20160201.` | Create, Get, ListIncomingRequests, Backup, Restore, Share |
| Loop | `Loop_20160324.` | CreateLoop, ListLoops, GetLoop, UpdateLoop, RemoveLoop, InviteLoopMember, ListLoopMembers, RemoveLoopMember, UpdateLoopMember, ListOwnerRobots |
| Media | `Media_20160725.` | Get, List, ListByAccount, ListByType |
| Notification | `Notification_20150505.` | GetStatus |
| OOBE | `OOBE_20161026.` | PrepareRobot, GetStatus, SetupRobot |
| Person | `Person_20160801.` | GetHolidays, ListHolidays, SetHoliday, RemoveHoliday, SwitchHolidays |
| Photo | `Photo_20151103.` | (methods not fully recovered) |
| Push | `Push_20160729.` | ListDevices, GetNotificationsMode, AddDevice, SetNotificationsMode |
| RobotProperties | `RobotProperties_20160225.` | CreateRobot, GetRobot, GetFriendlyIds, RemoveRobot, UpdateRobot |
| Settings/Skills | `Settings_20171219.` | GetSkillsJson, UpdateSkill, DeleteSettings |
| VoiceTraining | `VoiceTraining_20151103.` | (upload voice sample) |

---

## F008 — Authentication Flow

1. User provides email + password
2. POST to `api.jibo.com` with `X-Amz-Target: Account_20151111.Login`
3. Server returns `Account` object containing:
   - `accessKeyId` (AWS-style)
   - `secretAccessKey` (AWS-style)
   - `id`, `email`, `firstName`, `lastName`, `gender`, `birthday`, `isActive`, `photoUrl`, `phoneNumber`
4. Subsequent requests are signed with the returned `accessKeyId`/`secretAccessKey` via AWS SigV4

**Facebook Auth:**
- `Account_20151111.FacebookPrepareLogin` → get OAuth URL
- `Account_20151111.FacebookMobileConnect` (token) or `Account_20151111.FacebookConnect` (token + loopId)

**Google Auth (Skills OAuth):**
- Redirected to `https://www.jibo.com/google-oauth-callback`

---

## F009 — WiFi/QR Onboarding Flow (OOBE)

**Protocol:** Cloud-mediated QR code, NOT direct Bluetooth

**Step-by-step:**
1. User selects/types WiFi SSID + password (optional: static IP, subnet, router, DNS1, DNS2)
2. App calls `OOBE_20161026.PrepareRobot(loopId)` → gets `TokenContainer{token, expires}`
3. Token is valid for ~10 minutes, auto-refreshed every 10s
4. App constructs QR payload: `SSID\nPASSWORD\n[IP\nSUBNET\nROUTER\nDNS1\nDNS2\n]TOKEN`
5. **QR XOR Obfuscation:** payload XOR'd with key `"Wow, you cracked our secret code. Impressive. Maybe you should check out jibo.com/jobs."`
6. If QR payload > 50 chars/chunk, split into multiple sequential QR codes displayed one at a time
7. Robot camera reads QR code(s), extracts credentials + token
8. App polls `OOBE_20161026.GetStatus(token)` every 4 seconds
9. When `StatusContainer.complete == true`, WiFi setup is confirmed
10. App then calls `OOBE_20161026.SetupRobot(robotId, token)` → gets `KeysContainer{accessKeyId, secretAccessKey}` for the robot's AWS identity
11. Success → navigate to `WiFiSuccessFragment`

---

## F010 — Crypto and Key Management

**KeyManager** (Android Keystore-based):
- RSA keypair per account: alias `"account_{accountId}"`, stored in Android Keystore
- AES-256 symmetric key per Loop: generated with `KeyGenerator.getInstance("AES")`, 256-bit
- Symmetric keys stored encrypted (RSA/PKCS1) in app's `filesDir` as `"loop_{accountId}_{loopId}"`
- **Hard-coded IV bytes (for key encryption AES fallback):** `{10, 32, 101, 88, 3, 75, 46, 57, 94, 11, 27, 40, 6, 112, 51, 80}` (WEAK)
- **Hard-coded IV index sequence (for key derivation):** `{2, 4, 6, 8, 31, 29, 27, 25, 9, 11, 13, 15, 24, 22, 20, 18}`
- AES-CBC/PKCS5Padding for content encryption
- RSA/NONE/PKCS1Padding for key wrapping
- Key sharing between users: RSA public key exchange, sender encrypts AES key with recipient's RSA public key
- Data signatures: `SHA256withRSA` with separator `"\n-----SIGNATURE-----\n"`

**SQLCipher:** Encrypted SQLite database used for local data storage.

---

## F011 — Robot Properties Schema

The `Robot` model stores configuration as a freeform JSON `payload` with these known fields:
- `serialNumber` — robot serial number
- `platform` — robot OS/platform identifier
- `SSID` — current WiFi network name
- `timezone` — IANA timezone string
- `avatar` — avatar ID (integer)
- `locationOverride` — JSON object with: `lat`, `lng`, `city`, `state`, `stateAbbr`, `country`, `countryCode`, `zipcode`, `addressLine`
- `connectedAt` — timestamp
- `remoteEnabled` — boolean

---

## F012 — Third-Party Services and SDKs

- **Crashlytics / Fabric** (Twitter, v2.6.8) — crash reporting
- **Firebase** (Messaging, Performance, Instance ID) — push notifications, performance
- **Salesforce SDK** — customer support / cases / knowledge base
- **Facebook SDK** — social login
- **Google Play Services** — GCM, Google Sign-In
- **iHeartRadio API** — radio station streaming
  - `https://us.api.iheart.com/api/v2/content/liveStations?limit=10000`
  - `https://au.api.iheart.com/`, `https://ca.api.iheart.com/`, `https://nz.api.iheart.com/`
- **Retrofit2 + OkHttp3** — HTTP client (for iHeart)
- **GSON / Jackson** — JSON serialization
- **Glide** — image loading
- **ButterKnife** — view binding
- **ZXing (modified)** — QR code generation
- **UCrop** — image cropping
- **Joda Time** — date/time utilities
- **Bolts** — async task chaining (Facebook SDK)
- **Android Architecture Components** — lifecycle/ViewModel

---

## F013 — Key UI Flows

**Onboarding flow (OnBoardingActivity):**
- Splash → Welcome → Login OR Signup
- Signup → (PhoneVerify) → (AboutYou) → Loop/Jibo check → TabbedActivity (main)
- Password reset: email → code → new password
- Deep link handling for activation, password reset, invite

**WiFi Setup (WifiActivity):**
- JiboPreparations → SetupOrReconnect → NetworkSelection → NetworkPwd (→ StaticOptions) → WiFiTokenGetter → WiFiQRCode → WiFiJiboConnecting → WiFiSuccess

**Main app (TabbedActivity):**
- Tabs: Home/Jibos, Loop, Settings
- Skills/Settings management with OAuth for 3rd-party skills
- Photo management (with tagging and encryption)
- Media (videos/photos from Jibo)
- Guided Experiences (tip videos)

---

## F014 — Interesting Non-obvious Details

1. App defaults to `stg-entrypoint.jibo.com` in `Commons.java` but runtime overrides to `api.jibo.com`
2. China market endpoints: `jibo.ling.cn` (Netposa partnership)
3. QR code XOR key is `"Wow, you cracked our secret code..."` — intentional easter egg
4. **SQLCipher is NOT used for Jibo's own database.** `DatabaseHelper` extends standard `android.database.sqlite.SQLiteOpenHelper`. SQLCipher (`libsqlcipher.so` and the `net.sqlcipher` package) comes from the Salesforce Service SDK, used for Salesforce SmartStore local storage. The two Jibo fragments that import `net.sqlcipher.database.SQLiteDatabase` do so only for the `CREATE_IF_NECESSARY` integer constant (used as an intent flag), not for database operations.
5. Loop max members: 16 (hardcoded in `Commons.MAX_LOOP_MEMBERS`)
6. Crashlytics build ID: `ea95e845-dbe5-43d8-b970-1971629d1ab1`
7. DevSettings fragment exists (accessible via `ACTION_DEV_SETTINGS` intent)
8. Salesforce used for customer support case management
9. `libutils-jni.so` stores 4 obfuscated API key strings. The strings are XOR/pad-obfuscated but visible via `strings(1)` analysis. Key layout:
   - key1: 15-digit numeric string (Facebook App ID)
   - key2: 32-zero-padded string
   - key3: 32-char hex string (MD5-format)
   - key4: 32-char alphanumeric string (Segment Analytics write key)
   The library also contains `strcmp` + `checkSecureData` + a reference to `Account_20151111.` (via JNI reflection on `Commons.TARGET_PREFIX_ACCOUNT`), suggesting endpoint validation logic.
10. `libucrop.so` uses the CImg image processing library (confirmed via mangled C++ symbol names)
11. Jibo app database file is unencrypted: `jiboapp.db` (opened via standard Android SQLiteOpenHelper)
12. The `JiboFileClient` base class handles Photo and VoiceTraining uploads — they share identical REST structure but use different `TARGET_PREFIX` strings injected via `setServiceType()`
13. `JiboLoopClient` has more methods than previously documented: `acceptInvitation`, `declineInvitation`, `getRobot` (RobotAccount), `listOwnerRobots`, `removeMember`, `removeMemberPhoto`, `setLegalGuardian`, `suspendLoop`, `updateMember`, `updateMemberPhoto`, `updateNickname`, `updatePhoneticName`
14. `JiboPushClient` also provides `getJotNotificationsMode` and `updateJotNotificationsMode` — per-device notification preferences
15. **AWS credentials stored in plaintext in unencrypted database.** `EntityData.m10134i()` reads the current `Account` from the `entity` table (`type=1`) as a Gson JSON blob. The `Account` object includes `accessKeyId` and `secretAccessKey`. These are recoverable directly from `jiboapp.db` on a rooted device or device backup.
16. Entity type constants used in DB: `type=1` (Account/current user), `type=2` (Members/contacts)
17. Account serialization uses Gson `f9707l.toJson(account)` into the `data` column — full Account model including all fields is stored

---

## F015 — Complete Service Method Inventory (Updated)

Full enumeration of all service operations across all client classes:

### Account Service (`Account_20151111.`)
`Login`, `Create`, `ActivateByCode`, `ActivateById`, `ChangeEmail`, `ChangePassword`, `ResetKeys`, `SendPasswordReset`, `PasswordResetByCode`, `FacebookConnect`, `FacebookMobileConnect`, `FacebookPrepareLogin`, `Search`, `Get`, `Update`, `UpdatePhoto`, `RemovePhoto`, `Remove`, `ResendActivationCode`, `SendPhoneVerificationCode`, `VerifyPhoneByCode`, `CreateAccessToken`

### AccountAdmin Service (`Account_20151111.`)
`ActivateById`

### Binary Service (`Binary_20151201.`)
`Create`, `Get`, `List`, `Remove` + `downloadFileFromUrl()` (direct S3 HTTP)

### Collision Service (`Collision_20161126.`)
`Match(faceIds: List<String>, imageS3Key: String)` → `CollisionCheckContainer`

### GQA Service (`GQA_20160930s.`)
`listAttributions(loopId, timestamp)` → `AttributionListResponse`
`sendQuestion(question)` → `GQAAttribution`

### Jot Service (`Jot_20160126.`)
`createMessage(loopId, content, parts, tags)` → `Message`
`listMessages(loopId, from, to)` → `List<Message>`
`markRead(messageIds)` → `CommandResponse`

### Key Service (`Key_20160201.`)
`createRequest(loopId, encryptedKey)` → `Request`
`getRequest(requestId)` → `Request`
`listIncomingRequests(loopId)` → `List<Request>`
`backupEncryptedKey(loopId, keyId, encryptedKey)` → `CommandResponse`
`restoreEncryptedKey(loopId, keyId)` → `Backup`
`share(requestId, encryptedKey)` → `Request`

### Loop Service (`Loop_20160324.`)
`createLoop(name, robotId)`, `listLoops()`, `updateLoop(id, name)`, `removeLoop(id)`, `acceptInvitation(id)`, `declineInvitation(id)`, `getRobot(loopId)`, `inviteMember(loopId, email, firstName, lastName, gender, birthday, isChild, hasGuardian)`, `listMembers(loopIds, memberIds)`, `listOwnerRobots(accountId)`, `removeMember(loopId, memberId)`, `removeMemberPhoto(loopId, memberId)`, `setLegalGuardian(loopId, guardianId, childId)`, `suspendLoop(loopId)`, `updateMember(...)`, `updateMemberPhoto(loopId, memberId, file)`, `updateNickname(loopId, memberId, nickname)`, `updatePhoneticName(loopId, memberId, phoneticName)`

### Media Service (`Media_20160725.`)
`create(loopId, accountId, type, reference, file, isEncrypted)`, `get(mediaIds)`, `list(loopIds, from, to)`, `remove(mediaIds)`

### Notification Service (`Notification_20150505.`)
`getStatus(notificationId)` → `StatusContainer`

### OOBE Service (`OOBE_20161026.`)
`prepareRobot(loopId)` → `TokenContainer`
`getStatus(token)` → `StatusContainer`
`setupRobot(robotId, token)` → `KeysContainer{accessKeyId, secretAccessKey}`

### Person Service (`Person_20160801.`)
`getAccountProperties(keys)`, `getLoopProperties(loopId, keys)`, `setAccountProperty(key, value)`, `setLoopProperty(loopId, key, value)`, `listHolidays(loopId)`, `switchHolidays(enabled, holidayIds, loopId)`

### Photo Service (`Photo_20151103.`)
File upload/download via `JiboFileClient`: `getFile`, `listFiles`, `removeFile`, `uploadFile`

### Push Service (`Push_20160729.`)
`createDevice(device)` → `List<Device>`
`removeDevice(deviceToken)` → `List<Device>`
`getJotNotificationsMode()` → `JotNotificationsModeResponse`
`updateJotNotificationsMode(mode)` → `JotNotificationsModeResponse`

### RobotProperties Service (`RobotProperties_20160225.`)
`createRobot(robot)`, `getRobot(id)`, `getFriendlyIds(count)`, `removeRobot(id)`, `updateRobot(robot)`

### Settings/Skills Service (`Settings_20171219.`)
`getSkillsJson(loopId)` → raw JSON string
`updateSkill(loopId, UpdateSettingData{key, value, skillId})` → `UpdateSettingData`
`deleteSettings(loopId, DeleteSettingData{key})` → `DeleteSettingData`

### VoiceTraining Service (`VoiceTraining_20151103.`)
File upload via `JiboFileClient`: `uploadFile(path, file)` → `FileLink`
