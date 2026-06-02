package android.support.design.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.design.R;
import android.support.v4.util.Pools;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.PointerIconCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.content.res.AppCompatResources;
import android.support.v7.widget.TooltipCompat;
import android.text.Layout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.FrameLayout.LayoutParams;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

@ViewPager.DecorView
public class TabLayout extends HorizontalScrollView {
   private static final Pools.Pool<TabLayout.Tab> n = new Pools.SynchronizedPool<>(16);
   private DataSetObserver A;
   private TabLayout.TabLayoutOnPageChangeListener B;
   private TabLayout.AdapterChangeListener C;
   private boolean D;
   private final Pools.Pool<TabLayout.TabView> E;
   int a;
   int b;
   int c;
   int d;
   int e;
   ColorStateList f;
   float g;
   float h;
   final int i;
   int j;
   int k;
   int l;
   ViewPager m;
   private final ArrayList<TabLayout.Tab> o = new ArrayList<>();
   private TabLayout.Tab p;
   private final TabLayout.SlidingTabStrip q;
   private final int r;
   private final int s;
   private final int t;
   private int u;
   private TabLayout.OnTabSelectedListener v;
   private final ArrayList<TabLayout.OnTabSelectedListener> w;
   private TabLayout.OnTabSelectedListener x;
   private ValueAnimator y;
   private PagerAdapter z;

   public TabLayout(Context var1, AttributeSet var2) {
      this(var1, var2, 0);
   }

   public TabLayout(Context var1, AttributeSet var2, int var3) {
      super(var1, var2, var3);
      this.j = Integer.MAX_VALUE;
      this.w = new ArrayList<>();
      this.E = new Pools.SimplePool<>(12);
      ThemeUtils.a(var1);
      this.setHorizontalScrollBarEnabled(false);
      this.q = new TabLayout.SlidingTabStrip(this, var1);
      super.addView(this.q, 0, new LayoutParams(-2, -1));
      TypedArray var8 = var1.obtainStyledAttributes(var2, R.styleable.TabLayout, var3, R.style.Widget_Design_TabLayout);
      this.q.b(var8.getDimensionPixelSize(R.styleable.TabLayout_tabIndicatorHeight, 0));
      this.q.a(var8.getColor(R.styleable.TabLayout_tabIndicatorColor, 0));
      var3 = var8.getDimensionPixelSize(R.styleable.TabLayout_tabPadding, 0);
      this.d = var3;
      this.c = var3;
      this.b = var3;
      this.a = var3;
      this.a = var8.getDimensionPixelSize(R.styleable.TabLayout_tabPaddingStart, this.a);
      this.b = var8.getDimensionPixelSize(R.styleable.TabLayout_tabPaddingTop, this.b);
      this.c = var8.getDimensionPixelSize(R.styleable.TabLayout_tabPaddingEnd, this.c);
      this.d = var8.getDimensionPixelSize(R.styleable.TabLayout_tabPaddingBottom, this.d);
      this.e = var8.getResourceId(R.styleable.TabLayout_tabTextAppearance, R.style.TextAppearance_Design_Tab);
      TypedArray var6 = var1.obtainStyledAttributes(this.e, android.support.v7.appcompat.R.styleable.TextAppearance);

      try {
         this.g = var6.getDimensionPixelSize(android.support.v7.appcompat.R.styleable.TextAppearance_android_textSize, 0);
         this.f = var6.getColorStateList(android.support.v7.appcompat.R.styleable.TextAppearance_android_textColor);
      } finally {
         var6.recycle();
      }

      if (var8.hasValue(R.styleable.TabLayout_tabTextColor)) {
         this.f = var8.getColorStateList(R.styleable.TabLayout_tabTextColor);
      }

      if (var8.hasValue(R.styleable.TabLayout_tabSelectedTextColor)) {
         var3 = var8.getColor(R.styleable.TabLayout_tabSelectedTextColor, 0);
         this.f = a(this.f.getDefaultColor(), var3);
      }

      this.r = var8.getDimensionPixelSize(R.styleable.TabLayout_tabMinWidth, -1);
      this.s = var8.getDimensionPixelSize(R.styleable.TabLayout_tabMaxWidth, -1);
      this.i = var8.getResourceId(R.styleable.TabLayout_tabBackground, 0);
      this.u = var8.getDimensionPixelSize(R.styleable.TabLayout_tabContentStart, 0);
      this.l = var8.getInt(R.styleable.TabLayout_tabMode, 1);
      this.k = var8.getInt(R.styleable.TabLayout_tabGravity, 0);
      var8.recycle();
      Resources var7 = this.getResources();
      this.h = var7.getDimensionPixelSize(R.dimen.design_tab_text_size_2line);
      this.t = var7.getDimensionPixelSize(R.dimen.design_tab_scrollable_min_width);
      this.g();
   }

   private int a(int var1, float var2) {
      int var3 = 0;
      int var4 = 0;
      if (this.l == 0) {
         View var6 = this.q.getChildAt(var1);
         View var5;
         if (var1 + 1 < this.q.getChildCount()) {
            var5 = this.q.getChildAt(var1 + 1);
         } else {
            var5 = null;
         }

         if (var6 != null) {
            var1 = var6.getWidth();
         } else {
            var1 = 0;
         }

         var3 = var4;
         if (var5 != null) {
            var3 = var5.getWidth();
         }

         var4 = var6.getLeft() + var1 / 2 - this.getWidth() / 2;
         var1 = (int)((var3 + var1) * 0.5F * var2);
         if (ViewCompat.e(this) == 0) {
            var3 = var1 + var4;
         } else {
            var3 = var4 - var1;
         }
      }

      return var3;
   }

   private static ColorStateList a(int var0, int var1) {
      return new ColorStateList(new int[][]{SELECTED_STATE_SET, EMPTY_STATE_SET}, new int[]{var1, var0});
   }

   private void a(TabItem var1) {
      TabLayout.Tab var2 = this.a();
      if (var1.a != null) {
         var2.a(var1.a);
      }

      if (var1.b != null) {
         var2.a(var1.b);
      }

      if (var1.c != 0) {
         var2.a(var1.c);
      }

      if (!TextUtils.isEmpty(var1.getContentDescription())) {
         var2.b(var1.getContentDescription());
      }

      this.a(var2);
   }

   private void a(TabLayout.Tab var1, int var2) {
      var1.b(var2);
      this.o.add(var2, var1);
      int var3 = this.o.size();
      var2++;

      while (var2 < var3) {
         this.o.get(var2).b(var2);
         var2++;
      }
   }

   private void a(ViewPager var1, boolean var2, boolean var3) {
      if (this.m != null) {
         if (this.B != null) {
            this.m.b(this.B);
         }

         if (this.C != null) {
            this.m.b(this.C);
         }
      }

      if (this.x != null) {
         this.b(this.x);
         this.x = null;
      }

      if (var1 != null) {
         this.m = var1;
         if (this.B == null) {
            this.B = new TabLayout.TabLayoutOnPageChangeListener(this);
         }

         this.B.a();
         var1.a(this.B);
         this.x = new TabLayout.ViewPagerOnTabSelectedListener(var1);
         this.a(this.x);
         PagerAdapter var4 = var1.getAdapter();
         if (var4 != null) {
            this.a(var4, var2);
         }

         if (this.C == null) {
            this.C = new TabLayout.AdapterChangeListener(this);
         }

         this.C.a(var2);
         var1.a(this.C);
         this.a(var1.getCurrentItem(), 0.0F, true);
      } else {
         this.m = null;
         this.a((PagerAdapter)null, false);
      }

      this.D = var3;
   }

   private void a(View var1) {
      if (var1 instanceof TabItem) {
         this.a((TabItem)var1);
      } else {
         throw new IllegalArgumentException("Only TabItem instances can be added to TabLayout");
      }
   }

   private void a(android.widget.LinearLayout.LayoutParams var1) {
      if (this.l == 1 && this.k == 0) {
         var1.width = 0;
         var1.weight = 1.0F;
      } else {
         var1.width = -2;
         var1.weight = 0.0F;
      }
   }

   private TabLayout.TabView c(TabLayout.Tab var1) {
      TabLayout.TabView var2;
      if (this.E != null) {
         var2 = this.E.a();
      } else {
         var2 = null;
      }

      TabLayout.TabView var3 = var2;
      if (var2 == null) {
         var3 = new TabLayout.TabView(this, this.getContext());
      }

      var3.a(var1);
      var3.setFocusable(true);
      var3.setMinimumWidth(this.getTabMinWidth());
      return var3;
   }

   private void c(int var1) {
      TabLayout.TabView var2 = (TabLayout.TabView)this.q.getChildAt(var1);
      this.q.removeViewAt(var1);
      if (var2 != null) {
         var2.a();
         this.E.a(var2);
      }

      this.requestLayout();
   }

   private void d() {
      int var2 = this.o.size();

      for (int var1 = 0; var1 < var2; var1++) {
         this.o.get(var1).h();
      }
   }

   private void d(int var1) {
      if (var1 != -1) {
         if (this.getWindowToken() != null && ViewCompat.y(this) && !this.q.a()) {
            int var3 = this.getScrollX();
            int var2 = this.a(var1, 0.0F);
            if (var3 != var2) {
               this.f();
               this.y.setIntValues(new int[]{var3, var2});
               this.y.start();
            }

            this.q.b(var1, 300);
         } else {
            this.a(var1, 0.0F, true);
         }
      }
   }

   private void d(TabLayout.Tab var1) {
      TabLayout.TabView var2 = var1.b;
      this.q.addView(var2, var1.c(), this.e());
   }

   private android.widget.LinearLayout.LayoutParams e() {
      android.widget.LinearLayout.LayoutParams var1 = new android.widget.LinearLayout.LayoutParams(-2, -1);
      this.a(var1);
      return var1;
   }

   private void e(TabLayout.Tab var1) {
      for (int var2 = this.w.size() - 1; var2 >= 0; var2--) {
         this.w.get(var2).a(var1);
      }
   }

   private void f() {
      if (this.y == null) {
         this.y = new ValueAnimator();
         this.y.setInterpolator(AnimationUtils.b);
         this.y.setDuration(300L);
         this.y.addUpdateListener(new AnimatorUpdateListener(this) {
            final TabLayout a;

            {
               this.a = var1;
            }

            public void onAnimationUpdate(ValueAnimator var1) {
               this.a.scrollTo((Integer)var1.getAnimatedValue(), 0);
            }
         });
      }
   }

   private void f(TabLayout.Tab var1) {
      for (int var2 = this.w.size() - 1; var2 >= 0; var2--) {
         this.w.get(var2).b(var1);
      }
   }

   private void g() {
      int var1;
      if (this.l == 0) {
         var1 = Math.max(0, this.u - this.a);
      } else {
         var1 = 0;
      }

      ViewCompat.b(this.q, var1, 0, 0, 0);
      switch (this.l) {
         case 0:
            this.q.setGravity(8388611);
            break;
         case 1:
            this.q.setGravity(1);
      }

      this.a(true);
   }

   private void g(TabLayout.Tab var1) {
      for (int var2 = this.w.size() - 1; var2 >= 0; var2--) {
         this.w.get(var2).c(var1);
      }
   }

   private int getDefaultHeight() {
      int var2 = this.o.size();
      int var1 = 0;

      while (true) {
         if (var1 >= var2) {
            var4 = false;
            break;
         }

         TabLayout.Tab var3 = this.o.get(var1);
         if (var3 != null && var3.b() != null && !TextUtils.isEmpty(var3.d())) {
            var4 = true;
            break;
         }

         var1++;
      }

      byte var5;
      if (var4) {
         var5 = 72;
      } else {
         var5 = 48;
      }

      return var5;
   }

   private float getScrollPosition() {
      return this.q.b();
   }

   private int getTabMinWidth() {
      int var1;
      if (this.r != -1) {
         var1 = this.r;
      } else if (this.l == 0) {
         var1 = this.t;
      } else {
         var1 = 0;
      }

      return var1;
   }

   private int getTabScrollRange() {
      return Math.max(0, this.q.getWidth() - this.getWidth() - this.getPaddingLeft() - this.getPaddingRight());
   }

   private void setSelectedTabView(int var1) {
      int var3 = this.q.getChildCount();
      if (var1 < var3) {
         for (int var2 = 0; var2 < var3; var2++) {
            View var5 = this.q.getChildAt(var2);
            boolean var4;
            if (var2 == var1) {
               var4 = true;
            } else {
               var4 = false;
            }

            var5.setSelected(var4);
         }
      }
   }

   public TabLayout.Tab a() {
      TabLayout.Tab var2 = n.a();
      TabLayout.Tab var1 = var2;
      if (var2 == null) {
         var1 = new TabLayout.Tab();
      }

      var1.a = this;
      var1.b = this.c(var1);
      return var1;
   }

   public TabLayout.Tab a(int var1) {
      TabLayout.Tab var2;
      if (var1 >= 0 && var1 < this.getTabCount()) {
         var2 = this.o.get(var1);
      } else {
         var2 = null;
      }

      return var2;
   }

   public void a(int var1, float var2, boolean var3) {
      this.a(var1, var2, var3, true);
   }

   void a(int var1, float var2, boolean var3, boolean var4) {
      int var5 = Math.round(var1 + var2);
      if (var5 >= 0 && var5 < this.q.getChildCount()) {
         if (var4) {
            this.q.a(var1, var2);
         }

         if (this.y != null && this.y.isRunning()) {
            this.y.cancel();
         }

         this.scrollTo(this.a(var1, var2), 0);
         if (var3) {
            this.setSelectedTabView(var5);
         }
      }
   }

   public void a(TabLayout.OnTabSelectedListener var1) {
      if (!this.w.contains(var1)) {
         this.w.add(var1);
      }
   }

   public void a(TabLayout.Tab var1) {
      this.a(var1, this.o.isEmpty());
   }

   public void a(TabLayout.Tab var1, int var2, boolean var3) {
      if (var1.a != this) {
         throw new IllegalArgumentException("Tab belongs to a different TabLayout.");
      }

      this.a(var1, var2);
      this.d(var1);
      if (var3) {
         var1.e();
      }
   }

   public void a(TabLayout.Tab var1, boolean var2) {
      this.a(var1, this.o.size(), var2);
   }

   void a(PagerAdapter var1, boolean var2) {
      if (this.z != null && this.A != null) {
         this.z.b(this.A);
      }

      this.z = var1;
      if (var2 && var1 != null) {
         if (this.A == null) {
            this.A = new TabLayout.PagerAdapterObserver(this);
         }

         var1.a(this.A);
      }

      this.c();
   }

   public void a(ViewPager var1, boolean var2) {
      this.a(var1, var2, false);
   }

   void a(boolean var1) {
      for (int var2 = 0; var2 < this.q.getChildCount(); var2++) {
         View var3 = this.q.getChildAt(var2);
         var3.setMinimumWidth(this.getTabMinWidth());
         this.a((android.widget.LinearLayout.LayoutParams)var3.getLayoutParams());
         if (var1) {
            var3.requestLayout();
         }
      }
   }

   public void addView(View var1) {
      this.a(var1);
   }

   public void addView(View var1, int var2) {
      this.a(var1);
   }

   public void addView(View var1, int var2, android.view.ViewGroup.LayoutParams var3) {
      this.a(var1);
   }

   public void addView(View var1, android.view.ViewGroup.LayoutParams var2) {
      this.a(var1);
   }

   int b(int var1) {
      return Math.round(this.getResources().getDisplayMetrics().density * var1);
   }

   public void b() {
      for (int var1 = this.q.getChildCount() - 1; var1 >= 0; var1--) {
         this.c(var1);
      }

      Iterator var3 = this.o.iterator();

      while (var3.hasNext()) {
         TabLayout.Tab var2 = (TabLayout.Tab)var3.next();
         var3.remove();
         var2.i();
         n.a(var2);
      }

      this.p = null;
   }

   public void b(TabLayout.OnTabSelectedListener var1) {
      this.w.remove(var1);
   }

   void b(TabLayout.Tab var1) {
      this.b(var1, true);
   }

   void b(TabLayout.Tab var1, boolean var2) {
      TabLayout.Tab var4 = this.p;
      if (var4 == var1) {
         if (var4 != null) {
            this.g(var1);
            this.d(var1.c());
         }
      } else {
         int var3;
         if (var1 != null) {
            var3 = var1.c();
         } else {
            var3 = -1;
         }

         if (var2) {
            if ((var4 == null || var4.c() == -1) && var3 != -1) {
               this.a(var3, 0.0F, true);
            } else {
               this.d(var3);
            }

            if (var3 != -1) {
               this.setSelectedTabView(var3);
            }
         }

         if (var4 != null) {
            this.f(var4);
         }

         this.p = var1;
         if (var1 != null) {
            this.e(var1);
         }
      }
   }

   void c() {
      this.b();
      if (this.z != null) {
         int var2 = this.z.b();

         for (int var1 = 0; var1 < var2; var1++) {
            this.a(this.a().a(this.z.c(var1)), false);
         }

         if (this.m != null && var2 > 0) {
            int var3 = this.m.getCurrentItem();
            if (var3 != this.getSelectedTabPosition() && var3 < this.getTabCount()) {
               this.b(this.a(var3));
            }
         }
      }
   }

   public LayoutParams generateLayoutParams(AttributeSet var1) {
      return this.generateDefaultLayoutParams();
   }

   public int getSelectedTabPosition() {
      int var1;
      if (this.p != null) {
         var1 = this.p.c();
      } else {
         var1 = -1;
      }

      return var1;
   }

   public int getTabCount() {
      return this.o.size();
   }

   public int getTabGravity() {
      return this.k;
   }

   int getTabMaxWidth() {
      return this.j;
   }

   public int getTabMode() {
      return this.l;
   }

   public ColorStateList getTabTextColors() {
      return this.f;
   }

   protected void onAttachedToWindow() {
      super.onAttachedToWindow();
      if (this.m == null) {
         ViewParent var1 = this.getParent();
         if (var1 instanceof ViewPager) {
            this.a((ViewPager)var1, true, true);
         }
      }
   }

   protected void onDetachedFromWindow() {
      super.onDetachedFromWindow();
      if (this.D) {
         this.setupWithViewPager(null);
         this.D = false;
      }
   }

   protected void onMeasure(int var1, int var2) {
      boolean var4 = true;
      int var3 = this.b(this.getDefaultHeight()) + this.getPaddingTop() + this.getPaddingBottom();
      switch (MeasureSpec.getMode(var2)) {
         case Integer.MIN_VALUE:
            var2 = MeasureSpec.makeMeasureSpec(Math.min(var3, MeasureSpec.getSize(var2)), 1073741824);
            break;
         case 0:
            var2 = MeasureSpec.makeMeasureSpec(var3, 1073741824);
      }

      var3 = MeasureSpec.getSize(var1);
      if (MeasureSpec.getMode(var1) != 0) {
         if (this.s > 0) {
            var3 = this.s;
         } else {
            var3 -= this.b(56);
         }

         this.j = var3;
      }

      super.onMeasure(var1, var2);
      if (this.getChildCount() == 1) {
         View var5 = this.getChildAt(0);
         boolean var6;
         switch (this.l) {
            case 0:
               if (var5.getMeasuredWidth() < this.getMeasuredWidth()) {
                  var6 = 1;
               } else {
                  var6 = 0;
               }
               break;
            case 1:
               if (var5.getMeasuredWidth() != this.getMeasuredWidth()) {
                  var6 = var4;
               } else {
                  var6 = 0;
               }
               break;
            default:
               var6 = 0;
         }

         if (var6) {
            var6 = getChildMeasureSpec(var2, this.getPaddingTop() + this.getPaddingBottom(), var5.getLayoutParams().height);
            var5.measure(MeasureSpec.makeMeasureSpec(this.getMeasuredWidth(), 1073741824), var6);
         }
      }
   }

   @Deprecated
   public void setOnTabSelectedListener(TabLayout.OnTabSelectedListener var1) {
      if (this.v != null) {
         this.b(this.v);
      }

      this.v = var1;
      if (var1 != null) {
         this.a(var1);
      }
   }

   void setScrollAnimatorListener(AnimatorListener var1) {
      this.f();
      this.y.addListener(var1);
   }

   public void setSelectedTabIndicatorColor(int var1) {
      this.q.a(var1);
   }

   public void setSelectedTabIndicatorHeight(int var1) {
      this.q.b(var1);
   }

   public void setTabGravity(int var1) {
      if (this.k != var1) {
         this.k = var1;
         this.g();
      }
   }

   public void setTabMode(int var1) {
      if (var1 != this.l) {
         this.l = var1;
         this.g();
      }
   }

   public void setTabTextColors(ColorStateList var1) {
      if (this.f != var1) {
         this.f = var1;
         this.d();
      }
   }

   @Deprecated
   public void setTabsFromPagerAdapter(PagerAdapter var1) {
      this.a(var1, false);
   }

   public void setupWithViewPager(ViewPager var1) {
      this.a(var1, true);
   }

   public boolean shouldDelayChildPressedState() {
      boolean var1;
      if (this.getTabScrollRange() > 0) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   private class AdapterChangeListener implements ViewPager.OnAdapterChangeListener {
      final TabLayout a;
      private boolean b;

      AdapterChangeListener(TabLayout var1) {
         this.a = var1;
      }

      @Override
      public void a(ViewPager var1, PagerAdapter var2, PagerAdapter var3) {
         if (this.a.m == var1) {
            this.a.a(var3, this.b);
         }
      }

      void a(boolean var1) {
         this.b = var1;
      }
   }

   public interface OnTabSelectedListener {
      void a(TabLayout.Tab var1);

      void b(TabLayout.Tab var1);

      void c(TabLayout.Tab var1);
   }

   private class PagerAdapterObserver extends DataSetObserver {
      final TabLayout a;

      PagerAdapterObserver(TabLayout var1) {
         this.a = var1;
      }

      public void onChanged() {
         this.a.c();
      }

      public void onInvalidated() {
         this.a.c();
      }
   }

   private class SlidingTabStrip extends LinearLayout {
      int a;
      float b;
      final TabLayout c;
      private int d;
      private final Paint e;
      private int f;
      private int g;
      private int h;
      private ValueAnimator i;

      SlidingTabStrip(TabLayout var1, Context var2) {
         super(var2);
         this.c = var1;
         this.a = -1;
         this.f = -1;
         this.g = -1;
         this.h = -1;
         this.setWillNotDraw(false);
         this.e = new Paint();
      }

      private void c() {
         View var8 = this.getChildAt(this.a);
         int var4;
         int var5;
         if (var8 != null && var8.getWidth() > 0) {
            int var7 = var8.getLeft();
            int var6 = var8.getRight();
            var5 = var6;
            var4 = var7;
            if (this.b > 0.0F) {
               var5 = var6;
               var4 = var7;
               if (this.a < this.getChildCount() - 1) {
                  var8 = this.getChildAt(this.a + 1);
                  float var2 = this.b;
                  float var3 = var8.getLeft();
                  float var1 = this.b;
                  var4 = (int)(var7 * (1.0F - var1) + var2 * var3);
                  var1 = this.b;
                  var3 = var8.getRight();
                  var2 = this.b;
                  var5 = (int)(var6 * (1.0F - var2) + var3 * var1);
               }
            }
         } else {
            var5 = -1;
            var4 = -1;
         }

         this.a(var4, var5);
      }

      void a(int var1) {
         if (this.e.getColor() != var1) {
            this.e.setColor(var1);
            ViewCompat.c(this);
         }
      }

      void a(int var1, float var2) {
         if (this.i != null && this.i.isRunning()) {
            this.i.cancel();
         }

         this.a = var1;
         this.b = var2;
         this.c();
      }

      void a(int var1, int var2) {
         if (var1 != this.g || var2 != this.h) {
            this.g = var1;
            this.h = var2;
            ViewCompat.c(this);
         }
      }

      boolean a() {
         boolean var4 = false;
         int var2 = this.getChildCount();
         int var1 = 0;

         boolean var3;
         while (true) {
            var3 = var4;
            if (var1 >= var2) {
               break;
            }

            if (this.getChildAt(var1).getWidth() <= 0) {
               var3 = true;
               break;
            }

            var1++;
         }

         return var3;
      }

      float b() {
         return this.a + this.b;
      }

      void b(int var1) {
         if (this.d != var1) {
            this.d = var1;
            ViewCompat.c(this);
         }
      }

      void b(int var1, int var2) {
         if (this.i != null && this.i.isRunning()) {
            this.i.cancel();
         }

         boolean var3;
         if (ViewCompat.e(this) == 1) {
            var3 = 1;
         } else {
            var3 = 0;
         }

         View var7 = this.getChildAt(var1);
         if (var7 == null) {
            this.c();
         } else {
            int var5 = var7.getLeft();
            int var6 = var7.getRight();
            int var4;
            if (Math.abs(var1 - this.a) <= 1) {
               var3 = this.g;
               var4 = this.h;
            } else {
               var4 = this.c.b(24);
               if (var1 < this.a) {
                  if (var3) {
                     var4 = var5 - var4;
                     var3 = var4;
                  } else {
                     var4 = var6 + var4;
                     var3 = var4;
                  }
               } else if (var3) {
                  var4 = var6 + var4;
                  var3 = var4;
               } else {
                  var4 = var5 - var4;
                  var3 = var4;
               }
            }

            if (var3 != var5 || var4 != var6) {
               ValueAnimator var10 = new ValueAnimator();
               this.i = var10;
               var10.setInterpolator(AnimationUtils.b);
               var10.setDuration(var2);
               var10.setFloatValues(new float[]{0.0F, 1.0F});
               var10.addUpdateListener(new AnimatorUpdateListener(this, var3, var5, var4, var6) {
                  final int a;
                  final int b;
                  final int c;
                  final int d;
                  final TabLayout.SlidingTabStrip e;

                  {
                     this.e = var1;
                     this.a = var2x;
                     this.b = var3x;
                     this.c = var4x;
                     this.d = var5x;
                  }

                  public void onAnimationUpdate(ValueAnimator var1) {
                     float var2x = var1.getAnimatedFraction();
                     this.e.a(AnimationUtils.a(this.a, this.b, var2x), AnimationUtils.a(this.c, this.d, var2x));
                  }
               });
               var10.addListener(new AnimatorListenerAdapter(this, var1) {
                  final int a;
                  final TabLayout.SlidingTabStrip b;

                  {
                     this.b = var1;
                     this.a = var2x;
                  }

                  public void onAnimationEnd(Animator var1) {
                     this.b.a = this.a;
                     this.b.b = 0.0F;
                  }
               });
               var10.start();
            }
         }
      }

      public void draw(Canvas var1) {
         super.draw(var1);
         if (this.g >= 0 && this.h > this.g) {
            var1.drawRect(this.g, this.getHeight() - this.d, this.h, this.getHeight(), this.e);
         }
      }

      protected void onLayout(boolean var1, int var2, int var3, int var4, int var5) {
         super.onLayout(var1, var2, var3, var4, var5);
         if (this.i != null && this.i.isRunning()) {
            this.i.cancel();
            long var7 = this.i.getDuration();
            var2 = this.a;
            float var6 = this.i.getAnimatedFraction();
            this.b(var2, Math.round((float)var7 * (1.0F - var6)));
         } else {
            this.c();
         }
      }

      protected void onMeasure(int var1, int var2) {
         boolean var6 = false;
         super.onMeasure(var1, var2);
         if (MeasureSpec.getMode(var1) == 1073741824 && this.c.l == 1 && this.c.k == 1) {
            int var7 = this.getChildCount();
            int var5 = 0;
            int var4 = 0;

            while (var5 < var7) {
               View var8 = this.getChildAt(var5);
               int var3;
               if (var8.getVisibility() == 0) {
                  var3 = Math.max(var4, var8.getMeasuredWidth());
               } else {
                  var3 = var4;
               }

               var5++;
               var4 = var3;
            }

            if (var4 > 0) {
               int var9 = this.c.b(16);
               if (var4 * var7 <= this.getMeasuredWidth() - var9 * 2) {
                  var5 = 0;
                  boolean var10 = var6;

                  while (true) {
                     var6 = var10;
                     if (var5 >= var7) {
                        break;
                     }

                     android.widget.LinearLayout.LayoutParams var13 = (android.widget.LinearLayout.LayoutParams)this.getChildAt(var5).getLayoutParams();
                     if (var13.width != var4 || var13.weight != 0.0F) {
                        var13.width = var4;
                        var13.weight = 0.0F;
                        var10 = true;
                     }

                     var5++;
                  }
               } else {
                  this.c.k = 0;
                  this.c.a(false);
                  var6 = true;
               }

               if (var6) {
                  super.onMeasure(var1, var2);
               }
            }
         }
      }

      public void onRtlPropertiesChanged(int var1) {
         super.onRtlPropertiesChanged(var1);
         if (VERSION.SDK_INT < 23 && this.f != var1) {
            this.requestLayout();
            this.f = var1;
         }
      }
   }

   public static final class Tab {
      TabLayout a;
      TabLayout.TabView b;
      private Object c;
      private Drawable d;
      private CharSequence e;
      private CharSequence f;
      private int g = -1;
      private View h;

      Tab() {
      }

      public TabLayout.Tab a(int var1) {
         return this.a(LayoutInflater.from(this.b.getContext()).inflate(var1, this.b, false));
      }

      public TabLayout.Tab a(Drawable var1) {
         this.d = var1;
         this.h();
         return this;
      }

      public TabLayout.Tab a(View var1) {
         this.h = var1;
         this.h();
         return this;
      }

      public TabLayout.Tab a(CharSequence var1) {
         this.e = var1;
         this.h();
         return this;
      }

      public View a() {
         return this.h;
      }

      public Drawable b() {
         return this.d;
      }

      public TabLayout.Tab b(CharSequence var1) {
         this.f = var1;
         this.h();
         return this;
      }

      void b(int var1) {
         this.g = var1;
      }

      public int c() {
         return this.g;
      }

      public CharSequence d() {
         return this.e;
      }

      public void e() {
         if (this.a == null) {
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
         }

         this.a.b(this);
      }

      public boolean f() {
         if (this.a == null) {
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
         }

         boolean var1;
         if (this.a.getSelectedTabPosition() == this.g) {
            var1 = true;
         } else {
            var1 = false;
         }

         return var1;
      }

      public CharSequence g() {
         return this.f;
      }

      void h() {
         if (this.b != null) {
            this.b.b();
         }
      }

      void i() {
         this.a = null;
         this.b = null;
         this.c = null;
         this.d = null;
         this.e = null;
         this.f = null;
         this.g = -1;
         this.h = null;
      }
   }

   public static class TabLayoutOnPageChangeListener implements ViewPager.OnPageChangeListener {
      private final WeakReference<TabLayout> a;
      private int b;
      private int c;

      public TabLayoutOnPageChangeListener(TabLayout var1) {
         this.a = new WeakReference<>(var1);
      }

      void a() {
         this.c = 0;
         this.b = 0;
      }

      @Override
      public void a(int var1) {
         this.b = this.c;
         this.c = var1;
      }

      @Override
      public void a(int var1, float var2, int var3) {
         boolean var5 = false;
         TabLayout var6 = this.a.get();
         if (var6 != null) {
            boolean var4;
            if (this.c == 2 && this.b != 1) {
               var4 = false;
            } else {
               var4 = true;
            }

            if (this.c != 2 || this.b != 0) {
               var5 = true;
            }

            var6.a(var1, var2, var4, var5);
         }
      }

      @Override
      public void b(int var1) {
         TabLayout var3 = this.a.get();
         if (var3 != null && var3.getSelectedTabPosition() != var1 && var1 < var3.getTabCount()) {
            boolean var2;
            if (this.c != 0 && (this.c != 2 || this.b != 0)) {
               var2 = false;
            } else {
               var2 = true;
            }

            var3.b(var3.a(var1), var2);
         }
      }
   }

   class TabView extends LinearLayout {
      final TabLayout a;
      private TabLayout.Tab b;
      private TextView c;
      private ImageView d;
      private View e;
      private TextView f;
      private ImageView g;
      private int h;

      public TabView(TabLayout var1, Context var2) {
         super(var2);
         this.a = var1;
         this.h = 2;
         if (var1.i != 0) {
            ViewCompat.a(this, AppCompatResources.b(var2, var1.i));
         }

         ViewCompat.b(this, var1.a, var1.b, var1.c, var1.d);
         this.setGravity(17);
         this.setOrientation(1);
         this.setClickable(true);
         ViewCompat.a(this, PointerIconCompat.a(this.getContext(), 1002));
      }

      private float a(Layout var1, int var2, float var3) {
         return var1.getLineWidth(var2) * (var3 / var1.getPaint().getTextSize());
      }

      private void a(TextView var1, ImageView var2) {
         Object var8 = null;
         Drawable var6;
         if (this.b != null) {
            var6 = this.b.b();
         } else {
            var6 = null;
         }

         CharSequence var7;
         if (this.b != null) {
            var7 = this.b.d();
         } else {
            var7 = null;
         }

         CharSequence var5;
         if (this.b != null) {
            var5 = this.b.g();
         } else {
            var5 = null;
         }

         if (var2 != null) {
            if (var6 != null) {
               var2.setImageDrawable(var6);
               var2.setVisibility(0);
               this.setVisibility(0);
            } else {
               var2.setVisibility(8);
               var2.setImageDrawable(null);
            }

            var2.setContentDescription(var5);
         }

         boolean var3;
         if (!TextUtils.isEmpty(var7)) {
            var3 = true;
         } else {
            var3 = false;
         }

         if (var1 != null) {
            if (var3) {
               var1.setText(var7);
               var1.setVisibility(0);
               this.setVisibility(0);
            } else {
               var1.setVisibility(8);
               var1.setText(null);
            }

            var1.setContentDescription(var5);
         }

         if (var2 != null) {
            MarginLayoutParams var9 = (MarginLayoutParams)var2.getLayoutParams();
            int var4;
            if (var3 && var2.getVisibility() == 0) {
               var4 = this.a.b(8);
            } else {
               var4 = 0;
            }

            if (var4 != var9.bottomMargin) {
               var9.bottomMargin = var4;
               var2.requestLayout();
            }
         }

         CharSequence var10;
         if (var3) {
            var10 = (CharSequence)var8;
         } else {
            var10 = var5;
         }

         TooltipCompat.a(this, var10);
      }

      void a() {
         this.a(null);
         this.setSelected(false);
      }

      void a(TabLayout.Tab var1) {
         if (var1 != this.b) {
            this.b = var1;
            this.b();
         }
      }

      final void b() {
         TabLayout.Tab var3 = this.b;
         View var2;
         if (var3 != null) {
            var2 = var3.a();
         } else {
            var2 = null;
         }

         if (var2 != null) {
            ViewParent var4 = var2.getParent();
            if (var4 != this) {
               if (var4 != null) {
                  ((ViewGroup)var4).removeView(var2);
               }

               this.addView(var2);
            }

            this.e = var2;
            if (this.c != null) {
               this.c.setVisibility(8);
            }

            if (this.d != null) {
               this.d.setVisibility(8);
               this.d.setImageDrawable(null);
            }

            this.f = (TextView)var2.findViewById(16908308);
            if (this.f != null) {
               this.h = TextViewCompat.a(this.f);
            }

            this.g = (ImageView)var2.findViewById(16908294);
         } else {
            if (this.e != null) {
               this.removeView(this.e);
               this.e = null;
            }

            this.f = null;
            this.g = null;
         }

         if (this.e == null) {
            if (this.d == null) {
               ImageView var5 = (ImageView)LayoutInflater.from(this.getContext()).inflate(R.layout.design_layout_tab_icon, this, false);
               this.addView(var5, 0);
               this.d = var5;
            }

            if (this.c == null) {
               TextView var6 = (TextView)LayoutInflater.from(this.getContext()).inflate(R.layout.design_layout_tab_text, this, false);
               this.addView(var6);
               this.c = var6;
               this.h = TextViewCompat.a(this.c);
            }

            TextViewCompat.a(this.c, this.a.e);
            if (this.a.f != null) {
               this.c.setTextColor(this.a.f);
            }

            this.a(this.c, this.d);
         } else if (this.f != null || this.g != null) {
            this.a(this.f, this.g);
         }

         boolean var1;
         if (var3 != null && var3.f()) {
            var1 = true;
         } else {
            var1 = false;
         }

         this.setSelected(var1);
      }

      public void onInitializeAccessibilityEvent(AccessibilityEvent var1) {
         super.onInitializeAccessibilityEvent(var1);
         var1.setClassName(ActionBar.Tab.class.getName());
      }

      public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo var1) {
         super.onInitializeAccessibilityNodeInfo(var1);
         var1.setClassName(ActionBar.Tab.class.getName());
      }

      public void onMeasure(int var1, int var2) {
         int var5;
         boolean var7;
         var7 = true;
         int var9 = MeasureSpec.getSize(var1);
         int var8 = MeasureSpec.getMode(var1);
         int var6 = this.a.getTabMaxWidth();
         var5 = var1;
         label58:
         if (var6 > 0) {
            if (var8 != 0) {
               var5 = var1;
               if (var9 <= var6) {
                  break label58;
               }
            }

            var5 = MeasureSpec.makeMeasureSpec(this.a.j, Integer.MIN_VALUE);
         }

         super.onMeasure(var5, var2);
         if (this.c != null) {
            this.getResources();
            float var4 = this.a.g;
            var6 = this.h;
            float var3;
            if (this.d != null && this.d.getVisibility() == 0) {
               var1 = 1;
               var3 = var4;
            } else {
               var1 = var6;
               var3 = var4;
               if (this.c != null) {
                  var1 = var6;
                  var3 = var4;
                  if (this.c.getLineCount() > 1) {
                     var3 = this.a.h;
                     var1 = var6;
                  }
               }
            }

            var4 = this.c.getTextSize();
            var8 = this.c.getLineCount();
            var6 = TextViewCompat.a(this.c);
            if (var3 != var4 || var6 >= 0 && var1 != var6) {
               boolean var15 = var7;
               if (this.a.l == 1) {
                  var15 = var7;
                  if (var3 > var4) {
                     var15 = var7;
                     label34:
                     if (var8 == 1) {
                        Layout var10 = this.c.getLayout();
                        if (var10 != null) {
                           var15 = var7;
                           if (!(this.a(var10, 0, var3) > this.getMeasuredWidth() - this.getPaddingLeft() - this.getPaddingRight())) {
                              break label34;
                           }
                        }

                        var15 = false;
                     }
                  }
               }

               if (var15) {
                  this.c.setTextSize(0, var3);
                  this.c.setMaxLines(var1);
                  super.onMeasure(var5, var2);
               }
            }
         }
      }

      public boolean performClick() {
         boolean var2 = super.performClick();
         boolean var1 = var2;
         if (this.b != null) {
            if (!var2) {
               this.playSoundEffect(0);
            }

            this.b.e();
            var1 = true;
         }

         return var1;
      }

      public void setSelected(boolean var1) {
         boolean var2;
         if (this.isSelected() != var1) {
            var2 = true;
         } else {
            var2 = false;
         }

         super.setSelected(var1);
         if (var2 && var1 && VERSION.SDK_INT < 16) {
            this.sendAccessibilityEvent(4);
         }

         if (this.c != null) {
            this.c.setSelected(var1);
         }

         if (this.d != null) {
            this.d.setSelected(var1);
         }

         if (this.e != null) {
            this.e.setSelected(var1);
         }
      }
   }

   public static class ViewPagerOnTabSelectedListener implements TabLayout.OnTabSelectedListener {
      private final ViewPager a;

      public ViewPagerOnTabSelectedListener(ViewPager var1) {
         this.a = var1;
      }

      @Override
      public void a(TabLayout.Tab var1) {
         this.a.setCurrentItem(var1.c());
      }

      @Override
      public void b(TabLayout.Tab var1) {
      }

      @Override
      public void c(TabLayout.Tab var1) {
      }
   }
}
