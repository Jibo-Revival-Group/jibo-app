package android.support.design.widget;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build.VERSION;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.view.View;
import java.util.ArrayList;

class FloatingActionButtonLollipop extends FloatingActionButtonImpl {
   private InsetDrawable p;

   FloatingActionButtonLollipop(VisibilityAwareImageButton var1, ShadowViewDelegate var2) {
      super(var1, var2);
   }

   @Override
   public float a() {
      return this.n.getElevation();
   }

   @Override
   void a(float var1, float var2) {
      if (VERSION.SDK_INT == 21) {
         if (this.n.isEnabled()) {
            this.n.setElevation(var1);
            if (!this.n.isFocused() && !this.n.isPressed()) {
               this.n.setTranslationZ(0.0F);
            } else {
               this.n.setTranslationZ(var2);
            }
         } else {
            this.n.setElevation(0.0F);
            this.n.setTranslationZ(0.0F);
         }
      } else {
         android.animation.StateListAnimator var3 = new android.animation.StateListAnimator();
         AnimatorSet var4 = new AnimatorSet();
         var4.play(ObjectAnimator.ofFloat(this.n, "elevation", new float[]{var1}).setDuration(0L))
            .with(ObjectAnimator.ofFloat(this.n, View.TRANSLATION_Z, new float[]{var2}).setDuration(100L));
         var4.setInterpolator(a);
         var3.addState(j, var4);
         var4 = new AnimatorSet();
         var4.play(ObjectAnimator.ofFloat(this.n, "elevation", new float[]{var1}).setDuration(0L))
            .with(ObjectAnimator.ofFloat(this.n, View.TRANSLATION_Z, new float[]{var2}).setDuration(100L));
         var4.setInterpolator(a);
         var3.addState(k, var4);
         AnimatorSet var5 = new AnimatorSet();
         ArrayList var7 = new ArrayList();
         var7.add(ObjectAnimator.ofFloat(this.n, "elevation", new float[]{var1}).setDuration(0L));
         if (VERSION.SDK_INT >= 22 && VERSION.SDK_INT <= 24) {
            var7.add(ObjectAnimator.ofFloat(this.n, View.TRANSLATION_Z, new float[]{this.n.getTranslationZ()}).setDuration(100L));
         }

         var7.add(ObjectAnimator.ofFloat(this.n, View.TRANSLATION_Z, new float[]{0.0F}).setDuration(100L));
         var5.playSequentially(var7.toArray(new ObjectAnimator[0]));
         var5.setInterpolator(a);
         var3.addState(l, var5);
         var4 = new AnimatorSet();
         var4.play(ObjectAnimator.ofFloat(this.n, "elevation", new float[]{0.0F}).setDuration(0L))
            .with(ObjectAnimator.ofFloat(this.n, View.TRANSLATION_Z, new float[]{0.0F}).setDuration(0L));
         var4.setInterpolator(a);
         var3.addState(m, var4);
         this.n.setStateListAnimator(var3);
      }

      if (this.o.b()) {
         this.e();
      }
   }

   @Override
   void a(int var1) {
      if (this.e instanceof RippleDrawable) {
         ((RippleDrawable)this.e).setColor(ColorStateList.valueOf(var1));
      } else {
         super.a(var1);
      }
   }

   @Override
   void a(ColorStateList var1, Mode var2, int var3, int var4) {
      this.d = DrawableCompat.g(this.k());
      DrawableCompat.a(this.d, var1);
      if (var2 != null) {
         DrawableCompat.a(this.d, var2);
      }

      Object var5;
      if (var4 > 0) {
         this.f = this.a(var4, var1);
         var5 = new LayerDrawable(new Drawable[]{this.f, this.d});
      } else {
         this.f = null;
         var5 = this.d;
      }

      this.e = new RippleDrawable(ColorStateList.valueOf(var3), (Drawable)var5, null);
      this.g = this.e;
      this.o.a(this.e);
   }

   @Override
   void a(Rect var1) {
      if (this.o.b()) {
         float var2 = this.o.a();
         float var3 = this.a() + this.i;
         int var5 = (int)Math.ceil(ShadowDrawableWrapper.b(var3, var2, false));
         int var4 = (int)Math.ceil(ShadowDrawableWrapper.a(var3, var2, false));
         var1.set(var5, var4, var5, var4);
      } else {
         var1.set(0, 0, 0, 0);
      }
   }

   @Override
   void a(int[] var1) {
   }

   @Override
   void b() {
   }

   @Override
   void b(Rect var1) {
      if (this.o.b()) {
         this.p = new InsetDrawable(this.e, var1.left, var1.top, var1.right, var1.bottom);
         this.o.a(this.p);
      } else {
         this.o.a(this.e);
      }
   }

   @Override
   void d() {
      this.e();
   }

   @Override
   boolean h() {
      return false;
   }

   @Override
   CircularBorderDrawable i() {
      return new CircularBorderDrawableLollipop();
   }

   @Override
   GradientDrawable l() {
      return new FloatingActionButtonLollipop.AlwaysStatefulGradientDrawable();
   }

   static class AlwaysStatefulGradientDrawable extends GradientDrawable {
      public boolean isStateful() {
         return true;
      }
   }
}
