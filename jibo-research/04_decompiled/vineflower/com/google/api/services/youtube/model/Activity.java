package com.google.api.services.youtube.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

public final class Activity extends GenericJson {
   @Key
   private ActivityContentDetails contentDetails;
   @Key
   private String etag;
   @Key
   private String id;
   @Key
   private String kind;
   @Key
   private ActivitySnippet snippet;

   public Activity clone() {
      return (Activity)super.clone();
   }

   public ActivityContentDetails getContentDetails() {
      return this.contentDetails;
   }

   public String getEtag() {
      return this.etag;
   }

   public String getId() {
      return this.id;
   }

   public String getKind() {
      return this.kind;
   }

   public ActivitySnippet getSnippet() {
      return this.snippet;
   }

   public Activity set(String var1, Object var2) {
      return (Activity)super.set(var1, var2);
   }

   public Activity setContentDetails(ActivityContentDetails var1) {
      this.contentDetails = var1;
      return this;
   }

   public Activity setEtag(String var1) {
      this.etag = var1;
      return this;
   }

   public Activity setId(String var1) {
      this.id = var1;
      return this;
   }

   public Activity setKind(String var1) {
      this.kind = var1;
      return this;
   }

   public Activity setSnippet(ActivitySnippet var1) {
      this.snippet = var1;
      return this;
   }
}
