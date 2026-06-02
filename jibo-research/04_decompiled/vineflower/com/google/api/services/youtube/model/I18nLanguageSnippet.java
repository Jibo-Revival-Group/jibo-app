package com.google.api.services.youtube.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

public final class I18nLanguageSnippet extends GenericJson {
   @Key
   private String hl;
   @Key
   private String name;

   public I18nLanguageSnippet clone() {
      return (I18nLanguageSnippet)super.clone();
   }

   public String getHl() {
      return this.hl;
   }

   public String getName() {
      return this.name;
   }

   public I18nLanguageSnippet set(String var1, Object var2) {
      return (I18nLanguageSnippet)super.set(var1, var2);
   }

   public I18nLanguageSnippet setHl(String var1) {
      this.hl = var1;
      return this;
   }

   public I18nLanguageSnippet setName(String var1) {
      this.name = var1;
      return this;
   }
}
