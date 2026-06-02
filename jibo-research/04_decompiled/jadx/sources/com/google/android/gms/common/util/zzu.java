package com.google.android.gms.common.util;

import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public final class zzu {

    /* JADX INFO: renamed from: a */
    private static final Pattern f6698a = Pattern.compile("\\$\\{(.*?)\\}");

    /* JADX INFO: renamed from: a */
    public static boolean m7520a(String str) {
        return str == null || str.trim().isEmpty();
    }
}
