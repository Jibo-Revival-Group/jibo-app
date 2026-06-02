package com.google.android.gms.common;

import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
final class zzi extends zzh {

    /* JADX INFO: renamed from: a */
    private final byte[] f6709a;

    zzi(byte[] bArr) {
        super(Arrays.copyOfRange(bArr, 0, 25));
        this.f6709a = bArr;
    }

    @Override // com.google.android.gms.common.zzh
    /* JADX INFO: renamed from: c */
    final byte[] mo7542c() {
        return this.f6709a;
    }
}
