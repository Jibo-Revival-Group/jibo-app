package com.jibo.aws.integration.aws.services.notification.model;

import com.google.gson.annotations.Expose;

/* JADX INFO: loaded from: classes.dex */
public class GetStatusRequest extends JiboNotificationRequest {

    @Expose
    private String accountId;

    public GetStatusRequest(String str) {
        this.accountId = str;
    }

    public String getAccountId() {
        return this.accountId;
    }

    public int hashCode() {
        return (getAccountId() == null ? 0 : getAccountId().hashCode()) + 31;
    }

    public void setAccountId(String str) {
        this.accountId = str;
    }
}
