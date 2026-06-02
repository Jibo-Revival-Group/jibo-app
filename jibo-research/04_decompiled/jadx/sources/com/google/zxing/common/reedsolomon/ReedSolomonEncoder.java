package com.google.zxing.common.reedsolomon;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class ReedSolomonEncoder {

    /* JADX INFO: renamed from: a */
    private final GenericGF f9098a;

    /* JADX INFO: renamed from: b */
    private final List<GenericGFPoly> f9099b = new ArrayList();

    public ReedSolomonEncoder(GenericGF genericGF) {
        this.f9098a = genericGF;
        this.f9099b.add(new GenericGFPoly(genericGF, new int[]{1}));
    }

    /* JADX INFO: renamed from: a */
    private GenericGFPoly m9697a(int i) {
        if (i >= this.f9099b.size()) {
            GenericGFPoly genericGFPolyM9694b = this.f9099b.get(this.f9099b.size() - 1);
            for (int size = this.f9099b.size(); size <= i; size++) {
                genericGFPolyM9694b = genericGFPolyM9694b.m9694b(new GenericGFPoly(this.f9098a, new int[]{1, this.f9098a.m9682a((size - 1) + this.f9098a.m9685b())}));
                this.f9099b.add(genericGFPolyM9694b);
            }
        }
        return this.f9099b.get(i);
    }

    /* JADX INFO: renamed from: a */
    public void m9698a(int[] iArr, int i) {
        if (i == 0) {
            throw new IllegalArgumentException("No error correction bytes");
        }
        int length = iArr.length - i;
        if (length <= 0) {
            throw new IllegalArgumentException("No data bytes provided");
        }
        GenericGFPoly genericGFPolyM9697a = m9697a(i);
        int[] iArr2 = new int[length];
        System.arraycopy(iArr, 0, iArr2, 0, length);
        int[] iArrM9692a = new GenericGFPoly(this.f9098a, iArr2).m9690a(i, 1).m9696c(genericGFPolyM9697a)[1].m9692a();
        int length2 = i - iArrM9692a.length;
        for (int i2 = 0; i2 < length2; i2++) {
            iArr[length + i2] = 0;
        }
        System.arraycopy(iArrM9692a, 0, iArr, length + length2, iArrM9692a.length);
    }
}
