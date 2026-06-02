package com.jibo.aws.integration.aws.services.media.model;

import com.google.gson.annotations.Expose;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class GetRequest extends JiboMediaRequest {

    @Expose
    private List<String> paths;

    public GetRequest(List<String> list) {
        this.paths = list;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof GetRequest)) {
            return false;
        }
        GetRequest getRequest = (GetRequest) obj;
        if ((getRequest.getPaths() == null) ^ (getPaths() == null)) {
            return false;
        }
        return getRequest.getPaths() == null || getRequest.getPaths().equals(getPaths());
    }

    public List<String> getPaths() {
        return this.paths;
    }

    public int hashCode() {
        return (getPaths() == null ? 0 : getPaths().hashCode()) + 31;
    }

    public void setPaths(List<String> list) {
        this.paths = list;
    }

    public String toString() {
        return "GetRequest {paths='" + this.paths + "'}";
    }
}
