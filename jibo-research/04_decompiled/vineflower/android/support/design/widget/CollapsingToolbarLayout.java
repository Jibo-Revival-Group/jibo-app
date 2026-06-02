package android.support.design.widget;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.design.R;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.math.MathUtils;
import android.support.v4.util.ObjectsCompat;
import android.support.v4.view.OnApplyWindowInsetsListener;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.WindowInsetsCompat;
import android.support.v4.widget.ViewGroupUtils;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;

public class CollapsingToolbarLayout extends FrameLayout {
   final CollapsingTextHelper a;
   Drawable b;
   int c;
   WindowInsetsCompat d;
   private boolean e = true;
   private int f;
   private Toolbar g;
   private View h;
   private View i;
   private int j;
   private int k;
   private int l;
   private int m;
   private final Rect n = new Rect();
   private boolean o;
   private boolean p;
   private Drawable q;
   private int r;
   private boolean s;
   private ValueAnimator t;
   private long u;
   private int v = -1;
   private AppBarLayout.OnOffsetChangedListener w;

   public CollapsingToolbarLayout(Context var1) {
      this(var1, null);
   }

   public CollapsingToolbarLayout(Context var1, AttributeSet var2) {
      this(var1, var2, 0);
   }

   public CollapsingToolbarLayout(Context var1, AttributeSet var2, int var3) {
      super(var1, var2, var3);
      ThemeUtils.a(var1);
      this.a = new CollapsingTextHelper(this);
      this.a.a(AnimationUtils.e);
      TypedArray var4 = var1.obtainStyledAttributes(var2, R.styleable.CollapsingToolbarLayout, var3, R.style.Widget_Design_CollapsingToolbar);
      this.a.a(var4.getInt(R.styleable.CollapsingToolbarLayout_expandedTitleGravity, 8388691));
      this.a.b(var4.getInt(R.styleable.CollapsingToolbarLayout_collapsedTitleGravity, 8388627));
      var3 = var4.getDimensionPixelSize(R.styleable.CollapsingToolbarLayout_expandedTitleMargin, 0);
      this.m = var3;
      this.l = var3;
      this.k = var3;
      this.j = var3;
      if (var4.hasValue(R.styleable.CollapsingToolbarLayout_expandedTitleMarginStart)) {
         this.j = var4.getDimensionPixelSize(R.styleable.CollapsingToolbarLayout_expandedTitleMarginStart, 0);
      }

      if (var4.hasValue(R.styleable.CollapsingToolbarLayout_expandedTitleMarginEnd)) {
         this.l = var4.getDimensionPixelSize(R.styleable.CollapsingToolbarLayout_expandedTitleMarginEnd, 0);
      }

      if (var4.hasValue(R.styleable.CollapsingToolbarLayout_expandedTitleMarginTop)) {
         this.k = var4.getDimensionPixelSize(R.styleable.CollapsingToolbarLayout_expandedTitleMarginTop, 0);
      }

      if (var4.hasValue(R.styleable.CollapsingToolbarLayout_expandedTitleMarginBottom)) {
         this.m = var4.getDimensionPixelSize(R.styleable.CollapsingToolbarLayout_expandedTitleMarginBottom, 0);
      }

      this.o = var4.getBoolean(R.styleable.CollapsingToolbarLayout_titleEnabled, true);
      this.setTitle(var4.getText(R.styleable.CollapsingToolbarLayout_title));
      this.a.d(R.style.TextAppearance_Design_CollapsingToolbar_Expanded);
      this.a.c(android.support.v7.appcompat.R.style.TextAppearance_AppCompat_Widget_ActionBar_Title);
      if (var4.hasValue(R.styleable.CollapsingToolbarLayout_expandedTitleTextAppearance)) {
         this.a.d(var4.getResourceId(R.styleable.CollapsingToolbarLayout_expandedTitleTextAppearance, 0));
      }

      if (var4.hasValue(R.styleable.CollapsingToolbarLayout_collapsedTitleTextAppearance)) {
         this.a.c(var4.getResourceId(R.styleable.CollapsingToolbarLayout_collapsedTitleTextAppearance, 0));
      }

      this.v = var4.getDimensionPixelSize(R.styleable.CollapsingToolbarLayout_scrimVisibleHeightTrigger, -1);
      this.u = var4.getInt(R.styleable.CollapsingToolbarLayout_scrimAnimationDuration, 600);
      this.setContentScrim(var4.getDrawable(R.styleable.CollapsingToolbarLayout_contentScrim));
      this.setStatusBarScrim(var4.getDrawable(R.styleable.CollapsingToolbarLayout_statusBarScrim));
      this.f = var4.getResourceId(R.styleable.CollapsingToolbarLayout_toolbarId, -1);
      var4.recycle();
      this.setWillNotDraw(false);
      ViewCompat.a(this, new OnApplyWindowInsetsListener(this) {
         final CollapsingToolbarLayout a;

         {
            this.a = var1;
         }

         @Override
         public WindowInsetsCompat a(View var1, WindowInsetsCompat var2x) {
            return this.a.a(var2x);
         }
      });
   }

   static ViewOffsetHelper a(View var0) {
      ViewOffsetHelper var2 = (ViewOffsetHelper)var0.getTag(R.id.view_offset_helper);
      ViewOffsetHelper var1 = var2;
      if (var2 == null) {
         var1 = new ViewOffsetHelper(var0);
         var0.setTag(R.id.view_offset_helper, var1);
      }

      return var1;
   }

   private void a(int var1) {
      this.c();
      if (this.t == null) {
         this.t = new ValueAnimator();
         this.t.setDuration(this.u);
         ValueAnimator var3 = this.t;
         Interpolator var2;
         if (var1 > this.r) {
            var2 = AnimationUtils.c;
         } else {
            var2 = AnimationUtils.d;
         }

         var3.setInterpolator(var2);
         this.t.addUpdateListener(new AnimatorUpdateListener(this) {
            final CollapsingToolbarLayout a;

            {
               this.a = var1;
            }

            public void onAnimationUpdate(ValueAnimator var1) {
               this.a.setScrimAlpha((Integer)var1.getAnimatedValue());
            }
         });
      } else if (this.t.isRunning()) {
         this.t.cancel();
      }

      this.t.setIntValues(new int[]{this.r, var1});
      this.t.start();
   }

   private void c() {
      if (this.e) {
         this.g = null;
         this.h = null;
         if (this.f != -1) {
            this.g = (Toolbar)this.findViewById(this.f);
            if (this.g != null) {
               this.h = this.d(this.g);
            }
         }

         if (this.g == null) {
            int var2 = this.getChildCount();
            int var1 = 0;

            Toolbar var4;
            while (true) {
               if (var1 >= var2) {
                  var4 = null;
                  break;
               }

               View var3 = this.getChildAt(var1);
               if (var3 instanceof Toolbar) {
                  var4 = (Toolbar)var3;
                  break;
               }

               var1++;
            }

            this.g = var4;
         }

         this.d();
         this.e = false;
      }
   }

   private boolean c(View var1) {
      boolean var2 = true;
      if (this.h != null && this.h != this) {
         if (var1 != this.h) {
            var2 = false;
         }
      } else if (var1 != this.g) {
         var2 = false;
      }

      return var2;
   }

   private View d(View var1) {
      ViewParent var3 = var1.getParent();
      View var2 = var1;

      for (ViewParent var4 = var3; var4 != this && var4 != null; var4 = var4.getParent()) {
         if (var4 instanceof View) {
            var2 = (View)var4;
         }
      }

      return var2;
   }

   private void d() {
      if (!this.o && this.i != null) {
         ViewParent var1 = this.i.getParent();
         if (var1 instanceof ViewGroup) {
            ((ViewGroup)var1).removeView(this.i);
         }
      }

      if (this.o && this.g != null) {
         if (this.i == null) {
            this.i = new View(this.getContext());
         }

         if (this.i.getParent() == null) {
            this.g.addView(this.i, -1, -1);
         }
      }
   }

   private static int e(View var0) {
      android.view.ViewGroup.LayoutParams var3 = var0.getLayoutParams();
      int var4;
      if (var3 instanceof MarginLayoutParams) {
         MarginLayoutParams var5 = (MarginLayoutParams)var3;
         int var2 = var0.getHeight();
         var4 = var5.topMargin;
         var4 = var5.bottomMargin + var2 + var4;
      } else {
         var4 = var0.getHeight();
      }

      return var4;
   }

   protected CollapsingToolbarLayout.LayoutParams a() {
      return new CollapsingToolbarLayout.LayoutParams(-1, -1);
   }

   WindowInsetsCompat a(WindowInsetsCompat var1) {
      WindowInsetsCompat var2 = null;
      if (ViewCompat.r(this)) {
         var2 = var1;
      }

      if (!ObjectsCompat.a(this.d, var2)) {
         this.d = var2;
         this.requestLayout();
      }

      return var1.g();
   }

   protected android.widget.FrameLayout.LayoutParams a(android.view.ViewGroup.LayoutParams var1) {
      return new CollapsingToolbarLayout.LayoutParams(var1);
   }

   public void a(boolean var1, boolean var2) {
      short var3 = 255;
      if (this.s != var1) {
         if (var2) {
            if (!var1) {
               var3 = 0;
            }

            this.a(var3);
         } else {
            if (!var1) {
               var3 = 0;
            }

            this.setScrimAlpha(var3);
         }

         this.s = var1;
      }
   }

   final int b(View var1) {
      ViewOffsetHelper var3 = a(var1);
      CollapsingToolbarLayout.LayoutParams var2 = (CollapsingToolbarLayout.LayoutParams)var1.getLayoutParams();
      return this.getHeight() - var3.c() - var1.getHeight() - var2.bottomMargin;
   }

   final void b() {
      if (this.q != null || this.b != null) {
         boolean var1;
         if (this.getHeight() + this.c < this.getScrimVisibleHeightTrigger()) {
            var1 = true;
         } else {
            var1 = false;
         }

         this.setScrimsShown(var1);
      }
   }

   protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams var1) {
      return var1 instanceof CollapsingToolbarLayout.LayoutParams;
   }

   public void draw(Canvas var1) {
      super.draw(var1);
      this.c();
      if (this.g == null && this.q != null && this.r > 0) {
         this.q.mutate().setAlpha(this.r);
         this.q.draw(var1);
      }

      if (this.o && this.p) {
         this.a.a(var1);
      }

      if (this.b != null && this.r > 0) {
         int var2;
         if (this.d != null) {
            var2 = this.d.b();
         } else {
            var2 = 0;
         }

         if (var2 > 0) {
            this.b.setBounds(0, -this.c, this.getWidth(), var2 - this.c);
            this.b.mutate().setAlpha(this.r);
            this.b.draw(var1);
         }
      }
   }

   protected boolean drawChild(Canvas var1, View var2, long var3) {
      boolean var6 = false;
      boolean var5;
      if (this.q != null && this.r > 0 && this.c(var2)) {
         this.q.mutate().setAlpha(this.r);
         this.q.draw(var1);
         var5 = true;
      } else {
         var5 = false;
      }

      if (super.drawChild(var1, var2, var3) || var5) {
         var6 = true;
      }

      return var6;
   }

   protected void drawableStateChanged() {
      super.drawableStateChanged();
      int[] var3 = this.getDrawableState();
      boolean var1 = false;
      Drawable var4 = this.b;
      boolean var2 = var1;
      if (var4 != null) {
         var2 = var1;
         if (var4.isStateful()) {
            var2 = false | var4.setState(var3);
         }
      }

      var4 = this.q;
      var1 = var2;
      if (var4 != null) {
         var1 = var2;
         if (var4.isStateful()) {
            var1 = var2 | var4.setState(var3);
         }
      }

      var2 = var1;
      if (this.a != null) {
         var2 = var1 | this.a.a(var3);
      }

      if (var2) {
         this.invalidate();
      }
   }

   public android.widget.FrameLayout.LayoutParams generateLayoutParams(AttributeSet var1) {
      return new CollapsingToolbarLayout.LayoutParams(this.getContext(), var1);
   }

   public int getCollapsedTitleGravity() {
      return this.a.c();
   }

   public Typeface getCollapsedTitleTypeface() {
      return this.a.d();
   }

   public Drawable getContentScrim() {
      return this.q;
   }

   public int getExpandedTitleGravity() {
      return this.a.b();
   }

   public int getExpandedTitleMarginBottom() {
      return this.m;
   }

   public int getExpandedTitleMarginEnd() {
      return this.l;
   }

   public int getExpandedTitleMarginStart() {
      return this.j;
   }

   public int getExpandedTitleMarginTop() {
      return this.k;
   }

   public Typeface getExpandedTitleTypeface() {
      return this.a.e();
   }

   int getScrimAlpha() {
      return this.r;
   }

   public long getScrimAnimationDuration() {
      return this.u;
   }

   public int getScrimVisibleHeightTrigger() {
      int var1;
      if (this.v >= 0) {
         var1 = this.v;
      } else {
         if (this.d != null) {
            var1 = this.d.b();
         } else {
            var1 = 0;
         }

         int var2 = ViewCompat.k(this);
         if (var2 > 0) {
            var1 = Math.min(var1 + var2 * 2, this.getHeight());
         } else {
            var1 = this.getHeight() / 3;
         }
      }

      return var1;
   }

   public Drawable getStatusBarScrim() {
      return this.b;
   }

   public CharSequence getTitle() {
      CharSequence var1;
      if (this.o) {
         var1 = this.a.j();
      } else {
         var1 = null;
      }

      return var1;
   }

   protected void onAttachedToWindow() {
      super.onAttachedToWindow();
      ViewParent var1 = this.getParent();
      if (var1 instanceof AppBarLayout) {
         ViewCompat.b(this, ViewCompat.r((View)var1));
         if (this.w == null) {
            this.w = new CollapsingToolbarLayout.OffsetUpdateListener(this);
         }

         ((AppBarLayout)var1).a(this.w);
         ViewCompat.q(this);
      }
   }

   protected void onDetachedFromWindow() {
      ViewParent var1 = this.getParent();
      if (this.w != null && var1 instanceof AppBarLayout) {
         ((AppBarLayout)var1).b(this.w);
      }

      super.onDetachedFromWindow();
   }

   protected void onLayout(boolean var1, int var2, int var3, int var4, int var5) {
      int var7 = 1;
      byte var9 = 0;
      super.onLayout(var1, var2, var3, var4, var5);
      if (this.d != null) {
         int var8 = this.d.b();
         int var10 = this.getChildCount();

         for (int var6 = 0; var6 < var10; var6++) {
            View var15 = this.getChildAt(var6);
            if (!ViewCompat.r(var15) && var15.getTop() < var8) {
               ViewCompat.c(var15, var8);
            }
         }
      }

      if (this.o && this.i != null) {
         if (ViewCompat.B(this.i) && this.i.getVisibility() == 0) {
            var1 = true;
         } else {
            var1 = false;
         }

         this.p = var1;
         if (this.p) {
            boolean var19;
            if (ViewCompat.e(this) == 1) {
               var19 = var7;
            } else {
               var19 = 0;
            }

            Object var27;
            if (this.h != null) {
               var27 = this.h;
            } else {
               var27 = this.g;
            }

            int var11 = this.b((View)var27);
            ViewGroupUtils.b(this, this.i, this.n);
            CollapsingTextHelper var28 = this.a;
            int var25 = this.n.left;
            if (var19) {
               var7 = this.g.getTitleMarginEnd();
            } else {
               var7 = this.g.getTitleMarginStart();
            }

            int var13 = this.n.top;
            int var12 = this.g.getTitleMarginTop();
            int var14 = this.n.right;
            int var23;
            if (var19) {
               var23 = this.g.getTitleMarginStart();
            } else {
               var23 = this.g.getTitleMarginEnd();
            }

            var28.b(var25 + var7, var12 + var13 + var11, var23 + var14, var11 + this.n.bottom - this.g.getTitleMarginBottom());
            var28 = this.a;
            if (var19) {
               var7 = this.l;
            } else {
               var7 = this.j;
            }

            var23 = this.n.top;
            var25 = this.k;
            if (var19) {
               var19 = this.j;
            } else {
               var19 = this.l;
            }

            var28.a(var7, var23 + var25, var4 - var2 - var19, var5 - var3 - this.m);
            this.a.i();
         }
      }

      var3 = this.getChildCount();

      for (int var17 = var9; var17 < var3; var17++) {
         a(this.getChildAt(var17)).a();
      }

      if (this.g != null) {
         if (this.o && TextUtils.isEmpty(this.a.j())) {
            this.a.a(this.g.getTitle());
         }

         if (this.h != null && this.h != this) {
            this.setMinimumHeight(e(this.h));
         } else {
            this.setMinimumHeight(e(this.g));
         }
      }

      this.b();
   }

   protected void onMeasure(int var1, int var2) {
      this.c();
      super.onMeasure(var1, var2);
      int var3 = MeasureSpec.getMode(var2);
      if (this.d != null) {
         var2 = this.d.b();
      } else {
         var2 = 0;
      }

      if (var3 == 0 && var2 > 0) {
         super.onMeasure(var1, MeasureSpec.makeMeasureSpec(var2 + this.getMeasuredHeight(), 1073741824));
      }
   }

   protected void onSizeChanged(int var1, int var2, int var3, int var4) {
      super.onSizeChanged(var1, var2, var3, var4);
      if (this.q != null) {
         this.q.setBounds(0, 0, var1, var2);
      }
   }

   public void setCollapsedTitleGravity(int var1) {
      this.a.b(var1);
   }

   public void setCollapsedTitleTextAppearance(int var1) {
      this.a.c(var1);
   }

   public void setCollapsedTitleTextColor(int var1) {
      this.setCollapsedTitleTextColor(ColorStateList.valueOf(var1));
   }

   public void setCollapsedTitleTextColor(ColorStateList var1) {
      this.a.a(var1);
   }

   public void setCollapsedTitleTypeface(Typeface var1) {
      this.a.a(var1);
   }

   public void setContentScrim(Drawable var1) {
      Drawable var2 = null;
      if (this.q != var1) {
         if (this.q != null) {
            this.q.setCallback(null);
         }

         if (var1 != null) {
            var2 = var1.mutate();
         }

         this.q = var2;
         if (this.q != null) {
            this.q.setBounds(0, 0, this.getWidth(), this.getHeight());
            this.q.setCallback(this);
            this.q.setAlpha(this.r);
         }

         ViewCompat.c(this);
      }
   }

   public void setContentScrimColor(int var1) {
      this.setContentScrim(new ColorDrawable(var1));
   }

   public void setContentScrimResource(int var1) {
      this.setContentScrim(ContextCompat.a(this.getContext(), var1));
   }

   public void setExpandedTitleColor(int var1) {
      this.setExpandedTitleTextColor(ColorStateList.valueOf(var1));
   }

   public void setExpandedTitleGravity(int var1) {
      this.a.a(var1);
   }

   public void setExpandedTitleMarginBottom(int var1) {
      this.m = var1;
      this.requestLayout();
   }

   public void setExpandedTitleMarginEnd(int var1) {
      this.l = var1;
      this.requestLayout();
   }

   public void setExpandedTitleMarginStart(int var1) {
      this.j = var1;
      this.requestLayout();
   }

   public void setExpandedTitleMarginTop(int var1) {
      this.k = var1;
      this.requestLayout();
   }

   public void setExpandedTitleTextAppearance(int var1) {
      this.a.d(var1);
   }

   public void setExpandedTitleTextColor(ColorStateList var1) {
      this.a.b(var1);
   }

   public void setExpandedTitleTypeface(Typeface var1) {
      this.a.b(var1);
   }

   void setScrimAlpha(int var1) {
      if (var1 != this.r) {
         if (this.q != null && this.g != null) {
            ViewCompat.c(this.g);
         }

         this.r = var1;
         ViewCompat.c(this);
      }
   }

   public void setScrimAnimationDuration(long var1) {
      this.u = var1;
   }

   public void setScrimVisibleHeightTrigger(int var1) {
      if (this.v != var1) {
         this.v = var1;
         this.b();
      }
   }

   public void setScrimsShown(boolean var1) {
      boolean var2;
      if (ViewCompat.y(this) && !this.isInEditMode()) {
         var2 = true;
      } else {
         var2 = false;
      }

      this.a(var1, var2);
   }

   public void setStatusBarScrim(Drawable var1) {
      Drawable var3 = null;
      if (this.b != var1) {
         if (this.b != null) {
            this.b.setCallback(null);
         }

         if (var1 != null) {
            var3 = var1.mutate();
         }

         this.b = var3;
         if (this.b != null) {
            if (this.b.isStateful()) {
               this.b.setState(this.getDrawableState());
            }

            DrawableCompat.b(this.b, ViewCompat.e(this));
            var1 = this.b;
            boolean var2;
            if (this.getVisibility() == 0) {
               var2 = true;
            } else {
               var2 = false;
            }

            var1.setVisible(var2, false);
            this.b.setCallback(this);
            this.b.setAlpha(this.r);
         }

         ViewCompat.c(this);
      }
   }

   public void setStatusBarScrimColor(int var1) {
      this.setStatusBarScrim(new ColorDrawable(var1));
   }

   public void setStatusBarScrimResource(int var1) {
      this.setStatusBarScrim(ContextCompat.a(this.getContext(), var1));
   }

   public void setTitle(CharSequence var1) {
      this.a.a(var1);
   }

   public void setTitleEnabled(boolean var1) {
      if (var1 != this.o) {
         this.o = var1;
         this.d();
         this.requestLayout();
      }
   }

   public void setVisibility(int var1) {
      super.setVisibility(var1);
      boolean var2;
      if (var1 == 0) {
         var2 = true;
      } else {
         var2 = false;
      }

      if (this.b != null && this.b.isVisible() != var2) {
         this.b.setVisible(var2, false);
      }

      if (this.q != null && this.q.isVisible() != var2) {
         this.q.setVisible(var2, false);
      }
   }

   protected boolean verifyDrawable(Drawable var1) {
      boolean var2;
      if (!super.verifyDrawable(var1) && var1 != this.q && var1 != this.b) {
         var2 = false;
      } else {
         var2 = true;
      }

      return var2;
   }

   public static class LayoutParams extends android.widget.FrameLayout.LayoutParams {
      int a = 0;
      float b = 0.5F;

      public LayoutParams(int var1, int var2) {
         super(var1, var2);
      }

      public LayoutParams(Context var1, AttributeSet var2) {
         super(var1, var2);
         TypedArray var3 = var1.obtainStyledAttributes(var2, R.styleable.CollapsingToolbarLayout_Layout);
         this.a = var3.getInt(R.styleable.CollapsingToolbarLayout_Layout_layout_collapseMode, 0);
         this.a(var3.getFloat(R.styleable.CollapsingToolbarLayout_Layout_layout_collapseParallaxMultiplier, 0.5F));
         var3.recycle();
      }

      public LayoutParams(android.view.ViewGroup.LayoutParams var1) {
         super(var1);
      }

      public void a(float var1) {
         this.b = var1;
      }
   }

   private class OffsetUpdateListener implements AppBarLayout.OnOffsetChangedListener {
      final CollapsingToolbarLayout a;

      OffsetUpdateListener(CollapsingToolbarLayout var1) {
         this.a = var1;
      }

      @Override
      public void a(AppBarLayout var1, int var2) {
         this.a.c = var2;
         int var4;
         if (this.a.d != null) {
            var4 = this.a.d.b();
         } else {
            var4 = 0;
         }

         int var6 = this.a.getChildCount();

         for (int var5 = 0; var5 < var6; var5++) {
            View var9 = this.a.getChildAt(var5);
            CollapsingToolbarLayout.LayoutParams var8 = (CollapsingToolbarLayout.LayoutParams)var9.getLayoutParams();
            ViewOffsetHelper var7 = CollapsingToolbarLayout.a(var9);
            switch (var8.a) {
               case 1:
                  var7.a(MathUtils.a(-var2, 0, this.a.b(var9)));
                  break;
               case 2:
                  float var3 = -var2;
                  var7.a(Math.round(var8.b * var3));
            }
         }

         this.a.b();
         if (this.a.b != null && var4 > 0) {
            ViewCompat.c(this.a);
         }

         int var10 = this.a.getHeight();
         var6 = ViewCompat.k(this.a);
         this.a.a.b((float)Math.abs(var2) / (var10 - var6 - var4));
      }
   }
}
