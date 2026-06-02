package io.fabric.sdk.android.services.concurrency;

import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/* JADX INFO: loaded from: classes2.dex */
public class PriorityFutureTask<V> extends FutureTask<V> implements Dependency<Task>, PriorityProvider, Task {

    /* JADX INFO: renamed from: b */
    final Object f14651b;

    public PriorityFutureTask(Callable<V> callable) {
        super(callable);
        this.f14651b = m15306a(callable);
    }

    public PriorityFutureTask(Runnable runnable, V v) {
        super(runnable, v);
        this.f14651b = m15306a(runnable);
    }

    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        return ((PriorityProvider) mo15305a()).compareTo(obj);
    }

    @Override // io.fabric.sdk.android.services.concurrency.Dependency
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void mo15285c(Task task) {
        ((Dependency) ((PriorityProvider) mo15305a())).mo15285c(task);
    }

    @Override // io.fabric.sdk.android.services.concurrency.Dependency
    /* JADX INFO: renamed from: c */
    public Collection<Task> mo15284c() {
        return ((Dependency) ((PriorityProvider) mo15305a())).mo15284c();
    }

    @Override // io.fabric.sdk.android.services.concurrency.Dependency
    /* JADX INFO: renamed from: d */
    public boolean mo15286d() {
        return ((Dependency) ((PriorityProvider) mo15305a())).mo15286d();
    }

    @Override // io.fabric.sdk.android.services.concurrency.PriorityProvider
    /* JADX INFO: renamed from: b */
    public Priority mo5882b() {
        return ((PriorityProvider) mo15305a()).mo5882b();
    }

    @Override // io.fabric.sdk.android.services.concurrency.Task
    /* JADX INFO: renamed from: b */
    public void mo15301b(boolean z) {
        ((Task) ((PriorityProvider) mo15305a())).mo15301b(z);
    }

    @Override // io.fabric.sdk.android.services.concurrency.Task
    /* JADX INFO: renamed from: f */
    public boolean mo15302f() {
        return ((Task) ((PriorityProvider) mo15305a())).mo15302f();
    }

    @Override // io.fabric.sdk.android.services.concurrency.Task
    /* JADX INFO: renamed from: a */
    public void mo15299a(Throwable th) {
        ((Task) ((PriorityProvider) mo15305a())).mo15299a(th);
    }

    /* JADX WARN: Incorrect return type in method signature: <T::Lio/fabric/sdk/android/services/concurrency/Dependency<Lio/fabric/sdk/android/services/concurrency/Task;>;:Lio/fabric/sdk/android/services/concurrency/PriorityProvider;:Lio/fabric/sdk/android/services/concurrency/Task;>()TT; */
    /* JADX INFO: renamed from: a */
    public Dependency mo15305a() {
        return (Dependency) this.f14651b;
    }

    /* JADX WARN: Incorrect return type in method signature: <T::Lio/fabric/sdk/android/services/concurrency/Dependency<Lio/fabric/sdk/android/services/concurrency/Task;>;:Lio/fabric/sdk/android/services/concurrency/PriorityProvider;:Lio/fabric/sdk/android/services/concurrency/Task;>(Ljava/lang/Object;)TT; */
    /* JADX INFO: renamed from: a */
    protected Dependency m15306a(Object obj) {
        return PriorityTask.m15308a(obj) ? (Dependency) obj : new PriorityTask();
    }
}
