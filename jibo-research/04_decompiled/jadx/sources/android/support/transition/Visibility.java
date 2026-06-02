package android.support.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.TypedArray;
import android.support.transition.AnimatorUtilsApi14;
import android.support.transition.Transition;
import android.support.v4.content.res.TypedArrayUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: classes.dex */
public abstract class Visibility extends Transition {

    /* JADX INFO: renamed from: g */
    private static final String[] f1374g = {"android:visibility:visibility", "android:visibility:parent"};

    /* JADX INFO: renamed from: h */
    private int f1375h;

    private static class VisibilityInfo {

        /* JADX INFO: renamed from: a */
        boolean f1385a;

        /* JADX INFO: renamed from: b */
        boolean f1386b;

        /* JADX INFO: renamed from: c */
        int f1387c;

        /* JADX INFO: renamed from: d */
        int f1388d;

        /* JADX INFO: renamed from: e */
        ViewGroup f1389e;

        /* JADX INFO: renamed from: f */
        ViewGroup f1390f;

        private VisibilityInfo() {
        }
    }

    public Visibility() {
        this.f1375h = 3;
    }

    public Visibility(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1375h = 3;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, Styleable.f1255e);
        int iM1925a = TypedArrayUtils.m1925a(typedArrayObtainStyledAttributes, (XmlPullParser) attributeSet, "transitionVisibilityMode", 0, 0);
        typedArrayObtainStyledAttributes.recycle();
        if (iM1925a != 0) {
            m1333b(iM1925a);
        }
    }

    /* JADX INFO: renamed from: b */
    public void m1333b(int i) {
        if ((i & (-4)) != 0) {
            throw new IllegalArgumentException("Only MODE_IN and MODE_OUT flags are allowed");
        }
        this.f1375h = i;
    }

    /* JADX INFO: renamed from: p */
    public int m1334p() {
        return this.f1375h;
    }

    @Override // android.support.transition.Transition
    /* JADX INFO: renamed from: a */
    public String[] mo1075a() {
        return f1374g;
    }

    /* JADX INFO: renamed from: d */
    private void m1330d(TransitionValues transitionValues) {
        transitionValues.f1323a.put("android:visibility:visibility", Integer.valueOf(transitionValues.f1324b.getVisibility()));
        transitionValues.f1323a.put("android:visibility:parent", transitionValues.f1324b.getParent());
        int[] iArr = new int[2];
        transitionValues.f1324b.getLocationOnScreen(iArr);
        transitionValues.f1323a.put("android:visibility:screenLocation", iArr);
    }

    @Override // android.support.transition.Transition
    /* JADX INFO: renamed from: a */
    public void mo406a(TransitionValues transitionValues) {
        m1330d(transitionValues);
    }

    @Override // android.support.transition.Transition
    /* JADX INFO: renamed from: b */
    public void mo407b(TransitionValues transitionValues) {
        m1330d(transitionValues);
    }

    /* JADX INFO: renamed from: b */
    private VisibilityInfo m1329b(TransitionValues transitionValues, TransitionValues transitionValues2) {
        VisibilityInfo visibilityInfo = new VisibilityInfo();
        visibilityInfo.f1385a = false;
        visibilityInfo.f1386b = false;
        if (transitionValues != null && transitionValues.f1323a.containsKey("android:visibility:visibility")) {
            visibilityInfo.f1387c = ((Integer) transitionValues.f1323a.get("android:visibility:visibility")).intValue();
            visibilityInfo.f1389e = (ViewGroup) transitionValues.f1323a.get("android:visibility:parent");
        } else {
            visibilityInfo.f1387c = -1;
            visibilityInfo.f1389e = null;
        }
        if (transitionValues2 != null && transitionValues2.f1323a.containsKey("android:visibility:visibility")) {
            visibilityInfo.f1388d = ((Integer) transitionValues2.f1323a.get("android:visibility:visibility")).intValue();
            visibilityInfo.f1390f = (ViewGroup) transitionValues2.f1323a.get("android:visibility:parent");
        } else {
            visibilityInfo.f1388d = -1;
            visibilityInfo.f1390f = null;
        }
        if (transitionValues != null && transitionValues2 != null) {
            if (visibilityInfo.f1387c == visibilityInfo.f1388d && visibilityInfo.f1389e == visibilityInfo.f1390f) {
                return visibilityInfo;
            }
            if (visibilityInfo.f1387c != visibilityInfo.f1388d) {
                if (visibilityInfo.f1387c == 0) {
                    visibilityInfo.f1386b = false;
                    visibilityInfo.f1385a = true;
                } else if (visibilityInfo.f1388d == 0) {
                    visibilityInfo.f1386b = true;
                    visibilityInfo.f1385a = true;
                }
            } else if (visibilityInfo.f1390f == null) {
                visibilityInfo.f1386b = false;
                visibilityInfo.f1385a = true;
            } else if (visibilityInfo.f1389e == null) {
                visibilityInfo.f1386b = true;
                visibilityInfo.f1385a = true;
            }
        } else if (transitionValues == null && visibilityInfo.f1388d == 0) {
            visibilityInfo.f1386b = true;
            visibilityInfo.f1385a = true;
        } else if (transitionValues2 == null && visibilityInfo.f1387c == 0) {
            visibilityInfo.f1386b = false;
            visibilityInfo.f1385a = true;
        }
        return visibilityInfo;
    }

    @Override // android.support.transition.Transition
    /* JADX INFO: renamed from: a */
    public Animator mo405a(ViewGroup viewGroup, TransitionValues transitionValues, TransitionValues transitionValues2) {
        VisibilityInfo visibilityInfoM1329b = m1329b(transitionValues, transitionValues2);
        if (visibilityInfoM1329b.f1385a && (visibilityInfoM1329b.f1389e != null || visibilityInfoM1329b.f1390f != null)) {
            if (visibilityInfoM1329b.f1386b) {
                return m1331a(viewGroup, transitionValues, visibilityInfoM1329b.f1387c, transitionValues2, visibilityInfoM1329b.f1388d);
            }
            return m1332b(viewGroup, transitionValues, visibilityInfoM1329b.f1387c, transitionValues2, visibilityInfoM1329b.f1388d);
        }
        return null;
    }

    /* JADX INFO: renamed from: a */
    public Animator m1331a(ViewGroup viewGroup, TransitionValues transitionValues, int i, TransitionValues transitionValues2, int i2) {
        if ((this.f1375h & 1) != 1 || transitionValues2 == null) {
            return null;
        }
        if (transitionValues == null) {
            View view = (View) transitionValues2.f1324b.getParent();
            if (m1329b(m1228b(view, false), m1215a(view, false)).f1385a) {
                return null;
            }
        }
        return mo1131a(viewGroup, transitionValues2.f1324b, transitionValues, transitionValues2);
    }

    /* JADX INFO: renamed from: a */
    public Animator mo1131a(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x00e9  */
    /* JADX INFO: renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.animation.Animator m1332b(android.view.ViewGroup r9, android.support.transition.TransitionValues r10, int r11, android.support.transition.TransitionValues r12, int r13) {
        /*
            Method dump skipped, instruction units count: 237
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.transition.Visibility.m1332b(android.view.ViewGroup, android.support.transition.TransitionValues, int, android.support.transition.TransitionValues, int):android.animation.Animator");
    }

    /* JADX INFO: renamed from: b */
    public Animator mo1132b(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        return null;
    }

    @Override // android.support.transition.Transition
    /* JADX INFO: renamed from: a */
    public boolean mo1224a(TransitionValues transitionValues, TransitionValues transitionValues2) {
        if (transitionValues == null && transitionValues2 == null) {
            return false;
        }
        if (transitionValues != null && transitionValues2 != null && transitionValues2.f1323a.containsKey("android:visibility:visibility") != transitionValues.f1323a.containsKey("android:visibility:visibility")) {
            return false;
        }
        VisibilityInfo visibilityInfoM1329b = m1329b(transitionValues, transitionValues2);
        if (visibilityInfoM1329b.f1385a) {
            return visibilityInfoM1329b.f1387c == 0 || visibilityInfoM1329b.f1388d == 0;
        }
        return false;
    }

    private static class DisappearListener extends AnimatorListenerAdapter implements AnimatorUtilsApi14.AnimatorPauseListenerCompat, Transition.TransitionListener {

        /* JADX INFO: renamed from: a */
        boolean f1379a = false;

        /* JADX INFO: renamed from: b */
        private final View f1380b;

        /* JADX INFO: renamed from: c */
        private final int f1381c;

        /* JADX INFO: renamed from: d */
        private final ViewGroup f1382d;

        /* JADX INFO: renamed from: e */
        private final boolean f1383e;

        /* JADX INFO: renamed from: f */
        private boolean f1384f;

        DisappearListener(View view, int i, boolean z) {
            this.f1380b = view;
            this.f1381c = i;
            this.f1382d = (ViewGroup) view.getParent();
            this.f1383e = z;
            m1336a(true);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener, android.support.transition.AnimatorUtilsApi14.AnimatorPauseListenerCompat
        public void onAnimationPause(Animator animator) {
            if (!this.f1379a) {
                ViewUtils.m1300a(this.f1380b, this.f1381c);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener, android.support.transition.AnimatorUtilsApi14.AnimatorPauseListenerCompat
        public void onAnimationResume(Animator animator) {
            if (!this.f1379a) {
                ViewUtils.m1300a(this.f1380b, 0);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f1379a = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            m1335a();
        }

        @Override // android.support.transition.Transition.TransitionListener
        /* JADX INFO: renamed from: d */
        public void mo1154d(Transition transition) {
        }

        @Override // android.support.transition.Transition.TransitionListener
        /* JADX INFO: renamed from: a */
        public void mo1088a(Transition transition) {
            m1335a();
            transition.mo1227b(this);
        }

        @Override // android.support.transition.Transition.TransitionListener
        /* JADX INFO: renamed from: b */
        public void mo1089b(Transition transition) {
            m1336a(false);
        }

        @Override // android.support.transition.Transition.TransitionListener
        /* JADX INFO: renamed from: c */
        public void mo1090c(Transition transition) {
            m1336a(true);
        }

        /* JADX INFO: renamed from: a */
        private void m1335a() {
            if (!this.f1379a) {
                ViewUtils.m1300a(this.f1380b, this.f1381c);
                if (this.f1382d != null) {
                    this.f1382d.invalidate();
                }
            }
            m1336a(false);
        }

        /* JADX INFO: renamed from: a */
        private void m1336a(boolean z) {
            if (this.f1383e && this.f1384f != z && this.f1382d != null) {
                this.f1384f = z;
                ViewGroupUtils.m1284a(this.f1382d, z);
            }
        }
    }
}
