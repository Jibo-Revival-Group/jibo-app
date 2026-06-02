package com.salesforce.android.service.common.utilities.functional;

import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public class OptionalReference<T> extends WeakReference<T> {
    public OptionalReference(T t) {
        super(t);
    }

    @Override // java.lang.ref.Reference
    public T get() {
        return (T) super.get();
    }

    /* JADX INFO: renamed from: b */
    public boolean m14100b() {
        return get() != null;
    }

    /* JADX INFO: renamed from: a */
    public boolean m14098a(T t) {
        return t == get();
    }

    /* JADX INFO: renamed from: b */
    public void m14099b(T t) {
        if (m14098a(t)) {
            clear();
        }
    }

    /* JADX INFO: renamed from: a */
    public void m14097a(Consumer<? super T> consumer) {
        T t = get();
        if (t != null) {
            consumer.mo13033a(t);
        }
    }
}
