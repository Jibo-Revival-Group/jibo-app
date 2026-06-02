# Jibo Protocol Specification
**Source:** Static analysis of `com.jibo` v1.0.9 (build 33, 2018-05-30)  
**Confidence:** HIGH for structural details, MEDIUM for exact payload schemas  
**Generated:** 2026-06-03

---

## 1. Transport Overview

The Jibo Android app communicates with backend services via a **custom AWS-style RPC protocol** built on HTTPS. There is no REST, gRPC, or WebSocket communication to the Jibo backend from the app (the iHeart radio API uses standard Retrofit/OkHttp).

### Protocol Structure

```
POST https://{endpoint}/
Host: {endpoint}
Content-Type: application/json
Accept: application/json
X-Amz-Target: {ServicePrefix}{MethodName}
X-Amz-Date: {ISO8601}
Authorization: AWS4-HMAC-SHA256 Credential=...  (SigV4)
Content-Length: {n}

{JSON body}
```

All requests use HTTP POST with an empty resource path (`""`). The routing is done entirely via the `X-Amz-Target` header.

---

## 2. Endpoint Inventory

| Name | Hostname | Status |
|------|---------|--------|
| Production | `api.jibo.com` | PRIMARY (runtime default) |
| Staging | `stg-entrypoint.jibo.com` | Hardcoded default in Commons.java |
| Dev | `dev-entrypoint.jibo.com` | Available in DevSettings |
| Alpha | `alpha-entrypoint.jibo.com` | Available in DevSettings |
| China 1 (Netposa dev) | `jibo-dev.ling.cn` | China market only |
| China 2 (Netposa prod) | `jibo.ling.cn` | China market only |

**Runtime selection:** `BasicJiboApplication.m9829e()` reads from SharedPreferences key `"PREF_END_POINT"`, defaulting to `api.jibo.com`. The `OnBoardingActivity.onCreate()` also explicitly sets `ALLOWED_ENDPOINTS[2]` = `api.jibo.com` on first run for the "jibo" build flavor.

A developer settings fragment is accessible via intent action `ACTION_DEV_SETTINGS`.

---

## 3. Authentication Protocol

### 3.1 Initial Authentication (No Credentials)

Unauthenticated operations use `SignerOverride = "NoOpSignerType"` (no SigV4 signing).

```json
POST https://api.jibo.com/
X-Amz-Target: Account_20151111.Login
Content-Type: application/json

{
  "email": "user@example.com",
  "password": "plaintext_password"
}
```

**Response (`Account` object):**
```json
{
  "id": "<account_uuid>",
  "email": "user@example.com",
  "accessKeyId": "<AWS_ACCESS_KEY_ID>",
  "secretAccessKey": "<AWS_SECRET_ACCESS_KEY>",
  "firstName": "John",
  "lastName": "Doe",
  "gender": "male",
  "birthday": 1234567890000,
  "isActive": true,
  "photoUrl": "https://...",
  "phoneNumber": "+1...",
  "devices": [{"name": "...", "pushToken": "...", "type": "android"}]
}
```

### 3.2 Post-Login Request Signing

After login, the `accessKeyId`/`secretAccessKey` from the Account object are used to sign all subsequent requests with AWS SigV4 (`BasicAWSCredentials`).

### 3.3 Registration

```json
X-Amz-Target: Account_20151111.Create
{
  "email": "user@example.com",
  "password": "...",
  "invitationCode": "OPTIONAL"
}
```

### 3.4 Facebook Authentication

```json
// Step 1: Get OAuth URL
X-Amz-Target: Account_20151111.FacebookPrepareLogin
{}

// Step 2: Use returned URL in WebView, get Facebook access token

// Step 3: Connect Facebook account
X-Amz-Target: Account_20151111.FacebookMobileConnect
{"token": "<facebook_access_token>"}
// Returns: TokenContainer{token, expires}
```

### 3.5 Account Activation

```json
X-Amz-Target: Account_20151111.ActivateByCode  // NoOpSigner
{"code": "<activation_code>"}

X-Amz-Target: Account_20151111.ActivateById    // Signed
{"id": "<account_id>"}
```

### 3.6 Key Reset

```json
X-Amz-Target: Account_20151111.ResetKeys  // Signed
{}
// Returns new accessKeyId/secretAccessKey
```

---

## 4. OOBE (Out-Of-Box Experience) / WiFi Setup Protocol

### 4.1 Overview

The robot WiFi onboarding is entirely cloud-mediated. The phone displays a QR code that the robot's camera reads. There is **no direct Bluetooth or local network communication** during initial setup.

### 4.2 Step-by-Step Protocol

```
PHONE                    CLOUD                    ROBOT
  |                        |                        |
  |-- PrepareRobot(loopId)-->|                       |
  |<-- TokenContainer -------|                       |
  |                          |                       |
  | [Generate QR code from:  |                       |
  |  SSID + PASSWORD + TOKEN]|                       |
  | [XOR with key string]     |                       |
  | [Display on screen]       |                       |
  |                          |                       |
  |                          |<-- Robot reads QR -----|
  |                          |  [Robot decodes:       |
  |                          |   XOR with same key]   |
  |                          |  [Robot sends token    |
  |                          |   to confirm setup]    |
  |                          |<-- SetupRobot(id,token)|
  |                          |-- KeysContainer ------>|
  |-- GetStatus(token) ----->|                       |
  |<-- {complete: true} -----|                       |
```

### 4.3 PrepareRobot Request

```json
POST https://api.jibo.com/
X-Amz-Target: OOBE_20161026.PrepareRobot
{
  "loopId": "<loop_uuid>"  // NOTE: field serialized as "loopId" via JiboLoopRequest base
}

// Response - TokenContainer:
{
  "token": "<temporary_string>",
  "expires": 1527700000000  // epoch millis, valid ~10 min
}
```

Token is auto-refreshed every 10 seconds if within 30 seconds of expiry.

### 4.4 QR Code Payload Construction

```
raw = SSID + "\n" + PASSWORD + "\n"

// If static IP configured:
raw += IP_ADDRESS + "\n" + SUBNET_MASK + "\n" + ROUTER + "\n" + DNS1 + "\n" + DNS2 + "\n"

raw += TOKEN

// XOR obfuscation (repeating key):
xor_key = "Wow, you cracked our secret code. Impressive. Maybe you should check out jibo.com/jobs."
encoded = XOR(raw, xor_key)

// If encoded.length > 50 * N chars, split into N QR codes:
// Each QR code prefixed with: "{seq}/{total}\n{chunk}"
```

**Note:** This XOR is purely to prevent casual camera snooping, not cryptographic security. The token is the actual security mechanism (server-validated, short-lived).

### 4.5 GetStatus Request

Polled every 4 seconds from `WiFiBaseQRCodeFragment`:

```json
X-Amz-Target: OOBE_20161026.GetStatus
{
  "loopId": "<loop_uuid>"  // token is also passed somehow — likely as loopId field
}
// Actually: GetStatusRequest(str) where str is the token string

// Response - StatusContainer:
{
  "complete": true  // or false while waiting
}
```

### 4.6 SetupRobot Request (called by robot, not app)

```json
X-Amz-Target: OOBE_20161026.SetupRobot
{
  "id": "<robot_identifier>",
  "token": "<temporary_token>"
}

// Response - KeysContainer:
{
  "accessKeyId": "<robot_aws_access_key>",
  "secretAccessKey": "<robot_aws_secret_key>"
}
```

---

## 5. Loop (Social/Family Group) Protocol

A "Loop" is the user group associated with a Jibo robot. Each robot has exactly one Loop.

### 5.1 Loop Model

```json
{
  "id": "<loop_uuid>",
  "name": "The Smith Family",
  "robot": "<robot_id>",
  "robotFriendlyId": "jibo-abc123",
  "owner": "<account_id>",
  "members": [ /* Member objects */ ],
  "isSuspended": false,
  "created": 1527700000000,
  "updated": 1527700000000
}
```

### 5.2 Member Model

```json
{
  "id": "<member_uuid>",
  "accountId": "<account_uuid>",
  "loopId": "<loop_uuid>",
  "nickname": "Dad",
  "legalGuardianId": "<account_uuid>",
  "isChild": false,
  "agreementId": "<uuid>",
  "enrolled": {
    "face": true,
    "voice": false
  },
  "account": { /* MemberAccount object */ },
  "created": 1527700000000
}
```

### 5.3 Key Loop Operations

```json
// Create loop for robot
X-Amz-Target: Loop_20160324.CreateLoop
{"id": "<robot_id>", "name": "My Loop"}

// Invite member
X-Amz-Target: Loop_20160324.InviteLoopMember
{
  "loopId": "<loop_id>",
  "email": "member@example.com",
  "firstName": "Jane",
  "lastName": "Doe",
  "gender": "female",
  "isChild": false,
  "asLegalGuardian": false
}

// List all loops for account
X-Amz-Target: Loop_20160324.ListLoops
{}  // or with accountId/statusList/typeList filters

// List members
X-Amz-Target: Loop_20160324.ListLoopMembers
{"loopId": "<loop_id>"}

// Remove member
X-Amz-Target: Loop_20160324.RemoveLoopMember
{"id": "<member_id>", "loopId": "<loop_id>"}
```

---

## 6. Robot Properties Protocol

The Robot model stores metadata as a JSON `payload` blob with a fixed schema.

### 6.1 Robot Model

```json
{
  "id": "<robot_uuid>",
  "guid": "<global_unique_id>",
  "payload": {
    "serialNumber": "JB-XXXXXX",
    "platform": "linux-arm",
    "SSID": "MyWiFiNetwork",
    "timezone": "America/New_York",
    "avatar": 3,
    "connectedAt": 1527700000000,
    "remoteEnabled": true,
    "locationOverride": {
      "lat": 42.3601,
      "lng": -71.0589,
      "city": "Boston",
      "state": "Massachusetts",
      "stateAbbr": "MA",
      "country": "United States",
      "countryCode": "US",
      "zipcode": "02101",
      "addressLine": "123 Main St"
    }
  },
  "created": 1527700000000,
  "updated": 1527700000000
}
```

### 6.2 Robot Operations

```json
// Get robot by ID
X-Amz-Target: RobotProperties_20160225.GetRobot
{"id": "<robot_id>"}

// Create robot record
X-Amz-Target: RobotProperties_20160225.CreateRobot
{ /* Robot fields */ }

// Update robot
X-Amz-Target: RobotProperties_20160225.UpdateRobot
{ /* Robot fields */ }

// Get friendly IDs (human-readable robot names)
X-Amz-Target: RobotProperties_20160225.GetFriendlyIds
{"count": 1}
```

---

## 7. Messaging (Jot) Protocol

"Jot" is the messaging/notification system between app users.

```json
// Send message
X-Amz-Target: Jot_20160126.CreateMessage
{
  "loopId": "<loop_id>",
  "type": "...",
  "parts": [ /* MessagePart objects */ ]
}

// List messages
X-Amz-Target: Jot_20160126.ListMessages
{"loopId": "<loop_id>"}

// Mark read
X-Amz-Target: Jot_20160126.MarkRead
{"loopId": "<loop_id>", "messageIds": ["..."]}
```

---

## 8. Skills / Settings Protocol

Skills are 3rd-party integrations (iHeart Radio, Calendar, etc.) managed through a JSON settings blob.

```json
// Get all skill settings for robot
X-Amz-Target: Settings_20171219.GetSettings
{"loopId": "<loop_id>", "transId": "<uuid>"}

// Update a skill setting
X-Amz-Target: Settings_20171219.UpdateSettings
{
  "loopId": "<loop_id>",
  "transId": "<uuid>",
  "data": {
    "<skill_key>": {
      "value": {
        "skillId": "<skill_uuid>",
        "target": "<target_key>",
        "value": { /* skill-specific JSON */ }
      }
    }
  }
}
```

**OAuth flow for skills:**
- For Google: redirects to native Google sign-in, callback at `https://www.jibo.com/google-oauth-callback`
- For others: WebView-based OAuth with `iosClientId`, `iosCallbackUri`, `authorizationUri`, `scopes`
- OAuth tokens stored as encrypted skill setting values

---

## 9. Media Protocol

```json
// List media for loop
X-Amz-Target: Media_20160725.ListMedia  // or ListByAccount, ListByType
{"loopId": "<loop_id>"}

// Get single media item
X-Amz-Target: Media_20160725.GetMedia
{"id": "<media_id>"}
```

Media URLs are pre-signed S3 URLs returned by the server.

---

## 10. Key Exchange Protocol

The Key service manages end-to-end encryption keys for media sharing.

```json
// Create key (share symmetric key with a user)
X-Amz-Target: Key_20160201.CreateRequest
{
  "loopId": "<loop_id>",
  "publicKey": "<base64_rsa_public_key>"
}

// Accept incoming key request
X-Amz-Target: Key_20160201.GetRequest
{"id": "<key_request_id>"}

// List incoming key requests
X-Amz-Target: Key_20160201.ListIncomingRequests
{"loopId": "<loop_id>"}

// Backup key (AES encrypted with password)
X-Amz-Target: Key_20160201.Backup
{"loopId": "<loop_id>", "encryptedKey": "<base64>"}

// Restore key
X-Amz-Target: Key_20160201.Restore
{"loopId": "<loop_id>"}
```

---

## 11. Push Notification Protocol

```json
// Register device
X-Amz-Target: Push_20160729.AddDevice
{
  "name": "My Phone",
  "pushToken": "<fcm_token>",
  "type": "android"
}

// Set notification mode
X-Amz-Target: Push_20160729.SetNotificationsMode
// (JotNotificationsModeResponse structure)
```

---

## 12. iHeartRadio Integration

The iHeart integration uses standard REST via Retrofit, NOT the Jibo AWS protocol:

```
GET https://us.api.iheart.com/api/v2/content/liveStations?limit=10000&countryCode=US&genreId=16
// Returns station list

Endpoints by country:
- US: https://us.api.iheart.com/
- AU: https://au.api.iheart.com/
- CA: https://ca.api.iheart.com/
- NZ: https://nz.api.iheart.com/
```

---

## 13. Salesforce Support Integration

Customer support uses Salesforce Service SDK:
- **Cases URL:** `https://jibo.force.com/jibo`
- **Case type:** `NewCase`
- **Knowledge base:** `https://jibo.force.com/jibo` category `"Robot"`
- User data passed: `Unauthenticated_User_Email__c`, `Account_ID__c`, `Account_OID__c`

---

## 14. Mock Server Requirements

To revive the Jibo app for local/offline use, a mock server must implement:

### Minimum Required Endpoints (Account + OOBE)

| X-Amz-Target | Method | Notes |
|-------------|--------|-------|
| `Account_20151111.Login` | POST | Return fake Account with accessKeyId/secretAccessKey |
| `Account_20151111.Create` | POST | Registration |
| `Account_20151111.ActivateByCode` | POST | Activation |
| `Loop_20160324.ListLoops` | POST | Return list of loops |
| `Loop_20160324.CreateLoop` | POST | Create loop for robot |
| `RobotProperties_20160225.GetRobot` | POST | Return robot details |
| `OOBE_20161026.PrepareRobot` | POST | Return token for QR |
| `OOBE_20161026.GetStatus` | POST | Return `{complete: true}` after delay |
| `Settings_20171219.GetSettings` | POST | Return empty settings JSON |

### All-Features Endpoints

Additional services needed for full functionality: Account (all), Loop (all), RobotProperties (all), Jot, Media, Key, Push, Skills/Settings, GQA, Person, Notification, VoiceTraining, Collision, Binary, File, Photo.

### Mock Server Design

```python
# Minimal mock: check X-Amz-Target header, dispatch to handler
def handle(request):
    target = request.headers.get('X-Amz-Target')
    body = json.loads(request.body)
    
    if target == 'Account_20151111.Login':
        return {
            "id": str(uuid4()),
            "email": body["email"],
            "accessKeyId": "AKIAMOCK0000000001",
            "secretAccessKey": "mockSecretKey12345678901234567890",
            "isActive": True,
            ...
        }
    elif target == 'OOBE_20161026.PrepareRobot':
        return {
            "token": str(uuid4()),
            "expires": int(time.time() * 1000) + 600000
        }
    elif target == 'OOBE_20161026.GetStatus':
        return {"complete": True}
    ...
```

**Critical mock-server requirement:** Requests are AWS SigV4 signed. The mock server can either:
1. Skip SigV4 validation (easier for local testing)
2. Implement SigV4 validation with the test credentials

---

## 15. Confidence and Source Notes

| Finding | Confidence | Source |
|---------|-----------|--------|
| Transport protocol (POST, X-Amz-Target) | HIGH | `C0855e.mo9956a()` marshaller |
| Endpoint hostnames | HIGH | `Commons.java` |
| Service prefixes | HIGH | All `Jibo*Request.java` classes |
| Request JSON field names | HIGH | `@Expose` / `@SerializedName` annotations |
| Login response fields | HIGH | `Account.java` Parcelable constructor |
| QR payload format | HIGH | `WiFiBaseQRCodeFragment.m11172u()` |
| QR XOR key | HIGH | `WiFiBaseQRCodeFragment.m11173v()` |
| OOBE token flow | HIGH | `WiFiBaseQRCodeFragment` async handlers |
| iHeart API URLs | HIGH | `IHeartApiServiceGenerator.java` static block |
| Salesforce URL | HIGH | `JiboSupport.java` |
| Skills OAuth callback URL | HIGH | `OauthFragment.java` |
