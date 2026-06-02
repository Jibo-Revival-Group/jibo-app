package io.fabric.sdk.android.services.cache;

import android.content.Context;

/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractValueCache<T> implements ValueCache<T> {

    /* JADX INFO: renamed from: a */
    private final ValueCache<T> f14549a;

    /* JADX INFO: renamed from: a */
    protected abstract T mo15139a(Context context);

    /* JADX INFO: renamed from: a */
    protected abstract void mo15141a(Context context, T t);

    public AbstractValueCache(ValueCache<T> valueCache) {
        this.f14549a = valueCache;
    }

    @Override // io.fabric.sdk.android.services.cache.ValueCache
    /* JADX INFO: renamed from: a */
    public final synchronized T mo15140a(Context context, ValueLoader<T> valueLoader) throws Exception {
        T tMo15139a;
        tMo15139a = mo15139a(context);
        if (tMo15139a == null) {
            tMo15139a = this.f14549a != null ? this.f14549a.mo15140a(context, valueLoader) : valueLoader.mo5709b(context);
            m15138b(context, tMo15139a);
        }
        return tMo15139a;
    }

    /* JADX INFO: renamed from: b */
    private void m15138b(Context context, T t) {
        if (t == null) {
            throw new NullPointerException();
        }
        mo15141a(context, t);
    }
}
