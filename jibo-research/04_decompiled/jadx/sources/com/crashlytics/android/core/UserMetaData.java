package com.crashlytics.android.core;

/* JADX INFO: loaded from: classes.dex */
public class UserMetaData {

    /* JADX INFO: renamed from: a */
    public static final UserMetaData f5341a = new UserMetaData();

    /* JADX INFO: renamed from: b */
    public final String f5342b;

    /* JADX INFO: renamed from: c */
    public final String f5343c;

    /* JADX INFO: renamed from: d */
    public final String f5344d;

    public UserMetaData() {
        this(null, null, null);
    }

    public UserMetaData(String str, String str2, String str3) {
        this.f5342b = str;
        this.f5343c = str2;
        this.f5344d = str3;
    }

    /* JADX INFO: renamed from: a */
    public boolean m6000a() {
        return this.f5342b == null && this.f5343c == null && this.f5344d == null;
    }
}
