package android.support.design.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.design.R;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.ViewGroupUtils;
import android.support.v7.widget.AppCompatImageHelper;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import java.util.List;

@CoordinatorLayout.DefaultBehavior(a = FloatingActionButton.Behavior.class)
public class FloatingActionButton extends VisibilityAwareImageButton {
   int a;
   boolean b;
   final Rect c = new Rect();
   private ColorStateList d;
   private Mode e;
   private int f;
   private int g;
   private int h;
   private int i;
   private int j;
   private final Rect k = new Rect();
   private AppCompatImageHelper l;
   private FloatingActionButtonImpl m;

   public FloatingActionButton(Context var1) {
      this(var1, null);
   }

   public FloatingActionButton(Context var1, AttributeSet var2) {
      this(var1, var2, 0);
   }

   public FloatingActionButton(Context var1, AttributeSet var2, int var3) {
      super(var1, var2, var3);
      ThemeUtils.a(var1);
      TypedArray var6 = var1.obtainStyledAttributes(var2, R.styleable.FloatingActionButton, var3, R.style.Widget_Design_FloatingActionButton);
      this.d = var6.getColorStateList(R.styleable.FloatingActionButton_backgroundTint);
      this.e = ViewUtils.a(var6.getInt(R.styleable.FloatingActionButton_backgroundTintMode, -1), null);
      this.g = var6.getColor(R.styleable.FloatingActionButton_rippleColor, 0);
      this.h = var6.getInt(R.styleable.FloatingActionButton_fabSize, -1);
      this.i = var6.getDimensionPixelSize(R.styleable.FloatingActionButton_fabCustomSize, 0);
      this.f = var6.getDimensionPixelSize(R.styleable.FloatingActionButton_borderWidth, 0);
      float var4 = var6.getDimension(R.styleable.FloatingActionButton_elevation, 0.0F);
      float var5 = var6.getDimension(R.styleable.FloatingActionButton_pressedTranslationZ, 0.0F);
      this.b = var6.getBoolean(R.styleable.FloatingActionButton_useCompatPadding, false);
      var6.recycle();
      this.l = new AppCompatImageHelper(this);
      this.l.a(var2, var3);
      this.j = (int)this.getResources().getDimension(R.dimen.design_fab_image_size);
      this.getImpl().a(this.d, this.e, this.g, this.f);
      this.getImpl().a(var4);
      this.getImpl().b(var5);
   }

   private int a(int var1) {
      Resources var2 = this.getResources();
      if (this.i != 0) {
         var1 = this.i;
      } else {
         switch (var1) {
            case -1:
               if (Math.max(var2.getConfiguration().screenWidthDp, var2.getConfiguration().screenHeightDp) < 470) {
                  var1 = this.a(1);
               } else {
                  var1 = this.a(0);
               }
               break;
            case 0:
            default:
               var1 = var2.getDimensionPixelSize(R.dimen.design_fab_size_normal);
               break;
            case 1:
               var1 = var2.getDimensionPixelSize(R.dimen.design_fab_size_mini);
         }
      }

      return var1;
   }

   private static int a(int var0, int var1) {
      int var3 = MeasureSpec.getMode(var1);
      int var2 = MeasureSpec.getSize(var1);
      var1 = var0;
      switch (var3) {
         case Integer.MIN_VALUE:
            var1 = Math.min(var0, var2);
         case 0:
            break;
         case 1073741824:
            var1 = var2;
            break;
         default:
            var1 = var0;
      }

      return var1;
   }

   private FloatingActionButtonImpl.InternalVisibilityChangedListener c(FloatingActionButton.OnVisibilityChangedListener var1) {
      FloatingActionButtonImpl.InternalVisibilityChangedListener var2;
      if (var1 == null) {
         var2 = null;
      } else {
         var2 = new FloatingActionButtonImpl.InternalVisibilityChangedListener(this, var1) {
            final FloatingActionButton.OnVisibilityChangedListener a;
            final FloatingActionButton b;

            {
               this.b = var1;
               this.a = var2x;
            }

            @Override
            public void a() {
               this.a.a(this.b);
            }

            @Override
            public void b() {
               this.a.b(this.b);
            }
         };
      }

      return var2;
   }

   private FloatingActionButtonImpl c() {
      FloatingActionButtonImpl var1;
      if (VERSION.SDK_INT >= 21) {
         var1 = new FloatingActionButtonLollipop(this, new FloatingActionButton.ShadowDelegateImpl(this));
      } else {
         var1 = new FloatingActionButtonImpl(this, new FloatingActionButton.ShadowDelegateImpl(this));
      }

      return var1;
   }

   private FloatingActionButtonImpl getImpl() {
      if (this.m == null) {
         this.m = this.c();
      }

      return this.m;
   }

   public void a() {
      this.a((FloatingActionButton.OnVisibilityChangedListener)null);
   }

   public void a(FloatingActionButton.OnVisibilityChangedListener var1) {
      this.a(var1, true);
   }

   void a(FloatingActionButton.OnVisibilityChangedListener var1, boolean var2) {
      this.getImpl().b(this.c(var1), var2);
   }

   public boolean a(Rect var1) {
      boolean var2 = false;
      if (ViewCompat.y(this)) {
         var1.set(0, 0, this.getWidth(), this.getHeight());
         var1.left = var1.left + this.c.left;
         var1.top = var1.top + this.c.top;
         var1.right = var1.right - this.c.right;
         var1.bottom = var1.bottom - this.c.bottom;
         var2 = true;
      }

      return var2;
   }

   public void b() {
      this.b(null);
   }

   public void b(FloatingActionButton.OnVisibilityChangedListener var1) {
      this.b(var1, true);
   }

   void b(FloatingActionButton.OnVisibilityChangedListener var1, boolean var2) {
      this.getImpl().a(this.c(var1), var2);
   }

   protected void drawableStateChanged() {
      super.drawableStateChanged();
      this.getImpl().a(this.getDrawableState());
   }

   public ColorStateList getBackgroundTintList() {
      return this.d;
   }

   public Mode getBackgroundTintMode() {
      return this.e;
   }

   public float getCompatElevation() {
      return this.getImpl().a();
   }

   public Drawable getContentBackground() {
      return this.getImpl().c();
   }

   public int getCustomSize() {
      return this.i;
   }

   public int getRippleColor() {
      return this.g;
   }

   public int getSize() {
      return this.h;
   }

   int getSizeDimension() {
      return this.a(this.h);
   }

   public boolean getUseCompatPadding() {
      return this.b;
   }

   public void jumpDrawablesToCurrentState() {
      super.jumpDrawablesToCurrentState();
      this.getImpl().b();
   }

   protected void onAttachedToWindow() {
      super.onAttachedToWindow();
      this.getImpl().f();
   }

   protected void onDetachedFromWindow() {
      super.onDetachedFromWindow();
      this.getImpl().g();
   }

   protected void onMeasure(int var1, int var2) {
      int var3 = this.getSizeDimension();
      this.a = (var3 - this.j) / 2;
      this.getImpl().e();
      var1 = Math.min(a(var3, var1), a(var3, var2));
      this.setMeasuredDimension(this.c.left + var1 + this.c.right, var1 + this.c.top + this.c.bottom);
   }

   public boolean onTouchEvent(MotionEvent var1) {
      boolean var2;
      switch (var1.getAction()) {
         case 0:
            if (this.a(this.k) && !this.k.contains((int)var1.getX(), (int)var1.getY())) {
               var2 = false;
               break;
            }
         default:
            var2 = super.onTouchEvent(var1);
      }

      return var2;
   }

   public void setBackgroundColor(int var1) {
      Log.i("FloatingActionButton", "Setting a custom background is not supported.");
   }

   public void setBackgroundDrawable(Drawable var1) {
      Log.i("FloatingActionButton", "Setting a custom background is not supported.");
   }

   public void setBackgroundResource(int var1) {
      Log.i("FloatingActionButton", "Setting a custom background is not supported.");
   }

   public void setBackgroundTintList(ColorStateList var1) {
      if (this.d != var1) {
         this.d = var1;
         this.getImpl().a(var1);
      }
   }

   public void setBackgroundTintMode(Mode var1) {
      if (this.e != var1) {
         this.e = var1;
         this.getImpl().a(var1);
      }
   }

   public void setCompatElevation(float var1) {
      this.getImpl().a(var1);
   }

   public void setCustomSize(int var1) {
      if (var1 < 0) {
         throw new IllegalArgumentException("Custom size should be non-negative.");
      }

      this.i = var1;
   }

   public void setImageResource(int var1) {
      this.l.a(var1);
   }

   public void setRippleColor(int var1) {
      if (this.g != var1) {
         this.g = var1;
         this.getImpl().a(var1);
      }
   }

   public void setSize(int var1) {
      if (var1 != this.h) {
         this.h = var1;
         this.requestLayout();
      }
   }

   public void setUseCompatPadding(boolean var1) {
      if (this.b != var1) {
         this.b = var1;
         this.getImpl().d();
      }
   }

   public static class Behavior extends CoordinatorLayout.Behavior<FloatingActionButton> {
      private Rect a;
      private FloatingActionButton.OnVisibilityChangedListener b;
      private boolean c;

      public Behavior() {
         this.c = true;
      }

      public Behavior(Context var1, AttributeSet var2) {
         super(var1, var2);
         TypedArray var3 = var1.obtainStyledAttributes(var2, R.styleable.FloatingActionButton_Behavior_Layout);
         this.c = var3.getBoolean(R.styleable.FloatingActionButton_Behavior_Layout_behavior_autoHide, true);
         var3.recycle();
      }

      private void a(CoordinatorLayout var1, FloatingActionButton var2) {
         int var4 = 0;
         Rect var6 = var2.c;
         if (var6 != null && var6.centerX() > 0 && var6.centerY() > 0) {
            CoordinatorLayout.LayoutParams var5 = (CoordinatorLayout.LayoutParams)var2.getLayoutParams();
            int var3;
            if (var2.getRight() >= var1.getWidth() - var5.rightMargin) {
               var3 = var6.right;
            } else if (var2.getLeft() <= var5.leftMargin) {
               var3 = -var6.left;
            } else {
               var3 = 0;
            }

            if (var2.getBottom() >= var1.getHeight() - var5.bottomMargin) {
               var4 = var6.bottom;
            } else if (var2.getTop() <= var5.topMargin) {
               var4 = -var6.top;
            }

            if (var4 != 0) {
               ViewCompat.c(var2, var4);
            }

            if (var3 != 0) {
               ViewCompat.d(var2, var3);
            }
         }
      }

      private boolean a(CoordinatorLayout var1, AppBarLayout var2, FloatingActionButton var3) {
         boolean var4 = false;
         if (this.a(var2, var3)) {
            if (this.a == null) {
               this.a = new Rect();
            }

            Rect var5 = this.a;
            ViewGroupUtils.b(var1, var2, var5);
            if (var5.bottom <= var2.getMinimumHeightForVisibleOverlappingContent()) {
               var3.b(this.b, false);
            } else {
               var3.a(this.b, false);
            }

            var4 = true;
         }

         return var4;
      }

      private static boolean a(View var0) {
         LayoutParams var2 = var0.getLayoutParams();
         boolean var1;
         if (var2 instanceof CoordinatorLayout.LayoutParams) {
            var1 = ((CoordinatorLayout.LayoutParams)var2).b() instanceof BottomSheetBehavior;
         } else {
            var1 = false;
         }

         return var1;
      }

      private boolean a(View var1, FloatingActionButton var2) {
         CoordinatorLayout.LayoutParams var4 = (CoordinatorLayout.LayoutParams)var2.getLayoutParams();
         boolean var3;
         if (!this.c) {
            var3 = false;
         } else if (var4.a() != var1.getId()) {
            var3 = false;
         } else if (var2.getUserSetVisibility() != 0) {
            var3 = false;
         } else {
            var3 = true;
         }

         return var3;
      }

      private boolean b(View var1, FloatingActionButton var2) {
         boolean var5;
         if (!this.a(var1, var2)) {
            var5 = false;
         } else {
            CoordinatorLayout.LayoutParams var6 = (CoordinatorLayout.LayoutParams)var2.getLayoutParams();
            int var4 = var1.getTop();
            int var3 = var2.getHeight() / 2;
            if (var4 < var6.topMargin + var3) {
               var2.b(this.b, false);
            } else {
               var2.a(this.b, false);
            }

            var5 = true;
         }

         return var5;
      }

      @Override
      public void a(CoordinatorLayout.LayoutParams var1) {
         if (var1.h == 0) {
            var1.h = 80;
         }
      }

      public boolean a(CoordinatorLayout var1, FloatingActionButton var2, int var3) {
         List var7 = var1.c(var2);
         int var5 = var7.size();

         for (int var4 = 0; var4 < var5; var4++) {
            View var6 = (View)var7.get(var4);
            if (var6 instanceof AppBarLayout ? this.a(var1, (AppBarLayout)var6, var2) : a(var6) && this.b(var6, var2)) {
               break;
            }
         }

         var1.a(var2, var3);
         this.a(var1, var2);
         return true;
      }

      public boolean a(CoordinatorLayout var1, FloatingActionButton var2, Rect var3) {
         Rect var4 = var2.c;
         var3.set(var2.getLeft() + var4.left, var2.getTop() + var4.top, var2.getRight() - var4.right, var2.getBottom() - var4.bottom);
         return true;
      }

      public boolean a(CoordinatorLayout var1, FloatingActionButton var2, View var3) {
         if (var3 instanceof AppBarLayout) {
            this.a(var1, (AppBarLayout)var3, var2);
         } else if (a(var3)) {
            this.b(var3, var2);
         }

         return false;
      }
   }

   public abstract static class OnVisibilityChangedListener {
      public void a(FloatingActionButton var1) {
      }

      public void b(FloatingActionButton var1) {
      }
   }

   private class ShadowDelegateImpl implements ShadowViewDelegate {
      final FloatingActionButton a;

      ShadowDelegateImpl(FloatingActionButton var1) {
         this.a = var1;
      }

      @Override
      public float a() {
         return this.a.getSizeDimension() / 2.0F;
      }

      @Override
      public void a(int var1, int var2, int var3, int var4) {
         this.a.c.set(var1, var2, var3, var4);
         this.a.setPadding(this.a.a + var1, this.a.a + var2, this.a.a + var3, this.a.a + var4);
      }

      @Override
      public void a(Drawable var1) {
         this.a.setBackgroundDrawable(var1);
      }

      @Override
      public boolean b() {
         return this.a.b;
      }
   }
}
