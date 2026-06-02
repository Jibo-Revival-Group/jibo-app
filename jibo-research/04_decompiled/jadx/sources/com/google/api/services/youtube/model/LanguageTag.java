package com.google.api.services.youtube.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

/* JADX INFO: loaded from: classes.dex */
public final class LanguageTag extends GenericJson {

    @Key
    private String value;

    public String getValue() {
        return this.value;
    }

    public LanguageTag setValue(String str) {
        this.value = str;
        return this;
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public LanguageTag set(String str, Object obj) {
        return (LanguageTag) super.set(str, obj);
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public LanguageTag clone() {
        return (LanguageTag) super.clone();
    }
}
