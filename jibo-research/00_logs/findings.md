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

**SQLCipher note:** Jibo's own `jiboapp.db` is NOT encrypted (standard `SQLiteOpenHelper`). `libsqlcipher.so` belongs to the Salesforce SDK — see F014 item #4.

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

---

## F016 — FCM Push Message Contract (12 Types)

All push notification type strings handled by `JiboFirebaseMessagingService.onMessageReceived`:

| Type | UI Effect |
|------|-----------|
| `jot_created_silent` | Silent jot sync |
| `jot_created_tagged` | Sync + notification |
| `loop_changed_silent` | Loop sync |
| `loop_invited` | Notification → tab 0 (loops) |
| `loop_accepted` | Loop sync |
| `key_needed_silent` | Start `KeyRequestingSharingService ACTION_KEY_REQUESTED` |
| `key_shared_silent` | Start `KeyRequestingSharingService ACTION_KEY_SHARED` |
| `media_deleted_silent` | Start `MediaDeletingService` with `EXTRA_FROM_OUTSIDE=true` |
| `key_timeout_silent` | Add loopId to `PREF_LOOPS_IN_TIMEOUT` |
| `media_created_silent` | 4s delay → sync media → optional notification (tab 1) |
| `version_installed` | Show notification → `release_notes_url` |
| `version_updated` | Show notification → `release_notes_url` |

FCM data fields: `type`, `loopId`, `path`, `loc-args`, `id`  
Notification channel ID: `"my_channel_01"` (name: `"channel_name"`)

---

## F017 — Background Service Actions Reference

### KeyRequestingSharingService
- `ACTION_CHECK_ALL_LOOPS` — iterate entity table (type=8), trigger REQUEST_KEY for each accepted loop
- `ACTION_REQUEST_KEY(loopId)` — call `Key.createRequest(loopId, publicKey)` if no local key
- `ACTION_KEY_REQUESTED(loopId)` — list incoming requests, encrypt AES key for each, call `Key.share`
- `ACTION_KEY_SHARED(loopId, id)` — call `Key.getRequest(id)`, save decrypted key locally
- Broadcasts `ACTION_KEY_SAVED` (local) when key received

### KeysCheckerJobService (Firebase JobDispatcher)
- Scheduled via `SyncHelper.m10175a()` every 120–180 seconds
- Calls `ACTION_CHECK_ALL_LOOPS` only

### DeviceRegistrationService
- FCM token: `FirebaseInstanceId.getInstance().getToken()`
- Instance ID: `getId() + new SecureRandom().nextLong()`
- Saves: `PREF_PUSH_SERVICE_TOKEN`, `PREF_INSTANCE_ID`
- Calls: `Push_20160729.AddDevice`

### DeviceUnRegistrationService (on logout)
- Reads `PREF_INSTANCE_ID`
- Clears ALL SharedPreferences (`SharedPreferencesUtil.m11434b()`)
- Calls `KeyManager.logout(context)` — deletes all local key files from `filesDir`
- Calls `Push_20160729.removeDevice(instanceId)`

### MessageSendingService
- Generates thumbnails: 720×405 (display), 330×330 (robot)
- If `isEncrypted`: AES-encrypts files via `KeyManager.obtainKeyHolder(loopId).encodeFile()`
- Uploads to `Media_20160725.create` (with `isEncrypted` flag)
- Failed messages get ID `"TEMP_FAILED_" + System.currentTimeMillis()`

### MediaDeletingService
- `EXTRA_IDS` (String[]) — paths to delete
- `EXTRA_FROM_OUTSIDE` (boolean) — if true, skip API call (FCM-triggered local-only deletion)
- Permission: owner OR uploader OR `EXTRA_FROM_OUTSIDE`

### SyncHelper Bitmask
`1=loops | 2=accounts | 4=jots | 8=media | 16=delete-flag`

---

## F018 — SharedPreferences Schema

File key: `getString(R.string.app_name)` = `"Jibo"`

| Key | Type | Default | Notes |
|-----|------|---------|-------|
| `PREF_APP_OPEN_NUM` | int | 0 | Launch counter |
| `PREF_PUSH_SERVICE_TOKEN` | String | null | FCM token |
| `PREF_INSTANCE_ID` | String | null | instanceId + SecureRandom long |
| `PREF_MEDIA_TAB_MODE` | int | 0 | Gallery layout mode |
| `"Loop"` | String (JSON) | null | Last selected Loop |
| `PREF_PARENTS_MEMBERS` | String (CSV) | null | Guardian member IDs |
| `PREF_ENCRYPTION_ENABLED` | boolean | true | Global encryption on/off |
| `PREF_LOOPS_IN_TIMEOUT` | String (CSV) | null | Loops with key timeout |
| `PREF_LOOPS_ALERTED_TIMEOUT` | String (CSV) | null | Loops already alerted |
| `PREF_LOOPS_NO_HOLIDAYS` | String (CSV) | null | Loops with holidays off |
| `PREF_PUSHES_ON_GALLERY_CONTENT` | boolean | true | Gallery push toggle |
| `PREF_IS_PERSONAL_REPORT_DIALOG_SHOWN` | boolean | false | One-time dialog flag |
| `PREF_FIRST_TIME_TIPS` | boolean | true | First tips launch flag |
| `PREF_SHOW_INVITE_CONGRATS` | boolean | true | Invite congrats flag |
| `PREF_ACQUISITION` | boolean | false | Attribution flag |
| **`PREF_END_POINT`** | **String** | **api.jibo.com** | **Custom endpoint — revival path** |

**Note:** `OnBoardingActivity.onCreate()` always overwrites `PREF_END_POINT` to `Commons.ALLOWED_ENDPOINTS[2]` (`api.jibo.com`) on fresh launch. APK patch or access via `DevSettingsFragment` required to persist a custom endpoint.

---

## F019 — Complete Data Model Schemas

### Loop
`id, name, owner (accountId), robot (accountId), robotFriendlyId, members (List<Member>), created (Long), updated (Long), isSuspended (Boolean)`

### Member
`id, loopId, accountId, account (MemberAccount{id,email,firstName,lastName,photoUrl}), enrolled (Enrolled{voice:Boolean, face:Boolean}), status (InvitationStatus: invited|accepted|declined|removed), type (InvitationType: incoming|outgoing), nickname, phoneticName, legalGuardianId, created (Long), agreementId`  
`isEnrolled()` = `enrolled.voice || enrolled.face`

### Message (Jot)
`id, loopId, content, sender (accountId), parts (List<MessagePart>), tags (List<String>), created (Long), isRead (Boolean), isEncrypted (Boolean)`

### Account (full model)

| Field | Type | Description |
|-------|------|-------------|
| `id` | String | Account UUID |
| `email` | String | User email |
| `accessKeyId` | String | AWS-style credential |
| `secretAccessKey` | String | AWS-style credential |
| `devices` | List<Device> | Registered push devices |
| `firstName` | String | First name |
| `lastName` | String | Last name |
| `gender` | Gender enum | `male \| female \| other \| they` |
| `birthday` | Long | Epoch ms (null-able) |
| `isActive` | Boolean | Account activation status |
| `photoUrl` | String | Profile photo URL |
| `phoneNumber` | String | Phone (optional) |
| `messagingAllowed` | Boolean | SMS/messaging consent |

`isIncomplete()` = `isEmpty(firstName) || isEmpty(lastName) || gender == null`

### Entity Type Constants (DB)
`type=1` → Account (current user)  
`type=2` → Members / contacts  
`type=8` → Loops

### MemberComparator (sort order in UI)
1. Owner first
2. Then by `nickname` (if set) or `firstName` alphabetically
3. Robot member excluded from sort

---

## F020 — SECURITY: Hardcoded AWS Credentials in LoopHelper.suspendLoop()

**File:** `com.jibo.aws.integration.helpers.LoopHelper`  
**Method:** `suspendLoop()` — approximately line 279  
**Severity:** HIGH

`suspendLoop()` constructs a `BasicAWSCredentials(accessKeyId, secretAccessKey)` instance using **literal hardcoded string values** embedded in the compiled DEX bytecode. These are not the user's credentials — they appear to be service-level or test credentials stored directly in the application.

**Values:** REDACTED per security policy. The strings are plaintext in the DEX and recoverable via JADX decompilation.

**Impact:** Any party who decompiles the APK (trivially possible with JADX) can extract these credentials. If the credentials are still valid and have service permissions, they could be used to interact with the Jibo backend API signed as that identity.

**Location documented for revival purposes:** These credentials, if still valid, would authenticate `suspendLoop` calls without a user account — relevant for server mock testing to understand what signed identity the server expects for loop suspension operations.

---

## F024 — Skills JSON Schema (Settings_20171219.GetSkillsJson)

**Class:** `com.jibo.p019ui.helpers.skills.SkillsJsonParser`

The Skills settings endpoint returns either a JSON array (multiple skills) or a single JSON object (one skill). The app parses it into `DataItems.SkillDataItem` objects.

### SkillDataItem Structure

```json
[
  {
    "type": "skill",
    "index": 0,
    "view": {
      "type": "skill",
      "childViews": [
        {
          "type": "<item-type>",
          "index": 0,
          "key": "<pref-key>",
          ...
        }
      ]
    },
    "data": {
      "<pref-key>": <current-value>,
      ...
    }
  }
]
```

### Item Types

| `type` value | DataItem class | DataValue class | Notes |
|---|---|---|---|
| `skill` | `SkillDataItem` | — | Top-level skill container |
| `subheader` | `SubheaderDataItem` | — | Section header (display only) |
| `footer` | `FooterDataItem` | — | Footer (display only) |
| `switch` | `SwitchDataItem` | `BooleanDataValue` | Toggle switch |
| `toggle` | `ToggleDataItem` | `BooleanDataValue` | Same as switch |
| `choice` | `ChoiceDataItem` | `IntegerDataValue` | Multiple-choice selector |
| `oauth` | `OauthDataItem` | `OauthDataValue` | OAuth-connected skill |
| `connectable` | `ConnectableDataItem` | `ConnectableDataValue` | Connectable skill item |
| `location` | `LocationDataItem` | `LocationDataValue` | Location picker |
| `locationTextField` | `LocationDataItem` | `LocationDataValue` | Location text input |
| `time` | `TimeDataItem` | `TimeDataValue` | Time picker |

### Skills sorted by `view.index` field

### `isConfigured()` logic
- If data has ≤7 keys: checks all values are non-false (ignoring `offerProactively` key)
- If data has >7 keys: considered configured

### `TextLinksMatcher`
- Skill JSON can embed link placeholder `"JIBO_SETTINGS"` → navigates to `RobotSettingsFragment`

### Icon names (matched to drawables)
`ic_bike`, `ic_drive`, `ic_transport`, `ic_walk`, `personal_report_icon`

---

## F021 — TabbedActivity Navigation Map

**Class:** `com.jibo.p019ui.activity.TabbedActivity`

Main app activity after login. Fragment-based tab navigation:

### Tab Index Map

| Index | Fragment (complete state) | Fragment (initial — no loops) | Description |
|-------|--------------------------|-------------------------------|-------------|
| 0 | `JiboDetailsFragment` | `NoLoopsFragment` | Jibo/Loops home |
| 1 | `MediaFragment` | `MediaFragment` (hidden) | Gallery |
| 2 | `TipsListFragment` | `TipsListFragment` | Tips / guided experiences |
| 3 | *(Salesforce launch)* | *(Salesforce launch)* | Customer support |

- **Initial state** (no loops): tab 1 (gallery) visibility = `GONE`; all others visible
- **Complete state** (has loops): all 4 tabs visible
- Tab 3 triggers `JiboSupport.m9868a(activity)` (launchKnowledgeUI) — no Fragment, opens Salesforce

### Intent Extras (from notifications / other activities)

| Extra Key | Type | Effect |
|-----------|------|--------|
| `ARG_FROM_NOTIFICATION` | boolean | Logs analytics event |
| `ARG_LOOP_ID` | String | Pre-selects matching loop |
| `ARG_TAB_SELECTED` | int | Selects tab by index |
| `ARG_CURRENT_TAB` | int | Saved/restored tab on rotation |
| `ARG_ENTITY_SELECTED` | String | Opens LoopInviteDetailsActivity for that loop if invited |

### Loader IDs

- `loader_default_account` (type=1): if empty → redirects to OnBoardingActivity (forced logout)
- `loader_loops` (type=8): populates loop selector dropdown; saves last selected loop to `PREF_LOOP`
- `loader_jots_unread`: counts unread jots → badge on tab 0 (excludes `TEMP_SENDING_*` / `TEMP_FAILED_*`)

### Loop Selector Behavior

- Tap title bar on tab 0 → animated slide-down overlay with all loops listed
- Tap loop → if `isMemberInvited`: open `LoopInviteDetailsActivity`; if accepted: call `EntityData.m10117a(loop)` to set active loop
- Tap null/add button → launch `WifiActivity` (start WiFi onboarding to add a robot)
- After LoopInviteDetailsActivity returns (code 1006): auto-collapses selector after 3 seconds

### Activity Result Codes

| Request Code | From | Action |
|---|---|---|
| 1001 | AccountSettings | Triggers accounts sync (`SyncHelper.m10178b`) |
| 1003 | AvatarSelectionFragment | Updates robot info for current loop |
| 1006 | LoopInviteDetailsActivity | Shows loop selector, auto-collapses after 3s |

### On Resume
Checks if `PREF_PUSH_SERVICE_TOKEN` is empty → starts `DeviceRegistrationService`

---

## F022 — Encryption Passphrase Backup UX

---

## F023 — RobotSettings Screen and StatusContainer Usage

**Class:** `com.jibo.p019ui.fragment.settings.RobotSettingsFragment`

### Settings Screen Features

- **Jibo name** (`txtJiboName`) — editable via `ChangeLoopNameDialog`; saves via `Loop_20160324.updateLoop`
- **WiFi status** (`txtJiboWifi`) — shows SSID or "no connection" (red text) based on `StatusContainer.getConnected()`
- **Location** (`txtJiboLocation`) — shows city name + timezone from `Robot.payload`; navigates to `LocationFragment`
- **Remote access toggle** (`mRemoteSwitch`) — `Robot.payload.remoteEnabled` field; saves via `RobotProperties.updateRobot`
- **Avatar** — displayed via `RobotHelper.getAvatar(robot)` → image level index; changed via `AvatarSelectionFragment`
- **Passphrase button** — state depends on backup existence (from `Key.restoreEncryptedKey`) and local key presence
- **Holidays** → `HolidaySettingsFragment`
- **About** → `RobotAboutFragment` (shows serial, OS version, owner name/email)

### StatusContainer.getConnected() Usage (CRITICAL for mock)

`Notification_20150505.getStatus(loop.getRobot())` is called with the **robot's accountId** (not a notification ID).

The `StatusContainer` response must include:
```json
{
  "connected": true/false,
  "SSID": "...",   // optional
  ...
}
```

If `connected == true`: shows WiFi SSID name from `RobotHelper.getWifiName(robot)` in green text.
If `connected == false` or error: shows "Jibo status no connection" in red text.

**Mock server fix needed:** The current mock returns `{"status": "delivered"}` for `Notification_20150505.GetStatus` — should return `{"connected": true}` for revival to show online status.

### RobotAboutFragment

Displays from `Robot.payload`:
- `osVersion` → `RobotHelper.getRobotOS(robot)` — `payload.platform` or similar field
- `serialName` → `RobotHelper.getRobotSerialName(robot)` — `payload.serialNumber`
- Owner name/email from `LoopHelper.getOwner(loop)` → `member.account.fullName` + `member.account.email`

---

## F022 — Encryption Passphrase Backup UX

**Class:** `com.jibo.p019ui.fragment.dialog.passphrase.LoopPassphraseUtils`

The app prompts users to create a passphrase to back up their loop's AES key. Without a backup, the key can only be recovered from the Android Keystore on the original device.

### DialogType Enum (11 types)
`FIRST_TIME`, `MEDIA_ADDED`, `WEEK_AFTER`, `FROM_SETTINGS`, `ON_RECONNECT_TO_JIBO`, `ON_RECONNECT_TO_JIBO_NO_BACKUP`, `ON_CANCEL`, `ON_SET`, `RESTORE`, `RESTORE_BY_TIMEOUT`, `NO_BACKUP_BY_TIMEOUT`

### Dialog Cadence (automatic prompts)
1. **FIRST_TIME** — shown immediately if no passphrase configured for the loop
2. **MEDIA_ADDED** — shown after 24 hours (86,400,000 ms) if first-time dialog was shown
3. **WEEK_AFTER** — shown after 7 days (604,800,000 ms) if media_added was shown
4. Then stops automatically

### SharedPreferences Keys (Passphrase)
| Key | Type | Purpose |
|-----|------|---------|
| `PREFERENCE_LOOP_PASSPHRASE_DIALOG_SHOW_DATE` | Long (epoch ms) | Last time dialog was shown |
| `PREFERENCE_LAST_SHOWN_DIALOG_TYPE` | String | Last dialog type shown |
| `PREFERENCE_PASSPHRASE_LOOP_{loopId}` | boolean | Whether passphrase already set for this loop |

### Dialog Variants
- `LoopPassphraseSetDialog` — create/backup passphrase (request code 121)
- `LoopPassphraseRestoreDialog` — restore key from passphrase (request code 122)
- `LoopPassphraseInfoDialog` — display passphrase info (request code 123)

### Key Backup Check
`m10584a(loopId, fragment, listener)` calls `Key_20160201.restoreEncryptedKey(loopId, null)` — if it succeeds, a backup exists; if it errors (404/not found), no backup exists.
