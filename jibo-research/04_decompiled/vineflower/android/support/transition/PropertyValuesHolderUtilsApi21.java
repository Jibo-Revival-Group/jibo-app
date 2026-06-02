package android.support.transition;

import android.animation.PropertyValuesHolder;
import android.graphics.Path;
import android.graphics.PointF;
import android.util.Property;

class PropertyValuesHolderUtilsApi21 implements PropertyValuesHolderUtilsImpl {
   @Override
   public PropertyValuesHolder a(Property<?, PointF> var1, Path var2) {
      return PropertyValuesHolder.ofObject(var1, null, var2);
   }
}
