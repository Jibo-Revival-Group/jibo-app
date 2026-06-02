package okio;

import java.nio.charset.Charset;

final class Util {
   public static final Charset a = Charset.forName("UTF-8");

   public static int a(int var0) {
      return (0xFF000000 & var0) >>> 24 | (0xFF0000 & var0) >>> 8 | (0xFF00 & var0) << 8 | (var0 & 0xFF) << 24;
   }

   public static short a(short var0) {
      var0 = 65535 & var0;
      return (short)((var0 & 0xFF) << 8 | (0xFF00 & var0) >>> 8);
   }

   public static void a(long var0, long var2, long var4) {
      if ((var2 | var4) < 0L || var2 > var0 || var0 - var2 < var4) {
         throw new ArrayIndexOutOfBoundsException(String.format("size=%s offset=%s byteCount=%s", var0, var2, var4));
      }
   }

   public static void a(Throwable var0) {
      b(var0);
   }

   public static boolean a(byte[] var0, int var1, byte[] var2, int var3, int var4) {
      boolean var6 = false;
      int var5 = 0;

      while (true) {
         if (var5 >= var4) {
            var6 = true;
            break;
         }

         if (var0[var5 + var1] != var2[var5 + var3]) {
            break;
         }

         var5++;
      }

      return var6;
   }

   private static <T extends Throwable> void b(Throwable var0) throws T {
      throw var0;
   }
}
