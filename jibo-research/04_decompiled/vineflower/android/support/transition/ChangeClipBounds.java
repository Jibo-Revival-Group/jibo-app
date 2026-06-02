package android.support.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Rect;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

public class ChangeClipBounds extends Transition {
   private static final String[] g = new String[]{"android:clipBounds:clip"};

   public ChangeClipBounds() {
   }

   public ChangeClipBounds(Context var1, AttributeSet var2) {
      super(var1, var2);
   }

   private void d(TransitionValues var1) {
      View var3 = var1.b;
      if (var3.getVisibility() != 8) {
         Rect var2 = ViewCompat.A(var3);
         var1.a.put("android:clipBounds:clip", var2);
         if (var2 == null) {
            var2 = new Rect(0, 0, var3.getWidth(), var3.getHeight());
            var1.a.put("android:clipBounds:bounds", var2);
         }
      }
   }

   @Override
   public Animator a(ViewGroup var1, TransitionValues var2, TransitionValues var3) {
      ObjectAnimator var7;
      if (var2 != null && var3 != null && var2.a.containsKey("android:clipBounds:clip") && var3.a.containsKey("android:clipBounds:clip")) {
         Rect var5 = (Rect)var2.a.get("android:clipBounds:clip");
         Rect var6 = (Rect)var3.a.get("android:clipBounds:clip");
         boolean var4;
         if (var6 == null) {
            var4 = true;
         } else {
            var4 = false;
         }

         if (var5 == null && var6 == null) {
            var7 = null;
         } else {
            Rect var8;
            Rect var9;
            if (var5 == null) {
               var9 = (Rect)var2.a.get("android:clipBounds:bounds");
               var8 = var6;
            } else {
               var9 = var5;
               var8 = var6;
               if (var6 == null) {
                  var8 = (Rect)var3.a.get("android:clipBounds:bounds");
                  var9 = var5;
               }
            }

            if (var9.equals(var8)) {
               var7 = null;
            } else {
               ViewCompat.a(var3.b, var9);
               RectEvaluator var11 = new RectEvaluator(new Rect());
               ObjectAnimator var10 = ObjectAnimator.ofObject(var3.b, ViewUtils.b, var11, new Rect[]{var9, var8});
               var7 = var10;
               if (var4) {
                  var10.addListener(new AnimatorListenerAdapter(this, var3.b) {
                     final View a;
                     final ChangeClipBounds b;

                     {
                        this.b = var1;
                        this.a = var2x;
                     }

                     public void onAnimationEnd(Animator var1) {
                        ViewCompat.a(this.a, (Rect)null);
                     }
                  });
                  var7 = var10;
               }
            }
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
   public String[] a() {
      return g;
   }

   @Override
   public void b(TransitionValues var1) {
      this.d(var1);
   }
}
