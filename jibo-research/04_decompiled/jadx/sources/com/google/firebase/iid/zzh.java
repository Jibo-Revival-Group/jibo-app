package com.google.firebase.iid;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;

/* JADX INFO: loaded from: classes.dex */
public final class zzh implements ServiceConnection {

    /* JADX INFO: renamed from: a */
    private final Context f8653a;

    /* JADX INFO: renamed from: b */
    private final Intent f8654b;

    /* JADX INFO: renamed from: c */
    private final ScheduledExecutorService f8655c;

    /* JADX INFO: renamed from: d */
    private final Queue<zzd> f8656d;

    /* JADX INFO: renamed from: e */
    private zzf f8657e;

    /* JADX INFO: renamed from: f */
    private boolean f8658f;

    public zzh(Context context, String str) {
        this(context, str, new ScheduledThreadPoolExecutor(0));
    }

    private zzh(Context context, String str, ScheduledExecutorService scheduledExecutorService) {
        this.f8656d = new ArrayDeque();
        this.f8658f = false;
        this.f8653a = context.getApplicationContext();
        this.f8654b = new Intent(str).setPackage(this.f8653a.getPackageName());
        this.f8655c = scheduledExecutorService;
    }

    /* JADX INFO: renamed from: a */
    private final synchronized void m9131a() {
        if (Log.isLoggable("EnhancedIntentService", 3)) {
            Log.d("EnhancedIntentService", "flush queue called");
        }
        while (!this.f8656d.isEmpty()) {
            if (Log.isLoggable("EnhancedIntentService", 3)) {
                Log.d("EnhancedIntentService", "found intent to be delivered");
            }
            if (this.f8657e == null || !this.f8657e.isBinderAlive()) {
                if (Log.isLoggable("EnhancedIntentService", 3)) {
                    Log.d("EnhancedIntentService", new StringBuilder(39).append("binder is dead. start connection? ").append(!this.f8658f).toString());
                }
                if (!this.f8658f) {
                    this.f8658f = true;
                    try {
                    } catch (SecurityException e) {
                        Log.e("EnhancedIntentService", "Exception while binding the service", e);
                    }
                    if (!com.google.android.gms.common.stats.zza.m7483a().m7484a(this.f8653a, this.f8654b, this, 65)) {
                        Log.e("EnhancedIntentService", "binding to the service failed");
                        while (!this.f8656d.isEmpty()) {
                            this.f8656d.poll().m9128a();
                        }
                    }
                }
            } else {
                if (Log.isLoggable("EnhancedIntentService", 3)) {
                    Log.d("EnhancedIntentService", "binder is alive, sending the intent.");
                }
                this.f8657e.m9130a(this.f8656d.poll());
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public final synchronized void m9132a(Intent intent, BroadcastReceiver.PendingResult pendingResult) {
        if (Log.isLoggable("EnhancedIntentService", 3)) {
            Log.d("EnhancedIntentService", "new intent queued in the bind-strategy delivery");
        }
        this.f8656d.add(new zzd(intent, pendingResult, this.f8655c));
        m9131a();
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        synchronized (this) {
            this.f8658f = false;
            this.f8657e = (zzf) iBinder;
            if (Log.isLoggable("EnhancedIntentService", 3)) {
                String strValueOf = String.valueOf(componentName);
                Log.d("EnhancedIntentService", new StringBuilder(String.valueOf(strValueOf).length() + 20).append("onServiceConnected: ").append(strValueOf).toString());
            }
            m9131a();
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        if (Log.isLoggable("EnhancedIntentService", 3)) {
            String strValueOf = String.valueOf(componentName);
            Log.d("EnhancedIntentService", new StringBuilder(String.valueOf(strValueOf).length() + 23).append("onServiceDisconnected: ").append(strValueOf).toString());
        }
        m9131a();
    }
}
