# Background Services Report — Jibo Android App
**Source:** Static analysis of `com.jibo` v1.0.9  
**Generated:** 2026-06-03

---

## 1. Overview

The Jibo app uses 11 background service classes in `com.jibo.service`. All standard services use the `IntentService` pattern (work queue, auto-stops when done). Two are `JobService` subclasses using Firebase JobDispatcher for periodic scheduling.

| Class | Type | Purpose |
|-------|------|---------|
| `DeviceRegistrationService` | IntentService | Register device token for FCM push |
| `DeviceUnRegistrationService` | IntentService | Unregister device on logout |
| `JiboFirebaseMessagingService` | FirebaseMessagingService | Handle incoming push notifications |
| `JiboFirebaseInstanceIdService` | FirebaseInstanceIdService | Refresh FCM token |
| `KeyRequestingSharingService` | IntentService | Key exchange between users |
| `KeysCheckerJobService` | JobService (Firebase) | Periodic key check |
| `MediaDeletingService` | IntentService | Delete media files |
| `MessageSendingService` | IntentService | Send Jot messages with attachments |
| `DataSyncJobService` | JobService (Firebase) | Periodic background sync |
| `SyncTaskService` | IntentService | Handle sync work orders |
| `SyncHelper` | Utility class | Enqueue and schedule sync work |

---

## 2. FCM Push Notification Contract

**Class:** `com.jibo.service.JiboFirebaseMessagingService`

### 2.1 Message Type Enum (12 types)

All push notification types identified in `onMessageReceived`:

| Type String | Normalized | Handler Action |
|-------------|-----------|----------------|
| `jot_created_silent` | same | Sync jots for loop silently |
| `jot_created_tagged` | same | Sync jots, show notification |
| `loop_changed_silent` | same | Sync loop |
| `loop_invited` | same | Show notification; navigate to tab 0 |
| `loop_accepted` | same | Sync loops |
| `key_needed_silent` | same | Start key sharing workflow |
| `key_shared_silent` | same | Start key receiving workflow |
| `media_deleted_silent` | same | Delete media by path |
| `key_timeout_silent` | same | Mark loop in key timeout |
| `media_created_silent` | same | 4s delay, then sync + optional notification |
| `version_installed` | same | Show version install notification |
| `version_updated` | same | Show version update notification |

**Type normalization:** `.replace("-", "_").replace(".", "_")` — dashes and dots become underscores.

### 2.2 FCM Data Fields

| Field | Used By |
|-------|---------|
| `type` | All — message type selector |
| `loopId` | `loop_*`, `key_*`, `media_*`, `jot_*` |
| `path` | `media_deleted_silent` — path of media to delete |
| `loc-args` | Notification text substitution |
| `id` | `key_shared_silent` — request ID for key retrieval |

### 2.3 Detailed Handler Logic

**`loop_invited`**
- Shows system notification
- On tap: navigates to `TabbedActivity`, `ARG_TAB_SELECTED=0` (home/loops tab) with the `loopId`

**`media_created_silent`**
- Waits 4 seconds (delay for S3 propagation)
- Calls `SyncHelper` with flag `8` (media sync) for the loop
- If `PREF_PUSHES_ON_GALLERY_CONTENT == true`: shows notification navigating to tab 1 (gallery)

**`media_deleted_silent`**
- Starts `MediaDeletingService` with `EXTRA_FROM_OUTSIDE=true` and `EXTRA_IDS=[path]`
- `EXTRA_FROM_OUTSIDE=true` skips API call — only removes from local DB

**`key_needed_silent`**
- Starts `KeyRequestingSharingService` with `ACTION_KEY_REQUESTED` + `loopId`

**`key_shared_silent`**
- Starts `KeyRequestingSharingService` with `ACTION_KEY_SHARED` + `loopId` + `id`

**`key_timeout_silent`**
- Adds `loopId` to `PREF_LOOPS_IN_TIMEOUT` CSV list in SharedPreferences

**`version_installed` / `version_updated`**
- Shows notification with link to `R.string.release_notes_url`

**Notification channel:** `"my_channel_01"` (channel name: `"channel_name"`) — Android 8.0+ Oreo channel.

---

## 3. Device Registration Lifecycle

### 3.1 Registration (`DeviceRegistrationService`)

**Class:** `com.jibo.service.DeviceRegistrationService`  
Abstract base: `BasicDeviceRegistrationService`

**Triggered:** After successful login / account creation.

**Flow:**
1. `mo10152a()` → `FirebaseInstanceId.getInstance().getToken()` — gets FCM token
2. `mo10153b()` → `FirebaseInstanceId.getInstance().getId() + new SecureRandom().nextLong()` — unique instance ID
3. Calls `EntityData.getPushClient().createDevice(new Device(instanceId, token, Device.Type.android))`
4. Saves `PREF_PUSH_SERVICE_TOKEN = token`
5. Saves `PREF_INSTANCE_ID = instanceId`

**Device model sent to server:**
```json
{
  "instanceId": "<instanceId+random>",
  "token": "<FCM token>",
  "type": "android"
}
```

### 3.2 Unregistration (`DeviceUnRegistrationService`)

**Triggered:** On logout.

**Flow:**
1. Read `PREF_INSTANCE_ID` from SharedPreferences
2. Call `SharedPreferencesUtil.m11434b()` — clears ALL SharedPreferences
3. Call `KeyManager.logout(context)` — deletes all local key files
4. Call `Push.removeDevice(instanceId)` — deregisters from push server

---

## 4. Key Exchange Lifecycle

**Class:** `com.jibo.service.KeyRequestingSharingService`

Per-loop AES-256 symmetric keys are distributed out-of-band through the Key service. Each member gets an encrypted copy of the key.

### 4.1 Actions (4 total)

| Action Constant | Trigger | Description |
|----------------|---------|-------------|
| `ACTION_CHECK_ALL_LOOPS` | `KeysCheckerJobService` (every 120-180s) | Check all accepted loop memberships |
| `ACTION_REQUEST_KEY` | `ACTION_CHECK_ALL_LOOPS` | Request a key for a specific loop |
| `ACTION_KEY_REQUESTED` | FCM `key_needed_silent` | Share key with a requester |
| `ACTION_KEY_SHARED` | FCM `key_shared_silent` | Receive a shared key |

### 4.2 Detailed Flow

**`ACTION_CHECK_ALL_LOOPS`**
1. Query entity table for type=8 (Loop) rows
2. For each loop where `LoopHelper.isMemberAccepted()` is true
3. Send `ACTION_REQUEST_KEY` for that loop

**`ACTION_REQUEST_KEY` (loop member requesting a key)**
1. If no local key for loop AND `PREF_PUSH_SERVICE_TOKEN` is set
2. Call `Key_20160201.createRequest(loopId, keyManager.getPublicKeyForSharing())`
3. If response contains a key: call `m10164a` to save key locally

**`ACTION_KEY_REQUESTED` (loop owner sharing key with requester)**
1. Call `Key_20160201.listIncomingRequests(loopId)` → `List<Request>`
2. For each request:
   - Get requester's public key: `request.getPublicKey()`
   - Encrypt AES key: `symmetricKeyHolder.shareSymmetricKey(request.getPublicKey())` → RSA/PKCS1 encrypted blob
   - Call `Key_20160201.share(requestId, encryptedKeyBlob)`

**`ACTION_KEY_SHARED` (member receiving their key)**
1. Call `Key_20160201.getRequest(id)` → `Request` with `encryptedKey`
2. Save via `KeyManager.saveSymmetricKey(loopId, request.getEncryptedKey())`
3. Broadcast `ACTION_KEY_SAVED` local intent with `loopId`

### 4.3 Periodic Scheduling

`KeysCheckerJobService` runs `ACTION_CHECK_ALL_LOOPS` via Firebase JobDispatcher every **120–180 seconds** (window: 120s min, 180s max). Scheduled by `SyncHelper.m10175a()` (full sync).

---

## 5. Sync System

**Class:** `com.jibo.service.SyncHelper`

### 5.1 Sync Flag Bitmask

| Flag Value | Meaning |
|-----------|---------|
| `1` | Loops |
| `2` | Accounts |
| `4` | Jots (messages) |
| `8` | Media |
| `16` | Delete flag (or'd with media flag for delete sync) |
| `13` = `1\|4\|8` | Loops + Jots + Media |
| `28` = `4\|8\|16` | Accounts + Jots + Media |

### 5.2 Sync Entry Points

| Method | Flag | Description |
|--------|-----|-------------|
| `m10175a()` | ALL | Full sync: keys check + schedule KeysCheckerJobService |
| `m10176a(loopId)` | `1` | Loop sync |
| `m10178b()` | `2` | Accounts sync |
| `m10181c(loopId)` | `4` | Jot sync |
| `m10177a(loopId, delete)` | `8` or `8\|16` | Media sync (with optional delete) |

---

## 6. Message Sending

**Class:** `com.jibo.service.MessageSendingService`

### 6.1 Flow

1. Receive Intent with `Message` object (content + optional media file)
2. If message has photo/video:
   - Generate thumbnail (720×405 px) via `ImageUtils`
   - Generate robot thumbnail (330×330 px) via `ImageUtils`
3. If `message.isEncrypted()`:
   - Get AES key: `KeyManager.obtainKeyHolder(loopId)`
   - Encrypt file: `keyHolder.encodeFile(inputFile, outputFile)`
   - Encrypt thumbnails similarly
4. Upload media: `JiboMediaClient.create(loopId, type, parentPath, null, file, isEncrypted)`
   - Types: `Media.TYPE_THUMBNAIL` (`.thumb` suffix), `Media.TYPE_THUMBNAIL_ROBOT` (`.robot_thumb` suffix)
5. Create message: `JiboJotClient.createMessage(loopId, content, parts, tags)`

### 6.2 Failure Handling

- Failed messages get ID `"TEMP_FAILED_" + System.currentTimeMillis()`
- Stored in local DB with failed ID for retry/display

---

## 7. Media Deletion

**Class:** `com.jibo.service.MediaDeletingService`

### 7.1 Intent Extras

| Extra | Type | Description |
|-------|------|-------------|
| `EXTRA_IDS` | `String[]` | Array of media paths to delete |
| `EXTRA_FROM_OUTSIDE` | `boolean` | Whether deletion originated from push (external) |

### 7.2 Permission Model

Deletion is allowed only if **one of**:
- `EXTRA_FROM_OUTSIDE == true` (FCM-triggered deletion)
- Current user is loop owner
- Current user is the media uploader (`accountId` matches)

### 7.3 Deletion Flow

1. For each path in `EXTRA_IDS`:
   - Collect path AND its `reference` (thumbnail path) from media table
2. If `EXTRA_FROM_OUTSIDE == false`:
   - Call `Media_20160725.remove(mediaIds)` API
3. Delete from local DB (both main media and referenced thumbnails)

---

## 8. SharedPreferences Schema

**File:** `SharedPreferences` under key `getString(R.string.app_name)` = `"Jibo"`

| Key Constant | Type | Default | Description |
|---|---|---|---|
| `PREF_APP_OPEN_NUM` | int | 0 | App launch counter |
| `PREF_PUSH_SERVICE_TOKEN` | String | null | FCM device token |
| `PREF_INSTANCE_ID` | String | null | Firebase instance ID + random long |
| `PREF_MEDIA_TAB_MODE` | int | 0 | Media tab view mode (list vs grid) |
| `"Loop"` | String (Gson JSON) | null | Last selected Loop object |
| `PREF_PARENTS_MEMBERS` | String (CSV) | null | Guardian/parent member IDs |
| `PREF_ENCRYPTION_ENABLED` | boolean | true | Global encryption toggle |
| `PREF_LOOPS_IN_TIMEOUT` | String (CSV) | null | Loop IDs with key timeout |
| `PREF_LOOPS_ALERTED_TIMEOUT` | String (CSV) | null | Loop IDs already alerted for timeout |
| `PREF_LOOPS_NO_HOLIDAYS` | String (CSV) | null | Loop IDs with holidays disabled |
| `PREF_PUSHES_ON_GALLERY_CONTENT` | boolean | true | Show notification for new photos |
| `PREF_IS_PERSONAL_REPORT_DIALOG_SHOWN` | boolean | false | One-time onboarding dialog |
| `PREF_FIRST_TIME_TIPS` | boolean | true | Show first-time tips |
| `PREF_SHOW_INVITE_CONGRATS` | boolean | true | Show invite congratulations |
| `PREF_ACQUISITION` | boolean | false | Attribution acquisition flag |
| **`PREF_END_POINT`** | **String** | **api.jibo.com** | **CRITICAL: custom endpoint override (revival path)** |

---

## 9. Data Models

### 9.1 Loop

```java
class Loop {
    String id;
    String name;
    String owner;         // accountId of owner
    String robot;         // accountId of robot
    String robotFriendlyId;
    List<Member> members;
    Long created;
    Long updated;
    Boolean isSuspended;
}
```

### 9.2 Member

```java
class Member {
    String id;
    String loopId;
    String accountId;
    MemberAccount account;    // {id, email, firstName, lastName, photoUrl}
    Enrolled enrolled;        // {voice: Boolean, face: Boolean}
    InvitationStatus status;  // invited | accepted | declined | removed
    InvitationType type;      // incoming | outgoing
    String nickname;
    String phoneticName;
    String legalGuardianId;
    Long created;
    String agreementId;
}

// isEnrolled() = enrolled.voice || enrolled.face
```

### 9.3 Message (Jot)

```java
class Message {
    String id;
    String loopId;
    String content;
    String sender;        // accountId
    List<MessagePart> parts;
    List<String> tags;
    Long created;
    Boolean isRead;
    Boolean isEncrypted;
}
```

### 9.4 Entity Type Constants (DB)

| Type Value | Entity |
|-----------|--------|
| `1` | Account (current user) |
| `2` | Members / contacts |
| `8` | Loops |
