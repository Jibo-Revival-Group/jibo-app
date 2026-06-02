package android.support.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.graphics.Matrix;
import android.widget.ImageView;

/* JADX INFO: loaded from: classes.dex */
class ImageViewUtilsApi14 implements ImageViewUtilsImpl {
    ImageViewUtilsApi14() {
    }

    @Override // android.support.transition.ImageViewUtilsImpl
    /* JADX INFO: renamed from: a */
    public void mo1173a(ImageView imageView) {
        ImageView.ScaleType scaleType = imageView.getScaleType();
        imageView.setTag(R.id.save_scale_type, scaleType);
        if (scaleType == ImageView.ScaleType.MATRIX) {
            imageView.setTag(R.id.save_image_matrix, imageView.getImageMatrix());
        } else {
            imageView.setScaleType(ImageView.ScaleType.MATRIX);
        }
        imageView.setImageMatrix(MatrixUtils.f1224a);
    }

    @Override // android.support.transition.ImageViewUtilsImpl
    /* JADX INFO: renamed from: a */
    public void mo1175a(ImageView imageView, Matrix matrix) {
        imageView.setImageMatrix(matrix);
    }

    @Override // android.support.transition.ImageViewUtilsImpl
    /* JADX INFO: renamed from: a */
    public void mo1174a(final ImageView imageView, Animator animator) {
        animator.addListener(new AnimatorListenerAdapter() { // from class: android.support.transition.ImageViewUtilsApi14.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator2) {
                ImageView.ScaleType scaleType = (ImageView.ScaleType) imageView.getTag(R.id.save_scale_type);
                imageView.setScaleType(scaleType);
                imageView.setTag(R.id.save_scale_type, null);
                if (scaleType == ImageView.ScaleType.MATRIX) {
                    imageView.setImageMatrix((Matrix) imageView.getTag(R.id.save_image_matrix));
                    imageView.setTag(R.id.save_image_matrix, null);
                }
                animator2.removeListener(this);
            }
        });
    }
}
