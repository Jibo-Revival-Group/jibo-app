package com.salesforce.android.service.common.liveagentlogging.internal.json;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.salesforce.android.service.common.liveagentlogging.event.BaseEvent;
import com.salesforce.android.service.common.utilities.logging.ServiceLogger;
import com.salesforce.android.service.common.utilities.logging.ServiceLogging;
import java.lang.reflect.Type;
import java.util.Date;

public class BaseEventSerializer implements JsonSerializer<BaseEvent> {
   private static final ServiceLogger a = ServiceLogging.a(BaseEventSerializer.class);

   public JsonElement a(BaseEvent var1, Type var2, JsonSerializationContext var3) {
      Date var4 = var1.a();
      JsonObject var6 = new JsonObject();
      var6.a("service", var1.b());
      var6.a("clientType", "android");
      var6.a("organizationId", var1.d());
      var6.a("correlationId", var1.c());
      var6.a("clientTimestamp", var3.a(var4));
      a.b("Serializing BaseEvent {} with correlation ID {}", var1.getClass().getSimpleName(), var1.c());
      JsonElement var5 = var3.a(var1);
      var5.l().a("basicInfo", var6);
      return var5;
   }
}
