package okhttp3;

import java.security.cert.Certificate;
import java.util.Collections;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import okhttp3.internal.Util;

/* JADX INFO: loaded from: classes2.dex */
public final class Handshake {

    /* JADX INFO: renamed from: a */
    private final TlsVersion f15070a;

    /* JADX INFO: renamed from: b */
    private final CipherSuite f15071b;

    /* JADX INFO: renamed from: c */
    private final List<Certificate> f15072c;

    /* JADX INFO: renamed from: d */
    private final List<Certificate> f15073d;

    private Handshake(TlsVersion tlsVersion, CipherSuite cipherSuite, List<Certificate> list, List<Certificate> list2) {
        this.f15070a = tlsVersion;
        this.f15071b = cipherSuite;
        this.f15072c = list;
        this.f15073d = list2;
    }

    /* JADX INFO: renamed from: a */
    public static Handshake m15609a(SSLSession sSLSession) {
        Certificate[] peerCertificates;
        List listEmptyList;
        List listEmptyList2;
        String cipherSuite = sSLSession.getCipherSuite();
        if (cipherSuite == null) {
            throw new IllegalStateException("cipherSuite == null");
        }
        CipherSuite cipherSuiteM15550a = CipherSuite.m15550a(cipherSuite);
        String protocol = sSLSession.getProtocol();
        if (protocol == null) {
            throw new IllegalStateException("tlsVersion == null");
        }
        TlsVersion tlsVersionForJavaName = TlsVersion.forJavaName(protocol);
        try {
            peerCertificates = sSLSession.getPeerCertificates();
        } catch (SSLPeerUnverifiedException e) {
            peerCertificates = null;
        }
        if (peerCertificates != null) {
            listEmptyList = Util.m15840a(peerCertificates);
        } else {
            listEmptyList = Collections.emptyList();
        }
        Certificate[] localCertificates = sSLSession.getLocalCertificates();
        if (localCertificates != null) {
            listEmptyList2 = Util.m15840a(localCertificates);
        } else {
            listEmptyList2 = Collections.emptyList();
        }
        return new Handshake(tlsVersionForJavaName, cipherSuiteM15550a, listEmptyList, listEmptyList2);
    }

    /* JADX INFO: renamed from: a */
    public static Handshake m15610a(TlsVersion tlsVersion, CipherSuite cipherSuite, List<Certificate> list, List<Certificate> list2) {
        if (tlsVersion == null) {
            throw new NullPointerException("tlsVersion == null");
        }
        if (cipherSuite == null) {
            throw new NullPointerException("cipherSuite == null");
        }
        return new Handshake(tlsVersion, cipherSuite, Util.m15839a(list), Util.m15839a(list2));
    }

    /* JADX INFO: renamed from: a */
    public TlsVersion m15611a() {
        return this.f15070a;
    }

    /* JADX INFO: renamed from: b */
    public CipherSuite m15612b() {
        return this.f15071b;
    }

    /* JADX INFO: renamed from: c */
    public List<Certificate> m15613c() {
        return this.f15072c;
    }

    /* JADX INFO: renamed from: d */
    public List<Certificate> m15614d() {
        return this.f15073d;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Handshake)) {
            return false;
        }
        Handshake handshake = (Handshake) obj;
        return this.f15070a.equals(handshake.f15070a) && this.f15071b.equals(handshake.f15071b) && this.f15072c.equals(handshake.f15072c) && this.f15073d.equals(handshake.f15073d);
    }

    public int hashCode() {
        return ((((((this.f15070a.hashCode() + 527) * 31) + this.f15071b.hashCode()) * 31) + this.f15072c.hashCode()) * 31) + this.f15073d.hashCode();
    }
}
