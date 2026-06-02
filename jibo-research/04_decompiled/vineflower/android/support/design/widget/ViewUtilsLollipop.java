package android.support.design.widget;

import android.animation.AnimatorInflater;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.support.design.R;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;

class ViewUtilsLollipop {
   private static final int[] a = new int[]{16843848};

   static void a(View var0) {
      var0.setOutlineProvider(ViewOutlineProvider.BOUNDS);
   }

   static void a(View var0, float var1) {
      int var3 = var0.getResources().getInteger(R.integer.app_bar_elevation_anim_duration);
      android.animation.StateListAnimator var5 = new android.animation.StateListAnimator();
      int var4 = R.attr.state_collapsible;
      int var2 = -R.attr.state_collapsed;
      ObjectAnimator var6 = ObjectAnimator.ofFloat(var0, "elevation", new float[]{0.0F}).setDuration(var3);
      var5.addState(new int[]{16842766, var4, var2}, var6);
      var6 = ObjectAnimator.ofFloat(var0, "elevation", new float[]{var1}).setDuration(var3);
      var5.addState(new int[]{16842766}, var6);
      var6 = ObjectAnimator.ofFloat(var0, "elevation", new float[]{0.0F}).setDuration(0L);
      var5.addState(new int[0], var6);
      var0.setStateListAnimator(var5);
   }

   static void a(View var0, AttributeSet var1, int var2, int var3) {
      Context var4 = var0.getContext();
      TypedArray var7 = var4.obtainStyledAttributes(var1, a, var2, var3);

      try {
         if (var7.hasValue(0)) {
            var0.setStateListAnimator(AnimatorInflater.loadStateListAnimator(var4, var7.getResourceId(0, 0)));
         }
      } finally {
         var7.recycle();
      }
   }
}
