package android.support.transition;

import android.animation.TypeEvaluator;
import android.graphics.Rect;

class RectEvaluator implements TypeEvaluator<Rect> {
   private Rect a;

   RectEvaluator() {
   }

   RectEvaluator(Rect var1) {
      this.a = var1;
   }

   public Rect a(float var1, Rect var2, Rect var3) {
      int var4 = var2.left;
      var4 = (int)((var3.left - var2.left) * var1) + var4;
      int var5 = var2.top;
      var5 = (int)((var3.top - var2.top) * var1) + var5;
      int var6 = var2.right;
      var6 = (int)((var3.right - var2.right) * var1) + var6;
      int var7 = var2.bottom;
      var7 = (int)((var3.bottom - var2.bottom) * var1) + var7;
      if (this.a == null) {
         var2 = new Rect(var4, var5, var6, var7);
      } else {
         this.a.set(var4, var5, var6, var7);
         var2 = this.a;
      }

      return var2;
   }
}
