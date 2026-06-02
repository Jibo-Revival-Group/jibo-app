package com.salesforce.android.service.common.liveagentclient.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.salesforce.android.service.common.liveagentclient.LiveAgentMessageRegistry;
import com.salesforce.android.service.common.liveagentclient.response.LiveAgentStringResponse;
import com.salesforce.android.service.common.liveagentclient.response.message.LiveAgentMessage;
import java.util.Collection;

public class GsonFactory {
   public static Gson a(GsonBuilder var0, LiveAgentMessageRegistry var1, boolean var2) {
      if (var2) {
         var0.a(Collection.class, new CollectionSerializer());
      }

      return var0.a(LiveAgentStringResponse.class, new LiveAgentStringResponseDeserializer())
         .a(LiveAgentMessage.class, new LiveAgentMessageDeserializer(var1))
         .a();
   }
}
