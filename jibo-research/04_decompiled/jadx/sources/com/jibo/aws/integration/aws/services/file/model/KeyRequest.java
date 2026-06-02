package com.jibo.aws.integration.aws.services.file.model;

import com.amazonaws.AmazonWebServiceRequest;
import com.google.gson.annotations.Expose;
import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public abstract class KeyRequest extends AmazonWebServiceRequest implements Serializable {

    @Expose
    private String key;

    public KeyRequest(String str) {
        this.key = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof KeyRequest)) {
            return false;
        }
        KeyRequest keyRequest = (KeyRequest) obj;
        if ((keyRequest.getKey() == null) ^ (getKey() == null)) {
            return false;
        }
        return keyRequest.getKey() == null || keyRequest.getKey().equals(getKey());
    }

    public String getKey() {
        return this.key;
    }

    public abstract String getServicePrefix();

    public int hashCode() {
        return (getKey() == null ? 0 : getKey().hashCode()) + 31;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public String toString() {
        return "KeyRequest {key='" + this.key + "'}";
    }
}
