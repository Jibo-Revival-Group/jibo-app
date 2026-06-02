package com.segment.analytics.integrations;

import com.segment.analytics.AnalyticsContext;
import com.segment.analytics.ValueMap;
import com.segment.analytics.internal.Utils;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;

public abstract class BasePayload extends ValueMap {
   static final String ANONYMOUS_ID_KEY = "anonymousId";
   static final String CHANNEL_KEY = "channel";
   static final String CONTEXT_KEY = "context";
   static final String INTEGRATIONS_KEY = "integrations";
   static final String MESSAGE_ID = "messageId";
   static final String TIMESTAMP_KEY = "timestamp";
   static final String TYPE_KEY = "type";
   static final String USER_ID_KEY = "userId";

   BasePayload(BasePayload.Type var1, String var2, Date var3, Map<String, Object> var4, Map<String, Object> var5, String var6, String var7) {
      this.put("channel", BasePayload.Channel.mobile);
      this.put("type", var1);
      this.put("messageId", var2);
      this.put("timestamp", Utils.toISO8601String(var3));
      this.put("context", var4);
      this.put("integrations", var5);
      if (!Utils.isNullOrEmpty(var6)) {
         this.put("userId", var6);
      }

      this.put("anonymousId", var7);
   }

   public String anonymousId() {
      return this.getString("anonymousId");
   }

   public AnalyticsContext context() {
      return this.getValueMap("context", AnalyticsContext.class);
   }

   public ValueMap integrations() {
      return this.getValueMap("integrations");
   }

   public String messageId() {
      return this.getString("messageId");
   }

   public BasePayload putValue(String var1, Object var2) {
      super.putValue(var1, var2);
      return this;
   }

   public Date timestamp() {
      String var1 = this.getString("timestamp");
      Date var2;
      if (Utils.isNullOrEmpty(var1)) {
         var2 = null;
      } else {
         var2 = Utils.parseISO8601Date(var1);
      }

      return var2;
   }

   public abstract BasePayload.Builder toBuilder();

   public BasePayload.Type type() {
      return this.getEnum(BasePayload.Type.class, "type");
   }

   public String userId() {
      return this.getString("userId");
   }

   public abstract static class Builder<P extends BasePayload, B extends BasePayload.Builder> {
      private String anonymousId;
      private Map<String, Object> context;
      private Map<String, Object> integrationsBuilder;
      private String messageId;
      private Date timestamp;
      private String userId;

      Builder() {
      }

      Builder(BasePayload var1) {
         this.messageId = var1.messageId();
         this.timestamp = var1.timestamp();
         this.context = var1.context();
         this.integrationsBuilder = new LinkedHashMap<>(var1.integrations());
         this.userId = var1.userId();
         this.anonymousId = var1.anonymousId();
      }

      public B anonymousId(String var1) {
         this.anonymousId = Utils.assertNotNullOrEmpty(var1, "anonymousId");
         return this.self();
      }

      public P build() {
         if (Utils.isNullOrEmpty(this.userId) && Utils.isNullOrEmpty(this.anonymousId)) {
            throw new NullPointerException("either userId or anonymousId is required");
         }

         Map var1;
         if (Utils.isNullOrEmpty(this.integrationsBuilder)) {
            var1 = Collections.emptyMap();
         } else {
            var1 = Utils.immutableCopyOf(this.integrationsBuilder);
         }

         if (Utils.isNullOrEmpty(this.messageId)) {
            this.messageId = UUID.randomUUID().toString();
         }

         if (this.timestamp == null) {
            this.timestamp = new Date();
         }

         if (Utils.isNullOrEmpty(this.context)) {
            this.context = Collections.emptyMap();
         }

         return this.realBuild(this.messageId, this.timestamp, this.context, var1, this.userId, this.anonymousId);
      }

      public B context(Map<String, ?> var1) {
         Utils.assertNotNull(var1, "context");
         this.context = Collections.unmodifiableMap(new LinkedHashMap<>(var1));
         return this.self();
      }

      public B integration(String var1, Map<String, Object> var2) {
         Utils.assertNotNullOrEmpty(var1, "key");
         Utils.assertNotNullOrEmpty(var2, "options");
         if (this.integrationsBuilder == null) {
            this.integrationsBuilder = new LinkedHashMap<>();
         }

         this.integrationsBuilder.put(var1, Utils.immutableCopyOf(var2));
         return this.self();
      }

      public B integration(String var1, boolean var2) {
         Utils.assertNotNullOrEmpty(var1, "key");
         if (this.integrationsBuilder == null) {
            this.integrationsBuilder = new LinkedHashMap<>();
         }

         this.integrationsBuilder.put(var1, var2);
         return this.self();
      }

      public B integrations(Map<String, ?> var1) {
         BasePayload.Builder var2;
         if (Utils.isNullOrEmpty(var1)) {
            var2 = this.self();
         } else {
            if (this.integrationsBuilder == null) {
               this.integrationsBuilder = new LinkedHashMap<>();
            }

            this.integrationsBuilder.putAll(var1);
            var2 = this.self();
         }

         return (B)var2;
      }

      public B messageId(String var1) {
         Utils.assertNotNullOrEmpty(var1, "messageId");
         this.messageId = var1;
         return this.self();
      }

      abstract P realBuild(String var1, Date var2, Map<String, Object> var3, Map<String, Object> var4, String var5, String var6);

      abstract B self();

      public B timestamp(Date var1) {
         Utils.assertNotNull(var1, "timestamp");
         this.timestamp = var1;
         return this.self();
      }

      public B userId(String var1) {
         this.userId = Utils.assertNotNullOrEmpty(var1, "userId");
         return this.self();
      }
   }

   public enum Channel {
      browser,
      mobile,
      server;

      private static final BasePayload.Channel[] $VALUES = new BasePayload.Channel[]{
         BasePayload.Channel.browser, BasePayload.Channel.mobile, BasePayload.Channel.server
      };
   }

   public enum Type {
      alias,
      group,
      identify,
      screen,
      track;

      private static final BasePayload.Type[] $VALUES = new BasePayload.Type[]{
         BasePayload.Type.alias, BasePayload.Type.group, BasePayload.Type.identify, BasePayload.Type.screen, BasePayload.Type.track
      };
   }
}
