package com.jibo.aws.integration.aws.services.binary.model;

import com.amazonaws.AmazonWebServiceRequest;
import com.google.gson.annotations.Expose;
import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public abstract class PathRequest extends AmazonWebServiceRequest implements Serializable {

    @Expose
    private String path;

    public PathRequest(String str) {
        this.path = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof PathRequest)) {
            return false;
        }
        PathRequest pathRequest = (PathRequest) obj;
        if ((pathRequest.getPath() == null) ^ (getPath() == null)) {
            return false;
        }
        return pathRequest.getPath() == null || pathRequest.getPath().equals(getPath());
    }

    public String getPath() {
        return this.path;
    }

    public abstract String getServicePrefix();

    public int hashCode() {
        return (getPath() == null ? 0 : getPath().hashCode()) + 31;
    }

    public void setPath(String str) {
        this.path = str;
    }

    public String toString() {
        return "PathRequest {path='" + this.path + "'}";
    }
}
