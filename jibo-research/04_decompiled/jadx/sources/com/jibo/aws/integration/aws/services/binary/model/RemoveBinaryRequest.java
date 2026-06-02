package com.jibo.aws.integration.aws.services.binary.model;

import com.jibo.aws.integration.util.Commons;

/* JADX INFO: loaded from: classes.dex */
public class RemoveBinaryRequest extends PathRequest {
    public RemoveBinaryRequest(String str) {
        super(str);
    }

    @Override // com.jibo.aws.integration.aws.services.binary.model.PathRequest
    public String getServicePrefix() {
        return Commons.TARGET_PREFIX_PLACEHOLDER;
    }
}
