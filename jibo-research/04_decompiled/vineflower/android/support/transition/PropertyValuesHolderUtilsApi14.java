package android.support.transition;

import android.animation.PropertyValuesHolder;
import android.graphics.Path;
import android.graphics.PointF;
import android.util.Property;

class PropertyValuesHolderUtilsApi14 implements PropertyValuesHolderUtilsImpl {
   @Override
   public PropertyValuesHolder a(Property<?, PointF> var1, Path var2) {
      return PropertyValuesHolder.ofFloat(new PathProperty(var1, var2), new float[]{0.0F, 1.0F});
   }
}
