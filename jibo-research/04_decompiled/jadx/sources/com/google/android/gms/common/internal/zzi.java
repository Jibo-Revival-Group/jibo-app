package com.google.android.gms.common.internal;

import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzi<TListener> {

    /* JADX INFO: renamed from: a */
    private TListener f6621a;

    /* JADX INFO: renamed from: b */
    private boolean f6622b = false;

    /* JADX INFO: renamed from: c */
    private /* synthetic */ zzd f6623c;

    public zzi(zzd zzdVar, TListener tlistener) {
        this.f6623c = zzdVar;
        this.f6621a = tlistener;
    }

    /* JADX INFO: renamed from: a */
    protected abstract void mo7442a(TListener tlistener);

    /* JADX INFO: renamed from: b */
    public final void m7446b() {
        TListener tlistener;
        synchronized (this) {
            tlistener = this.f6621a;
            if (this.f6622b) {
                String strValueOf = String.valueOf(this);
                Log.w("GmsClient", new StringBuilder(String.valueOf(strValueOf).length() + 47).append("Callback proxy ").append(strValueOf).append(" being reused. This is not safe.").toString());
            }
        }
        if (tlistener != null) {
            try {
                mo7442a(tlistener);
            } catch (RuntimeException e) {
                throw e;
            }
        }
        synchronized (this) {
            this.f6622b = true;
        }
        m7447c();
    }

    /* JADX INFO: renamed from: c */
    public final void m7447c() {
        m7448d();
        synchronized (this.f6623c.f6608r) {
            this.f6623c.f6608r.remove(this);
        }
    }

    /* JADX INFO: renamed from: d */
    public final void m7448d() {
        synchronized (this) {
            this.f6621a = null;
        }
    }
}
