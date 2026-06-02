package com.google.api.services.youtube.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

/* JADX INFO: loaded from: classes.dex */
public final class LiveChatPollVotedDetails extends GenericJson {

    @Key
    private String itemId;

    @Key
    private String pollId;

    public String getItemId() {
        return this.itemId;
    }

    public LiveChatPollVotedDetails setItemId(String str) {
        this.itemId = str;
        return this;
    }

    public String getPollId() {
        return this.pollId;
    }

    public LiveChatPollVotedDetails setPollId(String str) {
        this.pollId = str;
        return this;
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public LiveChatPollVotedDetails set(String str, Object obj) {
        return (LiveChatPollVotedDetails) super.set(str, obj);
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public LiveChatPollVotedDetails clone() {
        return (LiveChatPollVotedDetails) super.clone();
    }
}
