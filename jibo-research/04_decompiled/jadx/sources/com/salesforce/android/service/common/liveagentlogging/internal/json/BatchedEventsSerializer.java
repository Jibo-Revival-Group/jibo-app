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

/* JADX INFO: loaded from: classes.dex */
public class BatchedEventsSerializer implements JsonSerializer<BatchedEvents> {

    /* JADX INFO: renamed from: a */
    private static final ServiceLogger f13637a = ServiceLogging.m14203a((Class<?>) BatchedEventsSerializer.class);

    @Override // com.google.gson.JsonSerializer
    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public JsonElement mo9422a(BatchedEvents batchedEvents, Type type, JsonSerializationContext jsonSerializationContext) {
        JsonObject jsonObject = new JsonObject();
        for (BaseEvent baseEvent : batchedEvents.m13922a()) {
            String strM13921a = m13921a(baseEvent);
            if (strM13921a == null) {
                f13637a.mo14193d("Ignoring unknown batched event {}", baseEvent);
            } else {
                if (!jsonObject.m9406b(strM13921a)) {
                    jsonObject.m9402a(strM13921a, new JsonArray());
                }
                jsonObject.m9407c(strM13921a).m9396m().m9383a(jsonSerializationContext.mo9421a(baseEvent, BaseEvent.class));
            }
        }
        return jsonObject;
    }

    /* JADX INFO: renamed from: a */
    private String m13921a(Object obj) {
        Class<?> cls = obj.getClass();
        if (cls.isAnnotationPresent(BatchedEvent.class)) {
            return ((BatchedEvent) cls.getAnnotation(BatchedEvent.class)).m13878a();
        }
        return null;
    }
}
