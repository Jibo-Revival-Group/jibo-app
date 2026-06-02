package com.google.api.services.youtube.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

public final class PromotedItemId extends GenericJson {
   @Key
   private String recentlyUploadedBy;
   @Key
   private String type;
   @Key
   private String videoId;
   @Key
   private String websiteUrl;

   public PromotedItemId clone() {
      return (PromotedItemId)super.clone();
   }

   public String getRecentlyUploadedBy() {
      return this.recentlyUploadedBy;
   }

   public String getType() {
      return this.type;
   }

   public String getVideoId() {
      return this.videoId;
   }

   public String getWebsiteUrl() {
      return this.websiteUrl;
   }

   public PromotedItemId set(String var1, Object var2) {
      return (PromotedItemId)super.set(var1, var2);
   }

   public PromotedItemId setRecentlyUploadedBy(String var1) {
      this.recentlyUploadedBy = var1;
      return this;
   }

   public PromotedItemId setType(String var1) {
      this.type = var1;
      return this;
   }

   public PromotedItemId setVideoId(String var1) {
      this.videoId = var1;
      return this;
   }

   public PromotedItemId setWebsiteUrl(String var1) {
      this.websiteUrl = var1;
      return this;
   }
}
