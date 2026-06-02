package com.crashlytics.android.answers;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import io.fabric.sdk.android.services.events.EventTransform;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

class SessionEventTransform implements EventTransform<SessionEvent> {
   public byte[] a(SessionEvent var1) throws IOException {
      return this.b(var1).toString().getBytes("UTF-8");
   }

   @TargetApi(9)
   public JSONObject b(SessionEvent var1) throws IOException {
      try {
         JSONObject var2 = new JSONObject();
         SessionEventMetadata var3 = var1.a;
         var2.put("appBundleId", var3.a);
         var2.put("executionId", var3.b);
         var2.put("installationId", var3.c);
         var2.put("androidId", var3.d);
         var2.put("advertisingId", var3.e);
         var2.put("limitAdTrackingEnabled", var3.f);
         var2.put("betaDeviceToken", var3.g);
         var2.put("buildId", var3.h);
         var2.put("osVersion", var3.i);
         var2.put("deviceModel", var3.j);
         var2.put("appVersionCode", var3.k);
         var2.put("appVersionName", var3.l);
         var2.put("timestamp", var1.b);
         var2.put("type", var1.c.toString());
         if (var1.d != null) {
            JSONObject var5 = new JSONObject(var1.d);
            var2.put("details", var5);
         }

         var2.put("customType", var1.e);
         if (var1.f != null) {
            JSONObject var6 = new JSONObject(var1.f);
            var2.put("customAttributes", var6);
         }

         var2.put("predefinedType", var1.g);
         if (var1.h != null) {
            JSONObject var7 = new JSONObject(var1.h);
            var2.put("predefinedAttributes", var7);
         }

         return var2;
      } catch (JSONException var4) {
         if (VERSION.SDK_INT >= 9) {
            throw new IOException(var4.getMessage(), var4);
         } else {
            throw new IOException(var4.getMessage());
         }
      }
   }
}
