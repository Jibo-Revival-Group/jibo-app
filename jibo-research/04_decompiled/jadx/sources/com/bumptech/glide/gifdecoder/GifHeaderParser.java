package com.bumptech.glide.gifdecoder;

import android.util.Log;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class GifHeaderParser {

    /* JADX INFO: renamed from: b */
    private ByteBuffer f4825b;

    /* JADX INFO: renamed from: c */
    private GifHeader f4826c;

    /* JADX INFO: renamed from: a */
    private final byte[] f4824a = new byte[256];

    /* JADX INFO: renamed from: d */
    private int f4827d = 0;

    /* JADX INFO: renamed from: a */
    public GifHeaderParser m5377a(byte[] bArr) {
        m5364c();
        if (bArr != null) {
            this.f4825b = ByteBuffer.wrap(bArr);
            this.f4825b.rewind();
            this.f4825b.order(ByteOrder.LITTLE_ENDIAN);
        } else {
            this.f4825b = null;
            this.f4826c.f4812b = 2;
        }
        return this;
    }

    /* JADX INFO: renamed from: a */
    public void m5378a() {
        this.f4825b = null;
        this.f4826c = null;
    }

    /* JADX INFO: renamed from: c */
    private void m5364c() {
        this.f4825b = null;
        Arrays.fill(this.f4824a, (byte) 0);
        this.f4826c = new GifHeader();
        this.f4827d = 0;
    }

    /* JADX INFO: renamed from: b */
    public GifHeader m5379b() {
        if (this.f4825b == null) {
            throw new IllegalStateException("You must call setData() before parseHeader()");
        }
        if (m5376o()) {
            return this.f4826c;
        }
        m5369h();
        if (!m5376o()) {
            m5365d();
            if (this.f4826c.f4813c < 0) {
                this.f4826c.f4812b = 1;
            }
        }
        return this.f4826c;
    }

    /* JADX INFO: renamed from: d */
    private void m5365d() {
        boolean z = false;
        while (!z && !m5376o()) {
            switch (m5374m()) {
                case 33:
                    switch (m5374m()) {
                        case 1:
                            m5372k();
                            break;
                        case 249:
                            this.f4826c.f4814d = new GifFrame();
                            m5366e();
                            break;
                        case 254:
                            m5372k();
                            break;
                        case 255:
                            m5373l();
                            String str = "";
                            for (int i = 0; i < 11; i++) {
                                str = str + ((char) this.f4824a[i]);
                            }
                            if (str.equals("NETSCAPE2.0")) {
                                m5368g();
                            } else {
                                m5372k();
                            }
                            break;
                        default:
                            m5372k();
                            break;
                    }
                    break;
                case 44:
                    if (this.f4826c.f4814d == null) {
                        this.f4826c.f4814d = new GifFrame();
                    }
                    m5367f();
                    break;
                case 59:
                    z = true;
                    break;
                default:
                    this.f4826c.f4812b = 1;
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: e */
    private void m5366e() {
        m5374m();
        int iM5374m = m5374m();
        this.f4826c.f4814d.f4806g = (iM5374m & 28) >> 2;
        if (this.f4826c.f4814d.f4806g == 0) {
            this.f4826c.f4814d.f4806g = 1;
        }
        this.f4826c.f4814d.f4805f = (iM5374m & 1) != 0;
        int iM5375n = m5375n();
        if (iM5375n < 3) {
            iM5375n = 10;
        }
        this.f4826c.f4814d.f4808i = iM5375n * 10;
        this.f4826c.f4814d.f4807h = m5374m();
        m5374m();
    }

    /* JADX INFO: renamed from: f */
    private void m5367f() {
        this.f4826c.f4814d.f4800a = m5375n();
        this.f4826c.f4814d.f4801b = m5375n();
        this.f4826c.f4814d.f4802c = m5375n();
        this.f4826c.f4814d.f4803d = m5375n();
        int iM5374m = m5374m();
        boolean z = (iM5374m & 128) != 0;
        int iPow = (int) Math.pow(2.0d, (iM5374m & 7) + 1);
        this.f4826c.f4814d.f4804e = (iM5374m & 64) != 0;
        if (z) {
            this.f4826c.f4814d.f4810k = m5363a(iPow);
        } else {
            this.f4826c.f4814d.f4810k = null;
        }
        this.f4826c.f4814d.f4809j = this.f4825b.position();
        m5371j();
        if (!m5376o()) {
            this.f4826c.f4813c++;
            this.f4826c.f4815e.add(this.f4826c.f4814d);
        }
    }

    /* JADX INFO: renamed from: g */
    private void m5368g() {
        do {
            m5373l();
            if (this.f4824a[0] == 1) {
                this.f4826c.f4823m = (this.f4824a[1] & 255) | ((this.f4824a[2] & 255) << 8);
            }
            if (this.f4827d <= 0) {
                return;
            }
        } while (!m5376o());
    }

    /* JADX INFO: renamed from: h */
    private void m5369h() {
        String str = "";
        for (int i = 0; i < 6; i++) {
            str = str + ((char) m5374m());
        }
        if (!str.startsWith("GIF")) {
            this.f4826c.f4812b = 1;
            return;
        }
        m5370i();
        if (this.f4826c.f4818h && !m5376o()) {
            this.f4826c.f4811a = m5363a(this.f4826c.f4819i);
            this.f4826c.f4822l = this.f4826c.f4811a[this.f4826c.f4820j];
        }
    }

    /* JADX INFO: renamed from: i */
    private void m5370i() {
        this.f4826c.f4816f = m5375n();
        this.f4826c.f4817g = m5375n();
        int iM5374m = m5374m();
        this.f4826c.f4818h = (iM5374m & 128) != 0;
        this.f4826c.f4819i = 2 << (iM5374m & 7);
        this.f4826c.f4820j = m5374m();
        this.f4826c.f4821k = m5374m();
    }

    /* JADX INFO: renamed from: a */
    private int[] m5363a(int i) {
        int[] iArr;
        BufferUnderflowException e;
        int i2 = 0;
        byte[] bArr = new byte[i * 3];
        try {
            this.f4825b.get(bArr);
            iArr = new int[256];
            int i3 = 0;
            while (i2 < i) {
                int i4 = i3 + 1;
                try {
                    int i5 = bArr[i3] & 255;
                    int i6 = i4 + 1;
                    int i7 = bArr[i4] & 255;
                    i3 = i6 + 1;
                    int i8 = i2 + 1;
                    iArr[i2] = (i5 << 16) | (-16777216) | (i7 << 8) | (bArr[i6] & 255);
                    i2 = i8;
                } catch (BufferUnderflowException e2) {
                    e = e2;
                    if (Log.isLoggable("GifHeaderParser", 3)) {
                        Log.d("GifHeaderParser", "Format Error Reading Color Table", e);
                    }
                    this.f4826c.f4812b = 1;
                    return iArr;
                }
            }
        } catch (BufferUnderflowException e3) {
            iArr = null;
            e = e3;
        }
        return iArr;
    }

    /* JADX INFO: renamed from: j */
    private void m5371j() {
        m5374m();
        m5372k();
    }

    /* JADX INFO: renamed from: k */
    private void m5372k() {
        int iM5374m;
        do {
            iM5374m = m5374m();
            this.f4825b.position(this.f4825b.position() + iM5374m);
        } while (iM5374m > 0);
    }

    /* JADX INFO: renamed from: l */
    private int m5373l() {
        int i = 0;
        this.f4827d = m5374m();
        if (this.f4827d > 0) {
            int i2 = 0;
            while (i < this.f4827d) {
                try {
                    i2 = this.f4827d - i;
                    this.f4825b.get(this.f4824a, i, i2);
                    i += i2;
                } catch (Exception e) {
                    if (Log.isLoggable("GifHeaderParser", 3)) {
                        Log.d("GifHeaderParser", "Error Reading Block n: " + i + " count: " + i2 + " blockSize: " + this.f4827d, e);
                    }
                    this.f4826c.f4812b = 1;
                }
            }
        }
        return i;
    }

    /* JADX INFO: renamed from: m */
    private int m5374m() {
        try {
            return this.f4825b.get() & 255;
        } catch (Exception e) {
            this.f4826c.f4812b = 1;
            return 0;
        }
    }

    /* JADX INFO: renamed from: n */
    private int m5375n() {
        return this.f4825b.getShort();
    }

    /* JADX INFO: renamed from: o */
    private boolean m5376o() {
        return this.f4826c.f4812b != 0;
    }
}
