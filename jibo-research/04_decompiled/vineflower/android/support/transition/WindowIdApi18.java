package android.support.transition;

import android.view.View;
import android.view.WindowId;

class WindowIdApi18 implements WindowIdImpl {
   private final WindowId a;

   WindowIdApi18(View var1) {
      this.a = var1.getWindowId();
   }

   @Override
   public boolean equals(Object var1) {
      boolean var2;
      if (var1 instanceof WindowIdApi18 && ((WindowIdApi18)var1).a.equals(this.a)) {
         var2 = true;
      } else {
         var2 = false;
      }

      return var2;
   }

   @Override
   public int hashCode() {
      return this.a.hashCode();
   }
}
