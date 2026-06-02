package okhttp3;

import com.yalantis.ucrop.util.FileUtils;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import okhttp3.internal.Util;
import okio.Buffer;
import org.apache.http.HttpHost;

/* JADX INFO: loaded from: classes2.dex */
public final class HttpUrl {

    /* JADX INFO: renamed from: d */
    private static final char[] f15076d = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* JADX INFO: renamed from: a */
    final String f15077a;

    /* JADX INFO: renamed from: b */
    final String f15078b;

    /* JADX INFO: renamed from: c */
    final int f15079c;

    /* JADX INFO: renamed from: e */
    private final String f15080e;

    /* JADX INFO: renamed from: f */
    private final String f15081f;

    /* JADX INFO: renamed from: g */
    private final List<String> f15082g;

    /* JADX INFO: renamed from: h */
    private final List<String> f15083h;

    /* JADX INFO: renamed from: i */
    private final String f15084i;

    /* JADX INFO: renamed from: j */
    private final String f15085j;

    HttpUrl(Builder builder) {
        this.f15077a = builder.f15086a;
        this.f15080e = m15636a(builder.f15087b, false);
        this.f15081f = m15636a(builder.f15088c, false);
        this.f15078b = builder.f15089d;
        this.f15079c = builder.m15678a();
        this.f15082g = m15637a(builder.f15091f, false);
        this.f15083h = builder.f15092g != null ? m15637a(builder.f15092g, true) : null;
        this.f15084i = builder.f15093h != null ? m15636a(builder.f15093h, false) : null;
        this.f15085j = builder.toString();
    }

    /* JADX INFO: renamed from: a */
    public URL m15646a() {
        try {
            return new URL(this.f15085j);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    /* JADX INFO: renamed from: b */
    public URI m15647b() {
        String string = m15663p().m15683b().toString();
        try {
            return new URI(string);
        } catch (URISyntaxException e) {
            try {
                return URI.create(string.replaceAll("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]", ""));
            } catch (Exception e2) {
                throw new RuntimeException(e);
            }
        }
    }

    /* JADX INFO: renamed from: c */
    public String m15648c() {
        return this.f15077a;
    }

    /* JADX INFO: renamed from: d */
    public boolean m15651d() {
        return this.f15077a.equals("https");
    }

    /* JADX INFO: renamed from: e */
    public String m15652e() {
        if (this.f15080e.isEmpty()) {
            return "";
        }
        int length = this.f15077a.length() + 3;
        return this.f15085j.substring(length, Util.m15833a(this.f15085j, length, this.f15085j.length(), ":@"));
    }

    /* JADX INFO: renamed from: f */
    public String m15653f() {
        if (this.f15081f.isEmpty()) {
            return "";
        }
        return this.f15085j.substring(this.f15085j.indexOf(58, this.f15077a.length() + 3) + 1, this.f15085j.indexOf(64));
    }

    /* JADX INFO: renamed from: g */
    public String m15654g() {
        return this.f15078b;
    }

    /* JADX INFO: renamed from: h */
    public int m15655h() {
        return this.f15079c;
    }

    /* JADX INFO: renamed from: a */
    public static int m15632a(String str) {
        if (str.equals(HttpHost.DEFAULT_SCHEME_NAME)) {
            return 80;
        }
        if (str.equals("https")) {
            return 443;
        }
        return -1;
    }

    /* JADX INFO: renamed from: i */
    public String m15656i() {
        int iIndexOf = this.f15085j.indexOf(47, this.f15077a.length() + 3);
        return this.f15085j.substring(iIndexOf, Util.m15833a(this.f15085j, iIndexOf, this.f15085j.length(), "?#"));
    }

    /* JADX INFO: renamed from: a */
    static void m15639a(StringBuilder sb, List<String> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            sb.append('/');
            sb.append(list.get(i));
        }
    }

    /* JADX INFO: renamed from: j */
    public List<String> m15657j() {
        int iIndexOf = this.f15085j.indexOf(47, this.f15077a.length() + 3);
        int iM15833a = Util.m15833a(this.f15085j, iIndexOf, this.f15085j.length(), "?#");
        ArrayList arrayList = new ArrayList();
        while (iIndexOf < iM15833a) {
            int i = iIndexOf + 1;
            iIndexOf = Util.m15832a(this.f15085j, i, iM15833a, '/');
            arrayList.add(this.f15085j.substring(i, iIndexOf));
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: k */
    public List<String> m15658k() {
        return this.f15082g;
    }

    /* JADX INFO: renamed from: l */
    public String m15659l() {
        if (this.f15083h == null) {
            return null;
        }
        int iIndexOf = this.f15085j.indexOf(63) + 1;
        return this.f15085j.substring(iIndexOf, Util.m15832a(this.f15085j, iIndexOf + 1, this.f15085j.length(), '#'));
    }

    /* JADX INFO: renamed from: b */
    static void m15644b(StringBuilder sb, List<String> list) {
        int size = list.size();
        for (int i = 0; i < size; i += 2) {
            String str = list.get(i);
            String str2 = list.get(i + 1);
            if (i > 0) {
                sb.append('&');
            }
            sb.append(str);
            if (str2 != null) {
                sb.append('=');
                sb.append(str2);
            }
        }
    }

    /* JADX INFO: renamed from: b */
    static List<String> m15643b(String str) {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (i <= str.length()) {
            int iIndexOf = str.indexOf(38, i);
            if (iIndexOf == -1) {
                iIndexOf = str.length();
            }
            int iIndexOf2 = str.indexOf(61, i);
            if (iIndexOf2 == -1 || iIndexOf2 > iIndexOf) {
                arrayList.add(str.substring(i, iIndexOf));
                arrayList.add(null);
            } else {
                arrayList.add(str.substring(i, iIndexOf2));
                arrayList.add(str.substring(iIndexOf2 + 1, iIndexOf));
            }
            i = iIndexOf + 1;
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: m */
    public String m15660m() {
        if (this.f15083h == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        m15644b(sb, this.f15083h);
        return sb.toString();
    }

    /* JADX INFO: renamed from: n */
    public String m15661n() {
        if (this.f15084i == null) {
            return null;
        }
        return this.f15085j.substring(this.f15085j.indexOf(35) + 1);
    }

    /* JADX INFO: renamed from: o */
    public String m15662o() {
        return m15650d("/...").m15684b("").m15686c("").m15687c().toString();
    }

    /* JADX INFO: renamed from: c */
    public HttpUrl m15649c(String str) {
        Builder builderM15650d = m15650d(str);
        if (builderM15650d != null) {
            return builderM15650d.m15687c();
        }
        return null;
    }

    /* JADX INFO: renamed from: p */
    public Builder m15663p() {
        Builder builder = new Builder();
        builder.f15086a = this.f15077a;
        builder.f15087b = m15652e();
        builder.f15088c = m15653f();
        builder.f15089d = this.f15078b;
        builder.f15090e = this.f15079c != m15632a(this.f15077a) ? this.f15079c : -1;
        builder.f15091f.clear();
        builder.f15091f.addAll(m15657j());
        builder.m15691g(m15659l());
        builder.f15093h = m15661n();
        return builder;
    }

    /* JADX INFO: renamed from: d */
    public Builder m15650d(String str) {
        Builder builder = new Builder();
        if (builder.m15679a(this, str) == Builder.ParseResult.SUCCESS) {
            return builder;
        }
        return null;
    }

    /* JADX INFO: renamed from: e */
    public static HttpUrl m15645e(String str) {
        Builder builder = new Builder();
        if (builder.m15679a((HttpUrl) null, str) == Builder.ParseResult.SUCCESS) {
            return builder.m15687c();
        }
        return null;
    }

    /* JADX INFO: renamed from: a */
    public static HttpUrl m15638a(URI uri) {
        return m15645e(uri.toString());
    }

    public boolean equals(Object obj) {
        return (obj instanceof HttpUrl) && ((HttpUrl) obj).f15085j.equals(this.f15085j);
    }

    public int hashCode() {
        return this.f15085j.hashCode();
    }

    public String toString() {
        return this.f15085j;
    }

    public static final class Builder {

        /* JADX INFO: renamed from: a */
        String f15086a;

        /* JADX INFO: renamed from: d */
        String f15089d;

        /* JADX INFO: renamed from: g */
        List<String> f15092g;

        /* JADX INFO: renamed from: h */
        String f15093h;

        /* JADX INFO: renamed from: b */
        String f15087b = "";

        /* JADX INFO: renamed from: c */
        String f15088c = "";

        /* JADX INFO: renamed from: e */
        int f15090e = -1;

        /* JADX INFO: renamed from: f */
        final List<String> f15091f = new ArrayList();

        enum ParseResult {
            SUCCESS,
            MISSING_SCHEME,
            UNSUPPORTED_SCHEME,
            INVALID_PORT,
            INVALID_HOST
        }

        public Builder() {
            this.f15091f.add("");
        }

        /* JADX INFO: renamed from: a */
        public Builder m15681a(String str) {
            if (str == null) {
                throw new NullPointerException("scheme == null");
            }
            if (str.equalsIgnoreCase(HttpHost.DEFAULT_SCHEME_NAME)) {
                this.f15086a = HttpHost.DEFAULT_SCHEME_NAME;
            } else if (str.equalsIgnoreCase("https")) {
                this.f15086a = "https";
            } else {
                throw new IllegalArgumentException("unexpected scheme: " + str);
            }
            return this;
        }

        /* JADX INFO: renamed from: b */
        public Builder m15684b(String str) {
            if (str == null) {
                throw new NullPointerException("username == null");
            }
            this.f15087b = HttpUrl.m15635a(str, " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
            return this;
        }

        /* JADX INFO: renamed from: c */
        public Builder m15686c(String str) {
            if (str == null) {
                throw new NullPointerException("password == null");
            }
            this.f15088c = HttpUrl.m15635a(str, " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
            return this;
        }

        /* JADX INFO: renamed from: d */
        public Builder m15688d(String str) {
            if (str == null) {
                throw new NullPointerException("host == null");
            }
            String strM15673e = m15673e(str, 0, str.length());
            if (strM15673e == null) {
                throw new IllegalArgumentException("unexpected host: " + str);
            }
            this.f15089d = strM15673e;
            return this;
        }

        /* JADX INFO: renamed from: a */
        public Builder m15680a(int i) {
            if (i <= 0 || i > 65535) {
                throw new IllegalArgumentException("unexpected port: " + i);
            }
            this.f15090e = i;
            return this;
        }

        /* JADX INFO: renamed from: a */
        int m15678a() {
            return this.f15090e != -1 ? this.f15090e : HttpUrl.m15632a(this.f15086a);
        }

        /* JADX INFO: renamed from: e */
        public Builder m15689e(String str) {
            if (str == null) {
                throw new NullPointerException("pathSegment == null");
            }
            m15667a(str, 0, str.length(), false, false);
            return this;
        }

        /* JADX INFO: renamed from: f */
        public Builder m15690f(String str) {
            if (str == null) {
                throw new NullPointerException("pathSegments == null");
            }
            return m15665a(str, false);
        }

        /* JADX INFO: renamed from: a */
        private Builder m15665a(String str, boolean z) {
            int i = 0;
            do {
                int iM15833a = Util.m15833a(str, i, str.length(), "/\\");
                m15667a(str, i, iM15833a, iM15833a < str.length(), z);
                i = iM15833a + 1;
            } while (i <= str.length());
            return this;
        }

        /* JADX INFO: renamed from: g */
        public Builder m15691g(String str) {
            List<String> listM15643b;
            if (str != null) {
                listM15643b = HttpUrl.m15643b(HttpUrl.m15635a(str, " \"'<>#", true, false, true, true));
            } else {
                listM15643b = null;
            }
            this.f15092g = listM15643b;
            return this;
        }

        /* JADX INFO: renamed from: a */
        public Builder m15682a(String str, String str2) {
            String strM15635a;
            if (str == null) {
                throw new NullPointerException("name == null");
            }
            if (this.f15092g == null) {
                this.f15092g = new ArrayList();
            }
            this.f15092g.add(HttpUrl.m15635a(str, " \"'<>#&=", false, false, true, true));
            List<String> list = this.f15092g;
            if (str2 != null) {
                strM15635a = HttpUrl.m15635a(str2, " \"'<>#&=", false, false, true, true);
            } else {
                strM15635a = null;
            }
            list.add(strM15635a);
            return this;
        }

        /* JADX INFO: renamed from: b */
        public Builder m15685b(String str, String str2) {
            String strM15635a;
            if (str == null) {
                throw new NullPointerException("encodedName == null");
            }
            if (this.f15092g == null) {
                this.f15092g = new ArrayList();
            }
            this.f15092g.add(HttpUrl.m15635a(str, " \"'<>#&=", true, false, true, true));
            List<String> list = this.f15092g;
            if (str2 != null) {
                strM15635a = HttpUrl.m15635a(str2, " \"'<>#&=", true, false, true, true);
            } else {
                strM15635a = null;
            }
            list.add(strM15635a);
            return this;
        }

        /* JADX INFO: renamed from: b */
        Builder m15683b() {
            int size = this.f15091f.size();
            for (int i = 0; i < size; i++) {
                this.f15091f.set(i, HttpUrl.m15635a(this.f15091f.get(i), "[]", true, true, false, true));
            }
            if (this.f15092g != null) {
                int size2 = this.f15092g.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    String str = this.f15092g.get(i2);
                    if (str != null) {
                        this.f15092g.set(i2, HttpUrl.m15635a(str, "\\^`{|}", true, true, true, true));
                    }
                }
            }
            if (this.f15093h != null) {
                this.f15093h = HttpUrl.m15635a(this.f15093h, " \"#<>\\^`{|}", true, true, false, false);
            }
            return this;
        }

        /* JADX INFO: renamed from: c */
        public HttpUrl m15687c() {
            if (this.f15086a == null) {
                throw new IllegalStateException("scheme == null");
            }
            if (this.f15089d == null) {
                throw new IllegalStateException("host == null");
            }
            return new HttpUrl(this);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(this.f15086a);
            sb.append("://");
            if (!this.f15087b.isEmpty() || !this.f15088c.isEmpty()) {
                sb.append(this.f15087b);
                if (!this.f15088c.isEmpty()) {
                    sb.append(':');
                    sb.append(this.f15088c);
                }
                sb.append('@');
            }
            if (this.f15089d.indexOf(58) != -1) {
                sb.append('[');
                sb.append(this.f15089d);
                sb.append(']');
            } else {
                sb.append(this.f15089d);
            }
            int iM15678a = m15678a();
            if (iM15678a != HttpUrl.m15632a(this.f15086a)) {
                sb.append(':');
                sb.append(iM15678a);
            }
            HttpUrl.m15639a(sb, this.f15091f);
            if (this.f15092g != null) {
                sb.append('?');
                HttpUrl.m15644b(sb, this.f15092g);
            }
            if (this.f15093h != null) {
                sb.append('#');
                sb.append(this.f15093h);
            }
            return sb.toString();
        }

        /* JADX INFO: renamed from: a */
        ParseResult m15679a(HttpUrl httpUrl, String str) {
            byte bCharAt;
            int iM15832a;
            int iM15831a = Util.m15831a(str, 0, str.length());
            int iM15851b = Util.m15851b(str, iM15831a, str.length());
            if (m15669b(str, iM15831a, iM15851b) != -1) {
                if (str.regionMatches(true, iM15831a, "https:", 0, 6)) {
                    this.f15086a = "https";
                    iM15831a += "https:".length();
                } else if (str.regionMatches(true, iM15831a, "http:", 0, 5)) {
                    this.f15086a = HttpHost.DEFAULT_SCHEME_NAME;
                    iM15831a += "http:".length();
                } else {
                    return ParseResult.UNSUPPORTED_SCHEME;
                }
            } else if (httpUrl != null) {
                this.f15086a = httpUrl.f15077a;
            } else {
                return ParseResult.MISSING_SCHEME;
            }
            boolean z = false;
            boolean z2 = false;
            int iM15670c = m15670c(str, iM15831a, iM15851b);
            if (iM15670c >= 2 || httpUrl == null || !httpUrl.f15077a.equals(this.f15086a)) {
                int i = iM15831a + iM15670c;
                while (true) {
                    boolean z3 = z2;
                    boolean z4 = z;
                    int i2 = i;
                    int iM15833a = Util.m15833a(str, i2, iM15851b, "@/\\?#");
                    if (iM15833a != iM15851b) {
                        bCharAt = str.charAt(iM15833a);
                    } else {
                        bCharAt = -1;
                    }
                    switch (bCharAt) {
                        case -1:
                        case 35:
                        case 47:
                        case 63:
                        case 92:
                            int iM15671d = m15671d(str, i2, iM15833a);
                            if (iM15671d + 1 < iM15833a) {
                                this.f15089d = m15673e(str, i2, iM15671d);
                                this.f15090e = m15675g(str, iM15671d + 1, iM15833a);
                                if (this.f15090e == -1) {
                                    return ParseResult.INVALID_PORT;
                                }
                            } else {
                                this.f15089d = m15673e(str, i2, iM15671d);
                                this.f15090e = HttpUrl.m15632a(this.f15086a);
                            }
                            if (this.f15089d == null) {
                                return ParseResult.INVALID_HOST;
                            }
                            iM15831a = iM15833a;
                            break;
                        case 64:
                            if (z3) {
                                this.f15088c += "%40" + HttpUrl.m15633a(str, i2, iM15833a, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true);
                            } else {
                                int iM15832a2 = Util.m15832a(str, i2, iM15833a, ':');
                                String strM15633a = HttpUrl.m15633a(str, i2, iM15832a2, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true);
                                if (z4) {
                                    strM15633a = this.f15087b + "%40" + strM15633a;
                                }
                                this.f15087b = strM15633a;
                                if (iM15832a2 != iM15833a) {
                                    z3 = true;
                                    this.f15088c = HttpUrl.m15633a(str, iM15832a2 + 1, iM15833a, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true);
                                }
                                z4 = true;
                            }
                            i = iM15833a + 1;
                            z2 = z3;
                            continue;
                            z = z4;
                            break;
                        default:
                            z2 = z3;
                            i = i2;
                            continue;
                            z = z4;
                            break;
                    }
                }
            } else {
                this.f15087b = httpUrl.m15652e();
                this.f15088c = httpUrl.m15653f();
                this.f15089d = httpUrl.f15078b;
                this.f15090e = httpUrl.f15079c;
                this.f15091f.clear();
                this.f15091f.addAll(httpUrl.m15657j());
                if (iM15831a == iM15851b || str.charAt(iM15831a) == '#') {
                    m15691g(httpUrl.m15659l());
                }
            }
            int iM15833a2 = Util.m15833a(str, iM15831a, iM15851b, "?#");
            m15666a(str, iM15831a, iM15833a2);
            if (iM15833a2 >= iM15851b || str.charAt(iM15833a2) != '?') {
                iM15832a = iM15833a2;
            } else {
                iM15832a = Util.m15832a(str, iM15833a2, iM15851b, '#');
                this.f15092g = HttpUrl.m15643b(HttpUrl.m15633a(str, iM15833a2 + 1, iM15832a, " \"'<>#", true, false, true, true));
            }
            if (iM15832a < iM15851b && str.charAt(iM15832a) == '#') {
                this.f15093h = HttpUrl.m15633a(str, iM15832a + 1, iM15851b, "", true, false, false, false);
            }
            return ParseResult.SUCCESS;
        }

        /* JADX INFO: renamed from: a */
        private void m15666a(String str, int i, int i2) {
            if (i != i2) {
                char cCharAt = str.charAt(i);
                if (cCharAt == '/' || cCharAt == '\\') {
                    this.f15091f.clear();
                    this.f15091f.add("");
                    i++;
                } else {
                    this.f15091f.set(this.f15091f.size() - 1, "");
                }
                int i3 = i;
                while (i3 < i2) {
                    int iM15833a = Util.m15833a(str, i3, i2, "/\\");
                    boolean z = iM15833a < i2;
                    m15667a(str, i3, iM15833a, z, true);
                    if (z) {
                        iM15833a++;
                    }
                    i3 = iM15833a;
                }
            }
        }

        /* JADX INFO: renamed from: a */
        private void m15667a(String str, int i, int i2, boolean z, boolean z2) {
            String strM15633a = HttpUrl.m15633a(str, i, i2, " \"<>^`{}|/\\?#", z2, false, false, true);
            if (!m15676h(strM15633a)) {
                if (m15677i(strM15633a)) {
                    m15672d();
                    return;
                }
                if (this.f15091f.get(this.f15091f.size() - 1).isEmpty()) {
                    this.f15091f.set(this.f15091f.size() - 1, strM15633a);
                } else {
                    this.f15091f.add(strM15633a);
                }
                if (z) {
                    this.f15091f.add("");
                }
            }
        }

        /* JADX INFO: renamed from: h */
        private boolean m15676h(String str) {
            return str.equals(FileUtils.HIDDEN_PREFIX) || str.equalsIgnoreCase("%2e");
        }

        /* JADX INFO: renamed from: i */
        private boolean m15677i(String str) {
            return str.equals("..") || str.equalsIgnoreCase("%2e.") || str.equalsIgnoreCase(".%2e") || str.equalsIgnoreCase("%2e%2e");
        }

        /* JADX INFO: renamed from: d */
        private void m15672d() {
            if (this.f15091f.remove(this.f15091f.size() - 1).isEmpty() && !this.f15091f.isEmpty()) {
                this.f15091f.set(this.f15091f.size() - 1, "");
            } else {
                this.f15091f.add("");
            }
        }

        /* JADX INFO: renamed from: b */
        private static int m15669b(String str, int i, int i2) {
            if (i2 - i < 2) {
                return -1;
            }
            char cCharAt = str.charAt(i);
            if ((cCharAt < 'a' || cCharAt > 'z') && (cCharAt < 'A' || cCharAt > 'Z')) {
                return -1;
            }
            for (int i3 = i + 1; i3 < i2; i3++) {
                char cCharAt2 = str.charAt(i3);
                if ((cCharAt2 < 'a' || cCharAt2 > 'z') && ((cCharAt2 < 'A' || cCharAt2 > 'Z') && ((cCharAt2 < '0' || cCharAt2 > '9') && cCharAt2 != '+' && cCharAt2 != '-' && cCharAt2 != '.'))) {
                    if (cCharAt2 == ':') {
                        return i3;
                    }
                    return -1;
                }
            }
            return -1;
        }

        /* JADX INFO: renamed from: c */
        private static int m15670c(String str, int i, int i2) {
            int i3 = 0;
            while (i < i2) {
                char cCharAt = str.charAt(i);
                if (cCharAt != '\\' && cCharAt != '/') {
                    break;
                }
                i3++;
                i++;
            }
            return i3;
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX INFO: renamed from: d */
        private static int m15671d(String str, int i, int i2) {
            int i3 = i;
            while (i3 < i2) {
                switch (str.charAt(i3)) {
                    case ':':
                        return i3;
                    case '[':
                        do {
                            i3++;
                            if (i3 < i2) {
                            }
                            i3++;
                            break;
                        } while (str.charAt(i3) != ']');
                        i3++;
                        break;
                    default:
                        i3++;
                        break;
                }
            }
            return i2;
        }

        /* JADX INFO: renamed from: e */
        private static String m15673e(String str, int i, int i2) {
            InetAddress inetAddressM15674f;
            String strM15634a = HttpUrl.m15634a(str, i, i2, false);
            if (strM15634a.contains(":")) {
                if (strM15634a.startsWith("[") && strM15634a.endsWith("]")) {
                    inetAddressM15674f = m15674f(strM15634a, 1, strM15634a.length() - 1);
                } else {
                    inetAddressM15674f = m15674f(strM15634a, 0, strM15634a.length());
                }
                if (inetAddressM15674f == null) {
                    return null;
                }
                byte[] address = inetAddressM15674f.getAddress();
                if (address.length == 16) {
                    return m15664a(address);
                }
                throw new AssertionError();
            }
            return Util.m15835a(strM15634a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:18:0x002c, code lost:
        
            if (r2 == r8.length) goto L50;
         */
        /* JADX WARN: Code restructure failed: missing block: B:19:0x002e, code lost:
        
            if (r1 != (-1)) goto L43;
         */
        /* JADX WARN: Code restructure failed: missing block: B:43:0x0085, code lost:
        
            java.lang.System.arraycopy(r8, r1, r8, r8.length - (r2 - r1), r2 - r1);
            java.util.Arrays.fill(r8, r1, (r8.length - r2) + r1, (byte) 0);
         */
        /* JADX WARN: Code restructure failed: missing block: B:48:0x00a0, code lost:
        
            throw new java.lang.AssertionError();
         */
        /* JADX WARN: Code restructure failed: missing block: B:62:?, code lost:
        
            return null;
         */
        /* JADX WARN: Code restructure failed: missing block: B:66:?, code lost:
        
            return java.net.InetAddress.getByAddress(r8);
         */
        /* JADX WARN: Removed duplicated region for block: B:27:0x0042  */
        /* JADX INFO: renamed from: f */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private static java.net.InetAddress m15674f(java.lang.String r12, int r13, int r14) {
            /*
                r11 = 1
                r7 = -1
                r3 = 0
                r5 = 0
                r0 = 16
                byte[] r8 = new byte[r0]
                r0 = r13
                r4 = r7
                r1 = r7
                r2 = r5
            Lc:
                if (r0 >= r14) goto L2b
                int r6 = r8.length
                if (r2 != r6) goto L13
                r0 = r3
            L12:
                return r0
            L13:
                int r6 = r0 + 2
                if (r6 > r14) goto L32
                java.lang.String r6 = "::"
                r9 = 2
                boolean r6 = r12.regionMatches(r0, r6, r5, r9)
                if (r6 == 0) goto L32
                if (r1 == r7) goto L24
                r0 = r3
                goto L12
            L24:
                int r0 = r0 + 2
                int r1 = r2 + 2
                if (r0 != r14) goto La1
                r2 = r1
            L2b:
                int r0 = r8.length
                if (r2 == r0) goto L94
                if (r1 != r7) goto L85
                r0 = r3
                goto L12
            L32:
                if (r2 == 0) goto L3e
                java.lang.String r6 = ":"
                boolean r6 = r12.regionMatches(r0, r6, r5, r11)
                if (r6 == 0) goto L55
                int r0 = r0 + 1
            L3e:
                r4 = r5
                r6 = r0
            L40:
                if (r6 >= r14) goto L4c
                char r9 = r12.charAt(r6)
                int r9 = okhttp3.HttpUrl.m15631a(r9)
                if (r9 != r7) goto L6c
            L4c:
                int r9 = r6 - r0
                if (r9 == 0) goto L53
                r10 = 4
                if (r9 <= r10) goto L72
            L53:
                r0 = r3
                goto L12
            L55:
                java.lang.String r6 = "."
                boolean r0 = r12.regionMatches(r0, r6, r5, r11)
                if (r0 == 0) goto L6a
                int r0 = r2 + (-2)
                boolean r0 = m15668a(r12, r4, r14, r8, r0)
                if (r0 != 0) goto L67
                r0 = r3
                goto L12
            L67:
                int r2 = r2 + 2
                goto L2b
            L6a:
                r0 = r3
                goto L12
            L6c:
                int r4 = r4 << 4
                int r4 = r4 + r9
                int r6 = r6 + 1
                goto L40
            L72:
                int r9 = r2 + 1
                int r10 = r4 >>> 8
                r10 = r10 & 255(0xff, float:3.57E-43)
                byte r10 = (byte) r10
                r8[r2] = r10
                int r2 = r9 + 1
                r4 = r4 & 255(0xff, float:3.57E-43)
                byte r4 = (byte) r4
                r8[r9] = r4
                r4 = r0
                r0 = r6
                goto Lc
            L85:
                int r0 = r8.length
                int r3 = r2 - r1
                int r0 = r0 - r3
                int r3 = r2 - r1
                java.lang.System.arraycopy(r8, r1, r8, r0, r3)
                int r0 = r8.length
                int r0 = r0 - r2
                int r0 = r0 + r1
                java.util.Arrays.fill(r8, r1, r0, r5)
            L94:
                java.net.InetAddress r0 = java.net.InetAddress.getByAddress(r8)     // Catch: java.net.UnknownHostException -> L9a
                goto L12
            L9a:
                r0 = move-exception
                java.lang.AssertionError r0 = new java.lang.AssertionError
                r0.<init>()
                throw r0
            La1:
                r2 = r1
                goto L3e
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.HttpUrl.Builder.m15674f(java.lang.String, int, int):java.net.InetAddress");
        }

        /* JADX INFO: renamed from: a */
        private static boolean m15668a(String str, int i, int i2, byte[] bArr, int i3) {
            int i4 = i;
            int i5 = i3;
            while (i4 < i2) {
                if (i5 == bArr.length) {
                    return false;
                }
                if (i5 != i3) {
                    if (str.charAt(i4) != '.') {
                        return false;
                    }
                    i4++;
                }
                int i6 = 0;
                int i7 = i4;
                while (i7 < i2) {
                    char cCharAt = str.charAt(i7);
                    if (cCharAt < '0' || cCharAt > '9') {
                        break;
                    }
                    if ((i6 != 0 || i4 == i7) && ((i6 * 10) + cCharAt) - 48 <= 255) {
                        i7++;
                    }
                    return false;
                }
                if (i7 - i4 == 0) {
                    return false;
                }
                bArr[i5] = (byte) i6;
                i5++;
                i4 = i7;
            }
            return i5 == i3 + 4;
        }

        /* JADX INFO: renamed from: a */
        private static String m15664a(byte[] bArr) {
            int i = 0;
            int i2 = 0;
            int i3 = -1;
            int i4 = 0;
            while (i4 < bArr.length) {
                int i5 = i4;
                while (i5 < 16 && bArr[i5] == 0 && bArr[i5 + 1] == 0) {
                    i5 += 2;
                }
                int i6 = i5 - i4;
                if (i6 > i2 && i6 >= 4) {
                    i2 = i6;
                    i3 = i4;
                }
                i4 = i5 + 2;
            }
            Buffer buffer = new Buffer();
            while (i < bArr.length) {
                if (i == i3) {
                    buffer.mo16298k(58);
                    i += i2;
                    if (i == 16) {
                        buffer.mo16298k(58);
                    }
                } else {
                    if (i > 0) {
                        buffer.mo16298k(58);
                    }
                    buffer.mo16299l(((bArr[i] & 255) << 8) | (bArr[i + 1] & 255));
                    i += 2;
                }
            }
            return buffer.m16306q();
        }

        /* JADX INFO: renamed from: g */
        private static int m15675g(String str, int i, int i2) {
            try {
                int i3 = Integer.parseInt(HttpUrl.m15633a(str, i, i2, "", false, false, false, true));
                if (i3 <= 0 || i3 > 65535) {
                    return -1;
                }
                return i3;
            } catch (NumberFormatException e) {
                return -1;
            }
        }
    }

    /* JADX INFO: renamed from: a */
    static String m15636a(String str, boolean z) {
        return m15634a(str, 0, str.length(), z);
    }

    /* JADX INFO: renamed from: a */
    private List<String> m15637a(List<String> list, boolean z) {
        int size = list.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            String str = list.get(i);
            arrayList.add(str != null ? m15636a(str, z) : null);
        }
        return Collections.unmodifiableList(arrayList);
    }

    /* JADX INFO: renamed from: a */
    static String m15634a(String str, int i, int i2, boolean z) {
        for (int i3 = i; i3 < i2; i3++) {
            char cCharAt = str.charAt(i3);
            if (cCharAt == '%' || (cCharAt == '+' && z)) {
                Buffer buffer = new Buffer();
                buffer.m16256a(str, i, i3);
                m15641a(buffer, str, i3, i2, z);
                return buffer.m16306q();
            }
        }
        return str.substring(i, i2);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0042  */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static void m15641a(okio.Buffer r5, java.lang.String r6, int r7, int r8, boolean r9) {
        /*
            r4 = -1
            r0 = r7
        L2:
            if (r0 >= r8) goto L46
            int r1 = r6.codePointAt(r0)
            r2 = 37
            if (r1 != r2) goto L36
            int r2 = r0 + 2
            if (r2 >= r8) goto L36
            int r2 = r0 + 1
            char r2 = r6.charAt(r2)
            int r2 = m15631a(r2)
            int r3 = r0 + 2
            char r3 = r6.charAt(r3)
            int r3 = m15631a(r3)
            if (r2 == r4) goto L42
            if (r3 == r4) goto L42
            int r2 = r2 << 4
            int r2 = r2 + r3
            r5.mo16298k(r2)
            int r0 = r0 + 2
        L30:
            int r1 = java.lang.Character.charCount(r1)
            int r0 = r0 + r1
            goto L2
        L36:
            r2 = 43
            if (r1 != r2) goto L42
            if (r9 == 0) goto L42
            r2 = 32
            r5.mo16298k(r2)
            goto L30
        L42:
            r5.m16254a(r1)
            goto L30
        L46:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.HttpUrl.m15641a(okio.Buffer, java.lang.String, int, int, boolean):void");
    }

    /* JADX INFO: renamed from: a */
    static boolean m15642a(String str, int i, int i2) {
        return i + 2 < i2 && str.charAt(i) == '%' && m15631a(str.charAt(i + 1)) != -1 && m15631a(str.charAt(i + 2)) != -1;
    }

    /* JADX INFO: renamed from: a */
    static int m15631a(char c) {
        if (c >= '0' && c <= '9') {
            return c - '0';
        }
        if (c >= 'a' && c <= 'f') {
            return (c - 'a') + 10;
        }
        if (c < 'A' || c > 'F') {
            return -1;
        }
        return (c - 'A') + 10;
    }

    /* JADX INFO: renamed from: a */
    static String m15633a(String str, int i, int i2, String str2, boolean z, boolean z2, boolean z3, boolean z4) {
        int iCharCount = i;
        while (iCharCount < i2) {
            int iCodePointAt = str.codePointAt(iCharCount);
            if (iCodePointAt >= 32 && iCodePointAt != 127 && ((iCodePointAt < 128 || !z4) && str2.indexOf(iCodePointAt) == -1 && ((iCodePointAt != 37 || (z && (!z2 || m15642a(str, iCharCount, i2)))) && (iCodePointAt != 43 || !z3)))) {
                iCharCount += Character.charCount(iCodePointAt);
            } else {
                Buffer buffer = new Buffer();
                buffer.m16256a(str, i, iCharCount);
                m15640a(buffer, str, iCharCount, i2, str2, z, z2, z3, z4);
                return buffer.m16306q();
            }
        }
        return str.substring(i, i2);
    }

    /* JADX INFO: renamed from: a */
    static void m15640a(Buffer buffer, String str, int i, int i2, String str2, boolean z, boolean z2, boolean z3, boolean z4) {
        Buffer buffer2 = null;
        while (i < i2) {
            int iCodePointAt = str.codePointAt(i);
            if (!z || (iCodePointAt != 9 && iCodePointAt != 10 && iCodePointAt != 12 && iCodePointAt != 13)) {
                if (iCodePointAt == 43 && z3) {
                    buffer.mo16267b(z ? "+" : "%2B");
                } else if (iCodePointAt < 32 || iCodePointAt == 127 || ((iCodePointAt >= 128 && z4) || str2.indexOf(iCodePointAt) != -1 || (iCodePointAt == 37 && (!z || (z2 && !m15642a(str, i, i2)))))) {
                    if (buffer2 == null) {
                        buffer2 = new Buffer();
                    }
                    buffer2.m16254a(iCodePointAt);
                    while (!buffer2.mo16283f()) {
                        int iMo16290i = buffer2.mo16290i() & 255;
                        buffer.mo16298k(37);
                        buffer.mo16298k((int) f15076d[(iMo16290i >> 4) & 15]);
                        buffer.mo16298k((int) f15076d[iMo16290i & 15]);
                    }
                } else {
                    buffer.m16254a(iCodePointAt);
                }
            }
            i += Character.charCount(iCodePointAt);
        }
    }

    /* JADX INFO: renamed from: a */
    static String m15635a(String str, String str2, boolean z, boolean z2, boolean z3, boolean z4) {
        return m15633a(str, 0, str.length(), str2, z, z2, z3, z4);
    }
}
