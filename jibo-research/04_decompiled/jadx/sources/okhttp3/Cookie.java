package okhttp3;

import com.yalantis.ucrop.util.FileUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import okhttp3.internal.Util;
import okhttp3.internal.http.HttpDate;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;

/* JADX INFO: loaded from: classes2.dex */
public final class Cookie {

    /* JADX INFO: renamed from: a */
    private static final Pattern f15041a = Pattern.compile("(\\d{2,4})[^\\d]*");

    /* JADX INFO: renamed from: b */
    private static final Pattern f15042b = Pattern.compile("(?i)(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec).*");

    /* JADX INFO: renamed from: c */
    private static final Pattern f15043c = Pattern.compile("(\\d{1,2})[^\\d]*");

    /* JADX INFO: renamed from: d */
    private static final Pattern f15044d = Pattern.compile("(\\d{1,2}):(\\d{1,2}):(\\d{1,2})[^\\d]*");

    /* JADX INFO: renamed from: e */
    private final String f15045e;

    /* JADX INFO: renamed from: f */
    private final String f15046f;

    /* JADX INFO: renamed from: g */
    private final long f15047g;

    /* JADX INFO: renamed from: h */
    private final String f15048h;

    /* JADX INFO: renamed from: i */
    private final String f15049i;

    /* JADX INFO: renamed from: j */
    private final boolean f15050j;

    /* JADX INFO: renamed from: k */
    private final boolean f15051k;

    /* JADX INFO: renamed from: l */
    private final boolean f15052l;

    /* JADX INFO: renamed from: m */
    private final boolean f15053m;

    private Cookie(String str, String str2, long j, String str3, String str4, boolean z, boolean z2, boolean z3, boolean z4) {
        this.f15045e = str;
        this.f15046f = str2;
        this.f15047g = j;
        this.f15048h = str3;
        this.f15049i = str4;
        this.f15050j = z;
        this.f15051k = z2;
        this.f15053m = z3;
        this.f15052l = z4;
    }

    /* JADX INFO: renamed from: a */
    public String m15583a() {
        return this.f15045e;
    }

    /* JADX INFO: renamed from: b */
    public String m15585b() {
        return this.f15046f;
    }

    /* JADX INFO: renamed from: a */
    private static boolean m15581a(String str, String str2) {
        if (str.equals(str2)) {
            return true;
        }
        return str.endsWith(str2) && str.charAt((str.length() - str2.length()) + (-1)) == '.' && !Util.m15855c(str);
    }

    /* JADX INFO: renamed from: a */
    public static Cookie m15580a(HttpUrl httpUrl, String str) {
        return m15579a(System.currentTimeMillis(), httpUrl, str);
    }

    /* JADX INFO: renamed from: a */
    static Cookie m15579a(long j, HttpUrl httpUrl, String str) {
        long j2;
        long j3;
        String strSubstring;
        String strM15854c;
        String strM15582b;
        int length = str.length();
        int iM15832a = Util.m15832a(str, 0, length, ';');
        int iM15832a2 = Util.m15832a(str, 0, iM15832a, '=');
        if (iM15832a2 == iM15832a) {
            return null;
        }
        String strM15854c2 = Util.m15854c(str, 0, iM15832a2);
        if (strM15854c2.isEmpty() || Util.m15850b(strM15854c2) != -1) {
            return null;
        }
        String strM15854c3 = Util.m15854c(str, iM15832a2 + 1, iM15832a);
        if (Util.m15850b(strM15854c3) != -1) {
            return null;
        }
        long jM15577a = 253402300799999L;
        long jM15576a = -1;
        String str2 = null;
        String str3 = null;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = true;
        boolean z4 = false;
        int i = iM15832a + 1;
        while (i < length) {
            int iM15832a3 = Util.m15832a(str, i, length, ';');
            int iM15832a4 = Util.m15832a(str, i, iM15832a3, '=');
            String strM15854c4 = Util.m15854c(str, i, iM15832a4);
            if (iM15832a4 < iM15832a3) {
                strM15854c = Util.m15854c(str, iM15832a4 + 1, iM15832a3);
            } else {
                strM15854c = "";
            }
            if (strM15854c4.equalsIgnoreCase("expires")) {
                try {
                    jM15577a = m15577a(strM15854c, 0, strM15854c.length());
                    z4 = true;
                    strM15582b = str2;
                } catch (IllegalArgumentException e) {
                    strM15582b = str2;
                }
            } else if (strM15854c4.equalsIgnoreCase("max-age")) {
                try {
                    jM15576a = m15576a(strM15854c);
                    z4 = true;
                    strM15582b = str2;
                } catch (NumberFormatException e2) {
                    strM15582b = str2;
                }
            } else if (strM15854c4.equalsIgnoreCase("domain")) {
                try {
                    strM15582b = m15582b(strM15854c);
                    z3 = false;
                } catch (IllegalArgumentException e3) {
                    strM15582b = str2;
                }
            } else if (strM15854c4.equalsIgnoreCase("path")) {
                str3 = strM15854c;
                strM15582b = str2;
            } else if (strM15854c4.equalsIgnoreCase("secure")) {
                z = true;
                strM15582b = str2;
            } else if (strM15854c4.equalsIgnoreCase("httponly")) {
                z2 = true;
                strM15582b = str2;
            } else {
                strM15582b = str2;
            }
            String str4 = strM15582b;
            i = iM15832a3 + 1;
            jM15577a = jM15577a;
            str2 = str4;
        }
        if (jM15576a == Long.MIN_VALUE) {
            j2 = Long.MIN_VALUE;
        } else if (jM15576a != -1) {
            if (jM15576a <= 9223372036854775L) {
                j3 = jM15576a * 1000;
            } else {
                j3 = Long.MAX_VALUE;
            }
            j2 = j3 + j;
            if (j2 < j || j2 > 253402300799999L) {
                j2 = 253402300799999L;
            }
        } else {
            j2 = jM15577a;
        }
        String strM15654g = httpUrl.m15654g();
        if (str2 == null) {
            str2 = strM15654g;
        } else if (!m15581a(strM15654g, str2)) {
            return null;
        }
        if (strM15654g.length() != str2.length() && PublicSuffixDatabase.m16207a().m16210a(str2) == null) {
            return null;
        }
        if (str3 == null || !str3.startsWith("/")) {
            String strM15656i = httpUrl.m15656i();
            int iLastIndexOf = strM15656i.lastIndexOf(47);
            strSubstring = iLastIndexOf != 0 ? strM15656i.substring(0, iLastIndexOf) : "/";
        } else {
            strSubstring = str3;
        }
        return new Cookie(strM15854c2, strM15854c3, j2, str2, strSubstring, z, z2, z3, z4);
    }

    /* JADX INFO: renamed from: a */
    private static long m15577a(String str, int i, int i2) {
        int iM15575a = m15575a(str, i, i2, false);
        int i3 = -1;
        int i4 = -1;
        int i5 = -1;
        int i6 = -1;
        int iIndexOf = -1;
        int i7 = -1;
        Matcher matcher = f15044d.matcher(str);
        while (iM15575a < i2) {
            int iM15575a2 = m15575a(str, iM15575a + 1, i2, true);
            matcher.region(iM15575a, iM15575a2);
            if (i3 == -1 && matcher.usePattern(f15044d).matches()) {
                i3 = Integer.parseInt(matcher.group(1));
                i4 = Integer.parseInt(matcher.group(2));
                i5 = Integer.parseInt(matcher.group(3));
            } else if (i6 == -1 && matcher.usePattern(f15043c).matches()) {
                i6 = Integer.parseInt(matcher.group(1));
            } else if (iIndexOf == -1 && matcher.usePattern(f15042b).matches()) {
                iIndexOf = f15042b.pattern().indexOf(matcher.group(1).toLowerCase(Locale.US)) / 4;
            } else if (i7 == -1 && matcher.usePattern(f15041a).matches()) {
                i7 = Integer.parseInt(matcher.group(1));
            }
            iM15575a = m15575a(str, iM15575a2 + 1, i2, false);
        }
        if (i7 >= 70 && i7 <= 99) {
            i7 += 1900;
        }
        if (i7 >= 0 && i7 <= 69) {
            i7 += 2000;
        }
        if (i7 < 1601) {
            throw new IllegalArgumentException();
        }
        if (iIndexOf == -1) {
            throw new IllegalArgumentException();
        }
        if (i6 < 1 || i6 > 31) {
            throw new IllegalArgumentException();
        }
        if (i3 < 0 || i3 > 23) {
            throw new IllegalArgumentException();
        }
        if (i4 < 0 || i4 > 59) {
            throw new IllegalArgumentException();
        }
        if (i5 < 0 || i5 > 59) {
            throw new IllegalArgumentException();
        }
        GregorianCalendar gregorianCalendar = new GregorianCalendar(Util.f15242f);
        gregorianCalendar.setLenient(false);
        gregorianCalendar.set(1, i7);
        gregorianCalendar.set(2, iIndexOf - 1);
        gregorianCalendar.set(5, i6);
        gregorianCalendar.set(11, i3);
        gregorianCalendar.set(12, i4);
        gregorianCalendar.set(13, i5);
        gregorianCalendar.set(14, 0);
        return gregorianCalendar.getTimeInMillis();
    }

    /* JADX INFO: renamed from: a */
    private static int m15575a(String str, int i, int i2, boolean z) {
        for (int i3 = i; i3 < i2; i3++) {
            char cCharAt = str.charAt(i3);
            if (((cCharAt < ' ' && cCharAt != '\t') || cCharAt >= 127 || (cCharAt >= '0' && cCharAt <= '9') || ((cCharAt >= 'a' && cCharAt <= 'z') || ((cCharAt >= 'A' && cCharAt <= 'Z') || cCharAt == ':'))) == (!z)) {
                return i3;
            }
        }
        return i2;
    }

    /* JADX INFO: renamed from: a */
    private static long m15576a(String str) {
        try {
            long j = Long.parseLong(str);
            if (j <= 0) {
                return Long.MIN_VALUE;
            }
            return j;
        } catch (NumberFormatException e) {
            if (str.matches("-?\\d+")) {
                return !str.startsWith("-") ? Long.MAX_VALUE : Long.MIN_VALUE;
            }
            throw e;
        }
    }

    /* JADX INFO: renamed from: b */
    private static String m15582b(String str) {
        if (str.endsWith(FileUtils.HIDDEN_PREFIX)) {
            throw new IllegalArgumentException();
        }
        if (str.startsWith(FileUtils.HIDDEN_PREFIX)) {
            str = str.substring(1);
        }
        String strM15835a = Util.m15835a(str);
        if (strM15835a == null) {
            throw new IllegalArgumentException();
        }
        return strM15835a;
    }

    /* JADX INFO: renamed from: a */
    public static List<Cookie> m15578a(HttpUrl httpUrl, Headers headers) {
        List<String> listM15621b = headers.m15621b("Set-Cookie");
        ArrayList arrayList = null;
        int size = listM15621b.size();
        for (int i = 0; i < size; i++) {
            Cookie cookieM15580a = m15580a(httpUrl, listM15621b.get(i));
            if (cookieM15580a != null) {
                ArrayList arrayList2 = arrayList == null ? new ArrayList() : arrayList;
                arrayList2.add(cookieM15580a);
                arrayList = arrayList2;
            }
        }
        if (arrayList != null) {
            return Collections.unmodifiableList(arrayList);
        }
        return Collections.emptyList();
    }

    public String toString() {
        return m15584a(false);
    }

    /* JADX INFO: renamed from: a */
    String m15584a(boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f15045e);
        sb.append('=');
        sb.append(this.f15046f);
        if (this.f15052l) {
            if (this.f15047g == Long.MIN_VALUE) {
                sb.append("; max-age=0");
            } else {
                sb.append("; expires=").append(HttpDate.m15965a(new Date(this.f15047g)));
            }
        }
        if (!this.f15053m) {
            sb.append("; domain=");
            if (z) {
                sb.append(FileUtils.HIDDEN_PREFIX);
            }
            sb.append(this.f15048h);
        }
        sb.append("; path=").append(this.f15049i);
        if (this.f15050j) {
            sb.append("; secure");
        }
        if (this.f15051k) {
            sb.append("; httponly");
        }
        return sb.toString();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Cookie)) {
            return false;
        }
        Cookie cookie = (Cookie) obj;
        return cookie.f15045e.equals(this.f15045e) && cookie.f15046f.equals(this.f15046f) && cookie.f15048h.equals(this.f15048h) && cookie.f15049i.equals(this.f15049i) && cookie.f15047g == this.f15047g && cookie.f15050j == this.f15050j && cookie.f15051k == this.f15051k && cookie.f15052l == this.f15052l && cookie.f15053m == this.f15053m;
    }

    public int hashCode() {
        return (((this.f15052l ? 0 : 1) + (((this.f15051k ? 0 : 1) + (((this.f15050j ? 0 : 1) + ((((((((((this.f15045e.hashCode() + 527) * 31) + this.f15046f.hashCode()) * 31) + this.f15048h.hashCode()) * 31) + this.f15049i.hashCode()) * 31) + ((int) (this.f15047g ^ (this.f15047g >>> 32)))) * 31)) * 31)) * 31)) * 31) + (this.f15053m ? 0 : 1);
    }
}
