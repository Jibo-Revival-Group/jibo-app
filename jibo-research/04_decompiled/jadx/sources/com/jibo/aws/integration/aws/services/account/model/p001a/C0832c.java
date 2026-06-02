package com.jibo.aws.integration.aws.services.account.model.p001a;

import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;
import com.google.gson.Gson;
import com.jibo.aws.integration.aws.services.account.model.FacebookPrepareLogin;

/* JADX INFO: renamed from: com.jibo.aws.integration.aws.services.account.model.a.c */
/* JADX INFO: loaded from: classes.dex */
public class C0832c implements Unmarshaller<FacebookPrepareLogin, JsonUnmarshallerContext> {
    @Override // com.amazonaws.transform.Unmarshaller
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public FacebookPrepareLogin unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) {
        return (FacebookPrepareLogin) new Gson().m9353a(jsonUnmarshallerContext.getReader().getReader(), FacebookPrepareLogin.class);
    }
}
