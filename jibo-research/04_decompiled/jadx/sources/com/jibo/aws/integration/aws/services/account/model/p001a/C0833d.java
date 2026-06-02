package com.jibo.aws.integration.aws.services.account.model.p001a;

import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;
import com.google.gson.Gson;
import com.jibo.aws.integration.aws.services.account.model.TokenContainer;

/* JADX INFO: renamed from: com.jibo.aws.integration.aws.services.account.model.a.d */
/* JADX INFO: loaded from: classes.dex */
public class C0833d implements Unmarshaller<TokenContainer, JsonUnmarshallerContext> {
    @Override // com.amazonaws.transform.Unmarshaller
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public TokenContainer unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) {
        return (TokenContainer) new Gson().m9353a(jsonUnmarshallerContext.getReader().getReader(), TokenContainer.class);
    }
}
