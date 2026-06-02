package android.support.v7.graphics.drawable;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.support.v4.graphics.drawable.DrawableCompat;

public class DrawableWrapper extends Drawable implements Callback {
   private Drawable a;

   public DrawableWrapper(Drawable var1) {
      this.a(var1);
   }

   public void a(Drawable var1) {
      if (this.a != null) {
         this.a.setCallback(null);
      }

      this.a = var1;
      if (var1 != null) {
         var1.setCallback(this);
      }
   }

   public Drawable b() {
      return this.a;
   }

   public void draw(Canvas var1) {
      this.a.draw(var1);
   }

   public int getChangingConfigurations() {
      return this.a.getChangingConfigurations();
   }

   public Drawable getCurrent() {
      return this.a.getCurrent();
   }

   public int getIntrinsicHeight() {
      return this.a.getIntrinsicHeight();
   }

   public int getIntrinsicWidth() {
      return this.a.getIntrinsicWidth();
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

   public int[] getState() {
      return this.a.getState();
   }

   public Region getTransparentRegion() {
      return this.a.getTransparentRegion();
   }

   public void invalidateDrawable(Drawable var1) {
      this.invalidateSelf();
   }

   public boolean isAutoMirrored() {
      return DrawableCompat.b(this.a);
   }

   public boolean isStateful() {
      return this.a.isStateful();
   }

   public void jumpToCurrentState() {
      DrawableCompat.a(this.a);
   }

   protected void onBoundsChange(Rect var1) {
      this.a.setBounds(var1);
   }

   protected boolean onLevelChange(int var1) {
      return this.a.setLevel(var1);
   }

   public void scheduleDrawable(Drawable var1, Runnable var2, long var3) {
      this.scheduleSelf(var2, var3);
   }

   public void setAlpha(int var1) {
      this.a.setAlpha(var1);
   }

   public void setAutoMirrored(boolean var1) {
      DrawableCompat.a(this.a, var1);
   }

   public void setChangingConfigurations(int var1) {
      this.a.setChangingConfigurations(var1);
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

   public void setHotspot(float var1, float var2) {
      DrawableCompat.a(this.a, var1, var2);
   }

   public void setHotspotBounds(int var1, int var2, int var3, int var4) {
      DrawableCompat.a(this.a, var1, var2, var3, var4);
   }

   public boolean setState(int[] var1) {
      return this.a.setState(var1);
   }

   public void setTint(int var1) {
      DrawableCompat.a(this.a, var1);
   }

   public void setTintList(ColorStateList var1) {
      DrawableCompat.a(this.a, var1);
   }

   public void setTintMode(Mode var1) {
      DrawableCompat.a(this.a, var1);
   }

   public boolean setVisible(boolean var1, boolean var2) {
      if (!super.setVisible(var1, var2) && !this.a.setVisible(var1, var2)) {
         var1 = false;
      } else {
         var1 = true;
      }

      return var1;
   }

   public void unscheduleDrawable(Drawable var1, Runnable var2) {
      this.unscheduleSelf(var2);
   }
}
