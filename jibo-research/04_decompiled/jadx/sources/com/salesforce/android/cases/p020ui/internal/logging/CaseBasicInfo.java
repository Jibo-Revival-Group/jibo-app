package com.salesforce.android.cases.p020ui.internal.logging;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes.dex */
public class CaseBasicInfo {

    @SerializedName(m9428a = "caseListName")
    private final String caseListName;

    @SerializedName(m9428a = "communityUrlString")
    private final String communityUrlString;

    @SerializedName(m9428a = "createCaseActionName")
    private final String createCaseActionName;

    @SerializedName(m9428a = "userType")
    private final String userType;

    public CaseBasicInfo(String str, String str2, String str3, String str4) {
        this.communityUrlString = str;
        this.caseListName = str2;
        this.createCaseActionName = str3;
        this.userType = str4;
    }
}
