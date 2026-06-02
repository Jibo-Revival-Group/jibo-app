package android.support.v4.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.Drawable.ConstantState;

class WrappedDrawableApi14 extends Drawable implements Callback, TintAwareDrawable, WrappedDrawable {
   static final Mode a = Mode.SRC_IN;
   WrappedDrawableApi14.DrawableWrapperState b;
   Drawable c;
   private int d;
   private Mode e;
   private boolean f;
   private boolean g;

   WrappedDrawableApi14(Drawable var1) {
      this.b = this.b();
      this.a(var1);
   }

   WrappedDrawableApi14(WrappedDrawableApi14.DrawableWrapperState var1, Resources var2) {
      this.b = var1;
      this.a(var2);
   }

   private void a(Resources var1) {
      if (this.b != null && this.b.b != null) {
         this.a(this.b.b.newDrawable(var1));
      }
   }

   private boolean a(int[] var1) {
      boolean var3 = false;
      if (this.c()) {
         ColorStateList var4 = this.b.c;
         Mode var5 = this.b.d;
         if (var4 != null && var5 != null) {
            int var2 = var4.getColorForState(var1, var4.getDefaultColor());
            if (!this.f || var2 != this.d || var5 != this.e) {
               this.setColorFilter(var2, var5);
               this.d = var2;
               this.e = var5;
               this.f = true;
               var3 = true;
            }
         } else {
            this.f = false;
            this.clearColorFilter();
         }
      }

      return var3;
   }

   @Override
   public final Drawable a() {
      return this.c;
   }

   @Override
   public final void a(Drawable var1) {
      if (this.c != null) {
         this.c.setCallback(null);
      }

      this.c = var1;
      if (var1 != null) {
         var1.setCallback(this);
         this.setVisible(var1.isVisible(), true);
         this.setState(var1.getState());
         this.setLevel(var1.getLevel());
         this.setBounds(var1.getBounds());
         if (this.b != null) {
            this.b.b = var1.getConstantState();
         }
      }

      this.invalidateSelf();
   }

   WrappedDrawableApi14.DrawableWrapperState b() {
      return new WrappedDrawableApi14.DrawableWrapperStateBase(this.b, null);
   }

   protected boolean c() {
      return true;
   }

   public void draw(Canvas var1) {
      this.c.draw(var1);
   }

   public int getChangingConfigurations() {
      int var2 = super.getChangingConfigurations();
      int var1;
      if (this.b != null) {
         var1 = this.b.getChangingConfigurations();
      } else {
         var1 = 0;
      }

      return var1 | var2 | this.c.getChangingConfigurations();
   }

   public ConstantState getConstantState() {
      WrappedDrawableApi14.DrawableWrapperState var1;
      if (this.b != null && this.b.a()) {
         this.b.a = this.getChangingConfigurations();
         var1 = this.b;
      } else {
         var1 = null;
      }

      return var1;
   }

   public Drawable getCurrent() {
      return this.c.getCurrent();
   }

   public int getIntrinsicHeight() {
      return this.c.getIntrinsicHeight();
   }

   public int getIntrinsicWidth() {
      return this.c.getIntrinsicWidth();
   }

   public int getMinimumHeight() {
      return this.c.getMinimumHeight();
   }

   public int getMinimumWidth() {
      return this.c.getMinimumWidth();
   }

   public int getOpacity() {
      return this.c.getOpacity();
   }

   public boolean getPadding(Rect var1) {
      return this.c.getPadding(var1);
   }

   public int[] getState() {
      return this.c.getState();
   }

   public Region getTransparentRegion() {
      return this.c.getTransparentRegion();
   }

   public void invalidateDrawable(Drawable var1) {
      this.invalidateSelf();
   }

   public boolean isStateful() {
      ColorStateList var2;
      if (this.c() && this.b != null) {
         var2 = this.b.c;
      } else {
         var2 = null;
      }

      boolean var1;
      if ((var2 == null || !var2.isStateful()) && !this.c.isStateful()) {
         var1 = false;
      } else {
         var1 = true;
      }

      return var1;
   }

   public void jumpToCurrentState() {
      this.c.jumpToCurrentState();
   }

   public Drawable mutate() {
      if (!this.g && super.mutate() == this) {
         this.b = this.b();
         if (this.c != null) {
            this.c.mutate();
         }

         if (this.b != null) {
            WrappedDrawableApi14.DrawableWrapperState var2 = this.b;
            ConstantState var1;
            if (this.c != null) {
               var1 = this.c.getConstantState();
            } else {
               var1 = null;
            }

            var2.b = var1;
         }

         this.g = true;
      }

      return this;
   }

   protected void onBoundsChange(Rect var1) {
      if (this.c != null) {
         this.c.setBounds(var1);
      }
   }

   protected boolean onLevelChange(int var1) {
      return this.c.setLevel(var1);
   }

   public void scheduleDrawable(Drawable var1, Runnable var2, long var3) {
      this.scheduleSelf(var2, var3);
   }

   public void setAlpha(int var1) {
      this.c.setAlpha(var1);
   }

   public void setChangingConfigurations(int var1) {
      this.c.setChangingConfigurations(var1);
   }

   public void setColorFilter(ColorFilter var1) {
      this.c.setColorFilter(var1);
   }

   public void setDither(boolean var1) {
      this.c.setDither(var1);
   }

   public void setFilterBitmap(boolean var1) {
      this.c.setFilterBitmap(var1);
   }

   public boolean setState(int[] var1) {
      boolean var2 = this.c.setState(var1);
      if (!this.a(var1) && !var2) {
         var2 = false;
      } else {
         var2 = true;
      }

      return var2;
   }

   @Override
   public void setTint(int var1) {
      this.setTintList(ColorStateList.valueOf(var1));
   }

   @Override
   public void setTintList(ColorStateList var1) {
      this.b.c = var1;
      this.a(this.getState());
   }

   @Override
   public void setTintMode(Mode var1) {
      this.b.d = var1;
      this.a(this.getState());
   }

   public boolean setVisible(boolean var1, boolean var2) {
      if (!super.setVisible(var1, var2) && !this.c.setVisible(var1, var2)) {
         var1 = false;
      } else {
         var1 = true;
      }

      return var1;
   }

   public void unscheduleDrawable(Drawable var1, Runnable var2) {
      this.unscheduleSelf(var2);
   }

   protected abstract static class DrawableWrapperState extends ConstantState {
      int a;
      ConstantState b;
      ColorStateList c = null;
      Mode d = WrappedDrawableApi14.a;

      DrawableWrapperState(WrappedDrawableApi14.DrawableWrapperState var1, Resources var2) {
         if (var1 != null) {
            this.a = var1.a;
            this.b = var1.b;
            this.c = var1.c;
            this.d = var1.d;
         }
      }

      boolean a() {
         boolean var1;
         if (this.b != null) {
            var1 = true;
         } else {
            var1 = false;
         }

         return var1;
      }

      public int getChangingConfigurations() {
         int var2 = this.a;
         int var1;
         if (this.b != null) {
            var1 = this.b.getChangingConfigurations();
         } else {
            var1 = 0;
         }

         return var1 | var2;
      }

      public Drawable newDrawable() {
         return this.newDrawable(null);
      }

      public abstract Drawable newDrawable(Resources var1);
   }

   private static class DrawableWrapperStateBase extends WrappedDrawableApi14.DrawableWrapperState {
      DrawableWrapperStateBase(WrappedDrawableApi14.DrawableWrapperState var1, Resources var2) {
         super(var1, var2);
      }

      @Override
      public Drawable newDrawable(Resources var1) {
         return new WrappedDrawableApi14(this, var1);
      }
   }
}
