package com.google.gson.internal.bind.util;

import java.util.TimeZone;

/* JADX INFO: loaded from: classes.dex */
public class ISO8601Utils {

    /* JADX INFO: renamed from: a */
    private static final TimeZone f9042a = TimeZone.getTimeZone("UTC");

    /* JADX WARN: Removed duplicated region for block: B:45:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0221  */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.util.Date m9623a(java.lang.String r13, java.text.ParsePosition r14) throws java.text.ParseException {
        /*
            Method dump skipped, instruction units count: 608
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.internal.bind.util.ISO8601Utils.m9623a(java.lang.String, java.text.ParsePosition):java.util.Date");
    }

    /* JADX INFO: renamed from: a */
    private static boolean m9624a(String str, int i, char c) {
        return i < str.length() && str.charAt(i) == c;
    }

    /* JADX INFO: renamed from: a */
    private static int m9622a(String str, int i, int i2) throws NumberFormatException {
        int i3;
        if (i < 0 || i2 > str.length() || i > i2) {
            throw new NumberFormatException(str);
        }
        int i4 = 0;
        if (i < i2) {
            i3 = i + 1;
            int iDigit = Character.digit(str.charAt(i), 10);
            if (iDigit < 0) {
                throw new NumberFormatException("Invalid number: " + str.substring(i, i2));
            }
            i4 = -iDigit;
        } else {
            i3 = i;
        }
        while (i3 < i2) {
            int i5 = i3 + 1;
            int iDigit2 = Character.digit(str.charAt(i3), 10);
            if (iDigit2 < 0) {
                throw new NumberFormatException("Invalid number: " + str.substring(i, i2));
            }
            i4 = (i4 * 10) - iDigit2;
            i3 = i5;
        }
        return -i4;
    }

    /* JADX INFO: renamed from: a */
    private static int m9621a(String str, int i) {
        while (i < str.length()) {
            char cCharAt = str.charAt(i);
            if (cCharAt >= '0' && cCharAt <= '9') {
                i++;
            } else {
                return i;
            }
        }
        return str.length();
    }
}
