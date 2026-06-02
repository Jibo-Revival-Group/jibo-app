package com.jibo.aws.integration.aws.services.exception.a;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.JsonErrorResponseHandler;
import com.amazonaws.transform.JsonErrorUnmarshaller;
import com.jibo.aws.integration.aws.services.exception.UnauthorizedRequestException;

public class i extends JsonErrorUnmarshaller {
   public i() {
      super(UnauthorizedRequestException.class);
   }

   @Override
   public boolean match(JsonErrorResponseHandler.JsonErrorResponse var1) {
      boolean var2;
      if (401 != var1.getStatusCode() && !"Unauthorized".equalsIgnoreCase(var1.getErrorCode())) {
         var2 = false;
      } else {
         var2 = true;
      }

      return var2;
   }

   @Override
   public AmazonServiceException unmarshall(JsonErrorResponseHandler.JsonErrorResponse var1) {
      UnauthorizedRequestException var2 = (UnauthorizedRequestException)super.unmarshall(var1);
      var2.setErrorCode("UnauthorizedRequestException");
      var2.setType(var1.get("Type"));
      return var2;
   }
}
