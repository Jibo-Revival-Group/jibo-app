package com.google.android.gms.common.util;

import android.support.v4.util.ArraySet;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class zze {
    /* JADX INFO: renamed from: a */
    private static <T> Set<T> m7499a(int i, boolean z) {
        return i <= 256 ? new ArraySet(i) : new HashSet(i, 1.0f);
    }

    /* JADX INFO: renamed from: a */
    public static <T> Set<T> m7500a(T t, T t2, T t3) {
        Set setM7499a = m7499a(3, false);
        setM7499a.add(t);
        setM7499a.add(t2);
        setM7499a.add(t3);
        return Collections.unmodifiableSet(setM7499a);
    }
}
