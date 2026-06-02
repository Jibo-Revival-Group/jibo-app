package io.fabric.sdk.android.services.concurrency;

import io.fabric.sdk.android.services.concurrency.AsyncTask;
import java.util.Collection;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes2.dex */
public abstract class PriorityAsyncTask<Params, Progress, Result> extends AsyncTask<Params, Progress, Result> implements Dependency<Task>, PriorityProvider, Task {

    /* JADX INFO: renamed from: a */
    private final PriorityTask f14647a = new PriorityTask();

    /* JADX INFO: renamed from: a */
    public final void m15300a(ExecutorService executorService, Params... paramsArr) {
        super.m15277a(new ProxyExecutor(executorService, this), paramsArr);
    }

    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        return Priority.compareTo(this, obj);
    }

    @Override // io.fabric.sdk.android.services.concurrency.Dependency
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void mo15285c(Task task) {
        if (m15281u_() != AsyncTask.Status.PENDING) {
            throw new IllegalStateException("Must not add Dependency after task is running");
        }
        ((Dependency) ((PriorityProvider) m15303g())).mo15285c(task);
    }

    @Override // io.fabric.sdk.android.services.concurrency.Dependency
    /* JADX INFO: renamed from: c */
    public Collection<Task> mo15284c() {
        return ((Dependency) ((PriorityProvider) m15303g())).mo15284c();
    }

    @Override // io.fabric.sdk.android.services.concurrency.Dependency
    /* JADX INFO: renamed from: d */
    public boolean mo15286d() {
        return ((Dependency) ((PriorityProvider) m15303g())).mo15286d();
    }

    /* JADX INFO: renamed from: b */
    public Priority mo5882b() {
        return ((PriorityProvider) m15303g()).mo5882b();
    }

    @Override // io.fabric.sdk.android.services.concurrency.Task
    /* JADX INFO: renamed from: b */
    public void mo15301b(boolean z) {
        ((Task) ((PriorityProvider) m15303g())).mo15301b(z);
    }

    @Override // io.fabric.sdk.android.services.concurrency.Task
    /* JADX INFO: renamed from: f */
    public boolean mo15302f() {
        return ((Task) ((PriorityProvider) m15303g())).mo15302f();
    }

    @Override // io.fabric.sdk.android.services.concurrency.Task
    /* JADX INFO: renamed from: a */
    public void mo15299a(Throwable th) {
        ((Task) ((PriorityProvider) m15303g())).mo15299a(th);
    }

    /* JADX WARN: Incorrect return type in method signature: <T::Lio/fabric/sdk/android/services/concurrency/Dependency<Lio/fabric/sdk/android/services/concurrency/Task;>;:Lio/fabric/sdk/android/services/concurrency/PriorityProvider;:Lio/fabric/sdk/android/services/concurrency/Task;>()TT; */
    /* JADX INFO: renamed from: g */
    public Dependency m15303g() {
        return this.f14647a;
    }

    private static class ProxyExecutor<Result> implements Executor {

        /* JADX INFO: renamed from: a */
        private final Executor f14648a;

        /* JADX INFO: renamed from: b */
        private final PriorityAsyncTask f14649b;

        public ProxyExecutor(Executor executor, PriorityAsyncTask priorityAsyncTask) {
            this.f14648a = executor;
            this.f14649b = priorityAsyncTask;
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            this.f14648a.execute(new PriorityFutureTask<Result>(runnable, null) { // from class: io.fabric.sdk.android.services.concurrency.PriorityAsyncTask.ProxyExecutor.1
                /* JADX WARN: Incorrect return type in method signature: <T::Lio/fabric/sdk/android/services/concurrency/Dependency<Lio/fabric/sdk/android/services/concurrency/Task;>;:Lio/fabric/sdk/android/services/concurrency/PriorityProvider;:Lio/fabric/sdk/android/services/concurrency/Task;>()TT; */
                @Override // io.fabric.sdk.android.services.concurrency.PriorityFutureTask
                /* JADX INFO: renamed from: a */
                public Dependency mo15305a() {
                    return ProxyExecutor.this.f14649b;
                }
            });
        }
    }
}
