package com.amazonaws.http;

/* JADX INFO: loaded from: classes.dex */
public interface HttpResponseHandler<T> {
    T handle(HttpResponse httpResponse);

    boolean needsConnectionLeftOpen();
}
