# Phase 1 Static Triage Report — Jibo Android APK
**Generated:** 2026-06-03  
**Analyst:** Claude Code (automated)

---

## APK Identity

| Field | Value |
|-------|-------|
| Filename | `Jibo.apk` |
| Absolute Path | `/Users/marcnoguera/jibo-claude/Jibo.apk` |
| Size | 47 MB (49,488,484 bytes) |
| SHA256 | `1581b6df9e7729f0d33c4011e656ec0508a69c8b1e9dfcc95014f7c25ef87a9f` |
| Package Name | `com.jibo` |
| Version Name | `1.0.9` |
| Version Code | `33` |
| Build Date | May 30, 2018 (from Crashlytics properties) |
| Min SDK | 19 (Android 4.4 KitKat) |
| Target SDK | 27 (Android 8.1 Oreo) |

---

## Tool Availability

| Tool | Available | Path |
|------|-----------|------|
| Java 17 | ✅ | `/opt/homebrew/opt/openjdk@17/bin/java` |
| JADX | ✅ | `/opt/homebrew/bin/jadx` |
| apktool | ✅ | `/opt/homebrew/bin/apktool` |
| dex2jar | ✅ (installed) | `/opt/homebrew/bin/d2j-dex2jar` |
| Vineflower 1.12.0 | ✅ (installed) | `/opt/homebrew/Cellar/vineflower/1.12.0/libexec/vineflower.jar` |
| aapt | ✅ | `~/Library/Android/sdk/build-tools/36.0.0/aapt` |
| aapt2 | ✅ | `~/Library/Android/sdk/build-tools/36.0.0/aapt2` |
| apkanalyzer | ✅ | `~/Library/Android/sdk/cmdline-tools/latest/bin/apkanalyzer` |
| adb | ✅ | `~/Library/Android/sdk/platform-tools/adb` |
| ripgrep | ✅ | `/opt/homebrew/bin/rg` |
| python3 | ✅ | `Python 3.13.9` |

---

## Signing Certificate

| Field | Value |
|-------|-------|
| Subject | CN=AZ |
| Issuer | CN=AZ (self-signed) |
| Serial | 0x5756a97a |
| Valid From | 2016-06-07 |
| Valid Until | 2041-06-01 |
| SHA1 | `50:09:0B:1A:46:82:87:C8:3C:23:AE:CD:C0:8D:94:CC:5C:B4:4D:2C` |
| Algorithm | SHA1withRSA (WEAK — 1024-bit key) |

---

## Manifest Summary

### Permissions

| Permission | Purpose |
|-----------|---------|
| `INTERNET` | Cloud API communication |
| `ACCESS_WIFI_STATE` | Read current WiFi network info |
| `CHANGE_WIFI_STATE` | WiFi management for setup |
| `ACCESS_COARSE_LOCATION` | Required by WiFi scanning |
| `ACCESS_FINE_LOCATION` | GPS for robot location |
| `READ/WRITE_EXTERNAL_STORAGE` | Media file access |
| `WAKE_LOCK` | Background sync |
| `READ_CONTACTS` | Contact lookup for Loop invites |
| `WRITE_SETTINGS` | WiFi/system settings modification |
| `GET_ACCOUNTS`, `MANAGE_ACCOUNTS`, `USE_CREDENTIALS` | Android account sync |
| `AUTHENTICATE_ACCOUNTS`, `READ/WRITE_SYNC_SETTINGS` | AccountManager/SyncAdapter |
| `USE_FINGERPRINT` (SDK 23+) | Biometric auth |
| `com.google.android.c2dm.permission.RECEIVE` | Firebase Cloud Messaging |

**No Bluetooth permissions declared.** WiFi setup is QR-code based, not Bluetooth.

### Main Activities

| Activity | Role |
|---------|------|
| `OnBoardingActivity` | LAUNCHER — login, signup, password reset |
| `TabbedActivity` | Main app with tab navigation |
| `WifiActivity` | WiFi setup wizard host |
| `SingleFragmentActivity` | Generic fragment container |
| `TipsActivity` | Tips/tutorial content |
| `GuidedExperienceActivity` | Guided experience flows |
| `PhotoViewerActivity` | Photo viewer |
| `TagPhotoActivity` | Photo tagging |
| `TipVideoActivity` | Video tips (landscape) |
| `LoopInviteDetailsActivity` | Loop invitation screen |
| `com.facebook.FacebookActivity` | Facebook OAuth |
| `com.yalantis.ucrop.UCropActivity` | Image cropping |
| Salesforce activities (4) | Customer support |

### Services

| Service | Role |
|---------|------|
| `JiboFirebaseMessagingService` | Firebase push message handler |
| `JiboFirebaseInstanceIdService` | Firebase token refresh |
| `DeviceRegistrationService` | Register device for push |
| `DeviceUnRegistrationService` | Unregister device |
| `DataSyncJobService` | Periodic data sync |
| `KeysCheckerJobService` | Encryption key check |
| `SyncTaskService` | Sync task manager |
| `MessageSendingService` | Send Jot messages |
| `MediaDeletingService` | Delete media files |
| `KeyRequestingSharingService` | Key exchange between users |
| Salesforce services (4) | Analytics, GCM, push |
| Firebase Messaging, InstanceID | Push infrastructure |

### Content Providers

| Provider | Authority | Purpose |
|---------|-----------|---------|
| `DatabaseProvider` | `com.jibo.provider.db` | Main app database |
| `LoopsAndLastMessagesContentProvider` | `com.jibo.provider.db.messages` | Messages/Loops data |
| `FileProvider` | `com.jibo.fileprovider` | File URI sharing |

### Broadcast Receivers

| Receiver | Purpose |
|---------|---------|
| `LoopHolidaysAlarmReceiver` | Holiday reminder alarms |
| `GcmReceiver` (Google) | Legacy GCM push |
| Firebase push receivers | Firebase push |
| Google Analytics receivers | Analytics |

---

## Native Libraries

| Library | Architectures | Notes |
|---------|--------------|-------|
| `libsqlcipher.so` | arm64-v8a, armeabi, armeabi-v7a, x86, x86_64 | SQLCipher encrypted SQLite |
| `libucrop.so` | arm64-v8a, armeabi-v7a, x86, x86_64 | Image crop native |
| `libutils-jni.so` | arm64-v8a, armeabi-v7a, x86, x86_64 | JNI utilities (Jibo-specific) |

All libraries are stripped (no debug symbols).

---

## Asset Categories

| Category | Files |
|---------|-------|
| Fonts | `ProximaNova-{Bold,Light,Regular,Semibold}.otf/.ttf`, `Roboto-{Bold,Medium,Regular}.ttf` |
| Crashlytics config | `crashlytics-build.properties` |
| CSS | `knowledge_article_details.css` (Salesforce support article styling) |
| JSON | `res/raw/genres.json` (iHeartRadio genre list) |
| Video | `res/raw/video_congrats.mp4` (congratulations animation) |
| XML config | `res/xml/servers.xml`, `app_restrictions.xml`, `authenticator.xml`, `files.xml` |

---

## Key Strings Found

| String Name | Value |
|------------|-------|
| `firebase_database_url` | `https://jibo-dev-672f5.firebaseio.com` |
| `google_api_key` | `AIzaSyB9RJzyVItZVjNjmDuN0nLhfrLPexhlOkM` |
| `google_timezone_api_key` | `AIzaSyAMb6PNT4zfy3oAaVBbDUD5e8GNiW9cIrE` |
| `places_api_key` | `AIzaSyC5ah9HTo60lTaRaEAkKtW_iR_VQPI77ms` |
| `ifttt_url` | `https://ifttt.com/jibo` |
| `api_version` | `v39.0` (Salesforce API) |
| `db_authority` | `com.jibo.provider.db` |

---

## Framework / Engine Evidence

| Framework | Evidence |
|-----------|---------|
| AWS SDK for Android | `AbstractJiboClient extends AmazonWebServiceClient` |
| Retrofit2 + OkHttp3 | iHeartRadio API calls |
| Crashlytics | `fabric.properties`, assets |
| Firebase | `firebaseinitprovider`, `firebaseperfprovider`, `google_api_key` string |
| Salesforce Service SDK | Multiple Salesforce activities/services |
| Facebook SDK | `FacebookActivity`, Facebook auth methods |
| Google Play Services (GCM/Auth) | Multiple GMS receivers/services |
| ZXing | QR code generation |
| SQLCipher | Encrypted database |
| Glide | Image loading |
| ButterKnife | View binding |
| Joda Time | Date/time |
| Jackson | JSON (via META-INF service files) |
| GSON | JSON serialization |

**No Unity, Cocos, React Native, Cordova, or other cross-platform framework detected.**

---

## DEX Structure

- `classes.dex` — primary DEX
- `classes2.dex` — secondary DEX (MultiDex)
- Total decompiled classes: ~6,356

---

## Interesting Files

| File | Finding |
|------|---------|
| `res/xml/servers.xml` | Binary XML — Salesforce server config (Production/Sandbox) |
| `res/xml/app_restrictions.xml` | MDM restrictions: `AppServiceHostLabels`, `AppServiceHosts`, `ManagedAppCallbackURL`, `RequireCertAuth`, `OnlyShowAuthorizedHosts` |
| `res/xml/authenticator.xml` | Android AccountManager integration — account type `com.jibo` |
| `res/raw/genres.json` | iHeartRadio genre list (Pop, Country, Hip-Hop, etc.) |
| `META-INF/CERT.RSA` | APK signing certificate |
| `assets/knowledge_article_details.css` | Salesforce CSS for knowledge articles |
| `lib/*/libutils-jni.so` | Unknown Jibo-specific JNI — needs further analysis |

---

## Recommended Phase 2 Strategy

1. **JADX** (already completed): Best for Kotlin/Java deobfuscation, class hierarchy
2. **dex2jar + Vineflower** (already completed): Second opinion on decompiled logic
3. **Priority analysis areas:**
   - `com.jibo.aws.integration` — entire API layer
   - `com.jibo.p019ui.fragment.wifi` — WiFi/OOBE setup
   - `com.jibo.p019ui.fragment.onboarding` — auth flow
   - `com.jibo.service` — background services
   - `com.jibo.p018db` — database schema/queries
   - `libutils-jni.so` — native code (strings analysis)

---

## Risks, Blockers, and Open Questions

| Item | Status |
|------|--------|
| JADX had 11 decompilation errors | Minor — most code recovered |
| `servers.xml` binary XML not readable as text | Used aapt to confirm Salesforce config |
| SQLCipher database key not yet found | Need to trace `DatabaseProvider` initialization |
| `libutils-jni.so` purpose unknown | Run `strings` against it |
| Device-to-cloud vs device-to-device protocol unknown | Is there local WebSocket to robot? |
| Token in QR: does robot contact cloud directly? | Yes — robot uses token to call SetupRobot |
