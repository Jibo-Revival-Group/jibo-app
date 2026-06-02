package com.jibo.aws.integration.aws.services.exception.p006a;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.JsonErrorResponseHandler;
import com.amazonaws.transform.JsonErrorUnmarshaller;
import com.jibo.aws.integration.aws.services.exception.ResourceNotFoundException;

/* JADX INFO: renamed from: com.jibo.aws.integration.aws.services.exception.a.g */
/* JADX INFO: loaded from: classes.dex */
public class C0862g extends JsonErrorUnmarshaller {
    public C0862g() {
        super(ResourceNotFoundException.class);
    }

    @Override // com.amazonaws.transform.JsonErrorUnmarshaller
    public boolean match(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) {
        return 404 == jsonErrorResponse.getStatusCode() || "Not Found".equalsIgnoreCase(jsonErrorResponse.getErrorCode());
    }

    @Override // com.amazonaws.transform.JsonErrorUnmarshaller, com.amazonaws.transform.Unmarshaller
    public AmazonServiceException unmarshall(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) {
        ResourceNotFoundException resourceNotFoundException = (ResourceNotFoundException) super.unmarshall(jsonErrorResponse);
        resourceNotFoundException.setErrorCode("ResourceNotFoundException");
        resourceNotFoundException.setType(jsonErrorResponse.get("Type"));
        return resourceNotFoundException;
    }
}
