package okhttp3.internal.http2;

import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: classes2.dex */
final class Ping {

    /* JADX INFO: renamed from: a */
    private final CountDownLatch f15571a = new CountDownLatch(1);

    /* JADX INFO: renamed from: b */
    private long f15572b = -1;

    /* JADX INFO: renamed from: c */
    private long f15573c = -1;

    Ping() {
    }

    /* JADX INFO: renamed from: a */
    void m16151a() {
        if (this.f15572b != -1) {
            throw new IllegalStateException();
        }
        this.f15572b = System.nanoTime();
    }

    /* JADX INFO: renamed from: b */
    void m16152b() {
        if (this.f15573c != -1 || this.f15572b == -1) {
            throw new IllegalStateException();
        }
        this.f15573c = System.nanoTime();
        this.f15571a.countDown();
    }

    /* JADX INFO: renamed from: c */
    void m16153c() {
        if (this.f15573c != -1 || this.f15572b == -1) {
            throw new IllegalStateException();
        }
        this.f15573c = this.f15572b - 1;
        this.f15571a.countDown();
    }
}
