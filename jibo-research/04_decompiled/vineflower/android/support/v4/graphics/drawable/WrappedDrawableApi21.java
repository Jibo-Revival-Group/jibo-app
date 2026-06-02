package android.support.v4.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Outline;
import android.graphics.Rect;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build.VERSION;
import android.util.Log;
import java.lang.reflect.Method;

class WrappedDrawableApi21 extends WrappedDrawableApi19 {
   private static Method d;

   WrappedDrawableApi21(Drawable var1) {
      super(var1);
      this.d();
   }

   WrappedDrawableApi21(WrappedDrawableApi14.DrawableWrapperState var1, Resources var2) {
      super(var1, var2);
      this.d();
   }

   private void d() {
      if (d == null) {
         try {
            d = Drawable.class.getDeclaredMethod("isProjected");
         } catch (Exception var2) {
            Log.w("WrappedDrawableApi21", "Failed to retrieve Drawable#isProjected() method", var2);
         }
      }
   }

   @Override
   WrappedDrawableApi14.DrawableWrapperState b() {
      return new WrappedDrawableApi21.DrawableWrapperStateLollipop(this.b, null);
   }

   @Override
   protected boolean c() {
      boolean var2 = false;
      boolean var1 = var2;
      if (VERSION.SDK_INT == 21) {
         Drawable var3 = this.c;
         if (!(var3 instanceof GradientDrawable) && !(var3 instanceof DrawableContainer) && !(var3 instanceof InsetDrawable)) {
            var1 = var2;
            if (!(var3 instanceof RippleDrawable)) {
               return var1;
            }
         }

         var1 = true;
      }

      return var1;
   }

   public Rect getDirtyBounds() {
      return this.c.getDirtyBounds();
   }

   public void getOutline(Outline var1) {
      this.c.getOutline(var1);
   }

   public void setHotspot(float var1, float var2) {
      this.c.setHotspot(var1, var2);
   }

   public void setHotspotBounds(int var1, int var2, int var3, int var4) {
      this.c.setHotspotBounds(var1, var2, var3, var4);
   }

   @Override
   public boolean setState(int[] var1) {
      boolean var2;
      if (super.setState(var1)) {
         this.invalidateSelf();
         var2 = true;
      } else {
         var2 = false;
      }

      return var2;
   }

   @Override
   public void setTint(int var1) {
      if (this.c()) {
         super.setTint(var1);
      } else {
         this.c.setTint(var1);
      }
   }

   @Override
   public void setTintList(ColorStateList var1) {
      if (this.c()) {
         super.setTintList(var1);
      } else {
         this.c.setTintList(var1);
      }
   }

   @Override
   public void setTintMode(Mode var1) {
      if (this.c()) {
         super.setTintMode(var1);
      } else {
         this.c.setTintMode(var1);
      }
   }

   private static class DrawableWrapperStateLollipop extends WrappedDrawableApi14.DrawableWrapperState {
      DrawableWrapperStateLollipop(WrappedDrawableApi14.DrawableWrapperState var1, Resources var2) {
         super(var1, var2);
      }

      @Override
      public Drawable newDrawable(Resources var1) {
         return new WrappedDrawableApi21(this, var1);
      }
   }
}
