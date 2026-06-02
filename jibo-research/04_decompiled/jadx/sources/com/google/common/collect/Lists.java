package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class Lists {
    /* JADX INFO: renamed from: a */
    public static <E> ArrayList<E> m9047a() {
        return new ArrayList<>();
    }

    /* JADX INFO: renamed from: a */
    public static <E> ArrayList<E> m9048a(Iterable<? extends E> iterable) {
        Preconditions.m9015a(iterable);
        if (iterable instanceof Collection) {
            return new ArrayList<>(Collections2.m9045a(iterable));
        }
        return m9049a(iterable.iterator());
    }

    /* JADX INFO: renamed from: a */
    public static <E> ArrayList<E> m9049a(Iterator<? extends E> it) {
        ArrayList<E> arrayListM9047a = m9047a();
        Iterators.m9046a(arrayListM9047a, it);
        return arrayListM9047a;
    }
}
