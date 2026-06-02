package com.bumptech.glide.request.animation;

import android.graphics.drawable.Drawable;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import com.bumptech.glide.request.animation.ViewAnimation;
import com.yalantis.ucrop.view.CropImageView;

/* JADX INFO: loaded from: classes.dex */
public class DrawableCrossFadeFactory<T extends Drawable> implements GlideAnimationFactory<T> {

    /* JADX INFO: renamed from: a */
    private final ViewAnimationFactory<T> f4967a;

    /* JADX INFO: renamed from: b */
    private final int f4968b;

    /* JADX INFO: renamed from: c */
    private DrawableCrossFadeViewAnimation<T> f4969c;

    /* JADX INFO: renamed from: d */
    private DrawableCrossFadeViewAnimation<T> f4970d;

    public DrawableCrossFadeFactory() {
        this(300);
    }

    public DrawableCrossFadeFactory(int i) {
        this(new ViewAnimationFactory(new DefaultAnimationFactory(i)), i);
    }

    DrawableCrossFadeFactory(ViewAnimationFactory<T> viewAnimationFactory, int i) {
        this.f4967a = viewAnimationFactory;
        this.f4968b = i;
    }

    @Override // com.bumptech.glide.request.animation.GlideAnimationFactory
    /* JADX INFO: renamed from: a */
    public GlideAnimation<T> mo5540a(boolean z, boolean z2) {
        if (z) {
            return NoAnimation.m5548b();
        }
        if (z2) {
            return m5538a();
        }
        return m5539b();
    }

    /* JADX INFO: renamed from: a */
    private GlideAnimation<T> m5538a() {
        if (this.f4969c == null) {
            this.f4969c = new DrawableCrossFadeViewAnimation<>(this.f4967a.mo5540a(false, true), this.f4968b);
        }
        return this.f4969c;
    }

    /* JADX INFO: renamed from: b */
    private GlideAnimation<T> m5539b() {
        if (this.f4970d == null) {
            this.f4970d = new DrawableCrossFadeViewAnimation<>(this.f4967a.mo5540a(false, false), this.f4968b);
        }
        return this.f4970d;
    }

    private static class DefaultAnimationFactory implements ViewAnimation.AnimationFactory {

        /* JADX INFO: renamed from: a */
        private final int f4971a;

        DefaultAnimationFactory(int i) {
            this.f4971a = i;
        }

        @Override // com.bumptech.glide.request.animation.ViewAnimation.AnimationFactory
        /* JADX INFO: renamed from: a */
        public Animation mo5541a() {
            AlphaAnimation alphaAnimation = new AlphaAnimation(CropImageView.DEFAULT_ASPECT_RATIO, 1.0f);
            alphaAnimation.setDuration(this.f4971a);
            return alphaAnimation;
        }
    }
}
