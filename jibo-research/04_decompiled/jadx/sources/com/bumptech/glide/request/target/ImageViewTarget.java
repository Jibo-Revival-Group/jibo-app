package com.bumptech.glide.request.target;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.bumptech.glide.request.animation.GlideAnimation;

/* JADX INFO: loaded from: classes.dex */
public abstract class ImageViewTarget<Z> extends ViewTarget<ImageView, Z> implements GlideAnimation.ViewAdapter {
    /* JADX INFO: renamed from: a */
    protected abstract void mo5550a(Z z);

    public ImageViewTarget(ImageView imageView) {
        super(imageView);
    }

    @Override // com.bumptech.glide.request.animation.GlideAnimation.ViewAdapter
    /* JADX INFO: renamed from: b */
    public Drawable mo5546b() {
        return ((ImageView) this.f4988a).getDrawable();
    }

    @Override // com.bumptech.glide.request.animation.GlideAnimation.ViewAdapter
    /* JADX INFO: renamed from: a */
    public void mo5545a(Drawable drawable) {
        ((ImageView) this.f4988a).setImageDrawable(drawable);
    }

    @Override // com.bumptech.glide.request.target.BaseTarget, com.bumptech.glide.request.target.Target
    public void onLoadStarted(Drawable drawable) {
        ((ImageView) this.f4988a).setImageDrawable(drawable);
    }

    @Override // com.bumptech.glide.request.target.BaseTarget, com.bumptech.glide.request.target.Target
    public void onLoadFailed(Exception exc, Drawable drawable) {
        ((ImageView) this.f4988a).setImageDrawable(drawable);
    }

    @Override // com.bumptech.glide.request.target.BaseTarget, com.bumptech.glide.request.target.Target
    public void onLoadCleared(Drawable drawable) {
        ((ImageView) this.f4988a).setImageDrawable(drawable);
    }

    @Override // com.bumptech.glide.request.target.Target
    public void onResourceReady(Z z, GlideAnimation<? super Z> glideAnimation) {
        if (glideAnimation == null || !glideAnimation.mo5543a(z, this)) {
            mo5550a(z);
        }
    }
}
