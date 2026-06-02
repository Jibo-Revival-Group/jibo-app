package android.support.design.internal;

import android.content.Context;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuItemImpl;
import android.support.v7.view.menu.SubMenuBuilder;

public class NavigationSubMenu extends SubMenuBuilder {
   public NavigationSubMenu(Context var1, NavigationMenu var2, MenuItemImpl var3) {
      super(var1, var2, var3);
   }

   @Override
   public void a(boolean var1) {
      super.a(var1);
      ((MenuBuilder)this.s()).a(var1);
   }
}
