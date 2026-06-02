package io.fabric.sdk.android.services.network;

import io.fabric.sdk.android.DefaultLogger;
import io.fabric.sdk.android.Logger;
import java.util.Locale;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;

/* JADX INFO: loaded from: classes2.dex */
public class DefaultHttpRequestFactory implements HttpRequestFactory {

    /* JADX INFO: renamed from: a */
    private final Logger f14683a;

    /* JADX INFO: renamed from: b */
    private PinningInfoProvider f14684b;

    /* JADX INFO: renamed from: c */
    private SSLSocketFactory f14685c;

    /* JADX INFO: renamed from: d */
    private boolean f14686d;

    public DefaultHttpRequestFactory() {
        this(new DefaultLogger());
    }

    public DefaultHttpRequestFactory(Logger logger) {
        this.f14683a = logger;
    }

    @Override // io.fabric.sdk.android.services.network.HttpRequestFactory
    /* JADX INFO: renamed from: a */
    public void mo15346a(PinningInfoProvider pinningInfoProvider) {
        if (this.f14684b != pinningInfoProvider) {
            this.f14684b = pinningInfoProvider;
            m15341a();
        }
    }

    /* JADX INFO: renamed from: a */
    private synchronized void m15341a() {
        this.f14686d = false;
        this.f14685c = null;
    }

    @Override // io.fabric.sdk.android.services.network.HttpRequestFactory
    /* JADX INFO: renamed from: a */
    public HttpRequest mo15345a(HttpMethod httpMethod, String str, Map<String, String> map) {
        HttpRequest httpRequestM15357e;
        SSLSocketFactory sSLSocketFactoryM15343b;
        switch (httpMethod) {
            case GET:
                httpRequestM15357e = HttpRequest.m15348a((CharSequence) str, (Map<?, ?>) map, true);
                break;
            case POST:
                httpRequestM15357e = HttpRequest.m15353b((CharSequence) str, (Map<?, ?>) map, true);
                break;
            case PUT:
                httpRequestM15357e = HttpRequest.m15356d((CharSequence) str);
                break;
            case DELETE:
                httpRequestM15357e = HttpRequest.m15357e((CharSequence) str);
                break;
            default:
                throw new IllegalArgumentException("Unsupported HTTP method!");
        }
        if (m15342a(str) && this.f14684b != null && (sSLSocketFactoryM15343b = m15343b()) != null) {
            ((HttpsURLConnection) httpRequestM15357e.m15375a()).setSSLSocketFactory(sSLSocketFactoryM15343b);
        }
        return httpRequestM15357e;
    }

    /* JADX INFO: renamed from: a */
    private boolean m15342a(String str) {
        return str != null && str.toLowerCase(Locale.US).startsWith("https");
    }

    /* JADX INFO: renamed from: b */
    private synchronized SSLSocketFactory m15343b() {
        if (this.f14685c == null && !this.f14686d) {
            this.f14685c = m15344c();
        }
        return this.f14685c;
    }

    /* JADX INFO: renamed from: c */
    private synchronized SSLSocketFactory m15344c() {
        SSLSocketFactory sSLSocketFactoryM15408a;
        this.f14686d = true;
        try {
            sSLSocketFactoryM15408a = NetworkUtils.m15408a(this.f14684b);
            this.f14683a.mo15063a("Fabric", "Custom SSL pinning enabled");
        } catch (Exception e) {
            this.f14683a.mo15073e("Fabric", "Exception while validating pinned certs", e);
            sSLSocketFactoryM15408a = null;
        }
        return sSLSocketFactoryM15408a;
    }
}
