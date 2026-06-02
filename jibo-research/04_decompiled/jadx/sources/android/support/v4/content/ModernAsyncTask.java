package android.support.v4.content;

import android.os.Binder;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.util.Log;
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

/* JADX INFO: loaded from: classes.dex */
abstract class ModernAsyncTask<Params, Progress, Result> {

    /* JADX INFO: renamed from: d */
    private static InternalHandler f1822d;

    /* JADX INFO: renamed from: a */
    private static final ThreadFactory f1819a = new ThreadFactory() { // from class: android.support.v4.content.ModernAsyncTask.1

        /* JADX INFO: renamed from: a */
        private final AtomicInteger f1829a = new AtomicInteger(1);

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "ModernAsyncTask #" + this.f1829a.getAndIncrement());
        }
    };

    /* JADX INFO: renamed from: b */
    private static final BlockingQueue<Runnable> f1820b = new LinkedBlockingQueue(10);

    /* JADX INFO: renamed from: c */
    public static final Executor f1821c = new ThreadPoolExecutor(5, 128, 1, TimeUnit.SECONDS, f1820b, f1819a);

    /* JADX INFO: renamed from: e */
    private static volatile Executor f1823e = f1821c;

    /* JADX INFO: renamed from: h */
    private volatile Status f1826h = Status.PENDING;

    /* JADX INFO: renamed from: i */
    private final AtomicBoolean f1827i = new AtomicBoolean();

    /* JADX INFO: renamed from: j */
    private final AtomicBoolean f1828j = new AtomicBoolean();

    /* JADX INFO: renamed from: f */
    private final WorkerRunnable<Params, Result> f1824f = new WorkerRunnable<Params, Result>() { // from class: android.support.v4.content.ModernAsyncTask.2
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
        @Override // java.util.concurrent.Callable
        public Result call() throws Exception {
            ModernAsyncTask.this.f1828j.set(true);
            Result result = null;
            try {
                try {
                    Process.setThreadPriority(10);
                    result = (Result) ModernAsyncTask.this.mo1828a((Object[]) this.f1835b);
                    Binder.flushPendingCommands();
                    return result;
                } finally {
                }
            } finally {
                ModernAsyncTask.this.m1894d(result);
            }
        }
    };

    /* JADX INFO: renamed from: g */
    private final FutureTask<Result> f1825g = new FutureTask<Result>(this.f1824f) { // from class: android.support.v4.content.ModernAsyncTask.3
        @Override // java.util.concurrent.FutureTask
        protected void done() {
            try {
                ModernAsyncTask.this.m1892c(get());
            } catch (InterruptedException e) {
                Log.w("AsyncTask", e);
            } catch (CancellationException e2) {
                ModernAsyncTask.this.m1892c(null);
            } catch (ExecutionException e3) {
                throw new RuntimeException("An error occurred while executing doInBackground()", e3.getCause());
            } catch (Throwable th) {
                throw new RuntimeException("An error occurred while executing doInBackground()", th);
            }
        }
    };

    public enum Status {
        PENDING,
        RUNNING,
        FINISHED
    }

    /* JADX INFO: renamed from: a */
    protected abstract Result mo1828a(Params... paramsArr);

    /* JADX INFO: renamed from: d */
    private static Handler m1886d() {
        InternalHandler internalHandler;
        synchronized (ModernAsyncTask.class) {
            if (f1822d == null) {
                f1822d = new InternalHandler();
            }
            internalHandler = f1822d;
        }
        return internalHandler;
    }

    ModernAsyncTask() {
    }

    /* JADX INFO: renamed from: c */
    void m1892c(Result result) {
        if (!this.f1828j.get()) {
            m1894d(result);
        }
    }

    /* JADX INFO: renamed from: d */
    Result m1894d(Result result) {
        m1886d().obtainMessage(1, new AsyncTaskResult(this, result)).sendToTarget();
        return result;
    }

    /* JADX INFO: renamed from: a */
    protected void m1888a() {
    }

    /* JADX INFO: renamed from: a */
    protected void mo1829a(Result result) {
    }

    /* JADX INFO: renamed from: b */
    protected void m1891b(Progress... progressArr) {
    }

    /* JADX INFO: renamed from: b */
    protected void mo1830b(Result result) {
        m1890b();
    }

    /* JADX INFO: renamed from: b */
    protected void m1890b() {
    }

    /* JADX INFO: renamed from: c */
    public final boolean m1893c() {
        return this.f1827i.get();
    }

    /* JADX INFO: renamed from: a */
    public final boolean m1889a(boolean z) {
        this.f1827i.set(true);
        return this.f1825g.cancel(z);
    }

    /* JADX INFO: renamed from: a */
    public final ModernAsyncTask<Params, Progress, Result> m1887a(Executor executor, Params... paramsArr) {
        if (this.f1826h != Status.PENDING) {
            switch (this.f1826h) {
                case RUNNING:
                    throw new IllegalStateException("Cannot execute task: the task is already running.");
                case FINISHED:
                    throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
                default:
                    throw new IllegalStateException("We should never reach this state");
            }
        }
        this.f1826h = Status.RUNNING;
        m1888a();
        this.f1824f.f1835b = paramsArr;
        executor.execute(this.f1825g);
        return this;
    }

    /* JADX INFO: renamed from: e */
    void m1895e(Result result) {
        if (m1893c()) {
            mo1830b(result);
        } else {
            mo1829a(result);
        }
        this.f1826h = Status.FINISHED;
    }

    private static class InternalHandler extends Handler {
        InternalHandler() {
            super(Looper.getMainLooper());
        }

        /* JADX WARN: Multi-variable type inference failed */
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
                    asyncTaskResult.f1833a.m1895e(asyncTaskResult.f1834b[0]);
                    break;
                case 2:
                    asyncTaskResult.f1833a.m1891b((Object[]) asyncTaskResult.f1834b);
                    break;
            }
        }
    }

    private static abstract class WorkerRunnable<Params, Result> implements Callable<Result> {

        /* JADX INFO: renamed from: b */
        Params[] f1835b;

        WorkerRunnable() {
        }
    }

    private static class AsyncTaskResult<Data> {

        /* JADX INFO: renamed from: a */
        final ModernAsyncTask f1833a;

        /* JADX INFO: renamed from: b */
        final Data[] f1834b;

        AsyncTaskResult(ModernAsyncTask modernAsyncTask, Data... dataArr) {
            this.f1833a = modernAsyncTask;
            this.f1834b = dataArr;
        }
    }
}
