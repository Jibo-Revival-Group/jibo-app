package com.google.gson.stream;

import com.facebook.internal.ServerProtocol;
import com.google.gson.internal.JsonReaderInternalAccess;
import com.google.gson.internal.bind.JsonTreeReader;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import org.apache.http.message.TokenParser;

/* JADX INFO: loaded from: classes.dex */
public class JsonReader implements Closeable {

    /* JADX INFO: renamed from: b */
    private static final char[] f9043b = ")]}'\n".toCharArray();

    /* JADX INFO: renamed from: c */
    private final Reader f9045c;

    /* JADX INFO: renamed from: j */
    private long f9052j;

    /* JADX INFO: renamed from: k */
    private int f9053k;

    /* JADX INFO: renamed from: l */
    private String f9054l;

    /* JADX INFO: renamed from: n */
    private int f9056n;

    /* JADX INFO: renamed from: o */
    private String[] f9057o;

    /* JADX INFO: renamed from: p */
    private int[] f9058p;

    /* JADX INFO: renamed from: d */
    private boolean f9046d = false;

    /* JADX INFO: renamed from: e */
    private final char[] f9047e = new char[1024];

    /* JADX INFO: renamed from: f */
    private int f9048f = 0;

    /* JADX INFO: renamed from: g */
    private int f9049g = 0;

    /* JADX INFO: renamed from: h */
    private int f9050h = 0;

    /* JADX INFO: renamed from: i */
    private int f9051i = 0;

    /* JADX INFO: renamed from: a */
    int f9044a = 0;

    /* JADX INFO: renamed from: m */
    private int[] f9055m = new int[32];

    static {
        JsonReaderInternalAccess.f8868a = new JsonReaderInternalAccess() { // from class: com.google.gson.stream.JsonReader.1
            @Override // com.google.gson.internal.JsonReaderInternalAccess
            /* JADX INFO: renamed from: a */
            public void mo9470a(JsonReader jsonReader) throws IOException {
                if (jsonReader instanceof JsonTreeReader) {
                    ((JsonTreeReader) jsonReader).m9520o();
                    return;
                }
                int iM9643r = jsonReader.f9044a;
                if (iM9643r == 0) {
                    iM9643r = jsonReader.m9643r();
                }
                if (iM9643r == 13) {
                    jsonReader.f9044a = 9;
                } else if (iM9643r == 12) {
                    jsonReader.f9044a = 8;
                } else {
                    if (iM9643r == 14) {
                        jsonReader.f9044a = 10;
                        return;
                    }
                    throw new IllegalStateException("Expected a name but was " + jsonReader.mo9511f() + jsonReader.m9644s());
                }
            }
        };
    }

    public JsonReader(Reader reader) {
        this.f9056n = 0;
        int[] iArr = this.f9055m;
        int i = this.f9056n;
        this.f9056n = i + 1;
        iArr[i] = 6;
        this.f9057o = new String[32];
        this.f9058p = new int[32];
        if (reader == null) {
            throw new NullPointerException("in == null");
        }
        this.f9045c = reader;
    }

    /* JADX INFO: renamed from: a */
    public final void m9641a(boolean z) {
        this.f9046d = z;
    }

    /* JADX INFO: renamed from: q */
    public final boolean m9642q() {
        return this.f9046d;
    }

    /* JADX INFO: renamed from: a */
    public void mo9506a() throws IOException {
        int iM9643r = this.f9044a;
        if (iM9643r == 0) {
            iM9643r = m9643r();
        }
        if (iM9643r == 3) {
            m9625a(1);
            this.f9058p[this.f9056n - 1] = 0;
            this.f9044a = 0;
            return;
        }
        throw new IllegalStateException("Expected BEGIN_ARRAY but was " + mo9511f() + m9644s());
    }

    /* JADX INFO: renamed from: b */
    public void mo9507b() throws IOException {
        int iM9643r = this.f9044a;
        if (iM9643r == 0) {
            iM9643r = m9643r();
        }
        if (iM9643r == 4) {
            this.f9056n--;
            int[] iArr = this.f9058p;
            int i = this.f9056n - 1;
            iArr[i] = iArr[i] + 1;
            this.f9044a = 0;
            return;
        }
        throw new IllegalStateException("Expected END_ARRAY but was " + mo9511f() + m9644s());
    }

    /* JADX INFO: renamed from: c */
    public void mo9508c() throws IOException {
        int iM9643r = this.f9044a;
        if (iM9643r == 0) {
            iM9643r = m9643r();
        }
        if (iM9643r == 1) {
            m9625a(3);
            this.f9044a = 0;
            return;
        }
        throw new IllegalStateException("Expected BEGIN_OBJECT but was " + mo9511f() + m9644s());
    }

    /* JADX INFO: renamed from: d */
    public void mo9509d() throws IOException {
        int iM9643r = this.f9044a;
        if (iM9643r == 0) {
            iM9643r = m9643r();
        }
        if (iM9643r == 2) {
            this.f9056n--;
            this.f9057o[this.f9056n] = null;
            int[] iArr = this.f9058p;
            int i = this.f9056n - 1;
            iArr[i] = iArr[i] + 1;
            this.f9044a = 0;
            return;
        }
        throw new IllegalStateException("Expected END_OBJECT but was " + mo9511f() + m9644s());
    }

    /* JADX INFO: renamed from: e */
    public boolean mo9510e() throws IOException {
        int iM9643r = this.f9044a;
        if (iM9643r == 0) {
            iM9643r = m9643r();
        }
        return (iM9643r == 2 || iM9643r == 4) ? false : true;
    }

    /* JADX INFO: renamed from: f */
    public JsonToken mo9511f() throws IOException {
        int iM9643r = this.f9044a;
        if (iM9643r == 0) {
            iM9643r = m9643r();
        }
        switch (iM9643r) {
            case 1:
                return JsonToken.BEGIN_OBJECT;
            case 2:
                return JsonToken.END_OBJECT;
            case 3:
                return JsonToken.BEGIN_ARRAY;
            case 4:
                return JsonToken.END_ARRAY;
            case 5:
            case 6:
                return JsonToken.BOOLEAN;
            case 7:
                return JsonToken.NULL;
            case 8:
            case 9:
            case 10:
            case 11:
                return JsonToken.STRING;
            case 12:
            case 13:
            case 14:
                return JsonToken.NAME;
            case 15:
            case 16:
                return JsonToken.NUMBER;
            case 17:
                return JsonToken.END_DOCUMENT;
            default:
                throw new AssertionError();
        }
    }

    /* JADX INFO: renamed from: r */
    int m9643r() throws IOException {
        int i = this.f9055m[this.f9056n - 1];
        if (i == 1) {
            this.f9055m[this.f9056n - 1] = 2;
        } else if (i == 2) {
            switch (m9628b(true)) {
                case 44:
                    break;
                case 59:
                    m9637w();
                    break;
                case 93:
                    this.f9044a = 4;
                    return 4;
                default:
                    throw m9629b("Unterminated array");
            }
        } else {
            if (i == 3 || i == 5) {
                this.f9055m[this.f9056n - 1] = 4;
                if (i == 5) {
                    switch (m9628b(true)) {
                        case 44:
                            break;
                        case 59:
                            m9637w();
                            break;
                        case 125:
                            this.f9044a = 2;
                            return 2;
                        default:
                            throw m9629b("Unterminated object");
                    }
                }
                int iM9628b = m9628b(true);
                switch (iM9628b) {
                    case 34:
                        this.f9044a = 13;
                        return 13;
                    case 39:
                        m9637w();
                        this.f9044a = 12;
                        return 12;
                    case 125:
                        if (i != 5) {
                            this.f9044a = 2;
                            return 2;
                        }
                        throw m9629b("Expected name");
                    default:
                        m9637w();
                        this.f9048f--;
                        if (m9626a((char) iM9628b)) {
                            this.f9044a = 14;
                            return 14;
                        }
                        throw m9629b("Expected name");
                }
            }
            if (i == 4) {
                this.f9055m[this.f9056n - 1] = 5;
                switch (m9628b(true)) {
                    case 58:
                        break;
                    case 59:
                    case 60:
                    default:
                        throw m9629b("Expected ':'");
                    case 61:
                        m9637w();
                        if ((this.f9048f < this.f9049g || m9631b(1)) && this.f9047e[this.f9048f] == '>') {
                            this.f9048f++;
                        }
                        break;
                }
            } else if (i == 6) {
                if (this.f9046d) {
                    m9640z();
                }
                this.f9055m[this.f9056n - 1] = 7;
            } else if (i == 7) {
                if (m9628b(false) == -1) {
                    this.f9044a = 17;
                    return 17;
                }
                m9637w();
                this.f9048f--;
            } else if (i == 8) {
                throw new IllegalStateException("JsonReader is closed");
            }
        }
        switch (m9628b(true)) {
            case 34:
                this.f9044a = 9;
                return 9;
            case 39:
                m9637w();
                this.f9044a = 8;
                return 8;
            case 44:
            case 59:
                break;
            case 91:
                this.f9044a = 3;
                return 3;
            case 93:
                if (i == 1) {
                    this.f9044a = 4;
                    return 4;
                }
                break;
            case 123:
                this.f9044a = 1;
                return 1;
            default:
                this.f9048f--;
                int iM9633o = m9633o();
                if (iM9633o == 0) {
                    int iM9634t = m9634t();
                    if (iM9634t == 0) {
                        if (!m9626a(this.f9047e[this.f9048f])) {
                            throw m9629b("Expected value");
                        }
                        m9637w();
                        this.f9044a = 10;
                        return 10;
                    }
                    return iM9634t;
                }
                return iM9633o;
        }
        if (i == 1 || i == 2) {
            m9637w();
            this.f9048f--;
            this.f9044a = 7;
            return 7;
        }
        throw m9629b("Unexpected value");
    }

    /* JADX INFO: renamed from: o */
    private int m9633o() throws IOException {
        String str;
        String str2;
        int i;
        char c = this.f9047e[this.f9048f];
        if (c == 't' || c == 'T') {
            str = ServerProtocol.DIALOG_RETURN_SCOPES_TRUE;
            str2 = "TRUE";
            i = 5;
        } else if (c == 'f' || c == 'F') {
            str = "false";
            str2 = "FALSE";
            i = 6;
        } else {
            if (c != 'n' && c != 'N') {
                return 0;
            }
            str = "null";
            str2 = "NULL";
            i = 7;
        }
        int length = str.length();
        for (int i2 = 1; i2 < length; i2++) {
            if (this.f9048f + i2 >= this.f9049g && !m9631b(i2 + 1)) {
                return 0;
            }
            char c2 = this.f9047e[this.f9048f + i2];
            if (c2 != str.charAt(i2) && c2 != str2.charAt(i2)) {
                return 0;
            }
        }
        if ((this.f9048f + length < this.f9049g || m9631b(length + 1)) && m9626a(this.f9047e[this.f9048f + length])) {
            return 0;
        }
        this.f9048f += length;
        this.f9044a = i;
        return i;
    }

    /* JADX WARN: Code restructure failed: missing block: B:108:?, code lost:
    
        return 15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:?, code lost:
    
        return 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0021, code lost:
    
        if (r3 != 2) goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0023, code lost:
    
        if (r4 == false) goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0029, code lost:
    
        if (r6 != Long.MIN_VALUE) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x002b, code lost:
    
        if (r5 == false) goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0031, code lost:
    
        if (r6 != 0) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0033, code lost:
    
        if (r5 != false) goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0035, code lost:
    
        if (r5 == false) goto L79;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0037, code lost:
    
        r15.f9052j = r6;
        r15.f9048f += r10;
        r15.f9044a = 15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x005a, code lost:
    
        if (m9626a(r2) == false) goto L11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x005c, code lost:
    
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x00e4, code lost:
    
        r6 = -r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x00e8, code lost:
    
        if (r3 == 2) goto L86;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x00eb, code lost:
    
        if (r3 == 4) goto L86;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x00ee, code lost:
    
        if (r3 != 7) goto L87;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x00f0, code lost:
    
        r15.f9053k = r10;
        r15.f9044a = 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x00f8, code lost:
    
        return 0;
     */
    /* JADX WARN: Removed duplicated region for block: B:25:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x008a  */
    /* JADX INFO: renamed from: t */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private int m9634t() throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 278
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.stream.JsonReader.m9634t():int");
    }

    /* JADX INFO: renamed from: a */
    private boolean m9626a(char c) throws IOException {
        switch (c) {
            case '#':
            case '/':
            case ';':
            case '=':
            case '\\':
                m9637w();
            case '\t':
            case '\n':
            case '\f':
            case '\r':
            case ' ':
            case ',':
            case ':':
            case '[':
            case ']':
            case '{':
            case '}':
                return false;
            default:
                return true;
        }
    }

    /* JADX INFO: renamed from: g */
    public String mo9512g() throws IOException {
        String strM9630b;
        int iM9643r = this.f9044a;
        if (iM9643r == 0) {
            iM9643r = m9643r();
        }
        if (iM9643r == 14) {
            strM9630b = m9635u();
        } else if (iM9643r == 12) {
            strM9630b = m9630b('\'');
        } else if (iM9643r == 13) {
            strM9630b = m9630b(TokenParser.DQUOTE);
        } else {
            throw new IllegalStateException("Expected a name but was " + mo9511f() + m9644s());
        }
        this.f9044a = 0;
        this.f9057o[this.f9056n - 1] = strM9630b;
        return strM9630b;
    }

    /* JADX INFO: renamed from: h */
    public String mo9513h() throws IOException {
        String str;
        int iM9643r = this.f9044a;
        if (iM9643r == 0) {
            iM9643r = m9643r();
        }
        if (iM9643r == 10) {
            str = m9635u();
        } else if (iM9643r == 8) {
            str = m9630b('\'');
        } else if (iM9643r == 9) {
            str = m9630b(TokenParser.DQUOTE);
        } else if (iM9643r == 11) {
            str = this.f9054l;
            this.f9054l = null;
        } else if (iM9643r == 15) {
            str = Long.toString(this.f9052j);
        } else if (iM9643r == 16) {
            str = new String(this.f9047e, this.f9048f, this.f9053k);
            this.f9048f += this.f9053k;
        } else {
            throw new IllegalStateException("Expected a string but was " + mo9511f() + m9644s());
        }
        this.f9044a = 0;
        int[] iArr = this.f9058p;
        int i = this.f9056n - 1;
        iArr[i] = iArr[i] + 1;
        return str;
    }

    /* JADX INFO: renamed from: i */
    public boolean mo9514i() throws IOException {
        int iM9643r = this.f9044a;
        if (iM9643r == 0) {
            iM9643r = m9643r();
        }
        if (iM9643r == 5) {
            this.f9044a = 0;
            int[] iArr = this.f9058p;
            int i = this.f9056n - 1;
            iArr[i] = iArr[i] + 1;
            return true;
        }
        if (iM9643r == 6) {
            this.f9044a = 0;
            int[] iArr2 = this.f9058p;
            int i2 = this.f9056n - 1;
            iArr2[i2] = iArr2[i2] + 1;
            return false;
        }
        throw new IllegalStateException("Expected a boolean but was " + mo9511f() + m9644s());
    }

    /* JADX INFO: renamed from: j */
    public void mo9515j() throws IOException {
        int iM9643r = this.f9044a;
        if (iM9643r == 0) {
            iM9643r = m9643r();
        }
        if (iM9643r == 7) {
            this.f9044a = 0;
            int[] iArr = this.f9058p;
            int i = this.f9056n - 1;
            iArr[i] = iArr[i] + 1;
            return;
        }
        throw new IllegalStateException("Expected null but was " + mo9511f() + m9644s());
    }

    /* JADX INFO: renamed from: k */
    public double mo9516k() throws IOException {
        int iM9643r = this.f9044a;
        if (iM9643r == 0) {
            iM9643r = m9643r();
        }
        if (iM9643r == 15) {
            this.f9044a = 0;
            int[] iArr = this.f9058p;
            int i = this.f9056n - 1;
            iArr[i] = iArr[i] + 1;
            return this.f9052j;
        }
        if (iM9643r == 16) {
            this.f9054l = new String(this.f9047e, this.f9048f, this.f9053k);
            this.f9048f += this.f9053k;
        } else if (iM9643r == 8 || iM9643r == 9) {
            this.f9054l = m9630b(iM9643r == 8 ? '\'' : TokenParser.DQUOTE);
        } else if (iM9643r == 10) {
            this.f9054l = m9635u();
        } else if (iM9643r != 11) {
            throw new IllegalStateException("Expected a double but was " + mo9511f() + m9644s());
        }
        this.f9044a = 11;
        double d = Double.parseDouble(this.f9054l);
        if (!this.f9046d && (Double.isNaN(d) || Double.isInfinite(d))) {
            throw new MalformedJsonException("JSON forbids NaN and infinities: " + d + m9644s());
        }
        this.f9054l = null;
        this.f9044a = 0;
        int[] iArr2 = this.f9058p;
        int i2 = this.f9056n - 1;
        iArr2[i2] = iArr2[i2] + 1;
        return d;
    }

    /* JADX INFO: renamed from: l */
    public long mo9517l() throws IOException {
        int iM9643r = this.f9044a;
        if (iM9643r == 0) {
            iM9643r = m9643r();
        }
        if (iM9643r == 15) {
            this.f9044a = 0;
            int[] iArr = this.f9058p;
            int i = this.f9056n - 1;
            iArr[i] = iArr[i] + 1;
            return this.f9052j;
        }
        if (iM9643r == 16) {
            this.f9054l = new String(this.f9047e, this.f9048f, this.f9053k);
            this.f9048f += this.f9053k;
        } else if (iM9643r == 8 || iM9643r == 9 || iM9643r == 10) {
            if (iM9643r == 10) {
                this.f9054l = m9635u();
            } else {
                this.f9054l = m9630b(iM9643r == 8 ? '\'' : TokenParser.DQUOTE);
            }
            try {
                long j = Long.parseLong(this.f9054l);
                this.f9044a = 0;
                int[] iArr2 = this.f9058p;
                int i2 = this.f9056n - 1;
                iArr2[i2] = iArr2[i2] + 1;
                return j;
            } catch (NumberFormatException e) {
            }
        } else {
            throw new IllegalStateException("Expected a long but was " + mo9511f() + m9644s());
        }
        this.f9044a = 11;
        double d = Double.parseDouble(this.f9054l);
        long j2 = (long) d;
        if (j2 != d) {
            throw new NumberFormatException("Expected a long but was " + this.f9054l + m9644s());
        }
        this.f9054l = null;
        this.f9044a = 0;
        int[] iArr3 = this.f9058p;
        int i3 = this.f9056n - 1;
        iArr3[i3] = iArr3[i3] + 1;
        return j2;
    }

    /* JADX INFO: renamed from: b */
    private String m9630b(char c) throws IOException {
        int i;
        int i2;
        StringBuilder sb;
        int i3;
        char[] cArr = this.f9047e;
        StringBuilder sb2 = null;
        do {
            int i4 = this.f9048f;
            int i5 = this.f9049g;
            int i6 = i4;
            while (i6 < i5) {
                int i7 = i6 + 1;
                char c2 = cArr[i6];
                if (c2 == c) {
                    this.f9048f = i7;
                    int i8 = (i7 - i4) - 1;
                    if (sb2 == null) {
                        return new String(cArr, i4, i8);
                    }
                    sb2.append(cArr, i4, i8);
                    return sb2.toString();
                }
                if (c2 == '\\') {
                    this.f9048f = i7;
                    int i9 = (i7 - i4) - 1;
                    if (sb2 == null) {
                        sb2 = new StringBuilder(Math.max((i9 + 1) * 2, 16));
                    }
                    sb2.append(cArr, i4, i9);
                    sb2.append(m9639y());
                    int i10 = this.f9048f;
                    sb = sb2;
                    i3 = i10;
                    i = this.f9049g;
                    i2 = i10;
                } else {
                    if (c2 == '\n') {
                        this.f9050h++;
                        this.f9051i = i7;
                    }
                    int i11 = i4;
                    i = i5;
                    i2 = i7;
                    sb = sb2;
                    i3 = i11;
                }
                i6 = i2;
                i5 = i;
                i4 = i3;
                sb2 = sb;
            }
            if (sb2 == null) {
                sb2 = new StringBuilder(Math.max((i6 - i4) * 2, 16));
            }
            sb2.append(cArr, i4, i6 - i4);
            this.f9048f = i6;
        } while (m9631b(1));
        throw m9629b("Unterminated string");
    }

    /* JADX INFO: renamed from: u */
    private String m9635u() throws IOException {
        StringBuilder sb = null;
        int i = 0;
        while (true) {
            if (this.f9048f + i < this.f9049g) {
                switch (this.f9047e[this.f9048f + i]) {
                    case '\t':
                    case '\n':
                    case '\f':
                    case '\r':
                    case ' ':
                    case ',':
                    case ':':
                    case '[':
                    case ']':
                    case '{':
                    case '}':
                        break;
                    case '#':
                    case '/':
                    case ';':
                    case '=':
                    case '\\':
                        m9637w();
                        break;
                    default:
                        i++;
                        continue;
                }
            } else if (i < this.f9047e.length) {
                if (m9631b(i + 1)) {
                }
            } else {
                if (sb == null) {
                    sb = new StringBuilder(Math.max(i, 16));
                }
                sb.append(this.f9047e, this.f9048f, i);
                this.f9048f = i + this.f9048f;
                if (m9631b(1)) {
                    i = 0;
                } else {
                    i = 0;
                }
            }
        }
        String str = sb == null ? new String(this.f9047e, this.f9048f, i) : sb.append(this.f9047e, this.f9048f, i).toString();
        this.f9048f = i + this.f9048f;
        return str;
    }

    /* JADX INFO: renamed from: c */
    private void m9632c(char c) throws IOException {
        char[] cArr = this.f9047e;
        do {
            int i = this.f9048f;
            int i2 = this.f9049g;
            int i3 = i;
            while (i3 < i2) {
                int i4 = i3 + 1;
                char c2 = cArr[i3];
                if (c2 == c) {
                    this.f9048f = i4;
                    return;
                }
                if (c2 == '\\') {
                    this.f9048f = i4;
                    m9639y();
                    i4 = this.f9048f;
                    i2 = this.f9049g;
                } else if (c2 == '\n') {
                    this.f9050h++;
                    this.f9051i = i4;
                }
                i3 = i4;
            }
            this.f9048f = i3;
        } while (m9631b(1));
        throw m9629b("Unterminated string");
    }

    /* JADX INFO: renamed from: v */
    private void m9636v() throws IOException {
        do {
            int i = 0;
            while (this.f9048f + i < this.f9049g) {
                switch (this.f9047e[this.f9048f + i]) {
                    case '\t':
                    case '\n':
                    case '\f':
                    case '\r':
                    case ' ':
                    case ',':
                    case ':':
                    case '[':
                    case ']':
                    case '{':
                    case '}':
                        break;
                    case '#':
                    case '/':
                    case ';':
                    case '=':
                    case '\\':
                        m9637w();
                        break;
                    default:
                        i++;
                        break;
                }
                this.f9048f = i + this.f9048f;
                return;
            }
            this.f9048f = i + this.f9048f;
        } while (m9631b(1));
    }

    /* JADX INFO: renamed from: m */
    public int mo9518m() throws IOException {
        int iM9643r = this.f9044a;
        if (iM9643r == 0) {
            iM9643r = m9643r();
        }
        if (iM9643r == 15) {
            int i = (int) this.f9052j;
            if (this.f9052j != i) {
                throw new NumberFormatException("Expected an int but was " + this.f9052j + m9644s());
            }
            this.f9044a = 0;
            int[] iArr = this.f9058p;
            int i2 = this.f9056n - 1;
            iArr[i2] = iArr[i2] + 1;
            return i;
        }
        if (iM9643r == 16) {
            this.f9054l = new String(this.f9047e, this.f9048f, this.f9053k);
            this.f9048f += this.f9053k;
        } else if (iM9643r == 8 || iM9643r == 9 || iM9643r == 10) {
            if (iM9643r == 10) {
                this.f9054l = m9635u();
            } else {
                this.f9054l = m9630b(iM9643r == 8 ? '\'' : TokenParser.DQUOTE);
            }
            try {
                int i3 = Integer.parseInt(this.f9054l);
                this.f9044a = 0;
                int[] iArr2 = this.f9058p;
                int i4 = this.f9056n - 1;
                iArr2[i4] = iArr2[i4] + 1;
                return i3;
            } catch (NumberFormatException e) {
            }
        } else {
            throw new IllegalStateException("Expected an int but was " + mo9511f() + m9644s());
        }
        this.f9044a = 11;
        double d = Double.parseDouble(this.f9054l);
        int i5 = (int) d;
        if (i5 != d) {
            throw new NumberFormatException("Expected an int but was " + this.f9054l + m9644s());
        }
        this.f9054l = null;
        this.f9044a = 0;
        int[] iArr3 = this.f9058p;
        int i6 = this.f9056n - 1;
        iArr3[i6] = iArr3[i6] + 1;
        return i5;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f9044a = 0;
        this.f9055m[0] = 8;
        this.f9056n = 1;
        this.f9045c.close();
    }

    /* JADX INFO: renamed from: n */
    public void mo9519n() throws IOException {
        int i = 0;
        do {
            int iM9643r = this.f9044a;
            if (iM9643r == 0) {
                iM9643r = m9643r();
            }
            if (iM9643r == 3) {
                m9625a(1);
                i++;
            } else if (iM9643r == 1) {
                m9625a(3);
                i++;
            } else if (iM9643r == 4 || iM9643r == 2) {
                this.f9056n--;
                i--;
            } else if (iM9643r == 14 || iM9643r == 10) {
                m9636v();
            } else if (iM9643r == 8 || iM9643r == 12) {
                m9632c('\'');
            } else if (iM9643r == 9 || iM9643r == 13) {
                m9632c(TokenParser.DQUOTE);
            } else if (iM9643r == 16) {
                this.f9048f += this.f9053k;
            }
            this.f9044a = 0;
        } while (i != 0);
        int[] iArr = this.f9058p;
        int i2 = this.f9056n - 1;
        iArr[i2] = iArr[i2] + 1;
        this.f9057o[this.f9056n - 1] = "null";
    }

    /* JADX INFO: renamed from: a */
    private void m9625a(int i) {
        if (this.f9056n == this.f9055m.length) {
            int[] iArr = new int[this.f9056n * 2];
            int[] iArr2 = new int[this.f9056n * 2];
            String[] strArr = new String[this.f9056n * 2];
            System.arraycopy(this.f9055m, 0, iArr, 0, this.f9056n);
            System.arraycopy(this.f9058p, 0, iArr2, 0, this.f9056n);
            System.arraycopy(this.f9057o, 0, strArr, 0, this.f9056n);
            this.f9055m = iArr;
            this.f9058p = iArr2;
            this.f9057o = strArr;
        }
        int[] iArr3 = this.f9055m;
        int i2 = this.f9056n;
        this.f9056n = i2 + 1;
        iArr3[i2] = i;
    }

    /* JADX INFO: renamed from: b */
    private boolean m9631b(int i) throws IOException {
        char[] cArr = this.f9047e;
        this.f9051i -= this.f9048f;
        if (this.f9049g != this.f9048f) {
            this.f9049g -= this.f9048f;
            System.arraycopy(cArr, this.f9048f, cArr, 0, this.f9049g);
        } else {
            this.f9049g = 0;
        }
        this.f9048f = 0;
        do {
            int i2 = this.f9045c.read(cArr, this.f9049g, cArr.length - this.f9049g);
            if (i2 == -1) {
                return false;
            }
            this.f9049g = i2 + this.f9049g;
            if (this.f9050h == 0 && this.f9051i == 0 && this.f9049g > 0 && cArr[0] == 65279) {
                this.f9048f++;
                this.f9051i++;
                i++;
            }
        } while (this.f9049g < i);
        return true;
    }

    /* JADX INFO: renamed from: b */
    private int m9628b(boolean z) throws IOException {
        char[] cArr = this.f9047e;
        int i = this.f9048f;
        int i2 = this.f9049g;
        while (true) {
            if (i == i2) {
                this.f9048f = i;
                if (m9631b(1)) {
                    i = this.f9048f;
                    i2 = this.f9049g;
                } else {
                    if (z) {
                        throw new EOFException("End of input" + m9644s());
                    }
                    return -1;
                }
            }
            int i3 = i + 1;
            char c = cArr[i];
            if (c == '\n') {
                this.f9050h++;
                this.f9051i = i3;
                i = i3;
            } else if (c == ' ' || c == '\r') {
                i = i3;
            } else if (c == '\t') {
                i = i3;
            } else if (c == '/') {
                this.f9048f = i3;
                if (i3 == i2) {
                    this.f9048f--;
                    boolean zM9631b = m9631b(2);
                    this.f9048f++;
                    if (!zM9631b) {
                        return c;
                    }
                }
                m9637w();
                switch (cArr[this.f9048f]) {
                    case '*':
                        this.f9048f++;
                        if (!m9627a("*/")) {
                            throw m9629b("Unterminated comment");
                        }
                        i = this.f9048f + 2;
                        i2 = this.f9049g;
                        break;
                        break;
                    case '/':
                        this.f9048f++;
                        m9638x();
                        i = this.f9048f;
                        i2 = this.f9049g;
                        break;
                    default:
                        return c;
                }
            } else if (c == '#') {
                this.f9048f = i3;
                m9637w();
                m9638x();
                i = this.f9048f;
                i2 = this.f9049g;
            } else {
                this.f9048f = i3;
                return c;
            }
        }
    }

    /* JADX INFO: renamed from: w */
    private void m9637w() throws IOException {
        if (!this.f9046d) {
            throw m9629b("Use JsonReader.setLenient(true) to accept malformed JSON");
        }
    }

    /* JADX INFO: renamed from: x */
    private void m9638x() throws IOException {
        char c;
        do {
            if (this.f9048f < this.f9049g || m9631b(1)) {
                char[] cArr = this.f9047e;
                int i = this.f9048f;
                this.f9048f = i + 1;
                c = cArr[i];
                if (c == '\n') {
                    this.f9050h++;
                    this.f9051i = this.f9048f;
                    return;
                }
            } else {
                return;
            }
        } while (c != '\r');
    }

    /* JADX INFO: renamed from: a */
    private boolean m9627a(String str) throws IOException {
        int i;
        int length = str.length();
        while (true) {
            if (this.f9048f + length > this.f9049g && !m9631b(length)) {
                return false;
            }
            if (this.f9047e[this.f9048f] == '\n') {
                this.f9050h++;
                this.f9051i = this.f9048f + 1;
            } else {
                for (0; i < length; i + 1) {
                    i = this.f9047e[this.f9048f + i] == str.charAt(i) ? i + 1 : 0;
                }
                return true;
            }
            this.f9048f++;
        }
    }

    public String toString() {
        return getClass().getSimpleName() + m9644s();
    }

    /* JADX INFO: renamed from: s */
    String m9644s() {
        return " at line " + (this.f9050h + 1) + " column " + ((this.f9048f - this.f9051i) + 1) + " path " + mo9521p();
    }

    /* JADX INFO: renamed from: p */
    public String mo9521p() {
        StringBuilder sbAppend = new StringBuilder().append('$');
        int i = this.f9056n;
        for (int i2 = 0; i2 < i; i2++) {
            switch (this.f9055m[i2]) {
                case 1:
                case 2:
                    sbAppend.append('[').append(this.f9058p[i2]).append(']');
                    break;
                case 3:
                case 4:
                case 5:
                    sbAppend.append('.');
                    if (this.f9057o[i2] != null) {
                        sbAppend.append(this.f9057o[i2]);
                    }
                    break;
            }
        }
        return sbAppend.toString();
    }

    /* JADX INFO: renamed from: y */
    private char m9639y() throws IOException {
        int i;
        if (this.f9048f == this.f9049g && !m9631b(1)) {
            throw m9629b("Unterminated escape sequence");
        }
        char[] cArr = this.f9047e;
        int i2 = this.f9048f;
        this.f9048f = i2 + 1;
        char c = cArr[i2];
        switch (c) {
            case '\n':
                this.f9050h++;
                this.f9051i = this.f9048f;
                return c;
            case '\"':
            case '\'':
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
                if (this.f9048f + 4 > this.f9049g && !m9631b(4)) {
                    throw m9629b("Unterminated escape sequence");
                }
                int i3 = this.f9048f;
                int i4 = i3 + 4;
                char c2 = 0;
                for (int i5 = i3; i5 < i4; i5++) {
                    char c3 = this.f9047e[i5];
                    char c4 = (char) (c2 << 4);
                    if (c3 >= '0' && c3 <= '9') {
                        i = c3 - '0';
                    } else if (c3 >= 'a' && c3 <= 'f') {
                        i = (c3 - 'a') + 10;
                    } else if (c3 >= 'A' && c3 <= 'F') {
                        i = (c3 - 'A') + 10;
                    } else {
                        throw new NumberFormatException("\\u" + new String(this.f9047e, this.f9048f, 4));
                    }
                    c2 = (char) (c4 + i);
                }
                this.f9048f += 4;
                return c2;
            default:
                throw m9629b("Invalid escape sequence");
        }
    }

    /* JADX INFO: renamed from: b */
    private IOException m9629b(String str) throws IOException {
        throw new MalformedJsonException(str + m9644s());
    }

    /* JADX INFO: renamed from: z */
    private void m9640z() throws IOException {
        m9628b(true);
        this.f9048f--;
        if (this.f9048f + f9043b.length <= this.f9049g || m9631b(f9043b.length)) {
            for (int i = 0; i < f9043b.length; i++) {
                if (this.f9047e[this.f9048f + i] != f9043b[i]) {
                    return;
                }
            }
            this.f9048f += f9043b.length;
        }
    }
}
