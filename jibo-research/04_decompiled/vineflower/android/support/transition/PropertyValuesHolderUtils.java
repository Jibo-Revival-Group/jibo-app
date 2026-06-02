package android.support.transition;

import android.animation.PropertyValuesHolder;
import android.graphics.Path;
import android.graphics.PointF;
import android.os.Build.VERSION;
import android.util.Property;

class PropertyValuesHolderUtils {
   private static final PropertyValuesHolderUtilsImpl a;

   static {
      if (VERSION.SDK_INT >= 21) {
         a = new PropertyValuesHolderUtilsApi21();
      } else {
         a = new PropertyValuesHolderUtilsApi14();
      }
   }

   static PropertyValuesHolder a(Property<?, PointF> var0, Path var1) {
      return a.a(var0, var1);
   }
}
