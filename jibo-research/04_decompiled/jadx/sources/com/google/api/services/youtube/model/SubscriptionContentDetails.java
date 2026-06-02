package com.google.api.services.youtube.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

/* JADX INFO: loaded from: classes.dex */
public final class SubscriptionContentDetails extends GenericJson {

    @Key
    private String activityType;

    @Key
    private Long newItemCount;

    @Key
    private Long totalItemCount;

    public String getActivityType() {
        return this.activityType;
    }

    public SubscriptionContentDetails setActivityType(String str) {
        this.activityType = str;
        return this;
    }

    public Long getNewItemCount() {
        return this.newItemCount;
    }

    public SubscriptionContentDetails setNewItemCount(Long l) {
        this.newItemCount = l;
        return this;
    }

    public Long getTotalItemCount() {
        return this.totalItemCount;
    }

    public SubscriptionContentDetails setTotalItemCount(Long l) {
        this.totalItemCount = l;
        return this;
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public SubscriptionContentDetails set(String str, Object obj) {
        return (SubscriptionContentDetails) super.set(str, obj);
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public SubscriptionContentDetails clone() {
        return (SubscriptionContentDetails) super.clone();
    }
}
