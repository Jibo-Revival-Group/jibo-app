package com.google.android.gms.internal;

/* JADX INFO: loaded from: classes.dex */
final class zzcks implements Runnable {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ boolean f7553a;

    /* JADX INFO: renamed from: b */
    private /* synthetic */ zzcln f7554b;

    /* JADX INFO: renamed from: c */
    private /* synthetic */ zzcgi f7555c;

    /* JADX INFO: renamed from: d */
    private /* synthetic */ zzckg f7556d;

    zzcks(zzckg zzckgVar, boolean z, zzcln zzclnVar, zzcgi zzcgiVar) {
        this.f7556d = zzckgVar;
        this.f7553a = z;
        this.f7554b = zzclnVar;
        this.f7555c = zzcgiVar;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        zzche zzcheVar = this.f7556d.f7509b;
        if (zzcheVar == null) {
            this.f7556d.mo7872t().m8106y().m8108a("Discarding data. Failed to set user attribute");
        } else {
            this.f7556d.m8340a(zzcheVar, this.f7553a ? null : this.f7554b, this.f7555c);
            this.f7556d.m8319F();
        }
    }
}
