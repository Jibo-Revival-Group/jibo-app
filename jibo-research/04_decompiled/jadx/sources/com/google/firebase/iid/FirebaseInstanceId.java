package com.google.firebase.iid;

import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.support.annotation.Keep;
import android.support.v4.util.ArrayMap;
import android.util.Log;
import com.facebook.appevents.AppEventsConstants;
import com.google.firebase.FirebaseApp;
import java.io.IOException;
import java.security.KeyPair;
import java.util.Map;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class FirebaseInstanceId {

    /* JADX INFO: renamed from: a */
    private static final long f8619a = TimeUnit.HOURS.toSeconds(8);

    /* JADX INFO: renamed from: b */
    private static Map<String, FirebaseInstanceId> f8620b = new ArrayMap();

    /* JADX INFO: renamed from: c */
    private static zzy f8621c;

    /* JADX INFO: renamed from: d */
    private static ScheduledThreadPoolExecutor f8622d;

    /* JADX INFO: renamed from: e */
    private final FirebaseApp f8623e;

    /* JADX INFO: renamed from: f */
    private final zzu f8624f;

    /* JADX INFO: renamed from: g */
    private final zzv f8625g;

    /* JADX INFO: renamed from: h */
    private KeyPair f8626h;

    /* JADX INFO: renamed from: i */
    private boolean f8627i = false;

    private FirebaseInstanceId(FirebaseApp firebaseApp) {
        this.f8623e = firebaseApp;
        if (zzu.m9155a(firebaseApp) == null) {
            throw new IllegalStateException("FirebaseInstanceId failed to initialize, FirebaseApp is missing project ID");
        }
        this.f8624f = new zzu(firebaseApp.m9084a());
        this.f8625g = new zzv(firebaseApp.m9084a(), this.f8624f);
        zzz zzzVarM9109e = m9109e();
        if (zzzVarM9109e == null || zzzVarM9109e.m9190b(this.f8624f.m9159b()) || f8621c.m9180a() != null) {
            m9099k();
        }
    }

    /* JADX INFO: renamed from: a */
    public static FirebaseInstanceId m9094a() {
        return getInstance(FirebaseApp.m9080d());
    }

    /* JADX INFO: renamed from: a */
    private final String m9095a(String str, String str2, Bundle bundle) throws IOException {
        bundle.putString("scope", str2);
        bundle.putString("sender", str);
        bundle.putString("subtype", str);
        bundle.putString("appid", m9107c());
        bundle.putString("gmp_app_id", this.f8623e.m9086c().m9092a());
        bundle.putString("gmsv", Integer.toString(this.f8624f.m9161d()));
        bundle.putString("osv", Integer.toString(Build.VERSION.SDK_INT));
        bundle.putString("app_ver", this.f8624f.m9159b());
        bundle.putString("app_ver_name", this.f8624f.m9160c());
        bundle.putString("cliv", "fiid-11910000");
        Bundle bundleM9169a = this.f8625g.m9169a(bundle);
        if (bundleM9169a == null) {
            throw new IOException("SERVICE_NOT_AVAILABLE");
        }
        String string = bundleM9169a.getString("registration_id");
        if (string != null || (string = bundleM9169a.getString("unregistered")) != null) {
            if (!"RST".equals(string) && !string.startsWith("RST|")) {
                return string;
            }
            m9111i();
            throw new IOException("SERVICE_NOT_AVAILABLE");
        }
        String string2 = bundleM9169a.getString("error");
        if (string2 != null) {
            throw new IOException(string2);
        }
        String strValueOf = String.valueOf(bundleM9169a);
        Log.w("FirebaseInstanceId", new StringBuilder(String.valueOf(strValueOf).length() + 20).append("Unexpected response ").append(strValueOf).toString(), new Throwable());
        throw new IOException("SERVICE_NOT_AVAILABLE");
    }

    /* JADX INFO: renamed from: a */
    static void m9096a(Runnable runnable, long j) {
        synchronized (FirebaseInstanceId.class) {
            if (f8622d == null) {
                f8622d = new ScheduledThreadPoolExecutor(1);
            }
            f8622d.schedule(runnable, j, TimeUnit.SECONDS);
        }
    }

    /* JADX INFO: renamed from: g */
    static zzy m9097g() {
        return f8621c;
    }

    @Keep
    public static synchronized FirebaseInstanceId getInstance(FirebaseApp firebaseApp) {
        FirebaseInstanceId firebaseInstanceId;
        firebaseInstanceId = f8620b.get(firebaseApp.m9086c().m9092a());
        if (firebaseInstanceId == null) {
            if (f8621c == null) {
                f8621c = new zzy(firebaseApp.m9084a());
            }
            firebaseInstanceId = new FirebaseInstanceId(firebaseApp);
            f8620b.put(firebaseApp.m9086c().m9092a(), firebaseInstanceId);
        }
        return firebaseInstanceId;
    }

    /* JADX INFO: renamed from: h */
    static boolean m9098h() {
        return Log.isLoggable("FirebaseInstanceId", 3) || (Build.VERSION.SDK_INT == 23 && Log.isLoggable("FirebaseInstanceId", 3));
    }

    /* JADX INFO: renamed from: k */
    private final synchronized void m9099k() {
        if (!this.f8627i) {
            m9102a(0L);
        }
    }

    /* JADX INFO: renamed from: l */
    private final void m9100l() {
        f8621c.m9185c("");
        this.f8626h = null;
    }

    /* JADX INFO: renamed from: a */
    public String m9101a(String str, String str2) throws IOException {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            throw new IOException("MAIN_THREAD");
        }
        zzz zzzVarM9179a = f8621c.m9179a("", str, str2);
        if (zzzVarM9179a != null && !zzzVarM9179a.m9190b(this.f8624f.m9159b())) {
            return zzzVarM9179a.f8704a;
        }
        String strM9095a = m9095a(str, str2, new Bundle());
        if (strM9095a == null) {
            return strM9095a;
        }
        f8621c.m9181a("", str, str2, strM9095a, this.f8624f.m9159b());
        return strM9095a;
    }

    /* JADX INFO: renamed from: a */
    final synchronized void m9102a(long j) {
        m9096a(new zzaa(this, this.f8624f, Math.min(Math.max(30L, j << 1), f8619a)), j);
        this.f8627i = true;
    }

    /* JADX INFO: renamed from: a */
    final void m9103a(String str) throws IOException {
        zzz zzzVarM9109e = m9109e();
        if (zzzVarM9109e == null || zzzVarM9109e.m9190b(this.f8624f.m9159b())) {
            throw new IOException("token not available");
        }
        Bundle bundle = new Bundle();
        String strValueOf = String.valueOf("/topics/");
        String strValueOf2 = String.valueOf(str);
        bundle.putString("gcm.topic", strValueOf2.length() != 0 ? strValueOf.concat(strValueOf2) : new String(strValueOf));
        String str2 = zzzVarM9109e.f8704a;
        String strValueOf3 = String.valueOf("/topics/");
        String strValueOf4 = String.valueOf(str);
        m9095a(str2, strValueOf4.length() != 0 ? strValueOf3.concat(strValueOf4) : new String(strValueOf3), bundle);
    }

    /* JADX INFO: renamed from: a */
    final synchronized void m9104a(boolean z) {
        this.f8627i = z;
    }

    /* JADX INFO: renamed from: b */
    final FirebaseApp m9105b() {
        return this.f8623e;
    }

    /* JADX INFO: renamed from: b */
    final void m9106b(String str) throws IOException {
        zzz zzzVarM9109e = m9109e();
        if (zzzVarM9109e == null || zzzVarM9109e.m9190b(this.f8624f.m9159b())) {
            throw new IOException("token not available");
        }
        Bundle bundle = new Bundle();
        String strValueOf = String.valueOf("/topics/");
        String strValueOf2 = String.valueOf(str);
        bundle.putString("gcm.topic", strValueOf2.length() != 0 ? strValueOf.concat(strValueOf2) : new String(strValueOf));
        bundle.putString("delete", AppEventsConstants.EVENT_PARAM_VALUE_YES);
        String str2 = zzzVarM9109e.f8704a;
        String strValueOf3 = String.valueOf("/topics/");
        String strValueOf4 = String.valueOf(str);
        m9095a(str2, strValueOf4.length() != 0 ? strValueOf3.concat(strValueOf4) : new String(strValueOf3), bundle);
    }

    /* JADX INFO: renamed from: c */
    public String m9107c() {
        if (this.f8626h == null) {
            this.f8626h = f8621c.m9187e("");
        }
        if (this.f8626h == null) {
            this.f8626h = f8621c.m9183b("");
        }
        return zzu.m9156a(this.f8626h);
    }

    /* JADX INFO: renamed from: d */
    public String m9108d() {
        zzz zzzVarM9109e = m9109e();
        if (zzzVarM9109e == null || zzzVarM9109e.m9190b(this.f8624f.m9159b())) {
            m9099k();
        }
        if (zzzVarM9109e != null) {
            return zzzVarM9109e.f8704a;
        }
        return null;
    }

    /* JADX INFO: renamed from: e */
    final zzz m9109e() {
        return f8621c.m9179a("", zzu.m9155a(this.f8623e), "*");
    }

    /* JADX INFO: renamed from: f */
    final String m9110f() throws IOException {
        return m9101a(zzu.m9155a(this.f8623e), "*");
    }

    /* JADX INFO: renamed from: i */
    final void m9111i() {
        f8621c.m9184b();
        m9100l();
        m9099k();
    }

    /* JADX INFO: renamed from: j */
    final void m9112j() {
        f8621c.m9186d("");
        m9099k();
    }
}
