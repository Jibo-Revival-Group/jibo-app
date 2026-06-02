package com.crashlytics.android.core;

import android.app.ActivityManager;
import android.os.Build;
import com.facebook.appevents.AppEventsConstants;
import com.yalantis.ucrop.util.FileUtils;
import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.services.common.IdManager;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
class SessionProtobufHelper {

    /* JADX INFO: renamed from: a */
    private static final ByteString f5332a = ByteString.m5711a(AppEventsConstants.EVENT_PARAM_VALUE_NO);

    /* JADX INFO: renamed from: b */
    private static final ByteString f5333b = ByteString.m5711a("Unity");

    /* JADX INFO: renamed from: a */
    public static void m5993a(CodedOutputStream codedOutputStream, String str, String str2, long j) throws Exception {
        codedOutputStream.m5750a(1, ByteString.m5711a(str2));
        codedOutputStream.m5750a(2, ByteString.m5711a(str));
        codedOutputStream.m5749a(3, j);
    }

    /* JADX INFO: renamed from: a */
    public static void m5995a(CodedOutputStream codedOutputStream, String str, String str2, String str3, String str4, String str5, int i, String str6) throws Exception {
        ByteString byteStringM5711a = ByteString.m5711a(str);
        ByteString byteStringM5711a2 = ByteString.m5711a(str2);
        ByteString byteStringM5711a3 = ByteString.m5711a(str3);
        ByteString byteStringM5711a4 = ByteString.m5711a(str4);
        ByteString byteStringM5711a5 = ByteString.m5711a(str5);
        ByteString byteStringM5711a6 = str6 != null ? ByteString.m5711a(str6) : null;
        codedOutputStream.m5765g(7, 2);
        codedOutputStream.m5767k(m5974a(byteStringM5711a, byteStringM5711a2, byteStringM5711a3, byteStringM5711a4, byteStringM5711a5, i, byteStringM5711a6));
        codedOutputStream.m5750a(1, byteStringM5711a);
        codedOutputStream.m5750a(2, byteStringM5711a3);
        codedOutputStream.m5750a(3, byteStringM5711a4);
        codedOutputStream.m5765g(5, 2);
        codedOutputStream.m5767k(m5972a(byteStringM5711a2));
        codedOutputStream.m5750a(1, byteStringM5711a2);
        codedOutputStream.m5750a(6, byteStringM5711a5);
        if (byteStringM5711a6 != null) {
            codedOutputStream.m5750a(8, f5333b);
            codedOutputStream.m5750a(9, byteStringM5711a6);
        }
        codedOutputStream.m5759b(10, i);
    }

    /* JADX INFO: renamed from: a */
    public static void m5998a(CodedOutputStream codedOutputStream, boolean z) throws Exception {
        ByteString byteStringM5711a = ByteString.m5711a(Build.VERSION.RELEASE);
        ByteString byteStringM5711a2 = ByteString.m5711a(Build.VERSION.CODENAME);
        codedOutputStream.m5765g(8, 2);
        codedOutputStream.m5767k(m5975a(byteStringM5711a, byteStringM5711a2, z));
        codedOutputStream.m5759b(1, 3);
        codedOutputStream.m5750a(2, byteStringM5711a);
        codedOutputStream.m5750a(3, byteStringM5711a2);
        codedOutputStream.m5751a(4, z);
    }

    /* JADX INFO: renamed from: a */
    public static void m5992a(CodedOutputStream codedOutputStream, String str, int i, String str2, int i2, long j, long j2, boolean z, Map<IdManager.DeviceIdentifierType, String> map, int i3, String str3, String str4) throws Exception {
        ByteString byteStringM5711a = ByteString.m5711a(str);
        ByteString byteStringM5984a = m5984a(str2);
        ByteString byteStringM5984a2 = m5984a(str4);
        ByteString byteStringM5984a3 = m5984a(str3);
        codedOutputStream.m5765g(9, 2);
        codedOutputStream.m5767k(m5970a(i, byteStringM5711a, byteStringM5984a, i2, j, j2, z, map, i3, byteStringM5984a3, byteStringM5984a2));
        codedOutputStream.m5750a(1, byteStringM5711a);
        codedOutputStream.m5759b(3, i);
        codedOutputStream.m5750a(4, byteStringM5984a);
        codedOutputStream.m5748a(5, i2);
        codedOutputStream.m5749a(6, j);
        codedOutputStream.m5749a(7, j2);
        codedOutputStream.m5751a(10, z);
        for (Map.Entry<IdManager.DeviceIdentifierType, String> entry : map.entrySet()) {
            codedOutputStream.m5765g(11, 2);
            codedOutputStream.m5767k(m5979a(entry.getKey(), entry.getValue()));
            codedOutputStream.m5759b(1, entry.getKey().protobufIndex);
            codedOutputStream.m5750a(2, ByteString.m5711a(entry.getValue()));
        }
        codedOutputStream.m5748a(12, i3);
        if (byteStringM5984a3 != null) {
            codedOutputStream.m5750a(13, byteStringM5984a3);
        }
        if (byteStringM5984a2 != null) {
            codedOutputStream.m5750a(14, byteStringM5984a2);
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m5994a(CodedOutputStream codedOutputStream, String str, String str2, String str3) throws Exception {
        if (str == null) {
            str = "";
        }
        ByteString byteStringM5711a = ByteString.m5711a(str);
        ByteString byteStringM5984a = m5984a(str2);
        ByteString byteStringM5984a2 = m5984a(str3);
        int iM5728b = 0 + CodedOutputStream.m5728b(1, byteStringM5711a);
        if (str2 != null) {
            iM5728b += CodedOutputStream.m5728b(2, byteStringM5984a);
        }
        if (str3 != null) {
            iM5728b += CodedOutputStream.m5728b(3, byteStringM5984a2);
        }
        codedOutputStream.m5765g(6, 2);
        codedOutputStream.m5767k(iM5728b);
        codedOutputStream.m5750a(1, byteStringM5711a);
        if (str2 != null) {
            codedOutputStream.m5750a(2, byteStringM5984a);
        }
        if (str3 != null) {
            codedOutputStream.m5750a(3, byteStringM5984a2);
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m5986a(CodedOutputStream codedOutputStream, long j, String str, TrimmedThrowableData trimmedThrowableData, Thread thread, StackTraceElement[] stackTraceElementArr, Thread[] threadArr, List<StackTraceElement[]> list, Map<String, String> map, LogFileManager logFileManager, ActivityManager.RunningAppProcessInfo runningAppProcessInfo, int i, String str2, String str3, Float f, int i2, boolean z, long j2, long j3) throws Exception {
        ByteString byteStringM5711a = ByteString.m5711a(str2);
        ByteString byteStringM5711a2 = str3 == null ? null : ByteString.m5711a(str3.replace("-", ""));
        ByteString byteStringM5922a = logFileManager.m5922a();
        if (byteStringM5922a == null) {
            Fabric.m15085h().mo15063a("CrashlyticsCore", "No log data to include with this event.");
        }
        logFileManager.m5926b();
        codedOutputStream.m5765g(10, 2);
        codedOutputStream.m5767k(m5971a(j, str, trimmedThrowableData, thread, stackTraceElementArr, threadArr, list, 8, map, runningAppProcessInfo, i, byteStringM5711a, byteStringM5711a2, f, i2, z, j2, j3, byteStringM5922a));
        codedOutputStream.m5749a(1, j);
        codedOutputStream.m5750a(2, ByteString.m5711a(str));
        m5990a(codedOutputStream, trimmedThrowableData, thread, stackTraceElementArr, threadArr, list, 8, byteStringM5711a, byteStringM5711a2, map, runningAppProcessInfo, i);
        m5991a(codedOutputStream, f, i2, z, i, j2, j3);
        m5987a(codedOutputStream, byteStringM5922a);
    }

    /* JADX INFO: renamed from: a */
    private static void m5990a(CodedOutputStream codedOutputStream, TrimmedThrowableData trimmedThrowableData, Thread thread, StackTraceElement[] stackTraceElementArr, Thread[] threadArr, List<StackTraceElement[]> list, int i, ByteString byteString, ByteString byteString2, Map<String, String> map, ActivityManager.RunningAppProcessInfo runningAppProcessInfo, int i2) throws Exception {
        codedOutputStream.m5765g(3, 2);
        codedOutputStream.m5767k(m5978a(trimmedThrowableData, thread, stackTraceElementArr, threadArr, list, i, byteString, byteString2, map, runningAppProcessInfo, i2));
        m5989a(codedOutputStream, trimmedThrowableData, thread, stackTraceElementArr, threadArr, list, i, byteString, byteString2);
        if (map != null && !map.isEmpty()) {
            m5997a(codedOutputStream, map);
        }
        if (runningAppProcessInfo != null) {
            codedOutputStream.m5751a(3, runningAppProcessInfo.importance != 100);
        }
        codedOutputStream.m5748a(4, i2);
    }

    /* JADX INFO: renamed from: a */
    private static void m5989a(CodedOutputStream codedOutputStream, TrimmedThrowableData trimmedThrowableData, Thread thread, StackTraceElement[] stackTraceElementArr, Thread[] threadArr, List<StackTraceElement[]> list, int i, ByteString byteString, ByteString byteString2) throws Exception {
        codedOutputStream.m5765g(1, 2);
        codedOutputStream.m5767k(m5977a(trimmedThrowableData, thread, stackTraceElementArr, threadArr, list, i, byteString, byteString2));
        m5996a(codedOutputStream, thread, stackTraceElementArr, 4, true);
        int length = threadArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            m5996a(codedOutputStream, threadArr[i2], list.get(i2), 0, false);
        }
        m5988a(codedOutputStream, trimmedThrowableData, 1, i, 2);
        codedOutputStream.m5765g(3, 2);
        codedOutputStream.m5767k(m5969a());
        codedOutputStream.m5750a(1, f5332a);
        codedOutputStream.m5750a(2, f5332a);
        codedOutputStream.m5749a(3, 0L);
        codedOutputStream.m5765g(4, 2);
        codedOutputStream.m5767k(m5973a(byteString, byteString2));
        codedOutputStream.m5749a(1, 0L);
        codedOutputStream.m5749a(2, 0L);
        codedOutputStream.m5750a(3, byteString);
        if (byteString2 != null) {
            codedOutputStream.m5750a(4, byteString2);
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m5997a(CodedOutputStream codedOutputStream, Map<String, String> map) throws Exception {
        for (Map.Entry<String, String> entry : map.entrySet()) {
            codedOutputStream.m5765g(2, 2);
            codedOutputStream.m5767k(m5982a(entry.getKey(), entry.getValue()));
            codedOutputStream.m5750a(1, ByteString.m5711a(entry.getKey()));
            String value = entry.getValue();
            if (value == null) {
                value = "";
            }
            codedOutputStream.m5750a(2, ByteString.m5711a(value));
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m5988a(CodedOutputStream codedOutputStream, TrimmedThrowableData trimmedThrowableData, int i, int i2, int i3) throws Exception {
        int i4 = 0;
        codedOutputStream.m5765g(i3, 2);
        codedOutputStream.m5767k(m5976a(trimmedThrowableData, 1, i2));
        codedOutputStream.m5750a(1, ByteString.m5711a(trimmedThrowableData.f5338b));
        String str = trimmedThrowableData.f5337a;
        if (str != null) {
            codedOutputStream.m5750a(3, ByteString.m5711a(str));
        }
        for (StackTraceElement stackTraceElement : trimmedThrowableData.f5339c) {
            m5985a(codedOutputStream, 4, stackTraceElement, true);
        }
        TrimmedThrowableData trimmedThrowableData2 = trimmedThrowableData.f5340d;
        if (trimmedThrowableData2 != null) {
            if (i < i2) {
                m5988a(codedOutputStream, trimmedThrowableData2, i + 1, i2, 6);
                return;
            }
            while (trimmedThrowableData2 != null) {
                trimmedThrowableData2 = trimmedThrowableData2.f5340d;
                i4++;
            }
            codedOutputStream.m5748a(7, i4);
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m5996a(CodedOutputStream codedOutputStream, Thread thread, StackTraceElement[] stackTraceElementArr, int i, boolean z) throws Exception {
        codedOutputStream.m5765g(1, 2);
        codedOutputStream.m5767k(m5983a(thread, stackTraceElementArr, i, z));
        codedOutputStream.m5750a(1, ByteString.m5711a(thread.getName()));
        codedOutputStream.m5748a(2, i);
        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
            m5985a(codedOutputStream, 3, stackTraceElement, z);
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m5985a(CodedOutputStream codedOutputStream, int i, StackTraceElement stackTraceElement, boolean z) throws Exception {
        codedOutputStream.m5765g(i, 2);
        codedOutputStream.m5767k(m5981a(stackTraceElement, z));
        if (stackTraceElement.isNativeMethod()) {
            codedOutputStream.m5749a(1, Math.max(stackTraceElement.getLineNumber(), 0));
        } else {
            codedOutputStream.m5749a(1, 0L);
        }
        codedOutputStream.m5750a(2, ByteString.m5711a(stackTraceElement.getClassName() + FileUtils.HIDDEN_PREFIX + stackTraceElement.getMethodName()));
        if (stackTraceElement.getFileName() != null) {
            codedOutputStream.m5750a(3, ByteString.m5711a(stackTraceElement.getFileName()));
        }
        if (!stackTraceElement.isNativeMethod() && stackTraceElement.getLineNumber() > 0) {
            codedOutputStream.m5749a(4, stackTraceElement.getLineNumber());
        }
        codedOutputStream.m5748a(5, z ? 4 : 0);
    }

    /* JADX INFO: renamed from: a */
    private static void m5991a(CodedOutputStream codedOutputStream, Float f, int i, boolean z, int i2, long j, long j2) throws Exception {
        codedOutputStream.m5765g(5, 2);
        codedOutputStream.m5767k(m5980a(f, i, z, i2, j, j2));
        if (f != null) {
            codedOutputStream.m5747a(1, f.floatValue());
        }
        codedOutputStream.m5761c(2, i);
        codedOutputStream.m5751a(3, z);
        codedOutputStream.m5748a(4, i2);
        codedOutputStream.m5749a(5, j);
        codedOutputStream.m5749a(6, j2);
    }

    /* JADX INFO: renamed from: a */
    private static void m5987a(CodedOutputStream codedOutputStream, ByteString byteString) throws Exception {
        if (byteString != null) {
            codedOutputStream.m5765g(6, 2);
            codedOutputStream.m5767k(m5999b(byteString));
            codedOutputStream.m5750a(1, byteString);
        }
    }

    /* JADX INFO: renamed from: a */
    private static int m5974a(ByteString byteString, ByteString byteString2, ByteString byteString3, ByteString byteString4, ByteString byteString5, int i, ByteString byteString6) {
        int iM5728b = 0 + CodedOutputStream.m5728b(1, byteString) + CodedOutputStream.m5728b(2, byteString3) + CodedOutputStream.m5728b(3, byteString4);
        int iM5972a = m5972a(byteString2);
        int iM5741j = iM5728b + iM5972a + CodedOutputStream.m5741j(5) + CodedOutputStream.m5742l(iM5972a) + CodedOutputStream.m5728b(6, byteString5);
        if (byteString6 != null) {
            iM5741j = iM5741j + CodedOutputStream.m5728b(8, f5333b) + CodedOutputStream.m5728b(9, byteString6);
        }
        return iM5741j + CodedOutputStream.m5736e(10, i);
    }

    /* JADX INFO: renamed from: a */
    private static int m5972a(ByteString byteString) {
        return 0 + CodedOutputStream.m5728b(1, byteString);
    }

    /* JADX INFO: renamed from: a */
    private static int m5975a(ByteString byteString, ByteString byteString2, boolean z) {
        return 0 + CodedOutputStream.m5736e(1, 3) + CodedOutputStream.m5728b(2, byteString) + CodedOutputStream.m5728b(3, byteString2) + CodedOutputStream.m5729b(4, z);
    }

    /* JADX INFO: renamed from: a */
    private static int m5979a(IdManager.DeviceIdentifierType deviceIdentifierType, String str) {
        return CodedOutputStream.m5736e(1, deviceIdentifierType.protobufIndex) + CodedOutputStream.m5728b(2, ByteString.m5711a(str));
    }

    /* JADX INFO: renamed from: a */
    private static int m5970a(int i, ByteString byteString, ByteString byteString2, int i2, long j, long j2, boolean z, Map<IdManager.DeviceIdentifierType, String> map, int i3, ByteString byteString3, ByteString byteString4) {
        int i4;
        int iM5728b = (byteString2 == null ? 0 : CodedOutputStream.m5728b(4, byteString2)) + CodedOutputStream.m5736e(3, i) + 0 + CodedOutputStream.m5728b(1, byteString) + CodedOutputStream.m5733d(5, i2) + CodedOutputStream.m5727b(6, j) + CodedOutputStream.m5727b(7, j2) + CodedOutputStream.m5729b(10, z);
        if (map != null) {
            Iterator<Map.Entry<IdManager.DeviceIdentifierType, String>> it = map.entrySet().iterator();
            while (true) {
                i4 = iM5728b;
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry<IdManager.DeviceIdentifierType, String> next = it.next();
                int iM5979a = m5979a(next.getKey(), next.getValue());
                iM5728b = iM5979a + CodedOutputStream.m5741j(11) + CodedOutputStream.m5742l(iM5979a) + i4;
            }
        } else {
            i4 = iM5728b;
        }
        return (byteString4 == null ? 0 : CodedOutputStream.m5728b(14, byteString4)) + i4 + CodedOutputStream.m5733d(12, i3) + (byteString3 == null ? 0 : CodedOutputStream.m5728b(13, byteString3));
    }

    /* JADX INFO: renamed from: a */
    private static int m5973a(ByteString byteString, ByteString byteString2) {
        int iM5727b = 0 + CodedOutputStream.m5727b(1, 0L) + CodedOutputStream.m5727b(2, 0L) + CodedOutputStream.m5728b(3, byteString);
        if (byteString2 != null) {
            return iM5727b + CodedOutputStream.m5728b(4, byteString2);
        }
        return iM5727b;
    }

    /* JADX INFO: renamed from: a */
    private static int m5971a(long j, String str, TrimmedThrowableData trimmedThrowableData, Thread thread, StackTraceElement[] stackTraceElementArr, Thread[] threadArr, List<StackTraceElement[]> list, int i, Map<String, String> map, ActivityManager.RunningAppProcessInfo runningAppProcessInfo, int i2, ByteString byteString, ByteString byteString2, Float f, int i3, boolean z, long j2, long j3, ByteString byteString3) {
        int iM5727b = 0 + CodedOutputStream.m5727b(1, j) + CodedOutputStream.m5728b(2, ByteString.m5711a(str));
        int iM5978a = m5978a(trimmedThrowableData, thread, stackTraceElementArr, threadArr, list, i, byteString, byteString2, map, runningAppProcessInfo, i2);
        int iM5741j = iM5727b + iM5978a + CodedOutputStream.m5741j(3) + CodedOutputStream.m5742l(iM5978a);
        int iM5980a = m5980a(f, i3, z, i2, j2, j3);
        int iM5741j2 = iM5980a + CodedOutputStream.m5741j(5) + CodedOutputStream.m5742l(iM5980a) + iM5741j;
        if (byteString3 != null) {
            int iM5999b = m5999b(byteString3);
            return iM5741j2 + iM5999b + CodedOutputStream.m5741j(6) + CodedOutputStream.m5742l(iM5999b);
        }
        return iM5741j2;
    }

    /* JADX INFO: renamed from: a */
    private static int m5978a(TrimmedThrowableData trimmedThrowableData, Thread thread, StackTraceElement[] stackTraceElementArr, Thread[] threadArr, List<StackTraceElement[]> list, int i, ByteString byteString, ByteString byteString2, Map<String, String> map, ActivityManager.RunningAppProcessInfo runningAppProcessInfo, int i2) {
        int i3;
        int iM5729b;
        int i4;
        int iM5977a = m5977a(trimmedThrowableData, thread, stackTraceElementArr, threadArr, list, i, byteString, byteString2);
        int iM5741j = 0 + iM5977a + CodedOutputStream.m5741j(1) + CodedOutputStream.m5742l(iM5977a);
        if (map != null) {
            Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
            while (true) {
                i4 = iM5741j;
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry<String, String> next = it.next();
                int iM5982a = m5982a(next.getKey(), next.getValue());
                iM5741j = iM5982a + CodedOutputStream.m5741j(2) + CodedOutputStream.m5742l(iM5982a) + i4;
            }
            i3 = i4;
        } else {
            i3 = iM5741j;
        }
        if (runningAppProcessInfo != null) {
            iM5729b = CodedOutputStream.m5729b(3, runningAppProcessInfo.importance != 100) + i3;
        } else {
            iM5729b = i3;
        }
        return iM5729b + CodedOutputStream.m5733d(4, i2);
    }

    /* JADX INFO: renamed from: a */
    private static int m5977a(TrimmedThrowableData trimmedThrowableData, Thread thread, StackTraceElement[] stackTraceElementArr, Thread[] threadArr, List<StackTraceElement[]> list, int i, ByteString byteString, ByteString byteString2) {
        int iM5983a = m5983a(thread, stackTraceElementArr, 4, true);
        int iM5741j = iM5983a + CodedOutputStream.m5741j(1) + CodedOutputStream.m5742l(iM5983a) + 0;
        int length = threadArr.length;
        int iM5741j2 = iM5741j;
        for (int i2 = 0; i2 < length; i2++) {
            int iM5983a2 = m5983a(threadArr[i2], list.get(i2), 0, false);
            iM5741j2 += iM5983a2 + CodedOutputStream.m5741j(1) + CodedOutputStream.m5742l(iM5983a2);
        }
        int iM5976a = m5976a(trimmedThrowableData, 1, i);
        int iM5741j3 = iM5976a + CodedOutputStream.m5741j(2) + CodedOutputStream.m5742l(iM5976a) + iM5741j2;
        int iM5969a = m5969a();
        int iM5741j4 = iM5741j3 + iM5969a + CodedOutputStream.m5741j(3) + CodedOutputStream.m5742l(iM5969a);
        int iM5973a = m5973a(byteString, byteString2);
        return iM5741j4 + iM5973a + CodedOutputStream.m5741j(3) + CodedOutputStream.m5742l(iM5973a);
    }

    /* JADX INFO: renamed from: a */
    private static int m5982a(String str, String str2) {
        int iM5728b = CodedOutputStream.m5728b(1, ByteString.m5711a(str));
        if (str2 == null) {
            str2 = "";
        }
        return iM5728b + CodedOutputStream.m5728b(2, ByteString.m5711a(str2));
    }

    /* JADX INFO: renamed from: a */
    private static int m5980a(Float f, int i, boolean z, int i2, long j, long j2) {
        return (f != null ? 0 + CodedOutputStream.m5726b(1, f.floatValue()) : 0) + CodedOutputStream.m5738f(2, i) + CodedOutputStream.m5729b(3, z) + CodedOutputStream.m5733d(4, i2) + CodedOutputStream.m5727b(5, j) + CodedOutputStream.m5727b(6, j2);
    }

    /* JADX INFO: renamed from: b */
    private static int m5999b(ByteString byteString) {
        return CodedOutputStream.m5728b(1, byteString);
    }

    /* JADX INFO: renamed from: a */
    private static int m5976a(TrimmedThrowableData trimmedThrowableData, int i, int i2) {
        int i3 = 0;
        int iM5728b = CodedOutputStream.m5728b(1, ByteString.m5711a(trimmedThrowableData.f5338b)) + 0;
        String str = trimmedThrowableData.f5337a;
        if (str != null) {
            iM5728b += CodedOutputStream.m5728b(3, ByteString.m5711a(str));
        }
        StackTraceElement[] stackTraceElementArr = trimmedThrowableData.f5339c;
        int length = stackTraceElementArr.length;
        int i4 = 0;
        while (i4 < length) {
            int iM5981a = m5981a(stackTraceElementArr[i4], true);
            i4++;
            iM5728b = iM5981a + CodedOutputStream.m5741j(4) + CodedOutputStream.m5742l(iM5981a) + iM5728b;
        }
        TrimmedThrowableData trimmedThrowableData2 = trimmedThrowableData.f5340d;
        if (trimmedThrowableData2 != null) {
            if (i < i2) {
                int iM5976a = m5976a(trimmedThrowableData2, i + 1, i2);
                return iM5728b + iM5976a + CodedOutputStream.m5741j(6) + CodedOutputStream.m5742l(iM5976a);
            }
            while (trimmedThrowableData2 != null) {
                trimmedThrowableData2 = trimmedThrowableData2.f5340d;
                i3++;
            }
            return iM5728b + CodedOutputStream.m5733d(7, i3);
        }
        return iM5728b;
    }

    /* JADX INFO: renamed from: a */
    private static int m5969a() {
        return 0 + CodedOutputStream.m5728b(1, f5332a) + CodedOutputStream.m5728b(2, f5332a) + CodedOutputStream.m5727b(3, 0L);
    }

    /* JADX INFO: renamed from: a */
    private static int m5981a(StackTraceElement stackTraceElement, boolean z) {
        int iM5727b;
        if (stackTraceElement.isNativeMethod()) {
            iM5727b = CodedOutputStream.m5727b(1, Math.max(stackTraceElement.getLineNumber(), 0)) + 0;
        } else {
            iM5727b = CodedOutputStream.m5727b(1, 0L) + 0;
        }
        int iM5728b = iM5727b + CodedOutputStream.m5728b(2, ByteString.m5711a(stackTraceElement.getClassName() + FileUtils.HIDDEN_PREFIX + stackTraceElement.getMethodName()));
        if (stackTraceElement.getFileName() != null) {
            iM5728b += CodedOutputStream.m5728b(3, ByteString.m5711a(stackTraceElement.getFileName()));
        }
        return CodedOutputStream.m5733d(5, z ? 2 : 0) + ((stackTraceElement.isNativeMethod() || stackTraceElement.getLineNumber() <= 0) ? iM5728b : iM5728b + CodedOutputStream.m5727b(4, stackTraceElement.getLineNumber()));
    }

    /* JADX INFO: renamed from: a */
    private static int m5983a(Thread thread, StackTraceElement[] stackTraceElementArr, int i, boolean z) {
        int iM5733d = CodedOutputStream.m5733d(2, i) + CodedOutputStream.m5728b(1, ByteString.m5711a(thread.getName()));
        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
            int iM5981a = m5981a(stackTraceElement, z);
            iM5733d += iM5981a + CodedOutputStream.m5741j(3) + CodedOutputStream.m5742l(iM5981a);
        }
        return iM5733d;
    }

    /* JADX INFO: renamed from: a */
    private static ByteString m5984a(String str) {
        if (str == null) {
            return null;
        }
        return ByteString.m5711a(str);
    }
}
