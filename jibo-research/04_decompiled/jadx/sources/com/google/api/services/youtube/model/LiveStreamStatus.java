package com.google.api.services.youtube.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

/* JADX INFO: loaded from: classes.dex */
public final class LiveStreamStatus extends GenericJson {

    @Key
    private LiveStreamHealthStatus healthStatus;

    @Key
    private String streamStatus;

    public LiveStreamHealthStatus getHealthStatus() {
        return this.healthStatus;
    }

    public LiveStreamStatus setHealthStatus(LiveStreamHealthStatus liveStreamHealthStatus) {
        this.healthStatus = liveStreamHealthStatus;
        return this;
    }

    public String getStreamStatus() {
        return this.streamStatus;
    }

    public LiveStreamStatus setStreamStatus(String str) {
        this.streamStatus = str;
        return this;
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public LiveStreamStatus set(String str, Object obj) {
        return (LiveStreamStatus) super.set(str, obj);
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public LiveStreamStatus clone() {
        return (LiveStreamStatus) super.clone();
    }
}
