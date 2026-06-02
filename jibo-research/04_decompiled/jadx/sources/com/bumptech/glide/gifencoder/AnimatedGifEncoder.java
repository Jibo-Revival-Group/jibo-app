package com.bumptech.glide.gifencoder;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import com.yalantis.ucrop.view.CropImageView;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes.dex */
public class AnimatedGifEncoder {

    /* JADX INFO: renamed from: a */
    private int f4828a;

    /* JADX INFO: renamed from: b */
    private int f4829b;

    /* JADX INFO: renamed from: d */
    private int f4831d;

    /* JADX INFO: renamed from: h */
    private OutputStream f4835h;

    /* JADX INFO: renamed from: i */
    private Bitmap f4836i;

    /* JADX INFO: renamed from: j */
    private byte[] f4837j;

    /* JADX INFO: renamed from: k */
    private byte[] f4838k;

    /* JADX INFO: renamed from: l */
    private int f4839l;

    /* JADX INFO: renamed from: m */
    private byte[] f4840m;

    /* JADX INFO: renamed from: u */
    private boolean f4848u;

    /* JADX INFO: renamed from: c */
    private Integer f4830c = null;

    /* JADX INFO: renamed from: e */
    private int f4832e = -1;

    /* JADX INFO: renamed from: f */
    private int f4833f = 0;

    /* JADX INFO: renamed from: g */
    private boolean f4834g = false;

    /* JADX INFO: renamed from: n */
    private boolean[] f4841n = new boolean[256];

    /* JADX INFO: renamed from: o */
    private int f4842o = 7;

    /* JADX INFO: renamed from: p */
    private int f4843p = -1;

    /* JADX INFO: renamed from: q */
    private boolean f4844q = false;

    /* JADX INFO: renamed from: r */
    private boolean f4845r = true;

    /* JADX INFO: renamed from: s */
    private boolean f4846s = false;

    /* JADX INFO: renamed from: t */
    private int f4847t = 10;

    /* JADX INFO: renamed from: a */
    public void m5391a(int i) {
        this.f4833f = Math.round(i / 10.0f);
    }

    /* JADX INFO: renamed from: a */
    public boolean m5394a(Bitmap bitmap) {
        if (bitmap == null || !this.f4834g) {
            return false;
        }
        try {
            if (!this.f4846s) {
                m5392a(bitmap.getWidth(), bitmap.getHeight());
            }
            this.f4836i = bitmap;
            m5383c();
            m5382b();
            if (this.f4845r) {
                m5387f();
                m5389h();
                if (this.f4832e >= 0) {
                    m5388g();
                }
            }
            m5385d();
            m5386e();
            if (!this.f4845r) {
                m5389h();
            }
            m5390i();
            this.f4845r = false;
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    /* JADX INFO: renamed from: a */
    public boolean m5393a() {
        boolean z;
        if (!this.f4834g) {
            return false;
        }
        this.f4834g = false;
        try {
            this.f4835h.write(59);
            this.f4835h.flush();
            if (this.f4844q) {
                this.f4835h.close();
            }
            z = true;
        } catch (IOException e) {
            z = false;
        }
        this.f4831d = 0;
        this.f4835h = null;
        this.f4836i = null;
        this.f4837j = null;
        this.f4838k = null;
        this.f4840m = null;
        this.f4844q = false;
        this.f4845r = true;
        return z;
    }

    /* JADX INFO: renamed from: a */
    public void m5392a(int i, int i2) {
        if (!this.f4834g || this.f4845r) {
            this.f4828a = i;
            this.f4829b = i2;
            if (this.f4828a < 1) {
                this.f4828a = 320;
            }
            if (this.f4829b < 1) {
                this.f4829b = 240;
            }
            this.f4846s = true;
        }
    }

    /* JADX INFO: renamed from: a */
    public boolean m5395a(OutputStream outputStream) {
        if (outputStream == null) {
            return false;
        }
        boolean z = true;
        this.f4844q = false;
        this.f4835h = outputStream;
        try {
            m5380a("GIF89a");
        } catch (IOException e) {
            z = false;
        }
        this.f4834g = z;
        return z;
    }

    /* JADX INFO: renamed from: b */
    private void m5382b() {
        int length = this.f4837j.length;
        int i = length / 3;
        this.f4838k = new byte[i];
        NeuQuant neuQuant = new NeuQuant(this.f4837j, length, this.f4847t);
        this.f4840m = neuQuant.m5412d();
        for (int i2 = 0; i2 < this.f4840m.length; i2 += 3) {
            byte b = this.f4840m[i2];
            this.f4840m[i2] = this.f4840m[i2 + 2];
            this.f4840m[i2 + 2] = b;
            this.f4841n[i2 / 3] = false;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < i; i4++) {
            int i5 = i3 + 1;
            int i6 = i5 + 1;
            i3 = i6 + 1;
            int iM5405a = neuQuant.m5405a(this.f4837j[i3] & 255, this.f4837j[i5] & 255, this.f4837j[i6] & 255);
            this.f4841n[iM5405a] = true;
            this.f4838k[i4] = (byte) iM5405a;
        }
        this.f4837j = null;
        this.f4839l = 8;
        this.f4842o = 7;
        if (this.f4830c != null) {
            this.f4831d = m5381b(this.f4830c.intValue());
        } else if (this.f4848u) {
            this.f4831d = m5381b(0);
        }
    }

    /* JADX INFO: renamed from: b */
    private int m5381b(int i) {
        int i2;
        int i3 = 0;
        if (this.f4840m == null) {
            return -1;
        }
        int iRed = Color.red(i);
        int iGreen = Color.green(i);
        int iBlue = Color.blue(i);
        int i4 = 16777216;
        int length = this.f4840m.length;
        int i5 = 0;
        while (i3 < length) {
            int i6 = i3 + 1;
            int i7 = iRed - (this.f4840m[i3] & 255);
            int i8 = i6 + 1;
            int i9 = iGreen - (this.f4840m[i6] & 255);
            int i10 = iBlue - (this.f4840m[i8] & 255);
            int i11 = (i7 * i7) + (i9 * i9) + (i10 * i10);
            int i12 = i8 / 3;
            if (!this.f4841n[i12] || i11 >= i4) {
                i11 = i4;
                i2 = i5;
            } else {
                i2 = i12;
            }
            i5 = i2;
            i4 = i11;
            i3 = i8 + 1;
        }
        return i5;
    }

    /* JADX INFO: renamed from: c */
    private void m5383c() {
        int width = this.f4836i.getWidth();
        int height = this.f4836i.getHeight();
        if (width != this.f4828a || height != this.f4829b) {
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(this.f4828a, this.f4829b, Bitmap.Config.ARGB_8888);
            new Canvas(bitmapCreateBitmap).drawBitmap(bitmapCreateBitmap, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, (Paint) null);
            this.f4836i = bitmapCreateBitmap;
        }
        int[] iArr = new int[width * height];
        this.f4836i.getPixels(iArr, 0, width, 0, 0, width, height);
        this.f4837j = new byte[iArr.length * 3];
        this.f4848u = false;
        int i = 0;
        int i2 = 0;
        for (int i3 : iArr) {
            if (i3 == 0) {
                i++;
            }
            int i4 = i2 + 1;
            this.f4837j[i2] = (byte) (i3 & 255);
            int i5 = i4 + 1;
            this.f4837j[i4] = (byte) ((i3 >> 8) & 255);
            i2 = i5 + 1;
            this.f4837j[i5] = (byte) ((i3 >> 16) & 255);
        }
        double length = ((double) (i * 100)) / ((double) iArr.length);
        this.f4848u = length > 4.0d;
        if (Log.isLoggable("AnimatedGifEncoder", 3)) {
            Log.d("AnimatedGifEncoder", "got pixels for frame with " + length + "% transparent pixels");
        }
    }

    /* JADX INFO: renamed from: d */
    private void m5385d() throws IOException {
        int i;
        int i2;
        this.f4835h.write(33);
        this.f4835h.write(249);
        this.f4835h.write(4);
        if (this.f4830c != null || this.f4848u) {
            i = 1;
            i2 = 2;
        } else {
            i2 = 0;
            i = 0;
        }
        if (this.f4843p >= 0) {
            i2 = this.f4843p & 7;
        }
        this.f4835h.write((i2 << 2) | 0 | 0 | i);
        m5384c(this.f4833f);
        this.f4835h.write(this.f4831d);
        this.f4835h.write(0);
    }

    /* JADX INFO: renamed from: e */
    private void m5386e() throws IOException {
        this.f4835h.write(44);
        m5384c(0);
        m5384c(0);
        m5384c(this.f4828a);
        m5384c(this.f4829b);
        if (this.f4845r) {
            this.f4835h.write(0);
        } else {
            this.f4835h.write(this.f4842o | 128);
        }
    }

    /* JADX INFO: renamed from: f */
    private void m5387f() throws IOException {
        m5384c(this.f4828a);
        m5384c(this.f4829b);
        this.f4835h.write(this.f4842o | 240);
        this.f4835h.write(0);
        this.f4835h.write(0);
    }

    /* JADX INFO: renamed from: g */
    private void m5388g() throws IOException {
        this.f4835h.write(33);
        this.f4835h.write(255);
        this.f4835h.write(11);
        m5380a("NETSCAPE2.0");
        this.f4835h.write(3);
        this.f4835h.write(1);
        m5384c(this.f4832e);
        this.f4835h.write(0);
    }

    /* JADX INFO: renamed from: h */
    private void m5389h() throws IOException {
        this.f4835h.write(this.f4840m, 0, this.f4840m.length);
        int length = 768 - this.f4840m.length;
        for (int i = 0; i < length; i++) {
            this.f4835h.write(0);
        }
    }

    /* JADX INFO: renamed from: i */
    private void m5390i() throws IOException {
        new LZWEncoder(this.f4828a, this.f4829b, this.f4838k, this.f4839l).m5403b(this.f4835h);
    }

    /* JADX INFO: renamed from: c */
    private void m5384c(int i) throws IOException {
        this.f4835h.write(i & 255);
        this.f4835h.write((i >> 8) & 255);
    }

    /* JADX INFO: renamed from: a */
    private void m5380a(String str) throws IOException {
        for (int i = 0; i < str.length(); i++) {
            this.f4835h.write((byte) str.charAt(i));
        }
    }
}
