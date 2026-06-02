package com.google.api.services.youtube.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

public final class SuperChatEvent extends GenericJson {
   @Key
   private String etag;
   @Key
   private String id;
   @Key
   private String kind;
   @Key
   private SuperChatEventSnippet snippet;

   public SuperChatEvent clone() {
      return (SuperChatEvent)super.clone();
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

   public SuperChatEventSnippet getSnippet() {
      return this.snippet;
   }

   public SuperChatEvent set(String var1, Object var2) {
      return (SuperChatEvent)super.set(var1, var2);
   }

   public SuperChatEvent setEtag(String var1) {
      this.etag = var1;
      return this;
   }

   public SuperChatEvent setId(String var1) {
      this.id = var1;
      return this;
   }

   public SuperChatEvent setKind(String var1) {
      this.kind = var1;
      return this;
   }

   public SuperChatEvent setSnippet(SuperChatEventSnippet var1) {
      this.snippet = var1;
      return this;
   }
}
