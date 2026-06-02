package android.support.design.widget;

import android.support.v4.view.animation.FastOutLinearInInterpolator;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.support.v4.view.animation.LinearOutSlowInInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;

class AnimationUtils {
   static final Interpolator a = new LinearInterpolator();
   static final Interpolator b = new FastOutSlowInInterpolator();
   static final Interpolator c = new FastOutLinearInInterpolator();
   static final Interpolator d = new LinearOutSlowInInterpolator();
   static final Interpolator e = new DecelerateInterpolator();

   static float a(float var0, float var1, float var2) {
      return (var1 - var0) * var2 + var0;
   }

   static int a(int var0, int var1, float var2) {
      return Math.round((var1 - var0) * var2) + var0;
   }
}
