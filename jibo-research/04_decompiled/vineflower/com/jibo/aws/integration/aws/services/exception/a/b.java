package com.jibo.aws.integration.aws.services.exception.a;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.JsonErrorResponseHandler;
import com.amazonaws.transform.JsonErrorUnmarshaller;
import com.jibo.aws.integration.aws.services.exception.InvalidParameterValueException;

public class b extends JsonErrorUnmarshaller {
   public b() {
      super(InvalidParameterValueException.class);
   }

   @Override
   public boolean match(JsonErrorResponseHandler.JsonErrorResponse var1) {
      return var1.getErrorCode().equals("InvalidParameterValueException");
   }

   @Override
   public AmazonServiceException unmarshall(JsonErrorResponseHandler.JsonErrorResponse var1) {
      InvalidParameterValueException var2 = (InvalidParameterValueException)super.unmarshall(var1);
      var2.setErrorCode("InvalidParameterValueException");
      var2.setType(var1.get("Type"));
      return var2;
   }
}
