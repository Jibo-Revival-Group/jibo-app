package com.salesforce.android.cases.core.internal.http.response;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes.dex */
public class BodyResponse {

    @SerializedName(m9428a = "isRichText")
    private boolean isRichText;

    @SerializedName(m9428a = "text")
    private String text;

    /* JADX INFO: renamed from: a */
    public boolean m12254a() {
        return this.isRichText;
    }

    /* JADX INFO: renamed from: b */
    public String m12255b() {
        return this.text;
    }
}
