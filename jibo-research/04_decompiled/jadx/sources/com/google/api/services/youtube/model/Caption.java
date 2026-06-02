package com.google.api.services.youtube.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

/* JADX INFO: loaded from: classes.dex */
public final class Caption extends GenericJson {

    @Key
    private String etag;

    /* JADX INFO: renamed from: id */
    @Key
    private String f8488id;

    @Key
    private String kind;

    @Key
    private CaptionSnippet snippet;

    public String getEtag() {
        return this.etag;
    }

    public Caption setEtag(String str) {
        this.etag = str;
        return this;
    }

    public String getId() {
        return this.f8488id;
    }

    public Caption setId(String str) {
        this.f8488id = str;
        return this;
    }

    public String getKind() {
        return this.kind;
    }

    public Caption setKind(String str) {
        this.kind = str;
        return this;
    }

    public CaptionSnippet getSnippet() {
        return this.snippet;
    }

    public Caption setSnippet(CaptionSnippet captionSnippet) {
        this.snippet = captionSnippet;
        return this;
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public Caption set(String str, Object obj) {
        return (Caption) super.set(str, obj);
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public Caption clone() {
        return (Caption) super.clone();
    }
}
