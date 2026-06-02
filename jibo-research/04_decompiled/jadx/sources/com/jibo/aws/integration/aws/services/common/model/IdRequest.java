package com.jibo.aws.integration.aws.services.common.model;

import com.google.gson.annotations.Expose;

/* JADX INFO: loaded from: classes.dex */
public abstract class IdRequest extends IdRequestAbstract {

    /* JADX INFO: renamed from: id */
    @Expose
    private String f9414id;

    public IdRequest(String str) {
        super(str);
    }

    @Override // com.jibo.aws.integration.aws.services.common.model.IdRequestAbstract
    public String getId() {
        return this.f9414id;
    }

    @Override // com.jibo.aws.integration.aws.services.common.model.IdRequestAbstract
    public void setId(String str) {
        this.f9414id = str;
    }

    @Override // com.jibo.aws.integration.aws.services.common.model.IdRequestAbstract
    public String toString() {
        return "IdRequest {id='" + this.f9414id + "'}";
    }
}
