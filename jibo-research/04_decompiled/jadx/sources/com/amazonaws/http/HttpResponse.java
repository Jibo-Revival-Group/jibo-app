package com.amazonaws.http;

import java.io.InputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.GZIPInputStream;

/* JADX INFO: loaded from: classes.dex */
public class HttpResponse {
    private InputStream content;
    private final Map<String, String> headers;
    private final InputStream rawContent;
    private final int statusCode;
    private final String statusText;

    public static class Builder {
        private InputStream content;
        private final Map<String, String> headers = new HashMap();
        private int statusCode;
        private String statusText;

        public HttpResponse build() {
            return new HttpResponse(this.statusText, this.statusCode, Collections.unmodifiableMap(this.headers), this.content);
        }

        public Builder content(InputStream inputStream) {
            this.content = inputStream;
            return this;
        }

        public Builder header(String str, String str2) {
            this.headers.put(str, str2);
            return this;
        }

        public Builder statusCode(int i) {
            this.statusCode = i;
            return this;
        }

        public Builder statusText(String str) {
            this.statusText = str;
            return this;
        }
    }

    private HttpResponse(String str, int i, Map<String, String> map, InputStream inputStream) {
        this.statusText = str;
        this.statusCode = i;
        this.headers = map;
        this.rawContent = inputStream;
    }

    public static Builder builder() {
        return new Builder();
    }

    public InputStream getContent() {
        if (this.content == null) {
            synchronized (this) {
                if (this.rawContent == null || !("gzip".equalsIgnoreCase(this.headers.get("Content-Encoding")) || "gzip".equalsIgnoreCase(this.headers.get("content-encoding")))) {
                    this.content = this.rawContent;
                } else {
                    this.content = new GZIPInputStream(this.rawContent);
                }
            }
        }
        return this.content;
    }

    public Map<String, String> getHeaders() {
        return this.headers;
    }

    public InputStream getRawContent() {
        return this.rawContent;
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    public String getStatusText() {
        return this.statusText;
    }

    public void setContent(InputStream inputStream) {
        this.content = inputStream;
    }
}
