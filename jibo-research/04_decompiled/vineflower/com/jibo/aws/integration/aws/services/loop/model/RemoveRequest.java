package com.jibo.aws.integration.aws.services.loop.model;

public class RemoveRequest extends JiboLoopRequest {
   public RemoveRequest(String var1) {
      super(var1);
   }

   @Override
   public String getServiceMethodName() {
      return "RemoveLoop";
   }
}
