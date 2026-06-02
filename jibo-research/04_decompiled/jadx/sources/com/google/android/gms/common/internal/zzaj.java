package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
final class zzaj implements ServiceConnection {

    /* JADX INFO: renamed from: a */
    private final Set<ServiceConnection> f6550a = new HashSet();

    /* JADX INFO: renamed from: b */
    private int f6551b = 2;

    /* JADX INFO: renamed from: c */
    private boolean f6552c;

    /* JADX INFO: renamed from: d */
    private IBinder f6553d;

    /* JADX INFO: renamed from: e */
    private final zzah f6554e;

    /* JADX INFO: renamed from: f */
    private ComponentName f6555f;

    /* JADX INFO: renamed from: g */
    private /* synthetic */ zzai f6556g;

    public zzaj(zzai zzaiVar, zzah zzahVar) {
        this.f6556g = zzaiVar;
        this.f6554e = zzahVar;
    }

    /* JADX INFO: renamed from: a */
    public final void m7341a(ServiceConnection serviceConnection, String str) {
        com.google.android.gms.common.stats.zza unused = this.f6556g.f6547d;
        Context unused2 = this.f6556g.f6545b;
        this.f6554e.m7335d();
        this.f6550a.add(serviceConnection);
    }

    /* JADX INFO: renamed from: a */
    public final void m7342a(String str) {
        this.f6551b = 3;
        this.f6552c = this.f6556g.f6547d.m7485a(this.f6556g.f6545b, str, this.f6554e.m7335d(), this, this.f6554e.m7334c());
        if (this.f6552c) {
            this.f6556g.f6546c.sendMessageDelayed(this.f6556g.f6546c.obtainMessage(1, this.f6554e), this.f6556g.f6549f);
        } else {
            this.f6551b = 2;
            try {
                com.google.android.gms.common.stats.zza unused = this.f6556g.f6547d;
                this.f6556g.f6545b.unbindService(this);
            } catch (IllegalArgumentException e) {
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public final boolean m7343a() {
        return this.f6552c;
    }

    /* JADX INFO: renamed from: a */
    public final boolean m7344a(ServiceConnection serviceConnection) {
        return this.f6550a.contains(serviceConnection);
    }

    /* JADX INFO: renamed from: b */
    public final int m7345b() {
        return this.f6551b;
    }

    /* JADX INFO: renamed from: b */
    public final void m7346b(ServiceConnection serviceConnection, String str) {
        com.google.android.gms.common.stats.zza unused = this.f6556g.f6547d;
        Context unused2 = this.f6556g.f6545b;
        this.f6550a.remove(serviceConnection);
    }

    /* JADX INFO: renamed from: b */
    public final void m7347b(String str) {
        this.f6556g.f6546c.removeMessages(1, this.f6554e);
        com.google.android.gms.common.stats.zza unused = this.f6556g.f6547d;
        this.f6556g.f6545b.unbindService(this);
        this.f6552c = false;
        this.f6551b = 2;
    }

    /* JADX INFO: renamed from: c */
    public final boolean m7348c() {
        return this.f6550a.isEmpty();
    }

    /* JADX INFO: renamed from: d */
    public final IBinder m7349d() {
        return this.f6553d;
    }

    /* JADX INFO: renamed from: e */
    public final ComponentName m7350e() {
        return this.f6555f;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        synchronized (this.f6556g.f6544a) {
            this.f6556g.f6546c.removeMessages(1, this.f6554e);
            this.f6553d = iBinder;
            this.f6555f = componentName;
            Iterator<ServiceConnection> it = this.f6550a.iterator();
            while (it.hasNext()) {
                it.next().onServiceConnected(componentName, iBinder);
            }
            this.f6551b = 1;
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        synchronized (this.f6556g.f6544a) {
            this.f6556g.f6546c.removeMessages(1, this.f6554e);
            this.f6553d = null;
            this.f6555f = componentName;
            Iterator<ServiceConnection> it = this.f6550a.iterator();
            while (it.hasNext()) {
                it.next().onServiceDisconnected(componentName);
            }
            this.f6551b = 2;
        }
    }
}
