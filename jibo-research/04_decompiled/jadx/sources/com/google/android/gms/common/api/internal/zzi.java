package com.google.android.gms.common.api.internal;

import android.util.Log;
import android.util.SparseArray;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes.dex */
public class zzi extends zzo {

    /* JADX INFO: renamed from: e */
    private final SparseArray<zza> f6404e;

    class zza implements GoogleApiClient.OnConnectionFailedListener {

        /* JADX INFO: renamed from: a */
        public final int f6405a;

        /* JADX INFO: renamed from: b */
        public final GoogleApiClient f6406b;

        /* JADX INFO: renamed from: c */
        public final GoogleApiClient.OnConnectionFailedListener f6407c;

        public zza(int i, GoogleApiClient googleApiClient, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
            this.f6405a = i;
            this.f6406b = googleApiClient;
            this.f6407c = onConnectionFailedListener;
            googleApiClient.mo6891a(this);
        }

        @Override // com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener
        /* JADX INFO: renamed from: a */
        public final void mo6916a(ConnectionResult connectionResult) {
            String strValueOf = String.valueOf(connectionResult);
            Log.d("AutoManageHelper", new StringBuilder(String.valueOf(strValueOf).length() + 27).append("beginFailureResolution for ").append(strValueOf).toString());
            zzi.this.m7229b(connectionResult, this.f6405a);
        }
    }

    private zzi(zzcf zzcfVar) {
        super(zzcfVar);
        this.f6404e = new SparseArray<>();
        this.f6157a.mo7165a("AutoManageHelper", this);
    }

    /* JADX INFO: renamed from: b */
    private final zza m7211b(int i) {
        if (this.f6404e.size() <= i) {
            return null;
        }
        return this.f6404e.get(this.f6404e.keyAt(i));
    }

    /* JADX INFO: renamed from: b */
    public static zzi m7212b(zzce zzceVar) {
        zzcf zzcfVarA = m6949a(zzceVar);
        zzi zziVar = (zzi) zzcfVarA.mo7164a("AutoManageHelper", zzi.class);
        return zziVar != null ? zziVar : new zzi(zzcfVarA);
    }

    /* JADX INFO: renamed from: a */
    public final void m7213a(int i) {
        zza zzaVar = this.f6404e.get(i);
        this.f6404e.remove(i);
        if (zzaVar != null) {
            zzaVar.f6406b.mo6897b(zzaVar);
            zzaVar.f6406b.mo6903g();
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m7214a(int i, GoogleApiClient googleApiClient, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        com.google.android.gms.common.internal.zzbq.m7374a(googleApiClient, "GoogleApiClient instance cannot be null");
        com.google.android.gms.common.internal.zzbq.m7379a(this.f6404e.indexOfKey(i) < 0, new StringBuilder(54).append("Already managing a GoogleApiClient with id ").append(i).toString());
        zzp zzpVar = this.f6422c.get();
        boolean z = this.f6421b;
        String strValueOf = String.valueOf(zzpVar);
        Log.d("AutoManageHelper", new StringBuilder(String.valueOf(strValueOf).length() + 49).append("starting AutoManage for client ").append(i).append(" ").append(z).append(" ").append(strValueOf).toString());
        this.f6404e.put(i, new zza(i, googleApiClient, onConnectionFailedListener));
        if (this.f6421b && zzpVar == null) {
            String strValueOf2 = String.valueOf(googleApiClient);
            Log.d("AutoManageHelper", new StringBuilder(String.valueOf(strValueOf2).length() + 11).append("connecting ").append(strValueOf2).toString());
            googleApiClient.mo6901e();
        }
    }

    @Override // com.google.android.gms.common.api.internal.zzo
    /* JADX INFO: renamed from: a */
    protected final void mo7010a(ConnectionResult connectionResult, int i) {
        Log.w("AutoManageHelper", "Unresolved error while connecting client. Stopping auto-manage.");
        if (i < 0) {
            Log.wtf("AutoManageHelper", "AutoManageLifecycleHelper received onErrorResolutionFailed callback but no failing client ID is set", new Exception());
            return;
        }
        zza zzaVar = this.f6404e.get(i);
        if (zzaVar != null) {
            m7213a(i);
            GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener = zzaVar.f6407c;
            if (onConnectionFailedListener != null) {
                onConnectionFailedListener.mo6916a(connectionResult);
            }
        }
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    /* JADX INFO: renamed from: a */
    public final void mo6953a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        for (int i = 0; i < this.f6404e.size(); i++) {
            zza zzaVarM7211b = m7211b(i);
            if (zzaVarM7211b != null) {
                printWriter.append((CharSequence) str).append("GoogleApiClient #").print(zzaVarM7211b.f6405a);
                printWriter.println(":");
                zzaVarM7211b.f6406b.mo6893a(String.valueOf(str).concat("  "), fileDescriptor, printWriter, strArr);
            }
        }
    }

    @Override // com.google.android.gms.common.api.internal.zzo, com.google.android.gms.common.api.internal.LifecycleCallback
    /* JADX INFO: renamed from: b */
    public final void mo6954b() {
        super.mo6954b();
        boolean z = this.f6421b;
        String strValueOf = String.valueOf(this.f6404e);
        Log.d("AutoManageHelper", new StringBuilder(String.valueOf(strValueOf).length() + 14).append("onStart ").append(z).append(" ").append(strValueOf).toString());
        if (this.f6422c.get() == null) {
            for (int i = 0; i < this.f6404e.size(); i++) {
                zza zzaVarM7211b = m7211b(i);
                if (zzaVarM7211b != null) {
                    zzaVarM7211b.f6406b.mo6901e();
                }
            }
        }
    }

    @Override // com.google.android.gms.common.api.internal.zzo, com.google.android.gms.common.api.internal.LifecycleCallback
    /* JADX INFO: renamed from: d */
    public final void mo6957d() {
        super.mo6957d();
        for (int i = 0; i < this.f6404e.size(); i++) {
            zza zzaVarM7211b = m7211b(i);
            if (zzaVarM7211b != null) {
                zzaVarM7211b.f6406b.mo6903g();
            }
        }
    }

    @Override // com.google.android.gms.common.api.internal.zzo
    /* JADX INFO: renamed from: f */
    protected final void mo7011f() {
        for (int i = 0; i < this.f6404e.size(); i++) {
            zza zzaVarM7211b = m7211b(i);
            if (zzaVarM7211b != null) {
                zzaVarM7211b.f6406b.mo6901e();
            }
        }
    }
}
