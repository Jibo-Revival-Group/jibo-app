package com.jibo.aws.integration.aws.services.media.model;

import com.google.gson.annotations.Expose;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class RemoveRequest extends JiboMediaRequest {

    @Expose
    private List<String> paths;

    public RemoveRequest(List<String> list) {
        this.paths = list;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof RemoveRequest)) {
            return false;
        }
        RemoveRequest removeRequest = (RemoveRequest) obj;
        if ((removeRequest.getPaths() == null) ^ (getPaths() == null)) {
            return false;
        }
        return removeRequest.getPaths() == null || removeRequest.getPaths().equals(getPaths());
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
        return "RemoveRequest {paths='" + this.paths + "'}";
    }
}
