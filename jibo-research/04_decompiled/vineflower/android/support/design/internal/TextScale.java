package android.support.design.internal;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.support.transition.Transition;
import android.support.transition.TransitionValues;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.Map;

public class TextScale extends Transition {
   private void d(TransitionValues var1) {
      if (var1.b instanceof TextView) {
         TextView var2 = (TextView)var1.b;
         var1.a.put("android:textscale:scale", var2.getScaleX());
      }
   }

   @Override
   public Animator a(ViewGroup var1, TransitionValues var2, TransitionValues var3) {
      float var5 = 1.0F;
      ValueAnimator var7;
      if (var2 != null && var3 != null && var2.b instanceof TextView && var3.b instanceof TextView) {
         TextView var6 = (TextView)var3.b;
         Map var8 = var2.a;
         Map var9 = var3.a;
         float var4;
         if (var8.get("android:textscale:scale") != null) {
            var4 = (Float)var8.get("android:textscale:scale");
         } else {
            var4 = 1.0F;
         }

         if (var9.get("android:textscale:scale") != null) {
            var5 = (Float)var9.get("android:textscale:scale");
         }

         if (var4 == var5) {
            var7 = null;
         } else {
            var7 = ValueAnimator.ofFloat(new float[]{var4, var5});
            var7.addUpdateListener(new AnimatorUpdateListener(this, var6) {
               final TextView a;
               final TextScale b;

               {
                  this.b = var1;
                  this.a = var2x;
               }

               public void onAnimationUpdate(ValueAnimator var1) {
                  float var2x = (Float)var1.getAnimatedValue();
                  this.a.setScaleX(var2x);
                  this.a.setScaleY(var2x);
               }
            });
         }
      } else {
         var7 = null;
      }

      return var7;
   }

   @Override
   public void a(TransitionValues var1) {
      this.d(var1);
   }

   @Override
   public void b(TransitionValues var1) {
      this.d(var1);
   }
}
