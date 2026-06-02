package com.google.api.services.youtube.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

/* JADX INFO: loaded from: classes.dex */
public final class GuideCategorySnippet extends GenericJson {

    @Key
    private String channelId;

    @Key
    private String title;

    public String getChannelId() {
        return this.channelId;
    }

    public GuideCategorySnippet setChannelId(String str) {
        this.channelId = str;
        return this;
    }

    public String getTitle() {
        return this.title;
    }

    public GuideCategorySnippet setTitle(String str) {
        this.title = str;
        return this;
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public GuideCategorySnippet set(String str, Object obj) {
        return (GuideCategorySnippet) super.set(str, obj);
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public GuideCategorySnippet clone() {
        return (GuideCategorySnippet) super.clone();
    }
}
