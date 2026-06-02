package com.jibo.aws.integration.aws.services.robotProperties.model;

import com.google.gson.annotations.Expose;

/* JADX INFO: loaded from: classes.dex */
public class GetFriendlyIdsRequest extends JiboRobotPropertiesRequest {

    @Expose
    private Integer count;

    public GetFriendlyIdsRequest(int i) {
        this.count = Integer.valueOf(i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof GetFriendlyIdsRequest)) {
            return false;
        }
        GetFriendlyIdsRequest getFriendlyIdsRequest = (GetFriendlyIdsRequest) obj;
        if ((getFriendlyIdsRequest.getCount() == null) ^ (getCount() == null)) {
            return false;
        }
        return getFriendlyIdsRequest.getCount() == null || getFriendlyIdsRequest.getCount().equals(getCount());
    }

    public Integer getCount() {
        return this.count;
    }

    public int hashCode() {
        return (getCount() == null ? 0 : getCount().hashCode()) + 31;
    }

    public void setCount(int i) {
        this.count = Integer.valueOf(i);
    }

    public String toString() {
        return "FriendlyIdsRequest {count='" + this.count + "'}";
    }
}
