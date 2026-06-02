package okhttp3;

import java.net.Proxy;
import java.net.ProxySelector;
import java.net.Socket;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import okhttp3.Call;
import okhttp3.EventListener;
import okhttp3.Headers;
import okhttp3.Response;
import okhttp3.internal.Internal;
import okhttp3.internal.Util;
import okhttp3.internal.cache.InternalCache;
import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.connection.RouteDatabase;
import okhttp3.internal.connection.StreamAllocation;
import okhttp3.internal.platform.Platform;
import okhttp3.internal.tls.CertificateChainCleaner;
import okhttp3.internal.tls.OkHostnameVerifier;

/* JADX INFO: loaded from: classes2.dex */
public class OkHttpClient implements Cloneable, Call.Factory {

    /* JADX INFO: renamed from: a */
    static final List<Protocol> f15118a = Util.m15840a(Protocol.HTTP_2, Protocol.HTTP_1_1);

    /* JADX INFO: renamed from: b */
    static final List<ConnectionSpec> f15119b = Util.m15840a(ConnectionSpec.f15029a, ConnectionSpec.f15031c);

    /* JADX INFO: renamed from: A */
    final int f15120A;

    /* JADX INFO: renamed from: B */
    final int f15121B;

    /* JADX INFO: renamed from: C */
    final int f15122C;

    /* JADX INFO: renamed from: c */
    final Dispatcher f15123c;

    /* JADX INFO: renamed from: d */
    final Proxy f15124d;

    /* JADX INFO: renamed from: e */
    final List<Protocol> f15125e;

    /* JADX INFO: renamed from: f */
    final List<ConnectionSpec> f15126f;

    /* JADX INFO: renamed from: g */
    final List<Interceptor> f15127g;

    /* JADX INFO: renamed from: h */
    final List<Interceptor> f15128h;

    /* JADX INFO: renamed from: i */
    final EventListener.Factory f15129i;

    /* JADX INFO: renamed from: j */
    final ProxySelector f15130j;

    /* JADX INFO: renamed from: k */
    final CookieJar f15131k;

    /* JADX INFO: renamed from: l */
    final Cache f15132l;

    /* JADX INFO: renamed from: m */
    final InternalCache f15133m;

    /* JADX INFO: renamed from: n */
    final SocketFactory f15134n;

    /* JADX INFO: renamed from: o */
    final SSLSocketFactory f15135o;

    /* JADX INFO: renamed from: p */
    final CertificateChainCleaner f15136p;

    /* JADX INFO: renamed from: q */
    final HostnameVerifier f15137q;

    /* JADX INFO: renamed from: r */
    final CertificatePinner f15138r;

    /* JADX INFO: renamed from: s */
    final Authenticator f15139s;

    /* JADX INFO: renamed from: t */
    final Authenticator f15140t;

    /* JADX INFO: renamed from: u */
    final ConnectionPool f15141u;

    /* JADX INFO: renamed from: v */
    final Dns f15142v;

    /* JADX INFO: renamed from: w */
    final boolean f15143w;

    /* JADX INFO: renamed from: x */
    final boolean f15144x;

    /* JADX INFO: renamed from: y */
    final boolean f15145y;

    /* JADX INFO: renamed from: z */
    final int f15146z;

    static {
        Internal.f15235a = new Internal() { // from class: okhttp3.OkHttpClient.1
            @Override // okhttp3.internal.Internal
            /* JADX INFO: renamed from: a */
            public void mo15737a(Headers.Builder builder, String str) {
                builder.m15624a(str);
            }

            @Override // okhttp3.internal.Internal
            /* JADX INFO: renamed from: a */
            public void mo15738a(Headers.Builder builder, String str, String str2) {
                builder.m15628b(str, str2);
            }

            @Override // okhttp3.internal.Internal
            /* JADX INFO: renamed from: a */
            public boolean mo15740a(ConnectionPool connectionPool, RealConnection realConnection) {
                return connectionPool.m15561b(realConnection);
            }

            @Override // okhttp3.internal.Internal
            /* JADX INFO: renamed from: a */
            public RealConnection mo15734a(ConnectionPool connectionPool, Address address, StreamAllocation streamAllocation, Route route) {
                return connectionPool.m15559a(address, streamAllocation, route);
            }

            @Override // okhttp3.internal.Internal
            /* JADX INFO: renamed from: a */
            public boolean mo15739a(Address address, Address address2) {
                return address.m15483a(address2);
            }

            @Override // okhttp3.internal.Internal
            /* JADX INFO: renamed from: a */
            public Socket mo15733a(ConnectionPool connectionPool, Address address, StreamAllocation streamAllocation) {
                return connectionPool.m15558a(address, streamAllocation);
            }

            @Override // okhttp3.internal.Internal
            /* JADX INFO: renamed from: b */
            public void mo15741b(ConnectionPool connectionPool, RealConnection realConnection) {
                connectionPool.m15560a(realConnection);
            }

            @Override // okhttp3.internal.Internal
            /* JADX INFO: renamed from: a */
            public RouteDatabase mo15735a(ConnectionPool connectionPool) {
                return connectionPool.f15022a;
            }

            @Override // okhttp3.internal.Internal
            /* JADX INFO: renamed from: a */
            public int mo15732a(Response.Builder builder) {
                return builder.f15214c;
            }

            @Override // okhttp3.internal.Internal
            /* JADX INFO: renamed from: a */
            public void mo15736a(ConnectionSpec connectionSpec, SSLSocket sSLSocket, boolean z) {
                connectionSpec.m15563a(sSLSocket, z);
            }
        };
    }

    public OkHttpClient() {
        this(new Builder());
    }

    OkHttpClient(Builder builder) {
        this.f15123c = builder.f15148a;
        this.f15124d = builder.f15149b;
        this.f15125e = builder.f15150c;
        this.f15126f = builder.f15151d;
        this.f15127g = Util.m15839a(builder.f15152e);
        this.f15128h = Util.m15839a(builder.f15153f);
        this.f15129i = builder.f15154g;
        this.f15130j = builder.f15155h;
        this.f15131k = builder.f15156i;
        this.f15132l = builder.f15157j;
        this.f15133m = builder.f15158k;
        this.f15134n = builder.f15159l;
        Iterator<ConnectionSpec> it = this.f15126f.iterator();
        boolean z = false;
        while (it.hasNext()) {
            z = z || it.next().m15564a();
        }
        if (builder.f15160m != null || !z) {
            this.f15135o = builder.f15160m;
            this.f15136p = builder.f15161n;
        } else {
            X509TrustManager x509TrustManagerM15706z = m15706z();
            this.f15135o = m15705a(x509TrustManagerM15706z);
            this.f15136p = CertificateChainCleaner.m16212a(x509TrustManagerM15706z);
        }
        this.f15137q = builder.f15162o;
        this.f15138r = builder.f15163p.m15545a(this.f15136p);
        this.f15139s = builder.f15164q;
        this.f15140t = builder.f15165r;
        this.f15141u = builder.f15166s;
        this.f15142v = builder.f15167t;
        this.f15143w = builder.f15168u;
        this.f15144x = builder.f15169v;
        this.f15145y = builder.f15170w;
        this.f15146z = builder.f15171x;
        this.f15120A = builder.f15172y;
        this.f15121B = builder.f15173z;
        this.f15122C = builder.f15147A;
    }

    /* JADX INFO: renamed from: z */
    private X509TrustManager m15706z() {
        try {
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustManagerFactory.init((KeyStore) null);
            TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
            if (trustManagers.length != 1 || !(trustManagers[0] instanceof X509TrustManager)) {
                throw new IllegalStateException("Unexpected default trust managers:" + Arrays.toString(trustManagers));
            }
            return (X509TrustManager) trustManagers[0];
        } catch (GeneralSecurityException e) {
            throw new AssertionError();
        }
    }

    /* JADX INFO: renamed from: a */
    private SSLSocketFactory m15705a(X509TrustManager x509TrustManager) {
        try {
            SSLContext sSLContext = SSLContext.getInstance("TLS");
            sSLContext.init(null, new TrustManager[]{x509TrustManager}, null);
            return sSLContext.getSocketFactory();
        } catch (GeneralSecurityException e) {
            throw new AssertionError();
        }
    }

    /* JADX INFO: renamed from: a */
    public int m15707a() {
        return this.f15146z;
    }

    /* JADX INFO: renamed from: b */
    public int m15708b() {
        return this.f15120A;
    }

    /* JADX INFO: renamed from: c */
    public int m15709c() {
        return this.f15121B;
    }

    /* JADX INFO: renamed from: d */
    public Proxy m15710d() {
        return this.f15124d;
    }

    /* JADX INFO: renamed from: e */
    public ProxySelector m15711e() {
        return this.f15130j;
    }

    /* JADX INFO: renamed from: f */
    public CookieJar m15712f() {
        return this.f15131k;
    }

    /* JADX INFO: renamed from: g */
    InternalCache m15713g() {
        return this.f15132l != null ? this.f15132l.f14840a : this.f15133m;
    }

    /* JADX INFO: renamed from: h */
    public Dns m15714h() {
        return this.f15142v;
    }

    /* JADX INFO: renamed from: i */
    public SocketFactory m15715i() {
        return this.f15134n;
    }

    /* JADX INFO: renamed from: j */
    public SSLSocketFactory m15716j() {
        return this.f15135o;
    }

    /* JADX INFO: renamed from: k */
    public HostnameVerifier m15717k() {
        return this.f15137q;
    }

    /* JADX INFO: renamed from: l */
    public CertificatePinner m15718l() {
        return this.f15138r;
    }

    /* JADX INFO: renamed from: m */
    public Authenticator m15719m() {
        return this.f15140t;
    }

    /* JADX INFO: renamed from: n */
    public Authenticator m15720n() {
        return this.f15139s;
    }

    /* JADX INFO: renamed from: o */
    public ConnectionPool m15721o() {
        return this.f15141u;
    }

    /* JADX INFO: renamed from: p */
    public boolean m15722p() {
        return this.f15143w;
    }

    /* JADX INFO: renamed from: q */
    public boolean m15723q() {
        return this.f15144x;
    }

    /* JADX INFO: renamed from: r */
    public boolean m15724r() {
        return this.f15145y;
    }

    /* JADX INFO: renamed from: s */
    public Dispatcher m15725s() {
        return this.f15123c;
    }

    /* JADX INFO: renamed from: t */
    public List<Protocol> m15726t() {
        return this.f15125e;
    }

    /* JADX INFO: renamed from: u */
    public List<ConnectionSpec> m15727u() {
        return this.f15126f;
    }

    /* JADX INFO: renamed from: v */
    public List<Interceptor> m15728v() {
        return this.f15127g;
    }

    /* JADX INFO: renamed from: w */
    public List<Interceptor> m15729w() {
        return this.f15128h;
    }

    /* JADX INFO: renamed from: x */
    EventListener.Factory m15730x() {
        return this.f15129i;
    }

    @Override // okhttp3.Call.Factory
    /* JADX INFO: renamed from: a */
    public Call mo15540a(Request request) {
        return new RealCall(this, request, false);
    }

    /* JADX INFO: renamed from: y */
    public Builder m15731y() {
        return new Builder(this);
    }

    public static final class Builder {

        /* JADX INFO: renamed from: A */
        int f15147A;

        /* JADX INFO: renamed from: a */
        Dispatcher f15148a;

        /* JADX INFO: renamed from: b */
        Proxy f15149b;

        /* JADX INFO: renamed from: c */
        List<Protocol> f15150c;

        /* JADX INFO: renamed from: d */
        List<ConnectionSpec> f15151d;

        /* JADX INFO: renamed from: e */
        final List<Interceptor> f15152e;

        /* JADX INFO: renamed from: f */
        final List<Interceptor> f15153f;

        /* JADX INFO: renamed from: g */
        EventListener.Factory f15154g;

        /* JADX INFO: renamed from: h */
        ProxySelector f15155h;

        /* JADX INFO: renamed from: i */
        CookieJar f15156i;

        /* JADX INFO: renamed from: j */
        Cache f15157j;

        /* JADX INFO: renamed from: k */
        InternalCache f15158k;

        /* JADX INFO: renamed from: l */
        SocketFactory f15159l;

        /* JADX INFO: renamed from: m */
        SSLSocketFactory f15160m;

        /* JADX INFO: renamed from: n */
        CertificateChainCleaner f15161n;

        /* JADX INFO: renamed from: o */
        HostnameVerifier f15162o;

        /* JADX INFO: renamed from: p */
        CertificatePinner f15163p;

        /* JADX INFO: renamed from: q */
        Authenticator f15164q;

        /* JADX INFO: renamed from: r */
        Authenticator f15165r;

        /* JADX INFO: renamed from: s */
        ConnectionPool f15166s;

        /* JADX INFO: renamed from: t */
        Dns f15167t;

        /* JADX INFO: renamed from: u */
        boolean f15168u;

        /* JADX INFO: renamed from: v */
        boolean f15169v;

        /* JADX INFO: renamed from: w */
        boolean f15170w;

        /* JADX INFO: renamed from: x */
        int f15171x;

        /* JADX INFO: renamed from: y */
        int f15172y;

        /* JADX INFO: renamed from: z */
        int f15173z;

        public Builder() {
            this.f15152e = new ArrayList();
            this.f15153f = new ArrayList();
            this.f15148a = new Dispatcher();
            this.f15150c = OkHttpClient.f15118a;
            this.f15151d = OkHttpClient.f15119b;
            this.f15154g = EventListener.m15603a(EventListener.f15063a);
            this.f15155h = ProxySelector.getDefault();
            this.f15156i = CookieJar.f15054a;
            this.f15159l = SocketFactory.getDefault();
            this.f15162o = OkHostnameVerifier.f15621a;
            this.f15163p = CertificatePinner.f14897a;
            this.f15164q = Authenticator.f14839a;
            this.f15165r = Authenticator.f14839a;
            this.f15166s = new ConnectionPool();
            this.f15167t = Dns.f15062a;
            this.f15168u = true;
            this.f15169v = true;
            this.f15170w = true;
            this.f15171x = 10000;
            this.f15172y = 10000;
            this.f15173z = 10000;
            this.f15147A = 0;
        }

        Builder(OkHttpClient okHttpClient) {
            this.f15152e = new ArrayList();
            this.f15153f = new ArrayList();
            this.f15148a = okHttpClient.f15123c;
            this.f15149b = okHttpClient.f15124d;
            this.f15150c = okHttpClient.f15125e;
            this.f15151d = okHttpClient.f15126f;
            this.f15152e.addAll(okHttpClient.f15127g);
            this.f15153f.addAll(okHttpClient.f15128h);
            this.f15154g = okHttpClient.f15129i;
            this.f15155h = okHttpClient.f15130j;
            this.f15156i = okHttpClient.f15131k;
            this.f15158k = okHttpClient.f15133m;
            this.f15157j = okHttpClient.f15132l;
            this.f15159l = okHttpClient.f15134n;
            this.f15160m = okHttpClient.f15135o;
            this.f15161n = okHttpClient.f15136p;
            this.f15162o = okHttpClient.f15137q;
            this.f15163p = okHttpClient.f15138r;
            this.f15164q = okHttpClient.f15139s;
            this.f15165r = okHttpClient.f15140t;
            this.f15166s = okHttpClient.f15141u;
            this.f15167t = okHttpClient.f15142v;
            this.f15168u = okHttpClient.f15143w;
            this.f15169v = okHttpClient.f15144x;
            this.f15170w = okHttpClient.f15145y;
            this.f15171x = okHttpClient.f15146z;
            this.f15172y = okHttpClient.f15120A;
            this.f15173z = okHttpClient.f15121B;
            this.f15147A = okHttpClient.f15122C;
        }

        /* JADX INFO: renamed from: a */
        public Builder m15743a(long j, TimeUnit timeUnit) {
            this.f15171x = m15742a("timeout", j, timeUnit);
            return this;
        }

        /* JADX INFO: renamed from: b */
        public Builder m15753b(long j, TimeUnit timeUnit) {
            this.f15172y = m15742a("timeout", j, timeUnit);
            return this;
        }

        /* JADX INFO: renamed from: c */
        public Builder m15755c(long j, TimeUnit timeUnit) {
            this.f15173z = m15742a("timeout", j, timeUnit);
            return this;
        }

        /* JADX INFO: renamed from: a */
        private static int m15742a(String str, long j, TimeUnit timeUnit) {
            if (j < 0) {
                throw new IllegalArgumentException(str + " < 0");
            }
            if (timeUnit == null) {
                throw new NullPointerException("unit == null");
            }
            long millis = timeUnit.toMillis(j);
            if (millis > 2147483647L) {
                throw new IllegalArgumentException(str + " too large.");
            }
            if (millis != 0 || j <= 0) {
                return (int) millis;
            }
            throw new IllegalArgumentException(str + " too small.");
        }

        /* JADX INFO: renamed from: a */
        public Builder m15744a(Proxy proxy) {
            this.f15149b = proxy;
            return this;
        }

        /* JADX INFO: renamed from: a */
        public Builder m15749a(Cache cache) {
            this.f15157j = cache;
            this.f15158k = null;
            return this;
        }

        /* JADX INFO: renamed from: a */
        public Builder m15746a(SSLSocketFactory sSLSocketFactory) {
            if (sSLSocketFactory == null) {
                throw new NullPointerException("sslSocketFactory == null");
            }
            X509TrustManager x509TrustManagerMo16179a = Platform.m16203b().mo16179a(sSLSocketFactory);
            if (x509TrustManagerMo16179a == null) {
                throw new IllegalStateException("Unable to extract the trust manager on " + Platform.m16203b() + ", sslSocketFactory is " + sSLSocketFactory.getClass());
            }
            this.f15160m = sSLSocketFactory;
            this.f15161n = CertificateChainCleaner.m16212a(x509TrustManagerMo16179a);
            return this;
        }

        /* JADX INFO: renamed from: a */
        public Builder m15747a(SSLSocketFactory sSLSocketFactory, X509TrustManager x509TrustManager) {
            if (sSLSocketFactory == null) {
                throw new NullPointerException("sslSocketFactory == null");
            }
            if (x509TrustManager == null) {
                throw new NullPointerException("trustManager == null");
            }
            this.f15160m = sSLSocketFactory;
            this.f15161n = CertificateChainCleaner.m16212a(x509TrustManager);
            return this;
        }

        /* JADX INFO: renamed from: a */
        public Builder m15748a(Authenticator authenticator) {
            if (authenticator == null) {
                throw new NullPointerException("proxyAuthenticator == null");
            }
            this.f15164q = authenticator;
            return this;
        }

        /* JADX INFO: renamed from: a */
        public Builder m15750a(Dispatcher dispatcher) {
            if (dispatcher == null) {
                throw new IllegalArgumentException("dispatcher == null");
            }
            this.f15148a = dispatcher;
            return this;
        }

        /* JADX INFO: renamed from: a */
        public Builder m15745a(List<ConnectionSpec> list) {
            this.f15151d = Util.m15839a(list);
            return this;
        }

        /* JADX INFO: renamed from: a */
        public Builder m15751a(Interceptor interceptor) {
            this.f15152e.add(interceptor);
            return this;
        }

        /* JADX INFO: renamed from: b */
        public Builder m15754b(Interceptor interceptor) {
            this.f15153f.add(interceptor);
            return this;
        }

        /* JADX INFO: renamed from: a */
        public OkHttpClient m15752a() {
            return new OkHttpClient(this);
        }
    }
}
