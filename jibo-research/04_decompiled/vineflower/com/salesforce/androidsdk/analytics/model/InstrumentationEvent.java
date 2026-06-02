package com.salesforce.androidsdk.analytics.model;

import android.text.TextUtils;
import com.salesforce.androidsdk.analytics.util.SalesforceAnalyticsLogger;
import org.json.JSONException;
import org.json.JSONObject;

public class InstrumentationEvent {
   private String a;
   private long b;
   private long c;
   private String d;
   private JSONObject e;
   private String f;
   private int g;
   private String h;
   private JSONObject i;
   private InstrumentationEvent.SchemaType j;
   private InstrumentationEvent.EventType k;
   private InstrumentationEvent.ErrorType l;
   private DeviceAppAttributes m;
   private String n;
   private String o;
   private long p;
   private JSONObject q;
   private JSONObject r;
   private JSONObject s;

   InstrumentationEvent(
      String var1,
      long var2,
      long var4,
      String var6,
      JSONObject var7,
      String var8,
      int var9,
      String var10,
      JSONObject var11,
      InstrumentationEvent.SchemaType var12,
      InstrumentationEvent.EventType var13,
      InstrumentationEvent.ErrorType var14,
      DeviceAppAttributes var15,
      String var16,
      String var17,
      long var18,
      JSONObject var20,
      JSONObject var21,
      JSONObject var22
   ) {
      this.a = var1;
      this.b = var2;
      this.c = var4;
      this.d = var6;
      this.e = var7;
      this.f = var8;
      this.g = var9;
      this.h = var10;
      this.i = var11;
      this.j = var12;
      this.k = var13;
      this.l = var14;
      this.m = var15;
      this.n = var16;
      this.o = var17;
      this.p = var18;
      this.q = var20;
      this.r = var21;
      this.s = var22;
   }

   public InstrumentationEvent(JSONObject var1) {
      if (var1 != null) {
         this.a = var1.optString("eventId");
         this.b = var1.optLong("startTime");
         this.c = var1.optLong("endTime");
         this.d = var1.optString("name");
         this.e = var1.optJSONObject("attributes");
         this.f = var1.optString("sessionId");
         this.g = var1.optInt("sequenceId");
         this.h = var1.optString("senderId");
         this.i = var1.optJSONObject("senderContext");
         String var2 = var1.optString("schemaType");
         if (!TextUtils.isEmpty(var2)) {
            this.j = InstrumentationEvent.SchemaType.valueOf(var2);
         }

         var2 = var1.optString("eventType");
         if (!TextUtils.isEmpty(var2)) {
            this.k = InstrumentationEvent.EventType.valueOf(var2);
         }

         var2 = var1.optString("errorType");
         if (!TextUtils.isEmpty(var2)) {
            this.l = InstrumentationEvent.ErrorType.valueOf(var2);
         }

         JSONObject var5 = var1.optJSONObject("deviceAppAttributes");
         if (var5 != null) {
            this.m = new DeviceAppAttributes(var5);
         }

         this.n = var1.optString("connectionType");
         this.o = var1.optString("senderParentId");
         this.p = var1.optLong("sessionStartTime");
         this.q = var1.optJSONObject("page");
         this.r = var1.optJSONObject("previousPage");
         this.s = var1.optJSONObject("marks");
      }
   }

   public String a() {
      return this.a;
   }

   public long b() {
      return this.b;
   }

   public long c() {
      return this.c;
   }

   public String d() {
      return this.d;
   }

   public JSONObject e() {
      return this.e;
   }

   @Override
   public boolean equals(Object var1) {
      boolean var3 = false;
      boolean var2 = var3;
      if (var1 != null) {
         if (!(var1 instanceof InstrumentationEvent)) {
            var2 = var3;
         } else {
            var1 = var1;
            var2 = var3;
            if (!TextUtils.isEmpty(this.a)) {
               var2 = var3;
               if (this.a.equals(var1.a())) {
                  var2 = true;
               }
            }
         }
      }

      return var2;
   }

   public String f() {
      return this.f;
   }

   public int g() {
      return this.g;
   }

   public String h() {
      return this.h;
   }

   @Override
   public int hashCode() {
      return this.a.hashCode();
   }

   public JSONObject i() {
      return this.i;
   }

   public InstrumentationEvent.SchemaType j() {
      return this.j;
   }

   public InstrumentationEvent.EventType k() {
      return this.k;
   }

   public InstrumentationEvent.ErrorType l() {
      return this.l;
   }

   public DeviceAppAttributes m() {
      return this.m;
   }

   public String n() {
      return this.n;
   }

   public String o() {
      return this.o;
   }

   public long p() {
      return this.p;
   }

   public JSONObject q() {
      return this.q;
   }

   public JSONObject r() {
      return this.r;
   }

   public JSONObject s() {
      return this.s;
   }

   public JSONObject t() {
      JSONObject var1 = new JSONObject();

      try {
         var1.put("eventId", this.a);
         var1.put("startTime", this.b);
         var1.put("endTime", this.c);
         var1.put("name", this.d);
         if (this.e != null) {
            var1.put("attributes", this.e);
         }

         if (this.f != null) {
            var1.put("sessionId", this.f);
         }

         var1.put("sequenceId", this.g);
         var1.put("senderId", this.h);
         if (this.i != null) {
            var1.put("senderContext", this.i);
         }

         if (this.j != null) {
            var1.put("schemaType", this.j.name());
         }

         if (this.k != null) {
            var1.put("eventType", this.k.name());
         }

         if (this.l != null) {
            var1.put("errorType", this.l.name());
         }

         var1.put("deviceAppAttributes", this.m.a());
         var1.put("connectionType", this.n);
         var1.put("senderParentId", this.o);
         var1.put("sessionStartTime", this.p);
         if (this.q != null) {
            var1.put("page", this.q);
         }

         if (this.r != null) {
            var1.put("previousPage", this.r);
         }

         if (this.s != null) {
            var1.put("marks", this.s);
         }
      } catch (JSONException var3) {
         SalesforceAnalyticsLogger.a(null, "InstrumentationEvent", "Exception thrown while attempting to convert to JSON", var3);
      }

      return var1;
   }

   public enum ErrorType {
      error,
      info,
      warn;

      private static final InstrumentationEvent.ErrorType[] $VALUES = new InstrumentationEvent.ErrorType[]{
         InstrumentationEvent.ErrorType.info, InstrumentationEvent.ErrorType.warn, InstrumentationEvent.ErrorType.error
      };
   }

   public enum EventType {
      crud,
      error,
      system,
      user;

      private static final InstrumentationEvent.EventType[] $VALUES = new InstrumentationEvent.EventType[]{
         InstrumentationEvent.EventType.user, InstrumentationEvent.EventType.system, InstrumentationEvent.EventType.error, InstrumentationEvent.EventType.crud
      };
   }

   public enum SchemaType {
      LightningError,
      LightningInteraction,
      LightningPageView,
      LightningPerformance;

      private static final InstrumentationEvent.SchemaType[] $VALUES = new InstrumentationEvent.SchemaType[]{
         InstrumentationEvent.SchemaType.LightningInteraction,
         InstrumentationEvent.SchemaType.LightningPageView,
         InstrumentationEvent.SchemaType.LightningPerformance,
         InstrumentationEvent.SchemaType.LightningError
      };
   }
}
