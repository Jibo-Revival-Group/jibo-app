package okhttp3.internal.http;

import com.google.api.client.http.HttpMethods;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Pattern;
import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.Util;
import org.apache.http.protocol.HTTP;

/* JADX INFO: loaded from: classes2.dex */
public final class HttpHeaders {

    /* JADX INFO: renamed from: a */
    private static final Pattern f15368a = Pattern.compile(" +([^ \"=]*)=(:?\"([^\"]*)\"|([^ \"=]*)) *(:?,|$)");

    /* JADX INFO: renamed from: a */
    public static long m15972a(Response response) {
        return m15971a(response.m15797g());
    }

    /* JADX INFO: renamed from: a */
    public static long m15971a(Headers headers) {
        return m15970a(headers.m15619a("Content-Length"));
    }

    /* JADX INFO: renamed from: a */
    private static long m15970a(String str) {
        if (str == null) {
            return -1L;
        }
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException e) {
            return -1L;
        }
    }

    /* JADX INFO: renamed from: a */
    public static boolean m15975a(Response response, Headers headers, Request request) {
        for (String str : m15982e(response)) {
            if (!Util.m15846a(headers.m15621b(str), request.m15767b(str))) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: renamed from: b */
    public static boolean m15978b(Response response) {
        return m15977b(response.m15797g());
    }

    /* JADX INFO: renamed from: b */
    public static boolean m15977b(Headers headers) {
        return m15979c(headers).contains("*");
    }

    /* JADX INFO: renamed from: e */
    private static Set<String> m15982e(Response response) {
        return m15979c(response.m15797g());
    }

    /* JADX INFO: renamed from: c */
    public static Set<String> m15979c(Headers headers) {
        Set<String> setEmptySet = Collections.emptySet();
        int iM15617a = headers.m15617a();
        for (int i = 0; i < iM15617a; i++) {
            if (org.apache.http.HttpHeaders.VARY.equalsIgnoreCase(headers.m15618a(i))) {
                String strM15620b = headers.m15620b(i);
                if (setEmptySet.isEmpty()) {
                    setEmptySet = new TreeSet<>((Comparator<? super String>) String.CASE_INSENSITIVE_ORDER);
                }
                String[] strArrSplit = strM15620b.split(",");
                for (String str : strArrSplit) {
                    setEmptySet.add(str.trim());
                }
            }
        }
        return setEmptySet;
    }

    /* JADX INFO: renamed from: c */
    public static Headers m15980c(Response response) {
        return m15973a(response.m15800j().m15791a().m15768c(), response.m15797g());
    }

    /* JADX INFO: renamed from: a */
    public static Headers m15973a(Headers headers, Headers headers2) {
        Set<String> setM15979c = m15979c(headers2);
        if (setM15979c.isEmpty()) {
            return new Headers.Builder().m15626a();
        }
        Headers.Builder builder = new Headers.Builder();
        int iM15617a = headers.m15617a();
        for (int i = 0; i < iM15617a; i++) {
            String strM15618a = headers.m15618a(i);
            if (setM15979c.contains(strM15618a)) {
                builder.m15625a(strM15618a, headers.m15620b(i));
            }
        }
        return builder.m15626a();
    }

    /* JADX INFO: renamed from: a */
    public static void m15974a(CookieJar cookieJar, HttpUrl httpUrl, Headers headers) {
        if (cookieJar != CookieJar.f15054a) {
            List<Cookie> listM15578a = Cookie.m15578a(httpUrl, headers);
            if (!listM15578a.isEmpty()) {
                cookieJar.mo15587a(httpUrl, listM15578a);
            }
        }
    }

    /* JADX INFO: renamed from: d */
    public static boolean m15981d(Response response) {
        if (response.m15791a().m15766b().equals(HttpMethods.HEAD)) {
            return false;
        }
        int iM15793c = response.m15793c();
        if ((iM15793c >= 100 && iM15793c < 200) || iM15793c == 204 || iM15793c == 304) {
            return m15972a(response) != -1 || HTTP.CHUNK_CODING.equalsIgnoreCase(response.m15789a("Transfer-Encoding"));
        }
        return true;
    }

    /* JADX INFO: renamed from: a */
    public static int m15969a(String str, int i, String str2) {
        while (i < str.length() && str2.indexOf(str.charAt(i)) == -1) {
            i++;
        }
        return i;
    }

    /* JADX INFO: renamed from: a */
    public static int m15968a(String str, int i) {
        char cCharAt;
        while (i < str.length() && ((cCharAt = str.charAt(i)) == ' ' || cCharAt == '\t')) {
            i++;
        }
        return i;
    }

    /* JADX INFO: renamed from: b */
    public static int m15976b(String str, int i) {
        try {
            long j = Long.parseLong(str);
            if (j > 2147483647L) {
                return Integer.MAX_VALUE;
            }
            if (j < 0) {
                return 0;
            }
            return (int) j;
        } catch (NumberFormatException e) {
            return i;
        }
    }
}
