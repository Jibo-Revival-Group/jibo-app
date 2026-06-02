package com.salesforce.android.cases.core.internal.http.response;

import com.google.gson.annotations.SerializedName;

public class ListViewDescribeResponse {
   @SerializedName(a = "query")
   private String query;
   @SerializedName(a = "scope")
   private String scope;

   public String a() {
      return this.scope;
   }

   public String b() {
      return this.query;
   }
}
