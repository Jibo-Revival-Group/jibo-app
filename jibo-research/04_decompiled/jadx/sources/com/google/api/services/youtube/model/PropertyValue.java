package com.google.api.services.youtube.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

/* JADX INFO: loaded from: classes.dex */
public final class PropertyValue extends GenericJson {

    @Key
    private String property;

    @Key
    private String value;

    public String getProperty() {
        return this.property;
    }

    public PropertyValue setProperty(String str) {
        this.property = str;
        return this;
    }

    public String getValue() {
        return this.value;
    }

    public PropertyValue setValue(String str) {
        this.value = str;
        return this;
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public PropertyValue set(String str, Object obj) {
        return (PropertyValue) super.set(str, obj);
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public PropertyValue clone() {
        return (PropertyValue) super.clone();
    }
}
