package com.jibo.aws.integration.aws.services.binary.model.p003a;

import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;
import com.google.gson.Gson;
import com.jibo.aws.integration.aws.services.binary.model.BinaryLink;

/* JADX INFO: renamed from: com.jibo.aws.integration.aws.services.binary.model.a.a */
/* JADX INFO: loaded from: classes.dex */
public class C0844a implements Unmarshaller<BinaryLink, JsonUnmarshallerContext> {
    @Override // com.amazonaws.transform.Unmarshaller
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public BinaryLink unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) {
        return (BinaryLink) new Gson().m9353a(jsonUnmarshallerContext.getReader().getReader(), BinaryLink.class);
    }
}
