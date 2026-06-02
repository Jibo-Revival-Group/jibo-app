package io.fabric.sdk.android.services.cache;

import android.content.Context;

/* JADX INFO: loaded from: classes2.dex */
public class MemoryValueCache<T> extends AbstractValueCache<T> {

    /* JADX INFO: renamed from: a */
    private T f14550a;

    public MemoryValueCache() {
        this(null);
    }

    public MemoryValueCache(ValueCache<T> valueCache) {
        super(valueCache);
    }

    @Override // io.fabric.sdk.android.services.cache.AbstractValueCache
    /* JADX INFO: renamed from: a */
    protected T mo15139a(Context context) {
        return this.f14550a;
    }

    @Override // io.fabric.sdk.android.services.cache.AbstractValueCache
    /* JADX INFO: renamed from: a */
    protected void mo15141a(Context context, T t) {
        this.f14550a = t;
    }
}
