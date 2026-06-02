package android.support.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.support.v4.content.res.TypedArrayUtils;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

public class Fade extends Visibility {
   public Fade() {
   }

   public Fade(int var1) {
      this.b(var1);
   }

   public Fade(Context var1, AttributeSet var2) {
      super(var1, var2);
      TypedArray var3 = var1.obtainStyledAttributes(var2, Styleable.f);
      this.b(TypedArrayUtils.a(var3, (XmlResourceParser)var2, "fadingMode", 0, this.p()));
      var3.recycle();
   }

   private static float a(TransitionValues var0, float var1) {
      float var2 = var1;
      if (var0 != null) {
         Float var3 = (Float)var0.a.get("android:fade:transitionAlpha");
         var2 = var1;
         if (var3 != null) {
            var2 = var3;
         }
      }

      return var2;
   }

   private Animator a(View var1, float var2, float var3) {
      ObjectAnimator var5;
      if (var2 == var3) {
         var5 = null;
      } else {
         ViewUtils.a(var1, var2);
         ObjectAnimator var4 = ObjectAnimator.ofFloat(var1, ViewUtils.a, new float[]{var3});
         var4.addListener(new Fade.FadeAnimatorListener(var1));
         this.a(new TransitionListenerAdapter(this, var1) {
            final View a;
            final Fade b;

            {
               this.b = var1;
               this.a = var2x;
            }

            @Override
            public void a(Transition var1) {
               ViewUtils.a(this.a, 1.0F);
               ViewUtils.e(this.a);
               var1.b(this);
            }
         });
         var5 = var4;
      }

      return var5;
   }

   @Override
   public Animator a(ViewGroup var1, View var2, TransitionValues var3, TransitionValues var4) {
      float var5 = 0.0F;
      float var6 = a(var3, 0.0F);
      if (var6 != 1.0F) {
         var5 = var6;
      }

      return this.a(var2, var5, 1.0F);
   }

   @Override
   public void a(TransitionValues var1) {
      super.a(var1);
      var1.a.put("android:fade:transitionAlpha", ViewUtils.c(var1.b));
   }

   @Override
   public Animator b(ViewGroup var1, View var2, TransitionValues var3, TransitionValues var4) {
      ViewUtils.d(var2);
      return this.a(var2, a(var3, 1.0F), 0.0F);
   }

   private static class FadeAnimatorListener extends AnimatorListenerAdapter {
      private final View a;
      private boolean b = false;

      FadeAnimatorListener(View var1) {
         this.a = var1;
      }

      public void onAnimationEnd(Animator var1) {
         ViewUtils.a(this.a, 1.0F);
         if (this.b) {
            this.a.setLayerType(0, null);
         }
      }

      public void onAnimationStart(Animator var1) {
         if (ViewCompat.s(this.a) && this.a.getLayerType() == 0) {
            this.b = true;
            this.a.setLayerType(2, null);
         }
      }
   }
}
