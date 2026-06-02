package okhttp3;

import java.nio.charset.Charset;
import okio.ByteString;

public final class Credentials {
   public static String a(String var0, String var1) {
      return a(var0, var1, Charset.forName("ISO-8859-1"));
   }

   public static String a(String var0, String var1, Charset var2) {
      var0 = ByteString.a((var0 + ":" + var1).getBytes(var2)).b();
      return "Basic " + var0;
   }
}
