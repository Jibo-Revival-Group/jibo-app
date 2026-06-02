package com.bumptech.glide.util;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class MarkEnforcingInputStream extends FilterInputStream {
   private int a = Integer.MIN_VALUE;

   public MarkEnforcingInputStream(InputStream var1) {
      super(var1);
   }

   private long a(long var1) {
      long var3;
      if (this.a == 0) {
         var3 = -1L;
      } else {
         var3 = var1;
         if (this.a != Integer.MIN_VALUE) {
            var3 = var1;
            if (var1 > this.a) {
               var3 = this.a;
            }
         }
      }

      return var3;
   }

   private void b(long var1) {
      if (this.a != Integer.MIN_VALUE && var1 != -1L) {
         this.a = (int)(this.a - var1);
      }
   }

   @Override
   public int available() throws IOException {
      int var1;
      if (this.a == Integer.MIN_VALUE) {
         var1 = super.available();
      } else {
         var1 = Math.min(this.a, super.available());
      }

      return var1;
   }

   @Override
   public void mark(int var1) {
      super.mark(var1);
      this.a = var1;
   }

   @Override
   public int read() throws IOException {
      int var1;
      if (this.a(1L) == -1L) {
         var1 = -1;
      } else {
         var1 = super.read();
         this.b(1L);
      }

      return var1;
   }

   @Override
   public int read(byte[] var1, int var2, int var3) throws IOException {
      byte var4 = -1;
      var3 = (int)this.a(var3);
      if (var3 == -1) {
         var2 = var4;
      } else {
         var2 = super.read(var1, var2, var3);
         this.b(var2);
      }

      return var2;
   }

   @Override
   public void reset() throws IOException {
      super.reset();
      this.a = Integer.MIN_VALUE;
   }

   @Override
   public long skip(long var1) throws IOException {
      long var3 = -1L;
      var1 = this.a(var1);
      if (var1 == -1L) {
         var1 = var3;
      } else {
         var1 = super.skip(var1);
         this.b(var1);
      }

      return var1;
   }
}
