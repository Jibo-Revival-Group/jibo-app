package com.fasterxml.jackson.core.io;

import java.util.Arrays;

public final class CharTypes {
   static final int[] a;
   static final int[] b;
   static final int[] c;
   static final int[] d;
   static final int[] e;
   static final int[] f;
   static final int[] g;
   static final int[] h;
   private static final char[] i = "0123456789ABCDEF".toCharArray();
   private static final byte[] j;

   static {
      int var1 = i.length;
      j = new byte[var1];

      for (int var0 = 0; var0 < var1; var0++) {
         j[var0] = (byte)i[var0];
      }

      int[] var2 = new int[256];

      for (int var3 = 0; var3 < 32; var3++) {
         var2[var3] = -1;
      }

      var2[34] = 1;
      var2[92] = 1;
      a = var2;
      var2 = new int[a.length];
      System.arraycopy(a, 0, var2, 0, var2.length);

      for (int var9 = 128; var9 < 256; var9++) {
         byte var4;
         if ((var9 & 224) == 192) {
            var4 = 2;
         } else if ((var9 & 240) == 224) {
            var4 = 3;
         } else if ((var9 & 248) == 240) {
            var4 = 4;
         } else {
            var4 = -1;
         }

         var2[var9] = var4;
      }

      b = var2;
      var2 = new int[256];
      Arrays.fill(var2, -1);

      for (int var5 = 33; var5 < 256; var5++) {
         if (Character.isJavaIdentifierPart((char)var5)) {
            var2[var5] = 0;
         }
      }

      var2[64] = 0;
      var2[35] = 0;
      var2[42] = 0;
      var2[45] = 0;
      var2[43] = 0;
      c = var2;
      var2 = new int[256];
      System.arraycopy(c, 0, var2, 0, var2.length);
      Arrays.fill(var2, 128, 128, 0);
      d = var2;
      var2 = new int[256];
      System.arraycopy(b, 128, var2, 128, 128);
      Arrays.fill(var2, 0, 32, -1);
      var2[9] = 0;
      var2[10] = 10;
      var2[13] = 13;
      var2[42] = 42;
      e = var2;
      var2 = new int[256];
      System.arraycopy(b, 128, var2, 128, 128);
      Arrays.fill(var2, 0, 32, -1);
      var2[32] = 1;
      var2[9] = 1;
      var2[10] = 10;
      var2[13] = 13;
      var2[47] = 47;
      var2[35] = 35;
      f = var2;
      var2 = new int[128];

      for (int var6 = 0; var6 < 32; var6++) {
         var2[var6] = -1;
      }

      var2[34] = 34;
      var2[92] = 92;
      var2[8] = 98;
      var2[9] = 116;
      var2[12] = 102;
      var2[10] = 110;
      var2[13] = 114;
      g = var2;
      h = new int[128];
      Arrays.fill(h, -1);
      int var7 = 0;

      while (var7 < 10) {
         h[var7 + 48] = var7++;
      }

      for (int var8 = 0; var8 < 6; var8++) {
         h[var8 + 97] = var8 + 10;
         h[var8 + 65] = var8 + 10;
      }
   }

   public static int a(int var0) {
      if (var0 > 127) {
         var0 = -1;
      } else {
         var0 = h[var0];
      }

      return var0;
   }

   public static void a(StringBuilder var0, String var1) {
      int[] var7 = g;
      int var4 = var7.length;
      int var3 = 0;

      for (int var5 = var1.length(); var3 < var5; var3++) {
         char var2 = var1.charAt(var3);
         if (var2 < var4 && var7[var2] != 0) {
            var0.append('\\');
            int var6 = var7[var2];
            if (var6 < 0) {
               var0.append('u');
               var0.append('0');
               var0.append('0');
               var0.append(i[var2 >> 4]);
               var0.append(i[var2 & 15]);
            } else {
               var0.append((char)var6);
            }
         } else {
            var0.append(var2);
         }
      }
   }

   public static int[] a() {
      return a;
   }

   public static int[] b() {
      return b;
   }

   public static int[] c() {
      return c;
   }

   public static int[] d() {
      return d;
   }

   public static int[] e() {
      return e;
   }

   public static int[] f() {
      return g;
   }

   public static char[] g() {
      return (char[])i.clone();
   }

   public static byte[] h() {
      return (byte[])j.clone();
   }
}
