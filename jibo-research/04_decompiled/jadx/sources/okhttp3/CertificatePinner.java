package okhttp3;

import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.net.ssl.SSLPeerUnverifiedException;
import okhttp3.internal.Util;
import okhttp3.internal.tls.CertificateChainCleaner;
import okio.ByteString;

/* JADX INFO: loaded from: classes2.dex */
public final class CertificatePinner {

    /* JADX INFO: renamed from: a */
    public static final CertificatePinner f14897a = new Builder().m15547a();

    /* JADX INFO: renamed from: b */
    private final Set<Pin> f14898b;

    /* JADX INFO: renamed from: c */
    private final CertificateChainCleaner f14899c;

    CertificatePinner(Set<Pin> set, CertificateChainCleaner certificateChainCleaner) {
        this.f14898b = set;
        this.f14899c = certificateChainCleaner;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof CertificatePinner) && Util.m15846a(this.f14899c, ((CertificatePinner) obj).f14899c) && this.f14898b.equals(((CertificatePinner) obj).f14898b);
    }

    public int hashCode() {
        return ((this.f14899c != null ? this.f14899c.hashCode() : 0) * 31) + this.f14898b.hashCode();
    }

    /* JADX INFO: renamed from: a */
    public void m15546a(String str, List<Certificate> list) throws SSLPeerUnverifiedException {
        List<Pin> listM15544a = m15544a(str);
        if (!listM15544a.isEmpty()) {
            if (this.f14899c != null) {
                list = this.f14899c.mo16186a(list, str);
            }
            int size = list.size();
            for (int i = 0; i < size; i++) {
                X509Certificate x509Certificate = (X509Certificate) list.get(i);
                int size2 = listM15544a.size();
                int i2 = 0;
                ByteString byteStringM15543b = null;
                ByteString byteStringM15542a = null;
                while (i2 < size2) {
                    Pin pin = listM15544a.get(i2);
                    if (pin.f14903c.equals("sha256/")) {
                        if (byteStringM15543b == null) {
                            byteStringM15543b = m15543b(x509Certificate);
                        }
                        if (pin.f14904d.equals(byteStringM15543b)) {
                            return;
                        }
                    } else if (pin.f14903c.equals("sha1/")) {
                        if (byteStringM15542a == null) {
                            byteStringM15542a = m15542a(x509Certificate);
                        }
                        if (pin.f14904d.equals(byteStringM15542a)) {
                            return;
                        }
                    } else {
                        throw new AssertionError();
                    }
                    i2++;
                    byteStringM15542a = byteStringM15542a;
                    byteStringM15543b = byteStringM15543b;
                }
            }
            StringBuilder sbAppend = new StringBuilder().append("Certificate pinning failure!").append("\n  Peer certificate chain:");
            int size3 = list.size();
            for (int i3 = 0; i3 < size3; i3++) {
                X509Certificate x509Certificate2 = (X509Certificate) list.get(i3);
                sbAppend.append("\n    ").append(m15541a((Certificate) x509Certificate2)).append(": ").append(x509Certificate2.getSubjectDN().getName());
            }
            sbAppend.append("\n  Pinned certificates for ").append(str).append(":");
            int size4 = listM15544a.size();
            for (int i4 = 0; i4 < size4; i4++) {
                sbAppend.append("\n    ").append(listM15544a.get(i4));
            }
            throw new SSLPeerUnverifiedException(sbAppend.toString());
        }
    }

    /* JADX INFO: renamed from: a */
    List<Pin> m15544a(String str) {
        List<Pin> listEmptyList = Collections.emptyList();
        for (Pin pin : this.f14898b) {
            if (pin.m15548a(str)) {
                if (listEmptyList.isEmpty()) {
                    listEmptyList = new ArrayList<>();
                }
                listEmptyList.add(pin);
            }
        }
        return listEmptyList;
    }

    /* JADX INFO: renamed from: a */
    CertificatePinner m15545a(CertificateChainCleaner certificateChainCleaner) {
        return Util.m15846a(this.f14899c, certificateChainCleaner) ? this : new CertificatePinner(this.f14898b, certificateChainCleaner);
    }

    /* JADX INFO: renamed from: a */
    public static String m15541a(Certificate certificate) {
        if (!(certificate instanceof X509Certificate)) {
            throw new IllegalArgumentException("Certificate pinning requires X509 certificates");
        }
        return "sha256/" + m15543b((X509Certificate) certificate).mo16330b();
    }

    /* JADX INFO: renamed from: a */
    static ByteString m15542a(X509Certificate x509Certificate) {
        return ByteString.m16318a(x509Certificate.getPublicKey().getEncoded()).mo16332d();
    }

    /* JADX INFO: renamed from: b */
    static ByteString m15543b(X509Certificate x509Certificate) {
        return ByteString.m16318a(x509Certificate.getPublicKey().getEncoded()).mo16333e();
    }

    static final class Pin {

        /* JADX INFO: renamed from: a */
        final String f14901a;

        /* JADX INFO: renamed from: b */
        final String f14902b;

        /* JADX INFO: renamed from: c */
        final String f14903c;

        /* JADX INFO: renamed from: d */
        final ByteString f14904d;

        /* JADX INFO: renamed from: a */
        boolean m15548a(String str) {
            return this.f14901a.startsWith("*.") ? str.regionMatches(false, str.indexOf(46) + 1, this.f14902b, 0, this.f14902b.length()) : str.equals(this.f14902b);
        }

        public boolean equals(Object obj) {
            return (obj instanceof Pin) && this.f14901a.equals(((Pin) obj).f14901a) && this.f14903c.equals(((Pin) obj).f14903c) && this.f14904d.equals(((Pin) obj).f14904d);
        }

        public int hashCode() {
            return ((((this.f14901a.hashCode() + 527) * 31) + this.f14903c.hashCode()) * 31) + this.f14904d.hashCode();
        }

        public String toString() {
            return this.f14903c + this.f14904d.mo16330b();
        }
    }

    public static final class Builder {

        /* JADX INFO: renamed from: a */
        private final List<Pin> f14900a = new ArrayList();

        /* JADX INFO: renamed from: a */
        public CertificatePinner m15547a() {
            return new CertificatePinner(new LinkedHashSet(this.f14900a), null);
        }
    }
}
