package com.google.android.gms.internal;

import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
final class zzchx extends zzcjl {

    /* JADX INFO: renamed from: a */
    static final Pair<String, Long> f7256a = new Pair<>("", 0L);

    /* JADX INFO: renamed from: b */
    public final zzcib f7257b;

    /* JADX INFO: renamed from: c */
    public final zzcia f7258c;

    /* JADX INFO: renamed from: d */
    public final zzcia f7259d;

    /* JADX INFO: renamed from: e */
    public final zzcia f7260e;

    /* JADX INFO: renamed from: f */
    public final zzcia f7261f;

    /* JADX INFO: renamed from: g */
    public final zzcia f7262g;

    /* JADX INFO: renamed from: h */
    public final zzcia f7263h;

    /* JADX INFO: renamed from: i */
    public final zzcic f7264i;

    /* JADX INFO: renamed from: j */
    public final zzcia f7265j;

    /* JADX INFO: renamed from: k */
    public final zzcia f7266k;

    /* JADX INFO: renamed from: l */
    public final zzchz f7267l;

    /* JADX INFO: renamed from: m */
    public final zzcia f7268m;

    /* JADX INFO: renamed from: n */
    public final zzcia f7269n;

    /* JADX INFO: renamed from: o */
    public boolean f7270o;

    /* JADX INFO: renamed from: q */
    private SharedPreferences f7271q;

    /* JADX INFO: renamed from: r */
    private String f7272r;

    /* JADX INFO: renamed from: s */
    private boolean f7273s;

    /* JADX INFO: renamed from: t */
    private long f7274t;

    /* JADX INFO: renamed from: u */
    private String f7275u;

    /* JADX INFO: renamed from: v */
    private long f7276v;

    /* JADX INFO: renamed from: w */
    private final Object f7277w;

    zzchx(zzcim zzcimVar) {
        super(zzcimVar);
        this.f7257b = new zzcib(this, "health_monitor", Math.max(0L, zzchc.f7179e.m8041b().longValue()));
        this.f7258c = new zzcia(this, "last_upload", 0L);
        this.f7259d = new zzcia(this, "last_upload_attempt", 0L);
        this.f7260e = new zzcia(this, "backoff", 0L);
        this.f7261f = new zzcia(this, "last_delete_stale", 0L);
        this.f7265j = new zzcia(this, "time_before_start", 10000L);
        this.f7266k = new zzcia(this, "session_timeout", 1800000L);
        this.f7267l = new zzchz(this, "start_new_session", true);
        this.f7268m = new zzcia(this, "last_pause_time", 0L);
        this.f7269n = new zzcia(this, "time_active", 0L);
        this.f7262g = new zzcia(this, "midnight_offset", 0L);
        this.f7263h = new zzcia(this, "first_open_time", 0L);
        this.f7264i = new zzcic(this, "app_instance_id", null);
        this.f7277w = new Object();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: D */
    public final SharedPreferences m8120D() {
        mo7855c();
        m8259Q();
        return this.f7271q;
    }

    /* JADX INFO: renamed from: A */
    final Boolean m8122A() {
        mo7855c();
        if (m8120D().contains("use_service")) {
            return Boolean.valueOf(m8120D().getBoolean("use_service", false));
        }
        return null;
    }

    /* JADX INFO: renamed from: B */
    final void m8123B() {
        mo7855c();
        mo7872t().m8101E().m8108a("Clearing collection preferences.");
        boolean zContains = m8120D().contains("measurement_enabled");
        boolean zM8130c = zContains ? m8130c(true) : true;
        SharedPreferences.Editor editorEdit = m8120D().edit();
        editorEdit.clear();
        editorEdit.apply();
        if (zContains) {
            m8128b(zM8130c);
        }
    }

    /* JADX INFO: renamed from: C */
    protected final String m8124C() {
        mo7855c();
        String string = m8120D().getString("previous_os_version", null);
        mo7860h().m8259Q();
        String str = Build.VERSION.RELEASE;
        if (!TextUtils.isEmpty(str) && !str.equals(string)) {
            SharedPreferences.Editor editorEdit = m8120D().edit();
            editorEdit.putString("previous_os_version", str);
            editorEdit.apply();
        }
        return string;
    }

    /* JADX INFO: renamed from: a */
    final Pair<String, Boolean> m8125a(String str) {
        mo7855c();
        long jMo7497b = mo7863k().mo7497b();
        if (this.f7272r != null && jMo7497b < this.f7274t) {
            return new Pair<>(this.f7272r, Boolean.valueOf(this.f7273s));
        }
        this.f7274t = jMo7497b + mo7874v().m7942a(str, zzchc.f7178d);
        AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(true);
        try {
            AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(mo7864l());
            if (advertisingIdInfo != null) {
                this.f7272r = advertisingIdInfo.getId();
                this.f7273s = advertisingIdInfo.isLimitAdTrackingEnabled();
            }
            if (this.f7272r == null) {
                this.f7272r = "";
            }
        } catch (Throwable th) {
            mo7872t().m8100D().m8109a("Unable to get advertising id", th);
            this.f7272r = "";
        }
        AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(false);
        return new Pair<>(this.f7272r, Boolean.valueOf(this.f7273s));
    }

    /* JADX INFO: renamed from: a */
    final void m8126a(boolean z) {
        mo7855c();
        mo7872t().m8101E().m8109a("Setting useService", Boolean.valueOf(z));
        SharedPreferences.Editor editorEdit = m8120D().edit();
        editorEdit.putBoolean("use_service", z);
        editorEdit.apply();
    }

    /* JADX INFO: renamed from: b */
    final String m8127b(String str) {
        mo7855c();
        String str2 = (String) m8125a(str).first;
        MessageDigest messageDigestM8409g = zzclq.m8409g("MD5");
        if (messageDigestM8409g == null) {
            return null;
        }
        return String.format(Locale.US, "%032X", new BigInteger(1, messageDigestM8409g.digest(str2.getBytes())));
    }

    /* JADX INFO: renamed from: b */
    final void m8128b(boolean z) {
        mo7855c();
        mo7872t().m8101E().m8109a("Setting measurementEnabled", Boolean.valueOf(z));
        SharedPreferences.Editor editorEdit = m8120D().edit();
        editorEdit.putBoolean("measurement_enabled", z);
        editorEdit.apply();
    }

    /* JADX INFO: renamed from: c */
    final void m8129c(String str) {
        mo7855c();
        SharedPreferences.Editor editorEdit = m8120D().edit();
        editorEdit.putString("gmp_app_id", str);
        editorEdit.apply();
    }

    /* JADX INFO: renamed from: c */
    final boolean m8130c(boolean z) {
        mo7855c();
        return m8120D().getBoolean("measurement_enabled", z);
    }

    /* JADX INFO: renamed from: d */
    final void m8131d(String str) {
        synchronized (this.f7277w) {
            this.f7275u = str;
            this.f7276v = mo7863k().mo7497b();
        }
    }

    @Override // com.google.android.gms.internal.zzcjl
    /* JADX INFO: renamed from: d_ */
    protected final void mo8063d_() {
        this.f7271q = mo7864l().getSharedPreferences("com.google.android.gms.measurement.prefs", 0);
        this.f7270o = this.f7271q.getBoolean("has_been_opened", false);
        if (this.f7270o) {
            return;
        }
        SharedPreferences.Editor editorEdit = this.f7271q.edit();
        editorEdit.putBoolean("has_been_opened", true);
        editorEdit.apply();
    }

    @Override // com.google.android.gms.internal.zzcjl
    /* JADX INFO: renamed from: w */
    protected final boolean mo7936w() {
        return true;
    }

    /* JADX INFO: renamed from: y */
    final String m8132y() {
        mo7855c();
        return m8120D().getString("gmp_app_id", null);
    }

    /* JADX INFO: renamed from: z */
    final String m8133z() {
        String str;
        synchronized (this.f7277w) {
            str = Math.abs(mo7863k().mo7497b() - this.f7276v) < 1000 ? this.f7275u : null;
        }
        return str;
    }
}
