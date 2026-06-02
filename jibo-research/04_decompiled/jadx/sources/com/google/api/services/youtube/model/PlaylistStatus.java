package com.google.api.services.youtube.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

/* JADX INFO: loaded from: classes.dex */
public final class PlaylistStatus extends GenericJson {

    @Key
    private String privacyStatus;

    public String getPrivacyStatus() {
        return this.privacyStatus;
    }

    public PlaylistStatus setPrivacyStatus(String str) {
        this.privacyStatus = str;
        return this;
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public PlaylistStatus set(String str, Object obj) {
        return (PlaylistStatus) super.set(str, obj);
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public PlaylistStatus clone() {
        return (PlaylistStatus) super.clone();
    }
}
