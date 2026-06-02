package com.salesforce.android.knowledge.ui.internal.logging;

import com.google.gson.annotations.SerializedName;

class KbBasicInfo {
   @SerializedName(a = "communityUrl")
   final String mCommunityUrl;
   @SerializedName(a = "dataCategoryGroup")
   final String mDataCategoryGroup;
   @SerializedName(a = "rootCategory")
   final String mRootCategory;
   @SerializedName(a = "userType")
   final String mUserType;

   KbBasicInfo(String var1, String var2, String var3, boolean var4) {
      this.mCommunityUrl = var1;
      this.mDataCategoryGroup = var2;
      this.mRootCategory = var3;
      if (var4) {
         var1 = "authenticated";
      } else {
         var1 = "guest";
      }

      this.mUserType = var1;
   }
}
