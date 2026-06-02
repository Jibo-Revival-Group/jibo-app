package com.jibo.aws.integration.aws.services.loop.model;

import com.google.gson.annotations.Expose;

/* JADX INFO: loaded from: classes.dex */
public class UpdatePhoneticNameRequest extends JiboLoopRequest {

    /* JADX INFO: renamed from: id */
    @Expose
    private String f9574id;

    @Expose
    private String phoneticName;

    public UpdatePhoneticNameRequest(String str, String str2, String str3) {
        super(str);
        this.f9574id = str2;
        this.phoneticName = str3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof UpdatePhoneticNameRequest)) {
            return false;
        }
        UpdatePhoneticNameRequest updatePhoneticNameRequest = (UpdatePhoneticNameRequest) obj;
        if ((updatePhoneticNameRequest.getLoopId() == null) ^ (getLoopId() == null)) {
            return false;
        }
        if (updatePhoneticNameRequest.getLoopId() != null && !updatePhoneticNameRequest.getLoopId().equals(getLoopId())) {
            return false;
        }
        if ((updatePhoneticNameRequest.getId() == null) ^ (getId() == null)) {
            return false;
        }
        if (updatePhoneticNameRequest.getId() != null && !updatePhoneticNameRequest.getId().equals(getId())) {
            return false;
        }
        if ((updatePhoneticNameRequest.getPhoneticName() == null) ^ (getPhoneticName() == null)) {
            return false;
        }
        return updatePhoneticNameRequest.getPhoneticName() == null || updatePhoneticNameRequest.getPhoneticName().equals(getPhoneticName());
    }

    public String getId() {
        return this.f9574id;
    }

    public String getPhoneticName() {
        return this.phoneticName;
    }

    public int hashCode() {
        return (((getId() == null ? 0 : getId().hashCode()) + (((getLoopId() == null ? 0 : getLoopId().hashCode()) + 31) * 31)) * 31) + (getPhoneticName() != null ? getPhoneticName().hashCode() : 0);
    }

    public void setId(String str) {
        this.f9574id = str;
    }

    public void setPhoneticName(String str) {
        this.phoneticName = str;
    }

    @Override // com.jibo.aws.integration.aws.services.loop.model.JiboLoopRequest
    public String toString() {
        return "UpdatePhoneticNameRequest {loopId='" + this.loopId + "', id='" + this.f9574id + "', phoneticName='" + this.phoneticName + "'}";
    }
}
