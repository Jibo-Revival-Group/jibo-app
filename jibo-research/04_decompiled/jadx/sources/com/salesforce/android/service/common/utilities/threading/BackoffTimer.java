package com.salesforce.android.service.common.utilities.threading;

import android.os.Handler;
import android.os.Looper;
import com.salesforce.android.service.common.utilities.logging.ServiceLogger;
import com.salesforce.android.service.common.utilities.logging.ServiceLogging;
import com.salesforce.android.service.common.utilities.threading.HandlerManager;
import com.salesforce.android.service.common.utilities.validation.Arguments;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public class BackoffTimer implements HandlerManager {

    /* JADX INFO: renamed from: a */
    protected static final ServiceLogger f13928a = ServiceLogging.m14203a((Class<?>) BackoffTimer.class);

    /* JADX INFO: renamed from: b */
    protected boolean f13929b = false;

    /* JADX INFO: renamed from: c */
    protected AtomicInteger f13930c = new AtomicInteger();

    /* JADX INFO: renamed from: d */
    private final TimerRunnable f13931d;

    /* JADX INFO: renamed from: e */
    private final Handler f13932e;

    /* JADX INFO: renamed from: f */
    private final int f13933f;

    /* JADX INFO: renamed from: g */
    private long f13934g;

    protected interface OnTimerExecutedListener {
        /* JADX INFO: renamed from: a */
        void mo14217a();
    }

    protected BackoffTimer(Builder builder) {
        this.f13931d = new TimerRunnable(builder.f13936a, new OnTimerExecutedListener() { // from class: com.salesforce.android.service.common.utilities.threading.BackoffTimer.1
            @Override // com.salesforce.android.service.common.utilities.threading.BackoffTimer.OnTimerExecutedListener
            /* JADX INFO: renamed from: a */
            public void mo14217a() {
                BackoffTimer.this.m14216c();
            }
        });
        this.f13933f = builder.f13938c;
        this.f13934g = builder.f13937b;
        this.f13932e = builder.f13939d;
    }

    @Override // com.salesforce.android.service.common.utilities.threading.HandlerManager
    /* JADX INFO: renamed from: a */
    public void mo14214a() {
        if (!this.f13929b) {
            this.f13929b = true;
            m14216c();
        }
    }

    @Override // com.salesforce.android.service.common.utilities.threading.HandlerManager
    /* JADX INFO: renamed from: b */
    public void mo14215b() {
        if (this.f13929b) {
            f13928a.mo14186a("Cancelling the BackoffTimer.");
            this.f13932e.removeCallbacks(this.f13931d);
            this.f13929b = false;
            this.f13930c.set(0);
        }
    }

    /* JADX INFO: renamed from: c */
    protected void m14216c() {
        if (this.f13929b) {
            if (this.f13930c.get() >= this.f13933f) {
                f13928a.mo14193d("BackoffTimer has exceeded the maximum number of attempts ({}). Stopping.", Integer.valueOf(this.f13933f));
                mo14215b();
            } else {
                f13928a.mo14189b("Scheduling the BackoffTimer with a delay of {}ms", Long.valueOf(this.f13934g));
                this.f13930c.incrementAndGet();
                this.f13932e.postDelayed(this.f13931d, this.f13934g);
                this.f13934g *= 2;
            }
        }
    }

    private static class TimerRunnable implements Runnable {

        /* JADX INFO: renamed from: a */
        private final HandlerManager.OnTimerElapsedListener f13940a;

        /* JADX INFO: renamed from: b */
        private final OnTimerExecutedListener f13941b;

        TimerRunnable(HandlerManager.OnTimerElapsedListener onTimerElapsedListener, OnTimerExecutedListener onTimerExecutedListener) {
            this.f13940a = onTimerElapsedListener;
            this.f13941b = onTimerExecutedListener;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f13941b.mo14217a();
            BackoffTimer.f13928a.mo14186a("Notifying the OnTimerElapsedListener that the BackoffTimer has elapsed.");
            this.f13940a.mo13832b();
        }
    }

    public static class Builder implements HandlerManager.Builder {

        /* JADX INFO: renamed from: a */
        protected HandlerManager.OnTimerElapsedListener f13936a;

        /* JADX INFO: renamed from: b */
        protected long f13937b = 1000;

        /* JADX INFO: renamed from: c */
        protected int f13938c = 10;

        /* JADX INFO: renamed from: d */
        protected Handler f13939d;

        @Override // com.salesforce.android.service.common.utilities.threading.HandlerManager.Builder
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Builder mo14221b(HandlerManager.OnTimerElapsedListener onTimerElapsedListener) {
            this.f13936a = onTimerElapsedListener;
            return this;
        }

        /* JADX INFO: renamed from: a */
        public Builder m14218a(int i) {
            this.f13938c = i;
            return this;
        }

        @Override // com.salesforce.android.service.common.utilities.threading.HandlerManager.Builder
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public BackoffTimer mo14222b() {
            Arguments.m14235a(this.f13936a);
            if (this.f13939d == null) {
                this.f13939d = new Handler(Looper.myLooper());
            }
            return new BackoffTimer(this);
        }
    }
}
