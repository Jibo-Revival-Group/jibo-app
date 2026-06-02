package com.jibo.aws.integration.aws.services.exception.a;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.JsonErrorResponseHandler;
import com.amazonaws.transform.JsonErrorUnmarshaller;
import com.jibo.aws.integration.aws.services.exception.InvalidRequestContentException;

public class c extends JsonErrorUnmarshaller {
   public c() {
      super(InvalidRequestContentException.class);
   }

   @Override
   public boolean match(JsonErrorResponseHandler.JsonErrorResponse var1) {
      boolean var2;
      if (400 != var1.getStatusCode() && !"Bad Request".equalsIgnoreCase(var1.getErrorCode())) {
         var2 = false;
      } else {
         var2 = true;
      }

      return var2;
   }

   @Override
   public AmazonServiceException unmarshall(JsonErrorResponseHandler.JsonErrorResponse var1) {
      InvalidRequestContentException var2 = (InvalidRequestContentException)super.unmarshall(var1);
      var2.setErrorCode("InvalidRequestContentException");
      var2.setType(var1.get("Type"));
      return var2;
   }
}
