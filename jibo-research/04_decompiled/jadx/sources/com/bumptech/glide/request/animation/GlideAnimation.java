package com.bumptech.glide.request.animation;

import android.graphics.drawable.Drawable;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public interface GlideAnimation<R> {

    public interface ViewAdapter {
        /* JADX INFO: renamed from: a */
        View m5544a();

        /* JADX INFO: renamed from: a */
        void mo5545a(Drawable drawable);

        /* JADX INFO: renamed from: b */
        Drawable mo5546b();
    }

    /* JADX INFO: renamed from: a */
    boolean mo5543a(R r, ViewAdapter viewAdapter);
}
