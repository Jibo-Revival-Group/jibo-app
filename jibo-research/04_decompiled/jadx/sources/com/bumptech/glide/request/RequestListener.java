package com.bumptech.glide.request;

import com.bumptech.glide.request.target.Target;

/* JADX INFO: loaded from: classes.dex */
public interface RequestListener<T, R> {
    /* JADX INFO: renamed from: a */
    boolean mo5532a(Exception exc, T t, Target<R> target, boolean z);

    /* JADX INFO: renamed from: a */
    boolean mo5533a(R r, T t, Target<R> target, boolean z, boolean z2);
}
