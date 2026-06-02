package com.salesforce.android.knowledge.ui.internal.util;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.view.View.OnClickListener;
import com.salesforce.android.knowledge.ui.R;

public class AnimatedOnClickListener implements OnClickListener {
   private ValueAnimator a;
   private final int b;
   private final int c;
   private final int d;
   private final OnClickListener e;

   private AnimatedOnClickListener(Context var1, OnClickListener var2) {
      int var3 = ContextCompat.c(var1, R.color.salesforce_brand_secondary);
      var3 = Color.argb(63, Color.red(var3), Color.green(var3), Color.blue(var3));
      this.b = 0;
      this.c = var3;
      this.d = 300;
      this.e = var2;
   }

   public static AnimatedOnClickListener a(Context var0, OnClickListener var1) {
      return new AnimatedOnClickListener(var0, var1);
   }

   public final void onClick(View var1) {
      if (this.a != null) {
         this.a.cancel();
      }

      this.a = ValueAnimator.ofObject(new ArgbEvaluator(), new Object[]{this.c, this.b});
      this.a.setDuration(this.d);
      this.a.addUpdateListener(new AnimatorUpdateListener(this, var1) {
         final View a;
         final AnimatedOnClickListener b;

         {
            this.b = var1;
            this.a = var2;
         }

         public void onAnimationUpdate(ValueAnimator var1) {
            this.a.setBackgroundColor((Integer)var1.getAnimatedValue());
         }
      });
      this.a.start();
      if (this.e != null) {
         this.e.onClick(var1);
      }
   }
}
