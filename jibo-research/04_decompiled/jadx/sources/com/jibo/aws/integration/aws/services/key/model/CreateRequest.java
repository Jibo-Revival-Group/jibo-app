package com.jibo.aws.integration.aws.services.key.model;

import com.google.gson.annotations.Expose;

/* JADX INFO: loaded from: classes.dex */
public class CreateRequest extends JiboKeyRequest {

    @Expose
    private String loopId;

    @Expose
    private String publicKey;

    public CreateRequest(String str, String str2) {
        this.loopId = str;
        this.publicKey = str2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof CreateRequest)) {
            return false;
        }
        CreateRequest createRequest = (CreateRequest) obj;
        if ((createRequest.getPublicKey() == null) ^ (getPublicKey() == null)) {
            return false;
        }
        if (createRequest.getPublicKey() != null && !createRequest.getPublicKey().equals(getPublicKey())) {
            return false;
        }
        if ((createRequest.getLoopId() == null) ^ (getLoopId() == null)) {
            return false;
        }
        return createRequest.getLoopId() == null || createRequest.getLoopId().equals(getLoopId());
    }

    public String getLoopId() {
        return this.loopId;
    }

    public String getPublicKey() {
        return this.publicKey;
    }

    @Override // com.jibo.aws.integration.aws.services.common.model.JiboRequestAbstract
    public String getServiceMethodName() {
        return "CreateRequest";
    }

    public int hashCode() {
        return (((getPublicKey() == null ? 0 : getPublicKey().hashCode()) + 31) * 31) + (getLoopId() != null ? getLoopId().hashCode() : 0);
    }

    public void setLoopId(String str) {
        this.loopId = str;
    }

    public void setPublicKey(String str) {
        this.publicKey = str;
    }

    public String toString() {
        return "CreateRequest {publicKey='" + this.publicKey + "'loopId='" + this.loopId + "'}";
    }
}
