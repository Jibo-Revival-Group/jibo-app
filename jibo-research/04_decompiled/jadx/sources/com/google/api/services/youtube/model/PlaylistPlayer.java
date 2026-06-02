package com.google.api.services.youtube.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

/* JADX INFO: loaded from: classes.dex */
public final class PlaylistPlayer extends GenericJson {

    @Key
    private String embedHtml;

    public String getEmbedHtml() {
        return this.embedHtml;
    }

    public PlaylistPlayer setEmbedHtml(String str) {
        this.embedHtml = str;
        return this;
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public PlaylistPlayer set(String str, Object obj) {
        return (PlaylistPlayer) super.set(str, obj);
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public PlaylistPlayer clone() {
        return (PlaylistPlayer) super.clone();
    }
}
