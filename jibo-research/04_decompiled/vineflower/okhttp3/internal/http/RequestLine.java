package okhttp3.internal.http;

import java.net.Proxy.Type;
import okhttp3.HttpUrl;
import okhttp3.Request;

public final class RequestLine {
   public static String a(HttpUrl var0) {
      String var1 = var0.i();
      String var2 = var0.l();
      String var3 = var1;
      if (var2 != null) {
         var3 = var1 + '?' + var2;
      }

      return var3;
   }

   public static String a(Request var0, Type var1) {
      StringBuilder var2 = new StringBuilder();
      var2.append(var0.b());
      var2.append(' ');
      if (b(var0, var1)) {
         var2.append(var0.a());
      } else {
         var2.append(a(var0.a()));
      }

      var2.append(" HTTP/1.1");
      return var2.toString();
   }

   private static boolean b(Request var0, Type var1) {
      boolean var2;
      if (!var0.g() && var1 == Type.HTTP) {
         var2 = true;
      } else {
         var2 = false;
      }

      return var2;
   }
}
