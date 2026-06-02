package com.jibo.utils.cache;

/* JADX INFO: loaded from: classes.dex */
public final class Preconditions {
    /* JADX INFO: renamed from: a */
    public static <T> T m11510a(T t) {
        return (T) m11511a(t, "Argument must not be null");
    }

    /* JADX INFO: renamed from: a */
    public static <T> T m11511a(T t, String str) {
        if (t == null) {
            throw new NullPointerException(str);
        }
        return t;
    }
}
