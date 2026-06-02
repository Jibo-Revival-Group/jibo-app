package android.support.v7.view.menu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

public abstract class BaseMenuPresenter implements MenuPresenter {
   protected Context a;
   protected Context b;
   protected MenuBuilder c;
   protected LayoutInflater d;
   protected LayoutInflater e;
   protected MenuView f;
   private MenuPresenter.Callback g;
   private int h;
   private int i;
   private int j;

   public BaseMenuPresenter(Context var1, int var2, int var3) {
      this.a = var1;
      this.d = LayoutInflater.from(var1);
      this.h = var2;
      this.i = var3;
   }

   public MenuView a(ViewGroup var1) {
      if (this.f == null) {
         this.f = (MenuView)this.d.inflate(this.h, var1, false);
         this.f.a(this.c);
         this.a(true);
      }

      return this.f;
   }

   public View a(MenuItemImpl var1, View var2, ViewGroup var3) {
      MenuView.ItemView var4;
      if (var2 instanceof MenuView.ItemView) {
         var4 = (MenuView.ItemView & View)var2;
      } else {
         var4 = this.b(var3);
      }

      this.a(var1, var4);
      return (View)var4;
   }

   public void a(int var1) {
      this.j = var1;
   }

   @Override
   public void a(Context var1, MenuBuilder var2) {
      this.b = var1;
      this.e = LayoutInflater.from(this.b);
      this.c = var2;
   }

   @Override
   public void a(MenuBuilder var1, boolean var2) {
      if (this.g != null) {
         this.g.a(var1, var2);
      }
   }

   public abstract void a(MenuItemImpl var1, MenuView.ItemView var2);

   @Override
   public void a(MenuPresenter.Callback var1) {
      this.g = var1;
   }

   protected void a(View var1, int var2) {
      ViewGroup var3 = (ViewGroup)var1.getParent();
      if (var3 != null) {
         var3.removeView(var1);
      }

      ((ViewGroup)this.f).addView(var1, var2);
   }

   @Override
   public void a(boolean var1) {
      ViewGroup var10 = (ViewGroup)this.f;
      if (var10 != null) {
         int var3;
         if (this.c != null) {
            this.c.j();
            ArrayList var9 = this.c.i();
            int var5 = var9.size();
            int var4 = 0;
            int var2 = 0;

            while (true) {
               var3 = var2;
               if (var4 >= var5) {
                  break;
               }

               MenuItemImpl var7 = (MenuItemImpl)var9.get(var4);
               if (this.a(var2, var7)) {
                  View var8 = var10.getChildAt(var2);
                  MenuItemImpl var6;
                  if (var8 instanceof MenuView.ItemView) {
                     var6 = ((MenuView.ItemView)var8).getItemData();
                  } else {
                     var6 = null;
                  }

                  View var11 = this.a(var7, var8, var10);
                  if (var7 != var6) {
                     var11.setPressed(false);
                     var11.jumpDrawablesToCurrentState();
                  }

                  if (var11 != var8) {
                     this.a(var11, var2);
                  }

                  var2++;
               }

               var4++;
            }
         } else {
            var3 = 0;
         }

         while (var3 < var10.getChildCount()) {
            if (!this.a(var10, var3)) {
               var3++;
            }
         }
      }
   }

   @Override
   public boolean a() {
      return false;
   }

   public boolean a(int var1, MenuItemImpl var2) {
      return true;
   }

   @Override
   public boolean a(MenuBuilder var1, MenuItemImpl var2) {
      return false;
   }

   @Override
   public boolean a(SubMenuBuilder var1) {
      boolean var2;
      if (this.g != null) {
         var2 = this.g.a(var1);
      } else {
         var2 = false;
      }

      return var2;
   }

   protected boolean a(ViewGroup var1, int var2) {
      var1.removeViewAt(var2);
      return true;
   }

   @Override
   public int b() {
      return this.j;
   }

   public MenuView.ItemView b(ViewGroup var1) {
      return (MenuView.ItemView)this.d.inflate(this.i, var1, false);
   }

   @Override
   public boolean b(MenuBuilder var1, MenuItemImpl var2) {
      return false;
   }

   public MenuPresenter.Callback d() {
      return this.g;
   }
}
