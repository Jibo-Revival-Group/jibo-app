package com.google.zxing.qrcode.encoder;

import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.google.zxing.qrcode.decoder.Mode;
import com.google.zxing.qrcode.decoder.Version;

/* JADX INFO: loaded from: classes.dex */
public final class QRCode {

    /* JADX INFO: renamed from: a */
    private Mode f9125a;

    /* JADX INFO: renamed from: b */
    private ErrorCorrectionLevel f9126b;

    /* JADX INFO: renamed from: c */
    private Version f9127c;

    /* JADX INFO: renamed from: d */
    private int f9128d = -1;

    /* JADX INFO: renamed from: e */
    private ByteMatrix f9129e;

    /* JADX INFO: renamed from: a */
    public ByteMatrix m9767a() {
        return this.f9129e;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(200);
        sb.append("<<\n");
        sb.append(" mode: ");
        sb.append(this.f9125a);
        sb.append("\n ecLevel: ");
        sb.append(this.f9126b);
        sb.append("\n version: ");
        sb.append(this.f9127c);
        sb.append("\n maskPattern: ");
        sb.append(this.f9128d);
        if (this.f9129e == null) {
            sb.append("\n matrix: null\n");
        } else {
            sb.append("\n matrix:\n");
            sb.append(this.f9129e);
        }
        sb.append(">>\n");
        return sb.toString();
    }

    /* JADX INFO: renamed from: a */
    public void m9770a(Mode mode) {
        this.f9125a = mode;
    }

    /* JADX INFO: renamed from: a */
    public void m9769a(ErrorCorrectionLevel errorCorrectionLevel) {
        this.f9126b = errorCorrectionLevel;
    }

    /* JADX INFO: renamed from: a */
    public void m9771a(Version version) {
        this.f9127c = version;
    }

    /* JADX INFO: renamed from: a */
    public void m9768a(int i) {
        this.f9128d = i;
    }

    /* JADX INFO: renamed from: a */
    public void m9772a(ByteMatrix byteMatrix) {
        this.f9129e = byteMatrix;
    }

    /* JADX INFO: renamed from: b */
    public static boolean m9766b(int i) {
        return i >= 0 && i < 8;
    }
}
