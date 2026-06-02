package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class Iterators {
    /* JADX INFO: renamed from: a */
    public static <T> boolean m9046a(Collection<T> collection, Iterator<? extends T> it) {
        Preconditions.m9015a(collection);
        Preconditions.m9015a(it);
        boolean zAdd = false;
        while (it.hasNext()) {
            zAdd |= collection.add(it.next());
        }
        return zAdd;
    }
}
