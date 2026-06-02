package android.arch.lifecycle;

import android.arch.lifecycle.Lifecycle;

/* JADX INFO: loaded from: classes.dex */
public class SingleGeneratedAdapterObserver implements GenericLifecycleObserver {

    /* JADX INFO: renamed from: a */
    private final GeneratedAdapter f66a;

    SingleGeneratedAdapterObserver(GeneratedAdapter generatedAdapter) {
        this.f66a = generatedAdapter;
    }

    @Override // android.arch.lifecycle.GenericLifecycleObserver
    /* JADX INFO: renamed from: a */
    public void mo30a(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        this.f66a.m37a(lifecycleOwner, event, false, null);
        this.f66a.m37a(lifecycleOwner, event, true, null);
    }
}
