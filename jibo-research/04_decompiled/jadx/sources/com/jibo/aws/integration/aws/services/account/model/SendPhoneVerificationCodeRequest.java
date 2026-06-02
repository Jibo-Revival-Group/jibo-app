package com.jibo.aws.integration.aws.services.account.model;

import com.google.gson.annotations.Expose;

/* JADX INFO: loaded from: classes.dex */
public class SendPhoneVerificationCodeRequest extends JiboAccountRequest {

    @Expose
    private String phoneNumber;

    public SendPhoneVerificationCodeRequest(String str) {
        this.phoneNumber = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof SendPhoneVerificationCodeRequest)) {
            return false;
        }
        SendPhoneVerificationCodeRequest sendPhoneVerificationCodeRequest = (SendPhoneVerificationCodeRequest) obj;
        if ((sendPhoneVerificationCodeRequest.getPhoneNumber() == null) ^ (getPhoneNumber() == null)) {
            return false;
        }
        return sendPhoneVerificationCodeRequest.getPhoneNumber() == null || sendPhoneVerificationCodeRequest.getPhoneNumber().equals(getPhoneNumber());
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public int hashCode() {
        return (getPhoneNumber() == null ? 0 : getPhoneNumber().hashCode()) + 31;
    }

    public void setPhoneNumber(String str) {
        this.phoneNumber = str;
    }

    public String toString() {
        return getClass().getSimpleName() + " {phoneNumber='" + this.phoneNumber + "'}";
    }
}
