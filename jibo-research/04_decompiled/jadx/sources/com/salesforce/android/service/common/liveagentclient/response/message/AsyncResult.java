package com.salesforce.android.service.common.liveagentclient.response.message;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes.dex */
public class AsyncResult {

    @SerializedName(m9428a = "error")
    private String mErrorMessage;

    @SerializedName(m9428a = "isSuccess")
    private boolean mIsSuccess;

    /* JADX INFO: renamed from: a */
    public boolean m13872a() {
        return this.mErrorMessage != null;
    }

    /* JADX INFO: renamed from: b */
    public String m13873b() {
        return this.mErrorMessage;
    }
}
