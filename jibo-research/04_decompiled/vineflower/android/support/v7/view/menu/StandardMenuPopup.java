package android.support.v7.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.os.Parcelable;
import android.support.v7.appcompat.R;
import android.support.v7.widget.MenuPopupWindow;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.View.OnAttachStateChangeListener;
import android.view.View.OnKeyListener;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.PopupWindow.OnDismissListener;

final class StandardMenuPopup extends MenuPopup implements MenuPresenter, OnKeyListener, OnItemClickListener, OnDismissListener {
   final MenuPopupWindow a;
   View b;
   private final Context c;
   private final MenuBuilder d;
   private final MenuAdapter e;
   private final boolean f;
   private final int g;
   private final int h;
   private final int i;
   private final OnGlobalLayoutListener j = new OnGlobalLayoutListener(this) {
      final StandardMenuPopup a;

      {
         this.a = var1;
      }

      public void onGlobalLayout() {
         if (this.a.f() && !this.a.a.c()) {
            View var1 = this.a.b;
            if (var1 != null && var1.isShown()) {
               this.a.a.d();
            } else {
               this.a.e();
            }
         }
      }
   };
   private final OnAttachStateChangeListener k = new OnAttachStateChangeListener(this) {
      final StandardMenuPopup a;

      {
         this.a = var1;
      }

      public void onViewAttachedToWindow(View var1) {
      }

      public void onViewDetachedFromWindow(View var1) {
         if (this.a.o != null) {
            if (!this.a.o.isAlive()) {
               this.a.o = var1.getViewTreeObserver();
            }

            this.a.o.removeGlobalOnLayoutListener(this.a.j);
         }

         var1.removeOnAttachStateChangeListener(this);
      }
   };
   private OnDismissListener l;
   private View m;
   private MenuPresenter.Callback n;
   private ViewTreeObserver o;
   private boolean p;
   private boolean q;
   private int r;
   private int s = 0;
   private boolean t;

   public StandardMenuPopup(Context var1, MenuBuilder var2, View var3, int var4, int var5, boolean var6) {
      this.c = var1;
      this.d = var2;
      this.f = var6;
      this.e = new MenuAdapter(var2, LayoutInflater.from(var1), this.f);
      this.h = var4;
      this.i = var5;
      Resources var7 = var1.getResources();
      this.g = Math.max(var7.getDisplayMetrics().widthPixels / 2, var7.getDimensionPixelSize(R.dimen.abc_config_prefDialogWidth));
      this.m = var3;
      this.a = new MenuPopupWindow(this.c, null, this.h, this.i);
      var2.a(this, var1);
   }

   private boolean j() {
      boolean var2 = true;
      if (!this.f()) {
         if (!this.p && this.m != null) {
            this.b = this.m;
            this.a.a(this);
            this.a.a(this);
            this.a.a(true);
            View var3 = this.b;
            boolean var1;
            if (this.o == null) {
               var1 = true;
            } else {
               var1 = false;
            }

            this.o = var3.getViewTreeObserver();
            if (var1) {
               this.o.addOnGlobalLayoutListener(this.j);
            }

            var3.addOnAttachStateChangeListener(this.k);
            this.a.b(var3);
            this.a.e(this.s);
            if (!this.q) {
               this.r = a(this.e, null, this.c, this.g);
               this.q = true;
            }

            this.a.g(this.r);
            this.a.h(2);
            this.a.a(this.i());
            this.a.d();
            ListView var6 = this.a.g();
            var6.setOnKeyListener(this);
            if (this.t && this.d.m() != null) {
               FrameLayout var5 = (FrameLayout)LayoutInflater.from(this.c).inflate(R.layout.abc_popup_menu_header_item_layout, var6, false);
               TextView var4 = (TextView)var5.findViewById(16908310);
               if (var4 != null) {
                  var4.setText(this.d.m());
               }

               var5.setEnabled(false);
               var6.addHeaderView(var5, null, false);
            }

            this.a.a(this.e);
            this.a.d();
         } else {
            var2 = false;
         }
      }

      return var2;
   }

   @Override
   public void a(int var1) {
      this.s = var1;
   }

   @Override
   public void a(Parcelable var1) {
   }

   @Override
   public void a(MenuBuilder var1) {
   }

   @Override
   public void a(MenuBuilder var1, boolean var2) {
      if (var1 == this.d) {
         this.e();
         if (this.n != null) {
            this.n.a(var1, var2);
         }
      }
   }

   @Override
   public void a(MenuPresenter.Callback var1) {
      this.n = var1;
   }

   @Override
   public void a(View var1) {
      this.m = var1;
   }

   @Override
   public void a(OnDismissListener var1) {
      this.l = var1;
   }

   @Override
   public void a(boolean var1) {
      this.q = false;
      if (this.e != null) {
         this.e.notifyDataSetChanged();
      }
   }

   @Override
   public boolean a() {
      return false;
   }

   @Override
   public boolean a(SubMenuBuilder var1) {
      if (var1.hasVisibleItems()) {
         MenuPopupHelper var3 = new MenuPopupHelper(this.c, var1, this.b, this.f, this.h, this.i);
         var3.a(this.n);
         var3.a(MenuPopup.b(var1));
         var3.a(this.s);
         var3.a(this.l);
         this.l = null;
         this.d.b(false);
         if (var3.a(this.a.j(), this.a.k())) {
            if (this.n != null) {
               this.n.a(var1);
            }

            return true;
         }
      }

      return false;
   }

   @Override
   public void b(int var1) {
      this.a.c(var1);
   }

   @Override
   public void b(boolean var1) {
      this.e.a(var1);
   }

   @Override
   public Parcelable c() {
      return null;
   }

   @Override
   public void c(int var1) {
      this.a.d(var1);
   }

   @Override
   public void c(boolean var1) {
      this.t = var1;
   }

   @Override
   public void d() {
      if (!this.j()) {
         throw new IllegalStateException("StandardMenuPopup cannot be used without an anchor");
      }
   }

   @Override
   public void e() {
      if (this.f()) {
         this.a.e();
      }
   }

   @Override
   public boolean f() {
      boolean var1;
      if (!this.p && this.a.f()) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   @Override
   public ListView g() {
      return this.a.g();
   }

   public void onDismiss() {
      this.p = true;
      this.d.close();
      if (this.o != null) {
         if (!this.o.isAlive()) {
            this.o = this.b.getViewTreeObserver();
         }

         this.o.removeGlobalOnLayoutListener(this.j);
         this.o = null;
      }

      this.b.removeOnAttachStateChangeListener(this.k);
      if (this.l != null) {
         this.l.onDismiss();
      }
   }

   public boolean onKey(View var1, int var2, KeyEvent var3) {
      boolean var4 = true;
      if (var3.getAction() == 1 && var2 == 82) {
         this.e();
      } else {
         var4 = false;
      }

      return var4;
   }
}
