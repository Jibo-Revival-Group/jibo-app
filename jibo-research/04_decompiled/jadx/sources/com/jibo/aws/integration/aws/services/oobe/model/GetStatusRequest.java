package com.jibo.aws.integration.aws.services.oobe.model;

import com.google.gson.annotations.Expose;

/* JADX INFO: loaded from: classes.dex */
public class GetStatusRequest extends JiboOobeRequest {

    @Expose
    private String token;

    public GetStatusRequest(String str) {
        this.token = str;
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
}
