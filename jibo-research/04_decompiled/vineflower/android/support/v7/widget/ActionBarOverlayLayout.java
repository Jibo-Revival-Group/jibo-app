package android.support.v7.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.view.NestedScrollingParent;
import android.support.v4.view.NestedScrollingParentHelper;
import android.support.v4.view.ViewCompat;
import android.support.v7.appcompat.R;
import android.support.v7.view.menu.MenuPresenter;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.Window.Callback;
import android.widget.OverScroller;

public class ActionBarOverlayLayout extends ViewGroup implements NestedScrollingParent, DecorContentParent {
   static final int[] e = new int[]{R.attr.actionBarSize, 16842841};
   private final Runnable A;
   private final Runnable B;
   private final NestedScrollingParentHelper C;
   ActionBarContainer a;
   boolean b;
   ViewPropertyAnimator c;
   final AnimatorListenerAdapter d;
   private int f;
   private int g = 0;
   private ContentFrameLayout h;
   private DecorToolbar i;
   private Drawable j;
   private boolean k;
   private boolean l;
   private boolean m;
   private boolean n;
   private int o;
   private int p;
   private final Rect q = new Rect();
   private final Rect r = new Rect();
   private final Rect s = new Rect();
   private final Rect t = new Rect();
   private final Rect u = new Rect();
   private final Rect v = new Rect();
   private final Rect w = new Rect();
   private ActionBarOverlayLayout.ActionBarVisibilityCallback x;
   private final int y = 600;
   private OverScroller z;

   public ActionBarOverlayLayout(Context var1) {
      this(var1, null);
   }

   public ActionBarOverlayLayout(Context var1, AttributeSet var2) {
      super(var1, var2);
      this.d = new AnimatorListenerAdapter(this) {
         final ActionBarOverlayLayout a;

         {
            this.a = var1;
         }

         public void onAnimationCancel(Animator var1) {
            this.a.c = null;
            this.a.b = false;
         }

         public void onAnimationEnd(Animator var1) {
            this.a.c = null;
            this.a.b = false;
         }
      };
      this.A = new Runnable(this) {
         final ActionBarOverlayLayout a;

         {
            this.a = var1;
         }

         @Override
         public void run() {
            this.a.e();
            this.a.c = this.a.a.animate().translationY(0.0F).setListener(this.a.d);
         }
      };
      this.B = new Runnable(this) {
         final ActionBarOverlayLayout a;

         {
            this.a = var1;
         }

         @Override
         public void run() {
            this.a.e();
            this.a.c = this.a.a.animate().translationY(-this.a.a.getHeight()).setListener(this.a.d);
         }
      };
      this.a(var1);
      this.C = new NestedScrollingParentHelper(this);
   }

   private DecorToolbar a(View var1) {
      DecorToolbar var2;
      if (var1 instanceof DecorToolbar) {
         var2 = (DecorToolbar)var1;
      } else {
         if (!(var1 instanceof Toolbar)) {
            throw new IllegalStateException("Can't make a decor toolbar out of " + var1.getClass().getSimpleName());
         }

         var2 = ((Toolbar)var1).getWrapper();
      }

      return var2;
   }

   private void a(Context var1) {
      boolean var3 = true;
      TypedArray var4 = this.getContext().getTheme().obtainStyledAttributes(e);
      this.f = var4.getDimensionPixelSize(0, 0);
      this.j = var4.getDrawable(1);
      boolean var2;
      if (this.j == null) {
         var2 = true;
      } else {
         var2 = false;
      }

      this.setWillNotDraw(var2);
      var4.recycle();
      if (var1.getApplicationInfo().targetSdkVersion < 19) {
         var2 = var3;
      } else {
         var2 = false;
      }

      this.k = var2;
      this.z = new OverScroller(var1);
   }

   private boolean a(float var1, float var2) {
      boolean var3 = false;
      this.z.fling(0, 0, 0, (int)var2, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
      if (this.z.getFinalY() > this.a.getHeight()) {
         var3 = true;
      }

      return var3;
   }

   private boolean a(View var1, Rect var2, boolean var3, boolean var4, boolean var5, boolean var6) {
      boolean var8 = false;
      ActionBarOverlayLayout.LayoutParams var9 = (ActionBarOverlayLayout.LayoutParams)var1.getLayoutParams();
      boolean var7 = var8;
      if (var3) {
         var7 = var8;
         if (var9.leftMargin != var2.left) {
            var9.leftMargin = var2.left;
            var7 = true;
         }
      }

      var3 = var7;
      if (var4) {
         var3 = var7;
         if (var9.topMargin != var2.top) {
            var9.topMargin = var2.top;
            var3 = true;
         }
      }

      var4 = var3;
      if (var6) {
         var4 = var3;
         if (var9.rightMargin != var2.right) {
            var9.rightMargin = var2.right;
            var4 = true;
         }
      }

      if (var5 && var9.bottomMargin != var2.bottom) {
         var9.bottomMargin = var2.bottom;
         var4 = true;
      }

      return var4;
   }

   private void m() {
      this.e();
      this.postDelayed(this.A, 600L);
   }

   private void n() {
      this.e();
      this.postDelayed(this.B, 600L);
   }

   private void o() {
      this.e();
      this.A.run();
   }

   private void p() {
      this.e();
      this.B.run();
   }

   public ActionBarOverlayLayout.LayoutParams a(AttributeSet var1) {
      return new ActionBarOverlayLayout.LayoutParams(this.getContext(), var1);
   }

   @Override
   public void a(int var1) {
      this.c();
      switch (var1) {
         case 2:
            this.i.g();
            break;
         case 5:
            this.i.h();
            break;
         case 109:
            this.setOverlayMode(true);
      }
   }

   @Override
   public void a(Menu var1, MenuPresenter.Callback var2) {
      this.c();
      this.i.a(var1, var2);
   }

   public boolean a() {
      return this.l;
   }

   protected ActionBarOverlayLayout.LayoutParams b() {
      return new ActionBarOverlayLayout.LayoutParams(-1, -1);
   }

   void c() {
      if (this.h == null) {
         this.h = (ContentFrameLayout)this.findViewById(R.id.action_bar_activity_content);
         this.a = (ActionBarContainer)this.findViewById(R.id.action_bar_container);
         this.i = this.a(this.findViewById(R.id.action_bar));
      }
   }

   protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams var1) {
      return var1 instanceof ActionBarOverlayLayout.LayoutParams;
   }

   public boolean d() {
      return this.n;
   }

   public void draw(Canvas var1) {
      super.draw(var1);
      if (this.j != null && !this.k) {
         int var2;
         if (this.a.getVisibility() == 0) {
            var2 = (int)(this.a.getBottom() + this.a.getTranslationY() + 0.5F);
         } else {
            var2 = 0;
         }

         this.j.setBounds(0, var2, this.getWidth(), this.j.getIntrinsicHeight() + var2);
         this.j.draw(var1);
      }
   }

   void e() {
      this.removeCallbacks(this.A);
      this.removeCallbacks(this.B);
      if (this.c != null) {
         this.c.cancel();
      }
   }

   @Override
   public boolean f() {
      this.c();
      return this.i.i();
   }

   protected boolean fitSystemWindows(Rect var1) {
      this.c();
      if ((ViewCompat.p(this) & 256) != 0) {
      }

      boolean var2 = this.a(this.a, var1, true, true, false, true);
      this.t.set(var1);
      ViewUtils.a(this, this.t, this.q);
      if (!this.u.equals(this.t)) {
         this.u.set(this.t);
         var2 = true;
      }

      if (!this.r.equals(this.q)) {
         this.r.set(this.q);
         var2 = true;
      }

      if (var2) {
         this.requestLayout();
      }

      return true;
   }

   @Override
   public boolean g() {
      this.c();
      return this.i.j();
   }

   protected android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams var1) {
      return new ActionBarOverlayLayout.LayoutParams(var1);
   }

   public int getActionBarHideOffset() {
      int var1;
      if (this.a != null) {
         var1 = -((int)this.a.getTranslationY());
      } else {
         var1 = 0;
      }

      return var1;
   }

   public int getNestedScrollAxes() {
      return this.C.a();
   }

   public CharSequence getTitle() {
      this.c();
      return this.i.e();
   }

   @Override
   public boolean h() {
      this.c();
      return this.i.k();
   }

   @Override
   public boolean i() {
      this.c();
      return this.i.l();
   }

   @Override
   public boolean j() {
      this.c();
      return this.i.m();
   }

   @Override
   public void k() {
      this.c();
      this.i.n();
   }

   @Override
   public void l() {
      this.c();
      this.i.o();
   }

   protected void onConfigurationChanged(Configuration var1) {
      super.onConfigurationChanged(var1);
      this.a(this.getContext());
      ViewCompat.q(this);
   }

   protected void onDetachedFromWindow() {
      super.onDetachedFromWindow();
      this.e();
   }

   protected void onLayout(boolean var1, int var2, int var3, int var4, int var5) {
      var3 = this.getChildCount();
      var4 = this.getPaddingLeft();
      this.getPaddingRight();
      var5 = this.getPaddingTop();
      this.getPaddingBottom();

      for (int var12 = 0; var12 < var3; var12++) {
         View var10 = this.getChildAt(var12);
         if (var10.getVisibility() != 8) {
            ActionBarOverlayLayout.LayoutParams var11 = (ActionBarOverlayLayout.LayoutParams)var10.getLayoutParams();
            int var8 = var10.getMeasuredWidth();
            int var9 = var10.getMeasuredHeight();
            int var7 = var11.leftMargin + var4;
            int var6 = var11.topMargin + var5;
            var10.layout(var7, var6, var8 + var7, var9 + var6);
         }
      }
   }

   protected void onMeasure(int var1, int var2) {
      this.c();
      this.measureChildWithMargins(this.a, var1, 0, var2, 0);
      ActionBarOverlayLayout.LayoutParams var9 = (ActionBarOverlayLayout.LayoutParams)this.a.getLayoutParams();
      int var8 = Math.max(0, this.a.getMeasuredWidth() + var9.leftMargin + var9.rightMargin);
      int var4 = this.a.getMeasuredHeight();
      int var3 = var9.topMargin;
      int var7 = Math.max(0, var9.bottomMargin + var4 + var3);
      int var6 = View.combineMeasuredStates(0, this.a.getMeasuredState());
      boolean var12;
      if ((ViewCompat.p(this) & 256) != 0) {
         var12 = 1;
      } else {
         var12 = 0;
      }

      if (var12) {
         int var5 = this.f;
         var3 = var5;
         if (this.m) {
            var3 = var5;
            if (this.a.getTabContainer() != null) {
               var3 = var5 + this.f;
            }
         }
      } else if (this.a.getVisibility() != 8) {
         var3 = this.a.getMeasuredHeight();
      } else {
         var3 = 0;
      }

      this.s.set(this.q);
      this.v.set(this.t);
      if (!this.l && !var12) {
         Rect var22 = this.s;
         var22.top += var3;
         Rect var23 = this.s;
         var23.bottom += 0;
      } else {
         Rect var20 = this.v;
         var20.top += var3;
         Rect var21 = this.v;
         var21.bottom += 0;
      }

      this.a(this.h, this.s, true, true, true, true);
      if (!this.w.equals(this.v)) {
         this.w.set(this.v);
         this.h.a(this.v);
      }

      this.measureChildWithMargins(this.h, var1, 0, var2, 0);
      var9 = (ActionBarOverlayLayout.LayoutParams)this.h.getLayoutParams();
      var3 = Math.max(var8, this.h.getMeasuredWidth() + var9.leftMargin + var9.rightMargin);
      int var15 = this.h.getMeasuredHeight();
      var12 = var9.topMargin;
      var7 = Math.max(var7, var9.bottomMargin + var15 + var12);
      var12 = View.combineMeasuredStates(var6, this.h.getMeasuredState());
      var15 = this.getPaddingLeft();
      var6 = this.getPaddingRight();
      var7 = Math.max(var7 + this.getPaddingTop() + this.getPaddingBottom(), this.getSuggestedMinimumHeight());
      this.setMeasuredDimension(
         View.resolveSizeAndState(Math.max(var3 + var15 + var6, this.getSuggestedMinimumWidth()), var1, var12),
         View.resolveSizeAndState(var7, var2, var12 << 16)
      );
   }

   @Override
   public boolean onNestedFling(View var1, float var2, float var3, boolean var4) {
      boolean var5 = true;
      if (this.n && var4) {
         if (this.a(var2, var3)) {
            this.p();
         } else {
            this.o();
         }

         this.b = true;
         var4 = var5;
      } else {
         var4 = false;
      }

      return var4;
   }

   @Override
   public boolean onNestedPreFling(View var1, float var2, float var3) {
      return false;
   }

   @Override
   public void onNestedPreScroll(View var1, int var2, int var3, int[] var4) {
   }

   @Override
   public void onNestedScroll(View var1, int var2, int var3, int var4, int var5) {
      this.o += var3;
      this.setActionBarHideOffset(this.o);
   }

   @Override
   public void onNestedScrollAccepted(View var1, View var2, int var3) {
      this.C.a(var1, var2, var3);
      this.o = this.getActionBarHideOffset();
      this.e();
      if (this.x != null) {
         this.x.d();
      }
   }

   @Override
   public boolean onStartNestedScroll(View var1, View var2, int var3) {
      boolean var4;
      if ((var3 & 2) != 0 && this.a.getVisibility() == 0) {
         var4 = this.n;
      } else {
         var4 = false;
      }

      return var4;
   }

   @Override
   public void onStopNestedScroll(View var1) {
      if (this.n && !this.b) {
         if (this.o <= this.a.getHeight()) {
            this.m();
         } else {
            this.n();
         }
      }

      if (this.x != null) {
         this.x.e();
      }
   }

   public void onWindowSystemUiVisibilityChanged(int var1) {
      boolean var5 = true;
      if (VERSION.SDK_INT >= 16) {
         super.onWindowSystemUiVisibilityChanged(var1);
      }

      this.c();
      int var4 = this.p;
      this.p = var1;
      boolean var2;
      if ((var1 & 4) == 0) {
         var2 = true;
      } else {
         var2 = false;
      }

      boolean var3;
      if ((var1 & 256) != 0) {
         var3 = true;
      } else {
         var3 = false;
      }

      if (this.x != null) {
         ActionBarOverlayLayout.ActionBarVisibilityCallback var6 = this.x;
         if (var3) {
            var5 = false;
         }

         var6.a(var5);
         if (!var2 && var3) {
            this.x.c();
         } else {
            this.x.b();
         }
      }

      if (((var4 ^ var1) & 256) != 0 && this.x != null) {
         ViewCompat.q(this);
      }
   }

   protected void onWindowVisibilityChanged(int var1) {
      super.onWindowVisibilityChanged(var1);
      this.g = var1;
      if (this.x != null) {
         this.x.a(var1);
      }
   }

   public void setActionBarHideOffset(int var1) {
      this.e();
      var1 = Math.max(0, Math.min(var1, this.a.getHeight()));
      this.a.setTranslationY(-var1);
   }

   public void setActionBarVisibilityCallback(ActionBarOverlayLayout.ActionBarVisibilityCallback var1) {
      this.x = var1;
      if (this.getWindowToken() != null) {
         this.x.a(this.g);
         if (this.p != 0) {
            this.onWindowSystemUiVisibilityChanged(this.p);
            ViewCompat.q(this);
         }
      }
   }

   public void setHasNonEmbeddedTabs(boolean var1) {
      this.m = var1;
   }

   public void setHideOnContentScrollEnabled(boolean var1) {
      if (var1 != this.n) {
         this.n = var1;
         if (!var1) {
            this.e();
            this.setActionBarHideOffset(0);
         }
      }
   }

   public void setIcon(int var1) {
      this.c();
      this.i.a(var1);
   }

   public void setIcon(Drawable var1) {
      this.c();
      this.i.a(var1);
   }

   public void setLogo(int var1) {
      this.c();
      this.i.b(var1);
   }

   public void setOverlayMode(boolean var1) {
      this.l = var1;
      if (var1 && this.getContext().getApplicationInfo().targetSdkVersion < 19) {
         var1 = true;
      } else {
         var1 = false;
      }

      this.k = var1;
   }

   public void setShowingForActionMode(boolean var1) {
   }

   public void setUiOptions(int var1) {
   }

   @Override
   public void setWindowCallback(Callback var1) {
      this.c();
      this.i.a(var1);
   }

   @Override
   public void setWindowTitle(CharSequence var1) {
      this.c();
      this.i.a(var1);
   }

   public boolean shouldDelayChildPressedState() {
      return false;
   }

   public interface ActionBarVisibilityCallback {
      void a(int var1);

      void a(boolean var1);

      void b();

      void c();

      void d();

      void e();
   }

   public static class LayoutParams extends MarginLayoutParams {
      public LayoutParams(int var1, int var2) {
         super(var1, var2);
      }

      public LayoutParams(Context var1, AttributeSet var2) {
         super(var1, var2);
      }

      public LayoutParams(android.view.ViewGroup.LayoutParams var1) {
         super(var1);
      }
   }
}
