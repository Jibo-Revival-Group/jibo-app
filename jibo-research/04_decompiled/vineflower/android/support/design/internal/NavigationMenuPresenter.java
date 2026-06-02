package android.support.design.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.Build.VERSION;
import android.support.design.R;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.WindowInsetsCompat;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuItemImpl;
import android.support.v7.view.menu.MenuPresenter;
import android.support.v7.view.menu.MenuView;
import android.support.v7.view.menu.SubMenuBuilder;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.ArrayList;

public class NavigationMenuPresenter implements MenuPresenter {
   LinearLayout a;
   MenuBuilder b;
   NavigationMenuPresenter.NavigationMenuAdapter c;
   LayoutInflater d;
   int e;
   boolean f;
   ColorStateList g;
   ColorStateList h;
   Drawable i;
   int j;
   final OnClickListener k = new OnClickListener(this) {
      final NavigationMenuPresenter a;

      {
         this.a = var1;
      }

      public void onClick(View var1) {
         NavigationMenuItemView var3 = (NavigationMenuItemView)var1;
         this.a.b(true);
         MenuItemImpl var4 = var3.getItemData();
         boolean var2 = this.a.b.a(var4, this.a, 0);
         if (var4 != null && var4.isCheckable() && var2) {
            this.a.c.a(var4);
         }

         this.a.b(false);
         this.a.a(false);
      }
   };
   private NavigationMenuView l;
   private MenuPresenter.Callback m;
   private int n;
   private int o;

   public MenuView a(ViewGroup var1) {
      if (this.l == null) {
         this.l = (NavigationMenuView)this.d.inflate(R.layout.design_navigation_menu, var1, false);
         if (this.c == null) {
            this.c = new NavigationMenuPresenter.NavigationMenuAdapter(this);
         }

         this.a = (LinearLayout)this.d.inflate(R.layout.design_navigation_item_header, this.l, false);
         this.l.setAdapter(this.c);
      }

      return this.l;
   }

   public void a(int var1) {
      this.n = var1;
   }

   @Override
   public void a(Context var1, MenuBuilder var2) {
      this.d = LayoutInflater.from(var1);
      this.b = var2;
      this.j = var1.getResources().getDimensionPixelOffset(R.dimen.design_navigation_separator_vertical_padding);
   }

   public void a(ColorStateList var1) {
      this.h = var1;
      this.a(false);
   }

   public void a(Drawable var1) {
      this.i = var1;
      this.a(false);
   }

   @Override
   public void a(Parcelable var1) {
      if (var1 instanceof Bundle) {
         Bundle var3 = (Bundle)var1;
         SparseArray var2 = var3.getSparseParcelableArray("android:menu:list");
         if (var2 != null) {
            this.l.restoreHierarchyState(var2);
         }

         Bundle var5 = var3.getBundle("android:menu:adapter");
         if (var5 != null) {
            this.c.a(var5);
         }

         SparseArray var4 = var3.getSparseParcelableArray("android:menu:header");
         if (var4 != null) {
            this.a.restoreHierarchyState(var4);
         }
      }
   }

   public void a(WindowInsetsCompat var1) {
      int var2 = var1.b();
      if (this.o != var2) {
         this.o = var2;
         if (this.a.getChildCount() == 0) {
            this.l.setPadding(0, this.o, 0, this.l.getPaddingBottom());
         }
      }

      ViewCompat.b(this.a, var1);
   }

   @Override
   public void a(MenuBuilder var1, boolean var2) {
      if (this.m != null) {
         this.m.a(var1, var2);
      }
   }

   public void a(MenuItemImpl var1) {
      this.c.a(var1);
   }

   @Override
   public void a(MenuPresenter.Callback var1) {
      this.m = var1;
   }

   public void a(View var1) {
      this.a.addView(var1);
      this.l.setPadding(0, 0, 0, this.l.getPaddingBottom());
   }

   @Override
   public void a(boolean var1) {
      if (this.c != null) {
         this.c.a();
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
      return false;
   }

   @Override
   public int b() {
      return this.n;
   }

   public View b(int var1) {
      View var2 = this.d.inflate(var1, this.a, false);
      this.a(var2);
      return var2;
   }

   public void b(ColorStateList var1) {
      this.g = var1;
      this.a(false);
   }

   public void b(boolean var1) {
      if (this.c != null) {
         this.c.a(var1);
      }
   }

   @Override
   public boolean b(MenuBuilder var1, MenuItemImpl var2) {
      return false;
   }

   @Override
   public Parcelable c() {
      Bundle var3;
      if (VERSION.SDK_INT >= 11) {
         Bundle var2 = new Bundle();
         if (this.l != null) {
            SparseArray var1 = new SparseArray();
            this.l.saveHierarchyState(var1);
            var2.putSparseParcelableArray("android:menu:list", var1);
         }

         if (this.c != null) {
            var2.putBundle("android:menu:adapter", this.c.b());
         }

         var3 = var2;
         if (this.a != null) {
            SparseArray var4 = new SparseArray();
            this.a.saveHierarchyState(var4);
            var2.putSparseParcelableArray("android:menu:header", var4);
            var3 = var2;
         }
      } else {
         var3 = null;
      }

      return var3;
   }

   public void c(int var1) {
      this.e = var1;
      this.f = true;
      this.a(false);
   }

   public int d() {
      return this.a.getChildCount();
   }

   public ColorStateList e() {
      return this.h;
   }

   public ColorStateList f() {
      return this.g;
   }

   public Drawable g() {
      return this.i;
   }

   private static class HeaderViewHolder extends NavigationMenuPresenter.ViewHolder {
      public HeaderViewHolder(View var1) {
         super(var1);
      }
   }

   private class NavigationMenuAdapter extends RecyclerView.Adapter<NavigationMenuPresenter.ViewHolder> {
      final NavigationMenuPresenter a;
      private final ArrayList<NavigationMenuPresenter.NavigationMenuItem> b;
      private MenuItemImpl c;
      private boolean d;

      NavigationMenuAdapter(NavigationMenuPresenter var1) {
         this.a = var1;
         this.b = new ArrayList<>();
         this.c();
      }

      private void a(int var1, int var2) {
         while (var1 < var2) {
            ((NavigationMenuPresenter.NavigationMenuTextItem)this.b.get(var1)).a = true;
            var1++;
         }
      }

      private void c() {
         if (!this.d) {
            this.d = true;
            this.b.clear();
            this.b.add(new NavigationMenuPresenter.NavigationMenuHeaderItem());
            int var2 = -1;
            int var1 = 0;
            boolean var10 = false;
            int var7 = this.a.b.i().size();
            int var5 = 0;

            while (var5 < var7) {
               MenuItemImpl var13 = this.a.b.i().get(var5);
               if (var13.isChecked()) {
                  this.a(var13);
               }

               if (var13.isCheckable()) {
                  var13.a(false);
               }

               if (!var13.hasSubMenu()) {
                  int var19 = var13.getGroupId();
                  if (var19 != var2) {
                     var2 = this.b.size();
                     boolean var11;
                     if (var13.getIcon() != null) {
                        var11 = true;
                     } else {
                        var11 = false;
                     }

                     var10 = var11;
                     var1 = var2;
                     if (var5 != 0) {
                        var1 = var2 + 1;
                        this.b.add(new NavigationMenuPresenter.NavigationMenuSeparatorItem(this.a.j, this.a.j));
                        var10 = var11;
                     }
                  } else if (!var10 && var13.getIcon() != null) {
                     var10 = true;
                     this.a(var1, this.b.size());
                  }

                  NavigationMenuPresenter.NavigationMenuTextItem var21 = new NavigationMenuPresenter.NavigationMenuTextItem(var13);
                  var21.a = var10;
                  this.b.add(var21);
                  var2 = var1;
                  var1 = var19;
               } else {
                  SubMenu var14 = var13.getSubMenu();
                  if (var14.hasVisibleItems()) {
                     if (var5 != 0) {
                        this.b.add(new NavigationMenuPresenter.NavigationMenuSeparatorItem(this.a.j, 0));
                     }

                     this.b.add(new NavigationMenuPresenter.NavigationMenuTextItem(var13));
                     boolean var3 = false;
                     int var8 = this.b.size();
                     int var9 = var14.size();
                     int var6 = 0;

                     while (var6 < var9) {
                        MenuItemImpl var12 = (MenuItemImpl)var14.getItem(var6);
                        boolean var4 = var3;
                        if (var12.isVisible()) {
                           var4 = var3;
                           if (!var3) {
                              var4 = var3;
                              if (var12.getIcon() != null) {
                                 var4 = true;
                              }
                           }

                           if (var12.isCheckable()) {
                              var12.a(false);
                           }

                           if (var13.isChecked()) {
                              this.a(var13);
                           }

                           this.b.add(new NavigationMenuPresenter.NavigationMenuTextItem(var12));
                        }

                        var6++;
                        var3 = var4;
                     }

                     if (var3) {
                        this.a(var8, this.b.size());
                     }
                  }

                  int var18 = var2;
                  var2 = var1;
                  var1 = var18;
               }

               var5++;
               int var20 = var1;
               var1 = var2;
               var2 = var20;
            }

            this.d = false;
         }
      }

      public NavigationMenuPresenter.ViewHolder a(ViewGroup var1, int var2) {
         NavigationMenuPresenter.ViewHolder var3;
         switch (var2) {
            case 0:
               var3 = new NavigationMenuPresenter.NormalViewHolder(this.a.d, var1, this.a.k);
               break;
            case 1:
               var3 = new NavigationMenuPresenter.SubheaderViewHolder(this.a.d, var1);
               break;
            case 2:
               var3 = new NavigationMenuPresenter.SeparatorViewHolder(this.a.d, var1);
               break;
            case 3:
               var3 = new NavigationMenuPresenter.HeaderViewHolder(this.a.a);
               break;
            default:
               var3 = null;
         }

         return var3;
      }

      public void a() {
         this.c();
         this.notifyDataSetChanged();
      }

      public void a(Bundle var1) {
         byte var3 = 0;
         int var4 = var1.getInt("android:menu:checked", 0);
         if (var4 != 0) {
            this.d = true;
            int var5 = this.b.size();

            for (int var2 = 0; var2 < var5; var2++) {
               NavigationMenuPresenter.NavigationMenuItem var6 = this.b.get(var2);
               if (var6 instanceof NavigationMenuPresenter.NavigationMenuTextItem) {
                  MenuItemImpl var11 = ((NavigationMenuPresenter.NavigationMenuTextItem)var6).a();
                  if (var11 != null && var11.getItemId() == var4) {
                     this.a(var11);
                     break;
                  }
               }
            }

            this.d = false;
            this.c();
         }

         SparseArray var8 = var1.getSparseParcelableArray("android:menu:action_views");
         if (var8 != null) {
            var4 = this.b.size();

            for (int var9 = var3; var9 < var4; var9++) {
               NavigationMenuPresenter.NavigationMenuItem var12 = this.b.get(var9);
               if (var12 instanceof NavigationMenuPresenter.NavigationMenuTextItem) {
                  MenuItemImpl var7 = ((NavigationMenuPresenter.NavigationMenuTextItem)var12).a();
                  if (var7 != null) {
                     View var13 = var7.getActionView();
                     if (var13 != null) {
                        ParcelableSparseArray var14 = (ParcelableSparseArray)var8.get(var7.getItemId());
                        if (var14 != null) {
                           var13.restoreHierarchyState(var14);
                        }
                     }
                  }
               }
            }
         }
      }

      public void a(NavigationMenuPresenter.ViewHolder var1) {
         if (var1 instanceof NavigationMenuPresenter.NormalViewHolder) {
            ((NavigationMenuItemView)var1.itemView).b();
         }
      }

      public void a(NavigationMenuPresenter.ViewHolder var1, int var2) {
         switch (this.getItemViewType(var2)) {
            case 0:
               NavigationMenuItemView var6 = (NavigationMenuItemView)var1.itemView;
               var6.setIconTintList(this.a.h);
               if (this.a.f) {
                  var6.setTextAppearance(this.a.e);
               }

               if (this.a.g != null) {
                  var6.setTextColor(this.a.g);
               }

               Drawable var4;
               if (this.a.i != null) {
                  var4 = this.a.i.getConstantState().newDrawable();
               } else {
                  var4 = null;
               }

               ViewCompat.a(var6, var4);
               NavigationMenuPresenter.NavigationMenuTextItem var5 = (NavigationMenuPresenter.NavigationMenuTextItem)this.b.get(var2);
               var6.setNeedsEmptyIcon(var5.a);
               var6.a(var5.a(), 0);
               break;
            case 1:
               ((TextView)var1.itemView).setText(((NavigationMenuPresenter.NavigationMenuTextItem)this.b.get(var2)).a().getTitle());
               break;
            case 2:
               NavigationMenuPresenter.NavigationMenuSeparatorItem var3 = (NavigationMenuPresenter.NavigationMenuSeparatorItem)this.b.get(var2);
               var1.itemView.setPadding(0, var3.a(), 0, var3.b());
         }
      }

      public void a(MenuItemImpl var1) {
         if (this.c != var1 && var1.isCheckable()) {
            if (this.c != null) {
               this.c.setChecked(false);
            }

            this.c = var1;
            var1.setChecked(true);
         }
      }

      public void a(boolean var1) {
         this.d = var1;
      }

      public Bundle b() {
         Bundle var4 = new Bundle();
         if (this.c != null) {
            var4.putInt("android:menu:checked", this.c.getItemId());
         }

         SparseArray var5 = new SparseArray();
         int var2 = this.b.size();

         for (int var1 = 0; var1 < var2; var1++) {
            NavigationMenuPresenter.NavigationMenuItem var3 = this.b.get(var1);
            if (var3 instanceof NavigationMenuPresenter.NavigationMenuTextItem) {
               MenuItemImpl var6 = ((NavigationMenuPresenter.NavigationMenuTextItem)var3).a();
               View var8;
               if (var6 != null) {
                  var8 = var6.getActionView();
               } else {
                  var8 = null;
               }

               if (var8 != null) {
                  ParcelableSparseArray var7 = new ParcelableSparseArray();
                  var8.saveHierarchyState(var7);
                  var5.put(var6.getItemId(), var7);
               }
            }
         }

         var4.putSparseParcelableArray("android:menu:action_views", var5);
         return var4;
      }

      @Override
      public int getItemCount() {
         return this.b.size();
      }

      @Override
      public long getItemId(int var1) {
         return var1;
      }

      @Override
      public int getItemViewType(int var1) {
         NavigationMenuPresenter.NavigationMenuItem var2 = this.b.get(var1);
         byte var3;
         if (var2 instanceof NavigationMenuPresenter.NavigationMenuSeparatorItem) {
            var3 = 2;
         } else if (var2 instanceof NavigationMenuPresenter.NavigationMenuHeaderItem) {
            var3 = 3;
         } else {
            if (!(var2 instanceof NavigationMenuPresenter.NavigationMenuTextItem)) {
               throw new RuntimeException("Unknown item type.");
            }

            if (((NavigationMenuPresenter.NavigationMenuTextItem)var2).a().hasSubMenu()) {
               var3 = 1;
            } else {
               var3 = 0;
            }
         }

         return var3;
      }
   }

   private static class NavigationMenuHeaderItem implements NavigationMenuPresenter.NavigationMenuItem {
      NavigationMenuHeaderItem() {
      }
   }

   private interface NavigationMenuItem {
   }

   private static class NavigationMenuSeparatorItem implements NavigationMenuPresenter.NavigationMenuItem {
      private final int a;
      private final int b;

      public NavigationMenuSeparatorItem(int var1, int var2) {
         this.a = var1;
         this.b = var2;
      }

      public int a() {
         return this.a;
      }

      public int b() {
         return this.b;
      }
   }

   private static class NavigationMenuTextItem implements NavigationMenuPresenter.NavigationMenuItem {
      boolean a;
      private final MenuItemImpl b;

      NavigationMenuTextItem(MenuItemImpl var1) {
         this.b = var1;
      }

      public MenuItemImpl a() {
         return this.b;
      }
   }

   private static class NormalViewHolder extends NavigationMenuPresenter.ViewHolder {
      public NormalViewHolder(LayoutInflater var1, ViewGroup var2, OnClickListener var3) {
         super(var1.inflate(R.layout.design_navigation_item, var2, false));
         this.itemView.setOnClickListener(var3);
      }
   }

   private static class SeparatorViewHolder extends NavigationMenuPresenter.ViewHolder {
      public SeparatorViewHolder(LayoutInflater var1, ViewGroup var2) {
         super(var1.inflate(R.layout.design_navigation_item_separator, var2, false));
      }
   }

   private static class SubheaderViewHolder extends NavigationMenuPresenter.ViewHolder {
      public SubheaderViewHolder(LayoutInflater var1, ViewGroup var2) {
         super(var1.inflate(R.layout.design_navigation_item_subheader, var2, false));
      }
   }

   private abstract static class ViewHolder extends RecyclerView.ViewHolder {
      public ViewHolder(View var1) {
         super(var1);
      }
   }
}
