package com.google.android.gms.internal;

import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import android.util.Pair;
import com.facebook.internal.AnalyticsEvents;
import com.google.android.gms.common.api.internal.zzbz;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.common.util.zzd;
import com.google.android.gms.common.util.zzh;
import com.google.android.gms.measurement.AppMeasurement;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.jibo.aws.integration.helpers.RobotHelper;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;
import org.apache.http.HttpHeaders;

/* JADX INFO: loaded from: classes.dex */
public class zzcim {

    /* JADX INFO: renamed from: a */
    private static volatile zzcim f7333a;

    /* JADX INFO: renamed from: A */
    private boolean f7334A;

    /* JADX INFO: renamed from: B */
    private Boolean f7335B;

    /* JADX INFO: renamed from: C */
    private long f7336C;

    /* JADX INFO: renamed from: D */
    private FileLock f7337D;

    /* JADX INFO: renamed from: E */
    private FileChannel f7338E;

    /* JADX INFO: renamed from: F */
    private List<Long> f7339F;

    /* JADX INFO: renamed from: G */
    private List<Runnable> f7340G;

    /* JADX INFO: renamed from: H */
    private int f7341H;

    /* JADX INFO: renamed from: I */
    private int f7342I;

    /* JADX INFO: renamed from: J */
    private long f7343J;

    /* JADX INFO: renamed from: K */
    private long f7344K;

    /* JADX INFO: renamed from: L */
    private boolean f7345L;

    /* JADX INFO: renamed from: M */
    private boolean f7346M;

    /* JADX INFO: renamed from: N */
    private boolean f7347N;

    /* JADX INFO: renamed from: O */
    private final long f7348O;

    /* JADX INFO: renamed from: b */
    private final Context f7349b;

    /* JADX INFO: renamed from: c */
    private final zzcgn f7350c;

    /* JADX INFO: renamed from: d */
    private final zzchx f7351d;

    /* JADX INFO: renamed from: e */
    private final zzchm f7352e;

    /* JADX INFO: renamed from: f */
    private final zzcih f7353f;

    /* JADX INFO: renamed from: g */
    private final zzclf f7354g;

    /* JADX INFO: renamed from: h */
    private final zzcig f7355h;

    /* JADX INFO: renamed from: i */
    private final AppMeasurement f7356i;

    /* JADX INFO: renamed from: j */
    private final FirebaseAnalytics f7357j;

    /* JADX INFO: renamed from: k */
    private final zzclq f7358k;

    /* JADX INFO: renamed from: l */
    private final zzchk f7359l;

    /* JADX INFO: renamed from: m */
    private final zzcgo f7360m;

    /* JADX INFO: renamed from: n */
    private final zzchi f7361n;

    /* JADX INFO: renamed from: o */
    private final zzchq f7362o;

    /* JADX INFO: renamed from: p */
    private final zzd f7363p;

    /* JADX INFO: renamed from: q */
    private final zzckc f7364q;

    /* JADX INFO: renamed from: r */
    private final zzckg f7365r;

    /* JADX INFO: renamed from: s */
    private final zzcgu f7366s;

    /* JADX INFO: renamed from: t */
    private final zzcjn f7367t;

    /* JADX INFO: renamed from: u */
    private final zzchh f7368u;

    /* JADX INFO: renamed from: v */
    private final zzchv f7369v;

    /* JADX INFO: renamed from: w */
    private final zzcll f7370w;

    /* JADX INFO: renamed from: x */
    private final zzcgk f7371x;

    /* JADX INFO: renamed from: y */
    private final zzcgd f7372y;

    /* JADX INFO: renamed from: z */
    private boolean f7373z = false;

    class zza implements zzcgq {

        /* JADX INFO: renamed from: a */
        zzcme f7374a;

        /* JADX INFO: renamed from: b */
        List<Long> f7375b;

        /* JADX INFO: renamed from: c */
        List<zzcmb> f7376c;

        /* JADX INFO: renamed from: d */
        private long f7377d;

        private zza() {
        }

        /* synthetic */ zza(zzcim zzcimVar, zzcin zzcinVar) {
            this();
        }

        /* JADX INFO: renamed from: a */
        private static long m8254a(zzcmb zzcmbVar) {
            return ((zzcmbVar.f7665c.longValue() / 1000) / 60) / 60;
        }

        @Override // com.google.android.gms.internal.zzcgq
        /* JADX INFO: renamed from: a */
        public final void mo8009a(zzcme zzcmeVar) {
            zzbq.m7373a(zzcmeVar);
            this.f7374a = zzcmeVar;
        }

        @Override // com.google.android.gms.internal.zzcgq
        /* JADX INFO: renamed from: a */
        public final boolean mo8010a(long j, zzcmb zzcmbVar) {
            zzbq.m7373a(zzcmbVar);
            if (this.f7376c == null) {
                this.f7376c = new ArrayList();
            }
            if (this.f7375b == null) {
                this.f7375b = new ArrayList();
            }
            if (this.f7376c.size() > 0 && m8254a(this.f7376c.get(0)) != m8254a(zzcmbVar)) {
                return false;
            }
            long jM8713f = this.f7377d + ((long) zzcmbVar.m8713f());
            if (jM8713f >= Math.max(0, zzchc.f7185k.m8041b().intValue())) {
                return false;
            }
            this.f7377d = jM8713f;
            this.f7376c.add(zzcmbVar);
            this.f7375b.add(Long.valueOf(j));
            return this.f7376c.size() < Math.max(1, zzchc.f7186l.m8041b().intValue());
        }
    }

    private zzcim(zzcjm zzcjmVar) {
        zzbq.m7373a(zzcjmVar);
        this.f7349b = zzcjmVar.f7443a;
        this.f7343J = -1L;
        this.f7363p = zzh.m7501d();
        this.f7348O = this.f7363p.mo7496a();
        this.f7350c = new zzcgn(this);
        zzchx zzchxVar = new zzchx(this);
        zzchxVar.m8260R();
        this.f7351d = zzchxVar;
        zzchm zzchmVar = new zzchm(this);
        zzchmVar.m8260R();
        this.f7352e = zzchmVar;
        zzclq zzclqVar = new zzclq(this);
        zzclqVar.m8260R();
        this.f7358k = zzclqVar;
        zzchk zzchkVar = new zzchk(this);
        zzchkVar.m8260R();
        this.f7359l = zzchkVar;
        zzcgu zzcguVar = new zzcgu(this);
        zzcguVar.m8260R();
        this.f7366s = zzcguVar;
        zzchh zzchhVar = new zzchh(this);
        zzchhVar.m8260R();
        this.f7368u = zzchhVar;
        zzcgo zzcgoVar = new zzcgo(this);
        zzcgoVar.m8260R();
        this.f7360m = zzcgoVar;
        zzchi zzchiVar = new zzchi(this);
        zzchiVar.m8260R();
        this.f7361n = zzchiVar;
        zzcgk zzcgkVar = new zzcgk(this);
        zzcgkVar.m8260R();
        this.f7371x = zzcgkVar;
        this.f7372y = new zzcgd(this);
        zzchq zzchqVar = new zzchq(this);
        zzchqVar.m8260R();
        this.f7362o = zzchqVar;
        zzckc zzckcVar = new zzckc(this);
        zzckcVar.m8260R();
        this.f7364q = zzckcVar;
        zzckg zzckgVar = new zzckg(this);
        zzckgVar.m8260R();
        this.f7365r = zzckgVar;
        zzcjn zzcjnVar = new zzcjn(this);
        zzcjnVar.m8260R();
        this.f7367t = zzcjnVar;
        zzcll zzcllVar = new zzcll(this);
        zzcllVar.m8260R();
        this.f7370w = zzcllVar;
        this.f7369v = new zzchv(this);
        this.f7356i = new AppMeasurement(this);
        this.f7357j = new FirebaseAnalytics(this);
        zzclf zzclfVar = new zzclf(this);
        zzclfVar.m8260R();
        this.f7354g = zzclfVar;
        zzcig zzcigVar = new zzcig(this);
        zzcigVar.m8260R();
        this.f7355h = zzcigVar;
        zzcih zzcihVar = new zzcih(this);
        zzcihVar.m8260R();
        this.f7353f = zzcihVar;
        if (this.f7349b.getApplicationContext() instanceof Application) {
            zzcjn zzcjnVarM8239l = m8239l();
            if (zzcjnVarM8239l.mo7864l().getApplicationContext() instanceof Application) {
                Application application = (Application) zzcjnVarM8239l.mo7864l().getApplicationContext();
                if (zzcjnVarM8239l.f7444a == null) {
                    zzcjnVarM8239l.f7444a = new zzckb(zzcjnVarM8239l, null);
                }
                application.unregisterActivityLifecycleCallbacks(zzcjnVarM8239l.f7444a);
                application.registerActivityLifecycleCallbacks(zzcjnVarM8239l.f7444a);
                zzcjnVarM8239l.mo7872t().m8101E().m8108a("Registered activity lifecycle callback");
            }
        } else {
            m8233f().m8097A().m8108a("Application context is not an Application");
        }
        this.f7353f.m8173a(new zzcin(this));
    }

    /* JADX INFO: renamed from: D */
    static void m8179D() {
        throw new IllegalStateException("Unexpected call on client side");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: H */
    public final void m8180H() {
        zzcho zzchoVarM8099C;
        String strConcat;
        m8235h().mo7855c();
        this.f7358k.m8261S();
        this.f7351d.m8261S();
        this.f7368u.m8261S();
        m8233f().m8099C().m8109a("App measurement is starting up, version", 11910L);
        m8233f().m8099C().m8108a("To enable debug logging run: adb shell setprop log.tag.FA VERBOSE");
        String strM8065z = this.f7368u.m8065z();
        if (m8242o().m8440j(strM8065z)) {
            zzchoVarM8099C = m8233f().m8099C();
            strConcat = "Faster debug mode event logging enabled. To disable, run:\n  adb shell setprop debug.firebase.analytics.app .none.";
        } else {
            zzchoVarM8099C = m8233f().m8099C();
            String strValueOf = String.valueOf(strM8065z);
            strConcat = strValueOf.length() != 0 ? "To enable faster debug mode event logging run:\n  adb shell setprop debug.firebase.analytics.app ".concat(strValueOf) : new String("To enable faster debug mode event logging run:\n  adb shell setprop debug.firebase.analytics.app ");
        }
        zzchoVarM8099C.m8108a(strConcat);
        m8233f().m8100D().m8108a("Debug-level message logging enabled");
        if (this.f7341H != this.f7342I) {
            m8233f().m8106y().m8110a("Not all components initialized", Integer.valueOf(this.f7341H), Integer.valueOf(this.f7342I));
        }
        this.f7373z = true;
    }

    /* JADX INFO: renamed from: I */
    private final zzchv m8181I() {
        if (this.f7369v == null) {
            throw new IllegalStateException("Network broadcast receiver not created");
        }
        return this.f7369v;
    }

    /* JADX INFO: renamed from: J */
    private final zzcll m8182J() {
        m8202b(this.f7370w);
        return this.f7370w;
    }

    /* JADX INFO: renamed from: K */
    private final boolean m8183K() {
        m8235h().mo7855c();
        try {
            this.f7338E = new RandomAccessFile(new File(this.f7349b.getFilesDir(), "google_app_measurement.db"), "rw").getChannel();
            this.f7337D = this.f7338E.tryLock();
        } catch (FileNotFoundException e) {
            m8233f().m8106y().m8109a("Failed to acquire storage lock", e);
        } catch (IOException e2) {
            m8233f().m8106y().m8109a("Failed to access storage lock file", e2);
        }
        if (this.f7337D != null) {
            m8233f().m8101E().m8108a("Storage concurrent access okay");
            return true;
        }
        m8233f().m8106y().m8108a("Storage concurrent data access panic");
        return false;
    }

    /* JADX INFO: renamed from: L */
    private final long m8184L() {
        long jMo7496a = this.f7363p.mo7496a();
        zzchx zzchxVarM8232e = m8232e();
        zzchxVarM8232e.m8259Q();
        zzchxVarM8232e.mo7855c();
        long jM8136a = zzchxVarM8232e.f7262g.m8136a();
        if (jM8136a == 0) {
            jM8136a = 1 + ((long) zzchxVarM8232e.mo7868p().m8444z().nextInt(86400000));
            zzchxVarM8232e.f7262g.m8137a(jM8136a);
        }
        return ((((jM8136a + jMo7496a) / 1000) / 60) / 60) / 24;
    }

    /* JADX INFO: renamed from: M */
    private final boolean m8185M() {
        m8235h().mo7855c();
        m8211a();
        return m8244q().m7974G() || !TextUtils.isEmpty(m8244q().m7969B());
    }

    /* JADX INFO: renamed from: N */
    private final void m8186N() {
        long jMax;
        long jMax2;
        m8235h().mo7855c();
        m8211a();
        if (m8187O()) {
            if (this.f7344K > 0) {
                long jAbs = 3600000 - Math.abs(this.f7363p.mo7497b() - this.f7344K);
                if (jAbs > 0) {
                    m8233f().m8101E().m8109a("Upload has been suspended. Will update scheduling later in approximately ms", Long.valueOf(jAbs));
                    m8181I().m8119b();
                    m8182J().m8382y();
                    return;
                }
                this.f7344K = 0L;
            }
            if (!m8227b() || !m8185M()) {
                m8233f().m8101E().m8108a("Nothing to upload or uploading impossible");
                m8181I().m8119b();
                m8182J().m8382y();
                return;
            }
            long jMo7496a = this.f7363p.mo7496a();
            long jMax3 = Math.max(0L, zzchc.f7162C.m8041b().longValue());
            boolean z = m8244q().m7975H() || m8244q().m7970C();
            if (z) {
                String strM7940A = this.f7350c.m7940A();
                jMax = (TextUtils.isEmpty(strM7940A) || ".none.".equals(strM7940A)) ? Math.max(0L, zzchc.f7197w.m8041b().longValue()) : Math.max(0L, zzchc.f7198x.m8041b().longValue());
            } else {
                jMax = Math.max(0L, zzchc.f7196v.m8041b().longValue());
            }
            long jM8136a = m8232e().f7258c.m8136a();
            long jM8136a2 = m8232e().f7259d.m8136a();
            long jMax4 = Math.max(m8244q().m7972E(), m8244q().m7973F());
            if (jMax4 == 0) {
                jMax2 = 0;
            } else {
                long jAbs2 = jMo7496a - Math.abs(jMax4 - jMo7496a);
                long jAbs3 = jMo7496a - Math.abs(jM8136a - jMo7496a);
                long jAbs4 = jMo7496a - Math.abs(jM8136a2 - jMo7496a);
                long jMax5 = Math.max(jAbs3, jAbs4);
                jMax2 = jAbs2 + jMax3;
                if (z && jMax5 > 0) {
                    jMax2 = Math.min(jAbs2, jMax5) + jMax;
                }
                if (!m8242o().m8427a(jMax5, jMax)) {
                    jMax2 = jMax5 + jMax;
                }
                if (jAbs4 != 0 && jAbs4 >= jAbs2) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= Math.min(20, Math.max(0, zzchc.f7164E.m8041b().intValue()))) {
                            jMax2 = 0;
                            break;
                        }
                        jMax2 += (1 << i2) * Math.max(0L, zzchc.f7163D.m8041b().longValue());
                        if (jMax2 > jAbs4) {
                            break;
                        } else {
                            i = i2 + 1;
                        }
                    }
                }
            }
            if (jMax2 == 0) {
                m8233f().m8101E().m8108a("Next upload time is 0");
                m8181I().m8119b();
                m8182J().m8382y();
                return;
            }
            if (!m8246s().m8115y()) {
                m8233f().m8101E().m8108a("No network");
                m8181I().m8118a();
                m8182J().m8382y();
                return;
            }
            long jM8136a3 = m8232e().f7260e.m8136a();
            long jMax6 = Math.max(0L, zzchc.f7194t.m8041b().longValue());
            long jMax7 = !m8242o().m8427a(jM8136a3, jMax6) ? Math.max(jMax2, jMax6 + jM8136a3) : jMax2;
            m8181I().m8119b();
            long jMo7496a2 = jMax7 - this.f7363p.mo7496a();
            if (jMo7496a2 <= 0) {
                jMo7496a2 = Math.max(0L, zzchc.f7199y.m8041b().longValue());
                m8232e().f7258c.m8137a(this.f7363p.mo7496a());
            }
            m8233f().m8101E().m8109a("Upload scheduled in approximately ms", Long.valueOf(jMo7496a2));
            m8182J().m8381a(jMo7496a2);
        }
    }

    /* JADX INFO: renamed from: O */
    private final boolean m8187O() {
        m8235h().mo7855c();
        m8211a();
        return this.f7334A;
    }

    /* JADX INFO: renamed from: P */
    private final void m8188P() {
        m8235h().mo7855c();
        if (this.f7345L || this.f7346M || this.f7347N) {
            m8233f().m8101E().m8111a("Not stopping services. fetch, network, upload", Boolean.valueOf(this.f7345L), Boolean.valueOf(this.f7346M), Boolean.valueOf(this.f7347N));
            return;
        }
        m8233f().m8101E().m8108a("Stopping uploading service(s)");
        if (this.f7340G != null) {
            Iterator<Runnable> it = this.f7340G.iterator();
            while (it.hasNext()) {
                it.next().run();
            }
            this.f7340G.clear();
        }
    }

    /* JADX INFO: renamed from: a */
    private final int m8189a(FileChannel fileChannel) {
        int i = 0;
        m8235h().mo7855c();
        if (fileChannel == null || !fileChannel.isOpen()) {
            m8233f().m8106y().m8108a("Bad chanel to read from");
        } else {
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(4);
            try {
                fileChannel.position(0L);
                int i2 = fileChannel.read(byteBufferAllocate);
                if (i2 == 4) {
                    byteBufferAllocate.flip();
                    i = byteBufferAllocate.getInt();
                } else if (i2 != -1) {
                    m8233f().m8097A().m8109a("Unexpected data length. Bytes read", Integer.valueOf(i2));
                }
            } catch (IOException e) {
                m8233f().m8106y().m8109a("Failed to read from channel", e);
            }
        }
        return i;
    }

    /* JADX INFO: renamed from: a */
    private final zzcgi m8190a(Context context, String str, String str2, boolean z, boolean z2) {
        String string;
        String installerPackageName = AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
        String str3 = AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
        int i = Integer.MIN_VALUE;
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            m8233f().m8106y().m8108a("PackageManager is null, can not log app install information");
            return null;
        }
        try {
            installerPackageName = packageManager.getInstallerPackageName(str);
        } catch (IllegalArgumentException e) {
            m8233f().m8106y().m8109a("Error retrieving installer package name. appId", zzchm.m8093a(str));
        }
        if (installerPackageName == null) {
            installerPackageName = "manual_install";
        } else if ("com.android.vending".equals(installerPackageName)) {
            installerPackageName = "";
        }
        try {
            PackageInfo packageInfoM7814b = zzbhf.m7816a(context).m7814b(str, 0);
            if (packageInfoM7814b != null) {
                CharSequence charSequenceM7815b = zzbhf.m7816a(context).m7815b(str);
                string = !TextUtils.isEmpty(charSequenceM7815b) ? charSequenceM7815b.toString() : AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
                try {
                    str3 = packageInfoM7814b.versionName;
                    i = packageInfoM7814b.versionCode;
                } catch (PackageManager.NameNotFoundException e2) {
                    m8233f().m8106y().m8110a("Error retrieving newly installed package info. appId, appName", zzchm.m8093a(str), string);
                    return null;
                }
            }
            return new zzcgi(str, str2, str3, i, installerPackageName, 11910L, m8242o().m8432b(context, str), (String) null, z, false, "", 0L, 0L, 0, z2);
        } catch (PackageManager.NameNotFoundException e3) {
            string = AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
        }
    }

    /* JADX INFO: renamed from: a */
    public static zzcim m8191a(Context context) {
        zzbq.m7373a(context);
        zzbq.m7373a(context.getApplicationContext());
        if (f7333a == null) {
            synchronized (zzcim.class) {
                if (f7333a == null) {
                    f7333a = new zzcim(new zzcjm(context));
                }
            }
        }
        return f7333a;
    }

    /* JADX INFO: renamed from: a */
    private final void m8192a(zzcgh zzcghVar) {
        ArrayMap arrayMap;
        m8235h().mo7855c();
        if (TextUtils.isEmpty(zzcghVar.m7888d())) {
            m8221a(zzcghVar.m7881b(), 204, (Throwable) null, (byte[]) null, (Map<String, List<String>>) null);
            return;
        }
        String strM7888d = zzcghVar.m7888d();
        String strM7885c = zzcghVar.m7885c();
        Uri.Builder builder = new Uri.Builder();
        Uri.Builder builderEncodedAuthority = builder.scheme(zzchc.f7181g.m8041b()).encodedAuthority(zzchc.f7182h.m8041b());
        String strValueOf = String.valueOf(strM7888d);
        builderEncodedAuthority.path(strValueOf.length() != 0 ? "config/app/".concat(strValueOf) : new String("config/app/")).appendQueryParameter("app_instance_id", strM7885c).appendQueryParameter(RobotHelper.FIELD_PLATFORM, "android").appendQueryParameter("gmp_version", "11910");
        String string = builder.build().toString();
        try {
            URL url = new URL(string);
            m8233f().m8101E().m8109a("Fetching remote configuration", zzcghVar.m7881b());
            zzcly zzclyVarM8152a = m8237j().m8152a(zzcghVar.m7881b());
            String strM8155b = m8237j().m8155b(zzcghVar.m7881b());
            if (zzclyVarM8152a == null || TextUtils.isEmpty(strM8155b)) {
                arrayMap = null;
            } else {
                ArrayMap arrayMap2 = new ArrayMap();
                arrayMap2.put(HttpHeaders.IF_MODIFIED_SINCE, strM8155b);
                arrayMap = arrayMap2;
            }
            this.f7345L = true;
            zzchq zzchqVarM8246s = m8246s();
            String strM7881b = zzcghVar.m7881b();
            zzciq zzciqVar = new zzciq(this);
            zzchqVarM8246s.mo7855c();
            zzchqVarM8246s.m8259Q();
            zzbq.m7373a(url);
            zzbq.m7373a(zzciqVar);
            zzchqVarM8246s.mo7871s().m8175b(new zzchu(zzchqVarM8246s, strM7881b, url, null, arrayMap, zzciqVar));
        } catch (MalformedURLException e) {
            m8233f().m8106y().m8110a("Failed to parse config URL. Not fetching. appId", zzchm.m8093a(zzcghVar.m7881b()), string);
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m8194a(zzcjk zzcjkVar) {
        if (zzcjkVar == null) {
            throw new IllegalStateException("Component not created");
        }
    }

    /* JADX INFO: renamed from: a */
    private final boolean m8195a(int i, FileChannel fileChannel) {
        m8235h().mo7855c();
        if (fileChannel == null || !fileChannel.isOpen()) {
            m8233f().m8106y().m8108a("Bad chanel to read from");
            return false;
        }
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(4);
        byteBufferAllocate.putInt(i);
        byteBufferAllocate.flip();
        try {
            fileChannel.truncate(0L);
            fileChannel.write(byteBufferAllocate);
            fileChannel.force(true);
            if (fileChannel.size() == 4) {
                return true;
            }
            m8233f().m8106y().m8109a("Error writing to channel. Bytes written", Long.valueOf(fileChannel.size()));
            return true;
        } catch (IOException e) {
            m8233f().m8106y().m8109a("Failed to write to channel", e);
            return false;
        }
    }

    /* JADX INFO: renamed from: a */
    private static boolean m8196a(zzcmb zzcmbVar, String str, Object obj) {
        if (TextUtils.isEmpty(str) || obj == null) {
            return false;
        }
        for (zzcmc zzcmcVar : zzcmbVar.f7663a) {
            if (str.equals(zzcmcVar.f7669a)) {
                return ((obj instanceof Long) && obj.equals(zzcmcVar.f7671c)) || ((obj instanceof String) && obj.equals(zzcmcVar.f7670b)) || ((obj instanceof Double) && obj.equals(zzcmcVar.f7672d));
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:124:0x0391 A[Catch: all -> 0x01be, TryCatch #8 {all -> 0x01be, blocks: (B:3:0x0007, B:16:0x0080, B:17:0x0083, B:19:0x0089, B:23:0x0096, B:24:0x00af, B:26:0x00b9, B:28:0x00d5, B:30:0x0110, B:34:0x0123, B:36:0x0137, B:120:0x0360, B:122:0x037c, B:173:0x05d2, B:124:0x0391, B:126:0x03a1, B:127:0x03b0, B:129:0x03c1, B:131:0x03cd, B:132:0x03d8, B:133:0x03dd, B:135:0x03e7, B:138:0x03f5, B:140:0x045b, B:141:0x04bf, B:143:0x04ec, B:144:0x04f7, B:146:0x04fc, B:148:0x050a, B:150:0x0513, B:151:0x051a, B:153:0x051d, B:154:0x0526, B:166:0x05a7, B:155:0x0528, B:158:0x053c, B:160:0x056a, B:162:0x0594, B:165:0x05a1, B:167:0x05ab, B:172:0x05c0, B:175:0x05ea, B:176:0x05f9, B:178:0x0613, B:180:0x061d, B:181:0x062b, B:183:0x0653, B:185:0x066f, B:188:0x069b, B:190:0x06a9, B:192:0x06c0, B:193:0x06d3, B:195:0x06d7, B:197:0x06e3, B:198:0x06f6, B:200:0x06fa, B:202:0x0702, B:203:0x0719, B:204:0x071d, B:205:0x0725, B:207:0x0736, B:209:0x074c, B:210:0x0766, B:212:0x0774, B:214:0x0788, B:215:0x07c0, B:218:0x07d0, B:220:0x07d9, B:222:0x07e3, B:224:0x07e7, B:226:0x07eb, B:228:0x07ef, B:230:0x0803, B:232:0x080d, B:234:0x082f, B:235:0x083c, B:236:0x0853, B:238:0x086a, B:240:0x08a3, B:241:0x08b4, B:242:0x08cb, B:244:0x08d1, B:246:0x08e4, B:248:0x08ed, B:249:0x08fb, B:250:0x0903, B:252:0x0909, B:253:0x091d, B:254:0x0935, B:256:0x093c, B:258:0x0954, B:259:0x095a, B:261:0x096c, B:262:0x0972, B:263:0x0975, B:265:0x0985, B:266:0x099c, B:268:0x09a3, B:270:0x09b3, B:295:0x0a8e, B:275:0x09cd, B:272:0x09b7, B:274:0x09c3, B:294:0x0a75, B:276:0x09d8, B:277:0x09eb, B:278:0x09f9, B:297:0x0a97, B:281:0x0a09, B:283:0x0a10, B:285:0x0a1a, B:286:0x0a1e, B:290:0x0a32, B:291:0x0a36, B:298:0x0aaa, B:48:0x01b9, B:84:0x02b6, B:106:0x032f, B:113:0x034e, B:97:0x02f6, B:89:0x02cf, B:116:0x0356, B:117:0x0359, B:63:0x0213, B:72:0x0241), top: B:321:0x0007, inners: #1, #7 }] */
    /* JADX WARN: Removed duplicated region for block: B:177:0x0610 A[PHI: r17
      0x0610: PHI (r17v4 boolean) = (r17v3 boolean), (r17v3 boolean), (r17v3 boolean), (r17v3 boolean), (r17v1 boolean) binds: [B:156:0x0538, B:157:0x053a, B:159:0x0568, B:176:0x05f9, B:123:0x038f] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x01a6 A[Catch: SQLiteException -> 0x02e0, all -> 0x0abb, TRY_LEAVE, TryCatch #9 {SQLiteException -> 0x02e0, all -> 0x0abb, blocks: (B:44:0x0181, B:46:0x01a6, B:71:0x0232, B:72:0x0241, B:73:0x0244, B:75:0x024a, B:76:0x025b, B:78:0x0269, B:79:0x027b, B:91:0x02d4, B:87:0x02bc), top: B:322:0x0181 }] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0231  */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final boolean m8197a(java.lang.String r31, long r32) {
        /*
            Method dump skipped, instruction units count: 2784
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzcim.m8197a(java.lang.String, long):boolean");
    }

    /* JADX INFO: renamed from: a */
    private final boolean m8198a(String str, zzcha zzchaVar) {
        long jLongValue;
        zzclp zzclpVar;
        String strM8034d = zzchaVar.f7157b.m8034d("currency");
        if ("ecommerce_purchase".equals(zzchaVar.f7156a)) {
            double dDoubleValue = zzchaVar.f7157b.m8033c("value").doubleValue() * 1000000.0d;
            if (dDoubleValue == 0.0d) {
                dDoubleValue = zzchaVar.f7157b.m8032b("value").longValue() * 1000000.0d;
            }
            if (dDoubleValue > 9.223372036854776E18d || dDoubleValue < -9.223372036854776E18d) {
                m8233f().m8097A().m8110a("Data lost. Currency value is too big. appId", zzchm.m8093a(str), Double.valueOf(dDoubleValue));
                return false;
            }
            jLongValue = Math.round(dDoubleValue);
        } else {
            jLongValue = zzchaVar.f7157b.m8032b("value").longValue();
        }
        if (!TextUtils.isEmpty(strM8034d)) {
            String upperCase = strM8034d.toUpperCase(Locale.US);
            if (upperCase.matches("[A-Z]{3}")) {
                String strValueOf = String.valueOf("_ltv_");
                String strValueOf2 = String.valueOf(upperCase);
                String strConcat = strValueOf2.length() != 0 ? strValueOf.concat(strValueOf2) : new String(strValueOf);
                zzclp zzclpVarM7997c = m8244q().m7997c(str, strConcat);
                if (zzclpVarM7997c == null || !(zzclpVarM7997c.f7610e instanceof Long)) {
                    zzcgo zzcgoVarM8244q = m8244q();
                    int iM7943b = this.f7350c.m7943b(str, zzchc.f7166G) - 1;
                    zzbq.m7375a(str);
                    zzcgoVarM8244q.mo7855c();
                    zzcgoVarM8244q.m8259Q();
                    try {
                        zzcgoVarM8244q.m7968A().execSQL("delete from user_attributes where app_id=? and name in (select name from user_attributes where app_id=? and name like '_ltv_%' order by set_timestamp desc limit ?,10);", new String[]{str, str, String.valueOf(iM7943b)});
                    } catch (SQLiteException e) {
                        zzcgoVarM8244q.mo7872t().m8106y().m8110a("Error pruning currencies. appId", zzchm.m8093a(str), e);
                    }
                    zzclpVar = new zzclp(str, zzchaVar.f7158c, strConcat, this.f7363p.mo7496a(), Long.valueOf(jLongValue));
                } else {
                    zzclpVar = new zzclp(str, zzchaVar.f7158c, strConcat, this.f7363p.mo7496a(), Long.valueOf(jLongValue + ((Long) zzclpVarM7997c.f7610e).longValue()));
                }
                if (!m8244q().m7991a(zzclpVar)) {
                    m8233f().m8106y().m8111a("Too many unique user properties are set. Ignoring user property. appId", zzchm.m8093a(str), m8243p().m8092c(zzclpVar.f7608c), zzclpVar.f7610e);
                    m8242o().m8426a(str, 9, (String) null, (String) null, 0);
                }
            }
        }
        return true;
    }

    /* JADX INFO: renamed from: a */
    private final zzcma[] m8199a(String str, zzcmg[] zzcmgVarArr, zzcmb[] zzcmbVarArr) {
        zzbq.m7375a(str);
        return m8253z().m7935a(str, zzcmbVarArr, zzcmgVarArr);
    }

    /* JADX INFO: renamed from: b */
    private final zzcgi m8200b(String str) {
        zzcgh zzcghVarM7993b = m8244q().m7993b(str);
        if (zzcghVarM7993b == null || TextUtils.isEmpty(zzcghVarM7993b.m7902i())) {
            m8233f().m8100D().m8109a("No app data available; dropping", str);
            return null;
        }
        try {
            String str2 = zzbhf.m7816a(this.f7349b).m7814b(str, 0).versionName;
            if (zzcghVarM7993b.m7902i() != null && !zzcghVarM7993b.m7902i().equals(str2)) {
                m8233f().m8097A().m8109a("App version does not match; dropping. appId", zzchm.m8093a(str));
                return null;
            }
        } catch (PackageManager.NameNotFoundException e) {
        }
        return new zzcgi(str, zzcghVarM7993b.m7888d(), zzcghVarM7993b.m7902i(), zzcghVarM7993b.m7904j(), zzcghVarM7993b.m7906k(), zzcghVarM7993b.m7908l(), zzcghVarM7993b.m7910m(), (String) null, zzcghVarM7993b.m7913n(), false, zzcghVarM7993b.m7894f(), zzcghVarM7993b.m7875A(), 0L, 0, zzcghVarM7993b.m7876B());
    }

    /* JADX WARN: Removed duplicated region for block: B:128:0x05ca A[Catch: all -> 0x0576, TryCatch #0 {all -> 0x0576, blocks: (B:30:0x0109, B:32:0x011c, B:38:0x0142, B:40:0x017a, B:42:0x0183, B:43:0x019a, B:46:0x01ac, B:48:0x01c2, B:50:0x01cb, B:51:0x01e2, B:54:0x0204, B:58:0x022e, B:59:0x0245, B:61:0x0255, B:63:0x0276, B:64:0x0298, B:66:0x02a6, B:67:0x02bb, B:69:0x02df, B:72:0x02ef, B:74:0x0325, B:75:0x033e, B:78:0x0395, B:81:0x03b2, B:83:0x03c2, B:85:0x03cc, B:87:0x03d2, B:88:0x03de, B:90:0x0429, B:92:0x042f, B:93:0x0435, B:95:0x0443, B:96:0x04bd, B:97:0x04df, B:99:0x04e5, B:117:0x0599, B:118:0x05a1, B:120:0x05a9, B:121:0x05af, B:123:0x05b5, B:126:0x05c4, B:128:0x05ca, B:129:0x05d0, B:131:0x05e2, B:135:0x0637, B:137:0x0658, B:134:0x0623, B:103:0x053f, B:105:0x054d, B:107:0x055d, B:108:0x0572, B:113:0x057f, B:115:0x0585, B:102:0x0535, B:101:0x052a, B:100:0x0519, B:34:0x0128, B:36:0x0132), top: B:142:0x0109, inners: #1 }] */
    /* JADX INFO: renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void m8201b(com.google.android.gms.internal.zzcha r31, com.google.android.gms.internal.zzcgi r32) {
        /*
            Method dump skipped, instruction units count: 1647
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzcim.m8201b(com.google.android.gms.internal.zzcha, com.google.android.gms.internal.zzcgi):void");
    }

    /* JADX INFO: renamed from: b */
    private static void m8202b(zzcjl zzcjlVar) {
        if (zzcjlVar == null) {
            throw new IllegalStateException("Component not created");
        }
        if (!zzcjlVar.m8258P()) {
            throw new IllegalStateException("Component not initialized");
        }
    }

    /* JADX INFO: renamed from: d */
    private final void m8203d(zzcgi zzcgiVar) {
        boolean z = true;
        m8235h().mo7855c();
        m8211a();
        zzbq.m7373a(zzcgiVar);
        zzbq.m7375a(zzcgiVar.f7087a);
        zzcgh zzcghVarM7993b = m8244q().m7993b(zzcgiVar.f7087a);
        String strM8127b = m8232e().m8127b(zzcgiVar.f7087a);
        boolean z2 = false;
        if (zzcghVarM7993b == null) {
            zzcgh zzcghVar = new zzcgh(this, zzcgiVar.f7087a);
            zzcghVar.m7879a(m8252y().m8064y());
            zzcghVar.m7887c(strM8127b);
            zzcghVarM7993b = zzcghVar;
            z2 = true;
        } else if (!strM8127b.equals(zzcghVarM7993b.m7891e())) {
            zzcghVarM7993b.m7887c(strM8127b);
            zzcghVarM7993b.m7879a(m8252y().m8064y());
            z2 = true;
        }
        if (!TextUtils.isEmpty(zzcgiVar.f7088b) && !zzcgiVar.f7088b.equals(zzcghVarM7993b.m7888d())) {
            zzcghVarM7993b.m7883b(zzcgiVar.f7088b);
            z2 = true;
        }
        if (!TextUtils.isEmpty(zzcgiVar.f7097k) && !zzcgiVar.f7097k.equals(zzcghVarM7993b.m7894f())) {
            zzcghVarM7993b.m7890d(zzcgiVar.f7097k);
            z2 = true;
        }
        if (zzcgiVar.f7091e != 0 && zzcgiVar.f7091e != zzcghVarM7993b.m7908l()) {
            zzcghVarM7993b.m7889d(zzcgiVar.f7091e);
            z2 = true;
        }
        if (!TextUtils.isEmpty(zzcgiVar.f7089c) && !zzcgiVar.f7089c.equals(zzcghVarM7993b.m7902i())) {
            zzcghVarM7993b.m7893e(zzcgiVar.f7089c);
            z2 = true;
        }
        if (zzcgiVar.f7096j != zzcghVarM7993b.m7904j()) {
            zzcghVarM7993b.m7886c(zzcgiVar.f7096j);
            z2 = true;
        }
        if (zzcgiVar.f7090d != null && !zzcgiVar.f7090d.equals(zzcghVarM7993b.m7906k())) {
            zzcghVarM7993b.m7896f(zzcgiVar.f7090d);
            z2 = true;
        }
        if (zzcgiVar.f7092f != zzcghVarM7993b.m7910m()) {
            zzcghVarM7993b.m7892e(zzcgiVar.f7092f);
            z2 = true;
        }
        if (zzcgiVar.f7094h != zzcghVarM7993b.m7913n()) {
            zzcghVarM7993b.m7880a(zzcgiVar.f7094h);
            z2 = true;
        }
        if (!TextUtils.isEmpty(zzcgiVar.f7093g) && !zzcgiVar.f7093g.equals(zzcghVarM7993b.m7925y())) {
            zzcghVarM7993b.m7899g(zzcgiVar.f7093g);
            z2 = true;
        }
        if (zzcgiVar.f7098l != zzcghVarM7993b.m7875A()) {
            zzcghVarM7993b.m7915o(zzcgiVar.f7098l);
            z2 = true;
        }
        if (zzcgiVar.f7101o != zzcghVarM7993b.m7876B()) {
            zzcghVarM7993b.m7884b(zzcgiVar.f7101o);
        } else {
            z = z2;
        }
        if (z) {
            m8244q().m7985a(zzcghVarM7993b);
        }
    }

    /* JADX INFO: renamed from: A */
    public final zzcgd m8204A() {
        m8194a(this.f7372y);
        return this.f7372y;
    }

    /* JADX INFO: renamed from: B */
    public final boolean m8205B() {
        boolean zBooleanValue = false;
        m8235h().mo7855c();
        m8211a();
        if (this.f7350c.m7947x()) {
            return false;
        }
        Boolean boolM7944b = this.f7350c.m7944b("firebase_analytics_collection_enabled");
        if (boolM7944b != null) {
            zBooleanValue = boolM7944b.booleanValue();
        } else if (!zzbz.m7158b()) {
            zBooleanValue = true;
        }
        return m8232e().m8130c(zBooleanValue);
    }

    /* JADX INFO: renamed from: C */
    final long m8206C() {
        Long lValueOf = Long.valueOf(m8232e().f7263h.m8136a());
        return lValueOf.longValue() == 0 ? this.f7348O : Math.min(this.f7348O, lValueOf.longValue());
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x018d A[Catch: all -> 0x029b, TryCatch #1 {all -> 0x029b, blocks: (B:3:0x000d, B:5:0x0017, B:8:0x002b, B:10:0x0031, B:12:0x0045, B:14:0x004d, B:16:0x0057, B:20:0x0065, B:23:0x007b, B:25:0x0085, B:27:0x009c, B:29:0x00bc, B:30:0x00d3, B:32:0x00e1, B:34:0x00e9, B:35:0x00f3, B:37:0x0116, B:38:0x011b, B:40:0x0121, B:42:0x0133, B:45:0x013a, B:47:0x0140, B:49:0x0152, B:51:0x015a, B:52:0x0160, B:54:0x017c, B:58:0x0188, B:60:0x018d, B:62:0x01cb, B:63:0x01d2, B:66:0x01de, B:68:0x01ea, B:69:0x01f3, B:70:0x0205, B:73:0x0211, B:75:0x0218, B:76:0x0225, B:78:0x0235, B:79:0x023c, B:82:0x0280, B:85:0x0289, B:64:0x01d6, B:91:0x02a5, B:93:0x02bb, B:95:0x02c5), top: B:102:0x000d, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x01db  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x01ea A[Catch: all -> 0x029b, TryCatch #1 {all -> 0x029b, blocks: (B:3:0x000d, B:5:0x0017, B:8:0x002b, B:10:0x0031, B:12:0x0045, B:14:0x004d, B:16:0x0057, B:20:0x0065, B:23:0x007b, B:25:0x0085, B:27:0x009c, B:29:0x00bc, B:30:0x00d3, B:32:0x00e1, B:34:0x00e9, B:35:0x00f3, B:37:0x0116, B:38:0x011b, B:40:0x0121, B:42:0x0133, B:45:0x013a, B:47:0x0140, B:49:0x0152, B:51:0x015a, B:52:0x0160, B:54:0x017c, B:58:0x0188, B:60:0x018d, B:62:0x01cb, B:63:0x01d2, B:66:0x01de, B:68:0x01ea, B:69:0x01f3, B:70:0x0205, B:73:0x0211, B:75:0x0218, B:76:0x0225, B:78:0x0235, B:79:0x023c, B:82:0x0280, B:85:0x0289, B:64:0x01d6, B:91:0x02a5, B:93:0x02bb, B:95:0x02c5), top: B:102:0x000d, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0210  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0218 A[Catch: MalformedURLException -> 0x0288, all -> 0x029b, TryCatch #0 {MalformedURLException -> 0x0288, blocks: (B:70:0x0205, B:73:0x0211, B:75:0x0218, B:76:0x0225, B:78:0x0235, B:79:0x023c, B:82:0x0280), top: B:100:0x0205, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0235 A[Catch: MalformedURLException -> 0x0288, all -> 0x029b, TryCatch #0 {MalformedURLException -> 0x0288, blocks: (B:70:0x0205, B:73:0x0211, B:75:0x0218, B:76:0x0225, B:78:0x0235, B:79:0x023c, B:82:0x0280), top: B:100:0x0205, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x027e  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0280 A[Catch: MalformedURLException -> 0x0288, all -> 0x029b, TRY_ENTER, TRY_LEAVE, TryCatch #0 {MalformedURLException -> 0x0288, blocks: (B:70:0x0205, B:73:0x0211, B:75:0x0218, B:76:0x0225, B:78:0x0235, B:79:0x023c, B:82:0x0280), top: B:100:0x0205, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x02c9  */
    /* JADX INFO: renamed from: E */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void m8207E() {
        /*
            Method dump skipped, instruction units count: 722
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzcim.m8207E():void");
    }

    /* JADX INFO: renamed from: F */
    final void m8208F() {
        this.f7342I++;
    }

    /* JADX INFO: renamed from: G */
    final void m8209G() {
        m8235h().mo7855c();
        m8211a();
        if (this.f7334A) {
            return;
        }
        m8233f().m8099C().m8108a("This instance being marked as an uploader");
        m8235h().mo7855c();
        m8211a();
        if (m8187O() && m8183K()) {
            int iM8189a = m8189a(this.f7338E);
            int iM8060B = m8252y().m8060B();
            m8235h().mo7855c();
            if (iM8189a > iM8060B) {
                m8233f().m8106y().m8110a("Panic: can't downgrade version. Previous, current version", Integer.valueOf(iM8189a), Integer.valueOf(iM8060B));
            } else if (iM8189a < iM8060B) {
                if (m8195a(iM8060B, this.f7338E)) {
                    m8233f().m8101E().m8110a("Storage version upgraded. Previous, current version", Integer.valueOf(iM8189a), Integer.valueOf(iM8060B));
                } else {
                    m8233f().m8106y().m8110a("Storage version upgrade failed. Previous, current version", Integer.valueOf(iM8189a), Integer.valueOf(iM8060B));
                }
            }
        }
        this.f7334A = true;
        m8186N();
    }

    /* JADX INFO: renamed from: a */
    public final String m8210a(String str) {
        try {
            return (String) m8235h().m8172a(new zzcio(this, str)).get(30000L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            m8233f().m8106y().m8110a("Failed to get app instance id. appId", zzchm.m8093a(str), e);
            return null;
        }
    }

    /* JADX INFO: renamed from: a */
    final void m8211a() {
        if (!this.f7373z) {
            throw new IllegalStateException("AppMeasurement is not initialized");
        }
    }

    /* JADX INFO: renamed from: a */
    protected final void m8212a(int i, Throwable th, byte[] bArr) {
        m8235h().mo7855c();
        m8211a();
        if (bArr == null) {
            try {
                bArr = new byte[0];
            } finally {
                this.f7346M = false;
                m8188P();
            }
        }
        List<Long> list = this.f7339F;
        this.f7339F = null;
        if ((i == 200 || i == 204) && th == null) {
            try {
                m8232e().f7258c.m8137a(this.f7363p.mo7496a());
                m8232e().f7259d.m8137a(0L);
                m8186N();
                m8233f().m8101E().m8110a("Successful upload. Got network response. code, size", Integer.valueOf(i), Integer.valueOf(bArr.length));
                m8244q().m8006x();
                try {
                    for (Long l : list) {
                        zzcgo zzcgoVarM8244q = m8244q();
                        long jLongValue = l.longValue();
                        zzcgoVarM8244q.mo7855c();
                        zzcgoVarM8244q.m8259Q();
                        try {
                            if (zzcgoVarM8244q.m7968A().delete("queue", "rowid=?", new String[]{String.valueOf(jLongValue)}) != 1) {
                                throw new SQLiteException("Deleted fewer rows from queue than expected");
                            }
                        } catch (SQLiteException e) {
                            zzcgoVarM8244q.mo7872t().m8106y().m8109a("Failed to delete a bundle in a queue table", e);
                            throw e;
                        }
                    }
                    m8244q().m8007y();
                    m8244q().m8008z();
                    if (m8246s().m8115y() && m8185M()) {
                        m8207E();
                    } else {
                        this.f7343J = -1L;
                        m8186N();
                    }
                    this.f7344K = 0L;
                } catch (Throwable th2) {
                    m8244q().m8008z();
                    throw th2;
                }
            } catch (SQLiteException e2) {
                m8233f().m8106y().m8109a("Database error while trying to delete uploaded bundles", e2);
                this.f7344K = this.f7363p.mo7497b();
                m8233f().m8101E().m8109a("Disable upload, time", Long.valueOf(this.f7344K));
            }
        } else {
            m8233f().m8101E().m8110a("Network upload failed. Will retry later. code, error", Integer.valueOf(i), th);
            m8232e().f7259d.m8137a(this.f7363p.mo7496a());
            if (i == 503 || i == 429) {
                m8232e().f7260e.m8137a(this.f7363p.mo7496a());
            }
            m8186N();
        }
    }

    /* JADX INFO: renamed from: a */
    final void m8213a(zzcgi zzcgiVar) throws PackageManager.NameNotFoundException {
        m8244q().m7993b(zzcgiVar.f7087a);
        zzcgo zzcgoVarM8244q = m8244q();
        String str = zzcgiVar.f7087a;
        zzbq.m7375a(str);
        zzcgoVarM8244q.mo7855c();
        zzcgoVarM8244q.m8259Q();
        try {
            SQLiteDatabase sQLiteDatabaseM7968A = zzcgoVarM8244q.m7968A();
            String[] strArr = {str};
            int iDelete = sQLiteDatabaseM7968A.delete("audience_filter_values", "app_id=?", strArr) + sQLiteDatabaseM7968A.delete("apps", "app_id=?", strArr) + 0 + sQLiteDatabaseM7968A.delete("events", "app_id=?", strArr) + sQLiteDatabaseM7968A.delete("user_attributes", "app_id=?", strArr) + sQLiteDatabaseM7968A.delete("conditional_properties", "app_id=?", strArr) + sQLiteDatabaseM7968A.delete("raw_events", "app_id=?", strArr) + sQLiteDatabaseM7968A.delete("raw_events_metadata", "app_id=?", strArr) + sQLiteDatabaseM7968A.delete("queue", "app_id=?", strArr);
            if (iDelete > 0) {
                zzcgoVarM8244q.mo7872t().m8101E().m8110a("Reset analytics data. app, records", str, Integer.valueOf(iDelete));
            }
        } catch (SQLiteException e) {
            zzcgoVarM8244q.mo7872t().m8106y().m8110a("Error resetting analytics data. appId, error", zzchm.m8093a(str), e);
        }
        m8230c(m8190a(this.f7349b, zzcgiVar.f7087a, zzcgiVar.f7088b, zzcgiVar.f7094h, zzcgiVar.f7101o));
    }

    /* JADX INFO: renamed from: a */
    final void m8214a(zzcgl zzcglVar) {
        zzcgi zzcgiVarM8200b = m8200b(zzcglVar.f7102a);
        if (zzcgiVarM8200b != null) {
            m8215a(zzcglVar, zzcgiVarM8200b);
        }
    }

    /* JADX INFO: renamed from: a */
    final void m8215a(zzcgl zzcglVar, zzcgi zzcgiVar) {
        boolean z = true;
        zzbq.m7373a(zzcglVar);
        zzbq.m7375a(zzcglVar.f7102a);
        zzbq.m7373a(zzcglVar.f7103b);
        zzbq.m7373a(zzcglVar.f7104c);
        zzbq.m7375a(zzcglVar.f7104c.f7598a);
        m8235h().mo7855c();
        m8211a();
        if (TextUtils.isEmpty(zzcgiVar.f7088b)) {
            return;
        }
        if (!zzcgiVar.f7094h) {
            m8203d(zzcgiVar);
            return;
        }
        zzcgl zzcglVar2 = new zzcgl(zzcglVar);
        zzcglVar2.f7106e = false;
        m8244q().m8006x();
        try {
            zzcgl zzcglVarM7998d = m8244q().m7998d(zzcglVar2.f7102a, zzcglVar2.f7104c.f7598a);
            if (zzcglVarM7998d != null && !zzcglVarM7998d.f7103b.equals(zzcglVar2.f7103b)) {
                m8233f().m8097A().m8111a("Updating a conditional user property with different origin. name, origin, origin (from DB)", m8243p().m8092c(zzcglVar2.f7104c.f7598a), zzcglVar2.f7103b, zzcglVarM7998d.f7103b);
            }
            if (zzcglVarM7998d != null && zzcglVarM7998d.f7106e) {
                zzcglVar2.f7103b = zzcglVarM7998d.f7103b;
                zzcglVar2.f7105d = zzcglVarM7998d.f7105d;
                zzcglVar2.f7109h = zzcglVarM7998d.f7109h;
                zzcglVar2.f7107f = zzcglVarM7998d.f7107f;
                zzcglVar2.f7110i = zzcglVarM7998d.f7110i;
                zzcglVar2.f7106e = zzcglVarM7998d.f7106e;
                zzcglVar2.f7104c = new zzcln(zzcglVar2.f7104c.f7598a, zzcglVarM7998d.f7104c.f7599b, zzcglVar2.f7104c.m8383a(), zzcglVarM7998d.f7104c.f7600c);
                z = false;
            } else if (TextUtils.isEmpty(zzcglVar2.f7107f)) {
                zzcglVar2.f7104c = new zzcln(zzcglVar2.f7104c.f7598a, zzcglVar2.f7105d, zzcglVar2.f7104c.m8383a(), zzcglVar2.f7104c.f7600c);
                zzcglVar2.f7106e = true;
            } else {
                z = false;
            }
            if (zzcglVar2.f7106e) {
                zzcln zzclnVar = zzcglVar2.f7104c;
                zzclp zzclpVar = new zzclp(zzcglVar2.f7102a, zzcglVar2.f7103b, zzclnVar.f7598a, zzclnVar.f7599b, zzclnVar.m8383a());
                if (m8244q().m7991a(zzclpVar)) {
                    m8233f().m8100D().m8111a("User property updated immediately", zzcglVar2.f7102a, m8243p().m8092c(zzclpVar.f7608c), zzclpVar.f7610e);
                } else {
                    m8233f().m8106y().m8111a("(2)Too many active user properties, ignoring", zzchm.m8093a(zzcglVar2.f7102a), m8243p().m8092c(zzclpVar.f7608c), zzclpVar.f7610e);
                }
                if (z && zzcglVar2.f7110i != null) {
                    m8201b(new zzcha(zzcglVar2.f7110i, zzcglVar2.f7105d), zzcgiVar);
                }
            }
            if (m8244q().m7989a(zzcglVar2)) {
                m8233f().m8100D().m8111a("Conditional property added", zzcglVar2.f7102a, m8243p().m8092c(zzcglVar2.f7104c.f7598a), zzcglVar2.f7104c.m8383a());
            } else {
                m8233f().m8106y().m8111a("Too many conditional properties, ignoring", zzchm.m8093a(zzcglVar2.f7102a), m8243p().m8092c(zzcglVar2.f7104c.f7598a), zzcglVar2.f7104c.m8383a());
            }
            m8244q().m8007y();
        } finally {
            m8244q().m8008z();
        }
    }

    /* JADX INFO: renamed from: a */
    final void m8216a(zzcha zzchaVar, zzcgi zzcgiVar) {
        List<zzcgl> listM7984a;
        List<zzcgl> listM7984a2;
        List<zzcgl> listM7984a3;
        zzbq.m7373a(zzcgiVar);
        zzbq.m7375a(zzcgiVar.f7087a);
        m8235h().mo7855c();
        m8211a();
        String str = zzcgiVar.f7087a;
        long j = zzchaVar.f7159d;
        m8242o();
        if (zzclq.m8393a(zzchaVar, zzcgiVar)) {
            if (!zzcgiVar.f7094h) {
                m8203d(zzcgiVar);
                return;
            }
            m8244q().m8006x();
            try {
                zzcgo zzcgoVarM8244q = m8244q();
                zzbq.m7375a(str);
                zzcgoVarM8244q.mo7855c();
                zzcgoVarM8244q.m8259Q();
                if (j < 0) {
                    zzcgoVarM8244q.mo7872t().m8097A().m8110a("Invalid time querying timed out conditional properties", zzchm.m8093a(str), Long.valueOf(j));
                    listM7984a = Collections.emptyList();
                } else {
                    listM7984a = zzcgoVarM8244q.m7984a("active=0 and app_id=? and abs(? - creation_timestamp) > trigger_timeout", new String[]{str, String.valueOf(j)});
                }
                for (zzcgl zzcglVar : listM7984a) {
                    if (zzcglVar != null) {
                        m8233f().m8100D().m8111a("User property timed out", zzcglVar.f7102a, m8243p().m8092c(zzcglVar.f7104c.f7598a), zzcglVar.f7104c.m8383a());
                        if (zzcglVar.f7108g != null) {
                            m8201b(new zzcha(zzcglVar.f7108g, j), zzcgiVar);
                        }
                        m8244q().m8000e(str, zzcglVar.f7104c.f7598a);
                    }
                }
                zzcgo zzcgoVarM8244q2 = m8244q();
                zzbq.m7375a(str);
                zzcgoVarM8244q2.mo7855c();
                zzcgoVarM8244q2.m8259Q();
                if (j < 0) {
                    zzcgoVarM8244q2.mo7872t().m8097A().m8110a("Invalid time querying expired conditional properties", zzchm.m8093a(str), Long.valueOf(j));
                    listM7984a2 = Collections.emptyList();
                } else {
                    listM7984a2 = zzcgoVarM8244q2.m7984a("active<>0 and app_id=? and abs(? - triggered_timestamp) > time_to_live", new String[]{str, String.valueOf(j)});
                }
                ArrayList arrayList = new ArrayList(listM7984a2.size());
                for (zzcgl zzcglVar2 : listM7984a2) {
                    if (zzcglVar2 != null) {
                        m8233f().m8100D().m8111a("User property expired", zzcglVar2.f7102a, m8243p().m8092c(zzcglVar2.f7104c.f7598a), zzcglVar2.f7104c.m8383a());
                        m8244q().m7995b(str, zzcglVar2.f7104c.f7598a);
                        if (zzcglVar2.f7112k != null) {
                            arrayList.add(zzcglVar2.f7112k);
                        }
                        m8244q().m8000e(str, zzcglVar2.f7104c.f7598a);
                    }
                }
                ArrayList arrayList2 = arrayList;
                int size = arrayList2.size();
                int i = 0;
                while (i < size) {
                    Object obj = arrayList2.get(i);
                    i++;
                    m8201b(new zzcha((zzcha) obj, j), zzcgiVar);
                }
                zzcgo zzcgoVarM8244q3 = m8244q();
                String str2 = zzchaVar.f7156a;
                zzbq.m7375a(str);
                zzbq.m7375a(str2);
                zzcgoVarM8244q3.mo7855c();
                zzcgoVarM8244q3.m8259Q();
                if (j < 0) {
                    zzcgoVarM8244q3.mo7872t().m8097A().m8111a("Invalid time querying triggered conditional properties", zzchm.m8093a(str), zzcgoVarM8244q3.mo7867o().m8090a(str2), Long.valueOf(j));
                    listM7984a3 = Collections.emptyList();
                } else {
                    listM7984a3 = zzcgoVarM8244q3.m7984a("active=0 and app_id=? and trigger_event_name=? and abs(? - creation_timestamp) <= trigger_timeout", new String[]{str, str2, String.valueOf(j)});
                }
                ArrayList arrayList3 = new ArrayList(listM7984a3.size());
                for (zzcgl zzcglVar3 : listM7984a3) {
                    if (zzcglVar3 != null) {
                        zzcln zzclnVar = zzcglVar3.f7104c;
                        zzclp zzclpVar = new zzclp(zzcglVar3.f7102a, zzcglVar3.f7103b, zzclnVar.f7598a, j, zzclnVar.m8383a());
                        if (m8244q().m7991a(zzclpVar)) {
                            m8233f().m8100D().m8111a("User property triggered", zzcglVar3.f7102a, m8243p().m8092c(zzclpVar.f7608c), zzclpVar.f7610e);
                        } else {
                            m8233f().m8106y().m8111a("Too many active user properties, ignoring", zzchm.m8093a(zzcglVar3.f7102a), m8243p().m8092c(zzclpVar.f7608c), zzclpVar.f7610e);
                        }
                        if (zzcglVar3.f7110i != null) {
                            arrayList3.add(zzcglVar3.f7110i);
                        }
                        zzcglVar3.f7104c = new zzcln(zzclpVar);
                        zzcglVar3.f7106e = true;
                        m8244q().m7989a(zzcglVar3);
                    }
                }
                m8201b(zzchaVar, zzcgiVar);
                ArrayList arrayList4 = arrayList3;
                int size2 = arrayList4.size();
                int i2 = 0;
                while (i2 < size2) {
                    Object obj2 = arrayList4.get(i2);
                    i2++;
                    m8201b(new zzcha((zzcha) obj2, j), zzcgiVar);
                }
                m8244q().m8007y();
            } finally {
                m8244q().m8008z();
            }
        }
    }

    /* JADX INFO: renamed from: a */
    final void m8217a(zzcha zzchaVar, String str) {
        zzcgh zzcghVarM7993b = m8244q().m7993b(str);
        if (zzcghVarM7993b == null || TextUtils.isEmpty(zzcghVarM7993b.m7902i())) {
            m8233f().m8100D().m8109a("No app data available; dropping event", str);
            return;
        }
        try {
            String str2 = zzbhf.m7816a(this.f7349b).m7814b(str, 0).versionName;
            if (zzcghVarM7993b.m7902i() != null && !zzcghVarM7993b.m7902i().equals(str2)) {
                m8233f().m8097A().m8109a("App version does not match; dropping event. appId", zzchm.m8093a(str));
                return;
            }
        } catch (PackageManager.NameNotFoundException e) {
            if (!"_ui".equals(zzchaVar.f7156a)) {
                m8233f().m8097A().m8109a("Could not find package. appId", zzchm.m8093a(str));
            }
        }
        m8216a(zzchaVar, new zzcgi(str, zzcghVarM7993b.m7888d(), zzcghVarM7993b.m7902i(), zzcghVarM7993b.m7904j(), zzcghVarM7993b.m7906k(), zzcghVarM7993b.m7908l(), zzcghVarM7993b.m7910m(), (String) null, zzcghVarM7993b.m7913n(), false, zzcghVarM7993b.m7894f(), zzcghVarM7993b.m7875A(), 0L, 0, zzcghVarM7993b.m7876B()));
    }

    /* JADX INFO: renamed from: a */
    final void m8218a(zzcjl zzcjlVar) {
        this.f7341H++;
    }

    /* JADX INFO: renamed from: a */
    final void m8219a(zzcln zzclnVar, zzcgi zzcgiVar) {
        m8235h().mo7855c();
        m8211a();
        if (TextUtils.isEmpty(zzcgiVar.f7088b)) {
            return;
        }
        if (!zzcgiVar.f7094h) {
            m8203d(zzcgiVar);
            return;
        }
        int iM8437e = m8242o().m8437e(zzclnVar.f7598a);
        if (iM8437e != 0) {
            m8242o();
            m8242o().m8426a(zzcgiVar.f7087a, iM8437e, "_ev", zzclq.m8387a(zzclnVar.f7598a, 24, true), zzclnVar.f7598a != null ? zzclnVar.f7598a.length() : 0);
            return;
        }
        int iM8431b = m8242o().m8431b(zzclnVar.f7598a, zzclnVar.m8383a());
        if (iM8431b != 0) {
            m8242o();
            String strM8387a = zzclq.m8387a(zzclnVar.f7598a, 24, true);
            Object objM8383a = zzclnVar.m8383a();
            if (objM8383a != null && ((objM8383a instanceof String) || (objM8383a instanceof CharSequence))) {
                length = String.valueOf(objM8383a).length();
            }
            m8242o().m8426a(zzcgiVar.f7087a, iM8431b, "_ev", strM8387a, length);
            return;
        }
        Object objM8435c = m8242o().m8435c(zzclnVar.f7598a, zzclnVar.m8383a());
        if (objM8435c != null) {
            zzclp zzclpVar = new zzclp(zzcgiVar.f7087a, zzclnVar.f7600c, zzclnVar.f7598a, zzclnVar.f7599b, objM8435c);
            m8233f().m8100D().m8110a("Setting user property", m8243p().m8092c(zzclpVar.f7608c), objM8435c);
            m8244q().m8006x();
            try {
                m8203d(zzcgiVar);
                boolean zM7991a = m8244q().m7991a(zzclpVar);
                m8244q().m8007y();
                if (zM7991a) {
                    m8233f().m8100D().m8110a("User property set", m8243p().m8092c(zzclpVar.f7608c), zzclpVar.f7610e);
                } else {
                    m8233f().m8106y().m8110a("Too many unique user properties are set. Ignoring user property", m8243p().m8092c(zzclpVar.f7608c), zzclpVar.f7610e);
                    m8242o().m8426a(zzcgiVar.f7087a, 9, (String) null, (String) null, 0);
                }
            } finally {
                m8244q().m8008z();
            }
        }
    }

    /* JADX INFO: renamed from: a */
    final void m8220a(Runnable runnable) {
        m8235h().mo7855c();
        if (this.f7340G == null) {
            this.f7340G = new ArrayList();
        }
        this.f7340G.add(runnable);
    }

    /* JADX INFO: renamed from: a */
    final void m8221a(String str, int i, Throwable th, byte[] bArr, Map<String, List<String>> map) {
        boolean z = true;
        m8235h().mo7855c();
        m8211a();
        zzbq.m7375a(str);
        if (bArr == null) {
            try {
                bArr = new byte[0];
            } finally {
                this.f7345L = false;
                m8188P();
            }
        }
        m8233f().m8101E().m8109a("onConfigFetched. Response size", Integer.valueOf(bArr.length));
        m8244q().m8006x();
        try {
            zzcgh zzcghVarM7993b = m8244q().m7993b(str);
            boolean z2 = (i == 200 || i == 204 || i == 304) && th == null;
            if (zzcghVarM7993b == null) {
                m8233f().m8097A().m8109a("App does not exist in onConfigFetched. appId", zzchm.m8093a(str));
            } else if (z2 || i == 404) {
                List<String> list = map != null ? map.get(HttpHeaders.LAST_MODIFIED) : null;
                String str2 = (list == null || list.size() <= 0) ? null : list.get(0);
                if (i == 404 || i == 304) {
                    if (m8237j().m8152a(str) == null && !m8237j().m8154a(str, null, null)) {
                        return;
                    }
                } else if (!m8237j().m8154a(str, bArr, str2)) {
                    return;
                }
                zzcghVarM7993b.m7898g(this.f7363p.mo7496a());
                m8244q().m7985a(zzcghVarM7993b);
                if (i == 404) {
                    m8233f().m8098B().m8109a("Config not found. Using empty config. appId", str);
                } else {
                    m8233f().m8101E().m8110a("Successfully fetched config. Got network response. code, size", Integer.valueOf(i), Integer.valueOf(bArr.length));
                }
                if (m8246s().m8115y() && m8185M()) {
                    m8207E();
                } else {
                    m8186N();
                }
            } else {
                zzcghVarM7993b.m7901h(this.f7363p.mo7496a());
                m8244q().m7985a(zzcghVarM7993b);
                m8233f().m8101E().m8110a("Fetching config failed. code, error", Integer.valueOf(i), th);
                m8237j().m8157c(str);
                m8232e().f7259d.m8137a(this.f7363p.mo7496a());
                if (i != 503 && i != 429) {
                    z = false;
                }
                if (z) {
                    m8232e().f7260e.m8137a(this.f7363p.mo7496a());
                }
                m8186N();
            }
            m8244q().m8007y();
        } finally {
            m8244q().m8008z();
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m8222a(boolean z) {
        m8186N();
    }

    /* JADX INFO: renamed from: b */
    final void m8223b(zzcgi zzcgiVar) {
        m8235h().mo7855c();
        m8211a();
        zzbq.m7375a(zzcgiVar.f7087a);
        m8203d(zzcgiVar);
    }

    /* JADX INFO: renamed from: b */
    final void m8224b(zzcgl zzcglVar) {
        zzcgi zzcgiVarM8200b = m8200b(zzcglVar.f7102a);
        if (zzcgiVarM8200b != null) {
            m8225b(zzcglVar, zzcgiVarM8200b);
        }
    }

    /* JADX INFO: renamed from: b */
    final void m8225b(zzcgl zzcglVar, zzcgi zzcgiVar) {
        zzbq.m7373a(zzcglVar);
        zzbq.m7375a(zzcglVar.f7102a);
        zzbq.m7373a(zzcglVar.f7104c);
        zzbq.m7375a(zzcglVar.f7104c.f7598a);
        m8235h().mo7855c();
        m8211a();
        if (TextUtils.isEmpty(zzcgiVar.f7088b)) {
            return;
        }
        if (!zzcgiVar.f7094h) {
            m8203d(zzcgiVar);
            return;
        }
        m8244q().m8006x();
        try {
            m8203d(zzcgiVar);
            zzcgl zzcglVarM7998d = m8244q().m7998d(zzcglVar.f7102a, zzcglVar.f7104c.f7598a);
            if (zzcglVarM7998d != null) {
                m8233f().m8100D().m8110a("Removing conditional user property", zzcglVar.f7102a, m8243p().m8092c(zzcglVar.f7104c.f7598a));
                m8244q().m8000e(zzcglVar.f7102a, zzcglVar.f7104c.f7598a);
                if (zzcglVarM7998d.f7106e) {
                    m8244q().m7995b(zzcglVar.f7102a, zzcglVar.f7104c.f7598a);
                }
                if (zzcglVar.f7112k != null) {
                    m8201b(m8242o().m8420a(zzcglVar.f7112k.f7156a, zzcglVar.f7112k.f7157b != null ? zzcglVar.f7112k.f7157b.m8031b() : null, zzcglVarM7998d.f7103b, zzcglVar.f7112k.f7159d, true, false), zzcgiVar);
                }
            } else {
                m8233f().m8097A().m8110a("Conditional user property doesn't exist", zzchm.m8093a(zzcglVar.f7102a), m8243p().m8092c(zzcglVar.f7104c.f7598a));
            }
            m8244q().m8007y();
        } finally {
            m8244q().m8008z();
        }
    }

    /* JADX INFO: renamed from: b */
    final void m8226b(zzcln zzclnVar, zzcgi zzcgiVar) {
        m8235h().mo7855c();
        m8211a();
        if (TextUtils.isEmpty(zzcgiVar.f7088b)) {
            return;
        }
        if (!zzcgiVar.f7094h) {
            m8203d(zzcgiVar);
            return;
        }
        m8233f().m8100D().m8109a("Removing user property", m8243p().m8092c(zzclnVar.f7598a));
        m8244q().m8006x();
        try {
            m8203d(zzcgiVar);
            m8244q().m7995b(zzcgiVar.f7087a, zzclnVar.f7598a);
            m8244q().m8007y();
            m8233f().m8100D().m8109a("User property removed", m8243p().m8092c(zzclnVar.f7598a));
        } finally {
            m8244q().m8008z();
        }
    }

    /* JADX INFO: renamed from: b */
    protected final boolean m8227b() {
        boolean z = false;
        m8211a();
        m8235h().mo7855c();
        if (this.f7335B == null || this.f7336C == 0 || (this.f7335B != null && !this.f7335B.booleanValue() && Math.abs(this.f7363p.mo7497b() - this.f7336C) > 1000)) {
            this.f7336C = this.f7363p.mo7497b();
            if (m8242o().m8439h("android.permission.INTERNET") && m8242o().m8439h("android.permission.ACCESS_NETWORK_STATE") && (zzbhf.m7816a(this.f7349b).m7811a() || (zzcid.m8144a(this.f7349b) && zzcla.m8353a(this.f7349b, false)))) {
                z = true;
            }
            this.f7335B = Boolean.valueOf(z);
            if (this.f7335B.booleanValue()) {
                this.f7335B = Boolean.valueOf(m8242o().m8438f(m8252y().m8059A()));
            }
        }
        return this.f7335B.booleanValue();
    }

    /* JADX INFO: renamed from: b */
    public final byte[] m8228b(zzcha zzchaVar, String str) {
        long j;
        m8211a();
        m8235h().mo7855c();
        m8179D();
        zzbq.m7373a(zzchaVar);
        zzbq.m7375a(str);
        zzcmd zzcmdVar = new zzcmd();
        m8244q().m8006x();
        try {
            zzcgh zzcghVarM7993b = m8244q().m7993b(str);
            if (zzcghVarM7993b == null) {
                m8233f().m8100D().m8109a("Log and bundle not available. package_name", str);
                return new byte[0];
            }
            if (!zzcghVarM7993b.m7913n()) {
                m8233f().m8100D().m8109a("Log and bundle disabled. package_name", str);
                return new byte[0];
            }
            if (("_iap".equals(zzchaVar.f7156a) || "ecommerce_purchase".equals(zzchaVar.f7156a)) && !m8198a(str, zzchaVar)) {
                m8233f().m8097A().m8109a("Failed to handle purchase event at single event bundle creation. appId", zzchm.m8093a(str));
            }
            zzcme zzcmeVar = new zzcme();
            zzcmdVar.f7674a = new zzcme[]{zzcmeVar};
            zzcmeVar.f7685a = 1;
            zzcmeVar.f7693i = "android";
            zzcmeVar.f7699o = zzcghVarM7993b.m7881b();
            zzcmeVar.f7698n = zzcghVarM7993b.m7906k();
            zzcmeVar.f7700p = zzcghVarM7993b.m7902i();
            long jM7904j = zzcghVarM7993b.m7904j();
            zzcmeVar.f7678C = jM7904j == -2147483648L ? null : Integer.valueOf((int) jM7904j);
            zzcmeVar.f7701q = Long.valueOf(zzcghVarM7993b.m7908l());
            zzcmeVar.f7709y = zzcghVarM7993b.m7888d();
            zzcmeVar.f7706v = Long.valueOf(zzcghVarM7993b.m7910m());
            if (m8205B() && zzcgn.m7937B() && this.f7350c.m7945c(zzcmeVar.f7699o)) {
                m8252y();
                zzcmeVar.f7682G = null;
            }
            Pair<String, Boolean> pairM8125a = m8232e().m8125a(zzcghVarM7993b.m7881b());
            if (zzcghVarM7993b.m7876B() && pairM8125a != null && !TextUtils.isEmpty((CharSequence) pairM8125a.first)) {
                zzcmeVar.f7703s = (String) pairM8125a.first;
                zzcmeVar.f7704t = (Boolean) pairM8125a.second;
            }
            m8251x().m8259Q();
            zzcmeVar.f7695k = Build.MODEL;
            m8251x().m8259Q();
            zzcmeVar.f7694j = Build.VERSION.RELEASE;
            zzcmeVar.f7697m = Integer.valueOf((int) m8251x().m8020x());
            zzcmeVar.f7696l = m8251x().m8021y();
            zzcmeVar.f7705u = zzcghVarM7993b.m7885c();
            zzcmeVar.f7677B = zzcghVarM7993b.m7894f();
            List<zzclp> listM7981a = m8244q().m7981a(zzcghVarM7993b.m7881b());
            zzcmeVar.f7687c = new zzcmg[listM7981a.size()];
            for (int i = 0; i < listM7981a.size(); i++) {
                zzcmg zzcmgVar = new zzcmg();
                zzcmeVar.f7687c[i] = zzcmgVar;
                zzcmgVar.f7715b = listM7981a.get(i).f7608c;
                zzcmgVar.f7714a = Long.valueOf(listM7981a.get(i).f7609d);
                m8242o().m8425a(zzcmgVar, listM7981a.get(i).f7610e);
            }
            Bundle bundleM8031b = zzchaVar.f7157b.m8031b();
            if ("_iap".equals(zzchaVar.f7156a)) {
                bundleM8031b.putLong("_c", 1L);
                m8233f().m8100D().m8108a("Marking in-app purchase as real-time");
                bundleM8031b.putLong("_r", 1L);
            }
            bundleM8031b.putString("_o", zzchaVar.f7158c);
            if (m8242o().m8440j(zzcmeVar.f7699o)) {
                m8242o().m8423a(bundleM8031b, "_dbg", (Object) 1L);
                m8242o().m8423a(bundleM8031b, "_r", (Object) 1L);
            }
            zzcgw zzcgwVarM7979a = m8244q().m7979a(str, zzchaVar.f7156a);
            if (zzcgwVarM7979a == null) {
                m8244q().m7986a(new zzcgw(str, zzchaVar.f7156a, 1L, 0L, zzchaVar.f7159d, 0L, null, null, null));
                j = 0;
            } else {
                j = zzcgwVarM7979a.f7148e;
                m8244q().m7986a(zzcgwVarM7979a.m8025a(zzchaVar.f7159d).m8024a());
            }
            zzcgv zzcgvVar = new zzcgv(this, zzchaVar.f7158c, str, zzchaVar.f7156a, zzchaVar.f7159d, j, bundleM8031b);
            zzcmb zzcmbVar = new zzcmb();
            zzcmeVar.f7686b = new zzcmb[]{zzcmbVar};
            zzcmbVar.f7665c = Long.valueOf(zzcgvVar.f7140c);
            zzcmbVar.f7664b = zzcgvVar.f7139b;
            zzcmbVar.f7666d = Long.valueOf(zzcgvVar.f7141d);
            zzcmbVar.f7663a = new zzcmc[zzcgvVar.f7142e.m8029a()];
            int i2 = 0;
            for (String str2 : zzcgvVar.f7142e) {
                zzcmc zzcmcVar = new zzcmc();
                zzcmbVar.f7663a[i2] = zzcmcVar;
                zzcmcVar.f7669a = str2;
                m8242o().m8424a(zzcmcVar, zzcgvVar.f7142e.m8030a(str2));
                i2++;
            }
            zzcmeVar.f7676A = m8199a(zzcghVarM7993b.m7881b(), zzcmeVar.f7687c, zzcmeVar.f7686b);
            zzcmeVar.f7689e = zzcmbVar.f7665c;
            zzcmeVar.f7690f = zzcmbVar.f7665c;
            long jM7900h = zzcghVarM7993b.m7900h();
            zzcmeVar.f7692h = jM7900h != 0 ? Long.valueOf(jM7900h) : null;
            long jM7897g = zzcghVarM7993b.m7897g();
            if (jM7897g != 0) {
                jM7900h = jM7897g;
            }
            zzcmeVar.f7691g = jM7900h != 0 ? Long.valueOf(jM7900h) : null;
            zzcghVarM7993b.m7918r();
            zzcmeVar.f7707w = Integer.valueOf((int) zzcghVarM7993b.m7914o());
            zzcmeVar.f7702r = 11910L;
            zzcmeVar.f7688d = Long.valueOf(this.f7363p.mo7496a());
            zzcmeVar.f7710z = Boolean.TRUE;
            zzcghVarM7993b.m7878a(zzcmeVar.f7689e.longValue());
            zzcghVarM7993b.m7882b(zzcmeVar.f7690f.longValue());
            m8244q().m7985a(zzcghVarM7993b);
            m8244q().m8007y();
            try {
                byte[] bArr = new byte[zzcmdVar.m8713f()];
                zzfjk zzfjkVarM8648a = zzfjk.m8648a(bArr, 0, bArr.length);
                zzcmdVar.mo8447a(zzfjkVarM8648a);
                zzfjkVarM8648a.m8664a();
                return m8242o().m8429a(bArr);
            } catch (IOException e) {
                m8233f().m8106y().m8110a("Data loss. Failed to bundle and serialize. appId", zzchm.m8093a(str), e);
                return null;
            }
        } finally {
            m8244q().m8008z();
        }
    }

    /* JADX INFO: renamed from: c */
    protected final void m8229c() {
        m8235h().mo7855c();
        m8244q().m7971D();
        if (m8232e().f7258c.m8136a() == 0) {
            m8232e().f7258c.m8137a(this.f7363p.mo7496a());
        }
        if (Long.valueOf(m8232e().f7263h.m8136a()).longValue() == 0) {
            m8233f().m8101E().m8109a("Persisting first open", Long.valueOf(this.f7348O));
            m8232e().f7263h.m8137a(this.f7348O);
        }
        if (m8227b()) {
            if (!TextUtils.isEmpty(m8252y().m8059A())) {
                String strM8132y = m8232e().m8132y();
                if (strM8132y == null) {
                    m8232e().m8129c(m8252y().m8059A());
                } else if (!strM8132y.equals(m8252y().m8059A())) {
                    m8233f().m8099C().m8108a("Rechecking which service to use due to a GMP App Id change");
                    m8232e().m8123B();
                    this.f7365r.m8336E();
                    this.f7365r.m8334C();
                    m8232e().m8129c(m8252y().m8059A());
                    m8232e().f7263h.m8137a(this.f7348O);
                    m8232e().f7264i.m8143a(null);
                }
            }
            m8239l().m8288a(m8232e().f7264i.m8142a());
            if (!TextUtils.isEmpty(m8252y().m8059A())) {
                zzcjn zzcjnVarM8239l = m8239l();
                zzcjnVarM8239l.mo7855c();
                zzcjnVarM8239l.m8259Q();
                if (zzcjnVarM8239l.f7441p.m8227b()) {
                    zzcjnVarM8239l.mo7861i().m8333B();
                    String strM8124C = zzcjnVarM8239l.mo7873u().m8124C();
                    if (!TextUtils.isEmpty(strM8124C)) {
                        zzcjnVarM8239l.mo7860h().m8259Q();
                        if (!strM8124C.equals(Build.VERSION.RELEASE)) {
                            Bundle bundle = new Bundle();
                            bundle.putString("_po", strM8124C);
                            zzcjnVarM8239l.m8289a("auto", "_ou", bundle);
                        }
                    }
                }
                m8250w().m8343a(new AtomicReference<>());
            }
        } else if (m8205B()) {
            if (!m8242o().m8439h("android.permission.INTERNET")) {
                m8233f().m8106y().m8108a("App is missing INTERNET permission");
            }
            if (!m8242o().m8439h("android.permission.ACCESS_NETWORK_STATE")) {
                m8233f().m8106y().m8108a("App is missing ACCESS_NETWORK_STATE permission");
            }
            if (!zzbhf.m7816a(this.f7349b).m7811a()) {
                if (!zzcid.m8144a(this.f7349b)) {
                    m8233f().m8106y().m8108a("AppMeasurementReceiver not registered/enabled");
                }
                if (!zzcla.m8353a(this.f7349b, false)) {
                    m8233f().m8106y().m8108a("AppMeasurementService not registered/enabled");
                }
            }
            m8233f().m8106y().m8108a("Uploading is not possible. App measurement disabled");
        }
        m8186N();
    }

    /* JADX INFO: renamed from: c */
    public final void m8230c(zzcgi zzcgiVar) throws PackageManager.NameNotFoundException {
        int i;
        ApplicationInfo applicationInfoM7810a;
        m8235h().mo7855c();
        m8211a();
        zzbq.m7373a(zzcgiVar);
        zzbq.m7375a(zzcgiVar.f7087a);
        if (TextUtils.isEmpty(zzcgiVar.f7088b)) {
            return;
        }
        zzcgh zzcghVarM7993b = m8244q().m7993b(zzcgiVar.f7087a);
        if (zzcghVarM7993b != null && TextUtils.isEmpty(zzcghVarM7993b.m7888d()) && !TextUtils.isEmpty(zzcgiVar.f7088b)) {
            zzcghVarM7993b.m7898g(0L);
            m8244q().m7985a(zzcghVarM7993b);
            m8237j().m8160d(zzcgiVar.f7087a);
        }
        if (!zzcgiVar.f7094h) {
            m8203d(zzcgiVar);
            return;
        }
        long jMo7496a = zzcgiVar.f7099m;
        if (jMo7496a == 0) {
            jMo7496a = this.f7363p.mo7496a();
        }
        int i2 = zzcgiVar.f7100n;
        if (i2 == 0 || i2 == 1) {
            i = i2;
        } else {
            m8233f().m8097A().m8110a("Incorrect app type, assuming installed app. appId, appType", zzchm.m8093a(zzcgiVar.f7087a), Integer.valueOf(i2));
            i = 0;
        }
        m8244q().m8006x();
        try {
            zzcgh zzcghVarM7993b2 = m8244q().m7993b(zzcgiVar.f7087a);
            if (zzcghVarM7993b2 != null && zzcghVarM7993b2.m7888d() != null && !zzcghVarM7993b2.m7888d().equals(zzcgiVar.f7088b)) {
                m8233f().m8097A().m8109a("New GMP App Id passed in. Removing cached database data. appId", zzchm.m8093a(zzcghVarM7993b2.m7881b()));
                zzcgo zzcgoVarM8244q = m8244q();
                String strM7881b = zzcghVarM7993b2.m7881b();
                zzcgoVarM8244q.m8259Q();
                zzcgoVarM8244q.mo7855c();
                zzbq.m7375a(strM7881b);
                try {
                    SQLiteDatabase sQLiteDatabaseM7968A = zzcgoVarM8244q.m7968A();
                    String[] strArr = {strM7881b};
                    int iDelete = sQLiteDatabaseM7968A.delete("audience_filter_values", "app_id=?", strArr) + sQLiteDatabaseM7968A.delete("events", "app_id=?", strArr) + 0 + sQLiteDatabaseM7968A.delete("user_attributes", "app_id=?", strArr) + sQLiteDatabaseM7968A.delete("conditional_properties", "app_id=?", strArr) + sQLiteDatabaseM7968A.delete("apps", "app_id=?", strArr) + sQLiteDatabaseM7968A.delete("raw_events", "app_id=?", strArr) + sQLiteDatabaseM7968A.delete("raw_events_metadata", "app_id=?", strArr) + sQLiteDatabaseM7968A.delete("event_filters", "app_id=?", strArr) + sQLiteDatabaseM7968A.delete("property_filters", "app_id=?", strArr);
                    if (iDelete > 0) {
                        zzcgoVarM8244q.mo7872t().m8101E().m8110a("Deleted application data. app, records", strM7881b, Integer.valueOf(iDelete));
                    }
                } catch (SQLiteException e) {
                    zzcgoVarM8244q.mo7872t().m8106y().m8110a("Error deleting application data. appId, error", zzchm.m8093a(strM7881b), e);
                }
                zzcghVarM7993b2 = null;
            }
            if (zzcghVarM7993b2 != null && zzcghVarM7993b2.m7902i() != null && !zzcghVarM7993b2.m7902i().equals(zzcgiVar.f7089c)) {
                Bundle bundle = new Bundle();
                bundle.putString("_pv", zzcghVarM7993b2.m7902i());
                m8216a(new zzcha("_au", new zzcgx(bundle), "auto", jMo7496a), zzcgiVar);
            }
            m8203d(zzcgiVar);
            zzcgw zzcgwVarM7979a = null;
            if (i == 0) {
                zzcgwVarM7979a = m8244q().m7979a(zzcgiVar.f7087a, "_f");
            } else if (i == 1) {
                zzcgwVarM7979a = m8244q().m7979a(zzcgiVar.f7087a, "_v");
            }
            if (zzcgwVarM7979a == null) {
                long j = (1 + (jMo7496a / 3600000)) * 3600000;
                if (i == 0) {
                    m8219a(new zzcln("_fot", jMo7496a, Long.valueOf(j), "auto"), zzcgiVar);
                    m8235h().mo7855c();
                    m8211a();
                    Bundle bundle2 = new Bundle();
                    bundle2.putLong("_c", 1L);
                    bundle2.putLong("_r", 1L);
                    bundle2.putLong("_uwa", 0L);
                    bundle2.putLong("_pfo", 0L);
                    bundle2.putLong("_sys", 0L);
                    bundle2.putLong("_sysu", 0L);
                    if (this.f7349b.getPackageManager() == null) {
                        m8233f().m8106y().m8109a("PackageManager is null, first open report might be inaccurate. appId", zzchm.m8093a(zzcgiVar.f7087a));
                    } else {
                        PackageInfo packageInfoM7814b = null;
                        try {
                            packageInfoM7814b = zzbhf.m7816a(this.f7349b).m7814b(zzcgiVar.f7087a, 0);
                        } catch (PackageManager.NameNotFoundException e2) {
                            m8233f().m8106y().m8110a("Package info is null, first open report might be inaccurate. appId", zzchm.m8093a(zzcgiVar.f7087a), e2);
                        }
                        if (packageInfoM7814b != null && packageInfoM7814b.firstInstallTime != 0) {
                            boolean z = false;
                            if (packageInfoM7814b.firstInstallTime != packageInfoM7814b.lastUpdateTime) {
                                bundle2.putLong("_uwa", 1L);
                            } else {
                                z = true;
                            }
                            m8219a(new zzcln("_fi", jMo7496a, Long.valueOf(z ? 1L : 0L), "auto"), zzcgiVar);
                        }
                        try {
                            applicationInfoM7810a = zzbhf.m7816a(this.f7349b).m7810a(zzcgiVar.f7087a, 0);
                        } catch (PackageManager.NameNotFoundException e3) {
                            m8233f().m8106y().m8110a("Application info is null, first open report might be inaccurate. appId", zzchm.m8093a(zzcgiVar.f7087a), e3);
                            applicationInfoM7810a = null;
                        }
                        if (applicationInfoM7810a != null) {
                            if ((applicationInfoM7810a.flags & 1) != 0) {
                                bundle2.putLong("_sys", 1L);
                            }
                            if ((applicationInfoM7810a.flags & 128) != 0) {
                                bundle2.putLong("_sysu", 1L);
                            }
                        }
                    }
                    zzcgo zzcgoVarM8244q2 = m8244q();
                    String str = zzcgiVar.f7087a;
                    zzbq.m7375a(str);
                    zzcgoVarM8244q2.mo7855c();
                    zzcgoVarM8244q2.m8259Q();
                    long jM8005h = zzcgoVarM8244q2.m8005h(str, "first_open_count");
                    if (jM8005h >= 0) {
                        bundle2.putLong("_pfo", jM8005h);
                    }
                    m8216a(new zzcha("_f", new zzcgx(bundle2), "auto", jMo7496a), zzcgiVar);
                } else if (i == 1) {
                    m8219a(new zzcln("_fvt", jMo7496a, Long.valueOf(j), "auto"), zzcgiVar);
                    m8235h().mo7855c();
                    m8211a();
                    Bundle bundle3 = new Bundle();
                    bundle3.putLong("_c", 1L);
                    bundle3.putLong("_r", 1L);
                    m8216a(new zzcha("_v", new zzcgx(bundle3), "auto", jMo7496a), zzcgiVar);
                }
                Bundle bundle4 = new Bundle();
                bundle4.putLong("_et", 1L);
                m8216a(new zzcha("_e", new zzcgx(bundle4), "auto", jMo7496a), zzcgiVar);
            } else if (zzcgiVar.f7095i) {
                m8216a(new zzcha("_cd", new zzcgx(new Bundle()), "auto", jMo7496a), zzcgiVar);
            }
            m8244q().m8007y();
        } finally {
            m8244q().m8008z();
        }
    }

    /* JADX INFO: renamed from: d */
    public final zzcgn m8231d() {
        return this.f7350c;
    }

    /* JADX INFO: renamed from: e */
    public final zzchx m8232e() {
        m8194a((zzcjk) this.f7351d);
        return this.f7351d;
    }

    /* JADX INFO: renamed from: f */
    public final zzchm m8233f() {
        m8202b(this.f7352e);
        return this.f7352e;
    }

    /* JADX INFO: renamed from: g */
    public final zzchm m8234g() {
        if (this.f7352e == null || !this.f7352e.m8258P()) {
            return null;
        }
        return this.f7352e;
    }

    /* JADX INFO: renamed from: h */
    public final zzcih m8235h() {
        m8202b(this.f7353f);
        return this.f7353f;
    }

    /* JADX INFO: renamed from: i */
    public final zzclf m8236i() {
        m8202b(this.f7354g);
        return this.f7354g;
    }

    /* JADX INFO: renamed from: j */
    public final zzcig m8237j() {
        m8202b(this.f7355h);
        return this.f7355h;
    }

    /* JADX INFO: renamed from: k */
    final zzcih m8238k() {
        return this.f7353f;
    }

    /* JADX INFO: renamed from: l */
    public final zzcjn m8239l() {
        m8202b(this.f7367t);
        return this.f7367t;
    }

    /* JADX INFO: renamed from: m */
    public final AppMeasurement m8240m() {
        return this.f7356i;
    }

    /* JADX INFO: renamed from: n */
    public final FirebaseAnalytics m8241n() {
        return this.f7357j;
    }

    /* JADX INFO: renamed from: o */
    public final zzclq m8242o() {
        m8194a((zzcjk) this.f7358k);
        return this.f7358k;
    }

    /* JADX INFO: renamed from: p */
    public final zzchk m8243p() {
        m8194a((zzcjk) this.f7359l);
        return this.f7359l;
    }

    /* JADX INFO: renamed from: q */
    public final zzcgo m8244q() {
        m8202b(this.f7360m);
        return this.f7360m;
    }

    /* JADX INFO: renamed from: r */
    public final zzchi m8245r() {
        m8202b(this.f7361n);
        return this.f7361n;
    }

    /* JADX INFO: renamed from: s */
    public final zzchq m8246s() {
        m8202b(this.f7362o);
        return this.f7362o;
    }

    /* JADX INFO: renamed from: t */
    public final Context m8247t() {
        return this.f7349b;
    }

    /* JADX INFO: renamed from: u */
    public final zzd m8248u() {
        return this.f7363p;
    }

    /* JADX INFO: renamed from: v */
    public final zzckc m8249v() {
        m8202b(this.f7364q);
        return this.f7364q;
    }

    /* JADX INFO: renamed from: w */
    public final zzckg m8250w() {
        m8202b(this.f7365r);
        return this.f7365r;
    }

    /* JADX INFO: renamed from: x */
    public final zzcgu m8251x() {
        m8202b(this.f7366s);
        return this.f7366s;
    }

    /* JADX INFO: renamed from: y */
    public final zzchh m8252y() {
        m8202b(this.f7368u);
        return this.f7368u;
    }

    /* JADX INFO: renamed from: z */
    public final zzcgk m8253z() {
        m8202b(this.f7371x);
        return this.f7371x;
    }
}
