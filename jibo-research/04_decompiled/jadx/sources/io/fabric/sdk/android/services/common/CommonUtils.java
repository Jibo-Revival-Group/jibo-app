package io.fabric.sdk.android.services.common;

import android.app.ActivityManager;
import android.content.Context;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.hardware.SensorManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Debug;
import android.os.StatFs;
import android.provider.Settings;
import android.text.TextUtils;
import com.facebook.internal.ServerProtocol;
import io.fabric.sdk.android.Fabric;
import java.io.Closeable;
import java.io.File;
import java.io.Flushable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;
import org.apache.http.message.TokenParser;

/* JADX INFO: loaded from: classes2.dex */
public class CommonUtils {

    /* JADX INFO: renamed from: b */
    private static Boolean f14569b = null;

    /* JADX INFO: renamed from: c */
    private static final char[] f14570c = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* JADX INFO: renamed from: d */
    private static long f14571d = -1;

    /* JADX INFO: renamed from: a */
    public static final Comparator<File> f14568a = new Comparator<File>() { // from class: io.fabric.sdk.android.services.common.CommonUtils.1
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(File file, File file2) {
            return (int) (file.lastModified() - file2.lastModified());
        }
    };

    /* JADX INFO: renamed from: a */
    public static SharedPreferences m15174a(Context context) {
        return context.getSharedPreferences("com.crashlytics.prefs", 0);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0031, code lost:
    
        r0 = r1[1];
     */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String m15176a(java.io.File r7, java.lang.String r8) throws java.lang.Throwable {
        /*
            r0 = 0
            r5 = 1
            boolean r1 = r7.exists()
            if (r1 == 0) goto L39
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch: java.lang.Exception -> L3a java.lang.Throwable -> L5e
            java.io.FileReader r1 = new java.io.FileReader     // Catch: java.lang.Exception -> L3a java.lang.Throwable -> L5e
            r1.<init>(r7)     // Catch: java.lang.Exception -> L3a java.lang.Throwable -> L5e
            r3 = 1024(0x400, float:1.435E-42)
            r2.<init>(r1, r3)     // Catch: java.lang.Exception -> L3a java.lang.Throwable -> L5e
        L14:
            java.lang.String r1 = r2.readLine()     // Catch: java.lang.Throwable -> L67 java.lang.Exception -> L69
            if (r1 == 0) goto L34
            java.lang.String r3 = "\\s*:\\s*"
            java.util.regex.Pattern r3 = java.util.regex.Pattern.compile(r3)     // Catch: java.lang.Throwable -> L67 java.lang.Exception -> L69
            r4 = 2
            java.lang.String[] r1 = r3.split(r1, r4)     // Catch: java.lang.Throwable -> L67 java.lang.Exception -> L69
            int r3 = r1.length     // Catch: java.lang.Throwable -> L67 java.lang.Exception -> L69
            if (r3 <= r5) goto L14
            r3 = 0
            r3 = r1[r3]     // Catch: java.lang.Throwable -> L67 java.lang.Exception -> L69
            boolean r3 = r3.equals(r8)     // Catch: java.lang.Throwable -> L67 java.lang.Exception -> L69
            if (r3 == 0) goto L14
            r3 = 1
            r0 = r1[r3]     // Catch: java.lang.Throwable -> L67 java.lang.Exception -> L69
        L34:
            java.lang.String r1 = "Failed to close system file reader."
            m15188a(r2, r1)
        L39:
            return r0
        L3a:
            r1 = move-exception
            r2 = r0
        L3c:
            io.fabric.sdk.android.Logger r3 = io.fabric.sdk.android.Fabric.m15085h()     // Catch: java.lang.Throwable -> L67
            java.lang.String r4 = "Fabric"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L67
            r5.<init>()     // Catch: java.lang.Throwable -> L67
            java.lang.String r6 = "Error parsing "
            java.lang.StringBuilder r5 = r5.append(r6)     // Catch: java.lang.Throwable -> L67
            java.lang.StringBuilder r5 = r5.append(r7)     // Catch: java.lang.Throwable -> L67
            java.lang.String r5 = r5.toString()     // Catch: java.lang.Throwable -> L67
            r3.mo15073e(r4, r5, r1)     // Catch: java.lang.Throwable -> L67
            java.lang.String r1 = "Failed to close system file reader."
            m15188a(r2, r1)
            goto L39
        L5e:
            r1 = move-exception
            r2 = r0
            r0 = r1
        L61:
            java.lang.String r1 = "Failed to close system file reader."
            m15188a(r2, r1)
            throw r0
        L67:
            r0 = move-exception
            goto L61
        L69:
            r1 = move-exception
            goto L3c
        */
        throw new UnsupportedOperationException("Method not decompiled: io.fabric.sdk.android.services.common.CommonUtils.m15176a(java.io.File, java.lang.String):java.lang.String");
    }

    /* JADX INFO: renamed from: a */
    public static int m15169a() {
        return Architecture.getValue().ordinal();
    }

    enum Architecture {
        X86_32,
        X86_64,
        ARM_UNKNOWN,
        PPC,
        PPC64,
        ARMV6,
        ARMV7,
        UNKNOWN,
        ARMV7S,
        ARM64;

        private static final Map<String, Architecture> matcher = new HashMap(4);

        static {
            matcher.put("armeabi-v7a", ARMV7);
            matcher.put("armeabi", ARMV6);
            matcher.put("arm64-v8a", ARM64);
            matcher.put("x86", X86_32);
        }

        static Architecture getValue() {
            String str = Build.CPU_ABI;
            if (TextUtils.isEmpty(str)) {
                Fabric.m15085h().mo15063a("Fabric", "Architecture#getValue()::Build.CPU_ABI returned null or empty");
                return UNKNOWN;
            }
            Architecture architecture = matcher.get(str.toLowerCase(Locale.US));
            if (architecture == null) {
                return UNKNOWN;
            }
            return architecture;
        }
    }

    /* JADX INFO: renamed from: b */
    public static synchronized long m15192b() {
        if (f14571d == -1) {
            long jM15172a = 0;
            String strM15176a = m15176a(new File("/proc/meminfo"), "MemTotal");
            if (!TextUtils.isEmpty(strM15176a)) {
                String upperCase = strM15176a.toUpperCase(Locale.US);
                try {
                    if (upperCase.endsWith("KB")) {
                        jM15172a = m15172a(upperCase, "KB", 1024);
                    } else if (upperCase.endsWith("MB")) {
                        jM15172a = m15172a(upperCase, "MB", 1048576);
                    } else if (upperCase.endsWith("GB")) {
                        jM15172a = m15172a(upperCase, "GB", 1073741824);
                    } else {
                        Fabric.m15085h().mo15063a("Fabric", "Unexpected meminfo format while computing RAM: " + upperCase);
                    }
                } catch (NumberFormatException e) {
                    Fabric.m15085h().mo15073e("Fabric", "Unexpected meminfo format while computing RAM: " + upperCase, e);
                }
            }
            f14571d = jM15172a;
        }
        return f14571d;
    }

    /* JADX INFO: renamed from: a */
    static long m15172a(String str, String str2, int i) {
        return Long.parseLong(str.split(str2)[0].trim()) * ((long) i);
    }

    /* JADX INFO: renamed from: a */
    public static ActivityManager.RunningAppProcessInfo m15173a(String str, Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses != null) {
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo.processName.equals(str)) {
                    return runningAppProcessInfo;
                }
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: a */
    public static String m15177a(InputStream inputStream) throws IOException {
        Scanner scannerUseDelimiter = new Scanner(inputStream).useDelimiter("\\A");
        return scannerUseDelimiter.hasNext() ? scannerUseDelimiter.next() : "";
    }

    /* JADX INFO: renamed from: a */
    public static String m15179a(String str) {
        return m15180a(str, "SHA-1");
    }

    /* JADX INFO: renamed from: b */
    public static String m15196b(InputStream inputStream) {
        return m15178a(inputStream, "SHA-1");
    }

    /* JADX INFO: renamed from: a */
    private static String m15178a(InputStream inputStream, String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
            byte[] bArr = new byte[1024];
            while (true) {
                int i = inputStream.read(bArr);
                if (i != -1) {
                    messageDigest.update(bArr, 0, i);
                } else {
                    return m15181a(messageDigest.digest());
                }
            }
        } catch (Exception e) {
            Fabric.m15085h().mo15073e("Fabric", "Could not calculate hash for app icon.", e);
            return "";
        }
    }

    /* JADX INFO: renamed from: a */
    private static String m15182a(byte[] bArr, String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(str);
            messageDigest.update(bArr);
            return m15181a(messageDigest.digest());
        } catch (NoSuchAlgorithmException e) {
            Fabric.m15085h().mo15073e("Fabric", "Could not create hashing algorithm: " + str + ", returning empty string.", e);
            return "";
        }
    }

    /* JADX INFO: renamed from: a */
    private static String m15180a(String str, String str2) {
        return m15182a(str.getBytes(), str2);
    }

    /* JADX INFO: renamed from: a */
    public static String m15183a(String... strArr) {
        if (strArr == null || strArr.length == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            if (str != null) {
                arrayList.add(str.replace("-", "").toLowerCase(Locale.US));
            }
        }
        Collections.sort(arrayList);
        StringBuilder sb = new StringBuilder();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            sb.append((String) it.next());
        }
        String string = sb.toString();
        if (string.length() > 0) {
            return m15179a(string);
        }
        return null;
    }

    /* JADX INFO: renamed from: b */
    public static long m15193b(Context context) {
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ((ActivityManager) context.getSystemService("activity")).getMemoryInfo(memoryInfo);
        return memoryInfo.availMem;
    }

    /* JADX INFO: renamed from: b */
    public static long m15194b(String str) {
        StatFs statFs = new StatFs(str);
        long blockSize = statFs.getBlockSize();
        return (((long) statFs.getBlockCount()) * blockSize) - (((long) statFs.getAvailableBlocks()) * blockSize);
    }

    /* JADX INFO: renamed from: c */
    public static Float m15197c(Context context) {
        if (context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED")) == null) {
            return null;
        }
        return Float.valueOf(r1.getIntExtra("level", -1) / r1.getIntExtra("scale", -1));
    }

    /* JADX INFO: renamed from: d */
    public static boolean m15201d(Context context) {
        if (m15203f(context)) {
            return false;
        }
        return ((SensorManager) context.getSystemService("sensor")).getDefaultSensor(8) != null;
    }

    /* JADX INFO: renamed from: a */
    public static void m15185a(Context context, String str) {
        if (m15202e(context)) {
            Fabric.m15085h().mo15063a("Fabric", str);
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m15186a(Context context, String str, Throwable th) {
        if (m15202e(context)) {
            Fabric.m15085h().mo15072e("Fabric", str);
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m15184a(Context context, int i, String str, String str2) {
        if (m15202e(context)) {
            Fabric.m15085h().mo15061a(i, "Fabric", str2);
        }
    }

    /* JADX INFO: renamed from: e */
    public static boolean m15202e(Context context) {
        if (f14569b == null) {
            f14569b = Boolean.valueOf(m15191a(context, "com.crashlytics.Trace", false));
        }
        return f14569b.booleanValue();
    }

    /* JADX INFO: renamed from: a */
    public static boolean m15191a(Context context, String str, boolean z) {
        Resources resources;
        if (context != null && (resources = context.getResources()) != null) {
            int iM15170a = m15170a(context, str, "bool");
            if (iM15170a > 0) {
                return resources.getBoolean(iM15170a);
            }
            int iM15170a2 = m15170a(context, str, "string");
            if (iM15170a2 > 0) {
                return Boolean.parseBoolean(context.getString(iM15170a2));
            }
            return z;
        }
        return z;
    }

    /* JADX INFO: renamed from: a */
    public static int m15170a(Context context, String str, String str2) {
        return context.getResources().getIdentifier(str, str2, m15207j(context));
    }

    /* JADX INFO: renamed from: f */
    public static boolean m15203f(Context context) {
        return ServerProtocol.DIALOG_PARAM_SDK_VERSION.equals(Build.PRODUCT) || "google_sdk".equals(Build.PRODUCT) || Settings.Secure.getString(context.getContentResolver(), "android_id") == null;
    }

    /* JADX INFO: renamed from: g */
    public static boolean m15204g(Context context) {
        boolean zM15203f = m15203f(context);
        String str = Build.TAGS;
        if ((zM15203f || str == null || !str.contains("test-keys")) && !new File("/system/app/Superuser.apk").exists()) {
            return !zM15203f && new File("/system/xbin/su").exists();
        }
        return true;
    }

    /* JADX INFO: renamed from: c */
    public static boolean m15198c() {
        return Debug.isDebuggerConnected() || Debug.waitingForDebugger();
    }

    /* JADX INFO: renamed from: h */
    public static int m15205h(Context context) {
        int i = 0;
        if (m15203f(context)) {
            i = 1;
        }
        if (m15204g(context)) {
            i |= 2;
        }
        if (m15198c()) {
            return i | 4;
        }
        return i;
    }

    /* JADX INFO: renamed from: a */
    public static int m15171a(Context context, boolean z) {
        Float fM15197c = m15197c(context);
        if (!z || fM15197c == null) {
            return 1;
        }
        if (fM15197c.floatValue() >= 99.0d) {
            return 3;
        }
        if (fM15197c.floatValue() < 99.0d) {
            return 2;
        }
        return 0;
    }

    /* JADX INFO: renamed from: a */
    public static String m15181a(byte[] bArr) {
        char[] cArr = new char[bArr.length * 2];
        for (int i = 0; i < bArr.length; i++) {
            int i2 = bArr[i] & 255;
            cArr[i * 2] = f14570c[i2 >>> 4];
            cArr[(i * 2) + 1] = f14570c[i2 & 15];
        }
        return new String(cArr);
    }

    /* JADX INFO: renamed from: i */
    public static boolean m15206i(Context context) {
        return (context.getApplicationInfo().flags & 2) != 0;
    }

    /* JADX INFO: renamed from: b */
    public static String m15195b(Context context, String str) {
        int iM15170a = m15170a(context, str, "string");
        return iM15170a > 0 ? context.getString(iM15170a) : "";
    }

    /* JADX INFO: renamed from: a */
    public static void m15188a(Closeable closeable, String str) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                Fabric.m15085h().mo15073e("Fabric", str, e);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m15189a(Flushable flushable, String str) {
        if (flushable != null) {
            try {
                flushable.flush();
            } catch (IOException e) {
                Fabric.m15085h().mo15073e("Fabric", str, e);
            }
        }
    }

    /* JADX INFO: renamed from: c */
    public static boolean m15200c(String str) {
        return str == null || str.length() == 0;
    }

    /* JADX INFO: renamed from: a */
    public static String m15175a(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("value must be zero or greater");
        }
        return String.format(Locale.US, "%1$10s", Integer.valueOf(i)).replace(TokenParser.f15715SP, '0');
    }

    /* JADX INFO: renamed from: j */
    public static String m15207j(Context context) {
        int i = context.getApplicationContext().getApplicationInfo().icon;
        return i > 0 ? context.getResources().getResourcePackageName(i) : context.getPackageName();
    }

    /* JADX INFO: renamed from: a */
    public static void m15190a(InputStream inputStream, OutputStream outputStream, byte[] bArr) throws IOException {
        while (true) {
            int i = inputStream.read(bArr);
            if (i != -1) {
                outputStream.write(bArr, 0, i);
            } else {
                return;
            }
        }
    }

    /* JADX INFO: renamed from: k */
    public static String m15208k(Context context) throws Throwable {
        InputStream inputStreamOpenRawResource;
        Throwable th;
        try {
            inputStreamOpenRawResource = context.getResources().openRawResource(m15209l(context));
            try {
                try {
                    String strM15196b = m15196b(inputStreamOpenRawResource);
                    str = m15200c(strM15196b) ? null : strM15196b;
                    m15188a((Closeable) inputStreamOpenRawResource, "Failed to close icon input stream.");
                } catch (Exception e) {
                    e = e;
                    Fabric.m15085h().mo15073e("Fabric", "Could not calculate hash for app icon.", e);
                    m15188a((Closeable) inputStreamOpenRawResource, "Failed to close icon input stream.");
                }
            } catch (Throwable th2) {
                th = th2;
                m15188a((Closeable) inputStreamOpenRawResource, "Failed to close icon input stream.");
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            inputStreamOpenRawResource = null;
        } catch (Throwable th3) {
            inputStreamOpenRawResource = null;
            th = th3;
            m15188a((Closeable) inputStreamOpenRawResource, "Failed to close icon input stream.");
            throw th;
        }
        return str;
    }

    /* JADX INFO: renamed from: l */
    public static int m15209l(Context context) {
        return context.getApplicationContext().getApplicationInfo().icon;
    }

    /* JADX INFO: renamed from: m */
    public static String m15210m(Context context) {
        int iM15170a = m15170a(context, "io.fabric.android.build_id", "string");
        if (iM15170a == 0) {
            iM15170a = m15170a(context, "com.crashlytics.android.build_id", "string");
        }
        if (iM15170a == 0) {
            return null;
        }
        String string = context.getResources().getString(iM15170a);
        Fabric.m15085h().mo15063a("Fabric", "Build ID is: " + string);
        return string;
    }

    /* JADX INFO: renamed from: a */
    public static void m15187a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception e2) {
            }
        }
    }

    /* JADX INFO: renamed from: c */
    public static boolean m15199c(Context context, String str) {
        return context.checkCallingOrSelfPermission(str) == 0;
    }

    /* JADX INFO: renamed from: n */
    public static boolean m15211n(Context context) {
        if (!m15199c(context, "android.permission.ACCESS_NETWORK_STATE")) {
            return true;
        }
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting();
    }
}
