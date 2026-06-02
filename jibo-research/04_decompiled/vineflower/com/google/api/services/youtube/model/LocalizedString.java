package com.google.api.services.youtube.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

public final class LocalizedString extends GenericJson {
   @Key
   private String language;
   @Key
   private String value;

   public LocalizedString clone() {
      return (LocalizedString)super.clone();
   }

   public String getLanguage() {
      return this.language;
   }

   public String getValue() {
      return this.value;
   }

   public LocalizedString set(String var1, Object var2) {
      return (LocalizedString)super.set(var1, var2);
   }

   public LocalizedString setLanguage(String var1) {
      this.language = var1;
      return this;
   }

   public LocalizedString setValue(String var1) {
      this.value = var1;
      return this;
   }
}
