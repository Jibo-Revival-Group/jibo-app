package android.support.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.os.Build;
import android.support.v4.content.res.TypedArrayUtils;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import com.yalantis.ucrop.view.CropImageView;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: classes.dex */
public class ChangeTransform extends Transition {

    /* JADX INFO: renamed from: g */
    private static final String[] f1148g = {"android:changeTransform:matrix", "android:changeTransform:transforms", "android:changeTransform:parentMatrix"};

    /* JADX INFO: renamed from: h */
    private static final Property<PathAnimatorMatrix, float[]> f1149h = new Property<PathAnimatorMatrix, float[]>(float[].class, "nonTranslations") { // from class: android.support.transition.ChangeTransform.1
        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public float[] get(PathAnimatorMatrix pathAnimatorMatrix) {
            return null;
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void set(PathAnimatorMatrix pathAnimatorMatrix, float[] fArr) {
            pathAnimatorMatrix.m1123a(fArr);
        }
    };

    /* JADX INFO: renamed from: i */
    private static final Property<PathAnimatorMatrix, PointF> f1150i = new Property<PathAnimatorMatrix, PointF>(PointF.class, "translations") { // from class: android.support.transition.ChangeTransform.2
        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public PointF get(PathAnimatorMatrix pathAnimatorMatrix) {
            return null;
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void set(PathAnimatorMatrix pathAnimatorMatrix, PointF pointF) {
            pathAnimatorMatrix.m1122a(pointF);
        }
    };

    /* JADX INFO: renamed from: j */
    private static final boolean f1151j;

    /* JADX INFO: renamed from: k */
    private boolean f1152k;

    /* JADX INFO: renamed from: l */
    private boolean f1153l;

    /* JADX INFO: renamed from: m */
    private Matrix f1154m;

    static {
        f1151j = Build.VERSION.SDK_INT >= 21;
    }

    public ChangeTransform() {
        this.f1152k = true;
        this.f1153l = true;
        this.f1154m = new Matrix();
    }

    public ChangeTransform(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1152k = true;
        this.f1153l = true;
        this.f1154m = new Matrix();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, Styleable.f1257g);
        this.f1152k = TypedArrayUtils.m1928a(typedArrayObtainStyledAttributes, (XmlPullParser) attributeSet, "reparentWithOverlay", 1, true);
        this.f1153l = TypedArrayUtils.m1928a(typedArrayObtainStyledAttributes, (XmlPullParser) attributeSet, "reparent", 0, true);
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // android.support.transition.Transition
    /* JADX INFO: renamed from: a */
    public String[] mo1075a() {
        return f1148g;
    }

    /* JADX INFO: renamed from: d */
    private void m1113d(TransitionValues transitionValues) {
        Matrix matrix;
        View view = transitionValues.f1324b;
        if (view.getVisibility() != 8) {
            transitionValues.f1323a.put("android:changeTransform:parent", view.getParent());
            transitionValues.f1323a.put("android:changeTransform:transforms", new Transforms(view));
            Matrix matrix2 = view.getMatrix();
            if (matrix2 == null || matrix2.isIdentity()) {
                matrix = null;
            } else {
                matrix = new Matrix(matrix2);
            }
            transitionValues.f1323a.put("android:changeTransform:matrix", matrix);
            if (this.f1153l) {
                Matrix matrix3 = new Matrix();
                ViewUtils.m1302a((ViewGroup) view.getParent(), matrix3);
                matrix3.preTranslate(-r0.getScrollX(), -r0.getScrollY());
                transitionValues.f1323a.put("android:changeTransform:parentMatrix", matrix3);
                transitionValues.f1323a.put("android:changeTransform:intermediateMatrix", view.getTag(R.id.transition_transform));
                transitionValues.f1323a.put("android:changeTransform:intermediateParentMatrix", view.getTag(R.id.parent_matrix));
            }
        }
    }

    @Override // android.support.transition.Transition
    /* JADX INFO: renamed from: a */
    public void mo406a(TransitionValues transitionValues) {
        m1113d(transitionValues);
        if (!f1151j) {
            ((ViewGroup) transitionValues.f1324b.getParent()).startViewTransition(transitionValues.f1324b);
        }
    }

    @Override // android.support.transition.Transition
    /* JADX INFO: renamed from: b */
    public void mo407b(TransitionValues transitionValues) {
        m1113d(transitionValues);
    }

    @Override // android.support.transition.Transition
    /* JADX INFO: renamed from: a */
    public Animator mo405a(ViewGroup viewGroup, TransitionValues transitionValues, TransitionValues transitionValues2) {
        if (transitionValues == null || transitionValues2 == null || !transitionValues.f1323a.containsKey("android:changeTransform:parent") || !transitionValues2.f1323a.containsKey("android:changeTransform:parent")) {
            return null;
        }
        ViewGroup viewGroup2 = (ViewGroup) transitionValues.f1323a.get("android:changeTransform:parent");
        boolean z = this.f1153l && !m1109a(viewGroup2, (ViewGroup) transitionValues2.f1323a.get("android:changeTransform:parent"));
        Matrix matrix = (Matrix) transitionValues.f1323a.get("android:changeTransform:intermediateMatrix");
        if (matrix != null) {
            transitionValues.f1323a.put("android:changeTransform:matrix", matrix);
        }
        Matrix matrix2 = (Matrix) transitionValues.f1323a.get("android:changeTransform:intermediateParentMatrix");
        if (matrix2 != null) {
            transitionValues.f1323a.put("android:changeTransform:parentMatrix", matrix2);
        }
        if (z) {
            m1110b(transitionValues, transitionValues2);
        }
        ObjectAnimator objectAnimatorM1105a = m1105a(transitionValues, transitionValues2, z);
        if (z && objectAnimatorM1105a != null && this.f1152k) {
            m1112b(viewGroup, transitionValues, transitionValues2);
        } else if (!f1151j) {
            viewGroup2.endViewTransition(transitionValues.f1324b);
        }
        return objectAnimatorM1105a;
    }

    /* JADX INFO: renamed from: a */
    private ObjectAnimator m1105a(TransitionValues transitionValues, TransitionValues transitionValues2, final boolean z) {
        Matrix matrix = (Matrix) transitionValues.f1323a.get("android:changeTransform:matrix");
        Matrix matrix2 = (Matrix) transitionValues2.f1323a.get("android:changeTransform:matrix");
        if (matrix == null) {
            matrix = MatrixUtils.f1224a;
        }
        final Matrix matrix3 = matrix2 == null ? MatrixUtils.f1224a : matrix2;
        if (matrix.equals(matrix3)) {
            return null;
        }
        final Transforms transforms = (Transforms) transitionValues2.f1323a.get("android:changeTransform:transforms");
        final View view = transitionValues2.f1324b;
        m1114g(view);
        float[] fArr = new float[9];
        matrix.getValues(fArr);
        float[] fArr2 = new float[9];
        matrix3.getValues(fArr2);
        final PathAnimatorMatrix pathAnimatorMatrix = new PathAnimatorMatrix(view, fArr);
        ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(pathAnimatorMatrix, PropertyValuesHolder.ofObject(f1149h, new FloatArrayEvaluator(new float[9]), fArr, fArr2), PropertyValuesHolderUtils.m1184a(f1150i, m1245l().mo1067a(fArr[2], fArr[5], fArr2[2], fArr2[5])));
        AnimatorListenerAdapter animatorListenerAdapter = new AnimatorListenerAdapter() { // from class: android.support.transition.ChangeTransform.3

            /* JADX INFO: renamed from: g */
            private boolean f1161g;

            /* JADX INFO: renamed from: h */
            private Matrix f1162h = new Matrix();

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                this.f1161g = true;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (!this.f1161g) {
                    if (z && ChangeTransform.this.f1152k) {
                        m1119a(matrix3);
                    } else {
                        view.setTag(R.id.transition_transform, null);
                        view.setTag(R.id.parent_matrix, null);
                    }
                }
                ViewUtils.m1306c(view, null);
                transforms.m1124a(view);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
            public void onAnimationPause(Animator animator) {
                m1119a(pathAnimatorMatrix.m1121a());
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
            public void onAnimationResume(Animator animator) {
                ChangeTransform.m1114g(view);
            }

            /* JADX INFO: renamed from: a */
            private void m1119a(Matrix matrix4) {
                this.f1162h.set(matrix4);
                view.setTag(R.id.transition_transform, this.f1162h);
                transforms.m1124a(view);
            }
        };
        objectAnimatorOfPropertyValuesHolder.addListener(animatorListenerAdapter);
        AnimatorUtils.m1061a(objectAnimatorOfPropertyValuesHolder, animatorListenerAdapter);
        return objectAnimatorOfPropertyValuesHolder;
    }

    /* JADX INFO: renamed from: a */
    private boolean m1109a(ViewGroup viewGroup, ViewGroup viewGroup2) {
        if (!m1230b(viewGroup) || !m1230b(viewGroup2)) {
            return viewGroup == viewGroup2;
        }
        TransitionValues transitionValuesB = m1228b((View) viewGroup, true);
        return transitionValuesB != null && viewGroup2 == transitionValuesB.f1324b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v1, types: [android.support.transition.Transition] */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX INFO: renamed from: b */
    private void m1112b(ViewGroup viewGroup, TransitionValues transitionValues, TransitionValues transitionValues2) {
        View view = transitionValues2.f1324b;
        Matrix matrix = new Matrix((Matrix) transitionValues2.f1323a.get("android:changeTransform:parentMatrix"));
        ViewUtils.m1304b(viewGroup, matrix);
        GhostViewImpl ghostViewImplM1168a = GhostViewUtils.m1168a(view, viewGroup, matrix);
        if (ghostViewImplM1168a != null) {
            ghostViewImplM1168a.mo1157a((ViewGroup) transitionValues.f1323a.get("android:changeTransform:parent"), transitionValues.f1324b);
            ?? r4 = this;
            while (r4.f1278d != null) {
                r4 = r4.f1278d;
            }
            r4.mo1214a(new GhostListener(view, ghostViewImplM1168a));
            if (f1151j) {
                if (transitionValues.f1324b != transitionValues2.f1324b) {
                    ViewUtils.m1299a(transitionValues.f1324b, CropImageView.DEFAULT_ASPECT_RATIO);
                }
                ViewUtils.m1299a(view, 1.0f);
            }
        }
    }

    /* JADX INFO: renamed from: b */
    private void m1110b(TransitionValues transitionValues, TransitionValues transitionValues2) {
        Matrix matrix;
        Matrix matrix2 = (Matrix) transitionValues2.f1323a.get("android:changeTransform:parentMatrix");
        transitionValues2.f1324b.setTag(R.id.parent_matrix, matrix2);
        Matrix matrix3 = this.f1154m;
        matrix3.reset();
        matrix2.invert(matrix3);
        Matrix matrix4 = (Matrix) transitionValues.f1323a.get("android:changeTransform:matrix");
        if (matrix4 == null) {
            Matrix matrix5 = new Matrix();
            transitionValues.f1323a.put("android:changeTransform:matrix", matrix5);
            matrix = matrix5;
        } else {
            matrix = matrix4;
        }
        matrix.postConcat((Matrix) transitionValues.f1323a.get("android:changeTransform:parentMatrix"));
        matrix.postConcat(matrix3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: g */
    public static void m1114g(View view) {
        m1111b(view, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, 1.0f, 1.0f, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: b */
    public static void m1111b(View view, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8) {
        view.setTranslationX(f);
        view.setTranslationY(f2);
        ViewCompat.m2592b(view, f3);
        view.setScaleX(f4);
        view.setScaleY(f5);
        view.setRotationX(f6);
        view.setRotationY(f7);
        view.setRotation(f8);
    }

    private static class Transforms {

        /* JADX INFO: renamed from: a */
        final float f1170a;

        /* JADX INFO: renamed from: b */
        final float f1171b;

        /* JADX INFO: renamed from: c */
        final float f1172c;

        /* JADX INFO: renamed from: d */
        final float f1173d;

        /* JADX INFO: renamed from: e */
        final float f1174e;

        /* JADX INFO: renamed from: f */
        final float f1175f;

        /* JADX INFO: renamed from: g */
        final float f1176g;

        /* JADX INFO: renamed from: h */
        final float f1177h;

        Transforms(View view) {
            this.f1170a = view.getTranslationX();
            this.f1171b = view.getTranslationY();
            this.f1172c = ViewCompat.m2610n(view);
            this.f1173d = view.getScaleX();
            this.f1174e = view.getScaleY();
            this.f1175f = view.getRotationX();
            this.f1176g = view.getRotationY();
            this.f1177h = view.getRotation();
        }

        /* JADX INFO: renamed from: a */
        public void m1124a(View view) {
            ChangeTransform.m1111b(view, this.f1170a, this.f1171b, this.f1172c, this.f1173d, this.f1174e, this.f1175f, this.f1176g, this.f1177h);
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof Transforms)) {
                return false;
            }
            Transforms transforms = (Transforms) obj;
            return transforms.f1170a == this.f1170a && transforms.f1171b == this.f1171b && transforms.f1172c == this.f1172c && transforms.f1173d == this.f1173d && transforms.f1174e == this.f1174e && transforms.f1175f == this.f1175f && transforms.f1176g == this.f1176g && transforms.f1177h == this.f1177h;
        }

        public int hashCode() {
            return (((this.f1176g != CropImageView.DEFAULT_ASPECT_RATIO ? Float.floatToIntBits(this.f1176g) : 0) + (((this.f1175f != CropImageView.DEFAULT_ASPECT_RATIO ? Float.floatToIntBits(this.f1175f) : 0) + (((this.f1174e != CropImageView.DEFAULT_ASPECT_RATIO ? Float.floatToIntBits(this.f1174e) : 0) + (((this.f1173d != CropImageView.DEFAULT_ASPECT_RATIO ? Float.floatToIntBits(this.f1173d) : 0) + (((this.f1172c != CropImageView.DEFAULT_ASPECT_RATIO ? Float.floatToIntBits(this.f1172c) : 0) + (((this.f1171b != CropImageView.DEFAULT_ASPECT_RATIO ? Float.floatToIntBits(this.f1171b) : 0) + ((this.f1170a != CropImageView.DEFAULT_ASPECT_RATIO ? Float.floatToIntBits(this.f1170a) : 0) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31) + (this.f1177h != CropImageView.DEFAULT_ASPECT_RATIO ? Float.floatToIntBits(this.f1177h) : 0);
        }
    }

    private static class GhostListener extends TransitionListenerAdapter {

        /* JADX INFO: renamed from: a */
        private View f1163a;

        /* JADX INFO: renamed from: b */
        private GhostViewImpl f1164b;

        GhostListener(View view, GhostViewImpl ghostViewImpl) {
            this.f1163a = view;
            this.f1164b = ghostViewImpl;
        }

        @Override // android.support.transition.TransitionListenerAdapter, android.support.transition.Transition.TransitionListener
        /* JADX INFO: renamed from: a */
        public void mo1088a(Transition transition) {
            transition.mo1227b(this);
            GhostViewUtils.m1169a(this.f1163a);
            this.f1163a.setTag(R.id.transition_transform, null);
            this.f1163a.setTag(R.id.parent_matrix, null);
        }

        @Override // android.support.transition.TransitionListenerAdapter, android.support.transition.Transition.TransitionListener
        /* JADX INFO: renamed from: b */
        public void mo1089b(Transition transition) {
            this.f1164b.setVisibility(4);
        }

        @Override // android.support.transition.TransitionListenerAdapter, android.support.transition.Transition.TransitionListener
        /* JADX INFO: renamed from: c */
        public void mo1090c(Transition transition) {
            this.f1164b.setVisibility(0);
        }
    }

    private static class PathAnimatorMatrix {

        /* JADX INFO: renamed from: a */
        private final Matrix f1165a = new Matrix();

        /* JADX INFO: renamed from: b */
        private final View f1166b;

        /* JADX INFO: renamed from: c */
        private final float[] f1167c;

        /* JADX INFO: renamed from: d */
        private float f1168d;

        /* JADX INFO: renamed from: e */
        private float f1169e;

        PathAnimatorMatrix(View view, float[] fArr) {
            this.f1166b = view;
            this.f1167c = (float[]) fArr.clone();
            this.f1168d = this.f1167c[2];
            this.f1169e = this.f1167c[5];
            m1120b();
        }

        /* JADX INFO: renamed from: a */
        void m1123a(float[] fArr) {
            System.arraycopy(fArr, 0, this.f1167c, 0, fArr.length);
            m1120b();
        }

        /* JADX INFO: renamed from: a */
        void m1122a(PointF pointF) {
            this.f1168d = pointF.x;
            this.f1169e = pointF.y;
            m1120b();
        }

        /* JADX INFO: renamed from: b */
        private void m1120b() {
            this.f1167c[2] = this.f1168d;
            this.f1167c[5] = this.f1169e;
            this.f1165a.setValues(this.f1167c);
            ViewUtils.m1306c(this.f1166b, this.f1165a);
        }

        /* JADX INFO: renamed from: a */
        Matrix m1121a() {
            return this.f1165a;
        }
    }
}
