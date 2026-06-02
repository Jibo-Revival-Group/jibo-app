package com.salesforce.android.knowledge.core.internal.http.response;

import com.google.gson.annotations.SerializedName;

public class ErrorResponse {
   private static String a = "INVALID_FILTER_LANGUAGE";
   private static String b = "ILLEGAL_QUERY_PARAMETER_VALUE";
   @SerializedName(a = "errorCode")
   private String mErrorCode = "";
   @SerializedName(a = "message")
   private String mMessage = "";

   public boolean a() {
      boolean var1;
      if (!a.equals(this.mErrorCode) && !b.equals(this.mErrorCode)) {
         var1 = false;
      } else {
         var1 = true;
      }

      return var1;
   }
}
