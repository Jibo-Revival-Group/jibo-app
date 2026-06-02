package com.jibo.aws.integration.aws.services.account.model;

import com.google.gson.annotations.Expose;

/* JADX INFO: loaded from: classes.dex */
public class FacebookConnectRequest extends JiboAccountRequest {

    @Expose
    private String state;

    @Expose
    private String token;

    public FacebookConnectRequest(String str, String str2) {
        this.state = str;
        this.token = str2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof FacebookConnectRequest)) {
            return false;
        }
        FacebookConnectRequest facebookConnectRequest = (FacebookConnectRequest) obj;
        if ((facebookConnectRequest.getToken() == null) ^ (getToken() == null)) {
            return false;
        }
        if (facebookConnectRequest.getToken() != null && !facebookConnectRequest.getToken().equals(getToken())) {
            return false;
        }
        if ((facebookConnectRequest.getState() == null) ^ (getState() == null)) {
            return false;
        }
        return facebookConnectRequest.getState() == null || facebookConnectRequest.getState().equals(getState());
    }

    public String getState() {
        return this.state;
    }

    public String getToken() {
        return this.token;
    }

    public int hashCode() {
        return (((getState() == null ? 0 : getState().hashCode()) + 31) * 31) + (getToken() != null ? getToken().hashCode() : 0);
    }

    public void setState(String str) {
        this.state = str;
    }

    public void setToken(String str) {
        this.token = str;
    }

    public String toString() {
        return "FacebookConnectRequest {state='" + this.state + "', token='" + this.token + "'}";
    }
}
