package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.util.ArrayMap;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.common.util.zzd;
import com.google.android.gms.measurement.AppMeasurement;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class zzcgd extends zzcjk {

    /* JADX INFO: renamed from: a */
    private final Map<String, Long> f7049a;

    /* JADX INFO: renamed from: b */
    private final Map<String, Integer> f7050b;

    /* JADX INFO: renamed from: c */
    private long f7051c;

    public zzcgd(zzcim zzcimVar) {
        super(zzcimVar);
        this.f7050b = new ArrayMap();
        this.f7049a = new ArrayMap();
    }

    /* JADX INFO: renamed from: a */
    private final void m7842a(long j, AppMeasurement.zzb zzbVar) {
        if (zzbVar == null) {
            mo7872t().m8101E().m8108a("Not logging ad exposure. No active activity");
            return;
        }
        if (j < 1000) {
            mo7872t().m8101E().m8109a("Not logging ad exposure. Less than 1000 ms. exposure", Long.valueOf(j));
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putLong("_xt", j);
        zzckc.m8307a(zzbVar, bundle);
        mo7858f().m8289a("am", "_xa", bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public final void m7845a(String str, long j) {
        mo7855c();
        zzbq.m7375a(str);
        if (this.f7050b.isEmpty()) {
            this.f7051c = j;
        }
        Integer num = this.f7050b.get(str);
        if (num != null) {
            this.f7050b.put(str, Integer.valueOf(num.intValue() + 1));
        } else if (this.f7050b.size() >= 100) {
            mo7872t().m8097A().m8108a("Too many ads visible");
        } else {
            this.f7050b.put(str, 1);
            this.f7049a.put(str, Long.valueOf(j));
        }
    }

    /* JADX INFO: renamed from: a */
    private final void m7846a(String str, long j, AppMeasurement.zzb zzbVar) {
        if (zzbVar == null) {
            mo7872t().m8101E().m8108a("Not logging ad unit exposure. No active activity");
            return;
        }
        if (j < 1000) {
            mo7872t().m8101E().m8109a("Not logging ad unit exposure. Less than 1000 ms. exposure", Long.valueOf(j));
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("_ai", str);
        bundle.putLong("_xt", j);
        zzckc.m8307a(zzbVar, bundle);
        mo7858f().m8289a("am", "_xu", bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: b */
    public final void m7847b(long j) {
        Iterator<String> it = this.f7049a.keySet().iterator();
        while (it.hasNext()) {
            this.f7049a.put(it.next(), Long.valueOf(j));
        }
        if (this.f7049a.isEmpty()) {
            return;
        }
        this.f7051c = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: b */
    public final void m7849b(String str, long j) {
        mo7855c();
        zzbq.m7375a(str);
        Integer num = this.f7050b.get(str);
        if (num == null) {
            mo7872t().m8106y().m8109a("Call to endAdUnitExposure for unknown ad unit id", str);
            return;
        }
        zzckf zzckfVarM8317y = mo7862j().m8317y();
        int iIntValue = num.intValue() - 1;
        if (iIntValue != 0) {
            this.f7050b.put(str, Integer.valueOf(iIntValue));
            return;
        }
        this.f7050b.remove(str);
        Long l = this.f7049a.get(str);
        if (l == null) {
            mo7872t().m8106y().m8108a("First ad unit exposure time was never set");
        } else {
            long jLongValue = j - l.longValue();
            this.f7049a.remove(str);
            m7846a(str, jLongValue, zzckfVarM8317y);
        }
        if (this.f7050b.isEmpty()) {
            if (this.f7051c == 0) {
                mo7872t().m8106y().m8108a("First ad exposure time was never set");
            } else {
                m7842a(j - this.f7051c, zzckfVarM8317y);
                this.f7051c = 0L;
            }
        }
    }

    @Override // com.google.android.gms.internal.zzcjk
    /* JADX INFO: renamed from: a */
    public final /* bridge */ /* synthetic */ void mo7850a() {
        super.mo7850a();
    }

    /* JADX INFO: renamed from: a */
    public final void m7851a(long j) {
        zzckf zzckfVarM8317y = mo7862j().m8317y();
        for (String str : this.f7049a.keySet()) {
            m7846a(str, j - this.f7049a.get(str).longValue(), zzckfVarM8317y);
        }
        if (!this.f7049a.isEmpty()) {
            m7842a(j - this.f7051c, zzckfVarM8317y);
        }
        m7847b(j);
    }

    /* JADX INFO: renamed from: a */
    public final void m7852a(String str) {
        if (str == null || str.length() == 0) {
            mo7872t().m8106y().m8108a("Ad unit id must be a non-empty string");
        } else {
            mo7871s().m8173a(new zzcge(this, str, mo7863k().mo7497b()));
        }
    }

    @Override // com.google.android.gms.internal.zzcjk
    /* JADX INFO: renamed from: b */
    public final /* bridge */ /* synthetic */ void mo7853b() {
        super.mo7853b();
    }

    /* JADX INFO: renamed from: b */
    public final void m7854b(String str) {
        if (str == null || str.length() == 0) {
            mo7872t().m8106y().m8108a("Ad unit id must be a non-empty string");
        } else {
            mo7871s().m8173a(new zzcgf(this, str, mo7863k().mo7497b()));
        }
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
}
