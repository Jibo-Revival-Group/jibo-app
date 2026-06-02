package com.bumptech.glide.provider;

import com.bumptech.glide.util.MultiClassKey;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class DataLoadProviderRegistry {

    /* JADX INFO: renamed from: a */
    private static final MultiClassKey f4928a = new MultiClassKey();

    /* JADX INFO: renamed from: b */
    private final Map<MultiClassKey, DataLoadProvider<?, ?>> f4929b = new HashMap();

    /* JADX INFO: renamed from: a */
    public <T, Z> void m5501a(Class<T> cls, Class<Z> cls2, DataLoadProvider<T, Z> dataLoadProvider) {
        this.f4929b.put(new MultiClassKey(cls, cls2), dataLoadProvider);
    }

    /* JADX INFO: renamed from: a */
    public <T, Z> DataLoadProvider<T, Z> m5500a(Class<T> cls, Class<Z> cls2) {
        DataLoadProvider<T, Z> dataLoadProvider;
        synchronized (f4928a) {
            f4928a.m5584a(cls, cls2);
            dataLoadProvider = (DataLoadProvider) this.f4929b.get(f4928a);
        }
        if (dataLoadProvider == null) {
            return EmptyDataLoadProvider.m5502a();
        }
        return dataLoadProvider;
    }
}
