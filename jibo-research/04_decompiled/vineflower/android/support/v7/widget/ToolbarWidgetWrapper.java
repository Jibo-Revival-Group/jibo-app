package android.support.v7.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v4.view.ViewPropertyAnimatorListenerAdapter;
import android.support.v7.appcompat.R;
import android.support.v7.content.res.AppCompatResources;
import android.support.v7.view.menu.ActionMenuItem;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuPresenter;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window.Callback;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.AdapterView.OnItemSelectedListener;

public class ToolbarWidgetWrapper implements DecorToolbar {
   Toolbar a;
   CharSequence b;
   Callback c;
   boolean d;
   private int e;
   private View f;
   private Spinner g;
   private View h;
   private Drawable i;
   private Drawable j;
   private Drawable k;
   private boolean l;
   private CharSequence m;
   private CharSequence n;
   private ActionMenuPresenter o;
   private int p = 0;
   private int q = 0;
   private Drawable r;

   public ToolbarWidgetWrapper(Toolbar var1, boolean var2) {
      this(var1, var2, R.string.abc_action_bar_up_description, R.drawable.abc_ic_ab_back_material);
   }

   public ToolbarWidgetWrapper(Toolbar var1, boolean var2, int var3, int var4) {
      this.a = var1;
      this.b = var1.getTitle();
      this.m = var1.getSubtitle();
      boolean var6;
      if (this.b != null) {
         var6 = true;
      } else {
         var6 = false;
      }

      this.l = var6;
      this.k = var1.getNavigationIcon();
      TintTypedArray var8 = TintTypedArray.a(var1.getContext(), null, R.styleable.ActionBar, R.attr.actionBarStyle, 0);
      this.r = var8.a(R.styleable.ActionBar_homeAsUpIndicator);
      if (var2) {
         CharSequence var7 = var8.c(R.styleable.ActionBar_title);
         if (!TextUtils.isEmpty(var7)) {
            this.b(var7);
         }

         var7 = var8.c(R.styleable.ActionBar_subtitle);
         if (!TextUtils.isEmpty(var7)) {
            this.c(var7);
         }

         Drawable var16 = var8.a(R.styleable.ActionBar_logo);
         if (var16 != null) {
            this.b(var16);
         }

         Drawable var17 = var8.a(R.styleable.ActionBar_icon);
         if (var17 != null) {
            this.a(var17);
         }

         if (this.k == null && this.r != null) {
            this.c(this.r);
         }

         this.c(var8.a(R.styleable.ActionBar_displayOptions, 0));
         var4 = var8.g(R.styleable.ActionBar_customNavigationLayout, 0);
         if (var4 != 0) {
            this.a(LayoutInflater.from(this.a.getContext()).inflate(var4, this.a, false));
            this.c(this.e | 16);
         }

         var4 = var8.f(R.styleable.ActionBar_height, 0);
         if (var4 > 0) {
            LayoutParams var18 = this.a.getLayoutParams();
            var18.height = var4;
            this.a.setLayoutParams(var18);
         }

         var4 = var8.d(R.styleable.ActionBar_contentInsetStart, -1);
         int var5 = var8.d(R.styleable.ActionBar_contentInsetEnd, -1);
         if (var4 >= 0 || var5 >= 0) {
            this.a.setContentInsetsRelative(Math.max(var4, 0), Math.max(var5, 0));
         }

         var4 = var8.g(R.styleable.ActionBar_titleTextStyle, 0);
         if (var4 != 0) {
            this.a.setTitleTextAppearance(this.a.getContext(), var4);
         }

         var4 = var8.g(R.styleable.ActionBar_subtitleTextStyle, 0);
         if (var4 != 0) {
            this.a.setSubtitleTextAppearance(this.a.getContext(), var4);
         }

         var4 = var8.g(R.styleable.ActionBar_popupTheme, 0);
         if (var4 != 0) {
            this.a.setPopupTheme(var4);
         }
      } else {
         this.e = this.y();
      }

      var8.a();
      this.i(var3);
      this.n = this.a.getNavigationContentDescription();
      this.a.setNavigationOnClickListener(new OnClickListener(this) {
         final ActionMenuItem a;
         final ToolbarWidgetWrapper b;

         {
            this.b = var1;
            this.a = new ActionMenuItem(this.b.a.getContext(), 0, 16908332, 0, 0, this.b.b);
         }

         public void onClick(View var1) {
            if (this.b.c != null && this.b.d) {
               this.b.c.onMenuItemSelected(0, this.a);
            }
         }
      });
   }

   private void A() {
      if (this.g == null) {
         this.g = new AppCompatSpinner(this.b(), null, R.attr.actionDropDownStyle);
         Toolbar.LayoutParams var1 = new Toolbar.LayoutParams(-2, -2, 8388627);
         this.g.setLayoutParams(var1);
      }
   }

   private void B() {
      if ((this.e & 4) != 0) {
         Toolbar var2 = this.a;
         Drawable var1;
         if (this.k != null) {
            var1 = this.k;
         } else {
            var1 = this.r;
         }

         var2.setNavigationIcon(var1);
      } else {
         this.a.setNavigationIcon(null);
      }
   }

   private void C() {
      if ((this.e & 4) != 0) {
         if (TextUtils.isEmpty(this.n)) {
            this.a.setNavigationContentDescription(this.q);
         } else {
            this.a.setNavigationContentDescription(this.n);
         }
      }
   }

   private void e(CharSequence var1) {
      this.b = var1;
      if ((this.e & 8) != 0) {
         this.a.setTitle(var1);
      }
   }

   private int y() {
      byte var1 = 11;
      if (this.a.getNavigationIcon() != null) {
         var1 = 15;
         this.r = this.a.getNavigationIcon();
      }

      return var1;
   }

   private void z() {
      Drawable var1 = null;
      if ((this.e & 2) != 0) {
         if ((this.e & 1) != 0) {
            if (this.j != null) {
               var1 = this.j;
            } else {
               var1 = this.i;
            }
         } else {
            var1 = this.i;
         }
      }

      this.a.setLogo(var1);
   }

   @Override
   public ViewPropertyAnimatorCompat a(int var1, long var2) {
      ViewPropertyAnimatorCompat var5 = ViewCompat.l(this.a);
      float var4;
      if (var1 == 0) {
         var4 = 1.0F;
      } else {
         var4 = 0.0F;
      }

      return var5.a(var4).a(var2).a(new ViewPropertyAnimatorListenerAdapter(this, var1) {
         final int a;
         final ToolbarWidgetWrapper b;
         private boolean c;

         {
            this.b = var1;
            this.a = var2x;
            this.c = false;
         }

         @Override
         public void a(View var1) {
            this.b.a.setVisibility(0);
         }

         @Override
         public void b(View var1) {
            if (!this.c) {
               this.b.a.setVisibility(this.a);
            }
         }

         @Override
         public void c(View var1) {
            this.c = true;
         }
      });
   }

   @Override
   public ViewGroup a() {
      return this.a;
   }

   @Override
   public void a(int var1) {
      Drawable var2;
      if (var1 != 0) {
         var2 = AppCompatResources.b(this.b(), var1);
      } else {
         var2 = null;
      }

      this.a(var2);
   }

   @Override
   public void a(Drawable var1) {
      this.i = var1;
      this.z();
   }

   @Override
   public void a(MenuPresenter.Callback var1, MenuBuilder.Callback var2) {
      this.a.setMenuCallbacks(var1, var2);
   }

   @Override
   public void a(ScrollingTabContainerView var1) {
      if (this.f != null && this.f.getParent() == this.a) {
         this.a.removeView(this.f);
      }

      this.f = var1;
      if (var1 != null && this.p == 2) {
         this.a.addView(this.f, 0);
         Toolbar.LayoutParams var2 = (Toolbar.LayoutParams)this.f.getLayoutParams();
         var2.width = -2;
         var2.height = -2;
         var2.a = 8388691;
         var1.setAllowCollapse(true);
      }
   }

   @Override
   public void a(Menu var1, MenuPresenter.Callback var2) {
      if (this.o == null) {
         this.o = new ActionMenuPresenter(this.a.getContext());
         this.o.a(R.id.action_menu_presenter);
      }

      this.o.a(var2);
      this.a.setMenu((MenuBuilder)var1, this.o);
   }

   @Override
   public void a(View var1) {
      if (this.h != null && (this.e & 16) != 0) {
         this.a.removeView(this.h);
      }

      this.h = var1;
      if (var1 != null && (this.e & 16) != 0) {
         this.a.addView(this.h);
      }
   }

   @Override
   public void a(Callback var1) {
      this.c = var1;
   }

   @Override
   public void a(SpinnerAdapter var1, OnItemSelectedListener var2) {
      this.A();
      this.g.setAdapter(var1);
      this.g.setOnItemSelectedListener(var2);
   }

   @Override
   public void a(CharSequence var1) {
      if (!this.l) {
         this.e(var1);
      }
   }

   @Override
   public void a(boolean var1) {
      this.a.setCollapsible(var1);
   }

   @Override
   public Context b() {
      return this.a.getContext();
   }

   @Override
   public void b(int var1) {
      Drawable var2;
      if (var1 != 0) {
         var2 = AppCompatResources.b(this.b(), var1);
      } else {
         var2 = null;
      }

      this.b(var2);
   }

   @Override
   public void b(Drawable var1) {
      this.j = var1;
      this.z();
   }

   @Override
   public void b(CharSequence var1) {
      this.l = true;
      this.e(var1);
   }

   @Override
   public void b(boolean var1) {
   }

   @Override
   public void c(int var1) {
      int var2 = this.e ^ var1;
      this.e = var1;
      if (var2 != 0) {
         if ((var2 & 4) != 0) {
            if ((var1 & 4) != 0) {
               this.C();
            }

            this.B();
         }

         if ((var2 & 3) != 0) {
            this.z();
         }

         if ((var2 & 8) != 0) {
            if ((var1 & 8) != 0) {
               this.a.setTitle(this.b);
               this.a.setSubtitle(this.m);
            } else {
               this.a.setTitle(null);
               this.a.setSubtitle(null);
            }
         }

         if ((var2 & 16) != 0 && this.h != null) {
            if ((var1 & 16) != 0) {
               this.a.addView(this.h);
            } else {
               this.a.removeView(this.h);
            }
         }
      }
   }

   @Override
   public void c(Drawable var1) {
      this.k = var1;
      this.B();
   }

   @Override
   public void c(CharSequence var1) {
      this.m = var1;
      if ((this.e & 8) != 0) {
         this.a.setSubtitle(var1);
      }
   }

   @Override
   public boolean c() {
      return this.a.hasExpandedActionView();
   }

   @Override
   public void d() {
      this.a.collapseActionView();
   }

   @Override
   public void d(int var1) {
      int var2 = this.p;
      if (var1 != var2) {
         switch (var2) {
            case 1:
               if (this.g != null && this.g.getParent() == this.a) {
                  this.a.removeView(this.g);
               }
               break;
            case 2:
               if (this.f != null && this.f.getParent() == this.a) {
                  this.a.removeView(this.f);
               }
         }

         this.p = var1;
         switch (var1) {
            case 0:
               break;
            case 1:
               this.A();
               this.a.addView(this.g, 0);
               break;
            case 2:
               if (this.f != null) {
                  this.a.addView(this.f, 0);
                  Toolbar.LayoutParams var3 = (Toolbar.LayoutParams)this.f.getLayoutParams();
                  var3.width = -2;
                  var3.height = -2;
                  var3.a = 8388691;
               }
               break;
            default:
               throw new IllegalArgumentException("Invalid navigation mode " + var1);
         }
      }
   }

   @Override
   public void d(Drawable var1) {
      ViewCompat.a(this.a, var1);
   }

   @Override
   public void d(CharSequence var1) {
      this.n = var1;
      this.C();
   }

   @Override
   public CharSequence e() {
      return this.a.getTitle();
   }

   @Override
   public void e(int var1) {
      if (this.g == null) {
         throw new IllegalStateException("Can't set dropdown selected position without an adapter");
      }

      this.g.setSelection(var1);
   }

   @Override
   public CharSequence f() {
      return this.a.getSubtitle();
   }

   @Override
   public void f(int var1) {
      Drawable var2;
      if (var1 != 0) {
         var2 = AppCompatResources.b(this.b(), var1);
      } else {
         var2 = null;
      }

      this.c(var2);
   }

   @Override
   public void g() {
      Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
   }

   @Override
   public void g(int var1) {
      String var2;
      if (var1 == 0) {
         var2 = null;
      } else {
         var2 = this.b().getString(var1);
      }

      this.d(var2);
   }

   @Override
   public void h() {
      Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
   }

   @Override
   public void h(int var1) {
      this.a.setVisibility(var1);
   }

   public void i(int var1) {
      if (var1 != this.q) {
         this.q = var1;
         if (TextUtils.isEmpty(this.a.getNavigationContentDescription())) {
            this.g(this.q);
         }
      }
   }

   @Override
   public boolean i() {
      return this.a.canShowOverflowMenu();
   }

   @Override
   public boolean j() {
      return this.a.isOverflowMenuShowing();
   }

   @Override
   public boolean k() {
      return this.a.isOverflowMenuShowPending();
   }

   @Override
   public boolean l() {
      return this.a.showOverflowMenu();
   }

   @Override
   public boolean m() {
      return this.a.hideOverflowMenu();
   }

   @Override
   public void n() {
      this.d = true;
   }

   @Override
   public void o() {
      this.a.dismissPopupMenus();
   }

   @Override
   public int p() {
      return this.e;
   }

   @Override
   public boolean q() {
      return this.a.isTitleTruncated();
   }

   @Override
   public int r() {
      return this.p;
   }

   @Override
   public int s() {
      int var1;
      if (this.g != null) {
         var1 = this.g.getSelectedItemPosition();
      } else {
         var1 = 0;
      }

      return var1;
   }

   @Override
   public int t() {
      int var1;
      if (this.g != null) {
         var1 = this.g.getCount();
      } else {
         var1 = 0;
      }

      return var1;
   }

   @Override
   public View u() {
      return this.h;
   }

   @Override
   public int v() {
      return this.a.getHeight();
   }

   @Override
   public int w() {
      return this.a.getVisibility();
   }

   @Override
   public Menu x() {
      return this.a.getMenu();
   }
}
