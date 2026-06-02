package com.jibo.aws.integration.aws.services.loop.model.p011a;

import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jibo.aws.integration.aws.services.loop.model.Robot;
import java.util.List;

/* JADX INFO: renamed from: com.jibo.aws.integration.aws.services.loop.model.a.f */
/* JADX INFO: loaded from: classes.dex */
public class C0927f implements Unmarshaller<List<Robot>, JsonUnmarshallerContext> {
    @Override // com.amazonaws.transform.Unmarshaller
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public List<Robot> unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) {
        return (List) new Gson().m9354a(jsonUnmarshallerContext.getReader().getReader(), new TypeToken<List<Robot>>() { // from class: com.jibo.aws.integration.aws.services.loop.model.a.f.1
        }.getType());
    }
}
