package com.amazonaws;

import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class ResponseMetadata {
    protected final Map<String, String> metadata;

    public ResponseMetadata(Map<String, String> map) {
        this.metadata = map;
    }

    public String getRequestId() {
        return this.metadata.get("AWS_REQUEST_ID");
    }

    public String toString() {
        return this.metadata == null ? "{}" : this.metadata.toString();
    }
}
