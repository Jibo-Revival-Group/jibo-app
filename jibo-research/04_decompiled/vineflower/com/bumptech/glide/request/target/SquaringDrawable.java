package com.bumptech.glide.request.target;

import android.annotation.TargetApi;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.Drawable.ConstantState;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;

public class SquaringDrawable extends GlideDrawable {
   private GlideDrawable a;
   private SquaringDrawable.State b;
   private boolean c;

   public SquaringDrawable(GlideDrawable var1, int var2) {
      this(new SquaringDrawable.State(var1.getConstantState(), var2), var1, null);
   }

   SquaringDrawable(SquaringDrawable.State var1, GlideDrawable var2, Resources var3) {
      this.b = var1;
      if (var2 == null) {
         if (var3 != null) {
            this.a = (GlideDrawable)var1.a.newDrawable(var3);
         } else {
            this.a = (GlideDrawable)var1.a.newDrawable();
         }
      } else {
         this.a = var2;
      }
   }

   public void clearColorFilter() {
      this.a.clearColorFilter();
   }

   public void draw(Canvas var1) {
      this.a.draw(var1);
   }

   @TargetApi(19)
   public int getAlpha() {
      return this.a.getAlpha();
   }

   @TargetApi(11)
   public Callback getCallback() {
      return this.a.getCallback();
   }

   public int getChangingConfigurations() {
      return this.a.getChangingConfigurations();
   }

   public ConstantState getConstantState() {
      return this.b;
   }

   public Drawable getCurrent() {
      return this.a.getCurrent();
   }

   public int getIntrinsicHeight() {
      return this.b.b;
   }

   public int getIntrinsicWidth() {
      return this.b.b;
   }

   public int getMinimumHeight() {
      return this.a.getMinimumHeight();
   }

   public int getMinimumWidth() {
      return this.a.getMinimumWidth();
   }

   public int getOpacity() {
      return this.a.getOpacity();
   }

   public boolean getPadding(Rect var1) {
      return this.a.getPadding(var1);
   }

   public void invalidateSelf() {
      super.invalidateSelf();
      this.a.invalidateSelf();
   }

   @Override
   public boolean isAnimated() {
      return this.a.isAnimated();
   }

   public boolean isRunning() {
      return this.a.isRunning();
   }

   public Drawable mutate() {
      if (!this.c && super.mutate() == this) {
         this.a = (GlideDrawable)this.a.mutate();
         this.b = new SquaringDrawable.State(this.b);
         this.c = true;
      }

      return this;
   }

   public void scheduleSelf(Runnable var1, long var2) {
      super.scheduleSelf(var1, var2);
      this.a.scheduleSelf(var1, var2);
   }

   public void setAlpha(int var1) {
      this.a.setAlpha(var1);
   }

   public void setBounds(int var1, int var2, int var3, int var4) {
      super.setBounds(var1, var2, var3, var4);
      this.a.setBounds(var1, var2, var3, var4);
   }

   public void setBounds(Rect var1) {
      super.setBounds(var1);
      this.a.setBounds(var1);
   }

   public void setChangingConfigurations(int var1) {
      this.a.setChangingConfigurations(var1);
   }

   public void setColorFilter(int var1, Mode var2) {
      this.a.setColorFilter(var1, var2);
   }

   public void setColorFilter(ColorFilter var1) {
      this.a.setColorFilter(var1);
   }

   public void setDither(boolean var1) {
      this.a.setDither(var1);
   }

   public void setFilterBitmap(boolean var1) {
      this.a.setFilterBitmap(var1);
   }

   @Override
   public void setLoopCount(int var1) {
      this.a.setLoopCount(var1);
   }

   public boolean setVisible(boolean var1, boolean var2) {
      return this.a.setVisible(var1, var2);
   }

   public void start() {
      this.a.start();
   }

   public void stop() {
      this.a.stop();
   }

   public void unscheduleSelf(Runnable var1) {
      super.unscheduleSelf(var1);
      this.a.unscheduleSelf(var1);
   }

   static class State extends ConstantState {
      private final ConstantState a;
      private final int b;

      State(ConstantState var1, int var2) {
         this.a = var1;
         this.b = var2;
      }

      State(SquaringDrawable.State var1) {
         this(var1.a, var1.b);
      }

      public int getChangingConfigurations() {
         return 0;
      }

      public Drawable newDrawable() {
         return this.newDrawable(null);
      }

      public Drawable newDrawable(Resources var1) {
         return new SquaringDrawable(this, null, var1);
      }
   }
}
