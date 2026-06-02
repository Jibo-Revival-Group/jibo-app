package org.apache.http.concurrent;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.apache.http.util.Args;

/* JADX INFO: loaded from: classes2.dex */
public class BasicFuture<T> implements Future<T>, Cancellable {
    private final FutureCallback<T> callback;
    private volatile boolean cancelled;
    private volatile boolean completed;

    /* JADX INFO: renamed from: ex */
    private volatile Exception f15706ex;
    private volatile T result;

    public BasicFuture(FutureCallback<T> futureCallback) {
        this.callback = futureCallback;
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return this.cancelled;
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return this.completed;
    }

    private T getResult() throws ExecutionException {
        if (this.f15706ex != null) {
            throw new ExecutionException(this.f15706ex);
        }
        return this.result;
    }

    @Override // java.util.concurrent.Future
    public synchronized T get() throws ExecutionException, InterruptedException {
        while (!this.completed) {
            wait();
        }
        return getResult();
    }

    @Override // java.util.concurrent.Future
    public synchronized T get(long j, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        T result;
        Args.notNull(timeUnit, "Time unit");
        long millis = timeUnit.toMillis(j);
        long jCurrentTimeMillis = millis <= 0 ? 0L : System.currentTimeMillis();
        if (!this.completed) {
            if (millis <= 0) {
                throw new TimeoutException();
            }
            long jCurrentTimeMillis2 = millis;
            do {
                wait(jCurrentTimeMillis2);
                if (this.completed) {
                    result = getResult();
                } else {
                    jCurrentTimeMillis2 = millis - (System.currentTimeMillis() - jCurrentTimeMillis);
                }
            } while (jCurrentTimeMillis2 > 0);
            throw new TimeoutException();
        }
        result = getResult();
        return result;
    }

    public boolean completed(T t) {
        boolean z = true;
        synchronized (this) {
            if (this.completed) {
                z = false;
            } else {
                this.completed = true;
                this.result = t;
                notifyAll();
                if (this.callback != null) {
                    this.callback.completed(t);
                }
            }
        }
        return z;
    }

    public boolean failed(Exception exc) {
        boolean z = true;
        synchronized (this) {
            if (this.completed) {
                z = false;
            } else {
                this.completed = true;
                this.f15706ex = exc;
                notifyAll();
                if (this.callback != null) {
                    this.callback.failed(exc);
                }
            }
        }
        return z;
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z) {
        boolean z2 = true;
        synchronized (this) {
            if (this.completed) {
                z2 = false;
            } else {
                this.completed = true;
                this.cancelled = true;
                notifyAll();
                if (this.callback != null) {
                    this.callback.cancelled();
                }
            }
        }
        return z2;
    }

    @Override // org.apache.http.concurrent.Cancellable
    public boolean cancel() {
        return cancel(true);
    }
}
