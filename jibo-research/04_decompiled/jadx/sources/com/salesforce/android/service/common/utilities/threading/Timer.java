package com.salesforce.android.service.common.utilities.threading;

import android.os.Handler;
import android.os.Looper;
import com.salesforce.android.service.common.utilities.logging.ServiceLogger;
import com.salesforce.android.service.common.utilities.logging.ServiceLogging;
import com.salesforce.android.service.common.utilities.threading.HandlerManager;
import com.salesforce.android.service.common.utilities.validation.Arguments;

/* JADX INFO: loaded from: classes.dex */
public class Timer implements HandlerManager {

    /* JADX INFO: renamed from: a */
    protected static final ServiceLogger f13953a = ServiceLogging.m14203a((Class<?>) Timer.class);

    /* JADX INFO: renamed from: b */
    protected boolean f13954b = false;

    /* JADX INFO: renamed from: c */
    private final TimerRunnable f13955c;

    /* JADX INFO: renamed from: d */
    private final long f13956d;

    /* JADX INFO: renamed from: e */
    private final Handler f13957e;

    protected interface OnTimerExecutedListener {
        /* JADX INFO: renamed from: a */
        void mo14231a();
    }

    protected Timer(Builder builder) {
        this.f13955c = new TimerRunnable(builder.f13959a, new OnTimerExecutedListener() { // from class: com.salesforce.android.service.common.utilities.threading.Timer.1
            @Override // com.salesforce.android.service.common.utilities.threading.Timer.OnTimerExecutedListener
            /* JADX INFO: renamed from: a */
            public void mo14231a() {
                Timer.this.f13954b = false;
            }
        });
        this.f13956d = builder.f13960b;
        this.f13957e = builder.f13961c;
    }

    @Override // com.salesforce.android.service.common.utilities.threading.HandlerManager
    /* JADX INFO: renamed from: a */
    public void mo14214a() {
        if (!this.f13954b) {
            f13953a.mo14189b("Scheduling the timer with a delay of {}ms", Long.valueOf(this.f13956d));
            this.f13957e.postDelayed(this.f13955c, this.f13956d);
            this.f13954b = true;
        }
    }

    @Override // com.salesforce.android.service.common.utilities.threading.HandlerManager
    /* JADX INFO: renamed from: b */
    public void mo14215b() {
        if (this.f13954b) {
            f13953a.mo14188b("Cancelling the timer.");
            this.f13957e.removeCallbacks(this.f13955c);
            this.f13954b = false;
        }
    }

    private static class TimerRunnable implements Runnable {

        /* JADX INFO: renamed from: a */
        private final HandlerManager.OnTimerElapsedListener f13962a;

        /* JADX INFO: renamed from: b */
        private final OnTimerExecutedListener f13963b;

        TimerRunnable(HandlerManager.OnTimerElapsedListener onTimerElapsedListener, OnTimerExecutedListener onTimerExecutedListener) {
            this.f13962a = onTimerElapsedListener;
            this.f13963b = onTimerExecutedListener;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f13963b.mo14231a();
            Timer.f13953a.mo14186a("Notifying the OnTimerElapsedListener that the timer has elapsed.");
            this.f13962a.mo13832b();
        }
    }

    public static class Builder implements HandlerManager.Builder {

        /* JADX INFO: renamed from: a */
        protected HandlerManager.OnTimerElapsedListener f13959a;

        /* JADX INFO: renamed from: b */
        protected long f13960b = 15000;

        /* JADX INFO: renamed from: c */
        protected Handler f13961c;

        @Override // com.salesforce.android.service.common.utilities.threading.HandlerManager.Builder
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Builder mo14221b(HandlerManager.OnTimerElapsedListener onTimerElapsedListener) {
            this.f13959a = onTimerElapsedListener;
            return this;
        }

        /* JADX INFO: renamed from: a */
        public Builder m14232a(long j) {
            this.f13960b = j;
            return this;
        }

        @Override // com.salesforce.android.service.common.utilities.threading.HandlerManager.Builder
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Timer mo14222b() {
            Arguments.m14235a(this.f13959a);
            if (this.f13961c == null) {
                this.f13961c = new Handler(Looper.myLooper());
            }
            return new Timer(this);
        }
    }
}
