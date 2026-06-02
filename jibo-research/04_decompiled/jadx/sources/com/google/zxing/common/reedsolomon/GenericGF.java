package com.google.zxing.common.reedsolomon;

/* JADX INFO: loaded from: classes.dex */
public final class GenericGF {

    /* JADX INFO: renamed from: a */
    public static final GenericGF f9081a = new GenericGF(4201, 4096, 1);

    /* JADX INFO: renamed from: b */
    public static final GenericGF f9082b = new GenericGF(1033, 1024, 1);

    /* JADX INFO: renamed from: c */
    public static final GenericGF f9083c = new GenericGF(67, 64, 1);

    /* JADX INFO: renamed from: d */
    public static final GenericGF f9084d = new GenericGF(19, 16, 1);

    /* JADX INFO: renamed from: e */
    public static final GenericGF f9085e = new GenericGF(285, 256, 0);

    /* JADX INFO: renamed from: f */
    public static final GenericGF f9086f = new GenericGF(301, 256, 1);

    /* JADX INFO: renamed from: g */
    public static final GenericGF f9087g = f9086f;

    /* JADX INFO: renamed from: h */
    public static final GenericGF f9088h = f9083c;

    /* JADX INFO: renamed from: i */
    private final int[] f9089i;

    /* JADX INFO: renamed from: j */
    private final int[] f9090j;

    /* JADX INFO: renamed from: k */
    private final GenericGFPoly f9091k;

    /* JADX INFO: renamed from: l */
    private final GenericGFPoly f9092l;

    /* JADX INFO: renamed from: m */
    private final int f9093m;

    /* JADX INFO: renamed from: n */
    private final int f9094n;

    /* JADX INFO: renamed from: o */
    private final int f9095o;

    public GenericGF(int i, int i2, int i3) {
        this.f9094n = i;
        this.f9093m = i2;
        this.f9095o = i3;
        this.f9089i = new int[i2];
        this.f9090j = new int[i2];
        int i4 = 1;
        for (int i5 = 0; i5 < i2; i5++) {
            this.f9089i[i5] = i4;
            i4 *= 2;
            if (i4 >= i2) {
                i4 = (i4 ^ i) & (i2 - 1);
            }
        }
        for (int i6 = 0; i6 < i2 - 1; i6++) {
            this.f9090j[this.f9089i[i6]] = i6;
        }
        this.f9091k = new GenericGFPoly(this, new int[]{0});
        this.f9092l = new GenericGFPoly(this, new int[]{1});
    }

    /* JADX INFO: renamed from: a */
    GenericGFPoly m9683a() {
        return this.f9091k;
    }

    /* JADX INFO: renamed from: a */
    GenericGFPoly m9684a(int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException();
        }
        if (i2 == 0) {
            return this.f9091k;
        }
        int[] iArr = new int[i + 1];
        iArr[0] = i2;
        return new GenericGFPoly(this, iArr);
    }

    /* JADX INFO: renamed from: b */
    static int m9681b(int i, int i2) {
        return i ^ i2;
    }

    /* JADX INFO: renamed from: a */
    int m9682a(int i) {
        return this.f9089i[i];
    }

    /* JADX INFO: renamed from: b */
    int m9686b(int i) {
        if (i == 0) {
            throw new IllegalArgumentException();
        }
        return this.f9090j[i];
    }

    /* JADX INFO: renamed from: c */
    int m9687c(int i) {
        if (i == 0) {
            throw new ArithmeticException();
        }
        return this.f9089i[(this.f9093m - this.f9090j[i]) - 1];
    }

    /* JADX INFO: renamed from: c */
    int m9688c(int i, int i2) {
        if (i == 0 || i2 == 0) {
            return 0;
        }
        return this.f9089i[(this.f9090j[i] + this.f9090j[i2]) % (this.f9093m - 1)];
    }

    /* JADX INFO: renamed from: b */
    public int m9685b() {
        return this.f9095o;
    }

    public String toString() {
        return "GF(0x" + Integer.toHexString(this.f9094n) + ',' + this.f9093m + ')';
    }
}
