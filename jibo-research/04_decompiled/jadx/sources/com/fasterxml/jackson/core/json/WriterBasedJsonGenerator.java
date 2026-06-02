package com.fasterxml.jackson.core.json;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.core.SerializableString;
import com.fasterxml.jackson.core.p000io.CharTypes;
import com.fasterxml.jackson.core.p000io.IOContext;
import com.fasterxml.jackson.core.p000io.NumberOutput;
import java.io.IOException;
import java.io.Writer;
import java.math.BigDecimal;
import java.math.BigInteger;
import org.apache.http.message.TokenParser;

/* JADX INFO: loaded from: classes.dex */
public final class WriterBasedJsonGenerator extends JsonGeneratorImpl {

    /* JADX INFO: renamed from: t */
    protected static final char[] f5591t = CharTypes.m6150g();

    /* JADX INFO: renamed from: A */
    protected SerializableString f5592A;

    /* JADX INFO: renamed from: u */
    protected final Writer f5593u;

    /* JADX INFO: renamed from: v */
    protected char[] f5594v;

    /* JADX INFO: renamed from: w */
    protected int f5595w;

    /* JADX INFO: renamed from: x */
    protected int f5596x;

    /* JADX INFO: renamed from: y */
    protected int f5597y;

    /* JADX INFO: renamed from: z */
    protected char[] f5598z;

    public WriterBasedJsonGenerator(IOContext iOContext, int i, ObjectCodec objectCodec, Writer writer) {
        super(iOContext, i, objectCodec);
        this.f5595w = 0;
        this.f5596x = 0;
        this.f5593u = writer;
        this.f5594v = iOContext.m6172h();
        this.f5597y = this.f5594v.length;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    /* JADX INFO: renamed from: a */
    public void mo6041a(String str) throws IOException {
        int iM6234a = this.f5426l.m6234a(str);
        if (iM6234a == 4) {
            m6055e("Can not write a field name, expecting a value");
        }
        m6382a(str, iM6234a == 1);
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    /* JADX INFO: renamed from: c */
    public void mo6050c() throws IOException {
        mo6099f("start an array");
        this.f5426l = this.f5426l.m6237g();
        if (this.f5405a != null) {
            this.f5405a.mo6091e(this);
            return;
        }
        if (this.f5596x >= this.f5597y) {
            m6385l();
        }
        char[] cArr = this.f5594v;
        int i = this.f5596x;
        this.f5596x = i + 1;
        cArr[i] = '[';
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    /* JADX INFO: renamed from: d */
    public void mo6052d() throws IOException {
        if (!this.f5426l.m6078a()) {
            m6055e("Current context not an ARRAY but " + this.f5426l.m6081d());
        }
        if (this.f5405a != null) {
            this.f5405a.mo6088b(this, this.f5426l.m6082e());
        } else {
            if (this.f5596x >= this.f5597y) {
                m6385l();
            }
            char[] cArr = this.f5594v;
            int i = this.f5596x;
            this.f5596x = i + 1;
            cArr[i] = ']';
        }
        this.f5426l = this.f5426l.m6239i();
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    /* JADX INFO: renamed from: e */
    public void mo6054e() throws IOException {
        mo6099f("start an object");
        this.f5426l = this.f5426l.m6238h();
        if (this.f5405a != null) {
            this.f5405a.mo6087b(this);
            return;
        }
        if (this.f5596x >= this.f5597y) {
            m6385l();
        }
        char[] cArr = this.f5594v;
        int i = this.f5596x;
        this.f5596x = i + 1;
        cArr[i] = '{';
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    /* JADX INFO: renamed from: f */
    public void mo6056f() throws IOException {
        if (!this.f5426l.m6080c()) {
            m6055e("Current context not an object but " + this.f5426l.m6081d());
        }
        if (this.f5405a != null) {
            this.f5405a.mo6086a(this, this.f5426l.m6082e());
        } else {
            if (this.f5596x >= this.f5597y) {
                m6385l();
            }
            char[] cArr = this.f5594v;
            int i = this.f5596x;
            this.f5596x = i + 1;
            cArr[i] = '}';
        }
        this.f5426l = this.f5426l.m6239i();
    }

    /* JADX INFO: renamed from: a */
    protected void m6382a(String str, boolean z) throws IOException {
        if (this.f5405a != null) {
            m6383b(str, z);
            return;
        }
        if (this.f5596x + 1 >= this.f5597y) {
            m6385l();
        }
        if (z) {
            char[] cArr = this.f5594v;
            int i = this.f5596x;
            this.f5596x = i + 1;
            cArr[i] = ',';
        }
        if (!m6098a(JsonGenerator.Feature.QUOTE_FIELD_NAMES)) {
            m6378j(str);
            return;
        }
        char[] cArr2 = this.f5594v;
        int i2 = this.f5596x;
        this.f5596x = i2 + 1;
        cArr2[i2] = TokenParser.DQUOTE;
        m6378j(str);
        if (this.f5596x >= this.f5597y) {
            m6385l();
        }
        char[] cArr3 = this.f5594v;
        int i3 = this.f5596x;
        this.f5596x = i3 + 1;
        cArr3[i3] = TokenParser.DQUOTE;
    }

    /* JADX INFO: renamed from: b */
    protected void m6383b(String str, boolean z) throws IOException {
        if (z) {
            this.f5405a.mo6089c(this);
        } else {
            this.f5405a.mo6094h(this);
        }
        if (m6098a(JsonGenerator.Feature.QUOTE_FIELD_NAMES)) {
            if (this.f5596x >= this.f5597y) {
                m6385l();
            }
            char[] cArr = this.f5594v;
            int i = this.f5596x;
            this.f5596x = i + 1;
            cArr[i] = TokenParser.DQUOTE;
            m6378j(str);
            if (this.f5596x >= this.f5597y) {
                m6385l();
            }
            char[] cArr2 = this.f5594v;
            int i2 = this.f5596x;
            this.f5596x = i2 + 1;
            cArr2[i2] = TokenParser.DQUOTE;
            return;
        }
        m6378j(str);
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    /* JADX INFO: renamed from: b */
    public void mo6049b(String str) throws IOException {
        mo6099f("write a string");
        if (str == null) {
            m6380m();
            return;
        }
        if (this.f5596x >= this.f5597y) {
            m6385l();
        }
        char[] cArr = this.f5594v;
        int i = this.f5596x;
        this.f5596x = i + 1;
        cArr[i] = TokenParser.DQUOTE;
        m6378j(str);
        if (this.f5596x >= this.f5597y) {
            m6385l();
        }
        char[] cArr2 = this.f5594v;
        int i2 = this.f5596x;
        this.f5596x = i2 + 1;
        cArr2[i2] = TokenParser.DQUOTE;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    /* JADX INFO: renamed from: c */
    public void mo6051c(String str) throws IOException {
        int length = str.length();
        int i = this.f5597y - this.f5596x;
        if (i == 0) {
            m6385l();
            i = this.f5597y - this.f5596x;
        }
        if (i >= length) {
            str.getChars(0, length, this.f5594v, this.f5596x);
            this.f5596x += length;
        } else {
            m6376h(str);
        }
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    /* JADX INFO: renamed from: b */
    public void mo6048b(SerializableString serializableString) throws IOException {
        mo6051c(serializableString.mo6095a());
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    /* JADX INFO: renamed from: a */
    public void mo6045a(char[] cArr, int i, int i2) throws IOException {
        if (i2 < 32) {
            if (i2 > this.f5597y - this.f5596x) {
                m6385l();
            }
            System.arraycopy(cArr, i, this.f5594v, this.f5596x, i2);
            this.f5596x += i2;
            return;
        }
        m6385l();
        this.f5593u.write(cArr, i, i2);
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    /* JADX INFO: renamed from: a */
    public void mo6037a(char c) throws IOException {
        if (this.f5596x >= this.f5597y) {
            m6385l();
        }
        char[] cArr = this.f5594v;
        int i = this.f5596x;
        this.f5596x = i + 1;
        cArr[i] = c;
    }

    /* JADX INFO: renamed from: h */
    private void m6376h(String str) throws IOException {
        int i = this.f5597y - this.f5596x;
        str.getChars(0, i, this.f5594v, this.f5596x);
        this.f5596x += i;
        m6385l();
        int length = str.length() - i;
        while (length > this.f5597y) {
            int i2 = this.f5597y;
            str.getChars(i, i + i2, this.f5594v, 0);
            this.f5595w = 0;
            this.f5596x = i2;
            m6385l();
            i += i2;
            length -= i2;
        }
        str.getChars(i, i + length, this.f5594v, 0);
        this.f5595w = 0;
        this.f5596x = length;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    /* JADX INFO: renamed from: b */
    public void mo6047b(int i) throws IOException {
        mo6099f("write a number");
        if (this.f5425k) {
            m6370c(i);
            return;
        }
        if (this.f5596x + 11 >= this.f5597y) {
            m6385l();
        }
        this.f5596x = NumberOutput.m6189a(i, this.f5594v, this.f5596x);
    }

    /* JADX INFO: renamed from: c */
    private void m6370c(int i) throws IOException {
        if (this.f5596x + 13 >= this.f5597y) {
            m6385l();
        }
        char[] cArr = this.f5594v;
        int i2 = this.f5596x;
        this.f5596x = i2 + 1;
        cArr[i2] = TokenParser.DQUOTE;
        this.f5596x = NumberOutput.m6189a(i, this.f5594v, this.f5596x);
        char[] cArr2 = this.f5594v;
        int i3 = this.f5596x;
        this.f5596x = i3 + 1;
        cArr2[i3] = TokenParser.DQUOTE;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    /* JADX INFO: renamed from: a */
    public void mo6040a(long j) throws IOException {
        mo6099f("write a number");
        if (this.f5425k) {
            m6369b(j);
            return;
        }
        if (this.f5596x + 21 >= this.f5597y) {
            m6385l();
        }
        this.f5596x = NumberOutput.m6192a(j, this.f5594v, this.f5596x);
    }

    /* JADX INFO: renamed from: b */
    private void m6369b(long j) throws IOException {
        if (this.f5596x + 23 >= this.f5597y) {
            m6385l();
        }
        char[] cArr = this.f5594v;
        int i = this.f5596x;
        this.f5596x = i + 1;
        cArr[i] = TokenParser.DQUOTE;
        this.f5596x = NumberOutput.m6192a(j, this.f5594v, this.f5596x);
        char[] cArr2 = this.f5594v;
        int i2 = this.f5596x;
        this.f5596x = i2 + 1;
        cArr2[i2] = TokenParser.DQUOTE;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    /* JADX INFO: renamed from: a */
    public void mo6043a(BigInteger bigInteger) throws IOException {
        mo6099f("write a number");
        if (bigInteger == null) {
            m6380m();
        } else if (this.f5425k) {
            m6377i(bigInteger.toString());
        } else {
            mo6051c(bigInteger.toString());
        }
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    /* JADX INFO: renamed from: a */
    public void mo6038a(double d) throws IOException {
        if (this.f5425k || (m6098a(JsonGenerator.Feature.QUOTE_NON_NUMERIC_NUMBERS) && (Double.isNaN(d) || Double.isInfinite(d)))) {
            mo6049b(String.valueOf(d));
        } else {
            mo6099f("write a number");
            mo6051c(String.valueOf(d));
        }
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    /* JADX INFO: renamed from: a */
    public void mo6039a(float f) throws IOException {
        if (this.f5425k || (m6098a(JsonGenerator.Feature.QUOTE_NON_NUMERIC_NUMBERS) && (Float.isNaN(f) || Float.isInfinite(f)))) {
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
            m6380m();
            return;
        }
        if (this.f5425k) {
            m6377i(m6098a(JsonGenerator.Feature.WRITE_BIGDECIMAL_AS_PLAIN) ? bigDecimal.toPlainString() : bigDecimal.toString());
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
            m6377i(str);
        } else {
            mo6051c(str);
        }
    }

    /* JADX INFO: renamed from: i */
    private void m6377i(String str) throws IOException {
        if (this.f5596x >= this.f5597y) {
            m6385l();
        }
        char[] cArr = this.f5594v;
        int i = this.f5596x;
        this.f5596x = i + 1;
        cArr[i] = TokenParser.DQUOTE;
        mo6051c(str);
        if (this.f5596x >= this.f5597y) {
            m6385l();
        }
        char[] cArr2 = this.f5594v;
        int i2 = this.f5596x;
        this.f5596x = i2 + 1;
        cArr2[i2] = TokenParser.DQUOTE;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    /* JADX INFO: renamed from: a */
    public void mo6044a(boolean z) throws IOException {
        int i;
        mo6099f("write a boolean value");
        if (this.f5596x + 5 >= this.f5597y) {
            m6385l();
        }
        int i2 = this.f5596x;
        char[] cArr = this.f5594v;
        if (z) {
            cArr[i2] = 't';
            int i3 = i2 + 1;
            cArr[i3] = 'r';
            int i4 = i3 + 1;
            cArr[i4] = 'u';
            i = i4 + 1;
            cArr[i] = 'e';
        } else {
            cArr[i2] = 'f';
            int i5 = i2 + 1;
            cArr[i5] = 'a';
            int i6 = i5 + 1;
            cArr[i6] = 'l';
            int i7 = i6 + 1;
            cArr[i7] = 's';
            i = i7 + 1;
            cArr[i] = 'e';
        }
        this.f5596x = i + 1;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    /* JADX INFO: renamed from: g */
    public void mo6057g() throws IOException {
        mo6099f("write a null");
        m6380m();
    }

    @Override // com.fasterxml.jackson.core.base.GeneratorBase
    /* JADX INFO: renamed from: f */
    protected void mo6099f(String str) throws IOException {
        char c;
        if (this.f5405a != null) {
            m6384g(str);
            return;
        }
        int iM6240j = this.f5426l.m6240j();
        if (iM6240j == 5) {
            m6055e("Can not " + str + ", expecting field name");
        }
        switch (iM6240j) {
            case 1:
                c = ',';
                break;
            case 2:
                c = ':';
                break;
            case 3:
                if (this.f5546s != null) {
                    mo6051c(this.f5546s.mo6095a());
                    return;
                }
                return;
            default:
                return;
        }
        if (this.f5596x >= this.f5597y) {
            m6385l();
        }
        this.f5594v[this.f5596x] = c;
        this.f5596x++;
    }

    /* JADX INFO: renamed from: g */
    protected void m6384g(String str) throws IOException {
        int iM6240j = this.f5426l.m6240j();
        if (iM6240j == 5) {
            m6055e("Can not " + str + ", expecting field name");
        }
        switch (iM6240j) {
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
        m6385l();
        if (this.f5593u != null && m6098a(JsonGenerator.Feature.FLUSH_PASSED_TO_STREAM)) {
            this.f5593u.flush();
        }
    }

    @Override // com.fasterxml.jackson.core.base.GeneratorBase, com.fasterxml.jackson.core.JsonGenerator, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        super.close();
        if (this.f5594v != null && m6098a(JsonGenerator.Feature.AUTO_CLOSE_JSON_CONTENT)) {
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
        m6385l();
        this.f5595w = 0;
        this.f5596x = 0;
        if (this.f5593u != null) {
            if (this.f5542o.m6167c() || m6098a(JsonGenerator.Feature.AUTO_CLOSE_TARGET)) {
                this.f5593u.close();
            } else if (m6098a(JsonGenerator.Feature.FLUSH_PASSED_TO_STREAM)) {
                this.f5593u.flush();
            }
        }
        mo6101j();
    }

    @Override // com.fasterxml.jackson.core.base.GeneratorBase
    /* JADX INFO: renamed from: j */
    protected void mo6101j() {
        char[] cArr = this.f5594v;
        if (cArr != null) {
            this.f5594v = null;
            this.f5542o.m6165b(cArr);
        }
    }

    /* JADX INFO: renamed from: j */
    private void m6378j(String str) throws IOException {
        int length = str.length();
        if (length > this.f5597y) {
            m6379k(str);
            return;
        }
        if (this.f5596x + length > this.f5597y) {
            m6385l();
        }
        str.getChars(0, length, this.f5594v, this.f5596x);
        if (this.f5545r != null) {
            m6374f(length);
        } else if (this.f5544q != 0) {
            m6368b(length, this.f5544q);
        } else {
            m6372d(length);
        }
    }

    /* JADX INFO: renamed from: d */
    private void m6372d(int i) throws IOException {
        int i2;
        int i3 = this.f5596x + i;
        int[] iArr = this.f5543p;
        int length = iArr.length;
        while (this.f5596x < i3) {
            do {
                char c = this.f5594v[this.f5596x];
                if (c >= length || iArr[c] == 0) {
                    i2 = this.f5596x + 1;
                    this.f5596x = i2;
                } else {
                    int i4 = this.f5596x - this.f5595w;
                    if (i4 > 0) {
                        this.f5593u.write(this.f5594v, this.f5595w, i4);
                    }
                    char[] cArr = this.f5594v;
                    int i5 = this.f5596x;
                    this.f5596x = i5 + 1;
                    char c2 = cArr[i5];
                    m6367a(c2, iArr[c2]);
                }
            } while (i2 < i3);
            return;
        }
    }

    /* JADX INFO: renamed from: k */
    private void m6379k(String str) throws IOException {
        m6385l();
        int length = str.length();
        int i = 0;
        do {
            int i2 = this.f5597y;
            if (i + i2 > length) {
                i2 = length - i;
            }
            str.getChars(i, i + i2, this.f5594v, 0);
            if (this.f5545r != null) {
                m6375g(i2);
            } else if (this.f5544q != 0) {
                m6371c(i2, this.f5544q);
            } else {
                m6373e(i2);
            }
            i += i2;
        } while (i < length);
    }

    /* JADX INFO: renamed from: e */
    private void m6373e(int i) throws IOException {
        char c;
        int[] iArr = this.f5543p;
        int length = iArr.length;
        int i2 = 0;
        int iM6366a = 0;
        while (i2 < i) {
            do {
                c = this.f5594v[i2];
                if (c < length && iArr[c] != 0) {
                    break;
                } else {
                    i2++;
                }
            } while (i2 < i);
            int i3 = i2 - iM6366a;
            if (i3 > 0) {
                this.f5593u.write(this.f5594v, iM6366a, i3);
                if (i2 >= i) {
                    return;
                }
            }
            int i4 = i2 + 1;
            iM6366a = m6366a(this.f5594v, i4, i, c, iArr[c]);
            i2 = i4;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x002d A[SYNTHETIC] */
    /* JADX INFO: renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void m6368b(int r10, int r11) throws java.io.IOException {
        /*
            r9 = this;
            int r0 = r9.f5596x
            int r1 = r0 + r10
            int[] r2 = r9.f5543p
            int r0 = r2.length
            int r3 = r11 + 1
            int r3 = java.lang.Math.min(r0, r3)
        Ld:
            int r0 = r9.f5596x
            if (r0 >= r1) goto L43
        L11:
            char[] r0 = r9.f5594v
            int r4 = r9.f5596x
            char r4 = r0[r4]
            if (r4 >= r3) goto L37
            r0 = r2[r4]
            if (r0 == 0) goto L3b
        L1d:
            int r5 = r9.f5596x
            int r6 = r9.f5595w
            int r5 = r5 - r6
            if (r5 <= 0) goto L2d
            java.io.Writer r6 = r9.f5593u
            char[] r7 = r9.f5594v
            int r8 = r9.f5595w
            r6.write(r7, r8, r5)
        L2d:
            int r5 = r9.f5596x
            int r5 = r5 + 1
            r9.f5596x = r5
            r9.m6367a(r4, r0)
            goto Ld
        L37:
            if (r4 <= r11) goto L3b
            r0 = -1
            goto L1d
        L3b:
            int r0 = r9.f5596x
            int r0 = r0 + 1
            r9.f5596x = r0
            if (r0 < r1) goto L11
        L43:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.json.WriterBasedJsonGenerator.m6368b(int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x002f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:27:? A[LOOP:1: B:4:0x000e->B:27:?, LOOP_END, SYNTHETIC] */
    /* JADX INFO: renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void m6371c(int r10, int r11) throws java.io.IOException {
        /*
            r9 = this;
            r0 = 0
            int[] r6 = r9.f5543p
            int r1 = r6.length
            int r2 = r11 + 1
            int r7 = java.lang.Math.min(r1, r2)
            r2 = r0
            r1 = r0
        Lc:
            if (r1 >= r10) goto L25
        Le:
            char[] r3 = r9.f5594v
            char r4 = r3[r1]
            if (r4 >= r7) goto L26
            r5 = r6[r4]
            if (r5 == 0) goto L2a
        L18:
            int r0 = r1 - r2
            if (r0 <= 0) goto L31
            java.io.Writer r3 = r9.f5593u
            char[] r8 = r9.f5594v
            r3.write(r8, r2, r0)
            if (r1 < r10) goto L31
        L25:
            return
        L26:
            if (r4 <= r11) goto L2b
            r5 = -1
            goto L18
        L2a:
            r0 = r5
        L2b:
            int r1 = r1 + 1
            if (r1 < r10) goto Le
            r5 = r0
            goto L18
        L31:
            int r2 = r1 + 1
            char[] r1 = r9.f5594v
            r0 = r9
            r3 = r10
            int r0 = r0.m6366a(r1, r2, r3, r4, r5)
            r1 = r2
            r2 = r0
            r0 = r5
            goto Lc
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.json.WriterBasedJsonGenerator.m6371c(int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0037 A[SYNTHETIC] */
    /* JADX INFO: renamed from: f */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void m6374f(int r12) throws java.io.IOException {
        /*
            r11 = this;
            int r0 = r11.f5596x
            int r2 = r0 + r12
            int[] r3 = r11.f5543p
            int r0 = r11.f5544q
            r1 = 1
            if (r0 >= r1) goto L41
            r0 = 65535(0xffff, float:9.1834E-41)
        Le:
            int r1 = r3.length
            int r4 = r0 + 1
            int r4 = java.lang.Math.min(r1, r4)
            com.fasterxml.jackson.core.io.CharacterEscapes r5 = r11.f5545r
        L17:
            int r1 = r11.f5596x
            if (r1 >= r2) goto L5a
        L1b:
            char[] r1 = r11.f5594v
            int r6 = r11.f5596x
            char r6 = r1[r6]
            if (r6 >= r4) goto L44
            r1 = r3[r6]
            if (r1 == 0) goto L52
        L27:
            int r7 = r11.f5596x
            int r8 = r11.f5595w
            int r7 = r7 - r8
            if (r7 <= 0) goto L37
            java.io.Writer r8 = r11.f5593u
            char[] r9 = r11.f5594v
            int r10 = r11.f5595w
            r8.write(r9, r10, r7)
        L37:
            int r7 = r11.f5596x
            int r7 = r7 + 1
            r11.f5596x = r7
            r11.m6367a(r6, r1)
            goto L17
        L41:
            int r0 = r11.f5544q
            goto Le
        L44:
            if (r6 <= r0) goto L48
            r1 = -1
            goto L27
        L48:
            com.fasterxml.jackson.core.SerializableString r1 = r5.m6152a(r6)
            r11.f5592A = r1
            if (r1 == 0) goto L52
            r1 = -2
            goto L27
        L52:
            int r1 = r11.f5596x
            int r1 = r1 + 1
            r11.f5596x = r1
            if (r1 < r2) goto L1b
        L5a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.json.WriterBasedJsonGenerator.m6374f(int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0048 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:35:? A[LOOP:1: B:7:0x0019->B:35:?, LOOP_END, SYNTHETIC] */
    /* JADX INFO: renamed from: g */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void m6375g(int r12) throws java.io.IOException {
        /*
            r11 = this;
            r1 = 0
            int[] r7 = r11.f5543p
            int r0 = r11.f5544q
            r2 = 1
            if (r0 >= r2) goto L31
            r0 = 65535(0xffff, float:9.1834E-41)
            r6 = r0
        Lc:
            int r0 = r7.length
            int r2 = r6 + 1
            int r8 = java.lang.Math.min(r0, r2)
            com.fasterxml.jackson.core.io.CharacterEscapes r9 = r11.f5545r
            r2 = r1
            r0 = r1
        L17:
            if (r1 >= r12) goto L30
        L19:
            char[] r3 = r11.f5594v
            char r4 = r3[r1]
            if (r4 >= r8) goto L35
            r5 = r7[r4]
            if (r5 == 0) goto L43
        L23:
            int r0 = r1 - r2
            if (r0 <= 0) goto L4a
            java.io.Writer r3 = r11.f5593u
            char[] r10 = r11.f5594v
            r3.write(r10, r2, r0)
            if (r1 < r12) goto L4a
        L30:
            return
        L31:
            int r0 = r11.f5544q
            r6 = r0
            goto Lc
        L35:
            if (r4 <= r6) goto L39
            r5 = -1
            goto L23
        L39:
            com.fasterxml.jackson.core.SerializableString r3 = r9.m6152a(r4)
            r11.f5592A = r3
            if (r3 == 0) goto L44
            r5 = -2
            goto L23
        L43:
            r0 = r5
        L44:
            int r1 = r1 + 1
            if (r1 < r12) goto L19
            r5 = r0
            goto L23
        L4a:
            int r2 = r1 + 1
            char[] r1 = r11.f5594v
            r0 = r11
            r3 = r12
            int r0 = r0.m6366a(r1, r2, r3, r4, r5)
            r1 = r2
            r2 = r0
            r0 = r5
            goto L17
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.json.WriterBasedJsonGenerator.m6375g(int):void");
    }

    /* JADX INFO: renamed from: m */
    private final void m6380m() throws IOException {
        if (this.f5596x + 4 >= this.f5597y) {
            m6385l();
        }
        int i = this.f5596x;
        char[] cArr = this.f5594v;
        cArr[i] = 'n';
        int i2 = i + 1;
        cArr[i2] = 'u';
        int i3 = i2 + 1;
        cArr[i3] = 'l';
        int i4 = i3 + 1;
        cArr[i4] = 'l';
        this.f5596x = i4 + 1;
    }

    /* JADX INFO: renamed from: a */
    private void m6367a(char c, int i) throws IOException {
        String strMo6095a;
        int i2;
        if (i >= 0) {
            if (this.f5596x >= 2) {
                int i3 = this.f5596x - 2;
                this.f5595w = i3;
                this.f5594v[i3] = TokenParser.ESCAPE;
                this.f5594v[i3 + 1] = (char) i;
                return;
            }
            char[] cArrM6381n = this.f5598z;
            if (cArrM6381n == null) {
                cArrM6381n = m6381n();
            }
            this.f5595w = this.f5596x;
            cArrM6381n[1] = (char) i;
            this.f5593u.write(cArrM6381n, 0, 2);
            return;
        }
        if (i != -2) {
            if (this.f5596x >= 6) {
                char[] cArr = this.f5594v;
                int i4 = this.f5596x - 6;
                this.f5595w = i4;
                cArr[i4] = TokenParser.ESCAPE;
                int i5 = i4 + 1;
                cArr[i5] = 'u';
                if (c > 255) {
                    int i6 = (c >> '\b') & 255;
                    int i7 = i5 + 1;
                    cArr[i7] = f5591t[i6 >> 4];
                    i2 = i7 + 1;
                    cArr[i2] = f5591t[i6 & 15];
                    c = (char) (c & 255);
                } else {
                    int i8 = i5 + 1;
                    cArr[i8] = '0';
                    i2 = i8 + 1;
                    cArr[i2] = '0';
                }
                int i9 = i2 + 1;
                cArr[i9] = f5591t[c >> 4];
                cArr[i9 + 1] = f5591t[c & 15];
                return;
            }
            char[] cArrM6381n2 = this.f5598z;
            if (cArrM6381n2 == null) {
                cArrM6381n2 = m6381n();
            }
            this.f5595w = this.f5596x;
            if (c > 255) {
                int i10 = (c >> '\b') & 255;
                int i11 = c & 255;
                cArrM6381n2[10] = f5591t[i10 >> 4];
                cArrM6381n2[11] = f5591t[i10 & 15];
                cArrM6381n2[12] = f5591t[i11 >> 4];
                cArrM6381n2[13] = f5591t[i11 & 15];
                this.f5593u.write(cArrM6381n2, 8, 6);
                return;
            }
            cArrM6381n2[6] = f5591t[c >> 4];
            cArrM6381n2[7] = f5591t[c & 15];
            this.f5593u.write(cArrM6381n2, 2, 6);
            return;
        }
        if (this.f5592A == null) {
            strMo6095a = this.f5545r.m6152a(c).mo6095a();
        } else {
            strMo6095a = this.f5592A.mo6095a();
            this.f5592A = null;
        }
        int length = strMo6095a.length();
        if (this.f5596x >= length) {
            int i12 = this.f5596x - length;
            this.f5595w = i12;
            strMo6095a.getChars(0, length, this.f5594v, i12);
        } else {
            this.f5595w = this.f5596x;
            this.f5593u.write(strMo6095a);
        }
    }

    /* JADX INFO: renamed from: a */
    private int m6366a(char[] cArr, int i, int i2, char c, int i3) throws IOException {
        String strMo6095a;
        int i4;
        if (i3 >= 0) {
            if (i > 1 && i < i2) {
                int i5 = i - 2;
                cArr[i5] = TokenParser.ESCAPE;
                cArr[i5 + 1] = (char) i3;
                return i5;
            }
            char[] cArrM6381n = this.f5598z;
            if (cArrM6381n == null) {
                cArrM6381n = m6381n();
            }
            cArrM6381n[1] = (char) i3;
            this.f5593u.write(cArrM6381n, 0, 2);
            return i;
        }
        if (i3 != -2) {
            if (i > 5 && i < i2) {
                int i6 = i - 6;
                int i7 = i6 + 1;
                cArr[i6] = TokenParser.ESCAPE;
                int i8 = i7 + 1;
                cArr[i7] = 'u';
                if (c > 255) {
                    int i9 = (c >> '\b') & 255;
                    int i10 = i8 + 1;
                    cArr[i8] = f5591t[i9 >> 4];
                    i4 = i10 + 1;
                    cArr[i10] = f5591t[i9 & 15];
                    c = (char) (c & 255);
                } else {
                    int i11 = i8 + 1;
                    cArr[i8] = '0';
                    i4 = i11 + 1;
                    cArr[i11] = '0';
                }
                int i12 = i4 + 1;
                cArr[i4] = f5591t[c >> 4];
                cArr[i12] = f5591t[c & 15];
                return i12 - 5;
            }
            char[] cArrM6381n2 = this.f5598z;
            if (cArrM6381n2 == null) {
                cArrM6381n2 = m6381n();
            }
            this.f5595w = this.f5596x;
            if (c > 255) {
                int i13 = (c >> '\b') & 255;
                int i14 = c & 255;
                cArrM6381n2[10] = f5591t[i13 >> 4];
                cArrM6381n2[11] = f5591t[i13 & 15];
                cArrM6381n2[12] = f5591t[i14 >> 4];
                cArrM6381n2[13] = f5591t[i14 & 15];
                this.f5593u.write(cArrM6381n2, 8, 6);
                return i;
            }
            cArrM6381n2[6] = f5591t[c >> 4];
            cArrM6381n2[7] = f5591t[c & 15];
            this.f5593u.write(cArrM6381n2, 2, 6);
            return i;
        }
        if (this.f5592A == null) {
            strMo6095a = this.f5545r.m6152a(c).mo6095a();
        } else {
            strMo6095a = this.f5592A.mo6095a();
            this.f5592A = null;
        }
        int length = strMo6095a.length();
        if (i >= length && i < i2) {
            int i15 = i - length;
            strMo6095a.getChars(0, length, cArr, i15);
            return i15;
        }
        this.f5593u.write(strMo6095a);
        return i;
    }

    /* JADX INFO: renamed from: n */
    private char[] m6381n() {
        char[] cArr = {TokenParser.ESCAPE, 0, TokenParser.ESCAPE, 'u', '0', '0', 0, 0, TokenParser.ESCAPE, 'u', 0, 0, 0, 0};
        this.f5598z = cArr;
        return cArr;
    }

    /* JADX INFO: renamed from: l */
    protected void m6385l() throws IOException {
        int i = this.f5596x - this.f5595w;
        if (i > 0) {
            int i2 = this.f5595w;
            this.f5595w = 0;
            this.f5596x = 0;
            this.f5593u.write(this.f5594v, i2, i);
        }
    }
}
