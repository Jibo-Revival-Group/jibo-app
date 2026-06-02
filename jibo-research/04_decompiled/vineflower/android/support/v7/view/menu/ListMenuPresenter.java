package android.support.v7.view.menu;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import android.support.v7.appcompat.R;
import android.util.SparseArray;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.AdapterView.OnItemClickListener;
import java.util.ArrayList;

public class ListMenuPresenter implements MenuPresenter, OnItemClickListener {
   Context a;
   LayoutInflater b;
   MenuBuilder c;
   ExpandedMenuView d;
   int e;
   int f;
   int g;
   ListMenuPresenter.MenuAdapter h;
   private MenuPresenter.Callback i;
   private int j;

   public ListMenuPresenter(int var1, int var2) {
      this.g = var1;
      this.f = var2;
   }

   public ListMenuPresenter(Context var1, int var2) {
      this(var2, 0);
      this.a = var1;
      this.b = LayoutInflater.from(this.a);
   }

   public MenuView a(ViewGroup var1) {
      if (this.d == null) {
         this.d = (ExpandedMenuView)this.b.inflate(R.layout.abc_expanded_menu_layout, var1, false);
         if (this.h == null) {
            this.h = new ListMenuPresenter.MenuAdapter(this);
         }

         this.d.setAdapter(this.h);
         this.d.setOnItemClickListener(this);
      }

      return this.d;
   }

   @Override
   public void a(Context var1, MenuBuilder var2) {
      if (this.f != 0) {
         this.a = new ContextThemeWrapper(var1, this.f);
         this.b = LayoutInflater.from(this.a);
      } else if (this.a != null) {
         this.a = var1;
         if (this.b == null) {
            this.b = LayoutInflater.from(this.a);
         }
      }

      this.c = var2;
      if (this.h != null) {
         this.h.notifyDataSetChanged();
      }
   }

   public void a(Bundle var1) {
      SparseArray var2 = new SparseArray();
      if (this.d != null) {
         this.d.saveHierarchyState(var2);
      }

      var1.putSparseParcelableArray("android:menu:list", var2);
   }

   @Override
   public void a(Parcelable var1) {
      this.b((Bundle)var1);
   }

   @Override
   public void a(MenuBuilder var1, boolean var2) {
      if (this.i != null) {
         this.i.a(var1, var2);
      }
   }

   @Override
   public void a(MenuPresenter.Callback var1) {
      this.i = var1;
   }

   @Override
   public void a(boolean var1) {
      if (this.h != null) {
         this.h.notifyDataSetChanged();
      }
   }

   @Override
   public boolean a() {
      return false;
   }

   @Override
   public boolean a(MenuBuilder var1, MenuItemImpl var2) {
      return false;
   }

   @Override
   public boolean a(SubMenuBuilder var1) {
      boolean var2;
      if (!var1.hasVisibleItems()) {
         var2 = false;
      } else {
         new MenuDialogHelper(var1).a((IBinder)null);
         if (this.i != null) {
            this.i.a(var1);
         }

         var2 = true;
      }

      return var2;
   }

   @Override
   public int b() {
      return this.j;
   }

   public void b(Bundle var1) {
      SparseArray var2 = var1.getSparseParcelableArray("android:menu:list");
      if (var2 != null) {
         this.d.restoreHierarchyState(var2);
      }
   }

   @Override
   public boolean b(MenuBuilder var1, MenuItemImpl var2) {
      return false;
   }

   @Override
   public Parcelable c() {
      Bundle var1;
      if (this.d == null) {
         var1 = null;
      } else {
         var1 = new Bundle();
         this.a(var1);
      }

      return var1;
   }

   public ListAdapter d() {
      if (this.h == null) {
         this.h = new ListMenuPresenter.MenuAdapter(this);
      }

      return this.h;
   }

   public void onItemClick(AdapterView<?> var1, View var2, int var3, long var4) {
      this.c.a(this.h.a(var3), this, 0);
   }

   private class MenuAdapter extends BaseAdapter {
      final ListMenuPresenter a;
      private int b;

      public MenuAdapter(ListMenuPresenter var1) {
         this.a = var1;
         this.b = -1;
         this.a();
      }

      public MenuItemImpl a(int var1) {
         ArrayList var3 = this.a.c.l();
         int var2 = this.a.e + var1;
         var1 = var2;
         if (this.b >= 0) {
            var1 = var2;
            if (var2 >= this.b) {
               var1 = var2 + 1;
            }
         }

         return (MenuItemImpl)var3.get(var1);
      }

      void a() {
         MenuItemImpl var3 = this.a.c.r();
         if (var3 != null) {
            ArrayList var4 = this.a.c.l();
            int var2 = var4.size();

            for (int var1 = 0; var1 < var2; var1++) {
               if ((MenuItemImpl)var4.get(var1) == var3) {
                  this.b = var1;
                  return;
               }
            }
         }

         this.b = -1;
      }

      public int getCount() {
         int var1 = this.a.c.l().size() - this.a.e;
         if (this.b >= 0) {
            var1--;
         }

         return var1;
      }

      public long getItemId(int var1) {
         return var1;
      }

      public View getView(int var1, View var2, ViewGroup var3) {
         if (var2 == null) {
            var2 = this.a.b.inflate(this.a.g, var3, false);
         }

         ((MenuView.ItemView)var2).a(this.a(var1), 0);
         return var2;
      }

      public void notifyDataSetChanged() {
         this.a();
         super.notifyDataSetChanged();
      }
   }
}
