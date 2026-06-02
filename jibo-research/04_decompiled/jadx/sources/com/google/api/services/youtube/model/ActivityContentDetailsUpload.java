package com.google.api.services.youtube.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

/* JADX INFO: loaded from: classes.dex */
public final class ActivityContentDetailsUpload extends GenericJson {

    @Key
    private String videoId;

    public String getVideoId() {
        return this.videoId;
    }

    public ActivityContentDetailsUpload setVideoId(String str) {
        this.videoId = str;
        return this;
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public ActivityContentDetailsUpload set(String str, Object obj) {
        return (ActivityContentDetailsUpload) super.set(str, obj);
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public ActivityContentDetailsUpload clone() {
        return (ActivityContentDetailsUpload) super.clone();
    }
}
