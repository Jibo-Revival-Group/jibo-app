package com.jibo.aws.integration.aws.services.exception.p006a;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.JsonErrorResponseHandler;
import com.amazonaws.transform.JsonErrorUnmarshaller;
import com.jibo.aws.integration.aws.services.exception.InvalidRequestContentException;

/* JADX INFO: renamed from: com.jibo.aws.integration.aws.services.exception.a.c */
/* JADX INFO: loaded from: classes.dex */
public class C0858c extends JsonErrorUnmarshaller {
    public C0858c() {
        super(InvalidRequestContentException.class);
    }

    @Override // com.amazonaws.transform.JsonErrorUnmarshaller
    public boolean match(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) {
        return 400 == jsonErrorResponse.getStatusCode() || "Bad Request".equalsIgnoreCase(jsonErrorResponse.getErrorCode());
    }

    @Override // com.amazonaws.transform.JsonErrorUnmarshaller, com.amazonaws.transform.Unmarshaller
    public AmazonServiceException unmarshall(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) {
        InvalidRequestContentException invalidRequestContentException = (InvalidRequestContentException) super.unmarshall(jsonErrorResponse);
        invalidRequestContentException.setErrorCode("InvalidRequestContentException");
        invalidRequestContentException.setType(jsonErrorResponse.get("Type"));
        return invalidRequestContentException;
    }
}
