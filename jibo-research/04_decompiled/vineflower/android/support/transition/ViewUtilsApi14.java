package android.support.transition;

import android.graphics.Matrix;
import android.view.View;
import android.view.ViewParent;

class ViewUtilsApi14 implements ViewUtilsImpl {
   private float[] a;

   @Override
   public ViewOverlayImpl a(View var1) {
      return ViewOverlayApi14.d(var1);
   }

   @Override
   public void a(View var1, float var2) {
      Float var3 = (Float)var1.getTag(R.id.save_non_transition_alpha);
      if (var3 != null) {
         var1.setAlpha(var3 * var2);
      } else {
         var1.setAlpha(var2);
      }
   }

   @Override
   public void a(View var1, int var2, int var3, int var4, int var5) {
      var1.setLeft(var2);
      var1.setTop(var3);
      var1.setRight(var4);
      var1.setBottom(var5);
   }

   @Override
   public void a(View var1, Matrix var2) {
      ViewParent var3 = var1.getParent();
      if (var3 instanceof View) {
         View var5 = (View)var3;
         this.a(var5, var2);
         var2.preTranslate(-var5.getScrollX(), -var5.getScrollY());
      }

      var2.preTranslate(var1.getLeft(), var1.getTop());
      Matrix var4 = var1.getMatrix();
      if (!var4.isIdentity()) {
         var2.preConcat(var4);
      }
   }

   @Override
   public WindowIdImpl b(View var1) {
      return new WindowIdApi14(var1.getWindowToken());
   }

   @Override
   public void b(View var1, Matrix var2) {
      ViewParent var3 = var1.getParent();
      if (var3 instanceof View) {
         View var5 = (View)var3;
         this.b(var5, var2);
         var2.postTranslate(var5.getScrollX(), var5.getScrollY());
      }

      var2.postTranslate(var1.getLeft(), var1.getTop());
      Matrix var4 = var1.getMatrix();
      if (!var4.isIdentity()) {
         Matrix var6 = new Matrix();
         if (var4.invert(var6)) {
            var2.postConcat(var6);
         }
      }
   }

   @Override
   public float c(View var1) {
      Float var3 = (Float)var1.getTag(R.id.save_non_transition_alpha);
      float var2;
      if (var3 != null) {
         var2 = var1.getAlpha() / var3;
      } else {
         var2 = var1.getAlpha();
      }

      return var2;
   }

   @Override
   public void c(View var1, Matrix var2) {
      if (var2 != null && !var2.isIdentity()) {
         float[] var10 = this.a;
         float[] var9 = var10;
         if (var10 == null) {
            var9 = new float[9];
            this.a = var9;
         }

         var2.getValues(var9);
         float var3 = var9[3];
         float var4 = (float)Math.sqrt(1.0F - var3 * var3);
         byte var8;
         if (var9[0] < 0.0F) {
            var8 = -1;
         } else {
            var8 = 1;
         }

         float var5 = var8 * var4;
         var4 = (float)Math.toDegrees(Math.atan2(var3, var5));
         var3 = var9[0] / var5;
         float var7 = var9[4] / var5;
         float var6 = var9[2];
         var5 = var9[5];
         var1.setPivotX(0.0F);
         var1.setPivotY(0.0F);
         var1.setTranslationX(var6);
         var1.setTranslationY(var5);
         var1.setRotation(var4);
         var1.setScaleX(var3);
         var1.setScaleY(var7);
      } else {
         var1.setPivotX(var1.getWidth() / 2);
         var1.setPivotY(var1.getHeight() / 2);
         var1.setTranslationX(0.0F);
         var1.setTranslationY(0.0F);
         var1.setScaleX(1.0F);
         var1.setScaleY(1.0F);
         var1.setRotation(0.0F);
      }
   }

   @Override
   public void d(View var1) {
      if (var1.getTag(R.id.save_non_transition_alpha) == null) {
         var1.setTag(R.id.save_non_transition_alpha, var1.getAlpha());
      }
   }

   @Override
   public void e(View var1) {
      if (var1.getVisibility() == 0) {
         var1.setTag(R.id.save_non_transition_alpha, null);
      }
   }
}
