package com.jibo.aws.integration.aws.services.exception;

import com.amazonaws.AmazonServiceException;

public class JiboServiceException extends AmazonServiceException {
   protected String a;

   public JiboServiceException(String var1) {
      super(var1);
   }

   public JiboServiceException(String var1, Exception var2) {
      super(var1, var2);
   }

   public String getType() {
      return this.a;
   }

   public void setType(String var1) {
      this.a = var1;
   }
}
