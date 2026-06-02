package com.google.api.services.youtube.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

/* JADX INFO: loaded from: classes.dex */
public final class ChannelBannerResource extends GenericJson {

    @Key
    private String etag;

    @Key
    private String kind;

    @Key
    private String url;

    public String getEtag() {
        return this.etag;
    }

    public ChannelBannerResource setEtag(String str) {
        this.etag = str;
        return this;
    }

    public String getKind() {
        return this.kind;
    }

    public ChannelBannerResource setKind(String str) {
        this.kind = str;
        return this;
    }

    public String getUrl() {
        return this.url;
    }

    public ChannelBannerResource setUrl(String str) {
        this.url = str;
        return this;
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public ChannelBannerResource set(String str, Object obj) {
        return (ChannelBannerResource) super.set(str, obj);
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public ChannelBannerResource clone() {
        return (ChannelBannerResource) super.clone();
    }
}
