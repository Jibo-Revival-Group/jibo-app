package com.google.firebase.iid;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.v4.content.WakefulBroadcastReceiver;
import android.util.Log;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzb extends Service {

    /* JADX INFO: renamed from: b */
    private Binder f8637b;

    /* JADX INFO: renamed from: d */
    private int f8639d;

    /* JADX INFO: renamed from: a */
    final ExecutorService f8636a = Executors.newSingleThreadExecutor();

    /* JADX INFO: renamed from: c */
    private final Object f8638c = new Object();

    /* JADX INFO: renamed from: e */
    private int f8640e = 0;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: d */
    public final void m9126d(Intent intent) {
        if (intent != null) {
            WakefulBroadcastReceiver.m1899a(intent);
        }
        synchronized (this.f8638c) {
            this.f8640e--;
            if (this.f8640e == 0) {
                stopSelfResult(this.f8639d);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    protected Intent mo9115a(Intent intent) {
        return intent;
    }

    /* JADX INFO: renamed from: b */
    public abstract void mo9117b(Intent intent);

    /* JADX INFO: renamed from: c */
    public boolean mo9127c(Intent intent) {
        return false;
    }

    @Override // android.app.Service
    public final synchronized IBinder onBind(Intent intent) {
        if (Log.isLoggable("EnhancedIntentService", 3)) {
            Log.d("EnhancedIntentService", "Service received bind request");
        }
        if (this.f8637b == null) {
            this.f8637b = new zzf(this);
        }
        return this.f8637b;
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent intent, int i, int i2) {
        synchronized (this.f8638c) {
            this.f8639d = i2;
            this.f8640e++;
        }
        Intent intentMo9115a = mo9115a(intent);
        if (intentMo9115a == null) {
            m9126d(intent);
            return 2;
        }
        if (mo9127c(intentMo9115a)) {
            m9126d(intent);
            return 2;
        }
        this.f8636a.execute(new zzc(this, intentMo9115a, intent));
        return 3;
    }
}
