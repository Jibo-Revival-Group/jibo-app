package com.google.api.client.util;

/* JADX INFO: loaded from: classes.dex */
public final class Joiner {
    private final com.google.api.client.repackaged.com.google.common.base.Joiner wrapped;

    /* JADX INFO: renamed from: on */
    public static Joiner m8980on(char c) {
        return new Joiner(com.google.api.client.repackaged.com.google.common.base.Joiner.m8968on(c));
    }

    private Joiner(com.google.api.client.repackaged.com.google.common.base.Joiner joiner) {
        this.wrapped = joiner;
    }

    public final String join(Iterable<?> iterable) {
        return this.wrapped.join(iterable);
    }
}
