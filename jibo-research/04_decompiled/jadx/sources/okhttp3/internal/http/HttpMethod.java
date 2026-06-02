package okhttp3.internal.http;

import com.google.api.client.http.HttpMethods;

/* JADX INFO: loaded from: classes2.dex */
public final class HttpMethod {
    /* JADX INFO: renamed from: a */
    public static boolean m15983a(String str) {
        return str.equals(HttpMethods.POST) || str.equals(HttpMethods.PATCH) || str.equals(HttpMethods.PUT) || str.equals(HttpMethods.DELETE) || str.equals("MOVE");
    }

    /* JADX INFO: renamed from: b */
    public static boolean m15984b(String str) {
        return str.equals(HttpMethods.POST) || str.equals(HttpMethods.PUT) || str.equals(HttpMethods.PATCH) || str.equals("PROPPATCH") || str.equals("REPORT");
    }

    /* JADX INFO: renamed from: c */
    public static boolean m15985c(String str) {
        return m15984b(str) || str.equals(HttpMethods.OPTIONS) || str.equals(HttpMethods.DELETE) || str.equals("PROPFIND") || str.equals("MKCOL") || str.equals("LOCK");
    }

    /* JADX INFO: renamed from: d */
    public static boolean m15986d(String str) {
        return str.equals("PROPFIND");
    }

    /* JADX INFO: renamed from: e */
    public static boolean m15987e(String str) {
        return !str.equals("PROPFIND");
    }
}
