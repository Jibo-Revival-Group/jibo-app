package okio;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class Timeout {

    /* JADX INFO: renamed from: c */
    public static final Timeout f15695c = new Timeout() { // from class: okio.Timeout.1
        @Override // okio.Timeout
        /* JADX INFO: renamed from: a */
        public Timeout mo16343a(long j, TimeUnit timeUnit) {
            return this;
        }

        @Override // okio.Timeout
        /* JADX INFO: renamed from: a */
        public Timeout mo16342a(long j) {
            return this;
        }

        @Override // okio.Timeout
        /* JADX INFO: renamed from: g */
        public void mo16346g() throws IOException {
        }
    };

    /* JADX INFO: renamed from: a */
    private boolean f15696a;

    /* JADX INFO: renamed from: b */
    private long f15697b;

    /* JADX INFO: renamed from: d */
    private long f15698d;

    /* JADX INFO: renamed from: a */
    public Timeout mo16343a(long j, TimeUnit timeUnit) {
        if (j < 0) {
            throw new IllegalArgumentException("timeout < 0: " + j);
        }
        if (timeUnit == null) {
            throw new IllegalArgumentException("unit == null");
        }
        this.f15698d = timeUnit.toNanos(j);
        return this;
    }

    /* JADX INFO: renamed from: x_ */
    public long mo16347x_() {
        return this.f15698d;
    }

    /* JADX INFO: renamed from: y_ */
    public boolean mo16348y_() {
        return this.f15696a;
    }

    /* JADX INFO: renamed from: d */
    public long mo16344d() {
        if (this.f15696a) {
            return this.f15697b;
        }
        throw new IllegalStateException("No deadline");
    }

    /* JADX INFO: renamed from: a */
    public Timeout mo16342a(long j) {
        this.f15696a = true;
        this.f15697b = j;
        return this;
    }

    /* JADX INFO: renamed from: z_ */
    public Timeout mo16349z_() {
        this.f15698d = 0L;
        return this;
    }

    /* JADX INFO: renamed from: f */
    public Timeout mo16345f() {
        this.f15696a = false;
        return this;
    }

    /* JADX INFO: renamed from: g */
    public void mo16346g() throws IOException {
        if (Thread.interrupted()) {
            throw new InterruptedIOException("thread interrupted");
        }
        if (this.f15696a && this.f15697b - System.nanoTime() <= 0) {
            throw new InterruptedIOException("deadline reached");
        }
    }
}
