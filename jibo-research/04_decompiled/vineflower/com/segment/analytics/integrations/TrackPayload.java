package com.segment.analytics.integrations;

import com.segment.analytics.Properties;
import com.segment.analytics.internal.Utils;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

public class TrackPayload extends BasePayload {
   static final String EVENT_KEY = "event";
   static final String PROPERTIES_KEY = "properties";

   TrackPayload(String var1, Date var2, Map<String, Object> var3, Map<String, Object> var4, String var5, String var6, String var7, Map<String, Object> var8) {
      super(BasePayload.Type.track, var1, var2, var3, var4, var5, var6);
      this.put("event", var7);
      this.put("properties", var8);
   }

   public String event() {
      return this.getString("event");
   }

   public Properties properties() {
      return this.getValueMap("properties", Properties.class);
   }

   public TrackPayload.Builder toBuilder() {
      return new TrackPayload.Builder(this);
   }

   @Override
   public String toString() {
      return "TrackPayload{event=\"" + this.event() + "\"}";
   }

   public static class Builder extends BasePayload.Builder<TrackPayload, TrackPayload.Builder> {
      private String event;
      private Map<String, Object> properties;

      public Builder() {
      }

      Builder(TrackPayload var1) {
         super(var1);
         this.event = var1.event();
         this.properties = var1.properties();
      }

      public TrackPayload.Builder event(String var1) {
         this.event = Utils.assertNotNullOrEmpty(var1, "event");
         return this;
      }

      public TrackPayload.Builder properties(Map<String, ?> var1) {
         Utils.assertNotNull(var1, "properties");
         this.properties = Collections.unmodifiableMap(new LinkedHashMap<>(var1));
         return this;
      }

      protected TrackPayload realBuild(String var1, Date var2, Map<String, Object> var3, Map<String, Object> var4, String var5, String var6) {
         Utils.assertNotNullOrEmpty(this.event, "event");
         Map var8 = this.properties;
         Map var7 = var8;
         if (Utils.isNullOrEmpty(var8)) {
            var7 = Collections.emptyMap();
         }

         return new TrackPayload(var1, var2, var3, var4, var5, var6, this.event, var7);
      }

      TrackPayload.Builder self() {
         return this;
      }
   }
}
