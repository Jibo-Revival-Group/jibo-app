package com.jibo.aws.integration.aws.services.exception.a;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.JsonErrorResponseHandler;
import com.amazonaws.transform.JsonErrorUnmarshaller;
import com.jibo.aws.integration.aws.services.exception.UnprocessableEntityException;

public class j extends JsonErrorUnmarshaller {
   public j() {
      super(UnprocessableEntityException.class);
   }

   @Override
   public boolean match(JsonErrorResponseHandler.JsonErrorResponse var1) {
      boolean var2;
      if (422 != var1.getStatusCode() && !"Unprocessable Entity".equalsIgnoreCase(var1.getErrorCode())) {
         var2 = false;
      } else {
         var2 = true;
      }

      return var2;
   }

   @Override
   public AmazonServiceException unmarshall(JsonErrorResponseHandler.JsonErrorResponse var1) {
      UnprocessableEntityException var2 = (UnprocessableEntityException)super.unmarshall(var1);
      var2.setErrorCode("UnprocessableEntityException");
      var2.setType(var1.get("Type"));
      return var2;
   }
}
