package com.google.api.services.youtube.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

public final class LiveChatBan extends GenericJson {
   @Key
   private String etag;
   @Key
   private String id;
   @Key
   private String kind;
   @Key
   private LiveChatBanSnippet snippet;

   public LiveChatBan clone() {
      return (LiveChatBan)super.clone();
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

   public LiveChatBanSnippet getSnippet() {
      return this.snippet;
   }

   public LiveChatBan set(String var1, Object var2) {
      return (LiveChatBan)super.set(var1, var2);
   }

   public LiveChatBan setEtag(String var1) {
      this.etag = var1;
      return this;
   }

   public LiveChatBan setId(String var1) {
      this.id = var1;
      return this;
   }

   public LiveChatBan setKind(String var1) {
      this.kind = var1;
      return this;
   }

   public LiveChatBan setSnippet(LiveChatBanSnippet var1) {
      this.snippet = var1;
      return this;
   }
}
