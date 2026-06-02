package com.amazonaws;

/* JADX INFO: loaded from: classes.dex */
public class AmazonClientException extends RuntimeException {
    private static final long serialVersionUID = 1;

    public AmazonClientException(String str) {
        super(str);
    }

    public AmazonClientException(String str, Throwable th) {
        super(str, th);
    }

    public boolean isRetryable() {
        return true;
    }
}
