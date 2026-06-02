package com.jibo.aws.integration.aws.services.binary.model;

public class RemoveBinaryRequest extends PathRequest {
   public RemoveBinaryRequest(String var1) {
      super(var1);
   }

   @Override
   public String getServicePrefix() {
      return "$TARGET$.";
   }
}
