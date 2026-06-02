package com.jibo.aws.integration.aws.services.notification.model.p013a;

import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;
import com.google.gson.Gson;
import com.jibo.aws.integration.aws.services.notification.model.StatusContainer;

/* JADX INFO: renamed from: com.jibo.aws.integration.aws.services.notification.model.a.a */
/* JADX INFO: loaded from: classes.dex */
public class C0938a implements Unmarshaller<StatusContainer, JsonUnmarshallerContext> {
    @Override // com.amazonaws.transform.Unmarshaller
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public StatusContainer unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) {
        return (StatusContainer) new Gson().m9353a(jsonUnmarshallerContext.getReader().getReader(), StatusContainer.class);
    }
}
