package android.support.v7.view.menu;

import android.content.Context;
import android.graphics.Rect;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.MeasureSpec;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.PopupWindow.OnDismissListener;

abstract class MenuPopup implements MenuPresenter, ShowableListMenu, OnItemClickListener {
   private Rect a;

   protected static int a(ListAdapter var0, ViewGroup var1, Context var2, int var3) {
      int var10 = MeasureSpec.makeMeasureSpec(0, 0);
      int var11 = MeasureSpec.makeMeasureSpec(0, 0);
      int var9 = var0.getCount();
      int var5 = 0;
      int var7 = 0;
      View var12 = null;
      int var4 = 0;

      while (true) {
         if (var5 >= var9) {
            var3 = var4;
            break;
         }

         int var8 = var0.getItemViewType(var5);
         int var6 = var7;
         if (var8 != var7) {
            var6 = var8;
            var12 = null;
         }

         if (var1 == null) {
            var1 = new FrameLayout(var2);
         }

         var12 = var0.getView(var5, var12, (ViewGroup)var1);
         var12.measure(var10, var11);
         var7 = var12.getMeasuredWidth();
         if (var7 >= var3) {
            break;
         }

         if (var7 > var4) {
            var4 = var7;
         }

         var5++;
         var7 = var6;
      }

      return var3;
   }

   protected static MenuAdapter a(ListAdapter var0) {
      MenuAdapter var1;
      if (var0 instanceof HeaderViewListAdapter) {
         var1 = (MenuAdapter)((HeaderViewListAdapter)var0).getWrappedAdapter();
      } else {
         var1 = (MenuAdapter)var0;
      }

      return var1;
   }

   protected static boolean b(MenuBuilder var0) {
      boolean var4 = false;
      int var2 = var0.size();
      int var1 = 0;

      boolean var3;
      while (true) {
         var3 = var4;
         if (var1 >= var2) {
            break;
         }

         MenuItem var5 = var0.getItem(var1);
         if (var5.isVisible() && var5.getIcon() != null) {
            var3 = true;
            break;
         }

         var1++;
      }

      return var3;
   }

   public abstract void a(int var1);

   @Override
   public void a(Context var1, MenuBuilder var2) {
   }

   public void a(Rect var1) {
      this.a = var1;
   }

   public abstract void a(MenuBuilder var1);

   public abstract void a(View var1);

   public abstract void a(OnDismissListener var1);

   @Override
   public boolean a(MenuBuilder var1, MenuItemImpl var2) {
      return false;
   }

   @Override
   public int b() {
      return 0;
   }

   public abstract void b(int var1);

   public abstract void b(boolean var1);

   @Override
   public boolean b(MenuBuilder var1, MenuItemImpl var2) {
      return false;
   }

   public abstract void c(int var1);

   public abstract void c(boolean var1);

   protected boolean h() {
      return true;
   }

   public Rect i() {
      return this.a;
   }

   public void onItemClick(AdapterView<?> var1, View var2, int var3, long var4) {
      ListAdapter var7 = (ListAdapter)var1.getAdapter();
      MenuBuilder var6 = a(var7).b;
      MenuItem var8 = (MenuItem)var7.getItem(var3);
      byte var9;
      if (this.h()) {
         var9 = 0;
      } else {
         var9 = 4;
      }

      var6.a(var8, this, var9);
   }
}
