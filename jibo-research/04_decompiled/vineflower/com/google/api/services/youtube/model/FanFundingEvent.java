package com.google.api.services.youtube.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

public final class FanFundingEvent extends GenericJson {
   @Key
   private String etag;
   @Key
   private String id;
   @Key
   private String kind;
   @Key
   private FanFundingEventSnippet snippet;

   public FanFundingEvent clone() {
      return (FanFundingEvent)super.clone();
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

   public FanFundingEventSnippet getSnippet() {
      return this.snippet;
   }

   public FanFundingEvent set(String var1, Object var2) {
      return (FanFundingEvent)super.set(var1, var2);
   }

   public FanFundingEvent setEtag(String var1) {
      this.etag = var1;
      return this;
   }

   public FanFundingEvent setId(String var1) {
      this.id = var1;
      return this;
   }

   public FanFundingEvent setKind(String var1) {
      this.kind = var1;
      return this;
   }

   public FanFundingEvent setSnippet(FanFundingEventSnippet var1) {
      this.snippet = var1;
      return this;
   }
}
