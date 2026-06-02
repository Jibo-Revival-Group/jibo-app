package com.google.android.gms.common.api;

/* JADX INFO: loaded from: classes.dex */
public class ApiException extends Exception {

    /* JADX INFO: renamed from: a */
    protected final Status f6091a;

    /* JADX WARN: Illegal instructions before constructor call */
    public ApiException(Status status) {
        int iM6936d = status.m6936d();
        String strM6934b = status.m6934b() != null ? status.m6934b() : "";
        super(new StringBuilder(String.valueOf(strM6934b).length() + 13).append(iM6936d).append(": ").append(strM6934b).toString());
        this.f6091a = status;
    }
}
