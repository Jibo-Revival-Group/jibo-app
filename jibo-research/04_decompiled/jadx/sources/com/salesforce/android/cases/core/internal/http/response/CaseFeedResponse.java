package com.salesforce.android.cases.core.internal.http.response;

import com.facebook.share.internal.ShareConstants;
import com.google.gson.annotations.SerializedName;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class CaseFeedResponse {

    @SerializedName(m9428a = "currentPageUrl")
    private String currentPageUrl;

    @SerializedName(m9428a = "elements")
    private List<Element> elements;

    @SerializedName(m9428a = "nextPageUrl")
    private String nextPageUrl;

    @SerializedName(m9428a = "updatesUrl")
    private String updatesUrl;

    /* JADX INFO: renamed from: a */
    public String m12290a() {
        return this.currentPageUrl;
    }

    /* JADX INFO: renamed from: b */
    public List<Element> m12291b() {
        return this.elements == null ? Collections.emptyList() : Collections.unmodifiableList(this.elements);
    }

    /* JADX INFO: renamed from: c */
    public String m12292c() {
        return this.nextPageUrl;
    }

    /* JADX INFO: renamed from: d */
    public String m12293d() {
        return this.updatesUrl;
    }

    public class Element {

        @SerializedName(m9428a = "actor")
        private ActorResponse actor;

        @SerializedName(m9428a = "body")
        private BodyResponse body;

        @SerializedName(m9428a = "createdDate")
        private String createdDate;

        /* JADX INFO: renamed from: id */
        @SerializedName(m9428a = ShareConstants.WEB_DIALOG_PARAM_ID)
        private String f12319id;

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
        public ActorResponse m12294a() {
            return this.actor;
        }

        /* JADX INFO: renamed from: b */
        public BodyResponse m12295b() {
            return this.body;
        }

        /* JADX INFO: renamed from: c */
        public String m12296c() {
            return this.createdDate;
        }

        /* JADX INFO: renamed from: d */
        public String m12297d() {
            return this.f12319id;
        }

        /* JADX INFO: renamed from: e */
        public String m12298e() {
            return this.modifiedDate;
        }

        /* JADX INFO: renamed from: f */
        public String m12299f() {
            return this.photoUrl;
        }

        /* JADX INFO: renamed from: g */
        public String m12300g() {
            return this.type;
        }

        /* JADX INFO: renamed from: h */
        public String m12301h() {
            return this.url;
        }

        /* JADX INFO: renamed from: i */
        public String m12302i() {
            return this.visibility;
        }
    }
}
