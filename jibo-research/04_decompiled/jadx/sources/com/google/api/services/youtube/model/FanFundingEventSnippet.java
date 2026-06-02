package com.google.api.services.youtube.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.json.JsonString;
import com.google.api.client.util.DateTime;
import com.google.api.client.util.Key;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes.dex */
public final class FanFundingEventSnippet extends GenericJson {

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
    private ChannelProfileDetails supporterDetails;

    public BigInteger getAmountMicros() {
        return this.amountMicros;
    }

    public FanFundingEventSnippet setAmountMicros(BigInteger bigInteger) {
        this.amountMicros = bigInteger;
        return this;
    }

    public String getChannelId() {
        return this.channelId;
    }

    public FanFundingEventSnippet setChannelId(String str) {
        this.channelId = str;
        return this;
    }

    public String getCommentText() {
        return this.commentText;
    }

    public FanFundingEventSnippet setCommentText(String str) {
        this.commentText = str;
        return this;
    }

    public DateTime getCreatedAt() {
        return this.createdAt;
    }

    public FanFundingEventSnippet setCreatedAt(DateTime dateTime) {
        this.createdAt = dateTime;
        return this;
    }

    public String getCurrency() {
        return this.currency;
    }

    public FanFundingEventSnippet setCurrency(String str) {
        this.currency = str;
        return this;
    }

    public String getDisplayString() {
        return this.displayString;
    }

    public FanFundingEventSnippet setDisplayString(String str) {
        this.displayString = str;
        return this;
    }

    public ChannelProfileDetails getSupporterDetails() {
        return this.supporterDetails;
    }

    public FanFundingEventSnippet setSupporterDetails(ChannelProfileDetails channelProfileDetails) {
        this.supporterDetails = channelProfileDetails;
        return this;
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public FanFundingEventSnippet set(String str, Object obj) {
        return (FanFundingEventSnippet) super.set(str, obj);
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public FanFundingEventSnippet clone() {
        return (FanFundingEventSnippet) super.clone();
    }
}
