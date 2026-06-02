package com.google.api.services.youtube.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

/* JADX INFO: loaded from: classes.dex */
public final class GuideCategory extends GenericJson {

    @Key
    private String etag;

    /* JADX INFO: renamed from: id */
    @Key
    private String f8494id;

    @Key
    private String kind;

    @Key
    private GuideCategorySnippet snippet;

    public String getEtag() {
        return this.etag;
    }

    public GuideCategory setEtag(String str) {
        this.etag = str;
        return this;
    }

    public String getId() {
        return this.f8494id;
    }

    public GuideCategory setId(String str) {
        this.f8494id = str;
        return this;
    }

    public String getKind() {
        return this.kind;
    }

    public GuideCategory setKind(String str) {
        this.kind = str;
        return this;
    }

    public GuideCategorySnippet getSnippet() {
        return this.snippet;
    }

    public GuideCategory setSnippet(GuideCategorySnippet guideCategorySnippet) {
        this.snippet = guideCategorySnippet;
        return this;
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public GuideCategory set(String str, Object obj) {
        return (GuideCategory) super.set(str, obj);
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public GuideCategory clone() {
        return (GuideCategory) super.clone();
    }
}
