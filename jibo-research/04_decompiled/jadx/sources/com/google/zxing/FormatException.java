package com.google.zxing;

/* JADX INFO: loaded from: classes.dex */
public final class FormatException extends ReaderException {

    /* JADX INFO: renamed from: b */
    private static final FormatException f9073b = new FormatException();

    private FormatException() {
    }

    /* JADX INFO: renamed from: a */
    public static FormatException m9662a() {
        return f9074a ? new FormatException() : f9073b;
    }
}
