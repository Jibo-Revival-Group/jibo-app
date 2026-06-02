package com.google.api.services.youtube.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.json.JsonString;
import com.google.api.client.util.Key;

/* JADX INFO: loaded from: classes.dex */
public final class VideoPlayer extends GenericJson {

    @JsonString
    @Key
    private Long embedHeight;

    @Key
    private String embedHtml;

    @JsonString
    @Key
    private Long embedWidth;

    public Long getEmbedHeight() {
        return this.embedHeight;
    }

    public VideoPlayer setEmbedHeight(Long l) {
        this.embedHeight = l;
        return this;
    }

    public String getEmbedHtml() {
        return this.embedHtml;
    }

    public VideoPlayer setEmbedHtml(String str) {
        this.embedHtml = str;
        return this;
    }

    public Long getEmbedWidth() {
        return this.embedWidth;
    }

    public VideoPlayer setEmbedWidth(Long l) {
        this.embedWidth = l;
        return this;
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public VideoPlayer set(String str, Object obj) {
        return (VideoPlayer) super.set(str, obj);
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public VideoPlayer clone() {
        return (VideoPlayer) super.clone();
    }
}
