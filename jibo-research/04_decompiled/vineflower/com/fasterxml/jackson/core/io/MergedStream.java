package com.fasterxml.jackson.core.io;

import java.io.IOException;
import java.io.InputStream;

public final class MergedStream extends InputStream {
   private final IOContext a;
   private final InputStream b;
   private byte[] c;
   private int d;
   private final int e;

   public MergedStream(IOContext var1, InputStream var2, byte[] var3, int var4, int var5) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
      this.d = var4;
      this.e = var5;
   }

   private void a() {
      byte[] var1 = this.c;
      if (var1 != null) {
         this.c = null;
         if (this.a != null) {
            this.a.a(var1);
         }
      }
   }

   @Override
   public int available() throws IOException {
      int var1;
      if (this.c != null) {
         var1 = this.e - this.d;
      } else {
         var1 = this.b.available();
      }

      return var1;
   }

   @Override
   public void close() throws IOException {
      this.a();
      this.b.close();
   }

   @Override
   public void mark(int var1) {
      if (this.c == null) {
         this.b.mark(var1);
      }
   }

   @Override
   public boolean markSupported() {
      boolean var1;
      if (this.c == null && this.b.markSupported()) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   @Override
   public int read() throws IOException {
      int var4;
      if (this.c != null) {
         byte[] var3 = this.c;
         var4 = this.d++;
         int var2 = var3[var4] & 255;
         var4 = var2;
         if (this.d >= this.e) {
            this.a();
            var4 = var2;
         }
      } else {
         var4 = this.b.read();
      }

      return var4;
   }

   @Override
   public int read(byte[] var1) throws IOException {
      return this.read(var1, 0, var1.length);
   }

   @Override
   public int read(byte[] var1, int var2, int var3) throws IOException {
      if (this.c != null) {
         int var5 = this.e - this.d;
         int var4 = var3;
         if (var3 > var5) {
            var4 = var5;
         }

         System.arraycopy(this.c, this.d, var1, var2, var4);
         this.d += var4;
         var2 = var4;
         if (this.d >= this.e) {
            this.a();
            var2 = var4;
         }
      } else {
         var2 = this.b.read(var1, var2, var3);
      }

      return var2;
   }

   @Override
   public void reset() throws IOException {
      if (this.c == null) {
         this.b.reset();
      }
   }

   @Override
   public long skip(long var1) throws IOException {
      long var4;
      long var6;
      if (this.c != null) {
         int var3 = this.e - this.d;
         if (var3 > var1) {
            this.d += (int)var1;
            return var1;
         }

         this.a();
         var4 = var3 + 0L;
         var6 = var1 - var3;
      } else {
         var4 = 0L;
         var6 = var1;
      }

      var1 = var4;
      if (var6 > 0L) {
         var1 = var4 + this.b.skip(var6);
      }

      return var1;
   }
}
