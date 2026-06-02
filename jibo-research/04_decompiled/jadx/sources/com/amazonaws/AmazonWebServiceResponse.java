package com.amazonaws;

/* JADX INFO: loaded from: classes.dex */
public class AmazonWebServiceResponse<T> {
    private ResponseMetadata responseMetadata;
    private T result;

    public String getRequestId() {
        if (this.responseMetadata == null) {
            return null;
        }
        return this.responseMetadata.getRequestId();
    }

    public T getResult() {
        return this.result;
    }

    public void setResponseMetadata(ResponseMetadata responseMetadata) {
        this.responseMetadata = responseMetadata;
    }

    public void setResult(T t) {
        this.result = t;
    }
}
