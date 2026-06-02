package com.google.android.gms.internal;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import com.facebook.internal.AnalyticsEvents;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zzbz;
import com.google.android.gms.common.util.zzd;
import com.google.firebase.iid.FirebaseInstanceId;
import java.math.BigInteger;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class zzchh extends zzcjl {

    /* JADX INFO: renamed from: a */
    private String f7204a;

    /* JADX INFO: renamed from: b */
    private String f7205b;

    /* JADX INFO: renamed from: c */
    private int f7206c;

    /* JADX INFO: renamed from: d */
    private String f7207d;

    /* JADX INFO: renamed from: e */
    private String f7208e;

    /* JADX INFO: renamed from: f */
    private long f7209f;

    /* JADX INFO: renamed from: g */
    private long f7210g;

    /* JADX INFO: renamed from: h */
    private int f7211h;

    /* JADX INFO: renamed from: i */
    private String f7212i;

    zzchh(zzcim zzcimVar) {
        super(zzcimVar);
    }

    /* JADX INFO: renamed from: D */
    private final String m8058D() {
        mo7855c();
        try {
            return FirebaseInstanceId.m9094a().m9107c();
        } catch (IllegalStateException e) {
            mo7872t().m8097A().m8108a("Failed to retrieve Firebase Instance Id");
            return null;
        }
    }

    /* JADX INFO: renamed from: A */
    final String m8059A() {
        m8259Q();
        return this.f7212i;
    }

    /* JADX INFO: renamed from: B */
    final int m8060B() {
        m8259Q();
        return this.f7206c;
    }

    /* JADX INFO: renamed from: C */
    final int m8061C() {
        m8259Q();
        return this.f7211h;
    }

    /* JADX INFO: renamed from: a */
    final zzcgi m8062a(String str) {
        mo7855c();
        String strM8065z = m8065z();
        String strM8059A = m8059A();
        m8259Q();
        String str2 = this.f7205b;
        long jM8060B = m8060B();
        m8259Q();
        String str3 = this.f7207d;
        m8259Q();
        mo7855c();
        if (this.f7209f == 0) {
            this.f7209f = this.f7441p.m8242o().m8432b(mo7864l(), mo7864l().getPackageName());
        }
        long j = this.f7209f;
        boolean zM8205B = this.f7441p.m8205B();
        boolean z = !mo7873u().f7270o;
        String strM8058D = m8058D();
        m8259Q();
        long jM8206C = this.f7441p.m8206C();
        int iM8061C = m8061C();
        Boolean boolM7944b = mo7874v().m7944b("google_analytics_adid_collection_enabled");
        return new zzcgi(strM8065z, strM8059A, str2, jM8060B, str3, 11910L, j, str, zM8205B, z, strM8058D, 0L, jM8206C, iM8061C, Boolean.valueOf(boolM7944b == null || boolM7944b.booleanValue()).booleanValue());
    }

    @Override // com.google.android.gms.internal.zzcjk
    /* JADX INFO: renamed from: a */
    public final /* bridge */ /* synthetic */ void mo7850a() {
        super.mo7850a();
    }

    @Override // com.google.android.gms.internal.zzcjk
    /* JADX INFO: renamed from: b */
    public final /* bridge */ /* synthetic */ void mo7853b() {
        super.mo7853b();
    }

    @Override // com.google.android.gms.internal.zzcjk
    /* JADX INFO: renamed from: c */
    public final /* bridge */ /* synthetic */ void mo7855c() {
        super.mo7855c();
    }

    @Override // com.google.android.gms.internal.zzcjk
    /* JADX INFO: renamed from: d */
    public final /* bridge */ /* synthetic */ zzcgd mo7856d() {
        return super.mo7856d();
    }

    @Override // com.google.android.gms.internal.zzcjl
    /* JADX INFO: renamed from: d_ */
    protected final void mo8063d_() {
        boolean z;
        String installerPackageName = "unknown";
        String str = AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
        int i = Integer.MIN_VALUE;
        String string = AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
        String packageName = mo7864l().getPackageName();
        PackageManager packageManager = mo7864l().getPackageManager();
        if (packageManager == null) {
            mo7872t().m8106y().m8109a("PackageManager is null, app identity information might be inaccurate. appId", zzchm.m8093a(packageName));
        } else {
            try {
                installerPackageName = packageManager.getInstallerPackageName(packageName);
            } catch (IllegalArgumentException e) {
                mo7872t().m8106y().m8109a("Error retrieving app installer package name. appId", zzchm.m8093a(packageName));
            }
            if (installerPackageName == null) {
                installerPackageName = "manual_install";
            } else if ("com.android.vending".equals(installerPackageName)) {
                installerPackageName = "";
            }
            try {
                PackageInfo packageInfo = packageManager.getPackageInfo(mo7864l().getPackageName(), 0);
                if (packageInfo != null) {
                    CharSequence applicationLabel = packageManager.getApplicationLabel(packageInfo.applicationInfo);
                    if (!TextUtils.isEmpty(applicationLabel)) {
                        string = applicationLabel.toString();
                    }
                    str = packageInfo.versionName;
                    i = packageInfo.versionCode;
                }
            } catch (PackageManager.NameNotFoundException e2) {
                mo7872t().m8106y().m8110a("Error retrieving package info. appId, appName", zzchm.m8093a(packageName), string);
            }
        }
        this.f7204a = packageName;
        this.f7207d = installerPackageName;
        this.f7205b = str;
        this.f7206c = i;
        this.f7208e = string;
        this.f7209f = 0L;
        Status statusM7155a = zzbz.m7155a(mo7864l());
        boolean z2 = statusM7155a != null && statusM7155a.m6935c();
        if (!z2) {
            if (statusM7155a == null) {
                mo7872t().m8106y().m8108a("GoogleService failed to initialize (no status)");
            } else {
                mo7872t().m8106y().m8110a("GoogleService failed to initialize, status", Integer.valueOf(statusM7155a.m6936d()), statusM7155a.m6934b());
            }
        }
        if (z2) {
            Boolean boolM7944b = mo7874v().m7944b("firebase_analytics_collection_enabled");
            if (mo7874v().m7947x()) {
                mo7872t().m8099C().m8108a("Collection disabled with firebase_analytics_collection_deactivated=1");
                z = false;
            } else if (boolM7944b != null && !boolM7944b.booleanValue()) {
                mo7872t().m8099C().m8108a("Collection disabled with firebase_analytics_collection_enabled=0");
                z = false;
            } else if (boolM7944b == null && zzbz.m7158b()) {
                mo7872t().m8099C().m8108a("Collection disabled with google_app_measurement_enable=0");
                z = false;
            } else {
                mo7872t().m8101E().m8108a("Collection enabled");
                z = true;
            }
        } else {
            z = false;
        }
        this.f7212i = "";
        this.f7210g = 0L;
        try {
            String strM7157a = zzbz.m7157a();
            if (TextUtils.isEmpty(strM7157a)) {
                strM7157a = "";
            }
            this.f7212i = strM7157a;
            if (z) {
                mo7872t().m8101E().m8110a("App package, google app id", this.f7204a, this.f7212i);
            }
        } catch (IllegalStateException e3) {
            mo7872t().m8106y().m8110a("getGoogleAppId or isMeasurementEnabled failed with exception. appId", zzchm.m8093a(packageName), e3);
        }
        if (Build.VERSION.SDK_INT >= 16) {
            this.f7211h = zzbhd.m7808a(mo7864l()) ? 1 : 0;
        } else {
            this.f7211h = 0;
        }
    }

    @Override // com.google.android.gms.internal.zzcjk
    /* JADX INFO: renamed from: e */
    public final /* bridge */ /* synthetic */ zzcgk mo7857e() {
        return super.mo7857e();
    }

    @Override // com.google.android.gms.internal.zzcjk
    /* JADX INFO: renamed from: f */
    public final /* bridge */ /* synthetic */ zzcjn mo7858f() {
        return super.mo7858f();
    }

    @Override // com.google.android.gms.internal.zzcjk
    /* JADX INFO: renamed from: g */
    public final /* bridge */ /* synthetic */ zzchh mo7859g() {
        return super.mo7859g();
    }

    @Override // com.google.android.gms.internal.zzcjk
    /* JADX INFO: renamed from: h */
    public final /* bridge */ /* synthetic */ zzcgu mo7860h() {
        return super.mo7860h();
    }

    @Override // com.google.android.gms.internal.zzcjk
    /* JADX INFO: renamed from: i */
    public final /* bridge */ /* synthetic */ zzckg mo7861i() {
        return super.mo7861i();
    }

    @Override // com.google.android.gms.internal.zzcjk
    /* JADX INFO: renamed from: j */
    public final /* bridge */ /* synthetic */ zzckc mo7862j() {
        return super.mo7862j();
    }

    @Override // com.google.android.gms.internal.zzcjk
    /* JADX INFO: renamed from: k */
    public final /* bridge */ /* synthetic */ zzd mo7863k() {
        return super.mo7863k();
    }

    @Override // com.google.android.gms.internal.zzcjk
    /* JADX INFO: renamed from: l */
    public final /* bridge */ /* synthetic */ Context mo7864l() {
        return super.mo7864l();
    }

    @Override // com.google.android.gms.internal.zzcjk
    /* JADX INFO: renamed from: m */
    public final /* bridge */ /* synthetic */ zzchi mo7865m() {
        return super.mo7865m();
    }

    @Override // com.google.android.gms.internal.zzcjk
    /* JADX INFO: renamed from: n */
    public final /* bridge */ /* synthetic */ zzcgo mo7866n() {
        return super.mo7866n();
    }

    @Override // com.google.android.gms.internal.zzcjk
    /* JADX INFO: renamed from: o */
    public final /* bridge */ /* synthetic */ zzchk mo7867o() {
        return super.mo7867o();
    }

    @Override // com.google.android.gms.internal.zzcjk
    /* JADX INFO: renamed from: p */
    public final /* bridge */ /* synthetic */ zzclq mo7868p() {
        return super.mo7868p();
    }

    @Override // com.google.android.gms.internal.zzcjk
    /* JADX INFO: renamed from: q */
    public final /* bridge */ /* synthetic */ zzcig mo7869q() {
        return super.mo7869q();
    }

    @Override // com.google.android.gms.internal.zzcjk
    /* JADX INFO: renamed from: r */
    public final /* bridge */ /* synthetic */ zzclf mo7870r() {
        return super.mo7870r();
    }

    @Override // com.google.android.gms.internal.zzcjk
    /* JADX INFO: renamed from: s */
    public final /* bridge */ /* synthetic */ zzcih mo7871s() {
        return super.mo7871s();
    }

    @Override // com.google.android.gms.internal.zzcjk
    /* JADX INFO: renamed from: t */
    public final /* bridge */ /* synthetic */ zzchm mo7872t() {
        return super.mo7872t();
    }

    @Override // com.google.android.gms.internal.zzcjk
    /* JADX INFO: renamed from: u */
    public final /* bridge */ /* synthetic */ zzchx mo7873u() {
        return super.mo7873u();
    }

    @Override // com.google.android.gms.internal.zzcjk
    /* JADX INFO: renamed from: v */
    public final /* bridge */ /* synthetic */ zzcgn mo7874v() {
        return super.mo7874v();
    }

    @Override // com.google.android.gms.internal.zzcjl
    /* JADX INFO: renamed from: w */
    protected final boolean mo7936w() {
        return true;
    }

    /* JADX INFO: renamed from: y */
    final String m8064y() {
        byte[] bArr = new byte[16];
        mo7868p().m8444z().nextBytes(bArr);
        return String.format(Locale.US, "%032x", new BigInteger(1, bArr));
    }

    /* JADX INFO: renamed from: z */
    final String m8065z() {
        m8259Q();
        return this.f7204a;
    }
}
