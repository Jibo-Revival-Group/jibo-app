package com.jibo.aws.integration.aws.services.skills.model;

import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
public class GetSettingsRequest extends JiboSkillsRequest {
    private String loopId;
    private String transId = UUID.randomUUID().toString();

    public GetSettingsRequest(String str) {
        this.loopId = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof GetSettingsRequest)) {
            return false;
        }
        GetSettingsRequest getSettingsRequest = (GetSettingsRequest) obj;
        if ((getSettingsRequest.getTransId() == null) ^ (getTransId() == null)) {
            return false;
        }
        if (getSettingsRequest.getTransId() != null && !getSettingsRequest.getTransId().equals(getTransId())) {
            return false;
        }
        if ((getSettingsRequest.getLoopId() == null) ^ (getLoopId() == null)) {
            return false;
        }
        return getSettingsRequest.getLoopId() == null || getSettingsRequest.getLoopId().equals(getLoopId());
    }

    public String getLoopId() {
        return this.loopId;
    }

    public String getTransId() {
        return this.transId;
    }

    public int hashCode() {
        return (((getTransId() == null ? 0 : getTransId().hashCode()) + 31) * 31) + (getLoopId() != null ? getLoopId().hashCode() : 0);
    }

    public void setLoopId(String str) {
        this.loopId = str;
    }

    public void setTransId(String str) {
        this.transId = str;
    }

    @Override // com.jibo.aws.integration.aws.services.skills.model.JiboSkillsRequest
    public String toString() {
        return "GetSettingsRequest {transId='" + this.transId + ", loopId='" + this.loopId + "'}";
    }
}
