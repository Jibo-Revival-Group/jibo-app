package android.support.v7.view.menu;

import android.content.Context;
import android.os.Parcelable;

public interface MenuPresenter {
   void a(Context var1, MenuBuilder var2);

   void a(Parcelable var1);

   void a(MenuBuilder var1, boolean var2);

   void a(MenuPresenter.Callback var1);

   void a(boolean var1);

   boolean a();

   boolean a(MenuBuilder var1, MenuItemImpl var2);

   boolean a(SubMenuBuilder var1);

   int b();

   boolean b(MenuBuilder var1, MenuItemImpl var2);

   Parcelable c();

   interface Callback {
      void a(MenuBuilder var1, boolean var2);

      boolean a(MenuBuilder var1);
   }
}
