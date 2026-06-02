package com.salesforce.android.cases.core.internal.http.response;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes.dex */
public class ListViewDescribeResponse {

    @SerializedName(m9428a = "query")
    private String query;

    @SerializedName(m9428a = "scope")
    private String scope;

    /* JADX INFO: renamed from: a */
    public String m12333a() {
        return this.scope;
    }

    /* JADX INFO: renamed from: b */
    public String m12334b() {
        return this.query;
    }
}
