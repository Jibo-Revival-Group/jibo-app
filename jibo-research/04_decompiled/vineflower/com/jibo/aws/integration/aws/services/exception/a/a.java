package com.jibo.aws.integration.aws.services.exception.a;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.JsonErrorResponseHandler;
import com.amazonaws.transform.JsonErrorUnmarshaller;
import com.jibo.aws.integration.aws.services.exception.ForbiddenRequestException;

public class a extends JsonErrorUnmarshaller {
   public a() {
      super(ForbiddenRequestException.class);
   }

   @Override
   public boolean match(JsonErrorResponseHandler.JsonErrorResponse var1) {
      boolean var2;
      if (403 != var1.getStatusCode() && !"Forbidden".equalsIgnoreCase(var1.getErrorCode())) {
         var2 = false;
      } else {
         var2 = true;
      }

      return var2;
   }

   @Override
   public AmazonServiceException unmarshall(JsonErrorResponseHandler.JsonErrorResponse var1) {
      ForbiddenRequestException var2 = (ForbiddenRequestException)super.unmarshall(var1);
      var2.setErrorCode("ForbiddenRequestException");
      var2.setType(var1.get("Type"));
      return var2;
   }
}
