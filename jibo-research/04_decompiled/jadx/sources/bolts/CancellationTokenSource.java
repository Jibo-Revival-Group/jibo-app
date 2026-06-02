package bolts;

import java.io.Closeable;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ScheduledFuture;

/* JADX INFO: loaded from: classes.dex */
public class CancellationTokenSource implements Closeable {

    /* JADX INFO: renamed from: a */
    private final Object f4590a;

    /* JADX INFO: renamed from: b */
    private final List<CancellationTokenRegistration> f4591b;

    /* JADX INFO: renamed from: c */
    private ScheduledFuture<?> f4592c;

    /* JADX INFO: renamed from: d */
    private boolean f4593d;

    /* JADX INFO: renamed from: e */
    private boolean f4594e;

    /* JADX INFO: renamed from: a */
    public boolean m5114a() {
        boolean z;
        synchronized (this.f4590a) {
            m5111b();
            z = this.f4593d;
        }
        return z;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        synchronized (this.f4590a) {
            if (!this.f4594e) {
                m5112c();
                Iterator<CancellationTokenRegistration> it = this.f4591b.iterator();
                while (it.hasNext()) {
                    it.next().close();
                }
                this.f4591b.clear();
                this.f4594e = true;
            }
        }
    }

    /* JADX INFO: renamed from: a */
    void m5113a(CancellationTokenRegistration cancellationTokenRegistration) {
        synchronized (this.f4590a) {
            m5111b();
            this.f4591b.remove(cancellationTokenRegistration);
        }
    }

    public String toString() {
        return String.format(Locale.US, "%s@%s[cancellationRequested=%s]", getClass().getName(), Integer.toHexString(hashCode()), Boolean.toString(m5114a()));
    }

    /* JADX INFO: renamed from: b */
    private void m5111b() {
        if (this.f4594e) {
            throw new IllegalStateException("Object already closed");
        }
    }

    /* JADX INFO: renamed from: c */
    private void m5112c() {
        if (this.f4592c != null) {
            this.f4592c.cancel(true);
            this.f4592c = null;
        }
    }
}
