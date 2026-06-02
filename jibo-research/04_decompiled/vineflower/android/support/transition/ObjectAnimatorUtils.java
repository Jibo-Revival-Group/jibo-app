package android.support.transition;

import android.animation.ObjectAnimator;
import android.graphics.Path;
import android.graphics.PointF;
import android.os.Build.VERSION;
import android.util.Property;

class ObjectAnimatorUtils {
   private static final ObjectAnimatorUtilsImpl a;

   static {
      if (VERSION.SDK_INT >= 21) {
         a = new ObjectAnimatorUtilsApi21();
      } else {
         a = new ObjectAnimatorUtilsApi14();
      }
   }

   static <T> ObjectAnimator a(T var0, Property<T, PointF> var1, Path var2) {
      return a.a(var0, var1, var2);
   }
}
