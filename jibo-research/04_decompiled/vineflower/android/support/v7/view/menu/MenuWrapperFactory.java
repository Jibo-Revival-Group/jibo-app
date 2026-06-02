package android.support.v7.view.menu;

import android.content.Context;
import android.os.Build.VERSION;
import android.support.v4.internal.view.SupportMenu;
import android.support.v4.internal.view.SupportMenuItem;
import android.support.v4.internal.view.SupportSubMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;

public final class MenuWrapperFactory {
   public static Menu a(Context var0, SupportMenu var1) {
      return new MenuWrapperICS(var0, var1);
   }

   public static MenuItem a(Context var0, SupportMenuItem var1) {
      MenuItemWrapperICS var2;
      if (VERSION.SDK_INT >= 16) {
         var2 = new MenuItemWrapperJB(var0, var1);
      } else {
         var2 = new MenuItemWrapperICS(var0, var1);
      }

      return var2;
   }

   public static SubMenu a(Context var0, SupportSubMenu var1) {
      return new SubMenuWrapperICS(var0, var1);
   }
}
