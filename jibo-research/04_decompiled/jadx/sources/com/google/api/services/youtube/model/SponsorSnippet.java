package com.google.api.services.youtube.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.DateTime;
import com.google.api.client.util.Key;

/* JADX INFO: loaded from: classes.dex */
public final class SponsorSnippet extends GenericJson {

    @Key
    private String channelId;

    @Key
    private ChannelProfileDetails sponsorDetails;

    @Key
    private DateTime sponsorSince;

    public String getChannelId() {
        return this.channelId;
    }

    public SponsorSnippet setChannelId(String str) {
        this.channelId = str;
        return this;
    }

    public ChannelProfileDetails getSponsorDetails() {
        return this.sponsorDetails;
    }

    public SponsorSnippet setSponsorDetails(ChannelProfileDetails channelProfileDetails) {
        this.sponsorDetails = channelProfileDetails;
        return this;
    }

    public DateTime getSponsorSince() {
        return this.sponsorSince;
    }

    public SponsorSnippet setSponsorSince(DateTime dateTime) {
        this.sponsorSince = dateTime;
        return this;
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public SponsorSnippet set(String str, Object obj) {
        return (SponsorSnippet) super.set(str, obj);
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public SponsorSnippet clone() {
        return (SponsorSnippet) super.clone();
    }
}
