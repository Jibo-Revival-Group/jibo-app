package com.bumptech.glide.request.animation;

import com.bumptech.glide.request.animation.GlideAnimation;

/* JADX INFO: loaded from: classes.dex */
public class NoAnimation<R> implements GlideAnimation<R> {

    /* JADX INFO: renamed from: a */
    private static final NoAnimation<?> f4974a = new NoAnimation<>();

    /* JADX INFO: renamed from: b */
    private static final GlideAnimationFactory<?> f4975b = new NoAnimationFactory();

    public static class NoAnimationFactory<R> implements GlideAnimationFactory<R> {
        @Override // com.bumptech.glide.request.animation.GlideAnimationFactory
        /* JADX INFO: renamed from: a */
        public GlideAnimation<R> mo5540a(boolean z, boolean z2) {
            return NoAnimation.f4974a;
        }
    }

    /* JADX INFO: renamed from: a */
    public static <R> GlideAnimationFactory<R> m5547a() {
        return (GlideAnimationFactory<R>) f4975b;
    }

    /* JADX INFO: renamed from: b */
    public static <R> GlideAnimation<R> m5548b() {
        return f4974a;
    }

    @Override // com.bumptech.glide.request.animation.GlideAnimation
    /* JADX INFO: renamed from: a */
    public boolean mo5543a(Object obj, GlideAnimation.ViewAdapter viewAdapter) {
        return false;
    }
}
