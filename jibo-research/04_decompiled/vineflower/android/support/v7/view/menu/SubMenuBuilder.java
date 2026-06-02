package android.support.v7.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

public class SubMenuBuilder extends MenuBuilder implements SubMenu {
   private MenuBuilder d;
   private MenuItemImpl e;

   public SubMenuBuilder(Context var1, MenuBuilder var2, MenuItemImpl var3) {
      super(var1);
      this.d = var2;
      this.e = var3;
   }

   @Override
   public String a() {
      int var1;
      if (this.e != null) {
         var1 = this.e.getItemId();
      } else {
         var1 = 0;
      }

      String var2;
      if (var1 == 0) {
         var2 = null;
      } else {
         var2 = super.a() + ":" + var1;
      }

      return var2;
   }

   @Override
   public void a(MenuBuilder.Callback var1) {
      this.d.a(var1);
   }

   @Override
   boolean a(MenuBuilder var1, MenuItem var2) {
      boolean var3;
      if (!super.a(var1, var2) && !this.d.a(var1, var2)) {
         var3 = false;
      } else {
         var3 = true;
      }

      return var3;
   }

   @Override
   public boolean b() {
      return this.d.b();
   }

   @Override
   public boolean c() {
      return this.d.c();
   }

   @Override
   public boolean c(MenuItemImpl var1) {
      return this.d.c(var1);
   }

   @Override
   public boolean d(MenuItemImpl var1) {
      return this.d.d(var1);
   }

   public MenuItem getItem() {
      return this.e;
   }

   @Override
   public MenuBuilder p() {
      return this.d.p();
   }

   public Menu s() {
      return this.d;
   }

   public SubMenu setHeaderIcon(int var1) {
      return (SubMenu)super.e(var1);
   }

   public SubMenu setHeaderIcon(Drawable var1) {
      return (SubMenu)super.a(var1);
   }

   public SubMenu setHeaderTitle(int var1) {
      return (SubMenu)super.d(var1);
   }

   public SubMenu setHeaderTitle(CharSequence var1) {
      return (SubMenu)super.a(var1);
   }

   public SubMenu setHeaderView(View var1) {
      return (SubMenu)super.a(var1);
   }

   public SubMenu setIcon(int var1) {
      this.e.setIcon(var1);
      return this;
   }

   public SubMenu setIcon(Drawable var1) {
      this.e.setIcon(var1);
      return this;
   }

   @Override
   public void setQwertyMode(boolean var1) {
      this.d.setQwertyMode(var1);
   }
}
