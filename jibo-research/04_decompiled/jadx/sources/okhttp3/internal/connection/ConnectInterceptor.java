package okhttp3.internal.connection;

import com.google.api.client.http.HttpMethods;
import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.http.RealInterceptorChain;

/* JADX INFO: loaded from: classes2.dex */
public final class ConnectInterceptor implements Interceptor {

    /* JADX INFO: renamed from: a */
    public final OkHttpClient f15320a;

    public ConnectInterceptor(OkHttpClient okHttpClient) {
        this.f15320a = okHttpClient;
    }

    @Override // okhttp3.Interceptor
    /* JADX INFO: renamed from: a */
    public Response mo12243a(Interceptor.Chain chain) throws IOException {
        RealInterceptorChain realInterceptorChain = (RealInterceptorChain) chain;
        Request requestMo15692a = realInterceptorChain.mo15692a();
        StreamAllocation streamAllocationM15989c = realInterceptorChain.m15989c();
        return realInterceptorChain.m15988a(requestMo15692a, streamAllocationM15989c, streamAllocationM15989c.m15947a(this.f15320a, !requestMo15692a.m15766b().equals(HttpMethods.GET)), streamAllocationM15989c.m15952b());
    }
}
