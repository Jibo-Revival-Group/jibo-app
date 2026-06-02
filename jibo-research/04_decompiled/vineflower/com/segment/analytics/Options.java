package com.segment.analytics;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Options {
   public static final String ALL_INTEGRATIONS_KEY = "All";
   private final Map<String, Object> integrations = new ConcurrentHashMap<>();

   public Map<String, Object> integrations() {
      return new LinkedHashMap<>(this.integrations);
   }

   public Options setIntegration(Analytics.BundledIntegration var1, boolean var2) {
      this.setIntegration(var1.key, var2);
      return this;
   }

   public Options setIntegration(String var1, boolean var2) {
      if ("Segment.io".equals(var1)) {
         throw new IllegalArgumentException("Segment integration cannot be enabled or disabled.");
      }

      this.integrations.put(var1, var2);
      return this;
   }

   public Options setIntegrationOptions(Analytics.BundledIntegration var1, Map<String, Object> var2) {
      this.integrations.put(var1.key, var2);
      return this;
   }

   public Options setIntegrationOptions(String var1, Map<String, Object> var2) {
      this.integrations.put(var1, var2);
      return this;
   }
}
