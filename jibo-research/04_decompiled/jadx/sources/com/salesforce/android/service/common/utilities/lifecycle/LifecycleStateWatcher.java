package com.salesforce.android.service.common.utilities.lifecycle;

import android.os.Handler;
import com.salesforce.android.service.common.utilities.lifecycle.LifecycleMetric;
import com.salesforce.android.service.common.utilities.lifecycle.LifecycleState;
import com.salesforce.android.service.common.utilities.logging.ServiceLogger;
import com.salesforce.android.service.common.utilities.logging.ServiceLogging;
import java.lang.Enum;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

/* JADX INFO: loaded from: classes.dex */
public class LifecycleStateWatcher<S extends Enum<S> & LifecycleState<M>, M extends Enum<M> & LifecycleMetric> {

    /* JADX INFO: renamed from: a */
    protected final BlockingDeque<S> f13906a = new LinkedBlockingDeque();

    /* JADX INFO: renamed from: b */
    protected final ServiceLogger f13907b;

    /* JADX INFO: renamed from: c */
    private final Handler f13908c;

    LifecycleStateWatcher(Handler handler, ServiceLogger serviceLogger) {
        this.f13908c = handler;
        this.f13907b = serviceLogger;
    }

    /* JADX WARN: Incorrect types in method signature: (TS;Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleEvaluator<TS;TM;>;)V */
    /* JADX INFO: renamed from: a */
    void m14184a(Enum r6, final LifecycleEvaluator lifecycleEvaluator) {
        if (this.f13906a.isEmpty() || this.f13906a.getLast() != r6) {
            this.f13907b.mo14189b("Adding state: {}.{} to the notification queue", r6.getClass().getSimpleName(), r6.name());
            this.f13906a.add(r6);
            this.f13908c.post(new Runnable() { // from class: com.salesforce.android.service.common.utilities.lifecycle.LifecycleStateWatcher.1
                @Override // java.lang.Runnable
                public void run() {
                    if (LifecycleStateWatcher.this.f13906a.isEmpty()) {
                        LifecycleStateWatcher.this.f13907b.mo14192d("State queue is empty.");
                        return;
                    }
                    Enum r0 = (Enum) LifecycleStateWatcher.this.f13906a.pop();
                    LifecycleStateWatcher.this.f13907b.mo14189b("Processing state {}", r0.name());
                    lifecycleEvaluator.m14176h(r0);
                }
            });
        }
    }

    /* JADX INFO: renamed from: a */
    void m14183a() {
        this.f13908c.removeCallbacksAndMessages(null);
    }

    public static class Builder<S extends Enum<S> & LifecycleState<M>, M extends Enum<M> & LifecycleMetric> {

        /* JADX INFO: renamed from: a */
        private Handler f13911a;

        /* JADX INFO: renamed from: b */
        private ServiceLogger f13912b;

        /* JADX INFO: renamed from: a */
        public LifecycleStateWatcher<S, M> m14185a(Class<S> cls) {
            if (this.f13911a == null) {
                this.f13911a = new Handler();
            }
            if (this.f13912b == null) {
                this.f13912b = ServiceLogging.m14204a(LifecycleStateWatcher.class, String.format("LifecycleStateWatcher:%s", cls.getSimpleName()));
            }
            return new LifecycleStateWatcher<>(this.f13911a, this.f13912b);
        }
    }
}
