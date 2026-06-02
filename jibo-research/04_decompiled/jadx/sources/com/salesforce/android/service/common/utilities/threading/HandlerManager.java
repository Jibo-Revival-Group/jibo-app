package com.salesforce.android.service.common.utilities.threading;

/* JADX INFO: loaded from: classes.dex */
public interface HandlerManager {

    public interface Builder {
        /* JADX INFO: renamed from: b */
        Builder mo14221b(OnTimerElapsedListener onTimerElapsedListener);

        /* JADX INFO: renamed from: b */
        HandlerManager mo14222b();
    }

    public interface OnTimerElapsedListener {
        /* JADX INFO: renamed from: b */
        void mo13832b();
    }

    /* JADX INFO: renamed from: a */
    void mo14214a();

    /* JADX INFO: renamed from: b */
    void mo14215b();
}
