package okhttp3;

import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLSocket;
import okhttp3.internal.Util;

/* JADX INFO: loaded from: classes2.dex */
public final class ConnectionSpec {

    /* JADX INFO: renamed from: d */
    final boolean f15033d;

    /* JADX INFO: renamed from: e */
    final boolean f15034e;

    /* JADX INFO: renamed from: f */
    final String[] f15035f;

    /* JADX INFO: renamed from: g */
    final String[] f15036g;

    /* JADX INFO: renamed from: h */
    private static final CipherSuite[] f15032h = {CipherSuite.f14955aX, CipherSuite.f14986bb, CipherSuite.f14956aY, CipherSuite.f14987bc, CipherSuite.f14993bi, CipherSuite.f14992bh, CipherSuite.f14982ay, CipherSuite.f14940aI, CipherSuite.f14983az, CipherSuite.f14941aJ, CipherSuite.f14964ag, CipherSuite.f14965ah, CipherSuite.f14909E, CipherSuite.f14913I, CipherSuite.f15001i};

    /* JADX INFO: renamed from: a */
    public static final ConnectionSpec f15029a = new Builder(true).m15571a(f15032h).m15572a(TlsVersion.TLS_1_3, TlsVersion.TLS_1_2, TlsVersion.TLS_1_1, TlsVersion.TLS_1_0).m15569a(true).m15573a();

    /* JADX INFO: renamed from: b */
    public static final ConnectionSpec f15030b = new Builder(f15029a).m15572a(TlsVersion.TLS_1_0).m15569a(true).m15573a();

    /* JADX INFO: renamed from: c */
    public static final ConnectionSpec f15031c = new Builder(false).m15573a();

    ConnectionSpec(Builder builder) {
        this.f15033d = builder.f15037a;
        this.f15035f = builder.f15038b;
        this.f15036g = builder.f15039c;
        this.f15034e = builder.f15040d;
    }

    /* JADX INFO: renamed from: a */
    public boolean m15564a() {
        return this.f15033d;
    }

    /* JADX INFO: renamed from: b */
    public List<CipherSuite> m15566b() {
        if (this.f15035f != null) {
            return CipherSuite.m15549a(this.f15035f);
        }
        return null;
    }

    /* JADX INFO: renamed from: c */
    public List<TlsVersion> m15567c() {
        if (this.f15036g != null) {
            return TlsVersion.forJavaNames(this.f15036g);
        }
        return null;
    }

    /* JADX INFO: renamed from: d */
    public boolean m15568d() {
        return this.f15034e;
    }

    /* JADX INFO: renamed from: a */
    void m15563a(SSLSocket sSLSocket, boolean z) {
        ConnectionSpec connectionSpecM15562b = m15562b(sSLSocket, z);
        if (connectionSpecM15562b.f15036g != null) {
            sSLSocket.setEnabledProtocols(connectionSpecM15562b.f15036g);
        }
        if (connectionSpecM15562b.f15035f != null) {
            sSLSocket.setEnabledCipherSuites(connectionSpecM15562b.f15035f);
        }
    }

    /* JADX INFO: renamed from: b */
    private ConnectionSpec m15562b(SSLSocket sSLSocket, boolean z) {
        String[] enabledCipherSuites;
        String[] enabledProtocols;
        if (this.f15035f != null) {
            enabledCipherSuites = Util.m15848a(CipherSuite.f14931a, sSLSocket.getEnabledCipherSuites(), this.f15035f);
        } else {
            enabledCipherSuites = sSLSocket.getEnabledCipherSuites();
        }
        if (this.f15036g != null) {
            enabledProtocols = Util.m15848a(Util.f15243g, sSLSocket.getEnabledProtocols(), this.f15036g);
        } else {
            enabledProtocols = sSLSocket.getEnabledProtocols();
        }
        String[] supportedCipherSuites = sSLSocket.getSupportedCipherSuites();
        int iM15834a = Util.m15834a(CipherSuite.f14931a, supportedCipherSuites, "TLS_FALLBACK_SCSV");
        if (z && iM15834a != -1) {
            enabledCipherSuites = Util.m15849a(enabledCipherSuites, supportedCipherSuites[iM15834a]);
        }
        return new Builder(this).m15570a(enabledCipherSuites).m15574b(enabledProtocols).m15573a();
    }

    /* JADX INFO: renamed from: a */
    public boolean m15565a(SSLSocket sSLSocket) {
        if (!this.f15033d) {
            return false;
        }
        if (this.f15036g == null || Util.m15852b(Util.f15243g, this.f15036g, sSLSocket.getEnabledProtocols())) {
            return this.f15035f == null || Util.m15852b(CipherSuite.f14931a, this.f15035f, sSLSocket.getEnabledCipherSuites());
        }
        return false;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ConnectionSpec)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        ConnectionSpec connectionSpec = (ConnectionSpec) obj;
        if (this.f15033d == connectionSpec.f15033d) {
            return !this.f15033d || (Arrays.equals(this.f15035f, connectionSpec.f15035f) && Arrays.equals(this.f15036g, connectionSpec.f15036g) && this.f15034e == connectionSpec.f15034e);
        }
        return false;
    }

    public int hashCode() {
        if (!this.f15033d) {
            return 17;
        }
        return (this.f15034e ? 0 : 1) + ((((Arrays.hashCode(this.f15035f) + 527) * 31) + Arrays.hashCode(this.f15036g)) * 31);
    }

    public String toString() {
        if (!this.f15033d) {
            return "ConnectionSpec()";
        }
        return "ConnectionSpec(cipherSuites=" + (this.f15035f != null ? m15566b().toString() : "[all enabled]") + ", tlsVersions=" + (this.f15036g != null ? m15567c().toString() : "[all enabled]") + ", supportsTlsExtensions=" + this.f15034e + ")";
    }

    public static final class Builder {

        /* JADX INFO: renamed from: a */
        boolean f15037a;

        /* JADX INFO: renamed from: b */
        String[] f15038b;

        /* JADX INFO: renamed from: c */
        String[] f15039c;

        /* JADX INFO: renamed from: d */
        boolean f15040d;

        Builder(boolean z) {
            this.f15037a = z;
        }

        public Builder(ConnectionSpec connectionSpec) {
            this.f15037a = connectionSpec.f15033d;
            this.f15038b = connectionSpec.f15035f;
            this.f15039c = connectionSpec.f15036g;
            this.f15040d = connectionSpec.f15034e;
        }

        /* JADX INFO: renamed from: a */
        public Builder m15571a(CipherSuite... cipherSuiteArr) {
            if (!this.f15037a) {
                throw new IllegalStateException("no cipher suites for cleartext connections");
            }
            String[] strArr = new String[cipherSuiteArr.length];
            for (int i = 0; i < cipherSuiteArr.length; i++) {
                strArr[i] = cipherSuiteArr[i].f15019bj;
            }
            return m15570a(strArr);
        }

        /* JADX INFO: renamed from: a */
        public Builder m15570a(String... strArr) {
            if (!this.f15037a) {
                throw new IllegalStateException("no cipher suites for cleartext connections");
            }
            if (strArr.length == 0) {
                throw new IllegalArgumentException("At least one cipher suite is required");
            }
            this.f15038b = (String[]) strArr.clone();
            return this;
        }

        /* JADX INFO: renamed from: a */
        public Builder m15572a(TlsVersion... tlsVersionArr) {
            if (!this.f15037a) {
                throw new IllegalStateException("no TLS versions for cleartext connections");
            }
            String[] strArr = new String[tlsVersionArr.length];
            for (int i = 0; i < tlsVersionArr.length; i++) {
                strArr[i] = tlsVersionArr[i].javaName;
            }
            return m15574b(strArr);
        }

        /* JADX INFO: renamed from: b */
        public Builder m15574b(String... strArr) {
            if (!this.f15037a) {
                throw new IllegalStateException("no TLS versions for cleartext connections");
            }
            if (strArr.length == 0) {
                throw new IllegalArgumentException("At least one TLS version is required");
            }
            this.f15039c = (String[]) strArr.clone();
            return this;
        }

        /* JADX INFO: renamed from: a */
        public Builder m15569a(boolean z) {
            if (!this.f15037a) {
                throw new IllegalStateException("no TLS extensions for cleartext connections");
            }
            this.f15040d = z;
            return this;
        }

        /* JADX INFO: renamed from: a */
        public ConnectionSpec m15573a() {
            return new ConnectionSpec(this);
        }
    }
}
