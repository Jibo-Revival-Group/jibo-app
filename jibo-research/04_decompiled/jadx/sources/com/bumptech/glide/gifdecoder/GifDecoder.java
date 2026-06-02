package com.bumptech.glide.gifdecoder;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.os.Build;
import android.util.Log;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class GifDecoder {

    /* JADX INFO: renamed from: a */
    private static final String f4783a = GifDecoder.class.getSimpleName();

    /* JADX INFO: renamed from: b */
    private static final Bitmap.Config f4784b = Bitmap.Config.ARGB_8888;

    /* JADX INFO: renamed from: c */
    private int[] f4785c;

    /* JADX INFO: renamed from: d */
    private ByteBuffer f4786d;

    /* JADX INFO: renamed from: f */
    private short[] f4788f;

    /* JADX INFO: renamed from: g */
    private byte[] f4789g;

    /* JADX INFO: renamed from: h */
    private byte[] f4790h;

    /* JADX INFO: renamed from: i */
    private byte[] f4791i;

    /* JADX INFO: renamed from: j */
    private int[] f4792j;

    /* JADX INFO: renamed from: k */
    private int f4793k;

    /* JADX INFO: renamed from: l */
    private byte[] f4794l;

    /* JADX INFO: renamed from: n */
    private BitmapProvider f4796n;

    /* JADX INFO: renamed from: o */
    private Bitmap f4797o;

    /* JADX INFO: renamed from: p */
    private boolean f4798p;

    /* JADX INFO: renamed from: q */
    private int f4799q;

    /* JADX INFO: renamed from: e */
    private final byte[] f4787e = new byte[256];

    /* JADX INFO: renamed from: m */
    private GifHeader f4795m = new GifHeader();

    public interface BitmapProvider {
        Bitmap obtain(int i, int i2, Bitmap.Config config);

        void release(Bitmap bitmap);
    }

    public GifDecoder(BitmapProvider bitmapProvider) {
        this.f4796n = bitmapProvider;
    }

    /* JADX INFO: renamed from: a */
    public void m5353a() {
        this.f4793k = (this.f4793k + 1) % this.f4795m.f4813c;
    }

    /* JADX INFO: renamed from: a */
    public int m5352a(int i) {
        if (i < 0 || i >= this.f4795m.f4813c) {
            return -1;
        }
        return this.f4795m.f4815e.get(i).f4808i;
    }

    /* JADX INFO: renamed from: b */
    public int m5355b() {
        if (this.f4795m.f4813c <= 0 || this.f4793k < 0) {
            return -1;
        }
        return m5352a(this.f4793k);
    }

    /* JADX INFO: renamed from: c */
    public int m5356c() {
        return this.f4795m.f4813c;
    }

    /* JADX INFO: renamed from: d */
    public int m5357d() {
        return this.f4793k;
    }

    /* JADX INFO: renamed from: e */
    public int m5358e() {
        return this.f4795m.f4823m;
    }

    /* JADX INFO: renamed from: f */
    public synchronized Bitmap m5359f() {
        Bitmap bitmap;
        int i = 0;
        synchronized (this) {
            if (this.f4795m.f4813c <= 0 || this.f4793k < 0) {
                if (Log.isLoggable(f4783a, 3)) {
                    Log.d(f4783a, "unable to decode frame, frameCount=" + this.f4795m.f4813c + " framePointer=" + this.f4793k);
                }
                this.f4799q = 1;
            }
            if (this.f4799q == 1 || this.f4799q == 2) {
                if (Log.isLoggable(f4783a, 3)) {
                    Log.d(f4783a, "Unable to decode frame, status=" + this.f4799q);
                }
                bitmap = null;
            } else {
                this.f4799q = 0;
                GifFrame gifFrame = this.f4795m.f4815e.get(this.f4793k);
                int i2 = this.f4793k - 1;
                GifFrame gifFrame2 = i2 >= 0 ? this.f4795m.f4815e.get(i2) : null;
                if (gifFrame.f4810k == null) {
                    this.f4785c = this.f4795m.f4811a;
                } else {
                    this.f4785c = gifFrame.f4810k;
                    if (this.f4795m.f4820j == gifFrame.f4807h) {
                        this.f4795m.f4822l = 0;
                    }
                }
                if (gifFrame.f4805f) {
                    int i3 = this.f4785c[gifFrame.f4807h];
                    this.f4785c[gifFrame.f4807h] = 0;
                    i = i3;
                }
                if (this.f4785c == null) {
                    if (Log.isLoggable(f4783a, 3)) {
                        Log.d(f4783a, "No Valid Color Table");
                    }
                    this.f4799q = 1;
                    bitmap = null;
                } else {
                    Bitmap bitmapM5346a = m5346a(gifFrame, gifFrame2);
                    if (gifFrame.f4805f) {
                        this.f4785c[gifFrame.f4807h] = i;
                    }
                    bitmap = bitmapM5346a;
                }
            }
        }
        return bitmap;
    }

    /* JADX INFO: renamed from: g */
    public void m5360g() {
        this.f4795m = null;
        this.f4794l = null;
        this.f4791i = null;
        this.f4792j = null;
        if (this.f4797o != null) {
            this.f4796n.release(this.f4797o);
        }
        this.f4797o = null;
        this.f4786d = null;
    }

    /* JADX INFO: renamed from: a */
    public void m5354a(GifHeader gifHeader, byte[] bArr) {
        this.f4795m = gifHeader;
        this.f4794l = bArr;
        this.f4799q = 0;
        this.f4793k = -1;
        this.f4786d = ByteBuffer.wrap(bArr);
        this.f4786d.rewind();
        this.f4786d.order(ByteOrder.LITTLE_ENDIAN);
        this.f4798p = false;
        Iterator<GifFrame> it = gifHeader.f4815e.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            } else if (it.next().f4806g == 3) {
                this.f4798p = true;
                break;
            }
        }
        this.f4791i = new byte[gifHeader.f4816f * gifHeader.f4817g];
        this.f4792j = new int[gifHeader.f4816f * gifHeader.f4817g];
    }

    /* JADX INFO: renamed from: a */
    private Bitmap m5346a(GifFrame gifFrame, GifFrame gifFrame2) {
        int i;
        int i2 = this.f4795m.f4816f;
        int i3 = this.f4795m.f4817g;
        int[] iArr = this.f4792j;
        if (gifFrame2 != null && gifFrame2.f4806g > 0) {
            if (gifFrame2.f4806g == 2) {
                int i4 = 0;
                if (!gifFrame.f4805f) {
                    i4 = this.f4795m.f4822l;
                }
                Arrays.fill(iArr, i4);
            } else if (gifFrame2.f4806g == 3 && this.f4797o != null) {
                this.f4797o.getPixels(iArr, 0, i2, 0, 0, i2, i3);
            }
        }
        m5348a(gifFrame);
        int i5 = 1;
        int i6 = 8;
        int i7 = 0;
        for (int i8 = 0; i8 < gifFrame.f4803d; i8++) {
            if (gifFrame.f4804e) {
                if (i7 >= gifFrame.f4803d) {
                    i5++;
                    switch (i5) {
                        case 2:
                            i7 = 4;
                            break;
                        case 3:
                            i7 = 2;
                            i6 = 4;
                            break;
                        case 4:
                            i7 = 1;
                            i6 = 2;
                            break;
                    }
                }
                int i9 = i7;
                i7 += i6;
                i = i9;
            } else {
                i = i8;
            }
            int i10 = i + gifFrame.f4801b;
            if (i10 < this.f4795m.f4817g) {
                int i11 = this.f4795m.f4816f * i10;
                int i12 = i11 + gifFrame.f4800a;
                int i13 = gifFrame.f4802c + i12;
                if (this.f4795m.f4816f + i11 < i13) {
                    i13 = this.f4795m.f4816f + i11;
                }
                int i14 = gifFrame.f4802c * i8;
                int i15 = i12;
                while (i15 < i13) {
                    int i16 = i14 + 1;
                    int i17 = this.f4785c[this.f4791i[i14] & 255];
                    if (i17 != 0) {
                        iArr[i15] = i17;
                    }
                    i15++;
                    i14 = i16;
                }
            }
        }
        if (this.f4798p && (gifFrame.f4806g == 0 || gifFrame.f4806g == 1)) {
            if (this.f4797o == null) {
                this.f4797o = m5351j();
            }
            this.f4797o.setPixels(iArr, 0, i2, 0, 0, i2, i3);
        }
        Bitmap bitmapM5351j = m5351j();
        bitmapM5351j.setPixels(iArr, 0, i2, 0, 0, i2, i3);
        return bitmapM5351j;
    }

    /* JADX INFO: renamed from: a */
    private void m5348a(GifFrame gifFrame) {
        int i;
        if (gifFrame != null) {
            this.f4786d.position(gifFrame.f4809j);
        }
        int i2 = gifFrame == null ? this.f4795m.f4816f * this.f4795m.f4817g : gifFrame.f4802c * gifFrame.f4803d;
        if (this.f4791i == null || this.f4791i.length < i2) {
            this.f4791i = new byte[i2];
        }
        if (this.f4788f == null) {
            this.f4788f = new short[4096];
        }
        if (this.f4789g == null) {
            this.f4789g = new byte[4096];
        }
        if (this.f4790h == null) {
            this.f4790h = new byte[4097];
        }
        int iM5349h = m5349h();
        int i3 = 1 << iM5349h;
        int i4 = i3 + 1;
        int i5 = i3 + 2;
        int i6 = iM5349h + 1;
        int i7 = (1 << i6) - 1;
        for (int i8 = 0; i8 < i3; i8++) {
            this.f4788f[i8] = 0;
            this.f4789g[i8] = (byte) i8;
        }
        int i9 = 0;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        int i14 = i7;
        int i15 = i5;
        int iM5350i = 0;
        int i16 = 0;
        int i17 = 0;
        int i18 = -1;
        int i19 = i6;
        while (true) {
            if (i9 >= i2) {
                break;
            }
            if (iM5350i == 0) {
                iM5350i = m5350i();
                if (iM5350i <= 0) {
                    this.f4799q = 3;
                    break;
                }
                i17 = 0;
            }
            i10 += (this.f4787e[i17] & 255) << i11;
            int i20 = i17 + 1;
            int i21 = iM5350i - 1;
            int i22 = i12;
            int i23 = i14;
            int i24 = i19;
            int i25 = i11 + 8;
            int i26 = i18;
            int i27 = i16;
            int i28 = i15;
            while (true) {
                if (i25 < i24) {
                    i12 = i22;
                    i18 = i26;
                    i15 = i28;
                    i16 = i27;
                    i19 = i24;
                    i17 = i20;
                    i11 = i25;
                    i14 = i23;
                    iM5350i = i21;
                    break;
                }
                int i29 = i10 & i23;
                int i30 = i10 >> i24;
                int i31 = i25 - i24;
                if (i29 == i3) {
                    i24 = iM5349h + 1;
                    i23 = (1 << i24) - 1;
                    i28 = i3 + 2;
                    i10 = i30;
                    i25 = i31;
                    i26 = -1;
                } else {
                    if (i29 > i28) {
                        this.f4799q = 3;
                        i10 = i30;
                        i12 = i22;
                        i14 = i23;
                        iM5350i = i21;
                        i18 = i26;
                        i19 = i24;
                        i17 = i20;
                        i15 = i28;
                        i16 = i27;
                        i11 = i31;
                        break;
                    }
                    if (i29 == i4) {
                        i10 = i30;
                        i12 = i22;
                        i14 = i23;
                        iM5350i = i21;
                        i18 = i26;
                        i19 = i24;
                        i17 = i20;
                        i15 = i28;
                        i16 = i27;
                        i11 = i31;
                        break;
                    }
                    if (i26 == -1) {
                        this.f4790h[i13] = this.f4789g[i29];
                        i25 = i31;
                        i22 = i29;
                        i13++;
                        i26 = i29;
                        i10 = i30;
                    } else {
                        if (i29 >= i28) {
                            this.f4790h[i13] = (byte) i22;
                            i13++;
                            i = i26;
                        } else {
                            i = i29;
                        }
                        while (i >= i3) {
                            this.f4790h[i13] = this.f4789g[i];
                            i = this.f4788f[i];
                            i13++;
                        }
                        int i32 = this.f4789g[i] & 255;
                        int i33 = i13 + 1;
                        this.f4790h[i13] = (byte) i32;
                        if (i28 < 4096) {
                            this.f4788f[i28] = (short) i26;
                            this.f4789g[i28] = (byte) i32;
                            i28++;
                            if ((i28 & i23) == 0 && i28 < 4096) {
                                i24++;
                                i23 += i28;
                            }
                        }
                        while (i33 > 0) {
                            i33--;
                            this.f4791i[i27] = this.f4790h[i33];
                            i9++;
                            i27++;
                        }
                        i22 = i32;
                        i13 = i33;
                        i26 = i29;
                        i25 = i31;
                        i10 = i30;
                    }
                }
            }
        }
        for (int i34 = i16; i34 < i2; i34++) {
            this.f4791i[i34] = 0;
        }
    }

    /* JADX INFO: renamed from: h */
    private int m5349h() {
        try {
            return this.f4786d.get() & 255;
        } catch (Exception e) {
            this.f4799q = 1;
            return 0;
        }
    }

    /* JADX INFO: renamed from: i */
    private int m5350i() {
        int iM5349h = m5349h();
        int i = 0;
        if (iM5349h > 0) {
            while (i < iM5349h) {
                int i2 = iM5349h - i;
                try {
                    this.f4786d.get(this.f4787e, i, i2);
                    i += i2;
                } catch (Exception e) {
                    Log.w(f4783a, "Error Reading Block", e);
                    this.f4799q = 1;
                }
            }
        }
        return i;
    }

    /* JADX INFO: renamed from: j */
    private Bitmap m5351j() {
        Bitmap bitmapObtain = this.f4796n.obtain(this.f4795m.f4816f, this.f4795m.f4817g, f4784b);
        if (bitmapObtain == null) {
            bitmapObtain = Bitmap.createBitmap(this.f4795m.f4816f, this.f4795m.f4817g, f4784b);
        }
        m5347a(bitmapObtain);
        return bitmapObtain;
    }

    @TargetApi(12)
    /* JADX INFO: renamed from: a */
    private static void m5347a(Bitmap bitmap) {
        if (Build.VERSION.SDK_INT >= 12) {
            bitmap.setHasAlpha(true);
        }
    }
}
