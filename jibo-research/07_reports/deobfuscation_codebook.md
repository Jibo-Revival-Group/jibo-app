# Deobfuscation Codebook — Jibo Android App
**Source:** JADX decompilation of `com.jibo` v1.0.9  
**Generated:** 2026-06-03

---

## Package Architecture

```
com.jibo
├── JiboApplication          -- Main Application class
├── BasicJiboApplication     -- Base Application (MultiDex)
├── JiboAnalytics            -- Segment Analytics wrapper
├── JiboSupport              -- Salesforce support integration
├── JiboGlideModule          -- Glide image loader config
├── JiboViewAddition         -- Salesforce view customization
├── R                        -- Resource IDs
│
├── api/iheart               -- iHeartRadio API integration
│   ├── IHeartApiServiceGenerator   -- Retrofit client factory
│   ├── IHeartFileHelper     -- Station file utilities
│   └── model/               -- Genre, Station, LocationConfig
│
├── aws/integration          -- Jibo backend API layer
│   ├── aws/services/        -- Service clients
│   │   ├── AbstractJiboClient       -- Base class (AWS AmazonWebServiceClient)
│   │   ├── AbstractJiboAsyncClient  -- Async base class
│   │   ├── account/         -- User account management
│   │   ├── accountAdmin/    -- Admin account operations
│   │   ├── binary/          -- Binary blob storage
│   │   ├── collision/       -- Face recognition collision checking
│   │   ├── exception/       -- API exception types
│   │   ├── file/            -- File storage
│   │   ├── gqa/             -- General Q&A / attribution
│   │   ├── jot/             -- Messaging
│   │   ├── key/             -- Encryption key management
│   │   ├── loop/            -- Loop (family group) management
│   │   ├── media/           -- Media (photos/videos)
│   │   ├── notification/    -- Notifications
│   │   ├── oobe/            -- Out-of-box experience (WiFi setup)
│   │   ├── person/          -- Person/holiday management
│   │   ├── photo/           -- Photo operations
│   │   ├── push/            -- Push notification devices
│   │   ├── robotProperties/ -- Robot metadata
│   │   ├── skills/          -- Skills/settings management
│   │   └── voicetraining/   -- Voice training samples
│   ├── helpers/             -- Business logic helpers
│   │   ├── AccountHelper    -- Account operations
│   │   ├── JotHelper        -- Message operations
│   │   ├── LoopHelper       -- Loop operations
│   │   ├── MediaHelper      -- Media operations
│   │   └── RobotHelper      -- Robot property accessors
│   └── util/
│       ├── Commons          -- Constants, endpoints, utilities
│       ├── KeyManager       -- Crypto key management
│       ├── DateTimeUtils    -- Date formatting
│       ├── ManufacturerHelper -- Device info
│       └── C0977a           -- Logging utility (obfuscated)
│
├── p018db/                  -- Database layer (obfuscated package)
│   ├── DatabaseContract     -- Table/URI definitions
│   ├── DatabaseProvider     -- ContentProvider (standard SQLite, NOT SQLCipher)
│   ├── EntityData           -- Data singleton (model layer)
│   └── LoopsAndLastMessagesContentProvider
│
├── p019ui/                  -- UI layer (obfuscated package)
│   ├── activity/            -- Activities
│   ├── fragment/
│   │   ├── account/         -- Account/profile screens
│   │   ├── dialog/          -- Dialogs
│   │   ├── guided/          -- Guided experiences
│   │   ├── home/            -- Home tab
│   │   ├── invite/          -- Loop invite screens
│   │   ├── jibos/           -- Jibo management
│   │   ├── onboarding/      -- Login/signup screens
│   │   ├── phone/           -- Phone verification
│   │   ├── profile/         -- Profile screens
│   │   ├── settings/        -- Settings screens
│   │   ├── tips/            -- Tips content
│   │   └── wifi/            -- WiFi setup wizard
│   ├── helpers/             -- UI helpers
│   └── view/                -- Custom views
│
├── service/                 -- Background services
│   ├── DeviceRegistrationService     -- Register device for push
│   ├── DeviceUnRegistrationService   -- Unregister on logout
│   ├── DataSyncJobService           -- Background data sync
│   ├── KeysCheckerJobService        -- Check/request encryption keys
│   ├── SyncTaskService              -- Sync coordination
│   ├── MessageSendingService        -- Send Jot messages
│   ├── MediaDeletingService         -- Delete media
│   ├── KeyRequestingSharingService  -- Key exchange between users
│   ├── JiboFirebaseMessagingService -- Handle push messages
│   ├── JiboFirebaseInstanceIdService -- Refresh push token
│   └── SyncHelper                   -- Sync coordination utility
│
└── utils/                   -- Utilities
    ├── cache/               -- Caching
    ├── ErrorHelper          -- Error code handling
    ├── ImageUtils           -- Image manipulation
    ├── LogUtils             -- Logging
    ├── QRCodeWriter         -- ZXing QR generation wrapper
    ├── SharedPreferencesUtil -- Preferences helpers
    └── Util                 -- General utilities
```

---

## Class Name Mappings

| Obfuscated Class | Proposed Name | Confidence | Evidence |
|---|---|:---:|---|
| `com.jibo.p018db` (package) | `com.jibo.db` | HIGH | apktool manifest shows `com.jibo.db.DatabaseProvider` |
| `com.jibo.p019ui` (package) | `com.jibo.ui` | HIGH | apktool manifest shows `com.jibo.ui.activity.*` |
| `com.jibo.aws.integration.aws.services.common.model.p005a.C0855e` | `DefaultRequestMarshaller` | HIGH | Builds HTTP request with X-Amz-Target header |
| `com.jibo.aws.integration.aws.services.common.model.p005a.C0852b` | `EmptyBodyMarshaller` | HIGH | Returns `"{}"` for body |
| `com.jibo.aws.integration.aws.services.common.model.p005a.C0853c` | `IdOrEmptyBodyMarshaller` | HIGH | Sends ID if non-empty, else `"{}"` |
| `com.jibo.aws.integration.util.C0977a` | `JiboLogger` | HIGH | Used as `TAG` and logging helper throughout |
| `com.jibo.aws.integration.aws.services.account.model.p001a.C0830a` | `AccountUnmarshaller` | HIGH | Unmarshals `Account` response |
| `com.jibo.aws.integration.aws.services.account.model.p001a.C0831b` | `AccountListUnmarshaller` | MEDIUM | Unmarshals `List<Account>` |
| `com.jibo.aws.integration.aws.services.account.model.p001a.C0832c` | `FacebookPrepareLoginUnmarshaller` | MEDIUM | Unmarshals `FacebookPrepareLogin` |
| `com.jibo.aws.integration.aws.services.account.model.p001a.C0833d` | `TokenContainerUnmarshaller` | MEDIUM | Unmarshals `TokenContainer` |
| `com.jibo.aws.integration.aws.services.account.model.p001a.C0834e` | `MultipartAccountMarshaller` | MEDIUM | For `UpdatePhotoRequest` |
| `com.jibo.aws.integration.aws.services.oobe.model.p014a.C0944a` | `KeysContainerUnmarshaller` | HIGH | Unmarshals `KeysContainer` response |
| `com.jibo.aws.integration.aws.services.oobe.model.p014a.C0945b` | `StatusContainerUnmarshaller` | HIGH | Unmarshals `StatusContainer` |
| `com.jibo.aws.integration.aws.services.oobe.model.p014a.C0946c` | `TokenContainerOOBEUnmarshaller` | HIGH | Unmarshals `TokenContainer` for OOBE |
| `com.jibo.aws.integration.aws.services.binary.p002a.C0842a` | `BinaryMarshaller` | MEDIUM | Handles binary data upload |
| `com.jibo.aws.integration.aws.services.exception.p006a.C0857b` | `UnauthorizedExceptionFactory` | MEDIUM | `UnauthorizedRequestException` |
| `com.jibo.aws.integration.aws.services.exception.p006a.C0858c` | `ForbiddenExceptionFactory` | MEDIUM | `ForbiddenRequestException` |
| `com.jibo.aws.integration.aws.services.exception.p006a.C0860e` | `ConflictExceptionFactory` | MEDIUM | `ConflictException` |
| `com.jibo.aws.integration.aws.services.exception.p006a.C0861f` | `NotFoundExceptionFactory` | MEDIUM | `ResourceNotFoundException` |
| `com.jibo.aws.integration.aws.services.exception.p006a.C0862g` | `InvalidParamExceptionFactory` | MEDIUM | `InvalidParameterValueException` |
| `com.jibo.aws.integration.aws.services.exception.p006a.C0864i` | `UnprocessableEntityFactory` | MEDIUM | `UnprocessableEntityException` |
| `com.jibo.aws.integration.aws.services.exception.p006a.C0865j` | `ServiceExceptionFactory` | MEDIUM | `ServiceException` |
| `com.jibo.aws.integration.util.Commons.AsyncCallback` | `ApiCallback<T>` | HIGH | Generic async callback interface |
| `EntityData.m10089a` | `EntityData.getInstance` | HIGH | Singleton accessor |
| `EntityData.m10134i` | `EntityData.getAccount` | HIGH | Returns current `Account` |
| `EntityData.m10122b` | `EntityData.getLoopClient` | MEDIUM | Returns `JiboLoopAsyncClient` |

---

## Method Mappings (Key Methods)

| Obfuscated Name | Class | Proposed Name | Evidence |
|---|---|---|---|
| `m9910a(ClientConfiguration)` | `AbstractJiboClient` | `configureClient` | Passthrough method |
| `m9911a()` | `AbstractJiboClient` | `initErrorHandlers` | Sets up error unmarshallers |
| `m9912a(request, handler, ctx)` | `AbstractJiboClient` | `executeRequest` | Core HTTP execution |
| `m9913a(jiboRequest, marshaller, unmarshaller)` | `AbstractJiboClient` | `invokeService` | High-level service call |
| `m10058a(loopId)` | `KeyManager` | `loopKeyFilename` | Returns `"loop_{accountId}_{loopId}"` |
| `m10059a(ctx)` | `KeyManager` | `initRsaKeyPair` | Creates RSA key in Keystore |
| `m10060a(ctx, loopId, keyBytes)` | `KeyManager` | `saveEncryptedKeyFile` | RSA-wraps and saves AES key |
| `m10062a(ctx, loopId)` | `KeyManager` | `loadDecryptedKeyBytes` | Decrypts and returns AES key bytes |
| `m10064b(ctx, loopId)` | `KeyManager` | `loadSecretKey` | Returns AES `SecretKey` |
| `m10065c(ctx, loopId)` | `KeyManager` | `hasKeyForLoop` | Checks if key file exists |
| `m11159a(data, key)` | `WiFiBaseQRCodeFragment` | `xorObfuscate` | XOR with repeating key |
| `m11172u()` | `WiFiBaseQRCodeFragment` | `buildQRPayload` | Constructs SSID+PW+TOKEN string |
| `m11173v()` | `WiFiBaseQRCodeFragment` | `generateQRCodes` | XOR-encodes and splits into QR codes |
| `m11174a()` | `WiFiBaseQRCodeFragment` | `startTokenRefresh` | Triggers token refresh runnable |
| `m11175q()` | `WiFiBaseQRCodeFragment` | `startRobotStatusPolling` | Polls GetStatus every 4s |
| `mo9956a(request)` | `C0855e` | `marshall` | Builds `DefaultRequest` with target header |
| `mo9961b(request)` | `C0855e` | `toJson` | Serializes request to JSON |
| `m9869a(context)` | `JiboSupport` | `initSalesforce` | Sets up SmartStoreSDKManager |
| `m9870b(context)` | `JiboSupport` | `launchCaseUI` | Opens Salesforce case creation |
| `m9868a(activity)` | `JiboSupport` | `launchKnowledgeUI` | Opens Salesforce knowledge base |

| `com.jibo.aws.integration.aws.services.media.JiboMediaClient` | `JiboMediaClient` | HIGH | Methods: `create`, `get`, `list`, `remove` |
| `com.jibo.aws.integration.aws.services.collision.JiboCollisionClient` | `JiboCollisionClient` | HIGH | Method: `match(faceIds, imageS3Key)` |
| `com.jibo.aws.integration.aws.services.gqa.JiboGQAClient` | `JiboGQAClient` | HIGH | Methods: `listAttributions`, `sendQuestion` |
| `com.jibo.aws.integration.aws.services.jot.JiboJotClient` | `JiboJotClient` | HIGH | Methods: `createMessage`, `listMessages`, `markRead` |
| `com.jibo.aws.integration.aws.services.key.JiboKeyClient` | `JiboKeyClient` | HIGH | Methods: `createRequest`, `getRequest`, `listIncomingRequests`, `backupEncryptedKey`, `restoreEncryptedKey`, `share` |
| `com.jibo.aws.integration.aws.services.loop.JiboLoopClient` | `JiboLoopClient` | HIGH | Full 18 methods including acceptInvitation, setLegalGuardian, etc. |
| `com.jibo.aws.integration.aws.services.notification.JiboNotificationClient` | `JiboNotificationClient` | HIGH | Method: `getStatus(notificationId)` |
| `com.jibo.aws.integration.aws.services.person.JiboPersonClient` | `JiboPersonClient` | HIGH | Methods: `getAccountProperties`, `getLoopProperties`, `setAccountProperty`, `setLoopProperty`, `listHolidays`, `switchHolidays` |
| `com.jibo.aws.integration.aws.services.push.JiboPushClient` | `JiboPushClient` | HIGH | Methods: `createDevice`, `removeDevice`, `getJotNotificationsMode`, `updateJotNotificationsMode` |
| `com.jibo.aws.integration.aws.services.robotProperties.JiboRobotPropertiesClient` | `JiboRobotPropertiesClient` | HIGH | Methods: `createRobot`, `getRobot`, `getFriendlyIds`, `removeRobot`, `updateRobot` |
| `com.jibo.aws.integration.aws.services.skills.JiboSkillsClient` | `JiboSkillsClient` | HIGH | Methods: `getSkillsJson`, `updateSkill`, `deleteSettings` |
| `com.jibo.aws.integration.aws.services.binary.JiboBinaryClient` | `JiboBinaryClient` | HIGH | Methods: `create`, `get`, `list`, `remove` + `downloadFileFromUrl` |
| `com.jibo.aws.integration.aws.services.file.JiboFileClient` | `JiboFileClient` | HIGH | Base for Photo/VoiceTraining; methods: `getFile`, `listFiles`, `removeFile`, `uploadFile` |
| `com.jibo.aws.integration.aws.services.accountAdmin.JiboAccountAdminClient` | `JiboAccountAdminClient` | HIGH | Single method: `activateById` |
| `com.jibo.p018db.DatabaseHelper` | `JiboDatabaseHelper` | HIGH | Standard SQLiteOpenHelper, unencrypted; creates `jiboapp.db` (v22) |
| `com.jibo.p018db.EntityData` | `EntityData` / `AppDataStore` | HIGH | Singleton data layer, holds all cached API entities |
| `com.jibo.p019ui.activity.TabbedActivity` | `TabbedActivity` | HIGH | Main 4-tab activity post-login |
| `com.jibo.p019ui.fragment.dialog.passphrase.LoopPassphraseUtils` | `LoopPassphraseUtils` | HIGH | Passphrase backup/restore dialog orchestration |
| `TabbedActivity.f9872n` | `FRAGMENT_CLASSES_COMPLETE` | HIGH | Tab fragment class names for complete state (4 tabs) |
| `TabbedActivity.f9873o` | `FRAGMENT_CLASSES_INITIAL` | HIGH | Tab fragment class names for initial state (no loops) |
| `TabbedActivity.f9876p` | `currentTabIndex` | HIGH | Currently selected tab (0-3) |
| `TabbedActivity.m10283a(i, force)` | `selectTab` | HIGH | Switch to tab i, optionally force-replace |
| `TabbedActivity.m10278C()` | `showLoopSelector` | HIGH | Slide down loop picker overlay with animation |
| `TabbedActivity.m10279D()` | `hideLoopSelector` | HIGH | Slide up loop picker overlay with animation |

---

## Service Target Prefix Reference

| Service | Target Prefix | Versioned API Date |
|---------|-------------|-------------------|
| Account | `Account_20151111.` | 2015-11-11 |
| Account Admin | `Account_20151111.` | 2015-11-11 |
| Audio | `Audio_20151103.` | 2015-11-03 |
| Binary | `Binary_20151201.` | 2015-12-01 |
| Collision | `Collision_20161126.` | 2016-11-26 |
| GQA | `GQA_20160930s.` | 2016-09-30 |
| Jot | `Jot_20160126.` | 2016-01-26 |
| Key | `Key_20160201.` | 2016-02-01 |
| Loop | `Loop_20160324.` | 2016-03-24 |
| Media | `Media_20160725.` | 2016-07-25 |
| Notification | `Notification_20150505.` | 2015-05-05 |
| OOBE | `OOBE_20161026.` | 2016-10-26 |
| Person | `Person_20160801.` | 2016-08-01 |
| Photo | `Photo_20151103.` | 2015-11-03 |
| Push | `Push_20160729.` | 2016-07-29 |
| RobotProperties | `RobotProperties_20160225.` | 2016-02-25 |
| Relationships | `Relationships_20160118.` | 2016-01-18 |
| Settings/Skills | `Settings_20171219.` | 2017-12-19 |
| Snap | `Snap_20160103.` | 2016-01-03 |
| VoiceTraining | `VoiceTraining_20151103.` | 2015-11-03 |

---

## Database Schema

### Tables (from `DatabaseContract`)

| Table | Columns | Purpose |
|-------|---------|---------|
| `entity` | `_id, name, type, retrieved, modified, data` | Generic entity store (Loops, Accounts, etc.) |
| `jot` | `_id, ...` | Cached messages |
| `media` | `_id, accountId, url, loopId, created, type, reference, isEncrypted` | Media metadata cache |
| `log_entries` | `_id, ...` | Debug/audit log |

### Full Table DDL

```sql
CREATE TABLE entity (
    _id TEXT NOT NULL,
    name TEXT NOT NULL DEFAULT '',
    type INTEGER NOT NULL DEFAULT 0,
    retrieved INTEGER NOT NULL DEFAULT -1,
    modified  INTEGER NOT NULL DEFAULT -1,
    data TEXT NULL DEFAULT NULL
);

CREATE TABLE jot (
    _id TEXT NOT NULL PRIMARY KEY,
    loopId TEXT NOT NULL DEFAULT '',
    content TEXT NULL DEFAULT NULL,
    sender TEXT NULL DEFAULT NULL,
    parts TEXT NULL DEFAULT NULL,
    hasPhotoVideo INTEGER DEFAULT 0,
    tags TEXT NULL DEFAULT NULL,
    created INTEGER DEFAULT -1,
    is_read INTEGER DEFAULT 0
);
CREATE INDEX jot_index_created ON jot(created);
CREATE INDEX jot_index_loop_created ON jot(created, loopId);

CREATE TABLE log_entry (
    _id INTEGER PRIMARY KEY,
    data TEXT NULL DEFAULT NULL
);

CREATE TABLE media (
    _id TEXT NOT NULL PRIMARY KEY,
    accountId TEXT NULL DEFAULT NULL,
    loopId TEXT NULL DEFAULT NULL,
    url TEXT NULL DEFAULT NULL,
    type TEXT NULL DEFAULT NULL,
    reference TEXT NULL DEFAULT NULL,
    isEncrypted INTEGER DEFAULT 0,
    created INTEGER NOT NULL DEFAULT -1
);
CREATE INDEX media_index_created ON media(created);
CREATE INDEX media_index_loop_created ON media(created, loopId);
```

**Schema version:** 22 (as of v1.0.9)

### Key Database Notes

- Database is **NOT encrypted** — uses standard Android SQLiteOpenHelper
- Database file: `jiboapp.db`
- ContentProvider authority: `com.jibo.provider.db`
- Entities stored as JSON blobs in the `data` column
- Media encryption status tracked via `isEncrypted` flag
- `libsqlcipher.so` present in APK is used exclusively by the Salesforce Service SDK (SmartStore), not by Jibo's own database code

### Entity Type Constants

| `type` Value | Entity Kind |
|---|---|
| `1` | Account (current authenticated user) |
| `2` | Members / contacts |
| `8` | Loops (family groups) |

---

## Data Models

### Loop

| Field | Type | Description |
|-------|------|-------------|
| `id` | String | Loop UUID |
| `name` | String | Display name |
| `owner` | String | accountId of owner |
| `robot` | String | accountId of robot member |
| `robotFriendlyId` | String | Human-readable robot ID |
| `members` | List<Member> | All loop members |
| `created` | Long | Epoch ms |
| `updated` | Long | Epoch ms |
| `isSuspended` | Boolean | Whether loop is suspended |

### Member

| Field | Type | Description |
|-------|------|-------------|
| `id` | String | Member UUID |
| `loopId` | String | Parent loop ID |
| `accountId` | String | User account ID |
| `account` | MemberAccount | `{id, email, firstName, lastName, photoUrl}` |
| `enrolled` | Enrolled | `{voice: Boolean, face: Boolean}` |
| `status` | InvitationStatus | `invited \| accepted \| declined \| removed` |
| `type` | InvitationType | `incoming \| outgoing` |
| `nickname` | String | Display nickname |
| `phoneticName` | String | Pronunciation hint for Jibo |
| `legalGuardianId` | String | Guardian accountId for child members |
| `created` | Long | Epoch ms |
| `agreementId` | String | EULA/agreement ID |

`isEnrolled()` = `enrolled.voice || enrolled.face`

### Message (Jot)

| Field | Type | Description |
|-------|------|-------------|
| `id` | String | Message UUID |
| `loopId` | String | Parent loop ID |
| `content` | String | Text content |
| `sender` | String | accountId of sender |
| `parts` | List<MessagePart> | Attached media parts |
| `tags` | List<String> | Message tags |
| `created` | Long | Epoch ms |
| `isRead` | Boolean | Read status |
| `isEncrypted` | Boolean | Whether content is AES-encrypted |

### MessagePart types
- `Media.TYPE_THUMBNAIL` → file with `.thumb` suffix
- `Media.TYPE_THUMBNAIL_ROBOT` → file with `.robot_thumb` suffix (330×330 px)

---

## Sync Flag Bitmask

| Flag | Decimal | Description |
|------|---------|-------------|
| Loops | `1` | Sync Loop entities |
| Accounts | `2` | Sync Account entities |
| Jots | `4` | Sync Jot/Message entities |
| Media | `8` | Sync Media metadata |
| Delete | `16` | OR'd with Media flag for delete sync |
| Loops+Jots+Media | `13` | Common combined sync |
| Accounts+Jots+Media | `28` | Full content sync |

---

## SharedPreferences Keys

**File:** SharedPreferences under `"Jibo"` (value of `R.string.app_name`)

| Key | Type | Default | Purpose |
|-----|------|---------|---------|
| `PREF_APP_OPEN_NUM` | int | 0 | Launch counter |
| `PREF_PUSH_SERVICE_TOKEN` | String | null | FCM device token |
| `PREF_INSTANCE_ID` | String | null | `instanceId + SecureRandom long` |
| `PREF_MEDIA_TAB_MODE` | int | 0 | Gallery layout (list/grid) |
| `"Loop"` | String (Gson JSON) | null | Last selected Loop object |
| `PREF_PARENTS_MEMBERS` | String (CSV) | null | Guardian member IDs |
| `PREF_ENCRYPTION_ENABLED` | boolean | true | Global AES encryption toggle |
| `PREF_LOOPS_IN_TIMEOUT` | String (CSV) | null | Loops with key exchange timeout |
| `PREF_LOOPS_ALERTED_TIMEOUT` | String (CSV) | null | Loops already shown timeout alert |
| `PREF_LOOPS_NO_HOLIDAYS` | String (CSV) | null | Loops with holidays disabled |
| `PREF_PUSHES_ON_GALLERY_CONTENT` | boolean | true | Gallery push notification toggle |
| `PREF_IS_PERSONAL_REPORT_DIALOG_SHOWN` | boolean | false | One-time dialog shown flag |
| `PREF_FIRST_TIME_TIPS` | boolean | true | First tips launch flag |
| `PREF_SHOW_INVITE_CONGRATS` | boolean | true | Invite congrats banner flag |
| `PREF_ACQUISITION` | boolean | false | Attribution acquisition flag |
| **`PREF_END_POINT`** | **String** | **api.jibo.com** | **Custom API endpoint (critical revival path)** |

**Warning:** `OnBoardingActivity.onCreate()` unconditionally overwrites `PREF_END_POINT` to `api.jibo.com` on each cold start via `Commons.ALLOWED_ENDPOINTS[2]`. DevSettingsFragment endpoint override only persists within the same session unless the overwrite is patched.
