package com.jibo.aws.integration.aws.services.gqa.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ListAttributionRequest extends GQABaseRequest {
   @Expose
   private long after;
   @Expose
   private long before;
   @Expose
   @SerializedName(a = "ID")
   private String id;
   @Expose
   @SerializedName(a = "Service")
   private String service = "";

   public ListAttributionRequest(String var1, long var2) {
      this.id = var1;
      this.before = var2;
   }

   public long getAfter() {
      return this.after;
   }

   public long getBefore() {
      return this.before;
   }

   public String getId() {
      return this.id;
   }

   public String getService() {
      return this.service;
   }

   public void setAfter(long var1) {
      this.after = var1;
   }

   public void setBefore(long var1) {
      this.before = var1;
   }

   public void setId(String var1) {
      this.id = var1;
   }

   public void setService(String var1) {
      this.service = var1;
   }
}
