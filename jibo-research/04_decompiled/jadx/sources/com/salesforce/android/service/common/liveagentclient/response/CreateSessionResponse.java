package com.salesforce.android.service.common.liveagentclient.response;

import com.facebook.share.internal.ShareConstants;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes.dex */
public class CreateSessionResponse {

    @SerializedName(m9428a = "affinityToken")
    private String mAffinityToken;

    @SerializedName(m9428a = "clientPollTimeout")
    private long mClientPollingTimeoutSeconds;

    @SerializedName(m9428a = ShareConstants.WEB_DIALOG_PARAM_ID)
    private String mSessionId;

    @SerializedName(m9428a = "key")
    private String mSessionKey;

    /* JADX INFO: renamed from: a */
    public String m13867a() {
        return this.mSessionId;
    }

    /* JADX INFO: renamed from: b */
    public String m13868b() {
        return this.mAffinityToken;
    }

    /* JADX INFO: renamed from: c */
    public String m13869c() {
        return this.mSessionKey;
    }

    /* JADX INFO: renamed from: d */
    public long m13870d() {
        return this.mClientPollingTimeoutSeconds * 1000;
    }
}
