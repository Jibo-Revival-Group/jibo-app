package com.google.android.gms.common.internal;

/* JADX INFO: loaded from: classes.dex */
public final class zzal {

    /* JADX INFO: renamed from: a */
    private static int f6559a = 15;

    /* JADX INFO: renamed from: b */
    private static final String f6560b = null;

    /* JADX INFO: renamed from: c */
    private final String f6561c;

    /* JADX INFO: renamed from: d */
    private final String f6562d;

    public zzal(String str) {
        this(str, null);
    }

    public zzal(String str, String str2) {
        zzbq.m7374a(str, (Object) "log tag cannot be null");
        zzbq.m7384b(str.length() <= 23, "tag \"%s\" is longer than the %d character maximum", str, 23);
        this.f6561c = str;
        if (str2 == null || str2.length() <= 0) {
            this.f6562d = null;
        } else {
            this.f6562d = str2;
        }
    }
}
