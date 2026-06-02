package okhttp3.internal.http;

import java.io.IOException;
import java.net.ProtocolException;
import okhttp3.Protocol;

public final class StatusLine {
   public final Protocol a;
   public final int b;
   public final String c;

   public StatusLine(Protocol var1, int var2, String var3) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
   }

   public static StatusLine a(String var0) throws IOException {
      byte var1 = 9;
      Protocol var3;
      if (var0.startsWith("HTTP/1.")) {
         if (var0.length() < 9 || var0.charAt(8) != ' ') {
            throw new ProtocolException("Unexpected status line: " + var0);
         }

         int var2 = var0.charAt(7) - '0';
         if (var2 == 0) {
            var3 = Protocol.HTTP_1_0;
         } else {
            if (var2 != 1) {
               throw new ProtocolException("Unexpected status line: " + var0);
            }

            var3 = Protocol.HTTP_1_1;
         }
      } else {
         if (!var0.startsWith("ICY ")) {
            throw new ProtocolException("Unexpected status line: " + var0);
         }

         var3 = Protocol.HTTP_1_0;
         var1 = 4;
      }

      if (var0.length() < var1 + 3) {
         throw new ProtocolException("Unexpected status line: " + var0);
      }

      int var6;
      try {
         var6 = Integer.parseInt(var0.substring(var1, var1 + 3));
      } catch (NumberFormatException var4) {
         throw new ProtocolException("Unexpected status line: " + var0);
      }

      if (var0.length() > var1 + 3) {
         if (var0.charAt(var1 + 3) != ' ') {
            throw new ProtocolException("Unexpected status line: " + var0);
         }

         var0 = var0.substring(var1 + 4);
      } else {
         var0 = "";
      }

      return new StatusLine(var3, var6, var0);
   }

   @Override
   public String toString() {
      StringBuilder var2 = new StringBuilder();
      String var1;
      if (this.a == Protocol.HTTP_1_0) {
         var1 = "HTTP/1.0";
      } else {
         var1 = "HTTP/1.1";
      }

      var2.append(var1);
      var2.append(' ').append(this.b);
      if (this.c != null) {
         var2.append(' ').append(this.c);
      }

      return var2.toString();
   }
}
