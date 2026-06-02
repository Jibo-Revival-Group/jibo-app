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

/* JADX INFO: loaded from: classes.dex */
public class BaseEventSerializer implements JsonSerializer<BaseEvent> {

    /* JADX INFO: renamed from: a */
    private static final ServiceLogger f13636a = ServiceLogging.m14203a((Class<?>) BaseEventSerializer.class);

    @Override // com.google.gson.JsonSerializer
    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public JsonElement mo9422a(BaseEvent baseEvent, Type type, JsonSerializationContext jsonSerializationContext) {
        Date dateM13892a = baseEvent.m13892a();
        JsonObject jsonObject = new JsonObject();
        jsonObject.m9405a("service", baseEvent.m13894b());
        jsonObject.m9405a("clientType", "android");
        jsonObject.m9405a("organizationId", baseEvent.m13896d());
        jsonObject.m9405a("correlationId", baseEvent.m13895c());
        jsonObject.m9402a("clientTimestamp", jsonSerializationContext.mo9420a(dateM13892a));
        f13636a.mo14189b("Serializing BaseEvent {} with correlation ID {}", baseEvent.getClass().getSimpleName(), baseEvent.m13895c());
        JsonElement jsonElementMo9420a = jsonSerializationContext.mo9420a(baseEvent);
        jsonElementMo9420a.m9395l().m9402a("basicInfo", jsonObject);
        return jsonElementMo9420a;
    }
}
