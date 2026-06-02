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

public final class CertificatePinner {
   public static final CertificatePinner a = new CertificatePinner.Builder().a();
   private final Set<CertificatePinner.Pin> b;
   private final CertificateChainCleaner c;

   CertificatePinner(Set<CertificatePinner.Pin> var1, CertificateChainCleaner var2) {
      this.b = var1;
      this.c = var2;
   }

   public static String a(Certificate var0) {
      if (!(var0 instanceof X509Certificate)) {
         throw new IllegalArgumentException("Certificate pinning requires X509 certificates");
      } else {
         return "sha256/" + b((X509Certificate)var0).b();
      }
   }

   static ByteString a(X509Certificate var0) {
      return ByteString.a(var0.getPublicKey().getEncoded()).d();
   }

   static ByteString b(X509Certificate var0) {
      return ByteString.a(var0.getPublicKey().getEncoded()).e();
   }

   List<CertificatePinner.Pin> a(String var1) {
      List var2 = Collections.emptyList();

      for (CertificatePinner.Pin var5 : this.b) {
         if (var5.a(var1)) {
            List var3 = var2;
            if (var2.isEmpty()) {
               var3 = new ArrayList();
            }

            var3.add(var5);
            var2 = var3;
         }
      }

      return var2;
   }

   CertificatePinner a(CertificateChainCleaner var1) {
      CertificatePinner var2;
      if (Util.a(this.c, var1)) {
         var2 = this;
      } else {
         var2 = new CertificatePinner(this.b, var1);
      }

      return var2;
   }

   public void a(String var1, List<Certificate> var2) throws SSLPeerUnverifiedException {
      List var10 = this.a(var1);
      if (!var10.isEmpty()) {
         List var9 = var2;
         if (this.c != null) {
            var9 = this.c.a(var2, var1);
         }

         int var5 = var9.size();

         for (int var3 = 0; var3 < var5; var3++) {
            X509Certificate var11 = (X509Certificate)var9.get(var3);
            int var6 = var10.size();
            int var4 = 0;
            ByteString var7 = null;
            ByteString var14 = null;

            while (var4 < var6) {
               CertificatePinner.Pin var12 = (CertificatePinner.Pin)var10.get(var4);
               if (var12.c.equals("sha256/")) {
                  ByteString var8 = var7;
                  if (var7 == null) {
                     var8 = b(var11);
                  }

                  if (var12.d.equals(var8)) {
                     return;
                  }

                  var7 = var8;
               } else {
                  if (!var12.c.equals("sha1/")) {
                     throw new AssertionError();
                  }

                  ByteString var21 = var14;
                  if (var14 == null) {
                     var21 = a(var11);
                  }

                  var14 = var21;
                  if (var12.d.equals(var21)) {
                     return;
                  }
               }

               var4++;
            }
         }

         StringBuilder var15 = new StringBuilder().append("Certificate pinning failure!").append("\n  Peer certificate chain:");
         int var18 = var9.size();

         for (int var16 = 0; var16 < var18; var16++) {
            X509Certificate var20 = (X509Certificate)var9.get(var16);
            var15.append("\n    ").append(a((Certificate)var20)).append(": ").append(var20.getSubjectDN().getName());
         }

         var15.append("\n  Pinned certificates for ").append(var1).append(":");
         var18 = var10.size();

         for (int var17 = 0; var17 < var18; var17++) {
            CertificatePinner.Pin var13 = (CertificatePinner.Pin)var10.get(var17);
            var15.append("\n    ").append(var13);
         }

         throw new SSLPeerUnverifiedException(var15.toString());
      }
   }

   @Override
   public boolean equals(Object var1) {
      boolean var2 = true;
      if (var1 != this) {
         if (var1 instanceof CertificatePinner && Util.a(this.c, ((CertificatePinner)var1).c) && this.b.equals(((CertificatePinner)var1).b)) {
            var2 = true;
         } else {
            var2 = false;
         }
      }

      return var2;
   }

   @Override
   public int hashCode() {
      int var1;
      if (this.c != null) {
         var1 = this.c.hashCode();
      } else {
         var1 = 0;
      }

      return var1 * 31 + this.b.hashCode();
   }

   public static final class Builder {
      private final List<CertificatePinner.Pin> a = new ArrayList<>();

      public CertificatePinner a() {
         return new CertificatePinner(new LinkedHashSet<>(this.a), null);
      }
   }

   static final class Pin {
      final String a;
      final String b;
      final String c;
      final ByteString d;

      boolean a(String var1) {
         boolean var2;
         if (this.a.startsWith("*.")) {
            var2 = var1.regionMatches(false, var1.indexOf(46) + 1, this.b, 0, this.b.length());
         } else {
            var2 = var1.equals(this.b);
         }

         return var2;
      }

      @Override
      public boolean equals(Object var1) {
         boolean var2;
         if (var1 instanceof CertificatePinner.Pin
            && this.a.equals(((CertificatePinner.Pin)var1).a)
            && this.c.equals(((CertificatePinner.Pin)var1).c)
            && this.d.equals(((CertificatePinner.Pin)var1).d)) {
            var2 = true;
         } else {
            var2 = false;
         }

         return var2;
      }

      @Override
      public int hashCode() {
         return ((this.a.hashCode() + 527) * 31 + this.c.hashCode()) * 31 + this.d.hashCode();
      }

      @Override
      public String toString() {
         return this.c + this.d.b();
      }
   }
}
