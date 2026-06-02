package com.salesforce.android.knowledge.ui.internal.home;

import android.animation.ObjectAnimator;
import android.view.View;

public class RotateAnimation {
   public static void a(View var0, float var1) {
      var0.setPivotY(var0.getHeight() / 2);
      var0.setPivotX(var0.getWidth() / 2);
      ObjectAnimator var2 = ObjectAnimator.ofFloat(var0, "rotation", new float[]{var1});
      var2.setDuration(400L);
      var2.start();
   }
}
