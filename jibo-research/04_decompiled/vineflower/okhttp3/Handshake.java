package okhttp3;

import java.security.cert.Certificate;
import java.util.Collections;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import okhttp3.internal.Util;

public final class Handshake {
   private final TlsVersion a;
   private final CipherSuite b;
   private final List<Certificate> c;
   private final List<Certificate> d;

   private Handshake(TlsVersion var1, CipherSuite var2, List<Certificate> var3, List<Certificate> var4) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
      this.d = var4;
   }

   public static Handshake a(SSLSession var0) {
      String var1 = var0.getCipherSuite();
      if (var1 == null) {
         throw new IllegalStateException("cipherSuite == null");
      }

      CipherSuite var2 = CipherSuite.a(var1);
      var1 = var0.getProtocol();
      if (var1 == null) {
         throw new IllegalStateException("tlsVersion == null");
      }

      TlsVersion var3 = TlsVersion.forJavaName(var1);

      try {
         var8 = var0.getPeerCertificates();
      } catch (SSLPeerUnverifiedException var4) {
         var8 = null;
      }

      List var9;
      if (var8 != null) {
         var9 = Util.a(var8);
      } else {
         var9 = Collections.emptyList();
      }

      Certificate[] var5 = var0.getLocalCertificates();
      List var6;
      if (var5 != null) {
         var6 = Util.a(var5);
      } else {
         var6 = Collections.emptyList();
      }

      return new Handshake(var3, var2, var9, var6);
   }

   public static Handshake a(TlsVersion var0, CipherSuite var1, List<Certificate> var2, List<Certificate> var3) {
      if (var0 == null) {
         throw new NullPointerException("tlsVersion == null");
      } else if (var1 == null) {
         throw new NullPointerException("cipherSuite == null");
      } else {
         return new Handshake(var0, var1, Util.a(var2), Util.a(var3));
      }
   }

   public TlsVersion a() {
      return this.a;
   }

   public CipherSuite b() {
      return this.b;
   }

   public List<Certificate> c() {
      return this.c;
   }

   public List<Certificate> d() {
      return this.d;
   }

   @Override
   public boolean equals(Object var1) {
      boolean var3 = false;
      boolean var2;
      if (!(var1 instanceof Handshake)) {
         var2 = var3;
      } else {
         var1 = var1;
         var2 = var3;
         if (this.a.equals(var1.a)) {
            var2 = var3;
            if (this.b.equals(var1.b)) {
               var2 = var3;
               if (this.c.equals(var1.c)) {
                  var2 = var3;
                  if (this.d.equals(var1.d)) {
                     var2 = true;
                  }
               }
            }
         }
      }

      return var2;
   }

   @Override
   public int hashCode() {
      return (((this.a.hashCode() + 527) * 31 + this.b.hashCode()) * 31 + this.c.hashCode()) * 31 + this.d.hashCode();
   }
}
