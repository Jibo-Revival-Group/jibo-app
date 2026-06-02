package com.jibo.aws.integration.aws.services.exception.a;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.JsonErrorResponseHandler;
import com.amazonaws.transform.JsonErrorUnmarshaller;
import com.jibo.aws.integration.aws.services.exception.MethodNotAllowedException;

public class d extends JsonErrorUnmarshaller {
   public d() {
      super(MethodNotAllowedException.class);
   }

   @Override
   public boolean match(JsonErrorResponseHandler.JsonErrorResponse var1) {
      boolean var2;
      if (405 != var1.getStatusCode() && !"Method Not Allowed".equalsIgnoreCase(var1.getErrorCode())) {
         var2 = false;
      } else {
         var2 = true;
      }

      return var2;
   }

   @Override
   public AmazonServiceException unmarshall(JsonErrorResponseHandler.JsonErrorResponse var1) {
      MethodNotAllowedException var2 = (MethodNotAllowedException)super.unmarshall(var1);
      var2.setErrorCode("MethodNotAllowedException");
      var2.setType(var1.get("Type"));
      return var2;
   }
}
