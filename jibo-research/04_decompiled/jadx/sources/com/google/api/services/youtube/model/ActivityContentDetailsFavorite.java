package com.google.api.services.youtube.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

/* JADX INFO: loaded from: classes.dex */
public final class ActivityContentDetailsFavorite extends GenericJson {

    @Key
    private ResourceId resourceId;

    public ResourceId getResourceId() {
        return this.resourceId;
    }

    public ActivityContentDetailsFavorite setResourceId(ResourceId resourceId) {
        this.resourceId = resourceId;
        return this;
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public ActivityContentDetailsFavorite set(String str, Object obj) {
        return (ActivityContentDetailsFavorite) super.set(str, obj);
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public ActivityContentDetailsFavorite clone() {
        return (ActivityContentDetailsFavorite) super.clone();
    }
}
