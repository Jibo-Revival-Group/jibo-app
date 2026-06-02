package okhttp3.internal.connection;

import java.io.IOException;
import java.lang.ref.Reference;
import java.net.ConnectException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownServiceException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocket;
import okhttp3.Address;
import okhttp3.CertificatePinner;
import okhttp3.Connection;
import okhttp3.ConnectionPool;
import okhttp3.ConnectionSpec;
import okhttp3.Handshake;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Route;
import okhttp3.internal.Internal;
import okhttp3.internal.Util;
import okhttp3.internal.Version;
import okhttp3.internal.http.HttpCodec;
import okhttp3.internal.http1.Http1Codec;
import okhttp3.internal.http2.ErrorCode;
import okhttp3.internal.http2.Http2Codec;
import okhttp3.internal.http2.Http2Connection;
import okhttp3.internal.http2.Http2Stream;
import okhttp3.internal.platform.Platform;
import okhttp3.internal.tls.OkHostnameVerifier;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Okio;
import org.apache.http.protocol.HTTP;

/* JADX INFO: loaded from: classes2.dex */
public final class RealConnection extends Http2Connection.Listener implements Connection {

    /* JADX INFO: renamed from: a */
    public boolean f15325a;

    /* JADX INFO: renamed from: b */
    public int f15326b;

    /* JADX INFO: renamed from: c */
    public int f15327c = 1;

    /* JADX INFO: renamed from: d */
    public final List<Reference<StreamAllocation>> f15328d = new ArrayList();

    /* JADX INFO: renamed from: e */
    public long f15329e = Long.MAX_VALUE;

    /* JADX INFO: renamed from: g */
    private final ConnectionPool f15330g;

    /* JADX INFO: renamed from: h */
    private final Route f15331h;

    /* JADX INFO: renamed from: i */
    private Socket f15332i;

    /* JADX INFO: renamed from: j */
    private Socket f15333j;

    /* JADX INFO: renamed from: k */
    private Handshake f15334k;

    /* JADX INFO: renamed from: l */
    private Protocol f15335l;

    /* JADX INFO: renamed from: m */
    private Http2Connection f15336m;

    /* JADX INFO: renamed from: n */
    private BufferedSource f15337n;

    /* JADX INFO: renamed from: o */
    private BufferedSink f15338o;

    public RealConnection(ConnectionPool connectionPool, Route route) {
        this.f15330g = connectionPool;
        this.f15331h = route;
    }

    /* JADX INFO: renamed from: a */
    public void m15913a(int i, int i2, int i3, boolean z) throws Throwable {
        if (this.f15335l != null) {
            throw new IllegalStateException("already connected");
        }
        List<ConnectionSpec> listM15488f = this.f15331h.m15827a().m15488f();
        ConnectionSpecSelector connectionSpecSelector = new ConnectionSpecSelector(listM15488f);
        if (this.f15331h.m15827a().m15491i() == null) {
            if (!listM15488f.contains(ConnectionSpec.f15031c)) {
                throw new RouteException(new UnknownServiceException("CLEARTEXT communication not enabled for client"));
            }
            String strM15654g = this.f15331h.m15827a().m15482a().m15654g();
            if (!Platform.m16203b().mo16185b(strM15654g)) {
                throw new RouteException(new UnknownServiceException("CLEARTEXT communication to " + strM15654g + " not permitted by network security policy"));
            }
        }
        RouteException routeException = null;
        do {
            try {
                if (this.f15331h.m15830d()) {
                    m15908a(i, i2, i3);
                } else {
                    m15907a(i, i2);
                }
                m15909a(connectionSpecSelector);
                if (this.f15336m != null) {
                    synchronized (this.f15330g) {
                        this.f15327c = this.f15336m.m16049a();
                    }
                    return;
                }
                return;
            } catch (IOException e) {
                Util.m15844a(this.f15333j);
                Util.m15844a(this.f15332i);
                this.f15333j = null;
                this.f15332i = null;
                this.f15337n = null;
                this.f15338o = null;
                this.f15334k = null;
                this.f15335l = null;
                this.f15336m = null;
                if (routeException == null) {
                    routeException = new RouteException(e);
                } else {
                    routeException.m15928a(e);
                }
                if (!z) {
                    throw routeException;
                }
            }
        } while (connectionSpecSelector.m15905a(e));
        throw routeException;
    }

    /* JADX INFO: renamed from: a */
    private void m15908a(int i, int i2, int i3) throws IOException {
        Request requestM15911g = m15911g();
        HttpUrl httpUrlM15765a = requestM15911g.m15765a();
        int i4 = 0;
        while (true) {
            i4++;
            if (i4 > 21) {
                throw new ProtocolException("Too many tunnel connections attempted: 21");
            }
            m15907a(i, i2);
            requestM15911g = m15906a(i2, i3, requestM15911g, httpUrlM15765a);
            if (requestM15911g != null) {
                Util.m15844a(this.f15332i);
                this.f15332i = null;
                this.f15338o = null;
                this.f15337n = null;
            } else {
                return;
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private void m15907a(int i, int i2) throws IOException {
        Socket socketCreateSocket;
        Proxy proxyM15828b = this.f15331h.m15828b();
        Address addressM15827a = this.f15331h.m15827a();
        if (proxyM15828b.type() == Proxy.Type.DIRECT || proxyM15828b.type() == Proxy.Type.HTTP) {
            socketCreateSocket = addressM15827a.m15485c().createSocket();
        } else {
            socketCreateSocket = new Socket(proxyM15828b);
        }
        this.f15332i = socketCreateSocket;
        this.f15332i.setSoTimeout(i2);
        try {
            Platform.m16203b().mo16183a(this.f15332i, this.f15331h.m15829c(), i);
            try {
                this.f15337n = Okio.m16360a(Okio.m16370b(this.f15332i));
                this.f15338o = Okio.m16359a(Okio.m16364a(this.f15332i));
            } catch (NullPointerException e) {
                if ("throw with null exception".equals(e.getMessage())) {
                    throw new IOException(e);
                }
            }
        } catch (ConnectException e2) {
            ConnectException connectException = new ConnectException("Failed to connect to " + this.f15331h.m15829c());
            connectException.initCause(e2);
            throw connectException;
        }
    }

    /* JADX INFO: renamed from: a */
    private void m15909a(ConnectionSpecSelector connectionSpecSelector) throws Throwable {
        if (this.f15331h.m15827a().m15491i() == null) {
            this.f15335l = Protocol.HTTP_1_1;
            this.f15333j = this.f15332i;
            return;
        }
        m15910b(connectionSpecSelector);
        if (this.f15335l == Protocol.HTTP_2) {
            this.f15333j.setSoTimeout(0);
            this.f15336m = new Http2Connection.Builder(true).m16072a(this.f15333j, this.f15331h.m15827a().m15482a().m15654g(), this.f15337n, this.f15338o).m16073a(this).m16074a();
            this.f15336m.m16068c();
        }
    }

    /* JADX INFO: renamed from: b */
    private void m15910b(ConnectionSpecSelector connectionSpecSelector) throws Throwable {
        SSLSocket sSLSocket;
        Protocol protocol;
        SSLSocket sSLSocket2 = null;
        Address addressM15827a = this.f15331h.m15827a();
        try {
            try {
                sSLSocket = (SSLSocket) addressM15827a.m15491i().createSocket(this.f15332i, addressM15827a.m15482a().m15654g(), addressM15827a.m15482a().m15655h(), true);
            } catch (AssertionError e) {
                e = e;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            ConnectionSpec connectionSpecM15904a = connectionSpecSelector.m15904a(sSLSocket);
            if (connectionSpecM15904a.m15568d()) {
                Platform.m16203b().mo16184a(sSLSocket, addressM15827a.m15482a().m15654g(), addressM15827a.m15487e());
            }
            sSLSocket.startHandshake();
            Handshake handshakeM15609a = Handshake.m15609a(sSLSocket.getSession());
            if (!addressM15827a.m15492j().verify(addressM15827a.m15482a().m15654g(), sSLSocket.getSession())) {
                X509Certificate x509Certificate = (X509Certificate) handshakeM15609a.m15613c().get(0);
                throw new SSLPeerUnverifiedException("Hostname " + addressM15827a.m15482a().m15654g() + " not verified:\n    certificate: " + CertificatePinner.m15541a((Certificate) x509Certificate) + "\n    DN: " + x509Certificate.getSubjectDN().getName() + "\n    subjectAltNames: " + OkHostnameVerifier.m16221a(x509Certificate));
            }
            addressM15827a.m15493k().m15546a(addressM15827a.m15482a().m15654g(), handshakeM15609a.m15613c());
            String strMo16178a = connectionSpecM15904a.m15568d() ? Platform.m16203b().mo16178a(sSLSocket) : null;
            this.f15333j = sSLSocket;
            this.f15337n = Okio.m16360a(Okio.m16370b(this.f15333j));
            this.f15338o = Okio.m16359a(Okio.m16364a(this.f15333j));
            this.f15334k = handshakeM15609a;
            if (strMo16178a != null) {
                protocol = Protocol.get(strMo16178a);
            } else {
                protocol = Protocol.HTTP_1_1;
            }
            this.f15335l = protocol;
            if (sSLSocket != null) {
                Platform.m16203b().mo16192b(sSLSocket);
            }
        } catch (AssertionError e2) {
            e = e2;
            if (!Util.m15845a(e)) {
                throw e;
            }
            throw new IOException(e);
        } catch (Throwable th2) {
            sSLSocket2 = sSLSocket;
            th = th2;
            if (sSLSocket2 != null) {
                Platform.m16203b().mo16192b(sSLSocket2);
            }
            Util.m15844a((Socket) sSLSocket2);
            throw th;
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Failed to find switch 'out' block (already processed)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.calcSwitchOut(SwitchRegionMaker.java:217)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.process(SwitchRegionMaker.java:68)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:112)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:104)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:89)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeMthRegion(RegionMaker.java:48)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:25)
        */
    /* JADX INFO: renamed from: a */
    private okhttp3.Request m15906a(int r9, int r10, okhttp3.Request r11, okhttp3.HttpUrl r12) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 236
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.connection.RealConnection.m15906a(int, int, okhttp3.Request, okhttp3.HttpUrl):okhttp3.Request");
    }

    /* JADX INFO: renamed from: g */
    private Request m15911g() {
        return new Request.Builder().m15778a(this.f15331h.m15827a().m15482a()).m15775a("Host", Util.m15837a(this.f15331h.m15827a().m15482a(), true)).m15775a("Proxy-Connection", HTTP.CONN_KEEP_ALIVE).m15775a("User-Agent", Version.m15858a()).m15784c();
    }

    /* JADX INFO: renamed from: a */
    public boolean m15916a(Address address, Route route) {
        if (this.f15328d.size() >= this.f15327c || this.f15325a || !Internal.f15235a.mo15739a(this.f15331h.m15827a(), address)) {
            return false;
        }
        if (address.m15482a().m15654g().equals(mo15554a().m15827a().m15482a().m15654g())) {
            return true;
        }
        if (this.f15336m == null || route == null || route.m15828b().type() != Proxy.Type.DIRECT || this.f15331h.m15828b().type() != Proxy.Type.DIRECT || !this.f15331h.m15829c().equals(route.m15829c()) || route.m15827a().m15492j() != OkHostnameVerifier.f15621a || !m15917a(address.m15482a())) {
            return false;
        }
        try {
            address.m15493k().m15546a(address.m15482a().m15654g(), m15921e().m15613c());
            return true;
        } catch (SSLPeerUnverifiedException e) {
            return false;
        }
    }

    /* JADX INFO: renamed from: a */
    public boolean m15917a(HttpUrl httpUrl) {
        if (httpUrl.m15655h() != this.f15331h.m15827a().m15482a().m15655h()) {
            return false;
        }
        if (httpUrl.m15654g().equals(this.f15331h.m15827a().m15482a().m15654g())) {
            return true;
        }
        return this.f15334k != null && OkHostnameVerifier.f15621a.m16226a(httpUrl.m15654g(), (X509Certificate) this.f15334k.m15613c().get(0));
    }

    /* JADX INFO: renamed from: a */
    public HttpCodec m15912a(OkHttpClient okHttpClient, StreamAllocation streamAllocation) throws SocketException {
        if (this.f15336m != null) {
            return new Http2Codec(okHttpClient, streamAllocation, this.f15336m);
        }
        this.f15333j.setSoTimeout(okHttpClient.m15708b());
        this.f15337n.mo15864a().mo16343a(okHttpClient.m15708b(), TimeUnit.MILLISECONDS);
        this.f15338o.mo16013a().mo16343a(okHttpClient.m15709c(), TimeUnit.MILLISECONDS);
        return new Http1Codec(okHttpClient, streamAllocation, this.f15337n, this.f15338o);
    }

    @Override // okhttp3.Connection
    /* JADX INFO: renamed from: a */
    public Route mo15554a() {
        return this.f15331h;
    }

    /* JADX INFO: renamed from: c */
    public void m15919c() {
        Util.m15844a(this.f15332i);
    }

    /* JADX INFO: renamed from: d */
    public Socket m15920d() {
        return this.f15333j;
    }

    /* JADX INFO: renamed from: a */
    public boolean m15918a(boolean z) {
        if (this.f15333j.isClosed() || this.f15333j.isInputShutdown() || this.f15333j.isOutputShutdown()) {
            return false;
        }
        if (this.f15336m != null) {
            return !this.f15336m.m16070d();
        }
        if (!z) {
            return true;
        }
        try {
            int soTimeout = this.f15333j.getSoTimeout();
            try {
                this.f15333j.setSoTimeout(1);
                if (this.f15337n.mo16283f()) {
                    this.f15333j.setSoTimeout(soTimeout);
                    return false;
                }
                this.f15333j.setSoTimeout(soTimeout);
                return true;
            } catch (Throwable th) {
                this.f15333j.setSoTimeout(soTimeout);
                throw th;
            }
        } catch (SocketTimeoutException e) {
            return true;
        } catch (IOException e2) {
            return false;
        }
    }

    @Override // okhttp3.internal.http2.Http2Connection.Listener
    /* JADX INFO: renamed from: a */
    public void mo15915a(Http2Stream http2Stream) throws IOException {
        http2Stream.m16106a(ErrorCode.REFUSED_STREAM);
    }

    @Override // okhttp3.internal.http2.Http2Connection.Listener
    /* JADX INFO: renamed from: a */
    public void mo15914a(Http2Connection http2Connection) {
        synchronized (this.f15330g) {
            this.f15327c = http2Connection.m16049a();
        }
    }

    /* JADX INFO: renamed from: e */
    public Handshake m15921e() {
        return this.f15334k;
    }

    /* JADX INFO: renamed from: f */
    public boolean m15922f() {
        return this.f15336m != null;
    }

    @Override // okhttp3.Connection
    /* JADX INFO: renamed from: b */
    public Protocol mo15555b() {
        return this.f15335l;
    }

    public String toString() {
        return "Connection{" + this.f15331h.m15827a().m15482a().m15654g() + ":" + this.f15331h.m15827a().m15482a().m15655h() + ", proxy=" + this.f15331h.m15828b() + " hostAddress=" + this.f15331h.m15829c() + " cipherSuite=" + (this.f15334k != null ? this.f15334k.m15612b() : "none") + " protocol=" + this.f15335l + '}';
    }
}
