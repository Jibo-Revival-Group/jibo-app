package android.support.transition;

import android.graphics.Matrix;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class GhostViewApi21 implements GhostViewImpl {
   private static Class<?> a;
   private static boolean b;
   private static Method c;
   private static boolean d;
   private static Method e;
   private static boolean f;
   private final View g;

   private GhostViewApi21(View var1) {
      this.g = var1;
   }

   private static void e() {
      if (!b) {
         try {
            a = Class.forName("android.view.GhostView");
         } catch (ClassNotFoundException var1) {
            Log.i("GhostViewApi21", "Failed to retrieve GhostView class", var1);
         }

         b = true;
      }
   }

   private static void f() {
      if (!d) {
         try {
            e();
            c = a.getDeclaredMethod("addGhost", View.class, ViewGroup.class, Matrix.class);
            c.setAccessible(true);
         } catch (NoSuchMethodException var1) {
            Log.i("GhostViewApi21", "Failed to retrieve addGhost method", var1);
         }

         d = true;
      }
   }

   private static void g() {
      if (!f) {
         try {
            e();
            e = a.getDeclaredMethod("removeGhost", View.class);
            e.setAccessible(true);
         } catch (NoSuchMethodException var1) {
            Log.i("GhostViewApi21", "Failed to retrieve removeGhost method", var1);
         }

         f = true;
      }
   }

   @Override
   public void a(ViewGroup var1, View var2) {
   }

   @Override
   public void setVisibility(int var1) {
      this.g.setVisibility(var1);
   }

   static class Creator implements GhostViewImpl.Creator {
      @Override
      public GhostViewImpl a(View var1, ViewGroup var2, Matrix var3) {
         GhostViewApi21.f();
         if (GhostViewApi21.c != null) {
            GhostViewApi21 var4;
            try {
               var4 = new GhostViewApi21((View)GhostViewApi21.c.invoke(null, var1, var2, var3));
            } catch (IllegalAccessException var5) {
               return null;
            } catch (InvocationTargetException var6) {
               throw new RuntimeException(var6.getCause());
            }

            return var4;
         } else {
            return null;
         }
      }

      @Override
      public void a(View var1) {
         GhostViewApi21.g();
         if (GhostViewApi21.e != null) {
            try {
               GhostViewApi21.e.invoke(null, var1);
            } catch (IllegalAccessException var2) {
            } catch (InvocationTargetException var3) {
               throw new RuntimeException(var3.getCause());
            }
         }
      }
   }
}
