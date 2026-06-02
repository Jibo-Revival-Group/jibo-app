package android.support.transition;

import android.graphics.Matrix;
import android.util.Log;
import android.view.View;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class ViewUtilsApi21 extends ViewUtilsApi19 {
   private static Method a;
   private static boolean b;
   private static Method c;
   private static boolean d;
   private static Method e;
   private static boolean f;

   private void a() {
      if (!b) {
         try {
            a = View.class.getDeclaredMethod("transformMatrixToGlobal", Matrix.class);
            a.setAccessible(true);
         } catch (NoSuchMethodException var2) {
            Log.i("ViewUtilsApi21", "Failed to retrieve transformMatrixToGlobal method", var2);
         }

         b = true;
      }
   }

   private void b() {
      if (!d) {
         try {
            c = View.class.getDeclaredMethod("transformMatrixToLocal", Matrix.class);
            c.setAccessible(true);
         } catch (NoSuchMethodException var2) {
            Log.i("ViewUtilsApi21", "Failed to retrieve transformMatrixToLocal method", var2);
         }

         d = true;
      }
   }

   private void c() {
      if (!f) {
         try {
            e = View.class.getDeclaredMethod("setAnimationMatrix", Matrix.class);
            e.setAccessible(true);
         } catch (NoSuchMethodException var2) {
            Log.i("ViewUtilsApi21", "Failed to retrieve setAnimationMatrix method", var2);
         }

         f = true;
      }
   }

   @Override
   public void a(View var1, Matrix var2) {
      this.a();
      if (a != null) {
         try {
            a.invoke(var1, var2);
         } catch (IllegalAccessException var3) {
         } catch (InvocationTargetException var4) {
            throw new RuntimeException(var4.getCause());
         }
      }
   }

   @Override
   public void b(View var1, Matrix var2) {
      this.b();
      if (c != null) {
         try {
            c.invoke(var1, var2);
         } catch (IllegalAccessException var3) {
         } catch (InvocationTargetException var4) {
            throw new RuntimeException(var4.getCause());
         }
      }
   }

   @Override
   public void c(View var1, Matrix var2) {
      this.c();
      if (e != null) {
         try {
            e.invoke(var1, var2);
         } catch (InvocationTargetException var3) {
         } catch (IllegalAccessException var4) {
            throw new RuntimeException(var4.getCause());
         }
      }
   }
}
