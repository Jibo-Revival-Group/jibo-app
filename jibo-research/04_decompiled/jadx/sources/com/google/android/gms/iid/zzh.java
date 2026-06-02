package com.google.android.gms.iid;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;

/* JADX INFO: loaded from: classes.dex */
public final class zzh implements ServiceConnection {

    /* JADX INFO: renamed from: a */
    private final Context f6812a;

    /* JADX INFO: renamed from: b */
    private final Intent f6813b;

    /* JADX INFO: renamed from: c */
    private final ScheduledExecutorService f6814c;

    /* JADX INFO: renamed from: d */
    private final Queue<zzd> f6815d;

    /* JADX INFO: renamed from: e */
    private zzf f6816e;

    /* JADX INFO: renamed from: f */
    private boolean f6817f;

    public zzh(Context context, String str) {
        this(context, str, new ScheduledThreadPoolExecutor(0));
    }

    private zzh(Context context, String str, ScheduledExecutorService scheduledExecutorService) {
        this.f6815d = new LinkedList();
        this.f6817f = false;
        this.f6812a = context.getApplicationContext();
        this.f6813b = new Intent(str).setPackage(this.f6812a.getPackageName());
        this.f6814c = scheduledExecutorService;
    }

    /* JADX INFO: renamed from: a */
    private final synchronized void m7622a() {
        if (Log.isLoggable("EnhancedIntentService", 3)) {
            Log.d("EnhancedIntentService", "flush queue called");
        }
        while (!this.f6815d.isEmpty()) {
            if (Log.isLoggable("EnhancedIntentService", 3)) {
                Log.d("EnhancedIntentService", "found intent to be delivered");
            }
            if (this.f6816e == null || !this.f6816e.isBinderAlive()) {
                if (Log.isLoggable("EnhancedIntentService", 3)) {
                    Log.d("EnhancedIntentService", new StringBuilder(39).append("binder is dead. start connection? ").append(!this.f6817f).toString());
                }
                if (!this.f6817f) {
                    this.f6817f = true;
                    try {
                    } catch (SecurityException e) {
                        Log.e("EnhancedIntentService", "Exception while binding the service", e);
                    }
                    if (!com.google.android.gms.common.stats.zza.m7483a().m7484a(this.f6812a, this.f6813b, this, 65)) {
                        Log.e("EnhancedIntentService", "binding to the service failed");
                        while (!this.f6815d.isEmpty()) {
                            this.f6815d.poll().m7619a();
                        }
                    }
                }
            } else {
                if (Log.isLoggable("EnhancedIntentService", 3)) {
                    Log.d("EnhancedIntentService", "binder is alive, sending the intent.");
                }
                this.f6816e.m7621a(this.f6815d.poll());
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public final synchronized void m7623a(Intent intent, BroadcastReceiver.PendingResult pendingResult) {
        if (Log.isLoggable("EnhancedIntentService", 3)) {
            Log.d("EnhancedIntentService", "new intent queued in the bind-strategy delivery");
        }
        this.f6815d.add(new zzd(intent, pendingResult, this.f6814c));
        m7622a();
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        synchronized (this) {
            this.f6817f = false;
            this.f6816e = (zzf) iBinder;
            if (Log.isLoggable("EnhancedIntentService", 3)) {
                String strValueOf = String.valueOf(componentName);
                Log.d("EnhancedIntentService", new StringBuilder(String.valueOf(strValueOf).length() + 20).append("onServiceConnected: ").append(strValueOf).toString());
            }
            m7622a();
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        if (Log.isLoggable("EnhancedIntentService", 3)) {
            String strValueOf = String.valueOf(componentName);
            Log.d("EnhancedIntentService", new StringBuilder(String.valueOf(strValueOf).length() + 23).append("onServiceDisconnected: ").append(strValueOf).toString());
        }
        m7622a();
    }
}
