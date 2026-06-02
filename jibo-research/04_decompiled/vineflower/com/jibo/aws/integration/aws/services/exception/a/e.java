package com.jibo.aws.integration.aws.services.exception.a;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.JsonErrorResponseHandler;
import com.amazonaws.transform.JsonErrorUnmarshaller;
import com.jibo.aws.integration.aws.services.exception.NotAcceptableException;

public class e extends JsonErrorUnmarshaller {
   public e() {
      super(NotAcceptableException.class);
   }

   @Override
   public boolean match(JsonErrorResponseHandler.JsonErrorResponse var1) {
      boolean var2;
      if (406 != var1.getStatusCode() && !"Not Acceptable".equalsIgnoreCase(var1.getErrorCode())) {
         var2 = false;
      } else {
         var2 = true;
      }

      return var2;
   }

   @Override
   public AmazonServiceException unmarshall(JsonErrorResponseHandler.JsonErrorResponse var1) {
      NotAcceptableException var2 = (NotAcceptableException)super.unmarshall(var1);
      var2.setErrorCode("NotAcceptableException");
      var2.setType(var1.get("Type"));
      return var2;
   }
}
