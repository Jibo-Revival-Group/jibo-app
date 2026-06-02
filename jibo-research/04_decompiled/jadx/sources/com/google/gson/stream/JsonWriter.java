package com.google.gson.stream;

import com.facebook.internal.ServerProtocol;
import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;

/* JADX INFO: loaded from: classes.dex */
public class JsonWriter implements Closeable, Flushable {

    /* JADX INFO: renamed from: a */
    private static final String[] f9059a = new String[128];

    /* JADX INFO: renamed from: b */
    private static final String[] f9060b;

    /* JADX INFO: renamed from: c */
    private final Writer f9061c;

    /* JADX INFO: renamed from: d */
    private int[] f9062d = new int[32];

    /* JADX INFO: renamed from: e */
    private int f9063e = 0;

    /* JADX INFO: renamed from: f */
    private String f9064f;

    /* JADX INFO: renamed from: g */
    private String f9065g;

    /* JADX INFO: renamed from: h */
    private boolean f9066h;

    /* JADX INFO: renamed from: i */
    private boolean f9067i;

    /* JADX INFO: renamed from: j */
    private String f9068j;

    /* JADX INFO: renamed from: k */
    private boolean f9069k;

    static {
        for (int i = 0; i <= 31; i++) {
            f9059a[i] = String.format("\\u%04x", Integer.valueOf(i));
        }
        f9059a[34] = "\\\"";
        f9059a[92] = "\\\\";
        f9059a[9] = "\\t";
        f9059a[8] = "\\b";
        f9059a[10] = "\\n";
        f9059a[13] = "\\r";
        f9059a[12] = "\\f";
        f9060b = (String[]) f9059a.clone();
        f9060b[60] = "\\u003c";
        f9060b[62] = "\\u003e";
        f9060b[38] = "\\u0026";
        f9060b[61] = "\\u003d";
        f9060b[39] = "\\u0027";
    }

    public JsonWriter(Writer writer) {
        m9648a(6);
        this.f9065g = ":";
        this.f9069k = true;
        if (writer == null) {
            throw new NullPointerException("out == null");
        }
        this.f9061c = writer;
    }

    /* JADX INFO: renamed from: c */
    public final void m9656c(String str) {
        if (str.length() == 0) {
            this.f9064f = null;
            this.f9065g = ":";
        } else {
            this.f9064f = str;
            this.f9065g = ": ";
        }
    }

    /* JADX INFO: renamed from: b */
    public final void m9655b(boolean z) {
        this.f9066h = z;
    }

    /* JADX INFO: renamed from: g */
    public boolean m9659g() {
        return this.f9066h;
    }

    /* JADX INFO: renamed from: c */
    public final void m9657c(boolean z) {
        this.f9067i = z;
    }

    /* JADX INFO: renamed from: h */
    public final boolean m9660h() {
        return this.f9067i;
    }

    /* JADX INFO: renamed from: d */
    public final void m9658d(boolean z) {
        this.f9069k = z;
    }

    /* JADX INFO: renamed from: i */
    public final boolean m9661i() {
        return this.f9069k;
    }

    /* JADX INFO: renamed from: b */
    public JsonWriter mo9530b() throws IOException {
        m9651j();
        return m9647a(1, "[");
    }

    /* JADX INFO: renamed from: c */
    public JsonWriter mo9532c() throws IOException {
        return m9646a(1, 2, "]");
    }

    /* JADX INFO: renamed from: d */
    public JsonWriter mo9533d() throws IOException {
        m9651j();
        return m9647a(3, "{");
    }

    /* JADX INFO: renamed from: e */
    public JsonWriter mo9534e() throws IOException {
        return m9646a(3, 5, "}");
    }

    /* JADX INFO: renamed from: a */
    private JsonWriter m9647a(int i, String str) throws IOException {
        m9654m();
        m9648a(i);
        this.f9061c.write(str);
        return this;
    }

    /* JADX INFO: renamed from: a */
    private JsonWriter m9646a(int i, int i2, String str) throws IOException {
        int iM9645a = m9645a();
        if (iM9645a != i2 && iM9645a != i) {
            throw new IllegalStateException("Nesting problem.");
        }
        if (this.f9068j != null) {
            throw new IllegalStateException("Dangling name: " + this.f9068j);
        }
        this.f9063e--;
        if (iM9645a == i2) {
            m9652k();
        }
        this.f9061c.write(str);
        return this;
    }

    /* JADX INFO: renamed from: a */
    private void m9648a(int i) {
        if (this.f9063e == this.f9062d.length) {
            int[] iArr = new int[this.f9063e * 2];
            System.arraycopy(this.f9062d, 0, iArr, 0, this.f9063e);
            this.f9062d = iArr;
        }
        int[] iArr2 = this.f9062d;
        int i2 = this.f9063e;
        this.f9063e = i2 + 1;
        iArr2[i2] = i;
    }

    /* JADX INFO: renamed from: a */
    private int m9645a() {
        if (this.f9063e == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        return this.f9062d[this.f9063e - 1];
    }

    /* JADX INFO: renamed from: b */
    private void m9649b(int i) {
        this.f9062d[this.f9063e - 1] = i;
    }

    /* JADX INFO: renamed from: a */
    public JsonWriter mo9528a(String str) throws IOException {
        if (str == null) {
            throw new NullPointerException("name == null");
        }
        if (this.f9068j != null) {
            throw new IllegalStateException();
        }
        if (this.f9063e == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.f9068j = str;
        return this;
    }

    /* JADX INFO: renamed from: j */
    private void m9651j() throws IOException {
        if (this.f9068j != null) {
            m9653l();
            m9650d(this.f9068j);
            this.f9068j = null;
        }
    }

    /* JADX INFO: renamed from: b */
    public JsonWriter mo9531b(String str) throws IOException {
        if (str == null) {
            return mo9535f();
        }
        m9651j();
        m9654m();
        m9650d(str);
        return this;
    }

    /* JADX INFO: renamed from: f */
    public JsonWriter mo9535f() throws IOException {
        if (this.f9068j != null) {
            if (this.f9069k) {
                m9651j();
                m9654m();
                this.f9061c.write("null");
            } else {
                this.f9068j = null;
            }
        } else {
            m9654m();
            this.f9061c.write("null");
        }
        return this;
    }

    /* JADX INFO: renamed from: a */
    public JsonWriter mo9529a(boolean z) throws IOException {
        m9651j();
        m9654m();
        this.f9061c.write(z ? ServerProtocol.DIALOG_RETURN_SCOPES_TRUE : "false");
        return this;
    }

    /* JADX INFO: renamed from: a */
    public JsonWriter mo9526a(Boolean bool) throws IOException {
        if (bool == null) {
            return mo9535f();
        }
        m9651j();
        m9654m();
        this.f9061c.write(bool.booleanValue() ? ServerProtocol.DIALOG_RETURN_SCOPES_TRUE : "false");
        return this;
    }

    /* JADX INFO: renamed from: a */
    public JsonWriter mo9525a(long j) throws IOException {
        m9651j();
        m9654m();
        this.f9061c.write(Long.toString(j));
        return this;
    }

    /* JADX INFO: renamed from: a */
    public JsonWriter mo9527a(Number number) throws IOException {
        if (number == null) {
            return mo9535f();
        }
        m9651j();
        String string = number.toString();
        if (!this.f9066h && (string.equals("-Infinity") || string.equals("Infinity") || string.equals("NaN"))) {
            throw new IllegalArgumentException("Numeric values must be finite, but was " + number);
        }
        m9654m();
        this.f9061c.append((CharSequence) string);
        return this;
    }

    public void flush() throws IOException {
        if (this.f9063e == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.f9061c.flush();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f9061c.close();
        int i = this.f9063e;
        if (i > 1 || (i == 1 && this.f9062d[i - 1] != 7)) {
            throw new IOException("Incomplete document");
        }
        this.f9063e = 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0030  */
    /* JADX INFO: renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void m9650d(java.lang.String r8) throws java.io.IOException {
        /*
            r7 = this;
            r1 = 0
            boolean r0 = r7.f9067i
            if (r0 == 0) goto L25
            java.lang.String[] r0 = com.google.gson.stream.JsonWriter.f9060b
        L7:
            java.io.Writer r2 = r7.f9061c
            java.lang.String r3 = "\""
            r2.write(r3)
            int r4 = r8.length()
            r3 = r1
        L13:
            if (r3 >= r4) goto L46
            char r2 = r8.charAt(r3)
            r5 = 128(0x80, float:1.794E-43)
            if (r2 >= r5) goto L28
            r2 = r0[r2]
            if (r2 != 0) goto L2e
        L21:
            int r2 = r3 + 1
            r3 = r2
            goto L13
        L25:
            java.lang.String[] r0 = com.google.gson.stream.JsonWriter.f9059a
            goto L7
        L28:
            r5 = 8232(0x2028, float:1.1535E-41)
            if (r2 != r5) goto L3f
            java.lang.String r2 = "\\u2028"
        L2e:
            if (r1 >= r3) goto L37
            java.io.Writer r5 = r7.f9061c
            int r6 = r3 - r1
            r5.write(r8, r1, r6)
        L37:
            java.io.Writer r1 = r7.f9061c
            r1.write(r2)
            int r1 = r3 + 1
            goto L21
        L3f:
            r5 = 8233(0x2029, float:1.1537E-41)
            if (r2 != r5) goto L21
            java.lang.String r2 = "\\u2029"
            goto L2e
        L46:
            if (r1 >= r4) goto L4f
            java.io.Writer r0 = r7.f9061c
            int r2 = r4 - r1
            r0.write(r8, r1, r2)
        L4f:
            java.io.Writer r0 = r7.f9061c
            java.lang.String r1 = "\""
            r0.write(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.stream.JsonWriter.m9650d(java.lang.String):void");
    }

    /* JADX INFO: renamed from: k */
    private void m9652k() throws IOException {
        if (this.f9064f != null) {
            this.f9061c.write("\n");
            int i = this.f9063e;
            for (int i2 = 1; i2 < i; i2++) {
                this.f9061c.write(this.f9064f);
            }
        }
    }

    /* JADX INFO: renamed from: l */
    private void m9653l() throws IOException {
        int iM9645a = m9645a();
        if (iM9645a == 5) {
            this.f9061c.write(44);
        } else if (iM9645a != 3) {
            throw new IllegalStateException("Nesting problem.");
        }
        m9652k();
        m9649b(4);
    }

    /* JADX INFO: renamed from: m */
    private void m9654m() throws IOException {
        switch (m9645a()) {
            case 1:
                m9649b(2);
                m9652k();
                return;
            case 2:
                this.f9061c.append(',');
                m9652k();
                return;
            case 3:
            case 5:
            default:
                throw new IllegalStateException("Nesting problem.");
            case 4:
                this.f9061c.append((CharSequence) this.f9065g);
                m9649b(5);
                return;
            case 6:
                break;
            case 7:
                if (!this.f9066h) {
                    throw new IllegalStateException("JSON must have only one top-level value.");
                }
                break;
        }
        m9649b(7);
    }
}
