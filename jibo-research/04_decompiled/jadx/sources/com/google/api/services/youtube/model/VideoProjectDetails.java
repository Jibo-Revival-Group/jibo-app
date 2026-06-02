package com.google.api.services.youtube.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class VideoProjectDetails extends GenericJson {

    @Key
    private List<String> tags;

    public List<String> getTags() {
        return this.tags;
    }

    public VideoProjectDetails setTags(List<String> list) {
        this.tags = list;
        return this;
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public VideoProjectDetails set(String str, Object obj) {
        return (VideoProjectDetails) super.set(str, obj);
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public VideoProjectDetails clone() {
        return (VideoProjectDetails) super.clone();
    }
}
