package com.jibo.aws.integration.aws.services.robotProperties.model.p017a;

import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;
import com.google.gson.Gson;
import com.jibo.aws.integration.aws.services.robotProperties.model.Robot;

/* JADX INFO: renamed from: com.jibo.aws.integration.aws.services.robotProperties.model.a.b */
/* JADX INFO: loaded from: classes.dex */
public class C0970b implements Unmarshaller<Robot, JsonUnmarshallerContext> {
    @Override // com.amazonaws.transform.Unmarshaller
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Robot unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) {
        return (Robot) new Gson().m9353a(jsonUnmarshallerContext.getReader().getReader(), Robot.class);
    }
}
