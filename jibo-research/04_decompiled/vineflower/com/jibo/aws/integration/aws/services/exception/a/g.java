package com.jibo.aws.integration.aws.services.exception.a;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.JsonErrorResponseHandler;
import com.amazonaws.transform.JsonErrorUnmarshaller;
import com.jibo.aws.integration.aws.services.exception.ResourceNotFoundException;

public class g extends JsonErrorUnmarshaller {
   public g() {
      super(ResourceNotFoundException.class);
   }

   @Override
   public boolean match(JsonErrorResponseHandler.JsonErrorResponse var1) {
      boolean var2;
      if (404 != var1.getStatusCode() && !"Not Found".equalsIgnoreCase(var1.getErrorCode())) {
         var2 = false;
      } else {
         var2 = true;
      }

      return var2;
   }

   @Override
   public AmazonServiceException unmarshall(JsonErrorResponseHandler.JsonErrorResponse var1) {
      ResourceNotFoundException var2 = (ResourceNotFoundException)super.unmarshall(var1);
      var2.setErrorCode("ResourceNotFoundException");
      var2.setType(var1.get("Type"));
      return var2;
   }
}
