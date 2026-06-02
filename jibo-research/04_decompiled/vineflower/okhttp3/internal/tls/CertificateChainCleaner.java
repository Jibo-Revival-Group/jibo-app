package okhttp3.internal.tls;

import java.security.cert.Certificate;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.X509TrustManager;
import okhttp3.internal.platform.Platform;

public abstract class CertificateChainCleaner {
   public static CertificateChainCleaner a(X509TrustManager var0) {
      return Platform.b().a(var0);
   }

   public abstract List<Certificate> a(List<Certificate> var1, String var2) throws SSLPeerUnverifiedException;
}
