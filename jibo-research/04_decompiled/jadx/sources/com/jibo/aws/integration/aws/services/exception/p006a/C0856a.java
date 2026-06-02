package com.jibo.aws.integration.aws.services.exception.p006a;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.JsonErrorResponseHandler;
import com.amazonaws.transform.JsonErrorUnmarshaller;
import com.jibo.aws.integration.aws.services.exception.ForbiddenRequestException;

/* JADX INFO: renamed from: com.jibo.aws.integration.aws.services.exception.a.a */
/* JADX INFO: loaded from: classes.dex */
public class C0856a extends JsonErrorUnmarshaller {
    public C0856a() {
        super(ForbiddenRequestException.class);
    }

    @Override // com.amazonaws.transform.JsonErrorUnmarshaller
    public boolean match(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) {
        return 403 == jsonErrorResponse.getStatusCode() || "Forbidden".equalsIgnoreCase(jsonErrorResponse.getErrorCode());
    }

    @Override // com.amazonaws.transform.JsonErrorUnmarshaller, com.amazonaws.transform.Unmarshaller
    public AmazonServiceException unmarshall(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) {
        ForbiddenRequestException forbiddenRequestException = (ForbiddenRequestException) super.unmarshall(jsonErrorResponse);
        forbiddenRequestException.setErrorCode("ForbiddenRequestException");
        forbiddenRequestException.setType(jsonErrorResponse.get("Type"));
        return forbiddenRequestException;
    }
}
