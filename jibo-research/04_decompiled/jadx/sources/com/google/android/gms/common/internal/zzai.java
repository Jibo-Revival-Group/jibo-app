package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
final class zzai extends zzag implements Handler.Callback {

    /* JADX INFO: renamed from: b */
    private final Context f6545b;

    /* JADX INFO: renamed from: c */
    private final Handler f6546c;

    /* JADX INFO: renamed from: a */
    private final HashMap<zzah, zzaj> f6544a = new HashMap<>();

    /* JADX INFO: renamed from: d */
    private final com.google.android.gms.common.stats.zza f6547d = com.google.android.gms.common.stats.zza.m7483a();

    /* JADX INFO: renamed from: e */
    private final long f6548e = 5000;

    /* JADX INFO: renamed from: f */
    private final long f6549f = 300000;

    zzai(Context context) {
        this.f6545b = context.getApplicationContext();
        this.f6546c = new Handler(context.getMainLooper(), this);
    }

    @Override // com.google.android.gms.common.internal.zzag
    /* JADX INFO: renamed from: a */
    protected final boolean mo7329a(zzah zzahVar, ServiceConnection serviceConnection, String str) {
        boolean zM7343a;
        zzbq.m7374a(serviceConnection, "ServiceConnection must not be null");
        synchronized (this.f6544a) {
            zzaj zzajVar = this.f6544a.get(zzahVar);
            if (zzajVar != null) {
                this.f6546c.removeMessages(0, zzahVar);
                if (!zzajVar.m7344a(serviceConnection)) {
                    zzajVar.m7341a(serviceConnection, str);
                    switch (zzajVar.m7345b()) {
                        case 1:
                            serviceConnection.onServiceConnected(zzajVar.m7350e(), zzajVar.m7349d());
                            break;
                        case 2:
                            zzajVar.m7342a(str);
                            break;
                    }
                } else {
                    String strValueOf = String.valueOf(zzahVar);
                    throw new IllegalStateException(new StringBuilder(String.valueOf(strValueOf).length() + 81).append("Trying to bind a GmsServiceConnection that was already connected before.  config=").append(strValueOf).toString());
                }
            } else {
                zzajVar = new zzaj(this, zzahVar);
                zzajVar.m7341a(serviceConnection, str);
                zzajVar.m7342a(str);
                this.f6544a.put(zzahVar, zzajVar);
            }
            zM7343a = zzajVar.m7343a();
        }
        return zM7343a;
    }

    @Override // com.google.android.gms.common.internal.zzag
    /* JADX INFO: renamed from: b */
    protected final void mo7331b(zzah zzahVar, ServiceConnection serviceConnection, String str) {
        zzbq.m7374a(serviceConnection, "ServiceConnection must not be null");
        synchronized (this.f6544a) {
            zzaj zzajVar = this.f6544a.get(zzahVar);
            if (zzajVar == null) {
                String strValueOf = String.valueOf(zzahVar);
                throw new IllegalStateException(new StringBuilder(String.valueOf(strValueOf).length() + 50).append("Nonexistent connection status for service config: ").append(strValueOf).toString());
            }
            if (!zzajVar.m7344a(serviceConnection)) {
                String strValueOf2 = String.valueOf(zzahVar);
                throw new IllegalStateException(new StringBuilder(String.valueOf(strValueOf2).length() + 76).append("Trying to unbind a GmsServiceConnection  that was not bound before.  config=").append(strValueOf2).toString());
            }
            zzajVar.m7346b(serviceConnection, str);
            if (zzajVar.m7348c()) {
                this.f6546c.sendMessageDelayed(this.f6546c.obtainMessage(0, zzahVar), this.f6548e);
            }
        }
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        switch (message.what) {
            case 0:
                synchronized (this.f6544a) {
                    zzah zzahVar = (zzah) message.obj;
                    zzaj zzajVar = this.f6544a.get(zzahVar);
                    if (zzajVar != null && zzajVar.m7348c()) {
                        if (zzajVar.m7343a()) {
                            zzajVar.m7347b("GmsClientSupervisor");
                        }
                        this.f6544a.remove(zzahVar);
                    }
                    break;
                }
                return true;
            case 1:
                synchronized (this.f6544a) {
                    zzah zzahVar2 = (zzah) message.obj;
                    zzaj zzajVar2 = this.f6544a.get(zzahVar2);
                    if (zzajVar2 != null && zzajVar2.m7345b() == 3) {
                        String strValueOf = String.valueOf(zzahVar2);
                        Log.wtf("GmsClientSupervisor", new StringBuilder(String.valueOf(strValueOf).length() + 47).append("Timeout waiting for ServiceConnection callback ").append(strValueOf).toString(), new Exception());
                        ComponentName componentNameM7350e = zzajVar2.m7350e();
                        if (componentNameM7350e == null) {
                            componentNameM7350e = zzahVar2.m7333b();
                        }
                        zzajVar2.onServiceDisconnected(componentNameM7350e == null ? new ComponentName(zzahVar2.m7332a(), "unknown") : componentNameM7350e);
                    }
                    break;
                }
                return true;
            default:
                return false;
        }
    }
}
