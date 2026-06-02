package com.salesforce.android.cases.core.internal.http.response;

import com.facebook.internal.AnalyticsEvents;
import com.facebook.share.internal.ShareConstants;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes.dex */
public class ActorResponse {

    @SerializedName(m9428a = "companyName")
    private String companyName;

    @SerializedName(m9428a = "displayName")
    private String displayName;

    @SerializedName(m9428a = "firstName")
    private String firstName;

    /* JADX INFO: renamed from: id */
    @SerializedName(m9428a = ShareConstants.WEB_DIALOG_PARAM_ID)
    private String f12316id;

    @SerializedName(m9428a = "isActive")
    private boolean isActive;

    @SerializedName(m9428a = "isInThisCommunity")
    private boolean isInThisCommunity;

    @SerializedName(m9428a = "lastName")
    private String lastName;

    @SerializedName(m9428a = AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_PHOTO)
    private PhotoResponse photo;

    @SerializedName(m9428a = ShareConstants.WEB_DIALOG_PARAM_TITLE)
    private String title;

    @SerializedName(m9428a = ShareConstants.MEDIA_TYPE)
    private String type;

    /* JADX INFO: renamed from: a */
    public String m12244a() {
        return this.companyName;
    }

    /* JADX INFO: renamed from: b */
    public String m12245b() {
        return this.displayName;
    }

    /* JADX INFO: renamed from: c */
    public String m12246c() {
        return this.firstName;
    }

    /* JADX INFO: renamed from: d */
    public String m12247d() {
        return this.f12316id;
    }

    /* JADX INFO: renamed from: e */
    public boolean m12248e() {
        return this.isActive;
    }

    /* JADX INFO: renamed from: f */
    public boolean m12249f() {
        return this.isInThisCommunity;
    }

    /* JADX INFO: renamed from: g */
    public String m12250g() {
        return this.lastName;
    }

    /* JADX INFO: renamed from: h */
    public PhotoResponse m12251h() {
        return this.photo;
    }

    /* JADX INFO: renamed from: i */
    public String m12252i() {
        return this.title;
    }

    /* JADX INFO: renamed from: j */
    public String m12253j() {
        return this.type;
    }
}
