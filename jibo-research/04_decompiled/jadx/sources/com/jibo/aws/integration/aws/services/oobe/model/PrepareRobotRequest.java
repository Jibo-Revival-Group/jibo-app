package com.jibo.aws.integration.aws.services.oobe.model;

import com.google.gson.annotations.Expose;

/* JADX INFO: loaded from: classes.dex */
public class PrepareRobotRequest extends JiboOobeRequest {

    @Expose
    private String loopId;

    public PrepareRobotRequest(String str) {
        this.loopId = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PrepareRobotRequest)) {
            return false;
        }
        PrepareRobotRequest prepareRobotRequest = (PrepareRobotRequest) obj;
        return getLoopId() != null ? getLoopId().equals(prepareRobotRequest.getLoopId()) : prepareRobotRequest.getLoopId() == null;
    }

    public String getLoopId() {
        return this.loopId;
    }

    public int hashCode() {
        if (getLoopId() != null) {
            return getLoopId().hashCode();
        }
        return 0;
    }

    public void setLoopId(String str) {
        this.loopId = str;
    }

    public String toString() {
        return "PrepareRobotRequest{loopId='" + this.loopId + "'}";
    }
}
