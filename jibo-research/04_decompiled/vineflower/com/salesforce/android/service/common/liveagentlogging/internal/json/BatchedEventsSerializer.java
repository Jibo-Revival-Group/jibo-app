package com.salesforce.android.service.common.liveagentlogging.internal.json;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.salesforce.android.service.common.liveagentlogging.BatchedEvent;
import com.salesforce.android.service.common.liveagentlogging.event.BaseEvent;
import com.salesforce.android.service.common.liveagentlogging.internal.request.BatchedEvents;
import com.salesforce.android.service.common.utilities.logging.ServiceLogger;
import com.salesforce.android.service.common.utilities.logging.ServiceLogging;
import java.lang.reflect.Type;

public class BatchedEventsSerializer implements JsonSerializer<BatchedEvents> {
   private static final ServiceLogger a = ServiceLogging.a(BatchedEventsSerializer.class);

   private String a(Object var1) {
      var1 = var1.getClass();
      String var3;
      if (var1.isAnnotationPresent(BatchedEvent.class)) {
         var3 = var1.getAnnotation(BatchedEvent.class).a();
      } else {
         var3 = null;
      }

      return var3;
   }

   public JsonElement a(BatchedEvents var1, Type var2, JsonSerializationContext var3) {
      JsonObject var7 = new JsonObject();

      for (BaseEvent var5 : var1.a()) {
         String var4 = this.a(var5);
         if (var4 == null) {
            a.d("Ignoring unknown batched event {}", var5);
         } else {
            if (!var7.b(var4)) {
               var7.a(var4, new JsonArray());
            }

            JsonElement var8 = var3.a(var5, BaseEvent.class);
            var7.c(var4).m().a(var8);
         }
      }

      return var7;
   }
}
