package android.support.transition;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.TypedArray;
import android.support.v4.content.res.TypedArrayUtils;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import org.xmlpull.v1.XmlPullParser;

public class Slide extends Visibility {
   private static final TimeInterpolator g = new DecelerateInterpolator();
   private static final TimeInterpolator h = new AccelerateInterpolator();
   private static final Slide.CalculateSlide k = new Slide.CalculateSlideHorizontal() {
      @Override
      public float a(ViewGroup var1, View var2) {
         return var2.getTranslationX() - var1.getWidth();
      }
   };
   private static final Slide.CalculateSlide l = new Slide.CalculateSlideHorizontal() {
      @Override
      public float a(ViewGroup var1, View var2) {
         boolean var4 = true;
         if (ViewCompat.e(var1) != 1) {
            var4 = false;
         }

         float var3;
         if (var4) {
            var3 = var2.getTranslationX() + var1.getWidth();
         } else {
            var3 = var2.getTranslationX() - var1.getWidth();
         }

         return var3;
      }
   };
   private static final Slide.CalculateSlide m = new Slide.CalculateSlideVertical() {
      @Override
      public float b(ViewGroup var1, View var2) {
         return var2.getTranslationY() - var1.getHeight();
      }
   };
   private static final Slide.CalculateSlide n = new Slide.CalculateSlideHorizontal() {
      @Override
      public float a(ViewGroup var1, View var2) {
         return var2.getTranslationX() + var1.getWidth();
      }
   };
   private static final Slide.CalculateSlide o = new Slide.CalculateSlideHorizontal() {
      @Override
      public float a(ViewGroup var1, View var2) {
         boolean var4 = true;
         if (ViewCompat.e(var1) != 1) {
            var4 = false;
         }

         float var3;
         if (var4) {
            var3 = var2.getTranslationX() - var1.getWidth();
         } else {
            var3 = var2.getTranslationX() + var1.getWidth();
         }

         return var3;
      }
   };
   private static final Slide.CalculateSlide p = new Slide.CalculateSlideVertical() {
      @Override
      public float b(ViewGroup var1, View var2) {
         return var2.getTranslationY() + var1.getHeight();
      }
   };
   private Slide.CalculateSlide i = p;
   private int j = 80;

   public Slide() {
      this.a(80);
   }

   public Slide(Context var1, AttributeSet var2) {
      super(var1, var2);
      TypedArray var4 = var1.obtainStyledAttributes(var2, Styleable.h);
      int var3 = TypedArrayUtils.a(var4, (XmlPullParser)var2, "slideEdge", 0, 80);
      var4.recycle();
      this.a(var3);
   }

   private void d(TransitionValues var1) {
      View var3 = var1.b;
      int[] var2 = new int[2];
      var3.getLocationOnScreen(var2);
      var1.a.put("android:slide:screenPosition", var2);
   }

   @Override
   public Animator a(ViewGroup var1, View var2, TransitionValues var3, TransitionValues var4) {
      Animator var9;
      if (var4 == null) {
         var9 = null;
      } else {
         int[] var10 = (int[])var4.a.get("android:slide:screenPosition");
         float var5 = var2.getTranslationX();
         float var7 = var2.getTranslationY();
         float var6 = this.i.a(var1, var2);
         float var8 = this.i.b(var1, var2);
         var9 = TranslationAnimationCreator.a(var2, var4, var10[0], var10[1], var6, var8, var5, var7, g);
      }

      return var9;
   }

   public void a(int var1) {
      switch (var1) {
         case 3:
            this.i = k;
            break;
         case 5:
            this.i = n;
            break;
         case 48:
            this.i = m;
            break;
         case 80:
            this.i = p;
            break;
         case 8388611:
            this.i = l;
            break;
         case 8388613:
            this.i = o;
            break;
         default:
            throw new IllegalArgumentException("Invalid slide direction");
      }

      this.j = var1;
      SidePropagation var2 = new SidePropagation();
      var2.a(var1);
      this.a(var2);
   }

   @Override
   public void a(TransitionValues var1) {
      super.a(var1);
      this.d(var1);
   }

   @Override
   public Animator b(ViewGroup var1, View var2, TransitionValues var3, TransitionValues var4) {
      Animator var9;
      if (var3 == null) {
         var9 = null;
      } else {
         int[] var10 = (int[])var3.a.get("android:slide:screenPosition");
         float var5 = var2.getTranslationX();
         float var6 = var2.getTranslationY();
         float var8 = this.i.a(var1, var2);
         float var7 = this.i.b(var1, var2);
         var9 = TranslationAnimationCreator.a(var2, var3, var10[0], var10[1], var5, var6, var8, var7, h);
      }

      return var9;
   }

   @Override
   public void b(TransitionValues var1) {
      super.b(var1);
      this.d(var1);
   }

   private interface CalculateSlide {
      float a(ViewGroup var1, View var2);

      float b(ViewGroup var1, View var2);
   }

   private abstract static class CalculateSlideHorizontal implements Slide.CalculateSlide {
      private CalculateSlideHorizontal() {
      }

      @Override
      public float b(ViewGroup var1, View var2) {
         return var2.getTranslationY();
      }
   }

   private abstract static class CalculateSlideVertical implements Slide.CalculateSlide {
      private CalculateSlideVertical() {
      }

      @Override
      public float a(ViewGroup var1, View var2) {
         return var2.getTranslationX();
      }
   }
}
