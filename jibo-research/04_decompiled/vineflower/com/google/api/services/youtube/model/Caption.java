package com.google.api.services.youtube.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

public final class Caption extends GenericJson {
   @Key
   private String etag;
   @Key
   private String id;
   @Key
   private String kind;
   @Key
   private CaptionSnippet snippet;

   public Caption clone() {
      return (Caption)super.clone();
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

   public CaptionSnippet getSnippet() {
      return this.snippet;
   }

   public Caption set(String var1, Object var2) {
      return (Caption)super.set(var1, var2);
   }

   public Caption setEtag(String var1) {
      this.etag = var1;
      return this;
   }

   public Caption setId(String var1) {
      this.id = var1;
      return this;
   }

   public Caption setKind(String var1) {
      this.kind = var1;
      return this;
   }

   public Caption setSnippet(CaptionSnippet var1) {
      this.snippet = var1;
      return this;
   }
}
