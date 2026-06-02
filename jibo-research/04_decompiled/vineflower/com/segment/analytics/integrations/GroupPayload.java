package com.segment.analytics.integrations;

import com.segment.analytics.Traits;
import com.segment.analytics.internal.Utils;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

public class GroupPayload extends BasePayload {
   static final String GROUP_ID_KEY = "groupId";
   static final String TRAITS_KEY = "traits";

   public GroupPayload(
      String var1, Date var2, Map<String, Object> var3, Map<String, Object> var4, String var5, String var6, String var7, Map<String, Object> var8
   ) {
      super(BasePayload.Type.group, var1, var2, var3, var4, var5, var6);
      this.put("groupId", var7);
      this.put("traits", var8);
   }

   public String groupId() {
      return this.getString("groupId");
   }

   public GroupPayload.Builder toBuilder() {
      return new GroupPayload.Builder(this);
   }

   @Override
   public String toString() {
      return "GroupPayload{groupId=\"" + this.groupId() + "\"}";
   }

   public Traits traits() {
      return this.getValueMap("traits", Traits.class);
   }

   public static class Builder extends BasePayload.Builder<GroupPayload, GroupPayload.Builder> {
      private String groupId;
      private Map<String, Object> traits;

      public Builder() {
      }

      Builder(GroupPayload var1) {
         super(var1);
         this.groupId = var1.groupId();
         this.traits = var1.traits();
      }

      public GroupPayload.Builder groupId(String var1) {
         this.groupId = Utils.assertNotNullOrEmpty(var1, "groupId");
         return this;
      }

      protected GroupPayload realBuild(String var1, Date var2, Map<String, Object> var3, Map<String, Object> var4, String var5, String var6) {
         Utils.assertNotNullOrEmpty(this.groupId, "groupId");
         Map var8 = this.traits;
         Map var7 = var8;
         if (Utils.isNullOrEmpty(var8)) {
            var7 = Collections.emptyMap();
         }

         return new GroupPayload(var1, var2, var3, var4, var5, var6, this.groupId, var7);
      }

      GroupPayload.Builder self() {
         return this;
      }

      public GroupPayload.Builder traits(Map<String, ?> var1) {
         Utils.assertNotNull(var1, "traits");
         this.traits = Collections.unmodifiableMap(new LinkedHashMap<>(var1));
         return this;
      }
   }
}
