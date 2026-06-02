package com.google.api.services.youtube.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

/* JADX INFO: loaded from: classes.dex */
public final class VideoCategory extends GenericJson {

    @Key
    private String etag;

    /* JADX INFO: renamed from: id */
    @Key
    private String f8516id;

    @Key
    private String kind;

    @Key
    private VideoCategorySnippet snippet;

    public String getEtag() {
        return this.etag;
    }

    public VideoCategory setEtag(String str) {
        this.etag = str;
        return this;
    }

    public String getId() {
        return this.f8516id;
    }

    public VideoCategory setId(String str) {
        this.f8516id = str;
        return this;
    }

    public String getKind() {
        return this.kind;
    }

    public VideoCategory setKind(String str) {
        this.kind = str;
        return this;
    }

    public VideoCategorySnippet getSnippet() {
        return this.snippet;
    }

    public VideoCategory setSnippet(VideoCategorySnippet videoCategorySnippet) {
        this.snippet = videoCategorySnippet;
        return this;
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public VideoCategory set(String str, Object obj) {
        return (VideoCategory) super.set(str, obj);
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public VideoCategory clone() {
        return (VideoCategory) super.clone();
    }
}
