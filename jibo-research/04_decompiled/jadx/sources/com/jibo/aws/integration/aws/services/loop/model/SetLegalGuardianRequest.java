package com.jibo.aws.integration.aws.services.loop.model;

import com.google.gson.annotations.Expose;

/* JADX INFO: loaded from: classes.dex */
public class SetLegalGuardianRequest extends JiboLoopRequest {

    @Expose
    private String childId;

    @Expose
    private String parentId;

    public SetLegalGuardianRequest(String str, String str2, String str3) {
        super(str);
        this.childId = str2;
        this.parentId = str3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof SetLegalGuardianRequest)) {
            return false;
        }
        SetLegalGuardianRequest setLegalGuardianRequest = (SetLegalGuardianRequest) obj;
        if ((setLegalGuardianRequest.getLoopId() == null) ^ (getLoopId() == null)) {
            return false;
        }
        if (setLegalGuardianRequest.getLoopId() != null && !setLegalGuardianRequest.getLoopId().equals(getLoopId())) {
            return false;
        }
        if ((setLegalGuardianRequest.getChildId() == null) ^ (getChildId() == null)) {
            return false;
        }
        if (setLegalGuardianRequest.getChildId() != null && !setLegalGuardianRequest.getChildId().equals(getChildId())) {
            return false;
        }
        if ((setLegalGuardianRequest.getParentId() == null) ^ (getParentId() == null)) {
            return false;
        }
        if (setLegalGuardianRequest.getParentId() == null || setLegalGuardianRequest.getParentId().equals(getParentId())) {
            return setLegalGuardianRequest.getParentId() == null || setLegalGuardianRequest.getParentId().equals(getParentId());
        }
        return false;
    }

    public String getChildId() {
        return this.childId;
    }

    public String getParentId() {
        return this.parentId;
    }

    public int hashCode() {
        return (((getChildId() == null ? 0 : getChildId().hashCode()) + (((getLoopId() == null ? 0 : getLoopId().hashCode()) + 31) * 31)) * 31) + (getParentId() != null ? getParentId().hashCode() : 0);
    }

    public void setChildId(String str) {
        this.childId = str;
    }

    public void setParentId(String str) {
        this.parentId = str;
    }

    @Override // com.jibo.aws.integration.aws.services.loop.model.JiboLoopRequest
    public String toString() {
        return "SetLegalGuardianRequest {loopId='" + this.loopId + "', childId='" + this.childId + "', parentId='" + this.parentId + "'}";
    }
}
