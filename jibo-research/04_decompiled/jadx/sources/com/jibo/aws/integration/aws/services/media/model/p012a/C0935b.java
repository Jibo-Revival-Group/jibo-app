package com.jibo.aws.integration.aws.services.media.model.p012a;

import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;
import com.google.gson.Gson;
import com.jibo.aws.integration.aws.services.media.model.Media;

/* JADX INFO: renamed from: com.jibo.aws.integration.aws.services.media.model.a.b */
/* JADX INFO: loaded from: classes.dex */
public class C0935b implements Unmarshaller<Media, JsonUnmarshallerContext> {
    @Override // com.amazonaws.transform.Unmarshaller
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Media unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) {
        return (Media) new Gson().m9353a(jsonUnmarshallerContext.getReader().getReader(), Media.class);
    }
}
