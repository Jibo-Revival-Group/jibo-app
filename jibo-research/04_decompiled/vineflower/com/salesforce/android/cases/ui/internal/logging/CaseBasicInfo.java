package com.salesforce.android.cases.ui.internal.logging;

import com.google.gson.annotations.SerializedName;

public class CaseBasicInfo {
   @SerializedName(a = "caseListName")
   private final String caseListName;
   @SerializedName(a = "communityUrlString")
   private final String communityUrlString;
   @SerializedName(a = "createCaseActionName")
   private final String createCaseActionName;
   @SerializedName(a = "userType")
   private final String userType;

   public CaseBasicInfo(String var1, String var2, String var3, String var4) {
      this.communityUrlString = var1;
      this.caseListName = var2;
      this.createCaseActionName = var3;
      this.userType = var4;
   }
}
