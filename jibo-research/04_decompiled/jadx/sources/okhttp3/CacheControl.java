package okhttp3;

import com.jibo.aws.integration.aws.services.person.model.Holiday;
import java.util.concurrent.TimeUnit;
import org.apache.http.HttpHeaders;

/* JADX INFO: loaded from: classes2.dex */
public final class CacheControl {

    /* JADX INFO: renamed from: a */
    public static final CacheControl f14874a = new Builder().m15531a().m15534c();

    /* JADX INFO: renamed from: b */
    public static final CacheControl f14875b = new Builder().m15533b().m15532a(Integer.MAX_VALUE, TimeUnit.SECONDS).m15534c();

    /* JADX INFO: renamed from: c */
    String f14876c;

    /* JADX INFO: renamed from: d */
    private final boolean f14877d;

    /* JADX INFO: renamed from: e */
    private final boolean f14878e;

    /* JADX INFO: renamed from: f */
    private final int f14879f;

    /* JADX INFO: renamed from: g */
    private final int f14880g;

    /* JADX INFO: renamed from: h */
    private final boolean f14881h;

    /* JADX INFO: renamed from: i */
    private final boolean f14882i;

    /* JADX INFO: renamed from: j */
    private final boolean f14883j;

    /* JADX INFO: renamed from: k */
    private final int f14884k;

    /* JADX INFO: renamed from: l */
    private final int f14885l;

    /* JADX INFO: renamed from: m */
    private final boolean f14886m;

    /* JADX INFO: renamed from: n */
    private final boolean f14887n;

    /* JADX INFO: renamed from: o */
    private final boolean f14888o;

    private CacheControl(boolean z, boolean z2, int i, int i2, boolean z3, boolean z4, boolean z5, int i3, int i4, boolean z6, boolean z7, boolean z8, String str) {
        this.f14877d = z;
        this.f14878e = z2;
        this.f14879f = i;
        this.f14880g = i2;
        this.f14881h = z3;
        this.f14882i = z4;
        this.f14883j = z5;
        this.f14884k = i3;
        this.f14885l = i4;
        this.f14886m = z6;
        this.f14887n = z7;
        this.f14888o = z8;
        this.f14876c = str;
    }

    CacheControl(Builder builder) {
        this.f14877d = builder.f14889a;
        this.f14878e = builder.f14890b;
        this.f14879f = builder.f14891c;
        this.f14880g = -1;
        this.f14881h = false;
        this.f14882i = false;
        this.f14883j = false;
        this.f14884k = builder.f14892d;
        this.f14885l = builder.f14893e;
        this.f14886m = builder.f14894f;
        this.f14887n = builder.f14895g;
        this.f14888o = builder.f14896h;
    }

    /* JADX INFO: renamed from: a */
    public boolean m15522a() {
        return this.f14877d;
    }

    /* JADX INFO: renamed from: b */
    public boolean m15523b() {
        return this.f14878e;
    }

    /* JADX INFO: renamed from: c */
    public int m15524c() {
        return this.f14879f;
    }

    /* JADX INFO: renamed from: d */
    public boolean m15525d() {
        return this.f14881h;
    }

    /* JADX INFO: renamed from: e */
    public boolean m15526e() {
        return this.f14882i;
    }

    /* JADX INFO: renamed from: f */
    public boolean m15527f() {
        return this.f14883j;
    }

    /* JADX INFO: renamed from: g */
    public int m15528g() {
        return this.f14884k;
    }

    /* JADX INFO: renamed from: h */
    public int m15529h() {
        return this.f14885l;
    }

    /* JADX INFO: renamed from: i */
    public boolean m15530i() {
        return this.f14886m;
    }

    /* JADX INFO: renamed from: a */
    public static CacheControl m15520a(Headers headers) {
        boolean z;
        String str;
        boolean z2 = false;
        boolean z3 = false;
        int iM15976b = -1;
        int iM15976b2 = -1;
        boolean z4 = false;
        boolean z5 = false;
        boolean z6 = false;
        int iM15976b3 = -1;
        int iM15976b4 = -1;
        boolean z7 = false;
        boolean z8 = false;
        boolean z9 = false;
        boolean z10 = true;
        int iM15617a = headers.m15617a();
        int i = 0;
        String str2 = null;
        while (true) {
            z = z2;
            if (i >= iM15617a) {
                break;
            }
            String strM15618a = headers.m15618a(i);
            String strM15620b = headers.m15620b(i);
            if (strM15618a.equalsIgnoreCase(HttpHeaders.CACHE_CONTROL)) {
                if (str2 != null) {
                    z10 = false;
                } else {
                    str2 = strM15620b;
                }
            } else if (!strM15618a.equalsIgnoreCase(HttpHeaders.PRAGMA)) {
                z2 = z;
                i++;
            } else {
                z10 = false;
            }
            z2 = z;
            int i2 = 0;
            while (i2 < strM15620b.length()) {
                int iM15969a = okhttp3.internal.http.HttpHeaders.m15969a(strM15620b, i2, "=,;");
                String strTrim = strM15620b.substring(i2, iM15969a).trim();
                if (iM15969a == strM15620b.length() || strM15620b.charAt(iM15969a) == ',' || strM15620b.charAt(iM15969a) == ';') {
                    i2 = iM15969a + 1;
                    str = null;
                } else {
                    int iM15968a = okhttp3.internal.http.HttpHeaders.m15968a(strM15620b, iM15969a + 1);
                    if (iM15968a < strM15620b.length() && strM15620b.charAt(iM15968a) == '\"') {
                        int i3 = iM15968a + 1;
                        int iM15969a2 = okhttp3.internal.http.HttpHeaders.m15969a(strM15620b, i3, "\"");
                        String strSubstring = strM15620b.substring(i3, iM15969a2);
                        i2 = iM15969a2 + 1;
                        str = strSubstring;
                    } else {
                        int iM15969a3 = okhttp3.internal.http.HttpHeaders.m15969a(strM15620b, iM15968a, ",;");
                        String strTrim2 = strM15620b.substring(iM15968a, iM15969a3).trim();
                        i2 = iM15969a3;
                        str = strTrim2;
                    }
                }
                if ("no-cache".equalsIgnoreCase(strTrim)) {
                    z2 = true;
                } else if ("no-store".equalsIgnoreCase(strTrim)) {
                    z3 = true;
                } else if ("max-age".equalsIgnoreCase(strTrim)) {
                    iM15976b = okhttp3.internal.http.HttpHeaders.m15976b(str, -1);
                } else if ("s-maxage".equalsIgnoreCase(strTrim)) {
                    iM15976b2 = okhttp3.internal.http.HttpHeaders.m15976b(str, -1);
                } else if ("private".equalsIgnoreCase(strTrim)) {
                    z4 = true;
                } else if (Holiday.CATEGORY_PUBLIC.equalsIgnoreCase(strTrim)) {
                    z5 = true;
                } else if ("must-revalidate".equalsIgnoreCase(strTrim)) {
                    z6 = true;
                } else if ("max-stale".equalsIgnoreCase(strTrim)) {
                    iM15976b3 = okhttp3.internal.http.HttpHeaders.m15976b(str, Integer.MAX_VALUE);
                } else if ("min-fresh".equalsIgnoreCase(strTrim)) {
                    iM15976b4 = okhttp3.internal.http.HttpHeaders.m15976b(str, -1);
                } else if ("only-if-cached".equalsIgnoreCase(strTrim)) {
                    z7 = true;
                } else if ("no-transform".equalsIgnoreCase(strTrim)) {
                    z8 = true;
                } else if ("immutable".equalsIgnoreCase(strTrim)) {
                    z9 = true;
                }
            }
            i++;
        }
        return new CacheControl(z, z3, iM15976b, iM15976b2, z4, z5, z6, iM15976b3, iM15976b4, z7, z8, z9, !z10 ? null : str2);
    }

    public String toString() {
        String str = this.f14876c;
        if (str != null) {
            return str;
        }
        String strM15521j = m15521j();
        this.f14876c = strM15521j;
        return strM15521j;
    }

    /* JADX INFO: renamed from: j */
    private String m15521j() {
        StringBuilder sb = new StringBuilder();
        if (this.f14877d) {
            sb.append("no-cache, ");
        }
        if (this.f14878e) {
            sb.append("no-store, ");
        }
        if (this.f14879f != -1) {
            sb.append("max-age=").append(this.f14879f).append(", ");
        }
        if (this.f14880g != -1) {
            sb.append("s-maxage=").append(this.f14880g).append(", ");
        }
        if (this.f14881h) {
            sb.append("private, ");
        }
        if (this.f14882i) {
            sb.append("public, ");
        }
        if (this.f14883j) {
            sb.append("must-revalidate, ");
        }
        if (this.f14884k != -1) {
            sb.append("max-stale=").append(this.f14884k).append(", ");
        }
        if (this.f14885l != -1) {
            sb.append("min-fresh=").append(this.f14885l).append(", ");
        }
        if (this.f14886m) {
            sb.append("only-if-cached, ");
        }
        if (this.f14887n) {
            sb.append("no-transform, ");
        }
        if (this.f14888o) {
            sb.append("immutable, ");
        }
        if (sb.length() == 0) {
            return "";
        }
        sb.delete(sb.length() - 2, sb.length());
        return sb.toString();
    }

    public static final class Builder {

        /* JADX INFO: renamed from: a */
        boolean f14889a;

        /* JADX INFO: renamed from: b */
        boolean f14890b;

        /* JADX INFO: renamed from: c */
        int f14891c = -1;

        /* JADX INFO: renamed from: d */
        int f14892d = -1;

        /* JADX INFO: renamed from: e */
        int f14893e = -1;

        /* JADX INFO: renamed from: f */
        boolean f14894f;

        /* JADX INFO: renamed from: g */
        boolean f14895g;

        /* JADX INFO: renamed from: h */
        boolean f14896h;

        /* JADX INFO: renamed from: a */
        public Builder m15531a() {
            this.f14889a = true;
            return this;
        }

        /* JADX INFO: renamed from: a */
        public Builder m15532a(int i, TimeUnit timeUnit) {
            int i2;
            if (i < 0) {
                throw new IllegalArgumentException("maxStale < 0: " + i);
            }
            long seconds = timeUnit.toSeconds(i);
            if (seconds > 2147483647L) {
                i2 = Integer.MAX_VALUE;
            } else {
                i2 = (int) seconds;
            }
            this.f14892d = i2;
            return this;
        }

        /* JADX INFO: renamed from: b */
        public Builder m15533b() {
            this.f14894f = true;
            return this;
        }

        /* JADX INFO: renamed from: c */
        public CacheControl m15534c() {
            return new CacheControl(this);
        }
    }
}
