package com.google.api.services.youtube.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

/* JADX INFO: loaded from: classes.dex */
public final class ChannelConversionPing extends GenericJson {

    @Key
    private String context;

    @Key
    private String conversionUrl;

    public String getContext() {
        return this.context;
    }

    public ChannelConversionPing setContext(String str) {
        this.context = str;
        return this;
    }

    public String getConversionUrl() {
        return this.conversionUrl;
    }

    public ChannelConversionPing setConversionUrl(String str) {
        this.conversionUrl = str;
        return this;
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public ChannelConversionPing set(String str, Object obj) {
        return (ChannelConversionPing) super.set(str, obj);
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public ChannelConversionPing clone() {
        return (ChannelConversionPing) super.clone();
    }
}
