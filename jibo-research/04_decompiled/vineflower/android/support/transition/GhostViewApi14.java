package android.support.transition;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.support.v4.view.ViewCompat;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.FrameLayout;

@SuppressLint("ViewConstructor")
class GhostViewApi14 extends View implements GhostViewImpl {
   final View a;
   ViewGroup b;
   View c;
   int d;
   Matrix e;
   private int f;
   private int g;
   private final Matrix h = new Matrix();
   private final OnPreDrawListener i = new OnPreDrawListener(this) {
      final GhostViewApi14 a;

      {
         this.a = var1;
      }

      public boolean onPreDraw() {
         this.a.e = this.a.a.getMatrix();
         ViewCompat.c(this.a);
         if (this.a.b != null && this.a.c != null) {
            this.a.b.endViewTransition(this.a.c);
            ViewCompat.c(this.a.b);
            this.a.b = null;
            this.a.c = null;
         }

         return true;
      }
   };

   GhostViewApi14(View var1) {
      super(var1.getContext());
      this.a = var1;
      this.setLayerType(2, null);
   }

   static GhostViewApi14 a(View var0) {
      return (GhostViewApi14)var0.getTag(R.id.ghost_view);
   }

   private static void a(View var0, GhostViewApi14 var1) {
      var0.setTag(R.id.ghost_view, var1);
   }

   @Override
   public void a(ViewGroup var1, View var2) {
      this.b = var1;
      this.c = var2;
   }

   protected void onAttachedToWindow() {
      super.onAttachedToWindow();
      a(this.a, this);
      int[] var1 = new int[2];
      int[] var2 = new int[2];
      this.getLocationOnScreen(var1);
      this.a.getLocationOnScreen(var2);
      var2[0] = (int)(var2[0] - this.a.getTranslationX());
      var2[1] = (int)(var2[1] - this.a.getTranslationY());
      this.f = var2[0] - var1[0];
      this.g = var2[1] - var1[1];
      this.a.getViewTreeObserver().addOnPreDrawListener(this.i);
      this.a.setVisibility(4);
   }

   protected void onDetachedFromWindow() {
      this.a.getViewTreeObserver().removeOnPreDrawListener(this.i);
      this.a.setVisibility(0);
      a(this.a, null);
      super.onDetachedFromWindow();
   }

   protected void onDraw(Canvas var1) {
      this.h.set(this.e);
      this.h.postTranslate(this.f, this.g);
      var1.setMatrix(this.h);
      this.a.draw(var1);
   }

   @Override
   public void setVisibility(int var1) {
      super.setVisibility(var1);
      View var2 = this.a;
      byte var3;
      if (var1 == 0) {
         var3 = 4;
      } else {
         var3 = 0;
      }

      var2.setVisibility(var3);
   }

   static class Creator implements GhostViewImpl.Creator {
      private static FrameLayout a(ViewGroup var0) {
         while (true) {
            FrameLayout var2;
            if (!(var0 instanceof FrameLayout)) {
               ViewParent var1 = var0.getParent();
               if (var1 instanceof ViewGroup) {
                  var0 = (ViewGroup)var1;
                  continue;
               }

               var2 = null;
            } else {
               var2 = (FrameLayout)var0;
            }

            return var2;
         }
      }

      @Override
      public GhostViewImpl a(View var1, ViewGroup var2, Matrix var3) {
         GhostViewApi14 var4 = GhostViewApi14.a(var1);
         GhostViewApi14 var6 = var4;
         if (var4 == null) {
            FrameLayout var5 = a(var2);
            if (var5 == null) {
               Object var7 = null;
               return (GhostViewImpl)var7;
            }

            var6 = new GhostViewApi14(var1);
            var5.addView(var6);
         }

         var6.d++;
         return var6;
      }

      @Override
      public void a(View var1) {
         var1 = GhostViewApi14.a(var1);
         if (var1 != null) {
            var1.d--;
            if (var1.d <= 0) {
               ViewParent var2 = var1.getParent();
               if (var2 instanceof ViewGroup) {
                  ViewGroup var4 = (ViewGroup)var2;
                  var4.endViewTransition(var1);
                  var4.removeView(var1);
               }
            }
         }
      }
   }
}
