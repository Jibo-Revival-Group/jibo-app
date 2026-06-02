package android.support.transition;

import android.graphics.Matrix;
import android.os.Build;
import android.support.transition.GhostViewApi14;
import android.support.transition.GhostViewApi21;
import android.support.transition.GhostViewImpl;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes.dex */
class GhostViewUtils {

    /* JADX INFO: renamed from: a */
    private static final GhostViewImpl.Creator f1218a;

    static {
        if (Build.VERSION.SDK_INT >= 21) {
            f1218a = new GhostViewApi21.Creator();
        } else {
            f1218a = new GhostViewApi14.Creator();
        }
    }

    /* JADX INFO: renamed from: a */
    static GhostViewImpl m1168a(View view, ViewGroup viewGroup, Matrix matrix) {
        return f1218a.mo1159a(view, viewGroup, matrix);
    }

    /* JADX INFO: renamed from: a */
    static void m1169a(View view) {
        f1218a.mo1160a(view);
    }
}
