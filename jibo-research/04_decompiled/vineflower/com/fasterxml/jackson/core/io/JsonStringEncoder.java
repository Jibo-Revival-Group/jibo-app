package com.fasterxml.jackson.core.io;

import com.fasterxml.jackson.core.util.ByteArrayBuilder;
import java.lang.ref.SoftReference;

public final class JsonStringEncoder {
   protected static final ThreadLocal<SoftReference<JsonStringEncoder>> a = new ThreadLocal<>();
   private static final char[] d = CharTypes.g();
   private static final byte[] e = CharTypes.h();
   protected ByteArrayBuilder b;
   protected final char[] c = new char[6];

   public JsonStringEncoder() {
      this.c[0] = '\\';
      this.c[2] = '0';
      this.c[3] = '0';
   }

   private static int a(int var0, int var1) {
      if (var1 >= 56320 && var1 <= 57343) {
         return 65536 + (var0 - 55296 << 10) + (var1 - 56320);
      } else {
         throw new IllegalArgumentException(
            "Broken surrogate pair: first char 0x" + Integer.toHexString(var0) + ", second 0x" + Integer.toHexString(var1) + "; illegal combination"
         );
      }
   }

   public static JsonStringEncoder a() {
      SoftReference var0 = a.get();
      JsonStringEncoder var2;
      if (var0 == null) {
         var2 = null;
      } else {
         var2 = (JsonStringEncoder)var0.get();
      }

      JsonStringEncoder var1 = var2;
      if (var2 == null) {
         var1 = new JsonStringEncoder();
         a.set(new SoftReference<>(var1));
      }

      return var1;
   }

   private static void a(int var0) {
      throw new IllegalArgumentException(UTF8Writer.c(var0));
   }

   public byte[] a(String var1) {
      ByteArrayBuilder var9 = this.b;
      ByteArrayBuilder var10 = var9;
      if (var9 == null) {
         var10 = new ByteArrayBuilder(null);
         this.b = var10;
      }

      int var8 = var1.length();
      byte[] var33 = var10.c();
      int var4 = var33.length;
      int var2 = 0;
      int var3 = 0;

      while (var3 < var8) {
         int var6 = var3 + 1;
         int var7 = var1.charAt(var3);
         int var5 = var4;
         var3 = var6;
         int var13 = var7;

         while (var13 <= 127) {
            var6 = var5;
            var7 = var2;
            if (var2 >= var5) {
               var33 = var10.d();
               var6 = var33.length;
               var7 = 0;
            }

            var2 = var7 + 1;
            var33[var7] = (byte)var13;
            if (var3 >= var8) {
               return this.b.b(var2);
            }

            var13 = var1.charAt(var3);
            var3++;
            var5 = var6;
         }

         if (var2 >= var5) {
            var33 = var10.d();
            var2 = var33.length;
            var5 = 0;
         } else {
            var6 = var2;
            var2 = var5;
            var5 = var6;
         }

         if (var13 < 2048) {
            var6 = var5 + 1;
            var33[var5] = (byte)(var13 >> 6 | 192);
            var5 = var13;
            var13 = var6;
         } else if (var13 >= 55296 && var13 <= 57343) {
            if (var13 > 56319) {
               a(var13);
            }

            if (var3 >= var8) {
               a(var13);
            }

            var6 = a(var13, var1.charAt(var3));
            if (var6 > 1114111) {
               a(var6);
            }

            var7 = var5 + 1;
            var33[var5] = (byte)(var6 >> 18 | 240);
            var13 = var2;
            var5 = var7;
            if (var7 >= var2) {
               var33 = var10.d();
               var13 = var33.length;
               var5 = 0;
            }

            var2 = var5 + 1;
            var33[var5] = (byte)(var6 >> 12 & 63 | 128);
            if (var2 >= var13) {
               var33 = var10.d();
               var2 = var33.length;
               var5 = 0;
            } else {
               var5 = var2;
               var2 = var13;
            }

            var33[var5] = (byte)(var6 >> 6 & 63 | 128);
            var13 = var5 + 1;
            var5 = var6;
            var3++;
         } else {
            var7 = var5 + 1;
            var33[var5] = (byte)(var13 >> 12 | 224);
            var5 = var2;
            var6 = var7;
            if (var7 >= var2) {
               var33 = var10.d();
               var5 = var33.length;
               var6 = 0;
            }

            var33[var6] = (byte)(var13 >> 6 & 63 | 128);
            var7 = var6 + 1;
            char var25 = (char)var13;
            var2 = var5;
            var13 = var7;
            var5 = var25;
         }

         var6 = var2;
         var7 = var13;
         if (var13 >= var2) {
            var33 = var10.d();
            var6 = var33.length;
            var7 = 0;
         }

         var33[var7] = (byte)(var5 & 63 | 128);
         var4 = var6;
         var2 = var7 + 1;
      }

      return this.b.b(var2);
   }
}
