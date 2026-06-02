package com.google.android.gms.common.api.internal;

import android.app.PendingIntent;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzo extends LifecycleCallback implements DialogInterface.OnCancelListener {

    /* JADX INFO: renamed from: b */
    protected volatile boolean f6421b;

    /* JADX INFO: renamed from: c */
    protected final AtomicReference<zzp> f6422c;

    /* JADX INFO: renamed from: d */
    protected final GoogleApiAvailability f6423d;

    /* JADX INFO: renamed from: e */
    private final Handler f6424e;

    protected zzo(zzcf zzcfVar) {
        this(zzcfVar, GoogleApiAvailability.m6828a());
    }

    private zzo(zzcf zzcfVar, GoogleApiAvailability googleApiAvailability) {
        super(zzcfVar);
        this.f6422c = new AtomicReference<>(null);
        this.f6424e = new Handler(Looper.getMainLooper());
        this.f6423d = googleApiAvailability;
    }

    /* JADX INFO: renamed from: a */
    private static int m7228a(zzp zzpVar) {
        if (zzpVar == null) {
            return -1;
        }
        return zzpVar.m7231a();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:23:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:4:0x0011  */
    /* JADX WARN: Removed duplicated region for block: B:6:0x0014  */
    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void mo6951a(int r7, int r8, android.content.Intent r9) {
        /*
            r6 = this;
            r5 = 18
            r1 = 13
            r2 = 1
            r3 = 0
            java.util.concurrent.atomic.AtomicReference<com.google.android.gms.common.api.internal.zzp> r0 = r6.f6422c
            java.lang.Object r0 = r0.get()
            com.google.android.gms.common.api.internal.zzp r0 = (com.google.android.gms.common.api.internal.zzp) r0
            switch(r7) {
                case 1: goto L34;
                case 2: goto L18;
                default: goto L11;
            }
        L11:
            r1 = r3
        L12:
            if (r1 == 0) goto L5a
            r6.m7230h()
        L17:
            return
        L18:
            com.google.android.gms.common.GoogleApiAvailability r1 = r6.f6423d
            android.app.Activity r4 = r6.m6950a()
            int r4 = r1.mo6834a(r4)
            if (r4 != 0) goto L68
            r1 = r2
        L25:
            if (r0 == 0) goto L17
            com.google.android.gms.common.ConnectionResult r2 = r0.m7232b()
            int r2 = r2.m6822c()
            if (r2 != r5) goto L12
            if (r4 != r5) goto L12
            goto L17
        L34:
            r4 = -1
            if (r8 != r4) goto L39
            r1 = r2
            goto L12
        L39:
            if (r8 != 0) goto L11
            if (r9 == 0) goto L43
            java.lang.String r2 = "<<ResolutionFailureErrorDetail>>"
            int r1 = r9.getIntExtra(r2, r1)
        L43:
            com.google.android.gms.common.api.internal.zzp r2 = new com.google.android.gms.common.api.internal.zzp
            com.google.android.gms.common.ConnectionResult r4 = new com.google.android.gms.common.ConnectionResult
            r5 = 0
            r4.<init>(r1, r5)
            int r0 = m7228a(r0)
            r2.<init>(r4, r0)
            java.util.concurrent.atomic.AtomicReference<com.google.android.gms.common.api.internal.zzp> r0 = r6.f6422c
            r0.set(r2)
            r0 = r2
            r1 = r3
            goto L12
        L5a:
            if (r0 == 0) goto L17
            com.google.android.gms.common.ConnectionResult r1 = r0.m7232b()
            int r0 = r0.m7231a()
            r6.mo7010a(r1, r0)
            goto L17
        L68:
            r1 = r3
            goto L25
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.internal.zzo.mo6951a(int, int, android.content.Intent):void");
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    /* JADX INFO: renamed from: a */
    public final void mo6952a(Bundle bundle) {
        super.mo6952a(bundle);
        if (bundle != null) {
            this.f6422c.set(bundle.getBoolean("resolving_error", false) ? new zzp(new ConnectionResult(bundle.getInt("failed_status"), (PendingIntent) bundle.getParcelable("failed_resolution")), bundle.getInt("failed_client_id", -1)) : null);
        }
    }

    /* JADX INFO: renamed from: a */
    protected abstract void mo7010a(ConnectionResult connectionResult, int i);

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    /* JADX INFO: renamed from: b */
    public void mo6954b() {
        super.mo6954b();
        this.f6421b = true;
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    /* JADX INFO: renamed from: b */
    public final void mo6955b(Bundle bundle) {
        super.mo6955b(bundle);
        zzp zzpVar = this.f6422c.get();
        if (zzpVar != null) {
            bundle.putBoolean("resolving_error", true);
            bundle.putInt("failed_client_id", zzpVar.m7231a());
            bundle.putInt("failed_status", zzpVar.m7232b().m6822c());
            bundle.putParcelable("failed_resolution", zzpVar.m7232b().m6823d());
        }
    }

    /* JADX INFO: renamed from: b */
    public final void m7229b(ConnectionResult connectionResult, int i) {
        zzp zzpVar = new zzp(connectionResult, i);
        if (this.f6422c.compareAndSet(null, zzpVar)) {
            this.f6424e.post(new zzq(this, zzpVar));
        }
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    /* JADX INFO: renamed from: d */
    public void mo6957d() {
        super.mo6957d();
        this.f6421b = false;
    }

    /* JADX INFO: renamed from: f */
    protected abstract void mo7011f();

    /* JADX INFO: renamed from: h */
    protected final void m7230h() {
        this.f6422c.set(null);
        mo7011f();
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        mo7010a(new ConnectionResult(13, null), m7228a(this.f6422c.get()));
        m7230h();
    }
}
