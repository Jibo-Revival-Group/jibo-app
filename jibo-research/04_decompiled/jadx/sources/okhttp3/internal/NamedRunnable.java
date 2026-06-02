package okhttp3.internal;

/* JADX INFO: loaded from: classes2.dex */
public abstract class NamedRunnable implements Runnable {

    /* JADX INFO: renamed from: b */
    protected final String f15236b;

    /* JADX INFO: renamed from: c */
    protected abstract void mo15763c();

    public NamedRunnable(String str, Object... objArr) {
        this.f15236b = Util.m15836a(str, objArr);
    }

    @Override // java.lang.Runnable
    public final void run() {
        String name = Thread.currentThread().getName();
        Thread.currentThread().setName(this.f15236b);
        try {
            mo15763c();
        } finally {
            Thread.currentThread().setName(name);
        }
    }
}
