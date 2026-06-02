package android.support.design.widget;

import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.DrawableContainer.DrawableContainerState;
import android.util.Log;
import java.lang.reflect.Method;

class DrawableUtils {
   private static Method a;
   private static boolean b;

   static boolean a(DrawableContainer var0, ConstantState var1) {
      return b(var0, var1);
   }

   private static boolean b(DrawableContainer var0, ConstantState var1) {
      boolean var2 = true;
      if (!b) {
         try {
            a = DrawableContainer.class.getDeclaredMethod("setConstantState", DrawableContainerState.class);
            a.setAccessible(true);
         } catch (NoSuchMethodException var4) {
            Log.e("DrawableUtils", "Could not fetch setConstantState(). Oh well.");
         }

         b = true;
      }

      if (a != null) {
         try {
            a.invoke(var0, var1);
            return var2;
         } catch (Exception var5) {
            Log.e("DrawableUtils", "Could not invoke setConstantState(). Oh well.");
         }
      }

      return false;
   }
}
