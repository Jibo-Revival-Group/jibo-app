package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.support.v7.view.menu.ListMenuItemView;
import android.support.v7.view.menu.MenuAdapter;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuItemImpl;
import android.transition.Transition;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import java.lang.reflect.Method;

public class MenuPopupWindow extends ListPopupWindow implements MenuItemHoverListener {
   private static Method a;
   private MenuItemHoverListener b;

   static {
      try {
         a = PopupWindow.class.getDeclaredMethod("setTouchModal", boolean.class);
      } catch (NoSuchMethodException var1) {
         Log.i("MenuPopupWindow", "Could not find method setTouchModal() on PopupWindow. Oh well.");
      }
   }

   public MenuPopupWindow(Context var1, AttributeSet var2, int var3, int var4) {
      super(var1, var2, var3, var4);
   }

   @Override
   DropDownListView a(Context var1, boolean var2) {
      MenuPopupWindow.MenuDropDownListView var3 = new MenuPopupWindow.MenuDropDownListView(var1, var2);
      var3.setHoverListener(this);
      return var3;
   }

   @Override
   public void a(MenuBuilder var1, MenuItem var2) {
      if (this.b != null) {
         this.b.a(var1, var2);
      }
   }

   public void a(MenuItemHoverListener var1) {
      this.b = var1;
   }

   public void a(Object var1) {
      if (VERSION.SDK_INT >= 23) {
         this.g.setEnterTransition((Transition)var1);
      }
   }

   @Override
   public void b(MenuBuilder var1, MenuItem var2) {
      if (this.b != null) {
         this.b.b(var1, var2);
      }
   }

   public void b(Object var1) {
      if (VERSION.SDK_INT >= 23) {
         this.g.setExitTransition((Transition)var1);
      }
   }

   @Override
   public void c(boolean var1) {
      if (a != null) {
         try {
            a.invoke(this.g, var1);
         } catch (Exception var3) {
            Log.i("MenuPopupWindow", "Could not invoke setTouchModal() on PopupWindow. Oh well.");
         }
      }
   }

   public static class MenuDropDownListView extends DropDownListView {
      final int a;
      final int b;
      private MenuItemHoverListener c;
      private MenuItem d;

      public MenuDropDownListView(Context var1, boolean var2) {
         super(var1, var2);
         Configuration var3 = var1.getResources().getConfiguration();
         if (VERSION.SDK_INT >= 17 && 1 == var3.getLayoutDirection()) {
            this.a = 21;
            this.b = 22;
         } else {
            this.a = 22;
            this.b = 21;
         }
      }

      @Override
      public boolean onHoverEvent(MotionEvent var1) {
         if (this.c != null) {
            ListAdapter var4 = this.getAdapter();
            int var2;
            MenuAdapter var9;
            if (var4 instanceof HeaderViewListAdapter) {
               HeaderViewListAdapter var8 = (HeaderViewListAdapter)var4;
               var2 = var8.getHeadersCount();
               var9 = (MenuAdapter)var8.getWrappedAdapter();
            } else {
               var2 = 0;
               var9 = (MenuAdapter)var4;
            }

            MenuItemImpl var5;
            label30: {
               if (var1.getAction() != 10) {
                  int var3 = this.pointToPosition((int)var1.getX(), (int)var1.getY());
                  if (var3 != -1) {
                     var2 = var3 - var2;
                     if (var2 >= 0 && var2 < var9.getCount()) {
                        var5 = var9.a(var2);
                        break label30;
                     }
                  }
               }

               var5 = null;
            }

            MenuItem var6 = this.d;
            if (var6 != var5) {
               MenuBuilder var10 = var9.a();
               if (var6 != null) {
                  this.c.a(var10, var6);
               }

               this.d = var5;
               if (var5 != null) {
                  this.c.b(var10, var5);
               }
            }
         }

         return super.onHoverEvent(var1);
      }

      public boolean onKeyDown(int var1, KeyEvent var2) {
         ListMenuItemView var4 = (ListMenuItemView)this.getSelectedView();
         boolean var3;
         if (var4 != null && var1 == this.a) {
            if (var4.isEnabled() && var4.getItemData().hasSubMenu()) {
               this.performItemClick(var4, this.getSelectedItemPosition(), this.getSelectedItemId());
            }

            var3 = true;
         } else if (var4 != null && var1 == this.b) {
            this.setSelection(-1);
            ((MenuAdapter)this.getAdapter()).a().b(false);
            var3 = true;
         } else {
            var3 = super.onKeyDown(var1, var2);
         }

         return var3;
      }

      public void setHoverListener(MenuItemHoverListener var1) {
         this.c = var1;
      }
   }
}
