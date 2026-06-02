package android.support.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.Animator.AnimatorListener;
import java.util.ArrayList;

class AnimatorUtilsApi14 implements AnimatorUtilsImpl {
   @Override
   public void a(Animator var1) {
      ArrayList var5 = var1.getListeners();
      if (var5 != null) {
         int var3 = var5.size();

         for (int var2 = 0; var2 < var3; var2++) {
            AnimatorListener var4 = (AnimatorListener)var5.get(var2);
            if (var4 instanceof AnimatorUtilsApi14.AnimatorPauseListenerCompat) {
               ((AnimatorUtilsApi14.AnimatorPauseListenerCompat)var4).onAnimationPause(var1);
            }
         }
      }
   }

   @Override
   public void a(Animator var1, AnimatorListenerAdapter var2) {
   }

   @Override
   public void b(Animator var1) {
      ArrayList var4 = var1.getListeners();
      if (var4 != null) {
         int var3 = var4.size();

         for (int var2 = 0; var2 < var3; var2++) {
            AnimatorListener var5 = (AnimatorListener)var4.get(var2);
            if (var5 instanceof AnimatorUtilsApi14.AnimatorPauseListenerCompat) {
               ((AnimatorUtilsApi14.AnimatorPauseListenerCompat)var5).onAnimationResume(var1);
            }
         }
      }
   }

   interface AnimatorPauseListenerCompat {
      void onAnimationPause(Animator var1);

      void onAnimationResume(Animator var1);
   }
}
