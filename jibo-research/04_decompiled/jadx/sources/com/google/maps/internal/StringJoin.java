package com.google.maps.internal;

/* JADX INFO: loaded from: classes.dex */
public class StringJoin {

    public interface UrlValue {
        String toUrlValue();
    }

    private StringJoin() {
    }

    public static String join(char c, String... strArr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strArr.length; i++) {
            if (i != 0) {
                sb.append(c);
            }
            sb.append(strArr[i]);
        }
        return sb.toString();
    }

    public static String join(char c, UrlValue... urlValueArr) {
        int i = 0;
        String[] strArr = new String[urlValueArr.length];
        int length = urlValueArr.length;
        int i2 = 0;
        while (i < length) {
            strArr[i2] = urlValueArr[i].toString();
            i++;
            i2++;
        }
        return join(c, strArr);
    }
}
