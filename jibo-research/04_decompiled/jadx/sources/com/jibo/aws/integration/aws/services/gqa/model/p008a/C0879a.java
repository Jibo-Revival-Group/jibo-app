package com.jibo.aws.integration.aws.services.gqa.model.p008a;

import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;
import com.google.gson.Gson;
import com.jibo.aws.integration.aws.services.gqa.model.GQAAttribution;

/* JADX INFO: renamed from: com.jibo.aws.integration.aws.services.gqa.model.a.a */
/* JADX INFO: loaded from: classes.dex */
public class C0879a implements Unmarshaller<GQAAttribution, JsonUnmarshallerContext> {
    @Override // com.amazonaws.transform.Unmarshaller
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public GQAAttribution unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) {
        return (GQAAttribution) new Gson().m9353a(jsonUnmarshallerContext.getReader().getReader(), GQAAttribution.class);
    }
}
