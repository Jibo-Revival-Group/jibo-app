package android.support.v7.widget;

import android.graphics.Rect;

/* JADX INFO: loaded from: classes.dex */
public interface FitWindowsViewGroup {

    public interface OnFitSystemWindowsListener {
        /* JADX INFO: renamed from: a */
        void mo3324a(Rect rect);
    }

    void setOnFitSystemWindowsListener(OnFitSystemWindowsListener onFitSystemWindowsListener);
}
