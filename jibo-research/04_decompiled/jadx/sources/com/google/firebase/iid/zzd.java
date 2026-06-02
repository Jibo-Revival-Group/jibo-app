package com.google.firebase.iid;

import android.content.BroadcastReceiver;
import android.content.Intent;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
final class zzd {

    /* JADX INFO: renamed from: a */
    final Intent f8644a;

    /* JADX INFO: renamed from: b */
    private final BroadcastReceiver.PendingResult f8645b;

    /* JADX INFO: renamed from: c */
    private boolean f8646c = false;

    /* JADX INFO: renamed from: d */
    private final ScheduledFuture<?> f8647d;

    zzd(Intent intent, BroadcastReceiver.PendingResult pendingResult, ScheduledExecutorService scheduledExecutorService) {
        this.f8644a = intent;
        this.f8645b = pendingResult;
        this.f8647d = scheduledExecutorService.schedule(new zze(this, intent), 9500L, TimeUnit.MILLISECONDS);
    }

    /* JADX INFO: renamed from: a */
    final synchronized void m9128a() {
        if (!this.f8646c) {
            this.f8645b.finish();
            this.f8647d.cancel(false);
            this.f8646c = true;
        }
    }
}
