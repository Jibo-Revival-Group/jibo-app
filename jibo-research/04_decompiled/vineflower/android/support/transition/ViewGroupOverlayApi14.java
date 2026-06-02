package android.support.transition;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

class ViewGroupOverlayApi14 extends ViewOverlayApi14 implements ViewGroupOverlayImpl {
   ViewGroupOverlayApi14(Context var1, ViewGroup var2, View var3) {
      super(var1, var2, var3);
   }

   static ViewGroupOverlayApi14 a(ViewGroup var0) {
      return (ViewGroupOverlayApi14)ViewOverlayApi14.d(var0);
   }

   @Override
   public void a(View var1) {
      this.a.a(var1);
   }

   @Override
   public void b(View var1) {
      this.a.b(var1);
   }
}
