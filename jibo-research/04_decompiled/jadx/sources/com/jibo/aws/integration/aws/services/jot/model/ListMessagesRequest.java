package com.jibo.aws.integration.aws.services.jot.model;

import com.google.gson.annotations.Expose;

/* JADX INFO: loaded from: classes.dex */
public class ListMessagesRequest extends JiboJotRequest {

    @Expose
    private Long after;

    @Expose
    private Long before;

    @Expose
    private String loopId;

    public ListMessagesRequest() {
    }

    public ListMessagesRequest(String str, Long l, Long l2) {
        this.loopId = str;
        this.after = l;
        this.before = l2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ListMessagesRequest)) {
            return false;
        }
        ListMessagesRequest listMessagesRequest = (ListMessagesRequest) obj;
        if ((listMessagesRequest.getAfter() == null) ^ (getAfter() == null)) {
            return false;
        }
        if (listMessagesRequest.getAfter() != null && !listMessagesRequest.getAfter().equals(getAfter())) {
            return false;
        }
        if ((listMessagesRequest.getBefore() == null) ^ (getBefore() == null)) {
            return false;
        }
        if (listMessagesRequest.getBefore() != null && !listMessagesRequest.getBefore().equals(getBefore())) {
            return false;
        }
        if ((listMessagesRequest.getLoopId() == null) ^ (getLoopId() == null)) {
            return false;
        }
        return listMessagesRequest.getLoopId() == null || listMessagesRequest.getLoopId().equals(getLoopId());
    }

    public Long getAfter() {
        return this.after;
    }

    public Long getBefore() {
        return this.before;
    }

    public String getLoopId() {
        return this.loopId;
    }

    public int hashCode() {
        return (((getAfter() == null ? 0 : getAfter().hashCode()) + (((getLoopId() == null ? 0 : getLoopId().hashCode()) + 31) * 31)) * 31) + (getBefore() != null ? getBefore().hashCode() : 0);
    }

    public void setAfter(Long l) {
        this.after = l;
    }

    public void setBefore(Long l) {
        this.before = l;
    }

    public void setLoopId(String str) {
        this.loopId = str;
    }

    public String toString() {
        return "ListMessagesRequest {loopId='" + this.loopId + "'after='" + this.after + "'before='" + this.before + "'}";
    }
}
