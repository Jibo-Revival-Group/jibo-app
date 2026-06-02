package android.support.transition;

import android.graphics.Rect;
import android.view.ViewGroup;

public class CircularPropagation extends VisibilityPropagation {
   private float a = 3.0F;

   private static float a(float var0, float var1, float var2, float var3) {
      var0 = var2 - var0;
      var1 = var3 - var1;
      return (float)Math.sqrt(var0 * var0 + var1 * var1);
   }

   @Override
   public long a(ViewGroup var1, Transition var2, TransitionValues var3, TransitionValues var4) {
      long var17;
      if (var3 == null && var4 == null) {
         var17 = 0L;
      } else {
         byte var6;
         if (var4 != null && this.b(var3) != 0) {
            var6 = 1;
            var3 = var4;
         } else {
            var6 = -1;
         }

         int var9 = this.c(var3);
         int var10 = this.d(var3);
         Rect var15 = var2.m();
         int var7;
         int var8;
         if (var15 != null) {
            var8 = var15.centerX();
            var7 = var15.centerY();
         } else {
            int[] var16 = new int[2];
            var1.getLocationOnScreen(var16);
            var8 = Math.round(var16[0] + var1.getWidth() / 2 + var1.getTranslationX());
            var7 = Math.round(var16[1] + var1.getHeight() / 2 + var1.getTranslationY());
         }

         float var5 = a(var9, var10, var8, var7) / a(0.0F, 0.0F, var1.getWidth(), var1.getHeight());
         long var13 = var2.b();
         var17 = var13;
         if (var13 < 0L) {
            var17 = 300L;
         }

         var17 = Math.round((float)(var17 * var6) / this.a * var5);
      }

      return var17;
   }
}
