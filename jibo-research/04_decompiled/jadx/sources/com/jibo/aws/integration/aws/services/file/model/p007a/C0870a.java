package com.jibo.aws.integration.aws.services.file.model.p007a;

import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;
import com.google.gson.Gson;
import com.jibo.aws.integration.aws.services.file.model.FileLink;

/* JADX INFO: renamed from: com.jibo.aws.integration.aws.services.file.model.a.a */
/* JADX INFO: loaded from: classes.dex */
public class C0870a implements Unmarshaller<FileLink, JsonUnmarshallerContext> {
    @Override // com.amazonaws.transform.Unmarshaller
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public FileLink unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) {
        return (FileLink) new Gson().m9353a(jsonUnmarshallerContext.getReader().getReader(), FileLink.class);
    }
}
