package com.segment.analytics;

import com.segment.analytics.Middleware;
import com.segment.analytics.integrations.BasePayload;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
class RealMiddlewareChain implements Middleware.Chain {
    private final Analytics analytics;
    private int index;
    private final List<Middleware> middlewares;
    private final BasePayload payload;

    RealMiddlewareChain(int i, BasePayload basePayload, List<Middleware> list, Analytics analytics) {
        this.index = i;
        this.payload = basePayload;
        this.middlewares = list;
        this.analytics = analytics;
    }

    @Override // com.segment.analytics.Middleware.Chain
    public BasePayload payload() {
        return this.payload;
    }

    @Override // com.segment.analytics.Middleware.Chain
    public void proceed(BasePayload basePayload) {
        if (this.index < this.middlewares.size()) {
            this.middlewares.get(this.index).intercept(new RealMiddlewareChain(this.index + 1, basePayload, this.middlewares, this.analytics));
        } else {
            this.analytics.run(basePayload);
        }
    }
}
