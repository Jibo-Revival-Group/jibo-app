package com.bumptech.glide.request.animation;

import com.bumptech.glide.request.animation.ViewAnimation;

/* JADX INFO: loaded from: classes.dex */
public class ViewAnimationFactory<R> implements GlideAnimationFactory<R> {

    /* JADX INFO: renamed from: a */
    private final ViewAnimation.AnimationFactory f4977a;

    /* JADX INFO: renamed from: b */
    private GlideAnimation<R> f4978b;

    ViewAnimationFactory(ViewAnimation.AnimationFactory animationFactory) {
        this.f4977a = animationFactory;
    }

    @Override // com.bumptech.glide.request.animation.GlideAnimationFactory
    /* JADX INFO: renamed from: a */
    public GlideAnimation<R> mo5540a(boolean z, boolean z2) {
        if (z || !z2) {
            return NoAnimation.m5548b();
        }
        if (this.f4978b == null) {
            this.f4978b = new ViewAnimation(this.f4977a);
        }
        return this.f4978b;
    }
}
