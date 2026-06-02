package android.support.v7.view.menu;

public interface MenuView {
   void a(MenuBuilder var1);

   interface ItemView {
      void a(MenuItemImpl var1, int var2);

      boolean a();

      MenuItemImpl getItemData();
   }
}
