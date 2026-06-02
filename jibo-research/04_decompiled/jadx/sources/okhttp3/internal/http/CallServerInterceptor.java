package okhttp3.internal.http;

import java.io.IOException;
import java.net.ProtocolException;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.Util;
import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.connection.StreamAllocation;
import okio.BufferedSink;
import okio.Okio;
import org.apache.http.protocol.HTTP;

/* JADX INFO: loaded from: classes2.dex */
public final class CallServerInterceptor implements Interceptor {

    /* JADX INFO: renamed from: a */
    private final boolean f15364a;

    public CallServerInterceptor(boolean z) {
        this.f15364a = z;
    }

    @Override // okhttp3.Interceptor
    /* JADX INFO: renamed from: a */
    public Response mo12243a(Interceptor.Chain chain) throws IOException {
        Response.Builder builderMo15958a;
        Response responseM15816a;
        RealInterceptorChain realInterceptorChain = (RealInterceptorChain) chain;
        HttpCodec httpCodecM15990d = realInterceptorChain.m15990d();
        StreamAllocation streamAllocationM15989c = realInterceptorChain.m15989c();
        RealConnection realConnection = (RealConnection) realInterceptorChain.mo15694b();
        Request requestMo15692a = realInterceptorChain.mo15692a();
        long jCurrentTimeMillis = System.currentTimeMillis();
        httpCodecM15990d.mo15962a(requestMo15692a);
        Response.Builder builderMo15958a2 = null;
        if (!HttpMethod.m15985c(requestMo15692a.m15766b()) || requestMo15692a.m15769d() == null) {
            builderMo15958a = null;
        } else {
            if (HTTP.EXPECT_CONTINUE.equalsIgnoreCase(requestMo15692a.m15764a("Expect"))) {
                httpCodecM15990d.mo15961a();
                builderMo15958a2 = httpCodecM15990d.mo15958a(true);
            }
            if (builderMo15958a2 == null) {
                BufferedSink bufferedSinkM16359a = Okio.m16359a(httpCodecM15990d.mo15960a(requestMo15692a, requestMo15692a.m15769d().mo14285b()));
                requestMo15692a.m15769d().mo14284a(bufferedSinkM16359a);
                bufferedSinkM16359a.close();
                builderMo15958a = builderMo15958a2;
            } else {
                if (!realConnection.m15922f()) {
                    streamAllocationM15989c.m15954d();
                }
                builderMo15958a = builderMo15958a2;
            }
        }
        httpCodecM15990d.mo15963b();
        if (builderMo15958a == null) {
            builderMo15958a = httpCodecM15990d.mo15958a(false);
        }
        Response responseM15816a2 = builderMo15958a.m15813a(requestMo15692a).m15810a(streamAllocationM15989c.m15952b().m15921e()).m15807a(jCurrentTimeMillis).m15817b(System.currentTimeMillis()).m15816a();
        int iM15793c = responseM15816a2.m15793c();
        if (this.f15364a && iM15793c == 101) {
            responseM15816a = responseM15816a2.m15799i().m15815a(Util.f15239c).m15816a();
        } else {
            responseM15816a = responseM15816a2.m15799i().m15815a(httpCodecM15990d.mo15959a(responseM15816a2)).m15816a();
        }
        if ("close".equalsIgnoreCase(responseM15816a.m15791a().m15764a("Connection")) || "close".equalsIgnoreCase(responseM15816a.m15789a("Connection"))) {
            streamAllocationM15989c.m15954d();
        }
        if ((iM15793c == 204 || iM15793c == 205) && responseM15816a.m15798h().mo15512b() > 0) {
            throw new ProtocolException("HTTP " + iM15793c + " had non-zero Content-Length: " + responseM15816a.m15798h().mo15512b());
        }
        return responseM15816a;
    }
}
