package okhttp3;

import java.net.Proxy;
import java.net.ProxySelector;
import java.util.List;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import okhttp3.HttpUrl;
import okhttp3.internal.Util;
import org.apache.http.HttpHost;

/* JADX INFO: loaded from: classes2.dex */
public final class Address {

    /* JADX INFO: renamed from: a */
    final HttpUrl f14828a;

    /* JADX INFO: renamed from: b */
    final Dns f14829b;

    /* JADX INFO: renamed from: c */
    final SocketFactory f14830c;

    /* JADX INFO: renamed from: d */
    final Authenticator f14831d;

    /* JADX INFO: renamed from: e */
    final List<Protocol> f14832e;

    /* JADX INFO: renamed from: f */
    final List<ConnectionSpec> f14833f;

    /* JADX INFO: renamed from: g */
    final ProxySelector f14834g;

    /* JADX INFO: renamed from: h */
    final Proxy f14835h;

    /* JADX INFO: renamed from: i */
    final SSLSocketFactory f14836i;

    /* JADX INFO: renamed from: j */
    final HostnameVerifier f14837j;

    /* JADX INFO: renamed from: k */
    final CertificatePinner f14838k;

    public Address(String str, int i, Dns dns, SocketFactory socketFactory, SSLSocketFactory sSLSocketFactory, HostnameVerifier hostnameVerifier, CertificatePinner certificatePinner, Authenticator authenticator, Proxy proxy, List<Protocol> list, List<ConnectionSpec> list2, ProxySelector proxySelector) {
        this.f14828a = new HttpUrl.Builder().m15681a(sSLSocketFactory != null ? "https" : HttpHost.DEFAULT_SCHEME_NAME).m15688d(str).m15680a(i).m15687c();
        if (dns == null) {
            throw new NullPointerException("dns == null");
        }
        this.f14829b = dns;
        if (socketFactory == null) {
            throw new NullPointerException("socketFactory == null");
        }
        this.f14830c = socketFactory;
        if (authenticator == null) {
            throw new NullPointerException("proxyAuthenticator == null");
        }
        this.f14831d = authenticator;
        if (list == null) {
            throw new NullPointerException("protocols == null");
        }
        this.f14832e = Util.m15839a(list);
        if (list2 == null) {
            throw new NullPointerException("connectionSpecs == null");
        }
        this.f14833f = Util.m15839a(list2);
        if (proxySelector == null) {
            throw new NullPointerException("proxySelector == null");
        }
        this.f14834g = proxySelector;
        this.f14835h = proxy;
        this.f14836i = sSLSocketFactory;
        this.f14837j = hostnameVerifier;
        this.f14838k = certificatePinner;
    }

    /* JADX INFO: renamed from: a */
    public HttpUrl m15482a() {
        return this.f14828a;
    }

    /* JADX INFO: renamed from: b */
    public Dns m15484b() {
        return this.f14829b;
    }

    /* JADX INFO: renamed from: c */
    public SocketFactory m15485c() {
        return this.f14830c;
    }

    /* JADX INFO: renamed from: d */
    public Authenticator m15486d() {
        return this.f14831d;
    }

    /* JADX INFO: renamed from: e */
    public List<Protocol> m15487e() {
        return this.f14832e;
    }

    /* JADX INFO: renamed from: f */
    public List<ConnectionSpec> m15488f() {
        return this.f14833f;
    }

    /* JADX INFO: renamed from: g */
    public ProxySelector m15489g() {
        return this.f14834g;
    }

    /* JADX INFO: renamed from: h */
    public Proxy m15490h() {
        return this.f14835h;
    }

    /* JADX INFO: renamed from: i */
    public SSLSocketFactory m15491i() {
        return this.f14836i;
    }

    /* JADX INFO: renamed from: j */
    public HostnameVerifier m15492j() {
        return this.f14837j;
    }

    /* JADX INFO: renamed from: k */
    public CertificatePinner m15493k() {
        return this.f14838k;
    }

    public boolean equals(Object obj) {
        return (obj instanceof Address) && this.f14828a.equals(((Address) obj).f14828a) && m15483a((Address) obj);
    }

    public int hashCode() {
        return (((this.f14837j != null ? this.f14837j.hashCode() : 0) + (((this.f14836i != null ? this.f14836i.hashCode() : 0) + (((this.f14835h != null ? this.f14835h.hashCode() : 0) + ((((((((((((this.f14828a.hashCode() + 527) * 31) + this.f14829b.hashCode()) * 31) + this.f14831d.hashCode()) * 31) + this.f14832e.hashCode()) * 31) + this.f14833f.hashCode()) * 31) + this.f14834g.hashCode()) * 31)) * 31)) * 31)) * 31) + (this.f14838k != null ? this.f14838k.hashCode() : 0);
    }

    /* JADX INFO: renamed from: a */
    boolean m15483a(Address address) {
        return this.f14829b.equals(address.f14829b) && this.f14831d.equals(address.f14831d) && this.f14832e.equals(address.f14832e) && this.f14833f.equals(address.f14833f) && this.f14834g.equals(address.f14834g) && Util.m15846a(this.f14835h, address.f14835h) && Util.m15846a(this.f14836i, address.f14836i) && Util.m15846a(this.f14837j, address.f14837j) && Util.m15846a(this.f14838k, address.f14838k) && m15482a().m15655h() == address.m15482a().m15655h();
    }

    public String toString() {
        StringBuilder sbAppend = new StringBuilder().append("Address{").append(this.f14828a.m15654g()).append(":").append(this.f14828a.m15655h());
        if (this.f14835h != null) {
            sbAppend.append(", proxy=").append(this.f14835h);
        } else {
            sbAppend.append(", proxySelector=").append(this.f14834g);
        }
        sbAppend.append("}");
        return sbAppend.toString();
    }
}
