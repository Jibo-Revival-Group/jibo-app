package com.google.android.gms.common.util;

import android.os.Process;
import android.os.StrictMode;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public final class zzs {

    /* JADX INFO: renamed from: a */
    private static String f6696a = null;

    /* JADX INFO: renamed from: b */
    private static final int f6697b = Process.myPid();

    /* JADX INFO: renamed from: a */
    public static String m7518a() {
        if (f6696a == null) {
            f6696a = m7519a(f6697b);
        }
        return f6696a;
    }

    /* JADX INFO: renamed from: a */
    private static String m7519a(int i) throws Throwable {
        BufferedReader bufferedReader;
        Throwable th;
        StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads;
        String strTrim = null;
        if (i > 0) {
            try {
                threadPolicyAllowThreadDiskReads = StrictMode.allowThreadDiskReads();
                try {
                    bufferedReader = new BufferedReader(new FileReader(new StringBuilder(25).append("/proc/").append(i).append("/cmdline").toString()));
                } finally {
                }
            } catch (IOException e) {
                bufferedReader = null;
            } catch (Throwable th2) {
                bufferedReader = null;
                th = th2;
            }
            try {
                StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
                strTrim = bufferedReader.readLine().trim();
                zzn.m7507a(bufferedReader);
            } catch (IOException e2) {
                zzn.m7507a(bufferedReader);
            } catch (Throwable th3) {
                th = th3;
                zzn.m7507a(bufferedReader);
                throw th;
            }
        }
        return strTrim;
    }
}
