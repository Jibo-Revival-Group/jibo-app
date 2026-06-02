package com.bumptech.glide.load.data;

import com.bumptech.glide.Priority;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public class ByteArrayFetcher implements DataFetcher<InputStream> {
    private final byte[] bytes;

    /* JADX INFO: renamed from: id */
    private final String f4882id;

    public ByteArrayFetcher(byte[] bArr, String str) {
        this.bytes = bArr;
        this.f4882id = str;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bumptech.glide.load.data.DataFetcher
    public InputStream loadData(Priority priority) {
        return new ByteArrayInputStream(this.bytes);
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public void cleanup() {
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public String getId() {
        return this.f4882id;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public void cancel() {
    }
}
