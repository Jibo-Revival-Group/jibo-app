package com.google.api.services.youtube.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class LiveChatPollEditedDetails extends GenericJson {

    /* JADX INFO: renamed from: id */
    @Key
    private String f8503id;

    @Key
    private List<LiveChatPollItem> items;

    @Key
    private String prompt;

    public String getId() {
        return this.f8503id;
    }

    public LiveChatPollEditedDetails setId(String str) {
        this.f8503id = str;
        return this;
    }

    public List<LiveChatPollItem> getItems() {
        return this.items;
    }

    public LiveChatPollEditedDetails setItems(List<LiveChatPollItem> list) {
        this.items = list;
        return this;
    }

    public String getPrompt() {
        return this.prompt;
    }

    public LiveChatPollEditedDetails setPrompt(String str) {
        this.prompt = str;
        return this;
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public LiveChatPollEditedDetails set(String str, Object obj) {
        return (LiveChatPollEditedDetails) super.set(str, obj);
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public LiveChatPollEditedDetails clone() {
        return (LiveChatPollEditedDetails) super.clone();
    }
}
