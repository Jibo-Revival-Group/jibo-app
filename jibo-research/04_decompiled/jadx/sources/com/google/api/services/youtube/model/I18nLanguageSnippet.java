package com.google.api.services.youtube.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

/* JADX INFO: loaded from: classes.dex */
public final class I18nLanguageSnippet extends GenericJson {

    /* JADX INFO: renamed from: hl */
    @Key
    private String f8496hl;

    @Key
    private String name;

    public String getHl() {
        return this.f8496hl;
    }

    public I18nLanguageSnippet setHl(String str) {
        this.f8496hl = str;
        return this;
    }

    public String getName() {
        return this.name;
    }

    public I18nLanguageSnippet setName(String str) {
        this.name = str;
        return this;
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public I18nLanguageSnippet set(String str, Object obj) {
        return (I18nLanguageSnippet) super.set(str, obj);
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public I18nLanguageSnippet clone() {
        return (I18nLanguageSnippet) super.clone();
    }
}
