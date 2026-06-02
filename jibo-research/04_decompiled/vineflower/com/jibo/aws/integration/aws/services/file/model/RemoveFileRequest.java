package com.jibo.aws.integration.aws.services.file.model;

public class RemoveFileRequest extends KeyRequest {
   public RemoveFileRequest(String var1) {
      super(var1);
   }

   @Override
   public String getServicePrefix() {
      return "$TARGET$.";
   }
}
