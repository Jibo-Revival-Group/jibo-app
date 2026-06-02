package com.google.android.gms.internal;

import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
final class zzcgy implements Iterator<String> {

    /* JADX INFO: renamed from: a */
    private Iterator<String> f7154a;

    /* JADX INFO: renamed from: b */
    private /* synthetic */ zzcgx f7155b;

    zzcgy(zzcgx zzcgxVar) {
        this.f7155b = zzcgxVar;
        this.f7154a = this.f7155b.f7153a.keySet().iterator();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f7154a.hasNext();
    }

    @Override // java.util.Iterator
    public final /* synthetic */ String next() {
        return this.f7154a.next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Remove not supported");
    }
}
