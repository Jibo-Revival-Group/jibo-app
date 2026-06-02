package bolts;

import bolts.Task;

/* JADX INFO: loaded from: classes.dex */
class UnobservedErrorNotifier {

    /* JADX INFO: renamed from: a */
    private Task<?> f4635a;

    public UnobservedErrorNotifier(Task<?> task) {
        this.f4635a = task;
    }

    protected void finalize() throws Throwable {
        Task.UnobservedExceptionHandler unobservedExceptionHandlerM5115a;
        try {
            Task<?> task = this.f4635a;
            if (task != null && (unobservedExceptionHandlerM5115a = Task.m5115a()) != null) {
                unobservedExceptionHandlerM5115a.m5143a(task, new UnobservedTaskException(task.m5137g()));
            }
        } finally {
            super.finalize();
        }
    }

    /* JADX INFO: renamed from: a */
    public void m5151a() {
        this.f4635a = null;
    }
}
