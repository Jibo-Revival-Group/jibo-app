package android.support.transition;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewOverlay;

/* JADX INFO: loaded from: classes.dex */
class ViewOverlayApi18 implements ViewOverlayImpl {

    /* JADX INFO: renamed from: a */
    private final ViewOverlay f1355a;

    ViewOverlayApi18(View view) {
        this.f1355a = view.getOverlay();
    }

    @Override // android.support.transition.ViewOverlayImpl
    /* JADX INFO: renamed from: a */
    public void mo1281a(Drawable drawable) {
        this.f1355a.add(drawable);
    }

    @Override // android.support.transition.ViewOverlayImpl
    /* JADX INFO: renamed from: b */
    public void mo1282b(Drawable drawable) {
        this.f1355a.remove(drawable);
    }
}
