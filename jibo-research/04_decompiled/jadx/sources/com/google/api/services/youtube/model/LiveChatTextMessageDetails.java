package com.google.api.services.youtube.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

/* JADX INFO: loaded from: classes.dex */
public final class LiveChatTextMessageDetails extends GenericJson {

    @Key
    private String messageText;

    public String getMessageText() {
        return this.messageText;
    }

    public LiveChatTextMessageDetails setMessageText(String str) {
        this.messageText = str;
        return this;
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public LiveChatTextMessageDetails set(String str, Object obj) {
        return (LiveChatTextMessageDetails) super.set(str, obj);
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public LiveChatTextMessageDetails clone() {
        return (LiveChatTextMessageDetails) super.clone();
    }
}
