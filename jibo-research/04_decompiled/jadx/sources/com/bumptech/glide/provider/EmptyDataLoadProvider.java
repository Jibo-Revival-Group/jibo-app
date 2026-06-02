package com.bumptech.glide.provider;

import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.ResourceEncoder;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public class EmptyDataLoadProvider<T, Z> implements DataLoadProvider<T, Z> {

    /* JADX INFO: renamed from: a */
    private static final DataLoadProvider<?, ?> f4930a = new EmptyDataLoadProvider();

    /* JADX INFO: renamed from: a */
    public static <T, Z> DataLoadProvider<T, Z> m5502a() {
        return (DataLoadProvider<T, Z>) f4930a;
    }

    @Override // com.bumptech.glide.provider.DataLoadProvider
    public ResourceDecoder<File, Z> getCacheDecoder() {
        return null;
    }

    @Override // com.bumptech.glide.provider.DataLoadProvider
    public ResourceDecoder<T, Z> getSourceDecoder() {
        return null;
    }

    @Override // com.bumptech.glide.provider.DataLoadProvider
    public Encoder<T> getSourceEncoder() {
        return null;
    }

    @Override // com.bumptech.glide.provider.DataLoadProvider
    public ResourceEncoder<Z> getEncoder() {
        return null;
    }
}
