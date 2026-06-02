package com.jibo.aws.integration.aws.services.exception.p006a;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.JsonErrorResponseHandler;
import com.amazonaws.transform.JsonErrorUnmarshaller;
import com.jibo.aws.integration.aws.services.exception.NotImplementedException;

/* JADX INFO: renamed from: com.jibo.aws.integration.aws.services.exception.a.f */
/* JADX INFO: loaded from: classes.dex */
public class C0861f extends JsonErrorUnmarshaller {
    public C0861f() {
        super(NotImplementedException.class);
    }

    @Override // com.amazonaws.transform.JsonErrorUnmarshaller
    public boolean match(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) {
        return 501 == jsonErrorResponse.getStatusCode() || "Not Implemented".equalsIgnoreCase(jsonErrorResponse.getErrorCode());
    }

    @Override // com.amazonaws.transform.JsonErrorUnmarshaller, com.amazonaws.transform.Unmarshaller
    public AmazonServiceException unmarshall(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) {
        NotImplementedException notImplementedException = (NotImplementedException) super.unmarshall(jsonErrorResponse);
        notImplementedException.setErrorCode("NotImplementedException");
        notImplementedException.setType(jsonErrorResponse.get("Type"));
        return notImplementedException;
    }
}
