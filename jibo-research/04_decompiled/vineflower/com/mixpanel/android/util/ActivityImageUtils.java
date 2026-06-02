package com.mixpanel.android.util;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.view.View;

public class ActivityImageUtils {
   public static int a(int var0) {
      float[] var1 = new float[3];
      Color.colorToHSV(var0, var1);
      var1[2] = 0.3F;
      return Color.HSVToColor(242, var1);
   }

   public static int a(Activity var0) {
      int var1 = -16777216;
      Bitmap var2 = a(var0, 1, 1, false);
      if (var2 != null) {
         var1 = var2.getPixel(0, 0);
      }

      return a(var1);
   }

   public static Bitmap a(Activity var0, int var1, int var2, boolean var3) {
      View var8 = var0.findViewById(16908290).getRootView();
      boolean var6 = var8.isDrawingCacheEnabled();
      var8.setDrawingCacheEnabled(true);
      var8.buildDrawingCache(true);
      Bitmap var9 = var8.getDrawingCache();
      Object var7 = null;
      Bitmap var11 = (Bitmap)var7;
      if (var9 != null) {
         var11 = (Bitmap)var7;
         if (var9.getWidth() > 0) {
            var11 = (Bitmap)var7;
            if (var9.getHeight() > 0) {
               int var5 = var1;
               int var4 = var2;
               if (var3) {
                  var5 = var9.getWidth() / var1;
                  var4 = var9.getHeight() / var2;
               }

               var11 = (Bitmap)var7;
               if (var5 > 0) {
                  var11 = (Bitmap)var7;
                  if (var4 > 0) {
                     try {
                        var11 = Bitmap.createScaledBitmap(var9, var5, var4, false);
                     } catch (OutOfMemoryError var10) {
                        MPLog.c("MixpanelAPI.ActImgUtils", "Not enough memory to produce scaled image, returning a null screenshot");
                        var11 = (Bitmap)var7;
                     }
                  }
               }
            }
         }
      }

      if (!var6) {
         var8.setDrawingCacheEnabled(false);
      }

      return var11;
   }
}
