package com.jibo.aws.integration.aws.services.media.model.p012a;

import android.text.TextUtils;
import com.amazonaws.Request;
import com.jibo.aws.integration.aws.services.binary.model.CreateBinaryRequest;
import com.jibo.aws.integration.aws.services.binary.model.p003a.C0846c;
import com.jibo.aws.integration.aws.services.common.model.JiboRequestAbstract;
import com.jibo.aws.integration.aws.services.media.model.CreateRequest;

/* JADX INFO: renamed from: com.jibo.aws.integration.aws.services.media.model.a.a */
/* JADX INFO: loaded from: classes.dex */
public class C0934a extends C0846c {
    @Override // com.jibo.aws.integration.aws.services.binary.model.p003a.C0846c
    /* JADX INFO: renamed from: a */
    protected void mo9940a(Request<JiboRequestAbstract> request, CreateBinaryRequest createBinaryRequest) {
        if (!TextUtils.isEmpty(createBinaryRequest.getPath())) {
            request.addHeader("x-path", createBinaryRequest.getPath());
        }
        request.addHeader("x-loop-id", ((CreateRequest) createBinaryRequest).getLoopId());
        request.addHeader("x-type", ((CreateRequest) createBinaryRequest).getType());
        request.addHeader("x-encrypted", (((CreateRequest) createBinaryRequest).isEncrypted() != null ? ((CreateRequest) createBinaryRequest).isEncrypted().booleanValue() : false) + "");
        if (TextUtils.isEmpty(((CreateRequest) createBinaryRequest).getReference())) {
            return;
        }
        request.addHeader("x-reference", ((CreateRequest) createBinaryRequest).getReference());
    }
}
