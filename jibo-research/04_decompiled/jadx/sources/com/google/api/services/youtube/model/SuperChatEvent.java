package com.google.api.services.youtube.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

/* JADX INFO: loaded from: classes.dex */
public final class SuperChatEvent extends GenericJson {

    @Key
    private String etag;

    /* JADX INFO: renamed from: id */
    @Key
    private String f8512id;

    @Key
    private String kind;

    @Key
    private SuperChatEventSnippet snippet;

    public String getEtag() {
        return this.etag;
    }

    public SuperChatEvent setEtag(String str) {
        this.etag = str;
        return this;
    }

    public String getId() {
        return this.f8512id;
    }

    public SuperChatEvent setId(String str) {
        this.f8512id = str;
        return this;
    }

    public String getKind() {
        return this.kind;
    }

    public SuperChatEvent setKind(String str) {
        this.kind = str;
        return this;
    }

    public SuperChatEventSnippet getSnippet() {
        return this.snippet;
    }

    public SuperChatEvent setSnippet(SuperChatEventSnippet superChatEventSnippet) {
        this.snippet = superChatEventSnippet;
        return this;
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public SuperChatEvent set(String str, Object obj) {
        return (SuperChatEvent) super.set(str, obj);
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public SuperChatEvent clone() {
        return (SuperChatEvent) super.clone();
    }
}
