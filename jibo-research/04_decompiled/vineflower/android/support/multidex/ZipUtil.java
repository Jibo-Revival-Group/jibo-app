package android.support.multidex;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.zip.CRC32;
import java.util.zip.ZipException;

final class ZipUtil {
   static long a(File var0) throws IOException {
      RandomAccessFile var6 = new RandomAccessFile(var0, "r");

      try {
         return a(var6, a(var6));
      } finally {
         var6.close();
      }
   }

   static long a(RandomAccessFile var0, ZipUtil.CentralDirectory var1) throws IOException {
      CRC32 var5 = new CRC32();
      long var3 = var1.b;
      var0.seek(var1.a);
      int var2 = (int)Math.min(16384L, var3);
      byte[] var6 = new byte[16384];

      for (int var7 = var0.read(var6, 0, var2); var7 != -1; var7 = var0.read(var6, 0, (int)Math.min(16384L, var3))) {
         var5.update(var6, 0, var7);
         var3 -= var7;
         if (var3 == 0L) {
            break;
         }
      }

      return var5.getValue();
   }

   static ZipUtil.CentralDirectory a(RandomAccessFile var0) throws IOException, ZipException {
      long var6 = 0L;
      long var4 = var0.length() - 22L;
      if (var4 < 0L) {
         throw new ZipException("File too short to be a zip file: " + var0.length());
      }

      long var2 = var4 - 65536L;
      if (var2 < 0L) {
         var2 = var6;
      }

      int var1 = Integer.reverseBytes(101010256);

      do {
         var0.seek(var4);
         if (var0.readInt() == var1) {
            var0.skipBytes(2);
            var0.skipBytes(2);
            var0.skipBytes(2);
            var0.skipBytes(2);
            ZipUtil.CentralDirectory var8 = new ZipUtil.CentralDirectory();
            var8.b = Integer.reverseBytes(var0.readInt()) & 4294967295L;
            var8.a = Integer.reverseBytes(var0.readInt()) & 4294967295L;
            return var8;
         }

         var6 = var4 - 1L;
         var4 = var6;
      } while (var6 >= var2);

      throw new ZipException("End Of Central Directory signature not found");
   }

   static class CentralDirectory {
      long a;
      long b;
   }
}
