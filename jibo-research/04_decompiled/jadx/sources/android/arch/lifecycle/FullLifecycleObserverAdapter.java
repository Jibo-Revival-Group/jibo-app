package android.arch.lifecycle;

import android.arch.lifecycle.Lifecycle;

/* JADX INFO: loaded from: classes.dex */
class FullLifecycleObserverAdapter implements GenericLifecycleObserver {

    /* JADX INFO: renamed from: a */
    private final FullLifecycleObserver f30a;

    FullLifecycleObserverAdapter(FullLifecycleObserver fullLifecycleObserver) {
        this.f30a = fullLifecycleObserver;
    }

    @Override // android.arch.lifecycle.GenericLifecycleObserver
    /* JADX INFO: renamed from: a */
    public void mo30a(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        switch (event) {
            case ON_CREATE:
                this.f30a.m31a(lifecycleOwner);
                return;
            case ON_START:
                this.f30a.m32b(lifecycleOwner);
                return;
            case ON_RESUME:
                this.f30a.m33c(lifecycleOwner);
                return;
            case ON_PAUSE:
                this.f30a.m34d(lifecycleOwner);
                return;
            case ON_STOP:
                this.f30a.m35e(lifecycleOwner);
                return;
            case ON_DESTROY:
                this.f30a.m36f(lifecycleOwner);
                return;
            case ON_ANY:
                throw new IllegalArgumentException("ON_ANY must not been send by anybody");
            default:
                return;
        }
    }
}
