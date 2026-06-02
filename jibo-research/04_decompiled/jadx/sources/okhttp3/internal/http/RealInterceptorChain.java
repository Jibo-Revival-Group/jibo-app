package okhttp3.internal.http;

import java.io.IOException;
import java.util.List;
import okhttp3.Connection;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.connection.StreamAllocation;

/* JADX INFO: loaded from: classes2.dex */
public final class RealInterceptorChain implements Interceptor.Chain {

    /* JADX INFO: renamed from: a */
    private final List<Interceptor> f15369a;

    /* JADX INFO: renamed from: b */
    private final StreamAllocation f15370b;

    /* JADX INFO: renamed from: c */
    private final HttpCodec f15371c;

    /* JADX INFO: renamed from: d */
    private final RealConnection f15372d;

    /* JADX INFO: renamed from: e */
    private final int f15373e;

    /* JADX INFO: renamed from: f */
    private final Request f15374f;

    /* JADX INFO: renamed from: g */
    private int f15375g;

    public RealInterceptorChain(List<Interceptor> list, StreamAllocation streamAllocation, HttpCodec httpCodec, RealConnection realConnection, int i, Request request) {
        this.f15369a = list;
        this.f15372d = realConnection;
        this.f15370b = streamAllocation;
        this.f15371c = httpCodec;
        this.f15373e = i;
        this.f15374f = request;
    }

    @Override // okhttp3.Interceptor.Chain
    /* JADX INFO: renamed from: b */
    public Connection mo15694b() {
        return this.f15372d;
    }

    /* JADX INFO: renamed from: c */
    public StreamAllocation m15989c() {
        return this.f15370b;
    }

    /* JADX INFO: renamed from: d */
    public HttpCodec m15990d() {
        return this.f15371c;
    }

    @Override // okhttp3.Interceptor.Chain
    /* JADX INFO: renamed from: a */
    public Request mo15692a() {
        return this.f15374f;
    }

    @Override // okhttp3.Interceptor.Chain
    /* JADX INFO: renamed from: a */
    public Response mo15693a(Request request) throws IOException {
        return m15988a(request, this.f15370b, this.f15371c, this.f15372d);
    }

    /* JADX INFO: renamed from: a */
    public Response m15988a(Request request, StreamAllocation streamAllocation, HttpCodec httpCodec, RealConnection realConnection) throws IOException {
        if (this.f15373e >= this.f15369a.size()) {
            throw new AssertionError();
        }
        this.f15375g++;
        if (this.f15371c != null && !this.f15372d.m15917a(request.m15765a())) {
            throw new IllegalStateException("network interceptor " + this.f15369a.get(this.f15373e - 1) + " must retain the same host and port");
        }
        if (this.f15371c != null && this.f15375g > 1) {
            throw new IllegalStateException("network interceptor " + this.f15369a.get(this.f15373e - 1) + " must call proceed() exactly once");
        }
        RealInterceptorChain realInterceptorChain = new RealInterceptorChain(this.f15369a, streamAllocation, httpCodec, realConnection, this.f15373e + 1, request);
        Interceptor interceptor = this.f15369a.get(this.f15373e);
        Response responseMo12243a = interceptor.mo12243a(realInterceptorChain);
        if (httpCodec != null && this.f15373e + 1 < this.f15369a.size() && realInterceptorChain.f15375g != 1) {
            throw new IllegalStateException("network interceptor " + interceptor + " must call proceed() exactly once");
        }
        if (responseMo12243a == null) {
            throw new NullPointerException("interceptor " + interceptor + " returned null");
        }
        return responseMo12243a;
    }
}
