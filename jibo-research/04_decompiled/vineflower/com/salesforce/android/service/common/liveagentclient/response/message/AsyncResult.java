package com.salesforce.android.service.common.liveagentclient.response.message;

import com.google.gson.annotations.SerializedName;

public class AsyncResult {
   @SerializedName(a = "error")
   private String mErrorMessage;
   @SerializedName(a = "isSuccess")
   private boolean mIsSuccess;

   public boolean a() {
      boolean var1;
      if (this.mErrorMessage != null) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   public String b() {
      return this.mErrorMessage;
   }
}
