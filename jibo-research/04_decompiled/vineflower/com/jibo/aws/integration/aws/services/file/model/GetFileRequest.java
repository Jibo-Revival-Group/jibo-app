package com.jibo.aws.integration.aws.services.file.model;

public class GetFileRequest extends KeyRequest {
   public GetFileRequest(String var1) {
      super(var1);
   }

   @Override
   public String getServicePrefix() {
      return "$TARGET$.";
   }
}
