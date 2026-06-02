package com.jibo.aws.integration.aws.services.binary.model;

public class ListBinaryRequest extends PathRequest {
   public ListBinaryRequest(String var1) {
      super(var1);
   }

   @Override
   public String getServicePrefix() {
      return "$TARGET$.";
   }
}
