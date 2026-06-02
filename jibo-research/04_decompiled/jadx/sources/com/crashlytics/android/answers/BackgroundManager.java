package com.crashlytics.android.answers;

import io.fabric.sdk.android.Fabric;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
class BackgroundManager {

    /* JADX INFO: renamed from: c */
    private final ScheduledExecutorService f5044c;

    /* JADX INFO: renamed from: d */
    private final List<Listener> f5045d = new ArrayList();

    /* JADX INFO: renamed from: e */
    private volatile boolean f5046e = true;

    /* JADX INFO: renamed from: a */
    final AtomicReference<ScheduledFuture<?>> f5042a = new AtomicReference<>();

    /* JADX INFO: renamed from: b */
    boolean f5043b = true;

    public interface Listener {
        /* JADX INFO: renamed from: a */
        void mo5645a();
    }

    public BackgroundManager(ScheduledExecutorService scheduledExecutorService) {
        this.f5044c = scheduledExecutorService;
    }

    /* JADX INFO: renamed from: a */
    public void m5643a(boolean z) {
        this.f5046e = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: c */
    public void m5640c() {
        Iterator<Listener> it = this.f5045d.iterator();
        while (it.hasNext()) {
            it.next().mo5645a();
        }
    }

    /* JADX INFO: renamed from: a */
    public void m5642a(Listener listener) {
        this.f5045d.add(listener);
    }

    /* JADX INFO: renamed from: a */
    public void m5641a() {
        this.f5043b = false;
        ScheduledFuture<?> andSet = this.f5042a.getAndSet(null);
        if (andSet != null) {
            andSet.cancel(false);
        }
    }

    /* JADX INFO: renamed from: b */
    public void m5644b() {
        if (this.f5046e && !this.f5043b) {
            this.f5043b = true;
            try {
                this.f5042a.compareAndSet(null, this.f5044c.schedule(new Runnable() { // from class: com.crashlytics.android.answers.BackgroundManager.1
                    @Override // java.lang.Runnable
                    public void run() {
                        BackgroundManager.this.f5042a.set(null);
                        BackgroundManager.this.m5640c();
                    }
                }, 5000L, TimeUnit.MILLISECONDS));
            } catch (RejectedExecutionException e) {
                Fabric.m15085h().mo15064a("Answers", "Failed to schedule background detector", e);
            }
        }
    }
}
