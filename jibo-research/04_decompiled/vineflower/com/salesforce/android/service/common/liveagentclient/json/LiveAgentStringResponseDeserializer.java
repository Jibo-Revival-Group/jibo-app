package com.salesforce.android.service.common.liveagentclient.json;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.salesforce.android.service.common.liveagentclient.response.LiveAgentStringResponse;
import java.lang.reflect.Type;

public class LiveAgentStringResponseDeserializer implements JsonDeserializer<LiveAgentStringResponse> {
   public LiveAgentStringResponse a(JsonElement var1, Type var2, JsonDeserializationContext var3) throws JsonParseException {
      return new LiveAgentStringResponse(var1.c());
   }
}
