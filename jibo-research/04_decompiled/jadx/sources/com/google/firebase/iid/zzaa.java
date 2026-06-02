package com.google.firebase.iid;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.PowerManager;
import android.util.Log;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
final class zzaa implements Runnable {

    /* JADX INFO: renamed from: a */
    private final long f8631a;

    /* JADX INFO: renamed from: b */
    private final PowerManager.WakeLock f8632b = ((PowerManager) m9122a().getSystemService("power")).newWakeLock(1, "fiid-sync");

    /* JADX INFO: renamed from: c */
    private final FirebaseInstanceId f8633c;

    /* JADX INFO: renamed from: d */
    private final zzu f8634d;

    zzaa(FirebaseInstanceId firebaseInstanceId, zzu zzuVar, long j) {
        this.f8633c = firebaseInstanceId;
        this.f8634d = zzuVar;
        this.f8631a = j;
        this.f8632b.setReferenceCounted(false);
    }

    /* JADX INFO: renamed from: a */
    private final boolean m9119a(String str) {
        String[] strArrSplit = str.split("!");
        if (strArrSplit.length != 2) {
            return true;
        }
        String str2 = strArrSplit[0];
        String str3 = strArrSplit[1];
        try {
            switch (str2) {
                case "S":
                    this.f8633c.m9103a(str3);
                    if (FirebaseInstanceId.m9098h()) {
                        Log.d("FirebaseInstanceId", "subscribe operation succeeded");
                        break;
                    }
                    break;
                case "U":
                    this.f8633c.m9106b(str3);
                    if (FirebaseInstanceId.m9098h()) {
                        Log.d("FirebaseInstanceId", "unsubscribe operation succeeded");
                        break;
                    }
                    break;
            }
        } catch (IOException e) {
            String strValueOf = String.valueOf(e.getMessage());
            Log.e("FirebaseInstanceId", strValueOf.length() != 0 ? "Topic sync failed: ".concat(strValueOf) : new String("Topic sync failed: "));
            return false;
        }
        return true;
    }

    /* JADX INFO: renamed from: c */
    private final boolean m9120c() {
        zzz zzzVarM9109e = this.f8633c.m9109e();
        if (zzzVarM9109e != null && !zzzVarM9109e.m9190b(this.f8634d.m9159b())) {
            return true;
        }
        try {
            String strM9110f = this.f8633c.m9110f();
            if (strM9110f == null) {
                Log.e("FirebaseInstanceId", "Token retrieval failed: null");
                return false;
            }
            if (Log.isLoggable("FirebaseInstanceId", 3)) {
                Log.d("FirebaseInstanceId", "Token successfully retrieved");
            }
            if (zzzVarM9109e != null && (zzzVarM9109e == null || strM9110f.equals(zzzVarM9109e.f8704a))) {
                return true;
            }
            Context contextM9122a = m9122a();
            Intent intent = new Intent("com.google.firebase.iid.TOKEN_REFRESH");
            Intent intent2 = new Intent("com.google.firebase.INSTANCE_ID_EVENT");
            intent2.setClass(contextM9122a, FirebaseInstanceIdReceiver.class);
            intent2.putExtra("wrapped_intent", intent);
            contextM9122a.sendBroadcast(intent2);
            return true;
        } catch (IOException | SecurityException e) {
            String strValueOf = String.valueOf(e.getMessage());
            Log.e("FirebaseInstanceId", strValueOf.length() != 0 ? "Token retrieval failed: ".concat(strValueOf) : new String("Token retrieval failed: "));
            return false;
        }
    }

    /* JADX INFO: renamed from: d */
    private final boolean m9121d() {
        while (true) {
            synchronized (this.f8633c) {
                String strM9180a = FirebaseInstanceId.m9097g().m9180a();
                if (strM9180a == null) {
                    Log.d("FirebaseInstanceId", "topic sync succeeded");
                    return true;
                }
                if (!m9119a(strM9180a)) {
                    return false;
                }
                FirebaseInstanceId.m9097g().m9182a(strM9180a);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    final Context m9122a() {
        return this.f8633c.m9105b().m9084a();
    }

    /* JADX INFO: renamed from: b */
    final boolean m9123b() {
        ConnectivityManager connectivityManager = (ConnectivityManager) m9122a().getSystemService("connectivity");
        NetworkInfo activeNetworkInfo = connectivityManager != null ? connectivityManager.getActiveNetworkInfo() : null;
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f8632b.acquire();
        try {
            this.f8633c.m9104a(true);
            if (!(this.f8634d.m9158a() != 0)) {
                this.f8633c.m9104a(false);
                return;
            }
            if (!m9123b()) {
                new zzab(this).m9124a();
                return;
            }
            if (m9120c() && m9121d()) {
                this.f8633c.m9104a(false);
            } else {
                this.f8633c.m9102a(this.f8631a);
            }
        } finally {
            this.f8632b.release();
        }
    }
}
