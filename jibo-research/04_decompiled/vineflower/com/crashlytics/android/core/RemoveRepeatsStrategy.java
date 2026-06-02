package com.crashlytics.android.core;

import java.util.HashMap;

class RemoveRepeatsStrategy implements StackTraceTrimmingStrategy {
   private final int a;

   public RemoveRepeatsStrategy() {
      this(1);
   }

   public RemoveRepeatsStrategy(int var1) {
      this.a = var1;
   }

   private static boolean a(StackTraceElement[] var0, int var1, int var2) {
      boolean var6 = false;
      int var4 = var2 - var1;
      boolean var5;
      if (var2 + var4 > var0.length) {
         var5 = var6;
      } else {
         int var3 = 0;

         while (true) {
            if (var3 >= var4) {
               var5 = true;
               break;
            }

            var5 = var6;
            if (!var0[var1 + var3].equals(var0[var2 + var3])) {
               break;
            }

            var3++;
         }
      }

      return var5;
   }

   private static StackTraceElement[] a(StackTraceElement[] var0, int var1) {
      HashMap var11 = new HashMap();
      StackTraceElement[] var8 = new StackTraceElement[var0.length];
      int var2 = 0;
      int var4 = 1;
      int var6 = 0;

      while (var2 < var0.length) {
         StackTraceElement var10 = var0[var2];
         Integer var9 = (Integer)var11.get(var10);
         int var3;
         if (var9 != null && a(var0, var9, var2)) {
            int var7 = var2 - var9;
            int var13 = var4;
            var3 = var6;
            if (var4 < var1) {
               System.arraycopy(var0, var2, var8, var6, var7);
               var3 = var6 + var7;
               var13 = var4 + 1;
            }

            var6 = var7 - 1 + var2;
            var4 = var13;
         } else {
            var8[var6] = var0[var2];
            var3 = var6 + 1;
            int var5 = var2;
            var4 = 1;
            var6 = var5;
         }

         var11.put(var10, var2);
         var2 = var6 + 1;
         var6 = var3;
      }

      var0 = new StackTraceElement[var6];
      System.arraycopy(var8, 0, var0, 0, var0.length);
      return var0;
   }

   @Override
   public StackTraceElement[] a(StackTraceElement[] var1) {
      StackTraceElement[] var3 = a(var1, this.a);
      StackTraceElement[] var2 = var1;
      if (var3.length < var1.length) {
         var2 = var3;
      }

      return var2;
   }
}
