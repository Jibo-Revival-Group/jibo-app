# Jibo APK Reverse Engineering — Command Log

## Session: 2026-06-03

### Phase 1.1 — Environment Discovery

```bash
# Find APK in workspace
find . -maxdepth 4 -type f \( -iname "*.apk" -o -iname "*.jar" -o -iname "*vineflower*" -o -iname "*dex2jar*" \) 2>/dev/null
find ~/Downloads ~/Desktop ~/Documents -maxdepth 4 -type f -iname "*.apk" 2>/dev/null

# Tool discovery
java -version
command -v jadx
command -v apktool
find ~/Library/Android/sdk -name "aapt" -o -name "aapt2" 2>/dev/null
find /opt/homebrew /usr/local -maxdepth 8 -name "*vineflower*.jar" 2>/dev/null
find /opt/homebrew /usr/local -maxdepth 8 -name "d2j-dex2jar*" 2>/dev/null

# Install missing tools
brew install dex2jar
brew install vineflower
```

### Phase 1.2 — APK Fingerprinting

```bash
APK="/Users/marcnoguera/jibo-claude/Jibo.apk"
mkdir -p jibo-research/{00_logs,01_input,02_manifest_resources,03_assets,04_decompiled/jadx,04_decompiled/vineflower,04_decompiled/dex2jar,05_static_analysis,06_dynamic_analysis,07_reports,08_scripts}
cp "$APK" jibo-research/01_input/
shasum -a 256 "$APK"
file "$APK"
ls -lh "$APK"

# APKANALYZER
$APKANALYZER manifest application-id "$APK"
$APKANALYZER manifest version-name "$APK"
$APKANALYZER manifest version-code "$APK"
$APKANALYZER manifest min-sdk "$APK"
$APKANALYZER manifest target-sdk "$APK"

# AAPT
$AAPT dump badging "$APK" | tee jibo-research/02_manifest_resources/aapt_badging.txt
$AAPT dump permissions "$APK" | tee jibo-research/02_manifest_resources/aapt_permissions.txt

# Signing cert
keytool -printcert -file jibo-research/03_assets/extracted_apk/META-INF/CERT.RSA
```

### Phase 1.3 — Manifest Extraction

```bash
apktool d --no-src -f "$APK" -o jibo-research/02_manifest_resources/apktool_no_src
cp jibo-research/02_manifest_resources/apktool_no_src/AndroidManifest.xml jibo-research/02_manifest_resources/AndroidManifest.xml
grep -i "permission|bluetooth|camera|wifi|internet" jibo-research/02_manifest_resources/AndroidManifest.xml
```

### Phase 1.4 — Asset Extraction

```bash
mkdir -p jibo-research/03_assets/extracted_apk
unzip -q "$APK" -d jibo-research/03_assets/extracted_apk
find jibo-research/03_assets/extracted_apk/assets jibo-research/03_assets/extracted_apk/res/raw ... -type f | sort | tee jibo-research/03_assets/asset_file_index.txt
cat jibo-research/03_assets/extracted_apk/res/xml/servers.xml
cat jibo-research/03_assets/extracted_apk/res/xml/files.xml
cat jibo-research/03_assets/extracted_apk/assets/crashlytics-build.properties
grep -i "http|url|endpoint|api|firebase|google" jibo-research/02_manifest_resources/apktool_no_src/res/values/strings.xml
```

### Phase 2 — Decompilation

```bash
# JADX
jadx -d ./jibo-research/04_decompiled/jadx --deobf "$APK"

# dex2jar
d2j-dex2jar "$APK" -f -o ./jibo-research/04_decompiled/dex2jar/jibo-target.jar

# Vineflower
VINEFLOWER_JAR="/opt/homebrew/Cellar/vineflower/1.12.0/libexec/vineflower.jar"
java -jar "$VINEFLOWER_JAR" -dgs=1 ./jibo-research/04_decompiled/dex2jar/jibo-target.jar ./jibo-research/04_decompiled/vineflower/
```

### Phase 3 — Source Analysis

```bash
# Package structure
find jibo-research/04_decompiled/jadx/sources/com/jibo -maxdepth 2 -type d | sort

# Read key files
# - AbstractJiboClient.java
# - Commons.java (endpoints)
# - KeyManager.java (crypto)
# - JiboOobeClient.java (onboarding)
# - JiboAccountClient.java (auth)
# - WiFiBaseQRCodeFragment.java (QR setup)
# - WiFiQRCodeFragment.java (QR display)
# - OnBoardingActivity.java (flow)
# - IHeartApiServiceGenerator.java (radio)
# - OauthFragment.java (skills oauth)
# - RobotHelper.java (robot properties)
```

### Phase 3 (Continued) — Remaining Service Analysis

```bash
# Find and read all service clients
find jibo-research/04_decompiled/jadx/sources/com/jibo/aws/integration/aws/services -name "*.java" | grep -iv "model|p00|p01|Async" | sort

# Read all service clients:
# - JiboMediaClient.java, JiboCollisionClient.java, JiboGQAClient.java
# - JiboJotClient.java, JiboKeyClient.java, JiboLoopClient.java
# - JiboNotificationClient.java, JiboPersonClient.java, JiboPushClient.java
# - JiboRobotPropertiesClient.java, JiboSkillsClient.java
# - JiboBinaryClient.java, JiboFileClient.java (base class for Photo/VoiceTraining)
# - JiboVoiceTrainingClient.java, JiboPhotoClient.java
# - JiboAccountAdminClient.java

# Database layer
find jibo-research/04_decompiled/jadx/sources/com/jibo/p018db -name "*.java" | sort
# Read: DatabaseProvider.java, DatabaseHelper.java

# Native library analysis
strings jibo-research/03_assets/extracted_apk/lib/arm64-v8a/libutils-jni.so
strings jibo-research/03_assets/extracted_apk/lib/arm64-v8a/libucrop.so | head -40
strings jibo-research/03_assets/extracted_apk/lib/arm64-v8a/libsqlcipher.so | grep -E "^[A-Za-z]" | head -30

# SQLCipher investigation
grep -r "sqlcipher|net.sqlcipher" jibo-research/04_decompiled/jadx/sources/com/jibo/ --include="*.java"
# Result: only SignupCompleteFragment and ResetPasswordSentFragment import it,
# solely for the CREATE_IF_NECESSARY integer constant (used as Intent flag)
# DatabaseHelper uses standard android.database.sqlite.SQLiteOpenHelper — database is UNENCRYPTED
```
