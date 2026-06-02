package android.support.transition;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;

public class Explode extends Visibility {
   private static final TimeInterpolator g = new DecelerateInterpolator();
   private static final TimeInterpolator h = new AccelerateInterpolator();
   private int[] i = new int[2];

   public Explode() {
      this.a(new CircularPropagation());
   }

   public Explode(Context var1, AttributeSet var2) {
      super(var1, var2);
      this.a(new CircularPropagation());
   }

   private static float a(float var0, float var1) {
      return (float)Math.sqrt(var0 * var0 + var1 * var1);
   }

   private static float a(View var0, int var1, int var2) {
      var1 = Math.max(var1, var0.getWidth() - var1);
      var2 = Math.max(var2, var0.getHeight() - var2);
      return a(var1, var2);
   }

   private void a(View var1, Rect var2, int[] var3) {
      var1.getLocationOnScreen(this.i);
      int var10 = this.i[0];
      int var11 = this.i[1];
      Rect var14 = this.m();
      int var9;
      int var19;
      if (var14 == null) {
         var19 = var1.getWidth() / 2;
         var9 = Math.round(var1.getTranslationX()) + var19 + var10;
         var19 = var1.getHeight() / 2 + var11 + Math.round(var1.getTranslationY());
      } else {
         var9 = var14.centerX();
         var19 = var14.centerY();
      }

      int var13 = var2.centerX();
      int var12 = var2.centerY();
      float var7 = var13 - var9;
      float var6 = var12 - var19;
      float var5 = var6;
      float var4 = var7;
      if (var7 == 0.0F) {
         var5 = var6;
         var4 = var7;
         if (var6 == 0.0F) {
            var4 = (float)(Math.random() * 2.0) - 1.0F;
            var5 = (float)(Math.random() * 2.0) - 1.0F;
         }
      }

      var6 = a(var4, var5);
      var4 /= var6;
      var5 /= var6;
      var6 = a(var1, var9 - var10, var19 - var11);
      var3[0] = Math.round(var4 * var6);
      var3[1] = Math.round(var6 * var5);
   }

   private void d(TransitionValues var1) {
      View var6 = var1.b;
      var6.getLocationOnScreen(this.i);
      int var3 = this.i[0];
      int var4 = this.i[1];
      int var2 = var6.getWidth();
      int var5 = var6.getHeight();
      var1.a.put("android:explode:screenBounds", new Rect(var3, var4, var2 + var3, var5 + var4));
   }

   @Override
   public Animator a(ViewGroup var1, View var2, TransitionValues var3, TransitionValues var4) {
      Animator var9;
      if (var4 == null) {
         var9 = null;
      } else {
         Rect var10 = (Rect)var4.a.get("android:explode:screenBounds");
         float var7 = var2.getTranslationX();
         float var8 = var2.getTranslationY();
         this.a(var1, var10, this.i);
         float var5 = this.i[0];
         float var6 = this.i[1];
         var9 = TranslationAnimationCreator.a(var2, var4, var10.left, var10.top, var7 + var5, var8 + var6, var7, var8, g);
      }

      return var9;
   }

   @Override
   public void a(TransitionValues var1) {
      super.a(var1);
      this.d(var1);
   }

   @Override
   public Animator b(ViewGroup var1, View var2, TransitionValues var3, TransitionValues var4) {
      Animator var12;
      if (var3 == null) {
         var12 = null;
      } else {
         Rect var13 = (Rect)var3.a.get("android:explode:screenBounds");
         int var10 = var13.left;
         int var9 = var13.top;
         float var7 = var2.getTranslationX();
         float var8 = var2.getTranslationY();
         int[] var11 = (int[])var3.b.getTag(R.id.transition_position);
         float var14;
         float var15;
         if (var11 != null) {
            var14 = var11[0] - var13.left;
            var15 = var11[1] - var13.top;
            var13.offsetTo(var11[0], var11[1]);
            var15 += var8;
            var14 = var7 + var14;
         } else {
            var15 = var8;
            var14 = var7;
         }

         this.a(var1, var13, this.i);
         var12 = TranslationAnimationCreator.a(var2, var3, var10, var9, var7, var8, var14 + this.i[0], var15 + this.i[1], h);
      }

      return var12;
   }

   @Override
   public void b(TransitionValues var1) {
      super.b(var1);
      this.d(var1);
   }
}
