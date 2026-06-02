package com.google.android.gms.common.data;

import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractDataBuffer<T> implements DataBuffer<T> {

    /* JADX INFO: renamed from: a */
    protected final DataHolder f6459a;

    protected AbstractDataBuffer(DataHolder dataHolder) {
        this.f6459a = dataHolder;
    }

    @Override // com.google.android.gms.common.data.DataBuffer
    /* JADX INFO: renamed from: b */
    public int mo7261b() {
        if (this.f6459a == null) {
            return 0;
        }
        return this.f6459a.f6467a;
    }

    @Override // com.google.android.gms.common.api.Releasable
    /* JADX INFO: renamed from: c_ */
    public void mo6926c_() {
        if (this.f6459a != null) {
            this.f6459a.close();
        }
    }

    @Override // java.lang.Iterable
    public Iterator<T> iterator() {
        return new zzb(this);
    }
}
