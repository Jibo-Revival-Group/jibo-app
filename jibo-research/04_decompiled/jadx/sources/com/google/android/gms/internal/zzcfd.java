package com.google.android.gms.internal;

import android.content.ContentProviderClient;
import android.content.Context;
import android.location.Location;
import android.os.RemoteException;
import com.google.android.gms.common.api.internal.zzck;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationListener;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class zzcfd {

    /* JADX INFO: renamed from: a */
    private final zzcfu<zzcez> f7005a;

    /* JADX INFO: renamed from: b */
    private final Context f7006b;

    /* JADX INFO: renamed from: c */
    private ContentProviderClient f7007c = null;

    /* JADX INFO: renamed from: d */
    private boolean f7008d = false;

    /* JADX INFO: renamed from: e */
    private final Map<zzck<LocationListener>, zzcfi> f7009e = new HashMap();

    /* JADX INFO: renamed from: f */
    private final Map<zzck<Object>, zzcfh> f7010f = new HashMap();

    /* JADX INFO: renamed from: g */
    private final Map<zzck<LocationCallback>, zzcfe> f7011g = new HashMap();

    public zzcfd(Context context, zzcfu<zzcez> zzcfuVar) {
        this.f7006b = context;
        this.f7005a = zzcfuVar;
    }

    /* JADX INFO: renamed from: a */
    public final Location m7829a() throws RemoteException {
        this.f7005a.mo7820a();
        return ((zzcez) this.f7005a.mo7821b()).mo7824a(this.f7006b.getPackageName());
    }

    /* JADX INFO: renamed from: a */
    public final void m7830a(boolean z) throws RemoteException {
        this.f7005a.mo7820a();
        ((zzcez) this.f7005a.mo7821b()).mo7827a(z);
        this.f7008d = z;
    }

    /* JADX INFO: renamed from: b */
    public final LocationAvailability m7831b() throws RemoteException {
        this.f7005a.mo7820a();
        return ((zzcez) this.f7005a.mo7821b()).mo7828b(this.f7006b.getPackageName());
    }

    /* JADX INFO: renamed from: c */
    public final void m7832c() throws RemoteException {
        synchronized (this.f7009e) {
            for (zzcfi zzcfiVar : this.f7009e.values()) {
                if (zzcfiVar != null) {
                    ((zzcez) this.f7005a.mo7821b()).mo7826a(zzcfq.m7840a(zzcfiVar, (zzceu) null));
                }
            }
            this.f7009e.clear();
        }
        synchronized (this.f7011g) {
            for (zzcfe zzcfeVar : this.f7011g.values()) {
                if (zzcfeVar != null) {
                    ((zzcez) this.f7005a.mo7821b()).mo7826a(zzcfq.m7839a(zzcfeVar, (zzceu) null));
                }
            }
            this.f7011g.clear();
        }
        synchronized (this.f7010f) {
            for (zzcfh zzcfhVar : this.f7010f.values()) {
                if (zzcfhVar != null) {
                    ((zzcez) this.f7005a.mo7821b()).mo7825a(new zzcdz(2, null, zzcfhVar.asBinder(), null));
                }
            }
            this.f7010f.clear();
        }
    }

    /* JADX INFO: renamed from: d */
    public final void m7833d() throws RemoteException {
        if (this.f7008d) {
            m7830a(false);
        }
    }
}
