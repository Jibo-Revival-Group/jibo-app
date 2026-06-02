package com.jibo.aws.integration.aws.services.loop.model;

import com.google.gson.annotations.Expose;

/* JADX INFO: loaded from: classes.dex */
public class RobotRequest extends JiboLoopRequest {

    @Expose
    private String robotId;

    public RobotRequest(String str, String str2) {
        super(str);
        this.robotId = str2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof RobotRequest)) {
            return false;
        }
        RobotRequest robotRequest = (RobotRequest) obj;
        if ((robotRequest.getRobotId() == null) ^ (getRobotId() == null)) {
            return false;
        }
        if (robotRequest.getRobotId() != null && !robotRequest.getRobotId().equals(getRobotId())) {
            return false;
        }
        if ((robotRequest.getLoopId() == null) ^ (getLoopId() == null)) {
            return false;
        }
        return robotRequest.getLoopId() == null || robotRequest.getLoopId().equals(getLoopId());
    }

    @Override // com.jibo.aws.integration.aws.services.loop.model.JiboLoopRequest
    public String getLoopId() {
        return this.loopId;
    }

    public String getRobotId() {
        return this.robotId;
    }

    public int hashCode() {
        return (((getRobotId() == null ? 0 : getRobotId().hashCode()) + 31) * 31) + (getLoopId() != null ? getLoopId().hashCode() : 0);
    }

    @Override // com.jibo.aws.integration.aws.services.loop.model.JiboLoopRequest
    public void setLoopId(String str) {
        this.loopId = str;
    }

    public void setRobotId(String str) {
        this.robotId = str;
    }

    @Override // com.jibo.aws.integration.aws.services.loop.model.JiboLoopRequest
    public String toString() {
        return "RobotRequest {robotId='" + this.robotId + "'loopId='" + this.loopId + "'}";
    }
}
