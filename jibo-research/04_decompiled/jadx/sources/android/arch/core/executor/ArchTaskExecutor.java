package android.arch.core.executor;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public class ArchTaskExecutor extends TaskExecutor {

    /* JADX INFO: renamed from: a */
    private static volatile ArchTaskExecutor f0a;

    /* JADX INFO: renamed from: d */
    private static final Executor f1d = new Executor() { // from class: android.arch.core.executor.ArchTaskExecutor.1
        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            ArchTaskExecutor.m0a().mo2b(runnable);
        }
    };

    /* JADX INFO: renamed from: e */
    private static final Executor f2e = new Executor() { // from class: android.arch.core.executor.ArchTaskExecutor.2
        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            ArchTaskExecutor.m0a().mo1a(runnable);
        }
    };

    /* JADX INFO: renamed from: c */
    private TaskExecutor f4c = new DefaultTaskExecutor();

    /* JADX INFO: renamed from: b */
    private TaskExecutor f3b = this.f4c;

    private ArchTaskExecutor() {
    }

    /* JADX INFO: renamed from: a */
    public static ArchTaskExecutor m0a() {
        if (f0a != null) {
            return f0a;
        }
        synchronized (ArchTaskExecutor.class) {
            if (f0a == null) {
                f0a = new ArchTaskExecutor();
            }
        }
        return f0a;
    }

    @Override // android.arch.core.executor.TaskExecutor
    /* JADX INFO: renamed from: a */
    public void mo1a(Runnable runnable) {
        this.f3b.mo1a(runnable);
    }

    @Override // android.arch.core.executor.TaskExecutor
    /* JADX INFO: renamed from: b */
    public void mo2b(Runnable runnable) {
        this.f3b.mo2b(runnable);
    }

    @Override // android.arch.core.executor.TaskExecutor
    /* JADX INFO: renamed from: b */
    public boolean mo3b() {
        return this.f3b.mo3b();
    }
}
