package com.salesforce.android.service.common.liveagentclient.json;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.salesforce.android.service.common.liveagentclient.LiveAgentMessageRegistry;
import com.salesforce.android.service.common.liveagentclient.response.message.LiveAgentMessage;
import com.salesforce.android.service.common.liveagentclient.response.message.UnregisteredMessage;
import com.salesforce.android.service.common.utilities.logging.ServiceLogger;
import com.salesforce.android.service.common.utilities.logging.ServiceLogging;
import java.lang.reflect.Type;

class LiveAgentMessageDeserializer implements JsonDeserializer<LiveAgentMessage> {
   private static final ServiceLogger a = ServiceLogging.a(LiveAgentMessageDeserializer.class);
   private final LiveAgentMessageRegistry b;

   public LiveAgentMessageDeserializer(LiveAgentMessageRegistry var1) {
      this.b = var1;
   }

   public LiveAgentMessage a(JsonElement var1, Type var2, JsonDeserializationContext var3) throws JsonParseException {
      LiveAgentMessage var5;
      if (var1 == null) {
         a.d("Unable to deserialize LiveAgentMessage - Element is null");
         var5 = null;
      } else {
         JsonObject var7 = var1.l();
         String var6 = var7.c("type").c();
         JsonElement var8 = var7.c("message");
         Class var4 = this.b.a(var6);
         if (var4 == null) {
            a.e("Unregistered LiveAgent Message encountered. Type[{}] - Content[{}] ", var6, var8);
            var5 = new UnregisteredMessage(var6, var8);
         } else {
            a.a("De-serializing LiveAgentMessage - Type[{}] - Class[{}] - Content[{}]", var6, var4.getSimpleName(), var8);
            var5 = new LiveAgentMessage(var6, var3.a(var8, var4));
         }
      }

      return var5;
   }
}
