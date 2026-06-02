package com.google.api.services.youtube.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

public final class GuideCategory extends GenericJson {
   @Key
   private String etag;
   @Key
   private String id;
   @Key
   private String kind;
   @Key
   private GuideCategorySnippet snippet;

   public GuideCategory clone() {
      return (GuideCategory)super.clone();
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

   public GuideCategorySnippet getSnippet() {
      return this.snippet;
   }

   public GuideCategory set(String var1, Object var2) {
      return (GuideCategory)super.set(var1, var2);
   }

   public GuideCategory setEtag(String var1) {
      this.etag = var1;
      return this;
   }

   public GuideCategory setId(String var1) {
      this.id = var1;
      return this;
   }

   public GuideCategory setKind(String var1) {
      this.kind = var1;
      return this;
   }

   public GuideCategory setSnippet(GuideCategorySnippet var1) {
      this.snippet = var1;
      return this;
   }
}
