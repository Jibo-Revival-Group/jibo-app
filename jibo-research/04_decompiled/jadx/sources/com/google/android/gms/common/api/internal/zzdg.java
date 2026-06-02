package com.google.android.gms.common.api.internal;

import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.ResultCallbacks;
import com.google.android.gms.common.api.ResultTransform;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.TransformedResult;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public final class zzdg<R extends Result> extends TransformedResult<R> implements ResultCallback<R> {

    /* JADX INFO: renamed from: a */
    private ResultTransform<? super R, ? extends Result> f6378a;

    /* JADX INFO: renamed from: b */
    private zzdg<? extends Result> f6379b;

    /* JADX INFO: renamed from: c */
    private volatile ResultCallbacks<? super R> f6380c;

    /* JADX INFO: renamed from: d */
    private PendingResult<R> f6381d;

    /* JADX INFO: renamed from: e */
    private final Object f6382e;

    /* JADX INFO: renamed from: f */
    private Status f6383f;

    /* JADX INFO: renamed from: g */
    private final WeakReference<GoogleApiClient> f6384g;

    /* JADX INFO: renamed from: h */
    private final zzdi f6385h;

    /* JADX INFO: renamed from: i */
    private boolean f6386i;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public final void m7189a(Status status) {
        synchronized (this.f6382e) {
            this.f6383f = status;
            m7195b(this.f6383f);
        }
    }

    /* JADX INFO: renamed from: b */
    private final void m7193b() {
        if (this.f6378a == null && this.f6380c == null) {
            return;
        }
        GoogleApiClient googleApiClient = this.f6384g.get();
        if (!this.f6386i && this.f6378a != null && googleApiClient != null) {
            googleApiClient.mo6892a(this);
            this.f6386i = true;
        }
        if (this.f6383f != null) {
            m7195b(this.f6383f);
        } else if (this.f6381d != null) {
            this.f6381d.mo6920a(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: b */
    public static void m7194b(Result result) {
        if (result instanceof Releasable) {
            try {
                ((Releasable) result).mo6926c_();
            } catch (RuntimeException e) {
                String strValueOf = String.valueOf(result);
                Log.w("TransformedResultImpl", new StringBuilder(String.valueOf(strValueOf).length() + 18).append("Unable to release ").append(strValueOf).toString(), e);
            }
        }
    }

    /* JADX INFO: renamed from: b */
    private final void m7195b(Status status) {
        synchronized (this.f6382e) {
            if (this.f6378a != null) {
                Status statusM6932a = this.f6378a.m6932a(status);
                com.google.android.gms.common.internal.zzbq.m7374a(statusM6932a, "onFailure must not return null");
                this.f6379b.m7189a(statusM6932a);
            } else if (m7197c()) {
                this.f6380c.m6929a(status);
            }
        }
    }

    /* JADX INFO: renamed from: c */
    private final boolean m7197c() {
        return (this.f6380c == null || this.f6384g.get() == null) ? false : true;
    }

    /* JADX INFO: renamed from: a */
    final void m7200a() {
        this.f6380c = null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: a */
    public final void m7201a(PendingResult<?> pendingResult) {
        synchronized (this.f6382e) {
            this.f6381d = pendingResult;
            m7193b();
        }
    }

    @Override // com.google.android.gms.common.api.ResultCallback
    /* JADX INFO: renamed from: a */
    public final void mo6928a(R r) {
        synchronized (this.f6382e) {
            if (!r.mo6927a().m6935c()) {
                m7189a(r.mo6927a());
                m7194b(r);
            } else if (this.f6378a != null) {
                zzcs.m7177a().submit(new zzdh(this, r));
            } else if (m7197c()) {
                this.f6380c.m6930b(r);
            }
        }
    }
}
