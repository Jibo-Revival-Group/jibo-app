package com.google.maps.internal;

import com.google.maps.model.LatLng;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class PolylineEncoding {
   public static List<LatLng> decode(String var0) {
      int var7 = var0.length();
      ArrayList var8 = new ArrayList(var7 / 2);
      int var1 = 0;
      int var2 = 0;
      int var3 = 0;

      label38:
      while (var1 < var7) {
         int var4 = 1;
         int var5 = 0;
         int var6 = var1;

         while (true) {
            var1 = var6 + 1;
            var6 = var0.charAt(var6) - '?' - 1;
            var4 += var6 << var5;
            var5 += 5;
            if (var6 < 31) {
               if ((var4 & 1) != 0) {
                  var4 = ~(var4 >> 1);
               } else {
                  var4 >>= 1;
               }

               var6 = var3 + var4;
               var3 = 1;
               byte var13 = 0;
               var5 = var1;

               while (true) {
                  var1 = var5 + 1;
                  var5 = var0.charAt(var5) - '?' - 1;
                  var3 += var5 << var13;
                  var13 += 5;
                  if (var5 < 31) {
                     if ((var3 & 1) != 0) {
                        var3 = ~(var3 >> 1);
                     } else {
                        var3 >>= 1;
                     }

                     var2 += var3;
                     var8.add(new LatLng(var6 * 1.0E-5, var2 * 1.0E-5));
                     var3 = var6;
                     continue label38;
                  }

                  var5 = var1;
               }
            }

            var6 = var1;
         }
      }

      return var8;
   }

   public static String encode(List<LatLng> var0) {
      StringBuffer var9 = new StringBuffer();
      Iterator var10 = var0.iterator();
      long var3 = 0L;
      long var1 = 0L;

      while (var10.hasNext()) {
         LatLng var11 = (LatLng)var10.next();
         long var5 = Math.round(var11.lat * 100000.0);
         long var7 = Math.round(var11.lng * 100000.0);
         encode(var5 - var1, var9);
         encode(var7 - var3, var9);
         var3 = var7;
         var1 = var5;
      }

      return var9.toString();
   }

   public static String encode(LatLng[] var0) {
      return encode(Arrays.asList(var0));
   }

   private static void encode(long var0, StringBuffer var2) {
      if (var0 < 0L) {
         var0 = ~(var0 << 1);
      } else {
         var0 <<= 1;
      }

      while (var0 >= 32L) {
         var2.append(Character.toChars((int)((31L & var0 | 32L) + 63L)));
         var0 >>= 5;
      }

      var2.append(Character.toChars((int)(var0 + 63L)));
   }
}
