package com.amazonaws.util;

import com.jibo.aws.integration.util.C0977a;
import org.apache.http.message.TokenParser;

/* JADX INFO: loaded from: classes.dex */
public class VersionInfoUtils {
    private static volatile String userAgent;
    public static final String TAG = C0977a.m10070a(VersionInfoUtils.class);
    private static volatile String version = "2.2.7";
    private static volatile String platform = "android";

    public static String getPlatform() {
        return platform;
    }

    public static String getUserAgent() {
        if (userAgent == null) {
            synchronized (VersionInfoUtils.class) {
                if (userAgent == null) {
                    initializeUserAgent();
                }
            }
        }
        return userAgent;
    }

    public static String getVersion() {
        return version;
    }

    private static void initializeUserAgent() {
        userAgent = userAgent();
    }

    private static String replaceSpaces(String str) {
        return str.replace(TokenParser.f15715SP, '_');
    }

    static String userAgent() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("aws-sdk-");
        sb.append(getPlatform().toLowerCase());
        sb.append("/");
        sb.append(getVersion());
        sb.append(" ");
        sb.append(replaceSpaces(System.getProperty("os.name")));
        sb.append("/");
        sb.append(replaceSpaces(System.getProperty("os.version")));
        sb.append(" ");
        sb.append(replaceSpaces(System.getProperty("java.vm.name")));
        sb.append("/");
        sb.append(replaceSpaces(System.getProperty("java.vm.version")));
        sb.append("/");
        sb.append(replaceSpaces(System.getProperty("java.version")));
        String property = System.getProperty("user.language");
        String property2 = System.getProperty("user.region");
        if (property != null && property2 != null) {
            sb.append(" ");
            sb.append(replaceSpaces(property));
            sb.append("_");
            sb.append(replaceSpaces(property2));
        }
        return sb.toString();
    }
}
