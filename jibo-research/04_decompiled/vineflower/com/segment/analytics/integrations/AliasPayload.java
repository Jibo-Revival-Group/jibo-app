package com.segment.analytics.integrations;

import com.segment.analytics.internal.Utils;
import java.util.Date;
import java.util.Map;

public class AliasPayload extends BasePayload {
   static final String PREVIOUS_ID_KEY = "previousId";

   AliasPayload(String var1, Date var2, Map<String, Object> var3, Map<String, Object> var4, String var5, String var6, String var7) {
      super(BasePayload.Type.alias, var1, var2, var3, var4, var5, var6);
      this.put("previousId", var7);
   }

   public String previousId() {
      return this.getString("previousId");
   }

   public AliasPayload.Builder toBuilder() {
      return new AliasPayload.Builder(this);
   }

   @Override
   public String toString() {
      return "AliasPayload{userId=\"" + this.userId() + ",previousId=\"" + this.previousId() + "\"}";
   }

   public static final class Builder extends BasePayload.Builder<AliasPayload, AliasPayload.Builder> {
      private String previousId;

      public Builder() {
      }

      Builder(AliasPayload var1) {
         super(var1);
         this.previousId = var1.previousId();
      }

      public AliasPayload.Builder previousId(String var1) {
         this.previousId = Utils.assertNotNullOrEmpty(var1, "previousId");
         return this;
      }

      protected AliasPayload realBuild(String var1, Date var2, Map<String, Object> var3, Map<String, Object> var4, String var5, String var6) {
         Utils.assertNotNullOrEmpty(var5, "userId");
         Utils.assertNotNullOrEmpty(this.previousId, "previousId");
         return new AliasPayload(var1, var2, var3, var4, var5, var6, this.previousId);
      }

      AliasPayload.Builder self() {
         return this;
      }
   }
}
