package bolts;

import java.io.Closeable;

/* JADX INFO: loaded from: classes.dex */
public class CancellationTokenRegistration implements Closeable {

    /* JADX INFO: renamed from: a */
    private final Object f4586a;

    /* JADX INFO: renamed from: b */
    private CancellationTokenSource f4587b;

    /* JADX INFO: renamed from: c */
    private Runnable f4588c;

    /* JADX INFO: renamed from: d */
    private boolean f4589d;

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        synchronized (this.f4586a) {
            if (!this.f4589d) {
                this.f4589d = true;
                this.f4587b.m5113a(this);
                this.f4587b = null;
                this.f4588c = null;
            }
        }
    }
}
