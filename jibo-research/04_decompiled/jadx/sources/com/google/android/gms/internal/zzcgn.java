package com.google.android.gms.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.common.util.zzd;
import com.google.android.gms.common.util.zzs;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: loaded from: classes.dex */
public final class zzcgn extends zzcjk {

    /* JADX INFO: renamed from: a */
    private Boolean f7114a;

    zzcgn(zzcim zzcimVar) {
        super(zzcimVar);
    }

    /* JADX INFO: renamed from: B */
    public static boolean m7937B() {
        return zzchc.f7175a.m8041b().booleanValue();
    }

    /* JADX INFO: renamed from: y */
    public static long m7938y() {
        return zzchc.f7165F.m8041b().longValue();
    }

    /* JADX INFO: renamed from: z */
    public static long m7939z() {
        return zzchc.f7180f.m8041b().longValue();
    }

    /* JADX INFO: renamed from: A */
    public final String m7940A() {
        try {
            return (String) Class.forName("android.os.SystemProperties").getMethod("get", String.class, String.class).invoke(null, "debug.firebase.analytics.app", "");
        } catch (ClassNotFoundException e) {
            mo7872t().m8106y().m8109a("Could not find SystemProperties class", e);
            return "";
        } catch (IllegalAccessException e2) {
            mo7872t().m8106y().m8109a("Could not access SystemProperties.get()", e2);
            return "";
        } catch (NoSuchMethodException e3) {
            mo7872t().m8106y().m8109a("Could not find SystemProperties.get() method", e3);
            return "";
        } catch (InvocationTargetException e4) {
            mo7872t().m8106y().m8109a("SystemProperties.get() threw an exception", e4);
            return "";
        }
    }

    /* JADX INFO: renamed from: a */
    public final int m7941a(String str) {
        return m7943b(str, zzchc.f7191q);
    }

    /* JADX INFO: renamed from: a */
    public final long m7942a(String str, zzchd<Long> zzchdVar) {
        if (str == null) {
            return zzchdVar.m8041b().longValue();
        }
        String strM8153a = mo7869q().m8153a(str, zzchdVar.m8040a());
        if (TextUtils.isEmpty(strM8153a)) {
            return zzchdVar.m8041b().longValue();
        }
        try {
            return zzchdVar.m8039a(Long.valueOf(Long.valueOf(strM8153a).longValue())).longValue();
        } catch (NumberFormatException e) {
            return zzchdVar.m8041b().longValue();
        }
    }

    @Override // com.google.android.gms.internal.zzcjk
    /* JADX INFO: renamed from: a */
    public final /* bridge */ /* synthetic */ void mo7850a() {
        super.mo7850a();
    }

    /* JADX INFO: renamed from: b */
    public final int m7943b(String str, zzchd<Integer> zzchdVar) {
        if (str == null) {
            return zzchdVar.m8041b().intValue();
        }
        String strM8153a = mo7869q().m8153a(str, zzchdVar.m8040a());
        if (TextUtils.isEmpty(strM8153a)) {
            return zzchdVar.m8041b().intValue();
        }
        try {
            return zzchdVar.m8039a(Integer.valueOf(Integer.valueOf(strM8153a).intValue())).intValue();
        } catch (NumberFormatException e) {
            return zzchdVar.m8041b().intValue();
        }
    }

    /* JADX INFO: renamed from: b */
    final Boolean m7944b(String str) {
        Boolean boolValueOf = null;
        zzbq.m7375a(str);
        try {
            if (mo7864l().getPackageManager() == null) {
                mo7872t().m8106y().m8108a("Failed to load metadata: PackageManager is null");
            } else {
                ApplicationInfo applicationInfoM7810a = zzbhf.m7816a(mo7864l()).m7810a(mo7864l().getPackageName(), 128);
                if (applicationInfoM7810a == null) {
                    mo7872t().m8106y().m8108a("Failed to load metadata: ApplicationInfo is null");
                } else if (applicationInfoM7810a.metaData == null) {
                    mo7872t().m8106y().m8108a("Failed to load metadata: Metadata bundle is null");
                } else if (applicationInfoM7810a.metaData.containsKey(str)) {
                    boolValueOf = Boolean.valueOf(applicationInfoM7810a.metaData.getBoolean(str));
                }
            }
        } catch (PackageManager.NameNotFoundException e) {
            mo7872t().m8106y().m8109a("Failed to load metadata: Package name not found", e);
        }
        return boolValueOf;
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

    /* JADX INFO: renamed from: c */
    public final boolean m7945c(String str) {
        return AppEventsConstants.EVENT_PARAM_VALUE_YES.equals(mo7869q().m8153a(str, "gaia_collection_enabled"));
    }

    @Override // com.google.android.gms.internal.zzcjk
    /* JADX INFO: renamed from: d */
    public final /* bridge */ /* synthetic */ zzcgd mo7856d() {
        return super.mo7856d();
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

    /* JADX INFO: renamed from: w */
    public final boolean m7946w() {
        if (this.f7114a == null) {
            synchronized (this) {
                if (this.f7114a == null) {
                    ApplicationInfo applicationInfo = mo7864l().getApplicationInfo();
                    String strM7518a = zzs.m7518a();
                    if (applicationInfo != null) {
                        String str = applicationInfo.processName;
                        this.f7114a = Boolean.valueOf(str != null && str.equals(strM7518a));
                    }
                    if (this.f7114a == null) {
                        this.f7114a = Boolean.TRUE;
                        mo7872t().m8106y().m8108a("My process not in the list of running processes");
                    }
                }
            }
        }
        return this.f7114a.booleanValue();
    }

    /* JADX INFO: renamed from: x */
    public final boolean m7947x() {
        Boolean boolM7944b = m7944b("firebase_analytics_collection_deactivated");
        return boolM7944b != null && boolM7944b.booleanValue();
    }
}
