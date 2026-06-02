package com.segment.analytics.integrations;

import com.segment.analytics.Traits;
import com.segment.analytics.internal.Utils;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

public class IdentifyPayload extends BasePayload {
   static final String TRAITS_KEY = "traits";

   IdentifyPayload(String var1, Date var2, Map<String, Object> var3, Map<String, Object> var4, String var5, String var6, Map<String, Object> var7) {
      super(BasePayload.Type.identify, var1, var2, var3, var4, var5, var6);
      this.put("traits", var7);
   }

   public IdentifyPayload.Builder toBuilder() {
      return new IdentifyPayload.Builder(this);
   }

   @Override
   public String toString() {
      return "IdentifyPayload{\"userId=\"" + this.userId() + "\"}";
   }

   public Traits traits() {
      return this.getValueMap("traits", Traits.class);
   }

   public static class Builder extends BasePayload.Builder<IdentifyPayload, IdentifyPayload.Builder> {
      private Map<String, Object> traits;

      public Builder() {
      }

      Builder(IdentifyPayload var1) {
         super(var1);
         this.traits = var1.traits();
      }

      IdentifyPayload realBuild(String var1, Date var2, Map<String, Object> var3, Map<String, Object> var4, String var5, String var6) {
         if (Utils.isNullOrEmpty(var5) && Utils.isNullOrEmpty(this.traits)) {
            throw new NullPointerException("either userId or traits are required");
         } else {
            return new IdentifyPayload(var1, var2, var3, var4, var5, var6, this.traits);
         }
      }

      IdentifyPayload.Builder self() {
         return this;
      }

      public IdentifyPayload.Builder traits(Map<String, ?> var1) {
         Utils.assertNotNull(var1, "traits");
         this.traits = Collections.unmodifiableMap(new LinkedHashMap<>(var1));
         return this;
      }
   }
}
