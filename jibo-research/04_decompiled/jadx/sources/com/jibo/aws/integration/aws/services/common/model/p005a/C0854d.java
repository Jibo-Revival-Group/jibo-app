package com.jibo.aws.integration.aws.services.common.model.p005a;

import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;
import com.google.gson.Gson;
import com.jibo.aws.integration.aws.services.common.model.IdResponse;

/* JADX INFO: renamed from: com.jibo.aws.integration.aws.services.common.model.a.d */
/* JADX INFO: loaded from: classes.dex */
public class C0854d implements Unmarshaller<IdResponse, JsonUnmarshallerContext> {
    @Override // com.amazonaws.transform.Unmarshaller
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public IdResponse unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) {
        return (IdResponse) new Gson().m9353a(jsonUnmarshallerContext.getReader().getReader(), IdResponse.class);
    }
}
