package com.google.android.gms.iid;

import android.content.BroadcastReceiver;
import android.content.Intent;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
final class zzd {

    /* JADX INFO: renamed from: a */
    final Intent f6803a;

    /* JADX INFO: renamed from: b */
    private final BroadcastReceiver.PendingResult f6804b;

    /* JADX INFO: renamed from: c */
    private boolean f6805c = false;

    /* JADX INFO: renamed from: d */
    private final ScheduledFuture<?> f6806d;

    zzd(Intent intent, BroadcastReceiver.PendingResult pendingResult, ScheduledExecutorService scheduledExecutorService) {
        this.f6803a = intent;
        this.f6804b = pendingResult;
        this.f6806d = scheduledExecutorService.schedule(new zze(this, intent), 9500L, TimeUnit.MILLISECONDS);
    }

    /* JADX INFO: renamed from: a */
    final synchronized void m7619a() {
        if (!this.f6805c) {
            this.f6804b.finish();
            this.f6806d.cancel(false);
            this.f6805c = true;
        }
    }
}
