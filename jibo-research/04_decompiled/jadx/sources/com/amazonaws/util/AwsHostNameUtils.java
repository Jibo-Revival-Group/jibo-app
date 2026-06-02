package com.amazonaws.util;

import com.amazonaws.regions.Regions;
import com.jibo.aws.integration.util.Commons;
import java.net.URI;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public class AwsHostNameUtils {
    private static final Pattern S3_ENDPOINT_PATTERN = Pattern.compile("^(?:.+\\.)?s3[.-]([a-z0-9-]+)$");

    public static String parseRegionName(String str, String str2) {
        if (str.endsWith(".jibo.com")) {
            return parseStandardRegionName(str.substring(0, str.length() - ".jibo.com".length()));
        }
        if (str2 != null) {
            Matcher matcher = Pattern.compile("^(?:.+\\.)?" + Pattern.quote(str2) + "[.-]([a-z0-9-]+)\\.").matcher(str);
            if (matcher.find()) {
                return matcher.group(1);
            }
        }
        return "api-dev";
    }

    @Deprecated
    public static String parseServiceName(URI uri) {
        String host = uri.getHost();
        if (!host.endsWith(Commons.DEFAULT_DOMAIN)) {
            throw new IllegalArgumentException("Cannot parse a service name from an unrecognized endpoint (" + host + ").");
        }
        String strSubstring = host.substring(0, host.indexOf(".jibo.com"));
        return (strSubstring.endsWith(".s3") || S3_ENDPOINT_PATTERN.matcher(strSubstring).matches()) ? "s3" : strSubstring.indexOf(46) != -1 ? strSubstring.substring(0, strSubstring.indexOf(46)) : strSubstring;
    }

    private static String parseStandardRegionName(String str) {
        return Regions.ApiDev.getName();
    }
}
