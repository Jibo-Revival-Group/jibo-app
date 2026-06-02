package android.support.v4.app;

import android.view.View;
import android.view.ViewTreeObserver;

/* JADX INFO: loaded from: classes.dex */
class OneShotPreDrawListener implements View.OnAttachStateChangeListener, ViewTreeObserver.OnPreDrawListener {

    /* JADX INFO: renamed from: a */
    private final View f1749a;

    /* JADX INFO: renamed from: b */
    private ViewTreeObserver f1750b;

    /* JADX INFO: renamed from: c */
    private final Runnable f1751c;

    private OneShotPreDrawListener(View view, Runnable runnable) {
        this.f1749a = view;
        this.f1750b = view.getViewTreeObserver();
        this.f1751c = runnable;
    }

    /* JADX INFO: renamed from: a */
    public static OneShotPreDrawListener m1780a(View view, Runnable runnable) {
        OneShotPreDrawListener oneShotPreDrawListener = new OneShotPreDrawListener(view, runnable);
        view.getViewTreeObserver().addOnPreDrawListener(oneShotPreDrawListener);
        view.addOnAttachStateChangeListener(oneShotPreDrawListener);
        return oneShotPreDrawListener;
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        m1781a();
        this.f1751c.run();
        return true;
    }

    /* JADX INFO: renamed from: a */
    public void m1781a() {
        if (this.f1750b.isAlive()) {
            this.f1750b.removeOnPreDrawListener(this);
        } else {
            this.f1749a.getViewTreeObserver().removeOnPreDrawListener(this);
        }
        this.f1749a.removeOnAttachStateChangeListener(this);
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
        this.f1750b = view.getViewTreeObserver();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        m1781a();
    }
}
