package com.jibo.aws.integration.aws.services.key.model.p010a;

import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jibo.aws.integration.aws.services.key.model.Request;
import java.util.List;

/* JADX INFO: renamed from: com.jibo.aws.integration.aws.services.key.model.a.a */
/* JADX INFO: loaded from: classes.dex */
public class C0896a implements Unmarshaller<List<Request>, JsonUnmarshallerContext> {
    @Override // com.amazonaws.transform.Unmarshaller
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public List<Request> unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) {
        return (List) new Gson().m9354a(jsonUnmarshallerContext.getReader().getReader(), new TypeToken<List<Request>>() { // from class: com.jibo.aws.integration.aws.services.key.model.a.a.1
        }.getType());
    }
}
