package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.PersistableBundle;
import com.facebook.internal.NativeProtocol;
import com.google.android.gms.common.util.zzd;

/* JADX INFO: loaded from: classes.dex */
public final class zzcll extends zzcjl {

    /* JADX INFO: renamed from: a */
    private final AlarmManager f7594a;

    /* JADX INFO: renamed from: b */
    private final zzcgs f7595b;

    /* JADX INFO: renamed from: c */
    private Integer f7596c;

    protected zzcll(zzcim zzcimVar) {
        super(zzcimVar);
        this.f7594a = (AlarmManager) mo7864l().getSystemService("alarm");
        this.f7595b = new zzclm(this, zzcimVar);
    }

    /* JADX INFO: renamed from: A */
    private final int m8378A() {
        if (this.f7596c == null) {
            String strValueOf = String.valueOf(mo7864l().getPackageName());
            this.f7596c = Integer.valueOf((strValueOf.length() != 0 ? "measurement".concat(strValueOf) : new String("measurement")).hashCode());
        }
        return this.f7596c.intValue();
    }

    /* JADX INFO: renamed from: B */
    private final PendingIntent m8379B() {
        Intent className = new Intent().setClassName(mo7864l(), "com.google.android.gms.measurement.AppMeasurementReceiver");
        className.setAction("com.google.android.gms.measurement.UPLOAD");
        return PendingIntent.getBroadcast(mo7864l(), 0, className, 0);
    }

    @TargetApi(24)
    /* JADX INFO: renamed from: z */
    private final void m8380z() {
        JobScheduler jobScheduler = (JobScheduler) mo7864l().getSystemService("jobscheduler");
        mo7872t().m8101E().m8109a("Cancelling job. JobID", Integer.valueOf(m8378A()));
        jobScheduler.cancel(m8378A());
    }

    @Override // com.google.android.gms.internal.zzcjk
    /* JADX INFO: renamed from: a */
    public final /* bridge */ /* synthetic */ void mo7850a() {
        super.mo7850a();
    }

    /* JADX INFO: renamed from: a */
    public final void m8381a(long j) {
        m8259Q();
        if (!zzcid.m8144a(mo7864l())) {
            mo7872t().m8100D().m8108a("Receiver not registered/enabled");
        }
        if (!zzcla.m8353a(mo7864l(), false)) {
            mo7872t().m8100D().m8108a("Service not registered/enabled");
        }
        m8382y();
        long jMo7497b = mo7863k().mo7497b() + j;
        if (j < Math.max(0L, zzchc.f7200z.m8041b().longValue()) && !this.f7595b.m8017b()) {
            mo7872t().m8101E().m8108a("Scheduling upload with DelayedRunnable");
            this.f7595b.m8016a(j);
        }
        if (Build.VERSION.SDK_INT < 24) {
            mo7872t().m8101E().m8108a("Scheduling upload with AlarmManager");
            this.f7594a.setInexactRepeating(2, jMo7497b, Math.max(zzchc.f7195u.m8041b().longValue(), j), m8379B());
            return;
        }
        mo7872t().m8101E().m8108a("Scheduling upload with JobScheduler");
        ComponentName componentName = new ComponentName(mo7864l(), "com.google.android.gms.measurement.AppMeasurementJobService");
        JobScheduler jobScheduler = (JobScheduler) mo7864l().getSystemService("jobscheduler");
        JobInfo.Builder builder = new JobInfo.Builder(m8378A(), componentName);
        builder.setMinimumLatency(j);
        builder.setOverrideDeadline(j << 1);
        PersistableBundle persistableBundle = new PersistableBundle();
        persistableBundle.putString(NativeProtocol.WEB_DIALOG_ACTION, "com.google.android.gms.measurement.UPLOAD");
        builder.setExtras(persistableBundle);
        JobInfo jobInfoBuild = builder.build();
        mo7872t().m8101E().m8109a("Scheduling job. JobID", Integer.valueOf(m8378A()));
        jobScheduler.schedule(jobInfoBuild);
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
        this.f7594a.cancel(m8379B());
        if (Build.VERSION.SDK_INT < 24) {
            return false;
        }
        m8380z();
        return false;
    }

    /* JADX INFO: renamed from: y */
    public final void m8382y() {
        m8259Q();
        this.f7594a.cancel(m8379B());
        this.f7595b.m8018c();
        if (Build.VERSION.SDK_INT >= 24) {
            m8380z();
        }
    }
}
