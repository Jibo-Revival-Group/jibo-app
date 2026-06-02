package com.jibo.aws.integration.aws.services.oobe.model.p014a;

import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;
import com.google.gson.Gson;
import com.jibo.aws.integration.aws.services.oobe.model.TokenContainer;

/* JADX INFO: renamed from: com.jibo.aws.integration.aws.services.oobe.model.a.c */
/* JADX INFO: loaded from: classes.dex */
public class C0946c implements Unmarshaller<TokenContainer, JsonUnmarshallerContext> {
    @Override // com.amazonaws.transform.Unmarshaller
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public TokenContainer unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) {
        return (TokenContainer) new Gson().m9353a(jsonUnmarshallerContext.getReader().getReader(), TokenContainer.class);
    }
}
