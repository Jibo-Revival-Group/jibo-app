package com.google.api.services.youtube.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

public final class PlaylistPlayer extends GenericJson {
   @Key
   private String embedHtml;

   public PlaylistPlayer clone() {
      return (PlaylistPlayer)super.clone();
   }

   public String getEmbedHtml() {
      return this.embedHtml;
   }

   public PlaylistPlayer set(String var1, Object var2) {
      return (PlaylistPlayer)super.set(var1, var2);
   }

   public PlaylistPlayer setEmbedHtml(String var1) {
      this.embedHtml = var1;
      return this;
   }
}
