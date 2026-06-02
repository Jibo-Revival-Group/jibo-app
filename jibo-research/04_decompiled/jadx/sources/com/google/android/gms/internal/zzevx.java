package com.google.android.gms.internal;

import com.google.android.gms.internal.zzevw;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public class zzevx implements zzevw.zza {

    /* JADX INFO: renamed from: a */
    private zzevw f7843a;

    /* JADX INFO: renamed from: b */
    private int f7844b = 0;

    /* JADX INFO: renamed from: c */
    private boolean f7845c = false;

    /* JADX INFO: renamed from: d */
    private WeakReference<zzevw.zza> f7846d = new WeakReference<>(this);

    protected zzevx(zzevw zzevwVar) {
        this.f7843a = zzevwVar;
    }

    @Override // com.google.android.gms.internal.zzevw.zza
    /* JADX INFO: renamed from: b */
    public final void mo8555b(int i) {
        this.f7844b |= i;
    }

    /* JADX INFO: renamed from: c */
    protected final void m8556c(int i) {
        this.f7843a.m8549a(1);
    }

    /* JADX INFO: renamed from: e */
    protected final void m8557e() {
        if (this.f7845c) {
            return;
        }
        this.f7844b = this.f7843a.m8553b();
        this.f7843a.m8552a(this.f7846d);
        this.f7845c = true;
    }

    /* JADX INFO: renamed from: f */
    protected final void m8558f() {
        if (this.f7845c) {
            this.f7843a.m8554b(this.f7846d);
            this.f7845c = false;
        }
    }

    /* JADX INFO: renamed from: g */
    public final int m8559g() {
        return this.f7844b;
    }
}
