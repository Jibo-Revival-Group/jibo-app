package okhttp3;

import java.io.IOException;
import java.util.ArrayList;
import okhttp3.EventListener;
import okhttp3.internal.NamedRunnable;
import okhttp3.internal.cache.CacheInterceptor;
import okhttp3.internal.connection.ConnectInterceptor;
import okhttp3.internal.http.BridgeInterceptor;
import okhttp3.internal.http.CallServerInterceptor;
import okhttp3.internal.http.RealInterceptorChain;
import okhttp3.internal.http.RetryAndFollowUpInterceptor;
import okhttp3.internal.platform.Platform;

/* JADX INFO: loaded from: classes2.dex */
final class RealCall implements Call {

    /* JADX INFO: renamed from: a */
    final OkHttpClient f15174a;

    /* JADX INFO: renamed from: b */
    final RetryAndFollowUpInterceptor f15175b;

    /* JADX INFO: renamed from: c */
    final EventListener f15176c;

    /* JADX INFO: renamed from: d */
    final Request f15177d;

    /* JADX INFO: renamed from: e */
    final boolean f15178e;

    /* JADX INFO: renamed from: f */
    private boolean f15179f;

    RealCall(OkHttpClient okHttpClient, Request request, boolean z) {
        EventListener.Factory factoryM15730x = okHttpClient.m15730x();
        this.f15174a = okHttpClient;
        this.f15177d = request;
        this.f15178e = z;
        this.f15175b = new RetryAndFollowUpInterceptor(okHttpClient, z);
        this.f15176c = factoryM15730x.mo15604a(this);
    }

    @Override // okhttp3.Call
    /* JADX INFO: renamed from: a */
    public Request mo15535a() {
        return this.f15177d;
    }

    @Override // okhttp3.Call
    /* JADX INFO: renamed from: b */
    public Response mo15537b() throws IOException {
        synchronized (this) {
            if (this.f15179f) {
                throw new IllegalStateException("Already Executed");
            }
            this.f15179f = true;
        }
        m15756i();
        try {
            this.f15174a.m15725s().m15596a(this);
            Response responseM15760h = m15760h();
            if (responseM15760h == null) {
                throw new IOException("Canceled");
            }
            return responseM15760h;
        } finally {
            this.f15174a.m15725s().m15600b(this);
        }
    }

    /* JADX INFO: renamed from: i */
    private void m15756i() {
        this.f15175b.m16000a(Platform.m16203b().mo16177a("response.body().close()"));
    }

    @Override // okhttp3.Call
    /* JADX INFO: renamed from: a */
    public void mo15536a(Callback callback) {
        synchronized (this) {
            if (this.f15179f) {
                throw new IllegalStateException("Already Executed");
            }
            this.f15179f = true;
        }
        m15756i();
        this.f15174a.m15725s().m15595a(new AsyncCall(callback));
    }

    @Override // okhttp3.Call
    /* JADX INFO: renamed from: c */
    public void mo15538c() {
        this.f15175b.m15999a();
    }

    @Override // okhttp3.Call
    /* JADX INFO: renamed from: d */
    public boolean mo15539d() {
        return this.f15175b.m16001b();
    }

    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public RealCall clone() {
        return new RealCall(this.f15174a, this.f15177d, this.f15178e);
    }

    final class AsyncCall extends NamedRunnable {

        /* JADX INFO: renamed from: c */
        private final Callback f15181c;

        AsyncCall(Callback callback) {
            super("OkHttp %s", RealCall.this.m15759g());
            this.f15181c = callback;
        }

        /* JADX INFO: renamed from: a */
        String m15761a() {
            return RealCall.this.f15177d.m15765a().m15654g();
        }

        /* JADX INFO: renamed from: b */
        RealCall m15762b() {
            return RealCall.this;
        }

        @Override // okhttp3.internal.NamedRunnable
        /* JADX INFO: renamed from: c */
        protected void mo15763c() {
            Response responseM15760h;
            boolean z = true;
            try {
                try {
                    responseM15760h = RealCall.this.m15760h();
                } catch (IOException e) {
                    e = e;
                    z = false;
                }
                try {
                    if (RealCall.this.f15175b.m16001b()) {
                        this.f15181c.onFailure(RealCall.this, new IOException("Canceled"));
                    } else {
                        this.f15181c.onResponse(RealCall.this, responseM15760h);
                    }
                } catch (IOException e2) {
                    e = e2;
                    if (z) {
                        Platform.m16203b().mo16181a(4, "Callback failure for " + RealCall.this.m15758f(), e);
                    } else {
                        this.f15181c.onFailure(RealCall.this, e);
                    }
                }
            } finally {
                RealCall.this.f15174a.m15725s().m15599b(this);
            }
        }
    }

    /* JADX INFO: renamed from: f */
    String m15758f() {
        return (mo15539d() ? "canceled " : "") + (this.f15178e ? "web socket" : "call") + " to " + m15759g();
    }

    /* JADX INFO: renamed from: g */
    String m15759g() {
        return this.f15177d.m15765a().m15662o();
    }

    /* JADX INFO: renamed from: h */
    Response m15760h() throws IOException {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.f15174a.m15728v());
        arrayList.add(this.f15175b);
        arrayList.add(new BridgeInterceptor(this.f15174a.m15712f()));
        arrayList.add(new CacheInterceptor(this.f15174a.m15713g()));
        arrayList.add(new ConnectInterceptor(this.f15174a));
        if (!this.f15178e) {
            arrayList.addAll(this.f15174a.m15729w());
        }
        arrayList.add(new CallServerInterceptor(this.f15178e));
        return new RealInterceptorChain(arrayList, null, null, null, 0, this.f15177d).mo15693a(this.f15177d);
    }
}
