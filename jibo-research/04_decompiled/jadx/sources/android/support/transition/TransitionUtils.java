package android.support.transition;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.TypeEvaluator;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.yalantis.ucrop.view.CropImageView;

/* JADX INFO: loaded from: classes.dex */
class TransitionUtils {
    /* JADX INFO: renamed from: a */
    static View m1275a(ViewGroup viewGroup, View view, View view2) {
        Matrix matrix = new Matrix();
        matrix.setTranslate(-view2.getScrollX(), -view2.getScrollY());
        ViewUtils.m1302a(view, matrix);
        ViewUtils.m1304b(viewGroup, matrix);
        RectF rectF = new RectF(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, view.getWidth(), view.getHeight());
        matrix.mapRect(rectF);
        int iRound = Math.round(rectF.left);
        int iRound2 = Math.round(rectF.top);
        int iRound3 = Math.round(rectF.right);
        int iRound4 = Math.round(rectF.bottom);
        ImageView imageView = new ImageView(view.getContext());
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        Bitmap bitmapM1274a = m1274a(view, matrix, rectF);
        if (bitmapM1274a != null) {
            imageView.setImageBitmap(bitmapM1274a);
        }
        imageView.measure(View.MeasureSpec.makeMeasureSpec(iRound3 - iRound, 1073741824), View.MeasureSpec.makeMeasureSpec(iRound4 - iRound2, 1073741824));
        imageView.layout(iRound, iRound2, iRound3, iRound4);
        return imageView;
    }

    /* JADX INFO: renamed from: a */
    private static Bitmap m1274a(View view, Matrix matrix, RectF rectF) {
        int iRound = Math.round(rectF.width());
        int iRound2 = Math.round(rectF.height());
        if (iRound <= 0 || iRound2 <= 0) {
            return null;
        }
        float fMin = Math.min(1.0f, 1048576.0f / (iRound * iRound2));
        matrix.postTranslate(-rectF.left, -rectF.top);
        matrix.postScale(fMin, fMin);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap((int) (iRound * fMin), (int) (iRound2 * fMin), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        canvas.concat(matrix);
        view.draw(canvas);
        return bitmapCreateBitmap;
    }

    /* JADX INFO: renamed from: a */
    static Animator m1273a(Animator animator, Animator animator2) {
        if (animator != null) {
            if (animator2 == null) {
                return animator;
            }
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(animator, animator2);
            return animatorSet;
        }
        return animator2;
    }

    static class MatrixEvaluator implements TypeEvaluator<Matrix> {

        /* JADX INFO: renamed from: a */
        final float[] f1320a = new float[9];

        /* JADX INFO: renamed from: b */
        final float[] f1321b = new float[9];

        /* JADX INFO: renamed from: c */
        final Matrix f1322c = new Matrix();

        MatrixEvaluator() {
        }

        @Override // android.animation.TypeEvaluator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Matrix evaluate(float f, Matrix matrix, Matrix matrix2) {
            matrix.getValues(this.f1320a);
            matrix2.getValues(this.f1321b);
            for (int i = 0; i < 9; i++) {
                this.f1321b[i] = ((this.f1321b[i] - this.f1320a[i]) * f) + this.f1320a[i];
            }
            this.f1322c.setValues(this.f1321b);
            return this.f1322c;
        }
    }
}
