package com.fasterxml.jackson.core.json;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.core.SerializableString;
import com.fasterxml.jackson.core.p000io.CharTypes;
import com.fasterxml.jackson.core.p000io.CharacterEscapes;
import com.fasterxml.jackson.core.p000io.IOContext;
import com.fasterxml.jackson.core.p000io.NumberOutput;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes.dex */
public class UTF8JsonGenerator extends JsonGeneratorImpl {

    /* JADX INFO: renamed from: A */
    protected final int f5572A;

    /* JADX INFO: renamed from: B */
    protected boolean f5573B;

    /* JADX INFO: renamed from: C */
    protected boolean f5574C;

    /* JADX INFO: renamed from: u */
    protected final OutputStream f5575u;

    /* JADX INFO: renamed from: v */
    protected byte[] f5576v;

    /* JADX INFO: renamed from: w */
    protected int f5577w;

    /* JADX INFO: renamed from: x */
    protected final int f5578x;

    /* JADX INFO: renamed from: y */
    protected final int f5579y;

    /* JADX INFO: renamed from: z */
    protected char[] f5580z;

    /* JADX INFO: renamed from: t */
    static final byte[] f5571t = CharTypes.m6151h();

    /* JADX INFO: renamed from: D */
    private static final byte[] f5568D = {110, 117, 108, 108};

    /* JADX INFO: renamed from: E */
    private static final byte[] f5569E = {116, 114, 117, 101};

    /* JADX INFO: renamed from: F */
    private static final byte[] f5570F = {102, 97, 108, 115, 101};

    public UTF8JsonGenerator(IOContext iOContext, int i, ObjectCodec objectCodec, OutputStream outputStream) {
        super(iOContext, i, objectCodec);
        this.f5577w = 0;
        this.f5575u = outputStream;
        this.f5573B = true;
        this.f5576v = iOContext.m6170f();
        this.f5578x = this.f5576v.length;
        this.f5579y = this.f5578x >> 3;
        this.f5580z = iOContext.m6172h();
        this.f5572A = this.f5580z.length;
        if (m6098a(JsonGenerator.Feature.ESCAPE_NON_ASCII)) {
            mo6032a(127);
        }
        this.f5574C = JsonGenerator.Feature.QUOTE_FIELD_NAMES.enabledIn(i) ? false : true;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    /* JADX INFO: renamed from: a */
    public void mo6041a(String str) throws IOException {
        if (this.f5405a != null) {
            m6302g(str);
            return;
        }
        int iM6234a = this.f5426l.m6234a(str);
        if (iM6234a == 4) {
            m6055e("Can not write a field name, expecting a value");
        }
        if (iM6234a == 1) {
            if (this.f5577w >= this.f5578x) {
                m6303l();
            }
            byte[] bArr = this.f5576v;
            int i = this.f5577w;
            this.f5577w = i + 1;
            bArr[i] = 44;
        }
        if (this.f5574C) {
            m6282a(str, false);
            return;
        }
        int length = str.length();
        if (length > this.f5572A) {
            m6282a(str, true);
            return;
        }
        if (this.f5577w >= this.f5578x) {
            m6303l();
        }
        byte[] bArr2 = this.f5576v;
        int i2 = this.f5577w;
        this.f5577w = i2 + 1;
        bArr2[i2] = 34;
        if (length <= this.f5579y) {
            if (this.f5577w + length > this.f5578x) {
                m6303l();
            }
            m6285b(str, 0, length);
        } else {
            m6281a(str, 0, length);
        }
        if (this.f5577w >= this.f5578x) {
            m6303l();
        }
        byte[] bArr3 = this.f5576v;
        int i3 = this.f5577w;
        this.f5577w = i3 + 1;
        bArr3[i3] = 34;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    /* JADX INFO: renamed from: c */
    public final void mo6050c() throws IOException {
        mo6099f("start an array");
        this.f5426l = this.f5426l.m6237g();
        if (this.f5405a != null) {
            this.f5405a.mo6091e(this);
            return;
        }
        if (this.f5577w >= this.f5578x) {
            m6303l();
        }
        byte[] bArr = this.f5576v;
        int i = this.f5577w;
        this.f5577w = i + 1;
        bArr[i] = 91;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    /* JADX INFO: renamed from: d */
    public final void mo6052d() throws IOException {
        if (!this.f5426l.m6078a()) {
            m6055e("Current context not an ARRAY but " + this.f5426l.m6081d());
        }
        if (this.f5405a != null) {
            this.f5405a.mo6088b(this, this.f5426l.m6082e());
        } else {
            if (this.f5577w >= this.f5578x) {
                m6303l();
            }
            byte[] bArr = this.f5576v;
            int i = this.f5577w;
            this.f5577w = i + 1;
            bArr[i] = 93;
        }
        this.f5426l = this.f5426l.m6239i();
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    /* JADX INFO: renamed from: e */
    public final void mo6054e() throws IOException {
        mo6099f("start an object");
        this.f5426l = this.f5426l.m6238h();
        if (this.f5405a != null) {
            this.f5405a.mo6087b(this);
            return;
        }
        if (this.f5577w >= this.f5578x) {
            m6303l();
        }
        byte[] bArr = this.f5576v;
        int i = this.f5577w;
        this.f5577w = i + 1;
        bArr[i] = 123;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    /* JADX INFO: renamed from: f */
    public final void mo6056f() throws IOException {
        if (!this.f5426l.m6080c()) {
            m6055e("Current context not an object but " + this.f5426l.m6081d());
        }
        if (this.f5405a != null) {
            this.f5405a.mo6086a(this, this.f5426l.m6082e());
        } else {
            if (this.f5577w >= this.f5578x) {
                m6303l();
            }
            byte[] bArr = this.f5576v;
            int i = this.f5577w;
            this.f5577w = i + 1;
            bArr[i] = 125;
        }
        this.f5426l = this.f5426l.m6239i();
    }

    /* JADX INFO: renamed from: g */
    protected final void m6302g(String str) throws IOException {
        int iM6234a = this.f5426l.m6234a(str);
        if (iM6234a == 4) {
            m6055e("Can not write a field name, expecting a value");
        }
        if (iM6234a == 1) {
            this.f5405a.mo6089c(this);
        } else {
            this.f5405a.mo6094h(this);
        }
        if (this.f5574C) {
            m6282a(str, false);
            return;
        }
        int length = str.length();
        if (length > this.f5572A) {
            m6282a(str, true);
            return;
        }
        if (this.f5577w >= this.f5578x) {
            m6303l();
        }
        byte[] bArr = this.f5576v;
        int i = this.f5577w;
        this.f5577w = i + 1;
        bArr[i] = 34;
        str.getChars(0, length, this.f5580z, 0);
        if (length <= this.f5579y) {
            if (this.f5577w + length > this.f5578x) {
                m6303l();
            }
            m6293d(this.f5580z, 0, length);
        } else {
            m6290c(this.f5580z, 0, length);
        }
        if (this.f5577w >= this.f5578x) {
            m6303l();
        }
        byte[] bArr2 = this.f5576v;
        int i2 = this.f5577w;
        this.f5577w = i2 + 1;
        bArr2[i2] = 34;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    /* JADX INFO: renamed from: b */
    public void mo6049b(String str) throws IOException {
        mo6099f("write a string");
        if (str == null) {
            m6299m();
            return;
        }
        int length = str.length();
        if (length > this.f5579y) {
            m6282a(str, true);
            return;
        }
        if (this.f5577w + length >= this.f5578x) {
            m6303l();
        }
        byte[] bArr = this.f5576v;
        int i = this.f5577w;
        this.f5577w = i + 1;
        bArr[i] = 34;
        m6285b(str, 0, length);
        if (this.f5577w >= this.f5578x) {
            m6303l();
        }
        byte[] bArr2 = this.f5576v;
        int i2 = this.f5577w;
        this.f5577w = i2 + 1;
        bArr2[i2] = 34;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    /* JADX INFO: renamed from: c */
    public void mo6051c(String str) throws IOException {
        int length = str.length();
        int i = 0;
        while (length > 0) {
            char[] cArr = this.f5580z;
            int length2 = cArr.length;
            if (length < length2) {
                length2 = length;
            }
            str.getChars(i, i + length2, cArr, 0);
            mo6045a(cArr, 0, length2);
            i += length2;
            length -= length2;
        }
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    /* JADX INFO: renamed from: b */
    public void mo6048b(SerializableString serializableString) throws IOException {
        byte[] bArrMo6096b = serializableString.mo6096b();
        if (bArrMo6096b.length > 0) {
            m6283a(bArrMo6096b);
        }
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    /* JADX INFO: renamed from: a */
    public final void mo6045a(char[] cArr, int i, int i2) throws IOException {
        int i3 = i2 + i2 + i2;
        if (this.f5577w + i3 > this.f5578x) {
            if (this.f5578x < i3) {
                m6286b(cArr, i, i2);
                return;
            }
            m6303l();
        }
        int i4 = i2 + i;
        int iM6278a = i;
        while (iM6278a < i4) {
            do {
                char c = cArr[iM6278a];
                if (c <= 127) {
                    byte[] bArr = this.f5576v;
                    int i5 = this.f5577w;
                    this.f5577w = i5 + 1;
                    bArr[i5] = (byte) c;
                    iM6278a++;
                } else {
                    int i6 = iM6278a + 1;
                    char c2 = cArr[iM6278a];
                    if (c2 < 2048) {
                        byte[] bArr2 = this.f5576v;
                        int i7 = this.f5577w;
                        this.f5577w = i7 + 1;
                        bArr2[i7] = (byte) ((c2 >> 6) | 192);
                        byte[] bArr3 = this.f5576v;
                        int i8 = this.f5577w;
                        this.f5577w = i8 + 1;
                        bArr3[i8] = (byte) ((c2 & '?') | 128);
                        iM6278a = i6;
                    } else {
                        iM6278a = m6278a(c2, cArr, i6, i4);
                    }
                }
            } while (iM6278a < i4);
            return;
        }
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    /* JADX INFO: renamed from: a */
    public void mo6037a(char c) throws IOException {
        if (this.f5577w + 3 >= this.f5578x) {
            m6303l();
        }
        byte[] bArr = this.f5576v;
        if (c <= 127) {
            int i = this.f5577w;
            this.f5577w = i + 1;
            bArr[i] = (byte) c;
        } else {
            if (c < 2048) {
                int i2 = this.f5577w;
                this.f5577w = i2 + 1;
                bArr[i2] = (byte) ((c >> 6) | 192);
                int i3 = this.f5577w;
                this.f5577w = i3 + 1;
                bArr[i3] = (byte) ((c & '?') | 128);
                return;
            }
            m6278a(c, (char[]) null, 0, 0);
        }
    }

    /* JADX INFO: renamed from: b */
    private final void m6286b(char[] cArr, int i, int i2) throws IOException {
        int i3 = this.f5578x;
        byte[] bArr = this.f5576v;
        int iM6278a = i;
        while (iM6278a < i2) {
            do {
                char c = cArr[iM6278a];
                if (c < 128) {
                    if (this.f5577w >= i3) {
                        m6303l();
                    }
                    int i4 = this.f5577w;
                    this.f5577w = i4 + 1;
                    bArr[i4] = (byte) c;
                    iM6278a++;
                } else {
                    if (this.f5577w + 3 >= this.f5578x) {
                        m6303l();
                    }
                    int i5 = iM6278a + 1;
                    char c2 = cArr[iM6278a];
                    if (c2 < 2048) {
                        int i6 = this.f5577w;
                        this.f5577w = i6 + 1;
                        bArr[i6] = (byte) ((c2 >> 6) | 192);
                        int i7 = this.f5577w;
                        this.f5577w = i7 + 1;
                        bArr[i7] = (byte) ((c2 & '?') | 128);
                        iM6278a = i5;
                    } else {
                        iM6278a = m6278a(c2, cArr, i5, i2);
                    }
                }
            } while (iM6278a < i2);
            return;
        }
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    /* JADX INFO: renamed from: b */
    public void mo6047b(int i) throws IOException {
        mo6099f("write a number");
        if (this.f5577w + 11 >= this.f5578x) {
            m6303l();
        }
        if (this.f5425k) {
            m6288c(i);
        } else {
            this.f5577w = NumberOutput.m6188a(i, this.f5576v, this.f5577w);
        }
    }

    /* JADX INFO: renamed from: c */
    private final void m6288c(int i) throws IOException {
        if (this.f5577w + 13 >= this.f5578x) {
            m6303l();
        }
        byte[] bArr = this.f5576v;
        int i2 = this.f5577w;
        this.f5577w = i2 + 1;
        bArr[i2] = 34;
        this.f5577w = NumberOutput.m6188a(i, this.f5576v, this.f5577w);
        byte[] bArr2 = this.f5576v;
        int i3 = this.f5577w;
        this.f5577w = i3 + 1;
        bArr2[i3] = 34;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    /* JADX INFO: renamed from: a */
    public void mo6040a(long j) throws IOException {
        mo6099f("write a number");
        if (this.f5425k) {
            m6284b(j);
            return;
        }
        if (this.f5577w + 21 >= this.f5578x) {
            m6303l();
        }
        this.f5577w = NumberOutput.m6191a(j, this.f5576v, this.f5577w);
    }

    /* JADX INFO: renamed from: b */
    private final void m6284b(long j) throws IOException {
        if (this.f5577w + 23 >= this.f5578x) {
            m6303l();
        }
        byte[] bArr = this.f5576v;
        int i = this.f5577w;
        this.f5577w = i + 1;
        bArr[i] = 34;
        this.f5577w = NumberOutput.m6191a(j, this.f5576v, this.f5577w);
        byte[] bArr2 = this.f5576v;
        int i2 = this.f5577w;
        this.f5577w = i2 + 1;
        bArr2[i2] = 34;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    /* JADX INFO: renamed from: a */
    public void mo6043a(BigInteger bigInteger) throws IOException {
        mo6099f("write a number");
        if (bigInteger == null) {
            m6299m();
        } else if (this.f5425k) {
            m6298h(bigInteger.toString());
        } else {
            mo6051c(bigInteger.toString());
        }
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    /* JADX INFO: renamed from: a */
    public void mo6038a(double d) throws IOException {
        if (this.f5425k || ((Double.isNaN(d) || Double.isInfinite(d)) && m6098a(JsonGenerator.Feature.QUOTE_NON_NUMERIC_NUMBERS))) {
            mo6049b(String.valueOf(d));
        } else {
            mo6099f("write a number");
            mo6051c(String.valueOf(d));
        }
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    /* JADX INFO: renamed from: a */
    public void mo6039a(float f) throws IOException {
        if (this.f5425k || ((Float.isNaN(f) || Float.isInfinite(f)) && m6098a(JsonGenerator.Feature.QUOTE_NON_NUMERIC_NUMBERS))) {
            mo6049b(String.valueOf(f));
        } else {
            mo6099f("write a number");
            mo6051c(String.valueOf(f));
        }
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    /* JADX INFO: renamed from: a */
    public void mo6042a(BigDecimal bigDecimal) throws IOException {
        mo6099f("write a number");
        if (bigDecimal == null) {
            m6299m();
            return;
        }
        if (this.f5425k) {
            m6298h(m6098a(JsonGenerator.Feature.WRITE_BIGDECIMAL_AS_PLAIN) ? bigDecimal.toPlainString() : bigDecimal.toString());
        } else if (m6098a(JsonGenerator.Feature.WRITE_BIGDECIMAL_AS_PLAIN)) {
            mo6051c(bigDecimal.toPlainString());
        } else {
            mo6051c(bigDecimal.toString());
        }
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    /* JADX INFO: renamed from: d */
    public void mo6053d(String str) throws IOException {
        mo6099f("write a number");
        if (this.f5425k) {
            m6298h(str);
        } else {
            mo6051c(str);
        }
    }

    /* JADX INFO: renamed from: h */
    private final void m6298h(String str) throws IOException {
        if (this.f5577w >= this.f5578x) {
            m6303l();
        }
        byte[] bArr = this.f5576v;
        int i = this.f5577w;
        this.f5577w = i + 1;
        bArr[i] = 34;
        mo6051c(str);
        if (this.f5577w >= this.f5578x) {
            m6303l();
        }
        byte[] bArr2 = this.f5576v;
        int i2 = this.f5577w;
        this.f5577w = i2 + 1;
        bArr2[i2] = 34;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    /* JADX INFO: renamed from: a */
    public void mo6044a(boolean z) throws IOException {
        mo6099f("write a boolean value");
        if (this.f5577w + 5 >= this.f5578x) {
            m6303l();
        }
        byte[] bArr = z ? f5569E : f5570F;
        int length = bArr.length;
        System.arraycopy(bArr, 0, this.f5576v, this.f5577w, length);
        this.f5577w += length;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    /* JADX INFO: renamed from: g */
    public void mo6057g() throws IOException {
        mo6099f("write a null");
        m6299m();
    }

    @Override // com.fasterxml.jackson.core.base.GeneratorBase
    /* JADX INFO: renamed from: f */
    protected final void mo6099f(String str) throws IOException {
        byte b;
        int iM6240j = this.f5426l.m6240j();
        if (iM6240j == 5) {
            m6055e("Can not " + str + ", expecting field name");
        }
        if (this.f5405a == null) {
            switch (iM6240j) {
                case 1:
                    b = 44;
                    break;
                case 2:
                    b = 58;
                    break;
                case 3:
                    if (this.f5546s != null) {
                        byte[] bArrMo6096b = this.f5546s.mo6096b();
                        if (bArrMo6096b.length > 0) {
                            m6283a(bArrMo6096b);
                            return;
                        }
                        return;
                    }
                    return;
                default:
                    return;
            }
            if (this.f5577w >= this.f5578x) {
                m6303l();
            }
            this.f5576v[this.f5577w] = b;
            this.f5577w++;
            return;
        }
        m6300a(str, iM6240j);
    }

    /* JADX INFO: renamed from: a */
    protected final void m6300a(String str, int i) throws IOException {
        switch (i) {
            case 0:
                if (this.f5426l.m6078a()) {
                    this.f5405a.mo6093g(this);
                } else if (this.f5426l.m6080c()) {
                    this.f5405a.mo6094h(this);
                }
                break;
            case 1:
                this.f5405a.mo6092f(this);
                break;
            case 2:
                this.f5405a.mo6090d(this);
                break;
            case 3:
                this.f5405a.mo6085a(this);
                break;
            default:
                m6058h();
                break;
        }
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator, java.io.Flushable
    public void flush() throws IOException {
        m6303l();
        if (this.f5575u != null && m6098a(JsonGenerator.Feature.FLUSH_PASSED_TO_STREAM)) {
            this.f5575u.flush();
        }
    }

    @Override // com.fasterxml.jackson.core.base.GeneratorBase, com.fasterxml.jackson.core.JsonGenerator, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        super.close();
        if (this.f5576v != null && m6098a(JsonGenerator.Feature.AUTO_CLOSE_JSON_CONTENT)) {
            while (true) {
                JsonWriteContext jsonWriteContextI = m6100i();
                if (jsonWriteContextI.m6078a()) {
                    mo6052d();
                } else if (!jsonWriteContextI.m6080c()) {
                    break;
                } else {
                    mo6056f();
                }
            }
        }
        m6303l();
        this.f5577w = 0;
        if (this.f5575u != null) {
            if (this.f5542o.m6167c() || m6098a(JsonGenerator.Feature.AUTO_CLOSE_TARGET)) {
                this.f5575u.close();
            } else if (m6098a(JsonGenerator.Feature.FLUSH_PASSED_TO_STREAM)) {
                this.f5575u.flush();
            }
        }
        mo6101j();
    }

    @Override // com.fasterxml.jackson.core.base.GeneratorBase
    /* JADX INFO: renamed from: j */
    protected void mo6101j() {
        byte[] bArr = this.f5576v;
        if (bArr != null && this.f5573B) {
            this.f5576v = null;
            this.f5542o.m6164b(bArr);
        }
        char[] cArr = this.f5580z;
        if (cArr != null) {
            this.f5580z = null;
            this.f5542o.m6165b(cArr);
        }
    }

    /* JADX INFO: renamed from: a */
    private final void m6283a(byte[] bArr) throws IOException {
        int length = bArr.length;
        if (this.f5577w + length > this.f5578x) {
            m6303l();
            if (length > 512) {
                this.f5575u.write(bArr, 0, length);
                return;
            }
        }
        System.arraycopy(bArr, 0, this.f5576v, this.f5577w, length);
        this.f5577w = length + this.f5577w;
    }

    /* JADX INFO: renamed from: a */
    private final void m6282a(String str, boolean z) throws IOException {
        if (z) {
            if (this.f5577w >= this.f5578x) {
                m6303l();
            }
            byte[] bArr = this.f5576v;
            int i = this.f5577w;
            this.f5577w = i + 1;
            bArr[i] = 34;
        }
        int length = str.length();
        int i2 = 0;
        while (length > 0) {
            int iMin = Math.min(this.f5579y, length);
            if (this.f5577w + iMin > this.f5578x) {
                m6303l();
            }
            m6285b(str, i2, iMin);
            i2 += iMin;
            length -= iMin;
        }
        if (z) {
            if (this.f5577w >= this.f5578x) {
                m6303l();
            }
            byte[] bArr2 = this.f5576v;
            int i3 = this.f5577w;
            this.f5577w = i3 + 1;
            bArr2[i3] = 34;
        }
    }

    /* JADX INFO: renamed from: c */
    private final void m6290c(char[] cArr, int i, int i2) throws IOException {
        do {
            int iMin = Math.min(this.f5579y, i2);
            if (this.f5577w + iMin > this.f5578x) {
                m6303l();
            }
            m6293d(cArr, i, iMin);
            i += iMin;
            i2 -= iMin;
        } while (i2 > 0);
    }

    /* JADX INFO: renamed from: a */
    private final void m6281a(String str, int i, int i2) throws IOException {
        do {
            int iMin = Math.min(this.f5579y, i2);
            if (this.f5577w + iMin > this.f5578x) {
                m6303l();
            }
            m6285b(str, i, iMin);
            i += iMin;
            i2 -= iMin;
        } while (i2 > 0);
    }

    /* JADX INFO: renamed from: d */
    private final void m6293d(char[] cArr, int i, int i2) throws IOException {
        int i3 = i2 + i;
        int i4 = this.f5577w;
        byte[] bArr = this.f5576v;
        int[] iArr = this.f5543p;
        while (i < i3) {
            char c = cArr[i];
            if (c > 127 || iArr[c] != 0) {
                break;
            }
            bArr[i4] = (byte) c;
            i++;
            i4++;
        }
        this.f5577w = i4;
        if (i < i3) {
            if (this.f5545r != null) {
                m6297g(cArr, i, i3);
            } else if (this.f5544q == 0) {
                m6295e(cArr, i, i3);
            } else {
                m6296f(cArr, i, i3);
            }
        }
    }

    /* JADX INFO: renamed from: b */
    private final void m6285b(String str, int i, int i2) throws IOException {
        int i3 = i2 + i;
        int i4 = this.f5577w;
        byte[] bArr = this.f5576v;
        int[] iArr = this.f5543p;
        while (i < i3) {
            char cCharAt = str.charAt(i);
            if (cCharAt > 127 || iArr[cCharAt] != 0) {
                break;
            }
            bArr[i4] = (byte) cCharAt;
            i++;
            i4++;
        }
        this.f5577w = i4;
        if (i < i3) {
            if (this.f5545r != null) {
                m6294e(str, i, i3);
            } else if (this.f5544q == 0) {
                m6289c(str, i, i3);
            } else {
                m6292d(str, i, i3);
            }
        }
    }

    /* JADX INFO: renamed from: e */
    private final void m6295e(char[] cArr, int i, int i2) throws IOException {
        if (this.f5577w + ((i2 - i) * 6) > this.f5578x) {
            m6303l();
        }
        int iM6291d = this.f5577w;
        byte[] bArr = this.f5576v;
        int[] iArr = this.f5543p;
        while (i < i2) {
            int i3 = i + 1;
            char c = cArr[i];
            if (c <= 127) {
                if (iArr[c] == 0) {
                    bArr[iM6291d] = (byte) c;
                    iM6291d++;
                    i = i3;
                } else {
                    int i4 = iArr[c];
                    if (i4 > 0) {
                        int i5 = iM6291d + 1;
                        bArr[iM6291d] = 92;
                        iM6291d = i5 + 1;
                        bArr[i5] = (byte) i4;
                        i = i3;
                    } else {
                        iM6291d = m6291d(c, iM6291d);
                        i = i3;
                    }
                }
            } else {
                if (c <= 2047) {
                    int i6 = iM6291d + 1;
                    bArr[iM6291d] = (byte) ((c >> 6) | 192);
                    iM6291d = i6 + 1;
                    bArr[i6] = (byte) ((c & '?') | 128);
                } else {
                    iM6291d = m6287c(c, iM6291d);
                }
                i = i3;
            }
        }
        this.f5577w = iM6291d;
    }

    /* JADX INFO: renamed from: c */
    private final void m6289c(String str, int i, int i2) throws IOException {
        if (this.f5577w + ((i2 - i) * 6) > this.f5578x) {
            m6303l();
        }
        int iM6291d = this.f5577w;
        byte[] bArr = this.f5576v;
        int[] iArr = this.f5543p;
        while (i < i2) {
            int i3 = i + 1;
            char cCharAt = str.charAt(i);
            if (cCharAt <= 127) {
                if (iArr[cCharAt] == 0) {
                    bArr[iM6291d] = (byte) cCharAt;
                    iM6291d++;
                    i = i3;
                } else {
                    int i4 = iArr[cCharAt];
                    if (i4 > 0) {
                        int i5 = iM6291d + 1;
                        bArr[iM6291d] = 92;
                        iM6291d = i5 + 1;
                        bArr[i5] = (byte) i4;
                        i = i3;
                    } else {
                        iM6291d = m6291d(cCharAt, iM6291d);
                        i = i3;
                    }
                }
            } else {
                if (cCharAt <= 2047) {
                    int i6 = iM6291d + 1;
                    bArr[iM6291d] = (byte) ((cCharAt >> 6) | 192);
                    iM6291d = i6 + 1;
                    bArr[i6] = (byte) ((cCharAt & '?') | 128);
                } else {
                    iM6291d = m6287c(cCharAt, iM6291d);
                }
                i = i3;
            }
        }
        this.f5577w = iM6291d;
    }

    /* JADX INFO: renamed from: f */
    private final void m6296f(char[] cArr, int i, int i2) throws IOException {
        if (this.f5577w + ((i2 - i) * 6) > this.f5578x) {
            m6303l();
        }
        int iM6291d = this.f5577w;
        byte[] bArr = this.f5576v;
        int[] iArr = this.f5543p;
        int i3 = this.f5544q;
        while (i < i2) {
            int i4 = i + 1;
            char c = cArr[i];
            if (c <= 127) {
                if (iArr[c] == 0) {
                    bArr[iM6291d] = (byte) c;
                    iM6291d++;
                    i = i4;
                } else {
                    int i5 = iArr[c];
                    if (i5 > 0) {
                        int i6 = iM6291d + 1;
                        bArr[iM6291d] = 92;
                        iM6291d = i6 + 1;
                        bArr[i6] = (byte) i5;
                        i = i4;
                    } else {
                        iM6291d = m6291d(c, iM6291d);
                        i = i4;
                    }
                }
            } else if (c > i3) {
                iM6291d = m6291d(c, iM6291d);
                i = i4;
            } else {
                if (c <= 2047) {
                    int i7 = iM6291d + 1;
                    bArr[iM6291d] = (byte) ((c >> 6) | 192);
                    iM6291d = i7 + 1;
                    bArr[i7] = (byte) ((c & '?') | 128);
                } else {
                    iM6291d = m6287c(c, iM6291d);
                }
                i = i4;
            }
        }
        this.f5577w = iM6291d;
    }

    /* JADX INFO: renamed from: d */
    private final void m6292d(String str, int i, int i2) throws IOException {
        if (this.f5577w + ((i2 - i) * 6) > this.f5578x) {
            m6303l();
        }
        int iM6291d = this.f5577w;
        byte[] bArr = this.f5576v;
        int[] iArr = this.f5543p;
        int i3 = this.f5544q;
        while (i < i2) {
            int i4 = i + 1;
            char cCharAt = str.charAt(i);
            if (cCharAt <= 127) {
                if (iArr[cCharAt] == 0) {
                    bArr[iM6291d] = (byte) cCharAt;
                    iM6291d++;
                    i = i4;
                } else {
                    int i5 = iArr[cCharAt];
                    if (i5 > 0) {
                        int i6 = iM6291d + 1;
                        bArr[iM6291d] = 92;
                        iM6291d = i6 + 1;
                        bArr[i6] = (byte) i5;
                        i = i4;
                    } else {
                        iM6291d = m6291d(cCharAt, iM6291d);
                        i = i4;
                    }
                }
            } else if (cCharAt > i3) {
                iM6291d = m6291d(cCharAt, iM6291d);
                i = i4;
            } else {
                if (cCharAt <= 2047) {
                    int i7 = iM6291d + 1;
                    bArr[iM6291d] = (byte) ((cCharAt >> 6) | 192);
                    iM6291d = i7 + 1;
                    bArr[i7] = (byte) ((cCharAt & '?') | 128);
                } else {
                    iM6291d = m6287c(cCharAt, iM6291d);
                }
                i = i4;
            }
        }
        this.f5577w = iM6291d;
    }

    /* JADX INFO: renamed from: g */
    private final void m6297g(char[] cArr, int i, int i2) throws IOException {
        if (this.f5577w + ((i2 - i) * 6) > this.f5578x) {
            m6303l();
        }
        int iM6280a = this.f5577w;
        byte[] bArr = this.f5576v;
        int[] iArr = this.f5543p;
        int i3 = this.f5544q <= 0 ? 65535 : this.f5544q;
        CharacterEscapes characterEscapes = this.f5545r;
        while (i < i2) {
            int i4 = i + 1;
            char c = cArr[i];
            if (c <= 127) {
                if (iArr[c] == 0) {
                    bArr[iM6280a] = (byte) c;
                    iM6280a++;
                    i = i4;
                } else {
                    int i5 = iArr[c];
                    if (i5 > 0) {
                        int i6 = iM6280a + 1;
                        bArr[iM6280a] = 92;
                        iM6280a = i6 + 1;
                        bArr[i6] = (byte) i5;
                        i = i4;
                    } else if (i5 == -2) {
                        SerializableString serializableStringM6152a = characterEscapes.m6152a(c);
                        if (serializableStringM6152a == null) {
                            m6055e("Invalid custom escape definitions; custom escape not found for character code 0x" + Integer.toHexString(c) + ", although was supposed to have one");
                        }
                        iM6280a = m6280a(bArr, iM6280a, serializableStringM6152a, i2 - i4);
                        i = i4;
                    } else {
                        iM6280a = m6291d(c, iM6280a);
                        i = i4;
                    }
                }
            } else if (c > i3) {
                iM6280a = m6291d(c, iM6280a);
                i = i4;
            } else {
                SerializableString serializableStringM6152a2 = characterEscapes.m6152a(c);
                if (serializableStringM6152a2 != null) {
                    iM6280a = m6280a(bArr, iM6280a, serializableStringM6152a2, i2 - i4);
                    i = i4;
                } else {
                    if (c <= 2047) {
                        int i7 = iM6280a + 1;
                        bArr[iM6280a] = (byte) ((c >> 6) | 192);
                        iM6280a = i7 + 1;
                        bArr[i7] = (byte) ((c & '?') | 128);
                    } else {
                        iM6280a = m6287c(c, iM6280a);
                    }
                    i = i4;
                }
            }
        }
        this.f5577w = iM6280a;
    }

    /* JADX INFO: renamed from: e */
    private final void m6294e(String str, int i, int i2) throws IOException {
        if (this.f5577w + ((i2 - i) * 6) > this.f5578x) {
            m6303l();
        }
        int iM6280a = this.f5577w;
        byte[] bArr = this.f5576v;
        int[] iArr = this.f5543p;
        int i3 = this.f5544q <= 0 ? 65535 : this.f5544q;
        CharacterEscapes characterEscapes = this.f5545r;
        while (i < i2) {
            int i4 = i + 1;
            char cCharAt = str.charAt(i);
            if (cCharAt <= 127) {
                if (iArr[cCharAt] == 0) {
                    bArr[iM6280a] = (byte) cCharAt;
                    iM6280a++;
                    i = i4;
                } else {
                    int i5 = iArr[cCharAt];
                    if (i5 > 0) {
                        int i6 = iM6280a + 1;
                        bArr[iM6280a] = 92;
                        iM6280a = i6 + 1;
                        bArr[i6] = (byte) i5;
                        i = i4;
                    } else if (i5 == -2) {
                        SerializableString serializableStringM6152a = characterEscapes.m6152a(cCharAt);
                        if (serializableStringM6152a == null) {
                            m6055e("Invalid custom escape definitions; custom escape not found for character code 0x" + Integer.toHexString(cCharAt) + ", although was supposed to have one");
                        }
                        iM6280a = m6280a(bArr, iM6280a, serializableStringM6152a, i2 - i4);
                        i = i4;
                    } else {
                        iM6280a = m6291d(cCharAt, iM6280a);
                        i = i4;
                    }
                }
            } else if (cCharAt > i3) {
                iM6280a = m6291d(cCharAt, iM6280a);
                i = i4;
            } else {
                SerializableString serializableStringM6152a2 = characterEscapes.m6152a(cCharAt);
                if (serializableStringM6152a2 != null) {
                    iM6280a = m6280a(bArr, iM6280a, serializableStringM6152a2, i2 - i4);
                    i = i4;
                } else {
                    if (cCharAt <= 2047) {
                        int i7 = iM6280a + 1;
                        bArr[iM6280a] = (byte) ((cCharAt >> 6) | 192);
                        iM6280a = i7 + 1;
                        bArr[i7] = (byte) ((cCharAt & '?') | 128);
                    } else {
                        iM6280a = m6287c(cCharAt, iM6280a);
                    }
                    i = i4;
                }
            }
        }
        this.f5577w = iM6280a;
    }

    /* JADX INFO: renamed from: a */
    private final int m6280a(byte[] bArr, int i, SerializableString serializableString, int i2) throws IOException {
        byte[] bArrMo6096b = serializableString.mo6096b();
        int length = bArrMo6096b.length;
        if (length > 6) {
            return m6279a(bArr, i, this.f5578x, bArrMo6096b, i2);
        }
        System.arraycopy(bArrMo6096b, 0, bArr, i, length);
        return length + i;
    }

    /* JADX INFO: renamed from: a */
    private final int m6279a(byte[] bArr, int i, int i2, byte[] bArr2, int i3) throws IOException {
        int i4;
        int length = bArr2.length;
        if (i + length > i2) {
            this.f5577w = i;
            m6303l();
            int i5 = this.f5577w;
            if (length > bArr.length) {
                this.f5575u.write(bArr2, 0, length);
                return i5;
            }
            System.arraycopy(bArr2, 0, bArr, i5, length);
            i4 = i5 + length;
        } else {
            i4 = i;
        }
        if ((i3 * 6) + i4 > i2) {
            m6303l();
            return this.f5577w;
        }
        return i4;
    }

    /* JADX INFO: renamed from: a */
    private final int m6278a(int i, char[] cArr, int i2, int i3) throws IOException {
        if (i >= 55296 && i <= 57343) {
            if (i2 >= i3 || cArr == null) {
                m6055e("Split surrogate on writeRaw() input (last character)");
            }
            m6301b(i, cArr[i2]);
            return i2 + 1;
        }
        byte[] bArr = this.f5576v;
        int i4 = this.f5577w;
        this.f5577w = i4 + 1;
        bArr[i4] = (byte) ((i >> 12) | 224);
        int i5 = this.f5577w;
        this.f5577w = i5 + 1;
        bArr[i5] = (byte) (((i >> 6) & 63) | 128);
        int i6 = this.f5577w;
        this.f5577w = i6 + 1;
        bArr[i6] = (byte) ((i & 63) | 128);
        return i2;
    }

    /* JADX INFO: renamed from: b */
    protected final void m6301b(int i, int i2) throws IOException {
        int iA = m6097a(i, i2);
        if (this.f5577w + 4 > this.f5578x) {
            m6303l();
        }
        byte[] bArr = this.f5576v;
        int i3 = this.f5577w;
        this.f5577w = i3 + 1;
        bArr[i3] = (byte) ((iA >> 18) | 240);
        int i4 = this.f5577w;
        this.f5577w = i4 + 1;
        bArr[i4] = (byte) (((iA >> 12) & 63) | 128);
        int i5 = this.f5577w;
        this.f5577w = i5 + 1;
        bArr[i5] = (byte) (((iA >> 6) & 63) | 128);
        int i6 = this.f5577w;
        this.f5577w = i6 + 1;
        bArr[i6] = (byte) ((iA & 63) | 128);
    }

    /* JADX INFO: renamed from: c */
    private final int m6287c(int i, int i2) throws IOException {
        byte[] bArr = this.f5576v;
        if (i >= 55296 && i <= 57343) {
            int i3 = i2 + 1;
            bArr[i2] = 92;
            int i4 = i3 + 1;
            bArr[i3] = 117;
            int i5 = i4 + 1;
            bArr[i4] = f5571t[(i >> 12) & 15];
            int i6 = i5 + 1;
            bArr[i5] = f5571t[(i >> 8) & 15];
            int i7 = i6 + 1;
            bArr[i6] = f5571t[(i >> 4) & 15];
            int i8 = i7 + 1;
            bArr[i7] = f5571t[i & 15];
            return i8;
        }
        int i9 = i2 + 1;
        bArr[i2] = (byte) ((i >> 12) | 224);
        int i10 = i9 + 1;
        bArr[i9] = (byte) (((i >> 6) & 63) | 128);
        int i11 = i10 + 1;
        bArr[i10] = (byte) ((i & 63) | 128);
        return i11;
    }

    /* JADX INFO: renamed from: m */
    private final void m6299m() throws IOException {
        if (this.f5577w + 4 >= this.f5578x) {
            m6303l();
        }
        System.arraycopy(f5568D, 0, this.f5576v, this.f5577w, 4);
        this.f5577w += 4;
    }

    /* JADX INFO: renamed from: d */
    private int m6291d(int i, int i2) throws IOException {
        int i3;
        byte[] bArr = this.f5576v;
        int i4 = i2 + 1;
        bArr[i2] = 92;
        int i5 = i4 + 1;
        bArr[i4] = 117;
        if (i > 255) {
            int i6 = (i >> 8) & 255;
            int i7 = i5 + 1;
            bArr[i5] = f5571t[i6 >> 4];
            i3 = i7 + 1;
            bArr[i7] = f5571t[i6 & 15];
            i &= 255;
        } else {
            int i8 = i5 + 1;
            bArr[i5] = 48;
            i3 = i8 + 1;
            bArr[i8] = 48;
        }
        int i9 = i3 + 1;
        bArr[i3] = f5571t[i >> 4];
        int i10 = i9 + 1;
        bArr[i9] = f5571t[i & 15];
        return i10;
    }

    /* JADX INFO: renamed from: l */
    protected final void m6303l() throws IOException {
        int i = this.f5577w;
        if (i > 0) {
            this.f5577w = 0;
            this.f5575u.write(this.f5576v, 0, i);
        }
    }
}
