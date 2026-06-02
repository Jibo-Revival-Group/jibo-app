package android.support.v7.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.internal.view.SupportSubMenu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

class SubMenuWrapperICS extends MenuWrapperICS implements SubMenu {
   SubMenuWrapperICS(Context var1, SupportSubMenu var2) {
      super(var1, var2);
   }

   public SupportSubMenu b() {
      return (SupportSubMenu)this.b;
   }

   public void clearHeader() {
      this.b().clearHeader();
   }

   public MenuItem getItem() {
      return this.a(this.b().getItem());
   }

   public SubMenu setHeaderIcon(int var1) {
      this.b().setHeaderIcon(var1);
      return this;
   }

   public SubMenu setHeaderIcon(Drawable var1) {
      this.b().setHeaderIcon(var1);
      return this;
   }

   public SubMenu setHeaderTitle(int var1) {
      this.b().setHeaderTitle(var1);
      return this;
   }

   public SubMenu setHeaderTitle(CharSequence var1) {
      this.b().setHeaderTitle(var1);
      return this;
   }

   public SubMenu setHeaderView(View var1) {
      this.b().setHeaderView(var1);
      return this;
   }

   public SubMenu setIcon(int var1) {
      this.b().setIcon(var1);
      return this;
   }

   public SubMenu setIcon(Drawable var1) {
      this.b().setIcon(var1);
      return this;
   }
}
