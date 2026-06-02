package com.jibo.aws.integration.aws.services.loop.model.p011a;

import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;
import com.google.gson.Gson;
import com.jibo.aws.integration.aws.services.loop.model.Loop;

/* JADX INFO: renamed from: com.jibo.aws.integration.aws.services.loop.model.a.b */
/* JADX INFO: loaded from: classes.dex */
public class C0923b implements Unmarshaller<Loop, JsonUnmarshallerContext> {
    @Override // com.amazonaws.transform.Unmarshaller
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Loop unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) {
        return (Loop) new Gson().m9353a(jsonUnmarshallerContext.getReader().getReader(), Loop.class);
    }
}
