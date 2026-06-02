package com.jibo.aws.integration.aws.services.key.model;

import com.google.gson.annotations.Expose;

/* JADX INFO: loaded from: classes.dex */
public class ListIncomingRequest extends JiboKeyRequest {

    @Expose
    private String loopId;

    public ListIncomingRequest(String str) {
        this.loopId = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ListIncomingRequest)) {
            return false;
        }
        ListIncomingRequest listIncomingRequest = (ListIncomingRequest) obj;
        if ((listIncomingRequest.getLoopId() == null) ^ (getLoopId() == null)) {
            return false;
        }
        return listIncomingRequest.getLoopId() == null || listIncomingRequest.getLoopId().equals(getLoopId());
    }

    public String getLoopId() {
        return this.loopId;
    }

    @Override // com.jibo.aws.integration.aws.services.common.model.JiboRequestAbstract
    public String getServiceMethodName() {
        return "ListIncomingRequests";
    }

    public int hashCode() {
        return (getLoopId() == null ? 0 : getLoopId().hashCode()) + 31;
    }

    public void setLoopId(String str) {
        this.loopId = str;
    }

    public String toString() {
        return "ListIncomingRequest {loopId='" + this.loopId + "'}";
    }
}
