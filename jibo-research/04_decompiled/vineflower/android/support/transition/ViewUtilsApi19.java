package android.support.transition;

import android.util.Log;
import android.view.View;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class ViewUtilsApi19 extends ViewUtilsApi18 {
   private static Method a;
   private static boolean b;
   private static Method c;
   private static boolean d;

   private void a() {
      if (!b) {
         try {
            a = View.class.getDeclaredMethod("setTransitionAlpha", float.class);
            a.setAccessible(true);
         } catch (NoSuchMethodException var2) {
            Log.i("ViewUtilsApi19", "Failed to retrieve setTransitionAlpha method", var2);
         }

         b = true;
      }
   }

   private void b() {
      if (!d) {
         try {
            c = View.class.getDeclaredMethod("getTransitionAlpha");
            c.setAccessible(true);
         } catch (NoSuchMethodException var2) {
            Log.i("ViewUtilsApi19", "Failed to retrieve getTransitionAlpha method", var2);
         }

         d = true;
      }
   }

   @Override
   public void a(View var1, float var2) {
      this.a();
      if (a != null) {
         try {
            a.invoke(var1, var2);
         } catch (IllegalAccessException var3) {
         } catch (InvocationTargetException var4) {
            throw new RuntimeException(var4.getCause());
         }
      } else {
         var1.setAlpha(var2);
      }
   }

   @Override
   public float c(View var1) {
      this.b();
      if (c != null) {
         try {
            return (Float)c.invoke(var1);
         } catch (IllegalAccessException var4) {
         } catch (InvocationTargetException var5) {
            throw new RuntimeException(var5.getCause());
         }
      }

      return super.c(var1);
   }

   @Override
   public void d(View var1) {
   }

   @Override
   public void e(View var1) {
   }
}
