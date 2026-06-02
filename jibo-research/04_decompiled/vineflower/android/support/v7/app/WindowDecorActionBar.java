package android.support.v7.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v4.view.ViewPropertyAnimatorListener;
import android.support.v4.view.ViewPropertyAnimatorListenerAdapter;
import android.support.v4.view.ViewPropertyAnimatorUpdateListener;
import android.support.v7.appcompat.R;
import android.support.v7.view.ActionBarPolicy;
import android.support.v7.view.ActionMode;
import android.support.v7.view.SupportMenuInflater;
import android.support.v7.view.ViewPropertyAnimatorCompatSet;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.widget.ActionBarContainer;
import android.support.v7.widget.ActionBarContextView;
import android.support.v7.widget.ActionBarOverlayLayout;
import android.support.v7.widget.DecorToolbar;
import android.support.v7.widget.ScrollingTabContainerView;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.SpinnerAdapter;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class WindowDecorActionBar extends ActionBar implements ActionBarOverlayLayout.ActionBarVisibilityCallback {
   static final boolean s;
   private static final Interpolator t;
   private static final Interpolator u;
   private int A;
   private boolean B;
   private boolean C;
   private ArrayList<ActionBar.OnMenuVisibilityListener> D;
   private boolean E;
   private int F;
   private boolean G;
   private boolean H;
   private boolean I;
   Context a;
   ActionBarOverlayLayout b;
   ActionBarContainer c;
   DecorToolbar d;
   ActionBarContextView e;
   View f;
   ScrollingTabContainerView g;
   WindowDecorActionBar.ActionModeImpl h;
   ActionMode i;
   ActionMode.Callback j;
   boolean k;
   boolean l;
   boolean m;
   ViewPropertyAnimatorCompatSet n;
   boolean o;
   final ViewPropertyAnimatorListener p;
   final ViewPropertyAnimatorListener q;
   final ViewPropertyAnimatorUpdateListener r;
   private Context v;
   private Activity w;
   private Dialog x;
   private ArrayList<WindowDecorActionBar.TabImpl> y = new ArrayList<>();
   private WindowDecorActionBar.TabImpl z;

   static {
      boolean var0;
      if (!WindowDecorActionBar.class.desiredAssertionStatus()) {
         var0 = true;
      } else {
         var0 = false;
      }

      s = var0;
      t = new AccelerateInterpolator();
      u = new DecelerateInterpolator();
   }

   public WindowDecorActionBar(Activity var1, boolean var2) {
      this.A = -1;
      this.D = new ArrayList<>();
      this.F = 0;
      this.k = true;
      this.H = true;
      this.p = new ViewPropertyAnimatorListenerAdapter(this) {
         final WindowDecorActionBar a;

         {
            this.a = var1;
         }

         @Override
         public void b(View var1) {
            if (this.a.k && this.a.f != null) {
               this.a.f.setTranslationY(0.0F);
               this.a.c.setTranslationY(0.0F);
            }

            this.a.c.setVisibility(8);
            this.a.c.setTransitioning(false);
            this.a.n = null;
            this.a.a();
            if (this.a.b != null) {
               ViewCompat.q(this.a.b);
            }
         }
      };
      this.q = new ViewPropertyAnimatorListenerAdapter(this) {
         final WindowDecorActionBar a;

         {
            this.a = var1;
         }

         @Override
         public void b(View var1) {
            this.a.n = null;
            this.a.c.requestLayout();
         }
      };
      this.r = new ViewPropertyAnimatorUpdateListener(this) {
         final WindowDecorActionBar a;

         {
            this.a = var1;
         }

         @Override
         public void a(View var1) {
            ((View)this.a.c.getParent()).invalidate();
         }
      };
      this.w = var1;
      View var3 = var1.getWindow().getDecorView();
      this.a(var3);
      if (!var2) {
         this.f = var3.findViewById(16908290);
      }
   }

   public WindowDecorActionBar(Dialog var1) {
      this.A = -1;
      this.D = new ArrayList<>();
      this.F = 0;
      this.k = true;
      this.H = true;
      this.p = new ViewPropertyAnimatorListenerAdapter(this) {
         final WindowDecorActionBar a;

         {
            this.a = var1;
         }

         @Override
         public void b(View var1) {
            if (this.a.k && this.a.f != null) {
               this.a.f.setTranslationY(0.0F);
               this.a.c.setTranslationY(0.0F);
            }

            this.a.c.setVisibility(8);
            this.a.c.setTransitioning(false);
            this.a.n = null;
            this.a.a();
            if (this.a.b != null) {
               ViewCompat.q(this.a.b);
            }
         }
      };
      this.q = new ViewPropertyAnimatorListenerAdapter(this) {
         final WindowDecorActionBar a;

         {
            this.a = var1;
         }

         @Override
         public void b(View var1) {
            this.a.n = null;
            this.a.c.requestLayout();
         }
      };
      this.r = new ViewPropertyAnimatorUpdateListener(this) {
         final WindowDecorActionBar a;

         {
            this.a = var1;
         }

         @Override
         public void a(View var1) {
            ((View)this.a.c.getParent()).invalidate();
         }
      };
      this.x = var1;
      this.a(var1.getWindow().getDecorView());
   }

   private void a(ActionBar.Tab var1, int var2) {
      var1 = var1;
      if (var1.g() == null) {
         throw new IllegalStateException("Action Bar Tab must have a Callback");
      }

      var1.a(var2);
      this.y.add(var2, var1);
      int var3 = this.y.size();
      var2++;

      while (var2 < var3) {
         this.y.get(var2).a(var2);
         var2++;
      }
   }

   private void a(View var1) {
      this.b = (ActionBarOverlayLayout)var1.findViewById(R.id.decor_content_parent);
      if (this.b != null) {
         this.b.setActionBarVisibilityCallback(this);
      }

      this.d = this.b(var1.findViewById(R.id.action_bar));
      this.e = (ActionBarContextView)var1.findViewById(R.id.action_context_bar);
      this.c = (ActionBarContainer)var1.findViewById(R.id.action_bar_container);
      if (this.d != null && this.e != null && this.c != null) {
         this.a = this.d.b();
         boolean var2;
         if ((this.d.p() & 4) != 0) {
            var2 = 1;
         } else {
            var2 = 0;
         }

         if (var2) {
            this.B = true;
         }

         ActionBarPolicy var4 = ActionBarPolicy.a(this.a);
         boolean var3;
         if (!var4.f() && !var2) {
            var3 = false;
         } else {
            var3 = true;
         }

         this.setHomeButtonEnabled(var3);
         this.e(var4.d());
         TypedArray var5 = this.a.obtainStyledAttributes(null, R.styleable.ActionBar, R.attr.actionBarStyle, 0);
         if (var5.getBoolean(R.styleable.ActionBar_hideOnContentScroll, false)) {
            this.setHideOnContentScrollEnabled(true);
         }

         var2 = var5.getDimensionPixelSize(R.styleable.ActionBar_elevation, 0);
         if (var2 != 0) {
            this.setElevation(var2);
         }

         var5.recycle();
      } else {
         throw new IllegalStateException(this.getClass().getSimpleName() + " can only be used " + "with a compatible window decor layout");
      }
   }

   static boolean a(boolean var0, boolean var1, boolean var2) {
      boolean var3 = true;
      if (var2) {
         var0 = var3;
      } else {
         if (!var0) {
            var0 = var3;
            if (!var1) {
               return var0;
            }
         }

         var0 = false;
      }

      return var0;
   }

   private DecorToolbar b(View var1) {
      DecorToolbar var2;
      if (var1 instanceof DecorToolbar) {
         var2 = (DecorToolbar)var1;
      } else {
         if (!(var1 instanceof Toolbar)) {
            String var3;
            if ("Can't make a decor toolbar out of " + var1 != null) {
               var3 = var1.getClass().getSimpleName();
            } else {
               var3 = "null";
            }

            throw new IllegalStateException(var3);
         }

         var2 = ((Toolbar)var1).getWrapper();
      }

      return var2;
   }

   private void e(boolean var1) {
      boolean var3 = true;
      this.E = var1;
      if (!this.E) {
         this.d.a((ScrollingTabContainerView)null);
         this.c.setTabContainer(this.g);
      } else {
         this.c.setTabContainer(null);
         this.d.a(this.g);
      }

      boolean var2;
      if (this.getNavigationMode() == 2) {
         var2 = true;
      } else {
         var2 = false;
      }

      if (this.g != null) {
         if (var2) {
            this.g.setVisibility(0);
            if (this.b != null) {
               ViewCompat.q(this.b);
            }
         } else {
            this.g.setVisibility(8);
         }
      }

      DecorToolbar var4 = this.d;
      if (!this.E && var2) {
         var1 = true;
      } else {
         var1 = false;
      }

      var4.a(var1);
      ActionBarOverlayLayout var7 = this.b;
      if (!this.E && var2) {
         var1 = var3;
      } else {
         var1 = false;
      }

      var7.setHasNonEmbeddedTabs(var1);
   }

   private void f() {
      if (this.g == null) {
         ScrollingTabContainerView var1 = new ScrollingTabContainerView(this.a);
         if (this.E) {
            var1.setVisibility(0);
            this.d.a(var1);
         } else {
            if (this.getNavigationMode() == 2) {
               var1.setVisibility(0);
               if (this.b != null) {
                  ViewCompat.q(this.b);
               }
            } else {
               var1.setVisibility(8);
            }

            this.c.setTabContainer(var1);
         }

         this.g = var1;
      }
   }

   private void f(boolean var1) {
      if (a(this.l, this.m, this.G)) {
         if (!this.H) {
            this.H = true;
            this.b(var1);
         }
      } else if (this.H) {
         this.H = false;
         this.c(var1);
      }
   }

   private void g() {
      if (this.z != null) {
         this.selectTab(null);
      }

      this.y.clear();
      if (this.g != null) {
         this.g.a();
      }

      this.A = -1;
   }

   private void h() {
      if (!this.G) {
         this.G = true;
         if (this.b != null) {
            this.b.setShowingForActionMode(true);
         }

         this.f(false);
      }
   }

   private void i() {
      if (this.G) {
         this.G = false;
         if (this.b != null) {
            this.b.setShowingForActionMode(false);
         }

         this.f(false);
      }
   }

   private boolean j() {
      return ViewCompat.y(this.c);
   }

   void a() {
      if (this.j != null) {
         this.j.a(this.i);
         this.i = null;
         this.j = null;
      }
   }

   @Override
   public void a(int var1) {
      this.F = var1;
   }

   @Override
   public void a(boolean var1) {
      this.k = var1;
   }

   @Override
   public void addOnMenuVisibilityListener(ActionBar.OnMenuVisibilityListener var1) {
      this.D.add(var1);
   }

   @Override
   public void addTab(ActionBar.Tab var1) {
      this.addTab(var1, this.y.isEmpty());
   }

   @Override
   public void addTab(ActionBar.Tab var1, int var2) {
      this.addTab(var1, var2, this.y.isEmpty());
   }

   @Override
   public void addTab(ActionBar.Tab var1, int var2, boolean var3) {
      this.f();
      this.g.a(var1, var2, var3);
      this.a(var1, var2);
      if (var3) {
         this.selectTab(var1);
      }
   }

   @Override
   public void addTab(ActionBar.Tab var1, boolean var2) {
      this.f();
      this.g.b(var1, var2);
      this.a(var1, this.y.size());
      if (var2) {
         this.selectTab(var1);
      }
   }

   @Override
   public void b() {
      if (this.m) {
         this.m = false;
         this.f(true);
      }
   }

   public void b(boolean var1) {
      if (this.n != null) {
         this.n.c();
      }

      this.c.setVisibility(0);
      if (this.F == 0 && (this.I || var1)) {
         this.c.setTranslationY(0.0F);
         float var3 = -this.c.getHeight();
         float var2 = var3;
         if (var1) {
            int[] var4 = new int[]{0, 0};
            this.c.getLocationInWindow(var4);
            var2 = var3 - var4[1];
         }

         this.c.setTranslationY(var2);
         ViewPropertyAnimatorCompatSet var5 = new ViewPropertyAnimatorCompatSet();
         ViewPropertyAnimatorCompat var6 = ViewCompat.l(this.c).b(0.0F);
         var6.a(this.r);
         var5.a(var6);
         if (this.k && this.f != null) {
            this.f.setTranslationY(var2);
            var5.a(ViewCompat.l(this.f).b(0.0F));
         }

         var5.a(u);
         var5.a(250L);
         var5.a(this.q);
         this.n = var5;
         var5.a();
      } else {
         this.c.setAlpha(1.0F);
         this.c.setTranslationY(0.0F);
         if (this.k && this.f != null) {
            this.f.setTranslationY(0.0F);
         }

         this.q.b(null);
      }

      if (this.b != null) {
         ViewCompat.q(this.b);
      }
   }

   @Override
   public void c() {
      if (!this.m) {
         this.m = true;
         this.f(true);
      }
   }

   public void c(boolean var1) {
      if (this.n != null) {
         this.n.c();
      }

      if (this.F == 0 && (this.I || var1)) {
         this.c.setAlpha(1.0F);
         this.c.setTransitioning(true);
         ViewPropertyAnimatorCompatSet var4 = new ViewPropertyAnimatorCompatSet();
         float var3 = -this.c.getHeight();
         float var2 = var3;
         if (var1) {
            int[] var5 = new int[]{0, 0};
            this.c.getLocationInWindow(var5);
            var2 = var3 - var5[1];
         }

         ViewPropertyAnimatorCompat var6 = ViewCompat.l(this.c).b(var2);
         var6.a(this.r);
         var4.a(var6);
         if (this.k && this.f != null) {
            var4.a(ViewCompat.l(this.f).b(var2));
         }

         var4.a(t);
         var4.a(250L);
         var4.a(this.p);
         this.n = var4;
         var4.a();
      } else {
         this.p.b(null);
      }
   }

   @Override
   public boolean collapseActionView() {
      boolean var1;
      if (this.d != null && this.d.c()) {
         this.d.d();
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   @Override
   public void d() {
      if (this.n != null) {
         this.n.c();
         this.n = null;
      }
   }

   public void d(boolean var1) {
      if (var1) {
         this.h();
      } else {
         this.i();
      }

      if (this.j()) {
         ViewPropertyAnimatorCompat var2;
         ViewPropertyAnimatorCompat var3;
         if (var1) {
            var3 = this.d.a(4, 100L);
            var2 = this.e.a(0, 200L);
         } else {
            var2 = this.d.a(0, 200L);
            var3 = this.e.a(8, 100L);
         }

         ViewPropertyAnimatorCompatSet var4 = new ViewPropertyAnimatorCompatSet();
         var4.a(var3, var2);
         var4.a();
      } else if (var1) {
         this.d.h(4);
         this.e.setVisibility(0);
      } else {
         this.d.h(0);
         this.e.setVisibility(8);
      }
   }

   @Override
   public void dispatchMenuVisibilityChanged(boolean var1) {
      if (var1 != this.C) {
         this.C = var1;
         int var3 = this.D.size();

         for (int var2 = 0; var2 < var3; var2++) {
            this.D.get(var2).a(var1);
         }
      }
   }

   @Override
   public void e() {
   }

   @Override
   public View getCustomView() {
      return this.d.u();
   }

   @Override
   public int getDisplayOptions() {
      return this.d.p();
   }

   @Override
   public float getElevation() {
      return ViewCompat.m(this.c);
   }

   @Override
   public int getHeight() {
      return this.c.getHeight();
   }

   @Override
   public int getHideOffset() {
      return this.b.getActionBarHideOffset();
   }

   @Override
   public int getNavigationItemCount() {
      int var1;
      switch (this.d.r()) {
         case 1:
            var1 = this.d.t();
            break;
         case 2:
            var1 = this.y.size();
            break;
         default:
            var1 = 0;
      }

      return var1;
   }

   @Override
   public int getNavigationMode() {
      return this.d.r();
   }

   @Override
   public int getSelectedNavigationIndex() {
      int var1 = -1;
      switch (this.d.r()) {
         case 1:
            var1 = this.d.s();
            break;
         case 2:
            if (this.z != null) {
               var1 = this.z.a();
            }
      }

      return var1;
   }

   @Override
   public ActionBar.Tab getSelectedTab() {
      return this.z;
   }

   @Override
   public CharSequence getSubtitle() {
      return this.d.f();
   }

   @Override
   public ActionBar.Tab getTabAt(int var1) {
      return this.y.get(var1);
   }

   @Override
   public int getTabCount() {
      return this.y.size();
   }

   @Override
   public Context getThemedContext() {
      if (this.v == null) {
         TypedValue var2 = new TypedValue();
         this.a.getTheme().resolveAttribute(R.attr.actionBarWidgetTheme, var2, true);
         int var1 = var2.resourceId;
         if (var1 != 0) {
            this.v = new ContextThemeWrapper(this.a, var1);
         } else {
            this.v = this.a;
         }
      }

      return this.v;
   }

   @Override
   public CharSequence getTitle() {
      return this.d.e();
   }

   @Override
   public void hide() {
      if (!this.l) {
         this.l = true;
         this.f(false);
      }
   }

   @Override
   public boolean isHideOnContentScrollEnabled() {
      return this.b.d();
   }

   @Override
   public boolean isShowing() {
      int var1 = this.getHeight();
      boolean var2;
      if (!this.H || var1 != 0 && this.getHideOffset() >= var1) {
         var2 = false;
      } else {
         var2 = true;
      }

      return var2;
   }

   @Override
   public boolean isTitleTruncated() {
      boolean var1;
      if (this.d != null && this.d.q()) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   @Override
   public ActionBar.Tab newTab() {
      return new WindowDecorActionBar.TabImpl(this);
   }

   @Override
   public void onConfigurationChanged(Configuration var1) {
      this.e(ActionBarPolicy.a(this.a).d());
   }

   @Override
   public boolean onKeyShortcut(int var1, KeyEvent var2) {
      boolean var4 = false;
      if (this.h != null) {
         Menu var5 = this.h.b();
         if (var5 != null) {
            int var3;
            if (var2 != null) {
               var3 = var2.getDeviceId();
            } else {
               var3 = -1;
            }

            if (KeyCharacterMap.load(var3).getKeyboardType() != 1) {
               var4 = true;
            } else {
               var4 = false;
            }

            var5.setQwertyMode(var4);
            var4 = var5.performShortcut(var1, var2, 0);
         }
      }

      return var4;
   }

   @Override
   public void removeAllTabs() {
      this.g();
   }

   @Override
   public void removeOnMenuVisibilityListener(ActionBar.OnMenuVisibilityListener var1) {
      this.D.remove(var1);
   }

   @Override
   public void removeTab(ActionBar.Tab var1) {
      this.removeTabAt(var1.a());
   }

   @Override
   public void removeTabAt(int var1) {
      if (this.g != null) {
         int var2;
         if (this.z != null) {
            var2 = this.z.a();
         } else {
            var2 = this.A;
         }

         this.g.b(var1);
         WindowDecorActionBar.TabImpl var5 = this.y.remove(var1);
         if (var5 != null) {
            var5.a(-1);
         }

         int var4 = this.y.size();

         for (int var3 = var1; var3 < var4; var3++) {
            this.y.get(var3).a(var3);
         }

         if (var2 == var1) {
            if (this.y.isEmpty()) {
               var5 = null;
            } else {
               var5 = this.y.get(Math.max(0, var1 - 1));
            }

            this.selectTab(var5);
         }
      }
   }

   @Override
   public boolean requestFocus() {
      ViewGroup var2 = this.d.a();
      boolean var1;
      if (var2 != null && !var2.hasFocus()) {
         var2.requestFocus();
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   @Override
   public void selectTab(ActionBar.Tab var1) {
      int var2 = -1;
      if (this.getNavigationMode() != 2) {
         if (var1 != null) {
            var2 = var1.a();
         } else {
            var2 = -1;
         }

         this.A = var2;
      } else {
         FragmentTransaction var3;
         if (this.w instanceof FragmentActivity && !this.d.a().isInEditMode()) {
            var3 = ((FragmentActivity)this.w).getSupportFragmentManager().a().b();
         } else {
            var3 = null;
         }

         if (this.z == var1) {
            if (this.z != null) {
               this.z.g().c(this.z, var3);
               this.g.a(var1.a());
            }
         } else {
            ScrollingTabContainerView var4 = this.g;
            if (var1 != null) {
               var2 = var1.a();
            }

            var4.setTabSelected(var2);
            if (this.z != null) {
               this.z.g().b(this.z, var3);
            }

            this.z = (WindowDecorActionBar.TabImpl)var1;
            if (this.z != null) {
               this.z.g().a(this.z, var3);
            }
         }

         if (var3 != null && !var3.k()) {
            var3.d();
         }
      }
   }

   @Override
   public void setBackgroundDrawable(Drawable var1) {
      this.c.setPrimaryBackground(var1);
   }

   @Override
   public void setCustomView(int var1) {
      this.setCustomView(LayoutInflater.from(this.getThemedContext()).inflate(var1, this.d.a(), false));
   }

   @Override
   public void setCustomView(View var1) {
      this.d.a(var1);
   }

   @Override
   public void setCustomView(View var1, ActionBar.LayoutParams var2) {
      var1.setLayoutParams(var2);
      this.d.a(var1);
   }

   @Override
   public void setDefaultDisplayHomeAsUpEnabled(boolean var1) {
      if (!this.B) {
         this.setDisplayHomeAsUpEnabled(var1);
      }
   }

   @Override
   public void setDisplayHomeAsUpEnabled(boolean var1) {
      byte var2;
      if (var1) {
         var2 = 4;
      } else {
         var2 = 0;
      }

      this.setDisplayOptions(var2, 4);
   }

   @Override
   public void setDisplayOptions(int var1) {
      if ((var1 & 4) != 0) {
         this.B = true;
      }

      this.d.c(var1);
   }

   @Override
   public void setDisplayOptions(int var1, int var2) {
      int var3 = this.d.p();
      if ((var2 & 4) != 0) {
         this.B = true;
      }

      this.d.c(var3 & ~var2 | var1 & var2);
   }

   @Override
   public void setDisplayShowCustomEnabled(boolean var1) {
      byte var2;
      if (var1) {
         var2 = 16;
      } else {
         var2 = 0;
      }

      this.setDisplayOptions(var2, 16);
   }

   @Override
   public void setDisplayShowHomeEnabled(boolean var1) {
      byte var2;
      if (var1) {
         var2 = 2;
      } else {
         var2 = 0;
      }

      this.setDisplayOptions(var2, 2);
   }

   @Override
   public void setDisplayShowTitleEnabled(boolean var1) {
      byte var2;
      if (var1) {
         var2 = 8;
      } else {
         var2 = 0;
      }

      this.setDisplayOptions(var2, 8);
   }

   @Override
   public void setDisplayUseLogoEnabled(boolean var1) {
      byte var2;
      if (var1) {
         var2 = 1;
      } else {
         var2 = 0;
      }

      this.setDisplayOptions(var2, 1);
   }

   @Override
   public void setElevation(float var1) {
      ViewCompat.a(this.c, var1);
   }

   @Override
   public void setHideOffset(int var1) {
      if (var1 != 0 && !this.b.a()) {
         throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to set a non-zero hide offset");
      }

      this.b.setActionBarHideOffset(var1);
   }

   @Override
   public void setHideOnContentScrollEnabled(boolean var1) {
      if (var1 && !this.b.a()) {
         throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
      }

      this.o = var1;
      this.b.setHideOnContentScrollEnabled(var1);
   }

   @Override
   public void setHomeActionContentDescription(int var1) {
      this.d.g(var1);
   }

   @Override
   public void setHomeActionContentDescription(CharSequence var1) {
      this.d.d(var1);
   }

   @Override
   public void setHomeAsUpIndicator(int var1) {
      this.d.f(var1);
   }

   @Override
   public void setHomeAsUpIndicator(Drawable var1) {
      this.d.c(var1);
   }

   @Override
   public void setHomeButtonEnabled(boolean var1) {
      this.d.b(var1);
   }

   @Override
   public void setIcon(int var1) {
      this.d.a(var1);
   }

   @Override
   public void setIcon(Drawable var1) {
      this.d.a(var1);
   }

   @Override
   public void setListNavigationCallbacks(SpinnerAdapter var1, ActionBar.OnNavigationListener var2) {
      this.d.a(var1, new NavItemSelectedListener(var2));
   }

   @Override
   public void setLogo(int var1) {
      this.d.b(var1);
   }

   @Override
   public void setLogo(Drawable var1) {
      this.d.b(var1);
   }

   @Override
   public void setNavigationMode(int var1) {
      boolean var4 = true;
      int var2 = this.d.r();
      switch (var2) {
         case 2:
            this.A = this.getSelectedNavigationIndex();
            this.selectTab(null);
            this.g.setVisibility(8);
      }

      if (var2 != var1 && !this.E && this.b != null) {
         ViewCompat.q(this.b);
      }

      this.d.d(var1);
      switch (var1) {
         case 2:
            this.f();
            this.g.setVisibility(0);
            if (this.A != -1) {
               this.setSelectedNavigationItem(this.A);
               this.A = -1;
            }
      }

      DecorToolbar var5 = this.d;
      boolean var3;
      if (var1 == 2 && !this.E) {
         var3 = true;
      } else {
         var3 = false;
      }

      var5.a(var3);
      ActionBarOverlayLayout var7 = this.b;
      if (var1 == 2 && !this.E) {
         var3 = var4;
      } else {
         var3 = false;
      }

      var7.setHasNonEmbeddedTabs(var3);
   }

   @Override
   public void setSelectedNavigationItem(int var1) {
      switch (this.d.r()) {
         case 1:
            this.d.e(var1);
            break;
         case 2:
            this.selectTab(this.y.get(var1));
            break;
         default:
            throw new IllegalStateException("setSelectedNavigationIndex not valid for current navigation mode");
      }
   }

   @Override
   public void setShowHideAnimationEnabled(boolean var1) {
      this.I = var1;
      if (!var1 && this.n != null) {
         this.n.c();
      }
   }

   @Override
   public void setSplitBackgroundDrawable(Drawable var1) {
   }

   @Override
   public void setStackedBackgroundDrawable(Drawable var1) {
      this.c.setStackedBackground(var1);
   }

   @Override
   public void setSubtitle(int var1) {
      this.setSubtitle(this.a.getString(var1));
   }

   @Override
   public void setSubtitle(CharSequence var1) {
      this.d.c(var1);
   }

   @Override
   public void setTitle(int var1) {
      this.setTitle(this.a.getString(var1));
   }

   @Override
   public void setTitle(CharSequence var1) {
      this.d.b(var1);
   }

   @Override
   public void setWindowTitle(CharSequence var1) {
      this.d.a(var1);
   }

   @Override
   public void show() {
      if (this.l) {
         this.l = false;
         this.f(false);
      }
   }

   @Override
   public ActionMode startActionMode(ActionMode.Callback var1) {
      if (this.h != null) {
         this.h.c();
      }

      this.b.setHideOnContentScrollEnabled(false);
      this.e.c();
      WindowDecorActionBar.ActionModeImpl var2 = new WindowDecorActionBar.ActionModeImpl(this, this.e.getContext(), var1);
      if (var2.e()) {
         this.h = var2;
         var2.d();
         this.e.a(var2);
         this.d(true);
         this.e.sendAccessibilityEvent(32);
      } else {
         var2 = null;
      }

      return var2;
   }

   public class ActionModeImpl extends ActionMode implements MenuBuilder.Callback {
      final WindowDecorActionBar a;
      private final Context b;
      private final MenuBuilder c;
      private ActionMode.Callback d;
      private WeakReference<View> e;

      public ActionModeImpl(WindowDecorActionBar var1, Context var2, ActionMode.Callback var3) {
         this.a = var1;
         this.b = var2;
         this.d = var3;
         this.c = new MenuBuilder(var2).a(1);
         this.c.a(this);
      }

      @Override
      public MenuInflater a() {
         return new SupportMenuInflater(this.b);
      }

      @Override
      public void a(int var1) {
         this.b(this.a.a.getResources().getString(var1));
      }

      @Override
      public void a(MenuBuilder var1) {
         if (this.d != null) {
            this.d();
            this.a.e.a();
         }
      }

      @Override
      public void a(View var1) {
         this.a.e.setCustomView(var1);
         this.e = new WeakReference<>(var1);
      }

      @Override
      public void a(CharSequence var1) {
         this.a.e.setSubtitle(var1);
      }

      @Override
      public void a(boolean var1) {
         super.a(var1);
         this.a.e.setTitleOptional(var1);
      }

      @Override
      public boolean a(MenuBuilder var1, MenuItem var2) {
         boolean var3;
         if (this.d != null) {
            var3 = this.d.a(this, var2);
         } else {
            var3 = false;
         }

         return var3;
      }

      @Override
      public Menu b() {
         return this.c;
      }

      @Override
      public void b(int var1) {
         this.a(this.a.a.getResources().getString(var1));
      }

      @Override
      public void b(CharSequence var1) {
         this.a.e.setTitle(var1);
      }

      @Override
      public void c() {
         if (this.a.h == this) {
            if (!WindowDecorActionBar.a(this.a.l, this.a.m, false)) {
               this.a.i = this;
               this.a.j = this.d;
            } else {
               this.d.a(this);
            }

            this.d = null;
            this.a.d(false);
            this.a.e.b();
            this.a.d.a().sendAccessibilityEvent(32);
            this.a.b.setHideOnContentScrollEnabled(this.a.o);
            this.a.h = null;
         }
      }

      @Override
      public void d() {
         if (this.a.h == this) {
            this.c.g();

            try {
               this.d.b(this, this.c);
            } finally {
               this.c.h();
            }
         }
      }

      public boolean e() {
         this.c.g();

         try {
            return this.d.a(this, this.c);
         } finally {
            this.c.h();
         }
      }

      @Override
      public CharSequence f() {
         return this.a.e.getTitle();
      }

      @Override
      public CharSequence g() {
         return this.a.e.getSubtitle();
      }

      @Override
      public boolean h() {
         return this.a.e.d();
      }

      @Override
      public View i() {
         View var1;
         if (this.e != null) {
            var1 = this.e.get();
         } else {
            var1 = null;
         }

         return var1;
      }
   }

   public class TabImpl extends ActionBar.Tab {
      final WindowDecorActionBar a;
      private ActionBar.TabListener b;
      private Drawable c;
      private CharSequence d;
      private CharSequence e;
      private int f;
      private View g;

      public TabImpl(WindowDecorActionBar var1) {
         this.a = var1;
         this.f = -1;
      }

      @Override
      public int a() {
         return this.f;
      }

      public void a(int var1) {
         this.f = var1;
      }

      @Override
      public Drawable b() {
         return this.c;
      }

      @Override
      public CharSequence c() {
         return this.d;
      }

      @Override
      public View d() {
         return this.g;
      }

      @Override
      public void e() {
         this.a.selectTab(this);
      }

      @Override
      public CharSequence f() {
         return this.e;
      }

      public ActionBar.TabListener g() {
         return this.b;
      }
   }
}
