package com.jibo.aws.integration.aws.services.account.model.p001a;

import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jibo.aws.integration.aws.services.account.model.Account;
import java.util.List;

/* JADX INFO: renamed from: com.jibo.aws.integration.aws.services.account.model.a.b */
/* JADX INFO: loaded from: classes.dex */
public class C0831b implements Unmarshaller<List<Account>, JsonUnmarshallerContext> {
    @Override // com.amazonaws.transform.Unmarshaller
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public List<Account> unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) {
        return (List) new Gson().m9354a(jsonUnmarshallerContext.getReader().getReader(), new TypeToken<List<Account>>() { // from class: com.jibo.aws.integration.aws.services.account.model.a.b.1
        }.getType());
    }
}
