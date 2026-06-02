package com.salesforce.android.knowledge.core.internal.http.response;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class DataCategoryGroupsResponse {

    @SerializedName(m9428a = "categoryGroups")
    private List<DataCategoryGroup> mDataCategoryGroups;

    /* JADX INFO: renamed from: a */
    public List<DataCategoryGroup> m13188a() {
        return this.mDataCategoryGroups;
    }

    public static class DataCategoryGroup {

        @SerializedName(m9428a = "label")
        private String mLabel;

        @SerializedName(m9428a = "name")
        private String mName;

        @SerializedName(m9428a = "topCategories")
        private List<DataCategory> mTopCategories;

        /* JADX INFO: renamed from: a */
        public String m13192a() {
            return this.mLabel;
        }

        /* JADX INFO: renamed from: b */
        public String m13193b() {
            return this.mName;
        }

        /* JADX INFO: renamed from: c */
        public List<DataCategory> m13194c() {
            return this.mTopCategories;
        }
    }

    public static class DataCategory {

        @SerializedName(m9428a = "childCategories")
        private List<DataCategory> mChildCategories;

        @SerializedName(m9428a = "label")
        private String mLabel;

        @SerializedName(m9428a = "name")
        private String mName;

        @SerializedName(m9428a = "url")
        private String mUrl;

        /* JADX INFO: renamed from: a */
        public String m13189a() {
            return this.mLabel;
        }

        /* JADX INFO: renamed from: b */
        public String m13190b() {
            return this.mName;
        }

        /* JADX INFO: renamed from: c */
        public List<DataCategory> m13191c() {
            if (this.mChildCategories == null) {
                this.mChildCategories = new ArrayList(0);
            }
            return this.mChildCategories;
        }
    }
}
