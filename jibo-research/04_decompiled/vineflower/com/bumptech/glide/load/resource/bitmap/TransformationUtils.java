package com.bumptech.glide.load.resource.bitmap;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Bitmap.Config;
import android.os.Build.VERSION;
import android.util.Log;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;

public final class TransformationUtils {
   public static int a(int var0) {
      short var1;
      switch (var0) {
         case 3:
         case 4:
            var1 = 180;
            break;
         case 5:
         case 6:
            var1 = 90;
            break;
         case 7:
         case 8:
            var1 = 270;
            break;
         default:
            var1 = 0;
      }

      return var1;
   }

   private static Config a(Bitmap var0) {
      Config var1;
      if (var0.getConfig() != null) {
         var1 = var0.getConfig();
      } else {
         var1 = Config.ARGB_8888;
      }

      return var1;
   }

   public static Bitmap a(Bitmap var0, Bitmap var1, int var2, int var3) {
      float var5 = 0.0F;
      Bitmap var8;
      if (var1 == null) {
         var8 = null;
      } else {
         if (var1.getWidth() == var2) {
            var8 = var1;
            if (var1.getHeight() == var3) {
               return var8;
            }
         }

         Matrix var10 = new Matrix();
         float var4;
         float var6;
         if (var1.getWidth() * var3 > var1.getHeight() * var2) {
            var6 = (float)var3 / var1.getHeight();
            var4 = (var2 - var1.getWidth() * var6) * 0.5F;
         } else {
            var6 = (float)var2 / var1.getWidth();
            float var7 = var3;
            var5 = var1.getHeight();
            var4 = 0.0F;
            var5 = (var7 - var5 * var6) * 0.5F;
         }

         var10.setScale(var6, var6);
         var10.postTranslate((int)(var4 + 0.5F), (int)(var5 + 0.5F));
         if (var0 == null) {
            var0 = Bitmap.createBitmap(var2, var3, a(var1));
         }

         a(var1, var0);
         new Canvas(var0).drawBitmap(var1, var10, new Paint(6));
         var8 = var0;
      }

      return var8;
   }

   public static Bitmap a(Bitmap var0, BitmapPool var1, int var2) {
      Matrix var6 = new Matrix();
      a(var2, var6);
      if (!var6.isIdentity()) {
         RectF var5 = new RectF(0.0F, 0.0F, var0.getWidth(), var0.getHeight());
         var6.mapRect(var5);
         int var3 = Math.round(var5.width());
         var2 = Math.round(var5.height());
         Config var7 = a(var0);
         Bitmap var4 = var1.get(var3, var2, var7);
         Bitmap var8 = var4;
         if (var4 == null) {
            var8 = Bitmap.createBitmap(var3, var2, var7);
         }

         var6.postTranslate(-var5.left, -var5.top);
         new Canvas(var8).drawBitmap(var0, var6, new Paint(6));
         var0 = var8;
      }

      return var0;
   }

   public static Bitmap a(Bitmap var0, BitmapPool var1, int var2, int var3) {
      Bitmap var9;
      if (var0.getWidth() == var2 && var0.getHeight() == var3) {
         var9 = var0;
         if (Log.isLoggable("TransformationUtils", 2)) {
            Log.v("TransformationUtils", "requested target size matches input, returning input");
            var9 = var0;
         }
      } else {
         float var4 = Math.min((float)var2 / var0.getWidth(), (float)var3 / var0.getHeight());
         int var6 = (int)(var0.getWidth() * var4);
         int var5 = (int)(var0.getHeight() * var4);
         if (var0.getWidth() == var6 && var0.getHeight() == var5) {
            var9 = var0;
            if (Log.isLoggable("TransformationUtils", 2)) {
               Log.v("TransformationUtils", "adjusted target size matches input, returning input");
               var9 = var0;
            }
         } else {
            Config var8 = a(var0);
            Bitmap var7 = var1.get(var6, var5, var8);
            var9 = var7;
            if (var7 == null) {
               var9 = Bitmap.createBitmap(var6, var5, var8);
            }

            a(var0, var9);
            if (Log.isLoggable("TransformationUtils", 2)) {
               Log.v("TransformationUtils", "request: " + var2 + "x" + var3);
               Log.v("TransformationUtils", "toFit:   " + var0.getWidth() + "x" + var0.getHeight());
               Log.v("TransformationUtils", "toReuse: " + var9.getWidth() + "x" + var9.getHeight());
               Log.v("TransformationUtils", "minPct:   " + var4);
            }

            Canvas var10 = new Canvas(var9);
            Matrix var11 = new Matrix();
            var11.setScale(var4, var4);
            var10.drawBitmap(var0, var11, new Paint(6));
         }
      }

      return var9;
   }

   static void a(int var0, Matrix var1) {
      switch (var0) {
         case 2:
            var1.setScale(-1.0F, 1.0F);
            break;
         case 3:
            var1.setRotate(180.0F);
            break;
         case 4:
            var1.setRotate(180.0F);
            var1.postScale(-1.0F, 1.0F);
            break;
         case 5:
            var1.setRotate(90.0F);
            var1.postScale(-1.0F, 1.0F);
            break;
         case 6:
            var1.setRotate(90.0F);
            break;
         case 7:
            var1.setRotate(-90.0F);
            var1.postScale(-1.0F, 1.0F);
            break;
         case 8:
            var1.setRotate(-90.0F);
      }
   }

   @TargetApi(12)
   public static void a(Bitmap var0, Bitmap var1) {
      if (VERSION.SDK_INT >= 12 && var1 != null) {
         var1.setHasAlpha(var0.hasAlpha());
      }
   }
}
