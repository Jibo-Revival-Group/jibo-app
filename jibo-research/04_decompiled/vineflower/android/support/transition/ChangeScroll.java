package android.support.transition;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

public class ChangeScroll extends Transition {
   private static final String[] g = new String[]{"android:changeScroll:x", "android:changeScroll:y"};

   public ChangeScroll() {
   }

   public ChangeScroll(Context var1, AttributeSet var2) {
      super(var1, var2);
   }

   private void d(TransitionValues var1) {
      var1.a.put("android:changeScroll:x", var1.b.getScrollX());
      var1.a.put("android:changeScroll:y", var1.b.getScrollY());
   }

   @Override
   public Animator a(ViewGroup var1, TransitionValues var2, TransitionValues var3) {
      View var8 = null;
      Animator var9 = var8;
      if (var2 != null) {
         if (var3 == null) {
            var9 = var8;
         } else {
            var8 = var3.b;
            int var7 = (Integer)var2.a.get("android:changeScroll:x");
            int var4 = (Integer)var3.a.get("android:changeScroll:x");
            int var6 = (Integer)var2.a.get("android:changeScroll:y");
            int var5 = (Integer)var3.a.get("android:changeScroll:y");
            ObjectAnimator var10;
            if (var7 != var4) {
               var8.setScrollX(var7);
               var10 = ObjectAnimator.ofInt(var8, "scrollX", new int[]{var7, var4});
            } else {
               var10 = null;
            }

            ObjectAnimator var11;
            if (var6 != var5) {
               var8.setScrollY(var6);
               var11 = ObjectAnimator.ofInt(var8, "scrollY", new int[]{var6, var5});
            } else {
               var11 = null;
            }

            var9 = TransitionUtils.a(var10, var11);
         }
      }

      return var9;
   }

   @Override
   public void a(TransitionValues var1) {
      this.d(var1);
   }

   @Override
   public String[] a() {
      return g;
   }

   @Override
   public void b(TransitionValues var1) {
      this.d(var1);
   }
}
