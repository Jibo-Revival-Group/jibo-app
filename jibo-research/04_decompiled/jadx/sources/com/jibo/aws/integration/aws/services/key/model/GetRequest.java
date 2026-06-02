package com.jibo.aws.integration.aws.services.key.model;

import com.jibo.aws.integration.aws.services.common.model.IdRequest;
import com.jibo.aws.integration.util.Commons;

/* JADX INFO: loaded from: classes.dex */
public class GetRequest extends IdRequest {
    public GetRequest(String str) {
        super(str);
    }

    @Override // com.jibo.aws.integration.aws.services.common.model.JiboRequestAbstract
    public String getServiceAbbr() {
        return "key";
    }

    @Override // com.jibo.aws.integration.aws.services.common.model.JiboRequestAbstract
    public String getServiceMethodName() {
        return "GetRequest";
    }

    @Override // com.jibo.aws.integration.aws.services.common.model.JiboRequestAbstract
    public String getServicePrefix() {
        return Commons.TARGET_PREFIX_KEY;
    }

    @Override // com.jibo.aws.integration.aws.services.common.model.IdRequest, com.jibo.aws.integration.aws.services.common.model.IdRequestAbstract
    public String toString() {
        return "GetRequest {id='" + getId() + "'}";
    }
}
