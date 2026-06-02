package com.jibo.aws.integration.aws.services.file.model;

import com.jibo.aws.integration.util.Commons;

/* JADX INFO: loaded from: classes.dex */
public class GetFileRequest extends KeyRequest {
    public GetFileRequest(String str) {
        super(str);
    }

    @Override // com.jibo.aws.integration.aws.services.file.model.KeyRequest
    public String getServicePrefix() {
        return Commons.TARGET_PREFIX_PLACEHOLDER;
    }
}
