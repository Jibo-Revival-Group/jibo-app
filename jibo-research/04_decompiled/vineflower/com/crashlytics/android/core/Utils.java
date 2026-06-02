package com.crashlytics.android.core;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Comparator;

final class Utils {
   private static final FilenameFilter a = new FilenameFilter() {
      @Override
      public boolean accept(File var1, String var2) {
         return true;
      }
   };

   static int a(File var0, int var1, Comparator<File> var2) {
      return a(var0, a, var1, var2);
   }

   static int a(File var0, FilenameFilter var1, int var2, Comparator<File> var3) {
      int var6 = 0;
      File[] var8 = var0.listFiles(var1);
      if (var8 != null) {
         int var4 = var8.length;
         Arrays.sort(var8, var3);
         int var7 = var8.length;
         int var5 = 0;

         while (true) {
            var6 = var4;
            if (var5 >= var7) {
               break;
            }

            File var9 = var8[var5];
            var6 = var4;
            if (var4 <= var2) {
               break;
            }

            var9.delete();
            var5++;
            var4--;
         }
      }

      return var6;
   }
}
