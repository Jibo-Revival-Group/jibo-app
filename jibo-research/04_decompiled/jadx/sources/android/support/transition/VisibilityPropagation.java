package android.support.transition;

import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public abstract class VisibilityPropagation extends TransitionPropagation {

    /* JADX INFO: renamed from: a */
    private static final String[] f1391a = {"android:visibilityPropagation:visibility", "android:visibilityPropagation:center"};

    @Override // android.support.transition.TransitionPropagation
    /* JADX INFO: renamed from: a */
    public void mo1255a(TransitionValues transitionValues) {
        View view = transitionValues.f1324b;
        Integer numValueOf = (Integer) transitionValues.f1323a.get("android:visibility:visibility");
        if (numValueOf == null) {
            numValueOf = Integer.valueOf(view.getVisibility());
        }
        transitionValues.f1323a.put("android:visibilityPropagation:visibility", numValueOf);
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        iArr[0] = iArr[0] + Math.round(view.getTranslationX());
        iArr[0] = iArr[0] + (view.getWidth() / 2);
        iArr[1] = iArr[1] + Math.round(view.getTranslationY());
        iArr[1] = (view.getHeight() / 2) + iArr[1];
        transitionValues.f1323a.put("android:visibilityPropagation:center", iArr);
    }

    @Override // android.support.transition.TransitionPropagation
    /* JADX INFO: renamed from: a */
    public String[] mo1256a() {
        return f1391a;
    }

    /* JADX INFO: renamed from: b */
    public int m1338b(TransitionValues transitionValues) {
        Integer num;
        if (transitionValues != null && (num = (Integer) transitionValues.f1323a.get("android:visibilityPropagation:visibility")) != null) {
            return num.intValue();
        }
        return 8;
    }

    /* JADX INFO: renamed from: c */
    public int m1339c(TransitionValues transitionValues) {
        return m1337a(transitionValues, 0);
    }

    /* JADX INFO: renamed from: d */
    public int m1340d(TransitionValues transitionValues) {
        return m1337a(transitionValues, 1);
    }

    /* JADX INFO: renamed from: a */
    private static int m1337a(TransitionValues transitionValues, int i) {
        int[] iArr;
        if (transitionValues != null && (iArr = (int[]) transitionValues.f1323a.get("android:visibilityPropagation:center")) != null) {
            return iArr[i];
        }
        return -1;
    }
}
