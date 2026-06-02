package com.google.api.services.youtube.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

/* JADX INFO: loaded from: classes.dex */
public final class CommentThread extends GenericJson {

    @Key
    private String etag;

    /* JADX INFO: renamed from: id */
    @Key
    private String f8492id;

    @Key
    private String kind;

    @Key
    private CommentThreadReplies replies;

    @Key
    private CommentThreadSnippet snippet;

    public String getEtag() {
        return this.etag;
    }

    public CommentThread setEtag(String str) {
        this.etag = str;
        return this;
    }

    public String getId() {
        return this.f8492id;
    }

    public CommentThread setId(String str) {
        this.f8492id = str;
        return this;
    }

    public String getKind() {
        return this.kind;
    }

    public CommentThread setKind(String str) {
        this.kind = str;
        return this;
    }

    public CommentThreadReplies getReplies() {
        return this.replies;
    }

    public CommentThread setReplies(CommentThreadReplies commentThreadReplies) {
        this.replies = commentThreadReplies;
        return this;
    }

    public CommentThreadSnippet getSnippet() {
        return this.snippet;
    }

    public CommentThread setSnippet(CommentThreadSnippet commentThreadSnippet) {
        this.snippet = commentThreadSnippet;
        return this;
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public CommentThread set(String str, Object obj) {
        return (CommentThread) super.set(str, obj);
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public CommentThread clone() {
        return (CommentThread) super.clone();
    }
}
