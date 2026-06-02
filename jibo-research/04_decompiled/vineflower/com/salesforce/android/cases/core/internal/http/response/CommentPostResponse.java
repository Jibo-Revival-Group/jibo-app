package com.salesforce.android.cases.core.internal.http.response;

import com.google.gson.annotations.SerializedName;

public class CommentPostResponse {
   @SerializedName(a = "actor")
   private ActorResponse actor;
   @SerializedName(a = "body")
   private BodyResponse body;
   @SerializedName(a = "createdDate")
   private String createdDate;
   @SerializedName(a = "id")
   private String id;
   @SerializedName(a = "modifiedDate")
   private String modifiedDate;
   @SerializedName(a = "photoUrl")
   private String photoUrl;
   @SerializedName(a = "type")
   private String type;
   @SerializedName(a = "url")
   private String url;
   @SerializedName(a = "visibility")
   private String visibility;

   public ActorResponse a() {
      return this.actor;
   }

   public BodyResponse b() {
      return this.body;
   }

   public String c() {
      return this.createdDate;
   }

   public String d() {
      return this.id;
   }

   public String e() {
      return this.modifiedDate;
   }

   public String f() {
      return this.photoUrl;
   }

   public String g() {
      return this.type;
   }

   public String h() {
      return this.url;
   }

   public String i() {
      return this.visibility;
   }
}
