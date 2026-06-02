package com.amazonaws.util;

import com.amazonaws.Request;
import com.amazonaws.http.HttpMethodName;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLEncoder;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.http.HttpHost;
import org.apache.http.protocol.HTTP;

/* JADX INFO: loaded from: classes.dex */
public class HttpUtils {
    private static final Pattern ENCODED_CHARACTERS_PATTERN;

    static {
        StringBuilder sb = new StringBuilder();
        sb.append(Pattern.quote("+")).append("|").append(Pattern.quote("*")).append("|").append(Pattern.quote("%7E")).append("|").append(Pattern.quote("%2F"));
        ENCODED_CHARACTERS_PATTERN = Pattern.compile(sb.toString());
    }

    public static String appendUri(String str, String str2) {
        return appendUri(str, str2, false);
    }

    public static String appendUri(String str, String str2, boolean z) {
        if (str2 == null || str2.length() <= 0) {
            return !str.endsWith("/") ? str + "/" : str;
        }
        if (str2.startsWith("/")) {
            if (str.endsWith("/")) {
                str = str.substring(0, str.length() - 1);
            }
        } else if (!str.endsWith("/")) {
            str = str + "/";
        }
        String strUrlEncode = urlEncode(str2, true);
        if (z) {
            strUrlEncode = strUrlEncode.replace("//", "/%2F");
        }
        return str + strUrlEncode;
    }

    public static String encodeParameters(Request<?> request) {
        boolean z;
        if (request.getParameters().isEmpty()) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        boolean z2 = true;
        try {
            for (Map.Entry<String, String> entry : request.getParameters().entrySet()) {
                String strEncode = URLEncoder.encode(entry.getKey(), HTTP.UTF_8);
                String value = entry.getValue();
                String strEncode2 = value == null ? "" : URLEncoder.encode(value, HTTP.UTF_8);
                if (z2) {
                    z = false;
                } else {
                    sb.append("&");
                    z = z2;
                }
                sb.append(strEncode).append("=").append(strEncode2);
                z2 = z;
            }
            return sb.toString();
        } catch (UnsupportedEncodingException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static boolean isUsingNonDefaultPort(URI uri) {
        String lowerCase = uri.getScheme().toLowerCase();
        int port = uri.getPort();
        if (port <= 0) {
            return false;
        }
        if (lowerCase.equals(HttpHost.DEFAULT_SCHEME_NAME) && port == 80) {
            return false;
        }
        return (lowerCase.equals("https") && port == 443) ? false : true;
    }

    public static String urlEncode(String str, boolean z) {
        if (str == null) {
            return "";
        }
        try {
            String strEncode = URLEncoder.encode(str, HTTP.UTF_8);
            Matcher matcher = ENCODED_CHARACTERS_PATTERN.matcher(strEncode);
            StringBuffer stringBuffer = new StringBuffer(strEncode.length());
            while (matcher.find()) {
                String strGroup = matcher.group(0);
                if ("+".equals(strGroup)) {
                    strGroup = "%20";
                } else if ("*".equals(strGroup)) {
                    strGroup = "%2A";
                } else if ("%7E".equals(strGroup)) {
                    strGroup = "~";
                } else if (z && "%2F".equals(strGroup)) {
                    strGroup = "/";
                }
                matcher.appendReplacement(stringBuffer, strGroup);
            }
            matcher.appendTail(stringBuffer);
            return stringBuffer.toString();
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean usePayloadForQueryParameters(Request<?> request) {
        return HttpMethodName.POST.equals(request.getHttpMethod()) && (request.getContent() == null);
    }
}
