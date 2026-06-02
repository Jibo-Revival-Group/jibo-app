package com.jibo.aws.integration.aws.services.account.model.p001a;

import com.amazonaws.Request;
import com.jibo.aws.integration.aws.services.account.model.UpdatePhotoRequest;
import com.jibo.aws.integration.aws.services.binary.model.CreateBinaryRequest;
import com.jibo.aws.integration.aws.services.binary.model.p003a.C0846c;
import com.jibo.aws.integration.aws.services.common.model.JiboRequestAbstract;
import java.util.HashMap;

/* JADX INFO: renamed from: com.jibo.aws.integration.aws.services.account.model.a.e */
/* JADX INFO: loaded from: classes.dex */
public class C0834e extends C0846c {
    @Override // com.jibo.aws.integration.aws.services.binary.model.p003a.C0846c
    /* JADX INFO: renamed from: a */
    protected void mo9940a(Request<JiboRequestAbstract> request, CreateBinaryRequest createBinaryRequest) {
        UpdatePhotoRequest updatePhotoRequest = (UpdatePhotoRequest) createBinaryRequest;
        if (updatePhotoRequest.getMeta() == null) {
            updatePhotoRequest.setMeta(new HashMap());
        }
        if (updatePhotoRequest.getMeta().containsKey("size")) {
            return;
        }
        updatePhotoRequest.getMeta().put("size", Long.toString(updatePhotoRequest.getBody().length()));
    }
}
