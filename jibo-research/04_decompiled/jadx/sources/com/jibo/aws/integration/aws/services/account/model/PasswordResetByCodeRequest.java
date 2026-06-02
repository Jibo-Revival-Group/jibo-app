package com.jibo.aws.integration.aws.services.account.model;

import com.google.gson.annotations.Expose;

/* JADX INFO: loaded from: classes.dex */
public class PasswordResetByCodeRequest extends JiboAccountRequest {

    @Expose
    private String code;

    @Expose
    private String password;

    public PasswordResetByCodeRequest(String str, String str2) {
        this.code = str;
        this.password = str2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof PasswordResetByCodeRequest)) {
            return false;
        }
        PasswordResetByCodeRequest passwordResetByCodeRequest = (PasswordResetByCodeRequest) obj;
        if ((passwordResetByCodeRequest.getCode() == null) ^ (getCode() == null)) {
            return false;
        }
        if (passwordResetByCodeRequest.getCode() != null && !passwordResetByCodeRequest.getCode().equals(getCode())) {
            return false;
        }
        if ((passwordResetByCodeRequest.getPassword() == null) ^ (getPassword() == null)) {
            return false;
        }
        return passwordResetByCodeRequest.getPassword() == null || passwordResetByCodeRequest.getPassword().equals(getPassword());
    }

    public String getCode() {
        return this.code;
    }

    public String getPassword() {
        return this.password;
    }

    public int hashCode() {
        return (((getCode() == null ? 0 : getCode().hashCode()) + 31) * 31) + (getPassword() != null ? getPassword().hashCode() : 0);
    }

    public void setCode(String str) {
        this.code = str;
    }

    public void setPassword(String str) {
        this.password = str;
    }

    public String toString() {
        return getClass().getSimpleName() + " {code='" + this.code + "'password='" + this.password + "'}";
    }
}
