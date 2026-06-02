package com.salesforce.android.cases.core.internal.http.response;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes.dex */
public class PhotoResponse {

    @SerializedName(m9428a = "fullEmailPhotoUrl")
    private String fullEmailPhotoUrl;

    @SerializedName(m9428a = "largePhotoUrl")
    private String largePhotoUrl;

    @SerializedName(m9428a = "photoVersionId")
    private String photoVersionId;

    @SerializedName(m9428a = "smallPhotoUrl")
    private String smallPhotoUrl;

    @SerializedName(m9428a = "standardEmailPhotoUrl")
    private String standardEmailPhotoUrl;

    @SerializedName(m9428a = "url")
    private String url;

    /* JADX INFO: renamed from: a */
    public String m12340a() {
        return this.fullEmailPhotoUrl;
    }

    /* JADX INFO: renamed from: b */
    public String m12341b() {
        return this.largePhotoUrl;
    }

    /* JADX INFO: renamed from: c */
    public String m12342c() {
        return this.photoVersionId;
    }

    /* JADX INFO: renamed from: d */
    public String m12343d() {
        return this.smallPhotoUrl;
    }

    /* JADX INFO: renamed from: e */
    public String m12344e() {
        return this.standardEmailPhotoUrl;
    }

    /* JADX INFO: renamed from: f */
    public String m12345f() {
        return this.url;
    }
}
