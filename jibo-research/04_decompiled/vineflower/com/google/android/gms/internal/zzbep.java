package com.google.android.gms.internal;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public final class zzbep {
   private static int a(byte[] var0, int var1) {
      return var0[var1] & 0xFF | (var0[var1 + 1] & 0xFF) << 8 | (var0[var1 + 2] & 0xFF) << 16 | (var0[var1 + 3] & 0xFF) << 24;
   }

   private static long a(long var0, long var2, long var4) {
      var0 = (var0 ^ var2) * var4;
      var0 = (var0 ^ var0 >>> 47 ^ var2) * var4;
      return (var0 ^ var0 >>> 47) * var4;
   }

   public static long a(byte[] var0) {
      int var4 = var0.length;
      if (var4 >= 0 && var4 <= var0.length) {
         long var17;
         if (var4 <= 32) {
            if (var4 <= 16) {
               if (var4 >= 8) {
                  long var7 = -7286425919675154353L + (var4 << 1);
                  long var9 = -7286425919675154353L + b(var0, 0);
                  var17 = b(var0, var4 + 0 - 8);
                  var17 = a(Long.rotateRight(var17, 37) * var7 + var9, (Long.rotateRight(var9, 25) + var17) * var7, var7);
               } else if (var4 >= 4) {
                  var17 = var4 << 1;
                  var17 = a(((a(var0, 0) & 4294967295L) << 3) + var4, a(var0, var4 + 0 - 4) & 4294967295L, -7286425919675154353L + var17);
               } else if (var4 > 0) {
                  byte var1 = var0[0];
                  byte var3 = var0[(var4 >> 1) + 0];
                  byte var2 = var0[var4 - 1 + 0];
                  var17 = (var1 & 255) + ((var3 & 255) << 8);
                  var17 = (((var2 & 255) << 2) + var4) * -4348849565147123417L ^ var17 * -7286425919675154353L;
                  var17 = (var17 ^ var17 >>> 47) * -7286425919675154353L;
               } else {
                  var17 = -7286425919675154353L;
               }
            } else {
               long var25 = -7286425919675154353L + (var4 << 1);
               long var23 = -5435081209227447693L * b(var0, 0);
               long var11 = b(var0, 8);
               var17 = b(var0, var4 + 0 - 8) * var25;
               var17 = a(
                  b(var0, var4 + 0 - 16) * -7286425919675154353L + Long.rotateRight(var23 + var11, 43) + Long.rotateRight(var17, 30),
                  var23 + Long.rotateRight(-7286425919675154353L + var11, 18) + var17,
                  var25
               );
            }
         } else if (var4 <= 64) {
            var17 = -7286425919675154353L + (var4 << 1);
            long var24 = b(var0, 0) * -7286425919675154353L;
            long var13 = b(var0, 8);
            long var28 = b(var0, var4 + 0 - 8) * var17;
            long var26 = b(var0, var4 + 0 - 16) * -7286425919675154353L + Long.rotateRight(var24 + var13, 43) + Long.rotateRight(var28, 30);
            var13 = a(var26, Long.rotateRight(var13 - 7286425919675154353L, 18) + var24 + var28, var17);
            var28 = b(var0, 16) * var17;
            long var15 = b(var0, 24);
            var26 = (var26 + b(var0, var4 + 0 - 32)) * var17;
            var17 = a(
               (b(var0, var4 + 0 - 24) + var13) * var17 + Long.rotateRight(var28 + var15, 43) + Long.rotateRight(var26, 30),
               Long.rotateRight(var15 + var24, 18) + var28 + var26,
               var17
            );
         } else {
            var17 = a(var0, 0, var4);
         }

         return var17;
      } else {
         throw new IndexOutOfBoundsException(new StringBuilder(67).append("Out of bound index with offput: 0 and length: ").append(var4).toString());
      }
   }

   private static long a(byte[] var0, int var1, int var2) {
      long[] var15 = new long[2];
      long[] var16 = new long[2];
      long var5 = b(var0, 0);
      int var3 = ((var2 - 1) / 64 << 6) + 0;
      int var4 = (var2 - 1 & 63) + var3 - 63;
      long var9 = 95310865018149119L + var5;
      long var7 = 2480279821605975764L;
      var5 = 1390051526045402406L;

      while (true) {
         var9 = Long.rotateRight(var9 + var7 + var15[0] + b(var0, var1 + 8), 37);
         long var11 = Long.rotateRight(var7 + var15[1] + b(var0, var1 + 48), 42);
         var7 = var9 * -5435081209227447693L ^ var16[1];
         var9 = var11 * -5435081209227447693L + var15[0] + b(var0, var1 + 40);
         var11 = Long.rotateRight(var5 + var16[0], 33) * -5435081209227447693L;
         a(var0, var1, var15[1] * -5435081209227447693L, var16[0] + var7, var15);
         a(var0, var1 + 32, var11 + var16[1], var9 + b(var0, var1 + 16), var16);
         var1 += 64;
         if (var1 == var3) {
            var5 = -5435081209227447693L + ((255L & var7) << 1);
            var16[0] += var2 - 1 & 63;
            var15[0] += var16[0];
            var16[0] += var15[0];
            long var13 = Long.rotateRight(var11 + var9 + var15[0] + b(var0, var4 + 8), 37);
            var11 = Long.rotateRight(var15[1] + var9 + b(var0, var4 + 48), 42);
            var9 = var13 * var5 ^ var16[1] * 9L;
            var11 = var11 * var5 + var15[0] * 9L + b(var0, var4 + 40);
            var7 = Long.rotateRight(var16[0] + var7, 33) * var5;
            a(var0, var4, var15[1] * var5, var9 + var16[0], var15);
            a(var0, var4 + 32, var7 + var16[1], var11 + b(var0, var4 + 16), var16);
            return a(a(var15[0], var16[0], var5) + (var11 >>> 47 ^ var11) * -4348849565147123417L + var9, a(var15[1], var16[1], var5) + var7, var5);
         }

         var5 = var7;
         var7 = var9;
         var9 = var11;
      }
   }

   private static void a(byte[] var0, int var1, long var2, long var4, long[] var6) {
      long var13 = b(var0, var1);
      long var11 = b(var0, var1 + 8);
      long var9 = b(var0, var1 + 16);
      long var7 = b(var0, var1 + 24);
      var2 = var13 + var2;
      var4 = Long.rotateRight(var4 + var2 + var7, 21);
      var11 = var11 + var2 + var9;
      var9 = Long.rotateRight(var11, 44);
      var6[0] = var11 + var7;
      var6[1] = var2 + var9 + var4;
   }

   private static long b(byte[] var0, int var1) {
      ByteBuffer var2 = ByteBuffer.wrap(var0, var1, 8);
      var2.order(ByteOrder.LITTLE_ENDIAN);
      return var2.getLong();
   }
}
