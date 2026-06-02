package android.support.transition;

import android.view.View;

/* JADX INFO: loaded from: classes.dex */
class ViewUtilsApi18 extends ViewUtilsApi14 {
    ViewUtilsApi18() {
    }

    @Override // android.support.transition.ViewUtilsApi14, android.support.transition.ViewUtilsImpl
    /* JADX INFO: renamed from: a */
    public ViewOverlayImpl mo1313a(View view) {
        return new ViewOverlayApi18(view);
    }

    @Override // android.support.transition.ViewUtilsApi14, android.support.transition.ViewUtilsImpl
    /* JADX INFO: renamed from: b */
    public WindowIdImpl mo1317b(View view) {
        return new WindowIdApi18(view);
    }
}
