package com.jibo.aws.integration.aws.services.loop.model;

import com.google.gson.annotations.Expose;

/* JADX INFO: loaded from: classes.dex */
public class CreateRequest extends RobotIdRequest {

    @Expose
    private String name;

    public CreateRequest(String str, String str2) {
        super(str);
        this.name = str2;
    }

    @Override // com.jibo.aws.integration.aws.services.common.model.IdRequestAbstract
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof CreateRequest)) {
            return false;
        }
        CreateRequest createRequest = (CreateRequest) obj;
        if ((createRequest.getName() == null) ^ (getName() == null)) {
            return false;
        }
        return createRequest.getName() == null || createRequest.getName().equals(getName());
    }

    public String getName() {
        return this.name;
    }

    @Override // com.jibo.aws.integration.aws.services.common.model.JiboRequestAbstract
    public String getServiceMethodName() {
        return "CreateLoop";
    }

    @Override // com.jibo.aws.integration.aws.services.common.model.IdRequestAbstract
    public int hashCode() {
        return (getName() == null ? 0 : getName().hashCode()) + (super.hashCode() * 31);
    }

    public void setName(String str) {
        this.name = str;
    }

    @Override // com.jibo.aws.integration.aws.services.loop.model.RobotIdRequest, com.jibo.aws.integration.aws.services.common.model.IdRequestAbstract
    public String toString() {
        return "CreateRequest {robotId='" + getId() + "', name='" + this.name + "'}";
    }
}
