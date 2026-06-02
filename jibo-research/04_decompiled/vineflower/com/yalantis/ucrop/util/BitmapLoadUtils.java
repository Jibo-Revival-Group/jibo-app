package com.yalantis.ucrop.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.BitmapFactory.Options;
import android.net.Uri;
import android.os.Build.VERSION;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import com.yalantis.ucrop.callback.BitmapLoadCallback;
import com.yalantis.ucrop.task.BitmapLoadTask;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;

public class BitmapLoadUtils {
   private static final String TAG = "BitmapLoadUtils";

   public static int calculateInSampleSize(Options var0, int var1, int var2) {
      int var7 = var0.outHeight;
      int var6 = var0.outWidth;
      byte var4 = 1;
      byte var5 = 1;
      byte var3 = var5;
      if (var7 <= var2) {
         if (var6 <= var1) {
            return var4;
         }

         var3 = var5;
      }

      while (true) {
         if (var7 / var3 <= var2) {
            var4 = var3;
            if (var6 / var3 <= var1) {
               return var4;
            }
         }

         var3 *= 2;
      }
   }

   public static int calculateMaxBitmapSize(Context var0) {
      Display var6 = ((WindowManager)var0.getSystemService("window")).getDefaultDisplay();
      Point var5 = new Point();
      int var3;
      int var4;
      if (VERSION.SDK_INT >= 13) {
         var6.getSize(var5);
         var4 = var5.x;
         var3 = var5.y;
      } else {
         var4 = var6.getWidth();
         var3 = var6.getHeight();
      }

      double var1 = Math.pow(var4, 2.0);
      var3 = (int)Math.sqrt(Math.pow(var3, 2.0) + var1);
      Canvas var7 = new Canvas();
      return Math.min(var3 * 2, Math.min(var7.getMaximumBitmapWidth(), var7.getMaximumBitmapHeight()));
   }

   public static void close(Closeable var0) {
      if (var0 != null && var0 instanceof Closeable) {
         try {
            var0.close();
         } catch (IOException var1) {
         }
      }
   }

   public static void decodeBitmapInBackground(Context var0, Uri var1, Uri var2, int var3, int var4, BitmapLoadCallback var5) {
      new BitmapLoadTask(var0, var1, var2, var3, var4, var5).execute(new Void[0]);
   }

   public static int exifToDegrees(int var0) {
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

   public static int exifToTranslation(int var0) {
      byte var1;
      switch (var0) {
         case 2:
         case 4:
         case 5:
         case 7:
            var1 = -1;
            break;
         case 3:
         case 6:
         default:
            var1 = 1;
      }

      return var1;
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   public static int getExifOrientation(Context var0, Uri var1) {
      byte var4 = 0;
      int var3 = 0;
      int var2 = var4;

      InputStream var5;
      try {
         var5 = var0.getContentResolver().openInputStream(var1);
      } catch (IOException var10) {
         Log.e("BitmapLoadUtils", "getExifOrientation: " + var1.toString(), var10);
         return var2;
      }

      if (var5 == null) {
         var2 = var3;
      } else {
         int var14 = var4;

         try {
            var11 = new ImageHeaderParser;
         } catch (IOException var9) {
            Log.e("BitmapLoadUtils", "getExifOrientation: " + var1.toString(), var9);
            return var14;
         }

         var14 = var4;

         try {
            var11./* $VF: Unable to resugar constructor */<init>(var5);
         } catch (IOException var8) {
            Log.e("BitmapLoadUtils", "getExifOrientation: " + var1.toString(), var8);
            return var14;
         }

         var14 = var4;

         try {
            var3 = var11.getOrientation();
         } catch (IOException var7) {
            Log.e("BitmapLoadUtils", "getExifOrientation: " + var1.toString(), var7);
            return var14;
         }

         var14 = var3;

         try {
            close(var5);
         } catch (IOException var6) {
            Log.e("BitmapLoadUtils", "getExifOrientation: " + var1.toString(), var6);
            return var14;
         }

         var2 = var3;
      }

      return var2;
   }

   public static Bitmap transformBitmap(Bitmap var0, Matrix var1) {
      boolean var2;
      try {
         var4 = Bitmap.createBitmap(var0, 0, 0, var0.getWidth(), var0.getHeight(), var1, true);
         var2 = var0.sameAs(var4);
      } catch (OutOfMemoryError var3) {
         Log.e("BitmapLoadUtils", "transformBitmap: ", var3);
         return var0;
      }

      if (!var2) {
         var0 = var4;
      }

      return var0;
   }
}
