package io.fabric.sdk.android.services.concurrency;

import android.annotation.TargetApi;
import java.util.concurrent.Callable;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class PriorityThreadPoolExecutor extends ThreadPoolExecutor {

    /* JADX INFO: renamed from: a */
    private static final int f14655a = Runtime.getRuntime().availableProcessors();

    /* JADX INFO: renamed from: b */
    private static final int f14656b = f14655a + 1;

    /* JADX INFO: renamed from: c */
    private static final int f14657c = (f14655a * 2) + 1;

    <T extends Runnable & Dependency & Task & PriorityProvider> PriorityThreadPoolExecutor(int i, int i2, long j, TimeUnit timeUnit, DependencyPriorityBlockingQueue<T> dependencyPriorityBlockingQueue, ThreadFactory threadFactory) {
        super(i, i2, j, timeUnit, dependencyPriorityBlockingQueue, threadFactory);
        prestartAllCoreThreads();
    }

    /* JADX INFO: renamed from: a */
    public static <T extends Runnable & Dependency & Task & PriorityProvider> PriorityThreadPoolExecutor m15311a(int i, int i2) {
        return new PriorityThreadPoolExecutor(i, i2, 1L, TimeUnit.SECONDS, new DependencyPriorityBlockingQueue(), new PriorityThreadFactory(10));
    }

    /* JADX INFO: renamed from: a */
    public static PriorityThreadPoolExecutor m15310a() {
        return m15311a(f14656b, f14657c);
    }

    @Override // java.util.concurrent.AbstractExecutorService
    protected <T> RunnableFuture<T> newTaskFor(Runnable runnable, T t) {
        return new PriorityFutureTask(runnable, t);
    }

    @Override // java.util.concurrent.AbstractExecutorService
    protected <T> RunnableFuture<T> newTaskFor(Callable<T> callable) {
        return new PriorityFutureTask(callable);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.Executor
    @TargetApi(9)
    public void execute(Runnable runnable) {
        if (PriorityTask.m15308a(runnable)) {
            super.execute(runnable);
        } else {
            super.execute(newTaskFor(runnable, null));
        }
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    protected void afterExecute(Runnable runnable, Throwable th) {
        Task task = (Task) runnable;
        task.mo15301b(true);
        task.mo15299a(th);
        getQueue().m15296d();
        super.afterExecute(runnable, th);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public DependencyPriorityBlockingQueue getQueue() {
        return (DependencyPriorityBlockingQueue) super.getQueue();
    }

    protected static final class PriorityThreadFactory implements ThreadFactory {

        /* JADX INFO: renamed from: a */
        private final int f14658a;

        public PriorityThreadFactory(int i) {
            this.f14658a = i;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setPriority(this.f14658a);
            thread.setName("Queue");
            return thread;
        }
    }
}
