package com.google.api.services.youtube.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

public final class I18nRegionSnippet extends GenericJson {
   @Key
   private String gl;
   @Key
   private String name;

   public I18nRegionSnippet clone() {
      return (I18nRegionSnippet)super.clone();
   }

   public String getGl() {
      return this.gl;
   }

   public String getName() {
      return this.name;
   }

   public I18nRegionSnippet set(String var1, Object var2) {
      return (I18nRegionSnippet)super.set(var1, var2);
   }

   public I18nRegionSnippet setGl(String var1) {
      this.gl = var1;
      return this;
   }

   public I18nRegionSnippet setName(String var1) {
      this.name = var1;
      return this;
   }
}
