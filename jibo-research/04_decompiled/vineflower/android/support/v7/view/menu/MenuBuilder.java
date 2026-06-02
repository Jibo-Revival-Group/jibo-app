package android.support.v7.view.menu;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.content.ContextCompat;
import android.support.v4.internal.view.SupportMenu;
import android.support.v4.view.ActionProvider;
import android.support.v7.appcompat.R;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyCharacterMap.KeyData;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class MenuBuilder implements SupportMenu {
   private static final int[] d = new int[]{1, 4, 5, 3, 2, 0};
   CharSequence a;
   Drawable b;
   View c;
   private final Context e;
   private final Resources f;
   private boolean g;
   private boolean h;
   private MenuBuilder.Callback i;
   private ArrayList<MenuItemImpl> j;
   private ArrayList<MenuItemImpl> k;
   private boolean l;
   private ArrayList<MenuItemImpl> m;
   private ArrayList<MenuItemImpl> n;
   private boolean o;
   private int p = 0;
   private ContextMenuInfo q;
   private boolean r = false;
   private boolean s = false;
   private boolean t = false;
   private boolean u = false;
   private boolean v = false;
   private ArrayList<MenuItemImpl> w = new ArrayList<>();
   private CopyOnWriteArrayList<WeakReference<MenuPresenter>> x = new CopyOnWriteArrayList<>();
   private MenuItemImpl y;
   private boolean z;

   public MenuBuilder(Context var1) {
      this.e = var1;
      this.f = var1.getResources();
      this.j = new ArrayList<>();
      this.k = new ArrayList<>();
      this.l = true;
      this.m = new ArrayList<>();
      this.n = new ArrayList<>();
      this.o = true;
      this.e(true);
   }

   private static int a(ArrayList<MenuItemImpl> var0, int var1) {
      int var2 = var0.size() - 1;

      while (true) {
         if (var2 < 0) {
            var1 = 0;
            break;
         }

         if (((MenuItemImpl)var0.get(var2)).c() <= var1) {
            var1 = var2 + 1;
            break;
         }

         var2--;
      }

      return var1;
   }

   private MenuItemImpl a(int var1, int var2, int var3, int var4, CharSequence var5, int var6) {
      return new MenuItemImpl(this, var1, var2, var3, var4, var5, var6);
   }

   private void a(int var1, CharSequence var2, int var3, Drawable var4, View var5) {
      Resources var6 = this.d();
      if (var5 != null) {
         this.c = var5;
         this.a = null;
         this.b = null;
      } else {
         if (var1 > 0) {
            this.a = var6.getText(var1);
         } else if (var2 != null) {
            this.a = var2;
         }

         if (var3 > 0) {
            this.b = ContextCompat.a(this.e(), var3);
         } else if (var4 != null) {
            this.b = var4;
         }

         this.c = null;
      }

      this.a(false);
   }

   private void a(int var1, boolean var2) {
      if (var1 >= 0 && var1 < this.j.size()) {
         this.j.remove(var1);
         if (var2) {
            this.a(true);
         }
      }
   }

   private boolean a(SubMenuBuilder var1, MenuPresenter var2) {
      boolean var3 = false;
      boolean var4 = false;
      if (this.x.isEmpty()) {
         var3 = var4;
      } else {
         if (var2 != null) {
            var3 = var2.a(var1);
         }

         for (WeakReference var5 : this.x) {
            MenuPresenter var6 = (MenuPresenter)var5.get();
            if (var6 == null) {
               this.x.remove(var5);
            } else if (!var3) {
               var3 = var6.a(var1);
            }
         }
      }

      return var3;
   }

   private void d(boolean var1) {
      if (!this.x.isEmpty()) {
         this.g();

         for (WeakReference var2 : this.x) {
            MenuPresenter var3 = (MenuPresenter)var2.get();
            if (var3 == null) {
               this.x.remove(var2);
            } else {
               var3.a(var1);
            }
         }

         this.h();
      }
   }

   private void e(Bundle var1) {
      if (!this.x.isEmpty()) {
         SparseArray var4 = new SparseArray();

         for (WeakReference var5 : this.x) {
            MenuPresenter var6 = (MenuPresenter)var5.get();
            if (var6 == null) {
               this.x.remove(var5);
            } else {
               int var2 = var6.b();
               if (var2 > 0) {
                  Parcelable var7 = var6.c();
                  if (var7 != null) {
                     var4.put(var2, var7);
                  }
               }
            }
         }

         var1.putSparseParcelableArray("android:menu:presenters", var4);
      }
   }

   private void e(boolean var1) {
      boolean var2 = true;
      if (var1 && this.f.getConfiguration().keyboard != 1 && this.f.getBoolean(R.bool.abc_config_showMenuShortcutsWhenKeyboardPresent)) {
         var1 = var2;
      } else {
         var1 = false;
      }

      this.h = var1;
   }

   private static int f(int var0) {
      int var1 = (-65536 & var0) >> 16;
      if (var1 >= 0 && var1 < d.length) {
         return d[var1] << 16 | 65535 & var0;
      } else {
         throw new IllegalArgumentException("order does not contain a valid category.");
      }
   }

   private void f(Bundle var1) {
      SparseArray var6 = var1.getSparseParcelableArray("android:menu:presenters");
      if (var6 != null && !this.x.isEmpty()) {
         for (WeakReference var5 : this.x) {
            MenuPresenter var4 = (MenuPresenter)var5.get();
            if (var4 == null) {
               this.x.remove(var5);
            } else {
               int var2 = var4.b();
               if (var2 > 0) {
                  Parcelable var7 = (Parcelable)var6.get(var2);
                  if (var7 != null) {
                     var4.a(var7);
                  }
               }
            }
         }
      }
   }

   public int a(int var1, int var2) {
      int var4 = this.size();
      int var3 = var2;
      if (var2 < 0) {
         var3 = 0;
      }

      var2 = var3;

      while (true) {
         if (var2 >= var4) {
            var1 = -1;
            break;
         }

         if (this.j.get(var2).getGroupId() == var1) {
            var1 = var2;
            break;
         }

         var2++;
      }

      return var1;
   }

   public MenuBuilder a(int var1) {
      this.p = var1;
      return this;
   }

   protected MenuBuilder a(Drawable var1) {
      this.a(0, null, 0, var1, null);
      return this;
   }

   protected MenuBuilder a(View var1) {
      this.a(0, null, 0, null, var1);
      return this;
   }

   protected MenuBuilder a(CharSequence var1) {
      this.a(0, var1, 0, null, null);
      return this;
   }

   MenuItemImpl a(int var1, KeyEvent var2) {
      ArrayList var10 = this.w;
      var10.clear();
      this.a(var10, var1, var2);
      MenuItemImpl var11;
      if (var10.isEmpty()) {
         var11 = null;
      } else {
         int var5 = var2.getMetaState();
         KeyData var9 = new KeyData();
         var2.getKeyData(var9);
         int var6 = var10.size();
         if (var6 == 1) {
            var11 = (MenuItemImpl)var10.get(0);
         } else {
            boolean var7 = this.b();

            for (int var3 = 0; var3 < var6; var3++) {
               MenuItemImpl var8 = (MenuItemImpl)var10.get(var3);
               char var4;
               if (var7) {
                  var4 = var8.getAlphabeticShortcut();
               } else {
                  var4 = var8.getNumericShortcut();
               }

               if (var4 == var9.meta[0]) {
                  MenuItemImpl var12 = var8;
                  if ((var5 & 2) == 0) {
                     return var12;
                  }
               }

               if (var4 == var9.meta[2]) {
                  MenuItemImpl var13 = var8;
                  if ((var5 & 2) != 0) {
                     return var13;
                  }
               }

               if (var7 && var4 == '\b') {
                  MenuItemImpl var14 = var8;
                  if (var1 == 67) {
                     return var14;
                  }
               }
            }

            var11 = null;
         }
      }

      return var11;
   }

   protected MenuItem a(int var1, int var2, int var3, CharSequence var4) {
      int var5 = f(var3);
      MenuItemImpl var6 = this.a(var1, var2, var3, var5, var4, this.p);
      if (this.q != null) {
         var6.a(this.q);
      }

      this.j.add(a(this.j, var5), var6);
      this.a(true);
      return var6;
   }

   protected String a() {
      return "android:menu:actionviewstates";
   }

   public void a(Bundle var1) {
      this.e(var1);
   }

   public void a(MenuBuilder.Callback var1) {
      this.i = var1;
   }

   void a(MenuItemImpl var1) {
      this.l = true;
      this.a(true);
   }

   public void a(MenuPresenter var1) {
      this.a(var1, this.e);
   }

   public void a(MenuPresenter var1, Context var2) {
      this.x.add(new WeakReference<>(var1));
      var1.a(var2, this);
      this.o = true;
   }

   void a(MenuItem var1) {
      int var3 = var1.getGroupId();
      int var4 = this.j.size();
      this.g();

      for (int var2 = 0; var2 < var4; var2++) {
         MenuItemImpl var6 = this.j.get(var2);
         if (var6.getGroupId() == var3 && var6.g() && var6.isCheckable()) {
            boolean var5;
            if (var6 == var1) {
               var5 = true;
            } else {
               var5 = false;
            }

            var6.b(var5);
         }
      }

      this.h();
   }

   void a(List<MenuItemImpl> var1, int var2, KeyEvent var3) {
      boolean var9 = this.b();
      int var7 = var3.getModifiers();
      KeyData var11 = new KeyData();
      if (var3.getKeyData(var11) || var2 == 67) {
         int var8 = this.j.size();

         for (int var4 = 0; var4 < var8; var4++) {
            MenuItemImpl var10 = this.j.get(var4);
            if (var10.hasSubMenu()) {
               ((MenuBuilder)var10.getSubMenu()).a(var1, var2, var3);
            }

            char var5;
            if (var9) {
               var5 = var10.getAlphabeticShortcut();
            } else {
               var5 = var10.getNumericShortcut();
            }

            int var6;
            if (var9) {
               var6 = var10.getAlphabeticModifiers();
            } else {
               var6 = var10.getNumericModifiers();
            }

            boolean var12;
            if ((var7 & 69647) == (var6 & 69647)) {
               var12 = true;
            } else {
               var12 = false;
            }

            if (var12 && var5 != 0 && (var5 == var11.meta[0] || var5 == var11.meta[2] || var9 && var5 == '\b' && var2 == 67) && var10.isEnabled()) {
               var1.add(var10);
            }
         }
      }
   }

   public void a(boolean var1) {
      if (!this.r) {
         if (var1) {
            this.l = true;
            this.o = true;
         }

         this.d(var1);
      } else {
         this.s = true;
         if (var1) {
            this.t = true;
         }
      }
   }

   boolean a(MenuBuilder var1, MenuItem var2) {
      boolean var3;
      if (this.i != null && this.i.a(var1, var2)) {
         var3 = true;
      } else {
         var3 = false;
      }

      return var3;
   }

   public boolean a(MenuItem var1, int var2) {
      return this.a(var1, null, var2);
   }

   public boolean a(MenuItem var1, MenuPresenter var2, int var3) {
      boolean var6 = false;
      MenuItemImpl var7 = (MenuItemImpl)var1;
      boolean var5 = var6;
      if (var7 != null) {
         if (!var7.isEnabled()) {
            var5 = var6;
         } else {
            var5 = var7.b();
            ActionProvider var8 = var7.a();
            boolean var4;
            if (var8 != null && var8.e()) {
               var4 = true;
            } else {
               var4 = false;
            }

            if (var7.n()) {
               var6 = var7.expandActionView() | var5;
               var5 = var6;
               if (var6) {
                  this.b(true);
                  var5 = var6;
               }
            } else if (!var7.hasSubMenu() && !var4) {
               if ((var3 & 1) == 0) {
                  this.b(true);
               }
            } else {
               if ((var3 & 4) == 0) {
                  this.b(false);
               }

               if (!var7.hasSubMenu()) {
                  var7.a(new SubMenuBuilder(this.e(), this, var7));
               }

               SubMenuBuilder var11 = (SubMenuBuilder)var7.getSubMenu();
               if (var4) {
                  var8.a(var11);
               }

               var6 = this.a(var11, var2) | var5;
               var5 = var6;
               if (!var6) {
                  this.b(true);
                  var5 = var6;
               }
            }
         }
      }

      return var5;
   }

   public MenuItem add(int var1) {
      return this.a(0, 0, 0, this.f.getString(var1));
   }

   public MenuItem add(int var1, int var2, int var3, int var4) {
      return this.a(var1, var2, var3, this.f.getString(var4));
   }

   public MenuItem add(int var1, int var2, int var3, CharSequence var4) {
      return this.a(var1, var2, var3, var4);
   }

   public MenuItem add(CharSequence var1) {
      return this.a(0, 0, 0, var1);
   }

   public int addIntentOptions(int var1, int var2, int var3, ComponentName var4, Intent[] var5, Intent var6, int var7, MenuItem[] var8) {
      PackageManager var10 = this.e.getPackageManager();
      List var12 = var10.queryIntentActivityOptions(var4, var5, var6, 0);
      int var9;
      if (var12 != null) {
         var9 = var12.size();
      } else {
         var9 = 0;
      }

      if ((var7 & 1) == 0) {
         this.removeGroup(var1);
      }

      for (int var16 = 0; var16 < var9; var16++) {
         ResolveInfo var11 = (ResolveInfo)var12.get(var16);
         Intent var13;
         if (var11.specificIndex < 0) {
            var13 = var6;
         } else {
            var13 = var5[var11.specificIndex];
         }

         Intent var14 = new Intent(var13);
         var14.setComponent(new ComponentName(var11.activityInfo.applicationInfo.packageName, var11.activityInfo.name));
         MenuItem var15 = this.add(var1, var2, var3, var11.loadLabel(var10)).setIcon(var11.loadIcon(var10)).setIntent(var14);
         if (var8 != null && var11.specificIndex >= 0) {
            var8[var11.specificIndex] = var15;
         }
      }

      return var9;
   }

   public SubMenu addSubMenu(int var1) {
      return this.addSubMenu(0, 0, 0, this.f.getString(var1));
   }

   public SubMenu addSubMenu(int var1, int var2, int var3, int var4) {
      return this.addSubMenu(var1, var2, var3, this.f.getString(var4));
   }

   public SubMenu addSubMenu(int var1, int var2, int var3, CharSequence var4) {
      MenuItemImpl var6 = (MenuItemImpl)this.a(var1, var2, var3, var4);
      SubMenuBuilder var5 = new SubMenuBuilder(this.e, this, var6);
      var6.a(var5);
      return var5;
   }

   public SubMenu addSubMenu(CharSequence var1) {
      return this.addSubMenu(0, 0, 0, var1);
   }

   public int b(int var1) {
      int var3 = this.size();
      int var2 = 0;

      while (true) {
         if (var2 >= var3) {
            var1 = -1;
            break;
         }

         if (this.j.get(var2).getItemId() == var1) {
            var1 = var2;
            break;
         }

         var2++;
      }

      return var1;
   }

   public void b(Bundle var1) {
      this.f(var1);
   }

   void b(MenuItemImpl var1) {
      this.o = true;
      this.a(true);
   }

   public void b(MenuPresenter var1) {
      for (WeakReference var2 : this.x) {
         MenuPresenter var3 = (MenuPresenter)var2.get();
         if (var3 == null || var3 == var1) {
            this.x.remove(var2);
         }
      }
   }

   public final void b(boolean var1) {
      if (!this.v) {
         this.v = true;

         for (WeakReference var2 : this.x) {
            MenuPresenter var3 = (MenuPresenter)var2.get();
            if (var3 == null) {
               this.x.remove(var2);
            } else {
               var3.a(this, var1);
            }
         }

         this.v = false;
      }
   }

   boolean b() {
      return this.g;
   }

   public int c(int var1) {
      return this.a(var1, 0);
   }

   public void c(Bundle var1) {
      int var3 = this.size();
      int var2 = 0;
      SparseArray var4 = null;

      while (var2 < var3) {
         MenuItem var8 = this.getItem(var2);
         View var7 = var8.getActionView();
         SparseArray var6 = var4;
         if (var7 != null) {
            var6 = var4;
            if (var7.getId() != -1) {
               SparseArray var5 = var4;
               if (var4 == null) {
                  var5 = new SparseArray();
               }

               var7.saveHierarchyState(var5);
               var6 = var5;
               if (var8.isActionViewExpanded()) {
                  var1.putInt("android:menu:expandedactionview", var8.getItemId());
                  var6 = var5;
               }
            }
         }

         if (var8.hasSubMenu()) {
            ((SubMenuBuilder)var8.getSubMenu()).c(var1);
         }

         var2++;
         var4 = var6;
      }

      if (var4 != null) {
         var1.putSparseParcelableArray(this.a(), var4);
      }
   }

   public void c(boolean var1) {
      this.z = var1;
   }

   public boolean c() {
      return this.h;
   }

   public boolean c(MenuItemImpl var1) {
      boolean var3 = false;
      if (!this.x.isEmpty()) {
         this.g();
         Iterator var4 = this.x.iterator();
         boolean var2 = false;

         while (var4.hasNext()) {
            WeakReference var5 = (WeakReference)var4.next();
            MenuPresenter var6 = (MenuPresenter)var5.get();
            if (var6 == null) {
               this.x.remove(var5);
            } else {
               var3 = var6.a(this, var1);
               var2 = var3;
               if (var3) {
                  var2 = var3;
                  break;
               }
            }
         }

         this.h();
         var3 = var2;
         if (var2) {
            this.y = var1;
            var3 = var2;
         }
      }

      return var3;
   }

   public void clear() {
      if (this.y != null) {
         this.d(this.y);
      }

      this.j.clear();
      this.a(true);
   }

   public void clearHeader() {
      this.b = null;
      this.a = null;
      this.c = null;
      this.a(false);
   }

   public void close() {
      this.b(true);
   }

   Resources d() {
      return this.f;
   }

   protected MenuBuilder d(int var1) {
      this.a(var1, null, 0, null, null);
      return this;
   }

   public void d(Bundle var1) {
      if (var1 != null) {
         SparseArray var6 = var1.getSparseParcelableArray(this.a());
         int var3 = this.size();

         for (int var2 = 0; var2 < var3; var2++) {
            MenuItem var4 = this.getItem(var2);
            View var5 = var4.getActionView();
            if (var5 != null && var5.getId() != -1) {
               var5.restoreHierarchyState(var6);
            }

            if (var4.hasSubMenu()) {
               ((SubMenuBuilder)var4.getSubMenu()).d(var1);
            }
         }

         int var8 = var1.getInt("android:menu:expandedactionview");
         if (var8 > 0) {
            MenuItem var7 = this.findItem(var8);
            if (var7 != null) {
               var7.expandActionView();
            }
         }
      }
   }

   public boolean d(MenuItemImpl var1) {
      boolean var2 = false;
      boolean var3 = var2;
      if (!this.x.isEmpty()) {
         if (this.y != var1) {
            var3 = var2;
         } else {
            this.g();
            Iterator var5 = this.x.iterator();
            var2 = false;

            while (var5.hasNext()) {
               WeakReference var6 = (WeakReference)var5.next();
               MenuPresenter var4 = (MenuPresenter)var6.get();
               if (var4 == null) {
                  this.x.remove(var6);
               } else {
                  var3 = var4.b(this, var1);
                  var2 = var3;
                  if (var3) {
                     var2 = var3;
                     break;
                  }
               }
            }

            this.h();
            var3 = var2;
            if (var2) {
               this.y = null;
               var3 = var2;
            }
         }
      }

      return var3;
   }

   public Context e() {
      return this.e;
   }

   protected MenuBuilder e(int var1) {
      this.a(0, null, var1, null, null);
      return this;
   }

   public void f() {
      if (this.i != null) {
         this.i.a(this);
      }
   }

   public MenuItem findItem(int var1) {
      int var3 = this.size();
      int var2 = 0;

      MenuItem var4;
      while (true) {
         if (var2 >= var3) {
            var4 = null;
            break;
         }

         var4 = this.j.get(var2);
         if (var4.getItemId() == var1) {
            break;
         }

         if (var4.hasSubMenu()) {
            MenuItem var5 = var4.getSubMenu().findItem(var1);
            var4 = var5;
            if (var5 != null) {
               break;
            }
         }

         var2++;
      }

      return var4;
   }

   public void g() {
      if (!this.r) {
         this.r = true;
         this.s = false;
         this.t = false;
      }
   }

   public MenuItem getItem(int var1) {
      return this.j.get(var1);
   }

   public void h() {
      this.r = false;
      if (this.s) {
         this.s = false;
         this.a(this.t);
      }
   }

   public boolean hasVisibleItems() {
      boolean var3;
      if (this.z) {
         var3 = true;
      } else {
         int var2 = this.size();
         int var1 = 0;

         while (true) {
            if (var1 >= var2) {
               var3 = false;
               break;
            }

            if (this.j.get(var1).isVisible()) {
               var3 = true;
               break;
            }

            var1++;
         }
      }

      return var3;
   }

   public ArrayList<MenuItemImpl> i() {
      ArrayList var3;
      if (!this.l) {
         var3 = this.k;
      } else {
         this.k.clear();
         int var2 = this.j.size();

         for (int var1 = 0; var1 < var2; var1++) {
            MenuItemImpl var4 = this.j.get(var1);
            if (var4.isVisible()) {
               this.k.add(var4);
            }
         }

         this.l = false;
         this.o = true;
         var3 = this.k;
      }

      return var3;
   }

   public boolean isShortcutKey(int var1, KeyEvent var2) {
      boolean var3;
      if (this.a(var1, var2) != null) {
         var3 = true;
      } else {
         var3 = false;
      }

      return var3;
   }

   public void j() {
      ArrayList var3 = this.i();
      if (this.o) {
         Iterator var4 = this.x.iterator();
         boolean var1 = false;

         while (var4.hasNext()) {
            WeakReference var6 = (WeakReference)var4.next();
            MenuPresenter var5 = (MenuPresenter)var6.get();
            if (var5 == null) {
               this.x.remove(var6);
            } else {
               var1 |= var5.a();
            }
         }

         if (var1) {
            this.m.clear();
            this.n.clear();
            int var2 = var3.size();

            for (int var7 = 0; var7 < var2; var7++) {
               MenuItemImpl var8 = (MenuItemImpl)var3.get(var7);
               if (var8.j()) {
                  this.m.add(var8);
               } else {
                  this.n.add(var8);
               }
            }
         } else {
            this.m.clear();
            this.n.clear();
            this.n.addAll(this.i());
         }

         this.o = false;
      }
   }

   public ArrayList<MenuItemImpl> k() {
      this.j();
      return this.m;
   }

   public ArrayList<MenuItemImpl> l() {
      this.j();
      return this.n;
   }

   public CharSequence m() {
      return this.a;
   }

   public Drawable n() {
      return this.b;
   }

   public View o() {
      return this.c;
   }

   public MenuBuilder p() {
      return this;
   }

   public boolean performIdentifierAction(int var1, int var2) {
      return this.a(this.findItem(var1), var2);
   }

   public boolean performShortcut(int var1, KeyEvent var2, int var3) {
      MenuItemImpl var5 = this.a(var1, var2);
      boolean var4 = false;
      if (var5 != null) {
         var4 = this.a(var5, var3);
      }

      if ((var3 & 2) != 0) {
         this.b(true);
      }

      return var4;
   }

   boolean q() {
      return this.u;
   }

   public MenuItemImpl r() {
      return this.y;
   }

   public void removeGroup(int var1) {
      int var3 = this.c(var1);
      if (var3 >= 0) {
         int var4 = this.j.size();

         for (int var2 = 0; var2 < var4 - var3 && this.j.get(var3).getGroupId() == var1; var2++) {
            this.a(var3, false);
         }

         this.a(true);
      }
   }

   public void removeItem(int var1) {
      this.a(this.b(var1), true);
   }

   public void setGroupCheckable(int var1, boolean var2, boolean var3) {
      int var5 = this.j.size();

      for (int var4 = 0; var4 < var5; var4++) {
         MenuItemImpl var6 = this.j.get(var4);
         if (var6.getGroupId() == var1) {
            var6.a(var3);
            var6.setCheckable(var2);
         }
      }
   }

   public void setGroupEnabled(int var1, boolean var2) {
      int var4 = this.j.size();

      for (int var3 = 0; var3 < var4; var3++) {
         MenuItemImpl var5 = this.j.get(var3);
         if (var5.getGroupId() == var1) {
            var5.setEnabled(var2);
         }
      }
   }

   public void setGroupVisible(int var1, boolean var2) {
      int var5 = this.j.size();
      int var4 = 0;
      boolean var3 = false;

      while (var4 < var5) {
         MenuItemImpl var6 = this.j.get(var4);
         if (var6.getGroupId() == var1 && var6.c(var2)) {
            var3 = true;
         }

         var4++;
      }

      if (var3) {
         this.a(true);
      }
   }

   public void setQwertyMode(boolean var1) {
      this.g = var1;
      this.a(false);
   }

   public int size() {
      return this.j.size();
   }

   public interface Callback {
      void a(MenuBuilder var1);

      boolean a(MenuBuilder var1, MenuItem var2);
   }

   public interface ItemInvoker {
      boolean a(MenuItemImpl var1);
   }
}
