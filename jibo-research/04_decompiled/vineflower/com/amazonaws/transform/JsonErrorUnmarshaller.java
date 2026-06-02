package com.amazonaws.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.JsonErrorResponseHandler;

public class JsonErrorUnmarshaller extends AbstractErrorUnmarshaller<JsonErrorResponseHandler.JsonErrorResponse> {
   public JsonErrorUnmarshaller() {
   }

   protected JsonErrorUnmarshaller(Class<? extends AmazonServiceException> var1) {
      super(var1);
   }

   public boolean match(JsonErrorResponseHandler.JsonErrorResponse var1) {
      return true;
   }

   public AmazonServiceException unmarshall(JsonErrorResponseHandler.JsonErrorResponse var1) {
      String var2 = var1.getMessage();
      String var3 = var1.getErrorCode();
      if (var2 != null && !var2.isEmpty() || var3 != null && !var3.isEmpty()) {
         AmazonServiceException var4 = this.newException(var2);
         var4.setErrorCode(var3);
         return var4;
      } else {
         throw new AmazonClientException("Neither error message nor error code is found in the error response payload.");
      }
   }
}
