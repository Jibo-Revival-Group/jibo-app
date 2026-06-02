package android.support.transition;

import android.graphics.Matrix;
import android.view.View;
import com.yalantis.ucrop.view.CropImageView;

/* JADX INFO: loaded from: classes.dex */
class ViewUtilsApi14 implements ViewUtilsImpl {

    /* JADX INFO: renamed from: a */
    private float[] f1361a;

    ViewUtilsApi14() {
    }

    @Override // android.support.transition.ViewUtilsImpl
    /* JADX INFO: renamed from: a */
    public ViewOverlayImpl mo1313a(View view) {
        return ViewOverlayApi14.m1290d(view);
    }

    @Override // android.support.transition.ViewUtilsImpl
    /* JADX INFO: renamed from: b */
    public WindowIdImpl mo1317b(View view) {
        return new WindowIdApi14(view.getWindowToken());
    }

    @Override // android.support.transition.ViewUtilsImpl
    /* JADX INFO: renamed from: a */
    public void mo1314a(View view, float f) {
        Float f2 = (Float) view.getTag(R.id.save_non_transition_alpha);
        if (f2 != null) {
            view.setAlpha(f2.floatValue() * f);
        } else {
            view.setAlpha(f);
        }
    }

    @Override // android.support.transition.ViewUtilsImpl
    /* JADX INFO: renamed from: c */
    public float mo1319c(View view) {
        Float f = (Float) view.getTag(R.id.save_non_transition_alpha);
        return f != null ? view.getAlpha() / f.floatValue() : view.getAlpha();
    }

    @Override // android.support.transition.ViewUtilsImpl
    /* JADX INFO: renamed from: d */
    public void mo1321d(View view) {
        if (view.getTag(R.id.save_non_transition_alpha) == null) {
            view.setTag(R.id.save_non_transition_alpha, Float.valueOf(view.getAlpha()));
        }
    }

    @Override // android.support.transition.ViewUtilsImpl
    /* JADX INFO: renamed from: e */
    public void mo1322e(View view) {
        if (view.getVisibility() == 0) {
            view.setTag(R.id.save_non_transition_alpha, null);
        }
    }

    @Override // android.support.transition.ViewUtilsImpl
    /* JADX INFO: renamed from: a */
    public void mo1316a(View view, Matrix matrix) {
        Object parent = view.getParent();
        if (parent instanceof View) {
            mo1316a((View) parent, matrix);
            matrix.preTranslate(-r0.getScrollX(), -r0.getScrollY());
        }
        matrix.preTranslate(view.getLeft(), view.getTop());
        Matrix matrix2 = view.getMatrix();
        if (!matrix2.isIdentity()) {
            matrix.preConcat(matrix2);
        }
    }

    @Override // android.support.transition.ViewUtilsImpl
    /* JADX INFO: renamed from: b */
    public void mo1318b(View view, Matrix matrix) {
        Object parent = view.getParent();
        if (parent instanceof View) {
            mo1318b((View) parent, matrix);
            matrix.postTranslate(r0.getScrollX(), r0.getScrollY());
        }
        matrix.postTranslate(view.getLeft(), view.getTop());
        Matrix matrix2 = view.getMatrix();
        if (!matrix2.isIdentity()) {
            Matrix matrix3 = new Matrix();
            if (matrix2.invert(matrix3)) {
                matrix.postConcat(matrix3);
            }
        }
    }

    @Override // android.support.transition.ViewUtilsImpl
    /* JADX INFO: renamed from: c */
    public void mo1320c(View view, Matrix matrix) {
        if (matrix == null || matrix.isIdentity()) {
            view.setPivotX(view.getWidth() / 2);
            view.setPivotY(view.getHeight() / 2);
            view.setTranslationX(CropImageView.DEFAULT_ASPECT_RATIO);
            view.setTranslationY(CropImageView.DEFAULT_ASPECT_RATIO);
            view.setScaleX(1.0f);
            view.setScaleY(1.0f);
            view.setRotation(CropImageView.DEFAULT_ASPECT_RATIO);
            return;
        }
        float[] fArr = this.f1361a;
        if (fArr == null) {
            fArr = new float[9];
            this.f1361a = fArr;
        }
        matrix.getValues(fArr);
        float f = fArr[3];
        float fSqrt = (fArr[0] < CropImageView.DEFAULT_ASPECT_RATIO ? -1 : 1) * ((float) Math.sqrt(1.0f - (f * f)));
        float degrees = (float) Math.toDegrees(Math.atan2(f, fSqrt));
        float f2 = fArr[0] / fSqrt;
        float f3 = fArr[4] / fSqrt;
        float f4 = fArr[2];
        float f5 = fArr[5];
        view.setPivotX(CropImageView.DEFAULT_ASPECT_RATIO);
        view.setPivotY(CropImageView.DEFAULT_ASPECT_RATIO);
        view.setTranslationX(f4);
        view.setTranslationY(f5);
        view.setRotation(degrees);
        view.setScaleX(f2);
        view.setScaleY(f3);
    }

    @Override // android.support.transition.ViewUtilsImpl
    /* JADX INFO: renamed from: a */
    public void mo1315a(View view, int i, int i2, int i3, int i4) {
        view.setLeft(i);
        view.setTop(i2);
        view.setRight(i3);
        view.setBottom(i4);
    }
}
