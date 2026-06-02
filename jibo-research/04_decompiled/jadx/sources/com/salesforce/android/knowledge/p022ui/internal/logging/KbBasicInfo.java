package com.salesforce.android.knowledge.p022ui.internal.logging;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes.dex */
class KbBasicInfo {

    @SerializedName(m9428a = "communityUrl")
    final String mCommunityUrl;

    @SerializedName(m9428a = "dataCategoryGroup")
    final String mDataCategoryGroup;

    @SerializedName(m9428a = "rootCategory")
    final String mRootCategory;

    @SerializedName(m9428a = "userType")
    final String mUserType;

    KbBasicInfo(String str, String str2, String str3, boolean z) {
        this.mCommunityUrl = str;
        this.mDataCategoryGroup = str2;
        this.mRootCategory = str3;
        this.mUserType = z ? "authenticated" : "guest";
    }
}
