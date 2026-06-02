package com.google.gson.internal;

/* JADX INFO: renamed from: com.google.gson.internal.$Gson$Preconditions, reason: invalid class name */
/* JADX INFO: loaded from: classes.dex */
public final class C$Gson$Preconditions {
    /* JADX INFO: renamed from: a */
    public static <T> T m9432a(T t) {
        if (t == null) {
            throw new NullPointerException();
        }
        return t;
    }

    /* JADX INFO: renamed from: a */
    public static void m9433a(boolean z) {
        if (!z) {
            throw new IllegalArgumentException();
        }
    }
}
