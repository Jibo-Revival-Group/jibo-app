package com.google.api.services.youtube.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

public final class ChannelLocalization extends GenericJson {
   @Key
   private String description;
   @Key
   private String title;

   public ChannelLocalization clone() {
      return (ChannelLocalization)super.clone();
   }

   public String getDescription() {
      return this.description;
   }

   public String getTitle() {
      return this.title;
   }

   public ChannelLocalization set(String var1, Object var2) {
      return (ChannelLocalization)super.set(var1, var2);
   }

   public ChannelLocalization setDescription(String var1) {
      this.description = var1;
      return this;
   }

   public ChannelLocalization setTitle(String var1) {
      this.title = var1;
      return this;
   }
}
