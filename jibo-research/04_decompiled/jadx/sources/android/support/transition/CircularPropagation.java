package android.support.transition;

import android.graphics.Rect;
import android.view.ViewGroup;
import com.yalantis.ucrop.view.CropImageView;

/* JADX INFO: loaded from: classes.dex */
public class CircularPropagation extends VisibilityPropagation {

    /* JADX INFO: renamed from: a */
    private float f1178a = 3.0f;

    @Override // android.support.transition.TransitionPropagation
    /* JADX INFO: renamed from: a */
    public long mo1126a(ViewGroup viewGroup, Transition transition, TransitionValues transitionValues, TransitionValues transitionValues2) {
        int i;
        int iRound;
        int iRound2;
        if (transitionValues == null && transitionValues2 == null) {
            return 0L;
        }
        if (transitionValues2 == null || m1338b(transitionValues) == 0) {
            i = -1;
            transitionValues2 = transitionValues;
        } else {
            i = 1;
        }
        int iC = m1339c(transitionValues2);
        int iD = m1340d(transitionValues2);
        Rect rectM1246m = transition.m1246m();
        if (rectM1246m != null) {
            iRound = rectM1246m.centerX();
            iRound2 = rectM1246m.centerY();
        } else {
            viewGroup.getLocationOnScreen(new int[2]);
            iRound = Math.round(r7[0] + (viewGroup.getWidth() / 2) + viewGroup.getTranslationX());
            iRound2 = Math.round(r7[1] + (viewGroup.getHeight() / 2) + viewGroup.getTranslationY());
        }
        float fM1125a = m1125a(iC, iD, iRound, iRound2) / m1125a(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, viewGroup.getWidth(), viewGroup.getHeight());
        long jM1225b = transition.m1225b();
        if (jM1225b < 0) {
            jM1225b = 300;
        }
        return Math.round(((jM1225b * ((long) i)) / this.f1178a) * fM1125a);
    }

    /* JADX INFO: renamed from: a */
    private static float m1125a(float f, float f2, float f3, float f4) {
        float f5 = f3 - f;
        float f6 = f4 - f2;
        return (float) Math.sqrt((f5 * f5) + (f6 * f6));
    }
}
