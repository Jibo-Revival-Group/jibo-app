package com.google.api.services.youtube.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

public final class ActivityContentDetailsSocial extends GenericJson {
   @Key
   private String author;
   @Key
   private String imageUrl;
   @Key
   private String referenceUrl;
   @Key
   private ResourceId resourceId;
   @Key
   private String type;

   public ActivityContentDetailsSocial clone() {
      return (ActivityContentDetailsSocial)super.clone();
   }

   public String getAuthor() {
      return this.author;
   }

   public String getImageUrl() {
      return this.imageUrl;
   }

   public String getReferenceUrl() {
      return this.referenceUrl;
   }

   public ResourceId getResourceId() {
      return this.resourceId;
   }

   public String getType() {
      return this.type;
   }

   public ActivityContentDetailsSocial set(String var1, Object var2) {
      return (ActivityContentDetailsSocial)super.set(var1, var2);
   }

   public ActivityContentDetailsSocial setAuthor(String var1) {
      this.author = var1;
      return this;
   }

   public ActivityContentDetailsSocial setImageUrl(String var1) {
      this.imageUrl = var1;
      return this;
   }

   public ActivityContentDetailsSocial setReferenceUrl(String var1) {
      this.referenceUrl = var1;
      return this;
   }

   public ActivityContentDetailsSocial setResourceId(ResourceId var1) {
      this.resourceId = var1;
      return this;
   }

   public ActivityContentDetailsSocial setType(String var1) {
      this.type = var1;
      return this;
   }
}
