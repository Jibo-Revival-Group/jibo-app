package android.support.transition;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroupOverlay;

class ViewGroupOverlayApi18 implements ViewGroupOverlayImpl {
   private final ViewGroupOverlay a;

   ViewGroupOverlayApi18(ViewGroup var1) {
      this.a = var1.getOverlay();
   }

   @Override
   public void a(Drawable var1) {
      this.a.add(var1);
   }

   @Override
   public void a(View var1) {
      this.a.add(var1);
   }

   @Override
   public void b(Drawable var1) {
      this.a.remove(var1);
   }

   @Override
   public void b(View var1) {
      this.a.remove(var1);
   }
}
