package com.google.api.services.youtube.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

/* JADX INFO: loaded from: classes.dex */
public final class I18nRegion extends GenericJson {

    @Key
    private String etag;

    /* JADX INFO: renamed from: id */
    @Key
    private String f8497id;

    @Key
    private String kind;

    @Key
    private I18nRegionSnippet snippet;

    public String getEtag() {
        return this.etag;
    }

    public I18nRegion setEtag(String str) {
        this.etag = str;
        return this;
    }

    public String getId() {
        return this.f8497id;
    }

    public I18nRegion setId(String str) {
        this.f8497id = str;
        return this;
    }

    public String getKind() {
        return this.kind;
    }

    public I18nRegion setKind(String str) {
        this.kind = str;
        return this;
    }

    public I18nRegionSnippet getSnippet() {
        return this.snippet;
    }

    public I18nRegion setSnippet(I18nRegionSnippet i18nRegionSnippet) {
        this.snippet = i18nRegionSnippet;
        return this;
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public I18nRegion set(String str, Object obj) {
        return (I18nRegion) super.set(str, obj);
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public I18nRegion clone() {
        return (I18nRegion) super.clone();
    }
}
