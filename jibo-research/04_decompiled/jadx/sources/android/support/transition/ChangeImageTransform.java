package android.support.transition;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.transition.TransitionUtils;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class ChangeImageTransform extends Transition {

    /* JADX INFO: renamed from: g */
    private static final String[] f1143g = {"android:changeImageTransform:matrix", "android:changeImageTransform:bounds"};

    /* JADX INFO: renamed from: h */
    private static final TypeEvaluator<Matrix> f1144h = new TypeEvaluator<Matrix>() { // from class: android.support.transition.ChangeImageTransform.1
        @Override // android.animation.TypeEvaluator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Matrix evaluate(float f, Matrix matrix, Matrix matrix2) {
            return null;
        }
    };

    /* JADX INFO: renamed from: i */
    private static final Property<ImageView, Matrix> f1145i = new Property<ImageView, Matrix>(Matrix.class, "animatedTransform") { // from class: android.support.transition.ChangeImageTransform.2
        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void set(ImageView imageView, Matrix matrix) {
            ImageViewUtils.m1172a(imageView, matrix);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Matrix get(ImageView imageView) {
            return null;
        }
    };

    public ChangeImageTransform() {
    }

    public ChangeImageTransform(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* JADX INFO: renamed from: d */
    private void m1100d(TransitionValues transitionValues) {
        View view = transitionValues.f1324b;
        if ((view instanceof ImageView) && view.getVisibility() == 0) {
            ImageView imageView = (ImageView) view;
            if (imageView.getDrawable() != null) {
                Map<String, Object> map = transitionValues.f1323a;
                map.put("android:changeImageTransform:bounds", new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
                map.put("android:changeImageTransform:matrix", m1097b(imageView));
            }
        }
    }

    @Override // android.support.transition.Transition
    /* JADX INFO: renamed from: a */
    public void mo406a(TransitionValues transitionValues) {
        m1100d(transitionValues);
    }

    @Override // android.support.transition.Transition
    /* JADX INFO: renamed from: b */
    public void mo407b(TransitionValues transitionValues) {
        m1100d(transitionValues);
    }

    @Override // android.support.transition.Transition
    /* JADX INFO: renamed from: a */
    public String[] mo1075a() {
        return f1143g;
    }

    @Override // android.support.transition.Transition
    /* JADX INFO: renamed from: a */
    public Animator mo405a(ViewGroup viewGroup, TransitionValues transitionValues, TransitionValues transitionValues2) {
        ObjectAnimator objectAnimatorM1095a;
        if (transitionValues == null || transitionValues2 == null) {
            return null;
        }
        Rect rect = (Rect) transitionValues.f1323a.get("android:changeImageTransform:bounds");
        Rect rect2 = (Rect) transitionValues2.f1323a.get("android:changeImageTransform:bounds");
        if (rect == null || rect2 == null) {
            return null;
        }
        Matrix matrix = (Matrix) transitionValues.f1323a.get("android:changeImageTransform:matrix");
        Matrix matrix2 = (Matrix) transitionValues2.f1323a.get("android:changeImageTransform:matrix");
        boolean z = (matrix == null && matrix2 == null) || (matrix != null && matrix.equals(matrix2));
        if (rect.equals(rect2) && z) {
            return null;
        }
        ImageView imageView = (ImageView) transitionValues2.f1324b;
        Drawable drawable = imageView.getDrawable();
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        ImageViewUtils.m1170a(imageView);
        if (intrinsicWidth == 0 || intrinsicHeight == 0) {
            objectAnimatorM1095a = m1095a(imageView);
        } else {
            if (matrix == null) {
                matrix = MatrixUtils.f1224a;
            }
            if (matrix2 == null) {
                matrix2 = MatrixUtils.f1224a;
            }
            f1145i.set(imageView, matrix);
            objectAnimatorM1095a = m1096a(imageView, matrix, matrix2);
        }
        ImageViewUtils.m1171a(imageView, objectAnimatorM1095a);
        return objectAnimatorM1095a;
    }

    /* JADX INFO: renamed from: a */
    private ObjectAnimator m1095a(ImageView imageView) {
        return ObjectAnimator.ofObject(imageView, (Property<ImageView, V>) f1145i, (TypeEvaluator) f1144h, (Object[]) new Matrix[]{null, null});
    }

    /* JADX INFO: renamed from: a */
    private ObjectAnimator m1096a(ImageView imageView, Matrix matrix, Matrix matrix2) {
        return ObjectAnimator.ofObject(imageView, (Property<ImageView, V>) f1145i, (TypeEvaluator) new TransitionUtils.MatrixEvaluator(), (Object[]) new Matrix[]{matrix, matrix2});
    }

    /* JADX INFO: renamed from: android.support.transition.ChangeImageTransform$3 */
    static /* synthetic */ class C00853 {

        /* JADX INFO: renamed from: a */
        static final /* synthetic */ int[] f1146a = new int[ImageView.ScaleType.values().length];

        static {
            try {
                f1146a[ImageView.ScaleType.FIT_XY.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f1146a[ImageView.ScaleType.CENTER_CROP.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    /* JADX INFO: renamed from: b */
    private static Matrix m1097b(ImageView imageView) {
        switch (C00853.f1146a[imageView.getScaleType().ordinal()]) {
            case 1:
                return m1098c(imageView);
            case 2:
                return m1099d(imageView);
            default:
                return new Matrix(imageView.getImageMatrix());
        }
    }

    /* JADX INFO: renamed from: c */
    private static Matrix m1098c(ImageView imageView) {
        Drawable drawable = imageView.getDrawable();
        Matrix matrix = new Matrix();
        matrix.postScale(imageView.getWidth() / drawable.getIntrinsicWidth(), imageView.getHeight() / drawable.getIntrinsicHeight());
        return matrix;
    }

    /* JADX INFO: renamed from: d */
    private static Matrix m1099d(ImageView imageView) {
        Drawable drawable = imageView.getDrawable();
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int width = imageView.getWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        int height = imageView.getHeight();
        float fMax = Math.max(width / intrinsicWidth, height / intrinsicHeight);
        int iRound = Math.round((width - (intrinsicWidth * fMax)) / 2.0f);
        int iRound2 = Math.round((height - (intrinsicHeight * fMax)) / 2.0f);
        Matrix matrix = new Matrix();
        matrix.postScale(fMax, fMax);
        matrix.postTranslate(iRound, iRound2);
        return matrix;
    }
}
