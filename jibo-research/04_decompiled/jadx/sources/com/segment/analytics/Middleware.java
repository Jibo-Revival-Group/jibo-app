package com.segment.analytics;

import com.segment.analytics.integrations.BasePayload;

/* JADX INFO: loaded from: classes.dex */
public interface Middleware {

    public interface Chain {
        BasePayload payload();

        void proceed(BasePayload basePayload);
    }

    void intercept(Chain chain);
}
