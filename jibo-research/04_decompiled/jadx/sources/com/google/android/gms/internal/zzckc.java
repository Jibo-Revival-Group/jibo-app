package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.util.ArrayMap;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.common.util.zzd;
import com.google.android.gms.measurement.AppMeasurement;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class zzckc extends zzcjl {

    /* JADX INFO: renamed from: a */
    protected zzckf f7492a;

    /* JADX INFO: renamed from: b */
    private volatile AppMeasurement.zzb f7493b;

    /* JADX INFO: renamed from: c */
    private AppMeasurement.zzb f7494c;

    /* JADX INFO: renamed from: d */
    private long f7495d;

    /* JADX INFO: renamed from: e */
    private final Map<Activity, zzckf> f7496e;

    /* JADX INFO: renamed from: f */
    private final CopyOnWriteArrayList<AppMeasurement.zza> f7497f;

    /* JADX INFO: renamed from: g */
    private boolean f7498g;

    /* JADX INFO: renamed from: h */
    private AppMeasurement.zzb f7499h;

    /* JADX INFO: renamed from: i */
    private String f7500i;

    public zzckc(zzcim zzcimVar) {
        super(zzcimVar);
        this.f7496e = new ArrayMap();
        this.f7497f = new CopyOnWriteArrayList<>();
    }

    /* JADX INFO: renamed from: a */
    private static String m8303a(String str) {
        String[] strArrSplit = str.split("\\.");
        if (strArrSplit.length == 0) {
            return str.substring(0, 36);
        }
        String str2 = strArrSplit[strArrSplit.length - 1];
        return str2.length() > 36 ? str2.substring(0, 36) : str2;
    }

    /* JADX INFO: renamed from: a */
    private final void m8304a(Activity activity, zzckf zzckfVar, boolean z) {
        boolean z2;
        boolean zM8921a = true;
        AppMeasurement.zzb zzbVar = this.f7493b != null ? this.f7493b : (this.f7494c == null || Math.abs(mo7863k().mo7497b() - this.f7495d) >= 1000) ? null : this.f7494c;
        AppMeasurement.zzb zzbVar2 = zzbVar != null ? new AppMeasurement.zzb(zzbVar) : null;
        this.f7498g = true;
        try {
            try {
                Iterator<AppMeasurement.zza> it = this.f7497f.iterator();
                while (it.hasNext()) {
                    try {
                        zM8921a &= it.next().m8921a(zzbVar2, zzckfVar);
                    } catch (Exception e) {
                        mo7872t().m8106y().m8109a("onScreenChangeCallback threw exception", e);
                    }
                }
                this.f7498g = false;
                z2 = zM8921a;
            } catch (Throwable th) {
                this.f7498g = false;
                throw th;
            }
        } catch (Exception e2) {
            z2 = zM8921a;
            mo7872t().m8106y().m8109a("onScreenChangeCallback loop threw exception", e2);
            this.f7498g = false;
        }
        AppMeasurement.zzb zzbVar3 = this.f7493b == null ? this.f7494c : this.f7493b;
        if (z2) {
            if (zzckfVar.f8397c == null) {
                zzckfVar.f8397c = m8303a(activity.getClass().getCanonicalName());
            }
            zzckf zzckfVar2 = new zzckf(zzckfVar);
            this.f7494c = this.f7493b;
            this.f7495d = mo7863k().mo7497b();
            this.f7493b = zzckfVar2;
            mo7871s().m8173a(new zzckd(this, z, zzbVar3, zzckfVar2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public final void m8306a(zzckf zzckfVar) {
        mo7856d().m7851a(mo7863k().mo7497b());
        if (mo7870r().m8374a(zzckfVar.f7507a)) {
            zzckfVar.f7507a = false;
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m8307a(AppMeasurement.zzb zzbVar, Bundle bundle) {
        if (bundle == null || zzbVar == null || bundle.containsKey("_sc")) {
            return;
        }
        if (zzbVar.f8396b != null) {
            bundle.putString("_sn", zzbVar.f8396b);
        }
        bundle.putString("_sc", zzbVar.f8397c);
        bundle.putLong("_si", zzbVar.f8398d);
    }

    /* JADX INFO: renamed from: a */
    final zzckf m8308a(Activity activity) {
        zzbq.m7373a(activity);
        zzckf zzckfVar = this.f7496e.get(activity);
        if (zzckfVar != null) {
            return zzckfVar;
        }
        zzckf zzckfVar2 = new zzckf(null, m8303a(activity.getClass().getCanonicalName()), mo7868p().m8443y());
        this.f7496e.put(activity, zzckfVar2);
        return zzckfVar2;
    }

    @Override // com.google.android.gms.internal.zzcjk
    /* JADX INFO: renamed from: a */
    public final /* bridge */ /* synthetic */ void mo7850a() {
        super.mo7850a();
    }

    /* JADX INFO: renamed from: a */
    public final void m8309a(Activity activity, Bundle bundle) {
        zzckf zzckfVar;
        if (bundle == null || (zzckfVar = this.f7496e.get(activity)) == null) {
            return;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putLong(ShareConstants.WEB_DIALOG_PARAM_ID, zzckfVar.f8398d);
        bundle2.putString("name", zzckfVar.f8396b);
        bundle2.putString("referrer_name", zzckfVar.f8397c);
        bundle.putBundle("com.google.firebase.analytics.screen_service", bundle2);
    }

    /* JADX INFO: renamed from: a */
    public final void m8310a(Activity activity, String str, String str2) {
        if (activity == null) {
            mo7872t().m8097A().m8108a("setCurrentScreen must be called with a non-null activity");
            return;
        }
        mo7871s();
        if (!zzcih.m8170y()) {
            mo7872t().m8097A().m8108a("setCurrentScreen must be called from the main thread");
            return;
        }
        if (this.f7498g) {
            mo7872t().m8097A().m8108a("Cannot call setCurrentScreen from onScreenChangeCallback");
            return;
        }
        if (this.f7493b == null) {
            mo7872t().m8097A().m8108a("setCurrentScreen cannot be called while no activity active");
            return;
        }
        if (this.f7496e.get(activity) == null) {
            mo7872t().m8097A().m8108a("setCurrentScreen must be called with an activity in the activity lifecycle");
            return;
        }
        if (str2 == null) {
            str2 = m8303a(activity.getClass().getCanonicalName());
        }
        boolean zEquals = this.f7493b.f8397c.equals(str2);
        boolean zM8396a = zzclq.m8396a(this.f7493b.f8396b, str);
        if (zEquals && zM8396a) {
            mo7872t().m8098B().m8108a("setCurrentScreen cannot be called with the same class and name");
            return;
        }
        if (str != null && (str.length() <= 0 || str.length() > 100)) {
            mo7872t().m8097A().m8109a("Invalid screen name length in setCurrentScreen. Length", Integer.valueOf(str.length()));
            return;
        }
        if (str2 != null && (str2.length() <= 0 || str2.length() > 100)) {
            mo7872t().m8097A().m8109a("Invalid class name length in setCurrentScreen. Length", Integer.valueOf(str2.length()));
            return;
        }
        mo7872t().m8101E().m8110a("Setting current screen to name, class", str == null ? "null" : str, str2);
        zzckf zzckfVar = new zzckf(str, str2, mo7868p().m8443y());
        this.f7496e.put(activity, zzckfVar);
        m8304a(activity, zzckfVar, true);
    }

    /* JADX INFO: renamed from: a */
    public final void m8311a(AppMeasurement.zza zzaVar) {
        if (zzaVar == null) {
            mo7872t().m8097A().m8108a("Attempting to register null OnScreenChangeCallback");
        } else {
            this.f7497f.remove(zzaVar);
            this.f7497f.add(zzaVar);
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m8312a(String str, AppMeasurement.zzb zzbVar) {
        mo7855c();
        synchronized (this) {
            if (this.f7500i == null || this.f7500i.equals(str) || zzbVar != null) {
                this.f7500i = str;
                this.f7499h = zzbVar;
            }
        }
    }

    @Override // com.google.android.gms.internal.zzcjk
    /* JADX INFO: renamed from: b */
    public final /* bridge */ /* synthetic */ void mo7853b() {
        super.mo7853b();
    }

    /* JADX INFO: renamed from: b */
    public final void m8313b(Activity activity) {
        m8304a(activity, m8308a(activity), false);
        zzcgd zzcgdVarMo7856d = mo7856d();
        zzcgdVarMo7856d.mo7871s().m8173a(new zzcgg(zzcgdVarMo7856d, zzcgdVarMo7856d.mo7863k().mo7497b()));
    }

    /* JADX INFO: renamed from: b */
    public final void m8314b(AppMeasurement.zza zzaVar) {
        this.f7497f.remove(zzaVar);
    }

    @Override // com.google.android.gms.internal.zzcjk
    /* JADX INFO: renamed from: c */
    public final /* bridge */ /* synthetic */ void mo7855c() {
        super.mo7855c();
    }

    /* JADX INFO: renamed from: c */
    public final void m8315c(Activity activity) {
        zzckf zzckfVarM8308a = m8308a(activity);
        this.f7494c = this.f7493b;
        this.f7495d = mo7863k().mo7497b();
        this.f7493b = null;
        mo7871s().m8173a(new zzcke(this, zzckfVarM8308a));
    }

    @Override // com.google.android.gms.internal.zzcjk
    /* JADX INFO: renamed from: d */
    public final /* bridge */ /* synthetic */ zzcgd mo7856d() {
        return super.mo7856d();
    }

    /* JADX INFO: renamed from: d */
    public final void m8316d(Activity activity) {
        this.f7496e.remove(activity);
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
        return false;
    }

    /* JADX INFO: renamed from: y */
    public final zzckf m8317y() {
        m8259Q();
        mo7855c();
        return this.f7492a;
    }

    /* JADX INFO: renamed from: z */
    public final AppMeasurement.zzb m8318z() {
        AppMeasurement.zzb zzbVar = this.f7493b;
        if (zzbVar == null) {
            return null;
        }
        return new AppMeasurement.zzb(zzbVar);
    }
}
