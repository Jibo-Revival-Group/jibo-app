package android.support.v4.graphics.drawable;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;

class WrappedDrawableApi19 extends WrappedDrawableApi14 {
   WrappedDrawableApi19(Drawable var1) {
      super(var1);
   }

   WrappedDrawableApi19(WrappedDrawableApi14.DrawableWrapperState var1, Resources var2) {
      super(var1, var2);
   }

   @Override
   WrappedDrawableApi14.DrawableWrapperState b() {
      return new WrappedDrawableApi19.DrawableWrapperStateKitKat(this.b, null);
   }

   public boolean isAutoMirrored() {
      return this.c.isAutoMirrored();
   }

   public void setAutoMirrored(boolean var1) {
      this.c.setAutoMirrored(var1);
   }

   private static class DrawableWrapperStateKitKat extends WrappedDrawableApi14.DrawableWrapperState {
      DrawableWrapperStateKitKat(WrappedDrawableApi14.DrawableWrapperState var1, Resources var2) {
         super(var1, var2);
      }

      @Override
      public Drawable newDrawable(Resources var1) {
         return new WrappedDrawableApi19(this, var1);
      }
   }
}
