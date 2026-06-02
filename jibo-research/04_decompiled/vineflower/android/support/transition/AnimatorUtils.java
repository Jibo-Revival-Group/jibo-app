package android.support.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Build.VERSION;

class AnimatorUtils {
   private static final AnimatorUtilsImpl a;

   static {
      if (VERSION.SDK_INT >= 19) {
         a = new AnimatorUtilsApi19();
      } else {
         a = new AnimatorUtilsApi14();
      }
   }

   static void a(Animator var0) {
      a.a(var0);
   }

   static void a(Animator var0, AnimatorListenerAdapter var1) {
      a.a(var0, var1);
   }

   static void b(Animator var0) {
      a.b(var0);
   }
}
