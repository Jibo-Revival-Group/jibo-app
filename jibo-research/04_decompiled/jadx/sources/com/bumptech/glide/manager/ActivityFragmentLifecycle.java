package com.bumptech.glide.manager;

import com.bumptech.glide.util.Util;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
class ActivityFragmentLifecycle implements Lifecycle {

    /* JADX INFO: renamed from: a */
    private final Set<LifecycleListener> f4892a = Collections.newSetFromMap(new WeakHashMap());

    /* JADX INFO: renamed from: b */
    private boolean f4893b;

    /* JADX INFO: renamed from: c */
    private boolean f4894c;

    ActivityFragmentLifecycle() {
    }

    @Override // com.bumptech.glide.manager.Lifecycle
    /* JADX INFO: renamed from: a */
    public void mo5452a(LifecycleListener lifecycleListener) {
        this.f4892a.add(lifecycleListener);
        if (this.f4894c) {
            lifecycleListener.onDestroy();
        } else if (this.f4893b) {
            lifecycleListener.onStart();
        } else {
            lifecycleListener.onStop();
        }
    }

    /* JADX INFO: renamed from: a */
    void m5451a() {
        this.f4893b = true;
        Iterator it = Util.m5590a(this.f4892a).iterator();
        while (it.hasNext()) {
            ((LifecycleListener) it.next()).onStart();
        }
    }

    /* JADX INFO: renamed from: b */
    void m5453b() {
        this.f4893b = false;
        Iterator it = Util.m5590a(this.f4892a).iterator();
        while (it.hasNext()) {
            ((LifecycleListener) it.next()).onStop();
        }
    }

    /* JADX INFO: renamed from: c */
    void m5454c() {
        this.f4894c = true;
        Iterator it = Util.m5590a(this.f4892a).iterator();
        while (it.hasNext()) {
            ((LifecycleListener) it.next()).onDestroy();
        }
    }
}
