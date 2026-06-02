package com.jibo.utils;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.Drawable;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.os.Build.VERSION;
import android.support.v4.app.Fragment;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.view.Menu;
import android.view.MenuItem;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class ImageUtils {
   private static int a(Options var0, int var1, int var2) {
      int var3 = 1;
      if (var0.outWidth > var1 || var0.outHeight > var2) {
         var3 = (int)Math.max(Math.round((double)var0.outWidth / var1), Math.round((double)var0.outHeight / var2));
      }

      return var3;
   }

   public static Bitmap a(Bitmap var0) {
      if (var0 == null) {
         var0 = null;
      } else {
         int var2 = Math.min(var0.getWidth(), var0.getHeight());
         int var1 = var2 / 2;
         Bitmap var3 = Bitmap.createBitmap(var2, var2, Config.ARGB_4444);
         Canvas var5 = new Canvas(var3);
         Rect var7 = new Rect(var0.getWidth() / 2 - var1, var0.getHeight() / 2 - var1, var0.getWidth() / 2 + var1, var0.getHeight() / 2 + var1);
         Rect var6 = new Rect(0, 0, var2, var2);
         Paint var4 = new Paint();
         var4.setAntiAlias(true);
         var5.drawCircle(var1, var1, var1, var4);
         var5.drawBitmap(var0, var7, var6, var4);
         var0 = var3;
      }

      return var0;
   }

   public static Bitmap a(String var0, int var1, int var2) throws FileNotFoundException {
      if (!new File(var0).exists()) {
         throw new FileNotFoundException();
      }

      Options var3 = new Options();
      var3.inJustDecodeBounds = true;
      BitmapFactory.decodeFile(var0, var3);
      var3.inSampleSize = a(var3, var1, var2);
      var3.inJustDecodeBounds = false;
      var3.inPurgeable = true;
      var3.inInputShareable = true;
      return BitmapFactory.decodeFile(var0, var3);
   }

   public static Drawable a(Context var0, int var1) {
      Drawable var2;
      if (VERSION.SDK_INT >= 23) {
         var2 = var0.getResources().getDrawable(var1, var0.getTheme());
      } else {
         var2 = var0.getResources().getDrawable(var1);
      }

      return DrawableCompat.g(var2);
   }

   public static Drawable a(Context var0, int var1, int var2) {
      var2 = b(var0, var2);
      Drawable var3 = a(var0, var1);
      DrawableCompat.a(var3, var2);
      return var3;
   }

   public static void a(Context var0, Menu var1) {
      for (int var2 = 0; var2 < var1.size(); var2++) {
         a(var0, var1.getItem(var2), 2131099871);
      }
   }

   public static void a(Context var0, MenuItem var1, int var2) {
      if (var1 != null) {
         Drawable var3 = var1.getIcon();
         if (var3 != null) {
            var3 = DrawableCompat.g(var3);
            DrawableCompat.a(var3, b(var0, var2));
            var1.setIcon(var3);
         }
      }
   }

   public static void a(Fragment var0, int var1, Uri var2) {
      Intent var3 = new Intent("android.media.action.IMAGE_CAPTURE");
      var3.addFlags(3);
      if (var2 != null) {
         var3.putExtra("output", var2);
         var3.putExtra("android.intent.extra.videoQuality", 1);
      }

      var0.startActivityForResult(var3, var1);
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   public static void a(File var0, File var1) {
      try {
         if (var1.exists()) {
            var1.delete();
         }
      } catch (IOException var9) {
         return;
      }

      FileInputStream var3;
      try {
         var3 = new FileInputStream(var0);
      } catch (IOException var8) {
         return;
      }

      if (var3 != null) {
         try {
            var10 = new FileOutputStream(var1);
            var11 = new byte[1048576];
         } catch (IOException var7) {
            return;
         }

         while (true) {
            int var2;
            try {
               var2 = var3.read(var11);
            } catch (IOException var5) {
               break;
            }

            if (var2 <= 0) {
               try {
                  var10.close();
                  var3.close();
               } catch (IOException var4) {
               }
               break;
            }

            try {
               var10.write(var11, 0, var2);
            } catch (IOException var6) {
               break;
            }
         }
      }
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   public static void a(String var0, InputStream var1) {
      File var3;
      try {
         var3 = new File(var0);
         if (var3.exists()) {
            var3.delete();
         }
      } catch (IOException var8) {
         return;
      }

      if (var1 != null) {
         try {
            var9 = new FileOutputStream(var3);
            var10 = new byte[102400];
         } catch (IOException var7) {
            return;
         }

         while (true) {
            int var2;
            try {
               var2 = var1.read(var10);
            } catch (IOException var5) {
               break;
            }

            if (var2 <= 0) {
               try {
                  var9.close();
                  var1.close();
               } catch (IOException var4) {
               }
               break;
            }

            try {
               var9.write(var10, 0, var2);
            } catch (IOException var6) {
               break;
            }
         }
      }
   }

   public static void a(String var0, String var1, int var2, int var3) throws IOException {
      Options var5 = new Options();
      var5.inJustDecodeBounds = true;
      BitmapFactory.decodeFile(var0, var5);
      float var4 = (float)var2 / var3;
      var2 = Math.min(var2, var5.outWidth);
      var3 = Math.min(var5.outHeight, (int)(var2 / var4));
      var2 = (int)(var4 * var3);
      Bitmap var6 = ThumbnailUtils.extractThumbnail(BitmapFactory.decodeFile(var0), var2, var3);
      FileOutputStream var7 = new FileOutputStream(new File(var1));
      var6.compress(CompressFormat.JPEG, 95, var7);
      var7.close();
   }

   public static int b(Context var0, int var1) {
      if (VERSION.SDK_INT >= 23) {
         var1 = var0.getResources().getColor(var1, var0.getTheme());
      } else {
         var1 = var0.getResources().getColor(var1);
      }

      return var1;
   }

   public static Drawable b(Context var0, int var1, int var2) {
      ColorStateList var3 = c(var0, var2);
      Drawable var4 = a(var0, var1);
      DrawableCompat.a(var4, var3);
      return var4;
   }

   public static void b(Fragment var0, int var1, Uri var2) {
      Intent var3 = new Intent("android.media.action.IMAGE_CAPTURE");
      var3.addFlags(3);
      if (var2 != null) {
         var3.putExtra("output", var2);
         var3.putExtra("android.intent.extra.videoQuality", 1);
      }

      if (var0.getParentFragment() == null) {
         var0.startActivityForResult(var3, var1);
      } else {
         var0.getParentFragment().startActivityForResult(var3, var1);
      }
   }

   public static ColorStateList c(Context var0, int var1) {
      ColorStateList var2;
      if (VERSION.SDK_INT >= 23) {
         var2 = var0.getResources().getColorStateList(var1, var0.getTheme());
      } else {
         var2 = var0.getResources().getColorStateList(var1);
      }

      return var2;
   }
}
