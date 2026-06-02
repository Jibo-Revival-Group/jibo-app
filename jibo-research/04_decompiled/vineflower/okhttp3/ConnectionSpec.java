package okhttp3;

import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLSocket;
import okhttp3.internal.Util;

public final class ConnectionSpec {
   public static final ConnectionSpec a = new ConnectionSpec.Builder(true)
      .a(ConnectionSpec.h)
      .a(TlsVersion.TLS_1_3, TlsVersion.TLS_1_2, TlsVersion.TLS_1_1, TlsVersion.TLS_1_0)
      .a(true)
      .a();
   public static final ConnectionSpec b = new ConnectionSpec.Builder(a).a(TlsVersion.TLS_1_0).a(true).a();
   public static final ConnectionSpec c = new ConnectionSpec.Builder(false).a();
   private static final CipherSuite[] h = new CipherSuite[]{
      CipherSuite.aX,
      CipherSuite.bb,
      CipherSuite.aY,
      CipherSuite.bc,
      CipherSuite.bi,
      CipherSuite.bh,
      CipherSuite.ay,
      CipherSuite.aI,
      CipherSuite.az,
      CipherSuite.aJ,
      CipherSuite.ag,
      CipherSuite.ah,
      CipherSuite.E,
      CipherSuite.I,
      CipherSuite.i
   };
   final boolean d;
   final boolean e;
   final String[] f;
   final String[] g;

   ConnectionSpec(ConnectionSpec.Builder var1) {
      this.d = var1.a;
      this.f = var1.b;
      this.g = var1.c;
      this.e = var1.d;
   }

   private ConnectionSpec b(SSLSocket var1, boolean var2) {
      String[] var4;
      if (this.f != null) {
         var4 = Util.a(CipherSuite.a, var1.getEnabledCipherSuites(), this.f);
      } else {
         var4 = var1.getEnabledCipherSuites();
      }

      String[] var5;
      if (this.g != null) {
         var5 = Util.a(Util.g, var1.getEnabledProtocols(), this.g);
      } else {
         var5 = var1.getEnabledProtocols();
      }

      String[] var6 = var1.getSupportedCipherSuites();
      int var3 = Util.a(CipherSuite.a, var6, "TLS_FALLBACK_SCSV");
      String[] var7 = var4;
      if (var2) {
         var7 = var4;
         if (var3 != -1) {
            var7 = Util.a(var4, var6[var3]);
         }
      }

      return new ConnectionSpec.Builder(this).a(var7).b(var5).a();
   }

   void a(SSLSocket var1, boolean var2) {
      ConnectionSpec var3 = this.b(var1, var2);
      if (var3.g != null) {
         var1.setEnabledProtocols(var3.g);
      }

      if (var3.f != null) {
         var1.setEnabledCipherSuites(var3.f);
      }
   }

   public boolean a() {
      return this.d;
   }

   public boolean a(SSLSocket var1) {
      boolean var3 = false;
      boolean var2;
      if (!this.d) {
         var2 = var3;
      } else {
         if (this.g != null) {
            var2 = var3;
            if (!Util.b(Util.g, this.g, var1.getEnabledProtocols())) {
               return var2;
            }
         }

         if (this.f != null) {
            var2 = var3;
            if (!Util.b(CipherSuite.a, this.f, var1.getEnabledCipherSuites())) {
               return var2;
            }
         }

         var2 = true;
      }

      return var2;
   }

   public List<CipherSuite> b() {
      List var1;
      if (this.f != null) {
         var1 = CipherSuite.a(this.f);
      } else {
         var1 = null;
      }

      return var1;
   }

   public List<TlsVersion> c() {
      List var1;
      if (this.g != null) {
         var1 = TlsVersion.forJavaNames(this.g);
      } else {
         var1 = null;
      }

      return var1;
   }

   public boolean d() {
      return this.e;
   }

   @Override
   public boolean equals(Object var1) {
      boolean var3 = false;
      boolean var2;
      if (!(var1 instanceof ConnectionSpec)) {
         var2 = var3;
      } else if (var1 == this) {
         var2 = true;
      } else {
         var1 = var1;
         var2 = var3;
         if (this.d == var1.d) {
            if (this.d) {
               var2 = var3;
               if (!Arrays.equals(this.f, var1.f)) {
                  return var2;
               }

               var2 = var3;
               if (!Arrays.equals(this.g, var1.g)) {
                  return var2;
               }

               var2 = var3;
               if (this.e != var1.e) {
                  return var2;
               }
            }

            var2 = true;
         }
      }

      return var2;
   }

   @Override
   public int hashCode() {
      int var1 = 17;
      if (this.d) {
         int var2 = Arrays.hashCode(this.f);
         int var3 = Arrays.hashCode(this.g);
         byte var4;
         if (this.e) {
            var4 = 0;
         } else {
            var4 = 1;
         }

         var1 = var4 + ((var2 + 527) * 31 + var3) * 31;
      }

      return var1;
   }

   @Override
   public String toString() {
      String var1;
      if (!this.d) {
         var1 = "ConnectionSpec()";
      } else {
         if (this.f != null) {
            var1 = this.b().toString();
         } else {
            var1 = "[all enabled]";
         }

         String var2;
         if (this.g != null) {
            var2 = this.c().toString();
         } else {
            var2 = "[all enabled]";
         }

         var1 = "ConnectionSpec(cipherSuites=" + var1 + ", tlsVersions=" + var2 + ", supportsTlsExtensions=" + this.e + ")";
      }

      return var1;
   }

   public static final class Builder {
      boolean a;
      String[] b;
      String[] c;
      boolean d;

      public Builder(ConnectionSpec var1) {
         this.a = var1.d;
         this.b = var1.f;
         this.c = var1.g;
         this.d = var1.e;
      }

      Builder(boolean var1) {
         this.a = var1;
      }

      public ConnectionSpec.Builder a(boolean var1) {
         if (!this.a) {
            throw new IllegalStateException("no TLS extensions for cleartext connections");
         }

         this.d = var1;
         return this;
      }

      public ConnectionSpec.Builder a(String... var1) {
         if (!this.a) {
            throw new IllegalStateException("no cipher suites for cleartext connections");
         }

         if (var1.length == 0) {
            throw new IllegalArgumentException("At least one cipher suite is required");
         }

         this.b = (String[])var1.clone();
         return this;
      }

      public ConnectionSpec.Builder a(CipherSuite... var1) {
         if (!this.a) {
            throw new IllegalStateException("no cipher suites for cleartext connections");
         }

         String[] var3 = new String[var1.length];

         for (int var2 = 0; var2 < var1.length; var2++) {
            var3[var2] = var1[var2].bj;
         }

         return this.a(var3);
      }

      public ConnectionSpec.Builder a(TlsVersion... var1) {
         if (!this.a) {
            throw new IllegalStateException("no TLS versions for cleartext connections");
         }

         String[] var3 = new String[var1.length];

         for (int var2 = 0; var2 < var1.length; var2++) {
            var3[var2] = var1[var2].javaName;
         }

         return this.b(var3);
      }

      public ConnectionSpec a() {
         return new ConnectionSpec(this);
      }

      public ConnectionSpec.Builder b(String... var1) {
         if (!this.a) {
            throw new IllegalStateException("no TLS versions for cleartext connections");
         }

         if (var1.length == 0) {
            throw new IllegalArgumentException("At least one TLS version is required");
         }

         this.c = (String[])var1.clone();
         return this;
      }
   }
}
