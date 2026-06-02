package okhttp3.internal.tls;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.cert.TrustAnchor;
import java.security.cert.X509Certificate;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import javax.net.ssl.X509TrustManager;
import javax.security.auth.x500.X500Principal;

/* JADX INFO: loaded from: classes2.dex */
public abstract class TrustRootIndex {
    /* JADX INFO: renamed from: a */
    public abstract X509Certificate mo16229a(X509Certificate x509Certificate);

    /* JADX INFO: renamed from: a */
    public static TrustRootIndex m16227a(X509TrustManager x509TrustManager) {
        try {
            Method declaredMethod = x509TrustManager.getClass().getDeclaredMethod("findTrustAnchorByIssuerAndSignature", X509Certificate.class);
            declaredMethod.setAccessible(true);
            return new AndroidTrustRootIndex(x509TrustManager, declaredMethod);
        } catch (NoSuchMethodException e) {
            return m16228a(x509TrustManager.getAcceptedIssuers());
        }
    }

    /* JADX INFO: renamed from: a */
    public static TrustRootIndex m16228a(X509Certificate... x509CertificateArr) {
        return new BasicTrustRootIndex(x509CertificateArr);
    }

    static final class AndroidTrustRootIndex extends TrustRootIndex {

        /* JADX INFO: renamed from: a */
        private final X509TrustManager f15622a;

        /* JADX INFO: renamed from: b */
        private final Method f15623b;

        AndroidTrustRootIndex(X509TrustManager x509TrustManager, Method method) {
            this.f15623b = method;
            this.f15622a = x509TrustManager;
        }

        @Override // okhttp3.internal.tls.TrustRootIndex
        /* JADX INFO: renamed from: a */
        public X509Certificate mo16229a(X509Certificate x509Certificate) {
            try {
                TrustAnchor trustAnchor = (TrustAnchor) this.f15623b.invoke(this.f15622a, x509Certificate);
                if (trustAnchor != null) {
                    return trustAnchor.getTrustedCert();
                }
                return null;
            } catch (IllegalAccessException e) {
                throw new AssertionError();
            } catch (InvocationTargetException e2) {
                return null;
            }
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof AndroidTrustRootIndex)) {
                return false;
            }
            AndroidTrustRootIndex androidTrustRootIndex = (AndroidTrustRootIndex) obj;
            return this.f15622a.equals(androidTrustRootIndex.f15622a) && this.f15623b.equals(androidTrustRootIndex.f15623b);
        }

        public int hashCode() {
            return this.f15622a.hashCode() + (this.f15623b.hashCode() * 31);
        }
    }

    static final class BasicTrustRootIndex extends TrustRootIndex {

        /* JADX INFO: renamed from: a */
        private final Map<X500Principal, Set<X509Certificate>> f15624a = new LinkedHashMap();

        BasicTrustRootIndex(X509Certificate... x509CertificateArr) {
            for (X509Certificate x509Certificate : x509CertificateArr) {
                X500Principal subjectX500Principal = x509Certificate.getSubjectX500Principal();
                Set<X509Certificate> linkedHashSet = this.f15624a.get(subjectX500Principal);
                if (linkedHashSet == null) {
                    linkedHashSet = new LinkedHashSet<>(1);
                    this.f15624a.put(subjectX500Principal, linkedHashSet);
                }
                linkedHashSet.add(x509Certificate);
            }
        }

        @Override // okhttp3.internal.tls.TrustRootIndex
        /* JADX INFO: renamed from: a */
        public X509Certificate mo16229a(X509Certificate x509Certificate) {
            Set<X509Certificate> set = this.f15624a.get(x509Certificate.getIssuerX500Principal());
            if (set == null) {
                return null;
            }
            for (X509Certificate x509Certificate2 : set) {
                try {
                    x509Certificate.verify(x509Certificate2.getPublicKey());
                    return x509Certificate2;
                } catch (Exception e) {
                }
            }
            return null;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            return (obj instanceof BasicTrustRootIndex) && ((BasicTrustRootIndex) obj).f15624a.equals(this.f15624a);
        }

        public int hashCode() {
            return this.f15624a.hashCode();
        }
    }
}
