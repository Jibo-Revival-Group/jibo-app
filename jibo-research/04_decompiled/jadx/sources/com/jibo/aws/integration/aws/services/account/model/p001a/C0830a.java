package com.jibo.aws.integration.aws.services.account.model.p001a;

import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;
import com.google.gson.Gson;
import com.jibo.aws.integration.aws.services.account.model.Account;

/* JADX INFO: renamed from: com.jibo.aws.integration.aws.services.account.model.a.a */
/* JADX INFO: loaded from: classes.dex */
public class C0830a implements Unmarshaller<Account, JsonUnmarshallerContext> {
    @Override // com.amazonaws.transform.Unmarshaller
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Account unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) {
        return (Account) new Gson().m9353a(jsonUnmarshallerContext.getReader().getReader(), Account.class);
    }
}
