package android.support.transition;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroupOverlay;

/* JADX INFO: loaded from: classes.dex */
class ViewGroupOverlayApi18 implements ViewGroupOverlayImpl {

    /* JADX INFO: renamed from: a */
    private final ViewGroupOverlay f1339a;

    ViewGroupOverlayApi18(ViewGroup viewGroup) {
        this.f1339a = viewGroup.getOverlay();
    }

    @Override // android.support.transition.ViewOverlayImpl
    /* JADX INFO: renamed from: a */
    public void mo1281a(Drawable drawable) {
        this.f1339a.add(drawable);
    }

    @Override // android.support.transition.ViewOverlayImpl
    /* JADX INFO: renamed from: b */
    public void mo1282b(Drawable drawable) {
        this.f1339a.remove(drawable);
    }

    @Override // android.support.transition.ViewGroupOverlayImpl
    /* JADX INFO: renamed from: a */
    public void mo1279a(View view) {
        this.f1339a.add(view);
    }

    @Override // android.support.transition.ViewGroupOverlayImpl
    /* JADX INFO: renamed from: b */
    public void mo1280b(View view) {
        this.f1339a.remove(view);
    }
}
