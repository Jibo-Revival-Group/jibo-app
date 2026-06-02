package android.support.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

class AnimatorUtilsApi19 implements AnimatorUtilsImpl {
   @Override
   public void a(Animator var1) {
      var1.pause();
   }

   @Override
   public void a(Animator var1, AnimatorListenerAdapter var2) {
      var1.addPauseListener(var2);
   }

   @Override
   public void b(Animator var1) {
      var1.resume();
   }
}
