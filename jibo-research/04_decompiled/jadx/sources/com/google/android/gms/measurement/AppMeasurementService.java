package com.google.android.gms.measurement;

import android.app.Service;
import android.app.job.JobParameters;
import android.content.Intent;
import android.os.IBinder;
import com.google.android.gms.internal.zzcla;
import com.google.android.gms.internal.zzcle;

/* JADX INFO: loaded from: classes.dex */
public final class AppMeasurementService extends Service implements zzcle {

    /* JADX INFO: renamed from: a */
    private zzcla<AppMeasurementService> f8402a;

    /* JADX INFO: renamed from: a */
    private final zzcla<AppMeasurementService> m8923a() {
        if (this.f8402a == null) {
            this.f8402a = new zzcla<>(this);
        }
        return this.f8402a;
    }

    @Override // com.google.android.gms.internal.zzcle
    /* JADX INFO: renamed from: a */
    public final void mo8364a(JobParameters jobParameters, boolean z) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.gms.internal.zzcle
    /* JADX INFO: renamed from: a */
    public final void mo8365a(Intent intent) {
        AppMeasurementReceiver.m1899a(intent);
    }

    @Override // com.google.android.gms.internal.zzcle
    /* JADX INFO: renamed from: a */
    public final boolean mo8366a(int i) {
        return stopSelfResult(i);
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        return m8923a().m8356a(intent);
    }

    @Override // android.app.Service
    public final void onCreate() {
        super.onCreate();
        m8923a().m8357a();
    }

    @Override // android.app.Service
    public final void onDestroy() {
        m8923a().m8361b();
        super.onDestroy();
    }

    @Override // android.app.Service
    public final void onRebind(Intent intent) {
        m8923a().m8363c(intent);
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent intent, int i, int i2) {
        return m8923a().m8355a(intent, i, i2);
    }

    @Override // android.app.Service
    public final boolean onUnbind(Intent intent) {
        return m8923a().m8362b(intent);
    }
}
