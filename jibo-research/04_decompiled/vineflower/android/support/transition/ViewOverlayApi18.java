package android.support.transition;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewOverlay;

class ViewOverlayApi18 implements ViewOverlayImpl {
   private final ViewOverlay a;

   ViewOverlayApi18(View var1) {
      this.a = var1.getOverlay();
   }

   @Override
   public void a(Drawable var1) {
      this.a.add(var1);
   }

   @Override
   public void b(Drawable var1) {
      this.a.remove(var1);
   }
}
