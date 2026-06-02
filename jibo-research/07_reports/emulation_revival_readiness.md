# Emulation / Revival Readiness Report — Jibo Android App
**Source:** Static analysis of `com.jibo` v1.0.9  
**Generated:** 2026-06-03

---

## 1. Executive Summary

The Jibo Android app is **partially revivable** without the original Jibo cloud infrastructure. The app's UI and most features can be exercised with a mock backend server. However, **full revival** (robot actually connecting and responding) requires either:
- A modified Jibo robot firmware
- Or emulation of the robot side of the protocol

The app has **no local-only mode** — every feature requires a cloud connection.

---

## 2. What Works Offline

**Nothing.** The app is 100% cloud-dependent. On first launch, it immediately attempts to authenticate against `api.jibo.com`. There is no offline mode, demo mode, or cached-only operation.

---

## 3. Cloud Dependency Map

### Required for App Launch

| Service | Endpoint | Required Operation | Notes |
|---------|---------|-------------------|-------|
| Account | `api.jibo.com` | Login / Create | App cannot proceed without valid account |
| Loop | `api.jibo.com` | ListLoops | Main app screen requires loop list |

### Required for Core Features

| Feature | Service | Operations |
|---------|---------|-----------|
| View Jibo/robots | RobotProperties | GetRobot |
| Loop members | Loop | ListLoopMembers |
| Photos/videos | Media | ListMedia, GetMedia |
| Messaging (Jot) | Jot | CreateMessage, ListMessages |
| WiFi setup | OOBE | PrepareRobot, GetStatus |
| Skills | Settings | GetSkillsJson, UpdateSkill |
| Push notifications | Push | AddDevice |

### Required for Optional Features

| Feature | Service | Operations |
|---------|---------|-----------|
| Customer support | Salesforce | External (jibo.force.com) |
| iHeart radio | iHeart API | External (us.api.iheart.com) |
| Encryption key sharing | Key | All key operations |
| Voice training | VoiceTraining | Upload |
| Face recognition | Collision | Match |
| GQA / attribution | GQA | GetAttribution |

---

## 4. What Endpoints Need Mocking

### Minimum Viable Mock (App Launches + Main Screen)

```yaml
endpoints:
  - target: Account_20151111.Login
    method: POST
    response:
      id: <uuid>
      email: <from-request>
      accessKeyId: "AKIAMOCKTEST0001"
      secretAccessKey: "mockSecret1234567890123456789012"
      isActive: true
      firstName: "Jibo"
      lastName: "User"
      gender: "other"
      birthday: 0
      devices: []

  - target: Account_20151111.Create
    method: POST  
    response: <same as Login but empty>

  - target: Loop_20160324.ListLoops
    method: POST
    response: []  # empty list for new user

  - target: Push_20160729.AddDevice
    method: POST
    response: [<device>]
```

### Full Feature Mock

```yaml
additional_endpoints:
  # Loop management
  - Loop_20160324.CreateLoop
  - Loop_20160324.ListLoops
  - Loop_20160324.UpdateLoop
  - Loop_20160324.RemoveLoop
  - Loop_20160324.AcceptLoopInvitation
  - Loop_20160324.DeclineLoopInvitation
  - Loop_20160324.InviteMember
  - Loop_20160324.ListLoopMembers
  - Loop_20160324.RemoveMember
  - Loop_20160324.UpdateMember
  - Loop_20160324.UpdateNickname
  - Loop_20160324.UpdatePhoneticName
  - Loop_20160324.SetLegalGuardian
  - Loop_20160324.SuspendLoop
  - Loop_20160324.GetRobot
  - Loop_20160324.ListOwnerRobots

  # Robot properties
  - RobotProperties_20160225.CreateRobot
  - RobotProperties_20160225.GetRobot
  - RobotProperties_20160225.UpdateRobot
  - RobotProperties_20160225.RemoveRobot
  - RobotProperties_20160225.GetFriendlyIds

  # OOBE
  - OOBE_20161026.PrepareRobot
  - OOBE_20161026.GetStatus
  - OOBE_20161026.SetupRobot

  # Messaging
  - Jot_20160126.CreateMessage
  - Jot_20160126.ListMessages
  - Jot_20160126.MarkRead

  # Media
  - Media_20160725.CreateMedia
  - Media_20160725.GetMedia
  - Media_20160725.ListMedia
  - Media_20160725.RemoveMedia

  # Skills
  - Settings_20171219.GetSettings
  - Settings_20171219.UpdateSettings
  - Settings_20171219.DeleteSettings

  # Encryption keys
  - Key_20160201.CreateRequest
  - Key_20160201.GetRequest
  - Key_20160201.ListIncomingRequests
  - Key_20160201.BackupEncryptedKey
  - Key_20160201.RestoreEncryptedKey
  - Key_20160201.Share

  # Push notifications
  - Push_20160729.AddDevice
  - Push_20160729.RemoveDevice
  - Push_20160729.GetJotNotificationsMode
  - Push_20160729.UpdateJotNotificationsMode

  # Persons/holidays
  - Person_20160801.GetAccountProperties
  - Person_20160801.GetLoopProperties
  - Person_20160801.SetAccountProperty
  - Person_20160801.SetLoopProperty
  - Person_20160801.ListHolidays
  - Person_20160801.SwitchHolidays

  # Face recognition
  - Collision_20161126.Match

  # GQA / attribution
  - GQA_20160930s.ListAttributions
  - GQA_20160930s.SendQuestion

  # Notification status
  - Notification_20150505.GetStatus
```

---

## 5. What Onboarding Requires

### App-Side Requirements

1. Mock server listening at a hostname resolvable by the device (or use hosts file)
2. Mock server must accept unsigned requests for Login (NoOpSigner bypass)
3. Mock server must accept AWS SigV4-signed requests for all other operations
4. `PrepareRobot` must return a `TokenContainer` with token and expiry in future

### Robot-Side Requirements (for WiFi setup)

1. **QR parsing:** Robot firmware must XOR-decode QR code with key `"Wow, you cracked our secret code. Impressive. Maybe you should check out jibo.com/jobs."`
2. **Network connection:** Robot must use WiFi credentials from decoded QR
3. **OOBE call:** Robot must call `OOBE_20161026.SetupRobot(id, token)` to mock server
4. **Result handling:** Robot uses returned `KeysContainer` for subsequent AWS calls

**Without robot firmware access, WiFi setup can be simulated but not completed end-to-end.**

---

## 6. DNS / Redirect Strategy

To redirect `api.jibo.com` to a local mock server:

### Option A: Android hosts file (requires root)
```
192.168.1.100  api.jibo.com
```

### Option B: VPN/Proxy (no root required)
- Use an intercepting proxy (mitmproxy, Charles)
- Point Android VPN to local network
- Map `api.jibo.com` to mock server IP

### Option C: Modify APK
1. Decompile with apktool
2. Replace `api.jibo.com` references in strings.xml or smali
3. Recompile and sign with debug key
4. **Note:** App uses `Commons.setRootEndpoint()` — could be patched

### Option D: Xposed/LSPosed Framework
- Hook `Commons.setRootEndpoint()` to redirect to local server

### Option E: DevSettingsFragment UI (No APK Modification, No Root)

The app ships a `DevSettingsFragment` accessible via hidden swipe gesture or the `ACTION_DEV_SETTINGS` intent. It has an `setEndpoint()` button that calls:

```java
Commons.setRootEndpoint(enteredString);
sharedPreferences.edit().putString("PREF_END_POINT", enteredString).apply();
```

This changes the endpoint **at runtime** without APK modification.

**Critical caveat:** `OnBoardingActivity.onCreate()` always overwrites `PREF_END_POINT` with `Commons.ALLOWED_ENDPOINTS[2]` (`api.jibo.com`) on fresh launch:
```java
// OnBoardingActivity line 86:
sharedPreferences.edit().putString("PREF_END_POINT", Commons.ALLOWED_ENDPOINTS[2]).apply();
```

This means the custom endpoint is reset every time the app cold-starts through normal launch. To persist:
- Access DevSettingsFragment **after** OnBoardingActivity has started (not on the splash screen)
- OR use Option C/D to prevent the overwrite

**To invoke DevSettingsFragment via ADB (no interaction needed):**
```bash
adb shell am start -n com.jibo/.ui.activity.DevSettingsActivity
# or via broadcast if exported:
adb shell am broadcast -a com.jibo.ACTION_DEV_SETTINGS
```

**Option E is the lowest-friction path** for initial testing since it requires no root, no APK signing, and no proxy setup.

---

## 7. SigV4 Authentication Considerations

The mock server needs to handle SigV4. Options:

1. **Accept all signatures** (simplest) — just check header exists, don't validate
2. **Validate with test credentials** — use fixed `AKIAMOCKTEST0001`/`mockSecret...`

The AWS SDK signs with the credentials returned at Login. If the mock server returns fixed test credentials, all subsequent requests will be signed with those credentials.

---

## 8. APK Modification for Mock Server

To point the app to a local mock server without DNS tricks:

```bash
# 1. Decode APK
apktool d -f Jibo.apk -o Jibo_decoded/

# 2. Patch strings.xml
# Change api.jibo.com to 192.168.1.100 (or local hostname)
sed -i 's/api\.jibo\.com/192.168.1.100/g' Jibo_decoded/res/values/strings.xml

# 3. Patch Commons smali (if hardcoded)
# Find in smali: stg-entrypoint.jibo.com, api.jibo.com
find Jibo_decoded/smali* -name "Commons.smali" | xargs grep -l "api.jibo"
# Edit the const-string values

# 4. Rebuild
apktool b Jibo_decoded/ -o Jibo_patched.apk

# 5. Sign with debug key
keytool -genkey -v -keystore debug.keystore -alias debug -keyalg RSA -keysize 2048 -validity 10000
jarsigner -verbose -sigalg SHA1withRSA -digestalg SHA1 -keystore debug.keystore Jibo_patched.apk debug
zipalign -v 4 Jibo_patched.apk Jibo_final.apk
```

**Alternative:** Patch the APK to call `Commons.setRootEndpoint("192.168.1.100")` in application init.

---

## 9. Local Assets (What's Already On-Device)

| Asset | Available Locally | Notes |
|-------|-----------------|-------|
| ProximaNova fonts | ✅ Yes | In `assets/fonts/` |
| Roboto fonts | ✅ Yes | In `assets/fonts/` |
| Congratulations video | ✅ Yes | `res/raw/video_congrats.mp4` |
| Radio genres list | ✅ Yes | `res/raw/genres.json` (cached list) |
| Knowledge article CSS | ✅ Yes | `assets/knowledge_article_details.css` |
| UI drawables/layouts | ✅ Yes | In APK |
| Media (photos/videos from robot) | ❌ No | Retrieved from cloud S3 |
| Robot configuration | ❌ No | Retrieved from API |
| Loop data | ❌ No | Retrieved from API |
| Skills settings | ❌ No | Retrieved from API |

---

## 10. Risks and Unknowns

| Risk | Severity | Notes |
|------|---------|-------|
| ~~SQLCipher key unknown~~ | RESOLVED | **Jibo's database is NOT encrypted.** `jiboapp.db` uses standard unencrypted SQLite. SQLCipher in APK belongs to Salesforce SDK only. |
| Robot-side firmware unknown | HIGH | QR setup requires robot cooperation |
| SigV4 signing may be strict | LOW | App uses AWS SDK standard signing |
| Firebase dependency | MEDIUM | Push notifications require real Firebase or emulator |
| Salesforce dependency | LOW | Only for customer support flows |
| iHeart API requires key | MEDIUM | No auth key found; may work with no key or requires registration |
| Local WebSocket to robot | UNKNOWN | No evidence found in app; unclear if app talks directly to robot after setup |
| `libutils-jni.so` validation | LOW | Library performs `strcmp`/`checkSecureData` + validates `Account_20151111.` prefix via JNI call into `Commons.TARGET_PREFIX_ACCOUNT` — may reject non-Jibo endpoints |

---

## 11. Recommended Next Engineering Steps

### Immediate (App Only)

1. **Build Python mock server** from the expanded handler table in Section 12 (covers all ~55 endpoints)
2. **Patch APK** to point to local server (either DNS redirect or APK smali patch, see Section 8)
3. **Test app launch** — verify login flow works with mock credentials
4. **Test main screen** — verify loop list, Jibo info display
5. **Capture network traffic** with intercepting proxy to verify request/response format

### Short-term (Full App)

6. Test WiFi setup flow (app side only — robot will fail but app flow can be verified up to QR display)
7. Analyze `libutils-jni.so` binary more deeply to understand `checkSecureData` validation — verify whether it gates API access on the endpoint URL or just logs metrics
8. **The Jibo app database (`jiboapp.db`) is unencrypted** — if recovered from a device, it can be read directly with standard SQLite tools

### Long-term (Robot Revival)

9. Obtain Jibo robot firmware or disk image
10. Identify QR parsing code in firmware (XOR key: `"Wow, you cracked our secret code. Impressive. Maybe you should check out jibo.com/jobs."`)
11. Map robot-side API calls to app-side expectations (robot calls `OOBE_20161026.SetupRobot`, receives `KeysContainer`)
12. Build complete local stack: mock server + modified hosts on robot
13. Test end-to-end WiFi setup with robot

---

## 12. Mock Server Sample (Python)

```python
#!/usr/bin/env python3
"""Minimal Jibo mock server"""
from http.server import HTTPServer, BaseHTTPRequestHandler
import json, uuid, time

ACCOUNTS = {}

class JiboMockHandler(BaseHTTPRequestHandler):
    def do_POST(self):
        target = self.headers.get('X-Amz-Target', '')
        length = int(self.headers.get('Content-Length', 0))
        body = json.loads(self.rfile.read(length)) if length else {}
        
        response = self.dispatch(target, body)
        data = json.dumps(response).encode()
        self.send_response(200)
        self.send_header('Content-Type', 'application/json')
        self.send_header('Content-Length', len(data))
        self.end_headers()
        self.wfile.write(data)
    
    def dispatch(self, target, body):
        handlers = {
            # Account
            'Account_20151111.Login':     self.handle_login,
            'Account_20151111.Create':    self.handle_create,
            # Loop
            'Loop_20160324.ListLoops':       lambda b: [],
            'Loop_20160324.CreateLoop':      self.handle_create_loop,
            'Loop_20160324.UpdateLoop':      self.handle_create_loop,
            'Loop_20160324.RemoveLoop':      self.handle_create_loop,
            'Loop_20160324.AcceptLoopInvitation':  self.handle_create_loop,
            'Loop_20160324.DeclineLoopInvitation': self.handle_create_loop,
            'Loop_20160324.InviteMember':    self.handle_create_loop,
            'Loop_20160324.ListLoopMembers': lambda b: [],
            'Loop_20160324.RemoveMember':    self.handle_create_loop,
            'Loop_20160324.UpdateMember':    self.handle_create_loop,
            'Loop_20160324.ListOwnerRobots': lambda b: [],
            'Loop_20160324.GetRobot':        self.handle_get_robot,
            # Robot Properties
            'RobotProperties_20160225.GetRobot':      self.handle_get_robot,
            'RobotProperties_20160225.CreateRobot':   lambda b: {"success": True},
            'RobotProperties_20160225.UpdateRobot':   lambda b: {"success": True},
            'RobotProperties_20160225.RemoveRobot':   lambda b: {"success": True},
            'RobotProperties_20160225.GetFriendlyIds': lambda b: [],
            # OOBE
            'OOBE_20161026.PrepareRobot': self.handle_prepare_robot,
            'OOBE_20161026.GetStatus':    lambda b: {"complete": True},
            'OOBE_20161026.SetupRobot':   self.handle_setup_robot,
            # Messaging
            'Jot_20160126.CreateMessage': lambda b: {"id": str(uuid.uuid4()), "created": int(time.time() * 1000)},
            'Jot_20160126.ListMessages':  lambda b: [],
            'Jot_20160126.MarkRead':      lambda b: {"success": True},
            # Media
            'Media_20160725.CreateMedia': lambda b: {"id": str(uuid.uuid4())},
            'Media_20160725.GetMedia':    lambda b: [],
            'Media_20160725.ListMedia':   lambda b: [],
            'Media_20160725.RemoveMedia': lambda b: [],
            # Settings/Skills — returns raw JSON string (array of SkillDataItem)
            # Each skill has: type, index, view{type, childViews[...]}, data{...}
            # Item types: skill, subheader, footer, switch, toggle, choice, oauth, connectable, location, time
            'Settings_20171219.GetSettings':    lambda b: "[]",
            'Settings_20171219.UpdateSettings': lambda b: '{"data":{}}',
            'Settings_20171219.DeleteSettings': lambda b: '{"data":{}}',
            # Keys
            'Key_20160201.CreateRequest':       lambda b: {"id": str(uuid.uuid4()), "loopId": b.get("loopId",""), "encryptedKey": ""},
            'Key_20160201.GetRequest':          lambda b: {"id": b.get("id",""), "loopId": "", "encryptedKey": ""},
            'Key_20160201.ListIncomingRequests':lambda b: [],
            'Key_20160201.BackupEncryptedKey':  lambda b: {"success": True},
            'Key_20160201.RestoreEncryptedKey': lambda b: {"loopId": "", "encryptedKey": ""},
            'Key_20160201.Share':               lambda b: {"id": str(uuid.uuid4())},
            # Push
            'Push_20160729.AddDevice':                 lambda b: [b],
            'Push_20160729.RemoveDevice':              lambda b: [],
            'Push_20160729.GetJotNotificationsMode':   lambda b: {"mode": "all"},
            'Push_20160729.UpdateJotNotificationsMode':lambda b: {"mode": b.get("mode","all")},
            # Person
            'Person_20160801.GetAccountProperties': lambda b: {},
            'Person_20160801.GetLoopProperties':    lambda b: {},
            'Person_20160801.SetAccountProperty':   lambda b: {"success": True},
            'Person_20160801.SetLoopProperty':      lambda b: {"success": True},
            'Person_20160801.ListHolidays':         lambda b: [],
            'Person_20160801.SwitchHolidays':       lambda b: {"success": True},
            # Face recognition
            'Collision_20161126.Match':  lambda b: {"matched": False, "faces": []},
            # GQA
            'GQA_20160930s.ListAttributions': lambda b: {"attributions": [], "total": 0},
            'GQA_20160930s.SendQuestion':     lambda b: {"answer": "", "attribution": None},
            # Notification status — called with robot accountId as param; "connected" drives WiFi status UI
            'Notification_20150505.GetStatus': lambda b: {"connected": True, "SSID": "MockWifi"},
        }
        handler = handlers.get(target, lambda b: {})
        return handler(body)
    
    def handle_login(self, body):
        acct_id = str(uuid.uuid4())
        return {
            "id": acct_id,
            "email": body.get("email", "test@example.com"),
            "accessKeyId": "AKIAMOCKTEST00001",
            "secretAccessKey": "mockSecretKey12345678901234567890",
            "isActive": True,
            "firstName": "Jibo",
            "lastName": "User",
            "gender": "other",      # Gender enum: male | female | other | they
            "birthday": 0,          # epoch ms; 0 = not set
            "devices": [],
            "photoUrl": None,
            "phoneNumber": None,
            "messagingAllowed": True
            # isIncomplete() = isEmpty(firstName)||isEmpty(lastName)||gender==null
            # Full Account model: id, email, accessKeyId, secretAccessKey, devices,
            # firstName, lastName, gender, birthday, isActive, photoUrl, phoneNumber, messagingAllowed
        }
    
    def handle_create(self, body):
        return self.handle_login(body)
    
    def handle_create_loop(self, body):
        return {"id": str(uuid.uuid4()), "name": body.get("name", "My Loop"), 
                "robot": body.get("id", ""), "members": [], "isSuspended": False}
    
    def handle_get_robot(self, body):
        return {"id": body.get("id", ""), "guid": str(uuid.uuid4()), 
                "payload": {"serialNumber": "JB-MOCK001", "platform": "linux-arm"}}
    
    def handle_prepare_robot(self, body):
        return {"token": str(uuid.uuid4()), 
                "expires": int(time.time() * 1000) + 600000}
    
    def handle_setup_robot(self, body):
        # Returns the robot's AWS credentials (KeysContainer)
        return {"accessKeyId": "AKIAMOCKROBOT00001",
                "secretAccessKey": "mockRobotSecret12345678901234567890"}

if __name__ == '__main__':
    server = HTTPServer(('0.0.0.0', 443), JiboMockHandler)
    # Note: need SSL cert for HTTPS
    # server.socket = ssl.wrap_socket(server.socket, certfile='cert.pem', keyfile='key.pem')
    print("Jibo mock server running on port 443")
    server.serve_forever()
```

> **Note:** The above is simplified. Production mock needs HTTPS (TLS), proper SigV4 handling (or bypass), and more complete responses.
