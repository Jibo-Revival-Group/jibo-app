package com.jibo.aws.integration.aws.services.common.model.p005a;

import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;
import com.google.gson.Gson;
import com.jibo.aws.integration.aws.services.common.model.CommandResponse;

/* JADX INFO: renamed from: com.jibo.aws.integration.aws.services.common.model.a.a */
/* JADX INFO: loaded from: classes.dex */
public class C0851a implements Unmarshaller<CommandResponse, JsonUnmarshallerContext> {
    @Override // com.amazonaws.transform.Unmarshaller
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public CommandResponse unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) {
        return (CommandResponse) new Gson().m9353a(jsonUnmarshallerContext.getReader().getReader(), CommandResponse.class);
    }
}
