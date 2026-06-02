package com.google.api.services.youtube.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

/* JADX INFO: loaded from: classes.dex */
public final class InvideoPosition extends GenericJson {

    @Key
    private String cornerPosition;

    @Key
    private String type;

    public String getCornerPosition() {
        return this.cornerPosition;
    }

    public InvideoPosition setCornerPosition(String str) {
        this.cornerPosition = str;
        return this;
    }

    public String getType() {
        return this.type;
    }

    public InvideoPosition setType(String str) {
        this.type = str;
        return this;
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public InvideoPosition set(String str, Object obj) {
        return (InvideoPosition) super.set(str, obj);
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public InvideoPosition clone() {
        return (InvideoPosition) super.clone();
    }
}
