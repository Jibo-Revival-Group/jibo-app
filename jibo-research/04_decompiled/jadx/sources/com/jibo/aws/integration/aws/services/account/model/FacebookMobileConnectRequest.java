package com.jibo.aws.integration.aws.services.account.model;

import com.google.gson.annotations.Expose;

/* JADX INFO: loaded from: classes.dex */
public class FacebookMobileConnectRequest extends JiboAccountRequest {

    @Expose
    private String token;

    public FacebookMobileConnectRequest(String str) {
        this.token = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof FacebookMobileConnectRequest)) {
            return false;
        }
        FacebookMobileConnectRequest facebookMobileConnectRequest = (FacebookMobileConnectRequest) obj;
        if ((facebookMobileConnectRequest.getToken() == null) ^ (getToken() == null)) {
            return false;
        }
        return facebookMobileConnectRequest.getToken() == null || facebookMobileConnectRequest.getToken().equals(getToken());
    }

    public String getToken() {
        return this.token;
    }

    public int hashCode() {
        return (getToken() == null ? 0 : getToken().hashCode()) + 31;
    }

    public void setToken(String str) {
        this.token = str;
    }

    public String toString() {
        return "FacebookConnectRequest {token='" + this.token + "'}";
    }
}
