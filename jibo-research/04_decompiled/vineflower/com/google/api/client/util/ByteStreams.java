package com.google.api.client.util;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public final class ByteStreams {
   private static final int BUF_SIZE = 4096;

   private ByteStreams() {
   }

   public static long copy(InputStream var0, OutputStream var1) throws IOException {
      Preconditions.checkNotNull(var0);
      Preconditions.checkNotNull(var1);
      byte[] var5 = new byte[4096];
      long var3 = 0L;

      while (true) {
         int var2 = var0.read(var5);
         if (var2 == -1) {
            return var3;
         }

         var1.write(var5, 0, var2);
         var3 += var2;
      }
   }

   public static InputStream limit(InputStream var0, long var1) {
      return new ByteStreams.LimitedInputStream(var0, var1);
   }

   public static int read(InputStream var0, byte[] var1, int var2, int var3) throws IOException {
      Preconditions.checkNotNull(var0);
      Preconditions.checkNotNull(var1);
      if (var3 < 0) {
         throw new IndexOutOfBoundsException("len is negative");
      }

      int var4 = 0;

      while (var4 < var3) {
         int var5 = var0.read(var1, var2 + var4, var3 - var4);
         if (var5 == -1) {
            break;
         }

         var4 += var5;
      }

      return var4;
   }

   private static final class LimitedInputStream extends FilterInputStream {
      private long left;
      private long mark = -1L;

      LimitedInputStream(InputStream var1, long var2) {
         super(var1);
         Preconditions.checkNotNull(var1);
         boolean var4;
         if (var2 >= 0L) {
            var4 = true;
         } else {
            var4 = false;
         }

         Preconditions.checkArgument(var4, "limit must be non-negative");
         this.left = var2;
      }

      @Override
      public int available() throws IOException {
         return (int)Math.min(this.in.available(), this.left);
      }

      @Override
      public void mark(int var1) {
         synchronized (this) {
            this.in.mark(var1);
            this.mark = this.left;
         }
      }

      @Override
      public int read() throws IOException {
         int var1 = -1;
         if (this.left != 0L) {
            var1 = this.in.read();
            if (var1 != -1) {
               this.left--;
            }
         }

         return var1;
      }

      @Override
      public int read(byte[] var1, int var2, int var3) throws IOException {
         byte var4 = -1;
         if (this.left == 0L) {
            var2 = var4;
         } else {
            var3 = (int)Math.min(var3, this.left);
            var2 = this.in.read(var1, var2, var3);
            if (var2 != -1) {
               this.left -= var2;
            }
         }

         return var2;
      }

      @Override
      public void reset() throws IOException {
         synchronized (this) {
            if (!this.in.markSupported()) {
               IOException var3 = new IOException("Mark not supported");
               throw var3;
            }

            if (this.mark == -1L) {
               IOException var1 = new IOException("Mark not set");
               throw var1;
            }

            this.in.reset();
            this.left = this.mark;
         }
      }

      @Override
      public long skip(long var1) throws IOException {
         var1 = Math.min(var1, this.left);
         var1 = this.in.skip(var1);
         this.left -= var1;
         return var1;
      }
   }
}
