package com.jibo.aws.integration.aws.services.exception.a;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.JsonErrorResponseHandler;
import com.amazonaws.transform.JsonErrorUnmarshaller;
import com.jibo.aws.integration.aws.services.exception.ServiceException;

public class h extends JsonErrorUnmarshaller {
   public h() {
      super(ServiceException.class);
   }

   @Override
   public boolean match(JsonErrorResponseHandler.JsonErrorResponse var1) {
      boolean var2;
      if (500 != var1.getStatusCode() && !"Internal Server Error".equalsIgnoreCase(var1.getErrorCode())) {
         var2 = false;
      } else {
         var2 = true;
      }

      return var2;
   }

   @Override
   public AmazonServiceException unmarshall(JsonErrorResponseHandler.JsonErrorResponse var1) {
      ServiceException var2 = (ServiceException)super.unmarshall(var1);
      var2.setErrorCode("ServiceException");
      var2.setType(var1.get("Type"));
      return var2;
   }
}
