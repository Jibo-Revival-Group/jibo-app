package com.google.api.services.youtube.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

/* JADX INFO: loaded from: classes.dex */
public final class PlaylistContentDetails extends GenericJson {

    @Key
    private Long itemCount;

    public Long getItemCount() {
        return this.itemCount;
    }

    public PlaylistContentDetails setItemCount(Long l) {
        this.itemCount = l;
        return this;
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public PlaylistContentDetails set(String str, Object obj) {
        return (PlaylistContentDetails) super.set(str, obj);
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public PlaylistContentDetails clone() {
        return (PlaylistContentDetails) super.clone();
    }
}
