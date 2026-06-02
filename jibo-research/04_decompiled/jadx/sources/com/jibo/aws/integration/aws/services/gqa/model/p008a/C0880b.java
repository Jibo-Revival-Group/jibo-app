package com.jibo.aws.integration.aws.services.gqa.model.p008a;

import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;
import com.google.gson.Gson;
import com.jibo.aws.integration.aws.services.gqa.model.AttributionListResponse;

/* JADX INFO: renamed from: com.jibo.aws.integration.aws.services.gqa.model.a.b */
/* JADX INFO: loaded from: classes.dex */
public class C0880b implements Unmarshaller<AttributionListResponse, JsonUnmarshallerContext> {
    @Override // com.amazonaws.transform.Unmarshaller
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public AttributionListResponse unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) {
        return (AttributionListResponse) new Gson().m9353a(jsonUnmarshallerContext.getReader().getReader(), AttributionListResponse.class);
    }
}
