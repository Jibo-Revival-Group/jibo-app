package com.google.api.client.http;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public interface HttpExecuteInterceptor {
    void intercept(HttpRequest httpRequest) throws IOException;
}
