package com.jibo.aws.integration.aws.services.account.model;

import com.jibo.aws.integration.aws.services.binary.model.CreateBinaryRequest;
import java.io.File;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class UpdatePhotoRequest extends CreateBinaryRequest {
    public UpdatePhotoRequest(File file, Map<String, String> map) {
        super(null, file, map);
    }

    @Override // com.jibo.aws.integration.aws.services.binary.model.CreateBinaryRequest, com.jibo.aws.integration.aws.services.common.model.JiboRequestAbstract
    public String getServiceAbbr() {
        return "account";
    }

    @Override // com.jibo.aws.integration.aws.services.binary.model.CreateBinaryRequest, com.jibo.aws.integration.aws.services.common.model.JiboRequestAbstract
    public String getServicePrefix() {
        return "Account_20151111.";
    }

    @Override // com.jibo.aws.integration.aws.services.binary.model.CreateBinaryRequest
    public String toString() {
        return "UpdatePhotoRequest {, body='" + this.body + "', meta='" + this.meta + "'}";
    }
}
