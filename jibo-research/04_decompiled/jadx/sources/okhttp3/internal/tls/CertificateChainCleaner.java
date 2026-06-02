package okhttp3.internal.tls;

import java.security.cert.Certificate;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.X509TrustManager;
import okhttp3.internal.platform.Platform;

/* JADX INFO: loaded from: classes2.dex */
public abstract class CertificateChainCleaner {
    /* JADX INFO: renamed from: a */
    public abstract List<Certificate> mo16186a(List<Certificate> list, String str) throws SSLPeerUnverifiedException;

    /* JADX INFO: renamed from: a */
    public static CertificateChainCleaner m16212a(X509TrustManager x509TrustManager) {
        return Platform.m16203b().mo16180a(x509TrustManager);
    }
}
