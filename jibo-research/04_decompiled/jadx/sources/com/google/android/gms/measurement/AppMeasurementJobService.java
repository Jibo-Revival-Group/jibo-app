package com.google.android.gms.measurement;

import android.annotation.TargetApi;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Intent;
import com.google.android.gms.internal.zzcla;
import com.google.android.gms.internal.zzcle;

/* JADX INFO: loaded from: classes.dex */
@TargetApi(24)
public final class AppMeasurementJobService extends JobService implements zzcle {

    /* JADX INFO: renamed from: a */
    private zzcla<AppMeasurementJobService> f8400a;

    /* JADX INFO: renamed from: a */
    private final zzcla<AppMeasurementJobService> m8922a() {
        if (this.f8400a == null) {
            this.f8400a = new zzcla<>(this);
        }
        return this.f8400a;
    }

    @Override // com.google.android.gms.internal.zzcle
    @TargetApi(24)
    /* JADX INFO: renamed from: a */
    public final void mo8364a(JobParameters jobParameters, boolean z) {
        jobFinished(jobParameters, false);
    }

    @Override // com.google.android.gms.internal.zzcle
    /* JADX INFO: renamed from: a */
    public final void mo8365a(Intent intent) {
    }

    @Override // com.google.android.gms.internal.zzcle
    /* JADX INFO: renamed from: a */
    public final boolean mo8366a(int i) {
        throw new UnsupportedOperationException();
    }

    @Override // android.app.Service
    public final void onCreate() {
        super.onCreate();
        m8922a().m8357a();
    }

    @Override // android.app.Service
    public final void onDestroy() {
        m8922a().m8361b();
        super.onDestroy();
    }

    @Override // android.app.Service
    public final void onRebind(Intent intent) {
        m8922a().m8363c(intent);
    }

    @Override // android.app.job.JobService
    public final boolean onStartJob(JobParameters jobParameters) {
        return m8922a().m8360a(jobParameters);
    }

    @Override // android.app.job.JobService
    public final boolean onStopJob(JobParameters jobParameters) {
        return false;
    }

    @Override // android.app.Service
    public final boolean onUnbind(Intent intent) {
        return m8922a().m8362b(intent);
    }
}
