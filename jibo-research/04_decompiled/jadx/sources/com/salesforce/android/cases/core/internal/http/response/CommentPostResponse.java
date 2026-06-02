package com.salesforce.android.cases.core.internal.http.response;

import com.facebook.share.internal.ShareConstants;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes.dex */
public class CommentPostResponse {

    @SerializedName(m9428a = "actor")
    private ActorResponse actor;

    @SerializedName(m9428a = "body")
    private BodyResponse body;

    @SerializedName(m9428a = "createdDate")
    private String createdDate;

    /* JADX INFO: renamed from: id */
    @SerializedName(m9428a = ShareConstants.WEB_DIALOG_PARAM_ID)
    private String f12321id;

    @SerializedName(m9428a = "modifiedDate")
    private String modifiedDate;

    @SerializedName(m9428a = "photoUrl")
    private String photoUrl;

    @SerializedName(m9428a = ShareConstants.MEDIA_TYPE)
    private String type;

    @SerializedName(m9428a = "url")
    private String url;

    @SerializedName(m9428a = "visibility")
    private String visibility;

    /* JADX INFO: renamed from: a */
    public ActorResponse m12314a() {
        return this.actor;
    }

    /* JADX INFO: renamed from: b */
    public BodyResponse m12315b() {
        return this.body;
    }

    /* JADX INFO: renamed from: c */
    public String m12316c() {
        return this.createdDate;
    }

    /* JADX INFO: renamed from: d */
    public String m12317d() {
        return this.f12321id;
    }

    /* JADX INFO: renamed from: e */
    public String m12318e() {
        return this.modifiedDate;
    }

    /* JADX INFO: renamed from: f */
    public String m12319f() {
        return this.photoUrl;
    }

    /* JADX INFO: renamed from: g */
    public String m12320g() {
        return this.type;
    }

    /* JADX INFO: renamed from: h */
    public String m12321h() {
        return this.url;
    }

    /* JADX INFO: renamed from: i */
    public String m12322i() {
        return this.visibility;
    }
}
