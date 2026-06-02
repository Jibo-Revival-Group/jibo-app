package com.google.api.services.youtube.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

/* JADX INFO: loaded from: classes.dex */
public final class LiveChatBan extends GenericJson {

    @Key
    private String etag;

    /* JADX INFO: renamed from: id */
    @Key
    private String f8500id;

    @Key
    private String kind;

    @Key
    private LiveChatBanSnippet snippet;

    public String getEtag() {
        return this.etag;
    }

    public LiveChatBan setEtag(String str) {
        this.etag = str;
        return this;
    }

    public String getId() {
        return this.f8500id;
    }

    public LiveChatBan setId(String str) {
        this.f8500id = str;
        return this;
    }

    public String getKind() {
        return this.kind;
    }

    public LiveChatBan setKind(String str) {
        this.kind = str;
        return this;
    }

    public LiveChatBanSnippet getSnippet() {
        return this.snippet;
    }

    public LiveChatBan setSnippet(LiveChatBanSnippet liveChatBanSnippet) {
        this.snippet = liveChatBanSnippet;
        return this;
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public LiveChatBan set(String str, Object obj) {
        return (LiveChatBan) super.set(str, obj);
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public LiveChatBan clone() {
        return (LiveChatBan) super.clone();
    }
}
