package com.google.api.services.youtube.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.json.JsonString;
import com.google.api.client.util.Key;

public final class VideoPlayer extends GenericJson {
   @JsonString
   @Key
   private Long embedHeight;
   @Key
   private String embedHtml;
   @JsonString
   @Key
   private Long embedWidth;

   public VideoPlayer clone() {
      return (VideoPlayer)super.clone();
   }

   public Long getEmbedHeight() {
      return this.embedHeight;
   }

   public String getEmbedHtml() {
      return this.embedHtml;
   }

   public Long getEmbedWidth() {
      return this.embedWidth;
   }

   public VideoPlayer set(String var1, Object var2) {
      return (VideoPlayer)super.set(var1, var2);
   }

   public VideoPlayer setEmbedHeight(Long var1) {
      this.embedHeight = var1;
      return this;
   }

   public VideoPlayer setEmbedHtml(String var1) {
      this.embedHtml = var1;
      return this;
   }

   public VideoPlayer setEmbedWidth(Long var1) {
      this.embedWidth = var1;
      return this;
   }
}
