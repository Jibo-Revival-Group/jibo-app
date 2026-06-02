package com.jibo.aws.integration.aws.services.exception.p006a;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.JsonErrorResponseHandler;
import com.amazonaws.transform.JsonErrorUnmarshaller;
import com.jibo.aws.integration.aws.services.exception.NotAcceptableException;

/* JADX INFO: renamed from: com.jibo.aws.integration.aws.services.exception.a.e */
/* JADX INFO: loaded from: classes.dex */
public class C0860e extends JsonErrorUnmarshaller {
    public C0860e() {
        super(NotAcceptableException.class);
    }

    @Override // com.amazonaws.transform.JsonErrorUnmarshaller
    public boolean match(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) {
        return 406 == jsonErrorResponse.getStatusCode() || "Not Acceptable".equalsIgnoreCase(jsonErrorResponse.getErrorCode());
    }

    @Override // com.amazonaws.transform.JsonErrorUnmarshaller, com.amazonaws.transform.Unmarshaller
    public AmazonServiceException unmarshall(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) {
        NotAcceptableException notAcceptableException = (NotAcceptableException) super.unmarshall(jsonErrorResponse);
        notAcceptableException.setErrorCode("NotAcceptableException");
        notAcceptableException.setType(jsonErrorResponse.get("Type"));
        return notAcceptableException;
    }
}
