package com.google.firebase.iid;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Base64;
import android.util.Log;
import com.google.firebase.FirebaseApp;
import java.security.KeyPair;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: loaded from: classes.dex */
final class zzu {

    /* JADX INFO: renamed from: a */
    private final Context f8682a;

    /* JADX INFO: renamed from: b */
    private String f8683b;

    /* JADX INFO: renamed from: c */
    private String f8684c;

    /* JADX INFO: renamed from: d */
    private int f8685d;

    /* JADX INFO: renamed from: e */
    private int f8686e = 0;

    public zzu(Context context) {
        this.f8682a = context;
    }

    /* JADX INFO: renamed from: a */
    private final PackageInfo m9154a(String str) {
        try {
            return this.f8682a.getPackageManager().getPackageInfo(str, 0);
        } catch (PackageManager.NameNotFoundException e) {
            String strValueOf = String.valueOf(e);
            Log.w("FirebaseInstanceId", new StringBuilder(String.valueOf(strValueOf).length() + 23).append("Failed to find package ").append(strValueOf).toString());
            return null;
        }
    }

    /* JADX INFO: renamed from: a */
    public static String m9155a(FirebaseApp firebaseApp) {
        String strM9093b = firebaseApp.m9086c().m9093b();
        if (strM9093b != null) {
            return strM9093b;
        }
        String strM9092a = firebaseApp.m9086c().m9092a();
        if (!strM9092a.startsWith("1:")) {
            return strM9092a;
        }
        String[] strArrSplit = strM9092a.split(":");
        if (strArrSplit.length < 2) {
            return null;
        }
        String str = strArrSplit[1];
        if (str.isEmpty()) {
            return null;
        }
        return str;
    }

    /* JADX INFO: renamed from: a */
    public static String m9156a(KeyPair keyPair) {
        try {
            byte[] bArrDigest = MessageDigest.getInstance("SHA1").digest(keyPair.getPublic().getEncoded());
            bArrDigest[0] = (byte) ((bArrDigest[0] & 15) + 112);
            return Base64.encodeToString(bArrDigest, 0, 8, 11);
        } catch (NoSuchAlgorithmException e) {
            Log.w("FirebaseInstanceId", "Unexpected error, device missing required algorithms");
            return null;
        }
    }

    /* JADX INFO: renamed from: e */
    private final synchronized void m9157e() {
        PackageInfo packageInfoM9154a = m9154a(this.f8682a.getPackageName());
        if (packageInfoM9154a != null) {
            this.f8683b = Integer.toString(packageInfoM9154a.versionCode);
            this.f8684c = packageInfoM9154a.versionName;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x004b A[Catch: all -> 0x0023, TryCatch #0 {, blocks: (B:4:0x0002, B:6:0x0006, B:9:0x000a, B:11:0x001b, B:16:0x0026, B:18:0x002c, B:20:0x003f, B:22:0x0045, B:23:0x004b, B:25:0x005e, B:27:0x0064, B:28:0x006a, B:30:0x0077, B:31:0x007a, B:32:0x007d), top: B:34:0x0002 }] */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final synchronized int m9158a() {
        /*
            r4 = this;
            r0 = 0
            monitor-enter(r4)
            int r1 = r4.f8686e     // Catch: java.lang.Throwable -> L23
            if (r1 == 0) goto La
            int r0 = r4.f8686e     // Catch: java.lang.Throwable -> L23
        L8:
            monitor-exit(r4)
            return r0
        La:
            android.content.Context r1 = r4.f8682a     // Catch: java.lang.Throwable -> L23
            android.content.pm.PackageManager r1 = r1.getPackageManager()     // Catch: java.lang.Throwable -> L23
            java.lang.String r2 = "com.google.android.c2dm.permission.SEND"
            java.lang.String r3 = "com.google.android.gms"
            int r2 = r1.checkPermission(r2, r3)     // Catch: java.lang.Throwable -> L23
            r3 = -1
            if (r2 != r3) goto L26
            java.lang.String r1 = "FirebaseInstanceId"
            java.lang.String r2 = "Google Play services missing or without correct permission."
            android.util.Log.e(r1, r2)     // Catch: java.lang.Throwable -> L23
            goto L8
        L23:
            r0 = move-exception
            monitor-exit(r4)
            throw r0
        L26:
            boolean r0 = com.google.android.gms.common.util.zzq.m7517h()     // Catch: java.lang.Throwable -> L23
            if (r0 != 0) goto L4b
            android.content.Intent r0 = new android.content.Intent     // Catch: java.lang.Throwable -> L23
            java.lang.String r2 = "com.google.android.c2dm.intent.REGISTER"
            r0.<init>(r2)     // Catch: java.lang.Throwable -> L23
            java.lang.String r2 = "com.google.android.gms"
            r0.setPackage(r2)     // Catch: java.lang.Throwable -> L23
            r2 = 0
            java.util.List r0 = r1.queryIntentServices(r0, r2)     // Catch: java.lang.Throwable -> L23
            if (r0 == 0) goto L4b
            int r0 = r0.size()     // Catch: java.lang.Throwable -> L23
            if (r0 <= 0) goto L4b
            r0 = 1
            r4.f8686e = r0     // Catch: java.lang.Throwable -> L23
            int r0 = r4.f8686e     // Catch: java.lang.Throwable -> L23
            goto L8
        L4b:
            android.content.Intent r0 = new android.content.Intent     // Catch: java.lang.Throwable -> L23
            java.lang.String r2 = "com.google.iid.TOKEN_REQUEST"
            r0.<init>(r2)     // Catch: java.lang.Throwable -> L23
            java.lang.String r2 = "com.google.android.gms"
            r0.setPackage(r2)     // Catch: java.lang.Throwable -> L23
            r2 = 0
            java.util.List r0 = r1.queryBroadcastReceivers(r0, r2)     // Catch: java.lang.Throwable -> L23
            if (r0 == 0) goto L6a
            int r0 = r0.size()     // Catch: java.lang.Throwable -> L23
            if (r0 <= 0) goto L6a
            r0 = 2
            r4.f8686e = r0     // Catch: java.lang.Throwable -> L23
            int r0 = r4.f8686e     // Catch: java.lang.Throwable -> L23
            goto L8
        L6a:
            java.lang.String r0 = "FirebaseInstanceId"
            java.lang.String r1 = "Failed to resolve IID implementation package, falling back"
            android.util.Log.w(r0, r1)     // Catch: java.lang.Throwable -> L23
            boolean r0 = com.google.android.gms.common.util.zzq.m7517h()     // Catch: java.lang.Throwable -> L23
            if (r0 == 0) goto L7d
            r0 = 2
            r4.f8686e = r0     // Catch: java.lang.Throwable -> L23
        L7a:
            int r0 = r4.f8686e     // Catch: java.lang.Throwable -> L23
            goto L8
        L7d:
            r0 = 1
            r4.f8686e = r0     // Catch: java.lang.Throwable -> L23
            goto L7a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.iid.zzu.m9158a():int");
    }

    /* JADX INFO: renamed from: b */
    public final synchronized String m9159b() {
        if (this.f8683b == null) {
            m9157e();
        }
        return this.f8683b;
    }

    /* JADX INFO: renamed from: c */
    public final synchronized String m9160c() {
        if (this.f8684c == null) {
            m9157e();
        }
        return this.f8684c;
    }

    /* JADX INFO: renamed from: d */
    public final synchronized int m9161d() {
        PackageInfo packageInfoM9154a;
        if (this.f8685d == 0 && (packageInfoM9154a = m9154a("com.google.android.gms")) != null) {
            this.f8685d = packageInfoM9154a.versionCode;
        }
        return this.f8685d;
    }
}
