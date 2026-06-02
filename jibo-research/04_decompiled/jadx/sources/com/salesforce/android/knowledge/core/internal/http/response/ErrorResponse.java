package com.salesforce.android.knowledge.core.internal.http.response;

import com.facebook.share.internal.ShareConstants;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes.dex */
public class ErrorResponse {

    /* JADX INFO: renamed from: a */
    private static String f12949a = "INVALID_FILTER_LANGUAGE";

    /* JADX INFO: renamed from: b */
    private static String f12950b = "ILLEGAL_QUERY_PARAMETER_VALUE";

    @SerializedName(m9428a = "errorCode")
    private String mErrorCode = "";

    @SerializedName(m9428a = ShareConstants.WEB_DIALOG_PARAM_MESSAGE)
    private String mMessage = "";

    /* JADX INFO: renamed from: a */
    public boolean m13195a() {
        return f12949a.equals(this.mErrorCode) || f12950b.equals(this.mErrorCode);
    }
}
