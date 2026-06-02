package com.google.api.services.youtube.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class AccessPolicy extends GenericJson {

    @Key
    private Boolean allowed;

    @Key
    private List<String> exception;

    public Boolean getAllowed() {
        return this.allowed;
    }

    public AccessPolicy setAllowed(Boolean bool) {
        this.allowed = bool;
        return this;
    }

    public List<String> getException() {
        return this.exception;
    }

    public AccessPolicy setException(List<String> list) {
        this.exception = list;
        return this;
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public AccessPolicy set(String str, Object obj) {
        return (AccessPolicy) super.set(str, obj);
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public AccessPolicy clone() {
        return (AccessPolicy) super.clone();
    }
}
