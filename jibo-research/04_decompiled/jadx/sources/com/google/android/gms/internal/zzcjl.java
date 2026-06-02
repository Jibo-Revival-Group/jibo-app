package com.google.android.gms.internal;

/* JADX INFO: loaded from: classes.dex */
abstract class zzcjl extends zzcjk {

    /* JADX INFO: renamed from: a */
    private boolean f7442a;

    zzcjl(zzcim zzcimVar) {
        super(zzcimVar);
        this.f7441p.m8218a(this);
    }

    /* JADX INFO: renamed from: P */
    final boolean m8258P() {
        return this.f7442a;
    }

    /* JADX INFO: renamed from: Q */
    protected final void m8259Q() {
        if (!m8258P()) {
            throw new IllegalStateException("Not initialized");
        }
    }

    /* JADX INFO: renamed from: R */
    public final void m8260R() {
        if (this.f7442a) {
            throw new IllegalStateException("Can't initialize twice");
        }
        if (mo7936w()) {
            return;
        }
        this.f7441p.m8208F();
        this.f7442a = true;
    }

    /* JADX INFO: renamed from: S */
    public final void m8261S() {
        if (this.f7442a) {
            throw new IllegalStateException("Can't initialize twice");
        }
        mo8063d_();
        this.f7441p.m8208F();
        this.f7442a = true;
    }

    /* JADX INFO: renamed from: d_ */
    protected void mo8063d_() {
    }

    /* JADX INFO: renamed from: w */
    protected abstract boolean mo7936w();
}
