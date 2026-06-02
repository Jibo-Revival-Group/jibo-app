package com.crashlytics.android.core;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

final class ByteString {
   public static final ByteString a = new ByteString(new byte[0]);
   private final byte[] b;
   private volatile int c = 0;

   private ByteString(byte[] var1) {
      this.b = var1;
   }

   public static ByteString a(String var0) {
      try {
         return new ByteString(var0.getBytes("UTF-8"));
      } catch (UnsupportedEncodingException var1) {
         throw new RuntimeException("UTF-8 not supported.", var1);
      }
   }

   public static ByteString a(byte[] var0, int var1, int var2) {
      byte[] var3 = new byte[var2];
      System.arraycopy(var0, var1, var3, 0, var2);
      return new ByteString(var3);
   }

   public int a() {
      return this.b.length;
   }

   public void a(byte[] var1, int var2, int var3, int var4) {
      System.arraycopy(this.b, var2, var1, var3, var4);
   }

   public InputStream b() {
      return new ByteArrayInputStream(this.b);
   }

   @Override
   public boolean equals(Object var1) {
      boolean var5 = true;
      boolean var4;
      if (var1 == this) {
         var4 = var5;
      } else if (!(var1 instanceof ByteString)) {
         var4 = false;
      } else {
         ByteString var6 = (ByteString)var1;
         int var3 = this.b.length;
         if (var3 != var6.b.length) {
            var4 = false;
         } else {
            byte[] var7 = this.b;
            byte[] var8 = var6.b;
            int var2 = 0;

            while (true) {
               var4 = var5;
               if (var2 >= var3) {
                  break;
               }

               if (var7[var2] != var8[var2]) {
                  var4 = false;
                  break;
               }

               var2++;
            }
         }
      }

      return var4;
   }

   @Override
   public int hashCode() {
      int var1 = this.c;
      int var2 = var1;
      if (var1 == 0) {
         byte[] var5 = this.b;
         int var3 = this.b.length;
         var2 = 0;
         var1 = var3;

         while (var2 < var3) {
            byte var4 = var5[var2];
            var2++;
            var1 = var4 + var1 * 31;
         }

         var2 = var1;
         if (var1 == 0) {
            var2 = 1;
         }

         this.c = var2;
      }

      return var2;
   }
}
