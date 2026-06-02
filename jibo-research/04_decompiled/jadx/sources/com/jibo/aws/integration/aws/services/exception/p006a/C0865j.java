package com.jibo.aws.integration.aws.services.exception.p006a;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.JsonErrorResponseHandler;
import com.amazonaws.transform.JsonErrorUnmarshaller;
import com.jibo.aws.integration.aws.services.exception.UnprocessableEntityException;

/* JADX INFO: renamed from: com.jibo.aws.integration.aws.services.exception.a.j */
/* JADX INFO: loaded from: classes.dex */
public class C0865j extends JsonErrorUnmarshaller {
    public C0865j() {
        super(UnprocessableEntityException.class);
    }

    @Override // com.amazonaws.transform.JsonErrorUnmarshaller
    public boolean match(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) {
        return 422 == jsonErrorResponse.getStatusCode() || "Unprocessable Entity".equalsIgnoreCase(jsonErrorResponse.getErrorCode());
    }

    @Override // com.amazonaws.transform.JsonErrorUnmarshaller, com.amazonaws.transform.Unmarshaller
    public AmazonServiceException unmarshall(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) {
        UnprocessableEntityException unprocessableEntityException = (UnprocessableEntityException) super.unmarshall(jsonErrorResponse);
        unprocessableEntityException.setErrorCode("UnprocessableEntityException");
        unprocessableEntityException.setType(jsonErrorResponse.get("Type"));
        return unprocessableEntityException;
    }
}
