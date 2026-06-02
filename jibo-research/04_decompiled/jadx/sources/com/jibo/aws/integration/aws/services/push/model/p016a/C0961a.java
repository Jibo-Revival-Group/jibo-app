package com.jibo.aws.integration.aws.services.push.model.p016a;

import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jibo.aws.integration.aws.services.common.model.Device;
import java.util.List;

/* JADX INFO: renamed from: com.jibo.aws.integration.aws.services.push.model.a.a */
/* JADX INFO: loaded from: classes.dex */
public class C0961a implements Unmarshaller<List<Device>, JsonUnmarshallerContext> {
    @Override // com.amazonaws.transform.Unmarshaller
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public List<Device> unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) {
        return (List) new Gson().m9354a(jsonUnmarshallerContext.getReader().getReader(), new TypeToken<List<Device>>() { // from class: com.jibo.aws.integration.aws.services.push.model.a.a.1
        }.getType());
    }
}
