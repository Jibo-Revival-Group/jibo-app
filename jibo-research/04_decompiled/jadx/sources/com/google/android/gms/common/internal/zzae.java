package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public final class zzae implements Handler.Callback {

    /* JADX INFO: renamed from: a */
    private final zzaf f6529a;

    /* JADX INFO: renamed from: h */
    private final Handler f6536h;

    /* JADX INFO: renamed from: b */
    private final ArrayList<GoogleApiClient.ConnectionCallbacks> f6530b = new ArrayList<>();

    /* JADX INFO: renamed from: c */
    private ArrayList<GoogleApiClient.ConnectionCallbacks> f6531c = new ArrayList<>();

    /* JADX INFO: renamed from: d */
    private final ArrayList<GoogleApiClient.OnConnectionFailedListener> f6532d = new ArrayList<>();

    /* JADX INFO: renamed from: e */
    private volatile boolean f6533e = false;

    /* JADX INFO: renamed from: f */
    private final AtomicInteger f6534f = new AtomicInteger(0);

    /* JADX INFO: renamed from: g */
    private boolean f6535g = false;

    /* JADX INFO: renamed from: i */
    private final Object f6537i = new Object();

    public zzae(Looper looper, zzaf zzafVar) {
        this.f6529a = zzafVar;
        this.f6536h = new Handler(looper, this);
    }

    /* JADX INFO: renamed from: a */
    public final void m7318a() {
        this.f6533e = false;
        this.f6534f.incrementAndGet();
    }

    /* JADX INFO: renamed from: a */
    public final void m7319a(int i) {
        int i2 = 0;
        zzbq.m7379a(Looper.myLooper() == this.f6536h.getLooper(), "onUnintentionalDisconnection must only be called on the Handler thread");
        this.f6536h.removeMessages(1);
        synchronized (this.f6537i) {
            this.f6535g = true;
            ArrayList arrayList = new ArrayList(this.f6530b);
            int i3 = this.f6534f.get();
            ArrayList arrayList2 = arrayList;
            int size = arrayList2.size();
            while (i2 < size) {
                Object obj = arrayList2.get(i2);
                i2++;
                GoogleApiClient.ConnectionCallbacks connectionCallbacks = (GoogleApiClient.ConnectionCallbacks) obj;
                if (!this.f6533e || this.f6534f.get() != i3) {
                    break;
                } else if (this.f6530b.contains(connectionCallbacks)) {
                    connectionCallbacks.mo6914a(i);
                }
            }
            this.f6531c.clear();
            this.f6535g = false;
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m7320a(Bundle bundle) {
        int i = 0;
        zzbq.m7379a(Looper.myLooper() == this.f6536h.getLooper(), "onConnectionSuccess must only be called on the Handler thread");
        synchronized (this.f6537i) {
            zzbq.m7378a(!this.f6535g);
            this.f6536h.removeMessages(1);
            this.f6535g = true;
            zzbq.m7378a(this.f6531c.size() == 0);
            ArrayList arrayList = new ArrayList(this.f6530b);
            int i2 = this.f6534f.get();
            ArrayList arrayList2 = arrayList;
            int size = arrayList2.size();
            while (i < size) {
                Object obj = arrayList2.get(i);
                i++;
                GoogleApiClient.ConnectionCallbacks connectionCallbacks = (GoogleApiClient.ConnectionCallbacks) obj;
                if (!this.f6533e || !this.f6529a.mo7076g() || this.f6534f.get() != i2) {
                    break;
                } else if (!this.f6531c.contains(connectionCallbacks)) {
                    connectionCallbacks.mo6915a(bundle);
                }
            }
            this.f6531c.clear();
            this.f6535g = false;
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m7321a(ConnectionResult connectionResult) {
        int i = 0;
        zzbq.m7379a(Looper.myLooper() == this.f6536h.getLooper(), "onConnectionFailure must only be called on the Handler thread");
        this.f6536h.removeMessages(1);
        synchronized (this.f6537i) {
            ArrayList arrayList = new ArrayList(this.f6532d);
            int i2 = this.f6534f.get();
            ArrayList arrayList2 = arrayList;
            int size = arrayList2.size();
            while (i < size) {
                Object obj = arrayList2.get(i);
                i++;
                GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener = (GoogleApiClient.OnConnectionFailedListener) obj;
                if (!this.f6533e || this.f6534f.get() != i2) {
                    return;
                }
                if (this.f6532d.contains(onConnectionFailedListener)) {
                    onConnectionFailedListener.mo6916a(connectionResult);
                }
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m7322a(GoogleApiClient.ConnectionCallbacks connectionCallbacks) {
        zzbq.m7373a(connectionCallbacks);
        synchronized (this.f6537i) {
            if (this.f6530b.contains(connectionCallbacks)) {
                String strValueOf = String.valueOf(connectionCallbacks);
                Log.w("GmsClientEvents", new StringBuilder(String.valueOf(strValueOf).length() + 62).append("registerConnectionCallbacks(): listener ").append(strValueOf).append(" is already registered").toString());
            } else {
                this.f6530b.add(connectionCallbacks);
            }
        }
        if (this.f6529a.mo7076g()) {
            this.f6536h.sendMessage(this.f6536h.obtainMessage(1, connectionCallbacks));
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m7323a(GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        zzbq.m7373a(onConnectionFailedListener);
        synchronized (this.f6537i) {
            if (this.f6532d.contains(onConnectionFailedListener)) {
                String strValueOf = String.valueOf(onConnectionFailedListener);
                Log.w("GmsClientEvents", new StringBuilder(String.valueOf(strValueOf).length() + 67).append("registerConnectionFailedListener(): listener ").append(strValueOf).append(" is already registered").toString());
            } else {
                this.f6532d.add(onConnectionFailedListener);
            }
        }
    }

    /* JADX INFO: renamed from: b */
    public final void m7324b() {
        this.f6533e = true;
    }

    /* JADX INFO: renamed from: b */
    public final void m7325b(GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        zzbq.m7373a(onConnectionFailedListener);
        synchronized (this.f6537i) {
            if (!this.f6532d.remove(onConnectionFailedListener)) {
                String strValueOf = String.valueOf(onConnectionFailedListener);
                Log.w("GmsClientEvents", new StringBuilder(String.valueOf(strValueOf).length() + 57).append("unregisterConnectionFailedListener(): listener ").append(strValueOf).append(" not found").toString());
            }
        }
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        if (message.what != 1) {
            Log.wtf("GmsClientEvents", new StringBuilder(45).append("Don't know how to handle message: ").append(message.what).toString(), new Exception());
            return false;
        }
        GoogleApiClient.ConnectionCallbacks connectionCallbacks = (GoogleApiClient.ConnectionCallbacks) message.obj;
        synchronized (this.f6537i) {
            if (this.f6533e && this.f6529a.mo7076g() && this.f6530b.contains(connectionCallbacks)) {
                connectionCallbacks.mo6915a(this.f6529a.mo7075a());
            }
        }
        return true;
    }
}
