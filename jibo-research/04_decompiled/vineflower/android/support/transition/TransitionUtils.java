package android.support.transition;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.TypeEvaluator;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.Bitmap.Config;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.MeasureSpec;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

class TransitionUtils {
   static Animator a(Animator var0, Animator var1) {
      if (var0 != null) {
         if (var1 == null) {
            var1 = var0;
         } else {
            AnimatorSet var2 = new AnimatorSet();
            var2.playTogether(new Animator[]{var0, (Animator)var1});
            var1 = var2;
         }
      }

      return (Animator)var1;
   }

   private static Bitmap a(View var0, Matrix var1, RectF var2) {
      Object var7 = null;
      int var5 = Math.round(var2.width());
      int var4 = Math.round(var2.height());
      Bitmap var6 = (Bitmap)var7;
      if (var5 > 0) {
         var6 = (Bitmap)var7;
         if (var4 > 0) {
            float var3 = Math.min(1.0F, 1048576.0F / (var5 * var4));
            var5 = (int)(var5 * var3);
            var4 = (int)(var4 * var3);
            var1.postTranslate(-var2.left, -var2.top);
            var1.postScale(var3, var3);
            var6 = Bitmap.createBitmap(var5, var4, Config.ARGB_8888);
            Canvas var8 = new Canvas(var6);
            var8.concat(var1);
            var0.draw(var8);
         }
      }

      return var6;
   }

   static View a(ViewGroup var0, View var1, View var2) {
      Matrix var7 = new Matrix();
      var7.setTranslate(-var2.getScrollX(), -var2.getScrollY());
      ViewUtils.a(var1, var7);
      ViewUtils.b(var0, var7);
      RectF var10 = new RectF(0.0F, 0.0F, var1.getWidth(), var1.getHeight());
      var7.mapRect(var10);
      int var6 = Math.round(var10.left);
      int var3 = Math.round(var10.top);
      int var5 = Math.round(var10.right);
      int var4 = Math.round(var10.bottom);
      ImageView var8 = new ImageView(var1.getContext());
      var8.setScaleType(ScaleType.CENTER_CROP);
      Bitmap var9 = a(var1, var7, var10);
      if (var9 != null) {
         var8.setImageBitmap(var9);
      }

      var8.measure(MeasureSpec.makeMeasureSpec(var5 - var6, 1073741824), MeasureSpec.makeMeasureSpec(var4 - var3, 1073741824));
      var8.layout(var6, var3, var5, var4);
      return var8;
   }

   static class MatrixEvaluator implements TypeEvaluator<Matrix> {
      final float[] a = new float[9];
      final float[] b = new float[9];
      final Matrix c = new Matrix();

      public Matrix a(float var1, Matrix var2, Matrix var3) {
         var2.getValues(this.a);
         var3.getValues(this.b);

         for (int var6 = 0; var6 < 9; var6++) {
            float var5 = this.b[var6];
            float var4 = this.a[var6];
            this.b[var6] = (var5 - var4) * var1 + this.a[var6];
         }

         this.c.setValues(this.b);
         return this.c;
      }
   }
}
