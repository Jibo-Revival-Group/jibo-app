package android.support.design.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.Animator.AnimatorListener;
import android.util.StateSet;
import java.util.ArrayList;

final class StateListAnimator {
   ValueAnimator a;
   private final ArrayList<StateListAnimator.Tuple> b = new ArrayList<>();
   private StateListAnimator.Tuple c = null;
   private final AnimatorListener d;

   StateListAnimator() {
      this.a = null;
      this.d = new AnimatorListenerAdapter(this) {
         final StateListAnimator a;

         {
            this.a = var1;
         }

         public void onAnimationEnd(Animator var1) {
            if (this.a.a == var1) {
               this.a.a = null;
            }
         }
      };
   }

   private void a(StateListAnimator.Tuple var1) {
      this.a = var1.b;
      this.a.start();
   }

   private void b() {
      if (this.a != null) {
         this.a.cancel();
         this.a = null;
      }
   }

   public void a() {
      if (this.a != null) {
         this.a.end();
         this.a = null;
      }
   }

   void a(int[] var1) {
      int var3 = this.b.size();
      int var2 = 0;

      while (true) {
         if (var2 >= var3) {
            var5 = null;
            break;
         }

         StateListAnimator.Tuple var4 = this.b.get(var2);
         if (StateSet.stateSetMatches(var4.a, var1)) {
            var5 = var4;
            break;
         }

         var2++;
      }

      if (var5 != this.c) {
         if (this.c != null) {
            this.b();
         }

         this.c = var5;
         if (var5 != null) {
            this.a(var5);
         }
      }
   }

   public void a(int[] var1, ValueAnimator var2) {
      StateListAnimator.Tuple var3 = new StateListAnimator.Tuple(var1, var2);
      var2.addListener(this.d);
      this.b.add(var3);
   }

   static class Tuple {
      final int[] a;
      final ValueAnimator b;

      Tuple(int[] var1, ValueAnimator var2) {
         this.a = var1;
         this.b = var2;
      }
   }
}
