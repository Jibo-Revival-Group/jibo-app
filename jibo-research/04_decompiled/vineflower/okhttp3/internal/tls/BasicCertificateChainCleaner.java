package okhttp3.internal.tls;

import java.security.GeneralSecurityException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;

public final class BasicCertificateChainCleaner extends CertificateChainCleaner {
   private final TrustRootIndex a;

   public BasicCertificateChainCleaner(TrustRootIndex var1) {
      this.a = var1;
   }

   private boolean a(X509Certificate var1, X509Certificate var2) {
      boolean var3 = false;
      if (var1.getIssuerDN().equals(var2.getSubjectDN())) {
         try {
            var1.verify(var2.getPublicKey());
         } catch (GeneralSecurityException var4) {
            return var3;
         }

         var3 = true;
      }

      return var3;
   }

   @Override
   public List<Certificate> a(List<Certificate> var1, String var2) throws SSLPeerUnverifiedException {
      ArrayDeque var9 = new ArrayDeque(var1);
      var1 = new ArrayList();
      var1.add(var9.removeFirst());
      int var4 = 0;
      boolean var3 = false;

      while (var4 < 9) {
         X509Certificate var5 = (X509Certificate)var1.get(var1.size() - 1);
         X509Certificate var6 = this.a.a(var5);
         if (var6 != null) {
            if (var1.size() > 1 || !var5.equals(var6)) {
               var1.add(var6);
            }

            if (this.a(var6, var6)) {
               return var1;
            }

            var3 = true;
         } else {
            Iterator var10 = var9.iterator();

            X509Certificate var7;
            do {
               if (!var10.hasNext()) {
                  if (!var3) {
                     throw new SSLPeerUnverifiedException("Failed to find a trusted cert that signed " + var5);
                  }

                  return var1;
               }

               var7 = (X509Certificate)var10.next();
            } while (!this.a(var5, var7));

            var10.remove();
            var1.add(var7);
         }

         var4++;
      }

      throw new SSLPeerUnverifiedException("Certificate chain too long: " + var1);
   }

   @Override
   public boolean equals(Object var1) {
      boolean var2 = true;
      if (var1 != this && (!(var1 instanceof BasicCertificateChainCleaner) || !((BasicCertificateChainCleaner)var1).a.equals(this.a))) {
         var2 = false;
      }

      return var2;
   }

   @Override
   public int hashCode() {
      return this.a.hashCode();
   }
}
