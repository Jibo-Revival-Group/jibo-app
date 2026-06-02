package com.google.api.services.youtube.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

/* JADX INFO: loaded from: classes.dex */
public final class I18nLanguage extends GenericJson {

    @Key
    private String etag;

    /* JADX INFO: renamed from: id */
    @Key
    private String f8495id;

    @Key
    private String kind;

    @Key
    private I18nLanguageSnippet snippet;

    public String getEtag() {
        return this.etag;
    }

    public I18nLanguage setEtag(String str) {
        this.etag = str;
        return this;
    }

    public String getId() {
        return this.f8495id;
    }

    public I18nLanguage setId(String str) {
        this.f8495id = str;
        return this;
    }

    public String getKind() {
        return this.kind;
    }

    public I18nLanguage setKind(String str) {
        this.kind = str;
        return this;
    }

    public I18nLanguageSnippet getSnippet() {
        return this.snippet;
    }

    public I18nLanguage setSnippet(I18nLanguageSnippet i18nLanguageSnippet) {
        this.snippet = i18nLanguageSnippet;
        return this;
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public I18nLanguage set(String str, Object obj) {
        return (I18nLanguage) super.set(str, obj);
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public I18nLanguage clone() {
        return (I18nLanguage) super.clone();
    }
}
