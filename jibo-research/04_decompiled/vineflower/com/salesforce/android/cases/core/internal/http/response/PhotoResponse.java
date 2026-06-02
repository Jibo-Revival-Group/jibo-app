package com.salesforce.android.cases.core.internal.http.response;

import com.google.gson.annotations.SerializedName;

public class PhotoResponse {
   @SerializedName(a = "fullEmailPhotoUrl")
   private String fullEmailPhotoUrl;
   @SerializedName(a = "largePhotoUrl")
   private String largePhotoUrl;
   @SerializedName(a = "photoVersionId")
   private String photoVersionId;
   @SerializedName(a = "smallPhotoUrl")
   private String smallPhotoUrl;
   @SerializedName(a = "standardEmailPhotoUrl")
   private String standardEmailPhotoUrl;
   @SerializedName(a = "url")
   private String url;

   public String a() {
      return this.fullEmailPhotoUrl;
   }

   public String b() {
      return this.largePhotoUrl;
   }

   public String c() {
      return this.photoVersionId;
   }

   public String d() {
      return this.smallPhotoUrl;
   }

   public String e() {
      return this.standardEmailPhotoUrl;
   }

   public String f() {
      return this.url;
   }
}
