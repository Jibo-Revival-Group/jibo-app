package com.jibo.aws.integration.aws.services.loop.model.p011a;

import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jibo.aws.integration.aws.services.loop.model.Loop;
import java.util.List;

/* JADX INFO: renamed from: com.jibo.aws.integration.aws.services.loop.model.a.c */
/* JADX INFO: loaded from: classes.dex */
public class C0924c implements Unmarshaller<List<Loop>, JsonUnmarshallerContext> {
    @Override // com.amazonaws.transform.Unmarshaller
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public List<Loop> unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) {
        return (List) new Gson().m9354a(jsonUnmarshallerContext.getReader().getReader(), new TypeToken<List<Loop>>() { // from class: com.jibo.aws.integration.aws.services.loop.model.a.c.1
        }.getType());
    }
}
