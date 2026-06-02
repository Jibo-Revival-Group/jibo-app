package android.support.v4.view;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.os.Build.VERSION;
import android.support.v4.internal.view.SupportMenuItem;
import android.util.Log;
import android.view.MenuItem;

public final class MenuItemCompat {
   static final MenuItemCompat.MenuVersionImpl a;

   static {
      if (VERSION.SDK_INT >= 26) {
         a = new MenuItemCompat.MenuItemCompatApi26Impl();
      } else {
         a = new MenuItemCompat.MenuItemCompatBaseImpl();
      }
   }

   public static MenuItem a(MenuItem var0, ActionProvider var1) {
      if (var0 instanceof SupportMenuItem) {
         var0 = ((SupportMenuItem)var0).a(var1);
      } else {
         Log.w("MenuItemCompat", "setActionProvider: item does not implement SupportMenuItem; ignoring");
      }

      return var0;
   }

   public static void a(MenuItem var0, char var1, int var2) {
      if (var0 instanceof SupportMenuItem) {
         ((SupportMenuItem)var0).setNumericShortcut(var1, var2);
      } else {
         a.b(var0, var1, var2);
      }
   }

   public static void a(MenuItem var0, ColorStateList var1) {
      if (var0 instanceof SupportMenuItem) {
         ((SupportMenuItem)var0).setIconTintList(var1);
      } else {
         a.a(var0, var1);
      }
   }

   public static void a(MenuItem var0, Mode var1) {
      if (var0 instanceof SupportMenuItem) {
         ((SupportMenuItem)var0).setIconTintMode(var1);
      } else {
         a.a(var0, var1);
      }
   }

   public static void a(MenuItem var0, CharSequence var1) {
      if (var0 instanceof SupportMenuItem) {
         ((SupportMenuItem)var0).a(var1);
      } else {
         a.a(var0, var1);
      }
   }

   public static void b(MenuItem var0, char var1, int var2) {
      if (var0 instanceof SupportMenuItem) {
         ((SupportMenuItem)var0).setAlphabeticShortcut(var1, var2);
      } else {
         a.a(var0, var1, var2);
      }
   }

   public static void b(MenuItem var0, CharSequence var1) {
      if (var0 instanceof SupportMenuItem) {
         ((SupportMenuItem)var0).b(var1);
      } else {
         a.b(var0, var1);
      }
   }

   static class MenuItemCompatApi26Impl extends MenuItemCompat.MenuItemCompatBaseImpl {
      @Override
      public void a(MenuItem var1, char var2, int var3) {
         var1.setAlphabeticShortcut(var2, var3);
      }

      @Override
      public void a(MenuItem var1, ColorStateList var2) {
         var1.setIconTintList(var2);
      }

      @Override
      public void a(MenuItem var1, Mode var2) {
         var1.setIconTintMode(var2);
      }

      @Override
      public void a(MenuItem var1, CharSequence var2) {
         var1.setContentDescription(var2);
      }

      @Override
      public void b(MenuItem var1, char var2, int var3) {
         var1.setNumericShortcut(var2, var3);
      }

      @Override
      public void b(MenuItem var1, CharSequence var2) {
         var1.setTooltipText(var2);
      }
   }

   static class MenuItemCompatBaseImpl implements MenuItemCompat.MenuVersionImpl {
      @Override
      public void a(MenuItem var1, char var2, int var3) {
      }

      @Override
      public void a(MenuItem var1, ColorStateList var2) {
      }

      @Override
      public void a(MenuItem var1, Mode var2) {
      }

      @Override
      public void a(MenuItem var1, CharSequence var2) {
      }

      @Override
      public void b(MenuItem var1, char var2, int var3) {
      }

      @Override
      public void b(MenuItem var1, CharSequence var2) {
      }
   }

   interface MenuVersionImpl {
      void a(MenuItem var1, char var2, int var3);

      void a(MenuItem var1, ColorStateList var2);

      void a(MenuItem var1, Mode var2);

      void a(MenuItem var1, CharSequence var2);

      void b(MenuItem var1, char var2, int var3);

      void b(MenuItem var1, CharSequence var2);
   }
}
