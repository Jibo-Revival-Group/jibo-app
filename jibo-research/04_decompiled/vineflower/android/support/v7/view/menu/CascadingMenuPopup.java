package android.support.v7.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Parcelable;
import android.os.SystemClock;
import android.os.Build.VERSION;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.appcompat.R;
import android.support.v7.widget.MenuItemHoverListener;
import android.support.v7.widget.MenuPopupWindow;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.View.OnAttachStateChangeListener;
import android.view.View.OnKeyListener;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.PopupWindow.OnDismissListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

final class CascadingMenuPopup extends MenuPopup implements MenuPresenter, OnKeyListener, OnDismissListener {
   final Handler a;
   final List<CascadingMenuPopup.CascadingMenuInfo> b;
   View c;
   boolean d;
   private final Context e;
   private final int f;
   private final int g;
   private final int h;
   private final boolean i;
   private final List<MenuBuilder> j = new ArrayList<>();
   private final OnGlobalLayoutListener k;
   private final OnAttachStateChangeListener l;
   private final MenuItemHoverListener m;
   private int n;
   private int o;
   private View p;
   private int q;
   private boolean r;
   private boolean s;
   private int t;
   private int u;
   private boolean v;
   private boolean w;
   private MenuPresenter.Callback x;
   private ViewTreeObserver y;
   private OnDismissListener z;

   public CascadingMenuPopup(Context var1, View var2, int var3, int var4, boolean var5) {
      this.b = new ArrayList<>();
      this.k = new OnGlobalLayoutListener(this) {
         final CascadingMenuPopup a;

         {
            this.a = var1;
         }

         public void onGlobalLayout() {
            if (this.a.f() && this.a.b.size() > 0 && !this.a.b.get(0).a.c()) {
               View var1x = this.a.c;
               if (var1x != null && var1x.isShown()) {
                  Iterator var2x = this.a.b.iterator();

                  while (var2x.hasNext()) {
                     ((CascadingMenuPopup.CascadingMenuInfo)var2x.next()).a.d();
                  }
               } else {
                  this.a.e();
               }
            }
         }
      };
      this.l = new OnAttachStateChangeListener(this) {
         final CascadingMenuPopup a;

         {
            this.a = var1;
         }

         public void onViewAttachedToWindow(View var1) {
         }

         public void onViewDetachedFromWindow(View var1) {
            if (this.a.y != null) {
               if (!this.a.y.isAlive()) {
                  this.a.y = var1.getViewTreeObserver();
               }

               this.a.y.removeGlobalOnLayoutListener(this.a.k);
            }

            var1.removeOnAttachStateChangeListener(this);
         }
      };
      this.m = new MenuItemHoverListener(this) {
         final CascadingMenuPopup a;

         {
            this.a = var1;
         }

         @Override
         public void a(MenuBuilder var1, MenuItem var2x) {
            this.a.a.removeCallbacksAndMessages(var1);
         }

         @Override
         public void b(MenuBuilder var1, MenuItem var2x) {
            this.a.a.removeCallbacksAndMessages(null);
            int var3x = 0;
            int var4x = this.a.b.size();

            while (true) {
               if (var3x >= var4x) {
                  var3x = -1;
                  break;
               }

               if (var1 == this.a.b.get(var3x).b) {
                  break;
               }

               var3x++;
            }

            if (var3x != -1) {
               CascadingMenuPopup.CascadingMenuInfo var7;
               if (++var3x < this.a.b.size()) {
                  var7 = this.a.b.get(var3x);
               } else {
                  var7 = null;
               }

               Runnable var8 = new Runnable(this, var7, var2x, var1) {
                  final CascadingMenuPopup.CascadingMenuInfo a;
                  final MenuItem b;
                  final MenuBuilder c;
                  final <unrepresentable> d;

                  {
                     this.d = var1;
                     this.a = var2x;
                     this.b = var3x;
                     this.c = var4x;
                  }

                  @Override
                  public void run() {
                     if (this.a != null) {
                        this.d.a.d = true;
                        this.a.b.b(false);
                        this.d.a.d = false;
                     }

                     if (this.b.isEnabled() && this.b.hasSubMenu()) {
                        this.c.a(this.b, 4);
                     }
                  }
               };
               long var5x = SystemClock.uptimeMillis();
               this.a.a.postAtTime(var8, var1, var5x + 200L);
            }
         }
      };
      this.n = 0;
      this.o = 0;
      this.e = var1;
      this.p = var2;
      this.g = var3;
      this.h = var4;
      this.i = var5;
      this.v = false;
      this.q = this.k();
      Resources var6 = var1.getResources();
      this.f = Math.max(var6.getDisplayMetrics().widthPixels / 2, var6.getDimensionPixelSize(R.dimen.abc_config_prefDialogWidth));
      this.a = new Handler();
   }

   private MenuItem a(MenuBuilder var1, MenuBuilder var2) {
      int var4 = var1.size();
      int var3 = 0;

      while (true) {
         if (var3 >= var4) {
            var6 = null;
            break;
         }

         MenuItem var5 = var1.getItem(var3);
         if (var5.hasSubMenu() && var2 == var5.getSubMenu()) {
            var6 = var5;
            break;
         }

         var3++;
      }

      return var6;
   }

   private View a(CascadingMenuPopup.CascadingMenuInfo var1, MenuBuilder var2) {
      int var3 = 0;
      MenuItem var11 = this.a(var1.b, var2);
      View var7;
      if (var11 == null) {
         var7 = null;
      } else {
         ListView var6 = var1.a();
         ListAdapter var8 = var6.getAdapter();
         int var4;
         MenuAdapter var10;
         if (var8 instanceof HeaderViewListAdapter) {
            HeaderViewListAdapter var9 = (HeaderViewListAdapter)var8;
            var4 = var9.getHeadersCount();
            var10 = (MenuAdapter)var9.getWrappedAdapter();
         } else {
            var10 = (MenuAdapter)var8;
            var4 = 0;
         }

         int var5 = var10.getCount();

         while (true) {
            if (var3 >= var5) {
               var3 = -1;
               break;
            }

            if (var11 == var10.a(var3)) {
               break;
            }

            var3++;
         }

         if (var3 == -1) {
            var7 = null;
         } else {
            var3 = var3 + var4 - var6.getFirstVisiblePosition();
            if (var3 >= 0 && var3 < var6.getChildCount()) {
               var7 = var6.getChildAt(var3);
            } else {
               var7 = null;
            }
         }
      }

      return var7;
   }

   private void c(MenuBuilder var1) {
      LayoutInflater var9 = LayoutInflater.from(this.e);
      MenuAdapter var6 = new MenuAdapter(var1, var9, this.i);
      if (!this.f() && this.v) {
         var6.a(true);
      } else if (this.f()) {
         var6.a(MenuPopup.b(var1));
      }

      int var5 = a(var6, null, this.e, this.f);
      MenuPopupWindow var8 = this.j();
      var8.a(var6);
      var8.g(var5);
      var8.e(this.o);
      View var7;
      CascadingMenuPopup.CascadingMenuInfo var14;
      if (this.b.size() > 0) {
         var14 = this.b.get(this.b.size() - 1);
         var7 = this.a(var14, var1);
      } else {
         var7 = null;
         var14 = null;
      }

      if (var7 != null) {
         var8.c(false);
         var8.a((Object)null);
         int var3 = this.d(var5);
         boolean var2;
         if (var3 == 1) {
            var2 = 1;
         } else {
            var2 = 0;
         }

         this.q = var3;
         int var4;
         if (VERSION.SDK_INT >= 26) {
            var8.b(var7);
            var3 = 0;
            var4 = 0;
         } else {
            int[] var11 = new int[2];
            this.p.getLocationOnScreen(var11);
            int[] var10 = new int[2];
            var7.getLocationOnScreen(var10);
            if ((this.o & 7) == 5) {
               var11[0] += this.p.getWidth();
               var10[0] += var7.getWidth();
            }

            var4 = var10[0] - var11[0];
            var3 = var10[1] - var11[1];
         }

         if ((this.o & 5) == 5) {
            if (var2) {
               var2 = var4 + var5;
            } else {
               var2 = var4 - var7.getWidth();
            }
         } else if (var2) {
            var2 = var7.getWidth() + var4;
         } else {
            var2 = var4 - var5;
         }

         var8.c(var2);
         var8.b(true);
         var8.d(var3);
      } else {
         if (this.r) {
            var8.c(this.t);
         }

         if (this.s) {
            var8.d(this.u);
         }

         var8.a(this.i());
      }

      CascadingMenuPopup.CascadingMenuInfo var16 = new CascadingMenuPopup.CascadingMenuInfo(var8, var1, this.q);
      this.b.add(var16);
      var8.d();
      ListView var17 = var8.g();
      var17.setOnKeyListener(this);
      if (var14 == null && this.w && var1.m() != null) {
         FrameLayout var15 = (FrameLayout)var9.inflate(R.layout.abc_popup_menu_header_item_layout, var17, false);
         TextView var18 = (TextView)var15.findViewById(16908310);
         var15.setEnabled(false);
         var18.setText(var1.m());
         var17.addHeaderView(var15, null, false);
         var8.d();
      }
   }

   private int d(int var1) {
      ListView var3 = this.b.get(this.b.size() - 1).a();
      int[] var5 = new int[2];
      var3.getLocationOnScreen(var5);
      Rect var4 = new Rect();
      this.c.getWindowVisibleDisplayFrame(var4);
      byte var6;
      if (this.q == 1) {
         int var2 = var5[0];
         if (var3.getWidth() + var2 + var1 > var4.right) {
            var6 = 0;
         } else {
            var6 = 1;
         }
      } else if (var5[0] - var1 < 0) {
         var6 = 1;
      } else {
         var6 = 0;
      }

      return var6;
   }

   private int d(MenuBuilder var1) {
      int var2 = 0;
      int var3 = this.b.size();

      while (true) {
         if (var2 >= var3) {
            var2 = -1;
            break;
         }

         if (var1 == this.b.get(var2).b) {
            break;
         }

         var2++;
      }

      return var2;
   }

   private MenuPopupWindow j() {
      MenuPopupWindow var1 = new MenuPopupWindow(this.e, null, this.g, this.h);
      var1.a(this.m);
      var1.a(this);
      var1.a(this);
      var1.b(this.p);
      var1.e(this.o);
      var1.a(true);
      var1.h(2);
      return var1;
   }

   private int k() {
      byte var1 = 1;
      if (ViewCompat.e(this.p) == 1) {
         var1 = 0;
      }

      return var1;
   }

   @Override
   public void a(int var1) {
      if (this.n != var1) {
         this.n = var1;
         this.o = GravityCompat.a(var1, ViewCompat.e(this.p));
      }
   }

   @Override
   public void a(Parcelable var1) {
   }

   @Override
   public void a(MenuBuilder var1) {
      var1.a(this, this.e);
      if (this.f()) {
         this.c(var1);
      } else {
         this.j.add(var1);
      }
   }

   @Override
   public void a(MenuBuilder var1, boolean var2) {
      int var3 = this.d(var1);
      if (var3 >= 0) {
         int var4 = var3 + 1;
         if (var4 < this.b.size()) {
            this.b.get(var4).b.b(false);
         }

         CascadingMenuPopup.CascadingMenuInfo var5 = this.b.remove(var3);
         var5.b.b(this);
         if (this.d) {
            var5.a.b(null);
            var5.a.b(0);
         }

         var5.a.e();
         var3 = this.b.size();
         if (var3 > 0) {
            this.q = this.b.get(var3 - 1).c;
         } else {
            this.q = this.k();
         }

         if (var3 == 0) {
            this.e();
            if (this.x != null) {
               this.x.a(var1, true);
            }

            if (this.y != null) {
               if (this.y.isAlive()) {
                  this.y.removeGlobalOnLayoutListener(this.k);
               }

               this.y = null;
            }

            this.c.removeOnAttachStateChangeListener(this.l);
            this.z.onDismiss();
         } else if (var2) {
            this.b.get(0).b.b(false);
         }
      }
   }

   @Override
   public void a(MenuPresenter.Callback var1) {
      this.x = var1;
   }

   @Override
   public void a(View var1) {
      if (this.p != var1) {
         this.p = var1;
         this.o = GravityCompat.a(this.n, ViewCompat.e(this.p));
      }
   }

   @Override
   public void a(OnDismissListener var1) {
      this.z = var1;
   }

   @Override
   public void a(boolean var1) {
      Iterator var2 = this.b.iterator();

      while (var2.hasNext()) {
         a(((CascadingMenuPopup.CascadingMenuInfo)var2.next()).a().getAdapter()).notifyDataSetChanged();
      }
   }

   @Override
   public boolean a() {
      return false;
   }

   @Override
   public boolean a(SubMenuBuilder var1) {
      Iterator var3 = this.b.iterator();

      boolean var2;
      while (true) {
         if (var3.hasNext()) {
            CascadingMenuPopup.CascadingMenuInfo var4 = (CascadingMenuPopup.CascadingMenuInfo)var3.next();
            if (var1 != var4.b) {
               continue;
            }

            var4.a().requestFocus();
            var2 = true;
            break;
         }

         if (var1.hasVisibleItems()) {
            this.a((MenuBuilder)var1);
            if (this.x != null) {
               this.x.a(var1);
            }

            var2 = true;
         } else {
            var2 = false;
         }
         break;
      }

      return var2;
   }

   @Override
   public void b(int var1) {
      this.r = true;
      this.t = var1;
   }

   @Override
   public void b(boolean var1) {
      this.v = var1;
   }

   @Override
   public Parcelable c() {
      return null;
   }

   @Override
   public void c(int var1) {
      this.s = true;
      this.u = var1;
   }

   @Override
   public void c(boolean var1) {
      this.w = var1;
   }

   @Override
   public void d() {
      if (!this.f()) {
         Iterator var2 = this.j.iterator();

         while (var2.hasNext()) {
            this.c((MenuBuilder)var2.next());
         }

         this.j.clear();
         this.c = this.p;
         if (this.c != null) {
            boolean var1;
            if (this.y == null) {
               var1 = true;
            } else {
               var1 = false;
            }

            this.y = this.c.getViewTreeObserver();
            if (var1) {
               this.y.addOnGlobalLayoutListener(this.k);
            }

            this.c.addOnAttachStateChangeListener(this.l);
         }
      }
   }

   @Override
   public void e() {
      int var1 = this.b.size();
      if (var1 > 0) {
         CascadingMenuPopup.CascadingMenuInfo[] var3 = this.b.toArray(new CascadingMenuPopup.CascadingMenuInfo[var1]);
         var1--;

         for (; var1 >= 0; var1--) {
            CascadingMenuPopup.CascadingMenuInfo var2 = var3[var1];
            if (var2.a.f()) {
               var2.a.e();
            }
         }
      }
   }

   @Override
   public boolean f() {
      boolean var1;
      if (this.b.size() > 0 && this.b.get(0).a.f()) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   @Override
   public ListView g() {
      ListView var1;
      if (this.b.isEmpty()) {
         var1 = null;
      } else {
         var1 = this.b.get(this.b.size() - 1).a();
      }

      return var1;
   }

   @Override
   protected boolean h() {
      return false;
   }

   public void onDismiss() {
      int var2 = this.b.size();
      int var1 = 0;

      CascadingMenuPopup.CascadingMenuInfo var3;
      while (true) {
         if (var1 >= var2) {
            var3 = null;
            break;
         }

         var3 = this.b.get(var1);
         if (!var3.a.f()) {
            break;
         }

         var1++;
      }

      if (var3 != null) {
         var3.b.b(false);
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

   private static class CascadingMenuInfo {
      public final MenuPopupWindow a;
      public final MenuBuilder b;
      public final int c;

      public CascadingMenuInfo(MenuPopupWindow var1, MenuBuilder var2, int var3) {
         this.a = var1;
         this.b = var2;
         this.c = var3;
      }

      public ListView a() {
         return this.a.g();
      }
   }
}
