package com.jibo.aws.integration.aws.services.account.model;

import com.jibo.aws.integration.aws.services.common.model.IdRequest;

/* JADX INFO: loaded from: classes.dex */
public class ActivateByIdRequest extends IdRequest {
    public ActivateByIdRequest(String str) {
        super(str);
    }

    @Override // com.jibo.aws.integration.aws.services.common.model.JiboRequestAbstract
    public String getServiceAbbr() {
        return "account";
    }

    @Override // com.jibo.aws.integration.aws.services.common.model.JiboRequestAbstract
    public String getServicePrefix() {
        return "Account_20151111.";
    }
}
