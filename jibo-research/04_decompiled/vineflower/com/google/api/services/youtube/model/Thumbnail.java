package com.google.api.services.youtube.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

public final class Thumbnail extends GenericJson {
   @Key
   private Long height;
   @Key
   private String url;
   @Key
   private Long width;

   public Thumbnail clone() {
      return (Thumbnail)super.clone();
   }

   public Long getHeight() {
      return this.height;
   }

   public String getUrl() {
      return this.url;
   }

   public Long getWidth() {
      return this.width;
   }

   public Thumbnail set(String var1, Object var2) {
      return (Thumbnail)super.set(var1, var2);
   }

   public Thumbnail setHeight(Long var1) {
      this.height = var1;
      return this;
   }

   public Thumbnail setUrl(String var1) {
      this.url = var1;
      return this;
   }

   public Thumbnail setWidth(Long var1) {
      this.width = var1;
      return this;
   }
}
