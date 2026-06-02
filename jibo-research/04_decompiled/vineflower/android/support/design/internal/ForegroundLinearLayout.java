package android.support.design.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.design.R;
import android.support.v7.widget.LinearLayoutCompat;
import android.util.AttributeSet;
import android.view.Gravity;

public class ForegroundLinearLayout extends LinearLayoutCompat {
   protected boolean a;
   boolean b;
   private Drawable c;
   private final Rect d = new Rect();
   private final Rect e = new Rect();
   private int f = 119;

   public ForegroundLinearLayout(Context var1) {
      this(var1, null);
   }

   public ForegroundLinearLayout(Context var1, AttributeSet var2) {
      this(var1, var2, 0);
   }

   public ForegroundLinearLayout(Context var1, AttributeSet var2, int var3) {
      super(var1, var2, var3);
      this.a = true;
      this.b = false;
      TypedArray var4 = var1.obtainStyledAttributes(var2, R.styleable.ForegroundLinearLayout, var3, 0);
      this.f = var4.getInt(R.styleable.ForegroundLinearLayout_android_foregroundGravity, this.f);
      Drawable var5 = var4.getDrawable(R.styleable.ForegroundLinearLayout_android_foreground);
      if (var5 != null) {
         this.setForeground(var5);
      }

      this.a = var4.getBoolean(R.styleable.ForegroundLinearLayout_foregroundInsidePadding, true);
      var4.recycle();
   }

   public void draw(Canvas var1) {
      super.draw(var1);
      if (this.c != null) {
         Drawable var5 = this.c;
         if (this.b) {
            this.b = false;
            Rect var6 = this.d;
            Rect var4 = this.e;
            int var3 = this.getRight() - this.getLeft();
            int var2 = this.getBottom() - this.getTop();
            if (this.a) {
               var6.set(0, 0, var3, var2);
            } else {
               var6.set(this.getPaddingLeft(), this.getPaddingTop(), var3 - this.getPaddingRight(), var2 - this.getPaddingBottom());
            }

            Gravity.apply(this.f, var5.getIntrinsicWidth(), var5.getIntrinsicHeight(), var6, var4);
            var5.setBounds(var4);
         }

         var5.draw(var1);
      }
   }

   public void drawableHotspotChanged(float var1, float var2) {
      super.drawableHotspotChanged(var1, var2);
      if (this.c != null) {
         this.c.setHotspot(var1, var2);
      }
   }

   protected void drawableStateChanged() {
      super.drawableStateChanged();
      if (this.c != null && this.c.isStateful()) {
         this.c.setState(this.getDrawableState());
      }
   }

   public Drawable getForeground() {
      return this.c;
   }

   public int getForegroundGravity() {
      return this.f;
   }

   public void jumpDrawablesToCurrentState() {
      super.jumpDrawablesToCurrentState();
      if (this.c != null) {
         this.c.jumpToCurrentState();
      }
   }

   @Override
   protected void onLayout(boolean var1, int var2, int var3, int var4, int var5) {
      super.onLayout(var1, var2, var3, var4, var5);
      this.b |= var1;
   }

   protected void onSizeChanged(int var1, int var2, int var3, int var4) {
      super.onSizeChanged(var1, var2, var3, var4);
      this.b = true;
   }

   public void setForeground(Drawable var1) {
      if (this.c != var1) {
         if (this.c != null) {
            this.c.setCallback(null);
            this.unscheduleDrawable(this.c);
         }

         this.c = var1;
         if (var1 != null) {
            this.setWillNotDraw(false);
            var1.setCallback(this);
            if (var1.isStateful()) {
               var1.setState(this.getDrawableState());
            }

            if (this.f == 119) {
               var1.getPadding(new Rect());
            }
         } else {
            this.setWillNotDraw(true);
         }

         this.requestLayout();
         this.invalidate();
      }
   }

   public void setForegroundGravity(int var1) {
      if (this.f != var1) {
         if ((8388615 & var1) == 0) {
            var1 |= 8388611;
         }

         int var2 = var1;
         if ((var1 & 112) == 0) {
            var2 = var1 | 48;
         }

         this.f = var2;
         if (this.f == 119 && this.c != null) {
            Rect var3 = new Rect();
            this.c.getPadding(var3);
         }

         this.requestLayout();
      }
   }

   protected boolean verifyDrawable(Drawable var1) {
      boolean var2;
      if (!super.verifyDrawable(var1) && var1 != this.c) {
         var2 = false;
      } else {
         var2 = true;
      }

      return var2;
   }
}
