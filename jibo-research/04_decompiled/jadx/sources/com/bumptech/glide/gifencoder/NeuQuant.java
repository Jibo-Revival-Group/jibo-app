package com.bumptech.glide.gifencoder;

import com.facebook.internal.NativeProtocol;
import com.google.api.client.googleapis.media.MediaHttpUploader;

/* JADX INFO: loaded from: classes.dex */
class NeuQuant {

    /* JADX INFO: renamed from: a */
    protected int f4872a;

    /* JADX INFO: renamed from: b */
    protected byte[] f4873b;

    /* JADX INFO: renamed from: c */
    protected int f4874c;

    /* JADX INFO: renamed from: d */
    protected int f4875d;

    /* JADX INFO: renamed from: f */
    protected int[] f4877f = new int[256];

    /* JADX INFO: renamed from: g */
    protected int[] f4878g = new int[256];

    /* JADX INFO: renamed from: h */
    protected int[] f4879h = new int[256];

    /* JADX INFO: renamed from: i */
    protected int[] f4880i = new int[32];

    /* JADX INFO: renamed from: e */
    protected int[][] f4876e = new int[256][];

    public NeuQuant(byte[] bArr, int i, int i2) {
        this.f4873b = bArr;
        this.f4874c = i;
        this.f4875d = i2;
        for (int i3 = 0; i3 < 256; i3++) {
            this.f4876e[i3] = new int[4];
            int[] iArr = this.f4876e[i3];
            int i4 = (i3 << 12) / 256;
            iArr[2] = i4;
            iArr[1] = i4;
            iArr[0] = i4;
            this.f4879h[i3] = 256;
            this.f4878g[i3] = 0;
        }
    }

    /* JADX INFO: renamed from: a */
    public byte[] m5407a() {
        byte[] bArr = new byte[768];
        int[] iArr = new int[256];
        for (int i = 0; i < 256; i++) {
            iArr[this.f4876e[i][3]] = i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < 256; i3++) {
            int i4 = iArr[i3];
            int i5 = i2 + 1;
            bArr[i2] = (byte) this.f4876e[i4][0];
            int i6 = i5 + 1;
            bArr[i5] = (byte) this.f4876e[i4][1];
            i2 = i6 + 1;
            bArr[i6] = (byte) this.f4876e[i4][2];
        }
        return bArr;
    }

    /* JADX INFO: renamed from: b */
    public void m5409b() {
        int i;
        int i2;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (i3 < 256) {
            int[] iArr = this.f4876e[i3];
            int i6 = iArr[1];
            int i7 = i3;
            for (int i8 = i3 + 1; i8 < 256; i8++) {
                int[] iArr2 = this.f4876e[i8];
                if (iArr2[1] < i6) {
                    i6 = iArr2[1];
                    i7 = i8;
                }
            }
            int[] iArr3 = this.f4876e[i7];
            if (i3 != i7) {
                int i9 = iArr3[0];
                iArr3[0] = iArr[0];
                iArr[0] = i9;
                int i10 = iArr3[1];
                iArr3[1] = iArr[1];
                iArr[1] = i10;
                int i11 = iArr3[2];
                iArr3[2] = iArr[2];
                iArr[2] = i11;
                int i12 = iArr3[3];
                iArr3[3] = iArr[3];
                iArr[3] = i12;
            }
            if (i6 != i5) {
                this.f4877f[i5] = (i4 + i3) >> 1;
                for (int i13 = i5 + 1; i13 < i6; i13++) {
                    this.f4877f[i13] = i3;
                }
                i2 = i6;
                i = i3;
            } else {
                i = i4;
                i2 = i5;
            }
            i3++;
            i4 = i;
            i5 = i2;
        }
        this.f4877f[i5] = (i4 + 255) >> 1;
        for (int i14 = i5 + 1; i14 < 256; i14++) {
            this.f4877f[i14] = 255;
        }
    }

    /* JADX INFO: renamed from: c */
    public void m5411c() {
        int i;
        if (this.f4874c < 1509) {
            this.f4875d = 1;
        }
        this.f4872a = ((this.f4875d - 1) / 3) + 30;
        byte[] bArr = this.f4873b;
        int i2 = this.f4874c;
        int i3 = this.f4874c / (this.f4875d * 3);
        int i4 = i3 / 100;
        for (int i5 = 0; i5 < 32; i5++) {
            this.f4880i[i5] = (((1024 - (i5 * i5)) * 256) / 1024) * 1024;
        }
        if (this.f4874c < 1509) {
            i = 3;
        } else if (this.f4874c % 499 != 0) {
            i = 1497;
        } else if (this.f4874c % 491 != 0) {
            i = 1473;
        } else if (this.f4874c % 487 != 0) {
            i = 1461;
        } else {
            i = 1509;
        }
        int i6 = 0;
        int i7 = 32;
        int i8 = 2048;
        int i9 = 0;
        int i10 = 1024;
        while (i6 < i3) {
            int i11 = (bArr[i9 + 0] & 255) << 4;
            int i12 = (bArr[i9 + 1] & 255) << 4;
            int i13 = (bArr[i9 + 2] & 255) << 4;
            int iM5408b = m5408b(i11, i12, i13);
            m5410b(i10, iM5408b, i11, i12, i13);
            if (i7 != 0) {
                m5406a(i7, iM5408b, i11, i12, i13);
            }
            int i14 = i9 + i;
            int i15 = i14 >= i2 ? i14 - this.f4874c : i14;
            int i16 = i6 + 1;
            int i17 = i4 == 0 ? 1 : i4;
            if (i16 % i17 == 0) {
                int i18 = i10 - (i10 / this.f4872a);
                int i19 = i8 - (i8 / 30);
                int i20 = i19 >> 6;
                if (i20 <= 1) {
                    i20 = 0;
                }
                for (int i21 = 0; i21 < i20; i21++) {
                    this.f4880i[i21] = ((((i20 * i20) - (i21 * i21)) * 256) / (i20 * i20)) * i18;
                }
                i6 = i16;
                i7 = i20;
                i8 = i19;
                i4 = i17;
                i9 = i15;
                i10 = i18;
            } else {
                i6 = i16;
                i4 = i17;
                i9 = i15;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x0075 A[PHI: r1
      0x0075: PHI (r1v2 int) = (r1v1 int), (r1v13 int), (r1v13 int) binds: [B:5:0x0016, B:20:0x0041, B:25:0x004a] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int m5405a(int r13, int r14, int r15) {
        /*
            r12 = this;
            r11 = 2
            r10 = 1
            r9 = 0
            r7 = -1
            r3 = 256(0x100, float:3.59E-43)
            r5 = 1000(0x3e8, float:1.401E-42)
            int[] r0 = r12.f4877f
            r2 = r0[r14]
            int r0 = r2 + (-1)
            r6 = r0
            r1 = r2
            r4 = r5
            r2 = r7
        L12:
            if (r1 < r3) goto L16
            if (r6 < 0) goto L70
        L16:
            if (r1 >= r3) goto L75
            int[][] r0 = r12.f4876e
            r8 = r0[r1]
            r0 = r8[r10]
            int r0 = r0 - r14
            if (r0 < r4) goto L35
            r5 = r4
            r4 = r2
            r2 = r3
        L24:
            if (r6 < 0) goto L71
            int[][] r0 = r12.f4876e
            r8 = r0[r6]
            r0 = r8[r10]
            int r0 = r14 - r0
            if (r0 < r5) goto L52
            r6 = r7
            r1 = r2
            r2 = r4
            r4 = r5
            goto L12
        L35:
            int r1 = r1 + 1
            if (r0 >= 0) goto L3a
            int r0 = -r0
        L3a:
            r5 = r8[r9]
            int r5 = r5 - r13
            if (r5 >= 0) goto L40
            int r5 = -r5
        L40:
            int r5 = r5 + r0
            if (r5 >= r4) goto L75
            r0 = r8[r11]
            int r0 = r0 - r15
            if (r0 >= 0) goto L49
            int r0 = -r0
        L49:
            int r5 = r5 + r0
            if (r5 >= r4) goto L75
            r0 = 3
            r0 = r8[r0]
            r2 = r1
            r4 = r0
            goto L24
        L52:
            int r6 = r6 + (-1)
            if (r0 >= 0) goto L57
            int r0 = -r0
        L57:
            r1 = r8[r9]
            int r1 = r1 - r13
            if (r1 >= 0) goto L5d
            int r1 = -r1
        L5d:
            int r1 = r1 + r0
            if (r1 >= r5) goto L71
            r0 = r8[r11]
            int r0 = r0 - r15
            if (r0 >= 0) goto L66
            int r0 = -r0
        L66:
            int r0 = r0 + r1
            if (r0 >= r5) goto L71
            r1 = 3
            r4 = r8[r1]
            r1 = r2
            r2 = r4
            r4 = r0
            goto L12
        L70:
            return r2
        L71:
            r1 = r2
            r2 = r4
            r4 = r5
            goto L12
        L75:
            r5 = r4
            r4 = r2
            r2 = r1
            goto L24
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.gifencoder.NeuQuant.m5405a(int, int, int):int");
    }

    /* JADX INFO: renamed from: d */
    public byte[] m5412d() {
        m5411c();
        m5413e();
        m5409b();
        return m5407a();
    }

    /* JADX INFO: renamed from: e */
    public void m5413e() {
        for (int i = 0; i < 256; i++) {
            int[] iArr = this.f4876e[i];
            iArr[0] = iArr[0] >> 4;
            int[] iArr2 = this.f4876e[i];
            iArr2[1] = iArr2[1] >> 4;
            int[] iArr3 = this.f4876e[i];
            iArr3[2] = iArr3[2] >> 4;
            this.f4876e[i][3] = i;
        }
    }

    /* JADX INFO: renamed from: a */
    protected void m5406a(int i, int i2, int i3, int i4, int i5) {
        int i6;
        int i7 = i2 - i;
        int i8 = i7 < -1 ? -1 : i7;
        int i9 = i2 + i;
        if (i9 > 256) {
            i9 = 256;
        }
        int i10 = 1;
        int i11 = i2 - 1;
        int i12 = i2 + 1;
        while (true) {
            if (i12 < i9 || i11 > i8) {
                int i13 = i10 + 1;
                int i14 = this.f4880i[i10];
                if (i12 < i9) {
                    i6 = i12 + 1;
                    int[] iArr = this.f4876e[i12];
                    try {
                        iArr[0] = iArr[0] - (((iArr[0] - i3) * i14) / MediaHttpUploader.MINIMUM_CHUNK_SIZE);
                        iArr[1] = iArr[1] - (((iArr[1] - i4) * i14) / MediaHttpUploader.MINIMUM_CHUNK_SIZE);
                        iArr[2] = iArr[2] - (((iArr[2] - i5) * i14) / MediaHttpUploader.MINIMUM_CHUNK_SIZE);
                    } catch (Exception e) {
                    }
                } else {
                    i6 = i12;
                }
                if (i11 > i8) {
                    int i15 = i11 - 1;
                    int[] iArr2 = this.f4876e[i11];
                    try {
                        iArr2[0] = iArr2[0] - (((iArr2[0] - i3) * i14) / MediaHttpUploader.MINIMUM_CHUNK_SIZE);
                        iArr2[1] = iArr2[1] - (((iArr2[1] - i4) * i14) / MediaHttpUploader.MINIMUM_CHUNK_SIZE);
                        iArr2[2] = iArr2[2] - ((i14 * (iArr2[2] - i5)) / MediaHttpUploader.MINIMUM_CHUNK_SIZE);
                        i11 = i15;
                        i12 = i6;
                        i10 = i13;
                    } catch (Exception e2) {
                        i11 = i15;
                        i12 = i6;
                        i10 = i13;
                    }
                } else {
                    i12 = i6;
                    i10 = i13;
                }
            } else {
                return;
            }
        }
    }

    /* JADX INFO: renamed from: b */
    protected void m5410b(int i, int i2, int i3, int i4, int i5) {
        int[] iArr = this.f4876e[i2];
        iArr[0] = iArr[0] - (((iArr[0] - i3) * i) / 1024);
        iArr[1] = iArr[1] - (((iArr[1] - i4) * i) / 1024);
        iArr[2] = iArr[2] - (((iArr[2] - i5) * i) / 1024);
    }

    /* JADX INFO: renamed from: b */
    protected int m5408b(int i, int i2, int i3) {
        int i4;
        int i5;
        int i6;
        int i7;
        int i8 = Integer.MAX_VALUE;
        int i9 = -1;
        int i10 = 0;
        int i11 = -1;
        int i12 = Integer.MAX_VALUE;
        while (i10 < 256) {
            int[] iArr = this.f4876e[i10];
            int i13 = iArr[0] - i;
            if (i13 < 0) {
                i13 = -i13;
            }
            int i14 = iArr[1] - i2;
            if (i14 < 0) {
                i14 = -i14;
            }
            int i15 = i14 + i13;
            int i16 = iArr[2] - i3;
            if (i16 < 0) {
                i16 = -i16;
            }
            int i17 = i15 + i16;
            if (i17 < i12) {
                i4 = i10;
                i5 = i17;
            } else {
                i4 = i11;
                i5 = i12;
            }
            int i18 = i17 - (this.f4878g[i10] >> 12);
            if (i18 < i8) {
                i7 = i18;
                i6 = i10;
            } else {
                i6 = i9;
                i7 = i8;
            }
            int i19 = this.f4879h[i10] >> 10;
            int[] iArr2 = this.f4879h;
            iArr2[i10] = iArr2[i10] - i19;
            int[] iArr3 = this.f4878g;
            iArr3[i10] = (i19 << 10) + iArr3[i10];
            i10++;
            i9 = i6;
            i8 = i7;
            i12 = i5;
            i11 = i4;
        }
        int[] iArr4 = this.f4879h;
        iArr4[i11] = iArr4[i11] + 64;
        int[] iArr5 = this.f4878g;
        iArr5[i11] = iArr5[i11] - NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
        return i9;
    }
}
