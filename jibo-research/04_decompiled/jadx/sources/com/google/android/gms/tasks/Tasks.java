package com.google.android.gms.tasks;

import com.google.android.gms.common.internal.zzbq;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes.dex */
public final class Tasks {

    static final class zza implements zzb {

        /* JADX INFO: renamed from: a */
        private final CountDownLatch f8407a;

        private zza() {
            this.f8407a = new CountDownLatch(1);
        }

        /* synthetic */ zza(zzo zzoVar) {
            this();
        }

        /* JADX INFO: renamed from: a */
        public final void m8945a() throws InterruptedException {
            this.f8407a.await();
        }

        @Override // com.google.android.gms.tasks.OnFailureListener
        /* JADX INFO: renamed from: a */
        public final void mo8924a(Exception exc) {
            this.f8407a.countDown();
        }

        @Override // com.google.android.gms.tasks.OnSuccessListener
        /* JADX INFO: renamed from: a */
        public final void mo8925a(Object obj) {
            this.f8407a.countDown();
        }

        /* JADX INFO: renamed from: a */
        public final boolean m8946a(long j, TimeUnit timeUnit) throws InterruptedException {
            return this.f8407a.await(j, timeUnit);
        }
    }

    interface zzb extends OnFailureListener, OnSuccessListener<Object> {
    }

    /* JADX INFO: renamed from: a */
    public static <TResult> Task<TResult> m8938a(Exception exc) {
        zzn zznVar = new zzn();
        zznVar.m8959a(exc);
        return zznVar;
    }

    /* JADX INFO: renamed from: a */
    public static <TResult> Task<TResult> m8939a(TResult tresult) {
        zzn zznVar = new zzn();
        zznVar.m8960a(tresult);
        return zznVar;
    }

    /* JADX INFO: renamed from: a */
    public static <TResult> Task<TResult> m8940a(Executor executor, Callable<TResult> callable) {
        zzbq.m7374a(executor, "Executor must not be null");
        zzbq.m7374a(callable, "Callback must not be null");
        zzn zznVar = new zzn();
        executor.execute(new zzo(zznVar, callable));
        return zznVar;
    }

    /* JADX INFO: renamed from: a */
    public static <TResult> TResult m8941a(Task<TResult> task) throws ExecutionException, InterruptedException {
        zzbq.m7385c("Must not be called on the main application thread");
        zzbq.m7374a(task, "Task must not be null");
        if (task.mo8929a()) {
            return (TResult) m8944b(task);
        }
        zza zzaVar = new zza(null);
        m8943a((Task<?>) task, (zzb) zzaVar);
        zzaVar.m8945a();
        return (TResult) m8944b(task);
    }

    /* JADX INFO: renamed from: a */
    public static <TResult> TResult m8942a(Task<TResult> task, long j, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        zzbq.m7385c("Must not be called on the main application thread");
        zzbq.m7374a(task, "Task must not be null");
        zzbq.m7374a(timeUnit, "TimeUnit must not be null");
        if (task.mo8929a()) {
            return (TResult) m8944b(task);
        }
        zza zzaVar = new zza(null);
        m8943a((Task<?>) task, (zzb) zzaVar);
        if (zzaVar.m8946a(j, timeUnit)) {
            return (TResult) m8944b(task);
        }
        throw new TimeoutException("Timed out waiting for Task");
    }

    /* JADX INFO: renamed from: a */
    private static void m8943a(Task<?> task, zzb zzbVar) {
        task.mo8928a(TaskExecutors.f8405b, (OnSuccessListener<? super Object>) zzbVar);
        task.mo8927a(TaskExecutors.f8405b, (OnFailureListener) zzbVar);
    }

    /* JADX INFO: renamed from: b */
    private static <TResult> TResult m8944b(Task<TResult> task) throws ExecutionException {
        if (task.mo8930b()) {
            return task.mo8931c();
        }
        throw new ExecutionException(task.mo8932d());
    }
}
