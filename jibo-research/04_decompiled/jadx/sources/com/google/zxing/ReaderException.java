package com.google.zxing;

/* JADX INFO: loaded from: classes.dex */
public abstract class ReaderException extends Exception {

    /* JADX INFO: renamed from: a */
    protected static final boolean f9074a;

    static {
        f9074a = System.getProperty("surefire.test.class.path") != null;
    }

    ReaderException() {
    }

    @Override // java.lang.Throwable
    public final Throwable fillInStackTrace() {
        return null;
    }
}
