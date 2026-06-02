package bolts;

/* JADX INFO: loaded from: classes.dex */
public class TaskCompletionSource<TResult> {

    /* JADX INFO: renamed from: a */
    private final Task<TResult> f4634a = new Task<>();

    /* JADX INFO: renamed from: a */
    public Task<TResult> m5144a() {
        return this.f4634a;
    }

    /* JADX INFO: renamed from: b */
    public boolean m5149b() {
        return this.f4634a.m5138i();
    }

    /* JADX INFO: renamed from: a */
    public boolean m5146a(TResult tresult) {
        return this.f4634a.m5131b(tresult);
    }

    /* JADX INFO: renamed from: a */
    public boolean m5145a(Exception exc) {
        return this.f4634a.m5130b(exc);
    }

    /* JADX INFO: renamed from: c */
    public void m5150c() {
        if (!m5149b()) {
            throw new IllegalStateException("Cannot cancel a completed task.");
        }
    }

    /* JADX INFO: renamed from: b */
    public void m5148b(TResult tresult) {
        if (!m5146a(tresult)) {
            throw new IllegalStateException("Cannot set the result of a completed task.");
        }
    }

    /* JADX INFO: renamed from: b */
    public void m5147b(Exception exc) {
        if (!m5145a(exc)) {
            throw new IllegalStateException("Cannot set the error on a completed task.");
        }
    }
}
