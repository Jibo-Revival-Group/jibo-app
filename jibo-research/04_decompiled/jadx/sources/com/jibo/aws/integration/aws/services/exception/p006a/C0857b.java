package com.jibo.aws.integration.aws.services.exception.p006a;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.JsonErrorResponseHandler;
import com.amazonaws.transform.JsonErrorUnmarshaller;
import com.jibo.aws.integration.aws.services.exception.InvalidParameterValueException;

/* JADX INFO: renamed from: com.jibo.aws.integration.aws.services.exception.a.b */
/* JADX INFO: loaded from: classes.dex */
public class C0857b extends JsonErrorUnmarshaller {
    public C0857b() {
        super(InvalidParameterValueException.class);
    }

    @Override // com.amazonaws.transform.JsonErrorUnmarshaller
    public boolean match(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) {
        return jsonErrorResponse.getErrorCode().equals("InvalidParameterValueException");
    }

    @Override // com.amazonaws.transform.JsonErrorUnmarshaller, com.amazonaws.transform.Unmarshaller
    public AmazonServiceException unmarshall(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) {
        InvalidParameterValueException invalidParameterValueException = (InvalidParameterValueException) super.unmarshall(jsonErrorResponse);
        invalidParameterValueException.setErrorCode("InvalidParameterValueException");
        invalidParameterValueException.setType(jsonErrorResponse.get("Type"));
        return invalidParameterValueException;
    }
}
