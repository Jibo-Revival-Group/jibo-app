package com.salesforce.android.cases.core.internal.http.response;

import com.facebook.share.internal.ShareConstants;
import com.google.gson.annotations.SerializedName;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class CommunitiesListResponse {

    @SerializedName(m9428a = "communities")
    private List<Community> communities;

    @SerializedName(m9428a = "total")
    private int total;

    /* JADX INFO: renamed from: a */
    public List<Community> m12323a() {
        return this.communities == null ? Collections.emptyList() : Collections.unmodifiableList(this.communities);
    }

    /* JADX INFO: renamed from: b */
    public int m12324b() {
        return this.total;
    }

    public class Community {

        /* JADX INFO: renamed from: id */
        @SerializedName(m9428a = ShareConstants.WEB_DIALOG_PARAM_ID)
        private String f12322id;

        @SerializedName(m9428a = "siteUrl")
        private String siteUrl;

        /* JADX INFO: renamed from: a */
        public String m12325a() {
            return this.f12322id;
        }

        /* JADX INFO: renamed from: b */
        public String m12326b() {
            return this.siteUrl;
        }
    }
}
