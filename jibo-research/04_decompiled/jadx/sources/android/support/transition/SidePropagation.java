package android.support.transition;

import android.graphics.Rect;
import android.support.v4.view.ViewCompat;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes.dex */
public class SidePropagation extends VisibilityPropagation {

    /* JADX INFO: renamed from: a */
    private float f1239a = 3.0f;

    /* JADX INFO: renamed from: b */
    private int f1240b = 80;

    /* JADX INFO: renamed from: a */
    public void m1192a(int i) {
        this.f1240b = i;
    }

    @Override // android.support.transition.TransitionPropagation
    /* JADX INFO: renamed from: a */
    public long mo1126a(ViewGroup viewGroup, Transition transition, TransitionValues transitionValues, TransitionValues transitionValues2) {
        int i;
        int iCenterX;
        int iCenterY;
        if (transitionValues == null && transitionValues2 == null) {
            return 0L;
        }
        Rect rectM1246m = transition.m1246m();
        if (transitionValues2 != null && m1338b(transitionValues) != 0) {
            i = 1;
        } else {
            transitionValues2 = transitionValues;
            i = -1;
        }
        int iC = m1339c(transitionValues2);
        int iD = m1340d(transitionValues2);
        int[] iArr = new int[2];
        viewGroup.getLocationOnScreen(iArr);
        int iRound = iArr[0] + Math.round(viewGroup.getTranslationX());
        int iRound2 = iArr[1] + Math.round(viewGroup.getTranslationY());
        int width = iRound + viewGroup.getWidth();
        int height = iRound2 + viewGroup.getHeight();
        if (rectM1246m != null) {
            iCenterX = rectM1246m.centerX();
            iCenterY = rectM1246m.centerY();
        } else {
            iCenterX = (iRound + width) / 2;
            iCenterY = (iRound2 + height) / 2;
        }
        float fM1190a = m1190a(viewGroup, iC, iD, iCenterX, iCenterY, iRound, iRound2, width, height) / m1191a(viewGroup);
        long jM1225b = transition.m1225b();
        if (jM1225b < 0) {
            jM1225b = 300;
        }
        return Math.round(((jM1225b * ((long) i)) / this.f1239a) * fM1190a);
    }

    /* JADX INFO: renamed from: a */
    private int m1190a(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        int i9 = 5;
        if (this.f1240b == 8388611) {
            if (!(ViewCompat.m2601e(view) == 1)) {
                i9 = 3;
            }
        } else if (this.f1240b == 8388613) {
            i9 = ViewCompat.m2601e(view) == 1 ? 3 : 5;
        } else {
            i9 = this.f1240b;
        }
        switch (i9) {
            case 3:
                return (i7 - i) + Math.abs(i4 - i2);
            case 5:
                return (i - i5) + Math.abs(i4 - i2);
            case 48:
                return (i8 - i2) + Math.abs(i3 - i);
            case 80:
                return (i2 - i6) + Math.abs(i3 - i);
            default:
                return 0;
        }
    }

    /* JADX INFO: renamed from: a */
    private int m1191a(ViewGroup viewGroup) {
        switch (this.f1240b) {
            case 3:
            case 5:
            case 8388611:
            case 8388613:
                return viewGroup.getWidth();
            default:
                return viewGroup.getHeight();
        }
    }
}
