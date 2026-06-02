package com.jibo.aws.integration.aws.services.collision.model.p004a;

import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;
import com.google.gson.Gson;
import com.jibo.aws.integration.aws.services.collision.model.CollisionCheckContainer;

/* JADX INFO: renamed from: com.jibo.aws.integration.aws.services.collision.model.a.a */
/* JADX INFO: loaded from: classes.dex */
public class C0849a implements Unmarshaller<CollisionCheckContainer, JsonUnmarshallerContext> {
    @Override // com.amazonaws.transform.Unmarshaller
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public CollisionCheckContainer unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) {
        return (CollisionCheckContainer) new Gson().m9353a(jsonUnmarshallerContext.getReader().getReader(), CollisionCheckContainer.class);
    }
}
