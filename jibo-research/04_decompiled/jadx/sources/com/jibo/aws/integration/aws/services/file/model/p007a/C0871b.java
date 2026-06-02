package com.jibo.aws.integration.aws.services.file.model.p007a;

import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jibo.aws.integration.aws.services.file.model.FileLink;
import java.util.List;

/* JADX INFO: renamed from: com.jibo.aws.integration.aws.services.file.model.a.b */
/* JADX INFO: loaded from: classes.dex */
public class C0871b implements Unmarshaller<List<FileLink>, JsonUnmarshallerContext> {
    @Override // com.amazonaws.transform.Unmarshaller
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public List<FileLink> unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) {
        return (List) new Gson().m9354a(jsonUnmarshallerContext.getReader().getReader(), new TypeToken<List<FileLink>>() { // from class: com.jibo.aws.integration.aws.services.file.model.a.b.1
        }.getType());
    }
}
