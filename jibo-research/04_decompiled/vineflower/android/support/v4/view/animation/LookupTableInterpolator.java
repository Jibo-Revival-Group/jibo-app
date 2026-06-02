package android.support.v4.view.animation;

import android.view.animation.Interpolator;

abstract class LookupTableInterpolator implements Interpolator {
   private final float[] a;
   private final float b;

   protected LookupTableInterpolator(float[] var1) {
      this.a = var1;
      this.b = 1.0F / (this.a.length - 1);
   }

   public float getInterpolation(float var1) {
      float var2 = 1.0F;
      if (var1 >= 1.0F) {
         var1 = var2;
      } else if (var1 <= 0.0F) {
         var1 = 0.0F;
      } else {
         int var3 = Math.min((int)((this.a.length - 1) * var1), this.a.length - 2);
         var2 = (var1 - var3 * this.b) / this.b;
         var1 = this.a[var3];
         var1 = (this.a[var3 + 1] - this.a[var3]) * var2 + var1;
      }

      return var1;
   }
}
