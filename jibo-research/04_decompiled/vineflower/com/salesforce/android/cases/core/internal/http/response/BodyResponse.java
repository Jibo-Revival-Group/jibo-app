package com.salesforce.android.cases.core.internal.http.response;

import com.google.gson.annotations.SerializedName;

public class BodyResponse {
   @SerializedName(a = "isRichText")
   private boolean isRichText;
   @SerializedName(a = "text")
   private String text;

   public boolean a() {
      return this.isRichText;
   }

   public String b() {
      return this.text;
   }
}
