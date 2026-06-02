package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.view.ViewCompat;
import android.support.v7.appcompat.R;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.View;
import android.view.ActionMode.Callback;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;

public class ActionBarContainer extends FrameLayout {
   Drawable a;
   Drawable b;
   Drawable c;
   boolean d;
   boolean e;
   private boolean f;
   private View g;
   private View h;
   private View i;
   private int j;

   public ActionBarContainer(Context var1) {
      this(var1, null);
   }

   public ActionBarContainer(Context var1, AttributeSet var2) {
      super(var1, var2);
      ActionBarBackgroundDrawable var4;
      if (VERSION.SDK_INT >= 21) {
         var4 = new ActionBarBackgroundDrawableV21(this);
      } else {
         var4 = new ActionBarBackgroundDrawable(this);
      }

      ViewCompat.a(this, var4);
      TypedArray var5 = var1.obtainStyledAttributes(var2, R.styleable.ActionBar);
      this.a = var5.getDrawable(R.styleable.ActionBar_background);
      this.b = var5.getDrawable(R.styleable.ActionBar_backgroundStacked);
      this.j = var5.getDimensionPixelSize(R.styleable.ActionBar_height, -1);
      if (this.getId() == R.id.split_action_bar) {
         this.d = true;
         this.c = var5.getDrawable(R.styleable.ActionBar_backgroundSplit);
      }

      var5.recycle();
      boolean var3;
      if (this.d) {
         if (this.c == null) {
            var3 = true;
         } else {
            var3 = false;
         }
      } else if (this.a == null && this.b == null) {
         var3 = true;
      } else {
         var3 = false;
      }

      this.setWillNotDraw(var3);
   }

   private boolean a(View var1) {
      boolean var2;
      if (var1 != null && var1.getVisibility() != 8 && var1.getMeasuredHeight() != 0) {
         var2 = false;
      } else {
         var2 = true;
      }

      return var2;
   }

   private int b(View var1) {
      LayoutParams var4 = (LayoutParams)var1.getLayoutParams();
      int var2 = var1.getMeasuredHeight();
      int var3 = var4.topMargin;
      return var4.bottomMargin + var2 + var3;
   }

   protected void drawableStateChanged() {
      super.drawableStateChanged();
      if (this.a != null && this.a.isStateful()) {
         this.a.setState(this.getDrawableState());
      }

      if (this.b != null && this.b.isStateful()) {
         this.b.setState(this.getDrawableState());
      }

      if (this.c != null && this.c.isStateful()) {
         this.c.setState(this.getDrawableState());
      }
   }

   public View getTabContainer() {
      return this.g;
   }

   public void jumpDrawablesToCurrentState() {
      super.jumpDrawablesToCurrentState();
      if (this.a != null) {
         this.a.jumpToCurrentState();
      }

      if (this.b != null) {
         this.b.jumpToCurrentState();
      }

      if (this.c != null) {
         this.c.jumpToCurrentState();
      }
   }

   public void onFinishInflate() {
      super.onFinishInflate();
      this.h = this.findViewById(R.id.action_bar);
      this.i = this.findViewById(R.id.action_context_bar);
   }

   public boolean onHoverEvent(MotionEvent var1) {
      super.onHoverEvent(var1);
      return true;
   }

   public boolean onInterceptTouchEvent(MotionEvent var1) {
      boolean var2;
      if (!this.f && !super.onInterceptTouchEvent(var1)) {
         var2 = false;
      } else {
         var2 = true;
      }

      return var2;
   }

   public void onLayout(boolean var1, int var2, int var3, int var4, int var5) {
      boolean var6 = true;
      super.onLayout(var1, var2, var3, var4, var5);
      View var7 = this.g;
      if (var7 != null && var7.getVisibility() != 8) {
         var1 = true;
      } else {
         var1 = false;
      }

      if (var7 != null && var7.getVisibility() != 8) {
         var3 = this.getMeasuredHeight();
         LayoutParams var8 = (LayoutParams)var7.getLayoutParams();
         var7.layout(var2, var3 - var7.getMeasuredHeight() - var8.bottomMargin, var4, var3 - var8.bottomMargin);
      }

      boolean var10;
      if (this.d) {
         if (this.c != null) {
            this.c.setBounds(0, 0, this.getMeasuredWidth(), this.getMeasuredHeight());
            var10 = var6;
         } else {
            var10 = false;
         }
      } else {
         if (this.a == null) {
            var10 = false;
         } else {
            if (this.h.getVisibility() == 0) {
               this.a.setBounds(this.h.getLeft(), this.h.getTop(), this.h.getRight(), this.h.getBottom());
            } else if (this.i != null && this.i.getVisibility() == 0) {
               this.a.setBounds(this.i.getLeft(), this.i.getTop(), this.i.getRight(), this.i.getBottom());
            } else {
               this.a.setBounds(0, 0, 0, 0);
            }

            var10 = true;
         }

         this.e = var1;
         if (var1 && this.b != null) {
            this.b.setBounds(var7.getLeft(), var7.getTop(), var7.getRight(), var7.getBottom());
            var10 = var6;
         }
      }

      if (var10) {
         this.invalidate();
      }
   }

   public void onMeasure(int var1, int var2) {
      int var3 = var2;
      if (this.h == null) {
         var3 = var2;
         if (MeasureSpec.getMode(var2) == Integer.MIN_VALUE) {
            var3 = var2;
            if (this.j >= 0) {
               var3 = MeasureSpec.makeMeasureSpec(Math.min(this.j, MeasureSpec.getSize(var2)), Integer.MIN_VALUE);
            }
         }
      }

      super.onMeasure(var1, var3);
      if (this.h != null) {
         var2 = MeasureSpec.getMode(var3);
         if (this.g != null && this.g.getVisibility() != 8 && var2 != 1073741824) {
            if (!this.a(this.h)) {
               var1 = this.b(this.h);
            } else if (!this.a(this.i)) {
               var1 = this.b(this.i);
            } else {
               var1 = 0;
            }

            if (var2 == Integer.MIN_VALUE) {
               var2 = MeasureSpec.getSize(var3);
            } else {
               var2 = Integer.MAX_VALUE;
            }

            this.setMeasuredDimension(this.getMeasuredWidth(), Math.min(var1 + this.b(this.g), var2));
         }
      }
   }

   public boolean onTouchEvent(MotionEvent var1) {
      super.onTouchEvent(var1);
      return true;
   }

   public void setPrimaryBackground(Drawable var1) {
      boolean var2 = true;
      if (this.a != null) {
         this.a.setCallback(null);
         this.unscheduleDrawable(this.a);
      }

      this.a = var1;
      if (var1 != null) {
         var1.setCallback(this);
         if (this.h != null) {
            this.a.setBounds(this.h.getLeft(), this.h.getTop(), this.h.getRight(), this.h.getBottom());
         }
      }

      if (this.d) {
         if (this.c != null) {
            var2 = false;
         }
      } else if (this.a != null || this.b != null) {
         var2 = false;
      }

      this.setWillNotDraw(var2);
      this.invalidate();
   }

   public void setSplitBackground(Drawable var1) {
      boolean var2 = true;
      if (this.c != null) {
         this.c.setCallback(null);
         this.unscheduleDrawable(this.c);
      }

      this.c = var1;
      if (var1 != null) {
         var1.setCallback(this);
         if (this.d && this.c != null) {
            this.c.setBounds(0, 0, this.getMeasuredWidth(), this.getMeasuredHeight());
         }
      }

      if (this.d) {
         if (this.c != null) {
            var2 = false;
         }
      } else if (this.a != null || this.b != null) {
         var2 = false;
      }

      this.setWillNotDraw(var2);
      this.invalidate();
   }

   public void setStackedBackground(Drawable var1) {
      boolean var2 = true;
      if (this.b != null) {
         this.b.setCallback(null);
         this.unscheduleDrawable(this.b);
      }

      this.b = var1;
      if (var1 != null) {
         var1.setCallback(this);
         if (this.e && this.b != null) {
            this.b.setBounds(this.g.getLeft(), this.g.getTop(), this.g.getRight(), this.g.getBottom());
         }
      }

      if (this.d) {
         if (this.c != null) {
            var2 = false;
         }
      } else if (this.a != null || this.b != null) {
         var2 = false;
      }

      this.setWillNotDraw(var2);
      this.invalidate();
   }

   public void setTabContainer(ScrollingTabContainerView var1) {
      if (this.g != null) {
         this.removeView(this.g);
      }

      this.g = var1;
      if (var1 != null) {
         this.addView(var1);
         android.view.ViewGroup.LayoutParams var2 = var1.getLayoutParams();
         var2.width = -1;
         var2.height = -2;
         var1.setAllowCollapse(false);
      }
   }

   public void setTransitioning(boolean var1) {
      this.f = var1;
      int var2;
      if (var1) {
         var2 = 393216;
      } else {
         var2 = 262144;
      }

      this.setDescendantFocusability(var2);
   }

   public void setVisibility(int var1) {
      super.setVisibility(var1);
      boolean var2;
      if (var1 == 0) {
         var2 = true;
      } else {
         var2 = false;
      }

      if (this.a != null) {
         this.a.setVisible(var2, false);
      }

      if (this.b != null) {
         this.b.setVisible(var2, false);
      }

      if (this.c != null) {
         this.c.setVisible(var2, false);
      }
   }

   public ActionMode startActionModeForChild(View var1, Callback var2) {
      return null;
   }

   public ActionMode startActionModeForChild(View var1, Callback var2, int var3) {
      ActionMode var4;
      if (var3 != 0) {
         var4 = super.startActionModeForChild(var1, var2, var3);
      } else {
         var4 = null;
      }

      return var4;
   }

   protected boolean verifyDrawable(Drawable var1) {
      boolean var2;
      if ((var1 != this.a || this.d) && (var1 != this.b || !this.e) && (var1 != this.c || !this.d) && !super.verifyDrawable(var1)) {
         var2 = false;
      } else {
         var2 = true;
      }

      return var2;
   }
}
