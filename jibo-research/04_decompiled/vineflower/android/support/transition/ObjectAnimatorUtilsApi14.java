package android.support.transition;

import android.animation.ObjectAnimator;
import android.graphics.Path;
import android.graphics.PointF;
import android.util.Property;

class ObjectAnimatorUtilsApi14 implements ObjectAnimatorUtilsImpl {
   @Override
   public <T> ObjectAnimator a(T var1, Property<T, PointF> var2, Path var3) {
      return ObjectAnimator.ofFloat(var1, new PathProperty(var2, var3), new float[]{0.0F, 1.0F});
   }
}
