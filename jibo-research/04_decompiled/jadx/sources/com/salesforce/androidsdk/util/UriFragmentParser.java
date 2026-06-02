package com.salesforce.androidsdk.util;

import android.net.Uri;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.protocol.HTTP;

/* JADX INFO: loaded from: classes.dex */
public class UriFragmentParser {

    /* JADX INFO: renamed from: a */
    static final /* synthetic */ boolean f14463a;

    static {
        f14463a = !UriFragmentParser.class.desiredAssertionStatus();
    }

    /* JADX INFO: renamed from: a */
    public static Map<String, String> m15021a(Uri uri) {
        Map<String, String> mapM15022a = m15022a(uri.getEncodedFragment());
        if (mapM15022a.size() == 0) {
            return m15022a(uri.getEncodedQuery());
        }
        return mapM15022a;
    }

    /* JADX INFO: renamed from: a */
    public static Map<String, String> m15022a(String str) {
        HashMap map = new HashMap();
        if (str != null) {
            String strTrim = str.trim();
            if (strTrim.length() != 0) {
                String[] strArrSplit = strTrim.split("&");
                for (String str2 : strArrSplit) {
                    String[] strArrSplit2 = str2.split("=");
                    try {
                        map.put(URLDecoder.decode(strArrSplit2[0], HTTP.UTF_8), strArrSplit2.length > 1 ? URLDecoder.decode(strArrSplit2[1], HTTP.UTF_8) : "");
                    } catch (UnsupportedEncodingException e) {
                        SalesforceSDKLogger.m15016a("UriFragmentParser", "Unsupported encoding", e);
                    }
                }
            }
        }
        return map;
    }

    private UriFragmentParser() {
        if (!f14463a) {
            throw new AssertionError("don't construct me!");
        }
    }
}
