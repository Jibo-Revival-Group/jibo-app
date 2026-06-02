package com.google.api.services.youtube.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

/* JADX INFO: loaded from: classes.dex */
public final class VideoLocalization extends GenericJson {

    @Key
    private String description;

    @Key
    private String title;

    public String getDescription() {
        return this.description;
    }

    public VideoLocalization setDescription(String str) {
        this.description = str;
        return this;
    }

    public String getTitle() {
        return this.title;
    }

    public VideoLocalization setTitle(String str) {
        this.title = str;
        return this;
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public VideoLocalization set(String str, Object obj) {
        return (VideoLocalization) super.set(str, obj);
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public VideoLocalization clone() {
        return (VideoLocalization) super.clone();
    }
}
