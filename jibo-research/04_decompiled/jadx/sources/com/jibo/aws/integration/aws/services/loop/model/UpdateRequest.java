package com.jibo.aws.integration.aws.services.loop.model;

import com.google.gson.annotations.Expose;

/* JADX INFO: loaded from: classes.dex */
public class UpdateRequest extends JiboLoopRequest {

    @Expose
    private String name;

    public UpdateRequest(String str, String str2) {
        super(str);
        this.name = str2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof UpdateRequest)) {
            return false;
        }
        UpdateRequest updateRequest = (UpdateRequest) obj;
        if ((updateRequest.getName() == null) ^ (getName() == null)) {
            return false;
        }
        if (updateRequest.getName() != null && !updateRequest.getName().equals(getName())) {
            return false;
        }
        if ((updateRequest.getLoopId() == null) ^ (getLoopId() == null)) {
            return false;
        }
        return updateRequest.getLoopId() == null || updateRequest.getLoopId().equals(getLoopId());
    }

    public String getName() {
        return this.name;
    }

    @Override // com.jibo.aws.integration.aws.services.common.model.JiboRequestAbstract
    public String getServiceMethodName() {
        return "UpdateLoop";
    }

    public int hashCode() {
        return (((getName() == null ? 0 : getName().hashCode()) + 31) * 31) + (getLoopId() != null ? getLoopId().hashCode() : 0);
    }

    public void setName(String str) {
        this.name = str;
    }

    @Override // com.jibo.aws.integration.aws.services.loop.model.JiboLoopRequest
    public String toString() {
        return "UpdateRequest {name='" + this.name + "'loopId='" + this.loopId + "'}";
    }
}
