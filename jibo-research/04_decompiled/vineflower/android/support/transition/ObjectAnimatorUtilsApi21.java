package android.support.transition;

import android.animation.ObjectAnimator;
import android.graphics.Path;
import android.graphics.PointF;
import android.util.Property;

class ObjectAnimatorUtilsApi21 implements ObjectAnimatorUtilsImpl {
   @Override
   public <T> ObjectAnimator a(T var1, Property<T, PointF> var2, Path var3) {
      return ObjectAnimator.ofObject(var1, var2, null, var3);
   }
}
