package com.jibo.aws.integration.aws.services.binary.model;

public class GetBinaryRequest extends PathRequest {
   public GetBinaryRequest(String var1) {
      super(var1);
   }

   @Override
   public String getServicePrefix() {
      return "$TARGET$.";
   }
}
