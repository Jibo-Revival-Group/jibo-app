package com.google.android.gms.common.data;

import com.google.android.gms.common.internal.zzbq;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes.dex */
public class zzb<T> implements Iterator<T> {

    /* JADX INFO: renamed from: a */
    protected final DataBuffer<T> f6483a;

    /* JADX INFO: renamed from: b */
    protected int f6484b = -1;

    public zzb(DataBuffer<T> dataBuffer) {
        this.f6483a = (DataBuffer) zzbq.m7373a(dataBuffer);
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f6484b < this.f6483a.mo7261b() + (-1);
    }

    @Override // java.util.Iterator
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException(new StringBuilder(46).append("Cannot advance the iterator beyond ").append(this.f6484b).toString());
        }
        DataBuffer<T> dataBuffer = this.f6483a;
        int i = this.f6484b + 1;
        this.f6484b = i;
        return dataBuffer.mo7265a(i);
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Cannot remove elements from a DataBufferIterator");
    }
}
