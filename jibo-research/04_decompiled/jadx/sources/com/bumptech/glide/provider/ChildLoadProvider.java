package com.bumptech.glide.provider;

import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.resource.transcode.ResourceTranscoder;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public class ChildLoadProvider<A, T, Z, R> implements LoadProvider<A, T, Z, R>, Cloneable {

    /* JADX INFO: renamed from: a */
    private final LoadProvider<A, T, Z, R> f4922a;

    /* JADX INFO: renamed from: b */
    private ResourceDecoder<File, Z> f4923b;

    /* JADX INFO: renamed from: c */
    private ResourceDecoder<T, Z> f4924c;

    /* JADX INFO: renamed from: d */
    private ResourceEncoder<Z> f4925d;

    /* JADX INFO: renamed from: e */
    private ResourceTranscoder<Z, R> f4926e;

    /* JADX INFO: renamed from: f */
    private Encoder<T> f4927f;

    public ChildLoadProvider(LoadProvider<A, T, Z, R> loadProvider) {
        this.f4922a = loadProvider;
    }

    @Override // com.bumptech.glide.provider.LoadProvider
    /* JADX INFO: renamed from: a */
    public ModelLoader<A, T> mo5495a() {
        return this.f4922a.mo5495a();
    }

    /* JADX INFO: renamed from: a */
    public void m5497a(ResourceDecoder<T, Z> resourceDecoder) {
        this.f4924c = resourceDecoder;
    }

    /* JADX INFO: renamed from: a */
    public void m5496a(Encoder<T> encoder) {
        this.f4927f = encoder;
    }

    @Override // com.bumptech.glide.provider.DataLoadProvider
    public ResourceDecoder<File, Z> getCacheDecoder() {
        return this.f4923b != null ? this.f4923b : this.f4922a.getCacheDecoder();
    }

    @Override // com.bumptech.glide.provider.DataLoadProvider
    public ResourceDecoder<T, Z> getSourceDecoder() {
        return this.f4924c != null ? this.f4924c : this.f4922a.getSourceDecoder();
    }

    @Override // com.bumptech.glide.provider.DataLoadProvider
    public Encoder<T> getSourceEncoder() {
        return this.f4927f != null ? this.f4927f : this.f4922a.getSourceEncoder();
    }

    @Override // com.bumptech.glide.provider.DataLoadProvider
    public ResourceEncoder<Z> getEncoder() {
        return this.f4925d != null ? this.f4925d : this.f4922a.getEncoder();
    }

    @Override // com.bumptech.glide.provider.LoadProvider
    /* JADX INFO: renamed from: b */
    public ResourceTranscoder<Z, R> mo5498b() {
        return this.f4926e != null ? this.f4926e : this.f4922a.mo5498b();
    }

    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public ChildLoadProvider<A, T, Z, R> clone() {
        try {
            return (ChildLoadProvider) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
