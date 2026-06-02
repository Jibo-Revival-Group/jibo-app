package com.google.api.services.youtube.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

/* JADX INFO: loaded from: classes.dex */
public final class I18nRegionSnippet extends GenericJson {

    /* JADX INFO: renamed from: gl */
    @Key
    private String f8498gl;

    @Key
    private String name;

    public String getGl() {
        return this.f8498gl;
    }

    public I18nRegionSnippet setGl(String str) {
        this.f8498gl = str;
        return this;
    }

    public String getName() {
        return this.name;
    }

    public I18nRegionSnippet setName(String str) {
        this.name = str;
        return this;
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public I18nRegionSnippet set(String str, Object obj) {
        return (I18nRegionSnippet) super.set(str, obj);
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public I18nRegionSnippet clone() {
        return (I18nRegionSnippet) super.clone();
    }
}
