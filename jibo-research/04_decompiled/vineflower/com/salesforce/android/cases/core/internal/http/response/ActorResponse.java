package com.salesforce.android.cases.core.internal.http.response;

import com.google.gson.annotations.SerializedName;

public class ActorResponse {
   @SerializedName(a = "companyName")
   private String companyName;
   @SerializedName(a = "displayName")
   private String displayName;
   @SerializedName(a = "firstName")
   private String firstName;
   @SerializedName(a = "id")
   private String id;
   @SerializedName(a = "isActive")
   private boolean isActive;
   @SerializedName(a = "isInThisCommunity")
   private boolean isInThisCommunity;
   @SerializedName(a = "lastName")
   private String lastName;
   @SerializedName(a = "photo")
   private PhotoResponse photo;
   @SerializedName(a = "title")
   private String title;
   @SerializedName(a = "type")
   private String type;

   public String a() {
      return this.companyName;
   }

   public String b() {
      return this.displayName;
   }

   public String c() {
      return this.firstName;
   }

   public String d() {
      return this.id;
   }

   public boolean e() {
      return this.isActive;
   }

   public boolean f() {
      return this.isInThisCommunity;
   }

   public String g() {
      return this.lastName;
   }

   public PhotoResponse h() {
      return this.photo;
   }

   public String i() {
      return this.title;
   }

   public String j() {
      return this.type;
   }
}
