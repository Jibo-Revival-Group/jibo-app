package com.google.api.services.youtube.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

/* JADX INFO: loaded from: classes.dex */
public final class LiveChatModerator extends GenericJson {

    @Key
    private String etag;

    /* JADX INFO: renamed from: id */
    @Key
    private String f8502id;

    @Key
    private String kind;

    @Key
    private LiveChatModeratorSnippet snippet;

    public String getEtag() {
        return this.etag;
    }

    public LiveChatModerator setEtag(String str) {
        this.etag = str;
        return this;
    }

    public String getId() {
        return this.f8502id;
    }

    public LiveChatModerator setId(String str) {
        this.f8502id = str;
        return this;
    }

    public String getKind() {
        return this.kind;
    }

    public LiveChatModerator setKind(String str) {
        this.kind = str;
        return this;
    }

    public LiveChatModeratorSnippet getSnippet() {
        return this.snippet;
    }

    public LiveChatModerator setSnippet(LiveChatModeratorSnippet liveChatModeratorSnippet) {
        this.snippet = liveChatModeratorSnippet;
        return this;
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public LiveChatModerator set(String str, Object obj) {
        return (LiveChatModerator) super.set(str, obj);
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public LiveChatModerator clone() {
        return (LiveChatModerator) super.clone();
    }
}
