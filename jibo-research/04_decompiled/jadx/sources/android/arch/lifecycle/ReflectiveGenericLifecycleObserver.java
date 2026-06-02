package android.arch.lifecycle;

import android.arch.lifecycle.ClassesInfoCache;
import android.arch.lifecycle.Lifecycle;

/* JADX INFO: loaded from: classes.dex */
class ReflectiveGenericLifecycleObserver implements GenericLifecycleObserver {

    /* JADX INFO: renamed from: a */
    private final Object f63a;

    /* JADX INFO: renamed from: b */
    private final ClassesInfoCache.CallbackInfo f64b;

    ReflectiveGenericLifecycleObserver(Object obj) {
        this.f63a = obj;
        this.f64b = ClassesInfoCache.f22a.m26b(this.f63a.getClass());
    }

    @Override // android.arch.lifecycle.GenericLifecycleObserver
    /* JADX INFO: renamed from: a */
    public void mo30a(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        this.f64b.m28a(lifecycleOwner, event, this.f63a);
    }
}
