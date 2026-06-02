package retrofit2;

import com.google.firebase.perf.network.FirebasePerfOkHttpClient;
import java.io.IOException;
import okhttp3.MediaType;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;
import okio.ForwardingSource;
import okio.Okio;

/* JADX INFO: loaded from: classes2.dex */
final class OkHttpCall<T> implements Call<T> {

    /* JADX INFO: renamed from: a */
    private final ServiceMethod<T, ?> f16253a;

    /* JADX INFO: renamed from: b */
    private final Object[] f16254b;

    /* JADX INFO: renamed from: c */
    private volatile boolean f16255c;

    /* JADX INFO: renamed from: d */
    private okhttp3.Call f16256d;

    /* JADX INFO: renamed from: e */
    private Throwable f16257e;

    /* JADX INFO: renamed from: f */
    private boolean f16258f;

    OkHttpCall(ServiceMethod<T, ?> serviceMethod, Object[] objArr) {
        this.f16253a = serviceMethod;
        this.f16254b = objArr;
    }

    @Override // retrofit2.Call
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public OkHttpCall<T> clone() {
        return new OkHttpCall<>(this.f16253a, this.f16254b);
    }

    @Override // retrofit2.Call
    /* JADX INFO: renamed from: a */
    public void mo17078a(final Callback<T> callback) {
        Throwable th;
        okhttp3.Call callM17088d;
        Utils.m17162a(callback, "callback == null");
        synchronized (this) {
            if (this.f16258f) {
                throw new IllegalStateException("Already executed.");
            }
            this.f16258f = true;
            okhttp3.Call call = this.f16256d;
            th = this.f16257e;
            if (call == null && th == null) {
                try {
                    callM17088d = m17088d();
                    this.f16256d = callM17088d;
                } catch (Throwable th2) {
                    th = th2;
                    this.f16257e = th;
                    callM17088d = call;
                }
            } else {
                callM17088d = call;
            }
        }
        if (th != null) {
            callback.mo10471a(this, th);
            return;
        }
        if (this.f16255c) {
            callM17088d.mo15538c();
        }
        FirebasePerfOkHttpClient.enqueue(callM17088d, new okhttp3.Callback() { // from class: retrofit2.OkHttpCall.1
            @Override // okhttp3.Callback
            public void onResponse(okhttp3.Call call2, okhttp3.Response response) throws IOException {
                try {
                    m17092a(OkHttpCall.this.m17089a(response));
                } catch (Throwable th3) {
                    m17091a(th3);
                }
            }

            @Override // okhttp3.Callback
            public void onFailure(okhttp3.Call call2, IOException iOException) {
                try {
                    callback.mo10471a(OkHttpCall.this, iOException);
                } catch (Throwable th3) {
                    th3.printStackTrace();
                }
            }

            /* JADX INFO: renamed from: a */
            private void m17091a(Throwable th3) {
                try {
                    callback.mo10471a(OkHttpCall.this, th3);
                } catch (Throwable th4) {
                    th4.printStackTrace();
                }
            }

            /* JADX INFO: renamed from: a */
            private void m17092a(Response<T> response) {
                try {
                    callback.mo10472a(OkHttpCall.this, response);
                } catch (Throwable th3) {
                    th3.printStackTrace();
                }
            }
        });
    }

    /* JADX INFO: renamed from: d */
    private okhttp3.Call m17088d() throws IOException {
        okhttp3.Call callMo15540a = this.f16253a.f16329c.mo15540a(this.f16253a.m17144a(this.f16254b));
        if (callMo15540a == null) {
            throw new NullPointerException("Call.Factory returned null.");
        }
        return callMo15540a;
    }

    /* JADX INFO: renamed from: a */
    Response<T> m17089a(okhttp3.Response response) throws IOException {
        ResponseBody responseBodyM15798h = response.m15798h();
        okhttp3.Response responseM15816a = response.m15799i().m15815a(new NoContentResponseBody(responseBodyM15798h.mo15511a(), responseBodyM15798h.mo15512b())).m15816a();
        int iM15793c = responseM15816a.m15793c();
        if (iM15793c < 200 || iM15793c >= 300) {
            try {
                return Response.m17120a(Utils.m17167a(responseBodyM15798h), responseM15816a);
            } finally {
                responseBodyM15798h.close();
            }
        }
        if (iM15793c == 204 || iM15793c == 205) {
            responseBodyM15798h.close();
            return Response.m17119a((Object) null, responseM15816a);
        }
        ExceptionCatchingRequestBody exceptionCatchingRequestBody = new ExceptionCatchingRequestBody(responseBodyM15798h);
        try {
            return Response.m17119a(this.f16253a.m17143a(exceptionCatchingRequestBody), responseM15816a);
        } catch (RuntimeException e) {
            exceptionCatchingRequestBody.m17093g();
            throw e;
        }
    }

    @Override // retrofit2.Call
    /* JADX INFO: renamed from: a */
    public boolean mo17079a() {
        if (!this.f16255c) {
            synchronized (this) {
                z = this.f16256d != null && this.f16256d.mo15539d();
            }
        }
        return z;
    }

    static final class NoContentResponseBody extends ResponseBody {

        /* JADX INFO: renamed from: a */
        private final MediaType f16264a;

        /* JADX INFO: renamed from: b */
        private final long f16265b;

        NoContentResponseBody(MediaType mediaType, long j) {
            this.f16264a = mediaType;
            this.f16265b = j;
        }

        @Override // okhttp3.ResponseBody
        /* JADX INFO: renamed from: a */
        public MediaType mo15511a() {
            return this.f16264a;
        }

        @Override // okhttp3.ResponseBody
        /* JADX INFO: renamed from: b */
        public long mo15512b() {
            return this.f16265b;
        }

        @Override // okhttp3.ResponseBody
        /* JADX INFO: renamed from: c */
        public BufferedSource mo15513c() {
            throw new IllegalStateException("Cannot read raw response body of a converted body.");
        }
    }

    static final class ExceptionCatchingRequestBody extends ResponseBody {

        /* JADX INFO: renamed from: a */
        IOException f16261a;

        /* JADX INFO: renamed from: b */
        private final ResponseBody f16262b;

        ExceptionCatchingRequestBody(ResponseBody responseBody) {
            this.f16262b = responseBody;
        }

        @Override // okhttp3.ResponseBody
        /* JADX INFO: renamed from: a */
        public MediaType mo15511a() {
            return this.f16262b.mo15511a();
        }

        @Override // okhttp3.ResponseBody
        /* JADX INFO: renamed from: b */
        public long mo15512b() {
            return this.f16262b.mo15512b();
        }

        @Override // okhttp3.ResponseBody
        /* JADX INFO: renamed from: c */
        public BufferedSource mo15513c() {
            return Okio.m16360a(new ForwardingSource(this.f16262b.mo15513c()) { // from class: retrofit2.OkHttpCall.ExceptionCatchingRequestBody.1
                @Override // okio.ForwardingSource, okio.Source
                /* JADX INFO: renamed from: a */
                public long mo15863a(Buffer buffer, long j) throws IOException {
                    try {
                        return super.mo15863a(buffer, j);
                    } catch (IOException e) {
                        ExceptionCatchingRequestBody.this.f16261a = e;
                        throw e;
                    }
                }
            });
        }

        @Override // okhttp3.ResponseBody, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.f16262b.close();
        }

        /* JADX INFO: renamed from: g */
        void m17093g() throws IOException {
            if (this.f16261a != null) {
                throw this.f16261a;
            }
        }
    }
}
