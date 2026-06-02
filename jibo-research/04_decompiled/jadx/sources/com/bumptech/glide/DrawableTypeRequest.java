package com.bumptech.glide;

import android.content.Context;
import android.os.ParcelFileDescriptor;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.model.ImageVideoModelLoader;
import com.bumptech.glide.load.model.ImageVideoWrapper;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.load.resource.gifbitmap.GifBitmapWrapper;
import com.bumptech.glide.load.resource.transcode.ResourceTranscoder;
import com.bumptech.glide.manager.Lifecycle;
import com.bumptech.glide.manager.RequestTracker;
import com.bumptech.glide.provider.FixedLoadProvider;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public class DrawableTypeRequest<ModelType> extends DrawableRequestBuilder<ModelType> {

    /* JADX INFO: renamed from: g */
    private final ModelLoader<ModelType, InputStream> f4665g;

    /* JADX INFO: renamed from: h */
    private final ModelLoader<ModelType, ParcelFileDescriptor> f4666h;

    /* JADX INFO: renamed from: i */
    private final RequestManager.OptionsApplier f4667i;

    /* JADX INFO: renamed from: a */
    private static <A, Z, R> FixedLoadProvider<A, ImageVideoWrapper, Z, R> m5241a(Glide glide, ModelLoader<A, InputStream> modelLoader, ModelLoader<A, ParcelFileDescriptor> modelLoader2, Class<Z> cls, Class<R> cls2, ResourceTranscoder<Z, R> resourceTranscoder) {
        if (modelLoader == null && modelLoader2 == null) {
            return null;
        }
        if (resourceTranscoder == null) {
            resourceTranscoder = glide.m5258a(cls, cls2);
        }
        return new FixedLoadProvider<>(new ImageVideoModelLoader(modelLoader, modelLoader2), resourceTranscoder, glide.m5263b(ImageVideoWrapper.class, cls));
    }

    DrawableTypeRequest(Class<ModelType> cls, ModelLoader<ModelType, InputStream> modelLoader, ModelLoader<ModelType, ParcelFileDescriptor> modelLoader2, Context context, Glide glide, RequestTracker requestTracker, Lifecycle lifecycle, RequestManager.OptionsApplier optionsApplier) {
        super(context, cls, m5241a(glide, modelLoader, modelLoader2, GifBitmapWrapper.class, GlideDrawable.class, null), glide, requestTracker, lifecycle);
        this.f4665g = modelLoader;
        this.f4666h = modelLoader2;
        this.f4667i = optionsApplier;
    }
}
