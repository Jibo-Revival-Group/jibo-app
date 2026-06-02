package com.fasterxml.jackson.core.json;

import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.core.p000io.IOContext;
import com.fasterxml.jackson.core.p000io.MergedStream;
import com.fasterxml.jackson.core.p000io.UTF32Reader;
import com.fasterxml.jackson.core.sym.ByteQuadsCanonicalizer;
import com.fasterxml.jackson.core.sym.CharsToNameCanonicalizer;
import java.io.ByteArrayInputStream;
import java.io.CharConversionException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

/* JADX INFO: loaded from: classes.dex */
public final class ByteSourceJsonBootstrapper {

    /* JADX INFO: renamed from: a */
    protected final IOContext f5528a;

    /* JADX INFO: renamed from: b */
    protected final InputStream f5529b;

    /* JADX INFO: renamed from: c */
    protected final byte[] f5530c;

    /* JADX INFO: renamed from: e */
    protected boolean f5532e = true;

    /* JADX INFO: renamed from: f */
    protected int f5533f = 0;

    /* JADX INFO: renamed from: g */
    private int f5534g = 0;

    /* JADX INFO: renamed from: h */
    private int f5535h = 0;

    /* JADX INFO: renamed from: d */
    protected int f5531d = 0;

    /* JADX INFO: renamed from: i */
    private final boolean f5536i = true;

    public ByteSourceJsonBootstrapper(IOContext iOContext, InputStream inputStream) {
        this.f5528a = iOContext;
        this.f5529b = inputStream;
        this.f5530c = iOContext.m6169e();
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0054  */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.fasterxml.jackson.core.JsonEncoding m6212a() throws java.io.IOException {
        /*
            r5 = this;
            r0 = 1
            r1 = 0
            r2 = 4
            boolean r2 = r5.m6214a(r2)
            if (r2 == 0) goto L56
            byte[] r2 = r5.f5530c
            int r3 = r5.f5534g
            r2 = r2[r3]
            int r2 = r2 << 24
            byte[] r3 = r5.f5530c
            int r4 = r5.f5534g
            int r4 = r4 + 1
            r3 = r3[r4]
            r3 = r3 & 255(0xff, float:3.57E-43)
            int r3 = r3 << 16
            r2 = r2 | r3
            byte[] r3 = r5.f5530c
            int r4 = r5.f5534g
            int r4 = r4 + 2
            r3 = r3[r4]
            r3 = r3 & 255(0xff, float:3.57E-43)
            int r3 = r3 << 8
            r2 = r2 | r3
            byte[] r3 = r5.f5530c
            int r4 = r5.f5534g
            int r4 = r4 + 3
            r3 = r3[r4]
            r3 = r3 & 255(0xff, float:3.57E-43)
            r2 = r2 | r3
            boolean r3 = r5.m6209b(r2)
            if (r3 == 0) goto L46
        L3c:
            if (r0 != 0) goto L79
            com.fasterxml.jackson.core.JsonEncoding r0 = com.fasterxml.jackson.core.JsonEncoding.UTF8
        L40:
            com.fasterxml.jackson.core.io.IOContext r1 = r5.f5528a
            r1.m6156a(r0)
            return r0
        L46:
            boolean r3 = r5.m6210c(r2)
            if (r3 != 0) goto L3c
            int r2 = r2 >>> 16
            boolean r2 = r5.m6211d(r2)
            if (r2 != 0) goto L3c
        L54:
            r0 = r1
            goto L3c
        L56:
            r2 = 2
            boolean r2 = r5.m6214a(r2)
            if (r2 == 0) goto L54
            byte[] r2 = r5.f5530c
            int r3 = r5.f5534g
            r2 = r2[r3]
            r2 = r2 & 255(0xff, float:3.57E-43)
            int r2 = r2 << 8
            byte[] r3 = r5.f5530c
            int r4 = r5.f5534g
            int r4 = r4 + 1
            r3 = r3[r4]
            r3 = r3 & 255(0xff, float:3.57E-43)
            r2 = r2 | r3
            boolean r2 = r5.m6211d(r2)
            if (r2 == 0) goto L54
            goto L3c
        L79:
            int r0 = r5.f5533f
            switch(r0) {
                case 1: goto L86;
                case 2: goto L89;
                case 3: goto L7e;
                case 4: goto L93;
                default: goto L7e;
            }
        L7e:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            java.lang.String r1 = "Internal error"
            r0.<init>(r1)
            throw r0
        L86:
            com.fasterxml.jackson.core.JsonEncoding r0 = com.fasterxml.jackson.core.JsonEncoding.UTF8
            goto L40
        L89:
            boolean r0 = r5.f5532e
            if (r0 == 0) goto L90
            com.fasterxml.jackson.core.JsonEncoding r0 = com.fasterxml.jackson.core.JsonEncoding.UTF16_BE
            goto L40
        L90:
            com.fasterxml.jackson.core.JsonEncoding r0 = com.fasterxml.jackson.core.JsonEncoding.UTF16_LE
            goto L40
        L93:
            boolean r0 = r5.f5532e
            if (r0 == 0) goto L9a
            com.fasterxml.jackson.core.JsonEncoding r0 = com.fasterxml.jackson.core.JsonEncoding.UTF32_BE
            goto L40
        L9a:
            com.fasterxml.jackson.core.JsonEncoding r0 = com.fasterxml.jackson.core.JsonEncoding.UTF32_LE
            goto L40
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.json.ByteSourceJsonBootstrapper.m6212a():com.fasterxml.jackson.core.JsonEncoding");
    }

    /* JADX INFO: renamed from: b */
    public Reader m6215b() throws IOException {
        InputStream mergedStream;
        JsonEncoding jsonEncodingM6163b = this.f5528a.m6163b();
        switch (jsonEncodingM6163b.bits()) {
            case 8:
            case 16:
                InputStream inputStream = this.f5529b;
                if (inputStream == null) {
                    mergedStream = new ByteArrayInputStream(this.f5530c, this.f5534g, this.f5535h);
                } else {
                    mergedStream = this.f5534g < this.f5535h ? new MergedStream(this.f5528a, inputStream, this.f5530c, this.f5534g, this.f5535h) : inputStream;
                }
                return new InputStreamReader(mergedStream, jsonEncodingM6163b.getJavaName());
            case 32:
                return new UTF32Reader(this.f5528a, this.f5529b, this.f5530c, this.f5534g, this.f5535h, this.f5528a.m6163b().isBigEndian());
            default:
                throw new RuntimeException("Internal error");
        }
    }

    /* JADX INFO: renamed from: a */
    public JsonParser m6213a(int i, ObjectCodec objectCodec, ByteQuadsCanonicalizer byteQuadsCanonicalizer, CharsToNameCanonicalizer charsToNameCanonicalizer, int i2) throws IOException {
        if (m6212a() != JsonEncoding.UTF8 || !JsonFactory.Feature.CANONICALIZE_FIELD_NAMES.enabledIn(i2)) {
            return new ReaderBasedJsonParser(this.f5528a, i, m6215b(), objectCodec, charsToNameCanonicalizer.m6440b(i2));
        }
        return new UTF8StreamJsonParser(this.f5528a, i, this.f5529b, objectCodec, byteQuadsCanonicalizer.m6411b(i2), this.f5530c, this.f5534g, this.f5535h, this.f5536i);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:12:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:6:0x000e  */
    /* JADX INFO: renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean m6209b(int r6) throws java.io.IOException {
        /*
            r5 = this;
            r3 = 4
            r4 = 2
            r1 = 0
            r0 = 1
            switch(r6) {
                case -16842752: goto L34;
                case -131072: goto L24;
                case 65279: goto L19;
                case 65534: goto L2f;
                default: goto L7;
            }
        L7:
            int r2 = r6 >>> 16
            r3 = 65279(0xfeff, float:9.1475E-41)
            if (r2 != r3) goto L3a
            int r1 = r5.f5534g
            int r1 = r1 + 2
            r5.f5534g = r1
            r5.f5533f = r4
            r5.f5532e = r0
        L18:
            return r0
        L19:
            r5.f5532e = r0
            int r1 = r5.f5534g
            int r1 = r1 + 4
            r5.f5534g = r1
            r5.f5533f = r3
            goto L18
        L24:
            int r2 = r5.f5534g
            int r2 = r2 + 4
            r5.f5534g = r2
            r5.f5533f = r3
            r5.f5532e = r1
            goto L18
        L2f:
            java.lang.String r2 = "2143"
            r5.m6208a(r2)
        L34:
            java.lang.String r2 = "3412"
            r5.m6208a(r2)
            goto L7
        L3a:
            r3 = 65534(0xfffe, float:9.1833E-41)
            if (r2 != r3) goto L4a
            int r2 = r5.f5534g
            int r2 = r2 + 2
            r5.f5534g = r2
            r5.f5533f = r4
            r5.f5532e = r1
            goto L18
        L4a:
            int r2 = r6 >>> 8
            r3 = 15711167(0xefbbbf, float:2.2016034E-38)
            if (r2 != r3) goto L5c
            int r1 = r5.f5534g
            int r1 = r1 + 3
            r5.f5534g = r1
            r5.f5533f = r0
            r5.f5532e = r0
            goto L18
        L5c:
            r0 = r1
            goto L18
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.json.ByteSourceJsonBootstrapper.m6209b(int):boolean");
    }

    /* JADX INFO: renamed from: c */
    private boolean m6210c(int i) throws IOException {
        if ((i >> 8) == 0) {
            this.f5532e = true;
        } else if ((16777215 & i) == 0) {
            this.f5532e = false;
        } else if (((-16711681) & i) == 0) {
            m6208a("3412");
        } else {
            if (((-65281) & i) != 0) {
                return false;
            }
            m6208a("2143");
        }
        this.f5533f = 4;
        return true;
    }

    /* JADX INFO: renamed from: d */
    private boolean m6211d(int i) {
        if ((65280 & i) == 0) {
            this.f5532e = true;
        } else {
            if ((i & 255) != 0) {
                return false;
            }
            this.f5532e = false;
        }
        this.f5533f = 2;
        return true;
    }

    /* JADX INFO: renamed from: a */
    private void m6208a(String str) throws IOException {
        throw new CharConversionException("Unsupported UCS-4 endianness (" + str + ") detected");
    }

    /* JADX INFO: renamed from: a */
    protected boolean m6214a(int i) throws IOException {
        int i2;
        int i3 = this.f5535h - this.f5534g;
        while (i3 < i) {
            if (this.f5529b == null) {
                i2 = -1;
            } else {
                i2 = this.f5529b.read(this.f5530c, this.f5535h, this.f5530c.length - this.f5535h);
            }
            if (i2 < 1) {
                return false;
            }
            this.f5535h += i2;
            i3 = i2 + i3;
        }
        return true;
    }
}
