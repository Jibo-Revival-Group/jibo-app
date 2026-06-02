package com.bumptech.glide.request.animation;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import com.bumptech.glide.request.animation.GlideAnimation;

/* JADX INFO: loaded from: classes.dex */
public class DrawableCrossFadeViewAnimation<T extends Drawable> implements GlideAnimation<T> {

    /* JADX INFO: renamed from: a */
    private final GlideAnimation<T> f4972a;

    /* JADX INFO: renamed from: b */
    private final int f4973b;

    public DrawableCrossFadeViewAnimation(GlideAnimation<T> glideAnimation, int i) {
        this.f4972a = glideAnimation;
        this.f4973b = i;
    }

    @Override // com.bumptech.glide.request.animation.GlideAnimation
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public boolean mo5543a(T t, GlideAnimation.ViewAdapter viewAdapter) {
        Drawable drawableMo5546b = viewAdapter.mo5546b();
        if (drawableMo5546b != null) {
            TransitionDrawable transitionDrawable = new TransitionDrawable(new Drawable[]{drawableMo5546b, t});
            transitionDrawable.setCrossFadeEnabled(true);
            transitionDrawable.startTransition(this.f4973b);
            viewAdapter.mo5545a(transitionDrawable);
            return true;
        }
        this.f4972a.mo5543a(t, viewAdapter);
        return false;
    }
}
