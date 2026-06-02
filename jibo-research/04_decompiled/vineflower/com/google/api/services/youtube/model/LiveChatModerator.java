package com.google.api.services.youtube.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

public final class LiveChatModerator extends GenericJson {
   @Key
   private String etag;
   @Key
   private String id;
   @Key
   private String kind;
   @Key
   private LiveChatModeratorSnippet snippet;

   public LiveChatModerator clone() {
      return (LiveChatModerator)super.clone();
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

   public LiveChatModeratorSnippet getSnippet() {
      return this.snippet;
   }

   public LiveChatModerator set(String var1, Object var2) {
      return (LiveChatModerator)super.set(var1, var2);
   }

   public LiveChatModerator setEtag(String var1) {
      this.etag = var1;
      return this;
   }

   public LiveChatModerator setId(String var1) {
      this.id = var1;
      return this;
   }

   public LiveChatModerator setKind(String var1) {
      this.kind = var1;
      return this;
   }

   public LiveChatModerator setSnippet(LiveChatModeratorSnippet var1) {
      this.snippet = var1;
      return this;
   }
}
