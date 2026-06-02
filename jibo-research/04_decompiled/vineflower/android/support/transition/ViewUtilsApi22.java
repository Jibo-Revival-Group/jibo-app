package android.support.transition;

import android.annotation.SuppressLint;
import android.util.Log;
import android.view.View;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class ViewUtilsApi22 extends ViewUtilsApi21 {
   private static Method a;
   private static boolean b;

   @SuppressLint("PrivateApi")
   private void a() {
      if (!b) {
         try {
            a = View.class.getDeclaredMethod("setLeftTopRightBottom", int.class, int.class, int.class, int.class);
            a.setAccessible(true);
         } catch (NoSuchMethodException var2) {
            Log.i("ViewUtilsApi22", "Failed to retrieve setLeftTopRightBottom method", var2);
         }

         b = true;
      }
   }

   @Override
   public void a(View var1, int var2, int var3, int var4, int var5) {
      this.a();
      if (a != null) {
         try {
            a.invoke(var1, var2, var3, var4, var5);
         } catch (IllegalAccessException var6) {
         } catch (InvocationTargetException var7) {
            throw new RuntimeException(var7.getCause());
         }
      }
   }
}
