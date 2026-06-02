package okhttp3.internal.http;

import java.net.Proxy;
import okhttp3.HttpUrl;
import okhttp3.Request;
import org.apache.http.message.TokenParser;

/* JADX INFO: loaded from: classes2.dex */
public final class RequestLine {
    /* JADX INFO: renamed from: a */
    public static String m15992a(Request request, Proxy.Type type) {
        StringBuilder sb = new StringBuilder();
        sb.append(request.m15766b());
        sb.append(TokenParser.f15715SP);
        if (m15993b(request, type)) {
            sb.append(request.m15765a());
        } else {
            sb.append(m15991a(request.m15765a()));
        }
        sb.append(" HTTP/1.1");
        return sb.toString();
    }

    /* JADX INFO: renamed from: b */
    private static boolean m15993b(Request request, Proxy.Type type) {
        return !request.m15772g() && type == Proxy.Type.HTTP;
    }

    /* JADX INFO: renamed from: a */
    public static String m15991a(HttpUrl httpUrl) {
        String strM15656i = httpUrl.m15656i();
        String strM15659l = httpUrl.m15659l();
        return strM15659l != null ? strM15656i + '?' + strM15659l : strM15656i;
    }
}
