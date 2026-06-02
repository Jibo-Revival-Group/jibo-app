package com.google.firebase.iid;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;
import android.util.SparseArray;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.common.internal.zzbq;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
final class zzk implements ServiceConnection {

    /* JADX INFO: renamed from: a */
    int f8664a;

    /* JADX INFO: renamed from: b */
    final Messenger f8665b;

    /* JADX INFO: renamed from: c */
    zzp f8666c;

    /* JADX INFO: renamed from: d */
    final Queue<zzr<?>> f8667d;

    /* JADX INFO: renamed from: e */
    final SparseArray<zzr<?>> f8668e;

    /* JADX INFO: renamed from: f */
    final /* synthetic */ zzi f8669f;

    private zzk(zzi zziVar) {
        this.f8669f = zziVar;
        this.f8664a = 0;
        this.f8665b = new Messenger(new Handler(Looper.getMainLooper(), new Handler.Callback(this) { // from class: com.google.firebase.iid.zzl

            /* JADX INFO: renamed from: a */
            private final zzk f8670a;

            {
                this.f8670a = this;
            }

            @Override // android.os.Handler.Callback
            public final boolean handleMessage(Message message) {
                return this.f8670a.m9145a(message);
            }
        }));
        this.f8667d = new ArrayDeque();
        this.f8668e = new SparseArray<>();
    }

    /* JADX INFO: renamed from: a */
    private final void m9140a(zzs zzsVar) {
        Iterator<zzr<?>> it = this.f8667d.iterator();
        while (it.hasNext()) {
            it.next().m9151a(zzsVar);
        }
        this.f8667d.clear();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.f8668e.size()) {
                this.f8668e.clear();
                return;
            } else {
                this.f8668e.valueAt(i2).m9151a(zzsVar);
                i = i2 + 1;
            }
        }
    }

    /* JADX INFO: renamed from: c */
    private final void m9141c() {
        this.f8669f.f8661c.execute(new Runnable(this) { // from class: com.google.firebase.iid.zzn

            /* JADX INFO: renamed from: a */
            private final zzk f8672a;

            {
                this.f8672a = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                final zzr<?> zzrVarPoll;
                final zzk zzkVar = this.f8672a;
                while (true) {
                    synchronized (zzkVar) {
                        if (zzkVar.f8664a != 2) {
                            return;
                        }
                        if (zzkVar.f8667d.isEmpty()) {
                            zzkVar.m9142a();
                            return;
                        } else {
                            zzrVarPoll = zzkVar.f8667d.poll();
                            zzkVar.f8668e.put(zzrVarPoll.f8677a, zzrVarPoll);
                            zzkVar.f8669f.f8661c.schedule(new Runnable(zzkVar, zzrVarPoll) { // from class: com.google.firebase.iid.zzo

                                /* JADX INFO: renamed from: a */
                                private final zzk f8673a;

                                /* JADX INFO: renamed from: b */
                                private final zzr f8674b;

                                {
                                    this.f8673a = zzkVar;
                                    this.f8674b = zzrVarPoll;
                                }

                                @Override // java.lang.Runnable
                                public final void run() {
                                    this.f8673a.m9143a(this.f8674b.f8677a);
                                }
                            }, 30L, TimeUnit.SECONDS);
                        }
                    }
                    if (Log.isLoggable("MessengerIpcClient", 3)) {
                        String strValueOf = String.valueOf(zzrVarPoll);
                        Log.d("MessengerIpcClient", new StringBuilder(String.valueOf(strValueOf).length() + 8).append("Sending ").append(strValueOf).toString());
                    }
                    Context context = zzkVar.f8669f.f8660b;
                    Messenger messenger = zzkVar.f8665b;
                    Message messageObtain = Message.obtain();
                    messageObtain.what = zzrVarPoll.f8679c;
                    messageObtain.arg1 = zzrVarPoll.f8677a;
                    messageObtain.replyTo = messenger;
                    Bundle bundle = new Bundle();
                    bundle.putBoolean("oneWay", zzrVarPoll.mo9150a());
                    bundle.putString("pkg", context.getPackageName());
                    bundle.putBundle(ShareConstants.WEB_DIALOG_PARAM_DATA, zzrVarPoll.f8680d);
                    messageObtain.setData(bundle);
                    try {
                        zzkVar.f8666c.m9148a(messageObtain);
                    } catch (RemoteException e) {
                        zzkVar.m9144a(2, e.getMessage());
                    }
                }
            }
        });
    }

    /* JADX INFO: renamed from: a */
    final synchronized void m9142a() {
        if (this.f8664a == 2 && this.f8667d.isEmpty() && this.f8668e.size() == 0) {
            if (Log.isLoggable("MessengerIpcClient", 2)) {
                Log.v("MessengerIpcClient", "Finished handling requests, unbinding");
            }
            this.f8664a = 3;
            com.google.android.gms.common.stats.zza.m7483a();
            this.f8669f.f8660b.unbindService(this);
        }
    }

    /* JADX INFO: renamed from: a */
    final synchronized void m9143a(int i) {
        zzr<?> zzrVar = this.f8668e.get(i);
        if (zzrVar != null) {
            Log.w("MessengerIpcClient", new StringBuilder(31).append("Timing out request: ").append(i).toString());
            this.f8668e.remove(i);
            zzrVar.m9151a(new zzs(3, "Timed out waiting for response"));
            m9142a();
        }
    }

    /* JADX INFO: renamed from: a */
    final synchronized void m9144a(int i, String str) {
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            String strValueOf = String.valueOf(str);
            Log.d("MessengerIpcClient", strValueOf.length() != 0 ? "Disconnected: ".concat(strValueOf) : new String("Disconnected: "));
        }
        switch (this.f8664a) {
            case 0:
                throw new IllegalStateException();
            case 1:
            case 2:
                if (Log.isLoggable("MessengerIpcClient", 2)) {
                    Log.v("MessengerIpcClient", "Unbinding service");
                }
                this.f8664a = 4;
                com.google.android.gms.common.stats.zza.m7483a();
                this.f8669f.f8660b.unbindService(this);
                m9140a(new zzs(i, str));
                break;
            case 3:
                this.f8664a = 4;
                break;
            case 4:
                break;
            default:
                throw new IllegalStateException(new StringBuilder(26).append("Unknown state: ").append(this.f8664a).toString());
        }
    }

    /* JADX INFO: renamed from: a */
    final boolean m9145a(Message message) {
        int i = message.arg1;
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            Log.d("MessengerIpcClient", new StringBuilder(41).append("Received response to request: ").append(i).toString());
        }
        synchronized (this) {
            zzr<?> zzrVar = this.f8668e.get(i);
            if (zzrVar == null) {
                Log.w("MessengerIpcClient", new StringBuilder(50).append("Received response for unknown request: ").append(i).toString());
            } else {
                this.f8668e.remove(i);
                m9142a();
                Bundle data = message.getData();
                if (data.getBoolean("unsupported", false)) {
                    zzrVar.m9151a(new zzs(4, "Not supported by GmsCore"));
                } else {
                    zzrVar.mo9149a(data);
                }
            }
        }
        return true;
    }

    /* JADX INFO: renamed from: a */
    final synchronized boolean m9146a(zzr zzrVar) {
        boolean z = true;
        synchronized (this) {
            switch (this.f8664a) {
                case 0:
                    this.f8667d.add(zzrVar);
                    zzbq.m7378a(this.f8664a == 0);
                    if (Log.isLoggable("MessengerIpcClient", 2)) {
                        Log.v("MessengerIpcClient", "Starting bind to GmsCore");
                    }
                    this.f8664a = 1;
                    Intent intent = new Intent("com.google.android.c2dm.intent.REGISTER");
                    intent.setPackage("com.google.android.gms");
                    if (!com.google.android.gms.common.stats.zza.m7483a().m7484a(this.f8669f.f8660b, intent, this, 1)) {
                        m9144a(0, "Unable to bind to service");
                    } else {
                        this.f8669f.f8661c.schedule(new Runnable(this) { // from class: com.google.firebase.iid.zzm

                            /* JADX INFO: renamed from: a */
                            private final zzk f8671a;

                            {
                                this.f8671a = this;
                            }

                            @Override // java.lang.Runnable
                            public final void run() {
                                this.f8671a.m9147b();
                            }
                        }, 30L, TimeUnit.SECONDS);
                    }
                    break;
                case 1:
                    this.f8667d.add(zzrVar);
                    break;
                case 2:
                    this.f8667d.add(zzrVar);
                    m9141c();
                    break;
                case 3:
                case 4:
                    z = false;
                    break;
                default:
                    throw new IllegalStateException(new StringBuilder(26).append("Unknown state: ").append(this.f8664a).toString());
            }
        }
        return z;
    }

    /* JADX INFO: renamed from: b */
    final synchronized void m9147b() {
        if (this.f8664a == 1) {
            m9144a(1, "Timed out while binding");
        }
    }

    @Override // android.content.ServiceConnection
    public final synchronized void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if (Log.isLoggable("MessengerIpcClient", 2)) {
            Log.v("MessengerIpcClient", "Service connected");
        }
        if (iBinder == null) {
            m9144a(0, "Null service connection");
        } else {
            try {
                this.f8666c = new zzp(iBinder);
                this.f8664a = 2;
                m9141c();
            } catch (RemoteException e) {
                m9144a(0, e.getMessage());
            }
        }
    }

    @Override // android.content.ServiceConnection
    public final synchronized void onServiceDisconnected(ComponentName componentName) {
        if (Log.isLoggable("MessengerIpcClient", 2)) {
            Log.v("MessengerIpcClient", "Service disconnected");
        }
        m9144a(2, "Service disconnected");
    }
}
