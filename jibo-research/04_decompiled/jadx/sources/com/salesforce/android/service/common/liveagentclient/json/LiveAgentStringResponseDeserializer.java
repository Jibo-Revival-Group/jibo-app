package com.salesforce.android.service.common.liveagentclient.json;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.salesforce.android.service.common.liveagentclient.response.LiveAgentStringResponse;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes.dex */
public class LiveAgentStringResponseDeserializer implements JsonDeserializer<LiveAgentStringResponse> {
    @Override // com.google.gson.JsonDeserializer
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public LiveAgentStringResponse deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        return new LiveAgentStringResponse(jsonElement.mo9385c());
    }
}
