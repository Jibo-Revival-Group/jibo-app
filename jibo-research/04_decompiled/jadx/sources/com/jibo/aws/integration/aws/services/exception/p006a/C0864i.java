package com.jibo.aws.integration.aws.services.exception.p006a;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.JsonErrorResponseHandler;
import com.amazonaws.transform.JsonErrorUnmarshaller;
import com.jibo.aws.integration.aws.services.exception.UnauthorizedRequestException;

/* JADX INFO: renamed from: com.jibo.aws.integration.aws.services.exception.a.i */
/* JADX INFO: loaded from: classes.dex */
public class C0864i extends JsonErrorUnmarshaller {
    public C0864i() {
        super(UnauthorizedRequestException.class);
    }

    @Override // com.amazonaws.transform.JsonErrorUnmarshaller
    public boolean match(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) {
        return 401 == jsonErrorResponse.getStatusCode() || "Unauthorized".equalsIgnoreCase(jsonErrorResponse.getErrorCode());
    }

    @Override // com.amazonaws.transform.JsonErrorUnmarshaller, com.amazonaws.transform.Unmarshaller
    public AmazonServiceException unmarshall(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) {
        UnauthorizedRequestException unauthorizedRequestException = (UnauthorizedRequestException) super.unmarshall(jsonErrorResponse);
        unauthorizedRequestException.setErrorCode("UnauthorizedRequestException");
        unauthorizedRequestException.setType(jsonErrorResponse.get("Type"));
        return unauthorizedRequestException;
    }
}
