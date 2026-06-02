package android.support.transition;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import java.util.Map;

public class ChangeImageTransform extends Transition {
   private static final String[] g = new String[]{"android:changeImageTransform:matrix", "android:changeImageTransform:bounds"};
   private static final TypeEvaluator<Matrix> h = new TypeEvaluator<Matrix>() {
      public Matrix a(float var1, Matrix var2, Matrix var3) {
         return null;
      }
   };
   private static final Property<ImageView, Matrix> i = new Property<ImageView, Matrix>(Matrix.class, "animatedTransform") {
      public Matrix a(ImageView var1) {
         return null;
      }

      public void a(ImageView var1, Matrix var2) {
         ImageViewUtils.a(var1, var2);
      }
   };

   public ChangeImageTransform() {
   }

   public ChangeImageTransform(Context var1, AttributeSet var2) {
      super(var1, var2);
   }

   private ObjectAnimator a(ImageView var1) {
      return ObjectAnimator.ofObject(var1, i, h, new Matrix[]{null, null});
   }

   private ObjectAnimator a(ImageView var1, Matrix var2, Matrix var3) {
      return ObjectAnimator.ofObject(var1, i, new TransitionUtils.MatrixEvaluator(), new Matrix[]{var2, var3});
   }

   private static Matrix b(ImageView var0) {
      Matrix var1;
      switch (<unrepresentable>.a[var0.getScaleType().ordinal()]) {
         case 1:
            var1 = c(var0);
            break;
         case 2:
            var1 = d(var0);
            break;
         default:
            var1 = new Matrix(var0.getImageMatrix());
      }

      return var1;
   }

   private static Matrix c(ImageView var0) {
      Drawable var2 = var0.getDrawable();
      Matrix var1 = new Matrix();
      var1.postScale((float)var0.getWidth() / var2.getIntrinsicWidth(), (float)var0.getHeight() / var2.getIntrinsicHeight());
      return var1;
   }

   private static Matrix d(ImageView var0) {
      Drawable var8 = var0.getDrawable();
      int var7 = var8.getIntrinsicWidth();
      int var5 = var0.getWidth();
      float var1 = (float)var5 / var7;
      int var6 = var8.getIntrinsicHeight();
      int var4 = var0.getHeight();
      var1 = Math.max(var1, (float)var4 / var6);
      float var2 = var7;
      float var3 = var6;
      var5 = Math.round((var5 - var2 * var1) / 2.0F);
      var4 = Math.round((var4 - var3 * var1) / 2.0F);
      Matrix var9 = new Matrix();
      var9.postScale(var1, var1);
      var9.postTranslate(var5, var4);
      return var9;
   }

   private void d(TransitionValues var1) {
      View var3 = var1.b;
      if (var3 instanceof ImageView && var3.getVisibility() == 0) {
         ImageView var2 = (ImageView)var3;
         if (var2.getDrawable() != null) {
            Map var4 = var1.a;
            var4.put("android:changeImageTransform:bounds", new Rect(var3.getLeft(), var3.getTop(), var3.getRight(), var3.getBottom()));
            var4.put("android:changeImageTransform:matrix", b(var2));
         }
      }
   }

   @Override
   public Animator a(ViewGroup var1, TransitionValues var2, TransitionValues var3) {
      ObjectAnimator var8;
      if (var2 != null && var3 != null) {
         Rect var9 = (Rect)var2.a.get("android:changeImageTransform:bounds");
         Rect var7 = (Rect)var3.a.get("android:changeImageTransform:bounds");
         if (var9 != null && var7 != null) {
            Matrix var12 = (Matrix)var2.a.get("android:changeImageTransform:matrix");
            Matrix var6 = (Matrix)var3.a.get("android:changeImageTransform:matrix");
            boolean var4;
            if ((var12 != null || var6 != null) && (var12 == null || !var12.equals(var6))) {
               var4 = 0;
            } else {
               var4 = 1;
            }

            if (var9.equals(var7) && var4) {
               var8 = null;
            } else {
               ImageView var14 = (ImageView)var3.b;
               Drawable var10 = var14.getDrawable();
               var4 = var10.getIntrinsicWidth();
               int var5 = var10.getIntrinsicHeight();
               ImageViewUtils.a(var14);
               if (var4 != 0 && var5 != 0) {
                  Matrix var11 = var12;
                  if (var12 == null) {
                     var11 = MatrixUtils.a;
                  }

                  Matrix var13 = var6;
                  if (var6 == null) {
                     var13 = MatrixUtils.a;
                  }

                  i.set(var14, var11);
                  var8 = this.a(var14, var11, var13);
               } else {
                  var8 = this.a(var14);
               }

               ImageViewUtils.a(var14, var8);
            }
         } else {
            var8 = null;
         }
      } else {
         var8 = null;
      }

      return var8;
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
