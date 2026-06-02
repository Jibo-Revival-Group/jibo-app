package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v4.view.ViewPropertyAnimatorListener;
import android.support.v7.appcompat.R;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.MeasureSpec;

abstract class AbsActionBarView extends ViewGroup {
   protected final AbsActionBarView.VisibilityAnimListener a = new AbsActionBarView.VisibilityAnimListener(this);
   protected final Context b;
   protected ActionMenuView c;
   protected ActionMenuPresenter d;
   protected int e;
   protected ViewPropertyAnimatorCompat f;
   private boolean g;
   private boolean h;

   AbsActionBarView(Context var1) {
      this(var1, null);
   }

   AbsActionBarView(Context var1, AttributeSet var2) {
      this(var1, var2, 0);
   }

   AbsActionBarView(Context var1, AttributeSet var2, int var3) {
      super(var1, var2, var3);
      TypedValue var4 = new TypedValue();
      if (var1.getTheme().resolveAttribute(R.attr.actionBarPopupTheme, var4, true) && var4.resourceId != 0) {
         this.b = new ContextThemeWrapper(var1, var4.resourceId);
      } else {
         this.b = var1;
      }
   }

   protected static int a(int var0, int var1, boolean var2) {
      if (var2) {
         var0 -= var1;
      } else {
         var0 += var1;
      }

      return var0;
   }

   protected int a(View var1, int var2, int var3, int var4) {
      var1.measure(MeasureSpec.makeMeasureSpec(var2, Integer.MIN_VALUE), var3);
      return Math.max(0, var2 - var1.getMeasuredWidth() - var4);
   }

   protected int a(View var1, int var2, int var3, int var4, boolean var5) {
      int var6 = var1.getMeasuredWidth();
      int var7 = var1.getMeasuredHeight();
      var3 = (var4 - var7) / 2 + var3;
      if (var5) {
         var1.layout(var2 - var6, var3, var2, var7 + var3);
      } else {
         var1.layout(var2, var3, var2 + var6, var7 + var3);
      }

      var2 = var6;
      if (var5) {
         var2 = -var6;
      }

      return var2;
   }

   public ViewPropertyAnimatorCompat a(int var1, long var2) {
      if (this.f != null) {
         this.f.b();
      }

      ViewPropertyAnimatorCompat var4;
      if (var1 == 0) {
         if (this.getVisibility() != 0) {
            this.setAlpha(0.0F);
         }

         var4 = ViewCompat.l(this).a(1.0F);
         var4.a(var2);
         var4.a(this.a.a(var4, var1));
      } else {
         var4 = ViewCompat.l(this).a(0.0F);
         var4.a(var2);
         var4.a(this.a.a(var4, var1));
      }

      return var4;
   }

   public boolean a() {
      boolean var1;
      if (this.d != null) {
         var1 = this.d.f();
      } else {
         var1 = false;
      }

      return var1;
   }

   public int getAnimatedVisibility() {
      int var1;
      if (this.f != null) {
         var1 = this.a.a;
      } else {
         var1 = this.getVisibility();
      }

      return var1;
   }

   public int getContentHeight() {
      return this.e;
   }

   protected void onConfigurationChanged(Configuration var1) {
      super.onConfigurationChanged(var1);
      TypedArray var2 = this.getContext().obtainStyledAttributes(null, R.styleable.ActionBar, R.attr.actionBarStyle, 0);
      this.setContentHeight(var2.getLayoutDimension(R.styleable.ActionBar_height, 0));
      var2.recycle();
      if (this.d != null) {
         this.d.a(var1);
      }
   }

   public boolean onHoverEvent(MotionEvent var1) {
      int var2 = var1.getActionMasked();
      if (var2 == 9) {
         this.h = false;
      }

      if (!this.h) {
         boolean var3 = super.onHoverEvent(var1);
         if (var2 == 9 && !var3) {
            this.h = true;
         }
      }

      if (var2 == 10 || var2 == 3) {
         this.h = false;
      }

      return true;
   }

   public boolean onTouchEvent(MotionEvent var1) {
      int var2 = var1.getActionMasked();
      if (var2 == 0) {
         this.g = false;
      }

      if (!this.g) {
         boolean var3 = super.onTouchEvent(var1);
         if (var2 == 0 && !var3) {
            this.g = true;
         }
      }

      if (var2 == 1 || var2 == 3) {
         this.g = false;
      }

      return true;
   }

   public void setContentHeight(int var1) {
      this.e = var1;
      this.requestLayout();
   }

   public void setVisibility(int var1) {
      if (var1 != this.getVisibility()) {
         if (this.f != null) {
            this.f.b();
         }

         super.setVisibility(var1);
      }
   }

   protected class VisibilityAnimListener implements ViewPropertyAnimatorListener {
      int a;
      final AbsActionBarView b;
      private boolean c;

      protected VisibilityAnimListener(AbsActionBarView var1) {
         this.b = var1;
         this.c = false;
      }

      public AbsActionBarView.VisibilityAnimListener a(ViewPropertyAnimatorCompat var1, int var2) {
         this.b.f = var1;
         this.a = var2;
         return this;
      }

      @Override
      public void a(View var1) {
         this.b.setVisibility(0);
         this.c = false;
      }

      @Override
      public void b(View var1) {
         if (!this.c) {
            this.b.f = null;
            this.b.setVisibility(this.a);
         }
      }

      @Override
      public void c(View var1) {
         this.c = true;
      }
   }
}
