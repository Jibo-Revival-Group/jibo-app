package com.google.api.services.youtube.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

/* JADX INFO: loaded from: classes.dex */
public final class ChannelSectionLocalization extends GenericJson {

    @Key
    private String title;

    public String getTitle() {
        return this.title;
    }

    public ChannelSectionLocalization setTitle(String str) {
        this.title = str;
        return this;
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public ChannelSectionLocalization set(String str, Object obj) {
        return (ChannelSectionLocalization) super.set(str, obj);
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public ChannelSectionLocalization clone() {
        return (ChannelSectionLocalization) super.clone();
    }
}
