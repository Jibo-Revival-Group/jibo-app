package com.google.api.services.youtube.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

/* JADX INFO: loaded from: classes.dex */
public final class ResourceId extends GenericJson {

    @Key
    private String channelId;

    @Key
    private String kind;

    @Key
    private String playlistId;

    @Key
    private String videoId;

    public String getChannelId() {
        return this.channelId;
    }

    public ResourceId setChannelId(String str) {
        this.channelId = str;
        return this;
    }

    public String getKind() {
        return this.kind;
    }

    public ResourceId setKind(String str) {
        this.kind = str;
        return this;
    }

    public String getPlaylistId() {
        return this.playlistId;
    }

    public ResourceId setPlaylistId(String str) {
        this.playlistId = str;
        return this;
    }

    public String getVideoId() {
        return this.videoId;
    }

    public ResourceId setVideoId(String str) {
        this.videoId = str;
        return this;
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public ResourceId set(String str, Object obj) {
        return (ResourceId) super.set(str, obj);
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public ResourceId clone() {
        return (ResourceId) super.clone();
    }
}
