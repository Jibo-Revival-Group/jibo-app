package android.support.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.graphics.Matrix;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

class ImageViewUtilsApi14 implements ImageViewUtilsImpl {
   @Override
   public void a(ImageView var1) {
      ScaleType var2 = var1.getScaleType();
      var1.setTag(R.id.save_scale_type, var2);
      if (var2 == ScaleType.MATRIX) {
         var1.setTag(R.id.save_image_matrix, var1.getImageMatrix());
      } else {
         var1.setScaleType(ScaleType.MATRIX);
      }

      var1.setImageMatrix(MatrixUtils.a);
   }

   @Override
   public void a(ImageView var1, Animator var2) {
      var2.addListener(new AnimatorListenerAdapter(this, var1) {
         final ImageView a;
         final ImageViewUtilsApi14 b;

         {
            this.b = var1;
            this.a = var2x;
         }

         public void onAnimationEnd(Animator var1) {
            ScaleType var2x = (ScaleType)this.a.getTag(R.id.save_scale_type);
            this.a.setScaleType(var2x);
            this.a.setTag(R.id.save_scale_type, null);
            if (var2x == ScaleType.MATRIX) {
               this.a.setImageMatrix((Matrix)this.a.getTag(R.id.save_image_matrix));
               this.a.setTag(R.id.save_image_matrix, null);
            }

            var1.removeListener(this);
         }
      });
   }

   @Override
   public void a(ImageView var1, Matrix var2) {
      var1.setImageMatrix(var2);
   }
}
