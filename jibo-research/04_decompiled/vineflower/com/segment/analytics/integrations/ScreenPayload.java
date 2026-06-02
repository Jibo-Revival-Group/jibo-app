package com.segment.analytics.integrations;

import com.segment.analytics.Properties;
import com.segment.analytics.internal.Utils;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

public class ScreenPayload extends BasePayload {
   static final String CATEGORY_KEY = "category";
   static final String NAME_KEY = "name";
   static final String PROPERTIES_KEY = "properties";

   ScreenPayload(
      String var1, Date var2, Map<String, Object> var3, Map<String, Object> var4, String var5, String var6, String var7, String var8, Map<String, Object> var9
   ) {
      super(BasePayload.Type.screen, var1, var2, var3, var4, var5, var6);
      if (!Utils.isNullOrEmpty(var7)) {
         this.put("name", var7);
      }

      if (!Utils.isNullOrEmpty(var8)) {
         this.put("category", var8);
      }

      this.put("properties", var9);
   }

   @Deprecated
   public String category() {
      return this.getString("category");
   }

   public String event() {
      String var1 = this.name();
      if (Utils.isNullOrEmpty(var1)) {
         var1 = this.category();
      }

      return var1;
   }

   public String name() {
      return this.getString("name");
   }

   public Properties properties() {
      return this.getValueMap("properties", Properties.class);
   }

   public ScreenPayload.Builder toBuilder() {
      return new ScreenPayload.Builder(this);
   }

   @Override
   public String toString() {
      return "ScreenPayload{name=\"" + this.name() + ",category=\"" + this.category() + "\"}";
   }

   public static class Builder extends BasePayload.Builder<ScreenPayload, ScreenPayload.Builder> {
      private String category;
      private String name;
      private Map<String, Object> properties;

      public Builder() {
      }

      Builder(ScreenPayload var1) {
         super(var1);
         this.name = var1.name();
         this.properties = var1.properties();
      }

      @Deprecated
      public ScreenPayload.Builder category(String var1) {
         this.category = var1;
         return this;
      }

      public ScreenPayload.Builder name(String var1) {
         this.name = var1;
         return this;
      }

      public ScreenPayload.Builder properties(Map<String, ?> var1) {
         Utils.assertNotNull(var1, "properties");
         this.properties = Collections.unmodifiableMap(new LinkedHashMap<>(var1));
         return this;
      }

      protected ScreenPayload realBuild(String var1, Date var2, Map<String, Object> var3, Map<String, Object> var4, String var5, String var6) {
         if (Utils.isNullOrEmpty(this.name) && Utils.isNullOrEmpty(this.category)) {
            throw new NullPointerException("either name or category is required");
         }

         Map var8 = this.properties;
         Map var7 = var8;
         if (Utils.isNullOrEmpty(var8)) {
            var7 = Collections.emptyMap();
         }

         return new ScreenPayload(var1, var2, var3, var4, var5, var6, this.name, this.category, var7);
      }

      ScreenPayload.Builder self() {
         return this;
      }
   }
}
