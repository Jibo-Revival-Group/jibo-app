package com.salesforce.android.service.common.liveagentclient.json;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
class CollectionSerializer implements JsonSerializer<Collection<?>> {
    CollectionSerializer() {
    }

    @Override // com.google.gson.JsonSerializer
    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public JsonElement mo9422a(Collection<?> collection, Type type, JsonSerializationContext jsonSerializationContext) {
        if (collection == null || collection.isEmpty()) {
            return null;
        }
        JsonArray jsonArray = new JsonArray();
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            jsonArray.m9383a(jsonSerializationContext.mo9420a(it.next()));
        }
        return jsonArray;
    }
}
