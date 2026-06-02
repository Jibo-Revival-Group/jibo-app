package com.fasterxml.jackson.core.base;

import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.json.DupDetector;
import com.fasterxml.jackson.core.json.JsonReadContext;
import com.fasterxml.jackson.core.p000io.IOContext;
import com.fasterxml.jackson.core.p000io.NumberInput;
import com.fasterxml.jackson.core.util.ByteArrayBuilder;
import com.fasterxml.jackson.core.util.TextBuffer;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes.dex */
public abstract class ParserBase extends ParserMinimalBase {

    /* JADX INFO: renamed from: s */
    static final BigInteger f5428s = BigInteger.valueOf(-2147483648L);

    /* JADX INFO: renamed from: t */
    static final BigInteger f5429t = BigInteger.valueOf(2147483647L);

    /* JADX INFO: renamed from: u */
    static final BigInteger f5430u = BigInteger.valueOf(Long.MIN_VALUE);

    /* JADX INFO: renamed from: v */
    static final BigInteger f5431v = BigInteger.valueOf(Long.MAX_VALUE);

    /* JADX INFO: renamed from: w */
    static final BigDecimal f5432w = new BigDecimal(f5430u);

    /* JADX INFO: renamed from: x */
    static final BigDecimal f5433x = new BigDecimal(f5431v);

    /* JADX INFO: renamed from: y */
    static final BigDecimal f5434y = new BigDecimal(f5428s);

    /* JADX INFO: renamed from: z */
    static final BigDecimal f5435z = new BigDecimal(f5429t);

    /* JADX INFO: renamed from: A */
    protected int f5436A;

    /* JADX INFO: renamed from: B */
    protected int f5437B;

    /* JADX INFO: renamed from: C */
    protected long f5438C;

    /* JADX INFO: renamed from: D */
    protected double f5439D;

    /* JADX INFO: renamed from: E */
    protected BigInteger f5440E;

    /* JADX INFO: renamed from: F */
    protected BigDecimal f5441F;

    /* JADX INFO: renamed from: G */
    protected boolean f5442G;

    /* JADX INFO: renamed from: H */
    protected int f5443H;

    /* JADX INFO: renamed from: I */
    protected int f5444I;

    /* JADX INFO: renamed from: J */
    protected int f5445J;

    /* JADX INFO: renamed from: b */
    protected final IOContext f5446b;

    /* JADX INFO: renamed from: c */
    protected boolean f5447c;

    /* JADX INFO: renamed from: d */
    protected int f5448d;

    /* JADX INFO: renamed from: e */
    protected int f5449e;

    /* JADX INFO: renamed from: f */
    protected long f5450f;

    /* JADX INFO: renamed from: g */
    protected int f5451g;

    /* JADX INFO: renamed from: h */
    protected int f5452h;

    /* JADX INFO: renamed from: i */
    protected long f5453i;

    /* JADX INFO: renamed from: j */
    protected int f5454j;

    /* JADX INFO: renamed from: k */
    protected int f5455k;

    /* JADX INFO: renamed from: l */
    protected JsonReadContext f5456l;

    /* JADX INFO: renamed from: m */
    protected JsonToken f5457m;

    /* JADX INFO: renamed from: n */
    protected final TextBuffer f5458n;

    /* JADX INFO: renamed from: o */
    protected char[] f5459o;

    /* JADX INFO: renamed from: p */
    protected boolean f5460p;

    /* JADX INFO: renamed from: q */
    protected ByteArrayBuilder f5461q;

    /* JADX INFO: renamed from: r */
    protected byte[] f5462r;

    /* JADX INFO: renamed from: p */
    protected abstract boolean mo6118p() throws IOException;

    /* JADX INFO: renamed from: q */
    protected abstract void mo6119q() throws IOException;

    /* JADX INFO: renamed from: r */
    protected abstract void mo6120r() throws IOException;

    protected ParserBase(IOContext iOContext, int i) {
        super(i);
        this.f5448d = 0;
        this.f5449e = 0;
        this.f5450f = 0L;
        this.f5451g = 1;
        this.f5452h = 0;
        this.f5453i = 0L;
        this.f5454j = 1;
        this.f5455k = 0;
        this.f5459o = null;
        this.f5460p = false;
        this.f5461q = null;
        this.f5436A = 0;
        this.f5446b = iOContext;
        this.f5458n = iOContext.m6168d();
        this.f5456l = JsonReadContext.m6222a(JsonParser.Feature.STRICT_DUPLICATE_DETECTION.enabledIn(i) ? DupDetector.m6217a(this) : null);
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    /* JADX INFO: renamed from: d */
    public String mo6065d() throws IOException {
        return (this.f5463K == JsonToken.START_OBJECT || this.f5463K == JsonToken.START_ARRAY) ? this.f5456l.m6230h().m6229g() : this.f5456l.m6229g();
    }

    @Override // com.fasterxml.jackson.core.JsonParser, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (!this.f5447c) {
            this.f5447c = true;
            try {
                mo6120r();
            } finally {
                mo6121s();
            }
        }
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    /* JADX INFO: renamed from: e */
    public JsonLocation mo6066e() {
        return new JsonLocation(this.f5446b.m6155a(), -1L, this.f5450f + ((long) this.f5448d), this.f5451g, (this.f5448d - this.f5452h) + 1);
    }

    /* JADX INFO: renamed from: o */
    protected final void m6117o() throws IOException {
        if (!mo6118p()) {
            m6130E();
        }
    }

    /* JADX INFO: renamed from: s */
    protected void mo6121s() throws IOException {
        this.f5458n.m6474a();
        char[] cArr = this.f5459o;
        if (cArr != null) {
            this.f5459o = null;
            this.f5446b.m6166c(cArr);
        }
    }

    @Override // com.fasterxml.jackson.core.base.ParserMinimalBase
    /* JADX INFO: renamed from: t */
    protected void mo6122t() throws JsonParseException {
        if (!this.f5456l.m6079b()) {
            m6140c(": expected close marker for " + this.f5456l.m6081d() + " (from " + this.f5456l.m6224a(this.f5446b.m6155a()) + ")");
        }
    }

    /* JADX INFO: renamed from: u */
    protected final int m6123u() throws JsonParseException {
        mo6122t();
        return -1;
    }

    /* JADX INFO: renamed from: a */
    protected void m6113a(int i, char c) throws JsonParseException {
        m6141d("Unexpected close marker '" + ((char) i) + "': expected '" + c + "' (for " + this.f5456l.m6081d() + " starting at " + ("" + this.f5456l.m6224a(this.f5446b.m6155a())) + ")");
    }

    /* JADX INFO: renamed from: a */
    protected final JsonToken m6111a(boolean z, int i, int i2, int i3) {
        return (i2 >= 1 || i3 >= 1) ? m6115b(z, i, i2, i3) : m6110a(z, i);
    }

    /* JADX INFO: renamed from: a */
    protected final JsonToken m6110a(boolean z, int i) {
        this.f5442G = z;
        this.f5443H = i;
        this.f5444I = 0;
        this.f5445J = 0;
        this.f5436A = 0;
        return JsonToken.VALUE_NUMBER_INT;
    }

    /* JADX INFO: renamed from: b */
    protected final JsonToken m6115b(boolean z, int i, int i2, int i3) {
        this.f5442G = z;
        this.f5443H = i;
        this.f5444I = i2;
        this.f5445J = i3;
        this.f5436A = 0;
        return JsonToken.VALUE_NUMBER_FLOAT;
    }

    /* JADX INFO: renamed from: a */
    protected final JsonToken m6109a(String str, double d) {
        this.f5458n.m6476a(str);
        this.f5439D = d;
        this.f5436A = 8;
        return JsonToken.VALUE_NUMBER_FLOAT;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    /* JADX INFO: renamed from: i */
    public int mo6070i() throws IOException {
        if ((this.f5436A & 1) == 0) {
            if (this.f5436A == 0) {
                return m6124v();
            }
            if ((this.f5436A & 1) == 0) {
                m6125w();
            }
        }
        return this.f5437B;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    /* JADX INFO: renamed from: j */
    public long mo6071j() throws IOException {
        if ((this.f5436A & 2) == 0) {
            if (this.f5436A == 0) {
                m6112a(2);
            }
            if ((this.f5436A & 2) == 0) {
                m6126x();
            }
        }
        return this.f5438C;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    /* JADX INFO: renamed from: k */
    public BigInteger mo6072k() throws IOException {
        if ((this.f5436A & 4) == 0) {
            if (this.f5436A == 0) {
                m6112a(4);
            }
            if ((this.f5436A & 4) == 0) {
                m6127y();
            }
        }
        return this.f5440E;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    /* JADX INFO: renamed from: l */
    public float mo6073l() throws IOException {
        return (float) mo6074m();
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    /* JADX INFO: renamed from: m */
    public double mo6074m() throws IOException {
        if ((this.f5436A & 8) == 0) {
            if (this.f5436A == 0) {
                m6112a(8);
            }
            if ((this.f5436A & 8) == 0) {
                m6128z();
            }
        }
        return this.f5439D;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    /* JADX INFO: renamed from: n */
    public BigDecimal mo6075n() throws IOException {
        if ((this.f5436A & 16) == 0) {
            if (this.f5436A == 0) {
                m6112a(16);
            }
            if ((this.f5436A & 16) == 0) {
                m6105A();
            }
        }
        return this.f5441F;
    }

    /* JADX INFO: renamed from: a */
    protected void m6112a(int i) throws IOException {
        if (this.f5463K == JsonToken.VALUE_NUMBER_INT) {
            char[] cArrM6484e = this.f5458n.m6484e();
            int iM6483d = this.f5458n.m6483d();
            int i2 = this.f5443H;
            if (this.f5442G) {
                iM6483d++;
            }
            if (i2 <= 9) {
                int iM6181a = NumberInput.m6181a(cArrM6484e, iM6483d, i2);
                if (this.f5442G) {
                    iM6181a = -iM6181a;
                }
                this.f5437B = iM6181a;
                this.f5436A = 1;
                return;
            }
            if (i2 <= 18) {
                long jM6184b = NumberInput.m6184b(cArrM6484e, iM6483d, i2);
                if (this.f5442G) {
                    jM6184b = -jM6184b;
                }
                if (i2 == 10) {
                    if (this.f5442G) {
                        if (jM6184b >= -2147483648L) {
                            this.f5437B = (int) jM6184b;
                            this.f5436A = 1;
                            return;
                        }
                    } else if (jM6184b <= 2147483647L) {
                        this.f5437B = (int) jM6184b;
                        this.f5436A = 1;
                        return;
                    }
                }
                this.f5438C = jM6184b;
                this.f5436A = 2;
                return;
            }
            m6103a(i, cArrM6484e, iM6483d, i2);
            return;
        }
        if (this.f5463K == JsonToken.VALUE_NUMBER_FLOAT) {
            m6104e(i);
        } else {
            m6141d("Current token (" + this.f5463K + ") not numeric, can not use numeric value accessors");
        }
    }

    /* JADX INFO: renamed from: v */
    protected int m6124v() throws IOException {
        if (this.f5463K == JsonToken.VALUE_NUMBER_INT) {
            char[] cArrM6484e = this.f5458n.m6484e();
            int iM6483d = this.f5458n.m6483d();
            int i = this.f5443H;
            if (this.f5442G) {
                iM6483d++;
            }
            if (i <= 9) {
                int iM6181a = NumberInput.m6181a(cArrM6484e, iM6483d, i);
                if (this.f5442G) {
                    iM6181a = -iM6181a;
                }
                this.f5437B = iM6181a;
                this.f5436A = 1;
                return iM6181a;
            }
        }
        m6112a(1);
        if ((this.f5436A & 1) == 0) {
            m6125w();
        }
        return this.f5437B;
    }

    /* JADX INFO: renamed from: e */
    private void m6104e(int i) throws IOException {
        try {
            if (i == 16) {
                this.f5441F = this.f5458n.m6487h();
                this.f5436A = 16;
            } else {
                this.f5439D = this.f5458n.m6488i();
                this.f5436A = 8;
            }
        } catch (NumberFormatException e) {
            m6134a("Malformed numeric value '" + this.f5458n.m6485f() + "'", e);
        }
    }

    /* JADX INFO: renamed from: a */
    private void m6103a(int i, char[] cArr, int i2, int i3) throws IOException {
        String strM6485f = this.f5458n.m6485f();
        try {
            if (NumberInput.m6183a(cArr, i2, i3, this.f5442G)) {
                this.f5438C = Long.parseLong(strM6485f);
                this.f5436A = 2;
            } else {
                this.f5440E = new BigInteger(strM6485f);
                this.f5436A = 4;
            }
        } catch (NumberFormatException e) {
            m6134a("Malformed numeric value '" + strM6485f + "'", e);
        }
    }

    /* JADX INFO: renamed from: w */
    protected void m6125w() throws IOException {
        if ((this.f5436A & 2) != 0) {
            int i = (int) this.f5438C;
            if (i != this.f5438C) {
                m6141d("Numeric value (" + mo6067f() + ") out of range of int");
            }
            this.f5437B = i;
        } else if ((this.f5436A & 4) != 0) {
            if (f5428s.compareTo(this.f5440E) > 0 || f5429t.compareTo(this.f5440E) < 0) {
                m6106B();
            }
            this.f5437B = this.f5440E.intValue();
        } else if ((this.f5436A & 8) != 0) {
            if (this.f5439D < -2.147483648E9d || this.f5439D > 2.147483647E9d) {
                m6106B();
            }
            this.f5437B = (int) this.f5439D;
        } else if ((this.f5436A & 16) != 0) {
            if (f5434y.compareTo(this.f5441F) > 0 || f5435z.compareTo(this.f5441F) < 0) {
                m6106B();
            }
            this.f5437B = this.f5441F.intValue();
        } else {
            m6132G();
        }
        this.f5436A |= 1;
    }

    /* JADX INFO: renamed from: x */
    protected void m6126x() throws IOException {
        if ((this.f5436A & 1) != 0) {
            this.f5438C = this.f5437B;
        } else if ((this.f5436A & 4) != 0) {
            if (f5430u.compareTo(this.f5440E) > 0 || f5431v.compareTo(this.f5440E) < 0) {
                m6107C();
            }
            this.f5438C = this.f5440E.longValue();
        } else if ((this.f5436A & 8) != 0) {
            if (this.f5439D < -9.223372036854776E18d || this.f5439D > 9.223372036854776E18d) {
                m6107C();
            }
            this.f5438C = (long) this.f5439D;
        } else if ((this.f5436A & 16) != 0) {
            if (f5432w.compareTo(this.f5441F) > 0 || f5433x.compareTo(this.f5441F) < 0) {
                m6107C();
            }
            this.f5438C = this.f5441F.longValue();
        } else {
            m6132G();
        }
        this.f5436A |= 2;
    }

    /* JADX INFO: renamed from: y */
    protected void m6127y() throws IOException {
        if ((this.f5436A & 16) != 0) {
            this.f5440E = this.f5441F.toBigInteger();
        } else if ((this.f5436A & 2) != 0) {
            this.f5440E = BigInteger.valueOf(this.f5438C);
        } else if ((this.f5436A & 1) != 0) {
            this.f5440E = BigInteger.valueOf(this.f5437B);
        } else if ((this.f5436A & 8) != 0) {
            this.f5440E = BigDecimal.valueOf(this.f5439D).toBigInteger();
        } else {
            m6132G();
        }
        this.f5436A |= 4;
    }

    /* JADX INFO: renamed from: z */
    protected void m6128z() throws IOException {
        if ((this.f5436A & 16) != 0) {
            this.f5439D = this.f5441F.doubleValue();
        } else if ((this.f5436A & 4) != 0) {
            this.f5439D = this.f5440E.doubleValue();
        } else if ((this.f5436A & 2) != 0) {
            this.f5439D = this.f5438C;
        } else if ((this.f5436A & 1) != 0) {
            this.f5439D = this.f5437B;
        } else {
            m6132G();
        }
        this.f5436A |= 8;
    }

    /* JADX INFO: renamed from: A */
    protected void m6105A() throws IOException {
        if ((this.f5436A & 8) != 0) {
            this.f5441F = NumberInput.m6185b(mo6067f());
        } else if ((this.f5436A & 4) != 0) {
            this.f5441F = new BigDecimal(this.f5440E);
        } else if ((this.f5436A & 2) != 0) {
            this.f5441F = BigDecimal.valueOf(this.f5438C);
        } else if ((this.f5436A & 1) != 0) {
            this.f5441F = BigDecimal.valueOf(this.f5437B);
        } else {
            m6132G();
        }
        this.f5436A |= 16;
    }

    /* JADX INFO: renamed from: a */
    protected void m6114a(int i, String str) throws JsonParseException {
        String str2 = "Unexpected character (" + m6129d(i) + ") in numeric value";
        if (str != null) {
            str2 = str2 + ": " + str;
        }
        m6141d(str2);
    }

    /* JADX INFO: renamed from: b */
    protected void m6116b(String str) throws JsonParseException {
        m6141d("Invalid numeric value: " + str);
    }

    /* JADX INFO: renamed from: B */
    protected void m6106B() throws IOException {
        m6141d("Numeric value (" + mo6067f() + ") out of range of int (-2147483648 - 2147483647)");
    }

    /* JADX INFO: renamed from: C */
    protected void m6107C() throws IOException {
        m6141d("Numeric value (" + mo6067f() + ") out of range of long (-9223372036854775808 - 9223372036854775807)");
    }

    /* JADX INFO: renamed from: D */
    protected char mo6108D() throws IOException {
        throw new UnsupportedOperationException();
    }
}
