package com.amazonaws.http;

/* JADX INFO: loaded from: classes.dex */
public interface HttpClient {
    HttpResponse execute(HttpRequest httpRequest);

    void shutdown();
}
