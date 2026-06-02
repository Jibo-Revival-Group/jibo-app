package com.bumptech.glide.request.target;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;

/* JADX INFO: loaded from: classes.dex */
public class DrawableImageViewTarget extends ImageViewTarget<Drawable> {
    public DrawableImageViewTarget(ImageView imageView) {
        super(imageView);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bumptech.glide.request.target.ImageViewTarget
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public void mo5550a(Drawable drawable) {
        ((ImageView) this.f4988a).setImageDrawable(drawable);
    }
}
