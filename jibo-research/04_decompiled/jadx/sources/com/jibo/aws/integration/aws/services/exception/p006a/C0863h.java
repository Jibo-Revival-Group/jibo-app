package com.jibo.aws.integration.aws.services.exception.p006a;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.JsonErrorResponseHandler;
import com.amazonaws.transform.JsonErrorUnmarshaller;
import com.jibo.aws.integration.aws.services.exception.ServiceException;

/* JADX INFO: renamed from: com.jibo.aws.integration.aws.services.exception.a.h */
/* JADX INFO: loaded from: classes.dex */
public class C0863h extends JsonErrorUnmarshaller {
    public C0863h() {
        super(ServiceException.class);
    }

    @Override // com.amazonaws.transform.JsonErrorUnmarshaller
    public boolean match(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) {
        return 500 == jsonErrorResponse.getStatusCode() || "Internal Server Error".equalsIgnoreCase(jsonErrorResponse.getErrorCode());
    }

    @Override // com.amazonaws.transform.JsonErrorUnmarshaller, com.amazonaws.transform.Unmarshaller
    public AmazonServiceException unmarshall(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) {
        ServiceException serviceException = (ServiceException) super.unmarshall(jsonErrorResponse);
        serviceException.setErrorCode("ServiceException");
        serviceException.setType(jsonErrorResponse.get("Type"));
        return serviceException;
    }
}
