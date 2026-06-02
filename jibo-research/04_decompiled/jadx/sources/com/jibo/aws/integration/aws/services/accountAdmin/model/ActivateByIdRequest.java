package com.jibo.aws.integration.aws.services.accountAdmin.model;

import com.google.gson.annotations.Expose;
import com.jibo.aws.integration.aws.services.common.model.IdRequestAbstract;

/* JADX INFO: loaded from: classes.dex */
public class ActivateByIdRequest extends IdRequestAbstract {

    /* JADX INFO: renamed from: id */
    @Expose
    private String f9378id;

    public ActivateByIdRequest(String str) {
        super(str);
    }

    @Override // com.jibo.aws.integration.aws.services.common.model.IdRequestAbstract
    public String getId() {
        return this.f9378id;
    }

    @Override // com.jibo.aws.integration.aws.services.common.model.JiboRequestAbstract
    public String getServiceAbbr() {
        return "accountadmin";
    }

    @Override // com.jibo.aws.integration.aws.services.common.model.JiboRequestAbstract
    public String getServicePrefix() {
        return "Account_20151111.";
    }

    @Override // com.jibo.aws.integration.aws.services.common.model.IdRequestAbstract
    public void setId(String str) {
        this.f9378id = str;
    }

    @Override // com.jibo.aws.integration.aws.services.common.model.IdRequestAbstract
    public String toString() {
        return "ActivateByIdRequest {id='" + this.f9378id + "'}";
    }
}
