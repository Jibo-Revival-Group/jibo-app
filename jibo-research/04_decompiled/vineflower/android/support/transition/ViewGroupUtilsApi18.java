package android.support.transition;

import android.util.Log;
import android.view.ViewGroup;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class ViewGroupUtilsApi18 extends ViewGroupUtilsApi14 {
   private static Method a;
   private static boolean b;

   private void a() {
      if (!b) {
         try {
            a = ViewGroup.class.getDeclaredMethod("suppressLayout", boolean.class);
            a.setAccessible(true);
         } catch (NoSuchMethodException var2) {
            Log.i("ViewUtilsApi18", "Failed to retrieve suppressLayout method", var2);
         }

         b = true;
      }
   }

   @Override
   public ViewGroupOverlayImpl a(ViewGroup var1) {
      return new ViewGroupOverlayApi18(var1);
   }

   @Override
   public void a(ViewGroup var1, boolean var2) {
      this.a();
      if (a != null) {
         try {
            a.invoke(var1, var2);
         } catch (IllegalAccessException var3) {
            Log.i("ViewUtilsApi18", "Failed to invoke suppressLayout method", var3);
         } catch (InvocationTargetException var4) {
            Log.i("ViewUtilsApi18", "Error invoking suppressLayout method", var4);
         }
      }
   }
}
