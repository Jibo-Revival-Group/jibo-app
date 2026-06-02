package com.google.api.services.youtube.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

/* JADX INFO: loaded from: classes.dex */
public final class LiveChatMessageDeletedDetails extends GenericJson {

    @Key
    private String deletedMessageId;

    public String getDeletedMessageId() {
        return this.deletedMessageId;
    }

    public LiveChatMessageDeletedDetails setDeletedMessageId(String str) {
        this.deletedMessageId = str;
        return this;
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public LiveChatMessageDeletedDetails set(String str, Object obj) {
        return (LiveChatMessageDeletedDetails) super.set(str, obj);
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public LiveChatMessageDeletedDetails clone() {
        return (LiveChatMessageDeletedDetails) super.clone();
    }
}
