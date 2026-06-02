package android.support.transition;

import android.os.Build;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes.dex */
class ViewGroupUtils {

    /* JADX INFO: renamed from: a */
    private static final ViewGroupUtilsImpl f1340a;

    static {
        if (Build.VERSION.SDK_INT >= 18) {
            f1340a = new ViewGroupUtilsApi18();
        } else {
            f1340a = new ViewGroupUtilsApi14();
        }
    }

    /* JADX INFO: renamed from: a */
    static ViewGroupOverlayImpl m1283a(ViewGroup viewGroup) {
        return f1340a.mo1286a(viewGroup);
    }

    /* JADX INFO: renamed from: a */
    static void m1284a(ViewGroup viewGroup, boolean z) {
        f1340a.mo1287a(viewGroup, z);
    }
}
