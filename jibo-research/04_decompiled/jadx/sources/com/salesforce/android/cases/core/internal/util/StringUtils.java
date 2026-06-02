package com.salesforce.android.cases.core.internal.util;

import android.text.Html;
import android.text.Spanned;

/* JADX INFO: loaded from: classes.dex */
public class StringUtils {
    /* JADX INFO: renamed from: a */
    public static boolean m12616a(String str) {
        return str == null || str.trim().length() == 0;
    }

    /* JADX INFO: renamed from: b */
    public static boolean m12617b(String str) {
        return !m12616a(str);
    }

    /* JADX INFO: renamed from: c */
    public static String m12618c(String str) {
        return m12616a(str) ? str : str.replace("\"", "");
    }

    /* JADX INFO: renamed from: d */
    public static String m12619d(String str) {
        Spanned spannedFromHtml;
        return (m12616a(str) || (spannedFromHtml = Html.fromHtml(str)) == null) ? str : spannedFromHtml.toString().trim();
    }
}
