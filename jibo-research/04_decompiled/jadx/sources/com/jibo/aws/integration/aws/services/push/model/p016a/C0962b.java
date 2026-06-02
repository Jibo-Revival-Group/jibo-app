package com.jibo.aws.integration.aws.services.push.model.p016a;

import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;
import com.google.gson.Gson;
import com.jibo.aws.integration.aws.services.push.model.JotNotificationsModeResponse;

/* JADX INFO: renamed from: com.jibo.aws.integration.aws.services.push.model.a.b */
/* JADX INFO: loaded from: classes.dex */
public class C0962b implements Unmarshaller<JotNotificationsModeResponse, JsonUnmarshallerContext> {
    @Override // com.amazonaws.transform.Unmarshaller
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public JotNotificationsModeResponse unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) {
        return (JotNotificationsModeResponse) new Gson().m9353a(jsonUnmarshallerContext.getReader().getReader(), JotNotificationsModeResponse.class);
    }
}
