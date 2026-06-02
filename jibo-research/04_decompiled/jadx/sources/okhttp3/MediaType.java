package okhttp3;

import java.nio.charset.Charset;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes2.dex */
public final class MediaType {

    /* JADX INFO: renamed from: a */
    private static final Pattern f15094a = Pattern.compile("([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)/([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)");

    /* JADX INFO: renamed from: b */
    private static final Pattern f15095b = Pattern.compile(";\\s*(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)=(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)|\"([^\"]*)\"))?");

    /* JADX INFO: renamed from: c */
    private final String f15096c;

    /* JADX INFO: renamed from: d */
    private final String f15097d;

    /* JADX INFO: renamed from: e */
    private final String f15098e;

    /* JADX INFO: renamed from: f */
    private final String f15099f;

    private MediaType(String str, String str2, String str3, String str4) {
        this.f15096c = str;
        this.f15097d = str2;
        this.f15098e = str3;
        this.f15099f = str4;
    }

    /* JADX INFO: renamed from: a */
    public static MediaType m15695a(String str) {
        Matcher matcher = f15094a.matcher(str);
        if (!matcher.lookingAt()) {
            return null;
        }
        String lowerCase = matcher.group(1).toLowerCase(Locale.US);
        String lowerCase2 = matcher.group(2).toLowerCase(Locale.US);
        Matcher matcher2 = f15095b.matcher(str);
        String str2 = null;
        for (int iEnd = matcher.end(); iEnd < str.length(); iEnd = matcher2.end()) {
            matcher2.region(iEnd, str.length());
            if (!matcher2.lookingAt()) {
                return null;
            }
            String strGroup = matcher2.group(1);
            if (strGroup != null && strGroup.equalsIgnoreCase("charset")) {
                String strGroup2 = matcher2.group(2);
                if (strGroup2 != null) {
                    if (strGroup2.startsWith("'") && strGroup2.endsWith("'") && strGroup2.length() > 2) {
                        strGroup2 = strGroup2.substring(1, strGroup2.length() - 1);
                    }
                } else {
                    strGroup2 = matcher2.group(3);
                }
                if (str2 != null && !strGroup2.equalsIgnoreCase(str2)) {
                    return null;
                }
                str2 = strGroup2;
            }
        }
        return new MediaType(str, lowerCase, lowerCase2, str2);
    }

    /* JADX INFO: renamed from: a */
    public String m15696a() {
        return this.f15097d;
    }

    /* JADX INFO: renamed from: b */
    public Charset m15698b() {
        return m15697a((Charset) null);
    }

    /* JADX INFO: renamed from: a */
    public Charset m15697a(Charset charset) {
        try {
            return this.f15099f != null ? Charset.forName(this.f15099f) : charset;
        } catch (IllegalArgumentException e) {
            return charset;
        }
    }

    public String toString() {
        return this.f15096c;
    }

    public boolean equals(Object obj) {
        return (obj instanceof MediaType) && ((MediaType) obj).f15096c.equals(this.f15096c);
    }

    public int hashCode() {
        return this.f15096c.hashCode();
    }
}
