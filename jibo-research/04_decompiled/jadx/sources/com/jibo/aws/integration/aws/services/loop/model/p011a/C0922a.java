package com.jibo.aws.integration.aws.services.loop.model.p011a;

import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;
import com.google.gson.Gson;
import com.jibo.aws.integration.aws.services.key.model.Backup;

/* JADX INFO: renamed from: com.jibo.aws.integration.aws.services.loop.model.a.a */
/* JADX INFO: loaded from: classes.dex */
public class C0922a implements Unmarshaller<Backup, JsonUnmarshallerContext> {
    @Override // com.amazonaws.transform.Unmarshaller
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Backup unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) {
        return (Backup) new Gson().m9353a(jsonUnmarshallerContext.getReader().getReader(), Backup.class);
    }
}
