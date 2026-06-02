package com.google.android.gms.iid;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;
import com.google.android.gms.internal.zzcxs;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzb extends Service {

    /* JADX INFO: renamed from: b */
    private Binder f6796b;

    /* JADX INFO: renamed from: d */
    private int f6798d;

    /* JADX INFO: renamed from: a */
    final ExecutorService f6795a = Executors.newSingleThreadExecutor();

    /* JADX INFO: renamed from: c */
    private final Object f6797c = new Object();

    /* JADX INFO: renamed from: e */
    private int f6799e = 0;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public final void m7617a(Intent intent) {
        if (intent != null) {
            zzcxs.m1899a(intent);
        }
        synchronized (this.f6797c) {
            this.f6799e--;
            if (this.f6799e == 0) {
                stopSelfResult(this.f6798d);
            }
        }
    }

    public abstract void handleIntent(Intent intent);

    @Override // android.app.Service
    public final synchronized IBinder onBind(Intent intent) {
        if (Log.isLoggable("EnhancedIntentService", 3)) {
            Log.d("EnhancedIntentService", "Service received bind request");
        }
        if (this.f6796b == null) {
            this.f6796b = new zzf(this);
        }
        return this.f6796b;
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent intent, int i, int i2) {
        synchronized (this.f6797c) {
            this.f6798d = i2;
            this.f6799e++;
        }
        if (intent == null) {
            m7617a(intent);
            return 2;
        }
        this.f6795a.execute(new zzc(this, intent, intent));
        return 3;
    }
}
