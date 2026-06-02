package com.google.android.gms.internal;

/* JADX INFO: loaded from: classes.dex */
public class zzbey<T> {

    /* JADX INFO: renamed from: a */
    private static final Object f6924a = new Object();

    /* JADX INFO: renamed from: b */
    private static zzbfe f6925b = null;

    /* JADX INFO: renamed from: c */
    private static int f6926c = 0;

    /* JADX INFO: renamed from: d */
    private static String f6927d = "com.google.android.providers.gsf.permission.READ_GSERVICES";

    /* JADX INFO: renamed from: e */
    private String f6928e;

    /* JADX INFO: renamed from: f */
    private T f6929f;

    /* JADX INFO: renamed from: g */
    private T f6930g = null;

    protected zzbey(String str, T t) {
        this.f6928e = str;
        this.f6929f = t;
    }

    /* JADX INFO: renamed from: a */
    public static zzbey<Integer> m7691a(String str, Integer num) {
        return new zzbfb(str, num);
    }

    /* JADX INFO: renamed from: a */
    public static zzbey<Long> m7692a(String str, Long l) {
        return new zzbfa(str, l);
    }

    /* JADX INFO: renamed from: a */
    public static zzbey<String> m7693a(String str, String str2) {
        return new zzbfd(str, str2);
    }

    /* JADX INFO: renamed from: a */
    public static zzbey<Boolean> m7694a(String str, boolean z) {
        return new zzbez(str, Boolean.valueOf(z));
    }
}
