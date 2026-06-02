package com.fasterxml.jackson.core.json;

import com.facebook.internal.ServerProtocol;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.core.base.ParserBase;
import com.fasterxml.jackson.core.p000io.CharTypes;
import com.fasterxml.jackson.core.p000io.IOContext;
import com.fasterxml.jackson.core.sym.CharsToNameCanonicalizer;
import com.fasterxml.jackson.core.util.TextBuffer;
import java.io.IOException;
import java.io.Reader;
import org.apache.http.message.TokenParser;

/* JADX INFO: loaded from: classes.dex */
public class ReaderBasedJsonParser extends ParserBase {

    /* JADX INFO: renamed from: L */
    protected static final int[] f5560L = CharTypes.m6144a();

    /* JADX INFO: renamed from: M */
    protected Reader f5561M;

    /* JADX INFO: renamed from: N */
    protected char[] f5562N;

    /* JADX INFO: renamed from: O */
    protected boolean f5563O;

    /* JADX INFO: renamed from: P */
    protected ObjectCodec f5564P;

    /* JADX INFO: renamed from: Q */
    protected final CharsToNameCanonicalizer f5565Q;

    /* JADX INFO: renamed from: R */
    protected final int f5566R;

    /* JADX INFO: renamed from: S */
    protected boolean f5567S;

    public ReaderBasedJsonParser(IOContext iOContext, int i, Reader reader, ObjectCodec objectCodec, CharsToNameCanonicalizer charsToNameCanonicalizer, char[] cArr, int i2, int i3, boolean z) {
        super(iOContext, i);
        this.f5567S = false;
        this.f5561M = reader;
        this.f5562N = cArr;
        this.f5448d = i2;
        this.f5449e = i3;
        this.f5564P = objectCodec;
        this.f5565Q = charsToNameCanonicalizer;
        this.f5566R = charsToNameCanonicalizer.m6446e();
        this.f5563O = z;
    }

    public ReaderBasedJsonParser(IOContext iOContext, int i, Reader reader, ObjectCodec objectCodec, CharsToNameCanonicalizer charsToNameCanonicalizer) {
        super(iOContext, i);
        this.f5567S = false;
        this.f5561M = reader;
        this.f5562N = iOContext.m6171g();
        this.f5448d = 0;
        this.f5449e = 0;
        this.f5564P = objectCodec;
        this.f5565Q = charsToNameCanonicalizer;
        this.f5566R = charsToNameCanonicalizer.m6446e();
        this.f5563O = true;
    }

    @Override // com.fasterxml.jackson.core.base.ParserBase
    /* JADX INFO: renamed from: p */
    protected boolean mo6118p() throws IOException {
        this.f5450f += (long) this.f5449e;
        this.f5452h -= this.f5449e;
        if (this.f5561M == null) {
            return false;
        }
        int i = this.f5561M.read(this.f5562N, 0, this.f5562N.length);
        if (i > 0) {
            this.f5448d = 0;
            this.f5449e = i;
            return true;
        }
        mo6120r();
        if (i == 0) {
            throw new IOException("Reader returned 0 characters when trying to read " + this.f5449e);
        }
        return false;
    }

    /* JADX INFO: renamed from: e */
    protected char m6273e(String str) throws IOException {
        if (this.f5448d >= this.f5449e && !mo6118p()) {
            m6140c(str);
        }
        char[] cArr = this.f5562N;
        int i = this.f5448d;
        this.f5448d = i + 1;
        return cArr[i];
    }

    @Override // com.fasterxml.jackson.core.base.ParserBase
    /* JADX INFO: renamed from: r */
    protected void mo6120r() throws IOException {
        if (this.f5561M != null) {
            if (this.f5446b.m6167c() || m6062a(JsonParser.Feature.AUTO_CLOSE_SOURCE)) {
                this.f5561M.close();
            }
            this.f5561M = null;
        }
    }

    @Override // com.fasterxml.jackson.core.base.ParserBase
    /* JADX INFO: renamed from: s */
    protected void mo6121s() throws IOException {
        char[] cArr;
        super.mo6121s();
        this.f5565Q.m6441b();
        if (this.f5563O && (cArr = this.f5562N) != null) {
            this.f5562N = null;
            this.f5446b.m6160a(cArr);
        }
    }

    @Override // com.fasterxml.jackson.core.base.ParserMinimalBase, com.fasterxml.jackson.core.JsonParser
    /* JADX INFO: renamed from: f */
    public final String mo6067f() throws IOException {
        JsonToken jsonToken = this.f5463K;
        if (jsonToken != JsonToken.VALUE_STRING) {
            return m6270a(jsonToken);
        }
        if (this.f5567S) {
            this.f5567S = false;
            mo6119q();
        }
        return this.f5458n.m6485f();
    }

    /* JADX INFO: renamed from: a */
    protected final String m6270a(JsonToken jsonToken) {
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

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.fasterxml.jackson.core.base.ParserMinimalBase, com.fasterxml.jackson.core.JsonParser
    /* JADX INFO: renamed from: a */
    public final JsonToken mo6061a() throws IOException {
        JsonToken jsonTokenM6274e;
        this.f5436A = 0;
        if (this.f5463K == JsonToken.FIELD_NAME) {
            return m6241O();
        }
        if (this.f5567S) {
            m6267M();
        }
        int iM6246T = m6246T();
        if (iM6246T < 0) {
            close();
            this.f5463K = null;
            return null;
        }
        this.f5453i = (this.f5450f + ((long) this.f5448d)) - 1;
        this.f5454j = this.f5451g;
        this.f5455k = (this.f5448d - this.f5452h) - 1;
        this.f5462r = null;
        if (iM6246T == 93) {
            if (!this.f5456l.m6078a()) {
                m6113a(iM6246T, '}');
            }
            this.f5456l = this.f5456l.m6230h();
            JsonToken jsonToken = JsonToken.END_ARRAY;
            this.f5463K = jsonToken;
            return jsonToken;
        }
        if (iM6246T == 125) {
            if (!this.f5456l.m6080c()) {
                m6113a(iM6246T, ']');
            }
            this.f5456l = this.f5456l.m6230h();
            JsonToken jsonToken2 = JsonToken.END_OBJECT;
            this.f5463K = jsonToken2;
            return jsonToken2;
        }
        if (this.f5456l.m6231i()) {
            iM6246T = m6261i(iM6246T);
        }
        boolean zC = this.f5456l.m6080c();
        if (zC) {
            this.f5456l.m6227a(iM6246T == 34 ? m6263I() : m6275f(iM6246T));
            this.f5463K = JsonToken.FIELD_NAME;
            iM6246T = m6244R();
        }
        switch (iM6246T) {
            case 34:
                this.f5567S = true;
                jsonTokenM6274e = JsonToken.VALUE_STRING;
                break;
            case 45:
                jsonTokenM6274e = m6262H();
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
                jsonTokenM6274e = m6274e(iM6246T);
                break;
            case 91:
                if (!zC) {
                    this.f5456l = this.f5456l.m6225a(this.f5454j, this.f5455k);
                }
                jsonTokenM6274e = JsonToken.START_ARRAY;
                break;
            case 93:
            case 125:
                m6137b(iM6246T, "expected a value");
                m6252Z();
                jsonTokenM6274e = JsonToken.VALUE_TRUE;
                break;
            case 102:
                m6257aa();
                jsonTokenM6274e = JsonToken.VALUE_FALSE;
                break;
            case 110:
                m6258ab();
                jsonTokenM6274e = JsonToken.VALUE_NULL;
                break;
            case 116:
                m6252Z();
                jsonTokenM6274e = JsonToken.VALUE_TRUE;
                break;
            case 123:
                if (!zC) {
                    this.f5456l = this.f5456l.m6228b(this.f5454j, this.f5455k);
                }
                jsonTokenM6274e = JsonToken.START_OBJECT;
                break;
            default:
                jsonTokenM6274e = m6277g(iM6246T);
                break;
        }
        if (zC) {
            this.f5457m = jsonTokenM6274e;
            return this.f5463K;
        }
        this.f5463K = jsonTokenM6274e;
        return jsonTokenM6274e;
    }

    /* JADX INFO: renamed from: O */
    private final JsonToken m6241O() {
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
    protected final JsonToken m6274e(int i) throws IOException {
        int i2 = this.f5448d;
        int i3 = i2 - 1;
        int i4 = this.f5449e;
        if (i == 48) {
            return m6259b(false, i3);
        }
        int i5 = 1;
        int i6 = i2;
        while (i6 < i4) {
            int i7 = i6 + 1;
            char c = this.f5562N[i6];
            if (c >= '0' && c <= '9') {
                i5++;
                i6 = i7;
            } else {
                if (c == '.' || c == 'e' || c == 'E') {
                    this.f5448d = i7;
                    return m6254a(c, i3, i7, false, i5);
                }
                int i8 = i7 - 1;
                this.f5448d = i8;
                if (this.f5456l.m6079b()) {
                    m6260h(c);
                }
                this.f5458n.m6477a(this.f5562N, i3, i8 - i3);
                return m6110a(false, i5);
            }
        }
        this.f5448d = i3;
        return m6259b(false, i3);
    }

    /* JADX INFO: renamed from: a */
    private final JsonToken m6254a(int i, int i2, int i3, boolean z, int i4) throws IOException {
        int i5;
        int i6;
        int i7;
        int i8 = 0;
        int i9 = this.f5449e;
        if (i == 46) {
            int i10 = 0;
            int i11 = i3;
            while (i11 < i9) {
                int i12 = i11 + 1;
                char c = this.f5562N[i11];
                if (c >= '0' && c <= '9') {
                    i10++;
                    i11 = i12;
                } else {
                    if (i10 == 0) {
                        m6114a(c, "Decimal point not followed by a digit");
                    }
                    i5 = i10;
                    i6 = i12;
                    i7 = c;
                }
            }
            return m6259b(z, i2);
        }
        i5 = 0;
        i6 = i3;
        i7 = i;
        if (i7 == 101 || i7 == 69) {
            if (i6 >= i9) {
                this.f5448d = i2;
                return m6259b(z, i2);
            }
            int i13 = i6 + 1;
            char c2 = this.f5562N[i6];
            if (c2 != '-' && c2 != '+') {
                i7 = c2;
                i6 = i13;
            } else {
                if (i13 >= i9) {
                    this.f5448d = i2;
                    return m6259b(z, i2);
                }
                i6 = i13 + 1;
                i7 = this.f5562N[i13];
            }
            while (i7 <= 57 && i7 >= 48) {
                i8++;
                if (i6 >= i9) {
                    this.f5448d = i2;
                    return m6259b(z, i2);
                }
                i7 = this.f5562N[i6];
                i6++;
            }
            if (i8 == 0) {
                m6114a(i7, "Exponent indicator not followed by a digit");
            }
        }
        int i14 = i6 - 1;
        this.f5448d = i14;
        if (this.f5456l.m6079b()) {
            m6260h(i7);
        }
        this.f5458n.m6477a(this.f5562N, i2, i14 - i2);
        return m6115b(z, i4, i5, i8);
    }

    /* JADX INFO: renamed from: H */
    protected final JsonToken m6262H() throws IOException {
        int i = this.f5448d;
        int i2 = i - 1;
        int i3 = this.f5449e;
        if (i >= i3) {
            return m6259b(true, i2);
        }
        int i4 = i + 1;
        char c = this.f5562N[i];
        if (c > '9' || c < '0') {
            this.f5448d = i4;
            return m6269a((int) c, true);
        }
        if (c == '0') {
            return m6259b(true, i2);
        }
        int i5 = 1;
        int i6 = i4;
        while (i6 < i3) {
            int i7 = i6 + 1;
            char c2 = this.f5562N[i6];
            if (c2 >= '0' && c2 <= '9') {
                i5++;
                i6 = i7;
            } else {
                if (c2 == '.' || c2 == 'e' || c2 == 'E') {
                    this.f5448d = i7;
                    return m6254a(c2, i2, i7, true, i5);
                }
                int i8 = i7 - 1;
                this.f5448d = i8;
                if (this.f5456l.m6079b()) {
                    m6260h(c2);
                }
                this.f5458n.m6477a(this.f5562N, i2, i8 - i2);
                return m6110a(true, i5);
            }
        }
        return m6259b(true, i2);
    }

    /* JADX INFO: renamed from: b */
    private final JsonToken m6259b(boolean z, int i) throws IOException {
        int i2;
        char cM6273e;
        int i3;
        int i4;
        char[] cArrM6492m;
        char c;
        int i5;
        int i6;
        boolean z2;
        char c2;
        char[] cArrM6492m2;
        char cM6273e2;
        int i7;
        char cM6273e3;
        int i8;
        char c3;
        boolean z3;
        int i9;
        int i10;
        if (z) {
            i++;
        }
        this.f5448d = i;
        char[] cArrM6490k = this.f5458n.m6490k();
        if (!z) {
            i2 = 0;
        } else {
            i2 = 1;
            cArrM6490k[0] = '-';
        }
        int i11 = 0;
        if (this.f5448d < this.f5449e) {
            char[] cArr = this.f5562N;
            int i12 = this.f5448d;
            this.f5448d = i12 + 1;
            cM6273e = cArr[i12];
        } else {
            cM6273e = m6273e("No digit following minus sign");
        }
        if (cM6273e == '0') {
            cM6273e = m6242P();
        }
        boolean z4 = false;
        char c4 = cM6273e;
        char[] cArrM6492m3 = cArrM6490k;
        char c5 = c4;
        while (c5 >= '0' && c5 <= '9') {
            i11++;
            if (i2 >= cArrM6492m3.length) {
                cArrM6492m3 = this.f5458n.m6492m();
                i2 = 0;
            }
            i4 = i2 + 1;
            cArrM6492m3[i2] = c5;
            if (this.f5448d >= this.f5449e && !mo6118p()) {
                z4 = true;
                i3 = i11;
                cArrM6492m = cArrM6492m3;
                c = 0;
                break;
            }
            char[] cArr2 = this.f5562N;
            int i13 = this.f5448d;
            this.f5448d = i13 + 1;
            c5 = cArr2[i13];
            i2 = i4;
        }
        i3 = i11;
        i4 = i2;
        cArrM6492m = cArrM6492m3;
        c = c5;
        if (i3 == 0) {
            return m6269a(c, z);
        }
        int i14 = 0;
        if (c != '.') {
            i5 = 0;
            i6 = i4;
            z2 = z4;
            c2 = c;
            cArrM6492m2 = cArrM6492m;
        } else {
            int i15 = i4 + 1;
            cArrM6492m[i4] = c;
            while (true) {
                if (this.f5448d >= this.f5449e && !mo6118p()) {
                    z2 = true;
                    c2 = c;
                    break;
                }
                char[] cArr3 = this.f5562N;
                int i16 = this.f5448d;
                this.f5448d = i16 + 1;
                c = cArr3[i16];
                if (c < '0') {
                    z2 = z4;
                    c2 = c;
                    break;
                }
                if (c > '9') {
                    z2 = z4;
                    c2 = c;
                    break;
                }
                i14++;
                if (i15 >= cArrM6492m.length) {
                    cArrM6492m = this.f5458n.m6492m();
                    i15 = 0;
                }
                int i17 = i15;
                i15 = i17 + 1;
                cArrM6492m[i17] = c;
            }
            if (i14 == 0) {
                m6114a(c2, "Decimal point not followed by a digit");
            }
            i5 = i14;
            cArrM6492m2 = cArrM6492m;
            i6 = i15;
        }
        int i18 = 0;
        if (c2 != 'e' && c2 != 'E') {
            z3 = z2;
            c3 = c2;
            i9 = i6;
            i10 = 0;
        } else {
            if (i6 >= cArrM6492m2.length) {
                cArrM6492m2 = this.f5458n.m6492m();
                i6 = 0;
            }
            int i19 = i6 + 1;
            cArrM6492m2[i6] = c2;
            if (this.f5448d < this.f5449e) {
                char[] cArr4 = this.f5562N;
                int i20 = this.f5448d;
                this.f5448d = i20 + 1;
                cM6273e2 = cArr4[i20];
            } else {
                cM6273e2 = m6273e("expected a digit for number exponent");
            }
            if (cM6273e2 == '-' || cM6273e2 == '+') {
                if (i19 >= cArrM6492m2.length) {
                    cArrM6492m2 = this.f5458n.m6492m();
                    i7 = 0;
                } else {
                    i7 = i19;
                }
                int i21 = i7 + 1;
                cArrM6492m2[i7] = cM6273e2;
                if (this.f5448d < this.f5449e) {
                    char[] cArr5 = this.f5562N;
                    int i22 = this.f5448d;
                    this.f5448d = i22 + 1;
                    cM6273e3 = cArr5[i22];
                } else {
                    cM6273e3 = m6273e("expected a digit for number exponent");
                }
                char c6 = cM6273e3;
                i8 = i21;
                c3 = c6;
            } else {
                i8 = i19;
                c3 = cM6273e2;
            }
            while (c3 <= '9' && c3 >= '0') {
                i18++;
                if (i8 >= cArrM6492m2.length) {
                    cArrM6492m2 = this.f5458n.m6492m();
                    i8 = 0;
                }
                int i23 = i8 + 1;
                cArrM6492m2[i8] = c3;
                if (this.f5448d >= this.f5449e && !mo6118p()) {
                    i10 = i18;
                    z3 = true;
                    i9 = i23;
                    break;
                }
                char[] cArr6 = this.f5562N;
                int i24 = this.f5448d;
                this.f5448d = i24 + 1;
                c3 = cArr6[i24];
                i8 = i23;
            }
            z3 = z2;
            int i25 = i18;
            i9 = i8;
            i10 = i25;
            if (i10 == 0) {
                m6114a(c3, "Exponent indicator not followed by a digit");
            }
        }
        if (!z3) {
            this.f5448d--;
            if (this.f5456l.m6079b()) {
                m6260h(c3);
            }
        }
        this.f5458n.m6475a(i9);
        return m6111a(z, i3, i5, i10);
    }

    /* JADX INFO: renamed from: P */
    private final char m6242P() throws IOException {
        char c;
        if (this.f5448d >= this.f5449e || ((c = this.f5562N[this.f5448d]) >= '0' && c <= '9')) {
            return m6243Q();
        }
        return '0';
    }

    /* JADX INFO: renamed from: Q */
    private char m6243Q() throws IOException {
        if (this.f5448d >= this.f5449e && !mo6118p()) {
            return '0';
        }
        char c = this.f5562N[this.f5448d];
        if (c < '0' || c > '9') {
            return '0';
        }
        if (!m6062a(JsonParser.Feature.ALLOW_NUMERIC_LEADING_ZEROS)) {
            m6116b("Leading zeroes not allowed");
        }
        this.f5448d++;
        if (c == '0') {
            do {
                if (this.f5448d < this.f5449e || mo6118p()) {
                    c = this.f5562N[this.f5448d];
                    if (c < '0' || c > '9') {
                        return '0';
                    }
                    this.f5448d++;
                } else {
                    return c;
                }
            } while (c == '0');
            return c;
        }
        return c;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: InitCodeVariables
        jadx.core.utils.exceptions.JadxRuntimeException: Several immutable types in one variable: [int, char], vars: [r9v0 ??, r9v1 ??, r9v2 ??]
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVarType(InitCodeVariables.java:107)
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:83)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:74)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:57)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:45)
        	at jadx.core.dex.visitors.InitCodeVariables.visit(InitCodeVariables.java:29)
        */
    /* JADX INFO: renamed from: a */
    protected com.fasterxml.jackson.core.JsonToken m6269a(
    /*  JADX ERROR: JadxRuntimeException in pass: InitCodeVariables
        jadx.core.utils.exceptions.JadxRuntimeException: Several immutable types in one variable: [int, char], vars: [r9v0 ??, r9v1 ??, r9v2 ??]
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVarType(InitCodeVariables.java:107)
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:83)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:74)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:57)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:45)
        */
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r9v0 ??
        	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:236)
        	at jadx.core.codegen.MethodGen.addMethodArguments(MethodGen.java:224)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:169)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:407)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:337)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:303)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
        */

    /* JADX INFO: renamed from: h */
    private final void m6260h(int i) throws IOException {
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
                m6268N();
                break;
            default:
                m6136b(i);
                break;
        }
    }

    /* JADX INFO: renamed from: I */
    protected final String m6263I() throws IOException {
        int i = this.f5448d;
        int i2 = this.f5566R;
        int[] iArr = f5560L;
        while (true) {
            if (i >= this.f5449e) {
                break;
            }
            char c = this.f5562N[i];
            if (c < iArr.length && iArr[c] != 0) {
                if (c == '\"') {
                    int i3 = this.f5448d;
                    this.f5448d = i + 1;
                    return this.f5565Q.m6439a(this.f5562N, i3, i - i3, i2);
                }
            } else {
                i2 = (i2 * 33) + c;
                i++;
            }
        }
        int i4 = this.f5448d;
        this.f5448d = i;
        return m6255a(i4, i2, 34);
    }

    /* JADX INFO: renamed from: a */
    private String m6255a(int i, int i2, int i3) throws IOException {
        this.f5458n.m6477a(this.f5562N, i, this.f5448d - i);
        char[] cArrM6489j = this.f5458n.m6489j();
        int iM6491l = this.f5458n.m6491l();
        while (true) {
            if (this.f5448d >= this.f5449e && !mo6118p()) {
                m6140c(": was expecting closing '" + ((char) i3) + "' for name");
            }
            char[] cArr = this.f5562N;
            int i4 = this.f5448d;
            this.f5448d = i4 + 1;
            char cMo6108D = cArr[i4];
            if (cMo6108D <= '\\') {
                if (cMo6108D == '\\') {
                    cMo6108D = mo6108D();
                } else if (cMo6108D <= i3) {
                    if (cMo6108D != i3) {
                        if (cMo6108D < ' ') {
                            m6139c(cMo6108D, "name");
                        }
                    } else {
                        this.f5458n.m6475a(iM6491l);
                        TextBuffer textBuffer = this.f5458n;
                        return this.f5565Q.m6439a(textBuffer.m6484e(), textBuffer.m6483d(), textBuffer.m6481c(), i2);
                    }
                }
            }
            i2 = (i2 * 33) + cMo6108D;
            int i5 = iM6491l + 1;
            cArrM6489j[iM6491l] = cMo6108D;
            if (i5 >= cArrM6489j.length) {
                cArrM6489j = this.f5458n.m6492m();
                iM6491l = 0;
            } else {
                iM6491l = i5;
            }
        }
    }

    /* JADX INFO: renamed from: f */
    protected String m6275f(int i) throws IOException {
        boolean zIsJavaIdentifierPart;
        if (i == 39 && m6062a(JsonParser.Feature.ALLOW_SINGLE_QUOTES)) {
            return m6264J();
        }
        if (!m6062a(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES)) {
            m6137b(i, "was expecting double-quote to start field name");
        }
        int[] iArrM6146c = CharTypes.m6146c();
        int length = iArrM6146c.length;
        if (i < length) {
            zIsJavaIdentifierPart = iArrM6146c[i] == 0;
        } else {
            zIsJavaIdentifierPart = Character.isJavaIdentifierPart((char) i);
        }
        if (!zIsJavaIdentifierPart) {
            m6137b(i, "was expecting either valid name character (for unquoted name) or double-quote (for quoted) to start field name");
        }
        int i2 = this.f5448d;
        int i3 = this.f5566R;
        int i4 = this.f5449e;
        if (i2 < i4) {
            do {
                char c = this.f5562N[i2];
                if (c < length) {
                    if (iArrM6146c[c] != 0) {
                        int i5 = this.f5448d - 1;
                        this.f5448d = i2;
                        return this.f5565Q.m6439a(this.f5562N, i5, i2 - i5, i3);
                    }
                } else if (!Character.isJavaIdentifierPart(c)) {
                    int i6 = this.f5448d - 1;
                    this.f5448d = i2;
                    return this.f5565Q.m6439a(this.f5562N, i6, i2 - i6, i3);
                }
                i3 = (i3 * 33) + c;
                i2++;
            } while (i2 < i4);
        }
        int i7 = this.f5448d - 1;
        this.f5448d = i2;
        return m6256a(i7, i3, iArrM6146c);
    }

    /* JADX INFO: renamed from: J */
    protected String m6264J() throws IOException {
        int i = this.f5448d;
        int i2 = this.f5566R;
        int i3 = this.f5449e;
        if (i < i3) {
            int[] iArr = f5560L;
            int length = iArr.length;
            do {
                char c = this.f5562N[i];
                if (c == '\'') {
                    int i4 = this.f5448d;
                    this.f5448d = i + 1;
                    return this.f5565Q.m6439a(this.f5562N, i4, i - i4, i2);
                }
                if (c < length && iArr[c] != 0) {
                    break;
                }
                i2 = (i2 * 33) + c;
                i++;
            } while (i < i3);
        }
        int i5 = this.f5448d;
        this.f5448d = i;
        return m6255a(i5, i2, 39);
    }

    /* JADX INFO: renamed from: g */
    protected JsonToken m6277g(int i) throws IOException {
        switch (i) {
            case 39:
                if (m6062a(JsonParser.Feature.ALLOW_SINGLE_QUOTES)) {
                    return m6265K();
                }
                break;
            case 43:
                if (this.f5448d >= this.f5449e && !mo6118p()) {
                    m6131F();
                }
                char[] cArr = this.f5562N;
                int i2 = this.f5448d;
                this.f5448d = i2 + 1;
                return m6269a((int) cArr[i2], false);
            case 73:
                m6271a("Infinity", 1);
                if (m6062a(JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS)) {
                    return m6109a("Infinity", Double.POSITIVE_INFINITY);
                }
                m6141d("Non-standard token 'Infinity': enable JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS to allow");
                break;
                break;
            case 78:
                m6271a("NaN", 1);
                if (m6062a(JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS)) {
                    return m6109a("NaN", Double.NaN);
                }
                m6141d("Non-standard token 'NaN': enable JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS to allow");
                break;
                break;
        }
        if (Character.isJavaIdentifierStart(i)) {
            m6272a("" + ((char) i), "('true', 'false' or 'null')");
        }
        m6137b(i, "expected a valid value (number, String, array, object, 'true', 'false' or 'null')");
        return null;
    }

    /* JADX INFO: renamed from: K */
    protected JsonToken m6265K() throws IOException {
        char[] cArrM6490k = this.f5458n.m6490k();
        int iM6491l = this.f5458n.m6491l();
        while (true) {
            if (this.f5448d >= this.f5449e && !mo6118p()) {
                m6140c(": was expecting closing quote for a string value");
            }
            char[] cArr = this.f5562N;
            int i = this.f5448d;
            this.f5448d = i + 1;
            char cMo6108D = cArr[i];
            if (cMo6108D <= '\\') {
                if (cMo6108D == '\\') {
                    cMo6108D = mo6108D();
                } else if (cMo6108D <= '\'') {
                    if (cMo6108D != '\'') {
                        if (cMo6108D < ' ') {
                            m6139c(cMo6108D, "string value");
                        }
                    } else {
                        this.f5458n.m6475a(iM6491l);
                        return JsonToken.VALUE_STRING;
                    }
                }
            }
            if (iM6491l >= cArrM6490k.length) {
                cArrM6490k = this.f5458n.m6492m();
                iM6491l = 0;
            }
            int i2 = iM6491l;
            iM6491l = i2 + 1;
            cArrM6490k[i2] = cMo6108D;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0069 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x005a A[SYNTHETIC] */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.lang.String m6256a(int r6, int r7, int[] r8) throws java.io.IOException {
        /*
            r5 = this;
            com.fasterxml.jackson.core.util.TextBuffer r0 = r5.f5458n
            char[] r1 = r5.f5562N
            int r2 = r5.f5448d
            int r2 = r2 - r6
            r0.m6477a(r1, r6, r2)
            com.fasterxml.jackson.core.util.TextBuffer r0 = r5.f5458n
            char[] r1 = r0.m6489j()
            com.fasterxml.jackson.core.util.TextBuffer r0 = r5.f5458n
            int r0 = r0.m6491l()
            int r3 = r8.length
        L17:
            int r2 = r5.f5448d
            int r4 = r5.f5449e
            if (r2 < r4) goto L3d
            boolean r2 = r5.mo6118p()
            if (r2 != 0) goto L3d
        L23:
            com.fasterxml.jackson.core.util.TextBuffer r1 = r5.f5458n
            r1.m6475a(r0)
            com.fasterxml.jackson.core.util.TextBuffer r0 = r5.f5458n
            char[] r1 = r0.m6484e()
            int r2 = r0.m6483d()
            int r0 = r0.m6481c()
            com.fasterxml.jackson.core.sym.CharsToNameCanonicalizer r3 = r5.f5565Q
            java.lang.String r0 = r3.m6439a(r1, r2, r0, r7)
            return r0
        L3d:
            char[] r2 = r5.f5562N
            int r4 = r5.f5448d
            char r4 = r2[r4]
            if (r4 > r3) goto L62
            r2 = r8[r4]
            if (r2 != 0) goto L23
        L49:
            int r2 = r5.f5448d
            int r2 = r2 + 1
            r5.f5448d = r2
            int r2 = r7 * 33
            int r7 = r2 + r4
            int r2 = r0 + 1
            r1[r0] = r4
            int r0 = r1.length
            if (r2 < r0) goto L69
            com.fasterxml.jackson.core.util.TextBuffer r0 = r5.f5458n
            char[] r1 = r0.m6492m()
            r0 = 0
            goto L17
        L62:
            boolean r2 = java.lang.Character.isJavaIdentifierPart(r4)
            if (r2 != 0) goto L49
            goto L23
        L69:
            r0 = r2
            goto L17
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.json.ReaderBasedJsonParser.m6256a(int, int, int[]):java.lang.String");
    }

    @Override // com.fasterxml.jackson.core.base.ParserBase
    /* JADX INFO: renamed from: q */
    protected final void mo6119q() throws IOException {
        int i = this.f5448d;
        int i2 = this.f5449e;
        if (i < i2) {
            int[] iArr = f5560L;
            int length = iArr.length;
            while (true) {
                char c = this.f5562N[i];
                if (c < length && iArr[c] != 0) {
                    if (c == '\"') {
                        this.f5458n.m6477a(this.f5562N, this.f5448d, i - this.f5448d);
                        this.f5448d = i + 1;
                        return;
                    }
                } else {
                    i++;
                    if (i >= i2) {
                        break;
                    }
                }
            }
        }
        this.f5458n.m6480b(this.f5562N, this.f5448d, i - this.f5448d);
        this.f5448d = i;
        m6266L();
    }

    /* JADX INFO: renamed from: L */
    protected void m6266L() throws IOException {
        char[] cArrM6489j = this.f5458n.m6489j();
        int iM6491l = this.f5458n.m6491l();
        int[] iArr = f5560L;
        int length = iArr.length;
        while (true) {
            if (this.f5448d >= this.f5449e && !mo6118p()) {
                m6140c(": was expecting closing quote for a string value");
            }
            char[] cArr = this.f5562N;
            int i = this.f5448d;
            this.f5448d = i + 1;
            char cMo6108D = cArr[i];
            if (cMo6108D < length && iArr[cMo6108D] != 0) {
                if (cMo6108D != '\"') {
                    if (cMo6108D == '\\') {
                        cMo6108D = mo6108D();
                    } else if (cMo6108D < ' ') {
                        m6139c(cMo6108D, "string value");
                    }
                } else {
                    this.f5458n.m6475a(iM6491l);
                    return;
                }
            }
            if (iM6491l >= cArrM6489j.length) {
                cArrM6489j = this.f5458n.m6492m();
                iM6491l = 0;
            }
            int i2 = iM6491l;
            iM6491l = i2 + 1;
            cArrM6489j[i2] = cMo6108D;
        }
    }

    /* JADX INFO: renamed from: M */
    protected final void m6267M() throws IOException {
        this.f5567S = false;
        int i = this.f5448d;
        int i2 = this.f5449e;
        char[] cArr = this.f5562N;
        while (true) {
            if (i >= i2) {
                this.f5448d = i;
                if (!mo6118p()) {
                    m6140c(": was expecting closing quote for a string value");
                }
                i = this.f5448d;
                i2 = this.f5449e;
            }
            int i3 = i + 1;
            char c = cArr[i];
            if (c <= '\\') {
                if (c == '\\') {
                    this.f5448d = i3;
                    mo6108D();
                    i = this.f5448d;
                    i2 = this.f5449e;
                } else if (c <= '\"') {
                    if (c == '\"') {
                        this.f5448d = i3;
                        return;
                    } else if (c < ' ') {
                        this.f5448d = i3;
                        m6139c(c, "string value");
                    }
                }
            }
            i = i3;
        }
    }

    /* JADX INFO: renamed from: N */
    protected final void m6268N() throws IOException {
        if ((this.f5448d < this.f5449e || mo6118p()) && this.f5562N[this.f5448d] == '\n') {
            this.f5448d++;
        }
        this.f5451g++;
        this.f5452h = this.f5448d;
    }

    /* JADX INFO: renamed from: R */
    private final int m6244R() throws IOException {
        if (this.f5448d + 4 >= this.f5449e) {
            return m6253a(false);
        }
        char c = this.f5562N[this.f5448d];
        if (c == ':') {
            char[] cArr = this.f5562N;
            int i = this.f5448d + 1;
            this.f5448d = i;
            char c2 = cArr[i];
            if (c2 > ' ') {
                if (c2 == '/' || c2 == '#') {
                    return m6253a(true);
                }
                this.f5448d++;
                return c2;
            }
            if (c2 == ' ' || c2 == '\t') {
                char[] cArr2 = this.f5562N;
                int i2 = this.f5448d + 1;
                this.f5448d = i2;
                char c3 = cArr2[i2];
                if (c3 > ' ') {
                    if (c3 == '/' || c3 == '#') {
                        return m6253a(true);
                    }
                    this.f5448d++;
                    return c3;
                }
            }
            return m6253a(true);
        }
        if (c == ' ' || c == '\t') {
            char[] cArr3 = this.f5562N;
            int i3 = this.f5448d + 1;
            this.f5448d = i3;
            c = cArr3[i3];
        }
        if (c == ':') {
            char[] cArr4 = this.f5562N;
            int i4 = this.f5448d + 1;
            this.f5448d = i4;
            char c4 = cArr4[i4];
            if (c4 > ' ') {
                if (c4 == '/' || c4 == '#') {
                    return m6253a(true);
                }
                this.f5448d++;
                return c4;
            }
            if (c4 == ' ' || c4 == '\t') {
                char[] cArr5 = this.f5562N;
                int i5 = this.f5448d + 1;
                this.f5448d = i5;
                char c5 = cArr5[i5];
                if (c5 > ' ') {
                    if (c5 == '/' || c5 == '#') {
                        return m6253a(true);
                    }
                    this.f5448d++;
                    return c5;
                }
            }
            return m6253a(true);
        }
        return m6253a(false);
    }

    /* JADX INFO: renamed from: a */
    private final int m6253a(boolean z) throws IOException {
        while (true) {
            if (this.f5448d >= this.f5449e) {
                m6117o();
            }
            char[] cArr = this.f5562N;
            int i = this.f5448d;
            this.f5448d = i + 1;
            char c = cArr[i];
            if (c > ' ') {
                if (c == '/') {
                    m6248V();
                } else if (c != '#' || !m6250X()) {
                    if (z) {
                        return c;
                    }
                    if (c != ':') {
                        if (c < ' ') {
                            m6138c(c);
                        }
                        m6137b(c, "was expecting a colon to separate field name and value");
                    }
                    z = true;
                }
            } else if (c < ' ') {
                if (c == '\n') {
                    this.f5451g++;
                    this.f5452h = this.f5448d;
                } else if (c == '\r') {
                    m6268N();
                } else if (c != '\t') {
                    m6138c(c);
                }
            }
        }
    }

    /* JADX INFO: renamed from: i */
    private final int m6261i(int i) throws IOException {
        if (i != 44) {
            m6137b(i, "was expecting comma to separate " + this.f5456l.m6081d() + " entries");
        }
        while (this.f5448d < this.f5449e) {
            char[] cArr = this.f5562N;
            int i2 = this.f5448d;
            this.f5448d = i2 + 1;
            char c = cArr[i2];
            if (c > ' ') {
                if (c == '/' || c == '#') {
                    this.f5448d--;
                    return m6245S();
                }
                return c;
            }
            if (c < ' ') {
                if (c == '\n') {
                    this.f5451g++;
                    this.f5452h = this.f5448d;
                } else if (c == '\r') {
                    m6268N();
                } else if (c != '\t') {
                    m6138c(c);
                }
            }
        }
        return m6245S();
    }

    /* JADX INFO: renamed from: S */
    private final int m6245S() throws IOException {
        char c;
        while (true) {
            if (this.f5448d < this.f5449e || mo6118p()) {
                char[] cArr = this.f5562N;
                int i = this.f5448d;
                this.f5448d = i + 1;
                c = cArr[i];
                if (c > ' ') {
                    if (c == '/') {
                        m6248V();
                    } else if (c != '#' || !m6250X()) {
                        break;
                    }
                } else if (c < ' ') {
                    if (c == '\n') {
                        this.f5451g++;
                        this.f5452h = this.f5448d;
                    } else if (c == '\r') {
                        m6268N();
                    } else if (c != '\t') {
                        m6138c(c);
                    }
                }
            } else {
                throw m6060a("Unexpected end-of-input within/between " + this.f5456l.m6081d() + " entries");
            }
        }
        return c;
    }

    /* JADX INFO: renamed from: T */
    private final int m6246T() throws IOException {
        if (this.f5448d >= this.f5449e && !mo6118p()) {
            return m6123u();
        }
        char[] cArr = this.f5562N;
        int i = this.f5448d;
        this.f5448d = i + 1;
        char c = cArr[i];
        if (c > ' ') {
            if (c == '/' || c == '#') {
                this.f5448d--;
                return m6247U();
            }
            return c;
        }
        if (c != ' ') {
            if (c == '\n') {
                this.f5451g++;
                this.f5452h = this.f5448d;
            } else if (c == '\r') {
                m6268N();
            } else if (c != '\t') {
                m6138c(c);
            }
        }
        while (this.f5448d < this.f5449e) {
            char[] cArr2 = this.f5562N;
            int i2 = this.f5448d;
            this.f5448d = i2 + 1;
            char c2 = cArr2[i2];
            if (c2 > ' ') {
                if (c2 == '/' || c2 == '#') {
                    this.f5448d--;
                    return m6247U();
                }
                return c2;
            }
            if (c2 != ' ') {
                if (c2 == '\n') {
                    this.f5451g++;
                    this.f5452h = this.f5448d;
                } else if (c2 == '\r') {
                    m6268N();
                } else if (c2 != '\t') {
                    m6138c(c2);
                }
            }
        }
        return m6247U();
    }

    /* JADX INFO: renamed from: U */
    private int m6247U() throws IOException {
        while (true) {
            if (this.f5448d >= this.f5449e && !mo6118p()) {
                return m6123u();
            }
            char[] cArr = this.f5562N;
            int i = this.f5448d;
            this.f5448d = i + 1;
            char c = cArr[i];
            if (c > ' ') {
                if (c == '/') {
                    m6248V();
                } else if (c != '#' || !m6250X()) {
                    return c;
                }
            } else if (c != ' ') {
                if (c == '\n') {
                    this.f5451g++;
                    this.f5452h = this.f5448d;
                } else if (c == '\r') {
                    m6268N();
                } else if (c != '\t') {
                    m6138c(c);
                }
            }
        }
    }

    /* JADX INFO: renamed from: V */
    private void m6248V() throws IOException {
        if (!m6062a(JsonParser.Feature.ALLOW_COMMENTS)) {
            m6137b(47, "maybe a (non-standard) comment? (not recognized as one since Feature 'ALLOW_COMMENTS' not enabled for parser)");
        }
        if (this.f5448d >= this.f5449e && !mo6118p()) {
            m6140c(" in a comment");
        }
        char[] cArr = this.f5562N;
        int i = this.f5448d;
        this.f5448d = i + 1;
        char c = cArr[i];
        if (c == '/') {
            m6251Y();
        } else if (c == '*') {
            m6249W();
        } else {
            m6137b(c, "was expecting either '*' or '/' for a comment");
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0028, code lost:
    
        m6140c(" in a comment");
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x002d, code lost:
    
        return;
     */
    /* JADX INFO: renamed from: W */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void m6249W() throws java.io.IOException {
        /*
            r4 = this;
            r3 = 42
        L2:
            int r0 = r4.f5448d
            int r1 = r4.f5449e
            if (r0 < r1) goto Le
            boolean r0 = r4.mo6118p()
            if (r0 == 0) goto L28
        Le:
            char[] r0 = r4.f5562N
            int r1 = r4.f5448d
            int r2 = r1 + 1
            r4.f5448d = r2
            char r0 = r0[r1]
            if (r0 > r3) goto L2
            if (r0 != r3) goto L3f
            int r0 = r4.f5448d
            int r1 = r4.f5449e
            if (r0 < r1) goto L2e
            boolean r0 = r4.mo6118p()
            if (r0 != 0) goto L2e
        L28:
            java.lang.String r0 = " in a comment"
            r4.m6140c(r0)
        L2d:
            return
        L2e:
            char[] r0 = r4.f5562N
            int r1 = r4.f5448d
            char r0 = r0[r1]
            r1 = 47
            if (r0 != r1) goto L2
            int r0 = r4.f5448d
            int r0 = r0 + 1
            r4.f5448d = r0
            goto L2d
        L3f:
            r1 = 32
            if (r0 >= r1) goto L2
            r1 = 10
            if (r0 != r1) goto L52
            int r0 = r4.f5451g
            int r0 = r0 + 1
            r4.f5451g = r0
            int r0 = r4.f5448d
            r4.f5452h = r0
            goto L2
        L52:
            r1 = 13
            if (r0 != r1) goto L5a
            r4.m6268N()
            goto L2
        L5a:
            r1 = 9
            if (r0 == r1) goto L2
            r4.m6138c(r0)
            goto L2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.json.ReaderBasedJsonParser.m6249W():void");
    }

    /* JADX INFO: renamed from: X */
    private boolean m6250X() throws IOException {
        if (!m6062a(JsonParser.Feature.ALLOW_YAML_COMMENTS)) {
            return false;
        }
        m6251Y();
        return true;
    }

    /* JADX INFO: renamed from: Y */
    private void m6251Y() throws IOException {
        while (true) {
            if (this.f5448d < this.f5449e || mo6118p()) {
                char[] cArr = this.f5562N;
                int i = this.f5448d;
                this.f5448d = i + 1;
                char c = cArr[i];
                if (c < ' ') {
                    if (c == '\n') {
                        this.f5451g++;
                        this.f5452h = this.f5448d;
                        return;
                    } else if (c == '\r') {
                        m6268N();
                        return;
                    } else if (c != '\t') {
                        m6138c(c);
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
        int i = 0;
        if (this.f5448d >= this.f5449e && !mo6118p()) {
            m6140c(" in character escape sequence");
        }
        char[] cArr = this.f5562N;
        int i2 = this.f5448d;
        this.f5448d = i2 + 1;
        char c = cArr[i2];
        switch (c) {
            case '\"':
            case '/':
            case '\\':
                return c;
            case 'b':
                return '\b';
            case 'f':
                return '\f';
            case 'n':
                return '\n';
            case 'r':
                return TokenParser.f15712CR;
            case 't':
                return '\t';
            case 'u':
                for (int i3 = 0; i3 < 4; i3++) {
                    if (this.f5448d >= this.f5449e && !mo6118p()) {
                        m6140c(" in character escape sequence");
                    }
                    char[] cArr2 = this.f5562N;
                    int i4 = this.f5448d;
                    this.f5448d = i4 + 1;
                    char c2 = cArr2[i4];
                    int iM6142a = CharTypes.m6142a(c2);
                    if (iM6142a < 0) {
                        m6137b(c2, "expected a hex-digit for character escape sequence");
                    }
                    i = (i << 4) | iM6142a;
                }
                return (char) i;
            default:
                return m6133a(c);
        }
    }

    /* JADX INFO: renamed from: Z */
    private final void m6252Z() throws IOException {
        int i;
        char c;
        int i2 = this.f5448d;
        if (i2 + 3 < this.f5449e) {
            char[] cArr = this.f5562N;
            if (cArr[i2] == 'r') {
                int i3 = i2 + 1;
                if (cArr[i3] == 'u') {
                    int i4 = i3 + 1;
                    if (cArr[i4] == 'e' && ((c = cArr[(i = i4 + 1)]) < '0' || c == ']' || c == '}')) {
                        this.f5448d = i;
                        return;
                    }
                }
            }
        }
        m6271a(ServerProtocol.DIALOG_RETURN_SCOPES_TRUE, 1);
    }

    /* JADX INFO: renamed from: aa */
    private final void m6257aa() throws IOException {
        int i;
        char c;
        int i2 = this.f5448d;
        if (i2 + 4 < this.f5449e) {
            char[] cArr = this.f5562N;
            if (cArr[i2] == 'a') {
                int i3 = i2 + 1;
                if (cArr[i3] == 'l') {
                    int i4 = i3 + 1;
                    if (cArr[i4] == 's') {
                        int i5 = i4 + 1;
                        if (cArr[i5] == 'e' && ((c = cArr[(i = i5 + 1)]) < '0' || c == ']' || c == '}')) {
                            this.f5448d = i;
                            return;
                        }
                    }
                }
            }
        }
        m6271a("false", 1);
    }

    /* JADX INFO: renamed from: ab */
    private final void m6258ab() throws IOException {
        int i;
        char c;
        int i2 = this.f5448d;
        if (i2 + 3 < this.f5449e) {
            char[] cArr = this.f5562N;
            if (cArr[i2] == 'u') {
                int i3 = i2 + 1;
                if (cArr[i3] == 'l') {
                    int i4 = i3 + 1;
                    if (cArr[i4] == 'l' && ((c = cArr[(i = i4 + 1)]) < '0' || c == ']' || c == '}')) {
                        this.f5448d = i;
                        return;
                    }
                }
            }
        }
        m6271a("null", 1);
    }

    /* JADX INFO: renamed from: a */
    protected final void m6271a(String str, int i) throws IOException {
        char c;
        int length = str.length();
        do {
            if (this.f5448d >= this.f5449e && !mo6118p()) {
                m6276f(str.substring(0, i));
            }
            if (this.f5562N[this.f5448d] != str.charAt(i)) {
                m6276f(str.substring(0, i));
            }
            this.f5448d++;
            i++;
        } while (i < length);
        if ((this.f5448d < this.f5449e || mo6118p()) && (c = this.f5562N[this.f5448d]) >= '0' && c != ']' && c != '}' && Character.isJavaIdentifierPart(c)) {
            m6276f(str.substring(0, i));
        }
    }

    /* JADX INFO: renamed from: f */
    protected void m6276f(String str) throws IOException {
        m6272a(str, "'null', 'true', 'false' or NaN");
    }

    /* JADX INFO: renamed from: a */
    protected void m6272a(String str, String str2) throws IOException {
        StringBuilder sb = new StringBuilder(str);
        while (true) {
            if (this.f5448d >= this.f5449e && !mo6118p()) {
                break;
            }
            char c = this.f5562N[this.f5448d];
            if (!Character.isJavaIdentifierPart(c)) {
                break;
            }
            this.f5448d++;
            sb.append(c);
        }
        m6141d("Unrecognized token '" + sb.toString() + "': was expecting " + str2);
    }
}
