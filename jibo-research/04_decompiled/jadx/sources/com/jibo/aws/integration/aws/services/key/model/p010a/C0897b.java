package com.jibo.aws.integration.aws.services.key.model.p010a;

import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;
import com.google.gson.Gson;
import com.jibo.aws.integration.aws.services.key.model.Request;

/* JADX INFO: renamed from: com.jibo.aws.integration.aws.services.key.model.a.b */
/* JADX INFO: loaded from: classes.dex */
public class C0897b implements Unmarshaller<Request, JsonUnmarshallerContext> {
    @Override // com.amazonaws.transform.Unmarshaller
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Request unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) {
        return (Request) new Gson().m9353a(jsonUnmarshallerContext.getReader().getReader(), Request.class);
    }
}
