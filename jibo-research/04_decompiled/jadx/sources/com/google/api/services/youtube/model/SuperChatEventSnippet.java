package com.google.api.services.youtube.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.json.JsonString;
import com.google.api.client.util.DateTime;
import com.google.api.client.util.Key;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes.dex */
public final class SuperChatEventSnippet extends GenericJson {

    @JsonString
    @Key
    private BigInteger amountMicros;

    @Key
    private String channelId;

    @Key
    private String commentText;

    @Key
    private DateTime createdAt;

    @Key
    private String currency;

    @Key
    private String displayString;

    @Key
    private Long messageType;

    @Key
    private ChannelProfileDetails supporterDetails;

    public BigInteger getAmountMicros() {
        return this.amountMicros;
    }

    public SuperChatEventSnippet setAmountMicros(BigInteger bigInteger) {
        this.amountMicros = bigInteger;
        return this;
    }

    public String getChannelId() {
        return this.channelId;
    }

    public SuperChatEventSnippet setChannelId(String str) {
        this.channelId = str;
        return this;
    }

    public String getCommentText() {
        return this.commentText;
    }

    public SuperChatEventSnippet setCommentText(String str) {
        this.commentText = str;
        return this;
    }

    public DateTime getCreatedAt() {
        return this.createdAt;
    }

    public SuperChatEventSnippet setCreatedAt(DateTime dateTime) {
        this.createdAt = dateTime;
        return this;
    }

    public String getCurrency() {
        return this.currency;
    }

    public SuperChatEventSnippet setCurrency(String str) {
        this.currency = str;
        return this;
    }

    public String getDisplayString() {
        return this.displayString;
    }

    public SuperChatEventSnippet setDisplayString(String str) {
        this.displayString = str;
        return this;
    }

    public Long getMessageType() {
        return this.messageType;
    }

    public SuperChatEventSnippet setMessageType(Long l) {
        this.messageType = l;
        return this;
    }

    public ChannelProfileDetails getSupporterDetails() {
        return this.supporterDetails;
    }

    public SuperChatEventSnippet setSupporterDetails(ChannelProfileDetails channelProfileDetails) {
        this.supporterDetails = channelProfileDetails;
        return this;
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public SuperChatEventSnippet set(String str, Object obj) {
        return (SuperChatEventSnippet) super.set(str, obj);
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public SuperChatEventSnippet clone() {
        return (SuperChatEventSnippet) super.clone();
    }
}
