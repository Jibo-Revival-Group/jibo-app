package com.google.api.services.youtube.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

public final class LanguageTag extends GenericJson {
   @Key
   private String value;

   public LanguageTag clone() {
      return (LanguageTag)super.clone();
   }

   public String getValue() {
      return this.value;
   }

   public LanguageTag set(String var1, Object var2) {
      return (LanguageTag)super.set(var1, var2);
   }

   public LanguageTag setValue(String var1) {
      this.value = var1;
      return this;
   }
}
