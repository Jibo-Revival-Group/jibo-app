package android.support.v7.view;

import android.content.Context;
import android.support.v4.internal.view.SupportMenu;
import android.support.v4.internal.view.SupportMenuItem;
import android.support.v4.util.SimpleArrayMap;
import android.support.v7.view.menu.MenuWrapperFactory;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ActionMode.Callback;
import java.util.ArrayList;

public class SupportActionModeWrapper extends android.view.ActionMode {
   final Context a;
   final ActionMode b;

   public SupportActionModeWrapper(Context var1, ActionMode var2) {
      this.a = var1;
      this.b = var2;
   }

   public void finish() {
      this.b.c();
   }

   public View getCustomView() {
      return this.b.i();
   }

   public Menu getMenu() {
      return MenuWrapperFactory.a(this.a, (SupportMenu)this.b.b());
   }

   public MenuInflater getMenuInflater() {
      return this.b.a();
   }

   public CharSequence getSubtitle() {
      return this.b.g();
   }

   public Object getTag() {
      return this.b.j();
   }

   public CharSequence getTitle() {
      return this.b.f();
   }

   public boolean getTitleOptionalHint() {
      return this.b.k();
   }

   public void invalidate() {
      this.b.d();
   }

   public boolean isTitleOptional() {
      return this.b.h();
   }

   public void setCustomView(View var1) {
      this.b.a(var1);
   }

   public void setSubtitle(int var1) {
      this.b.b(var1);
   }

   public void setSubtitle(CharSequence var1) {
      this.b.a(var1);
   }

   public void setTag(Object var1) {
      this.b.a(var1);
   }

   public void setTitle(int var1) {
      this.b.a(var1);
   }

   public void setTitle(CharSequence var1) {
      this.b.b(var1);
   }

   public void setTitleOptionalHint(boolean var1) {
      this.b.a(var1);
   }

   public static class CallbackWrapper implements ActionMode.Callback {
      final Callback a;
      final Context b;
      final ArrayList<SupportActionModeWrapper> c;
      final SimpleArrayMap<Menu, Menu> d;

      public CallbackWrapper(Context var1, Callback var2) {
         this.b = var1;
         this.a = var2;
         this.c = new ArrayList<>();
         this.d = new SimpleArrayMap<>();
      }

      private Menu a(Menu var1) {
         Menu var3 = this.d.get(var1);
         Menu var2 = var3;
         if (var3 == null) {
            var2 = MenuWrapperFactory.a(this.b, (SupportMenu)var1);
            this.d.put(var1, var2);
         }

         return var2;
      }

      @Override
      public void a(ActionMode var1) {
         this.a.onDestroyActionMode(this.b(var1));
      }

      @Override
      public boolean a(ActionMode var1, Menu var2) {
         return this.a.onCreateActionMode(this.b(var1), this.a(var2));
      }

      @Override
      public boolean a(ActionMode var1, MenuItem var2) {
         return this.a.onActionItemClicked(this.b(var1), MenuWrapperFactory.a(this.b, (SupportMenuItem)var2));
      }

      public android.view.ActionMode b(ActionMode var1) {
         int var3 = this.c.size();
         int var2 = 0;

         while (true) {
            if (var2 >= var3) {
               var5 = new SupportActionModeWrapper(this.b, var1);
               this.c.add(var5);
               break;
            }

            SupportActionModeWrapper var4 = this.c.get(var2);
            if (var4 != null && var4.b == var1) {
               var5 = var4;
               break;
            }

            var2++;
         }

         return var5;
      }

      @Override
      public boolean b(ActionMode var1, Menu var2) {
         return this.a.onPrepareActionMode(this.b(var1), this.a(var2));
      }
   }
}
