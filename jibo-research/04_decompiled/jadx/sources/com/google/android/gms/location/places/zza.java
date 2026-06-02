package com.google.android.gms.location.places;

import com.google.android.gms.internal.zzbfm;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public abstract class zza extends zzbfm {
    /* JADX INFO: renamed from: a */
    static <E> List<E> m8809a(Collection<E> collection) {
        return (collection == null || collection.isEmpty()) ? Collections.emptyList() : new ArrayList(collection);
    }

    /* JADX INFO: renamed from: a */
    static <E> Set<E> m8810a(List<E> list) {
        return (list == null || list.isEmpty()) ? Collections.emptySet() : Collections.unmodifiableSet(new HashSet(list));
    }
}
