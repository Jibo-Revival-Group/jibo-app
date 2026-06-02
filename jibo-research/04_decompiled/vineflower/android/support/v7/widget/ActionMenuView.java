package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.support.v7.view.menu.ActionMenuItemView;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuItemImpl;
import android.support.v7.view.menu.MenuPresenter;
import android.support.v7.view.menu.MenuView;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewDebug.ExportedProperty;
import android.view.accessibility.AccessibilityEvent;

public class ActionMenuView extends LinearLayoutCompat implements MenuBuilder.ItemInvoker, MenuView {
   MenuBuilder.Callback a;
   ActionMenuView.OnMenuItemClickListener b;
   private MenuBuilder c;
   private Context d;
   private int e;
   private boolean f;
   private ActionMenuPresenter g;
   private MenuPresenter.Callback h;
   private boolean i;
   private int j;
   private int k;
   private int l;

   public ActionMenuView(Context var1) {
      this(var1, null);
   }

   public ActionMenuView(Context var1, AttributeSet var2) {
      super(var1, var2);
      this.setBaselineAligned(false);
      float var3 = var1.getResources().getDisplayMetrics().density;
      this.k = (int)(56.0F * var3);
      this.l = (int)(var3 * 4.0F);
      this.d = var1;
      this.e = 0;
   }

   static int a(View var0, int var1, int var2, int var3, int var4) {
      boolean var8 = false;
      ActionMenuView.LayoutParams var10 = (ActionMenuView.LayoutParams)var0.getLayoutParams();
      int var5 = MeasureSpec.makeMeasureSpec(MeasureSpec.getSize(var3) - var4, MeasureSpec.getMode(var3));
      ActionMenuItemView var9;
      if (var0 instanceof ActionMenuItemView) {
         var9 = (ActionMenuItemView)var0;
      } else {
         var9 = null;
      }

      boolean var14;
      if (var9 != null && var9.b()) {
         var14 = true;
      } else {
         var14 = false;
      }

      if (var2 > 0 && (!var14 || var2 >= 2)) {
         var0.measure(MeasureSpec.makeMeasureSpec(var1 * var2, Integer.MIN_VALUE), var5);
         int var6 = var0.getMeasuredWidth();
         var3 = var6 / var1;
         var2 = var3;
         if (var6 % var1 != 0) {
            var2 = var3 + 1;
         }

         var3 = var2;
         if (var14) {
            var3 = var2;
            if (var2 < 2) {
               var3 = 2;
            }
         }
      } else {
         var3 = 0;
      }

      boolean var7 = var8;
      if (!var10.a) {
         var7 = var8;
         if (var14) {
            var7 = true;
         }
      }

      var10.d = var7;
      var10.b = var3;
      var0.measure(MeasureSpec.makeMeasureSpec(var3 * var1, 1073741824), var5);
      return var3;
   }

   private void c(int var1, int var2) {
      int var17 = MeasureSpec.getMode(var2);
      int var6 = MeasureSpec.getSize(var1);
      int var16 = MeasureSpec.getSize(var2);
      var1 = this.getPaddingLeft();
      int var7 = this.getPaddingRight();
      int var14 = this.getPaddingTop() + this.getPaddingBottom();
      int var18 = getChildMeasureSpec(var2, var14, -2);
      int var19 = var6 - (var1 + var7);
      var1 = var19 / this.k;
      var2 = this.k;
      if (var1 == 0) {
         this.setMeasuredDimension(var19, 0);
      } else {
         int var21 = this.k + var19 % var2 / var1;
         var6 = 0;
         int var10 = 0;
         int var9 = 0;
         int var11 = 0;
         int var8 = 0;
         long var22 = 0L;
         int var20 = this.getChildCount();
         int var12 = 0;

         while (var12 < var20) {
            View var28 = this.getChildAt(var12);
            if (var28.getVisibility() == 8) {
               var7 = var6;
               var2 = var10;
               var6 = var1;
               var1 = var11;
            } else {
               boolean var26 = var28 instanceof ActionMenuItemView;
               var11++;
               if (var26) {
                  var28.setPadding(this.l, 0, this.l, 0);
               }

               ActionMenuView.LayoutParams var27 = (ActionMenuView.LayoutParams)var28.getLayoutParams();
               var27.f = false;
               var27.c = 0;
               var27.b = 0;
               var27.d = false;
               var27.leftMargin = 0;
               var27.rightMargin = 0;
               if (var26 && ((ActionMenuItemView)var28).b()) {
                  var26 = true;
               } else {
                  var26 = false;
               }

               var27.e = var26;
               if (var27.a) {
                  var2 = 1;
               } else {
                  var2 = var1;
               }

               int var15 = a(var28, var21, var2, var18, var14);
               var10 = Math.max(var10, var15);
               if (var27.d) {
                  var2 = var9 + 1;
               } else {
                  var2 = var9;
               }

               boolean var50;
               if (var27.a) {
                  var50 = true;
               } else {
                  var50 = (boolean)var8;
               }

               var1 -= var15;
               int var13 = Math.max(var6, var28.getMeasuredHeight());
               if (var15 == 1) {
                  long var24 = 1 << var12;
                  var6 = var1;
                  var9 = var2;
                  var22 |= var24;
                  var2 = var10;
                  var1 = var11;
                  var8 = var50;
                  var7 = var13;
               } else {
                  var8 = var10;
                  var10 = var13;
                  var6 = var1;
                  var9 = var2;
                  var1 = var11;
                  var2 = var8;
                  var8 = var50;
                  var7 = var10;
               }
            }

            var12++;
            var11 = var1;
            var1 = var6;
            var10 = var2;
            var6 = var7;
         }

         boolean var61;
         if (var8 && var11 == 2) {
            var61 = true;
         } else {
            var61 = false;
         }

         int var51 = 0;
         var12 = var1;

         while (var9 > 0 && var12 > 0) {
            var1 = Integer.MAX_VALUE;
            long var68 = 0L;
            var2 = 0;
            var14 = 0;

            while (var14 < var20) {
               ActionMenuView.LayoutParams var70 = (ActionMenuView.LayoutParams)this.getChildAt(var14).getLayoutParams();
               if (!var70.d) {
                  int var64 = var2;
                  var2 = var1;
                  var1 = var64;
               } else if (var70.b < var1) {
                  var2 = var70.b;
                  var68 = 1L << var14;
                  var1 = 1;
               } else if (var70.b == var1) {
                  var68 |= 1L << var14;
                  int var65 = var2 + 1;
                  var2 = var1;
                  var1 = var65;
               } else {
                  int var66 = var1;
                  var1 = var2;
                  var2 = var66;
               }

               int var67 = var14 + 1;
               var14 = var2;
               var2 = var1;
               var1 = var14;
               var14 = var67;
            }

            var22 |= var68;
            if (var2 > var12) {
               break;
            }

            var51 = 0;
            var2 = var12;

            while (var51 < var20) {
               View var74 = this.getChildAt(var51);
               ActionMenuView.LayoutParams var71 = (ActionMenuView.LayoutParams)var74.getLayoutParams();
               if ((1 << var51 & var68) == 0L) {
                  if (var71.b == var1 + 1) {
                     var22 |= 1 << var51;
                  }
               } else {
                  if (var61 && var71.e && var2 == 1) {
                     var74.setPadding(this.l + var21, 0, this.l, 0);
                  }

                  var71.b++;
                  var71.f = true;
                  var2--;
               }

               var51++;
            }

            var51 = 1;
            var12 = var2;
         }

         boolean var35;
         if (!var8 && var11 == 1) {
            var35 = true;
         } else {
            var35 = false;
         }

         boolean var55;
         if (var12 > 0 && var22 != 0L && (var12 < var11 - 1 || var35 || var10 > 1)) {
            float var5 = Long.bitCount(var22);
            float var3 = var5;
            if (!var35) {
               float var4 = var5;
               if ((1L & var22) != 0L) {
                  var4 = var5;
                  if (!((ActionMenuView.LayoutParams)this.getChildAt(0).getLayoutParams()).e) {
                     var4 = var5 - 0.5F;
                  }
               }

               var3 = var4;
               if ((1 << var20 - 1 & var22) != 0L) {
                  var3 = var4;
                  if (!((ActionMenuView.LayoutParams)this.getChildAt(var20 - 1).getLayoutParams()).e) {
                     var3 = var4 - 0.5F;
                  }
               }
            }

            if (var3 > 0.0F) {
               var2 = (int)(var12 * var21 / var3);
            } else {
               var2 = 0;
            }

            var55 = 0;
            var35 = (boolean)var51;
            var51 = var55;

            while (true) {
               var55 = var35;
               if (var51 >= var20) {
                  break;
               }

               if ((1 << var51 & var22) != 0L) {
                  View var72 = this.getChildAt(var51);
                  ActionMenuView.LayoutParams var75 = (ActionMenuView.LayoutParams)var72.getLayoutParams();
                  if (var72 instanceof ActionMenuItemView) {
                     var75.c = var2;
                     var75.f = true;
                     if (var51 == 0 && !var75.e) {
                        var75.leftMargin = -var2 / 2;
                     }

                     var35 = true;
                  } else if (var75.a) {
                     var75.c = var2;
                     var75.f = true;
                     var75.rightMargin = -var2 / 2;
                     var35 = true;
                  } else {
                     if (var51 != 0) {
                        var75.leftMargin = var2 / 2;
                     }

                     if (var51 != var20 - 1) {
                        var75.rightMargin = var2 / 2;
                     }
                  }
               }

               var51++;
            }
         } else {
            var55 = (byte)var51;
         }

         if (var55) {
            for (int var37 = 0; var37 < var20; var37++) {
               View var73 = this.getChildAt(var37);
               ActionMenuView.LayoutParams var76 = (ActionMenuView.LayoutParams)var73.getLayoutParams();
               if (var76.f) {
                  var2 = var76.b;
                  var73.measure(MeasureSpec.makeMeasureSpec(var76.c + var2 * var21, 1073741824), var18);
               }
            }
         }

         if (var17 == 1073741824) {
            var6 = var16;
         }

         this.setMeasuredDimension(var19, var6);
      }
   }

   public ActionMenuView.LayoutParams a(AttributeSet var1) {
      return new ActionMenuView.LayoutParams(this.getContext(), var1);
   }

   protected ActionMenuView.LayoutParams a(android.view.ViewGroup.LayoutParams var1) {
      ActionMenuView.LayoutParams var2;
      if (var1 != null) {
         ActionMenuView.LayoutParams var3;
         if (var1 instanceof ActionMenuView.LayoutParams) {
            var3 = new ActionMenuView.LayoutParams((ActionMenuView.LayoutParams)var1);
         } else {
            var3 = new ActionMenuView.LayoutParams(var1);
         }

         var2 = var3;
         if (var3.h <= 0) {
            var3.h = 16;
            var2 = var3;
         }
      } else {
         var2 = this.b();
      }

      return var2;
   }

   @Override
   public void a(MenuBuilder var1) {
      this.c = var1;
   }

   public void a(MenuPresenter.Callback var1, MenuBuilder.Callback var2) {
      this.h = var1;
      this.a = var2;
   }

   public boolean a() {
      return this.f;
   }

   protected boolean a(int var1) {
      boolean var3 = false;
      boolean var2;
      if (var1 == 0) {
         var2 = false;
      } else {
         View var5 = this.getChildAt(var1 - 1);
         View var4 = this.getChildAt(var1);
         var2 = var3;
         if (var1 < this.getChildCount()) {
            var2 = var3;
            if (var5 instanceof ActionMenuView.ActionMenuChildView) {
               var2 = false | ((ActionMenuView.ActionMenuChildView)var5).d();
            }
         }

         if (var1 > 0 && var4 instanceof ActionMenuView.ActionMenuChildView) {
            var2 |= ((ActionMenuView.ActionMenuChildView)var4).c();
         }
      }

      return var2;
   }

   @Override
   public boolean a(MenuItemImpl var1) {
      return this.c.a(var1, 0);
   }

   protected ActionMenuView.LayoutParams b() {
      ActionMenuView.LayoutParams var1 = new ActionMenuView.LayoutParams(-2, -2);
      var1.h = 16;
      return var1;
   }

   public ActionMenuView.LayoutParams c() {
      ActionMenuView.LayoutParams var1 = this.b();
      var1.a = true;
      return var1;
   }

   @Override
   protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams var1) {
      boolean var2;
      if (var1 != null && var1 instanceof ActionMenuView.LayoutParams) {
         var2 = true;
      } else {
         var2 = false;
      }

      return var2;
   }

   public MenuBuilder d() {
      return this.c;
   }

   public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent var1) {
      return false;
   }

   public boolean e() {
      boolean var1;
      if (this.g != null && this.g.f()) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   public boolean f() {
      boolean var1;
      if (this.g != null && this.g.g()) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   public boolean g() {
      boolean var1;
      if (this.g != null && this.g.j()) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   public Menu getMenu() {
      if (this.c == null) {
         Context var1 = this.getContext();
         this.c = new MenuBuilder(var1);
         this.c.a(new ActionMenuView.MenuBuilderCallback(this));
         this.g = new ActionMenuPresenter(var1);
         this.g.c(true);
         ActionMenuPresenter var2 = this.g;
         MenuPresenter.Callback var3;
         if (this.h != null) {
            var3 = this.h;
         } else {
            var3 = new ActionMenuView.ActionMenuPresenterCallback();
         }

         var2.a(var3);
         this.c.a(this.g, this.d);
         this.g.a(this);
      }

      return this.c;
   }

   public Drawable getOverflowIcon() {
      this.getMenu();
      return this.g.e();
   }

   public int getPopupTheme() {
      return this.e;
   }

   public int getWindowAnimations() {
      return 0;
   }

   public boolean h() {
      boolean var1;
      if (this.g != null && this.g.k()) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   public void i() {
      if (this.g != null) {
         this.g.h();
      }
   }

   public void onConfigurationChanged(Configuration var1) {
      super.onConfigurationChanged(var1);
      if (this.g != null) {
         this.g.a(false);
         if (this.g.j()) {
            this.g.g();
            this.g.f();
         }
      }
   }

   public void onDetachedFromWindow() {
      super.onDetachedFromWindow();
      this.i();
   }

   @Override
   protected void onLayout(boolean var1, int var2, int var3, int var4, int var5) {
      if (!this.i) {
         super.onLayout(var1, var2, var3, var4, var5);
      } else {
         int var12 = this.getChildCount();
         int var11 = (var5 - var3) / 2;
         int var13 = this.getDividerWidth();
         var5 = 0;
         var3 = 0;
         int var7 = var4 - var2 - this.getPaddingRight() - this.getPaddingLeft();
         int var6 = 0;
         var1 = ViewUtils.a(this);
         int var8 = 0;

         while (var8 < var12) {
            View var16 = this.getChildAt(var8);
            boolean var28;
            if (var16.getVisibility() == 8) {
               boolean var9 = (boolean)var6;
               var6 = var7;
               var7 = var5;
               var5 = var3;
               var28 = var9;
            } else {
               ActionMenuView.LayoutParams var17 = (ActionMenuView.LayoutParams)var16.getLayoutParams();
               if (var17.a) {
                  int var49 = var16.getMeasuredWidth();
                  var6 = var49;
                  if (this.a(var8)) {
                     var6 = var49 + var13;
                  }

                  int var14 = var16.getMeasuredHeight();
                  int var10;
                  if (var1) {
                     var49 = this.getPaddingLeft();
                     var10 = var17.leftMargin + var49;
                     var49 = var10 + var6;
                  } else {
                     var49 = this.getWidth() - this.getPaddingRight() - var17.rightMargin;
                     var10 = var49 - var6;
                  }

                  int var15 = var11 - var14 / 2;
                  var16.layout(var10, var15, var49, var14 + var15);
                  var6 = var7 - var6;
                  boolean var56 = true;
                  var7 = var3;
                  var49 = var5;
                  var28 = var56;
                  var5 = var7;
                  var7 = var49;
               } else {
                  int var57 = var16.getMeasuredWidth() + var17.leftMargin + var17.rightMargin;
                  int var53 = var5 + var57;
                  var5 = var53;
                  if (this.a(var8)) {
                     var5 = var53 + var13;
                  }

                  var53 = var7 - var57;
                  var57 = var3 + 1;
                  var7 = var5;
                  var28 = (boolean)var6;
                  var6 = var53;
                  var5 = var57;
               }
            }

            int var55 = var8 + 1;
            var8 = var7;
            var7 = var6;
            var6 = var28;
            var3 = var5;
            var5 = var8;
            var8 = var55;
         }

         if (var12 == 1 && !var6) {
            View var61 = this.getChildAt(0);
            var5 = var61.getMeasuredWidth();
            var3 = var61.getMeasuredHeight();
            var2 = (var4 - var2) / 2 - var5 / 2;
            var4 = var11 - var3 / 2;
            var61.layout(var2, var4, var5 + var2, var3 + var4);
         } else {
            byte var19;
            if (var6) {
               var19 = 0;
            } else {
               var19 = 1;
            }

            var19 = var3 - var19;
            if (var19 > 0) {
               var19 = var7 / var19;
            } else {
               var19 = 0;
            }

            var4 = Math.max(0, var19);
            if (var1) {
               var19 = this.getWidth() - this.getPaddingRight();

               for (int var29 = 0; var29 < var12; var29++) {
                  View var59 = this.getChildAt(var29);
                  ActionMenuView.LayoutParams var62 = (ActionMenuView.LayoutParams)var59.getLayoutParams();
                  if (var59.getVisibility() != 8 && !var62.a) {
                     var5 = var19 - var62.rightMargin;
                     var7 = var59.getMeasuredWidth();
                     var6 = var59.getMeasuredHeight();
                     var19 = var11 - var6 / 2;
                     var59.layout(var5 - var7, var19, var5, var6 + var19);
                     var19 = var5 - (var62.leftMargin + var7 + var4);
                  }
               }
            } else {
               var19 = this.getPaddingLeft();

               for (int var30 = 0; var30 < var12; var30++) {
                  View var63 = this.getChildAt(var30);
                  ActionMenuView.LayoutParams var60 = (ActionMenuView.LayoutParams)var63.getLayoutParams();
                  if (var63.getVisibility() != 8 && !var60.a) {
                     var7 = var19 + var60.leftMargin;
                     var19 = var63.getMeasuredWidth();
                     var5 = var63.getMeasuredHeight();
                     var6 = var11 - var5 / 2;
                     var63.layout(var7, var6, var7 + var19, var5 + var6);
                     var19 = var60.rightMargin + var19 + var4 + var7;
                  }
               }
            }
         }
      }
   }

   @Override
   protected void onMeasure(int var1, int var2) {
      boolean var6 = this.i;
      boolean var5;
      if (MeasureSpec.getMode(var1) == 1073741824) {
         var5 = true;
      } else {
         var5 = false;
      }

      this.i = var5;
      if (var6 != this.i) {
         this.j = 0;
      }

      int var3 = MeasureSpec.getSize(var1);
      if (this.i && this.c != null && var3 != this.j) {
         this.j = var3;
         this.c.a(true);
      }

      int var4 = this.getChildCount();
      if (this.i && var4 > 0) {
         this.c(var1, var2);
      } else {
         for (int var8 = 0; var8 < var4; var8++) {
            ActionMenuView.LayoutParams var7 = (ActionMenuView.LayoutParams)this.getChildAt(var8).getLayoutParams();
            var7.rightMargin = 0;
            var7.leftMargin = 0;
         }

         super.onMeasure(var1, var2);
      }
   }

   public void setExpandedActionViewsExclusive(boolean var1) {
      this.g.d(var1);
   }

   public void setOnMenuItemClickListener(ActionMenuView.OnMenuItemClickListener var1) {
      this.b = var1;
   }

   public void setOverflowIcon(Drawable var1) {
      this.getMenu();
      this.g.a(var1);
   }

   public void setOverflowReserved(boolean var1) {
      this.f = var1;
   }

   public void setPopupTheme(int var1) {
      if (this.e != var1) {
         this.e = var1;
         if (var1 == 0) {
            this.d = this.getContext();
         } else {
            this.d = new ContextThemeWrapper(this.getContext(), var1);
         }
      }
   }

   public void setPresenter(ActionMenuPresenter var1) {
      this.g = var1;
      this.g.a(this);
   }

   public interface ActionMenuChildView {
      boolean c();

      boolean d();
   }

   private static class ActionMenuPresenterCallback implements MenuPresenter.Callback {
      ActionMenuPresenterCallback() {
      }

      @Override
      public void a(MenuBuilder var1, boolean var2) {
      }

      @Override
      public boolean a(MenuBuilder var1) {
         return false;
      }
   }

   public static class LayoutParams extends LinearLayoutCompat.LayoutParams {
      @ExportedProperty
      public boolean a;
      @ExportedProperty
      public int b;
      @ExportedProperty
      public int c;
      @ExportedProperty
      public boolean d;
      @ExportedProperty
      public boolean e;
      boolean f;

      public LayoutParams(int var1, int var2) {
         super(var1, var2);
         this.a = false;
      }

      public LayoutParams(Context var1, AttributeSet var2) {
         super(var1, var2);
      }

      public LayoutParams(ActionMenuView.LayoutParams var1) {
         super(var1);
         this.a = var1.a;
      }

      public LayoutParams(android.view.ViewGroup.LayoutParams var1) {
         super(var1);
      }
   }

   private class MenuBuilderCallback implements MenuBuilder.Callback {
      final ActionMenuView a;

      MenuBuilderCallback(ActionMenuView var1) {
         this.a = var1;
      }

      @Override
      public void a(MenuBuilder var1) {
         if (this.a.a != null) {
            this.a.a.a(var1);
         }
      }

      @Override
      public boolean a(MenuBuilder var1, MenuItem var2) {
         boolean var3;
         if (this.a.b != null && this.a.b.a(var2)) {
            var3 = true;
         } else {
            var3 = false;
         }

         return var3;
      }
   }

   public interface OnMenuItemClickListener {
      boolean a(MenuItem var1);
   }
}
