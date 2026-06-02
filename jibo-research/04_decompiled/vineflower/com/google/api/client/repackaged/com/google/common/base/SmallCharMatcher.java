package com.google.api.client.repackaged.com.google.common.base;

import com.google.api.client.repackaged.com.google.common.annotations.GwtIncompatible;
import com.google.api.client.repackaged.com.google.common.annotations.VisibleForTesting;
import java.util.BitSet;

@GwtIncompatible("no precomputation is done in GWT")
final class SmallCharMatcher extends CharMatcher.FastMatcher {
   private static final int C1 = -862048943;
   private static final int C2 = 461845907;
   private static final double DESIRED_LOAD_FACTOR = 0.5;
   static final int MAX_SIZE = 1023;
   private final boolean containsZero;
   private final long filter;
   private final char[] table;

   private SmallCharMatcher(char[] var1, long var2, boolean var4, String var5) {
      super(var5);
      this.table = var1;
      this.filter = var2;
      this.containsZero = var4;
   }

   private boolean checkFilter(int var1) {
      boolean var2;
      if (1L == (this.filter >> var1 & 1L)) {
         var2 = true;
      } else {
         var2 = false;
      }

      return var2;
   }

   @VisibleForTesting
   static int chooseTableSize(int var0) {
      int var2;
      if (var0 == 1) {
         var2 = 2;
      } else {
         int var1 = Integer.highestOneBit(var0 - 1) << 1;

         while (true) {
            var2 = var1;
            if (!(var1 * 0.5 < var0)) {
               break;
            }

            var1 <<= 1;
         }
      }

      return var2;
   }

   static CharMatcher from(BitSet var0, String var1) {
      long var6 = 0L;
      int var2 = var0.cardinality();
      boolean var5 = var0.get(0);
      char[] var8 = new char[chooseTableSize(var2)];
      int var4 = var8.length - 1;

      for (int var9 = var0.nextSetBit(0); var9 != -1; var9 = var0.nextSetBit(var9 + 1)) {
         var6 |= 1L << var9;
         int var3 = smear(var9) & var4;

         while (var8[var3] != 0) {
            var3 = var3 + 1 & var4;
         }

         var8[var3] = (char)var9;
      }

      return new SmallCharMatcher(var8, var6, var5, var1);
   }

   static int smear(int var0) {
      return 461845907 * Integer.rotateLeft(-862048943 * var0, 15);
   }

   @Override
   public boolean matches(char var1) {
      boolean var6;
      if (var1 == 0) {
         var6 = this.containsZero;
      } else if (!this.checkFilter(var1)) {
         var6 = false;
      } else {
         int var5 = this.table.length - 1;
         int var3 = smear(var1) & var5;
         int var2 = var3;

         while (this.table[var2] != 0) {
            if (this.table[var2] == var1) {
               var6 = true;
               return var6;
            }

            int var4 = var2 + 1 & var5;
            var2 = var4;
            if (var4 == var3) {
               var6 = false;
               return var6;
            }
         }

         var6 = false;
      }

      return var6;
   }

   @Override
   void setBits(BitSet var1) {
      int var2 = 0;
      if (this.containsZero) {
         var1.set(0);
      }

      char[] var5 = this.table;

      for (int var3 = var5.length; var2 < var3; var2++) {
         char var4 = var5[var2];
         if (var4 != 0) {
            var1.set(var4);
         }
      }
   }
}
