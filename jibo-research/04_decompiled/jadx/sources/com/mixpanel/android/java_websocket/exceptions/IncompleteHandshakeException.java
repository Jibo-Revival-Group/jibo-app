package com.mixpanel.android.java_websocket.exceptions;

/* JADX INFO: loaded from: classes.dex */
public class IncompleteHandshakeException extends RuntimeException {

    /* JADX INFO: renamed from: a */
    private int f11777a;

    public IncompleteHandshakeException(int i) {
        this.f11777a = i;
    }

    public IncompleteHandshakeException() {
        this.f11777a = 0;
    }

    /* JADX INFO: renamed from: a */
    public int m11618a() {
        return this.f11777a;
    }
}
