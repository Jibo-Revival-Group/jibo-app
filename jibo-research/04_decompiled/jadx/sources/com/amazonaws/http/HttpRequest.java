package com.amazonaws.http;

import java.io.InputStream;
import java.net.URI;
import java.util.Collections;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class HttpRequest {
    private final InputStream content;
    private final Map<String, String> headers;
    private final String method;
    private URI uri;

    public HttpRequest(String str, URI uri, Map<String, String> map, InputStream inputStream) {
        this.method = str.toUpperCase();
        this.uri = uri;
        this.headers = map == null ? Collections.EMPTY_MAP : Collections.unmodifiableMap(map);
        this.content = inputStream;
    }

    public InputStream getContent() {
        return this.content;
    }

    public long getContentLength() {
        if (this.headers == null) {
            return 0L;
        }
        String str = this.headers.get("Content-Length");
        if (str == null || str.isEmpty()) {
            return 0L;
        }
        return Long.valueOf(str).longValue();
    }

    public Map<String, String> getHeaders() {
        return this.headers;
    }

    public String getMethod() {
        return this.method;
    }

    public URI getUri() {
        return this.uri;
    }

    void setUri(URI uri) {
        this.uri = uri;
    }
}
