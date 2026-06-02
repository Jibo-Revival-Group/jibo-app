package com.google.maps.internal;

import com.google.common.util.concurrent.RateLimiter;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: loaded from: classes.dex */
public class RateLimitExecutorService implements Runnable, ExecutorService {
    private static final int DEFAULT_QUERIES_PER_SECOND = 10;
    private static final Logger LOG = LoggerFactory.m17025a(RateLimitExecutorService.class.getName());
    private final ExecutorService delegate = new ThreadPoolExecutor(Runtime.getRuntime().availableProcessors(), Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), threadFactory("Rate Limited Dispatcher", true));
    private final BlockingQueue<Runnable> queue = new LinkedBlockingQueue();
    private final RateLimiter rateLimiter = RateLimiter.m9051a(10.0d, 1, TimeUnit.SECONDS);

    public RateLimitExecutorService() {
        setQueriesPerSecond(10);
        Thread thread = new Thread(this);
        thread.setDaemon(true);
        thread.setName("RateLimitExecutorDelayThread");
        thread.start();
    }

    public void setQueriesPerSecond(int i) {
        this.rateLimiter.m9058a(i);
    }

    @Override // java.lang.Runnable
    public void run() {
        while (!this.delegate.isShutdown()) {
            try {
                this.rateLimiter.m9063c();
                this.delegate.execute(this.queue.take());
            } catch (InterruptedException e) {
                LOG.mo17021a("Interrupted", (Throwable) e);
                return;
            }
        }
    }

    private static ThreadFactory threadFactory(final String str, final boolean z) {
        return new ThreadFactory() { // from class: com.google.maps.internal.RateLimitExecutorService.1
            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                Thread thread = new Thread(runnable, str);
                thread.setDaemon(z);
                return thread;
            }
        };
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        this.queue.add(runnable);
    }

    @Override // java.util.concurrent.ExecutorService
    public void shutdown() {
        this.delegate.shutdown();
    }

    @Override // java.util.concurrent.ExecutorService
    public List<Runnable> shutdownNow() {
        return this.delegate.shutdownNow();
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isShutdown() {
        return this.delegate.isShutdown();
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isTerminated() {
        return this.delegate.isTerminated();
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean awaitTermination(long j, TimeUnit timeUnit) throws InterruptedException {
        return this.delegate.awaitTermination(j, timeUnit);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> Future<T> submit(Callable<T> callable) {
        return this.delegate.submit(callable);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> Future<T> submit(Runnable runnable, T t) {
        return this.delegate.submit(runnable, t);
    }

    @Override // java.util.concurrent.ExecutorService
    public Future<?> submit(Runnable runnable) {
        return this.delegate.submit(runnable);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection) throws InterruptedException {
        return this.delegate.invokeAll(collection);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection, long j, TimeUnit timeUnit) throws InterruptedException {
        return this.delegate.invokeAll(collection, j, timeUnit);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> T invokeAny(Collection<? extends Callable<T>> collection) throws ExecutionException, InterruptedException {
        return (T) this.delegate.invokeAny(collection);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> T invokeAny(Collection<? extends Callable<T>> collection, long j, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        return (T) this.delegate.invokeAny(collection, j, timeUnit);
    }
}
