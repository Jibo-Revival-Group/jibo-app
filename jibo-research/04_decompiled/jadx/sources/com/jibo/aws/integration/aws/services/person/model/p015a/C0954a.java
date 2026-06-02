package com.jibo.aws.integration.aws.services.person.model.p015a;

import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import java.util.HashMap;

/* JADX INFO: renamed from: com.jibo.aws.integration.aws.services.person.model.a.a */
/* JADX INFO: loaded from: classes.dex */
public class C0954a implements Unmarshaller<HashMap<String, JsonObject>, JsonUnmarshallerContext> {
    @Override // com.amazonaws.transform.Unmarshaller
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public HashMap<String, JsonObject> unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) {
        return (HashMap) new Gson().m9354a(jsonUnmarshallerContext.getReader().getReader(), new TypeToken<HashMap<String, JsonObject>>() { // from class: com.jibo.aws.integration.aws.services.person.model.a.a.1
        }.getType());
    }
}
