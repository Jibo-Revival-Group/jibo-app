package okhttp3.internal.http;

import com.google.api.client.http.HttpMethods;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.HttpRetryException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.SocketTimeoutException;
import java.security.cert.CertificateException;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocketFactory;
import okhttp3.Address;
import okhttp3.CertificatePinner;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.Route;
import okhttp3.internal.Util;
import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.connection.RouteException;
import okhttp3.internal.connection.StreamAllocation;
import okhttp3.internal.http2.ConnectionShutdownException;
import org.apache.http.HttpStatus;

/* JADX INFO: loaded from: classes2.dex */
public final class RetryAndFollowUpInterceptor implements Interceptor {

    /* JADX INFO: renamed from: a */
    private final OkHttpClient f15378a;

    /* JADX INFO: renamed from: b */
    private final boolean f15379b;

    /* JADX INFO: renamed from: c */
    private StreamAllocation f15380c;

    /* JADX INFO: renamed from: d */
    private Object f15381d;

    /* JADX INFO: renamed from: e */
    private volatile boolean f15382e;

    public RetryAndFollowUpInterceptor(OkHttpClient okHttpClient, boolean z) {
        this.f15378a = okHttpClient;
        this.f15379b = z;
    }

    /* JADX INFO: renamed from: a */
    public void m15999a() {
        this.f15382e = true;
        StreamAllocation streamAllocation = this.f15380c;
        if (streamAllocation != null) {
            streamAllocation.m15955e();
        }
    }

    /* JADX INFO: renamed from: b */
    public boolean m16001b() {
        return this.f15382e;
    }

    /* JADX INFO: renamed from: a */
    public void m16000a(Object obj) {
        this.f15381d = obj;
    }

    @Override // okhttp3.Interceptor
    /* JADX INFO: renamed from: a */
    public Response mo12243a(Interceptor.Chain chain) throws IOException {
        Response responseM15988a;
        Request requestMo15692a = chain.mo15692a();
        this.f15380c = new StreamAllocation(this.f15378a.m15721o(), m15994a(requestMo15692a.m15765a()), this.f15381d);
        Response response = null;
        int i = 0;
        Request requestM15995a = requestMo15692a;
        while (!this.f15382e) {
            try {
                try {
                    responseM15988a = ((RealInterceptorChain) chain).m15988a(requestM15995a, this.f15380c, null, null);
                    if (response != null) {
                        responseM15988a = responseM15988a.m15799i().m15820c(response.m15799i().m15815a((ResponseBody) null).m15816a()).m15816a();
                    }
                    requestM15995a = m15995a(responseM15988a);
                } catch (IOException e) {
                    if (!m15997a(e, !(e instanceof ConnectionShutdownException), requestM15995a)) {
                        throw e;
                    }
                } catch (RouteException e2) {
                    if (!m15997a(e2.m15927a(), false, requestM15995a)) {
                        throw e2.m15927a();
                    }
                }
                if (requestM15995a == null) {
                    if (!this.f15379b) {
                        this.f15380c.m15953c();
                    }
                    return responseM15988a;
                }
                Util.m15843a(responseM15988a.m15798h());
                int i2 = i + 1;
                if (i2 > 20) {
                    this.f15380c.m15953c();
                    throw new ProtocolException("Too many follow-up requests: " + i2);
                }
                if (requestM15995a.m15769d() instanceof UnrepeatableRequestBody) {
                    this.f15380c.m15953c();
                    throw new HttpRetryException("Cannot retry streamed HTTP body", responseM15988a.m15793c());
                }
                if (!m15998a(responseM15988a, requestM15995a.m15765a())) {
                    this.f15380c.m15953c();
                    this.f15380c = new StreamAllocation(this.f15378a.m15721o(), m15994a(requestM15995a.m15765a()), this.f15381d);
                } else if (this.f15380c.m15946a() != null) {
                    throw new IllegalStateException("Closing the body of " + responseM15988a + " didn't close its backing stream. Bad interceptor?");
                }
                i = i2;
                response = responseM15988a;
            } catch (Throwable th) {
                this.f15380c.m15948a((IOException) null);
                this.f15380c.m15953c();
                throw th;
            }
        }
        this.f15380c.m15953c();
        throw new IOException("Canceled");
    }

    /* JADX INFO: renamed from: a */
    private Address m15994a(HttpUrl httpUrl) {
        HostnameVerifier hostnameVerifierM15717k;
        SSLSocketFactory sSLSocketFactoryM15716j;
        CertificatePinner certificatePinnerM15718l = null;
        if (httpUrl.m15651d()) {
            sSLSocketFactoryM15716j = this.f15378a.m15716j();
            hostnameVerifierM15717k = this.f15378a.m15717k();
            certificatePinnerM15718l = this.f15378a.m15718l();
        } else {
            hostnameVerifierM15717k = null;
            sSLSocketFactoryM15716j = null;
        }
        return new Address(httpUrl.m15654g(), httpUrl.m15655h(), this.f15378a.m15714h(), this.f15378a.m15715i(), sSLSocketFactoryM15716j, hostnameVerifierM15717k, certificatePinnerM15718l, this.f15378a.m15720n(), this.f15378a.m15710d(), this.f15378a.m15726t(), this.f15378a.m15727u(), this.f15378a.m15711e());
    }

    /* JADX INFO: renamed from: a */
    private boolean m15997a(IOException iOException, boolean z, Request request) {
        this.f15380c.m15948a(iOException);
        if (this.f15378a.m15724r()) {
            return !(z && (request.m15769d() instanceof UnrepeatableRequestBody)) && m15996a(iOException, z) && this.f15380c.m15956f();
        }
        return false;
    }

    /* JADX INFO: renamed from: a */
    private boolean m15996a(IOException iOException, boolean z) {
        if (iOException instanceof ProtocolException) {
            return false;
        }
        if (iOException instanceof InterruptedIOException) {
            return (iOException instanceof SocketTimeoutException) && !z;
        }
        return (((iOException instanceof SSLHandshakeException) && (iOException.getCause() instanceof CertificateException)) || (iOException instanceof SSLPeerUnverifiedException)) ? false : true;
    }

    /* JADX INFO: renamed from: a */
    private Request m15995a(Response response) throws IOException {
        String strM15789a;
        HttpUrl httpUrlM15649c;
        Proxy proxyM15710d;
        if (response == null) {
            throw new IllegalStateException();
        }
        RealConnection realConnectionM15952b = this.f15380c.m15952b();
        Route routeMo15554a = realConnectionM15952b != null ? realConnectionM15952b.mo15554a() : null;
        int iM15793c = response.m15793c();
        String strM15766b = response.m15791a().m15766b();
        switch (iM15793c) {
            case 300:
            case 301:
            case 302:
            case 303:
                break;
            case 307:
            case 308:
                if (!strM15766b.equals(HttpMethods.GET) && !strM15766b.equals(HttpMethods.HEAD)) {
                    return null;
                }
                break;
            case 401:
                return this.f15378a.m15719m().authenticate(routeMo15554a, response);
            case HttpStatus.SC_PROXY_AUTHENTICATION_REQUIRED /* 407 */:
                if (routeMo15554a != null) {
                    proxyM15710d = routeMo15554a.m15828b();
                } else {
                    proxyM15710d = this.f15378a.m15710d();
                }
                if (proxyM15710d.type() != Proxy.Type.HTTP) {
                    throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
                }
                return this.f15378a.m15720n().authenticate(routeMo15554a, response);
            case HttpStatus.SC_REQUEST_TIMEOUT /* 408 */:
                if (response.m15791a().m15769d() instanceof UnrepeatableRequestBody) {
                    return null;
                }
                return response.m15791a();
            default:
                return null;
        }
        if (!this.f15378a.m15723q() || (strM15789a = response.m15789a(org.apache.http.HttpHeaders.LOCATION)) == null || (httpUrlM15649c = response.m15791a().m15765a().m15649c(strM15789a)) == null) {
            return null;
        }
        if (!httpUrlM15649c.m15648c().equals(response.m15791a().m15765a().m15648c()) && !this.f15378a.m15722p()) {
            return null;
        }
        Request.Builder builderM15770e = response.m15791a().m15770e();
        if (HttpMethod.m15985c(strM15766b)) {
            boolean zM15986d = HttpMethod.m15986d(strM15766b);
            if (HttpMethod.m15987e(strM15766b)) {
                builderM15770e.m15776a(HttpMethods.GET, (RequestBody) null);
            } else {
                builderM15770e.m15776a(strM15766b, zM15986d ? response.m15791a().m15769d() : null);
            }
            if (!zM15986d) {
                builderM15770e.m15781b("Transfer-Encoding");
                builderM15770e.m15781b("Content-Length");
                builderM15770e.m15781b("Content-Type");
            }
        }
        if (!m15998a(response, httpUrlM15649c)) {
            builderM15770e.m15781b(org.apache.http.HttpHeaders.AUTHORIZATION);
        }
        return builderM15770e.m15778a(httpUrlM15649c).m15784c();
    }

    /* JADX INFO: renamed from: a */
    private boolean m15998a(Response response, HttpUrl httpUrl) {
        HttpUrl httpUrlM15765a = response.m15791a().m15765a();
        return httpUrlM15765a.m15654g().equals(httpUrl.m15654g()) && httpUrlM15765a.m15655h() == httpUrl.m15655h() && httpUrlM15765a.m15648c().equals(httpUrl.m15648c());
    }
}
