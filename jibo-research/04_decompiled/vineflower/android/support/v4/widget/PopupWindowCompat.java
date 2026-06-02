package android.support.v4.widget;

import android.os.Build.VERSION;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewCompat;
import android.util.Log;
import android.view.View;
import android.widget.PopupWindow;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public final class PopupWindowCompat {
   static final PopupWindowCompat.PopupWindowCompatBaseImpl a;

   static {
      if (VERSION.SDK_INT >= 23) {
         a = new PopupWindowCompat.PopupWindowCompatApi23Impl();
      } else if (VERSION.SDK_INT >= 21) {
         a = new PopupWindowCompat.PopupWindowCompatApi21Impl();
      } else if (VERSION.SDK_INT >= 19) {
         a = new PopupWindowCompat.PopupWindowCompatApi19Impl();
      } else {
         a = new PopupWindowCompat.PopupWindowCompatBaseImpl();
      }
   }

   public static void a(PopupWindow var0, int var1) {
      a.a(var0, var1);
   }

   public static void a(PopupWindow var0, View var1, int var2, int var3, int var4) {
      a.a(var0, var1, var2, var3, var4);
   }

   public static void a(PopupWindow var0, boolean var1) {
      a.a(var0, var1);
   }

   static class PopupWindowCompatApi19Impl extends PopupWindowCompat.PopupWindowCompatBaseImpl {
      @Override
      public void a(PopupWindow var1, View var2, int var3, int var4, int var5) {
         var1.showAsDropDown(var2, var3, var4, var5);
      }
   }

   static class PopupWindowCompatApi21Impl extends PopupWindowCompat.PopupWindowCompatApi19Impl {
      private static Field a;

      static {
         try {
            a = PopupWindow.class.getDeclaredField("mOverlapAnchor");
            a.setAccessible(true);
         } catch (NoSuchFieldException var1) {
            Log.i("PopupWindowCompatApi21", "Could not fetch mOverlapAnchor field from PopupWindow", var1);
         }
      }

      @Override
      public void a(PopupWindow var1, boolean var2) {
         if (a != null) {
            try {
               a.set(var1, var2);
            } catch (IllegalAccessException var3) {
               Log.i("PopupWindowCompatApi21", "Could not set overlap anchor field in PopupWindow", var3);
            }
         }
      }
   }

   static class PopupWindowCompatApi23Impl extends PopupWindowCompat.PopupWindowCompatApi21Impl {
      @Override
      public void a(PopupWindow var1, int var2) {
         var1.setWindowLayoutType(var2);
      }

      @Override
      public void a(PopupWindow var1, boolean var2) {
         var1.setOverlapAnchor(var2);
      }
   }

   static class PopupWindowCompatBaseImpl {
      private static Method a;
      private static boolean b;

      public void a(PopupWindow var1, int var2) {
         if (!b) {
            try {
               a = PopupWindow.class.getDeclaredMethod("setWindowLayoutType", int.class);
               a.setAccessible(true);
            } catch (Exception var5) {
            }

            b = true;
         }

         if (a != null) {
            try {
               a.invoke(var1, var2);
            } catch (Exception var4) {
            }
         }
      }

      public void a(PopupWindow var1, View var2, int var3, int var4, int var5) {
         int var6 = var3;
         if ((GravityCompat.a(var5, ViewCompat.e(var2)) & 7) == 5) {
            var6 = var3 - (var1.getWidth() - var2.getWidth());
         }

         var1.showAsDropDown(var2, var6, var4);
      }

      public void a(PopupWindow var1, boolean var2) {
      }
   }
}
