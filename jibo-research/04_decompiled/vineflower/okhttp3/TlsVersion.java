package okhttp3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public enum TlsVersion {
   SSL_3_0("SSLv3"),
   TLS_1_0("TLSv1"),
   TLS_1_1("TLSv1.1"),
   TLS_1_2("TLSv1.2"),
   TLS_1_3("TLSv1.3");

   private static final TlsVersion[] $VALUES = new TlsVersion[]{
      TlsVersion.TLS_1_3, TlsVersion.TLS_1_2, TlsVersion.TLS_1_1, TlsVersion.TLS_1_0, TlsVersion.SSL_3_0
   };
   final String javaName;

   TlsVersion(String var3) {
      this.javaName = var3;
   }

   public static TlsVersion forJavaName(String var0) {
      TlsVersion var2;
      switch (var0) {
         case "TLSv1.3":
            var2 = TLS_1_3;
            break;
         case "TLSv1.2":
            var2 = TLS_1_2;
            break;
         case "TLSv1.1":
            var2 = TLS_1_1;
            break;
         case "TLSv1":
            var2 = TLS_1_0;
            break;
         case "SSLv3":
            var2 = SSL_3_0;
            break;
         default:
            throw new IllegalArgumentException("Unexpected TLS version: " + var0);
      }

      return var2;
   }

   static List<TlsVersion> forJavaNames(String... var0) {
      ArrayList var3 = new ArrayList(var0.length);
      int var2 = var0.length;

      for (int var1 = 0; var1 < var2; var1++) {
         var3.add(forJavaName(var0[var1]));
      }

      return Collections.unmodifiableList(var3);
   }

   public String javaName() {
      return this.javaName;
   }
}
