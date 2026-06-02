package com.google.android.gms.internal;

import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Log;
import java.net.MalformedURLException;
import java.net.URL;

/* JADX INFO: loaded from: classes.dex */
public final class zzewq {
    /* JADX INFO: renamed from: a */
    public static int m8604a(byte[] bArr) {
        int i = 0;
        for (int i2 = 0; i2 < 4 && i2 < bArr.length; i2++) {
            i |= (bArr[i2] & 255) << (i2 << 3);
        }
        return i;
    }

    /* JADX INFO: renamed from: a */
    public static String m8605a(String str) {
        try {
            URL url = new URL(str);
            if (url.getQuery() != null) {
                str = str.substring(0, str.indexOf(r1) - 1);
            }
            String userInfo = url.getUserInfo();
            return userInfo == null ? str : str.replace(String.valueOf(userInfo).concat("@"), "");
        } catch (MalformedURLException e) {
            return str;
        }
    }

    /* JADX INFO: renamed from: a */
    public static String m8606a(String str, int i) {
        int iLastIndexOf;
        if (str.length() <= 2000) {
            return str;
        }
        if (str.charAt(2000) == '/') {
            return str.substring(0, 2000);
        }
        try {
            return (new URL(str).getPath().lastIndexOf(47) < 0 || (iLastIndexOf = str.lastIndexOf(47, 1999)) < 0) ? str.substring(0, 2000) : str.substring(0, iLastIndexOf);
        } catch (MalformedURLException e) {
            return str.substring(0, 2000);
        }
    }

    /* JADX INFO: renamed from: a */
    public static boolean m8607a(Context context) {
        try {
            return context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.getBoolean("firebase_performance_logcat_enabled", false);
        } catch (PackageManager.NameNotFoundException | NullPointerException e) {
            String strValueOf = String.valueOf(e.getMessage());
            Log.d("isEnabled", strValueOf.length() != 0 ? "No perf logcat meta data found ".concat(strValueOf) : new String("No perf logcat meta data found "));
            return false;
        }
    }
}
