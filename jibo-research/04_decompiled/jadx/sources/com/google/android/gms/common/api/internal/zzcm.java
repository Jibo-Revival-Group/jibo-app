package com.google.android.gms.common.api.internal;

import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class zzcm {

    /* JADX INFO: renamed from: a */
    private final Set<zzci<?>> f6351a = Collections.newSetFromMap(new WeakHashMap());

    /* JADX INFO: renamed from: a */
    public final void m7174a() {
        Iterator<zzci<?>> it = this.f6351a.iterator();
        while (it.hasNext()) {
            it.next().m7169a();
        }
        this.f6351a.clear();
    }
}
