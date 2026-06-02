package com.mixpanel.android.java_websocket.exceptions;

/* JADX INFO: loaded from: classes.dex */
public class InvalidFrameException extends InvalidDataException {
    public InvalidFrameException() {
        super(1002);
    }

    public InvalidFrameException(String str) {
        super(1002, str);
    }

    public InvalidFrameException(Throwable th) {
        super(1002, th);
    }
}
