package com.bumptech.glide.util;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public final class ContentLengthInputStream extends FilterInputStream {
   private final long a;
   private int b;

   ContentLengthInputStream(InputStream var1, long var2) {
      super(var1);
      this.a = var2;
   }

   private int a(int var1) throws IOException {
      if (var1 >= 0) {
         this.b += var1;
      } else if (this.a - this.b > 0L) {
         throw new IOException("Failed to read all expected data, expected: " + this.a + ", but read: " + this.b);
      }

      return var1;
   }

   public static InputStream a(InputStream var0, long var1) {
      return new ContentLengthInputStream(var0, var1);
   }

   // $VF: Could not verify finally blocks. A semaphore variable has been added to preserve control flow.
   // $VF: Could not create synchronized statement, marking monitor enters and exits
   // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
   @Override
   public int available() throws IOException {
      synchronized (this){} // $VF: monitorenter 
      boolean var6 = false /* VF: Semaphore variable */;

      long var2;
      try {
         var6 = true;
         var2 = Math.max(this.a - this.b, this.in.available());
         var6 = false;
      } finally {
         if (var6) {
            // $VF: monitorexit
         }
      }

      int var1 = (int)var2;
      // $VF: monitorexit
      return var1;
   }

   @Override
   public int read() throws IOException {
      synchronized (this) {
         return this.a(super.read());
      }
   }

   @Override
   public int read(byte[] var1) throws IOException {
      return this.read(var1, 0, var1.length);
   }

   @Override
   public int read(byte[] var1, int var2, int var3) throws IOException {
      synchronized (this) {
         return this.a(super.read(var1, var2, var3));
      }
   }
}
