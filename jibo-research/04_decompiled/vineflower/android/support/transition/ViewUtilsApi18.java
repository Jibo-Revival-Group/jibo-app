package android.support.transition;

import android.view.View;

class ViewUtilsApi18 extends ViewUtilsApi14 {
   @Override
   public ViewOverlayImpl a(View var1) {
      return new ViewOverlayApi18(var1);
   }

   @Override
   public WindowIdImpl b(View var1) {
      return new WindowIdApi18(var1);
   }
}
