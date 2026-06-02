package android.support.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PointF;
import android.os.Build.VERSION;
import android.support.v4.content.res.TypedArrayUtils;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import org.xmlpull.v1.XmlPullParser;

public class ChangeTransform extends Transition {
   private static final String[] g = new String[]{
      "android:changeTransform:matrix", "android:changeTransform:transforms", "android:changeTransform:parentMatrix"
   };
   private static final Property<ChangeTransform.PathAnimatorMatrix, float[]> h = new Property<ChangeTransform.PathAnimatorMatrix, float[]>(
      float[].class, "nonTranslations"
   ) {
      public void a(ChangeTransform.PathAnimatorMatrix var1, float[] var2) {
         var1.a(var2);
      }

      public float[] a(ChangeTransform.PathAnimatorMatrix var1) {
         return null;
      }
   };
   private static final Property<ChangeTransform.PathAnimatorMatrix, PointF> i = new Property<ChangeTransform.PathAnimatorMatrix, PointF>(
      PointF.class, "translations"
   ) {
      public PointF a(ChangeTransform.PathAnimatorMatrix var1) {
         return null;
      }

      public void a(ChangeTransform.PathAnimatorMatrix var1, PointF var2) {
         var1.a(var2);
      }
   };
   private static final boolean j;
   private boolean k = true;
   private boolean l = true;
   private Matrix m = new Matrix();

   static {
      boolean var0 = true;
      if (VERSION.SDK_INT < 21) {
         var0 = false;
      }

      j = var0;
   }

   public ChangeTransform() {
   }

   public ChangeTransform(Context var1, AttributeSet var2) {
      super(var1, var2);
      TypedArray var3 = var1.obtainStyledAttributes(var2, Styleable.g);
      this.k = TypedArrayUtils.a(var3, (XmlPullParser)var2, "reparentWithOverlay", 1, true);
      this.l = TypedArrayUtils.a(var3, (XmlPullParser)var2, "reparent", 0, true);
      var3.recycle();
   }

   private ObjectAnimator a(TransitionValues var1, TransitionValues var2, boolean var3) {
      Matrix var5 = (Matrix)var1.a.get("android:changeTransform:matrix");
      Matrix var9 = (Matrix)var2.a.get("android:changeTransform:matrix");
      Matrix var4 = var5;
      if (var5 == null) {
         var4 = MatrixUtils.a;
      }

      if (var9 == null) {
         var9 = MatrixUtils.a;
      }

      ObjectAnimator var10;
      if (var4.equals(var9)) {
         var10 = null;
      } else {
         ChangeTransform.Transforms var16 = (ChangeTransform.Transforms)var2.a.get("android:changeTransform:transforms");
         View var6 = var2.b;
         g(var6);
         float[] var12 = new float[9];
         var4.getValues(var12);
         float[] var8 = new float[9];
         var9.getValues(var8);
         ChangeTransform.PathAnimatorMatrix var15 = new ChangeTransform.PathAnimatorMatrix(var6, var12);
         PropertyValuesHolder var7 = PropertyValuesHolder.ofObject(h, new FloatArrayEvaluator(new float[9]), new float[][]{var12, var8});
         Path var13 = this.l().a(var12[2], var12[5], var8[2], var8[5]);
         ObjectAnimator var14 = ObjectAnimator.ofPropertyValuesHolder(var15, new PropertyValuesHolder[]{var7, PropertyValuesHolderUtils.a(i, var13)});
         AnimatorListenerAdapter var11 = new AnimatorListenerAdapter(this, var3, var9, var6, var16, var15) {
            final boolean a;
            final Matrix b;
            final View c;
            final ChangeTransform.Transforms d;
            final ChangeTransform.PathAnimatorMatrix e;
            final ChangeTransform f;
            private boolean g;
            private Matrix h;

            {
               this.f = var1;
               this.a = var2x;
               this.b = var3x;
               this.c = var4x;
               this.d = var5x;
               this.e = var6x;
               this.h = new Matrix();
            }

            private void a(Matrix var1) {
               this.h.set(var1);
               this.c.setTag(R.id.transition_transform, this.h);
               this.d.a(this.c);
            }

            public void onAnimationCancel(Animator var1) {
               this.g = true;
            }

            public void onAnimationEnd(Animator var1) {
               if (!this.g) {
                  if (this.a && this.f.k) {
                     this.a(this.b);
                  } else {
                     this.c.setTag(R.id.transition_transform, null);
                     this.c.setTag(R.id.parent_matrix, null);
                  }
               }

               ViewUtils.c(this.c, null);
               this.d.a(this.c);
            }

            public void onAnimationPause(Animator var1) {
               this.a(this.e.a());
            }

            public void onAnimationResume(Animator var1) {
               ChangeTransform.g(this.c);
            }
         };
         var14.addListener(var11);
         AnimatorUtils.a(var14, var11);
         var10 = var14;
      }

      return var10;
   }

   private boolean a(ViewGroup var1, ViewGroup var2) {
      boolean var3 = true;
      if (this.b(var1) && this.b(var2)) {
         TransitionValues var4 = this.b(var1, true);
         if (var4 != null) {
            if (var2 != var4.b) {
               var3 = false;
            }
         } else {
            var3 = false;
         }
      } else if (var1 != var2) {
         var3 = false;
      }

      return var3;
   }

   private void b(TransitionValues var1, TransitionValues var2) {
      Matrix var4 = (Matrix)var2.a.get("android:changeTransform:parentMatrix");
      var2.b.setTag(R.id.parent_matrix, var4);
      Matrix var3 = this.m;
      var3.reset();
      var4.invert(var3);
      Matrix var5 = (Matrix)var1.a.get("android:changeTransform:matrix");
      if (var5 == null) {
         var5 = new Matrix();
         var1.a.put("android:changeTransform:matrix", var5);
      }

      var5.postConcat((Matrix)var1.a.get("android:changeTransform:parentMatrix"));
      var5.postConcat(var3);
   }

   private static void b(View var0, float var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8) {
      var0.setTranslationX(var1);
      var0.setTranslationY(var2);
      ViewCompat.b(var0, var3);
      var0.setScaleX(var4);
      var0.setScaleY(var5);
      var0.setRotationX(var6);
      var0.setRotationY(var7);
      var0.setRotation(var8);
   }

   private void b(ViewGroup var1, TransitionValues var2, TransitionValues var3) {
      View var4 = var3.b;
      Matrix var5 = new Matrix((Matrix)var3.a.get("android:changeTransform:parentMatrix"));
      ViewUtils.b(var1, var5);
      GhostViewImpl var7 = GhostViewUtils.a(var4, var1, var5);
      if (var7 != null) {
         var7.a((ViewGroup)var2.a.get("android:changeTransform:parent"), var2.b);
         Transition var6 = this;

         while (var6.d != null) {
            var6 = var6.d;
         }

         var6.a(new ChangeTransform.GhostListener(var4, var7));
         if (j) {
            if (var2.b != var3.b) {
               ViewUtils.a(var2.b, 0.0F);
            }

            ViewUtils.a(var4, 1.0F);
         }
      }
   }

   private void d(TransitionValues var1) {
      View var3 = var1.b;
      if (var3.getVisibility() != 8) {
         var1.a.put("android:changeTransform:parent", var3.getParent());
         ChangeTransform.Transforms var2 = new ChangeTransform.Transforms(var3);
         var1.a.put("android:changeTransform:transforms", var2);
         Matrix var5 = var3.getMatrix();
         Matrix var6;
         if (var5 != null && !var5.isIdentity()) {
            var6 = new Matrix(var5);
         } else {
            var6 = null;
         }

         var1.a.put("android:changeTransform:matrix", var6);
         if (this.l) {
            Matrix var7 = new Matrix();
            ViewGroup var4 = (ViewGroup)var3.getParent();
            ViewUtils.a(var4, var7);
            var7.preTranslate(-var4.getScrollX(), -var4.getScrollY());
            var1.a.put("android:changeTransform:parentMatrix", var7);
            var1.a.put("android:changeTransform:intermediateMatrix", var3.getTag(R.id.transition_transform));
            var1.a.put("android:changeTransform:intermediateParentMatrix", var3.getTag(R.id.parent_matrix));
         }
      }
   }

   private static void g(View var0) {
      b(var0, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F);
   }

   @Override
   public Animator a(ViewGroup var1, TransitionValues var2, TransitionValues var3) {
      ObjectAnimator var7;
      if (var2 != null && var3 != null && var2.a.containsKey("android:changeTransform:parent") && var3.a.containsKey("android:changeTransform:parent")) {
         ViewGroup var6 = (ViewGroup)var2.a.get("android:changeTransform:parent");
         ViewGroup var5 = (ViewGroup)var3.a.get("android:changeTransform:parent");
         boolean var4;
         if (this.l && !this.a(var6, var5)) {
            var4 = true;
         } else {
            var4 = false;
         }

         Matrix var8 = (Matrix)var2.a.get("android:changeTransform:intermediateMatrix");
         if (var8 != null) {
            var2.a.put("android:changeTransform:matrix", var8);
         }

         Matrix var9 = (Matrix)var2.a.get("android:changeTransform:intermediateParentMatrix");
         if (var9 != null) {
            var2.a.put("android:changeTransform:parentMatrix", var9);
         }

         if (var4) {
            this.b(var2, var3);
         }

         ObjectAnimator var10 = this.a(var2, var3, var4);
         if (var4 && var10 != null && this.k) {
            this.b(var1, var2, var3);
         } else if (!j) {
            var6.endViewTransition(var2.b);
         }

         var7 = var10;
      } else {
         var7 = null;
      }

      return var7;
   }

   @Override
   public void a(TransitionValues var1) {
      this.d(var1);
      if (!j) {
         ((ViewGroup)var1.b.getParent()).startViewTransition(var1.b);
      }
   }

   @Override
   public String[] a() {
      return g;
   }

   @Override
   public void b(TransitionValues var1) {
      this.d(var1);
   }

   private static class GhostListener extends TransitionListenerAdapter {
      private View a;
      private GhostViewImpl b;

      GhostListener(View var1, GhostViewImpl var2) {
         this.a = var1;
         this.b = var2;
      }

      @Override
      public void a(Transition var1) {
         var1.b(this);
         GhostViewUtils.a(this.a);
         this.a.setTag(R.id.transition_transform, null);
         this.a.setTag(R.id.parent_matrix, null);
      }

      @Override
      public void b(Transition var1) {
         this.b.setVisibility(4);
      }

      @Override
      public void c(Transition var1) {
         this.b.setVisibility(0);
      }
   }

   private static class PathAnimatorMatrix {
      private final Matrix a = new Matrix();
      private final View b;
      private final float[] c;
      private float d;
      private float e;

      PathAnimatorMatrix(View var1, float[] var2) {
         this.b = var1;
         this.c = (float[])var2.clone();
         this.d = this.c[2];
         this.e = this.c[5];
         this.b();
      }

      private void b() {
         this.c[2] = this.d;
         this.c[5] = this.e;
         this.a.setValues(this.c);
         ViewUtils.c(this.b, this.a);
      }

      Matrix a() {
         return this.a;
      }

      void a(PointF var1) {
         this.d = var1.x;
         this.e = var1.y;
         this.b();
      }

      void a(float[] var1) {
         System.arraycopy(var1, 0, this.c, 0, var1.length);
         this.b();
      }
   }

   private static class Transforms {
      final float a;
      final float b;
      final float c;
      final float d;
      final float e;
      final float f;
      final float g;
      final float h;

      Transforms(View var1) {
         this.a = var1.getTranslationX();
         this.b = var1.getTranslationY();
         this.c = ViewCompat.n(var1);
         this.d = var1.getScaleX();
         this.e = var1.getScaleY();
         this.f = var1.getRotationX();
         this.g = var1.getRotationY();
         this.h = var1.getRotation();
      }

      public void a(View var1) {
         ChangeTransform.b(var1, this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h);
      }

      @Override
      public boolean equals(Object var1) {
         boolean var3 = false;
         boolean var2;
         if (!(var1 instanceof ChangeTransform.Transforms)) {
            var2 = var3;
         } else {
            var1 = var1;
            var2 = var3;
            if (var1.a == this.a) {
               var2 = var3;
               if (var1.b == this.b) {
                  var2 = var3;
                  if (var1.c == this.c) {
                     var2 = var3;
                     if (var1.d == this.d) {
                        var2 = var3;
                        if (var1.e == this.e) {
                           var2 = var3;
                           if (var1.f == this.f) {
                              var2 = var3;
                              if (var1.g == this.g) {
                                 var2 = var3;
                                 if (var1.h == this.h) {
                                    var2 = true;
                                 }
                              }
                           }
                        }
                     }
                  }
               }
            }
         }

         return var2;
      }

      @Override
      public int hashCode() {
         int var8 = 0;
         int var1;
         if (this.a != 0.0F) {
            var1 = Float.floatToIntBits(this.a);
         } else {
            var1 = 0;
         }

         int var2;
         if (this.b != 0.0F) {
            var2 = Float.floatToIntBits(this.b);
         } else {
            var2 = 0;
         }

         int var3;
         if (this.c != 0.0F) {
            var3 = Float.floatToIntBits(this.c);
         } else {
            var3 = 0;
         }

         int var4;
         if (this.d != 0.0F) {
            var4 = Float.floatToIntBits(this.d);
         } else {
            var4 = 0;
         }

         int var5;
         if (this.e != 0.0F) {
            var5 = Float.floatToIntBits(this.e);
         } else {
            var5 = 0;
         }

         int var6;
         if (this.f != 0.0F) {
            var6 = Float.floatToIntBits(this.f);
         } else {
            var6 = 0;
         }

         int var7;
         if (this.g != 0.0F) {
            var7 = Float.floatToIntBits(this.g);
         } else {
            var7 = 0;
         }

         if (this.h != 0.0F) {
            var8 = Float.floatToIntBits(this.h);
         }

         return (var7 + (var6 + (var5 + (var4 + (var3 + (var2 + var1 * 31) * 31) * 31) * 31) * 31) * 31) * 31 + var8;
      }
   }
}
