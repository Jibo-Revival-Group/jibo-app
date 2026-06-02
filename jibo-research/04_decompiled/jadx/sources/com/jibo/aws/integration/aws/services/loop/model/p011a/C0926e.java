package com.jibo.aws.integration.aws.services.loop.model.p011a;

import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;
import com.google.gson.Gson;
import com.jibo.aws.integration.aws.services.loop.model.RobotAccount;

/* JADX INFO: renamed from: com.jibo.aws.integration.aws.services.loop.model.a.e */
/* JADX INFO: loaded from: classes.dex */
public class C0926e implements Unmarshaller<RobotAccount, JsonUnmarshallerContext> {
    @Override // com.amazonaws.transform.Unmarshaller
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public RobotAccount unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) {
        return (RobotAccount) new Gson().m9353a(jsonUnmarshallerContext.getReader().getReader(), RobotAccount.class);
    }
}
