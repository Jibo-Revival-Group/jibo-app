package android.support.transition;

import android.animation.ObjectAnimator;
import android.graphics.Path;
import android.graphics.PointF;
import android.util.Property;

interface ObjectAnimatorUtilsImpl {
   <T> ObjectAnimator a(T var1, Property<T, PointF> var2, Path var3);
}
