package android.support.graphics.drawable;

import android.content.res.Resources.Theme;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.graphics.drawable.TintAwareDrawable;

abstract class VectorDrawableCommon extends Drawable implements TintAwareDrawable {
   Drawable b;

   public void applyTheme(Theme var1) {
      if (this.b != null) {
         DrawableCompat.a(this.b, var1);
      }
   }

   public void clearColorFilter() {
      if (this.b != null) {
         this.b.clearColorFilter();
      } else {
         super.clearColorFilter();
      }
   }

   public ColorFilter getColorFilter() {
      ColorFilter var1;
      if (this.b != null) {
         var1 = DrawableCompat.e(this.b);
      } else {
         var1 = null;
      }

      return var1;
   }

   public Drawable getCurrent() {
      Drawable var1;
      if (this.b != null) {
         var1 = this.b.getCurrent();
      } else {
         var1 = super.getCurrent();
      }

      return var1;
   }

   public int getMinimumHeight() {
      int var1;
      if (this.b != null) {
         var1 = this.b.getMinimumHeight();
      } else {
         var1 = super.getMinimumHeight();
      }

      return var1;
   }

   public int getMinimumWidth() {
      int var1;
      if (this.b != null) {
         var1 = this.b.getMinimumWidth();
      } else {
         var1 = super.getMinimumWidth();
      }

      return var1;
   }

   public boolean getPadding(Rect var1) {
      boolean var2;
      if (this.b != null) {
         var2 = this.b.getPadding(var1);
      } else {
         var2 = super.getPadding(var1);
      }

      return var2;
   }

   public int[] getState() {
      int[] var1;
      if (this.b != null) {
         var1 = this.b.getState();
      } else {
         var1 = super.getState();
      }

      return var1;
   }

   public Region getTransparentRegion() {
      Region var1;
      if (this.b != null) {
         var1 = this.b.getTransparentRegion();
      } else {
         var1 = super.getTransparentRegion();
      }

      return var1;
   }

   public void jumpToCurrentState() {
      if (this.b != null) {
         DrawableCompat.a(this.b);
      }
   }

   protected void onBoundsChange(Rect var1) {
      if (this.b != null) {
         this.b.setBounds(var1);
      } else {
         super.onBoundsChange(var1);
      }
   }

   protected boolean onLevelChange(int var1) {
      boolean var2;
      if (this.b != null) {
         var2 = this.b.setLevel(var1);
      } else {
         var2 = super.onLevelChange(var1);
      }

      return var2;
   }

   public void setChangingConfigurations(int var1) {
      if (this.b != null) {
         this.b.setChangingConfigurations(var1);
      } else {
         super.setChangingConfigurations(var1);
      }
   }

   public void setColorFilter(int var1, Mode var2) {
      if (this.b != null) {
         this.b.setColorFilter(var1, var2);
      } else {
         super.setColorFilter(var1, var2);
      }
   }

   public void setFilterBitmap(boolean var1) {
      if (this.b != null) {
         this.b.setFilterBitmap(var1);
      }
   }

   public void setHotspot(float var1, float var2) {
      if (this.b != null) {
         DrawableCompat.a(this.b, var1, var2);
      }
   }

   public void setHotspotBounds(int var1, int var2, int var3, int var4) {
      if (this.b != null) {
         DrawableCompat.a(this.b, var1, var2, var3, var4);
      }
   }

   public boolean setState(int[] var1) {
      boolean var2;
      if (this.b != null) {
         var2 = this.b.setState(var1);
      } else {
         var2 = super.setState(var1);
      }

      return var2;
   }
}
