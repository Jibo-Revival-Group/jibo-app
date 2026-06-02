package com.google.api.services.youtube.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class VideoTopicDetails extends GenericJson {

    @Key
    private List<String> relevantTopicIds;

    @Key
    private List<String> topicCategories;

    @Key
    private List<String> topicIds;

    public List<String> getRelevantTopicIds() {
        return this.relevantTopicIds;
    }

    public VideoTopicDetails setRelevantTopicIds(List<String> list) {
        this.relevantTopicIds = list;
        return this;
    }

    public List<String> getTopicCategories() {
        return this.topicCategories;
    }

    public VideoTopicDetails setTopicCategories(List<String> list) {
        this.topicCategories = list;
        return this;
    }

    public List<String> getTopicIds() {
        return this.topicIds;
    }

    public VideoTopicDetails setTopicIds(List<String> list) {
        this.topicIds = list;
        return this;
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public VideoTopicDetails set(String str, Object obj) {
        return (VideoTopicDetails) super.set(str, obj);
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public VideoTopicDetails clone() {
        return (VideoTopicDetails) super.clone();
    }
}
