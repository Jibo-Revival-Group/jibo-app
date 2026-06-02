package com.mixpanel.android.viewcrawler;

import android.os.Looper;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
class UIThreadSet<T> {

    /* JADX INFO: renamed from: a */
    private Set<T> f12158a = new HashSet();

    /* JADX INFO: renamed from: b */
    public void mo12064b(T t) {
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            throw new RuntimeException("Can't add an activity when not on the UI thread");
        }
        this.f12158a.add(t);
    }

    /* JADX INFO: renamed from: a */
    public void mo12062a(T t) {
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            throw new RuntimeException("Can't remove an activity when not on the UI thread");
        }
        this.f12158a.remove(t);
    }

    /* JADX INFO: renamed from: a */
    public Set<T> m12099a() {
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            throw new RuntimeException("Can't remove an activity when not on the UI thread");
        }
        return Collections.unmodifiableSet(this.f12158a);
    }
}
