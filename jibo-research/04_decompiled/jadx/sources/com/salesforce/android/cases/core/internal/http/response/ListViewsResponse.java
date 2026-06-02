package com.salesforce.android.cases.core.internal.http.response;

import com.facebook.share.internal.ShareConstants;
import com.google.gson.annotations.SerializedName;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ListViewsResponse {

    @SerializedName(m9428a = "listviews")
    private List<ListView> listviews;

    @SerializedName(m9428a = "size")
    private int size;

    /* JADX INFO: renamed from: a */
    public List<ListView> m12335a() {
        return this.listviews == null ? Collections.emptyList() : Collections.unmodifiableList(this.listviews);
    }

    /* JADX INFO: renamed from: b */
    public int m12336b() {
        return this.size;
    }

    public class ListView {

        @SerializedName(m9428a = "developerName")
        private String developerName;

        /* JADX INFO: renamed from: id */
        @SerializedName(m9428a = ShareConstants.WEB_DIALOG_PARAM_ID)
        private String f12325id;

        @SerializedName(m9428a = "label")
        private String label;

        /* JADX INFO: renamed from: a */
        public String m12337a() {
            return this.developerName;
        }

        /* JADX INFO: renamed from: b */
        public String m12338b() {
            return this.f12325id;
        }

        /* JADX INFO: renamed from: c */
        public String m12339c() {
            return this.label;
        }
    }
}
