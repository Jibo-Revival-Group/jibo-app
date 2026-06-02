package com.bumptech.glide;

import android.content.Context;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.resource.transcode.ResourceTranscoder;
import com.bumptech.glide.load.resource.transcode.UnitTranscoder;
import com.bumptech.glide.manager.Lifecycle;
import com.bumptech.glide.manager.RequestTracker;
import com.bumptech.glide.provider.FixedLoadProvider;
import com.bumptech.glide.provider.LoadProvider;

/* JADX INFO: loaded from: classes.dex */
public class GenericTranscodeRequest<ModelType, DataType, ResourceType> extends GenericRequestBuilder<ModelType, DataType, ResourceType, ResourceType> {

    /* JADX INFO: renamed from: g */
    private final ModelLoader<ModelType, DataType> f4698g;

    /* JADX INFO: renamed from: h */
    private final Class<DataType> f4699h;

    /* JADX INFO: renamed from: i */
    private final Class<ResourceType> f4700i;

    /* JADX INFO: renamed from: j */
    private final RequestManager.OptionsApplier f4701j;

    /* JADX INFO: renamed from: a */
    private static <A, T, Z, R> LoadProvider<A, T, Z, R> m5248a(Glide glide, ModelLoader<A, T> modelLoader, Class<T> cls, Class<Z> cls2, ResourceTranscoder<Z, R> resourceTranscoder) {
        return new FixedLoadProvider(modelLoader, resourceTranscoder, glide.m5263b(cls, cls2));
    }

    GenericTranscodeRequest(Context context, Glide glide, Class<ModelType> cls, ModelLoader<ModelType, DataType> modelLoader, Class<DataType> cls2, Class<ResourceType> cls3, RequestTracker requestTracker, Lifecycle lifecycle, RequestManager.OptionsApplier optionsApplier) {
        super(context, cls, m5248a(glide, modelLoader, cls2, cls3, UnitTranscoder.get()), cls3, glide, requestTracker, lifecycle);
        this.f4698g = modelLoader;
        this.f4699h = cls2;
        this.f4700i = cls3;
        this.f4701j = optionsApplier;
    }
}
