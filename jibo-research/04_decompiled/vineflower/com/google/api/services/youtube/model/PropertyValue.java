package com.google.api.services.youtube.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

public final class PropertyValue extends GenericJson {
   @Key
   private String property;
   @Key
   private String value;

   public PropertyValue clone() {
      return (PropertyValue)super.clone();
   }

   public String getProperty() {
      return this.property;
   }

   public String getValue() {
      return this.value;
   }

   public PropertyValue set(String var1, Object var2) {
      return (PropertyValue)super.set(var1, var2);
   }

   public PropertyValue setProperty(String var1) {
      this.property = var1;
      return this;
   }

   public PropertyValue setValue(String var1) {
      this.value = var1;
      return this;
   }
}
