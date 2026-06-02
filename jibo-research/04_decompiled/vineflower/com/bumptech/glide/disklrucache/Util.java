package com.bumptech.glide.disklrucache;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

final class Util {
   static final Charset a = Charset.forName("US-ASCII");
   static final Charset b = Charset.forName("UTF-8");

   static void a(Closeable var0) {
      if (var0 != null) {
         try {
            var0.close();
         } catch (RuntimeException var1) {
            throw var1;
         } catch (Exception var2) {
         }
      }
   }

   static void a(File var0) throws IOException {
      File[] var3 = var0.listFiles();
      if (var3 == null) {
         throw new IOException("not a readable directory: " + var0);
      }

      for (File var4 : var3) {
         if (var4.isDirectory()) {
            a(var4);
         }

         if (!var4.delete()) {
            throw new IOException("failed to delete file: " + var4);
         }
      }
   }
}
