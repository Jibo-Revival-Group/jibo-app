package com.jibo.aws.integration.aws.services.media.model;

import com.google.gson.annotations.Expose;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ListRequest extends JiboMediaRequest {

    @Expose
    private Long after;

    @Expose
    private Long before;

    @Expose
    private List<String> loopIds;

    public ListRequest() {
    }

    public ListRequest(List<String> list, Long l, Long l2) {
        this.loopIds = list;
        this.after = l;
        this.before = l2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ListRequest)) {
            return false;
        }
        ListRequest listRequest = (ListRequest) obj;
        if ((listRequest.getAfter() == null) ^ (getAfter() == null)) {
            return false;
        }
        if (listRequest.getAfter() != null && !listRequest.getAfter().equals(getAfter())) {
            return false;
        }
        if ((listRequest.getBefore() == null) ^ (getBefore() == null)) {
            return false;
        }
        if (listRequest.getBefore() != null && !listRequest.getBefore().equals(getBefore())) {
            return false;
        }
        if ((listRequest.getLoopIds() == null) ^ (getLoopIds() == null)) {
            return false;
        }
        return listRequest.getLoopIds() == null || listRequest.getLoopIds().equals(getLoopIds());
    }

    public Long getAfter() {
        return this.after;
    }

    public Long getBefore() {
        return this.before;
    }

    public List<String> getLoopIds() {
        return this.loopIds;
    }

    public int hashCode() {
        return (((getAfter() == null ? 0 : getAfter().hashCode()) + (((getLoopIds() == null ? 0 : getLoopIds().hashCode()) + 31) * 31)) * 31) + (getBefore() != null ? getBefore().hashCode() : 0);
    }

    public void setAfter(Long l) {
        this.after = l;
    }

    public void setBefore(Long l) {
        this.before = l;
    }

    public void setLoopIds(List<String> list) {
        this.loopIds = list;
    }

    public String toString() {
        return "ListRequest {loopId='" + this.loopIds + "'after='" + this.after + "'before='" + this.before + "'}";
    }
}
