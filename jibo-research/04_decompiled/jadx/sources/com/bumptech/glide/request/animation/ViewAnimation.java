package com.bumptech.glide.request.animation;

import android.view.View;
import android.view.animation.Animation;
import com.bumptech.glide.request.animation.GlideAnimation;

/* JADX INFO: loaded from: classes.dex */
public class ViewAnimation<R> implements GlideAnimation<R> {

    /* JADX INFO: renamed from: a */
    private final AnimationFactory f4976a;

    interface AnimationFactory {
        /* JADX INFO: renamed from: a */
        Animation mo5541a();
    }

    ViewAnimation(AnimationFactory animationFactory) {
        this.f4976a = animationFactory;
    }

    @Override // com.bumptech.glide.request.animation.GlideAnimation
    /* JADX INFO: renamed from: a */
    public boolean mo5543a(R r, GlideAnimation.ViewAdapter viewAdapter) {
        View viewM5544a = viewAdapter.m5544a();
        if (viewM5544a != null) {
            viewM5544a.clearAnimation();
            viewM5544a.startAnimation(this.f4976a.mo5541a());
            return false;
        }
        return false;
    }
}
