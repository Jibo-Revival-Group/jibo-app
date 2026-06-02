package com.jibo.aws.integration.aws.services.exception.a;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.JsonErrorResponseHandler;
import com.amazonaws.transform.JsonErrorUnmarshaller;
import com.jibo.aws.integration.aws.services.exception.NotImplementedException;

public class f extends JsonErrorUnmarshaller {
   public f() {
      super(NotImplementedException.class);
   }

   @Override
   public boolean match(JsonErrorResponseHandler.JsonErrorResponse var1) {
      boolean var2;
      if (501 != var1.getStatusCode() && !"Not Implemented".equalsIgnoreCase(var1.getErrorCode())) {
         var2 = false;
      } else {
         var2 = true;
      }

      return var2;
   }

   @Override
   public AmazonServiceException unmarshall(JsonErrorResponseHandler.JsonErrorResponse var1) {
      NotImplementedException var2 = (NotImplementedException)super.unmarshall(var1);
      var2.setErrorCode("NotImplementedException");
      var2.setType(var1.get("Type"));
      return var2;
   }
}
