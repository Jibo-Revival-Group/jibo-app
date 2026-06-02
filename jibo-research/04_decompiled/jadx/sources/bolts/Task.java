package bolts;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes.dex */
public class Task<TResult> {

    /* JADX INFO: renamed from: d */
    private static volatile UnobservedExceptionHandler f4598d;

    /* JADX INFO: renamed from: f */
    private boolean f4604f;

    /* JADX INFO: renamed from: g */
    private boolean f4605g;

    /* JADX INFO: renamed from: h */
    private TResult f4606h;

    /* JADX INFO: renamed from: i */
    private Exception f4607i;

    /* JADX INFO: renamed from: j */
    private boolean f4608j;

    /* JADX INFO: renamed from: k */
    private UnobservedErrorNotifier f4609k;

    /* JADX INFO: renamed from: a */
    public static final ExecutorService f4595a = BoltsExecutors.m5105a();

    /* JADX INFO: renamed from: c */
    private static final Executor f4597c = BoltsExecutors.m5106b();

    /* JADX INFO: renamed from: b */
    public static final Executor f4596b = AndroidExecutors.m5102b();

    /* JADX INFO: renamed from: m */
    private static Task<?> f4599m = new Task<>((Object) null);

    /* JADX INFO: renamed from: n */
    private static Task<Boolean> f4600n = new Task<>(true);

    /* JADX INFO: renamed from: o */
    private static Task<Boolean> f4601o = new Task<>(false);

    /* JADX INFO: renamed from: p */
    private static Task<?> f4602p = new Task<>(true);

    /* JADX INFO: renamed from: e */
    private final Object f4603e = new Object();

    /* JADX INFO: renamed from: l */
    private List<Continuation<TResult, Void>> f4610l = new ArrayList();

    public interface UnobservedExceptionHandler {
        /* JADX INFO: renamed from: a */
        void m5143a(Task<?> task, UnobservedTaskException unobservedTaskException);
    }

    /* JADX INFO: renamed from: a */
    public static UnobservedExceptionHandler m5115a() {
        return f4598d;
    }

    Task() {
    }

    private Task(TResult tresult) {
        m5131b(tresult);
    }

    private Task(boolean z) {
        if (z) {
            m5138i();
        } else {
            m5131b((Object) null);
        }
    }

    /* JADX INFO: renamed from: b */
    public static <TResult> Task<TResult>.TaskCompletionSource m5119b() {
        Task task = new Task();
        task.getClass();
        return new TaskCompletionSource();
    }

    /* JADX INFO: renamed from: c */
    public boolean m5133c() {
        boolean z;
        synchronized (this.f4603e) {
            z = this.f4604f;
        }
        return z;
    }

    /* JADX INFO: renamed from: d */
    public boolean m5134d() {
        boolean z;
        synchronized (this.f4603e) {
            z = this.f4605g;
        }
        return z;
    }

    /* JADX INFO: renamed from: e */
    public boolean m5135e() {
        boolean z;
        synchronized (this.f4603e) {
            z = m5137g() != null;
        }
        return z;
    }

    /* JADX INFO: renamed from: f */
    public TResult m5136f() {
        TResult tresult;
        synchronized (this.f4603e) {
            tresult = this.f4606h;
        }
        return tresult;
    }

    /* JADX INFO: renamed from: g */
    public Exception m5137g() {
        Exception exc;
        synchronized (this.f4603e) {
            if (this.f4607i != null) {
                this.f4608j = true;
                if (this.f4609k != null) {
                    this.f4609k.m5151a();
                    this.f4609k = null;
                }
            }
            exc = this.f4607i;
        }
        return exc;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: a */
    public static <TResult> Task<TResult> m5117a(TResult tresult) {
        if (tresult == 0) {
            return (Task<TResult>) f4599m;
        }
        if (tresult instanceof Boolean) {
            return ((Boolean) tresult).booleanValue() ? (Task<TResult>) f4600n : (Task<TResult>) f4601o;
        }
        bolts.TaskCompletionSource taskCompletionSource = new bolts.TaskCompletionSource();
        taskCompletionSource.m5148b(tresult);
        return taskCompletionSource.m5144a();
    }

    /* JADX INFO: renamed from: a */
    public static <TResult> Task<TResult> m5116a(Exception exc) {
        bolts.TaskCompletionSource taskCompletionSource = new bolts.TaskCompletionSource();
        taskCompletionSource.m5147b(exc);
        return taskCompletionSource.m5144a();
    }

    /* JADX INFO: renamed from: h */
    public static <TResult> Task<TResult> m5123h() {
        return (Task<TResult>) f4602p;
    }

    /* JADX INFO: renamed from: a */
    public <TContinuationResult> Task<TContinuationResult> m5127a(final Continuation<TResult, TContinuationResult> continuation, final Executor executor, final CancellationToken cancellationToken) {
        boolean zM5133c;
        final bolts.TaskCompletionSource taskCompletionSource = new bolts.TaskCompletionSource();
        synchronized (this.f4603e) {
            zM5133c = m5133c();
            if (!zM5133c) {
                this.f4610l.add(new Continuation<TResult, Void>() { // from class: bolts.Task.10
                    @Override // bolts.Continuation
                    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                    public Void then(Task<TResult> task) {
                        Task.m5121c(taskCompletionSource, continuation, task, executor, cancellationToken);
                        return null;
                    }
                });
            }
        }
        if (zM5133c) {
            m5121c(taskCompletionSource, continuation, this, executor, cancellationToken);
        }
        return taskCompletionSource.m5144a();
    }

    /* JADX INFO: renamed from: a */
    public <TContinuationResult> Task<TContinuationResult> m5125a(Continuation<TResult, TContinuationResult> continuation) {
        return m5127a(continuation, f4597c, null);
    }

    /* JADX INFO: renamed from: a */
    public <TContinuationResult> Task<TContinuationResult> m5126a(Continuation<TResult, Task<TContinuationResult>> continuation, Executor executor) {
        return m5129b(continuation, executor, null);
    }

    /* JADX INFO: renamed from: b */
    public <TContinuationResult> Task<TContinuationResult> m5129b(final Continuation<TResult, Task<TContinuationResult>> continuation, final Executor executor, final CancellationToken cancellationToken) {
        boolean zM5133c;
        final bolts.TaskCompletionSource taskCompletionSource = new bolts.TaskCompletionSource();
        synchronized (this.f4603e) {
            zM5133c = m5133c();
            if (!zM5133c) {
                this.f4610l.add(new Continuation<TResult, Void>() { // from class: bolts.Task.11
                    @Override // bolts.Continuation
                    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                    public Void then(Task<TResult> task) {
                        Task.m5122d(taskCompletionSource, continuation, task, executor, cancellationToken);
                        return null;
                    }
                });
            }
        }
        if (zM5133c) {
            m5122d(taskCompletionSource, continuation, this, executor, cancellationToken);
        }
        return taskCompletionSource.m5144a();
    }

    /* JADX INFO: renamed from: c */
    public <TContinuationResult> Task<TContinuationResult> m5132c(final Continuation<TResult, TContinuationResult> continuation, Executor executor, final CancellationToken cancellationToken) {
        return m5126a(new Continuation<TResult, Task<TContinuationResult>>() { // from class: bolts.Task.12
            @Override // bolts.Continuation
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Task<TContinuationResult> then(Task<TResult> task) {
                if (cancellationToken != null && cancellationToken.m5110a()) {
                    return Task.m5123h();
                }
                if (task.m5135e()) {
                    return Task.m5116a(task.m5137g());
                }
                if (task.m5134d()) {
                    return Task.m5123h();
                }
                return task.m5125a((Continuation) continuation);
            }
        }, executor);
    }

    /* JADX INFO: renamed from: b */
    public <TContinuationResult> Task<TContinuationResult> m5128b(Continuation<TResult, TContinuationResult> continuation) {
        return m5132c(continuation, f4597c, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: c */
    public static <TContinuationResult, TResult> void m5121c(final bolts.TaskCompletionSource<TContinuationResult> taskCompletionSource, final Continuation<TResult, TContinuationResult> continuation, final Task<TResult> task, Executor executor, final CancellationToken cancellationToken) {
        try {
            executor.execute(new Runnable() { // from class: bolts.Task.14
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.lang.Runnable
                public void run() {
                    if (cancellationToken != null && cancellationToken.m5110a()) {
                        taskCompletionSource.m5150c();
                        return;
                    }
                    try {
                        taskCompletionSource.m5148b(continuation.then(task));
                    } catch (CancellationException e) {
                        taskCompletionSource.m5150c();
                    } catch (Exception e2) {
                        taskCompletionSource.m5147b(e2);
                    }
                }
            });
        } catch (Exception e) {
            taskCompletionSource.m5147b(new ExecutorException(e));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: d */
    public static <TContinuationResult, TResult> void m5122d(final bolts.TaskCompletionSource<TContinuationResult> taskCompletionSource, final Continuation<TResult, Task<TContinuationResult>> continuation, final Task<TResult> task, Executor executor, final CancellationToken cancellationToken) {
        try {
            executor.execute(new Runnable() { // from class: bolts.Task.15
                /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x0026 -> B:18:0x0011). Please report as a decompilation issue!!! */
                /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0036 -> B:18:0x0011). Please report as a decompilation issue!!! */
                @Override // java.lang.Runnable
                public void run() {
                    if (cancellationToken != null && cancellationToken.m5110a()) {
                        taskCompletionSource.m5150c();
                        return;
                    }
                    try {
                        Task task2 = (Task) continuation.then(task);
                        if (task2 == null) {
                            taskCompletionSource.m5148b((Object) null);
                        } else {
                            task2.m5125a((Continuation) new Continuation<TContinuationResult, Void>() { // from class: bolts.Task.15.1
                                @Override // bolts.Continuation
                                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                                public Void then(Task<TContinuationResult> task3) {
                                    if ((cancellationToken != null && cancellationToken.m5110a()) || task3.m5134d()) {
                                        taskCompletionSource.m5150c();
                                    } else if (task3.m5135e()) {
                                        taskCompletionSource.m5147b(task3.m5137g());
                                    } else {
                                        taskCompletionSource.m5148b(task3.m5136f());
                                    }
                                    return null;
                                }
                            });
                        }
                    } catch (CancellationException e) {
                        taskCompletionSource.m5150c();
                    } catch (Exception e2) {
                        taskCompletionSource.m5147b(e2);
                    }
                }
            });
        } catch (Exception e) {
            taskCompletionSource.m5147b(new ExecutorException(e));
        }
    }

    /* JADX INFO: renamed from: j */
    private void m5124j() {
        synchronized (this.f4603e) {
            Iterator<Continuation<TResult, Void>> it = this.f4610l.iterator();
            while (it.hasNext()) {
                try {
                    it.next().then(this);
                } catch (RuntimeException e) {
                    throw e;
                } catch (Exception e2) {
                    throw new RuntimeException(e2);
                }
            }
            this.f4610l = null;
        }
    }

    /* JADX INFO: renamed from: i */
    boolean m5138i() {
        boolean z = true;
        synchronized (this.f4603e) {
            if (this.f4604f) {
                z = false;
            } else {
                this.f4604f = true;
                this.f4605g = true;
                this.f4603e.notifyAll();
                m5124j();
            }
        }
        return z;
    }

    /* JADX INFO: renamed from: b */
    boolean m5131b(TResult tresult) {
        boolean z = true;
        synchronized (this.f4603e) {
            if (this.f4604f) {
                z = false;
            } else {
                this.f4604f = true;
                this.f4606h = tresult;
                this.f4603e.notifyAll();
                m5124j();
            }
        }
        return z;
    }

    /* JADX INFO: renamed from: b */
    boolean m5130b(Exception exc) {
        synchronized (this.f4603e) {
            if (this.f4604f) {
                return false;
            }
            this.f4604f = true;
            this.f4607i = exc;
            this.f4608j = false;
            this.f4603e.notifyAll();
            m5124j();
            if (!this.f4608j && m5115a() != null) {
                this.f4609k = new UnobservedErrorNotifier(this);
            }
            return true;
        }
    }

    public class TaskCompletionSource extends bolts.TaskCompletionSource<TResult> {
        TaskCompletionSource() {
        }
    }
}
