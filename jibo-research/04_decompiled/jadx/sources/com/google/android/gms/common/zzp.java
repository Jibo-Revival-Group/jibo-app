package com.google.android.gms.common;

import android.annotation.TargetApi;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageInstaller;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.UserManager;
import android.util.Log;
import com.facebook.internal.ServerProtocol;
import com.facebook.internal.Utility;
import com.google.android.gms.R;
import com.google.android.gms.common.internal.zzbf;
import com.google.android.gms.common.util.zzx;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public class zzp {

    @Deprecated
    public static final String GOOGLE_PLAY_SERVICES_PACKAGE = "com.google.android.gms";
    public static final String GOOGLE_PLAY_STORE_PACKAGE = "com.android.vending";

    @Deprecated
    public static final int GOOGLE_PLAY_SERVICES_VERSION_CODE = 11910000;
    private static boolean zzflj = false;
    private static boolean zzflk = false;
    private static boolean zzfll = false;
    private static boolean zzflm = false;
    static final AtomicBoolean zzfln = new AtomicBoolean();
    private static final AtomicBoolean zzflo = new AtomicBoolean();

    zzp() {
    }

    @Deprecated
    public static PendingIntent getErrorPendingIntent(int i, Context context, int i2) {
        return zzf.m7530b().mo6837a(context, i, i2);
    }

    @Deprecated
    public static String getErrorString(int i) {
        return ConnectionResult.m6819a(i);
    }

    public static Context getRemoteContext(Context context) {
        try {
            return context.createPackageContext("com.google.android.gms", 3);
        } catch (PackageManager.NameNotFoundException e) {
            return null;
        }
    }

    public static Resources getRemoteResource(Context context) {
        try {
            return context.getPackageManager().getResourcesForApplication("com.google.android.gms");
        } catch (PackageManager.NameNotFoundException e) {
            return null;
        }
    }

    @Deprecated
    public static int isGooglePlayServicesAvailable(Context context) {
        PackageManager packageManager = context.getPackageManager();
        try {
            context.getResources().getString(R.string.common_google_play_services_unknown_issue);
        } catch (Throwable th) {
            Log.e("GooglePlayServicesUtil", "The Google Play services resources were not found. Check your project configuration to ensure that the resources are included.");
        }
        if (!"com.google.android.gms".equals(context.getPackageName()) && !zzflo.get()) {
            int iM7368b = zzbf.m7368b(context);
            if (iM7368b == 0) {
                throw new IllegalStateException("A required meta-data tag in your app's AndroidManifest.xml does not exist.  You must have the following declaration within the <application> element:     <meta-data android:name=\"com.google.android.gms.version\" android:value=\"@integer/google_play_services_version\" />");
            }
            if (iM7368b != GOOGLE_PLAY_SERVICES_VERSION_CODE) {
                throw new IllegalStateException(new StringBuilder(String.valueOf("com.google.android.gms.version").length() + 290).append("The meta-data tag in your app's AndroidManifest.xml does not have the right value.  Expected ").append(GOOGLE_PLAY_SERVICES_VERSION_CODE).append(" but found ").append(iM7368b).append(".  You must have the following declaration within the <application> element:     <meta-data android:name=\"").append("com.google.android.gms.version").append("\" android:value=\"@integer/google_play_services_version\" />").toString());
            }
        }
        boolean z = (com.google.android.gms.common.util.zzi.m7503b(context) || com.google.android.gms.common.util.zzi.m7505d(context)) ? false : true;
        PackageInfo packageInfo = null;
        if (z) {
            try {
                packageInfo = packageManager.getPackageInfo("com.android.vending", 8256);
            } catch (PackageManager.NameNotFoundException e) {
                Log.w("GooglePlayServicesUtil", "Google Play Store is missing.");
                return 9;
            }
        }
        try {
            PackageInfo packageInfo2 = packageManager.getPackageInfo("com.google.android.gms", 64);
            zzq.m7546a(context);
            if (z) {
                zzh zzhVarM7545a = zzq.m7545a(packageInfo, zzk.f6712a);
                if (zzhVarM7545a == null) {
                    Log.w("GooglePlayServicesUtil", "Google Play Store signature invalid.");
                    return 9;
                }
                if (zzq.m7545a(packageInfo2, zzhVarM7545a) == null) {
                    Log.w("GooglePlayServicesUtil", "Google Play services signature invalid.");
                    return 9;
                }
            } else if (zzq.m7545a(packageInfo2, zzk.f6712a) == null) {
                Log.w("GooglePlayServicesUtil", "Google Play services signature invalid.");
                return 9;
            }
            if (packageInfo2.versionCode / 1000 < GOOGLE_PLAY_SERVICES_VERSION_CODE / 1000) {
                Log.w("GooglePlayServicesUtil", new StringBuilder(77).append("Google Play services out of date.  Requires ").append(GOOGLE_PLAY_SERVICES_VERSION_CODE).append(" but found ").append(packageInfo2.versionCode).toString());
                return 2;
            }
            ApplicationInfo applicationInfo = packageInfo2.applicationInfo;
            if (applicationInfo == null) {
                try {
                    applicationInfo = packageManager.getApplicationInfo("com.google.android.gms", 0);
                } catch (PackageManager.NameNotFoundException e2) {
                    Log.wtf("GooglePlayServicesUtil", "Google Play services missing when getting application info.", e2);
                    return 1;
                }
            }
            return !applicationInfo.enabled ? 3 : 0;
        } catch (PackageManager.NameNotFoundException e3) {
            Log.w("GooglePlayServicesUtil", "Google Play services is missing.");
            return 1;
        }
    }

    @Deprecated
    public static boolean isUserRecoverableError(int i) {
        switch (i) {
            case 1:
            case 2:
            case 3:
            case 9:
                return true;
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            default:
                return false;
        }
    }

    @TargetApi(19)
    @Deprecated
    public static boolean zzb(Context context, int i, String str) {
        return zzx.m7525a(context, i, str);
    }

    @Deprecated
    public static void zzbp(Context context) throws GooglePlayServicesRepairableException, GooglePlayServicesNotAvailableException {
        int iMo6834a = zzf.m7530b().mo6834a(context);
        if (iMo6834a != 0) {
            zzf.m7530b();
            Intent intentM7528a = zzf.m7528a(context, iMo6834a, "e");
            Log.e("GooglePlayServicesUtil", new StringBuilder(57).append("GooglePlayServices not available due to error ").append(iMo6834a).toString());
            if (intentM7528a != null) {
                throw new GooglePlayServicesRepairableException(iMo6834a, "Google Play Services not available", intentM7528a);
            }
            throw new GooglePlayServicesNotAvailableException(iMo6834a);
        }
    }

    @Deprecated
    public static void zzce(Context context) {
        if (zzfln.getAndSet(true)) {
            return;
        }
        try {
            NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
            if (notificationManager != null) {
                notificationManager.cancel(10436);
            }
        } catch (SecurityException e) {
        }
    }

    @Deprecated
    public static int zzcf(Context context) {
        try {
            return context.getPackageManager().getPackageInfo("com.google.android.gms", 0).versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            Log.w("GooglePlayServicesUtil", "Google Play services is missing.");
            return 0;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x003d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean zzch(android.content.Context r7) {
        /*
            r0 = 0
            r1 = 1
            boolean r2 = com.google.android.gms.common.zzp.zzflm
            if (r2 != 0) goto L2d
            com.google.android.gms.internal.zzbhe r2 = com.google.android.gms.internal.zzbhf.m7816a(r7)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L41 java.lang.Throwable -> L4c
            java.lang.String r3 = "com.google.android.gms"
            r4 = 64
            android.content.pm.PackageInfo r2 = r2.m7814b(r3, r4)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L41 java.lang.Throwable -> L4c
            if (r2 == 0) goto L3d
            com.google.android.gms.common.zzq.m7546a(r7)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L41 java.lang.Throwable -> L4c
            r3 = 1
            com.google.android.gms.common.zzh[] r3 = new com.google.android.gms.common.zzh[r3]     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L41 java.lang.Throwable -> L4c
            r4 = 0
            com.google.android.gms.common.zzh[] r5 = com.google.android.gms.common.zzk.f6712a     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L41 java.lang.Throwable -> L4c
            r6 = 1
            r5 = r5[r6]     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L41 java.lang.Throwable -> L4c
            r3[r4] = r5     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L41 java.lang.Throwable -> L4c
            com.google.android.gms.common.zzh r2 = com.google.android.gms.common.zzq.m7545a(r2, r3)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L41 java.lang.Throwable -> L4c
            if (r2 == 0) goto L3d
            r2 = 1
            com.google.android.gms.common.zzp.zzfll = r2     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L41 java.lang.Throwable -> L4c
        L2b:
            com.google.android.gms.common.zzp.zzflm = r1
        L2d:
            boolean r2 = com.google.android.gms.common.zzp.zzfll
            if (r2 != 0) goto L3b
            java.lang.String r2 = "user"
            java.lang.String r3 = android.os.Build.TYPE
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L3c
        L3b:
            r0 = r1
        L3c:
            return r0
        L3d:
            r2 = 0
            com.google.android.gms.common.zzp.zzfll = r2     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L41 java.lang.Throwable -> L4c
            goto L2b
        L41:
            r2 = move-exception
            java.lang.String r3 = "GooglePlayServicesUtil"
            java.lang.String r4 = "Cannot find Google Play services package name."
            android.util.Log.w(r3, r4, r2)     // Catch: java.lang.Throwable -> L4c
            com.google.android.gms.common.zzp.zzflm = r1
            goto L2d
        L4c:
            r0 = move-exception
            com.google.android.gms.common.zzp.zzflm = r1
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.zzp.zzch(android.content.Context):boolean");
    }

    @Deprecated
    public static boolean zze(Context context, int i) {
        if (i == 18) {
            return true;
        }
        if (i == 1) {
            return zzv(context, "com.google.android.gms");
        }
        return false;
    }

    @Deprecated
    public static boolean zzf(Context context, int i) {
        return zzx.m7524a(context, i);
    }

    @TargetApi(21)
    static boolean zzv(Context context, String str) {
        Bundle applicationRestrictions;
        boolean zEquals = str.equals("com.google.android.gms");
        if (com.google.android.gms.common.util.zzq.m7515f()) {
            try {
                Iterator<PackageInstaller.SessionInfo> it = context.getPackageManager().getPackageInstaller().getAllSessions().iterator();
                while (it.hasNext()) {
                    if (str.equals(it.next().getAppPackageName())) {
                        return true;
                    }
                }
            } catch (Exception e) {
                return false;
            }
        }
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(str, Utility.DEFAULT_STREAM_BUFFER_SIZE);
            if (zEquals) {
                return applicationInfo.enabled;
            }
            if (applicationInfo.enabled) {
                if (!(com.google.android.gms.common.util.zzq.m7512c() && (applicationRestrictions = ((UserManager) context.getSystemService("user")).getApplicationRestrictions(context.getPackageName())) != null && ServerProtocol.DIALOG_RETURN_SCOPES_TRUE.equals(applicationRestrictions.getString("restricted_profile")))) {
                    return true;
                }
            }
            return false;
        } catch (PackageManager.NameNotFoundException e2) {
            return false;
        }
    }
}
