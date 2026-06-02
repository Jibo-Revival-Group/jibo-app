package com.jibo.aws.integration.aws.services.oobe.model.p014a;

import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;
import com.google.gson.Gson;
import com.jibo.aws.integration.aws.services.oobe.model.KeysContainer;

/* JADX INFO: renamed from: com.jibo.aws.integration.aws.services.oobe.model.a.a */
/* JADX INFO: loaded from: classes.dex */
public class C0944a implements Unmarshaller<KeysContainer, JsonUnmarshallerContext> {
    @Override // com.amazonaws.transform.Unmarshaller
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public KeysContainer unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) {
        return (KeysContainer) new Gson().m9353a(jsonUnmarshallerContext.getReader().getReader(), KeysContainer.class);
    }
}
