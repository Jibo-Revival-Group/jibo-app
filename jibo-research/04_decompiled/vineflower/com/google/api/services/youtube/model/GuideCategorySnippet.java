package com.google.api.services.youtube.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

public final class GuideCategorySnippet extends GenericJson {
   @Key
   private String channelId;
   @Key
   private String title;

   public GuideCategorySnippet clone() {
      return (GuideCategorySnippet)super.clone();
   }

   public String getChannelId() {
      return this.channelId;
   }

   public String getTitle() {
      return this.title;
   }

   public GuideCategorySnippet set(String var1, Object var2) {
      return (GuideCategorySnippet)super.set(var1, var2);
   }

   public GuideCategorySnippet setChannelId(String var1) {
      this.channelId = var1;
      return this;
   }

   public GuideCategorySnippet setTitle(String var1) {
      this.title = var1;
      return this;
   }
}
