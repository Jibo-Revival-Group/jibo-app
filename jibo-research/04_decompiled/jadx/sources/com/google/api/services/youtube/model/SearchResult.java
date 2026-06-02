package com.google.api.services.youtube.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

/* JADX INFO: loaded from: classes.dex */
public final class SearchResult extends GenericJson {

    @Key
    private String etag;

    /* JADX INFO: renamed from: id */
    @Key
    private ResourceId f8509id;

    @Key
    private String kind;

    @Key
    private SearchResultSnippet snippet;

    public String getEtag() {
        return this.etag;
    }

    public SearchResult setEtag(String str) {
        this.etag = str;
        return this;
    }

    public ResourceId getId() {
        return this.f8509id;
    }

    public SearchResult setId(ResourceId resourceId) {
        this.f8509id = resourceId;
        return this;
    }

    public String getKind() {
        return this.kind;
    }

    public SearchResult setKind(String str) {
        this.kind = str;
        return this;
    }

    public SearchResultSnippet getSnippet() {
        return this.snippet;
    }

    public SearchResult setSnippet(SearchResultSnippet searchResultSnippet) {
        this.snippet = searchResultSnippet;
        return this;
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public SearchResult set(String str, Object obj) {
        return (SearchResult) super.set(str, obj);
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public SearchResult clone() {
        return (SearchResult) super.clone();
    }
}
