package okhttp3.internal.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import okio.Okio;
import okio.Sink;
import okio.Source;

public interface FileSystem {
   FileSystem a = new FileSystem() {
      @Override
      public Source a(File var1) throws FileNotFoundException {
         return Okio.a(var1);
      }

      @Override
      public void a(File var1, File var2) throws IOException {
         this.d(var2);
         if (!var1.renameTo(var2)) {
            throw new IOException("failed to rename " + var1 + " to " + var2);
         }
      }

      @Override
      public Sink b(File var1) throws FileNotFoundException {
         Sink var2;
         try {
            var2 = Okio.b(var1);
         } catch (FileNotFoundException var3) {
            var1.getParentFile().mkdirs();
            return Okio.b(var1);
         }

         return var2;
      }

      @Override
      public Sink c(File var1) throws FileNotFoundException {
         Sink var2;
         try {
            var2 = Okio.c(var1);
         } catch (FileNotFoundException var3) {
            var1.getParentFile().mkdirs();
            return Okio.c(var1);
         }

         return var2;
      }

      @Override
      public void d(File var1) throws IOException {
         if (!var1.delete() && var1.exists()) {
            throw new IOException("failed to delete " + var1);
         }
      }

      @Override
      public boolean e(File var1) {
         return var1.exists();
      }

      @Override
      public long f(File var1) {
         return var1.length();
      }

      @Override
      public void g(File var1) throws IOException {
         File[] var4 = var1.listFiles();
         if (var4 == null) {
            throw new IOException("not a readable directory: " + var1);
         }

         for (File var5 : var4) {
            if (var5.isDirectory()) {
               this.g(var5);
            }

            if (!var5.delete()) {
               throw new IOException("failed to delete " + var5);
            }
         }
      }
   };

   Source a(File var1) throws FileNotFoundException;

   void a(File var1, File var2) throws IOException;

   Sink b(File var1) throws FileNotFoundException;

   Sink c(File var1) throws FileNotFoundException;

   void d(File var1) throws IOException;

   boolean e(File var1);

   long f(File var1);

   void g(File var1) throws IOException;
}
