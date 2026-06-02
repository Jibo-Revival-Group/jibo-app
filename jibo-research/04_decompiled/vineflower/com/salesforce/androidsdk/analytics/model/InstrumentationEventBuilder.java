package com.salesforce.androidsdk.analytics.model;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import com.salesforce.androidsdk.analytics.manager.AnalyticsManager;
import java.util.UUID;
import org.json.JSONObject;

public class InstrumentationEventBuilder {
   private AnalyticsManager a;
   private Context b;
   private long c;
   private long d;
   private String e;
   private JSONObject f;
   private String g;
   private String h;
   private JSONObject i;
   private InstrumentationEvent.SchemaType j;
   private InstrumentationEvent.EventType k;
   private InstrumentationEvent.ErrorType l;
   private String m;
   private long n;
   private JSONObject o;
   private JSONObject p;
   private JSONObject q;

   private InstrumentationEventBuilder(AnalyticsManager var1, Context var2) {
      this.a = var1;
      this.b = var2;
   }

   public static final InstrumentationEventBuilder a(AnalyticsManager var0, Context var1) {
      return new InstrumentationEventBuilder(var0, var1);
   }

   private String b() {
      StringBuilder var1 = new StringBuilder();
      ConnectivityManager var2 = (ConnectivityManager)this.b.getSystemService("connectivity");
      if (var2 != null) {
         NetworkInfo var3 = var2.getActiveNetworkInfo();
         if (var3 != null) {
            String var4 = var3.getTypeName();
            String var5 = var3.getSubtypeName();
            if (!TextUtils.isEmpty(var4)) {
               var1.append(var4);
               var1.append(";");
            }

            if (!TextUtils.isEmpty(var5)) {
               var1.append(var5);
            }
         }
      }

      return var1.toString();
   }

   public InstrumentationEvent a() throws InstrumentationEventBuilder.EventBuilderException {
      String var8 = UUID.randomUUID().toString();
      String var7 = null;
      if (this.j == null) {
         var7 = "Mandatory field 'schema type' not set!";
      }

      if (TextUtils.isEmpty(this.e)) {
         var7 = "Mandatory field 'name' not set!";
      }

      DeviceAppAttributes var9 = this.a.c();
      if (var9 == null) {
         var7 = "Mandatory field 'device app attributes' not set!";
      }

      String var6;
      label40: {
         if (this.j != InstrumentationEvent.SchemaType.LightningInteraction) {
            var6 = var7;
            if (this.j != InstrumentationEvent.SchemaType.LightningPerformance) {
               break label40;
            }
         }

         var6 = var7;
         if (this.k == null) {
            var6 = "Mandatory field 'event type' not set!";
         }
      }

      var7 = var6;
      if (this.j != InstrumentationEvent.SchemaType.LightningPerformance) {
         var7 = var6;
         if (this.o == null) {
            var7 = "Mandatory field 'page' not set!";
         }
      }

      if (var7 != null) {
         throw new InstrumentationEventBuilder.EventBuilderException(var7);
      }

      int var1 = this.a.b() + 1;
      this.a.a(var1);
      long var2 = System.currentTimeMillis();
      long var4;
      if (this.c == 0L) {
         var4 = var2;
      } else {
         var4 = this.c;
      }

      this.c = var4;
      if (this.n != 0L) {
         var2 = this.n;
      }

      this.n = var2;
      return new InstrumentationEvent(
         var8, this.c, this.d, this.e, this.f, this.g, var1, this.h, this.i, this.j, this.k, this.l, var9, this.b(), this.m, this.n, this.o, this.p, this.q
      );
   }

   public InstrumentationEventBuilder a(long var1) {
      this.c = var1;
      return this;
   }

   public InstrumentationEventBuilder a(InstrumentationEvent.EventType var1) {
      this.k = var1;
      return this;
   }

   public InstrumentationEventBuilder a(InstrumentationEvent.SchemaType var1) {
      this.j = var1;
      return this;
   }

   public InstrumentationEventBuilder a(String var1) {
      this.e = var1;
      return this;
   }

   public InstrumentationEventBuilder a(JSONObject var1) {
      this.f = var1;
      return this;
   }

   public InstrumentationEventBuilder b(long var1) {
      this.d = var1;
      return this;
   }

   public InstrumentationEventBuilder b(JSONObject var1) {
      this.o = var1;
      return this;
   }

   public static class EventBuilderException extends Exception {
      public EventBuilderException(String var1) {
         super(var1);
      }
   }
}
