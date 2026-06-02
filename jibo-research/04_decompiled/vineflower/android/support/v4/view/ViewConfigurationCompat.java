package android.support.v4.view;

import android.content.Context;
import android.os.Build.VERSION;
import android.util.Log;
import android.util.TypedValue;
import android.view.ViewConfiguration;
import java.lang.reflect.Method;

public final class ViewConfigurationCompat {
   private static Method a;

   static {
      if (VERSION.SDK_INT == 25) {
         try {
            a = ViewConfiguration.class.getDeclaredMethod("getScaledScrollFactor");
         } catch (Exception var1) {
            Log.i("ViewConfigCompat", "Could not find method getScaledScrollFactor() on ViewConfiguration");
         }
      }
   }

   public static float a(ViewConfiguration var0, Context var1) {
      float var2;
      if (VERSION.SDK_INT >= 26) {
         var2 = var0.getScaledHorizontalScrollFactor();
      } else {
         var2 = c(var0, var1);
      }

      return var2;
   }

   public static float b(ViewConfiguration var0, Context var1) {
      float var2;
      if (VERSION.SDK_INT >= 26) {
         var2 = var0.getScaledVerticalScrollFactor();
      } else {
         var2 = c(var0, var1);
      }

      return var2;
   }

   private static float c(ViewConfiguration var0, Context var1) {
      label21:
      if (VERSION.SDK_INT >= 25 && a != null) {
         int var3;
         try {
            var3 = (Integer)a.invoke(var0);
         } catch (Exception var4) {
            Log.i("ViewConfigCompat", "Could not find method getScaledScrollFactor() on ViewConfiguration");
            break label21;
         }

         float var6 = var3;
         return var6;
      }

      TypedValue var5 = new TypedValue();
      float var2;
      if (var1.getTheme().resolveAttribute(16842829, var5, true)) {
         var2 = var5.getDimension(var1.getResources().getDisplayMetrics());
      } else {
         var2 = 0.0F;
      }

      return var2;
   }
}
