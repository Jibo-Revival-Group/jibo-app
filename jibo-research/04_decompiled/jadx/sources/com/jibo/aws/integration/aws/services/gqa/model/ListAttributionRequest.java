package com.jibo.aws.integration.aws.services.gqa.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes.dex */
public class ListAttributionRequest extends GQABaseRequest {

    @Expose
    private long after;

    @Expose
    private long before;

    /* JADX INFO: renamed from: id */
    @SerializedName(m9428a = "ID")
    @Expose
    private String f9443id;

    @SerializedName(m9428a = "Service")
    @Expose
    private String service = "";

    public ListAttributionRequest(String str, long j) {
        this.f9443id = str;
        this.before = j;
    }

    public long getAfter() {
        return this.after;
    }

    public long getBefore() {
        return this.before;
    }

    public String getId() {
        return this.f9443id;
    }

    public String getService() {
        return this.service;
    }

    public void setAfter(long j) {
        this.after = j;
    }

    public void setBefore(long j) {
        this.before = j;
    }

    public void setId(String str) {
        this.f9443id = str;
    }

    public void setService(String str) {
        this.service = str;
    }
}
