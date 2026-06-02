package com.fasterxml.jackson.core.json;

import com.facebook.internal.NativeProtocol;
import com.facebook.internal.ServerProtocol;
import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.core.base.ParserBase;
import com.fasterxml.jackson.core.p000io.CharTypes;
import com.fasterxml.jackson.core.p000io.IOContext;
import com.fasterxml.jackson.core.sym.ByteQuadsCanonicalizer;
import com.fasterxml.jackson.core.util.ByteArrayBuilder;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import org.apache.http.message.TokenParser;

/* JADX INFO: loaded from: classes.dex */
public class UTF8StreamJsonParser extends ParserBase {

    /* JADX INFO: renamed from: M */
    protected ObjectCodec f5583M;

    /* JADX INFO: renamed from: N */
    protected final ByteQuadsCanonicalizer f5584N;

    /* JADX INFO: renamed from: O */
    protected int[] f5585O;

    /* JADX INFO: renamed from: P */
    protected boolean f5586P;

    /* JADX INFO: renamed from: Q */
    protected InputStream f5587Q;

    /* JADX INFO: renamed from: R */
    protected byte[] f5588R;

    /* JADX INFO: renamed from: S */
    protected boolean f5589S;

    /* JADX INFO: renamed from: U */
    private int f5590U;

    /* JADX INFO: renamed from: T */
    private static final int[] f5582T = CharTypes.m6145b();

    /* JADX INFO: renamed from: L */
    protected static final int[] f5581L = CharTypes.m6144a();

    public UTF8StreamJsonParser(IOContext iOContext, int i, InputStream inputStream, ObjectCodec objectCodec, ByteQuadsCanonicalizer byteQuadsCanonicalizer, byte[] bArr, int i2, int i3, boolean z) {
        super(iOContext, i);
        this.f5585O = new int[16];
        this.f5586P = false;
        this.f5587Q = inputStream;
        this.f5583M = objectCodec;
        this.f5584N = byteQuadsCanonicalizer;
        this.f5588R = bArr;
        this.f5448d = i2;
        this.f5449e = i3;
        this.f5452h = i2;
        this.f5450f = -i2;
        this.f5589S = z;
    }

    @Override // com.fasterxml.jackson.core.base.ParserBase
    /* JADX INFO: renamed from: p */
    protected final boolean mo6118p() throws IOException {
        int length;
        this.f5450f += (long) this.f5449e;
        this.f5452h -= this.f5449e;
        if (this.f5587Q == null || (length = this.f5588R.length) == 0) {
            return false;
        }
        int i = this.f5587Q.read(this.f5588R, 0, length);
        if (i > 0) {
            this.f5448d = 0;
            this.f5449e = i;
            return true;
        }
        mo6120r();
        if (i == 0) {
            throw new IOException("InputStream.read() returned 0 characters when trying to read " + this.f5588R.length + " bytes");
        }
        return false;
    }

    @Override // com.fasterxml.jackson.core.base.ParserBase
    /* JADX INFO: renamed from: r */
    protected void mo6120r() throws IOException {
        if (this.f5587Q != null) {
            if (this.f5446b.m6167c() || m6062a(JsonParser.Feature.AUTO_CLOSE_SOURCE)) {
                this.f5587Q.close();
            }
            this.f5587Q = null;
        }
    }

    @Override // com.fasterxml.jackson.core.base.ParserBase
    /* JADX INFO: renamed from: s */
    protected void mo6121s() throws IOException {
        byte[] bArr;
        super.mo6121s();
        this.f5584N.m6412b();
        if (this.f5589S && (bArr = this.f5588R) != null) {
            this.f5588R = ByteArrayBuilder.f5657a;
            this.f5446b.m6158a(bArr);
        }
    }

    @Override // com.fasterxml.jackson.core.base.ParserMinimalBase, com.fasterxml.jackson.core.JsonParser
    /* JADX INFO: renamed from: f */
    public String mo6067f() throws IOException {
        if (this.f5463K == JsonToken.VALUE_STRING) {
            if (this.f5586P) {
                this.f5586P = false;
                return m6344K();
            }
            return this.f5458n.m6485f();
        }
        return m6351a(this.f5463K);
    }

    /* JADX INFO: renamed from: a */
    protected final String m6351a(JsonToken jsonToken) {
        if (jsonToken == null) {
            return null;
        }
        switch (jsonToken.m6084id()) {
            case 5:
                return this.f5456l.m6229g();
            case 6:
            case 7:
            case 8:
                return this.f5458n.m6485f();
            default:
                return jsonToken.asString();
        }
    }

    @Override // com.fasterxml.jackson.core.base.ParserBase, com.fasterxml.jackson.core.JsonParser
    /* JADX INFO: renamed from: e */
    public JsonLocation mo6066e() {
        return new JsonLocation(this.f5446b.m6155a(), this.f5450f + ((long) this.f5448d), -1L, this.f5451g, (this.f5448d - this.f5452h) + 1);
    }

    @Override // com.fasterxml.jackson.core.base.ParserMinimalBase, com.fasterxml.jackson.core.JsonParser
    /* JADX INFO: renamed from: a */
    public JsonToken mo6061a() throws IOException {
        JsonToken jsonTokenM6356e;
        this.f5436A = 0;
        if (this.f5463K == JsonToken.FIELD_NAME) {
            return m6304O();
        }
        if (this.f5586P) {
            m6345L();
        }
        int iM6308S = m6308S();
        if (iM6308S < 0) {
            close();
            this.f5463K = null;
            return null;
        }
        this.f5453i = (this.f5450f + ((long) this.f5448d)) - 1;
        this.f5454j = this.f5451g;
        this.f5455k = (this.f5448d - this.f5452h) - 1;
        this.f5462r = null;
        if (iM6308S == 93) {
            if (!this.f5456l.m6078a()) {
                m6113a(iM6308S, '}');
            }
            this.f5456l = this.f5456l.m6230h();
            JsonToken jsonToken = JsonToken.END_ARRAY;
            this.f5463K = jsonToken;
            return jsonToken;
        }
        if (iM6308S == 125) {
            if (!this.f5456l.m6080c()) {
                m6113a(iM6308S, ']');
            }
            this.f5456l = this.f5456l.m6230h();
            JsonToken jsonToken2 = JsonToken.END_OBJECT;
            this.f5463K = jsonToken2;
            return jsonToken2;
        }
        if (this.f5456l.m6231i()) {
            if (iM6308S != 44) {
                m6137b(iM6308S, "was expecting comma to separate " + this.f5456l.m6081d() + " entries");
            }
            iM6308S = m6306Q();
        }
        if (!this.f5456l.m6080c()) {
            return m6332n(iM6308S);
        }
        this.f5456l.m6227a(m6358f(iM6308S));
        this.f5463K = JsonToken.FIELD_NAME;
        int iM6310U = m6310U();
        if (iM6310U == 34) {
            this.f5586P = true;
            this.f5457m = JsonToken.VALUE_STRING;
            return this.f5463K;
        }
        switch (iM6310U) {
            case 45:
                jsonTokenM6356e = m6341H();
                break;
            case 48:
            case 49:
            case 50:
            case 51:
            case 52:
            case 53:
            case 54:
            case 55:
            case 56:
            case 57:
                jsonTokenM6356e = m6356e(iM6310U);
                break;
            case 91:
                jsonTokenM6356e = JsonToken.START_ARRAY;
                break;
            case 102:
                m6353a("false", 1);
                jsonTokenM6356e = JsonToken.VALUE_FALSE;
                break;
            case 110:
                m6353a("null", 1);
                jsonTokenM6356e = JsonToken.VALUE_NULL;
                break;
            case 116:
                m6353a(ServerProtocol.DIALOG_RETURN_SCOPES_TRUE, 1);
                jsonTokenM6356e = JsonToken.VALUE_TRUE;
                break;
            case 123:
                jsonTokenM6356e = JsonToken.START_OBJECT;
                break;
            default:
                jsonTokenM6356e = m6361i(iM6310U);
                break;
        }
        this.f5457m = jsonTokenM6356e;
        return this.f5463K;
    }

    /* JADX INFO: renamed from: n */
    private final JsonToken m6332n(int i) throws IOException {
        if (i == 34) {
            this.f5586P = true;
            JsonToken jsonToken = JsonToken.VALUE_STRING;
            this.f5463K = jsonToken;
            return jsonToken;
        }
        switch (i) {
            case 45:
                JsonToken jsonTokenM6341H = m6341H();
                this.f5463K = jsonTokenM6341H;
                return jsonTokenM6341H;
            case 48:
            case 49:
            case 50:
            case 51:
            case 52:
            case 53:
            case 54:
            case 55:
            case 56:
            case 57:
                JsonToken jsonTokenM6356e = m6356e(i);
                this.f5463K = jsonTokenM6356e;
                return jsonTokenM6356e;
            case 91:
                this.f5456l = this.f5456l.m6225a(this.f5454j, this.f5455k);
                JsonToken jsonToken2 = JsonToken.START_ARRAY;
                this.f5463K = jsonToken2;
                return jsonToken2;
            case 102:
                m6353a("false", 1);
                JsonToken jsonToken3 = JsonToken.VALUE_FALSE;
                this.f5463K = jsonToken3;
                return jsonToken3;
            case 110:
                m6353a("null", 1);
                JsonToken jsonToken4 = JsonToken.VALUE_NULL;
                this.f5463K = jsonToken4;
                return jsonToken4;
            case 116:
                m6353a(ServerProtocol.DIALOG_RETURN_SCOPES_TRUE, 1);
                JsonToken jsonToken5 = JsonToken.VALUE_TRUE;
                this.f5463K = jsonToken5;
                return jsonToken5;
            case 123:
                this.f5456l = this.f5456l.m6228b(this.f5454j, this.f5455k);
                JsonToken jsonToken6 = JsonToken.START_OBJECT;
                this.f5463K = jsonToken6;
                return jsonToken6;
            default:
                JsonToken jsonTokenM6361i = m6361i(i);
                this.f5463K = jsonTokenM6361i;
                return jsonTokenM6361i;
        }
    }

    /* JADX INFO: renamed from: O */
    private final JsonToken m6304O() {
        this.f5460p = false;
        JsonToken jsonToken = this.f5457m;
        this.f5457m = null;
        if (jsonToken == JsonToken.START_ARRAY) {
            this.f5456l = this.f5456l.m6225a(this.f5454j, this.f5455k);
        } else if (jsonToken == JsonToken.START_OBJECT) {
            this.f5456l = this.f5456l.m6228b(this.f5454j, this.f5455k);
        }
        this.f5463K = jsonToken;
        return jsonToken;
    }

    /* JADX INFO: renamed from: e */
    protected JsonToken m6356e(int i) throws IOException {
        int i2;
        int i3 = 1;
        char[] cArrM6490k = this.f5458n.m6490k();
        if (i == 48) {
            i = m6305P();
        }
        cArrM6490k[0] = (char) i;
        int length = (this.f5448d + cArrM6490k.length) - 1;
        if (length > this.f5449e) {
            length = this.f5449e;
            i2 = 1;
        } else {
            i2 = 1;
        }
        while (this.f5448d < length) {
            byte[] bArr = this.f5588R;
            int i4 = this.f5448d;
            this.f5448d = i4 + 1;
            int i5 = bArr[i4] & 255;
            if (i5 >= 48 && i5 <= 57) {
                cArrM6490k[i3] = (char) i5;
                i3++;
                i2++;
            } else {
                if (i5 == 46 || i5 == 101 || i5 == 69) {
                    return m6317a(cArrM6490k, i3, i5, false, i2);
                }
                this.f5448d--;
                this.f5458n.m6475a(i3);
                if (this.f5456l.m6079b()) {
                    m6333o(i5);
                }
                return m6110a(false, i2);
            }
        }
        return m6318a(cArrM6490k, i3, false, i2);
    }

    /* JADX INFO: renamed from: H */
    protected JsonToken m6341H() throws IOException {
        int i;
        char[] cArrM6490k = this.f5458n.m6490k();
        cArrM6490k[0] = '-';
        if (this.f5448d >= this.f5449e) {
            m6117o();
        }
        byte[] bArr = this.f5588R;
        int i2 = this.f5448d;
        this.f5448d = i2 + 1;
        int iM6305P = bArr[i2] & 255;
        if (iM6305P < 48 || iM6305P > 57) {
            return m6348a(iM6305P, true);
        }
        if (iM6305P == 48) {
            iM6305P = m6305P();
        }
        int i3 = 2;
        cArrM6490k[1] = (char) iM6305P;
        int length = (this.f5448d + cArrM6490k.length) - 2;
        if (length > this.f5449e) {
            length = this.f5449e;
            i = 1;
        } else {
            i = 1;
        }
        while (this.f5448d < length) {
            byte[] bArr2 = this.f5588R;
            int i4 = this.f5448d;
            this.f5448d = i4 + 1;
            int i5 = bArr2[i4] & 255;
            if (i5 >= 48 && i5 <= 57) {
                i++;
                cArrM6490k[i3] = (char) i5;
                i3++;
            } else {
                if (i5 == 46 || i5 == 101 || i5 == 69) {
                    return m6317a(cArrM6490k, i3, i5, true, i);
                }
                this.f5448d--;
                this.f5458n.m6475a(i3);
                if (this.f5456l.m6079b()) {
                    m6333o(i5);
                }
                return m6110a(true, i);
            }
        }
        return m6318a(cArrM6490k, i3, true, i);
    }

    /* JADX INFO: renamed from: a */
    private final JsonToken m6318a(char[] cArr, int i, boolean z, int i2) throws IOException {
        int i3;
        int i4 = i2;
        int i5 = i;
        char[] cArrM6492m = cArr;
        while (true) {
            if (this.f5448d >= this.f5449e && !mo6118p()) {
                this.f5458n.m6475a(i5);
                return m6110a(z, i4);
            }
            byte[] bArr = this.f5588R;
            int i6 = this.f5448d;
            this.f5448d = i6 + 1;
            i3 = bArr[i6] & 255;
            if (i3 > 57 || i3 < 48) {
                break;
            }
            if (i5 >= cArrM6492m.length) {
                cArrM6492m = this.f5458n.m6492m();
                i5 = 0;
            }
            int i7 = i5;
            i5 = i7 + 1;
            cArrM6492m[i7] = (char) i3;
            i4++;
        }
        if (i3 == 46 || i3 == 101 || i3 == 69) {
            return m6317a(cArrM6492m, i5, i3, z, i4);
        }
        this.f5448d--;
        this.f5458n.m6475a(i5);
        if (this.f5456l.m6079b()) {
            byte[] bArr2 = this.f5588R;
            int i8 = this.f5448d;
            this.f5448d = i8 + 1;
            m6333o(bArr2[i8] & 255);
        }
        return m6110a(z, i4);
    }

    /* JADX INFO: renamed from: P */
    private final int m6305P() throws IOException {
        if (this.f5448d >= this.f5449e && !mo6118p()) {
            return 48;
        }
        int i = this.f5588R[this.f5448d] & 255;
        if (i < 48 || i > 57) {
            return 48;
        }
        if (!m6062a(JsonParser.Feature.ALLOW_NUMERIC_LEADING_ZEROS)) {
            m6116b("Leading zeroes not allowed");
        }
        this.f5448d++;
        if (i == 48) {
            do {
                if (this.f5448d < this.f5449e || mo6118p()) {
                    i = this.f5588R[this.f5448d] & 255;
                    if (i < 48 || i > 57) {
                        return 48;
                    }
                    this.f5448d++;
                } else {
                    return i;
                }
            } while (i == 48);
            return i;
        }
        return i;
    }

    /* JADX INFO: renamed from: a */
    private final JsonToken m6317a(char[] cArr, int i, int i2, boolean z, int i3) throws IOException {
        int i4;
        int i5;
        char[] cArrM6492m;
        int i6;
        int i7;
        int i8;
        int i9;
        boolean z2;
        int i10;
        int i11;
        int i12 = 0;
        boolean z3 = false;
        if (i2 != 46) {
            i4 = 0;
            i5 = i2;
            cArrM6492m = cArr;
            i6 = i;
        } else {
            int i13 = i + 1;
            cArr[i] = (char) i2;
            while (true) {
                if (this.f5448d >= this.f5449e && !mo6118p()) {
                    z3 = true;
                    i5 = i2;
                    break;
                }
                byte[] bArr = this.f5588R;
                int i14 = this.f5448d;
                this.f5448d = i14 + 1;
                i2 = bArr[i14] & 255;
                if (i2 < 48) {
                    i5 = i2;
                    break;
                }
                if (i2 > 57) {
                    i5 = i2;
                    break;
                }
                i12++;
                if (i13 >= cArr.length) {
                    cArr = this.f5458n.m6492m();
                    i13 = 0;
                }
                int i15 = i13;
                i13 = i15 + 1;
                cArr[i15] = (char) i2;
            }
            if (i12 == 0) {
                m6114a(i5, "Decimal point not followed by a digit");
            }
            i4 = i12;
            i6 = i13;
            cArrM6492m = cArr;
        }
        int i16 = 0;
        if (i5 != 101 && i5 != 69) {
            z2 = z3;
            i8 = i5;
            i10 = i6;
            i11 = 0;
        } else {
            if (i6 >= cArrM6492m.length) {
                cArrM6492m = this.f5458n.m6492m();
                i6 = 0;
            }
            int i17 = i6 + 1;
            cArrM6492m[i6] = (char) i5;
            if (this.f5448d >= this.f5449e) {
                m6117o();
            }
            byte[] bArr2 = this.f5588R;
            int i18 = this.f5448d;
            this.f5448d = i18 + 1;
            int i19 = bArr2[i18] & 255;
            if (i19 == 45 || i19 == 43) {
                if (i17 >= cArrM6492m.length) {
                    cArrM6492m = this.f5458n.m6492m();
                    i7 = 0;
                } else {
                    i7 = i17;
                }
                int i20 = i7 + 1;
                cArrM6492m[i7] = (char) i19;
                if (this.f5448d >= this.f5449e) {
                    m6117o();
                }
                byte[] bArr3 = this.f5588R;
                int i21 = this.f5448d;
                this.f5448d = i21 + 1;
                i8 = bArr3[i21] & 255;
                i9 = i20;
            } else {
                i9 = i17;
                i8 = i19;
            }
            while (i8 <= 57 && i8 >= 48) {
                i16++;
                if (i9 >= cArrM6492m.length) {
                    cArrM6492m = this.f5458n.m6492m();
                    i9 = 0;
                }
                int i22 = i9 + 1;
                cArrM6492m[i9] = (char) i8;
                if (this.f5448d >= this.f5449e && !mo6118p()) {
                    i11 = i16;
                    z2 = true;
                    i10 = i22;
                    break;
                }
                byte[] bArr4 = this.f5588R;
                int i23 = this.f5448d;
                this.f5448d = i23 + 1;
                i8 = bArr4[i23] & 255;
                i9 = i22;
            }
            z2 = z3;
            int i24 = i16;
            i10 = i9;
            i11 = i24;
            if (i11 == 0) {
                m6114a(i8, "Exponent indicator not followed by a digit");
            }
        }
        if (!z2) {
            this.f5448d--;
            if (this.f5456l.m6079b()) {
                m6333o(i8);
            }
        }
        this.f5458n.m6475a(i10);
        return m6115b(z, i3, i4, i11);
    }

    /* JADX INFO: renamed from: o */
    private final void m6333o(int i) throws IOException {
        this.f5448d++;
        switch (i) {
            case 9:
            case 32:
                break;
            case 10:
                this.f5451g++;
                this.f5452h = this.f5448d;
                break;
            case 13:
                m6347N();
                break;
            default:
                m6136b(i);
                break;
        }
    }

    /* JADX INFO: renamed from: f */
    protected final String m6358f(int i) throws IOException {
        if (i != 34) {
            return m6360h(i);
        }
        if (this.f5448d + 13 > this.f5449e) {
            return m6342I();
        }
        byte[] bArr = this.f5588R;
        int[] iArr = f5581L;
        int i2 = this.f5448d;
        this.f5448d = i2 + 1;
        int i3 = bArr[i2] & 255;
        if (iArr[i3] == 0) {
            int i4 = this.f5448d;
            this.f5448d = i4 + 1;
            int i5 = bArr[i4] & 255;
            if (iArr[i5] == 0) {
                int i6 = (i3 << 8) | i5;
                int i7 = this.f5448d;
                this.f5448d = i7 + 1;
                int i8 = bArr[i7] & 255;
                if (iArr[i8] == 0) {
                    int i9 = (i6 << 8) | i8;
                    int i10 = this.f5448d;
                    this.f5448d = i10 + 1;
                    int i11 = bArr[i10] & 255;
                    if (iArr[i11] == 0) {
                        int i12 = (i9 << 8) | i11;
                        int i13 = this.f5448d;
                        this.f5448d = i13 + 1;
                        int i14 = bArr[i13] & 255;
                        if (iArr[i14] == 0) {
                            this.f5590U = i12;
                            return m6359g(i14);
                        }
                        if (i14 == 34) {
                            return m6329c(i12, 4);
                        }
                        return m6326b(i12, i14, 4);
                    }
                    if (i11 == 34) {
                        return m6329c(i9, 3);
                    }
                    return m6326b(i9, i11, 3);
                }
                if (i8 == 34) {
                    return m6329c(i6, 2);
                }
                return m6326b(i6, i8, 2);
            }
            if (i5 == 34) {
                return m6329c(i3, 1);
            }
            return m6326b(i3, i5, 1);
        }
        if (i3 == 34) {
            return "";
        }
        return m6326b(0, i3, 0);
    }

    /* JADX INFO: renamed from: g */
    protected final String m6359g(int i) throws IOException {
        byte[] bArr = this.f5588R;
        int[] iArr = f5581L;
        int i2 = this.f5448d;
        this.f5448d = i2 + 1;
        int i3 = bArr[i2] & 255;
        if (iArr[i3] != 0) {
            if (i3 == 34) {
                return m6330c(this.f5590U, i, 1);
            }
            return m6319a(this.f5590U, i, i3, 1);
        }
        int i4 = i3 | (i << 8);
        int i5 = this.f5448d;
        this.f5448d = i5 + 1;
        int i6 = bArr[i5] & 255;
        if (iArr[i6] != 0) {
            if (i6 == 34) {
                return m6330c(this.f5590U, i4, 2);
            }
            return m6319a(this.f5590U, i4, i6, 2);
        }
        int i7 = (i4 << 8) | i6;
        int i8 = this.f5448d;
        this.f5448d = i8 + 1;
        int i9 = bArr[i8] & 255;
        if (iArr[i9] != 0) {
            if (i9 == 34) {
                return m6330c(this.f5590U, i7, 3);
            }
            return m6319a(this.f5590U, i7, i9, 3);
        }
        int i10 = (i7 << 8) | i9;
        int i11 = this.f5448d;
        this.f5448d = i11 + 1;
        int i12 = bArr[i11] & 255;
        if (iArr[i12] != 0) {
            if (i12 == 34) {
                return m6330c(this.f5590U, i10, 4);
            }
            return m6319a(this.f5590U, i10, i12, 4);
        }
        return m6349a(i12, i10);
    }

    /* JADX INFO: renamed from: a */
    protected final String m6349a(int i, int i2) throws IOException {
        byte[] bArr = this.f5588R;
        int[] iArr = f5581L;
        int i3 = this.f5448d;
        this.f5448d = i3 + 1;
        int i4 = bArr[i3] & 255;
        if (iArr[i4] != 0) {
            if (i4 == 34) {
                return m6327b(this.f5590U, i2, i, 1);
            }
            return m6320a(this.f5590U, i2, i, i4, 1);
        }
        int i5 = (i << 8) | i4;
        int i6 = this.f5448d;
        this.f5448d = i6 + 1;
        int i7 = bArr[i6] & 255;
        if (iArr[i7] != 0) {
            if (i7 == 34) {
                return m6327b(this.f5590U, i2, i5, 2);
            }
            return m6320a(this.f5590U, i2, i5, i7, 2);
        }
        int i8 = (i5 << 8) | i7;
        int i9 = this.f5448d;
        this.f5448d = i9 + 1;
        int i10 = bArr[i9] & 255;
        if (iArr[i10] != 0) {
            if (i10 == 34) {
                return m6327b(this.f5590U, i2, i8, 3);
            }
            return m6320a(this.f5590U, i2, i8, i10, 3);
        }
        int i11 = (i8 << 8) | i10;
        int i12 = this.f5448d;
        this.f5448d = i12 + 1;
        int i13 = bArr[i12] & 255;
        if (iArr[i13] != 0) {
            if (i13 == 34) {
                return m6327b(this.f5590U, i2, i11, 4);
            }
            return m6320a(this.f5590U, i2, i11, i13, 4);
        }
        return m6350a(i13, i2, i11);
    }

    /* JADX INFO: renamed from: a */
    protected final String m6350a(int i, int i2, int i3) throws IOException {
        this.f5585O[0] = this.f5590U;
        this.f5585O[1] = i2;
        this.f5585O[2] = i3;
        byte[] bArr = this.f5588R;
        int[] iArr = f5581L;
        int i4 = 3;
        int i5 = i;
        while (this.f5448d + 4 <= this.f5449e) {
            int i6 = this.f5448d;
            this.f5448d = i6 + 1;
            int i7 = bArr[i6] & 255;
            if (iArr[i7] != 0) {
                if (i7 == 34) {
                    return m6322a(this.f5585O, i4, i5, 1);
                }
                return m6352a(this.f5585O, i4, i5, i7, 1);
            }
            int i8 = (i5 << 8) | i7;
            int i9 = this.f5448d;
            this.f5448d = i9 + 1;
            int i10 = bArr[i9] & 255;
            if (iArr[i10] != 0) {
                if (i10 == 34) {
                    return m6322a(this.f5585O, i4, i8, 2);
                }
                return m6352a(this.f5585O, i4, i8, i10, 2);
            }
            int i11 = (i8 << 8) | i10;
            int i12 = this.f5448d;
            this.f5448d = i12 + 1;
            int i13 = bArr[i12] & 255;
            if (iArr[i13] != 0) {
                if (i13 == 34) {
                    return m6322a(this.f5585O, i4, i11, 3);
                }
                return m6352a(this.f5585O, i4, i11, i13, 3);
            }
            int i14 = (i11 << 8) | i13;
            int i15 = this.f5448d;
            this.f5448d = i15 + 1;
            int i16 = bArr[i15] & 255;
            if (iArr[i16] != 0) {
                if (i16 == 34) {
                    return m6322a(this.f5585O, i4, i14, 4);
                }
                return m6352a(this.f5585O, i4, i14, i16, 4);
            }
            if (i4 >= this.f5585O.length) {
                this.f5585O = m6325a(this.f5585O, i4);
            }
            this.f5585O[i4] = i14;
            i4++;
            i5 = i16;
        }
        return m6352a(this.f5585O, i4, 0, i5, 0);
    }

    /* JADX INFO: renamed from: I */
    protected String m6342I() throws IOException {
        if (this.f5448d >= this.f5449e && !mo6118p()) {
            m6140c(": was expecting closing '\"' for name");
        }
        byte[] bArr = this.f5588R;
        int i = this.f5448d;
        this.f5448d = i + 1;
        int i2 = bArr[i] & 255;
        return i2 == 34 ? "" : m6352a(this.f5585O, 0, 0, i2, 0);
    }

    /* JADX INFO: renamed from: b */
    private final String m6326b(int i, int i2, int i3) throws IOException {
        return m6352a(this.f5585O, 0, i, i2, i3);
    }

    /* JADX INFO: renamed from: a */
    private final String m6319a(int i, int i2, int i3, int i4) throws IOException {
        this.f5585O[0] = i;
        return m6352a(this.f5585O, 1, i2, i3, i4);
    }

    /* JADX INFO: renamed from: a */
    private final String m6320a(int i, int i2, int i3, int i4, int i5) throws IOException {
        this.f5585O[0] = i;
        this.f5585O[1] = i2;
        return m6352a(this.f5585O, 2, i3, i4, i5);
    }

    /* JADX WARN: Removed duplicated region for block: B:52:0x00db A[PHI: r13
      0x00db: PHI (r13v2 int) = (r13v1 int), (r13v5 int) binds: [B:4:0x0006, B:20:0x0039] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected final java.lang.String m6352a(int[] r10, int r11, int r12, int r13, int r14) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 223
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.json.UTF8StreamJsonParser.m6352a(int[], int, int, int, int):java.lang.String");
    }

    /* JADX INFO: renamed from: h */
    protected String m6360h(int i) throws IOException {
        int[] iArrM6325a;
        int i2;
        int i3;
        int i4;
        if (i == 39 && m6062a(JsonParser.Feature.ALLOW_SINGLE_QUOTES)) {
            return m6343J();
        }
        if (!m6062a(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES)) {
            m6137b((char) m6362j(i), "was expecting double-quote to start field name");
        }
        int[] iArrM6147d = CharTypes.m6147d();
        if (iArrM6147d[i] != 0) {
            m6137b(i, "was expecting either valid name character (for unquoted name) or double-quote (for quoted) to start field name");
        }
        int i5 = 0;
        int i6 = 0;
        int i7 = i;
        int i8 = 0;
        int[] iArrM6325a2 = this.f5585O;
        while (true) {
            if (i5 < 4) {
                int i9 = i5 + 1;
                i3 = i7 | (i6 << 8);
                i4 = i8;
                iArrM6325a = iArrM6325a2;
                i2 = i9;
            } else {
                if (i8 >= iArrM6325a2.length) {
                    iArrM6325a2 = m6325a(iArrM6325a2, iArrM6325a2.length);
                    this.f5585O = iArrM6325a2;
                }
                int i10 = i8 + 1;
                iArrM6325a2[i8] = i6;
                iArrM6325a = iArrM6325a2;
                i2 = 1;
                i3 = i7;
                i4 = i10;
            }
            if (this.f5448d >= this.f5449e && !mo6118p()) {
                m6140c(" in field name");
            }
            int i11 = this.f5588R[this.f5448d] & 255;
            if (iArrM6147d[i11] != 0) {
                break;
            }
            this.f5448d++;
            i6 = i3;
            i5 = i2;
            iArrM6325a2 = iArrM6325a;
            i8 = i4;
            i7 = i11;
        }
        if (i2 > 0) {
            if (i4 >= iArrM6325a.length) {
                iArrM6325a = m6325a(iArrM6325a, iArrM6325a.length);
                this.f5585O = iArrM6325a;
            }
            iArrM6325a[i4] = i3;
            i4++;
        }
        String strM6407a = this.f5584N.m6407a(iArrM6325a, i4);
        return strM6407a == null ? m6321a(iArrM6325a, i4, i2) : strM6407a;
    }

    /* JADX WARN: Removed duplicated region for block: B:63:0x011c A[PHI: r5
      0x011c: PHI (r5v2 int) = (r5v1 int), (r5v1 int), (r5v12 int) binds: [B:22:0x0055, B:24:0x0059, B:29:0x0066] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX INFO: renamed from: J */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected java.lang.String m6343J() throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 290
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.json.UTF8StreamJsonParser.m6343J():java.lang.String");
    }

    /* JADX INFO: renamed from: c */
    private final String m6329c(int i, int i2) throws JsonParseException {
        int iM6331d = m6331d(i, i2);
        String strM6413c = this.f5584N.m6413c(iM6331d);
        if (strM6413c == null) {
            this.f5585O[0] = iM6331d;
            return m6321a(this.f5585O, 1, i2);
        }
        return strM6413c;
    }

    /* JADX INFO: renamed from: c */
    private final String m6330c(int i, int i2, int i3) throws JsonParseException {
        int iM6331d = m6331d(i2, i3);
        String strM6404a = this.f5584N.m6404a(i, iM6331d);
        if (strM6404a == null) {
            this.f5585O[0] = i;
            this.f5585O[1] = iM6331d;
            return m6321a(this.f5585O, 2, i3);
        }
        return strM6404a;
    }

    /* JADX INFO: renamed from: b */
    private final String m6327b(int i, int i2, int i3, int i4) throws JsonParseException {
        int iM6331d = m6331d(i3, i4);
        String strM6405a = this.f5584N.m6405a(i, i2, iM6331d);
        if (strM6405a == null) {
            int[] iArr = this.f5585O;
            iArr[0] = i;
            iArr[1] = i2;
            iArr[2] = m6331d(iM6331d, i4);
            return m6321a(iArr, 3, i4);
        }
        return strM6405a;
    }

    /* JADX INFO: renamed from: a */
    private final String m6322a(int[] iArr, int i, int i2, int i3) throws JsonParseException {
        if (i >= iArr.length) {
            iArr = m6325a(iArr, iArr.length);
            this.f5585O = iArr;
        }
        int i4 = i + 1;
        iArr[i] = m6331d(i2, i3);
        String strM6407a = this.f5584N.m6407a(iArr, i4);
        if (strM6407a == null) {
            return m6321a(iArr, i4, i3);
        }
        return strM6407a;
    }

    /* JADX WARN: Removed duplicated region for block: B:52:0x0114 A[PHI: r2 r3
      0x0114: PHI (r2v6 int) = (r2v5 int), (r2v17 int) binds: [B:8:0x0033, B:30:0x00a4] A[DONT_GENERATE, DONT_INLINE]
      0x0114: PHI (r3v4 int) = (r3v3 int), (r3v9 int) binds: [B:8:0x0033, B:30:0x00a4] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final java.lang.String m6321a(int[] r12, int r13, int r14) throws com.fasterxml.jackson.core.JsonParseException {
        /*
            Method dump skipped, instruction units count: 281
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.json.UTF8StreamJsonParser.m6321a(int[], int, int):java.lang.String");
    }

    @Override // com.fasterxml.jackson.core.base.ParserBase
    /* JADX INFO: renamed from: q */
    protected void mo6119q() throws IOException {
        int i = this.f5448d;
        if (i >= this.f5449e) {
            m6117o();
            i = this.f5448d;
        }
        char[] cArrM6490k = this.f5458n.m6490k();
        int[] iArr = f5582T;
        int iMin = Math.min(this.f5449e, cArrM6490k.length + i);
        byte[] bArr = this.f5588R;
        int i2 = i;
        int i3 = 0;
        while (true) {
            if (i2 >= iMin) {
                break;
            }
            int i4 = bArr[i2] & 255;
            if (iArr[i4] != 0) {
                if (i4 == 34) {
                    this.f5448d = i2 + 1;
                    this.f5458n.m6475a(i3);
                    return;
                }
            } else {
                cArrM6490k[i3] = (char) i4;
                i3++;
                i2++;
            }
        }
        this.f5448d = i2;
        m6324a(cArrM6490k, i3);
    }

    /* JADX INFO: renamed from: K */
    protected String m6344K() throws IOException {
        int i = this.f5448d;
        if (i >= this.f5449e) {
            m6117o();
            i = this.f5448d;
        }
        char[] cArrM6490k = this.f5458n.m6490k();
        int[] iArr = f5582T;
        int iMin = Math.min(this.f5449e, cArrM6490k.length + i);
        byte[] bArr = this.f5588R;
        int i2 = i;
        int i3 = 0;
        while (true) {
            if (i2 >= iMin) {
                break;
            }
            int i4 = bArr[i2] & 255;
            if (iArr[i4] != 0) {
                if (i4 == 34) {
                    this.f5448d = i2 + 1;
                    return this.f5458n.m6478b(i3);
                }
            } else {
                cArrM6490k[i3] = (char) i4;
                i3++;
                i2++;
            }
        }
        this.f5448d = i2;
        m6324a(cArrM6490k, i3);
        return this.f5458n.m6485f();
    }

    /* JADX INFO: renamed from: a */
    private final void m6324a(char[] cArr, int i) throws IOException {
        int i2;
        int[] iArr = f5582T;
        byte[] bArr = this.f5588R;
        while (true) {
            int i3 = this.f5448d;
            if (i3 >= this.f5449e) {
                m6117o();
                i3 = this.f5448d;
            }
            if (i >= cArr.length) {
                cArr = this.f5458n.m6492m();
                i = 0;
            }
            int iMin = Math.min(this.f5449e, (cArr.length - i) + i3);
            while (true) {
                if (i3 < iMin) {
                    int i4 = i3 + 1;
                    int iM6335q = bArr[i3] & 255;
                    if (iArr[iM6335q] != 0) {
                        this.f5448d = i4;
                        if (iM6335q != 34) {
                            switch (iArr[iM6335q]) {
                                case 1:
                                    iM6335q = mo6108D();
                                    break;
                                case 2:
                                    iM6335q = m6334p(iM6335q);
                                    break;
                                case 3:
                                    if (this.f5449e - this.f5448d >= 2) {
                                        iM6335q = m6336r(iM6335q);
                                    } else {
                                        iM6335q = m6335q(iM6335q);
                                    }
                                    break;
                                case 4:
                                    int iM6337s = m6337s(iM6335q);
                                    int i5 = i + 1;
                                    cArr[i] = (char) (55296 | (iM6337s >> 10));
                                    if (i5 >= cArr.length) {
                                        cArr = this.f5458n.m6492m();
                                        i5 = 0;
                                    }
                                    i = i5;
                                    iM6335q = (iM6337s & 1023) | 56320;
                                    break;
                                default:
                                    if (iM6335q < 32) {
                                        m6139c(iM6335q, "string value");
                                    } else {
                                        m6363k(iM6335q);
                                    }
                                    break;
                            }
                            if (i >= cArr.length) {
                                cArr = this.f5458n.m6492m();
                                i2 = 0;
                            } else {
                                i2 = i;
                            }
                            i = i2 + 1;
                            cArr[i2] = (char) iM6335q;
                        } else {
                            this.f5458n.m6475a(i);
                            return;
                        }
                    } else {
                        cArr[i] = (char) iM6335q;
                        i3 = i4;
                        i++;
                    }
                } else {
                    this.f5448d = i3;
                }
            }
        }
    }

    /* JADX INFO: renamed from: L */
    protected void m6345L() throws IOException {
        this.f5586P = false;
        int[] iArr = f5582T;
        byte[] bArr = this.f5588R;
        while (true) {
            int i = this.f5448d;
            int i2 = this.f5449e;
            if (i >= i2) {
                m6117o();
                i = this.f5448d;
                i2 = this.f5449e;
            }
            while (true) {
                if (i < i2) {
                    int i3 = i + 1;
                    int i4 = bArr[i] & 255;
                    if (iArr[i4] != 0) {
                        this.f5448d = i3;
                        if (i4 != 34) {
                            switch (iArr[i4]) {
                                case 1:
                                    mo6108D();
                                    break;
                                case 2:
                                    m6338t(i4);
                                    break;
                                case 3:
                                    m6339u(i4);
                                    break;
                                case 4:
                                    m6340v(i4);
                                    break;
                                default:
                                    if (i4 < 32) {
                                        m6139c(i4, "string value");
                                    } else {
                                        m6363k(i4);
                                    }
                                    break;
                            }
                        } else {
                            return;
                        }
                    } else {
                        i = i3;
                    }
                } else {
                    this.f5448d = i;
                }
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:6:0x000a  */
    /* JADX INFO: renamed from: i */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected com.fasterxml.jackson.core.JsonToken m6361i(int r5) throws java.io.IOException {
        /*
            r4 = this;
            r1 = 1
            switch(r5) {
                case 39: goto L2f;
                case 43: goto L74;
                case 73: goto L58;
                case 78: goto L3c;
                case 93: goto L2a;
                case 125: goto L2a;
                default: goto L4;
            }
        L4:
            boolean r0 = java.lang.Character.isJavaIdentifierStart(r5)
            if (r0 == 0) goto L23
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = ""
            java.lang.StringBuilder r0 = r0.append(r1)
            char r1 = (char) r5
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "('true', 'false' or 'null')"
            r4.m6354a(r0, r1)
        L23:
            java.lang.String r0 = "expected a valid value (number, String, array, object, 'true', 'false' or 'null')"
            r4.m6137b(r5, r0)
            r0 = 0
        L29:
            return r0
        L2a:
            java.lang.String r0 = "expected a value"
            r4.m6137b(r5, r0)
        L2f:
            com.fasterxml.jackson.core.JsonParser$Feature r0 = com.fasterxml.jackson.core.JsonParser.Feature.ALLOW_SINGLE_QUOTES
            boolean r0 = r4.m6062a(r0)
            if (r0 == 0) goto L4
            com.fasterxml.jackson.core.JsonToken r0 = r4.m6346M()
            goto L29
        L3c:
            java.lang.String r0 = "NaN"
            r4.m6353a(r0, r1)
            com.fasterxml.jackson.core.JsonParser$Feature r0 = com.fasterxml.jackson.core.JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS
            boolean r0 = r4.m6062a(r0)
            if (r0 == 0) goto L52
            java.lang.String r0 = "NaN"
            r2 = 9221120237041090560(0x7ff8000000000000, double:NaN)
            com.fasterxml.jackson.core.JsonToken r0 = r4.m6109a(r0, r2)
            goto L29
        L52:
            java.lang.String r0 = "Non-standard token 'NaN': enable JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS to allow"
            r4.m6141d(r0)
            goto L4
        L58:
            java.lang.String r0 = "Infinity"
            r4.m6353a(r0, r1)
            com.fasterxml.jackson.core.JsonParser$Feature r0 = com.fasterxml.jackson.core.JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS
            boolean r0 = r4.m6062a(r0)
            if (r0 == 0) goto L6e
            java.lang.String r0 = "Infinity"
            r2 = 9218868437227405312(0x7ff0000000000000, double:Infinity)
            com.fasterxml.jackson.core.JsonToken r0 = r4.m6109a(r0, r2)
            goto L29
        L6e:
            java.lang.String r0 = "Non-standard token 'Infinity': enable JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS to allow"
            r4.m6141d(r0)
            goto L4
        L74:
            int r0 = r4.f5448d
            int r1 = r4.f5449e
            if (r0 < r1) goto L83
            boolean r0 = r4.mo6118p()
            if (r0 != 0) goto L83
            r4.m6131F()
        L83:
            byte[] r0 = r4.f5588R
            int r1 = r4.f5448d
            int r2 = r1 + 1
            r4.f5448d = r2
            r0 = r0[r1]
            r0 = r0 & 255(0xff, float:3.57E-43)
            r1 = 0
            com.fasterxml.jackson.core.JsonToken r0 = r4.m6348a(r0, r1)
            goto L29
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.json.UTF8StreamJsonParser.m6361i(int):com.fasterxml.jackson.core.JsonToken");
    }

    /* JADX INFO: renamed from: M */
    protected JsonToken m6346M() throws IOException {
        int iM6335q;
        int i;
        char[] cArrM6490k = this.f5458n.m6490k();
        int[] iArr = f5582T;
        byte[] bArr = this.f5588R;
        int i2 = 0;
        while (true) {
            if (this.f5448d >= this.f5449e) {
                m6117o();
            }
            if (i2 >= cArrM6490k.length) {
                cArrM6490k = this.f5458n.m6492m();
                i2 = 0;
            }
            int i3 = this.f5449e;
            int length = this.f5448d + (cArrM6490k.length - i2);
            if (length >= i3) {
                length = i3;
            }
            while (this.f5448d < length) {
                int i4 = this.f5448d;
                this.f5448d = i4 + 1;
                int i5 = bArr[i4] & 255;
                if (i5 != 39 && iArr[i5] == 0) {
                    cArrM6490k[i2] = (char) i5;
                    i2++;
                } else if (i5 != 39) {
                    switch (iArr[i5]) {
                        case 1:
                            iM6335q = i5 == 39 ? i5 : mo6108D();
                            break;
                        case 2:
                            iM6335q = m6334p(i5);
                            break;
                        case 3:
                            if (this.f5449e - this.f5448d >= 2) {
                                iM6335q = m6336r(i5);
                            } else {
                                iM6335q = m6335q(i5);
                            }
                            break;
                        case 4:
                            int iM6337s = m6337s(i5);
                            int i6 = i2 + 1;
                            cArrM6490k[i2] = (char) (55296 | (iM6337s >> 10));
                            if (i6 >= cArrM6490k.length) {
                                cArrM6490k = this.f5458n.m6492m();
                                i2 = 0;
                            } else {
                                i2 = i6;
                            }
                            iM6335q = 56320 | (iM6337s & 1023);
                            break;
                        default:
                            if (i5 < 32) {
                                m6139c(i5, "string value");
                            }
                            m6363k(i5);
                            break;
                    }
                    if (i2 >= cArrM6490k.length) {
                        cArrM6490k = this.f5458n.m6492m();
                        i = 0;
                    } else {
                        i = i2;
                    }
                    i2 = i + 1;
                    cArrM6490k[i] = (char) iM6335q;
                } else {
                    this.f5458n.m6475a(i2);
                    return JsonToken.VALUE_STRING;
                }
            }
        }
    }

    /* JADX INFO: renamed from: a */
    protected JsonToken m6348a(int i, boolean z) throws IOException {
        String str;
        int i2 = i;
        while (true) {
            if (i2 != 73) {
                break;
            }
            if (this.f5448d >= this.f5449e && !mo6118p()) {
                m6131F();
            }
            byte[] bArr = this.f5588R;
            int i3 = this.f5448d;
            this.f5448d = i3 + 1;
            byte b = bArr[i3];
            if (b == 78) {
                str = z ? "-INF" : "+INF";
            } else {
                if (b != 110) {
                    i2 = b;
                    break;
                }
                str = z ? "-Infinity" : "+Infinity";
            }
            m6353a(str, 3);
            if (m6062a(JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS)) {
                return m6109a(str, z ? Double.NEGATIVE_INFINITY : Double.POSITIVE_INFINITY);
            }
            m6141d("Non-standard token '" + str + "': enable JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS to allow");
            i2 = b;
        }
        m6114a(i2, "expected digit (0-9) to follow minus sign, for valid numeric value");
        return null;
    }

    /* JADX INFO: renamed from: a */
    protected final void m6353a(String str, int i) throws IOException {
        int length = str.length();
        if (this.f5448d + length >= this.f5449e) {
            m6328b(str, i);
            return;
        }
        do {
            if (this.f5588R[this.f5448d] != str.charAt(i)) {
                m6357e(str.substring(0, i));
            }
            this.f5448d++;
            i++;
        } while (i < length);
        int i2 = this.f5588R[this.f5448d] & 255;
        if (i2 >= 48 && i2 != 93 && i2 != 125) {
            m6323a(str, i, i2);
        }
    }

    /* JADX INFO: renamed from: b */
    private final void m6328b(String str, int i) throws IOException {
        int i2;
        int length = str.length();
        do {
            if ((this.f5448d >= this.f5449e && !mo6118p()) || this.f5588R[this.f5448d] != str.charAt(i)) {
                m6357e(str.substring(0, i));
            }
            this.f5448d++;
            i++;
        } while (i < length);
        if ((this.f5448d < this.f5449e || mo6118p()) && (i2 = this.f5588R[this.f5448d] & 255) >= 48 && i2 != 93 && i2 != 125) {
            m6323a(str, i, i2);
        }
    }

    /* JADX INFO: renamed from: a */
    private final void m6323a(String str, int i, int i2) throws IOException {
        if (Character.isJavaIdentifierPart((char) m6362j(i2))) {
            m6357e(str.substring(0, i));
        }
    }

    /* JADX INFO: renamed from: Q */
    private final int m6306Q() throws IOException {
        while (this.f5448d < this.f5449e) {
            byte[] bArr = this.f5588R;
            int i = this.f5448d;
            this.f5448d = i + 1;
            int i2 = bArr[i] & 255;
            if (i2 > 32) {
                if (i2 == 47 || i2 == 35) {
                    this.f5448d--;
                    return m6307R();
                }
                return i2;
            }
            if (i2 != 32) {
                if (i2 == 10) {
                    this.f5451g++;
                    this.f5452h = this.f5448d;
                } else if (i2 == 13) {
                    m6347N();
                } else if (i2 != 9) {
                    m6138c(i2);
                }
            }
        }
        return m6307R();
    }

    /* JADX INFO: renamed from: R */
    private final int m6307R() throws IOException {
        int i;
        while (true) {
            if (this.f5448d < this.f5449e || mo6118p()) {
                byte[] bArr = this.f5588R;
                int i2 = this.f5448d;
                this.f5448d = i2 + 1;
                i = bArr[i2] & 255;
                if (i > 32) {
                    if (i == 47) {
                        m6311V();
                    } else if (i != 35 || !m6313X()) {
                        break;
                    }
                } else if (i != 32) {
                    if (i == 10) {
                        this.f5451g++;
                        this.f5452h = this.f5448d;
                    } else if (i == 13) {
                        m6347N();
                    } else if (i != 9) {
                        m6138c(i);
                    }
                }
            } else {
                throw m6060a("Unexpected end-of-input within/between " + this.f5456l.m6081d() + " entries");
            }
        }
        return i;
    }

    /* JADX INFO: renamed from: S */
    private final int m6308S() throws IOException {
        if (this.f5448d >= this.f5449e && !mo6118p()) {
            return m6123u();
        }
        byte[] bArr = this.f5588R;
        int i = this.f5448d;
        this.f5448d = i + 1;
        int i2 = bArr[i] & 255;
        if (i2 > 32) {
            if (i2 == 47 || i2 == 35) {
                this.f5448d--;
                return m6309T();
            }
            return i2;
        }
        if (i2 != 32) {
            if (i2 == 10) {
                this.f5451g++;
                this.f5452h = this.f5448d;
            } else if (i2 == 13) {
                m6347N();
            } else if (i2 != 9) {
                m6138c(i2);
            }
        }
        while (this.f5448d < this.f5449e) {
            byte[] bArr2 = this.f5588R;
            int i3 = this.f5448d;
            this.f5448d = i3 + 1;
            int i4 = bArr2[i3] & 255;
            if (i4 > 32) {
                if (i4 == 47 || i4 == 35) {
                    this.f5448d--;
                    return m6309T();
                }
                return i4;
            }
            if (i4 != 32) {
                if (i4 == 10) {
                    this.f5451g++;
                    this.f5452h = this.f5448d;
                } else if (i4 == 13) {
                    m6347N();
                } else if (i4 != 9) {
                    m6138c(i4);
                }
            }
        }
        return m6309T();
    }

    /* JADX INFO: renamed from: T */
    private final int m6309T() throws IOException {
        while (true) {
            if (this.f5448d < this.f5449e || mo6118p()) {
                byte[] bArr = this.f5588R;
                int i = this.f5448d;
                this.f5448d = i + 1;
                int i2 = bArr[i] & 255;
                if (i2 > 32) {
                    if (i2 == 47) {
                        m6311V();
                    } else if (i2 != 35 || !m6313X()) {
                        return i2;
                    }
                } else if (i2 != 32) {
                    if (i2 == 10) {
                        this.f5451g++;
                        this.f5452h = this.f5448d;
                    } else if (i2 == 13) {
                        m6347N();
                    } else if (i2 != 9) {
                        m6138c(i2);
                    }
                }
            } else {
                return m6123u();
            }
        }
    }

    /* JADX INFO: renamed from: U */
    private final int m6310U() throws IOException {
        if (this.f5448d + 4 >= this.f5449e) {
            return m6316a(false);
        }
        byte b = this.f5588R[this.f5448d];
        if (b == 58) {
            byte[] bArr = this.f5588R;
            int i = this.f5448d + 1;
            this.f5448d = i;
            byte b2 = bArr[i];
            if (b2 > 32) {
                if (b2 == 47 || b2 == 35) {
                    return m6316a(true);
                }
                this.f5448d++;
                return b2;
            }
            if (b2 == 32 || b2 == 9) {
                byte[] bArr2 = this.f5588R;
                int i2 = this.f5448d + 1;
                this.f5448d = i2;
                byte b3 = bArr2[i2];
                if (b3 > 32) {
                    if (b3 == 47 || b3 == 35) {
                        return m6316a(true);
                    }
                    this.f5448d++;
                    return b3;
                }
            }
            return m6316a(true);
        }
        if (b == 32 || b == 9) {
            byte[] bArr3 = this.f5588R;
            int i3 = this.f5448d + 1;
            this.f5448d = i3;
            b = bArr3[i3];
        }
        if (b == 58) {
            byte[] bArr4 = this.f5588R;
            int i4 = this.f5448d + 1;
            this.f5448d = i4;
            byte b4 = bArr4[i4];
            if (b4 > 32) {
                if (b4 == 47 || b4 == 35) {
                    return m6316a(true);
                }
                this.f5448d++;
                return b4;
            }
            if (b4 == 32 || b4 == 9) {
                byte[] bArr5 = this.f5588R;
                int i5 = this.f5448d + 1;
                this.f5448d = i5;
                byte b5 = bArr5[i5];
                if (b5 > 32) {
                    if (b5 == 47 || b5 == 35) {
                        return m6316a(true);
                    }
                    this.f5448d++;
                    return b5;
                }
            }
            return m6316a(true);
        }
        return m6316a(false);
    }

    /* JADX INFO: renamed from: a */
    private final int m6316a(boolean z) throws IOException {
        while (true) {
            if (this.f5448d < this.f5449e || mo6118p()) {
                byte[] bArr = this.f5588R;
                int i = this.f5448d;
                this.f5448d = i + 1;
                int i2 = bArr[i] & 255;
                if (i2 > 32) {
                    if (i2 == 47) {
                        m6311V();
                    } else if (i2 != 35 || !m6313X()) {
                        if (z) {
                            return i2;
                        }
                        if (i2 != 58) {
                            if (i2 < 32) {
                                m6138c(i2);
                            }
                            m6137b(i2, "was expecting a colon to separate field name and value");
                        }
                        z = true;
                    }
                } else if (i2 != 32) {
                    if (i2 == 10) {
                        this.f5451g++;
                        this.f5452h = this.f5448d;
                    } else if (i2 == 13) {
                        m6347N();
                    } else if (i2 != 9) {
                        m6138c(i2);
                    }
                }
            } else {
                throw m6060a("Unexpected end-of-input within/between " + this.f5456l.m6081d() + " entries");
            }
        }
    }

    /* JADX INFO: renamed from: V */
    private final void m6311V() throws IOException {
        if (!m6062a(JsonParser.Feature.ALLOW_COMMENTS)) {
            m6137b(47, "maybe a (non-standard) comment? (not recognized as one since Feature 'ALLOW_COMMENTS' not enabled for parser)");
        }
        if (this.f5448d >= this.f5449e && !mo6118p()) {
            m6140c(" in a comment");
        }
        byte[] bArr = this.f5588R;
        int i = this.f5448d;
        this.f5448d = i + 1;
        int i2 = bArr[i] & 255;
        if (i2 == 47) {
            m6314Y();
        } else if (i2 == 42) {
            m6312W();
        } else {
            m6137b(i2, "was expecting either '*' or '/' for a comment");
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0033, code lost:
    
        m6140c(" in a comment");
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0038, code lost:
    
        return;
     */
    /* JADX INFO: renamed from: W */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void m6312W() throws java.io.IOException {
        /*
            r4 = this;
            int[] r0 = com.fasterxml.jackson.core.p000io.CharTypes.m6148e()
        L4:
            int r1 = r4.f5448d
            int r2 = r4.f5449e
            if (r1 < r2) goto L10
            boolean r1 = r4.mo6118p()
            if (r1 == 0) goto L33
        L10:
            byte[] r1 = r4.f5588R
            int r2 = r4.f5448d
            int r3 = r2 + 1
            r4.f5448d = r3
            r1 = r1[r2]
            r1 = r1 & 255(0xff, float:3.57E-43)
            r2 = r0[r1]
            if (r2 == 0) goto L4
            switch(r2) {
                case 2: goto L59;
                case 3: goto L5d;
                case 4: goto L61;
                case 10: goto L4a;
                case 13: goto L55;
                case 42: goto L27;
                default: goto L23;
            }
        L23:
            r4.m6363k(r1)
            goto L4
        L27:
            int r1 = r4.f5448d
            int r2 = r4.f5449e
            if (r1 < r2) goto L39
            boolean r1 = r4.mo6118p()
            if (r1 != 0) goto L39
        L33:
            java.lang.String r0 = " in a comment"
            r4.m6140c(r0)
        L38:
            return
        L39:
            byte[] r1 = r4.f5588R
            int r2 = r4.f5448d
            r1 = r1[r2]
            r2 = 47
            if (r1 != r2) goto L4
            int r0 = r4.f5448d
            int r0 = r0 + 1
            r4.f5448d = r0
            goto L38
        L4a:
            int r1 = r4.f5451g
            int r1 = r1 + 1
            r4.f5451g = r1
            int r1 = r4.f5448d
            r4.f5452h = r1
            goto L4
        L55:
            r4.m6347N()
            goto L4
        L59:
            r4.m6338t(r1)
            goto L4
        L5d:
            r4.m6339u(r1)
            goto L4
        L61:
            r4.m6340v(r1)
            goto L4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.json.UTF8StreamJsonParser.m6312W():void");
    }

    /* JADX INFO: renamed from: X */
    private final boolean m6313X() throws IOException {
        if (!m6062a(JsonParser.Feature.ALLOW_YAML_COMMENTS)) {
            return false;
        }
        m6314Y();
        return true;
    }

    /* JADX INFO: renamed from: Y */
    private final void m6314Y() throws IOException {
        int[] iArrM6148e = CharTypes.m6148e();
        while (true) {
            if (this.f5448d < this.f5449e || mo6118p()) {
                byte[] bArr = this.f5588R;
                int i = this.f5448d;
                this.f5448d = i + 1;
                int i2 = bArr[i] & 255;
                int i3 = iArrM6148e[i2];
                if (i3 != 0) {
                    switch (i3) {
                        case 2:
                            m6338t(i2);
                            break;
                        case 3:
                            m6339u(i2);
                            break;
                        case 4:
                            m6340v(i2);
                            break;
                        case 10:
                            this.f5451g++;
                            this.f5452h = this.f5448d;
                            return;
                        case 13:
                            m6347N();
                            return;
                        case 42:
                            break;
                        default:
                            if (i3 < 0) {
                                m6363k(i2);
                            }
                            break;
                    }
                }
            } else {
                return;
            }
        }
    }

    @Override // com.fasterxml.jackson.core.base.ParserBase
    /* JADX INFO: renamed from: D */
    protected char mo6108D() throws IOException {
        if (this.f5448d >= this.f5449e && !mo6118p()) {
            m6140c(" in character escape sequence");
        }
        byte[] bArr = this.f5588R;
        int i = this.f5448d;
        this.f5448d = i + 1;
        byte b = bArr[i];
        switch (b) {
            case 34:
            case 47:
            case 92:
                return (char) b;
            case 98:
                return '\b';
            case 102:
                return '\f';
            case 110:
                return '\n';
            case 114:
                return TokenParser.f15712CR;
            case 116:
                return '\t';
            case 117:
                int i2 = 0;
                for (int i3 = 0; i3 < 4; i3++) {
                    if (this.f5448d >= this.f5449e && !mo6118p()) {
                        m6140c(" in character escape sequence");
                    }
                    byte[] bArr2 = this.f5588R;
                    int i4 = this.f5448d;
                    this.f5448d = i4 + 1;
                    byte b2 = bArr2[i4];
                    int iM6142a = CharTypes.m6142a(b2);
                    if (iM6142a < 0) {
                        m6137b(b2, "expected a hex-digit for character escape sequence");
                    }
                    i2 = (i2 << 4) | iM6142a;
                }
                return (char) i2;
            default:
                return m6133a((char) m6362j(b));
        }
    }

    /* JADX INFO: renamed from: j */
    protected int m6362j(int i) throws IOException {
        int i2;
        char c;
        int i3 = i & 255;
        if (i3 > 127) {
            if ((i3 & 224) == 192) {
                i2 = i3 & 31;
                c = 1;
            } else if ((i3 & 240) == 224) {
                i2 = i3 & 15;
                c = 2;
            } else if ((i3 & 248) == 240) {
                i2 = i3 & 7;
                c = 3;
            } else {
                m6364l(i3 & 255);
                i2 = i3;
                c = 1;
            }
            int iM6315Z = m6315Z();
            if ((iM6315Z & 192) != 128) {
                m6365m(iM6315Z & 255);
            }
            int i4 = (i2 << 6) | (iM6315Z & 63);
            if (c <= 1) {
                return i4;
            }
            int iM6315Z2 = m6315Z();
            if ((iM6315Z2 & 192) != 128) {
                m6365m(iM6315Z2 & 255);
            }
            int i5 = (iM6315Z2 & 63) | (i4 << 6);
            if (c <= 2) {
                return i5;
            }
            int iM6315Z3 = m6315Z();
            if ((iM6315Z3 & 192) != 128) {
                m6365m(iM6315Z3 & 255);
            }
            return (iM6315Z3 & 63) | (i5 << 6);
        }
        return i3;
    }

    /* JADX INFO: renamed from: p */
    private final int m6334p(int i) throws IOException {
        if (this.f5448d >= this.f5449e) {
            m6117o();
        }
        byte[] bArr = this.f5588R;
        int i2 = this.f5448d;
        this.f5448d = i2 + 1;
        byte b = bArr[i2];
        if ((b & 192) != 128) {
            m6355b(b & 255, this.f5448d);
        }
        return (b & 63) | ((i & 31) << 6);
    }

    /* JADX INFO: renamed from: q */
    private final int m6335q(int i) throws IOException {
        if (this.f5448d >= this.f5449e) {
            m6117o();
        }
        int i2 = i & 15;
        byte[] bArr = this.f5588R;
        int i3 = this.f5448d;
        this.f5448d = i3 + 1;
        byte b = bArr[i3];
        if ((b & 192) != 128) {
            m6355b(b & 255, this.f5448d);
        }
        int i4 = (i2 << 6) | (b & 63);
        if (this.f5448d >= this.f5449e) {
            m6117o();
        }
        byte[] bArr2 = this.f5588R;
        int i5 = this.f5448d;
        this.f5448d = i5 + 1;
        byte b2 = bArr2[i5];
        if ((b2 & 192) != 128) {
            m6355b(b2 & 255, this.f5448d);
        }
        return (i4 << 6) | (b2 & 63);
    }

    /* JADX INFO: renamed from: r */
    private final int m6336r(int i) throws IOException {
        int i2 = i & 15;
        byte[] bArr = this.f5588R;
        int i3 = this.f5448d;
        this.f5448d = i3 + 1;
        byte b = bArr[i3];
        if ((b & 192) != 128) {
            m6355b(b & 255, this.f5448d);
        }
        int i4 = (i2 << 6) | (b & 63);
        byte[] bArr2 = this.f5588R;
        int i5 = this.f5448d;
        this.f5448d = i5 + 1;
        byte b2 = bArr2[i5];
        if ((b2 & 192) != 128) {
            m6355b(b2 & 255, this.f5448d);
        }
        return (i4 << 6) | (b2 & 63);
    }

    /* JADX INFO: renamed from: s */
    private final int m6337s(int i) throws IOException {
        if (this.f5448d >= this.f5449e) {
            m6117o();
        }
        byte[] bArr = this.f5588R;
        int i2 = this.f5448d;
        this.f5448d = i2 + 1;
        byte b = bArr[i2];
        if ((b & 192) != 128) {
            m6355b(b & 255, this.f5448d);
        }
        int i3 = (b & 63) | ((i & 7) << 6);
        if (this.f5448d >= this.f5449e) {
            m6117o();
        }
        byte[] bArr2 = this.f5588R;
        int i4 = this.f5448d;
        this.f5448d = i4 + 1;
        byte b2 = bArr2[i4];
        if ((b2 & 192) != 128) {
            m6355b(b2 & 255, this.f5448d);
        }
        int i5 = (i3 << 6) | (b2 & 63);
        if (this.f5448d >= this.f5449e) {
            m6117o();
        }
        byte[] bArr3 = this.f5588R;
        int i6 = this.f5448d;
        this.f5448d = i6 + 1;
        byte b3 = bArr3[i6];
        if ((b3 & 192) != 128) {
            m6355b(b3 & 255, this.f5448d);
        }
        return ((i5 << 6) | (b3 & 63)) - NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
    }

    /* JADX INFO: renamed from: t */
    private final void m6338t(int i) throws IOException {
        if (this.f5448d >= this.f5449e) {
            m6117o();
        }
        byte[] bArr = this.f5588R;
        int i2 = this.f5448d;
        this.f5448d = i2 + 1;
        byte b = bArr[i2];
        if ((b & 192) != 128) {
            m6355b(b & 255, this.f5448d);
        }
    }

    /* JADX INFO: renamed from: u */
    private final void m6339u(int i) throws IOException {
        if (this.f5448d >= this.f5449e) {
            m6117o();
        }
        byte[] bArr = this.f5588R;
        int i2 = this.f5448d;
        this.f5448d = i2 + 1;
        byte b = bArr[i2];
        if ((b & 192) != 128) {
            m6355b(b & 255, this.f5448d);
        }
        if (this.f5448d >= this.f5449e) {
            m6117o();
        }
        byte[] bArr2 = this.f5588R;
        int i3 = this.f5448d;
        this.f5448d = i3 + 1;
        byte b2 = bArr2[i3];
        if ((b2 & 192) != 128) {
            m6355b(b2 & 255, this.f5448d);
        }
    }

    /* JADX INFO: renamed from: v */
    private final void m6340v(int i) throws IOException {
        if (this.f5448d >= this.f5449e) {
            m6117o();
        }
        byte[] bArr = this.f5588R;
        int i2 = this.f5448d;
        this.f5448d = i2 + 1;
        byte b = bArr[i2];
        if ((b & 192) != 128) {
            m6355b(b & 255, this.f5448d);
        }
        if (this.f5448d >= this.f5449e) {
            m6117o();
        }
        byte[] bArr2 = this.f5588R;
        int i3 = this.f5448d;
        this.f5448d = i3 + 1;
        byte b2 = bArr2[i3];
        if ((b2 & 192) != 128) {
            m6355b(b2 & 255, this.f5448d);
        }
        if (this.f5448d >= this.f5449e) {
            m6117o();
        }
        byte[] bArr3 = this.f5588R;
        int i4 = this.f5448d;
        this.f5448d = i4 + 1;
        byte b3 = bArr3[i4];
        if ((b3 & 192) != 128) {
            m6355b(b3 & 255, this.f5448d);
        }
    }

    /* JADX INFO: renamed from: N */
    protected final void m6347N() throws IOException {
        if ((this.f5448d < this.f5449e || mo6118p()) && this.f5588R[this.f5448d] == 10) {
            this.f5448d++;
        }
        this.f5451g++;
        this.f5452h = this.f5448d;
    }

    /* JADX INFO: renamed from: Z */
    private int m6315Z() throws IOException {
        if (this.f5448d >= this.f5449e) {
            m6117o();
        }
        byte[] bArr = this.f5588R;
        int i = this.f5448d;
        this.f5448d = i + 1;
        return bArr[i] & 255;
    }

    /* JADX INFO: renamed from: e */
    protected void m6357e(String str) throws IOException {
        m6354a(str, "'null', 'true', 'false' or NaN");
    }

    /* JADX INFO: renamed from: a */
    protected void m6354a(String str, String str2) throws IOException {
        StringBuilder sb = new StringBuilder(str);
        while (true) {
            if (this.f5448d >= this.f5449e && !mo6118p()) {
                break;
            }
            byte[] bArr = this.f5588R;
            int i = this.f5448d;
            this.f5448d = i + 1;
            char cM6362j = (char) m6362j(bArr[i]);
            if (!Character.isJavaIdentifierPart(cM6362j)) {
                break;
            } else {
                sb.append(cM6362j);
            }
        }
        m6141d("Unrecognized token '" + sb.toString() + "': was expecting " + str2);
    }

    /* JADX INFO: renamed from: k */
    protected void m6363k(int i) throws JsonParseException {
        if (i < 32) {
            m6138c(i);
        }
        m6364l(i);
    }

    /* JADX INFO: renamed from: l */
    protected void m6364l(int i) throws JsonParseException {
        m6141d("Invalid UTF-8 start byte 0x" + Integer.toHexString(i));
    }

    /* JADX INFO: renamed from: m */
    protected void m6365m(int i) throws JsonParseException {
        m6141d("Invalid UTF-8 middle byte 0x" + Integer.toHexString(i));
    }

    /* JADX INFO: renamed from: b */
    protected void m6355b(int i, int i2) throws JsonParseException {
        this.f5448d = i2;
        m6365m(i);
    }

    /* JADX INFO: renamed from: a */
    public static int[] m6325a(int[] iArr, int i) {
        return iArr == null ? new int[i] : Arrays.copyOf(iArr, iArr.length + i);
    }

    /* JADX INFO: renamed from: d */
    private static final int m6331d(int i, int i2) {
        return i2 == 4 ? i : i | ((-1) << (i2 << 3));
    }
}
