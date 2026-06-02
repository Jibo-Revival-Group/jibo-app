package com.jibo.aws.integration.aws.services.loop.model;

import com.google.gson.annotations.Expose;
import com.jibo.aws.integration.aws.services.common.model.IdRequestAbstract;
import com.jibo.aws.integration.util.Commons;

/* JADX INFO: loaded from: classes.dex */
public class AccountIdRequest extends IdRequestAbstract {

    @Expose
    private String accountId;

    public AccountIdRequest(String str) {
        super(str);
    }

    @Override // com.jibo.aws.integration.aws.services.common.model.IdRequestAbstract
    public String getId() {
        return this.accountId;
    }

    @Override // com.jibo.aws.integration.aws.services.common.model.JiboRequestAbstract
    public String getServiceAbbr() {
        return "loop";
    }

    @Override // com.jibo.aws.integration.aws.services.common.model.JiboRequestAbstract
    public String getServicePrefix() {
        return Commons.TARGET_PREFIX_LOOP;
    }

    @Override // com.jibo.aws.integration.aws.services.common.model.IdRequestAbstract
    public void setId(String str) {
        this.accountId = str;
    }

    @Override // com.jibo.aws.integration.aws.services.common.model.IdRequestAbstract
    public String toString() {
        return "AccountIdRequest {accountId='" + this.accountId + "'}";
    }
}
