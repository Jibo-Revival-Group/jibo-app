package android.support.v4.app;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Bitmap.Config;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import java.util.List;
import java.util.Map;

public abstract class SharedElementCallback {
   private static int b = 1048576;
   private Matrix a;

   private static Bitmap a(Drawable var0) {
      int var2 = var0.getIntrinsicWidth();
      int var3 = var0.getIntrinsicHeight();
      Bitmap var11;
      if (var2 > 0 && var3 > 0) {
         float var1 = Math.min(1.0F, (float)b / (var2 * var3));
         if (var0 instanceof BitmapDrawable && var1 == 1.0F) {
            var11 = ((BitmapDrawable)var0).getBitmap();
         } else {
            var2 = (int)(var2 * var1);
            int var7 = (int)(var3 * var1);
            Bitmap var8 = Bitmap.createBitmap(var2, var7, Config.ARGB_8888);
            Canvas var9 = new Canvas(var8);
            Rect var10 = var0.getBounds();
            int var5 = var10.left;
            var3 = var10.top;
            int var6 = var10.right;
            int var4 = var10.bottom;
            var0.setBounds(0, 0, var2, var7);
            var0.draw(var9);
            var0.setBounds(var5, var3, var6, var4);
            var11 = var8;
         }
      } else {
         var11 = null;
      }

      return var11;
   }

   public Parcelable a(View var1, Matrix var2, RectF var3) {
      if (var1 instanceof ImageView) {
         ImageView var8 = (ImageView)var1;
         Drawable var7 = var8.getDrawable();
         Drawable var9 = var8.getBackground();
         if (var7 != null && var9 == null) {
            Bitmap var17 = a(var7);
            if (var17 != null) {
               Bundle var18 = new Bundle();
               var18.putParcelable("sharedElement:snapshot:bitmap", var17);
               var18.putString("sharedElement:snapshot:imageScaleType", var8.getScaleType().toString());
               if (var8.getScaleType() == ScaleType.MATRIX) {
                  var2 = var8.getImageMatrix();
                  float[] var10 = new float[9];
                  var2.getValues(var10);
                  var18.putFloatArray("sharedElement:snapshot:imageMatrix", var10);
               }

               return var18;
            }
         }
      }

      int var6 = Math.round(var3.width());
      int var5 = Math.round(var3.height());
      Object var16 = null;
      Bitmap var15 = (Bitmap)var16;
      if (var6 > 0) {
         var15 = (Bitmap)var16;
         if (var5 > 0) {
            float var4 = Math.min(1.0F, (float)b / (var6 * var5));
            var6 = (int)(var6 * var4);
            var5 = (int)(var5 * var4);
            if (this.a == null) {
               this.a = new Matrix();
            }

            this.a.set(var2);
            this.a.postTranslate(-var3.left, -var3.top);
            this.a.postScale(var4, var4);
            var15 = Bitmap.createBitmap(var6, var5, Config.ARGB_8888);
            Canvas var11 = new Canvas(var15);
            var11.concat(this.a);
            var1.draw(var11);
         }
      }

      return var15;
   }

   public View a(Context var1, Parcelable var2) {
      Matrix var3 = null;
      ImageView var5;
      if (var2 instanceof Bundle) {
         Bundle var4 = (Bundle)var2;
         Bitmap var6 = (Bitmap)var4.getParcelable("sharedElement:snapshot:bitmap");
         if (var6 == null) {
            var5 = var3;
         } else {
            var5 = new ImageView(var1);
            var5.setImageBitmap(var6);
            var5.setScaleType(ScaleType.valueOf(var4.getString("sharedElement:snapshot:imageScaleType")));
            if (var5.getScaleType() == ScaleType.MATRIX) {
               float[] var7 = var4.getFloatArray("sharedElement:snapshot:imageMatrix");
               var3 = new Matrix();
               var3.setValues(var7);
               var5.setImageMatrix(var3);
            }
         }
      } else if (var2 instanceof Bitmap) {
         Bitmap var8 = (Bitmap)var2;
         var5 = new ImageView(var1);
         var5.setImageBitmap(var8);
      } else {
         var5 = null;
      }

      return var5;
   }

   public void a(List<View> var1) {
   }

   public void a(List<String> var1, List<View> var2, SharedElementCallback.OnSharedElementsReadyListener var3) {
      var3.a();
   }

   public void a(List<String> var1, List<View> var2, List<View> var3) {
   }

   public void a(List<String> var1, Map<String, View> var2) {
   }

   public void b(List<String> var1, List<View> var2, List<View> var3) {
   }

   public interface OnSharedElementsReadyListener {
      void a();
   }
}
