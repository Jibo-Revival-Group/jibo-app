package okhttp3.internal.tls;

import javax.security.auth.x500.X500Principal;
import org.apache.http.message.TokenParser;

/* JADX INFO: loaded from: classes2.dex */
final class DistinguishedNameParser {

    /* JADX INFO: renamed from: a */
    private final String f15614a;

    /* JADX INFO: renamed from: b */
    private final int f15615b;

    /* JADX INFO: renamed from: c */
    private int f15616c;

    /* JADX INFO: renamed from: d */
    private int f15617d;

    /* JADX INFO: renamed from: e */
    private int f15618e;

    /* JADX INFO: renamed from: f */
    private int f15619f;

    /* JADX INFO: renamed from: g */
    private char[] f15620g;

    DistinguishedNameParser(X500Principal x500Principal) {
        this.f15614a = x500Principal.getName("RFC2253");
        this.f15615b = this.f15614a.length();
    }

    /* JADX INFO: renamed from: a */
    private String m16214a() {
        while (this.f15616c < this.f15615b && this.f15620g[this.f15616c] == ' ') {
            this.f15616c++;
        }
        if (this.f15616c == this.f15615b) {
            return null;
        }
        this.f15617d = this.f15616c;
        this.f15616c++;
        while (this.f15616c < this.f15615b && this.f15620g[this.f15616c] != '=' && this.f15620g[this.f15616c] != ' ') {
            this.f15616c++;
        }
        if (this.f15616c >= this.f15615b) {
            throw new IllegalStateException("Unexpected end of DN: " + this.f15614a);
        }
        this.f15618e = this.f15616c;
        if (this.f15620g[this.f15616c] == ' ') {
            while (this.f15616c < this.f15615b && this.f15620g[this.f15616c] != '=' && this.f15620g[this.f15616c] == ' ') {
                this.f15616c++;
            }
            if (this.f15620g[this.f15616c] != '=' || this.f15616c == this.f15615b) {
                throw new IllegalStateException("Unexpected end of DN: " + this.f15614a);
            }
        }
        this.f15616c++;
        while (this.f15616c < this.f15615b && this.f15620g[this.f15616c] == ' ') {
            this.f15616c++;
        }
        if (this.f15618e - this.f15617d > 4 && this.f15620g[this.f15617d + 3] == '.' && ((this.f15620g[this.f15617d] == 'O' || this.f15620g[this.f15617d] == 'o') && ((this.f15620g[this.f15617d + 1] == 'I' || this.f15620g[this.f15617d + 1] == 'i') && (this.f15620g[this.f15617d + 2] == 'D' || this.f15620g[this.f15617d + 2] == 'd')))) {
            this.f15617d += 4;
        }
        return new String(this.f15620g, this.f15617d, this.f15618e - this.f15617d);
    }

    /* JADX INFO: renamed from: b */
    private String m16215b() {
        this.f15616c++;
        this.f15617d = this.f15616c;
        this.f15618e = this.f15617d;
        while (this.f15616c != this.f15615b) {
            if (this.f15620g[this.f15616c] == '\"') {
                this.f15616c++;
                while (this.f15616c < this.f15615b && this.f15620g[this.f15616c] == ' ') {
                    this.f15616c++;
                }
                return new String(this.f15620g, this.f15617d, this.f15618e - this.f15617d);
            }
            if (this.f15620g[this.f15616c] == '\\') {
                this.f15620g[this.f15618e] = m16218e();
            } else {
                this.f15620g[this.f15618e] = this.f15620g[this.f15616c];
            }
            this.f15616c++;
            this.f15618e++;
        }
        throw new IllegalStateException("Unexpected end of DN: " + this.f15614a);
    }

    /* JADX INFO: renamed from: c */
    private String m16216c() {
        int i;
        if (this.f15616c + 4 >= this.f15615b) {
            throw new IllegalStateException("Unexpected end of DN: " + this.f15614a);
        }
        this.f15617d = this.f15616c;
        this.f15616c++;
        while (this.f15616c != this.f15615b && this.f15620g[this.f15616c] != '+' && this.f15620g[this.f15616c] != ',' && this.f15620g[this.f15616c] != ';') {
            if (this.f15620g[this.f15616c] == ' ') {
                this.f15618e = this.f15616c;
                this.f15616c++;
                while (this.f15616c < this.f15615b && this.f15620g[this.f15616c] == ' ') {
                    this.f15616c++;
                }
                i = this.f15618e - this.f15617d;
                if (i >= 5 || (i & 1) == 0) {
                    throw new IllegalStateException("Unexpected end of DN: " + this.f15614a);
                }
                byte[] bArr = new byte[i / 2];
                int i2 = this.f15617d + 1;
                for (int i3 = 0; i3 < bArr.length; i3++) {
                    bArr[i3] = (byte) m16213a(i2);
                    i2 += 2;
                }
                return new String(this.f15620g, this.f15617d, i);
            }
            if (this.f15620g[this.f15616c] >= 'A' && this.f15620g[this.f15616c] <= 'F') {
                char[] cArr = this.f15620g;
                int i4 = this.f15616c;
                cArr[i4] = (char) (cArr[i4] + TokenParser.f15715SP);
            }
            this.f15616c++;
        }
        this.f15618e = this.f15616c;
        i = this.f15618e - this.f15617d;
        if (i >= 5) {
        }
        throw new IllegalStateException("Unexpected end of DN: " + this.f15614a);
    }

    /* JADX INFO: renamed from: d */
    private String m16217d() {
        this.f15617d = this.f15616c;
        this.f15618e = this.f15616c;
        while (this.f15616c < this.f15615b) {
            switch (this.f15620g[this.f15616c]) {
                case ' ':
                    this.f15619f = this.f15618e;
                    this.f15616c++;
                    char[] cArr = this.f15620g;
                    int i = this.f15618e;
                    this.f15618e = i + 1;
                    cArr[i] = TokenParser.f15715SP;
                    while (this.f15616c < this.f15615b && this.f15620g[this.f15616c] == ' ') {
                        char[] cArr2 = this.f15620g;
                        int i2 = this.f15618e;
                        this.f15618e = i2 + 1;
                        cArr2[i2] = TokenParser.f15715SP;
                        this.f15616c++;
                    }
                    if (this.f15616c == this.f15615b || this.f15620g[this.f15616c] == ',' || this.f15620g[this.f15616c] == '+' || this.f15620g[this.f15616c] == ';') {
                        return new String(this.f15620g, this.f15617d, this.f15619f - this.f15617d);
                    }
                    break;
                case '+':
                case ',':
                case ';':
                    return new String(this.f15620g, this.f15617d, this.f15618e - this.f15617d);
                case '\\':
                    char[] cArr3 = this.f15620g;
                    int i3 = this.f15618e;
                    this.f15618e = i3 + 1;
                    cArr3[i3] = m16218e();
                    this.f15616c++;
                    break;
                default:
                    char[] cArr4 = this.f15620g;
                    int i4 = this.f15618e;
                    this.f15618e = i4 + 1;
                    cArr4[i4] = this.f15620g[this.f15616c];
                    this.f15616c++;
                    break;
            }
        }
        return new String(this.f15620g, this.f15617d, this.f15618e - this.f15617d);
    }

    /* JADX INFO: renamed from: e */
    private char m16218e() {
        this.f15616c++;
        if (this.f15616c == this.f15615b) {
            throw new IllegalStateException("Unexpected end of DN: " + this.f15614a);
        }
        switch (this.f15620g[this.f15616c]) {
            case ' ':
            case '\"':
            case '#':
            case '%':
            case '*':
            case '+':
            case ',':
            case ';':
            case '<':
            case '=':
            case '>':
            case '\\':
            case '_':
                return this.f15620g[this.f15616c];
            default:
                return m16219f();
        }
    }

    /* JADX INFO: renamed from: f */
    private char m16219f() {
        int i;
        int i2;
        int iM16213a = m16213a(this.f15616c);
        this.f15616c++;
        if (iM16213a < 128) {
            return (char) iM16213a;
        }
        if (iM16213a < 192 || iM16213a > 247) {
            return '?';
        }
        if (iM16213a <= 223) {
            i = 1;
            i2 = iM16213a & 31;
        } else if (iM16213a <= 239) {
            i = 2;
            i2 = iM16213a & 15;
        } else {
            i = 3;
            i2 = iM16213a & 7;
        }
        int i3 = i2;
        for (int i4 = 0; i4 < i; i4++) {
            this.f15616c++;
            if (this.f15616c == this.f15615b || this.f15620g[this.f15616c] != '\\') {
                return '?';
            }
            this.f15616c++;
            int iM16213a2 = m16213a(this.f15616c);
            this.f15616c++;
            if ((iM16213a2 & 192) != 128) {
                return '?';
            }
            i3 = (i3 << 6) + (iM16213a2 & 63);
        }
        return (char) i3;
    }

    /* JADX INFO: renamed from: a */
    private int m16213a(int i) {
        int i2;
        int i3;
        if (i + 1 >= this.f15615b) {
            throw new IllegalStateException("Malformed DN: " + this.f15614a);
        }
        char c = this.f15620g[i];
        if (c >= '0' && c <= '9') {
            i2 = c - '0';
        } else if (c >= 'a' && c <= 'f') {
            i2 = c - 'W';
        } else if (c >= 'A' && c <= 'F') {
            i2 = c - '7';
        } else {
            throw new IllegalStateException("Malformed DN: " + this.f15614a);
        }
        char c2 = this.f15620g[i + 1];
        if (c2 >= '0' && c2 <= '9') {
            i3 = c2 - '0';
        } else if (c2 >= 'a' && c2 <= 'f') {
            i3 = c2 - 'W';
        } else if (c2 >= 'A' && c2 <= 'F') {
            i3 = c2 - '7';
        } else {
            throw new IllegalStateException("Malformed DN: " + this.f15614a);
        }
        return (i2 << 4) + i3;
    }

    /* JADX INFO: renamed from: a */
    public String m16220a(String str) {
        this.f15616c = 0;
        this.f15617d = 0;
        this.f15618e = 0;
        this.f15619f = 0;
        this.f15620g = this.f15614a.toCharArray();
        String strM16214a = m16214a();
        if (strM16214a == null) {
            return null;
        }
        do {
            String strM16216c = "";
            if (this.f15616c == this.f15615b) {
                return null;
            }
            switch (this.f15620g[this.f15616c]) {
                case '\"':
                    strM16216c = m16215b();
                    break;
                case '#':
                    strM16216c = m16216c();
                    break;
                case '+':
                case ',':
                case ';':
                    break;
                default:
                    strM16216c = m16217d();
                    break;
            }
            if (!str.equalsIgnoreCase(strM16214a)) {
                if (this.f15616c >= this.f15615b) {
                    return null;
                }
                if (this.f15620g[this.f15616c] != ',' && this.f15620g[this.f15616c] != ';' && this.f15620g[this.f15616c] != '+') {
                    throw new IllegalStateException("Malformed DN: " + this.f15614a);
                }
                this.f15616c++;
                strM16214a = m16214a();
            } else {
                return strM16216c;
            }
        } while (strM16214a != null);
        throw new IllegalStateException("Malformed DN: " + this.f15614a);
    }
}
