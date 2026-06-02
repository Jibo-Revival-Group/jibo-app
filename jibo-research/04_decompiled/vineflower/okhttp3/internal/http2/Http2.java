package okhttp3.internal.http2;

import java.io.IOException;
import okhttp3.internal.Util;
import okio.ByteString;

public final class Http2 {
   static final ByteString a = ByteString.a("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");
   static final String[] b = new String[64];
   static final String[] c = new String[256];
   private static final String[] d = new String[]{
      "DATA", "HEADERS", "PRIORITY", "RST_STREAM", "SETTINGS", "PUSH_PROMISE", "PING", "GOAWAY", "WINDOW_UPDATE", "CONTINUATION"
   };

   static {
      byte var2 = 0;

      for (int var0 = 0; var0 < c.length; var0++) {
         c[var0] = Util.a("%8s", new Object[]{Integer.toBinaryString(var0)}).replace(' ', '0');
      }

      b[0] = "";
      b[1] = "END_STREAM";
      int[] var7 = new int[]{1};
      b[8] = "PADDED";

      for (int var3 : var7) {
         b[var3 | 8] = b[var3] + "|PADDED";
      }

      b[4] = "END_HEADERS";
      b[32] = "PRIORITY";
      b[36] = "END_HEADERS|PRIORITY";
      int[] var8 = new int[]{4, 32, 36};
      int var13 = var8.length;
      int var10 = 0;

      while (true) {
         int var11 = var2;
         if (var10 >= var13) {
            for (; var11 < b.length; var11++) {
               if (b[var11] == null) {
                  b[var11] = c[var11];
               }
            }

            return;
         }

         int var4 = var8[var10];

         for (int var6 : var7) {
            b[var6 | var4] = b[var6] + '|' + b[var4];
            b[var6 | var4 | 8] = b[var6] + '|' + b[var4] + "|PADDED";
         }

         var10++;
      }
   }

   private Http2() {
   }

   static IllegalArgumentException a(String var0, Object... var1) {
      throw new IllegalArgumentException(Util.a(var0, var1));
   }

   static String a(byte var0, byte var1) {
      String var2;
      if (var1 == 0) {
         var2 = "";
      } else {
         switch (var0) {
            case 2:
            case 3:
            case 7:
            case 8:
               var2 = c[var1];
               break;
            case 4:
            case 6:
               if (var1 == 1) {
                  var2 = "ACK";
               } else {
                  var2 = c[var1];
               }
               break;
            case 5:
            default:
               String var3;
               if (var1 < b.length) {
                  var3 = b[var1];
               } else {
                  var3 = c[var1];
               }

               if (var0 == 5 && (var1 & 4) != 0) {
                  var2 = var3.replace("HEADERS", "PUSH_PROMISE");
               } else {
                  var2 = var3;
                  if (var0 == 0) {
                     var2 = var3;
                     if ((var1 & 32) != 0) {
                        var2 = var3.replace("PRIORITY", "COMPRESSED");
                     }
                  }
               }
         }
      }

      return var2;
   }

   static String a(boolean var0, int var1, int var2, byte var3, byte var4) {
      String var5;
      if (var3 < d.length) {
         var5 = d[var3];
      } else {
         var5 = Util.a("0x%02x", new Object[]{var3});
      }

      String var7 = a(var3, var4);
      String var6;
      if (var0) {
         var6 = "<<";
      } else {
         var6 = ">>";
      }

      return Util.a("%s 0x%08x %5d %-13s %s", var6, var1, var2, var5, var7);
   }

   static IOException b(String var0, Object... var1) throws IOException {
      throw new IOException(Util.a(var0, var1));
   }
}
