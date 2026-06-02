package com.jibo.aws.integration.aws.services.jot.model.p009a;

import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;
import com.google.gson.Gson;
import com.jibo.aws.integration.aws.services.jot.model.Message;

/* JADX INFO: renamed from: com.jibo.aws.integration.aws.services.jot.model.a.a */
/* JADX INFO: loaded from: classes.dex */
public class C0887a implements Unmarshaller<Message, JsonUnmarshallerContext> {
    @Override // com.amazonaws.transform.Unmarshaller
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Message unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) {
        return (Message) new Gson().m9353a(jsonUnmarshallerContext.getReader().getReader(), Message.class);
    }
}
