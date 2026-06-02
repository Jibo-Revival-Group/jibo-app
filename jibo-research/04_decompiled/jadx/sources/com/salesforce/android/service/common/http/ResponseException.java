package com.salesforce.android.service.common.http;

/* JADX INFO: loaded from: classes.dex */
public class ResponseException extends Exception {

    /* JADX INFO: renamed from: a */
    final int f13466a;

    /* JADX INFO: renamed from: b */
    final String f13467b;

    public ResponseException(String str, int i, String str2) {
        super(str);
        this.f13466a = i;
        this.f13467b = str2;
    }

    /* JADX INFO: renamed from: a */
    public int m13779a() {
        return this.f13466a;
    }

    /* JADX INFO: renamed from: b */
    public String m13780b() {
        return this.f13467b;
    }
}
