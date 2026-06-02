package com.jibo.aws.integration.aws.services.exception.p006a;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.JsonErrorResponseHandler;
import com.amazonaws.transform.JsonErrorUnmarshaller;
import com.jibo.aws.integration.aws.services.exception.MethodNotAllowedException;

/* JADX INFO: renamed from: com.jibo.aws.integration.aws.services.exception.a.d */
/* JADX INFO: loaded from: classes.dex */
public class C0859d extends JsonErrorUnmarshaller {
    public C0859d() {
        super(MethodNotAllowedException.class);
    }

    @Override // com.amazonaws.transform.JsonErrorUnmarshaller
    public boolean match(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) {
        return 405 == jsonErrorResponse.getStatusCode() || "Method Not Allowed".equalsIgnoreCase(jsonErrorResponse.getErrorCode());
    }

    @Override // com.amazonaws.transform.JsonErrorUnmarshaller, com.amazonaws.transform.Unmarshaller
    public AmazonServiceException unmarshall(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) {
        MethodNotAllowedException methodNotAllowedException = (MethodNotAllowedException) super.unmarshall(jsonErrorResponse);
        methodNotAllowedException.setErrorCode("MethodNotAllowedException");
        methodNotAllowedException.setType(jsonErrorResponse.get("Type"));
        return methodNotAllowedException;
    }
}
