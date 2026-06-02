package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.util.zzd;

/* JADX INFO: loaded from: classes.dex */
public final class zzclf extends zzcjl {

    /* JADX INFO: renamed from: a */
    private Handler f7582a;

    /* JADX INFO: renamed from: b */
    private long f7583b;

    /* JADX INFO: renamed from: c */
    private final zzcgs f7584c;

    /* JADX INFO: renamed from: d */
    private final zzcgs f7585d;

    zzclf(zzcim zzcimVar) {
        super(zzcimVar);
        this.f7584c = new zzclg(this, this.f7441p);
        this.f7585d = new zzclh(this, this.f7441p);
        this.f7583b = mo7863k().mo7497b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public final void m8367a(long j) {
        mo7855c();
        m8372y();
        this.f7584c.m8018c();
        this.f7585d.m8018c();
        mo7872t().m8101E().m8109a("Activity resumed, time", Long.valueOf(j));
        this.f7583b = j;
        if (mo7863k().mo7496a() - mo7873u().f7266k.m8136a() > mo7873u().f7268m.m8136a()) {
            mo7873u().f7267l.m8134a(true);
            mo7873u().f7269n.m8137a(0L);
        }
        if (mo7873u().f7267l.m8135a()) {
            this.f7584c.m8016a(Math.max(0L, mo7873u().f7265j.m8136a() - mo7873u().f7269n.m8136a()));
        } else {
            this.f7585d.m8016a(Math.max(0L, 3600000 - mo7873u().f7269n.m8136a()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: b */
    public final void m8370b(long j) {
        mo7855c();
        m8372y();
        this.f7584c.m8018c();
        this.f7585d.m8018c();
        mo7872t().m8101E().m8109a("Activity paused, time", Long.valueOf(j));
        if (this.f7583b != 0) {
            mo7873u().f7269n.m8137a(mo7873u().f7269n.m8136a() + (j - this.f7583b));
        }
    }

    /* JADX INFO: renamed from: y */
    private final void m8372y() {
        synchronized (this) {
            if (this.f7582a == null) {
                this.f7582a = new Handler(Looper.getMainLooper());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: z */
    public final void m8373z() {
        mo7855c();
        m8374a(false);
        mo7856d().m7851a(mo7863k().mo7497b());
    }

    @Override // com.google.android.gms.internal.zzcjk
    /* JADX INFO: renamed from: a */
    public final /* bridge */ /* synthetic */ void mo7850a() {
        super.mo7850a();
    }

    /* JADX INFO: renamed from: a */
    public final boolean m8374a(boolean z) {
        mo7855c();
        m8259Q();
        long jMo7497b = mo7863k().mo7497b();
        mo7873u().f7268m.m8137a(mo7863k().mo7496a());
        long j = jMo7497b - this.f7583b;
        if (!z && j < 1000) {
            mo7872t().m8101E().m8109a("Screen exposed for less than 1000 ms. Event not sent. time", Long.valueOf(j));
            return false;
        }
        mo7873u().f7269n.m8137a(j);
        mo7872t().m8101E().m8109a("Recording user engagement, ms", Long.valueOf(j));
        Bundle bundle = new Bundle();
        bundle.putLong("_et", j);
        zzckc.m8307a(mo7862j().m8317y(), bundle);
        mo7858f().m8289a("auto", "_e", bundle);
        this.f7583b = jMo7497b;
        this.f7585d.m8018c();
        this.f7585d.m8016a(Math.max(0L, 3600000 - mo7873u().f7269n.m8136a()));
        return true;
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
}
