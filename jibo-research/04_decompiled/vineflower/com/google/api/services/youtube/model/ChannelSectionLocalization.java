package com.google.api.services.youtube.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

public final class ChannelSectionLocalization extends GenericJson {
   @Key
   private String title;

   public ChannelSectionLocalization clone() {
      return (ChannelSectionLocalization)super.clone();
   }

   public String getTitle() {
      return this.title;
   }

   public ChannelSectionLocalization set(String var1, Object var2) {
      return (ChannelSectionLocalization)super.set(var1, var2);
   }

   public ChannelSectionLocalization setTitle(String var1) {
      this.title = var1;
      return this;
   }
}
