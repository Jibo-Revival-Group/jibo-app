package com.segment.analytics;

import android.content.Context;
import java.util.Collections;
import java.util.Map;

class ProjectSettings extends ValueMap {
   private static final String INTEGRATIONS_KEY = "integrations";
   private static final String PLAN_KEY = "plan";
   private static final String TIMESTAMP_KEY = "timestamp";
   private static final String TRACKING_PLAN_KEY = "track";

   ProjectSettings(Map<String, Object> var1) {
      super(Collections.unmodifiableMap(var1));
   }

   static ProjectSettings create(Map<String, Object> var0) {
      var0.put("timestamp", System.currentTimeMillis());
      return new ProjectSettings(var0);
   }

   ValueMap integrations() {
      return this.getValueMap("integrations");
   }

   ValueMap plan() {
      return this.getValueMap("plan");
   }

   long timestamp() {
      return this.getLong("timestamp", 0L);
   }

   ValueMap trackingPlan() {
      ValueMap var1 = this.plan();
      if (var1 == null) {
         var1 = null;
      } else {
         var1 = var1.getValueMap("track");
      }

      return var1;
   }

   static class Cache extends ValueMap.Cache<ProjectSettings> {
      private static final String PROJECT_SETTINGS_CACHE_KEY_PREFIX = "project-settings-plan-";

      Cache(Context var1, Cartographer var2, String var3) {
         super(var1, var2, "project-settings-plan-" + var3, var3, ProjectSettings.class);
      }

      public ProjectSettings create(Map<String, Object> var1) {
         return new ProjectSettings(var1);
      }
   }
}
