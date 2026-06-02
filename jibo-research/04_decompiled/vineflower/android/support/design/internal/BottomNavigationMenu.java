package android.support.design.internal;

import android.content.Context;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuItemImpl;
import android.view.MenuItem;
import android.view.SubMenu;

public final class BottomNavigationMenu extends MenuBuilder {
   public BottomNavigationMenu(Context var1) {
      super(var1);
   }

   @Override
   protected MenuItem a(int var1, int var2, int var3, CharSequence var4) {
      if (this.size() + 1 > 5) {
         throw new IllegalArgumentException(
            "Maximum number of items supported by BottomNavigationView is 5. Limit can be checked with BottomNavigationView#getMaxItemCount()"
         );
      }

      this.g();
      MenuItem var5 = super.a(var1, var2, var3, var4);
      if (var5 instanceof MenuItemImpl) {
         ((MenuItemImpl)var5).a(true);
      }

      this.h();
      return var5;
   }

   @Override
   public SubMenu addSubMenu(int var1, int var2, int var3, CharSequence var4) {
      throw new UnsupportedOperationException("BottomNavigationView does not support submenus");
   }
}
