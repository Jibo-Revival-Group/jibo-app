package android.support.v7.view.menu;

import android.support.v7.appcompat.R;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;

public class MenuAdapter extends BaseAdapter {
   static final int a = R.layout.abc_popup_menu_item_layout;
   MenuBuilder b;
   private int c = -1;
   private boolean d;
   private final boolean e;
   private final LayoutInflater f;

   public MenuAdapter(MenuBuilder var1, LayoutInflater var2, boolean var3) {
      this.e = var3;
      this.f = var2;
      this.b = var1;
      this.b();
   }

   public MenuBuilder a() {
      return this.b;
   }

   public MenuItemImpl a(int var1) {
      ArrayList var3;
      if (this.e) {
         var3 = this.b.l();
      } else {
         var3 = this.b.i();
      }

      int var2 = var1;
      if (this.c >= 0) {
         var2 = var1;
         if (var1 >= this.c) {
            var2 = var1 + 1;
         }
      }

      return (MenuItemImpl)var3.get(var2);
   }

   public void a(boolean var1) {
      this.d = var1;
   }

   void b() {
      MenuItemImpl var4 = this.b.r();
      if (var4 != null) {
         ArrayList var3 = this.b.l();
         int var2 = var3.size();

         for (int var1 = 0; var1 < var2; var1++) {
            if ((MenuItemImpl)var3.get(var1) == var4) {
               this.c = var1;
               return;
            }
         }
      }

      this.c = -1;
   }

   public int getCount() {
      ArrayList var2;
      if (this.e) {
         var2 = this.b.l();
      } else {
         var2 = this.b.i();
      }

      int var1;
      if (this.c < 0) {
         var1 = var2.size();
      } else {
         var1 = var2.size() - 1;
      }

      return var1;
   }

   public long getItemId(int var1) {
      return var1;
   }

   public View getView(int var1, View var2, ViewGroup var3) {
      if (var2 == null) {
         var2 = this.f.inflate(a, var3, false);
      }

      MenuView.ItemView var4 = (MenuView.ItemView)var2;
      if (this.d) {
         ((ListMenuItemView)var2).setForceShowIcon(true);
      }

      var4.a(this.a(var1), 0);
      return var2;
   }

   public void notifyDataSetChanged() {
      this.b();
      super.notifyDataSetChanged();
   }
}
