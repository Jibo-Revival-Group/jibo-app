package com.google.android.gms.common.util;

import com.google.android.gms.common.internal.zzbg;
import java.lang.reflect.Array;
import java.util.Arrays;

public final class zza {
   public static void a(StringBuilder var0, double[] var1) {
      int var3 = var1.length;

      for (int var2 = 0; var2 < var3; var2++) {
         if (var2 != 0) {
            var0.append(",");
         }

         var0.append(Double.toString(var1[var2]));
      }
   }

   public static void a(StringBuilder var0, float[] var1) {
      int var3 = var1.length;

      for (int var2 = 0; var2 < var3; var2++) {
         if (var2 != 0) {
            var0.append(",");
         }

         var0.append(Float.toString(var1[var2]));
      }
   }

   public static void a(StringBuilder var0, long[] var1) {
      int var3 = var1.length;

      for (int var2 = 0; var2 < var3; var2++) {
         if (var2 != 0) {
            var0.append(",");
         }

         var0.append(Long.toString(var1[var2]));
      }
   }

   public static <T> void a(StringBuilder var0, T[] var1) {
      int var3 = var1.length;

      for (int var2 = 0; var2 < var3; var2++) {
         if (var2 != 0) {
            var0.append(",");
         }

         var0.append(var1[var2].toString());
      }
   }

   public static void a(StringBuilder var0, String[] var1) {
      int var3 = var1.length;

      for (int var2 = 0; var2 < var3; var2++) {
         if (var2 != 0) {
            var0.append(",");
         }

         var0.append("\"").append(var1[var2]).append("\"");
      }
   }

   public static void a(StringBuilder var0, boolean[] var1) {
      int var3 = var1.length;

      for (int var2 = 0; var2 < var3; var2++) {
         if (var2 != 0) {
            var0.append(",");
         }

         var0.append(Boolean.toString(var1[var2]));
      }
   }

   public static <T> T[] a(T[] var0, T... var1) {
      if (var0 == null) {
         var0 = null;
      } else if (var1.length == 0) {
         var0 = Arrays.copyOf(var0, var0.length);
      } else {
         Object[] var7 = (Object[])Array.newInstance(var1.getClass().getComponentType(), var0.length);
         int var5;
         if (var1.length == 1) {
            int var16 = var0.length;
            int var13 = 0;
            int var10 = 0;

            while (true) {
               var5 = var10;
               if (var13 >= var16) {
                  break;
               }

               Object var17 = var0[var13];
               if (!zzbg.a(var1[0], var17)) {
                  int var14 = var10 + 1;
                  var7[var10] = var17;
                  var10 = var14;
               }

               var13++;
            }
         } else {
            int var6 = var0.length;
            int var4 = 0;
            int var2 = 0;

            while (true) {
               var5 = var2;
               if (var4 >= var6) {
                  break;
               }

               Object var8 = var0[var4];
               var5 = var1.length;
               int var3 = 0;

               while (true) {
                  if (var3 >= var5) {
                     var3 = -1;
                     break;
                  }

                  if (zzbg.a(var1[var3], var8)) {
                     break;
                  }

                  var3++;
               }

               boolean var11;
               if (var3 >= 0) {
                  var11 = 1;
               } else {
                  var11 = 0;
               }

               if (!var11) {
                  var11 = var2 + 1;
                  var7[var2] = var8;
                  var2 = var11;
               }

               var4++;
            }
         }

         if (var7 == null) {
            var0 = null;
         } else {
            var0 = var7;
            if (var5 != var7.length) {
               var0 = Arrays.copyOf(var7, var5);
            }
         }
      }

      return (T[])var0;
   }
}
