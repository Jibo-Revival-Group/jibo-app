package android.support.v7.view.menu;

import android.content.Context;
import android.support.v4.internal.view.SupportMenuItem;
import android.support.v4.internal.view.SupportSubMenu;
import android.support.v4.util.ArrayMap;
import android.view.MenuItem;
import android.view.SubMenu;
import java.util.Iterator;
import java.util.Map;

abstract class BaseMenuWrapper<T> extends BaseWrapper<T> {
   final Context a;
   private Map<SupportMenuItem, MenuItem> c;
   private Map<SupportSubMenu, SubMenu> d;

   BaseMenuWrapper(Context var1, T var2) {
      super((T)var2);
      this.a = var1;
   }

   final MenuItem a(MenuItem var1) {
      if (var1 instanceof SupportMenuItem) {
         SupportMenuItem var3 = (SupportMenuItem)var1;
         if (this.c == null) {
            this.c = new ArrayMap<>();
         }

         MenuItem var2 = this.c.get(var1);
         var1 = var2;
         if (var2 == null) {
            var1 = MenuWrapperFactory.a(this.a, var3);
            this.c.put(var3, var1);
         }
      }

      return var1;
   }

   final SubMenu a(SubMenu var1) {
      if (var1 instanceof SupportSubMenu) {
         SupportSubMenu var3 = (SupportSubMenu)var1;
         if (this.d == null) {
            this.d = new ArrayMap<>();
         }

         SubMenu var2 = this.d.get(var3);
         var1 = var2;
         if (var2 == null) {
            var1 = MenuWrapperFactory.a(this.a, var3);
            this.d.put(var3, var1);
         }
      }

      return var1;
   }

   final void a() {
      if (this.c != null) {
         this.c.clear();
      }

      if (this.d != null) {
         this.d.clear();
      }
   }

   final void a(int var1) {
      if (this.c != null) {
         Iterator var2 = this.c.keySet().iterator();

         while (var2.hasNext()) {
            if (var1 == ((MenuItem)var2.next()).getGroupId()) {
               var2.remove();
            }
         }
      }
   }

   final void b(int var1) {
      if (this.c != null) {
         Iterator var2 = this.c.keySet().iterator();

         while (var2.hasNext()) {
            if (var1 == ((MenuItem)var2.next()).getItemId()) {
               var2.remove();
               break;
            }
         }
      }
   }
}
