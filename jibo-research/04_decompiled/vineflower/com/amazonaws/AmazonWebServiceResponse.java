package com.amazonaws;

public class AmazonWebServiceResponse<T> {
   private ResponseMetadata responseMetadata;
   private T result;

   public String getRequestId() {
      String var1;
      if (this.responseMetadata == null) {
         var1 = null;
      } else {
         var1 = this.responseMetadata.getRequestId();
      }

      return var1;
   }

   public T getResult() {
      return this.result;
   }

   public void setResponseMetadata(ResponseMetadata var1) {
      this.responseMetadata = var1;
   }

   public void setResult(T var1) {
      this.result = (T)var1;
   }
}
