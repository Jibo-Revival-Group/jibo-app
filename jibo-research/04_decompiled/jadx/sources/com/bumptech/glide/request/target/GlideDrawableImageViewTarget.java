package com.bumptech.glide.request.target;

import android.widget.ImageView;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.animation.GlideAnimation;

/* JADX INFO: loaded from: classes.dex */
public class GlideDrawableImageViewTarget extends ImageViewTarget<GlideDrawable> {

    /* JADX INFO: renamed from: b */
    private int f4979b;

    /* JADX INFO: renamed from: c */
    private GlideDrawable f4980c;

    public GlideDrawableImageViewTarget(ImageView imageView) {
        this(imageView, -1);
    }

    public GlideDrawableImageViewTarget(ImageView imageView, int i) {
        super(imageView);
        this.f4979b = i;
    }

    @Override // com.bumptech.glide.request.target.ImageViewTarget, com.bumptech.glide.request.target.Target
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onResourceReady(GlideDrawable glideDrawable, GlideAnimation<? super GlideDrawable> glideAnimation) {
        if (!glideDrawable.isAnimated()) {
            float intrinsicWidth = glideDrawable.getIntrinsicWidth() / glideDrawable.getIntrinsicHeight();
            if (Math.abs((((ImageView) this.f4988a).getWidth() / ((ImageView) this.f4988a).getHeight()) - 1.0f) <= 0.05f && Math.abs(intrinsicWidth - 1.0f) <= 0.05f) {
                glideDrawable = new SquaringDrawable(glideDrawable, ((ImageView) this.f4988a).getWidth());
            }
        }
        super.onResourceReady(glideDrawable, glideAnimation);
        this.f4980c = glideDrawable;
        glideDrawable.setLoopCount(this.f4979b);
        glideDrawable.start();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bumptech.glide.request.target.ImageViewTarget
    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public void mo5550a(GlideDrawable glideDrawable) {
        ((ImageView) this.f4988a).setImageDrawable(glideDrawable);
    }

    @Override // com.bumptech.glide.request.target.BaseTarget, com.bumptech.glide.manager.LifecycleListener
    public void onStart() {
        if (this.f4980c != null) {
            this.f4980c.start();
        }
    }

    @Override // com.bumptech.glide.request.target.BaseTarget, com.bumptech.glide.manager.LifecycleListener
    public void onStop() {
        if (this.f4980c != null) {
            this.f4980c.stop();
        }
    }
}
