package com.jibo.aws.integration.aws.services.account.model;

import com.google.gson.annotations.Expose;

/* JADX INFO: loaded from: classes.dex */
public abstract class ByCodeRequest extends JiboAccountRequest {

    @Expose
    private String code;

    public ByCodeRequest(String str) {
        this.code = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ByCodeRequest)) {
            return false;
        }
        ByCodeRequest byCodeRequest = (ByCodeRequest) obj;
        if ((byCodeRequest.getCode() == null) ^ (getCode() == null)) {
            return false;
        }
        return byCodeRequest.getCode() == null || byCodeRequest.getCode().equals(getCode());
    }

    public String getCode() {
        return this.code;
    }

    public int hashCode() {
        return (getCode() == null ? 0 : getCode().hashCode()) + 31;
    }

    public void setCode(String str) {
        this.code = str;
    }

    public String toString() {
        return "ByCodeRequest {code='" + this.code + "'}";
    }
}
