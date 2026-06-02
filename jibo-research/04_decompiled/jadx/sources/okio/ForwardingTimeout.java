package okio;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class ForwardingTimeout extends Timeout {

    /* JADX INFO: renamed from: a */
    private Timeout f15656a;

    public ForwardingTimeout(Timeout timeout) {
        if (timeout == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.f15656a = timeout;
    }

    /* JADX INFO: renamed from: a */
    public final Timeout m16341a() {
        return this.f15656a;
    }

    /* JADX INFO: renamed from: a */
    public final ForwardingTimeout m16340a(Timeout timeout) {
        if (timeout == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.f15656a = timeout;
        return this;
    }

    @Override // okio.Timeout
    /* JADX INFO: renamed from: a */
    public Timeout mo16343a(long j, TimeUnit timeUnit) {
        return this.f15656a.mo16343a(j, timeUnit);
    }

    @Override // okio.Timeout
    /* JADX INFO: renamed from: x_ */
    public long mo16347x_() {
        return this.f15656a.mo16347x_();
    }

    @Override // okio.Timeout
    /* JADX INFO: renamed from: y_ */
    public boolean mo16348y_() {
        return this.f15656a.mo16348y_();
    }

    @Override // okio.Timeout
    /* JADX INFO: renamed from: d */
    public long mo16344d() {
        return this.f15656a.mo16344d();
    }

    @Override // okio.Timeout
    /* JADX INFO: renamed from: a */
    public Timeout mo16342a(long j) {
        return this.f15656a.mo16342a(j);
    }

    @Override // okio.Timeout
    /* JADX INFO: renamed from: z_ */
    public Timeout mo16349z_() {
        return this.f15656a.mo16349z_();
    }

    @Override // okio.Timeout
    /* JADX INFO: renamed from: f */
    public Timeout mo16345f() {
        return this.f15656a.mo16345f();
    }

    @Override // okio.Timeout
    /* JADX INFO: renamed from: g */
    public void mo16346g() throws IOException {
        this.f15656a.mo16346g();
    }
}
