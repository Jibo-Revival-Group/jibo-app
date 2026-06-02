package com.jibo.aws.integration.aws.services.media.model.p012a;

import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jibo.aws.integration.aws.services.media.model.Media;
import java.util.List;

/* JADX INFO: renamed from: com.jibo.aws.integration.aws.services.media.model.a.c */
/* JADX INFO: loaded from: classes.dex */
public class C0936c implements Unmarshaller<List<Media>, JsonUnmarshallerContext> {
    @Override // com.amazonaws.transform.Unmarshaller
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public List<Media> unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) {
        return (List) new Gson().m9354a(jsonUnmarshallerContext.getReader().getReader(), new TypeToken<List<Media>>() { // from class: com.jibo.aws.integration.aws.services.media.model.a.c.1
        }.getType());
    }
}
