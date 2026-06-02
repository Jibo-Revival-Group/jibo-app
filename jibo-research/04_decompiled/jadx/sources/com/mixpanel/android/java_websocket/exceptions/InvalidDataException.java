package com.mixpanel.android.java_websocket.exceptions;

/* JADX INFO: loaded from: classes.dex */
public class InvalidDataException extends Exception {

    /* JADX INFO: renamed from: a */
    private int f11778a;

    public InvalidDataException(int i) {
        this.f11778a = i;
    }

    public InvalidDataException(int i, String str) {
        super(str);
        this.f11778a = i;
    }

    public InvalidDataException(int i, Throwable th) {
        super(th);
        this.f11778a = i;
    }

    /* JADX INFO: renamed from: a */
    public int m11619a() {
        return this.f11778a;
    }
}
