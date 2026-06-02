package com.jibo.aws.integration.aws.services.oobe.model;

import com.google.gson.annotations.Expose;

/* JADX INFO: loaded from: classes.dex */
public class SetupRobotRequest extends JiboOobeRequest {

    /* JADX INFO: renamed from: id */
    @Expose
    private String f9611id;

    @Expose
    private String token;

    public SetupRobotRequest(String str, String str2) {
        this.f9611id = str;
        this.token = str2;
    }

    public String getId() {
        return this.f9611id;
    }

    public String getToken() {
        return this.token;
    }

    public int hashCode() {
        return (((getId() == null ? 0 : getId().hashCode()) + 31) * 31) + (getToken() != null ? getToken().hashCode() : 0);
    }

    public void setId(String str) {
        this.f9611id = str;
    }

    public void setToken(String str) {
        this.token = str;
    }
}
