package android.support.v7.widget;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
class ScrollbarHelper {
    /* JADX INFO: renamed from: a */
    static int m4716a(RecyclerView.State state, OrientationHelper orientationHelper, View view, View view2, RecyclerView.LayoutManager layoutManager, boolean z, boolean z2) {
        int iMax;
        if (layoutManager.m4561v() == 0 || state.m4662e() == 0 || view == null || view2 == null) {
            return 0;
        }
        int iMin = Math.min(layoutManager.m4527d(view), layoutManager.m4527d(view2));
        int iMax2 = Math.max(layoutManager.m4527d(view), layoutManager.m4527d(view2));
        if (z2) {
            iMax = Math.max(0, (state.m4662e() - iMax2) - 1);
        } else {
            iMax = Math.max(0, iMin);
        }
        if (z) {
            return Math.round((iMax * (Math.abs(orientationHelper.mo4404b(view2) - orientationHelper.mo4400a(view)) / (Math.abs(layoutManager.m4527d(view) - layoutManager.m4527d(view2)) + 1))) + (orientationHelper.mo4405c() - orientationHelper.mo4400a(view)));
        }
        return iMax;
    }

    /* JADX INFO: renamed from: a */
    static int m4715a(RecyclerView.State state, OrientationHelper orientationHelper, View view, View view2, RecyclerView.LayoutManager layoutManager, boolean z) {
        if (layoutManager.m4561v() == 0 || state.m4662e() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z) {
            return Math.abs(layoutManager.m4527d(view) - layoutManager.m4527d(view2)) + 1;
        }
        return Math.min(orientationHelper.mo4411f(), orientationHelper.mo4404b(view2) - orientationHelper.mo4400a(view));
    }

    /* JADX INFO: renamed from: b */
    static int m4717b(RecyclerView.State state, OrientationHelper orientationHelper, View view, View view2, RecyclerView.LayoutManager layoutManager, boolean z) {
        if (layoutManager.m4561v() == 0 || state.m4662e() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z) {
            return state.m4662e();
        }
        return (int) (((orientationHelper.mo4404b(view2) - orientationHelper.mo4400a(view)) / (Math.abs(layoutManager.m4527d(view) - layoutManager.m4527d(view2)) + 1)) * state.m4662e());
    }
}
