package io.fabric.sdk.android.services.concurrency;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.util.Log;
import java.util.LinkedList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
public abstract class AsyncTask<Params, Progress, Result> {

    /* JADX INFO: renamed from: a */
    private static final int f14620a = Runtime.getRuntime().availableProcessors();

    /* JADX INFO: renamed from: d */
    private static final int f14623d = f14620a + 1;

    /* JADX INFO: renamed from: e */
    private static final int f14624e = (f14620a * 2) + 1;

    /* JADX INFO: renamed from: f */
    private static final ThreadFactory f14625f = new ThreadFactory() { // from class: io.fabric.sdk.android.services.concurrency.AsyncTask.1

        /* JADX INFO: renamed from: a */
        private final AtomicInteger f14634a = new AtomicInteger(1);

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "AsyncTask #" + this.f14634a.getAndIncrement());
        }
    };

    /* JADX INFO: renamed from: g */
    private static final BlockingQueue<Runnable> f14626g = new LinkedBlockingQueue(128);

    /* JADX INFO: renamed from: b */
    public static final Executor f14621b = new ThreadPoolExecutor(f14623d, f14624e, 1, TimeUnit.SECONDS, f14626g, f14625f);

    /* JADX INFO: renamed from: c */
    public static final Executor f14622c = new SerialExecutor();

    /* JADX INFO: renamed from: h */
    private static final InternalHandler f14627h = new InternalHandler();

    /* JADX INFO: renamed from: i */
    private static volatile Executor f14628i = f14622c;

    /* JADX INFO: renamed from: l */
    private volatile Status f14631l = Status.PENDING;

    /* JADX INFO: renamed from: m */
    private final AtomicBoolean f14632m = new AtomicBoolean();

    /* JADX INFO: renamed from: n */
    private final AtomicBoolean f14633n = new AtomicBoolean();

    /* JADX INFO: renamed from: j */
    private final WorkerRunnable<Params, Result> f14629j = new WorkerRunnable<Params, Result>() { // from class: io.fabric.sdk.android.services.concurrency.AsyncTask.2
        @Override // java.util.concurrent.Callable
        public Result call() throws Exception {
            AsyncTask.this.f14633n.set(true);
            Process.setThreadPriority(10);
            return (Result) AsyncTask.this.m15275e(AsyncTask.this.mo15109a((Object[]) this.f14644b));
        }
    };

    /* JADX INFO: renamed from: k */
    private final FutureTask<Result> f14630k = new FutureTask<Result>(this.f14629j) { // from class: io.fabric.sdk.android.services.concurrency.AsyncTask.3
        @Override // java.util.concurrent.FutureTask
        protected void done() {
            try {
                AsyncTask.this.m15274d(get());
            } catch (InterruptedException e) {
                Log.w("AsyncTask", e);
            } catch (CancellationException e2) {
                AsyncTask.this.m15274d(null);
            } catch (ExecutionException e3) {
                throw new RuntimeException("An error occured while executing doInBackground()", e3.getCause());
            }
        }
    };

    public enum Status {
        PENDING,
        RUNNING,
        FINISHED
    }

    /* JADX INFO: renamed from: a */
    protected abstract Result mo15109a(Params... paramsArr);

    private static class SerialExecutor implements Executor {

        /* JADX INFO: renamed from: a */
        final LinkedList<Runnable> f14640a;

        /* JADX INFO: renamed from: b */
        Runnable f14641b;

        private SerialExecutor() {
            this.f14640a = new LinkedList<>();
        }

        @Override // java.util.concurrent.Executor
        public synchronized void execute(final Runnable runnable) {
            this.f14640a.offer(new Runnable() { // from class: io.fabric.sdk.android.services.concurrency.AsyncTask.SerialExecutor.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        runnable.run();
                    } finally {
                        SerialExecutor.this.m15283a();
                    }
                }
            });
            if (this.f14641b == null) {
                m15283a();
            }
        }

        /* JADX INFO: renamed from: a */
        protected synchronized void m15283a() {
            Runnable runnablePoll = this.f14640a.poll();
            this.f14641b = runnablePoll;
            if (runnablePoll != null) {
                AsyncTask.f14621b.execute(this.f14641b);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: d */
    public void m15274d(Result result) {
        if (!this.f14633n.get()) {
            m15275e(result);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: e */
    public Result m15275e(Result result) {
        f14627h.obtainMessage(1, new AsyncTaskResult(this, result)).sendToTarget();
        return result;
    }

    /* JADX INFO: renamed from: u_ */
    public final Status m15281u_() {
        return this.f14631l;
    }

    /* JADX INFO: renamed from: a */
    protected void mo15111a() {
    }

    /* JADX INFO: renamed from: a */
    protected void mo15112a(Result result) {
    }

    /* JADX INFO: renamed from: b */
    protected void m15279b(Progress... progressArr) {
    }

    /* JADX INFO: renamed from: b */
    protected void mo15113b(Result result) {
        m15282v_();
    }

    /* JADX INFO: renamed from: v_ */
    protected void m15282v_() {
    }

    /* JADX INFO: renamed from: e */
    public final boolean m15280e() {
        return this.f14632m.get();
    }

    /* JADX INFO: renamed from: a */
    public final boolean m15278a(boolean z) {
        this.f14632m.set(true);
        return this.f14630k.cancel(z);
    }

    /* JADX INFO: renamed from: a */
    public final AsyncTask<Params, Progress, Result> m15277a(Executor executor, Params... paramsArr) {
        if (this.f14631l != Status.PENDING) {
            switch (this.f14631l) {
                case RUNNING:
                    throw new IllegalStateException("Cannot execute task: the task is already running.");
                case FINISHED:
                    throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
            }
        }
        this.f14631l = Status.RUNNING;
        mo15111a();
        this.f14629j.f14644b = paramsArr;
        executor.execute(this.f14630k);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: f */
    public void m15276f(Result result) {
        if (m15280e()) {
            mo15113b(result);
        } else {
            mo15112a(result);
        }
        this.f14631l = Status.FINISHED;
    }

    private static class InternalHandler extends Handler {
        public InternalHandler() {
            super(Looper.getMainLooper());
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            AsyncTaskResult asyncTaskResult = (AsyncTaskResult) message.obj;
            switch (message.what) {
                case 1:
                    asyncTaskResult.f14638a.m15276f(asyncTaskResult.f14639b[0]);
                    break;
                case 2:
                    asyncTaskResult.f14638a.m15279b((Object[]) asyncTaskResult.f14639b);
                    break;
            }
        }
    }

    private static abstract class WorkerRunnable<Params, Result> implements Callable<Result> {

        /* JADX INFO: renamed from: b */
        Params[] f14644b;

        private WorkerRunnable() {
        }
    }

    private static class AsyncTaskResult<Data> {

        /* JADX INFO: renamed from: a */
        final AsyncTask f14638a;

        /* JADX INFO: renamed from: b */
        final Data[] f14639b;

        AsyncTaskResult(AsyncTask asyncTask, Data... dataArr) {
            this.f14638a = asyncTask;
            this.f14639b = dataArr;
        }
    }
}
