package com.bumptech.glide.provider;

import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.resource.transcode.ResourceTranscoder;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public class FixedLoadProvider<A, T, Z, R> implements LoadProvider<A, T, Z, R> {

    /* JADX INFO: renamed from: a */
    private final ModelLoader<A, T> f4931a;

    /* JADX INFO: renamed from: b */
    private final ResourceTranscoder<Z, R> f4932b;

    /* JADX INFO: renamed from: c */
    private final DataLoadProvider<T, Z> f4933c;

    public FixedLoadProvider(ModelLoader<A, T> modelLoader, ResourceTranscoder<Z, R> resourceTranscoder, DataLoadProvider<T, Z> dataLoadProvider) {
        if (modelLoader == null) {
            throw new NullPointerException("ModelLoader must not be null");
        }
        this.f4931a = modelLoader;
        if (resourceTranscoder == null) {
            throw new NullPointerException("Transcoder must not be null");
        }
        this.f4932b = resourceTranscoder;
        if (dataLoadProvider == null) {
            throw new NullPointerException("DataLoadProvider must not be null");
        }
        this.f4933c = dataLoadProvider;
    }

    @Override // com.bumptech.glide.provider.LoadProvider
    /* JADX INFO: renamed from: a */
    public ModelLoader<A, T> mo5495a() {
        return this.f4931a;
    }

    @Override // com.bumptech.glide.provider.LoadProvider
    /* JADX INFO: renamed from: b */
    public ResourceTranscoder<Z, R> mo5498b() {
        return this.f4932b;
    }

    @Override // com.bumptech.glide.provider.DataLoadProvider
    public ResourceDecoder<File, Z> getCacheDecoder() {
        return this.f4933c.getCacheDecoder();
    }

    @Override // com.bumptech.glide.provider.DataLoadProvider
    public ResourceDecoder<T, Z> getSourceDecoder() {
        return this.f4933c.getSourceDecoder();
    }

    @Override // com.bumptech.glide.provider.DataLoadProvider
    public Encoder<T> getSourceEncoder() {
        return this.f4933c.getSourceEncoder();
    }

    @Override // com.bumptech.glide.provider.DataLoadProvider
    public ResourceEncoder<Z> getEncoder() {
        return this.f4933c.getEncoder();
    }
}
