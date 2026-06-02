package android.support.v7.widget;

import android.graphics.Rect;
import android.os.Build.VERSION;
import android.support.v4.view.ViewCompat;
import android.util.Log;
import android.view.View;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ViewUtils {
   private static Method a;

   static {
      if (VERSION.SDK_INT >= 18) {
         try {
            a = View.class.getDeclaredMethod("computeFitSystemWindows", Rect.class, Rect.class);
            if (!a.isAccessible()) {
               a.setAccessible(true);
            }
         } catch (NoSuchMethodException var1) {
            Log.d("ViewUtils", "Could not find method computeFitSystemWindows. Oh well.");
         }
      }
   }

   public static void a(View var0, Rect var1, Rect var2) {
      if (a != null) {
         try {
            a.invoke(var0, var1, var2);
         } catch (Exception var3) {
            Log.d("ViewUtils", "Could not invoke computeFitSystemWindows", var3);
         }
      }
   }

   public static boolean a(View var0) {
      boolean var1 = true;
      if (ViewCompat.e(var0) != 1) {
         var1 = false;
      }

      return var1;
   }

   public static void b(View var0) {
      if (VERSION.SDK_INT >= 16) {
         try {
            Method var1 = var0.getClass().getMethod("makeOptionalFitsSystemWindows");
            if (!var1.isAccessible()) {
               var1.setAccessible(true);
            }

            var1.invoke(var0);
         } catch (NoSuchMethodException var2) {
            Log.d("ViewUtils", "Could not find method makeOptionalFitsSystemWindows. Oh well...");
         } catch (InvocationTargetException var3) {
            Log.d("ViewUtils", "Could not invoke makeOptionalFitsSystemWindows", var3);
         } catch (IllegalAccessException var4) {
            Log.d("ViewUtils", "Could not invoke makeOptionalFitsSystemWindows", var4);
         }
      }
   }
}
