package com.google.api.services.youtube.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;
import java.util.List;

public final class LocalizedProperty extends GenericJson {
   @Key
   private LanguageTag defaultLanguage;
   @Key("default")
   private String default__;
   @Key
   private List<LocalizedString> localized;

   public LocalizedProperty clone() {
      return (LocalizedProperty)super.clone();
   }

   public String getDefault() {
      return this.default__;
   }

   public LanguageTag getDefaultLanguage() {
      return this.defaultLanguage;
   }

   public List<LocalizedString> getLocalized() {
      return this.localized;
   }

   public LocalizedProperty set(String var1, Object var2) {
      return (LocalizedProperty)super.set(var1, var2);
   }

   public LocalizedProperty setDefault(String var1) {
      this.default__ = var1;
      return this;
   }

   public LocalizedProperty setDefaultLanguage(LanguageTag var1) {
      this.defaultLanguage = var1;
      return this;
   }

   public LocalizedProperty setLocalized(List<LocalizedString> var1) {
      this.localized = var1;
      return this;
   }
}
