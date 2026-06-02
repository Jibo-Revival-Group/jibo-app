package android.support.transition;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes.dex */
class ViewGroupOverlayApi14 extends ViewOverlayApi14 implements ViewGroupOverlayImpl {
    ViewGroupOverlayApi14(Context context, ViewGroup viewGroup, View view) {
        super(context, viewGroup, view);
    }

    /* JADX INFO: renamed from: a */
    static ViewGroupOverlayApi14 m1278a(ViewGroup viewGroup) {
        return (ViewGroupOverlayApi14) ViewOverlayApi14.m1290d(viewGroup);
    }

    @Override // android.support.transition.ViewGroupOverlayImpl
    /* JADX INFO: renamed from: a */
    public void mo1279a(View view) {
        this.f1349a.m1293a(view);
    }

    @Override // android.support.transition.ViewGroupOverlayImpl
    /* JADX INFO: renamed from: b */
    public void mo1280b(View view) {
        this.f1349a.m1296b(view);
    }
}
