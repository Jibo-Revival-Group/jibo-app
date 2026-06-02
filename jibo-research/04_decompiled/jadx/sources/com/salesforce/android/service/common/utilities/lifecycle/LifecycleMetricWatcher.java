package com.salesforce.android.service.common.utilities.lifecycle;

import android.graphics.ColorSpace;
import android.os.Handler;
import com.salesforce.android.service.common.utilities.lifecycle.LifecycleMetric;
import com.salesforce.android.service.common.utilities.lifecycle.LifecycleState;
import com.salesforce.android.service.common.utilities.logging.ServiceLogger;
import com.salesforce.android.service.common.utilities.logging.ServiceLogging;
import java.lang.Enum;

/* JADX INFO: loaded from: classes.dex */
public class LifecycleMetricWatcher<S extends Enum<S> & LifecycleState<M>, M extends Enum<M> & LifecycleMetric> {

    /* JADX INFO: renamed from: a */
    private final ServiceLogger f13898a;

    /* JADX INFO: renamed from: b */
    private final Handler f13899b;

    /* JADX INFO: renamed from: c */
    private boolean f13900c;

    LifecycleMetricWatcher(Handler handler, ServiceLogger serviceLogger) {
        this.f13899b = handler;
        this.f13898a = serviceLogger;
    }

    /* JADX WARN: Incorrect types in method signature: (TS;Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleEvaluator;)V */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: a */
    void m14179a(Enum r11, final LifecycleEvaluator lifecycleEvaluator) {
        this.f13899b.removeCallbacksAndMessages(null);
        for (final ColorSpace.Adaptation adaptation : ((LifecycleState) r11).getMetrics()) {
            if (((LifecycleMetric) adaptation).getTimeoutMs() != null && ((LifecycleMetric) adaptation).getTimeoutMs().intValue() > 0) {
                this.f13898a.mo14189b("Starting timeout for metric: {} on state: {}", adaptation.name(), r11.name());
                this.f13899b.postDelayed(new Runnable() { // from class: com.salesforce.android.service.common.utilities.lifecycle.LifecycleMetricWatcher.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!LifecycleMetricWatcher.this.m14180a() && !lifecycleEvaluator.m14171d(adaptation)) {
                            LifecycleMetricWatcher.this.f13898a.mo14189b("Metric {} timed out after {} ms", adaptation.name(), ((LifecycleMetric) adaptation).getTimeoutMs());
                            lifecycleEvaluator.m14175g(adaptation);
                            LifecycleMetricWatcher.this.m14181b();
                        }
                    }
                }, ((LifecycleMetric) adaptation).getTimeoutMs().intValue());
            }
        }
    }

    /* JADX INFO: renamed from: a */
    boolean m14180a() {
        return this.f13900c;
    }

    /* JADX INFO: renamed from: b */
    void m14181b() {
        this.f13899b.removeCallbacksAndMessages(null);
        this.f13900c = true;
    }

    public static class Builder<S extends Enum<S> & LifecycleState<M>, M extends Enum<M> & LifecycleMetric> {

        /* JADX INFO: renamed from: a */
        private Handler f13904a;

        /* JADX INFO: renamed from: b */
        private ServiceLogger f13905b;

        /* JADX INFO: renamed from: a */
        public LifecycleMetricWatcher<S, M> m14182a(Class<S> cls) {
            if (this.f13904a == null) {
                this.f13904a = new Handler();
            }
            if (this.f13905b == null) {
                this.f13905b = ServiceLogging.m14204a(LifecycleEvaluator.class, String.format("LifecycleMetricWatcher:%s", cls.getSimpleName()));
            }
            return new LifecycleMetricWatcher<>(this.f13904a, this.f13905b);
        }
    }
}
