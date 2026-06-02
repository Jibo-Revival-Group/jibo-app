package com.google.api.services.youtube.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

public final class PlaylistLocalization extends GenericJson {
   @Key
   private String description;
   @Key
   private String title;

   public PlaylistLocalization clone() {
      return (PlaylistLocalization)super.clone();
   }

   public String getDescription() {
      return this.description;
   }

   public String getTitle() {
      return this.title;
   }

   public PlaylistLocalization set(String var1, Object var2) {
      return (PlaylistLocalization)super.set(var1, var2);
   }

   public PlaylistLocalization setDescription(String var1) {
      this.description = var1;
      return this;
   }

   public PlaylistLocalization setTitle(String var1) {
      this.title = var1;
      return this;
   }
}
