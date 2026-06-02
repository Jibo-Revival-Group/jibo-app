package com.jibo.aws.integration.aws.services.account.model;

import com.jibo.aws.integration.aws.services.common.model.EmptyRequest;

/* JADX INFO: loaded from: classes.dex */
public class RemovePhotoRequest extends EmptyRequest {
    @Override // com.jibo.aws.integration.aws.services.common.model.JiboRequestAbstract
    public String getServiceAbbr() {
        return "account";
    }

    @Override // com.jibo.aws.integration.aws.services.common.model.JiboRequestAbstract
    public String getServicePrefix() {
        return "Account_20151111.";
    }
}
