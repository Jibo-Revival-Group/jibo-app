package com.jibo.aws.integration.aws.services.loop.model;

import com.google.gson.annotations.Expose;

/* JADX INFO: loaded from: classes.dex */
public class RemoveMemberRequest extends JiboLoopRequest {

    /* JADX INFO: renamed from: id */
    @Expose
    private String f9569id;

    public RemoveMemberRequest(String str, String str2) {
        super(str);
        this.f9569id = str2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof RemoveMemberRequest)) {
            return false;
        }
        RemoveMemberRequest removeMemberRequest = (RemoveMemberRequest) obj;
        if ((removeMemberRequest.getId() == null) ^ (getId() == null)) {
            return false;
        }
        if (removeMemberRequest.getId() != null && !removeMemberRequest.getId().equals(getId())) {
            return false;
        }
        if ((removeMemberRequest.getLoopId() == null) ^ (getLoopId() == null)) {
            return false;
        }
        return removeMemberRequest.getLoopId() == null || removeMemberRequest.getLoopId().equals(getLoopId());
    }

    public String getId() {
        return this.f9569id;
    }

    @Override // com.jibo.aws.integration.aws.services.common.model.JiboRequestAbstract
    public String getServiceMethodName() {
        return "RemoveLoopMember";
    }

    public int hashCode() {
        return (((getId() == null ? 0 : getId().hashCode()) + 31) * 31) + (getLoopId() != null ? getLoopId().hashCode() : 0);
    }

    public void setId(String str) {
        this.f9569id = str;
    }

    @Override // com.jibo.aws.integration.aws.services.loop.model.JiboLoopRequest
    public String toString() {
        return "RemoveMemberRequest {id='" + this.f9569id + "'loopId='" + this.loopId + "'}";
    }
}
