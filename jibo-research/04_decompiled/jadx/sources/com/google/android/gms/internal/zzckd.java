package com.google.android.gms.internal;

import android.os.Bundle;
import com.google.android.gms.measurement.AppMeasurement;

/* JADX INFO: loaded from: classes.dex */
final class zzckd implements Runnable {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ boolean f7501a;

    /* JADX INFO: renamed from: b */
    private /* synthetic */ AppMeasurement.zzb f7502b;

    /* JADX INFO: renamed from: c */
    private /* synthetic */ zzckf f7503c;

    /* JADX INFO: renamed from: d */
    private /* synthetic */ zzckc f7504d;

    zzckd(zzckc zzckcVar, boolean z, AppMeasurement.zzb zzbVar, zzckf zzckfVar) {
        this.f7504d = zzckcVar;
        this.f7501a = z;
        this.f7502b = zzbVar;
        this.f7503c = zzckfVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f7501a && this.f7504d.f7492a != null) {
            this.f7504d.m8306a(this.f7504d.f7492a);
        }
        if ((this.f7502b != null && this.f7502b.f8398d == this.f7503c.f8398d && zzclq.m8396a(this.f7502b.f8397c, this.f7503c.f8397c) && zzclq.m8396a(this.f7502b.f8396b, this.f7503c.f8396b)) ? false : true) {
            Bundle bundle = new Bundle();
            zzckc.m8307a(this.f7503c, bundle);
            if (this.f7502b != null) {
                if (this.f7502b.f8396b != null) {
                    bundle.putString("_pn", this.f7502b.f8396b);
                }
                bundle.putString("_pc", this.f7502b.f8397c);
                bundle.putLong("_pi", this.f7502b.f8398d);
            }
            this.f7504d.mo7858f().m8289a("auto", "_vs", bundle);
        }
        this.f7504d.f7492a = this.f7503c;
        this.f7504d.mo7861i().m8342a(this.f7503c);
    }
}
