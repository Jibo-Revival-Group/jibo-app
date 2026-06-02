package android.support.transition;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.support.v4.view.ViewCompat;
import android.util.Log;
import android.util.Property;
import android.view.View;
import java.lang.reflect.Field;

class ViewUtils {
   static final Property<View, Float> a;
   static final Property<View, Rect> b;
   private static final ViewUtilsImpl c;
   private static Field d;
   private static boolean e;

   static {
      if (VERSION.SDK_INT >= 22) {
         c = new ViewUtilsApi22();
      } else if (VERSION.SDK_INT >= 21) {
         c = new ViewUtilsApi21();
      } else if (VERSION.SDK_INT >= 19) {
         c = new ViewUtilsApi19();
      } else if (VERSION.SDK_INT >= 18) {
         c = new ViewUtilsApi18();
      } else {
         c = new ViewUtilsApi14();
      }

      a = new Property<View, Float>(Float.class, "translationAlpha") {
         public Float a(View var1) {
            return ViewUtils.c(var1);
         }

         public void a(View var1, Float var2) {
            ViewUtils.a(var1, var2);
         }
      };
      b = new Property<View, Rect>(Rect.class, "clipBounds") {
         public Rect a(View var1) {
            return ViewCompat.A(var1);
         }

         public void a(View var1, Rect var2) {
            ViewCompat.a(var1, var2);
         }
      };
   }

   static ViewOverlayImpl a(View var0) {
      return c.a(var0);
   }

   private static void a() {
      if (!e) {
         try {
            d = View.class.getDeclaredField("mViewFlags");
            d.setAccessible(true);
         } catch (NoSuchFieldException var1) {
            Log.i("ViewUtils", "fetchViewFlagsField: ");
         }

         e = true;
      }
   }

   static void a(View var0, float var1) {
      c.a(var0, var1);
   }

   static void a(View var0, int var1) {
      a();
      if (d != null) {
         try {
            int var2 = d.getInt(var0);
            d.setInt(var0, var2 & -13 | var1);
         } catch (IllegalAccessException var3) {
         }
      }
   }

   static void a(View var0, int var1, int var2, int var3, int var4) {
      c.a(var0, var1, var2, var3, var4);
   }

   static void a(View var0, Matrix var1) {
      c.a(var0, var1);
   }

   static WindowIdImpl b(View var0) {
      return c.b(var0);
   }

   static void b(View var0, Matrix var1) {
      c.b(var0, var1);
   }

   static float c(View var0) {
      return c.c(var0);
   }

   static void c(View var0, Matrix var1) {
      c.c(var0, var1);
   }

   static void d(View var0) {
      c.d(var0);
   }

   static void e(View var0) {
      c.e(var0);
   }
}
