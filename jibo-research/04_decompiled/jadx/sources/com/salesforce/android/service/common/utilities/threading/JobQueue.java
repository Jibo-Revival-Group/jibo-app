package com.salesforce.android.service.common.utilities.threading;

import android.os.Handler;
import android.os.Looper;
import com.salesforce.android.service.common.utilities.control.Async;
import com.salesforce.android.service.common.utilities.control.BasicAsync;
import com.salesforce.android.service.common.utilities.control.ResultReceiver;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public class JobQueue {

    /* JADX INFO: renamed from: a */
    private final Executor f13942a;

    /* JADX INFO: renamed from: b */
    private final HandlerFactory f13943b;

    public JobQueue(Executor executor) {
        this(executor, new HandlerFactory());
    }

    JobQueue(Executor executor, HandlerFactory handlerFactory) {
        this.f13942a = executor;
        this.f13943b = handlerFactory;
    }

    /* JADX INFO: renamed from: a */
    public <T> Async<T> m14223a(Job<T> job) {
        Looper looperMyLooper = Looper.myLooper();
        if (looperMyLooper == null) {
            throw new IllegalStateException("Cannot add jobs on a thread without a looper");
        }
        return m14225a(job, looperMyLooper);
    }

    /* JADX INFO: renamed from: a */
    public <T> Async<T> m14225a(Job<T> job, Looper looper) {
        return m14224a(job, this.f13943b.m14226a(looper));
    }

    /* JADX INFO: renamed from: a */
    public <T> Async<T> m14224a(Job<T> job, Handler handler) {
        JobAsync jobAsync = new JobAsync(handler);
        this.f13942a.execute(new JobRunner(job, jobAsync));
        return jobAsync;
    }

    static class JobRunner<T> implements Runnable {

        /* JADX INFO: renamed from: a */
        final Job<T> f13950a;

        /* JADX INFO: renamed from: b */
        final ResultReceiver<T> f13951b;

        JobRunner(Job<T> job, ResultReceiver<T> resultReceiver) {
            this.f13950a = job;
            this.f13951b = resultReceiver;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.f13950a.mo12210a(this.f13951b);
            } catch (Throwable th) {
                this.f13951b.mo12615b(th);
            }
        }
    }

    static class JobAsync<T> extends BasicAsync<T> {

        /* JADX INFO: renamed from: a */
        final Handler f13944a;

        JobAsync(Handler handler) {
            this.f13944a = handler;
        }

        @Override // com.salesforce.android.service.common.utilities.control.BasicAsync, com.salesforce.android.service.common.utilities.control.ResultReceiver
        /* JADX INFO: renamed from: a */
        public BasicAsync<T> mo12614b(final T t) {
            if (this.f13944a.getLooper().equals(Looper.myLooper())) {
                super.mo12614b(t);
            } else {
                this.f13944a.post(new Runnable() { // from class: com.salesforce.android.service.common.utilities.threading.JobQueue.JobAsync.1
                    @Override // java.lang.Runnable
                    public void run() {
                        JobAsync.super.mo12614b(t);
                    }
                });
            }
            return this;
        }

        @Override // com.salesforce.android.service.common.utilities.control.BasicAsync, com.salesforce.android.service.common.utilities.control.ResultReceiver
        /* JADX INFO: renamed from: a */
        public BasicAsync<T> mo12615b(final Throwable th) {
            if (this.f13944a.getLooper().equals(Looper.myLooper())) {
                super.mo12615b(th);
            } else {
                this.f13944a.post(new Runnable() { // from class: com.salesforce.android.service.common.utilities.threading.JobQueue.JobAsync.2
                    @Override // java.lang.Runnable
                    public void run() {
                        JobAsync.super.mo12615b(th);
                    }
                });
            }
            return this;
        }

        @Override // com.salesforce.android.service.common.utilities.control.BasicAsync, com.salesforce.android.service.common.utilities.control.ResultReceiver
        /* JADX INFO: renamed from: a */
        public BasicAsync<T> mo12613b() {
            if (this.f13944a.getLooper().equals(Looper.myLooper())) {
                super.mo12613b();
            } else {
                this.f13944a.post(new Runnable() { // from class: com.salesforce.android.service.common.utilities.threading.JobQueue.JobAsync.3
                    @Override // java.lang.Runnable
                    public void run() {
                        JobAsync.super.mo12613b();
                    }
                });
            }
            return this;
        }
    }

    public static class HandlerFactory {
        /* JADX INFO: renamed from: a */
        public Handler m14226a(Looper looper) {
            return new Handler(looper);
        }
    }
}
