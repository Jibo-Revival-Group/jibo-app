# Onboarding Flow Analysis — Jibo Android App
**Source:** Static analysis of `com.jibo` v1.0.9  
**Generated:** 2026-06-03

---

## 1. Summary

The Jibo onboarding is a **two-phase cloud-mediated** process:
1. **Account onboarding:** Standard email/password or Facebook registration
2. **Robot WiFi setup:** QR-code based, cloud-brokered, **no Bluetooth**

There is **no Bluetooth or direct WiFi P2P** communication during setup.

---

## 2. Account Registration Flow

**Activity:** `OnBoardingActivity`  
**Entry fragment:** `WelcomeFragment` → `SignupLoginFragment`

```
WelcomeFragment
    ↓ (Sign up)
SignupFragment       -- calls Account_20151111.Create
    ↓ (Success)
SignupCompleteFragment  -- confirmation screen
    ↓
PhoneFillFragment    -- optional phone verification
    ↓
AboutYouFragment     -- name, gender, birthday
    ↓
TabbedActivity       -- main app
```

**Facebook auth alternative:**
```
WelcomeFragment
    ↓ (Facebook)
SocialMediaBaseFragment  -- calls FacebookPrepareLogin → FacebookMobileConnect
    ↓
(same as above)
```

**Login flow:**
```
LoginFragment  -- calls Account_20151111.Login
    ↓
TabbedActivity
```

### Deep Link Handling

The `OnBoardingActivity` handles deep links:
- `link_account_activate` — `?email=&code=` → activation
- `link_reset_password` — `?email=&code=` → password reset
- `link_create` — `?email=&code=` → Loop invite with signup
- `link_home` — `?email=&code=` → navigate to main
- `link_settings` — `?loopId=` → navigate to settings
- `google_auth_callback` — OAuth callback for skills

---

## 3. Robot WiFi Setup (OOBE) Flow

**Activity:** `WifiActivity`  
**Triggered from:** Main app `TabbedActivity` after login

### 3.1 Fragment Sequence

```
SetupOrReconnectFragment
    ↓ (New Jibo setup)
JiboPreparationsFragment   -- "remove screen cover, plug in, power on"
    ↓
NetworkSelectionFragment   -- WiFi network selection
    │
    ├── Current network: reads SSID from WifiManager
    ├── Enter manually: → NetworkNameFragment
    └── Other network: opens WiFi settings
    ↓
NetworkPwdFragment         -- WiFi password entry + optional static IP
    │
    └── StaticOptions (optional): IP, subnet, router, DNS1, DNS2
    ↓
WiFiTokenGetterFragment    -- calls PrepareRobot in background
    ↓ (token received)
WiFiQRCodeFragment         -- displays QR code(s)
    ↓ (tap "Done" after robot sees QR)
WiFiJiboConnectingFragment -- polls GetStatus every 4s
    ↓ (complete=true)
WiFiSuccessFragment        -- success!
```

### 3.2 WiFiTokenGetterFragment Behavior

- On `onResume()`: immediately starts the token refresh runnable
- Token refresh loop runs every 10 seconds
- If token expires (within 30s of expiry): calls `PrepareRobot` again
- Progress dialog shown during token refresh

### 3.3 WiFiQRCodeFragment Behavior

1. Receives `Loop` and `TokenContainer` from previous fragment
2. Constructs QR payload string (SSID + PW + token, XOR-encoded)
3. Displays QR code using ZXing `QRCodeWriter`
4. If payload requires multiple QR codes: shows navigation buttons (Prev/Next)
5. Screen brightness increased to 75% for better robot camera reading
6. Brightness slider available for user adjustment
7. "Done" button navigates to connecting screen

### 3.4 WiFiJiboConnectingFragment Behavior

- Polls `GetStatus(token)` every 4 seconds  
- On `complete=true`: navigates to success
- On error: shows help screen (`WiFiHelpFragment`)

---

## 4. WiFi Network Information Extraction

**Class:** `NetworkSelectionFragment.m11131a()`  

The app reads the current connected WiFi SSID using:
```java
WifiManager wifiManager = (WifiManager) getSystemService("wifi");
WifiInfo wifiInfo = wifiManager.getConnectionInfo();
String ssid = wifiInfo.getSSID(); // returns "<SSID>" with quotes
```

The `ACCESS_WIFI_STATE` and `ACCESS_COARSE_LOCATION` permissions are required.

---

## 5. Error Handling and Help

### WiFi Error Fragments

| Fragment | Error Type |
|---------|-----------|
| `WiFiError1Fragment` | Cannot connect to WiFi network |
| `WiFiError2Fragment` | Cannot get IP from router |
| `WiFiHelpFragment` | General help/troubleshooting |
| `WiFiHelpAbstractFragment` | Base class |

Support URLs referenced:
- WiFi error 1: `https://support.jibo.com/jibo/articles/en_US/FAQ/WIFI1-Cant-connect-to-Wi-Fi-network`
- WiFi error 2: `https://support.jibo.com/jibo/articles/en_US/FAQ/WIFI2-WIFI2a-Cant-get-IP-address-from-router`
- QR problem: `https://support.jibo.com/jibo/articles/en_US/FAQ/Jibo-wont-acknowledge-my-WiFi-QR-code`

### Support Contact

Button options available for users:
- "My Jibo says [error 1]" / "My Jibo says [error 2]"
- "Pointing my QR code at Jibo did nothing"
- Error reporter with brightness adjustment hint

---

## 6. Reconnection Flow

**Fragment:** `SetupOrReconnectFragment`

For existing robots reconnecting to new WiFi:
- Same flow as initial setup, but initiated from `TabbedActivity`
- Same QR code generation with existing Loop credentials
- No new account creation required

---

## 7. Loop Invite Flow

After setup, the owner can invite Loop members:

```
TabbedActivity (Jibos tab)
    ↓ (Invite)
InviteLoopMembersFragment
    │
    └── SelectGuardianFragment (for children)
    ↓
    Calls: Loop_20160324.InviteLoopMember
    Email sent to invitee
```

**Invite deep link handling:**
- Invitee clicks link → `link_create` deep link → `OnBoardingActivity`
- If already logged in and same email: navigate to Loop
- If different account: show "wrong account" dialog

---

## 8. Key Requirements for Revival

| Requirement | Needed For | Notes |
|-------------|-----------|-------|
| `Account_20151111.Login` mock | Any use | Returns fake AWS credentials |
| `Account_20151111.Create` mock | New accounts | Registration |
| `Loop_20160324.ListLoops` mock | Main app load | Returns loop list |
| `Loop_20160324.CreateLoop` mock | New robot setup | Associates robot to user |
| `RobotProperties_20160225.GetRobot` mock | Main app display | Returns robot info |
| `OOBE_20161026.PrepareRobot` mock | WiFi setup | Returns token for QR |
| `OOBE_20161026.GetStatus` mock | WiFi setup | Return `{complete: true}` |
| QR decoder on robot side | WiFi setup | Robot must decode XOR+QR |
| `Settings_20171219.GetSettings` mock | Skills settings | Return `{}` for empty |

**The physical robot must also be modified** to decode the XOR QR codes using the same key, contact a mock OOBE server, and complete the setup handshake. Without robot firmware access, this part of the flow cannot be completed even with a mock server.

---

## 9. Open Questions

1. Does the robot contact `api.jibo.com` directly for `SetupRobot`? (Likely yes)
2. What is the robot's exact QR parsing implementation?
3. How does the robot obtain its initial `id` to pass to `SetupRobot`?
4. Is there any local network protocol between the app and robot after initial setup? (e.g., local WebSocket for live control)
5. How does the robot use `KeysContainer` after setup?
