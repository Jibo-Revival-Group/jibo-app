package com.bumptech.glide.provider;

import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.resource.transcode.ResourceTranscoder;

/* JADX INFO: loaded from: classes.dex */
public interface LoadProvider<A, T, Z, R> extends DataLoadProvider<T, Z> {
    /* JADX INFO: renamed from: a */
    ModelLoader<A, T> mo5495a();

    /* JADX INFO: renamed from: b */
    ResourceTranscoder<Z, R> mo5498b();
}
