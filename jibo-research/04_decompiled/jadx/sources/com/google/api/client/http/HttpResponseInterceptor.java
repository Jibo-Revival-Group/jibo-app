package com.google.api.client.http;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public interface HttpResponseInterceptor {
    void interceptResponse(HttpResponse httpResponse) throws IOException;
}
