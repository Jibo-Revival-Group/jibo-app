package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.view.ActionProvider;
import android.support.v7.appcompat.R;
import android.support.v7.view.ActionBarPolicy;
import android.support.v7.view.menu.ActionMenuItemView;
import android.support.v7.view.menu.BaseMenuPresenter;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuItemImpl;
import android.support.v7.view.menu.MenuPopup;
import android.support.v7.view.menu.MenuPopupHelper;
import android.support.v7.view.menu.MenuPresenter;
import android.support.v7.view.menu.MenuView;
import android.support.v7.view.menu.ShowableListMenu;
import android.support.v7.view.menu.SubMenuBuilder;
import android.util.SparseBooleanArray;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import java.util.ArrayList;

class ActionMenuPresenter extends BaseMenuPresenter implements ActionProvider.SubUiVisibilityListener {
   private ActionMenuPresenter.ActionMenuPopupCallback A;
   ActionMenuPresenter.OverflowMenuButton g;
   ActionMenuPresenter.OverflowPopup h;
   ActionMenuPresenter.ActionButtonSubmenu i;
   ActionMenuPresenter.OpenOverflowRunnable j;
   final ActionMenuPresenter.PopupPresenterCallback k;
   int l;
   private Drawable m;
   private boolean n;
   private boolean o;
   private boolean p;
   private int q;
   private int r;
   private int s;
   private boolean t;
   private boolean u;
   private boolean v;
   private boolean w;
   private int x;
   private final SparseBooleanArray y = new SparseBooleanArray();
   private View z;

   public ActionMenuPresenter(Context var1) {
      super(var1, R.layout.abc_action_menu_layout, R.layout.abc_action_menu_item_layout);
      this.k = new ActionMenuPresenter.PopupPresenterCallback(this);
   }

   private View a(MenuItem var1) {
      ViewGroup var6 = (ViewGroup)this.f;
      View var4;
      if (var6 == null) {
         var4 = null;
      } else {
         int var3 = var6.getChildCount();
         int var2 = 0;

         while (true) {
            if (var2 >= var3) {
               var4 = null;
               break;
            }

            View var5 = var6.getChildAt(var2);
            if (var5 instanceof MenuView.ItemView) {
               var4 = var5;
               if (((MenuView.ItemView)var5).getItemData() == var1) {
                  break;
               }
            }

            var2++;
         }
      }

      return var4;
   }

   @Override
   public MenuView a(ViewGroup var1) {
      MenuView var2 = this.f;
      MenuView var3 = super.a(var1);
      if (var2 != var3) {
         ((ActionMenuView)var3).setPresenter(this);
      }

      return var3;
   }

   @Override
   public View a(MenuItemImpl var1, View var2, ViewGroup var3) {
      View var5 = var1.getActionView();
      if (var5 == null || var1.n()) {
         var5 = super.a(var1, var2, var3);
      }

      byte var4;
      if (var1.isActionViewExpanded()) {
         var4 = 8;
      } else {
         var4 = 0;
      }

      var5.setVisibility(var4);
      ActionMenuView var7 = (ActionMenuView)var3;
      LayoutParams var6 = var5.getLayoutParams();
      if (!var7.checkLayoutParams(var6)) {
         var5.setLayoutParams(var7.a(var6));
      }

      return var5;
   }

   @Override
   public void a(Context var1, MenuBuilder var2) {
      super.a(var1, var2);
      Resources var6 = var1.getResources();
      ActionBarPolicy var5 = ActionBarPolicy.a(var1);
      if (!this.p) {
         this.o = var5.b();
      }

      if (!this.v) {
         this.q = var5.c();
      }

      if (!this.t) {
         this.s = var5.a();
      }

      int var3 = this.q;
      if (this.o) {
         if (this.g == null) {
            this.g = new ActionMenuPresenter.OverflowMenuButton(this, this.a);
            if (this.n) {
               this.g.setImageDrawable(this.m);
               this.m = null;
               this.n = false;
            }

            int var4 = MeasureSpec.makeMeasureSpec(0, 0);
            this.g.measure(var4, var4);
         }

         var3 -= this.g.getMeasuredWidth();
      } else {
         this.g = null;
      }

      this.r = var3;
      this.x = (int)(56.0F * var6.getDisplayMetrics().density);
      this.z = null;
   }

   public void a(Configuration var1) {
      if (!this.t) {
         this.s = ActionBarPolicy.a(this.b).a();
      }

      if (this.c != null) {
         this.c.a(true);
      }
   }

   public void a(Drawable var1) {
      if (this.g != null) {
         this.g.setImageDrawable(var1);
      } else {
         this.n = true;
         this.m = var1;
      }
   }

   @Override
   public void a(Parcelable var1) {
      if (var1 instanceof ActionMenuPresenter.SavedState) {
         var1 = var1;
         if (var1.a > 0) {
            MenuItem var3 = this.c.findItem(var1.a);
            if (var3 != null) {
               this.a((SubMenuBuilder)var3.getSubMenu());
            }
         }
      }
   }

   @Override
   public void a(MenuBuilder var1, boolean var2) {
      this.h();
      super.a(var1, var2);
   }

   @Override
   public void a(MenuItemImpl var1, MenuView.ItemView var2) {
      var2.a(var1, 0);
      ActionMenuView var3 = (ActionMenuView)this.f;
      var2 = var2;
      var2.setItemInvoker(var3);
      if (this.A == null) {
         this.A = new ActionMenuPresenter.ActionMenuPopupCallback(this);
      }

      var2.setPopupCallback(this.A);
   }

   public void a(ActionMenuView var1) {
      this.f = var1;
      var1.a(this.c);
   }

   @Override
   public void a(boolean var1) {
      boolean var3 = true;
      boolean var4 = false;
      super.a(var1);
      ((View)this.f).requestLayout();
      if (this.c != null) {
         ArrayList var7 = this.c.k();
         int var5 = var7.size();

         for (int var2 = 0; var2 < var5; var2++) {
            ActionProvider var6 = ((MenuItemImpl)var7.get(var2)).a();
            if (var6 != null) {
               var6.a(this);
            }
         }
      }

      ArrayList var10;
      if (this.c != null) {
         var10 = this.c.l();
      } else {
         var10 = null;
      }

      int var8 = var4;
      if (this.o) {
         var8 = var4;
         if (var10 != null) {
            var8 = var10.size();
            if (var8 == 1) {
               if (!((MenuItemImpl)var10.get(0)).isActionViewExpanded()) {
                  var8 = 1;
               } else {
                  var8 = 0;
               }
            } else if (var8 > 0) {
               var8 = var3;
            } else {
               var8 = 0;
            }
         }
      }

      if (var8) {
         if (this.g == null) {
            this.g = new ActionMenuPresenter.OverflowMenuButton(this, this.a);
         }

         ViewGroup var11 = (ViewGroup)this.g.getParent();
         if (var11 != this.f) {
            if (var11 != null) {
               var11.removeView(this.g);
            }

            ActionMenuView var12 = (ActionMenuView)this.f;
            var12.addView(this.g, var12.c());
         }
      } else if (this.g != null && this.g.getParent() == this.f) {
         ((ViewGroup)this.f).removeView(this.g);
      }

      ((ActionMenuView)this.f).setOverflowReserved(this.o);
   }

   @Override
   public boolean a() {
      int var6;
      ArrayList var14;
      if (this.c != null) {
         var14 = this.c.i();
         var6 = var14.size();
      } else {
         var6 = 0;
         var14 = null;
      }

      int var1 = this.s;
      int var9 = this.r;
      int var10 = MeasureSpec.makeMeasureSpec(0, 0);
      ViewGroup var15 = (ViewGroup)this.f;
      int var3 = 0;
      int var5 = 0;
      int var4 = 0;

      for (int var2 = 0; var2 < var6; var2++) {
         MenuItemImpl var16 = (MenuItemImpl)var14.get(var2);
         if (var16.l()) {
            var3++;
         } else if (var16.k()) {
            var5++;
         } else {
            var4 = 1;
         }

         if (this.w && var16.isActionViewExpanded()) {
            var1 = 0;
         }
      }

      int var22;
      var22 = var1;
      label164:
      if (this.o) {
         if (!var4) {
            var22 = var1;
            if (var3 + var5 <= var1) {
               break label164;
            }
         }

         var22 = var1 - 1;
      }

      var22 -= var3;
      SparseBooleanArray var17 = this.y;
      var17.clear();
      var1 = 0;
      int var7;
      if (this.u) {
         var1 = var9 / this.x;
         var4 = this.x;
         var3 = this.x;
         var7 = var9 % var4 / var1 + var3;
      } else {
         var7 = 0;
      }

      int var8 = 0;
      int var39 = 0;
      var3 = var1;
      var1 = var22;
      var4 = var9;
      var22 = var39;

      while (var8 < var6) {
         MenuItemImpl var57 = (MenuItemImpl)var14.get(var8);
         if (var57.l()) {
            View var59 = this.a(var57, this.z, var15);
            if (this.z == null) {
               this.z = var59;
            }

            if (this.u) {
               var39 = var3 - ActionMenuView.a(var59, var7, var3, var10, 0);
            } else {
               var59.measure(var10, var10);
               var39 = var3;
            }

            var3 = var59.getMeasuredWidth();
            if (var22 == 0) {
               var22 = var3;
            }

            var9 = var57.getGroupId();
            if (var9 != 0) {
               var17.put(var9, true);
            }

            var57.d(true);
            var9 = var4 - var3;
            var3 = var1;
            var1 = var22;
            var4 = var39;
            var22 = var9;
         } else if (!var57.k()) {
            var57.d(false);
            var39 = var22;
            var22 = var4;
            var9 = var1;
            var4 = var3;
            var1 = var39;
            var3 = var9;
         } else {
            int var11 = var57.getGroupId();
            boolean var13 = var17.get(var11);
            boolean var12;
            if (var1 <= 0 && !var13 || var4 <= 0 || this.u && var3 <= 0) {
               var12 = false;
            } else {
               var12 = true;
            }

            if (var12) {
               View var18 = this.a(var57, this.z, var15);
               if (this.z == null) {
                  this.z = var18;
               }

               if (this.u) {
                  var39 = ActionMenuView.a(var18, var7, var3, var10, 0);
                  if (var39 == 0) {
                     var12 = false;
                  }

                  var3 -= var39;
               } else {
                  var18.measure(var10, var10);
               }

               var39 = var18.getMeasuredWidth();
               var9 = var4 - var39;
               var4 = var22;
               if (var22 == 0) {
                  var4 = var39;
               }

               if (this.u) {
                  boolean var25;
                  if (var9 >= 0) {
                     var25 = 1;
                  } else {
                     var25 = 0;
                  }

                  var12 &= var25;
                  var25 = var4;
                  var39 = var3;
                  var4 = var9;
                  var3 = var25;
                  var22 = var39;
               } else {
                  boolean var28;
                  if (var9 + var4 > 0) {
                     var28 = true;
                  } else {
                     var28 = false;
                  }

                  var12 &= var28;
                  var22 = var3;
                  var3 = var4;
                  var4 = var9;
               }
            } else {
               var39 = var22;
               var22 = var3;
               var3 = var39;
            }

            if (var12 && var11 != 0) {
               var17.put(var11, true);
            } else if (var13) {
               var17.put(var11, false);
               var9 = 0;

               while (var9 < var8) {
                  MenuItemImpl var58 = (MenuItemImpl)var14.get(var9);
                  var39 = var1;
                  if (var58.getGroupId() == var11) {
                     var39 = var1;
                     if (var58.j()) {
                        var39 = var1 + 1;
                     }

                     var58.d(false);
                  }

                  var9++;
                  var1 = var39;
               }
            }

            var39 = var1;
            if (var12) {
               var39 = var1 - 1;
            }

            var57.d(var12);
            var1 = var3;
            var3 = var39;
            var39 = var22;
            var22 = var4;
            var4 = var39;
         }

         var9 = var8 + 1;
         var8 = var22;
         var39 = var3;
         var3 = var4;
         var22 = var1;
         var4 = var8;
         var1 = var39;
         var8 = var9;
      }

      return true;
   }

   @Override
   public boolean a(int var1, MenuItemImpl var2) {
      return var2.j();
   }

   @Override
   public boolean a(SubMenuBuilder var1) {
      boolean var4 = false;
      if (var1.hasVisibleItems()) {
         SubMenuBuilder var5 = var1;

         while (var5.s() != this.c) {
            var5 = (SubMenuBuilder)var5.s();
         }

         View var6 = this.a(var5.getItem());
         if (var6 != null) {
            this.l = var1.getItem().getItemId();
            int var3 = var1.size();
            int var2 = 0;

            while (true) {
               if (var2 >= var3) {
                  var4 = false;
                  break;
               }

               MenuItem var8 = var1.getItem(var2);
               if (var8.isVisible() && var8.getIcon() != null) {
                  var4 = true;
                  break;
               }

               var2++;
            }

            this.i = new ActionMenuPresenter.ActionButtonSubmenu(this, this.b, var1, var6);
            this.i.a(var4);
            this.i.a();
            super.a(var1);
            var4 = true;
         }
      }

      return var4;
   }

   @Override
   public boolean a(ViewGroup var1, int var2) {
      boolean var3;
      if (var1.getChildAt(var2) == this.g) {
         var3 = false;
      } else {
         var3 = super.a(var1, var2);
      }

      return var3;
   }

   @Override
   public void b(boolean var1) {
      if (var1) {
         super.a((SubMenuBuilder)null);
      } else if (this.c != null) {
         this.c.b(false);
      }
   }

   @Override
   public Parcelable c() {
      ActionMenuPresenter.SavedState var1 = new ActionMenuPresenter.SavedState();
      var1.a = this.l;
      return var1;
   }

   public void c(boolean var1) {
      this.o = var1;
      this.p = true;
   }

   public void d(boolean var1) {
      this.w = var1;
   }

   public Drawable e() {
      Drawable var1;
      if (this.g != null) {
         var1 = this.g.getDrawable();
      } else if (this.n) {
         var1 = this.m;
      } else {
         var1 = null;
      }

      return var1;
   }

   public boolean f() {
      boolean var1 = true;
      if (this.o && !this.j() && this.c != null && this.f != null && this.j == null && !this.c.l().isEmpty()) {
         this.j = new ActionMenuPresenter.OpenOverflowRunnable(this, new ActionMenuPresenter.OverflowPopup(this, this.b, this.c, this.g, true));
         ((View)this.f).post(this.j);
         super.a((SubMenuBuilder)null);
      } else {
         var1 = false;
      }

      return var1;
   }

   public boolean g() {
      boolean var1;
      if (this.j != null && this.f != null) {
         ((View)this.f).removeCallbacks(this.j);
         this.j = null;
         var1 = true;
      } else {
         ActionMenuPresenter.OverflowPopup var2 = this.h;
         if (var2 != null) {
            var2.d();
            var1 = true;
         } else {
            var1 = false;
         }
      }

      return var1;
   }

   public boolean h() {
      return this.g() | this.i();
   }

   public boolean i() {
      boolean var1;
      if (this.i != null) {
         this.i.d();
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   public boolean j() {
      boolean var1;
      if (this.h != null && this.h.f()) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   public boolean k() {
      boolean var1;
      if (this.j == null && !this.j()) {
         var1 = false;
      } else {
         var1 = true;
      }

      return var1;
   }

   private class ActionButtonSubmenu extends MenuPopupHelper {
      final ActionMenuPresenter a;

      public ActionButtonSubmenu(ActionMenuPresenter var1, Context var2, SubMenuBuilder var3, View var4) {
         super(var2, var3, var4, false, R.attr.actionOverflowMenuStyle);
         this.a = var1;
         if (!((MenuItemImpl)var3.getItem()).j()) {
            Object var5;
            if (var1.g == null) {
               var5 = (View)var1.f;
            } else {
               var5 = var1.g;
            }

            this.a((View)var5);
         }

         this.a(var1.k);
      }

      @Override
      protected void e() {
         this.a.i = null;
         this.a.l = 0;
         super.e();
      }
   }

   private class ActionMenuPopupCallback extends ActionMenuItemView.PopupCallback {
      final ActionMenuPresenter a;

      ActionMenuPopupCallback(ActionMenuPresenter var1) {
         this.a = var1;
      }

      @Override
      public ShowableListMenu a() {
         MenuPopup var1;
         if (this.a.i != null) {
            var1 = this.a.i.b();
         } else {
            var1 = null;
         }

         return var1;
      }
   }

   private class OpenOverflowRunnable implements Runnable {
      final ActionMenuPresenter a;
      private ActionMenuPresenter.OverflowPopup b;

      public OpenOverflowRunnable(ActionMenuPresenter var1, ActionMenuPresenter.OverflowPopup var2) {
         this.a = var1;
         this.b = var2;
      }

      @Override
      public void run() {
         if (this.a.c != null) {
            this.a.c.f();
         }

         View var1 = (View)this.a.f;
         if (var1 != null && var1.getWindowToken() != null && this.b.c()) {
            this.a.h = this.b;
         }

         this.a.j = null;
      }
   }

   private class OverflowMenuButton extends AppCompatImageView implements ActionMenuView.ActionMenuChildView {
      final ActionMenuPresenter a;
      private final float[] b;

      public OverflowMenuButton(ActionMenuPresenter var1, Context var2) {
         super(var2, null, R.attr.actionOverflowButtonStyle);
         this.a = var1;
         this.b = new float[2];
         this.setClickable(true);
         this.setFocusable(true);
         this.setVisibility(0);
         this.setEnabled(true);
         TooltipCompat.a(this, this.getContentDescription());
         this.setOnTouchListener(new ForwardingListener(this, this, var1) {
            final ActionMenuPresenter a;
            final ActionMenuPresenter.OverflowMenuButton b;

            {
               this.b = var1;
               this.a = var3;
            }

            @Override
            public ShowableListMenu a() {
               MenuPopup var1x;
               if (this.b.a.h == null) {
                  var1x = null;
               } else {
                  var1x = this.b.a.h.b();
               }

               return var1x;
            }

            @Override
            public boolean b() {
               this.b.a.f();
               return true;
            }

            @Override
            public boolean c() {
               boolean var1x;
               if (this.b.a.j != null) {
                  var1x = false;
               } else {
                  this.b.a.g();
                  var1x = true;
               }

               return var1x;
            }
         });
      }

      @Override
      public boolean c() {
         return false;
      }

      @Override
      public boolean d() {
         return false;
      }

      public boolean performClick() {
         if (!super.performClick()) {
            this.playSoundEffect(0);
            this.a.f();
         }

         return true;
      }

      protected boolean setFrame(int var1, int var2, int var3, int var4) {
         boolean var8 = super.setFrame(var1, var2, var3, var4);
         Drawable var10 = this.getDrawable();
         Drawable var9 = this.getBackground();
         if (var10 != null && var9 != null) {
            int var7 = this.getWidth();
            var2 = this.getHeight();
            var1 = Math.max(var7, var2) / 2;
            int var6 = this.getPaddingLeft();
            int var5 = this.getPaddingRight();
            var4 = this.getPaddingTop();
            var3 = this.getPaddingBottom();
            var5 = (var7 + (var6 - var5)) / 2;
            var2 = (var2 + (var4 - var3)) / 2;
            DrawableCompat.a(var9, var5 - var1, var2 - var1, var5 + var1, var2 + var1);
         }

         return var8;
      }
   }

   private class OverflowPopup extends MenuPopupHelper {
      final ActionMenuPresenter a;

      public OverflowPopup(ActionMenuPresenter var1, Context var2, MenuBuilder var3, View var4, boolean var5) {
         super(var2, var3, var4, var5, R.attr.actionOverflowMenuStyle);
         this.a = var1;
         this.a(8388613);
         this.a(var1.k);
      }

      @Override
      protected void e() {
         if (this.a.c != null) {
            this.a.c.close();
         }

         this.a.h = null;
         super.e();
      }
   }

   private class PopupPresenterCallback implements MenuPresenter.Callback {
      final ActionMenuPresenter a;

      PopupPresenterCallback(ActionMenuPresenter var1) {
         this.a = var1;
      }

      @Override
      public void a(MenuBuilder var1, boolean var2) {
         if (var1 instanceof SubMenuBuilder) {
            var1.p().b(false);
         }

         MenuPresenter.Callback var3 = this.a.d();
         if (var3 != null) {
            var3.a(var1, var2);
         }
      }

      @Override
      public boolean a(MenuBuilder var1) {
         boolean var2 = false;
         if (var1 != null) {
            this.a.l = ((SubMenuBuilder)var1).getItem().getItemId();
            MenuPresenter.Callback var3 = this.a.d();
            if (var3 != null) {
               var2 = var3.a(var1);
            } else {
               var2 = false;
            }
         }

         return var2;
      }
   }

   private static class SavedState implements Parcelable {
      public static final Creator<ActionMenuPresenter.SavedState> CREATOR = new Creator<ActionMenuPresenter.SavedState>() {
         public ActionMenuPresenter.SavedState a(Parcel var1) {
            return new ActionMenuPresenter.SavedState(var1);
         }

         public ActionMenuPresenter.SavedState[] a(int var1) {
            return new ActionMenuPresenter.SavedState[var1];
         }
      };
      public int a;

      SavedState() {
      }

      SavedState(Parcel var1) {
         this.a = var1.readInt();
      }

      public int describeContents() {
         return 0;
      }

      public void writeToParcel(Parcel var1, int var2) {
         var1.writeInt(this.a);
      }
   }
}
