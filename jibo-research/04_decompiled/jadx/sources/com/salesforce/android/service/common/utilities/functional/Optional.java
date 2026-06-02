package com.salesforce.android.service.common.utilities.functional;

/* JADX INFO: loaded from: classes.dex */
public class Optional<T> {

    /* JADX INFO: renamed from: a */
    private static final Optional f13831a = m14095a((Object) null);

    /* JADX INFO: renamed from: b */
    private final T f13832b;

    /* JADX INFO: renamed from: a */
    public static <T> Optional<T> m14094a() {
        return f13831a;
    }

    /* JADX INFO: renamed from: a */
    public static <T> Optional<T> m14095a(T t) {
        return new Optional<>(t);
    }

    private Optional(T t) {
        this.f13832b = t;
    }

    /* JADX INFO: renamed from: a */
    public void m14096a(Consumer<? super T> consumer) {
        if (this.f13832b != null) {
            consumer.mo13033a(this.f13832b);
        }
    }
}
