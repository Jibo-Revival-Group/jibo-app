package com.google.android.gms.common;

import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
abstract class zzj extends zzh {

    /* JADX INFO: renamed from: b */
    private static final WeakReference<byte[]> f6710b = new WeakReference<>(null);

    /* JADX INFO: renamed from: a */
    private WeakReference<byte[]> f6711a;

    zzj(byte[] bArr) {
        super(bArr);
        this.f6711a = f6710b;
    }

    @Override // com.google.android.gms.common.zzh
    /* JADX INFO: renamed from: c */
    final byte[] mo7542c() {
        byte[] bArrMo7543d;
        synchronized (this) {
            bArrMo7543d = this.f6711a.get();
            if (bArrMo7543d == null) {
                bArrMo7543d = mo7543d();
                this.f6711a = new WeakReference<>(bArrMo7543d);
            }
        }
        return bArrMo7543d;
    }

    /* JADX INFO: renamed from: d */
    protected abstract byte[] mo7543d();
}
