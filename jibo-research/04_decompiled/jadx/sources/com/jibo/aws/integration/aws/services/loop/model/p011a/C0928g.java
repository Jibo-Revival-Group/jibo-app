package com.jibo.aws.integration.aws.services.loop.model.p011a;

import com.amazonaws.Request;
import com.jibo.aws.integration.aws.services.binary.model.CreateBinaryRequest;
import com.jibo.aws.integration.aws.services.binary.model.p003a.C0846c;
import com.jibo.aws.integration.aws.services.common.model.JiboRequestAbstract;
import com.jibo.aws.integration.aws.services.loop.model.UpdateMemberPhotoRequest;
import java.util.HashMap;

/* JADX INFO: renamed from: com.jibo.aws.integration.aws.services.loop.model.a.g */
/* JADX INFO: loaded from: classes.dex */
public class C0928g extends C0846c {
    @Override // com.jibo.aws.integration.aws.services.binary.model.p003a.C0846c
    /* JADX INFO: renamed from: a */
    protected void mo9940a(Request<JiboRequestAbstract> request, CreateBinaryRequest createBinaryRequest) {
        UpdateMemberPhotoRequest updateMemberPhotoRequest = (UpdateMemberPhotoRequest) createBinaryRequest;
        request.addHeader("x-loop-id", ((UpdateMemberPhotoRequest) createBinaryRequest).getLoopId());
        request.addHeader("x-id", ((UpdateMemberPhotoRequest) createBinaryRequest).getId());
        if (updateMemberPhotoRequest.getMeta() == null) {
            updateMemberPhotoRequest.setMeta(new HashMap());
        }
        if (updateMemberPhotoRequest.getMeta().containsKey("size")) {
            return;
        }
        updateMemberPhotoRequest.getMeta().put("size", Long.toString(updateMemberPhotoRequest.getBody().length()));
    }
}
